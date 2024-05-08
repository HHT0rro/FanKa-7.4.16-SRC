package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.downloadlib.addownload.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {

    /* renamed from: c, reason: collision with root package name */
    private final int f38417c;
    private final String dk;

    /* renamed from: e, reason: collision with root package name */
    private final JSONObject f38418e;
    private final String ej;

    /* renamed from: hc, reason: collision with root package name */
    private final long f38419hc;

    /* renamed from: k, reason: collision with root package name */
    private final JSONObject f38420k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f38421l;

    /* renamed from: m, reason: collision with root package name */
    private String f38422m;

    /* renamed from: n, reason: collision with root package name */
    private final String f38423n;
    private final long np;

    /* renamed from: oa, reason: collision with root package name */
    private final List<String> f38424oa;

    /* renamed from: q, reason: collision with root package name */
    private final String f38425q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f38426r;
    private final String sy;
    private final Object ve;

    /* renamed from: w, reason: collision with root package name */
    private final JSONObject f38427w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: c, reason: collision with root package name */
        private List<String> f38428c;
        private String dk;

        /* renamed from: e, reason: collision with root package name */
        private JSONObject f38429e;
        private String ej;

        /* renamed from: hc, reason: collision with root package name */
        private long f38430hc;

        /* renamed from: k, reason: collision with root package name */
        private String f38431k;

        /* renamed from: m, reason: collision with root package name */
        private String f38433m;

        /* renamed from: n, reason: collision with root package name */
        private String f38434n;
        private long np;

        /* renamed from: oa, reason: collision with root package name */
        private Map<String, Object> f38435oa;

        /* renamed from: r, reason: collision with root package name */
        private String f38437r;
        private Object sy;

        /* renamed from: t, reason: collision with root package name */
        private JSONObject f38438t;
        private int ve;

        /* renamed from: w, reason: collision with root package name */
        private JSONObject f38439w;

        /* renamed from: l, reason: collision with root package name */
        private boolean f38432l = false;

        /* renamed from: q, reason: collision with root package name */
        private boolean f38436q = false;

        public m dk(String str) {
            this.ej = str;
            return this;
        }

        public m ej(String str) {
            this.f38434n = str;
            return this;
        }

        public m l(String str) {
            this.f38437r = str;
            return this;
        }

        public m m(boolean z10) {
            this.f38436q = z10;
            return this;
        }

        public m dk(long j10) {
            this.f38430hc = j10;
            return this;
        }

        public m m(String str) {
            this.dk = str;
            return this;
        }

        public m dk(boolean z10) {
            this.f38432l = z10;
            return this;
        }

        public m m(long j10) {
            this.np = j10;
            return this;
        }

        public m dk(JSONObject jSONObject) {
            this.f38439w = jSONObject;
            return this;
        }

        public m m(JSONObject jSONObject) {
            this.f38429e = jSONObject;
            return this;
        }

        public m m(List<String> list) {
            this.f38428c = list;
            return this;
        }

        public m m(int i10) {
            this.ve = i10;
            return this;
        }

        public m m(Object obj) {
            this.sy = obj;
            return this;
        }

        public ej m() {
            if (TextUtils.isEmpty(this.f38433m)) {
                this.f38433m = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f38429e == null) {
                this.f38429e = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f38435oa;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f38435oa.entrySet()) {
                        if (!this.f38429e.has(entry.getKey())) {
                            this.f38429e.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.f38436q) {
                    this.f38431k = this.ej;
                    JSONObject jSONObject2 = new JSONObject();
                    this.f38438t = jSONObject2;
                    if (this.f38432l) {
                        jSONObject2.put("ad_extra_data", this.f38429e.toString());
                    } else {
                        Iterator<String> keys = this.f38429e.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f38438t.put(next, this.f38429e.get(next));
                        }
                    }
                    this.f38438t.put(u.ck, this.f38433m);
                    this.f38438t.put("tag", this.dk);
                    this.f38438t.put("value", this.np);
                    this.f38438t.put("ext_value", this.f38430hc);
                    if (!TextUtils.isEmpty(this.f38437r)) {
                        this.f38438t.put(TTDownloadField.TT_REFER, this.f38437r);
                    }
                    JSONObject jSONObject3 = this.f38439w;
                    if (jSONObject3 != null) {
                        this.f38438t = com.ss.android.download.api.ej.dk.m(jSONObject3, this.f38438t);
                    }
                    if (this.f38432l) {
                        if (!this.f38438t.has("log_extra") && !TextUtils.isEmpty(this.f38434n)) {
                            this.f38438t.put("log_extra", this.f38434n);
                        }
                        this.f38438t.put("is_ad_event", "1");
                    }
                }
                if (this.f38432l) {
                    jSONObject.put("ad_extra_data", this.f38429e.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f38434n)) {
                        jSONObject.put("log_extra", this.f38434n);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f38429e);
                }
                if (!TextUtils.isEmpty(this.f38437r)) {
                    jSONObject.putOpt(TTDownloadField.TT_REFER, this.f38437r);
                }
                JSONObject jSONObject4 = this.f38439w;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.ej.dk.m(jSONObject4, jSONObject);
                }
                this.f38429e = jSONObject;
            } catch (Exception e2) {
                c.mj().m(e2, "DownloadEventModel build");
            }
            return new ej(this);
        }
    }

    public ej(m mVar) {
        this.f38422m = mVar.f38433m;
        this.dk = mVar.dk;
        this.ej = mVar.ej;
        this.f38421l = mVar.f38432l;
        this.np = mVar.np;
        this.f38423n = mVar.f38434n;
        this.f38419hc = mVar.f38430hc;
        this.f38418e = mVar.f38429e;
        this.f38427w = mVar.f38439w;
        this.f38424oa = mVar.f38428c;
        this.f38417c = mVar.ve;
        this.ve = mVar.sy;
        this.f38426r = mVar.f38436q;
        this.f38425q = mVar.f38431k;
        this.f38420k = mVar.f38438t;
        this.sy = mVar.f38437r;
    }

    public int c() {
        return this.f38417c;
    }

    public String dk() {
        return this.dk;
    }

    public JSONObject e() {
        return this.f38418e;
    }

    public String ej() {
        return this.ej;
    }

    public long hc() {
        return this.f38419hc;
    }

    public boolean l() {
        return this.f38421l;
    }

    public String m() {
        return this.f38422m;
    }

    public String n() {
        return this.f38423n;
    }

    public long np() {
        return this.np;
    }

    public List<String> oa() {
        return this.f38424oa;
    }

    public JSONObject q() {
        return this.f38420k;
    }

    public String r() {
        return this.f38425q;
    }

    public boolean sy() {
        return this.f38426r;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("category: ");
        sb2.append(this.f38422m);
        sb2.append("\ttag: ");
        sb2.append(this.dk);
        sb2.append("\tlabel: ");
        sb2.append(this.ej);
        sb2.append("\nisAd: ");
        sb2.append(this.f38421l);
        sb2.append("\tadId: ");
        sb2.append(this.np);
        sb2.append("\tlogExtra: ");
        sb2.append(this.f38423n);
        sb2.append("\textValue: ");
        sb2.append(this.f38419hc);
        sb2.append("\nextJson: ");
        sb2.append((Object) this.f38418e);
        sb2.append("\nparamsJson: ");
        sb2.append((Object) this.f38427w);
        sb2.append("\nclickTrackUrl: ");
        List<String> list = this.f38424oa;
        sb2.append(list != null ? list.toString() : "");
        sb2.append("\teventSource: ");
        sb2.append(this.f38417c);
        sb2.append("\textraObject: ");
        Object obj = this.ve;
        sb2.append(obj != null ? obj.toString() : "");
        sb2.append("\nisV3: ");
        sb2.append(this.f38426r);
        sb2.append("\tV3EventName: ");
        sb2.append(this.f38425q);
        sb2.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f38420k;
        sb2.append(jSONObject != null ? jSONObject.toString() : "");
        return sb2.toString();
    }

    public Object ve() {
        return this.ve;
    }

    public JSONObject w() {
        return this.f38427w;
    }
}
