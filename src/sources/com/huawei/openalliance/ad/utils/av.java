package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class av {
    private static final String Code = "SwUt";

    public static Integer Code(String str, int i10) {
        return Code(str, i10, 0);
    }

    public static Integer Code(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str) || i11 < 0) {
            return null;
        }
        String[] split = str.split("-");
        if (split.length < i11 + 1) {
            return null;
        }
        return V(split[i11], i10);
    }

    private static Integer V(String str, int i10) {
        StringBuilder sb2;
        if (!TextUtils.isEmpty(str) && str.length() > i10) {
            try {
                return Integer.valueOf(Integer.parseInt(str.substring(i10, i10 + 1)));
            } catch (RuntimeException e2) {
                e = e2;
                sb2 = new StringBuilder();
                sb2.append("getSwh ");
                sb2.append(e.getClass().getSimpleName());
                gl.I(Code, sb2.toString());
                return null;
            } catch (Exception e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("getSwh ");
                sb2.append(e.getClass().getSimpleName());
                gl.I(Code, sb2.toString());
                return null;
            }
        }
        return null;
    }
}
