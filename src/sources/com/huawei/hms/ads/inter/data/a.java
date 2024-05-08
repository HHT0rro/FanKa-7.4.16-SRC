package com.huawei.hms.ads.inter.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.d;
import com.huawei.hms.ads.e;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.ks;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.v;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends com.huawei.openalliance.ad.inter.data.a implements IInterstitialAd {
    private transient INonwifiActionListener B;
    private RewardAdListener C;
    private List<ImageInfo> F;
    private VideoInfo S;
    private transient IInterstitialAdStatusListener Z;

    public a(AdContentData adContentData) {
        super(adContentData);
    }

    private void Code(Activity activity) {
        gl.V("InnerInterstitialAd", "startInterstitialViaActivity");
        Intent intent = new Intent();
        intent.setAction(u.aj);
        intent.setPackage(v.Z(activity));
        intent.putExtra("content_id", D());
        intent.putExtra("sdk_version", "13.4.62.302");
        intent.putExtra(ax.f32264g, h_());
        intent.putExtra(ax.f32262e, o());
        intent.putExtra(ax.N, E());
        intent.putExtra(ax.O, G());
        if (this.B != null) {
            if (Q() != null) {
                intent.putExtra("reward_key_nonwifi_action_play", this.B.Code(r1.Z()));
            }
            AppInfo v2 = v();
            if (v2 != null) {
                intent.putExtra("reward_key_nonwifi_action_download", this.B.Code(v2, v2.B()));
            }
        }
        AppInfo v10 = v();
        if (v10 != null && !TextUtils.isEmpty(v10.e())) {
            intent.putExtra("unique_id", v10.e());
        }
        intent.setClipData(u.cG);
        activity.startActivityForResult(intent, 1);
    }

    private void Code(IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        this.Z = iInterstitialAdStatusListener;
    }

    private VideoInfo Q() {
        MetaData k10;
        if (this.S == null && (k10 = k()) != null) {
            this.S = k10.V();
        }
        return this.S;
    }

    private void V(Context context) {
        gl.V("InnerInterstitialAd", "startInterstitialViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", D());
            jSONObject.put("sdk_version", "13.4.62.302");
            jSONObject.put(ax.f32264g, h_());
            jSONObject.put(ax.f32262e, o());
            jSONObject.put(ax.N, E());
            jSONObject.put(ax.O, G());
            if (this.B != null) {
                if (Q() != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.B.Code(r2.Z()));
                }
                AppInfo v2 = v();
                if (v2 != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.B.Code(v2, v2.B()));
                }
            }
            AppInfo v10 = v();
            if (v10 != null && !TextUtils.isEmpty(v10.e())) {
                jSONObject.put("unique_id", v10.e());
            }
            g.V(context).Code("interstitial_ad_show", jSONObject.toString(), null, null);
        } catch (JSONException e2) {
            gl.I("InnerInterstitialAd", "startInterstitialViaAidl, e:" + e2.getClass().getSimpleName());
        }
    }

    public RewardAdListener Code() {
        return this.C;
    }

    public IInterstitialAdStatusListener I() {
        return this.Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.S = adContentData.p();
            MetaData Z = this.Code.Z();
            if (Z != null) {
                this.F = Z.b();
            }
            if (this.Code.h() == 9) {
                return this.S != null;
            }
            if (this.Code.h() == 2 || this.Code.h() == 4) {
                return !aa.Code(this.F);
            }
        }
        return false;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener) {
        this.B = iNonwifiActionListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.C = rewardAdListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void show(Context context, IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        if (context == null) {
            return;
        }
        V(true);
        Code(iInterstitialAdStatusListener);
        d.Code(context).Code();
        e.Code(this);
        AppInfo v2 = v();
        if (v2 != null) {
            gl.Code("InnerInterstitialAd", "appName:" + v2.L() + ", uniqueId:" + u() + ", appuniqueId:" + v2.e());
        }
        if (!(context instanceof Activity)) {
            V(context);
        } else {
            Code((Activity) context);
            ks.Code(context).V(context);
        }
    }
}
