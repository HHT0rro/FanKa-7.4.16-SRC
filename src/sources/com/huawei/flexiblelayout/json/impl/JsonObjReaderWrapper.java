package com.huawei.flexiblelayout.json.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.json.Jsons;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonObjReaderWrapper implements FLImmutableMap {

    /* renamed from: a, reason: collision with root package name */
    private final FLImmutableMap f28177a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f28178b = new HashMap();

    public JsonObjReaderWrapper(@NonNull FLImmutableMap fLImmutableMap) {
        this.f28177a = fLImmutableMap;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(String str) {
        Object obj = this.f28178b.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.f28177a.get(str);
        Object immutableJsonIf = Jsons.toImmutableJsonIf(obj2);
        if (immutableJsonIf != obj2) {
            this.f28178b.put(str, immutableJsonIf);
        }
        return immutableJsonIf;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        return this.f28177a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public String[] keys() {
        return this.f28177a.keys();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLImmutableArray optArray(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof FLImmutableArray) {
            return (FLImmutableArray) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str) {
        return this.f28177a.optBoolean(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str) {
        return this.f28177a.optDouble(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str) {
        return this.f28177a.optInt(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str) {
        return this.f28177a.optLong(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLImmutableMap optMap(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof FLImmutableMap) {
            return (FLImmutableMap) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str) {
        return this.f28177a.optString(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        return this.f28177a.size();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str, boolean z10) {
        return this.f28177a.optBoolean(str, z10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str, double d10) {
        return this.f28177a.optDouble(str, d10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str, int i10) {
        return this.f28177a.optInt(str, i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str, long j10) {
        return this.f28177a.optLong(str, j10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str, String str2) {
        return this.f28177a.optString(str, str2);
    }
}
