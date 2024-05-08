package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.appgallery.agd.api.AgdConstant;
import com.huawei.appgallery.marketinstallerservice.api.Constant;
import com.tencent.turingface.sdk.mfa.flIYu;
import com.tencent.turingface.sdk.mfa.rBDKv;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class HDnuc {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f45596a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f45597b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f45598c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f45599d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public static CvowV f45600e;

    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List<com.tencent.turingface.sdk.mfa.JD1Ej>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    public static void a(CvowV cvowV) {
        Method method;
        rBDKv rbdkv = rBDKv.f45926a;
        rbdkv.f45929d = cvowV;
        boolean z10 = false;
        if (!rbdkv.f45931f) {
            rbdkv.f45931f = true;
            i3cNc.a(cvowV.f45543e);
            HandlerThread handlerThread = new HandlerThread("TuringFdCore_77_" + com.tencent.turingcam.oqKCa.f45455a + "_mfa", -8);
            handlerThread.start();
            rbdkv.f45930e = new rBDKv.spXPg(handlerThread.getLooper(), cvowV.f45543e);
            fenkF fenkf = new fenkF(rbdkv.f45930e);
            rbdkv.f45932g = fenkf;
            DO0IX do0ix = DO0IX.f45565a;
            do0ix.f45571g = cvowV;
            do0ix.f45572h = fenkf;
            do0ix.f45568d.put(40, Integer.valueOf(cvowV.f45557s ? 1 : 0));
            do0ix.f45568d.put(17, Integer.valueOf(cvowV.f45557s ? 1 : 0));
            Set<Integer> set = cvowV.f45563y;
            if (set != null) {
                for (Integer num : set) {
                    if (num != null) {
                        do0ix.f45568d.put(num, 0);
                    }
                }
            }
            new HnGHR(rbdkv).start();
        }
        Context context = cvowV.f45543e;
        LJPko.f45634a = cvowV;
        flIYu.f45796d = context;
        if (G1g37.f45591b.a(context, "enable_risk_click", false)) {
            if (Build.VERSION.SDK_INT >= 28) {
                Object obj = QafBz.f45668a;
                String[] strArr = {"L"};
                if (obj != null && (method = QafBz.f45669b) != null) {
                    try {
                        method.invoke(obj, strArr);
                        z10 = true;
                    } catch (Throwable unused) {
                    }
                }
                if (!z10) {
                    com.tencent.turingcam.oqKCa.i(context);
                }
            }
            flIYu.spXPg spxpg = flIYu.f45797e;
            flIYu.ShGzN shGzN = flIYu.f45798f;
            synchronized (qK8iQ.class) {
                qK8iQ.f45921a.add(spxpg);
                qK8iQ.f45922b = shGzN;
                gELYz.a(context.getApplicationContext(), qK8iQ.f45925e);
            }
            gELYz.f45804f = true;
        }
        OF1Jz.f45648b.f45649c = cvowV;
        new CXNbL(cvowV.f45543e).start();
    }

    public static int b(CvowV cvowV) {
        AtomicBoolean atomicBoolean = f45596a;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z10 = true;
        if (cvowV.f45546h) {
            TextUtils.isEmpty(cvowV.f45548j);
            String str = cvowV.f45548j;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("turingmfa");
                } else {
                    System.load(str);
                }
            } catch (Throwable unused) {
                z10 = false;
            }
            f45596a.set(z10);
        } else {
            atomicBoolean.set(true);
        }
        if (f45596a.get()) {
            return 0;
        }
        return Constant.INSTALL_FAILED_FILE_NOT_FOUND;
    }

    public static int c(CvowV cvowV) {
        Context context = cvowV.f45543e;
        HashMap hashMap = new HashMap();
        G1g37 g1g37 = G1g37.f45591b;
        hashMap.put("2008", g1g37.a(context, "e_w_d", false) ? "1" : "0");
        hashMap.put("2009", g1g37.a(context, "e_r_d", true) ? "1" : "0");
        hashMap.put(AgdConstant.INSTALL_TYPE_FULL_AUTO, g1g37.a(context, "e_w_nd", true) ? "1" : "0");
        hashMap.put(AgdConstant.INSTALL_TYPE_FULL_AUTO_NOTIFICATION, g1g37.a(context, "e_r_nd", true) ? "1" : "0");
        try {
            return com.tencent.turingcam.oqKCa.b(TNative$aa.i77(new SparseArray(), context, hashMap)) != 0 ? -10020 : 0;
        } catch (Throwable unused) {
            return -10020;
        }
    }

    public static int a() {
        if (!f45596a.get()) {
            return Constant.INSTALL_FAILED_FILE_NOT_FOUND;
        }
        if (com.tencent.turingcam.oqKCa.f45455a == 0) {
            return -10018;
        }
        if (!f45597b.get()) {
            return Constant.INSTALL_FAILED_SHA256_EEROR;
        }
        spXPg spxpg = f45600e.f45541c;
        if (spxpg == null) {
            spxpg = CvowV.f45539a;
        }
        return !spxpg.a() ? -10019 : 0;
    }
}
