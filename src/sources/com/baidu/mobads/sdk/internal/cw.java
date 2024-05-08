package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.inno.innosdk.pb.InnoMain;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class cw implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10124a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10125b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10126c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cs f10127d;

    public cw(cs csVar, int i10, int i11, String str) {
        this.f10127d = csVar;
        this.f10124a = i10;
        this.f10125b = i11;
        this.f10126c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10127d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10124a));
        hashMap.put("channelId", Integer.valueOf(this.f10125b));
        hashMap.put("novel_id", this.f10126c);
        this.f10127d.a(db.f10140r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z10) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10127d.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10127d.g()));
        hashMap.put("entry", Integer.valueOf(this.f10124a));
        hashMap.put("channelId", Integer.valueOf(this.f10125b));
        hashMap.put("novel_id", this.f10126c);
        hashMap.put("novel_info", jSONObject);
        this.f10127d.a(db.f10142t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10127d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10127d.g()));
        hashMap.put("entry", Integer.valueOf(this.f10124a));
        hashMap.put("channelId", Integer.valueOf(this.f10125b));
        hashMap.put("novel_id", this.f10126c);
        hashMap.put("novel_info", jSONObject);
        this.f10127d.a(db.f10141s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10124a));
        hashMap.put("channelId", Integer.valueOf(this.f10125b));
        hashMap.put("novel_id", this.f10126c);
        this.f10127d.a(db.f10144v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10127d.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10127d.g()));
        hashMap.put("entry", Integer.valueOf(this.f10124a));
        hashMap.put("channelId", Integer.valueOf(this.f10125b));
        hashMap.put("novel_id", this.f10126c);
        hashMap.put("backgroundColor", Integer.valueOf(i10));
        this.f10127d.a(db.f10145w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i10 = this.f10127d.i("get_cuid");
        String i11 = this.f10127d.i("get_imei");
        String i12 = this.f10127d.i("get_oaid");
        try {
            jSONObject.put("cuid", i10);
            jSONObject.put("imei", i11);
            jSONObject.put(InnoMain.INNO_KEY_OAID, i12);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(long j10) {
        this.f10127d.f9879i.a("单次阅读器打开时长 = " + j10);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10127d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10127d.g()));
        hashMap.put("entry", Integer.valueOf(this.f10124a));
        hashMap.put("channelId", Integer.valueOf(this.f10125b));
        hashMap.put("novel_id", this.f10126c);
        hashMap.put("count_down", Integer.valueOf(i10));
        this.f10127d.a(db.f10146x, hashMap);
    }
}
