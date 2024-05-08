package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.inno.innosdk.pb.InnoMain;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class de implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ db f10151a;

    public de(db dbVar) {
        this.f10151a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10151a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10151a.D));
        hashMap.put("channelId", Integer.valueOf(this.f10151a.E));
        hashMap.put("novel_id", this.f10151a.F);
        this.f10151a.a(db.f10140r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10151a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10151a.h()));
        hashMap.put("entry", Integer.valueOf(this.f10151a.D));
        hashMap.put("channelId", Integer.valueOf(this.f10151a.E));
        hashMap.put("novel_id", this.f10151a.F);
        hashMap.put("novel_info", jSONObject);
        this.f10151a.a(db.f10142t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10151a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10151a.h()));
        hashMap.put("entry", Integer.valueOf(this.f10151a.D));
        hashMap.put("channelId", Integer.valueOf(this.f10151a.E));
        hashMap.put("novel_id", this.f10151a.F);
        hashMap.put("novel_info", jSONObject);
        this.f10151a.a(db.f10141s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10151a.D));
        hashMap.put("channelId", Integer.valueOf(this.f10151a.E));
        hashMap.put("novel_id", this.f10151a.F);
        hashMap.put("isnight", Boolean.valueOf(this.f10151a.x()));
        this.f10151a.a(db.f10144v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10151a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10151a.h()));
        hashMap.put("entry", Integer.valueOf(this.f10151a.D));
        hashMap.put("channelId", Integer.valueOf(this.f10151a.E));
        hashMap.put("novel_id", this.f10151a.F);
        hashMap.put("backgroundColor", Integer.valueOf(i10));
        this.f10151a.a(db.f10145w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i10 = this.f10151a.i("get_cuid");
        String i11 = this.f10151a.i("get_imei");
        String i12 = this.f10151a.i("get_oaid");
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
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f10151a.H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f10151a.H;
            cpuNovelListener2.onReadTime(j10);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10151a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10151a.h()));
        hashMap.put("entry", Integer.valueOf(this.f10151a.D));
        hashMap.put("channelId", Integer.valueOf(this.f10151a.E));
        hashMap.put("novel_id", this.f10151a.F);
        hashMap.put("count_down", Integer.valueOf(i10));
        this.f10151a.a(db.f10146x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z10) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f10151a.I;
        if (softReference != null) {
            softReference2 = this.f10151a.I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f10151a.f9878h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f10151a.D));
                hashMap.put("channelId", Integer.valueOf(this.f10151a.E));
                hashMap.put("novel_id", this.f10151a.F);
                hashMap.put("isnight", Boolean.valueOf(this.f10151a.x()));
                this.f10151a.a(db.f10145w, hashMap);
            }
        }
    }
}
