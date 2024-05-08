package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hag.abilitykit.api.KitSdkManager;
import com.huawei.hag.abilitykit.dispatch.callback.StartAbilityCallBack;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.hms.ads.le;
import com.huawei.openalliance.ad.constant.ae;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.uriaction.RequestMsgBuilder;
import com.huawei.openalliance.ad.utils.z;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e extends q {
    private static final String Code = "FeatureAbilityAction";

    public e(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        try {
            gl.V(Code, "handle Feature ability action");
            if (!com.huawei.openalliance.ad.utils.q.V()) {
                gl.V(Code, "UnSupport HAG!");
                return V();
            }
            AdContentData adContentData = this.Z;
            if (adContentData != null && !TextUtils.isEmpty(adContentData.aB())) {
                gl.Code(Code, "AbilityDetailInfo is %s", this.Z.aB());
                gl.Code(Code, "HwChannelID is %s", this.Z.aC());
                PPSAbilityDataContent pPSAbilityDataContent = (PPSAbilityDataContent) z.V(this.Z.aB(), PPSAbilityDataContent.class, new Class[0]);
                if (pPSAbilityDataContent == null) {
                    gl.V(Code, "abilityDataContent is not json!");
                    return V();
                }
                pPSAbilityDataContent.Code(new FaParams(this.I.getPackageName(), this.Z.aC()).I());
                KitSdkManager.getInstance().startAbilityByAbilityInfo(this.I, z.V(new RequestMsgBuilder.a().Code(this.I.getPackageName()).V(u.cB).Code(pPSAbilityDataContent).Code()), new StartAbilityCallBack() { // from class: com.huawei.openalliance.ad.uriaction.e.1
                    public void onFailed(int i10, String str) {
                        gl.V(e.Code, "start ability failed, retErrCode is %s, errMsg is %s", Integer.valueOf(i10), str);
                        e eVar = e.this;
                        kv.Code(eVar.I, eVar.Z, ae.f32217d, (Integer) 1, Integer.valueOf(i10));
                        le leVar = e.this.B;
                        if (leVar != null) {
                            leVar.Code(-1);
                        }
                        e.this.V();
                    }

                    public void onSuccess(int i10) {
                        gl.V(e.Code, "start ability success, retCode is %s", Integer.valueOf(i10));
                        e eVar = e.this;
                        kv.Code(eVar.I, eVar.Z, ae.f32216c, (Integer) 1, (Integer) null);
                    }
                });
                Code(t.I);
                return true;
            }
            gl.V(Code, "parameters is empty!");
            return V();
        } catch (Throwable th) {
            gl.I(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            return V();
        }
    }
}
