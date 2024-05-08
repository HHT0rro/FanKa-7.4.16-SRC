package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        c.a();
    }

    public static boolean getInitFlag() {
        return a.b();
    }

    public static void init(Context context, boolean z10, boolean z11, boolean z12, String str, String str2) {
        new b(context).a(z10).c(z11).b(z12).a(0, str).a(1, str).a(str2).a();
    }

    public static void onEvent(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void onReport() {
        a.c();
    }

    public static void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.b(i10, str, linkedHashMap);
    }

    public static void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.a(i10, str, linkedHashMap);
    }
}
