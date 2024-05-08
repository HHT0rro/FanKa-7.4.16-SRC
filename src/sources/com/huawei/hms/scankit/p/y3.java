package com.huawei.hms.scankit.p;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: HaUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y3 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f31757a = "y3";

    /* renamed from: b, reason: collision with root package name */
    private static volatile Bundle f31758b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f31759c = "";

    /* renamed from: d, reason: collision with root package name */
    public static HashSet<String> f31760d = new HashSet<>();

    public static Bundle a(Context context) {
        if (context == null) {
            return new Bundle();
        }
        if (f31758b == null) {
            Bundle bundle = new Bundle();
            try {
                String string = a9.a.b(context).getString(AgConnectInfo.AgConnectKey.APPLICATION_ID);
                if (string == null) {
                    string = context.getPackageName();
                }
                bundle.putString("appid", string);
            } catch (RuntimeException | Exception unused) {
            }
            f31758b = bundle;
        }
        return f31758b;
    }

    public static String b(Context context) {
        if (f31759c.length() == 0) {
            f31759c = context.getPackageName();
        }
        return f31759c;
    }

    public static HashSet<String> a() {
        if (f31760d.size() == 0) {
            f31760d.add("com.huawei.scanner");
            f31760d.add("com.huawei.hitouch");
        }
        return f31760d;
    }

    public static boolean a(String str, HashSet<String> hashSet) {
        if (str.length() == 0) {
            return true;
        }
        Iterator<String> iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            if (str.contains(iterator2.next())) {
                return false;
            }
        }
        return true;
    }
}
