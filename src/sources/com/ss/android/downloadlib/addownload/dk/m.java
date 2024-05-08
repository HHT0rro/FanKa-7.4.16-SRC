package com.ss.android.downloadlib.addownload.dk;

import com.ss.android.downloadlib.hc.ve;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {
    public long dk;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f38576e;
    public long ej;

    /* renamed from: hc, reason: collision with root package name */
    public String f38577hc;

    /* renamed from: l, reason: collision with root package name */
    public String f38578l;

    /* renamed from: m, reason: collision with root package name */
    public long f38579m;

    /* renamed from: n, reason: collision with root package name */
    public String f38580n;
    public String np;

    public m() {
    }

    public JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f38579m);
            jSONObject.put("mAdId", this.dk);
            jSONObject.put("mExtValue", this.ej);
            jSONObject.put("mPackageName", this.f38578l);
            jSONObject.put("mAppName", this.np);
            jSONObject.put("mLogExtra", this.f38580n);
            jSONObject.put("mFileName", this.f38577hc);
            jSONObject.put("mTimeStamp", this.f38576e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public m(long j10, long j11, long j12, String str, String str2, String str3, String str4) {
        this.f38579m = j10;
        this.dk = j11;
        this.ej = j12;
        this.f38578l = str;
        this.np = str2;
        this.f38580n = str3;
        this.f38577hc = str4;
    }

    public static m m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        try {
            mVar.f38579m = ve.m(jSONObject, "mDownloadId");
            mVar.dk = ve.m(jSONObject, "mAdId");
            mVar.ej = ve.m(jSONObject, "mExtValue");
            mVar.f38578l = jSONObject.optString("mPackageName");
            mVar.np = jSONObject.optString("mAppName");
            mVar.f38580n = jSONObject.optString("mLogExtra");
            mVar.f38577hc = jSONObject.optString("mFileName");
            mVar.f38576e = ve.m(jSONObject, "mTimeStamp");
            return mVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
