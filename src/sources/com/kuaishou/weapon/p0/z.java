package com.kuaishou.weapon.p0;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class z {

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f36407e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private Set<String> f36408f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private Set<String> f36409g = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    private Set<String> f36410h = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private String f36403a = i.a("f118f1f9431de3a626df48d7302911", "0820");

    /* renamed from: b, reason: collision with root package name */
    private String f36404b = i.a("f118f1ef4616f3fc27d1", "0820");

    /* renamed from: c, reason: collision with root package name */
    private String f36405c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");

    /* renamed from: d, reason: collision with root package name */
    private String f36406d = i.a("fc03e7a44510", "0820");

    /* JADX WARN: Code restructure failed: missing block: B:182:0x01f2, code lost:
    
        if (r1 == null) goto L122;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0122 A[Catch: all -> 0x01e5, Exception -> 0x01e8, TryCatch #8 {Exception -> 0x01e8, all -> 0x01e5, blocks: (B:5:0x000d, B:7:0x0048, B:8:0x005c, B:10:0x0062, B:12:0x006b, B:14:0x0073, B:16:0x007b, B:18:0x0083, B:24:0x0091, B:27:0x0099, B:30:0x00a1, B:33:0x00a9, B:36:0x00b1, B:38:0x00bd, B:40:0x00c5, B:48:0x00cf, B:50:0x00d7, B:52:0x00df, B:54:0x00e7, B:55:0x00ec, B:58:0x00f4, B:61:0x00fc, B:64:0x0104, B:66:0x010a, B:68:0x0112, B:71:0x011a, B:73:0x0122, B:74:0x0128, B:77:0x0130, B:80:0x0138, B:83:0x0140, B:86:0x0148, B:89:0x0150, B:92:0x0158, B:94:0x0160, B:101:0x0169, B:103:0x0171, B:105:0x0179, B:107:0x0181, B:114:0x018a, B:116:0x0192, B:119:0x0198, B:121:0x01a3, B:123:0x01ab, B:125:0x01b3, B:111:0x01bd, B:98:0x01c4, B:44:0x01cb, B:130:0x01d2, B:132:0x01d8), top: B:4:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.z.a(android.content.Context):org.json.JSONArray");
    }

    public Set<String> b() {
        try {
            Set<String> set = this.f36409g;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f36409g;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        try {
            Set<String> set = this.f36410h;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f36410h;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            Set<String> set = this.f36407e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : this.f36407e) {
                if (str.contains(this.f36403a)) {
                    jSONObject.put("0", 1);
                } else if (str.contains(this.f36404b)) {
                    jSONObject.put("1", 1);
                } else if (str.contains(this.f36405c)) {
                    jSONObject.put("2", 1);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set e() {
        try {
            HashSet hashSet = new HashSet();
            Set<String> set = this.f36407e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            for (String str : this.f36407e) {
                if (str.endsWith("dex")) {
                    hashSet.add(str);
                }
                if (hashSet.size() > 5) {
                    break;
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

    public int a() {
        try {
            Set<String> set = this.f36408f;
            if (set == null || set.size() <= 0) {
                return 0;
            }
            return this.f36408f.size();
        } catch (Exception unused) {
            return 0;
        }
    }
}
