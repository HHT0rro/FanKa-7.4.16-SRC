package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.inno.innosdk.pb.InnoMain;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class aj implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ae f9773a;

    public aj(ae aeVar) {
        this.f9773a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9773a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f9773a.f9759t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        this.f9773a.a(db.f10140r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z10) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9773a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9773a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9773a.f9759t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f9773a.a(db.f10142t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9773a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9773a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9773a.f9759t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f9773a.a(db.f10141s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f9773a.f9759t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        this.f9773a.a(db.f10144v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i10) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9773a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9773a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9773a.f9759t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("backgroundColor", Integer.valueOf(i10));
        this.f9773a.a(db.f10145w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i10 = this.f9773a.i("get_cuid");
        String i11 = this.f9773a.i("get_imei");
        String i12 = this.f9773a.i("get_oaid");
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
        this.f9773a.f9879i.a("单次阅读器打开时长 = " + j10);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i10) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9773a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9773a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9773a.f9759t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("count_down", Integer.valueOf(i10));
        this.f9773a.a(db.f10146x, hashMap);
    }
}
