package com.huawei.flexiblelayout.css.util;

import android.content.Context;
import com.huawei.flexiblelayout.common.c;

/* compiled from: CSSUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28015a = "CSSUtils";

    public static int a(Context context, float f10) {
        return c.a(context, f10);
    }

    public static int b(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
