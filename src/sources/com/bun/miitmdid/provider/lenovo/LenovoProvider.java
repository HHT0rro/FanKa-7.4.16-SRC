package com.bun.miitmdid.provider.lenovo;

import XI.vs.K0.XI;
import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LenovoProvider extends BaseProvider {
    public static final String TAG = "SDK call Lenovo: ";
    public Context context;
    public XI openDeviceId = new XI();

    /* renamed from: com.bun.miitmdid.provider.lenovo.LenovoProvider$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class AnonymousClass1 implements XI.K0<String> {
        public AnonymousClass1() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
        @Override // XI.vs.K0.XI.K0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void serviceConnected(java.lang.String r6, XI.vs.K0.XI r7) {
            /*
                r5 = this;
                com.bun.miitmdid.provider.lenovo.LenovoProvider r6 = com.bun.miitmdid.provider.lenovo.LenovoProvider.this
                java.util.Objects.requireNonNull(r7)
                XI.vs.XI.XI r0 = r7.K0     // Catch: android.os.RemoteException -> Le
                if (r0 == 0) goto Le
                boolean r0 = r0.isSupport()     // Catch: android.os.RemoteException -> Le
                goto Lf
            Le:
                r0 = 0
            Lf:
                com.bun.miitmdid.provider.lenovo.LenovoProvider.access$002(r6, r0)
                android.content.Context r6 = r7.f650XI
                java.lang.String r0 = "Context is null, must be new OpenDeviceId first"
                if (r6 == 0) goto La2
                r6 = 0
                XI.vs.XI.XI r1 = r7.K0     // Catch: android.os.RemoteException -> L22
                if (r1 == 0) goto L26
                java.lang.String r1 = r1.getOAID()     // Catch: android.os.RemoteException -> L22
                goto L27
            L22:
                r1 = move-exception
                r1.printStackTrace()
            L26:
                r1 = r6
            L27:
                android.content.Context r2 = r7.f650XI
                if (r2 == 0) goto L9c
                java.lang.String r2 = r2.getPackageName()
                java.lang.String r3 = ""
                if (r2 == 0) goto L46
                boolean r4 = r2.equals(r3)
                if (r4 != 0) goto L46
                XI.vs.XI.XI r4 = r7.K0     // Catch: android.os.RemoteException -> L42
                if (r4 == 0) goto L46
                java.lang.String r2 = r4.getVAID(r2)     // Catch: android.os.RemoteException -> L42
                goto L47
            L42:
                r2 = move-exception
                r2.printStackTrace()
            L46:
                r2 = r6
            L47:
                android.content.Context r4 = r7.f650XI
                if (r4 == 0) goto L96
                java.lang.String r0 = r4.getPackageName()
                if (r0 == 0) goto L77
                boolean r4 = r0.equals(r3)
                if (r4 != 0) goto L77
                XI.vs.XI.XI r4 = r7.K0     // Catch: android.os.RemoteException -> L76
                if (r4 == 0) goto L77
                java.lang.String r6 = r4.getAAID(r0)     // Catch: android.os.RemoteException -> L76
                if (r6 == 0) goto L67
                boolean r4 = r3.equals(r6)     // Catch: android.os.RemoteException -> L76
                if (r4 == 0) goto L77
            L67:
                XI.vs.XI.XI r4 = r7.K0     // Catch: android.os.RemoteException -> L76
                boolean r4 = r4.XI(r0)     // Catch: android.os.RemoteException -> L76
                if (r4 == 0) goto L77
                XI.vs.XI.XI r7 = r7.K0     // Catch: android.os.RemoteException -> L76
                java.lang.String r6 = r7.getAAID(r0)     // Catch: android.os.RemoteException -> L76
                goto L77
            L76:
            L77:
                com.bun.miitmdid.provider.lenovo.LenovoProvider r7 = com.bun.miitmdid.provider.lenovo.LenovoProvider.this
                if (r1 != 0) goto L7c
                r1 = r3
            L7c:
                com.bun.miitmdid.provider.lenovo.LenovoProvider.access$102(r7, r1)
                com.bun.miitmdid.provider.lenovo.LenovoProvider r7 = com.bun.miitmdid.provider.lenovo.LenovoProvider.this
                if (r2 != 0) goto L84
                r2 = r3
            L84:
                com.bun.miitmdid.provider.lenovo.LenovoProvider.access$202(r7, r2)
                com.bun.miitmdid.provider.lenovo.LenovoProvider r7 = com.bun.miitmdid.provider.lenovo.LenovoProvider.this
                if (r6 != 0) goto L8c
                goto L8d
            L8c:
                r3 = r6
            L8d:
                com.bun.miitmdid.provider.lenovo.LenovoProvider.access$302(r7, r3)
                com.bun.miitmdid.provider.lenovo.LenovoProvider r6 = com.bun.miitmdid.provider.lenovo.LenovoProvider.this
                r6.returnCallResult()
                return
            L96:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                r6.<init>(r0)
                throw r6
            L9c:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                r6.<init>(r0)
                throw r6
            La2:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bun.miitmdid.provider.lenovo.LenovoProvider.AnonymousClass1.serviceConnected(java.lang.String, XI.vs.K0.XI):void");
        }
    }

    public LenovoProvider(Context context) {
        this.context = context;
    }

    public static /* synthetic */ boolean access$002(LenovoProvider lenovoProvider, boolean z10) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = Boolean.valueOf(z10);
        objArr[3] = 64;
        objArr[4] = 1598952044286L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    public static /* synthetic */ String access$102(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 65;
        objArr[4] = 1598952044287L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$202(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 66;
        objArr[4] = 1598952044288L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$302(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 67;
        objArr[4] = 1598952044289L;
        return (String) Utils.rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 68, 1598952044290L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 69, 1598952044291L})).booleanValue();
    }
}
