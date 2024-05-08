package cn.shuzilm.core;

import android.content.Context;
import android.os.Looper;
import android.telephony.TelephonyManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1773a;

    public m(Context context) {
        this.f1773a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        boolean z10;
        DUHelper dUHelper2;
        DUHelper dUHelper3;
        DUHelper dUHelper4;
        try {
            System.loadLibrary("du");
            dUHelper = DUHelper.f1682d;
            z10 = dUHelper.f1702x;
            if (!z10) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                if (Looper.myLooper() != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) DUHelper.mContext.getSystemService("phone");
                    dUHelper3 = DUHelper.f1682d;
                    telephonyManager.listen(dUHelper3, 256);
                    dUHelper4 = DUHelper.f1682d;
                    dUHelper4.h(this.f1773a);
                }
                DUHelper.i(DUHelper.mContext);
            }
            dUHelper2 = DUHelper.f1682d;
            dUHelper2.f1702x = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
