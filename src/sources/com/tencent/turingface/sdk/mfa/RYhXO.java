package com.tencent.turingface.sdk.mfa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.hianalytics.core.transport.net.Response;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class RYhXO implements Xjpd8 {

    /* renamed from: a, reason: collision with root package name */
    public OTVRM f45694a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ShGzN extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f45695a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f45696b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f45697c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f45698d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f45699e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f45700f;

        public ShGzN(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.f45695a = atomicReference;
            this.f45696b = atomicReference2;
            this.f45697c = atomicReference3;
            this.f45698d = context;
            this.f45699e = atomicReference4;
            this.f45700f = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String str = "";
            try {
                str = RYhXO.this.a((IBinder) this.f45695a.get());
            } catch (Throwable unused) {
                this.f45696b.set(Integer.valueOf(Response.Code.TIMEOUT_OR_OTHER_ERROR));
            }
            this.f45697c.set(str);
            try {
                this.f45698d.unbindService((ServiceConnection) this.f45699e.get());
            } catch (Throwable unused2) {
                this.f45696b.set(Integer.valueOf(Response.Code.CONNECTION_ERROR));
            }
            synchronized (this.f45700f) {
                try {
                    this.f45700f.notifyAll();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f45702a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f45703b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f45704c;

        public spXPg(AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.f45702a = atomicReference;
            this.f45703b = atomicReference2;
            this.f45704c = obj;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f45702a.set(iBinder);
            this.f45703b.set(this);
            synchronized (this.f45704c) {
                try {
                    this.f45704c.notifyAll();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public abstract String a(IBinder iBinder) throws Exception;

    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    public final void a(Context context) {
        this.f45694a = c(context);
    }

    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    public final OTVRM b(Context context) {
        OTVRM otvrm = this.f45694a;
        if (otvrm == null || otvrm.f45667b != 0) {
            this.f45694a = c(context);
        }
        return this.f45694a;
    }

    public final OTVRM c(Context context) {
        int i10;
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("");
        try {
            AtomicReference<IBinder> atomicReference2 = new AtomicReference<>();
            AtomicReference<ServiceConnection> atomicReference3 = new AtomicReference<>();
            i10 = a(context, atomicReference2, atomicReference3);
            if (i10 == 0) {
                try {
                    i10 = a(context, atomicReference2, atomicReference3, atomicReference);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            i10 = -1;
        }
        return new OTVRM(atomicReference.get(), i10);
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        Object obj = new Object();
        Intent intent = new Intent(kC0XR.a(kC0XR.f45851k));
        intent.setComponent(new ComponentName(kC0XR.a(kC0XR.f45843g), kC0XR.a(kC0XR.f45845h)));
        if (!context.bindService(intent, new spXPg(atomicReference, atomicReference2, obj), 1)) {
            return -100;
        }
        if (atomicReference.get() == null) {
            synchronized (obj) {
                try {
                    obj.wait(1000L);
                } catch (Throwable unused) {
                }
            }
        }
        if (atomicReference.get() == null) {
            return Response.Code.SSL_CONFIG_ERROR;
        }
        return 0;
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2, AtomicReference<String> atomicReference3) {
        Object obj = new Object();
        AtomicReference atomicReference4 = new AtomicReference(0);
        new ShGzN(atomicReference, atomicReference4, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Throwable unused) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }
}
