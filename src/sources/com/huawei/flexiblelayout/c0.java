package com.huawei.flexiblelayout;

import android.text.TextUtils;
import com.huawei.flexiblelayout.log.Log;

/* compiled from: GridWidthFunction.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c0 implements s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27744a = "GridWidthFunction";

    /* renamed from: b, reason: collision with root package name */
    public static final String f27745b = "grid-width";

    @Override // com.huawei.flexiblelayout.s
    public Integer a(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf(",") == -1) {
            return 0;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 2) {
                return a(Integer.valueOf(split[0].trim()).intValue(), Integer.valueOf(split[1].trim()).intValue());
            }
        } catch (Exception e2) {
            Log.w(f27744a, "execute, e: " + e2.getMessage().toString());
        }
        return 0;
    }

    private Integer a(int i10, int i11) {
        if (i11 <= 0) {
            return 0;
        }
        return Integer.valueOf((((int) ((r0.widthPixels / com.huawei.flexiblelayout.css.a.b().a().getResources().getDisplayMetrics().density) + 0.5f)) - i10) / i11);
    }
}
