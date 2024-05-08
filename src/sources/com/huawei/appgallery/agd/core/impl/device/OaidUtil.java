package com.huawei.appgallery.agd.core.impl.device;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import m9.a;
import m9.b;
import m9.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OaidUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final a f27428a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f27429b;

    static {
        String a10 = a();
        a10.hashCode();
        if (!a10.equals("meizu")) {
            f27428a = new b();
        } else {
            f27428a = new e();
        }
    }

    public static String a() {
        return "huawei";
    }

    public static void enableOAID(boolean z10) {
        f27429b = z10;
    }

    public static boolean getEnable() {
        return f27429b;
    }

    @Nullable
    public static String getOAID() {
        String oaid = f27428a.getOaid();
        if (TextUtils.isEmpty(oaid)) {
            refreshOAID();
        }
        return oaid;
    }

    public static void refreshOAID() {
        f27428a.a();
    }
}
