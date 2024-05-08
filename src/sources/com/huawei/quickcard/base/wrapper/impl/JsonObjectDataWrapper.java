package com.huawei.quickcard.base.wrapper.impl;

import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.huawei.quickcard.base.wrapper.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsonObjectDataWrapper implements DataWrapper<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33463a = "JsonObjectDataWrapper";

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull JSONObject jSONObject, @NonNull Object obj) {
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object get(JSONObject jSONObject, int i10) {
        return a.a(this, jSONObject, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull JSONObject jSONObject) {
        return false;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull JSONObject jSONObject) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ void set(JSONObject jSONObject, int i10, Object obj) {
        a.b(this, jSONObject, i10, obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(JSONObject jSONObject, int i10) {
        return a.c(this, jSONObject, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(JSONObject jSONObject, int i10, int i11) {
        return a.d(this, jSONObject, i10, i11);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object splice(String str, int i10, JSONObject jSONObject, int i11, int i12, Object... objArr) {
        return a.e(this, str, i10, jSONObject, i11, i12, objArr);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(JSONObject jSONObject) {
        return a.f(this, jSONObject);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull JSONObject jSONObject, @NonNull String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.opt(str);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        ArrayList arrayList = new ArrayList();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull JSONObject jSONObject, @NonNull String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
            CardLogUtils.e(f33463a, "can not set json object value " + str);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull JSONObject jSONObject) {
        return jSONObject.length();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public String stringify(@NonNull JSONObject jSONObject) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        String[] keys = keys(jSONObject);
        for (int i10 = 0; i10 < keys.length; i10++) {
            try {
                String str = keys[i10];
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
                sb2.append(u.bD);
                a.g(sb2, jSONObject.get(keys[i10]));
                if (i10 < keys.length - 1) {
                    sb2.append(',');
                }
            } catch (Exception e2) {
                CardLogUtils.e(f33463a, "stringify error javascriptobject", e2);
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
