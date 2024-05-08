package com.huawei.flexiblelayout.json.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.json.a;
import com.huawei.flexiblelayout.log.Log;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonArrImpl extends JsonArrReaderImpl implements FLArray {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28171b = "JsonArrImpl";

    public JsonArrImpl(@NonNull JSONArray jSONArray) {
        super(jSONArray);
    }

    @Override // com.huawei.flexiblelayout.json.impl.JsonArrReaderImpl, com.huawei.flexiblelayout.data.primitive.ListModel
    public Object get(int i10) {
        Object opt = this.mJsonArr.opt(i10);
        Object jsonIf = Jsons.toJsonIf(opt);
        if (jsonIf != opt) {
            try {
                this.mJsonArr.put(i10, jsonIf);
            } catch (JSONException unused) {
            }
        }
        return jsonIf;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLArray
    public Object remove(int i10) {
        return this.mJsonArr.remove(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLArray
    public void set(int i10, Object obj) {
        if (i10 >= this.mJsonArr.length()) {
            Log.e(f28171b, "index must be less than length of array.");
            return;
        }
        try {
            this.mJsonArr.put(i10, obj);
        } catch (JSONException unused) {
            Log.e(f28171b, "value must not be 'Double.isInfinite(value) || Double.isNaN(value)'.");
        }
    }

    public JsonArrImpl(@NonNull ListModel listModel) {
        super(listModel);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLArray
    @NonNull
    public JsonArrImpl add(Object obj) {
        if ((obj instanceof Number) && a.a(((Number) obj).doubleValue())) {
            Log.e(f28171b, "value must not be 'Double.isInfinite(value) || Double.isNaN(value)'.");
            return this;
        }
        this.mJsonArr.put(obj);
        return this;
    }

    @Override // com.huawei.flexiblelayout.json.impl.JsonArrReaderImpl, com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public FLArray optArray(int i10) {
        Object obj = get(i10);
        if (obj instanceof FLArray) {
            return (FLArray) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.json.impl.JsonArrReaderImpl, com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public FLMap optMap(int i10) {
        Object obj = get(i10);
        if (obj instanceof FLMap) {
            return (FLMap) obj;
        }
        return null;
    }
}
