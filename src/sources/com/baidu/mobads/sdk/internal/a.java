package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9689a = "none";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9690b = "text";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9691c = "static_image";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9692d = "gif";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9693e = "rich_media";

    /* renamed from: f, reason: collision with root package name */
    public static final String f9694f = "html";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9695g = "hybrid";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9696h = "video";

    /* renamed from: i, reason: collision with root package name */
    private static final long f9697i = 1750000;
    private String A;
    private String B;
    private String C;
    private int D;
    private String E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private String L;
    private List<String> N;
    private JSONObject O;
    private long P;
    private long Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private JSONObject Y;
    private int Z;

    /* renamed from: aa, reason: collision with root package name */
    private int f9698aa;

    /* renamed from: ab, reason: collision with root package name */
    private int f9699ab;

    /* renamed from: ac, reason: collision with root package name */
    private List<String> f9700ac;

    /* renamed from: ae, reason: collision with root package name */
    private String f9702ae;
    private String af;
    private JSONObject ag;
    private JSONObject ah;

    /* renamed from: j, reason: collision with root package name */
    private String f9703j;

    /* renamed from: k, reason: collision with root package name */
    private String f9704k;

    /* renamed from: l, reason: collision with root package name */
    private String f9705l;

    /* renamed from: m, reason: collision with root package name */
    private String f9706m;

    /* renamed from: n, reason: collision with root package name */
    private int f9707n;

    /* renamed from: o, reason: collision with root package name */
    private int f9708o;

    /* renamed from: p, reason: collision with root package name */
    private String f9709p;

    /* renamed from: q, reason: collision with root package name */
    private long f9710q;

    /* renamed from: r, reason: collision with root package name */
    private int f9711r;

    /* renamed from: t, reason: collision with root package name */
    private String f9713t;

    /* renamed from: u, reason: collision with root package name */
    private String f9714u;

    /* renamed from: v, reason: collision with root package name */
    private String f9715v;

    /* renamed from: w, reason: collision with root package name */
    private String f9716w;

    /* renamed from: x, reason: collision with root package name */
    private String f9717x;

    /* renamed from: y, reason: collision with root package name */
    private String f9718y;

    /* renamed from: z, reason: collision with root package name */
    private String f9719z;

    /* renamed from: s, reason: collision with root package name */
    private int f9712s = 1;
    private String M = "none";

    /* renamed from: ad, reason: collision with root package name */
    private int f9701ad = 0;

    /* JADX WARN: Removed duplicated region for block: B:45:0x0148 A[Catch: all -> 0x0177, JSONException -> 0x017c, TryCatch #4 {JSONException -> 0x017c, all -> 0x0177, blocks: (B:5:0x007e, B:8:0x0090, B:10:0x00a1, B:11:0x00b8, B:13:0x00c4, B:15:0x00cf, B:17:0x00d5, B:18:0x00d7, B:20:0x00dd, B:22:0x00e3, B:24:0x00eb, B:28:0x00f4, B:30:0x00fe, B:32:0x011b, B:36:0x0121, B:37:0x0127, B:39:0x012f, B:41:0x0135, B:43:0x013f, B:45:0x0148, B:47:0x0156, B:49:0x015d, B:50:0x0165, B:52:0x016b), top: B:4:0x007e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r17) {
        /*
            Method dump skipped, instructions count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public static boolean a(int i10) {
        return (i10 < 28 || 31 == i10 || 32 == i10 || 38 == i10 || 39 == i10 || 40 == i10 || 42 < i10) ? false : true;
    }

    public String A() {
        return this.f9719z;
    }

    public String B() {
        return this.f9718y;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    public long F() {
        return this.Q;
    }

    public List<String> G() {
        return this.N;
    }

    public String H() {
        return this.R;
    }

    public JSONObject I() {
        return this.O;
    }

    public String J() {
        return this.U;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        return this.W;
    }

    public String M() {
        String str = this.X;
        return (str == null || str.length() <= 4) ? this.X : "";
    }

    public int N() {
        return this.f9699ab;
    }

    public List<String> O() {
        return this.f9700ac;
    }

    public JSONObject P() {
        return this.Y;
    }

    public int Q() {
        return this.Z;
    }

    public int R() {
        return this.f9698aa;
    }

    public int S() {
        return this.f9701ad;
    }

    public JSONObject T() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.R);
            jSONObject.put("tit", this.f9703j);
            jSONObject.put(SocialConstants.PARAM_APP_DESC, this.f9704k);
            jSONObject.put("pk", this.f9715v);
            jSONObject.put("appname", this.f9709p);
            jSONObject.put(SocialConstants.PARAM_ACT, this.D);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String U() {
        return this.f9702ae;
    }

    public String V() {
        if (TextUtils.isEmpty(this.af)) {
            return "";
        }
        try {
            long parseLong = Long.parseLong(this.af);
            int length = this.af.length();
            return (parseLong <= 100000 || length <= 5) ? "" : this.af.substring(length - 4, length);
        } catch (Throwable th) {
            aw.b(th);
            return "";
        }
    }

    public String b() {
        return this.f9704k;
    }

    public String c() {
        return this.f9705l;
    }

    public String d() {
        return this.f9706m;
    }

    public int e() {
        return this.f9707n;
    }

    public int f() {
        return this.f9708o;
    }

    public String g() {
        return this.f9709p;
    }

    public String h() {
        return this.S;
    }

    public String i() {
        return this.T;
    }

    public long j() {
        return this.f9710q;
    }

    public int k() {
        return this.f9711r;
    }

    public int l() {
        return this.f9712s;
    }

    public String m() {
        return this.f9715v;
    }

    public String n() {
        return this.f9716w;
    }

    public String o() {
        return this.f9717x;
    }

    public int p() {
        return this.D;
    }

    public String q() {
        return this.E;
    }

    public int r() {
        return this.F;
    }

    public int s() {
        return this.G;
    }

    public int t() {
        return this.H;
    }

    public int u() {
        return this.I;
    }

    public int v() {
        return this.J;
    }

    public int w() {
        return this.K;
    }

    public String x() {
        return this.M;
    }

    public long y() {
        return this.P;
    }

    public String z() {
        if (!TextUtils.isEmpty(this.f9714u)) {
            return this.f9714u;
        }
        return this.f9713t;
    }

    public String a(String str) {
        if (this.ag == null) {
            return null;
        }
        JSONObject jSONObject = this.ah;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        String optString = this.ag.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (TextUtils.equals(optString, "fallback") && optJSONObject != null) {
            return optJSONObject.optString("fallback");
        }
        if (TextUtils.equals(optString, "page") && optJSONObject != null) {
            return optJSONObject.optString("page");
        }
        JSONObject jSONObject2 = this.ah;
        if (jSONObject2 != null) {
            return jSONObject2.optString(optString);
        }
        return null;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i10)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i10, int i11) {
        String[] split;
        int i12 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                        i12 = Integer.parseInt(split[0]);
                    }
                }
            } catch (Throwable th) {
                bs.a().d(th.getMessage());
            }
        }
        if (a(i12)) {
            i10 = i12;
        } else if (!a(i10)) {
            i10 = i11;
        }
        if (i10 == 42) {
            return 41;
        }
        return i10;
    }

    public String a() {
        return this.f9703j;
    }
}
