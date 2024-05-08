package com.huawei.flexiblelayout.json.impl;

import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.json.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonArrReaderImpl implements FLImmutableArray {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, Object> f28172a;

    @NonNull
    public final JSONArray mJsonArr;

    public JsonArrReaderImpl(@NonNull JSONArray jSONArray) {
        this.f28172a = new HashMap();
        this.mJsonArr = jSONArray;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public Object get(int i10) {
        Object obj = this.f28172a.get(Integer.valueOf(i10));
        if (obj != null) {
            return obj;
        }
        Object opt = this.mJsonArr.opt(i10);
        Object immutableJsonIf = Jsons.toImmutableJsonIf(opt);
        if (immutableJsonIf != opt) {
            this.f28172a.put(Integer.valueOf(i10), immutableJsonIf);
        }
        return immutableJsonIf;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public boolean isEmpty() {
        return size() == 0;
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
        return optBoolean(i10, false);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public double optDouble(int i10) {
        return optDouble(i10, ShadowDrawableWrapper.COS_45);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public int optInt(int i10) {
        return optInt(i10, 0);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public long optLong(int i10) {
        return optLong(i10, 0L);
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
        return optString(i10, "");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public int size() {
        return this.mJsonArr.length();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public boolean optBoolean(int i10, boolean z10) {
        Boolean a10 = a.a(get(i10));
        return a10 != null ? a10.booleanValue() : z10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public double optDouble(int i10, double d10) {
        Double b4 = a.b(get(i10));
        return b4 != null ? b4.doubleValue() : d10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public int optInt(int i10, int i11) {
        Integer c4 = a.c(get(i10));
        return c4 != null ? c4.intValue() : i11;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public long optLong(int i10, long j10) {
        Long d10 = a.d(get(i10));
        return d10 != null ? d10.longValue() : j10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public String optString(int i10, String str) {
        String e2 = a.e(get(i10));
        return e2 != null ? e2 : str;
    }

    public JsonArrReaderImpl(@NonNull ListModel listModel) {
        this.f28172a = new HashMap();
        this.mJsonArr = new JSONArray();
        int size = listModel.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mJsonArr.put(listModel.get(i10));
        }
    }
}
