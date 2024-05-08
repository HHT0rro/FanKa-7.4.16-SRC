package com.huawei.quickcard;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34086a = "GetElementByIDImpl";

    public static Object a(@Nullable String str, QuickCardRoot quickCardRoot) {
        ViewGroup rootViewGroup;
        if (TextUtils.isEmpty(str) || (rootViewGroup = quickCardRoot.getRootViewGroup()) == null) {
            return null;
        }
        return ValueUtils.obtainPropertyCacheBeanFromView(rootViewGroup).getViewById(str);
    }
}
