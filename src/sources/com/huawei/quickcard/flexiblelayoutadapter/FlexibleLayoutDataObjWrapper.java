package com.huawei.quickcard.flexiblelayoutadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.wrapper.DataWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexibleLayoutDataObjWrapper<T extends FLImmutableMap> implements DataWrapper<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33694a = "FlexibleLayoutDataObjWr";

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull FLImmutableMap fLImmutableMap, @NonNull Object obj) {
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object get(Object obj, int i10) {
        return com.huawei.quickcard.base.wrapper.a.a(this, obj, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull FLImmutableMap fLImmutableMap) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull FLImmutableMap fLImmutableMap) {
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
    public Object get(@NonNull FLImmutableMap fLImmutableMap, @NonNull String str) {
        return fLImmutableMap.get(str);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull FLImmutableMap fLImmutableMap) {
        return fLImmutableMap.keys();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull FLImmutableMap fLImmutableMap, @NonNull String str, @Nullable Object obj) {
        if (fLImmutableMap instanceof FLMap) {
            ((FLMap) fLImmutableMap).put(str, obj);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull FLImmutableMap fLImmutableMap) {
        return fLImmutableMap.size();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public String stringify(@NonNull FLImmutableMap fLImmutableMap) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        String[] keys = keys(fLImmutableMap);
        for (int i10 = 0; i10 < keys.length; i10++) {
            try {
                String str = keys[i10];
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
                sb2.append(u.bD);
                com.huawei.quickcard.base.wrapper.a.g(sb2, fLImmutableMap.get(keys[i10]));
                if (i10 < keys.length - 1) {
                    sb2.append(',');
                }
            } catch (Exception e2) {
                CardLogUtils.e(f33694a, "stringify error in flexiblelayout data", e2);
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
