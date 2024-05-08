package com.huawei.flexiblelayout.json.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.json.Jsons;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonArrReaderWrapper implements FLImmutableArray {

    /* renamed from: a, reason: collision with root package name */
    private final FLImmutableArray f28173a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, Object> f28174b = new HashMap();

    public JsonArrReaderWrapper(@NonNull FLImmutableArray fLImmutableArray) {
        this.f28173a = fLImmutableArray;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public Object get(int i10) {
        Object obj = this.f28174b.get(Integer.valueOf(i10));
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.f28173a.get(i10);
        Object immutableJsonIf = Jsons.toImmutableJsonIf(obj2);
        if (immutableJsonIf != obj2) {
            this.f28174b.put(Integer.valueOf(i10), immutableJsonIf);
        }
        return immutableJsonIf;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public boolean isEmpty() {
        return this.f28173a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public FLImmutableArray optArray(int i10) {
        Object obj = get(i10);
        if (obj instanceof FLImmutableArray) {
            return (FLImmutableArray) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public boolean optBoolean(int i10) {
        return this.f28173a.optBoolean(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public double optDouble(int i10) {
        return this.f28173a.optDouble(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public int optInt(int i10) {
        return this.f28173a.optInt(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public long optLong(int i10) {
        return this.f28173a.optLong(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public FLImmutableMap optMap(int i10) {
        Object obj = get(i10);
        if (obj instanceof FLImmutableMap) {
            return (FLImmutableMap) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public String optString(int i10) {
        return this.f28173a.optString(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public int size() {
        return this.f28173a.size();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public boolean optBoolean(int i10, boolean z10) {
        return this.f28173a.optBoolean(i10, z10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public double optDouble(int i10, double d10) {
        return this.f28173a.optDouble(i10, d10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public int optInt(int i10, int i11) {
        return this.f28173a.optInt(i10, i11);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public long optLong(int i10, long j10) {
        return this.f28173a.optLong(i10, j10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public String optString(int i10, String str) {
        return this.f28173a.optString(i10, str);
    }
}
