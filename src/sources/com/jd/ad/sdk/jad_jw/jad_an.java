package com.jd.ad.sdk.jad_jw;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.jd.ad.sdk.jad_sf.jad_an;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.logger.Logger;

/* compiled from: OaidHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an {
    public static String jad_an = "";

    /* compiled from: OaidHelper.java */
    /* renamed from: com.jd.ad.sdk.jad_jw.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class C0368jad_an implements IIdentifierListener {
        @Override // com.bun.miitmdid.interfaces.IIdentifierListener
        public void OnSupport(boolean z10, IdSupplier idSupplier) {
            if (z10 && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", jad_an.jad_an);
                jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void onSupport(IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            String oaid = idSupplier.getOAID();
            jad_an.jad_an = oaid;
            if (TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", jad_an.jad_an);
            jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 14 */
    /* JADX WARN: Unreachable blocks removed: 3, instructions: 15 */
    public static void jad_an(Context context) {
        Class<?> cls;
        Throwable th;
        Class<?> cls2;
        if (context == null || MdidSdkHelper.class == 0) {
            return;
        }
        if (IIdentifierListener.class != 0) {
            try {
                MdidSdkHelper.InitSdk(context, true, new C0368jad_an());
                return;
            } catch (Error e2) {
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ");
                jad_an2.append(Log.getStackTraceString(e2));
                Logger.d(jad_an2.toString());
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.UTILS_OADI_REFLECT_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
                return;
            } catch (Exception e10) {
                StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ");
                jad_an3.append(Log.getStackTraceString(e10));
                Logger.d(jad_an3.toString());
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.UTILS_OADI_REFLECT_ERROR;
                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e10.getMessage()));
                return;
            }
        }
        try {
            cls2 = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
            try {
                cls = Class.forName("com.bun.miitmdid.core.JLibrary");
            } catch (Throwable th2) {
                cls = null;
                th = th2;
            }
        } catch (Throwable th3) {
            cls = null;
            th = th3;
            cls2 = null;
        }
        try {
            cls.getMethod("InitEntry", Context.class).invoke(null, context);
        } catch (Throwable th4) {
            th = th4;
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect InitEntry method error: ");
            jad_an4.append(Log.getStackTraceString(th));
            Logger.d(jad_an4.toString());
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.UTILS_OADI_REFLECT_INITENTRY_ERROR;
            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(th.getMessage()));
            if (cls2 != null) {
                return;
            } else {
                return;
            }
        }
        if (cls2 != null || cls == null) {
            return;
        }
        try {
            MdidSdkHelper.InitSdk(context, true, (com.bun.miitmdid.core.IIdentifierListener) new jad_bo());
        } catch (Throwable th5) {
            StringBuilder jad_an5 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ");
            jad_an5.append(Log.getStackTraceString(th5));
            Logger.d(jad_an5.toString());
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar4 = com.jd.ad.sdk.jad_uh.jad_an.UTILS_OADI_REFLECT_ERROR;
            jad_fs.jad_an("", jad_anVar4.jad_an, jad_anVar4.jad_an(th5.getMessage()));
        }
    }

    /* compiled from: OaidHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_bo implements com.bun.miitmdid.core.IIdentifierListener {
        public void OnSupport(boolean z10, com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (z10 && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", jad_an.jad_an);
                jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void OnSupport(com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            String oaid = idSupplier.getOAID();
            jad_an.jad_an = oaid;
            if (TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", jad_an.jad_an);
            jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
