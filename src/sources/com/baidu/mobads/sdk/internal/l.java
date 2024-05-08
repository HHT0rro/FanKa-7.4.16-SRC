package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private int f10272a;

    /* renamed from: b, reason: collision with root package name */
    private String f10273b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    l a10 = a(jSONArray.getJSONObject(i10));
                    if (a10 != null) {
                        arrayList.add(new CpuChannelResponse(a10));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.f10273b;
    }

    private static l a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        l lVar = new l();
        lVar.f10272a = optInt;
        lVar.f10273b = optString;
        return lVar;
    }

    public int a() {
        return this.f10272a;
    }
}
