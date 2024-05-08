package com.tencent.turingface.sdk.mfa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.turingface.sdk.mfa.s5pTT;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kWj12 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f45883a = kC0XR.a(kC0XR.H0);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ShGzN {

        /* renamed from: a, reason: collision with root package name */
        public int f45884a;

        /* renamed from: b, reason: collision with root package name */
        public F2BEC f45885b;

        public ShGzN(int i10, F2BEC f2bec) {
            this.f45884a = i10;
            this.f45885b = f2bec;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f45886a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f45887b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f45888c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f45889d;

        /* renamed from: com.tencent.turingface.sdk.mfa.kWj12$spXPg$spXPg, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class C0655spXPg extends Thread {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBinder f45890a;

            public C0655spXPg(IBinder iBinder) {
                this.f45890a = iBinder;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                s5pTT c0656spXPg;
                int i10;
                IBinder iBinder = this.f45890a;
                String str = s5pTT.spXPg.f45938a;
                if (iBinder == null) {
                    c0656spXPg = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof s5pTT)) {
                        c0656spXPg = (s5pTT) queryLocalInterface;
                    } else {
                        c0656spXPg = new s5pTT.spXPg.C0656spXPg(iBinder);
                    }
                }
                try {
                    if (c0656spXPg.a()) {
                        i10 = 0;
                    } else {
                        c0656spXPg.e();
                        i10 = 1;
                    }
                    ShGzN a10 = kWj12.a(c0656spXPg.d().f45706b);
                    int i11 = a10.f45884a;
                    if (i11 != 0) {
                        spXPg.this.f45886a.set(Bi3eT.a(i11, i10));
                    } else {
                        F2BEC f2bec = a10.f45885b;
                        spXPg.this.f45886a.set(new Bi3eT(0, 200, System.currentTimeMillis() - spXPg.this.f45887b, f2bec.f45582h, c0656spXPg.b(), i10));
                    }
                } catch (Throwable unused) {
                    spXPg.this.f45886a.set(Bi3eT.a(-2003, -1));
                }
                synchronized (spXPg.this.f45888c) {
                    spXPg.this.f45888c.notify();
                }
                if (G1g37.f45591b.a(spXPg.this.f45889d, "s_t_d_ask", false)) {
                    try {
                        c0656spXPg.c();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public spXPg(AtomicReference atomicReference, long j10, Object obj, Context context) {
            this.f45886a = atomicReference;
            this.f45887b = j10;
            this.f45888c = obj;
            this.f45889d = context;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new C0655spXPg(iBinder).start();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this.f45886a.set(Bi3eT.a(-2004, -3));
            synchronized (this.f45888c) {
                this.f45888c.notify();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        if (r6.getCertificate("dddd" + r7) != null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingface.sdk.mfa.Bi3eT a(android.content.Context r15) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.kWj12.a(android.content.Context):com.tencent.turingface.sdk.mfa.Bi3eT");
    }

    public static Bi3eT b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(kC0XR.a(kC0XR.M0));
        intent.setPackage(kC0XR.a(kC0XR.N0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(Bi3eT.a(-2001, -1));
        if (context.getApplicationContext().bindService(intent, new spXPg(atomicReference, currentTimeMillis, obj, context), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException unused) {
                }
            }
        } else {
            atomicReference.set(Bi3eT.a(-2002, -1));
        }
        return (Bi3eT) atomicReference.get();
    }

    public static ShGzN a(byte[] bArr) {
        if (bArr == null) {
            return new ShGzN(-3001, null);
        }
        if (bArr.length < 4) {
            return new ShGzN(-3001, null);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, 4);
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            i10 += (bArr2[i11] & 255) << (i11 * 8);
        }
        if (i10 > 1048576) {
            return new ShGzN(-3003, null);
        }
        byte[] bArr3 = new byte[i10];
        int i12 = i10 + 4;
        if (bArr.length < i12) {
            return new ShGzN(-3004, null);
        }
        System.arraycopy((Object) bArr, 4, (Object) bArr3, 0, i10);
        F2BEC f2bec = new F2BEC(new String(bArr3));
        int length = bArr.length - i12;
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy((Object) bArr, i12, (Object) bArr4, 0, length);
            Base64.encodeToString(bArr4, 2);
            return new ShGzN(0, f2bec);
        }
        return new ShGzN(-3005, null);
    }
}
