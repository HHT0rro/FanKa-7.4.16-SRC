package com.ishumei.smantifraud.l1111l111111Il;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.huawei.quickcard.base.Attributes;
import com.ishumei.smantifraud.l1111l111111Il.l111l11111Il;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l1111l1Il implements l11l1111lIIl.l1111l111111Il, l11l1111lIIl.l111l11111lIl {
    private static final String l1111l111111Il = "zaq1mko0";
    private static l111l1111l1Il l111l11111I1l = null;
    private static final String l111l11111lIl = "{\n            \"ver\": 1,\n            \"code\": 0,\n            \"data\": \"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\",\n            \"length\": 11365,\n            \"enc\": 1\n        }";
    private l111l11111Il l111l11111Il;

    private l111l1111l1Il() {
    }

    private static l111l11111Il l1111l111111Il(String str) {
        l111l11111Il l111l11111il = new l111l11111Il();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (jSONObject.has("usrappcnt")) {
                    l111l11111il.l111l1111lI1l(jSONObject.getInt("usrappcnt"));
                }
                if (jSONObject.has("sysappcnt")) {
                    l111l11111il.l111l1111lIl(jSONObject.getInt("sysappcnt"));
                }
            } catch (Exception unused) {
            }
            try {
                if (jSONObject.has("risk_dirs")) {
                    l111l11111il.l111l11111lIl(l1111l111111Il(jSONObject.getJSONArray("risk_dirs")));
                }
            } catch (Exception unused2) {
            }
            try {
                if (jSONObject.has("white_apps")) {
                    l111l11111il.l1111l111111Il(l111l11111lIl(jSONObject.getJSONArray("white_apps")));
                }
            } catch (Exception unused3) {
            }
            try {
                l111l11111il.l1111l111111Il(l111l11111I1l(jSONObject));
            } catch (Exception unused4) {
            }
            try {
                if (jSONObject.has("core_atamper")) {
                    l111l11111il.l1111l111111Il(jSONObject.getBoolean("core_atamper"));
                }
            } catch (Exception unused5) {
            }
            try {
                if (jSONObject.has("all_atamper")) {
                    l111l11111il.l111l11111lIl(jSONObject.getBoolean("all_atamper"));
                }
            } catch (Exception unused6) {
            }
            try {
                if (jSONObject.has("risk_file_switch")) {
                    l111l11111il.l111l11111I1l(jSONObject.getBoolean("risk_file_switch"));
                }
            } catch (Exception unused7) {
            }
            try {
                if (jSONObject.has("upload_checker_switch")) {
                    l111l11111il.l111l11111Il(jSONObject.getBoolean("upload_checker_switch"));
                }
            } catch (Exception unused8) {
            }
            try {
                if (jSONObject.has("hook_switch")) {
                    l111l11111il.l111l1111l1Il(jSONObject.getBoolean("hook_switch"));
                }
            } catch (Exception unused9) {
            }
            try {
                if (jSONObject.has("hook_java_switch")) {
                    l111l11111il.l111l1111llIl(jSONObject.getBoolean("hook_java_switch"));
                }
            } catch (Exception unused10) {
            }
            try {
                if (jSONObject.has("net_max")) {
                    l111l11111il.l1111l111111Il(jSONObject.getInt("net_max"));
                }
            } catch (Exception unused11) {
            }
            try {
                if (jSONObject.has("re_max")) {
                    l111l11111il.l111l11111lIl(jSONObject.getInt("re_max"));
                }
            } catch (Exception unused12) {
            }
            try {
                if (jSONObject.has("up_max")) {
                    l111l11111il.l111l1111llIl(jSONObject.getInt("up_max"));
                }
            } catch (Exception unused13) {
            }
            try {
                l111l11111il.l111l11111I1l(jSONObject.optInt("weventt", 60));
                l111l11111il.l111l11111Il(jSONObject.optInt("weventc", 100));
                l111l11111il.l111l1111l1Il(jSONObject.optInt("weventmax", 10));
            } catch (Exception unused14) {
            }
            l111l11111il.l111l11111I1l(str);
            l111l11111il.l1111l111111Il(com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l1111l1Il(str));
            return l111l11111il;
        } catch (Exception unused15) {
            return null;
        }
    }

    public static synchronized l111l1111l1Il l1111l111111Il() {
        l111l1111l1Il l111l1111l1il;
        synchronized (l111l1111l1Il.class) {
            if (l111l11111I1l == null) {
                l111l11111I1l = new l111l1111l1Il();
            }
            l111l1111l1il = l111l11111I1l;
        }
        return l111l1111l1il;
    }

    private static Map<String, l111l11111Il.l1111l111111Il> l1111l111111Il(JSONArray jSONArray) {
        l111l11111Il.l1111l111111Il l1111l111111il;
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                l1111l111111il = new l111l11111Il.l1111l111111Il();
                String next = jSONObject2.keys().next();
                jSONObject = jSONObject2.getJSONObject(next);
                l1111l111111il.l1111l111111Il(next);
            } catch (JSONException unused) {
            }
            if (TextUtils.equals("sdcard", jSONObject.getString("type"))) {
                l1111l111111il.l1111l111111Il(0);
            } else if (TextUtils.equals("absolute", jSONObject.getString("type"))) {
                l1111l111111il.l1111l111111Il(1);
            }
            l1111l111111il.l111l11111lIl(jSONObject.getString(Attributes.Style.DIR));
            hashMap.put(l1111l111111il.l1111l111111Il(), l1111l111111il);
        }
        return hashMap;
    }

    private static Map<String, l111l11111Il.l1111l111111Il> l1111l111111Il(JSONObject jSONObject) {
        l111l11111Il.l1111l111111Il l1111l111111il;
        JSONObject jSONObject2;
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                l1111l111111il = new l111l11111Il.l1111l111111Il();
                String next = keys.next();
                jSONObject2 = jSONObject.getJSONObject(next);
                l1111l111111il.l1111l111111Il(next);
            } catch (Exception unused) {
            }
            if (TextUtils.equals("sdcard", jSONObject2.getString("type"))) {
                l1111l111111il.l1111l111111Il(0);
            } else if (TextUtils.equals("absolute", jSONObject2.getString("type"))) {
                l1111l111111il.l1111l111111Il(1);
            }
            l1111l111111il.l111l11111lIl(jSONObject2.getString(Attributes.Style.DIR));
            hashMap.put(l1111l111111il.l1111l111111Il(), l1111l111111il);
        }
        return hashMap;
    }

    private l111l11111Il l111l11111I1l() {
        l111l11111Il l111l11111I1l2 = l111l11111I1l(l111l11111lIl);
        if (l111l11111I1l2 != null) {
            l111l11111I1l2.l111l11111lIl("code");
        }
        return l111l11111I1l2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static l111l11111Il l111l11111I1l(String str) {
        String l1111l111111Il2;
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt(DatabaseSourceInfoStorage.COLUMN_LENGTH);
            int i11 = jSONObject.has("enc") ? jSONObject.getInt("enc") : 0;
            int i12 = jSONObject.has("ver") ? jSONObject.getInt("ver") : 0;
            byte[] l111l1111llIl = com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l1111llIl(jSONObject.getString("data"));
            if (i11 == 1) {
                byte[] l1111l111111Il3 = com.ishumei.smantifraud.l111l1111llIl.l111l1111lI1l.l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l11111lIl.l111l11111lIl(l1111l111111Il, l111l1111llIl, i10));
                l1111l111111Il2 = new String(l1111l111111Il3, 0, l1111l111111Il3.length, "utf-8");
            } else {
                l1111l111111Il2 = com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l11111lIl.l1111l111111Il(l1111l111111Il, l111l1111llIl, i10);
            }
            return i12 == 1 ? l1111l111111Il(l1111l111111Il2) : l111l11111lIl(l1111l111111Il2);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Set<String> l111l11111I1l(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (next.startsWith("sensitive.") && jSONObject.getBoolean(next)) {
                    hashSet.add(next.split("\\.")[1]);
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    private l111l11111Il l111l11111Il() {
        l111l11111Il l111l11111I1l2 = l111l11111I1l(com.ishumei.smantifraud.l111l11111lIl.l111l11111lIl.l1111l111111Il(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il()));
        if (l111l11111I1l2 != null) {
            l111l11111I1l2.l111l11111lIl("local");
        }
        return l111l11111I1l2;
    }

    private static Set<String> l111l11111Il(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (jSONObject.getBoolean(next)) {
                    hashSet.add(next);
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    private static l111l11111Il l111l11111lIl(String str) {
        l111l11111Il l111l11111il = new l111l11111Il();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (jSONObject.has("risk_dirs")) {
                    l111l11111il.l111l11111lIl(l1111l111111Il(jSONObject.getJSONObject("risk_dirs")));
                }
            } catch (Exception unused) {
            }
            try {
                if (jSONObject.has("white_apps")) {
                    l111l11111il.l1111l111111Il(l111l11111lIl(jSONObject.getJSONObject("white_apps")));
                }
            } catch (Exception unused2) {
            }
            try {
                if (jSONObject.has("sensitive")) {
                    l111l11111il.l1111l111111Il(l111l11111Il(jSONObject.getJSONObject("sensitive")));
                }
            } catch (Exception unused3) {
            }
            try {
                if (jSONObject.has("core_atamper")) {
                    l111l11111il.l1111l111111Il(jSONObject.getBoolean("core_atamper"));
                }
            } catch (Exception unused4) {
            }
            try {
                if (jSONObject.has("all_atamper")) {
                    l111l11111il.l111l11111lIl(jSONObject.getBoolean("all_atamper"));
                }
            } catch (Exception unused5) {
            }
            try {
                if (jSONObject.has("risk_file_switch")) {
                    l111l11111il.l111l11111I1l(jSONObject.getBoolean("risk_file_switch"));
                }
            } catch (Exception unused6) {
            }
            try {
                if (jSONObject.has("upload_checker_switch")) {
                    l111l11111il.l111l11111Il(jSONObject.getBoolean("upload_checker_switch"));
                }
            } catch (Exception unused7) {
            }
            l111l11111il.l111l11111I1l(str);
            l111l11111il.l1111l111111Il(com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l1111l1Il(str));
            return l111l11111il;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    private static Map<String, l111l11111Il.l111l11111lIl> l111l11111lIl(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                l111l11111Il.l111l11111lIl l111l11111lil = new l111l11111Il.l111l11111lIl();
                String next = jSONObject.keys().next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                l111l11111lil.l1111l111111Il(next);
                l111l11111lil.l111l11111lIl(jSONObject2.getString("pn"));
                hashMap.put(l111l11111lil.l1111l111111Il(), l111l11111lil);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    private static Map<String, l111l11111Il.l111l11111lIl> l111l11111lIl(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                l111l11111Il.l111l11111lIl l111l11111lil = new l111l11111Il.l111l11111lIl();
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                l111l11111lil.l1111l111111Il(next);
                l111l11111lil.l111l11111lIl(jSONObject2.getString("pn"));
                hashMap.put(l111l11111lil.l1111l111111Il(), l111l11111lil);
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l111l11111lIl
    public void l1111l111111Il(com.ishumei.smantifraud.l111l11111Il.l111l11111lIl l111l11111lil) {
        if (l111l11111lil.l1111l111111Il() == null) {
            return;
        }
        String jSONObject = l111l11111lil.l1111l111111Il().toString();
        this.l111l11111Il = l111l11111I1l(jSONObject);
        SharedPreferences.Editor edit = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il().getSharedPreferences("cloudms.conf", 0).edit();
        edit.putString("conf", jSONObject);
        edit.apply();
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l1111l111111Il
    public void l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll l11l1111i1ll) {
    }

    public final void l1111l111111Il(String str, String str2, final String str3) {
        com.ishumei.smantifraud.l111l11111Il.l1111l111111Il l1111l111111il = new com.ishumei.smantifraud.l111l11111Il.l1111l111111Il(str, str2, this, this) { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l1111l1Il.1
            @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111llIl, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
            public final byte[] l1111l111111Il() {
                try {
                    l111l11111Il l111l11111lIl2 = l111l1111l1Il.this.l111l11111lIl();
                    String l1111l111111Il2 = l111l11111lIl2 == null ? "" : l111l11111lIl2.l1111l111111Il();
                    String str4 = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l11111lIl;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("organization", str3);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("os", "android");
                    jSONObject2.put("sdkver", "3.7.3");
                    jSONObject2.put("md5", l1111l111111Il2);
                    jSONObject2.put("enc", 1);
                    jSONObject2.put("bb", com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l11111Il());
                    jSONObject2.put("sid", str4);
                    jSONObject.put("data", jSONObject2);
                    return jSONObject.toString().getBytes("utf-8");
                } catch (Exception unused) {
                    return null;
                }
            }
        };
        l1111l111111il.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l) new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il(30000, 0, 0.0f));
        com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l1111l111111Il(l1111l111111il);
    }

    public final l111l11111Il l111l11111lIl() {
        l111l11111Il l111l11111il = this.l111l11111Il;
        if (l111l11111il != null) {
            return l111l11111il;
        }
        l111l11111Il l111l11111I1l2 = l111l11111I1l(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il().getSharedPreferences("cloudms.conf", 0).getString("conf", null));
        if (l111l11111I1l2 != null) {
            l111l11111I1l2.l111l11111lIl("local");
        }
        this.l111l11111Il = l111l11111I1l2;
        if (l111l11111I1l2 != null) {
            return l111l11111I1l2;
        }
        l111l11111Il l111l11111I1l3 = l111l11111I1l(l111l11111lIl);
        if (l111l11111I1l3 != null) {
            l111l11111I1l3.l111l11111lIl("code");
        }
        this.l111l11111Il = l111l11111I1l3;
        return l111l11111I1l3;
    }
}
