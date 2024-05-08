package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class as {
    private static final List<String> Code = new ArrayList();

    public static void Code(Context context) {
        List<String> list = Code;
        list.clear();
        list.add(ar.Z(context));
        list.add(ar.V(context));
        list.add(ar.B(context));
        list.add(ar.I(context));
    }

    public static boolean Code(String str) {
        List<String> list = Code;
        if (list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return list.contains(str);
    }
}
