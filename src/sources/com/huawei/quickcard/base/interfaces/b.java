package com.huawei.quickcard.base.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class b {
    @Nullable
    public static Object a(IQuickCardData iQuickCardData, @NonNull int i10) {
        return iQuickCardData.get(String.valueOf(i10));
    }

    public static void b(IQuickCardData iQuickCardData, @NonNull int i10, @Nullable Object obj) {
        iQuickCardData.set(i10, obj);
    }

    public static void c(IQuickCardData iQuickCardData, @NonNull String str, @Nullable Object obj) {
        iQuickCardData.set(str, obj);
    }

    public static void d(IQuickCardData iQuickCardData, @NonNull int i10, @Nullable Object obj) {
        iQuickCardData.set(String.valueOf(i10), obj);
    }

    public static Object e(IQuickCardData iQuickCardData) {
        return iQuickCardData.slice(0, iQuickCardData.size());
    }

    public static Object f(IQuickCardData iQuickCardData, int i10) {
        return iQuickCardData.slice(i10, iQuickCardData.size());
    }

    public static Object g(IQuickCardData iQuickCardData, int i10) {
        return iQuickCardData.splice(i10, iQuickCardData.size() - i10, new Object[0]);
    }
}
