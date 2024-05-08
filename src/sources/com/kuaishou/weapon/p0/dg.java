package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class dg {
    public JSONArray a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                hashSet.add((String) jSONArray.get(i10));
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String str2 = (String) jSONArray.get(i10);
                if (str2.contains("frida")) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String str2 = (String) jSONArray.get(i10);
                if (str2.contains("substrate") || str2.contains(".jar") || str2.contains("xposed")) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null) {
            if (jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
                Set a10 = dl.a(jSONArray);
                Set a11 = dl.a(jSONArray2);
                if (a10 != null && a11 != null) {
                    a10.removeAll(a11);
                    if (a10.size() > 0) {
                        return new JSONArray((Collection) a10);
                    }
                    return null;
                }
            }
        }
        return jSONArray;
    }
}
