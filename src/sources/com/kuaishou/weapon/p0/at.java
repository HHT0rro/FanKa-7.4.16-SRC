package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35804a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35805b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f35806c;

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35937g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f35804a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35804a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f35804a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                hashSet.add(jSONArray.getString(i10));
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator<E> iterator2 = hashSet.iterator2();
            while (iterator2.hasNext()) {
                jSONArray2.put(iterator2.next());
            }
            return jSONArray2;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set c(String str) {
        JSONObject jSONObject = this.f35804a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i10), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f35804a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            int i10 = 0;
            if (TextUtils.equals(str, "46")) {
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                JSONArray jSONArray2 = new JSONArray();
                while (i10 < jSONArray.length()) {
                    jSONArray2.put(jSONArray.getString(i10).replaceAll(" ", "").replace("\n", "").replace(">", ""));
                    i10++;
                }
                return jSONArray2;
            }
            if (!TextUtils.equals(str, "45")) {
                return null;
            }
            String a10 = i.a("aae31bed33c490b6613a", "0701");
            String a11 = i.a("99e111e83fc4d0a7662b", "0701");
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray3 = new JSONArray(string);
            HashSet hashSet = new HashSet();
            while (i10 < jSONArray3.length()) {
                hashSet.add(jSONArray3.getString(i10).replaceAll(" ", "").replace("\n", ""));
                i10++;
            }
            JSONArray jSONArray4 = new JSONArray();
            for (Object obj : hashSet) {
                jSONArray4.put(obj);
                String str2 = (String) obj;
                if (str2.contains(a10)) {
                    this.f35805b = true;
                }
                if (str2.contains(a11)) {
                    this.f35806c = true;
                }
            }
            return jSONArray4;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set a(int i10) {
        HashSet hashSet = new HashSet();
        if (i10 == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i10) {
        JSONObject jSONObject = this.f35804a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set a10 = a(i10);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String replace = jSONArray.getString(i11).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                boolean startsWith = replace.startsWith(com.huawei.openalliance.ad.constant.u.bD);
                String str2 = replace;
                if (startsWith) {
                    str2 = replace.substring(1);
                }
                String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                String packageName = context.getPackageName();
                if (!str2.contains(packageName) && !packageName.contains(str2) && !a10.contains(substring)) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b() {
        return this.f35806c;
    }

    public boolean a() {
        return this.f35805b;
    }
}
