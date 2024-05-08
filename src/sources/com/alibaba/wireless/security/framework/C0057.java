package com.alibaba.wireless.security.framework;

import com.alibaba.wireless.security.framework.utils.C0050;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.framework.б, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0057 {

    /* renamed from: ж, reason: contains not printable characters */
    private static String f72 = "version";

    /* renamed from: з, reason: contains not printable characters */
    private static String f73 = "lib_dep_version";

    /* renamed from: и, reason: contains not printable characters */
    private static String f74 = "lib_dep_arch";

    /* renamed from: й, reason: contains not printable characters */
    private static String f75 = "target_plugin";

    /* renamed from: к, reason: contains not printable characters */
    private static String f76 = "sg_version";

    /* renamed from: а, reason: contains not printable characters */
    private JSONObject f77;

    /* renamed from: б, reason: contains not printable characters */
    private boolean f78 = true;

    /* renamed from: в, reason: contains not printable characters */
    private int f79 = 0;

    /* renamed from: г, reason: contains not printable characters */
    private boolean f80 = true;

    /* renamed from: д, reason: contains not printable characters */
    private String f81 = "";

    /* renamed from: е, reason: contains not printable characters */
    private boolean f82 = true;

    /* renamed from: ё, reason: contains not printable characters */
    private String f83 = "";

    private C0057(JSONObject jSONObject) {
        this.f77 = jSONObject;
    }

    /* renamed from: а, reason: contains not printable characters */
    public static C0057 m1857(File file) {
        JSONObject jSONObject;
        if (file == null) {
            return null;
        }
        if (file.exists()) {
            try {
                String m1826 = C0050.m1826(file);
                if (m1826 == null || m1826.length() <= 0) {
                    return null;
                }
                jSONObject = new JSONObject(m1826);
                if (!"1.0".equals(jSONObject.getString(f72))) {
                    return null;
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return new C0057(jSONObject);
    }

    /* renamed from: а, reason: contains not printable characters */
    public String m1858(String str) {
        try {
            return m1859().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public JSONObject m1859() {
        return this.f77;
    }

    /* renamed from: б, reason: contains not printable characters */
    public int m1860() {
        int i10;
        if (this.f78) {
            try {
                i10 = Integer.parseInt(m1859().getString(f73));
            } catch (Exception unused) {
                i10 = 0;
            }
            this.f79 = i10;
            this.f78 = false;
        }
        return this.f79;
    }

    /* renamed from: в, reason: contains not printable characters */
    public String m1861() {
        String str;
        if (this.f80) {
            try {
                str = m1859().getString(f74);
            } catch (Exception unused) {
                str = "";
            }
            this.f81 = str;
            this.f80 = false;
        }
        return this.f81;
    }

    /* renamed from: г, reason: contains not printable characters */
    public HashMap<String, String> m1862() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = m1859().getJSONObject(f76);
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* renamed from: д, reason: contains not printable characters */
    public String m1863() {
        String str;
        if (this.f82) {
            try {
                str = m1859().getString(f75);
            } catch (Exception unused) {
                str = "";
            }
            this.f83 = str;
            this.f82 = false;
        }
        return this.f83;
    }
}
