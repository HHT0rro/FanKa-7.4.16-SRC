package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class e0 {
    private i a(int i10) {
        String str;
        if (i10 != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private i b(int i10) {
        String str;
        if ((i10 & 4) != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private boolean e() {
        g1 b4 = s.c().b();
        if (TextUtils.isEmpty(b4.l())) {
            b4.h(o.a());
        }
        return !TextUtils.isEmpty(b4.l());
    }

    private String f() {
        g1 b4 = s.c().b();
        if (TextUtils.isEmpty(b4.i())) {
            b4.e(x0.c());
        }
        return b4.i();
    }

    public i a(Context context) {
        String c4 = c();
        if (!TextUtils.isEmpty(c4)) {
            return new i(d0.UDID, c4);
        }
        String a10 = a();
        if (!TextUtils.isEmpty(a10)) {
            return new i(d0.IMEI, a10);
        }
        boolean e2 = e();
        String b4 = b();
        return !TextUtils.isEmpty(b4) ? e2 ? new i(d0.SN, b4) : new i(d0.UDID, a(b4)) : e2 ? a(d()) : b(d());
    }

    public abstract String a();

    public abstract String a(String str);

    public abstract String b();

    public abstract String c();

    public abstract int d();
}
