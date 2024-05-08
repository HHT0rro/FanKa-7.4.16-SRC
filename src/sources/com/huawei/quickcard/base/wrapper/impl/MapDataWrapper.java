package com.huawei.quickcard.base.wrapper.impl;

import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.huawei.quickcard.base.wrapper.a;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MapDataWrapper implements DataWrapper<Map> {
    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull Map map, @NonNull Object obj) {
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object get(Map map, int i10) {
        return a.a(this, map, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull Map map) {
        return false;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull Map map) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ void set(Map map, int i10, Object obj) {
        a.b(this, map, i10, obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(Map map, int i10) {
        return a.c(this, map, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(Map map, int i10, int i11) {
        return a.d(this, map, i10, i11);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object splice(String str, int i10, Map map, int i11, int i12, Object... objArr) {
        return a.e(this, str, i10, map, i11, i12, objArr);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(Map map) {
        return a.f(this, map);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull Map map, @NonNull String str) {
        return map.get(str);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull Map map) {
        return (String[]) map.h().toArray(new String[0]);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull Map map, @NonNull String str, Object obj) {
        map.put(str, obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull Map map) {
        return map.h().size();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String stringify(@NonNull Map map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        String[] keys = keys(map);
        for (int i10 = 0; i10 < keys.length; i10++) {
            String str = keys[i10];
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\"");
            sb2.append(u.bD);
            a.g(sb2, map.get(keys[i10]));
            if (i10 < keys.length - 1) {
                sb2.append(',');
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
