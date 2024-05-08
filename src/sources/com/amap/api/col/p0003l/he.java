package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.realidentity.common.BuildConfig;
import com.amap.api.col.p0003l.fu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKSPUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class he {

    /* renamed from: a, reason: collision with root package name */
    private fu f6246a;

    public he(String str) {
        this.f6246a = null;
        try {
            this.f6246a = new fu.a(str, "1.0", BuildConfig.VERSION_NAME).a(new String[]{"info"}).a();
        } catch (fi unused) {
        }
    }

    public final void a(Context context, fu fuVar) {
        JSONArray jSONArray;
        if (fuVar == null) {
            return;
        }
        ArrayList<fu> arrayList = new ArrayList();
        arrayList.add(fuVar);
        if (arrayList.size() == 0) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = new JSONArray();
            for (fu fuVar2 : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("a", fuVar2.a());
                    jSONObject.put("b", fuVar2.b());
                    jSONObject.put("c", fuVar2.c());
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; fuVar2.f() != null && i10 < fuVar2.f().length; i10++) {
                        jSONArray2.put(fuVar2.f()[i10]);
                    }
                    jSONObject.put("d", jSONArray2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        String jSONArray3 = jSONArray.toString();
        if (TextUtils.isEmpty(jSONArray3)) {
            return;
        }
        hd.a(context, this.f6246a, "rbck", jSONArray3);
    }

    public final List<fu> a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(hd.a(context, this.f6246a, "rbck"));
            if (jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                fu fuVar = null;
                try {
                    fuVar = a(jSONArray.getJSONObject(i10));
                } catch (JSONException unused) {
                }
                if (fuVar != null) {
                    arrayList.add(fuVar);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            return new ArrayList();
        }
    }

    private static fu a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("a");
            String optString2 = jSONObject.optString("b");
            String optString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                arrayList.add(optJSONArray.getString(i10));
            }
            return new fu.a(optString, optString2, optString).a(optString3).a((String[]) arrayList.toArray(new String[0])).a();
        } catch (Throwable unused) {
            return null;
        }
    }
}
