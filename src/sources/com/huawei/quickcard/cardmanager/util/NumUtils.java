package com.huawei.quickcard.cardmanager.util;

import android.text.TextUtils;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NumUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33569a = "NumUtils";

    public static int parseInt(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            ManagerLogUtil.e(f33569a, "NumberFormatException, parse string is " + str);
            return i10;
        }
    }

    public static int parseInt(String str, int i10, int i11) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        try {
            if (!str.startsWith("0x") && !str.startsWith("0X")) {
                parseInt = Integer.parseInt(str);
                return parseInt;
            }
            parseInt = Integer.parseInt(str.substring(2), i10);
            return parseInt;
        } catch (Exception unused) {
            ManagerLogUtil.e(f33569a, "parse code failed: " + str);
            return i11;
        }
    }
}
