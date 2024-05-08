package com.bun.miitmdid.provider.freeme;

import XI.XI.K0.kM;
import XI.XI.K0.xo;
import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FreemeProvider extends BaseProvider {
    public static final String TAG = "SDK call Freeme: ";
    public Context context;
    public String packagename;

    /* renamed from: com.bun.miitmdid.provider.freeme.FreemeProvider$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class AnonymousClass1 implements xo {
        public final /* synthetic */ kM val$idSupplier;

        public AnonymousClass1(kM kMVar) {
            this.val$idSupplier = kMVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // XI.XI.K0.xo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void connectSuccess(boolean r6) {
            /*
                r5 = this;
                if (r6 == 0) goto L88
                XI.XI.K0.kM r6 = r5.val$idSupplier
                XI.XI.K0.K0 r6 = (XI.XI.K0.K0) r6
                boolean r6 = r6.XI()
                if (r6 == 0) goto L79
                com.bun.miitmdid.provider.freeme.FreemeProvider r6 = com.bun.miitmdid.provider.freeme.FreemeProvider.this
                r0 = 1
                com.bun.miitmdid.provider.freeme.FreemeProvider.access$002(r6, r0)
                XI.XI.K0.kM r6 = r5.val$idSupplier
                XI.XI.K0.K0 r6 = (XI.XI.K0.K0) r6
                XI.XI.XI.XI r6 = r6.K0
                r0 = 0
                if (r6 == 0) goto L24
                java.lang.String r6 = r6.getOAID()     // Catch: android.os.RemoteException -> L20
                goto L25
            L20:
                r6 = move-exception
                r6.printStackTrace()
            L24:
                r6 = r0
            L25:
                XI.XI.K0.kM r1 = r5.val$idSupplier
                com.bun.miitmdid.provider.freeme.FreemeProvider r2 = com.bun.miitmdid.provider.freeme.FreemeProvider.this
                com.bun.miitmdid.provider.freeme.FreemeProvider.access$100(r2)
                XI.XI.K0.K0 r1 = (XI.XI.K0.K0) r1
                XI.XI.XI.XI r1 = r1.K0
                if (r1 == 0) goto L3b
                java.lang.String r1 = r1.getVAID()     // Catch: android.os.RemoteException -> L37
                goto L3c
            L37:
                r1 = move-exception
                r1.printStackTrace()
            L3b:
                r1 = r0
            L3c:
                XI.XI.K0.kM r2 = r5.val$idSupplier
                com.bun.miitmdid.provider.freeme.FreemeProvider r3 = com.bun.miitmdid.provider.freeme.FreemeProvider.this
                java.lang.String r3 = com.bun.miitmdid.provider.freeme.FreemeProvider.access$100(r3)
                XI.XI.K0.K0 r2 = (XI.XI.K0.K0) r2
                XI.XI.XI.XI r4 = r2.K0
                if (r4 == 0) goto L5a
                XI.XI.XI.XI r4 = r2.K0     // Catch: android.os.RemoteException -> L56
                java.util.Objects.toString(r4)     // Catch: android.os.RemoteException -> L56
                XI.XI.XI.XI r2 = r2.K0     // Catch: android.os.RemoteException -> L56
                java.lang.String r0 = r2.getAAID(r3)     // Catch: android.os.RemoteException -> L56
                goto L5a
            L56:
                r2 = move-exception
                r2.printStackTrace()
            L5a:
                com.bun.miitmdid.provider.freeme.FreemeProvider r2 = com.bun.miitmdid.provider.freeme.FreemeProvider.this
                java.lang.String r3 = ""
                if (r6 != 0) goto L61
                r6 = r3
            L61:
                com.bun.miitmdid.provider.freeme.FreemeProvider.access$202(r2, r6)
                com.bun.miitmdid.provider.freeme.FreemeProvider r6 = com.bun.miitmdid.provider.freeme.FreemeProvider.this
                if (r1 != 0) goto L69
                r1 = r3
            L69:
                com.bun.miitmdid.provider.freeme.FreemeProvider.access$302(r6, r1)
                com.bun.miitmdid.provider.freeme.FreemeProvider r6 = com.bun.miitmdid.provider.freeme.FreemeProvider.this
                if (r0 != 0) goto L71
                r0 = r3
            L71:
                com.bun.miitmdid.provider.freeme.FreemeProvider.access$402(r6, r0)
                com.bun.miitmdid.provider.freeme.FreemeProvider r6 = com.bun.miitmdid.provider.freeme.FreemeProvider.this
                r6.returnCallResult()
            L79:
                XI.XI.K0.kM r6 = r5.val$idSupplier
                XI.XI.K0.K0 r6 = (XI.XI.K0.K0) r6
                XI.XI.XI.XI r0 = r6.K0
                if (r0 == 0) goto L88
                android.content.Context r0 = r6.f646XI
                android.content.ServiceConnection r6 = r6.xo
                r0.unbindService(r6)
            L88:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bun.miitmdid.provider.freeme.FreemeProvider.AnonymousClass1.connectSuccess(boolean):void");
        }
    }

    public FreemeProvider(Context context) {
        this.context = context;
        this.packagename = context.getPackageName();
    }

    public static /* synthetic */ boolean access$002(FreemeProvider freemeProvider, boolean z10) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = Boolean.valueOf(z10);
        objArr[3] = 53;
        objArr[4] = 1598952044275L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    public static /* synthetic */ String access$100(FreemeProvider freemeProvider) {
        Object[] objArr = new Object[4];
        objArr[1] = freemeProvider;
        objArr[2] = 54;
        objArr[3] = 1598952044276L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$202(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 55;
        objArr[4] = 1598952044277L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$302(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 56;
        objArr[4] = 1598952044278L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$402(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 57;
        objArr[4] = 1598952044279L;
        return (String) Utils.rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 58, 1598952044280L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 59, 1598952044281L})).booleanValue();
    }
}
