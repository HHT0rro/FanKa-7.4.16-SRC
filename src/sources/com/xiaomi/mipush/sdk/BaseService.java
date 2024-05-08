package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BaseService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public a f46940b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<BaseService> f46941a;

        public a(WeakReference<BaseService> weakReference) {
            this.f46941a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.f46941a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            fc.c.m("TimeoutHandler" + baseService.toString() + "  kill self");
            if (!baseService.a()) {
                baseService.stopSelf();
            } else {
                fc.c.m("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    public abstract boolean a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        super.onStart(intent, i10);
        if (this.f46940b == null) {
            this.f46940b = new a(new WeakReference(this));
        }
        this.f46940b.a();
    }
}
