package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.cn;
import com.huawei.openalliance.ad.ipc.a;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class c<SERVICE extends IInterface> implements a.InterfaceC0335a {
    public static final long Code = 3000;
    private static final String Z = "install_service_timeout_task";
    private SERVICE C;
    public com.huawei.openalliance.ad.ipc.a I;
    public Context V;
    private final String B = Z + hashCode();
    private boolean S = false;
    private final byte[] F = new byte[0];
    private Set<a> D = new CopyOnWriteArraySet();
    private ServiceConnection L = new ServiceConnection() { // from class: com.huawei.openalliance.ad.ipc.c.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                gl.Code(c.this.V(), "onServiceConnected comp name: %s pkgName: %s", componentName.getClassName(), componentName.getPackageName());
                if (!c.this.F().equalsIgnoreCase(componentName.getClassName())) {
                    c.this.Code("pps remote service name not match, disconnect service.");
                    c.this.Code((c) null);
                    return;
                }
                ba.Code(c.this.B);
                gl.V(c.this.V(), "PPS remote service connected: %d", Long.valueOf(System.currentTimeMillis()));
                c.this.Code((c) c.this.Code(iBinder));
                c.this.Code(componentName);
                if (c.this.S() && c.this.D()) {
                    gl.I(c.this.V(), "request is already timeout");
                    return;
                }
                IInterface a10 = c.this.a();
                if (a10 != null) {
                    ArrayList arrayList = new ArrayList(c.this.D);
                    c.this.D.clear();
                    Iterator<E> iterator2 = arrayList.iterator2();
                    while (iterator2.hasNext()) {
                        ((a) iterator2.next()).Code((a) a10);
                    }
                }
            } catch (Throwable th) {
                gl.I(c.this.V(), "BaseASM Service, service error: %s", th.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            gl.V(c.this.V(), "PPS remote service disconnected");
            c.this.Code((c) null);
            c.this.C();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class a<SERVICE extends IInterface> {
        private com.huawei.openalliance.ad.ipc.a Code;

        public abstract void Code(SERVICE service);

        public void Code(com.huawei.openalliance.ad.ipc.a aVar) {
            this.Code = aVar;
        }

        public abstract void Code(String str);

        public void finalize() {
            super.finalize();
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.Code == null || v.B(a.this.Code.Code())) {
                        return;
                    }
                    a.this.Code.I();
                }
            });
        }
    }

    public c(Context context) {
        this.V = context.getApplicationContext();
        this.I = new com.huawei.openalliance.ad.ipc.a(context, V(), this);
    }

    private void Code(long j10) {
        ba.Code(this.B);
        Code(false);
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.1
            @Override // java.lang.Runnable
            public void run() {
                gl.V(c.this.V(), "bind timeout " + System.currentTimeMillis());
                c.this.Code(true);
                c.this.Code("service bind timeout");
            }
        }, this.B, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Code(SERVICE service) {
        this.C = service;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        try {
            ArrayList arrayList = new ArrayList(this.D);
            this.D.clear();
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                ((a) iterator2.next()).Code(str);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z10) {
        synchronized (this.F) {
            this.S = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        boolean z10;
        synchronized (this.F) {
            z10 = this.S;
        }
        return z10;
    }

    private boolean L() {
        try {
            gl.V(V(), "bindService " + System.currentTimeMillis());
            B();
            Intent intent = new Intent(I());
            String Z2 = Z();
            gl.V(V(), "bind service pkg: " + Z2);
            intent.setPackage(Z2);
            if (!ea.B(this.V) && com.huawei.openalliance.ad.utils.e.Code(Z2)) {
                String B = com.huawei.openalliance.ad.utils.e.B(this.V, Z2);
                boolean isEmpty = TextUtils.isEmpty(B);
                gl.V(V(), "is sign empty: %s", Boolean.valueOf(isEmpty));
                if (!isEmpty && !cn.Code(this.V, Z2, B)) {
                    return false;
                }
            }
            boolean bindService = this.V.bindService(intent, this.L, 1);
            gl.V(V(), "bind service result: %s", Boolean.valueOf(bindService));
            if (!bindService) {
                Code("bind service failed");
            }
            return bindService;
        } catch (SecurityException unused) {
            gl.I(V(), "bindService SecurityException");
            Code("bindService SecurityException");
            return false;
        } catch (Exception e2) {
            gl.I(V(), "bindService " + e2.getClass().getSimpleName());
            Code("bindService " + e2.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized SERVICE a() {
        return this.C;
    }

    public abstract void B();

    public void C() {
    }

    public abstract SERVICE Code(IBinder iBinder);

    @Override // com.huawei.openalliance.ad.ipc.a.InterfaceC0335a
    public synchronized void Code() {
        this.V.unbindService(this.L);
        this.C = null;
    }

    public abstract void Code(ComponentName componentName);

    public void Code(a aVar, long j10) {
        gl.Code(V(), "handleTask");
        aVar.Code(this.I);
        this.I.V();
        SERVICE a10 = a();
        if (a10 != null) {
            aVar.Code((a) a10);
            return;
        }
        this.D.add(aVar);
        if (L() && S()) {
            Code(j10);
        }
    }

    public abstract String F();

    public abstract String I();

    public boolean S() {
        return false;
    }

    public String V() {
        return "";
    }

    public abstract String Z();
}
