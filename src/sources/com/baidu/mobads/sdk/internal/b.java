package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f9853a = 0;

    /* renamed from: b, reason: collision with root package name */
    private List<a> f9854b = new ArrayList();

    public static b a(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f9853a = jSONObject.optInt("n", 0);
            int optInt = jSONObject.optInt("enc", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("ad");
            if (optInt == 1) {
                String optString = jSONObject.optString("ad");
                if (!TextUtils.isEmpty(optString)) {
                    String b4 = h.b(optString);
                    if (!TextUtils.isEmpty(b4)) {
                        optJSONArray = new JSONArray(b4);
                    }
                }
            }
            bVar.f9854b = a.a(optJSONArray);
            return bVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return bVar;
        }
    }

    public List<a> a() {
        return this.f9854b;
    }
}
