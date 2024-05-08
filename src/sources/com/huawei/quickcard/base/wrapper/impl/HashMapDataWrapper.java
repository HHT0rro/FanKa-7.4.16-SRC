package com.huawei.quickcard.base.wrapper.impl;

import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.huawei.quickcard.base.wrapper.a;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HashMapDataWrapper implements DataWrapper<HashMap> {
    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull HashMap hashMap, @NonNull Object obj) {
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object get(HashMap hashMap, int i10) {
        return a.a(this, hashMap, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull HashMap hashMap) {
        return false;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull HashMap hashMap) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ void set(HashMap hashMap, int i10, Object obj) {
        a.b(this, hashMap, i10, obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(HashMap hashMap, int i10) {
        return a.c(this, hashMap, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(HashMap hashMap, int i10, int i11) {
        return a.d(this, hashMap, i10, i11);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object splice(String str, int i10, HashMap hashMap, int i11, int i12, Object... objArr) {
        return a.e(this, str, i10, hashMap, i11, i12, objArr);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(HashMap hashMap) {
        return a.f(this, hashMap);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull HashMap hashMap, @NonNull String str) {
        return hashMap.get(str);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull HashMap hashMap) {
        return (String[]) hashMap.h().toArray(new String[0]);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull HashMap hashMap, @NonNull String str, Object obj) {
        hashMap.put(str, obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull HashMap hashMap) {
        return hashMap.h().size();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String stringify(@NonNull HashMap hashMap) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        String[] keys = keys(hashMap);
        for (int i10 = 0; i10 < keys.length; i10++) {
            String str = keys[i10];
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\"");
            sb2.append(u.bD);
            a.g(sb2, hashMap.get(keys[i10]));
            if (i10 < keys.length - 1) {
                sb2.append(',');
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
