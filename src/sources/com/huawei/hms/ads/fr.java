package com.huawei.hms.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.ad.utils.aa;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fr {
    private static final String A = "swipeDesc";
    private static final String B = "location_collected_switch";
    private static final String C = "splash_show_time";
    private static final String Code = "SpHandler";
    private static final String D = "slogan_show_time";
    private static final String E = "swipeDp";
    private static final String F = "splash_skip_area";
    private static final String G = "twistDesc";
    private static final String H = "twistDegree";
    private static final String I = "location_expire_time";
    private static final String J = "twistAcc";
    private static final String K = "proHeight";
    private static final String L = "cache_slogan_show_time_def";
    private static final String M = "proBotMargin";
    private static final String N = "proTextSize";
    private static final String O = "proRadius";
    private static final String P = "preRequest";
    private static final String Q = "clctCtxIntvl";
    private static final String R = "clctCtxMap";
    private static final String S = "splash_show_mode";
    private static final int T = 60;
    private static final String U = "clctCtxSize";
    private static final String V = "HiAdSharedPreferences";
    private static final int W = 200;
    private static final String X = "clctCtx";
    private static final String Y = "ads_core_selection";
    private static final String Z = "location_refresh_interval_time";

    /* renamed from: a, reason: collision with root package name */
    private static final String f29228a = "smart_screen_slogan_time";
    private static final String aA = "oaid_report_on_npa";
    private static final String aB = "shield_other_splash_fashion";
    private static final String aC = "splashInteractCloseEffectiveTime";
    private static final int aD = 85;
    private static final int aE = 119;
    private static final String aF = "notification_app_list";
    private static final String aG = "singleInstanceLSModelList";
    private static final String aH = "sha256";

    /* renamed from: aa, reason: collision with root package name */
    private static final String f29229aa = "test_country_code";

    /* renamed from: ab, reason: collision with root package name */
    private static final String f29230ab = "exsplash_slogan_start_time";

    /* renamed from: ac, reason: collision with root package name */
    private static final String f29231ac = "exsplash_slogan_show_time";

    /* renamed from: ad, reason: collision with root package name */
    private static final String f29232ad = "linked_content_id";

    /* renamed from: ae, reason: collision with root package name */
    private static final String f29233ae = "exsplash_redundancy_time";
    private static final String af = "third_country_code";
    private static final String ag = "default_splash_mode";
    private static final String ah = "full_screen_notify";
    private static final String ai = "activate_notify_style";
    private static final String aj = "allow_ad_skip_time";
    private static final int ak = 0;
    private static final String al = "auto_open_forbidden";
    private static final String am = "has_restore_config";
    private static final String an = "ipcFlag";
    private static final int ao = 30;
    private static final String ap = "config_map";
    private static final String aq = "remindAgain";
    private static fr at = null;
    private static final byte[] av = new byte[0];
    private static final String az = "trust_app_list";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29234b = "clct_ctx_time";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29235c = "slogan_real_min_show_time";

    /* renamed from: d, reason: collision with root package name */
    private static final String f29236d = "splash_app_day_impfc";

    /* renamed from: e, reason: collision with root package name */
    private static final String f29237e = "today_show_times";

    /* renamed from: f, reason: collision with root package name */
    private static final String f29238f = "today_date";

    /* renamed from: g, reason: collision with root package name */
    private static final String f29239g = "config_refresh_interval";

    /* renamed from: h, reason: collision with root package name */
    private static final String f29240h = "config_refresh_last_time";

    /* renamed from: i, reason: collision with root package name */
    private static final String f29241i = "enable_user_info";

    /* renamed from: j, reason: collision with root package name */
    private static final String f29242j = "enable_share_pd";

    /* renamed from: k, reason: collision with root package name */
    private static final String f29243k = "no_show_ad_time";

    /* renamed from: l, reason: collision with root package name */
    private static final String f29244l = "img_size_upper_limit";

    /* renamed from: m, reason: collision with root package name */
    private static final String f29245m = "global_switch";

    /* renamed from: n, reason: collision with root package name */
    private static final String f29246n = "def_broswer_pkg_list";

    /* renamed from: o, reason: collision with root package name */
    private static final String f29247o = "ad_preload_interval";

    /* renamed from: p, reason: collision with root package name */
    private static final String f29248p = "preload_splash_req_time_interval";

    /* renamed from: q, reason: collision with root package name */
    private static final String f29249q = "min_banner_interval";

    /* renamed from: r, reason: collision with root package name */
    private static final String f29250r = "max_banner_interval";

    /* renamed from: s, reason: collision with root package name */
    private static final String f29251s = "default_banner_interval";

    /* renamed from: t, reason: collision with root package name */
    private static final String f29252t = "country_code";

    /* renamed from: u, reason: collision with root package name */
    private static final String f29253u = "gif_time_lower_limit_frame";

    /* renamed from: v, reason: collision with root package name */
    private static final String f29254v = "limit_of_container_aspect_ratio";

    /* renamed from: w, reason: collision with root package name */
    private static final String f29255w = "testDeviceConfigRefreshInterval";

    /* renamed from: x, reason: collision with root package name */
    private static final String f29256x = "splashInteractCfg";

    /* renamed from: y, reason: collision with root package name */
    private static final String f29257y = "clickDesc";

    /* renamed from: z, reason: collision with root package name */
    private static final String f29258z = "clickExtraArea";

    /* renamed from: ar, reason: collision with root package name */
    private final SharedPreferences f29259ar;
    private SharedPreferences as;
    private Map<String, String> au;
    private final byte[] aw = new byte[0];
    private String ax;
    private Context ay;

    private fr(Context context) {
        this.au = new HashMap();
        Context L2 = com.huawei.openalliance.ad.utils.l.L(context.getApplicationContext());
        this.ay = L2;
        this.f29259ar = L2.getSharedPreferences(V, 0);
        try {
            this.as = context.getSharedPreferences(V, 0);
        } catch (Throwable unused) {
            this.as = null;
            gl.I(Code, "create sp error.");
        }
        am();
        this.ax = new com.huawei.openalliance.ad.utils.j(this.ay).Code();
        this.au = (Map) com.huawei.openalliance.ad.utils.z.V(ao(), Map.class, new Class[0]);
    }

    private void B(boolean z10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putBoolean(am, z10).commit();
        }
    }

    public static fr Code(Context context) {
        return I(context);
    }

    private void Code(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("trustAppList", jSONObject);
            Code(editor, az, jSONObject2.toString());
        } catch (JSONException unused) {
            gl.Z(Code, "putTrustAppList JSONException");
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num, int i10) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        } else {
            editor.putInt(str, i10);
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Long l10) {
        if (l10 != null) {
            editor.putLong(str, l10.longValue());
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, String str2) {
        if (str2 != null) {
            editor.putString(str, str2);
        }
    }

    private void Code(Map.Entry<String, ?> entry, SharedPreferences.Editor editor) {
        if (entry == null || editor == null) {
            return;
        }
        Object value = entry.getValue();
        String key = entry.getKey();
        if (value instanceof Integer) {
            editor.putInt(key, ((Integer) value).intValue());
            return;
        }
        if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Long) {
            editor.putLong(key, ((Long) value).longValue());
            return;
        }
        if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, new HashSet((Set) value));
        }
    }

    private static fr I(Context context) {
        fr frVar;
        synchronized (av) {
            if (at == null) {
                at = new fr(context);
            }
            frVar = at;
        }
        return frVar;
    }

    private void V(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            editor.putString(ap, jSONObject.toString());
            this.au = (Map) com.huawei.openalliance.ad.utils.z.V(jSONObject.toString(), Map.class, new Class[0]);
        } catch (JSONException unused) {
            gl.Z(Code, "putConfigMap JSONException");
        }
    }

    private void am() {
        if (an()) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = this.as;
            if (sharedPreferences == null) {
                if (gl.Code()) {
                    gl.Code(Code, "there is no old config file");
                    return;
                }
                return;
            }
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null && !all.isEmpty()) {
                Set<Map.Entry<String, ?>> entrySet = all.entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    SharedPreferences.Editor edit = this.f29259ar.edit();
                    Iterator<Map.Entry<String, ?>> iterator2 = entrySet.iterator2();
                    while (iterator2.hasNext()) {
                        Code(iterator2.next(), edit);
                    }
                    edit.commit();
                }
                B(true);
                return;
            }
            if (gl.Code()) {
                gl.Code(Code, "there is no old config file");
            }
        } catch (Throwable th) {
            gl.I(Code, "restore config error:" + th.getClass().getSimpleName());
        }
    }

    private boolean an() {
        boolean z10;
        synchronized (this.aw) {
            z10 = this.f29259ar.getBoolean(am, false);
        }
        return z10;
    }

    private String ao() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(ap, "");
        }
        return string;
    }

    private String ap() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(f29245m, "");
        }
        return string;
    }

    private int aq() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(ag, 2);
        }
        return i10;
    }

    public int A() {
        int intValue;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(E)) : null;
            intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 100;
        }
        return intValue;
    }

    public void B(int i10) {
        synchronized (this.aw) {
            if (i10 > 0) {
                this.f29259ar.edit().putInt(f29233ae, i10).commit();
            }
        }
    }

    public void B(String str) {
        synchronized (this.aw) {
            this.f29259ar.edit().putString(aB, str).commit();
        }
    }

    public boolean B() {
        synchronized (this.aw) {
            return Integer.valueOf(this.f29259ar.getInt(B, 0)).intValue() == 1;
        }
    }

    public long C() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getLong(I, 1800000L);
        }
        return j10;
    }

    public void C(int i10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putInt("splash_skip_area", i10).commit();
        }
    }

    public void C(String str) {
        synchronized (this.aw) {
            this.f29259ar.edit().putString("sha256", str).commit();
        }
    }

    public String Code() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(az, "");
        }
        return string;
    }

    public void Code(int i10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putInt(L, i10).commit();
        }
    }

    public void Code(long j10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putLong(f29240h, j10).commit();
        }
    }

    public void Code(AppConfigRsp appConfigRsp) {
        synchronized (this.aw) {
            SharedPreferences.Editor edit = this.f29259ar.edit();
            edit.putLong(I, appConfigRsp.e().longValue());
            edit.putLong(Z, appConfigRsp.g().longValue());
            edit.putInt(B, appConfigRsp.f());
            edit.putInt(C, appConfigRsp.C());
            Code(edit, S, appConfigRsp.S());
            edit.putInt("splash_skip_area", appConfigRsp.F());
            if (com.huawei.openalliance.ad.utils.l.V(this.ay)) {
                Code(edit, D, appConfigRsp.B());
            } else {
                Code(edit, D, appConfigRsp.B(), 2000);
            }
            edit.putLong(f29235c, appConfigRsp.Z());
            edit.putInt(f29236d, appConfigRsp.I());
            Code(edit, f29239g, appConfigRsp.D());
            edit.putLong(f29240h, System.currentTimeMillis());
            edit.putString(f29245m, appConfigRsp.L());
            edit.putLong(f29248p, appConfigRsp.b());
            edit.putFloat(f29254v, (float) appConfigRsp.h());
            Code(edit, f29249q, appConfigRsp.c());
            Code(edit, f29250r, appConfigRsp.d());
            Code(edit, Y, appConfigRsp.i());
            edit.putString(f29229aa, appConfigRsp.j());
            V(edit, appConfigRsp.k());
            Code(edit, f29251s, appConfigRsp.l());
            Code(edit, appConfigRsp.V());
            Code(edit, aA, appConfigRsp.m());
            Code(edit, aj, appConfigRsp.n());
            Code(edit, aC, appConfigRsp.o());
            Code(appConfigRsp.p());
            Code(edit, "sha256", appConfigRsp.q());
            List<String> a10 = appConfigRsp.a();
            if (!aa.Code(a10)) {
                edit.putStringSet(f29246n, new HashSet(a10));
            }
            edit.commit();
        }
    }

    public void Code(String str) {
        synchronized (this.aw) {
            if (!TextUtils.isEmpty(str)) {
                this.f29259ar.edit().putString(f29252t, str).commit();
            }
        }
    }

    public void Code(List<String> list) {
        synchronized (this.aw) {
            if (!aa.Code(list)) {
                this.f29259ar.edit().putStringSet(aG, aa.Code(list, true)).commit();
            }
        }
    }

    public void Code(Set<String> set) {
        synchronized (this.aw) {
            SharedPreferences.Editor edit = this.f29259ar.edit();
            if (aa.Code(set)) {
                edit.putStringSet(aF, null);
            } else {
                edit.putStringSet(aF, set);
            }
            edit.commit();
        }
    }

    public void Code(boolean z10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putBoolean(f29241i, z10).commit();
        }
    }

    public int D() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(L, 0);
        }
        return i10;
    }

    public String E() {
        String V2;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            V2 = map != null ? com.huawei.openalliance.ad.utils.au.V(map.get(G)) : null;
        }
        return V2;
    }

    public int F() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt("splash_skip_area", 0);
        }
        return i10;
    }

    public void F(int i10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putInt(ai, i10).commit();
        }
    }

    public int G() {
        int intValue;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(H)) : null;
            intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 15;
        }
        return intValue;
    }

    public int H() {
        int intValue;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(J)) : null;
            intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 5;
        }
        return intValue;
    }

    public int I() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(S, aq());
        }
        return i10;
    }

    public void I(int i10) {
        synchronized (this.aw) {
            SharedPreferences.Editor edit = this.f29259ar.edit();
            edit.putInt(f29247o, i10);
            edit.commit();
        }
    }

    public void I(long j10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putLong(f29234b, j10).commit();
        }
    }

    public void I(String str) {
        synchronized (this.aw) {
            if (!TextUtils.isEmpty(str)) {
                this.f29259ar.edit().putString(f29245m, str).commit();
            }
        }
    }

    public void I(boolean z10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putBoolean("full_screen_notify", z10).commit();
        }
    }

    public int J() {
        int intValue;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(K)) : null;
            intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 56;
        }
        return intValue;
    }

    public int K() {
        int intValue;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(N)) : null;
            intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 16;
        }
        return intValue;
    }

    public int L() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29228a, 2000);
        }
        return i10;
    }

    public int M() {
        int intValue;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(O)) : null;
            intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 36;
        }
        return intValue;
    }

    public int N() {
        int intValue;
        synchronized (this.aw) {
            synchronized (this.aw) {
                Map<String, String> map = this.au;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(Q)) : null;
                intValue = (F2 != null && F2.intValue() >= 0) ? F2.intValue() : 60;
            }
        }
        return intValue;
    }

    public int O() {
        int intValue;
        synchronized (this.aw) {
            synchronized (this.aw) {
                Map<String, String> map = this.au;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(U)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 200;
            }
        }
        return intValue;
    }

    public Map<String, String> P() {
        Map<String, String> map;
        synchronized (this.aw) {
            synchronized (this.aw) {
                Map<String, String> map2 = this.au;
                map = map2 != null ? (Map) com.huawei.openalliance.ad.utils.z.V(map2.get(R), Map.class, new Class[0]) : null;
            }
        }
        return map;
    }

    public Long Q() {
        Long valueOf;
        synchronized (this.aw) {
            valueOf = Long.valueOf(this.f29259ar.getLong(f29230ab, 0L));
        }
        return valueOf;
    }

    public int R() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29231ac, 0);
        }
        return i10;
    }

    public long S() {
        long max;
        synchronized (this.aw) {
            max = Math.max(this.f29259ar.getLong(Z, 1800000L), com.huawei.openalliance.ad.constant.u.as);
        }
        return max;
    }

    public void S(int i10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putInt(ag, i10).commit();
        }
    }

    public String T() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(f29232ad, null);
        }
        return string;
    }

    public int U() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29233ae, 100);
        }
        return i10;
    }

    public int V() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(C, 3000);
        }
        return i10;
    }

    public int V(Context context) {
        int i10;
        synchronized (this.aw) {
            boolean g3 = com.huawei.openalliance.ad.utils.v.g(context);
            i10 = g3 ? 98 : 64;
            int i11 = g3 ? 119 : 85;
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(M)) : null;
            if (F2 != null && F2.intValue() > 0 && F2.intValue() <= i11) {
                i10 = F2.intValue();
            }
        }
        return i10;
    }

    public void V(int i10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putInt(f29228a, i10).commit();
        }
    }

    public void V(long j10) {
        synchronized (this.aw) {
            if (j10 > 0) {
                this.f29259ar.edit().putLong(f29230ab, j10).commit();
            }
        }
    }

    public void V(String str) {
        synchronized (this.aw) {
            if (!TextUtils.isEmpty(str)) {
                this.f29259ar.edit().putString(f29232ad, str).commit();
            }
        }
    }

    public void V(boolean z10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putBoolean(f29242j, z10).commit();
        }
    }

    public String W() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(af, this.ax);
        }
        return string;
    }

    public boolean X() {
        boolean z10;
        synchronized (this.aw) {
            z10 = this.f29259ar.getBoolean("full_screen_notify", true);
        }
        return z10;
    }

    public int Y() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(ai, 0);
        }
        return i10;
    }

    public int Z() {
        int i10;
        synchronized (this.aw) {
            int i11 = 0;
            i10 = this.f29259ar.getInt(S, 0);
            if (i10 == 0) {
                int aq2 = aq();
                if (aq2 != 1) {
                    i11 = aq2;
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public void Z(int i10) {
        synchronized (this.aw) {
            if (i10 > 0) {
                this.f29259ar.edit().putInt(f29231ac, i10).commit();
            }
        }
    }

    public void Z(String str) {
        synchronized (this.aw) {
            if (!com.huawei.openalliance.ad.utils.au.Code(str)) {
                this.f29259ar.edit().putString(af, str).commit();
            }
        }
    }

    public void Z(boolean z10) {
        synchronized (this.aw) {
            this.f29259ar.edit().putBoolean(al, z10).commit();
        }
    }

    public int a() {
        int i10;
        synchronized (this.aw) {
            int D2 = 1 == I() ? D() : 2000;
            if (com.huawei.openalliance.ad.utils.l.V(this.ay)) {
                D2 = L();
            }
            i10 = this.f29259ar.getInt(D, D2);
        }
        return i10;
    }

    public int aa() {
        synchronized (this.aw) {
            if (!ea.Code(this.ay).V()) {
                return 0;
            }
            return this.f29259ar.getInt(aA, 0);
        }
    }

    public int ab() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(aj, 0) * 1000;
        }
        return i10;
    }

    public boolean ac() {
        boolean z10;
        synchronized (this.aw) {
            z10 = this.f29259ar.getBoolean(al, false);
        }
        return z10;
    }

    public int ad() {
        synchronized (this.aw) {
            Integer F2 = com.huawei.openalliance.ad.utils.af.Code(this.au) ? null : com.huawei.openalliance.ad.utils.au.F(this.au.get("preRequest"));
            if (F2 == null) {
                return 0;
            }
            return F2.intValue();
        }
    }

    public boolean ae() {
        boolean z10;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(X)) : null;
            z10 = true;
            if (F2 == null || F2.intValue() != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    public long af() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getLong(f29234b, 0L);
        }
        return j10;
    }

    public int ag() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(aC, 30);
        }
        return i10;
    }

    public String ah() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(aB, "");
        }
        return string;
    }

    public Set<String> ai() {
        Set<String> stringSet;
        synchronized (this.aw) {
            stringSet = this.f29259ar.getStringSet(aF, new HashSet());
        }
        return stringSet;
    }

    public boolean aj() {
        synchronized (this.aw) {
            if (!com.huawei.openalliance.ad.utils.l.V(this.ay)) {
                return false;
            }
            gl.Code(Code, "isSingleMediaPlayerInstance, is tv");
            Set<String> stringSet = this.f29259ar.getStringSet(aG, new HashSet());
            String Code2 = com.huawei.openalliance.ad.utils.l.Code();
            if (!aa.Code(stringSet) && !TextUtils.isEmpty(Code2)) {
                return com.huawei.openalliance.ad.utils.au.Code(stringSet, Code2.toUpperCase(Locale.ENGLISH));
            }
            return true;
        }
    }

    public int ak() {
        int i10;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            i10 = 0;
            int Code2 = (map == null || TextUtils.isEmpty(map.get(an))) ? 0 : com.huawei.openalliance.ad.utils.au.Code(this.au.get(an), 0);
            if (Code2 == 0 || Code2 == 1) {
                i10 = Code2;
            }
        }
        return i10;
    }

    public String al() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString("sha256", "");
        }
        return string;
    }

    public long b() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getLong(f29235c, 300L);
        }
        return j10;
    }

    public int c() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29236d, 0);
        }
        return i10;
    }

    public int d() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29237e, 0);
        }
        return i10;
    }

    public String e() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(f29238f, "");
        }
        return string;
    }

    public boolean f() {
        boolean z10;
        synchronized (this.aw) {
            z10 = this.f29259ar.getBoolean(f29241i, false);
        }
        return z10;
    }

    public boolean g() {
        boolean z10;
        synchronized (this.aw) {
            z10 = this.f29259ar.getBoolean(f29242j, true);
        }
        return z10;
    }

    public long h() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getLong(f29243k, 0L);
        }
        return j10;
    }

    public int i() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29239g, 360);
        }
        return i10;
    }

    public long j() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getLong(f29240h, 0L);
        }
        return j10;
    }

    public boolean k() {
        Integer Code2 = com.huawei.openalliance.ad.utils.av.Code(ap(), 1);
        return Code2 != null && Code2.intValue() == 1;
    }

    public Set<String> l() {
        Set<String> stringSet;
        synchronized (this.aw) {
            stringSet = this.f29259ar.getStringSet(f29246n, com.huawei.openalliance.ad.constant.x.Code);
        }
        return stringSet;
    }

    public int m() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29247o, 0);
        }
        return i10;
    }

    public long n() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getLong(f29249q, 30L);
        }
        return j10;
    }

    public long o() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getInt(f29251s, 60);
        }
        return j10;
    }

    public long p() {
        long j10;
        synchronized (this.aw) {
            j10 = this.f29259ar.getLong(f29250r, 120L);
        }
        return j10;
    }

    public int q() {
        int i10;
        synchronized (this.aw) {
            i10 = this.f29259ar.getInt(f29244l, 52428800);
        }
        return i10;
    }

    public String r() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(f29252t, null);
        }
        return string;
    }

    public float s() {
        float f10;
        synchronized (this.aw) {
            f10 = this.f29259ar.getFloat(f29254v, 0.05f);
        }
        return f10;
    }

    public int t() {
        try {
            return ((Integer) Class.forName("com.huawei.openalliance.ad.ppskit.utils.SdkSpFunctionWrapper").getMethod("getAdsCoreSelection", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (Throwable unused) {
            gl.V(Code, "function wrapper not found");
            if (!ea.V(this.ay) && ea.Code(this.ay).V()) {
                return 1;
            }
            synchronized (this.aw) {
                String Code2 = com.huawei.openalliance.ad.utils.ay.Code(this.ay, com.huawei.openalliance.ad.constant.u.bF);
                if (!TextUtils.isEmpty(Code2)) {
                    int i10 = com.huawei.openalliance.ad.constant.e.Z.equalsIgnoreCase(Code2) ? 1 : com.huawei.openalliance.ad.constant.e.B.equalsIgnoreCase(Code2) ? 0 : com.huawei.openalliance.ad.constant.e.C.equalsIgnoreCase(Code2) ? 2 : -1;
                    if (i10 != -1) {
                        return i10;
                    }
                }
                return this.f29259ar.getInt(Y, (!ea.V(this.ay) || ea.Code(this.ay).V()) ? 1 : 0);
            }
        }
    }

    public String u() {
        String string;
        synchronized (this.aw) {
            string = this.f29259ar.getString(f29229aa, "");
        }
        return string;
    }

    public int v() {
        int intValue;
        synchronized (this.aw) {
            synchronized (this.aw) {
                Map<String, String> map = this.au;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(f29255w)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 10;
            }
        }
        return intValue;
    }

    public int w() {
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(f29256x)) : null;
            if (F2 != null && F2.intValue() >= 0) {
                if (F2.intValue() <= 4) {
                    return F2.intValue();
                }
                return 0;
            }
            return 0;
        }
    }

    public String x() {
        String V2;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            V2 = map != null ? com.huawei.openalliance.ad.utils.au.V(map.get(f29257y)) : null;
        }
        return V2;
    }

    public int y() {
        int intValue;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            Integer F2 = map != null ? com.huawei.openalliance.ad.utils.au.F(map.get(f29258z)) : null;
            intValue = (F2 != null && F2.intValue() >= 0 && F2.intValue() <= 24) ? F2.intValue() : 3;
        }
        return intValue;
    }

    public String z() {
        String V2;
        synchronized (this.aw) {
            Map<String, String> map = this.au;
            V2 = map != null ? com.huawei.openalliance.ad.utils.au.V(map.get(A)) : null;
        }
        return V2;
    }
}
