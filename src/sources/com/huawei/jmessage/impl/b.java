package com.huawei.jmessage.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.huawei.flexiblelayout.common.Debuggable;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventSourceProxy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements EventSource.Firer {

    /* renamed from: g, reason: collision with root package name */
    private static final String f32036g = "EventSourceProxy";

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f32037h = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final String f32038a;

    /* renamed from: b, reason: collision with root package name */
    private final EventSource f32039b;

    /* renamed from: d, reason: collision with root package name */
    private final Object f32041d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private int f32042e = 0;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f32043f = false;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, Subscriber> f32040c = new LinkedHashMap();

    /* compiled from: EventSourceProxy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f32044a;

        public a(Object obj) {
            this.f32044a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.a(bVar.f32039b.onFire(this.f32044a));
        }
    }

    public b(String str, EventSource eventSource) {
        this.f32038a = str;
        this.f32039b = eventSource;
    }

    public String b() {
        return this.f32038a;
    }

    public boolean c() {
        boolean z10;
        synchronized (this.f32041d) {
            z10 = this.f32042e == 0;
        }
        return z10;
    }

    public void d() {
        if (this.f32043f) {
            this.f32043f = false;
            this.f32039b.onRelease();
        }
    }

    @Override // com.huawei.jmessage.api.EventSource.Firer
    public void fire(Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f32037h.post(new a(obj));
        } else {
            a(this.f32039b.onFire(obj));
        }
    }

    public boolean b(int i10) {
        Subscriber subscriber;
        synchronized (this.f32041d) {
            subscriber = this.f32040c.get(Integer.valueOf(i10));
            if (subscriber != null) {
                this.f32040c.put(Integer.valueOf(i10), null);
                this.f32042e--;
            }
        }
        if (subscriber == null) {
            return false;
        }
        this.f32039b.onUnsubscribe(subscriber);
        return true;
    }

    public EventSource a() {
        return this.f32039b;
    }

    public boolean a(Subscriber subscriber, EventCallback.Message message) {
        return this.f32039b.onDispatch(subscriber, message);
    }

    public boolean a(Subscriber subscriber) {
        if (!this.f32043f) {
            this.f32039b.onInitialize(this);
            this.f32043f = true;
        }
        if (!this.f32039b.onSubscribe(subscriber)) {
            return false;
        }
        synchronized (this.f32041d) {
            if (this.f32040c.put(Integer.valueOf(subscriber.getId()), subscriber) != null) {
                return false;
            }
            this.f32042e++;
            return true;
        }
    }

    public boolean a(int i10) {
        boolean z10;
        synchronized (this.f32041d) {
            z10 = this.f32040c.get(Integer.valueOf(i10)) != null;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        EventCallback.Message message = new EventCallback.Message();
        message.payload = obj;
        synchronized (this.f32041d) {
            Iterator<Map.Entry<Integer, Subscriber>> iterator2 = this.f32040c.entrySet().iterator2();
            while (iterator2.hasNext()) {
                Subscriber value = iterator2.next().getValue();
                if (value == null) {
                    iterator2.remove();
                } else {
                    message.topic = value.getTopic();
                    message.subscribeId = value.getId();
                    if (a(value, message)) {
                        try {
                            value.getConsumer().call(message);
                        } catch (RemoteException unused) {
                            iterator2.remove();
                            this.f32042e--;
                        } catch (Exception e2) {
                            if (Debuggable.isDebuggable()) {
                                Log.e(f32036g, "Exception when invoking subscriber callback.", e2);
                            } else {
                                Log.e(f32036g, "Exception when invoking subscriber callback." + e2.getMessage());
                            }
                        }
                    }
                }
            }
        }
        if (c()) {
            d();
        }
    }
}
