package com.huawei.quickcard.flexiblelayoutadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.quickcard.base.wrapper.DataWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexibleLayoutDataArrWrapper<T extends FLImmutableArray> implements DataWrapper<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33693a = "FlexibleLayoutDataArrWr";

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object get(Object obj, int i10) {
        return com.huawei.quickcard.base.wrapper.a.a(this, obj, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull FLImmutableArray fLImmutableArray) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull FLImmutableArray fLImmutableArray) {
        return false;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ void set(Object obj, int i10, Object obj2) {
        com.huawei.quickcard.base.wrapper.a.b(this, obj, i10, obj2);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(Object obj, int i10) {
        return com.huawei.quickcard.base.wrapper.a.c(this, obj, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(Object obj, int i10, int i11) {
        return com.huawei.quickcard.base.wrapper.a.d(this, obj, i10, i11);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object splice(String str, int i10, Object obj, int i11, int i12, Object... objArr) {
        return com.huawei.quickcard.base.wrapper.a.e(this, str, i10, obj, i11, i12, objArr);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(Object obj) {
        return com.huawei.quickcard.base.wrapper.a.f(this, obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull FLImmutableArray fLImmutableArray, @NonNull Object obj) {
        if (fLImmutableArray instanceof FLArray) {
            ((FLArray) fLImmutableArray).add(obj);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull FLImmutableArray fLImmutableArray, @NonNull String str) {
        try {
            return fLImmutableArray.get(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull FLImmutableArray fLImmutableArray) {
        int size = fLImmutableArray.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = String.valueOf(i10);
        }
        return strArr;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull FLImmutableArray fLImmutableArray, @NonNull String str, @Nullable Object obj) {
        if (fLImmutableArray instanceof FLArray) {
            ((FLArray) fLImmutableArray).set(Integer.parseInt(str), obj);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull FLImmutableArray fLImmutableArray) {
        return fLImmutableArray.size();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public String stringify(@NonNull FLImmutableArray fLImmutableArray) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < fLImmutableArray.size(); i10++) {
            com.huawei.quickcard.base.wrapper.a.g(sb2, fLImmutableArray.get(i10));
            if (i10 < fLImmutableArray.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(']');
        return sb2.toString();
    }
}
