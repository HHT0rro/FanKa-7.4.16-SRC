package com.huawei.openalliance.ad.inter.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.ev;
import com.huawei.hms.ads.ex;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.ks;
import com.huawei.hms.ads.kt;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class s extends a implements i {
    private VideoInfo B;
    private boolean C;
    private boolean D;
    private transient INonwifiActionListener F;
    private RewardItem L;
    private transient com.huawei.openalliance.ad.inter.listeners.f S;

    /* renamed from: c, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.g f32483c;

    /* renamed from: d, reason: collision with root package name */
    private int f32484d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32485e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f32486f;

    public s(AdContentData adContentData) {
        super(adContentData);
        this.C = false;
        this.f32484d = 1;
        this.f32485e = true;
        this.f32486f = true;
        if (adContentData.G() == null || adContentData.H() == 0) {
            return;
        }
        this.L = new RewardItem(adContentData.G(), adContentData.H());
    }

    private void Code(Activity activity) {
        gl.V("RewardAd", "startRewardViaActivity");
        Intent intent = new Intent();
        intent.setAction(com.huawei.openalliance.ad.constant.u.af);
        intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(activity));
        intent.putExtra("content_id", D());
        intent.putExtra("sdk_version", "13.4.62.302");
        intent.putExtra(ax.f32264g, h_());
        intent.putExtra(ax.f32266i, this.f32484d);
        intent.putExtra(ax.f32267j, this.f32485e);
        intent.putExtra(ax.f32262e, o());
        intent.putExtra(ax.J, R());
        intent.putExtra(ax.N, E());
        intent.putExtra(ax.O, G());
        if (this.F != null) {
            if (T() != null) {
                intent.putExtra("reward_key_nonwifi_action_play", this.F.Code(r1.Z()));
            }
            AppInfo v2 = v();
            if (v2 != null) {
                intent.putExtra("reward_key_nonwifi_action_download", this.F.Code(v2, v2.B()));
            }
        }
        Code(activity, intent);
        AppInfo v10 = v();
        if (v10 != null && !TextUtils.isEmpty(v10.e())) {
            intent.putExtra("unique_id", v10.e());
        }
        intent.setClipData(com.huawei.openalliance.ad.constant.u.cG);
        activity.startActivityForResult(intent, 1);
    }

    private void Code(Context context, Intent intent) {
        String r10 = this.Code.r();
        if (com.huawei.openalliance.ad.utils.v.B(context) && r10 != null && kt.F(r10)) {
            intent.addFlags(268959744);
            intent.putExtra(ax.ag, true);
        }
    }

    private VideoInfo T() {
        MetaData k10;
        if (this.B == null && (k10 = k()) != null) {
            this.B = k10.V();
        }
        return this.B;
    }

    private void V(Context context) {
        gl.V("RewardAd", "startRewardViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", D());
            jSONObject.put("sdk_version", "13.4.62.302");
            jSONObject.put(ax.f32264g, h_());
            jSONObject.put(ax.f32266i, this.f32484d);
            jSONObject.put(ax.f32267j, this.f32485e);
            jSONObject.put(ax.f32262e, o());
            jSONObject.put(ax.N, E());
            jSONObject.put(ax.J, R());
            jSONObject.put(ax.O, G());
            if (this.F != null) {
                if (T() != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.F.Code(r2.Z()));
                }
                AppInfo v2 = v();
                if (v2 != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.F.Code(v2, v2.B()));
                }
            }
            AppInfo v10 = v();
            if (v10 != null && !TextUtils.isEmpty(v10.e())) {
                jSONObject.put("unique_id", v10.e());
            }
            com.huawei.openalliance.ad.ipc.g.V(context).Code("showReward", jSONObject.toString(), null, null);
        } catch (JSONException e2) {
            gl.I("RewardAd", "startRewardViaAidl, e:" + e2.getClass().getSimpleName());
        }
    }

    private void V(Context context, com.huawei.openalliance.ad.inter.listeners.f fVar) {
        gl.V("RewardAd", "showAd");
        if (context == null) {
            return;
        }
        Code(fVar);
        ex.Code(context).Code();
        ev.Code(this);
        AppInfo v2 = v();
        if (v2 != null) {
            gl.Code("RewardAd", "appName:" + v2.L() + ", uniqueId:" + u() + ", appuniqueId:" + v2.e());
        }
        if (!(context instanceof Activity)) {
            V(context);
        } else {
            Code((Activity) context);
            ks.Code(context).V(context);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public RewardItem B() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public boolean C() {
        return this.D;
    }

    public void Code(int i10) {
        this.f32484d = i10;
    }

    public void Code(Activity activity, com.huawei.openalliance.ad.inter.listeners.f fVar) {
        V(activity, fVar);
    }

    public void Code(Context context, com.huawei.openalliance.ad.inter.listeners.f fVar) {
        V(context, fVar);
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.f fVar) {
        this.S = fVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.g gVar) {
        this.f32483c = gVar;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void Code(boolean z10) {
        this.D = z10;
    }

    public com.huawei.openalliance.ad.inter.listeners.g I() {
        return this.f32483c;
    }

    public com.huawei.openalliance.ad.inter.listeners.f Q() {
        return this.S;
    }

    public boolean R() {
        return this.f32486f;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void V(boolean z10) {
        this.C = z10;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.B = adContentData.p();
        }
        return this.B != null;
    }

    public void Z(boolean z10) {
        this.f32486f = z10;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean Z() {
        return this.C;
    }

    public void a_(boolean z10) {
        this.f32485e = z10;
    }
}
