package com.huawei.flexiblelayout.json.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonObjImpl extends JsonObjReaderImpl implements FLMap {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28175b = "JsonObjImpl";

    public JsonObjImpl(@NonNull JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.huawei.flexiblelayout.json.impl.JsonObjReaderImpl, com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(@NonNull String str) {
        Object opt = this.mJsonObj.opt(str);
        Object jsonIf = Jsons.toJsonIf(opt);
        if (jsonIf != opt) {
            try {
                this.mJsonObj.put(str, jsonIf);
            } catch (JSONException unused) {
            }
        }
        return jsonIf;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    @NonNull
    public FLMap put(@NonNull String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        if (obj == null) {
            this.mJsonObj.remove(str);
            return this;
        }
        try {
            this.mJsonObj.put(str, obj);
        } catch (JSONException unused) {
            Log.e(f28175b, "value must not be 'Double.isInfinite(value) || Double.isNaN(value)'.");
        }
        return this;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    public Object remove(@NonNull String str) {
        return this.mJsonObj.remove(str);
    }

    public JsonObjImpl(@NonNull MapModel mapModel) {
        super(mapModel);
    }

    @Override // com.huawei.flexiblelayout.json.impl.JsonObjReaderImpl, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLArray optArray(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof FLArray) {
            return (FLArray) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.json.impl.JsonObjReaderImpl, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLMap optMap(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof FLMap) {
            return (FLMap) obj;
        }
        return null;
    }
}
