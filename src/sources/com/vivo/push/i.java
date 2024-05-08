package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.ag;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IPCManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f46231a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, i> f46232b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private boolean f46233c;

    /* renamed from: d, reason: collision with root package name */
    private String f46234d;

    /* renamed from: e, reason: collision with root package name */
    private Context f46235e;

    /* renamed from: g, reason: collision with root package name */
    private volatile IPCInvoke f46237g;

    /* renamed from: i, reason: collision with root package name */
    private String f46239i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f46240j;

    /* renamed from: h, reason: collision with root package name */
    private Object f46238h = new Object();

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f46236f = new AtomicInteger(1);

    private i(Context context, String str) {
        this.f46234d = null;
        this.f46240j = null;
        this.f46235e = context;
        this.f46239i = str;
        this.f46240j = new Handler(Looper.getMainLooper(), new j(this));
        String a10 = com.vivo.push.util.aa.a(context);
        this.f46234d = a10;
        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(this.f46239i)) {
            this.f46233c = ag.a(context, this.f46234d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.u.c(this.f46235e, "init error : push pkgname is " + this.f46234d + " ; action is " + this.f46239i);
        this.f46233c = false;
    }

    private void d() {
        this.f46240j.removeMessages(1);
        this.f46240j.sendEmptyMessageDelayed(1, com.huawei.openalliance.ad.ipc.c.Code);
    }

    private void e() {
        this.f46240j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.f46235e.unbindService(this);
        } catch (Exception e2) {
            com.vivo.push.util.u.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.u.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f46237g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f46237g == null) {
            com.vivo.push.util.u.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f46236f.set(1);
            return;
        }
        if (this.f46236f.get() == 2) {
            a(4);
        } else if (this.f46236f.get() != 4) {
            f();
        }
        synchronized (this.f46238h) {
            this.f46238h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f46237g = null;
        a(1);
    }

    public static i a(Context context, String str) {
        i iVar = f46232b.get(str);
        if (iVar == null) {
            synchronized (f46231a) {
                iVar = f46232b.get(str);
                if (iVar == null) {
                    iVar = new i(context, str);
                    f46232b.put(str, iVar);
                }
            }
        }
        return iVar;
    }

    private void b() {
        int i10 = this.f46236f.get();
        com.vivo.push.util.u.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i10)));
        if (i10 == 4 || i10 == 2 || i10 == 3 || i10 == 5 || !this.f46233c) {
            return;
        }
        a(2);
        if (!c()) {
            a(1);
            com.vivo.push.util.u.a("AidlManager", "bind core service fail");
        } else {
            d();
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.f46239i);
        intent.setPackage(this.f46234d);
        try {
            return this.f46235e.bindService(intent, this, 1);
        } catch (Exception e2) {
            com.vivo.push.util.u.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        String a10 = com.vivo.push.util.aa.a(this.f46235e);
        this.f46234d = a10;
        if (TextUtils.isEmpty(a10)) {
            com.vivo.push.util.u.c(this.f46235e, "push pkgname is null");
            return false;
        }
        boolean z10 = ag.a(this.f46235e, this.f46234d) >= 1260;
        this.f46233c = z10;
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        this.f46236f.set(i10);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f46236f.get() == 2) {
            synchronized (this.f46238h) {
                try {
                    this.f46238h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i10 = this.f46236f.get();
            if (i10 == 4) {
                this.f46240j.removeMessages(2);
                this.f46240j.sendEmptyMessageDelayed(2, 30000L);
                this.f46237g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.u.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i10)));
            return false;
        } catch (Exception e10) {
            com.vivo.push.util.u.a("AidlManager", "invoke error ", e10);
            int i11 = this.f46236f.get();
            com.vivo.push.util.u.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i11)));
            if (i11 == 2) {
                e();
                a(1);
                return false;
            }
            if (i11 == 3) {
                a(1);
                return false;
            }
            if (i11 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
