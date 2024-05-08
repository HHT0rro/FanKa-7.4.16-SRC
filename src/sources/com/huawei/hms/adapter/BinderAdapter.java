package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BinderAdapter implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f28978a;

    /* renamed from: b, reason: collision with root package name */
    private final String f28979b;

    /* renamed from: c, reason: collision with root package name */
    private final String f28980c;

    /* renamed from: d, reason: collision with root package name */
    private BinderCallBack f28981d;

    /* renamed from: e, reason: collision with root package name */
    private IBinder f28982e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f28983f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private boolean f28984g = false;

    /* renamed from: h, reason: collision with root package name */
    private Handler f28985h = null;

    /* renamed from: i, reason: collision with root package name */
    private Handler f28986i = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface BinderCallBack {
        void onBinderFailed(int i10);

        void onBinderFailed(int i10, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f28978a = context;
        this.f28979b = str;
        this.f28980c = str2;
    }

    private void c() {
        synchronized (this.f28983f) {
            Handler handler = this.f28985h;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.f28985h = null;
            }
        }
    }

    private void d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack f10 = BinderAdapter.this.f();
                if (f10 == null) {
                    return true;
                }
                f10.onTimedDisconnected();
                return true;
            }
        });
        this.f28986i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    private void e() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f28978a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack f10 = f();
            if (f10 != null) {
                f10.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e2) {
            HMSLog.e("BinderAdapter", "getBindFailPendingIntent failed " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack f() {
        return this.f28981d;
    }

    private void g() {
        Handler handler = this.f28985h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f28985h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.b();
                    return true;
                }
            });
        }
        this.f28985h.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
    }

    private void h() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f28986i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.f28981d = binderCallBack;
        a();
    }

    public int getConnTimeOut() {
        return 0;
    }

    public int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f28979b;
    }

    public IBinder getServiceBinder() {
        return this.f28982e;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f28984g) {
            this.f28984g = false;
            return;
        }
        unBind();
        c();
        BinderCallBack f10 = f();
        if (f10 != null) {
            f10.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f28982e = iBinder;
        c();
        BinderCallBack f10 = f();
        if (f10 != null) {
            f10.onServiceConnected(componentName, iBinder);
        }
        d();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack f10 = f();
        if (f10 != null) {
            f10.onServiceDisconnected(componentName);
        }
        h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f28978a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f28986i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.f28986i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
            }
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.f28979b) || TextUtils.isEmpty(this.f28980c)) {
            e();
        }
        Intent intent = new Intent(this.f28979b);
        try {
            intent.setPackage(this.f28980c);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            e();
        }
        synchronized (this.f28983f) {
            if (this.f28978a.bindService(intent, this, 1)) {
                g();
            } else {
                this.f28984g = true;
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BinderCallBack f10 = f();
        if (f10 != null) {
            f10.onBinderFailed(-1);
        }
    }
}
