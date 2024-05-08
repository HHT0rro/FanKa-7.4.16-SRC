package com.huawei.quickcard.base.wrapper.impl;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.huawei.quickcard.base.wrapper.a;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsonArrayDataWrapper implements DataWrapper<JSONArray> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33462a = "JsonArrayDataWrapper";

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull JSONArray jSONArray) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull JSONArray jSONArray) {
        return false;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(JSONArray jSONArray, int i10) {
        return a.c(this, jSONArray, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(JSONArray jSONArray) {
        return a.f(this, jSONArray);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull JSONArray jSONArray, @NonNull Object obj) {
        jSONArray.put(obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull JSONArray jSONArray) {
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = String.valueOf(i10);
        }
        return strArr;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull JSONArray jSONArray) {
        return jSONArray.length();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object slice(@NonNull JSONArray jSONArray, int i10, int i11) {
        int length = jSONArray.length();
        JSONArray jSONArray2 = new JSONArray();
        if (i10 < 0) {
            i10 += length;
        }
        int max = Math.max(i10, 0);
        if (max >= length) {
            return jSONArray2;
        }
        if (i11 < 0) {
            i11 += length;
        }
        if (i11 <= max) {
            return jSONArray2;
        }
        int min = Math.min(i11, length);
        while (max < min) {
            try {
                jSONArray2.put(jSONArray.opt(max));
            } catch (Exception unused) {
                CardLogUtils.e(f33462a, "slice err");
            }
            max++;
        }
        return jSONArray2;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object splice(String str, int i10, @NonNull JSONArray jSONArray, int i11, int i12, Object... objArr) {
        int i13;
        int length = jSONArray.length();
        int max = Math.max(Math.min(i11 < 0 ? length + i11 : i11, length), 0);
        int max2 = Math.max(Math.min(length - max, i12), 0);
        JSONArray jSONArray2 = new JSONArray();
        for (int i14 = max; i14 < max + max2; i14++) {
            try {
                jSONArray2.put(jSONArray.get(i14));
            } catch (JSONException unused) {
                CardLogUtils.e(f33462a, "splice error in json arr");
            }
        }
        int length2 = objArr.length - max2;
        int i15 = length + length2;
        int i16 = i15 - 1;
        while (i16 >= max) {
            try {
                if (i16 < objArr.length + max) {
                    Object obj = get(jSONArray, i16);
                    int i17 = i16 - max;
                    i13 = max;
                    jSONArray.put(i16, objArr[i17]);
                    if (str != null) {
                        Utils.notifyDataSet(i10, str + "[" + i16 + "]", obj, objArr[i17]);
                    }
                } else {
                    i13 = max;
                    if (length2 != 0) {
                        Object obj2 = get(jSONArray, i16);
                        jSONArray.put(i16, get(jSONArray, i16 - length2));
                        if (str != null) {
                            Utils.notifyDataSet(i10, str + "[" + i16 + "]", obj2, get(jSONArray, i16));
                        }
                    }
                }
                i16--;
                max = i13;
            } catch (Exception unused2) {
                CardLogUtils.e(f33462a, "splice error in json arr");
            }
        }
        for (int i18 = length - 1; i18 >= i15; i18--) {
            Object obj3 = get(jSONArray, i18);
            jSONArray.remove(i18);
            if (str != null) {
                Utils.notifyDataSet(i10, str + "[" + i18 + "]", obj3, null);
            }
        }
        return jSONArray2;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public String stringify(@NonNull JSONArray jSONArray) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                a.g(sb2, jSONArray.get(i10));
                if (i10 < jSONArray.length() - 1) {
                    sb2.append(',');
                }
            } catch (JSONException e2) {
                CardLogUtils.e(f33462a, "stringify error", e2);
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull JSONArray jSONArray, String str) {
        if (!Utils.isIntNum(str)) {
            return null;
        }
        int parseInt = Integer.parseInt(str);
        if (jSONArray.isNull(parseInt)) {
            return null;
        }
        return jSONArray.opt(parseInt);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull JSONArray jSONArray, String str, Object obj) {
        if (Utils.isIntNum(str)) {
            set(jSONArray, Integer.parseInt(str), obj);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull JSONArray jSONArray, int i10) {
        if (jSONArray.isNull(i10)) {
            return null;
        }
        return jSONArray.opt(i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull JSONArray jSONArray, int i10, Object obj) {
        try {
            jSONArray.put(i10, obj);
        } catch (JSONException unused) {
            CardLogUtils.e(f33462a, "can not set json array value " + i10);
        }
    }
}
