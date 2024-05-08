package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class gb extends af {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements IInterstitialAdStatusListener {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.f29024b));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.F));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.f29023a));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i10, int i11) {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.L));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            af.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ag.D));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
        }
    }

    public gb() {
        super(ai.f29033i);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.gb.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    af.Code(remoteCallResultCallback, gb.this.Code, 3002, null, true);
                    gl.Code("JsbStartInterstitialAdActivity", "adContentData is null, start activity failed");
                    return;
                }
                com.huawei.hms.ads.inter.data.a aVar = new com.huawei.hms.ads.inter.data.a(adContentData);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32245t);
                    String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32242q);
                    if (!TextUtils.isEmpty(optString)) {
                        aVar.Code(optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        aVar.V(optString2);
                    }
                } catch (Throwable unused) {
                    gl.I("JsbStartInterstitialAdActivity", "content parse error");
                }
                aVar.show(gb.this.Code(context), new a(remoteCallResultCallback, gb.this.Code));
                gb.this.V(remoteCallResultCallback, false);
            }
        });
    }
}
