package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* renamed from: b, reason: collision with root package name */
    private static volatile RequestManager f29723b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f29724c;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f29722a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static Queue<HuaweiApi.RequestHandler> f29725d = new ConcurrentLinkedQueue();

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, HuaweiApi.RequestHandler> f29726e = new LinkedHashMap();

    private RequestManager(Looper looper) {
        f29724c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f29725d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f29724c == null) {
            return;
        }
        HMSLog.i("RequestManager", "addToConnectedReqMap");
        f29724c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f29726e.put(String.this, requestHandler);
            }
        });
    }

    private void b() {
        while (!f29725d.isEmpty()) {
            HuaweiApi.RequestHandler poll = f29725d.poll();
            if (poll != null) {
                Object client = poll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    poll.onConnected();
                }
            }
        }
    }

    private void c() {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f29725d.isEmpty()) {
            f29725d.poll().onConnectionSuspended(1);
        }
        d();
    }

    private void d() {
        HMSLog.i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f29726e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> iterator2 = f29726e.entrySet().iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().getValue().onConnectionSuspended(1);
            } catch (RuntimeException e2) {
                HMSLog.e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e2.getMessage());
            }
            iterator2.remove();
        }
    }

    public static Handler getHandler() {
        return f29724c;
    }

    public static RequestManager getInstance() {
        synchronized (f29722a) {
            if (f29723b == null) {
                HandlerThread handlerThread = new HandlerThread("RequestManager");
                handlerThread.start();
                f29723b = new RequestManager(handlerThread.getLooper());
            }
        }
        return f29723b;
    }

    public static void removeReqByTransId(final String str) {
        if (f29724c == null) {
            return;
        }
        HMSLog.i("RequestManager", "removeReqByTransId");
        f29724c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.2
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f29726e.remove(String.this);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case NOTIFY_CONNECT_SUCCESS /* 10011 */:
                b();
                return true;
            case 10012:
                a(message);
                return true;
            case 10013:
                c();
                return true;
            default:
                HMSLog.i("RequestManager", "handleMessage unknown msg:" + message.what);
                return false;
        }
    }

    private void a(Message message) {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f29725d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e2) {
            HMSLog.e("RequestManager", "<handleConnectFailed> handle Failed" + e2.getMessage());
        }
    }
}
