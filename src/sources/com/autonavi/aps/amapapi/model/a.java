package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* compiled from: AMapLocationServer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a extends AMapLocation {

    /* renamed from: d, reason: collision with root package name */
    public String f9382d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9383e;

    /* renamed from: f, reason: collision with root package name */
    public String f9384f;

    /* renamed from: g, reason: collision with root package name */
    private String f9385g;

    /* renamed from: h, reason: collision with root package name */
    private String f9386h;

    /* renamed from: i, reason: collision with root package name */
    private int f9387i;

    /* renamed from: j, reason: collision with root package name */
    private String f9388j;

    /* renamed from: k, reason: collision with root package name */
    private int f9389k;

    /* renamed from: l, reason: collision with root package name */
    private String f9390l;

    /* renamed from: m, reason: collision with root package name */
    private JSONObject f9391m;

    /* renamed from: n, reason: collision with root package name */
    private String f9392n;

    /* renamed from: o, reason: collision with root package name */
    private String f9393o;

    /* renamed from: p, reason: collision with root package name */
    private String f9394p;

    public a(String str) {
        super(str);
        this.f9382d = "";
        this.f9385g = null;
        this.f9386h = "";
        this.f9388j = "";
        this.f9389k = 0;
        this.f9390l = "new";
        this.f9391m = null;
        this.f9392n = "";
        this.f9383e = true;
        this.f9384f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f9393o = "";
        this.f9394p = null;
    }

    private void i(String str) {
        this.f9392n = str;
    }

    public final String a() {
        return this.f9385g;
    }

    public final String b() {
        return this.f9386h;
    }

    public final int c() {
        return this.f9387i;
    }

    public final String d() {
        return this.f9388j;
    }

    public final String e() {
        return this.f9390l;
    }

    public final JSONObject f() {
        return this.f9391m;
    }

    public final String g() {
        return this.f9392n;
    }

    public final a h() {
        String g3 = g();
        if (TextUtils.isEmpty(g3)) {
            return null;
        }
        String[] split = g3.split(",");
        if (split.length != 3) {
            return null;
        }
        a aVar = new a("");
        aVar.setProvider(getProvider());
        aVar.setLongitude(j.c(split[0]));
        aVar.setLatitude(j.c(split[1]));
        aVar.setAccuracy(j.d(split[2]));
        aVar.setCityCode(getCityCode());
        aVar.setAdCode(getAdCode());
        aVar.setCountry(getCountry());
        aVar.setProvince(getProvince());
        aVar.setCity(getCity());
        aVar.setTime(getTime());
        aVar.e(e());
        aVar.c(String.valueOf(c()));
        if (j.a(aVar)) {
            return aVar;
        }
        return null;
    }

    public final String j() {
        return this.f9384f;
    }

    public final String k() {
        return this.f9394p;
    }

    public final int l() {
        return this.f9389k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i10) {
        try {
            JSONObject json = super.toJson(i10);
            if (i10 == 1) {
                json.put("retype", this.f9388j);
                json.put("cens", this.f9393o);
                json.put("coord", this.f9387i);
                json.put("mcell", this.f9392n);
                json.put(SocialConstants.PARAM_APP_DESC, this.f9382d);
                json.put(TextClassifier.TYPE_ADDRESS, getAddress());
                if (this.f9391m != null && j.a(json, "offpct")) {
                    json.put("offpct", this.f9391m.getString("offpct"));
                }
            } else if (i10 != 2 && i10 != 3) {
                return json;
            }
            json.put("type", this.f9390l);
            json.put("isReversegeo", this.f9383e);
            json.put("geoLanguage", this.f9384f);
            return json;
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\*");
        int length = split.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            String str2 = split[i10];
            if (!TextUtils.isEmpty(str2)) {
                String[] split2 = str2.split(",");
                setLongitude(j.c(split2[0]));
                setLatitude(j.c(split2[1]));
                setAccuracy(j.e(split2[2]));
                break;
            }
            i10++;
        }
        this.f9393o = str;
    }

    public final void a(String str) {
        this.f9385g = str;
    }

    public final void b(String str) {
        this.f9386h = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L1e
            java.lang.String r0 = "0"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L12
            r2 = 0
            r1.f9387i = r2
            goto L21
        L12:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L1e
            r2 = 1
            r1.f9387i = r2
            goto L21
        L1e:
            r2 = -1
            r1.f9387i = r2
        L21:
            int r2 = r1.f9387i
            if (r2 != 0) goto L2b
            java.lang.String r2 = "WGS84"
            super.setCoordType(r2)
            return
        L2b:
            java.lang.String r2 = "GCJ02"
            super.setCoordType(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.model.a.c(java.lang.String):void");
    }

    public final void d(String str) {
        this.f9388j = str;
    }

    public final void e(String str) {
        this.f9390l = str;
    }

    public final void f(String str) {
        this.f9384f = str;
    }

    public final void g(String str) {
        this.f9382d = str;
    }

    public final boolean i() {
        return this.f9383e;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i10) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i10);
            jSONObject.put("nb", this.f9394p);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public final void a(JSONObject jSONObject) {
        this.f9391m = jSONObject;
    }

    public final void b(JSONObject jSONObject) {
        try {
            b.a(this, jSONObject);
            e(jSONObject.optString("type", this.f9390l));
            d(jSONObject.optString("retype", this.f9388j));
            j(jSONObject.optString("cens", this.f9393o));
            g(jSONObject.optString(SocialConstants.PARAM_APP_DESC, this.f9382d));
            c(jSONObject.optString("coord", String.valueOf(this.f9387i)));
            i(jSONObject.optString("mcell", this.f9392n));
            a(jSONObject.optBoolean("isReversegeo", this.f9383e));
            f(jSONObject.optString("geoLanguage", this.f9384f));
            if (j.a(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (j.a(jSONObject, ExposeManager.UtArgsNames.pid)) {
                setBuildingId(jSONObject.optString(ExposeManager.UtArgsNames.pid));
            }
            if (j.a(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (j.a(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "AmapLoc");
        }
    }

    public final void a(boolean z10) {
        this.f9383e = z10;
    }

    public final void a(int i10) {
        this.f9389k = i10;
    }

    public final void h(String str) {
        this.f9394p = str;
    }
}
