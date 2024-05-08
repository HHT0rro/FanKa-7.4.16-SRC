package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import com.kuaishou.weapon.p0.dp;
import com.kuaishou.weapon.p0.w;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class A {
    private static int flag;
    private static JSONArray jsonObject;

    public A(Context context, int i10) {
        flag = i10;
        if (Engine.loadSuccess) {
            Engine.getInstance(context).qrs();
        } else {
            setA(context);
        }
    }

    public static String getE(String str) {
        try {
            dp a10 = dp.a();
            if (a10 != null) {
                return a10.a(str, "");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray getJsonObject() {
        return jsonObject;
    }

    public static void setA(Context context) {
        if (context != null) {
            jsonObject = new w(context).b(flag);
        }
    }

    public static void setE(String str, String str2) {
        try {
            dp a10 = dp.a();
            if (a10 != null) {
                a10.b(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void setJsonObject(JSONArray jSONArray) {
        jsonObject = jSONArray;
    }
}
