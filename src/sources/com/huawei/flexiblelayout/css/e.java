package com.huawei.flexiblelayout.css;

import android.view.View;

/* compiled from: CSSSelectorMarker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28006a = "css/";

    /* renamed from: b, reason: collision with root package name */
    private static final int f28007b = 1660944384;

    public static void a(View view, String str) {
        if (view != null) {
            view.setTag(str);
        }
    }

    public static String a(View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            tag = view.getTag(1660944384);
        }
        if (tag == null) {
            return null;
        }
        String obj = tag.toString();
        if (obj.startsWith(f28006a) && obj.length() > 4) {
            return obj.substring(4);
        }
        if (c.b(obj)) {
            return obj;
        }
        return null;
    }
}
