package com.huawei.flexiblelayout.json.impl;

import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.json.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonObjReaderImpl implements FLImmutableMap {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f28176a;

    @NonNull
    public final JSONObject mJsonObj;

    public JsonObjReaderImpl(@NonNull JSONObject jSONObject) {
        this.f28176a = new HashMap();
        this.mJsonObj = jSONObject;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(@NonNull String str) {
        Object obj = this.f28176a.get(str);
        if (obj != null) {
            return obj;
        }
        Object opt = this.mJsonObj.opt(str);
        Object immutableJsonIf = Jsons.toImmutableJsonIf(opt);
        if (immutableJsonIf != opt) {
            this.f28176a.put(str, immutableJsonIf);
        }
        return immutableJsonIf;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    @NonNull
    public String[] keys() {
        JSONArray names = this.mJsonObj.names();
        if (names == null) {
            return new String[0];
        }
        String[] strArr = new String[names.length()];
        for (int i10 = 0; i10 < names.length(); i10++) {
            strArr[i10] = names.optString(i10);
        }
        return strArr;
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
        return optBoolean(str, false);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str) {
        return optDouble(str, ShadowDrawableWrapper.COS_45);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str) {
        return optInt(str, 0);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str) {
        return optLong(str, 0L);
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
        return optString(str, "");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        return this.mJsonObj.length();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str, boolean z10) {
        Boolean a10 = a.a(get(str));
        return a10 != null ? a10.booleanValue() : z10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str, double d10) {
        Double b4 = a.b(get(str));
        return b4 != null ? b4.doubleValue() : d10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str, int i10) {
        Integer c4 = a.c(get(str));
        return c4 != null ? c4.intValue() : i10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str, long j10) {
        Long d10 = a.d(get(str));
        return d10 != null ? d10.longValue() : j10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str, String str2) {
        String e2 = a.e(get(str));
        return e2 != null ? e2 : str2;
    }

    public JsonObjReaderImpl(@NonNull MapModel mapModel) {
        this.f28176a = new HashMap();
        this.mJsonObj = new JSONObject();
        for (String str : mapModel.keys()) {
            try {
                this.mJsonObj.put(str, mapModel.get(str));
            } catch (JSONException unused) {
            }
        }
    }
}
