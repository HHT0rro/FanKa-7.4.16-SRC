package com.huawei.quickcard;

import android.content.Context;
import android.graphics.Shader;
import android.text.TextUtils;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34249a = "LinerGradientParser";

    /* renamed from: b, reason: collision with root package name */
    private static final String f34250b = "type";

    /* renamed from: c, reason: collision with root package name */
    private static final String f34251c = "color";

    /* renamed from: d, reason: collision with root package name */
    private static final String f34252d = "position";

    /* renamed from: e, reason: collision with root package name */
    private static final String f34253e = "directions";

    /* renamed from: f, reason: collision with root package name */
    private static final String f34254f = "values";

    /* renamed from: g, reason: collision with root package name */
    private static final String f34255g = "linearGradient";

    /* renamed from: h, reason: collision with root package name */
    private static final String f34256h = "repeatingLinearGradient";

    /* renamed from: i, reason: collision with root package name */
    private static final String f34257i = "tobottom";

    /* renamed from: j, reason: collision with root package name */
    private static final String f34258j = "null";

    public static t0 a(Context context, String str) {
        JSONObject a10 = a(str);
        if (a10 == null) {
            CardLogUtils.e(f34249a, "parse background json fail");
            return null;
        }
        return new t0(context, b(a10), a(a10), c(a10));
    }

    private static String b(JSONObject jSONObject) {
        try {
            return jSONObject.getString(f34253e);
        } catch (JSONException unused) {
            CardLogUtils.e(f34249a, "get direction error,return default direction!");
            return f34257i;
        }
    }

    private static Shader.TileMode c(JSONObject jSONObject) {
        String str;
        try {
            str = jSONObject.getString("type");
        } catch (JSONException unused) {
            CardLogUtils.e(f34249a, "get type error,return default type!");
            str = f34255g;
        }
        if (f34256h.equals(str)) {
            return Shader.TileMode.REPEAT;
        }
        return Shader.TileMode.CLAMP;
    }

    private static List<t> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        int length;
        LinkedList linkedList = new LinkedList();
        try {
            jSONArray = jSONObject.getJSONArray(f34254f);
            length = jSONArray.length();
        } catch (JSONException unused) {
            CardLogUtils.e(f34249a, "get color stop error, will not show background");
        }
        if (length < 2) {
            return null;
        }
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            t tVar = new t();
            tVar.a(jSONObject2.getString("color"));
            String string = jSONObject2.getString("position");
            if ("null".equals(string)) {
                string = null;
            }
            tVar.b(string);
            linkedList.add(tVar);
        }
        return linkedList;
    }

    private static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(f34254f);
            JSONObject jSONObject = new JSONObject();
            if (jSONArray.length() > 0) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                jSONObject.put("type", jSONObject2.getString("type"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray(f34253e);
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                    sb2.append(jSONArray2.get(i10));
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    sb2.append(f34257i);
                }
                jSONObject.put(f34253e, sb2.toString());
                JSONArray jSONArray3 = jSONObject2.getJSONArray(f34254f);
                JSONArray jSONArray4 = new JSONArray();
                if (jSONArray3.length() <= 1) {
                    return null;
                }
                for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                    JSONObject jSONObject3 = new JSONObject();
                    String[] split = jSONArray3.getString(i11).split("\\s+");
                    jSONObject3.put("color", split[0]);
                    jSONObject3.put("position", split.length > 1 ? split[1] : "null");
                    jSONArray4.put(jSONObject3);
                }
                jSONObject.put(f34254f, jSONArray4);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
