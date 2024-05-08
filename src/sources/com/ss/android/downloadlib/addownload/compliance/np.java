package com.ss.android.downloadlib.addownload.compliance;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.hc.ve;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np {

    /* renamed from: c, reason: collision with root package name */
    private long f38536c;
    private m dk;

    /* renamed from: e, reason: collision with root package name */
    private String f38537e;
    private int ej;

    /* renamed from: hc, reason: collision with root package name */
    private String f38538hc;

    /* renamed from: l, reason: collision with root package name */
    private int f38539l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f38540m;

    /* renamed from: n, reason: collision with root package name */
    private int f38541n;
    private int np = 15;

    /* renamed from: oa, reason: collision with root package name */
    private String f38542oa;

    /* renamed from: q, reason: collision with root package name */
    private String f38543q;

    /* renamed from: r, reason: collision with root package name */
    private dk f38544r;
    private String sy;
    private String ve;

    /* renamed from: w, reason: collision with root package name */
    private int f38545w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class dk {
        private String dk;

        /* renamed from: m, reason: collision with root package name */
        private int f38546m;

        public void m(int i10) {
            this.f38546m = i10;
        }

        public void m(String str) {
            this.dk = str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: c, reason: collision with root package name */
        private String f38547c;
        private String dk;

        /* renamed from: e, reason: collision with root package name */
        private String f38548e;
        private long ej;

        /* renamed from: hc, reason: collision with root package name */
        private List<C0574m> f38549hc;

        /* renamed from: l, reason: collision with root package name */
        private long f38550l;

        /* renamed from: m, reason: collision with root package name */
        private String f38551m;

        /* renamed from: n, reason: collision with root package name */
        private String f38552n;
        private String np;

        /* renamed from: oa, reason: collision with root package name */
        private String f38553oa;
        private String ve;

        /* renamed from: w, reason: collision with root package name */
        private String f38554w;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.np$m$m, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class C0574m {
            private String dk;

            /* renamed from: m, reason: collision with root package name */
            private String f38555m;

            public void dk(String str) {
                this.dk = str;
            }

            public void m(String str) {
                this.f38555m = str;
            }
        }

        public void dk(String str) {
            this.dk = str;
        }

        public void e(String str) {
            this.f38547c = str;
        }

        public void ej(String str) {
            this.np = str;
        }

        public void hc(String str) {
            this.f38553oa = str;
        }

        public void l(String str) {
            this.f38552n = str;
        }

        public void m(String str) {
            this.f38551m = str;
        }

        public void n(String str) {
            this.f38554w = str;
        }

        public void np(String str) {
            this.f38548e = str;
        }

        public void w(String str) {
            this.ve = str;
        }

        public void dk(long j10) {
            this.f38550l = j10;
        }

        public void m(long j10) {
            this.ej = j10;
        }

        public void m(List<C0574m> list) {
            this.f38549hc = list;
        }
    }

    public static np hc(String str) {
        np npVar = new np();
        try {
            JSONObject jSONObject = new JSONObject(str);
            m m10 = m(jSONObject);
            dk dk2 = dk(jSONObject);
            npVar.m(m10);
            npVar.m(dk2);
            npVar.m(jSONObject.optInt("show_auth", 0) == 1);
            npVar.m(jSONObject.optInt("download_permit"));
            npVar.dk(jSONObject.optInt("appstore_permit"));
            npVar.ej(jSONObject.optInt("market_online_status", 15));
            npVar.l(jSONObject.optInt("hijack_permit"));
            npVar.m(jSONObject.optString("package_name"));
            npVar.dk(jSONObject.optString("hijack_url"));
            npVar.np(jSONObject.optInt("code"));
            npVar.ej(jSONObject.optString("message"));
            npVar.m(jSONObject.optLong("request_duration", 0L));
            npVar.l(jSONObject.optString("back_web_url"));
            npVar.np(jSONObject.optString("hw_app_id"));
            npVar.n(jSONObject.optString("deep_link"));
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "ComplianceResult fromJson");
        }
        return npVar;
    }

    public void dk(int i10) {
        this.f38539l = i10;
    }

    public void ej(int i10) {
        this.np = i10;
    }

    public void l(int i10) {
        this.f38541n = i10;
    }

    public void m(boolean z10) {
        this.f38540m = z10;
    }

    public void n(String str) {
        this.sy = str;
    }

    public void np(int i10) {
        this.f38545w = i10;
    }

    public String toString() {
        return m(this);
    }

    public void dk(String str) {
        this.f38537e = str;
    }

    public void ej(String str) {
        this.f38542oa = str;
    }

    public void l(String str) {
        this.f38543q = str;
    }

    public void m(m mVar) {
        this.dk = mVar;
    }

    public void np(String str) {
        this.ve = str;
    }

    private static JSONArray ej(m mVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<m.C0574m> list = mVar.f38549hc;
        if (list != null && list.size() > 0) {
            for (m.C0574m c0574m : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0574m.f38555m);
                jSONObject.putOpt("permission_desc", c0574m.dk);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public String dk() {
        return this.sy;
    }

    public void m(int i10) {
        this.ej = i10;
    }

    private static JSONObject dk(m mVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (mVar != null) {
            jSONObject.putOpt("app_name", mVar.f38551m);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, mVar.dk);
            jSONObject.putOpt("update_time", Long.valueOf(mVar.ej));
            jSONObject.putOpt("size", Long.valueOf(mVar.f38550l));
            jSONObject.putOpt("developer_name", mVar.np);
            jSONObject.putOpt("policy_url", mVar.f38554w);
            jSONObject.putOpt("icon_url", mVar.f38553oa);
            jSONObject.putOpt("download_url", mVar.f38547c);
            jSONObject.putOpt("permissions", ej(mVar));
            jSONObject.putOpt("permission_classify_url", mVar.f38548e);
            jSONObject.putOpt("desc_url", mVar.ve);
        }
        return jSONObject;
    }

    public void m(String str) {
        this.f38538hc = str;
    }

    public int m() {
        return this.f38545w;
    }

    public void m(long j10) {
        this.f38536c = j10;
    }

    public void m(dk dkVar) {
        this.f38544r = dkVar;
    }

    public static String m(np npVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(npVar.f38540m ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(npVar.ej));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(npVar.f38539l));
            jSONObject.putOpt("market_online_status", Integer.valueOf(npVar.np));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(npVar.f38541n));
            jSONObject.putOpt("package_name", npVar.f38538hc);
            jSONObject.putOpt("hijack_url", npVar.f38537e);
            jSONObject.putOpt("code", Integer.valueOf(npVar.f38545w));
            jSONObject.putOpt("message", npVar.f38542oa);
            jSONObject.putOpt("request_duration", Long.valueOf(npVar.f38536c));
            jSONObject.putOpt("auth_info", dk(npVar.dk));
            jSONObject.putOpt("status", dk(npVar.f38544r));
            jSONObject.putOpt("back_web_url", npVar.f38543q);
            jSONObject.putOpt("hw_app_id", npVar.ve);
            jSONObject.putOpt("deep_link", npVar.sy);
        } catch (JSONException e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static dk dk(JSONObject jSONObject) {
        dk dkVar = new dk();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                dkVar.m(optJSONObject.optInt("status"));
                dkVar.m(optJSONObject.optString("message"));
            }
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "ComplianceResult getStatus");
        }
        return dkVar;
    }

    private static JSONObject dk(dk dkVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (dkVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(dkVar.f38546m));
            jSONObject.putOpt("message", dkVar.dk);
        }
        return jSONObject;
    }

    private static m m(JSONObject jSONObject) {
        m mVar = new m();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                mVar.m(optJSONObject.optString("app_name"));
                mVar.dk(optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                mVar.m(ve.m(optJSONObject, "update_time"));
                mVar.dk(ve.m(optJSONObject, "size"));
                mVar.ej(optJSONObject.optString("developer_name"));
                mVar.l(optJSONObject.optString("package_name"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    m(optJSONArray, arrayList);
                    mVar.m(arrayList);
                }
                mVar.np(optJSONObject.optString("permission_classify_url"));
                mVar.n(optJSONObject.optString("policy_url"));
                mVar.hc(optJSONObject.optString("icon_url"));
                mVar.e(optJSONObject.optString("download_url"));
                mVar.w(optJSONObject.optString("desc_url"));
            }
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "ComplianceResult getAuthInfo");
        }
        return mVar;
    }

    private static void m(JSONArray jSONArray, List<m.C0574m> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                m.C0574m c0574m = new m.C0574m();
                c0574m.m(optJSONObject.optString("permission_name"));
                c0574m.dk(optJSONObject.optString("permission_desc"));
                list.add(c0574m);
            }
        }
    }
}
