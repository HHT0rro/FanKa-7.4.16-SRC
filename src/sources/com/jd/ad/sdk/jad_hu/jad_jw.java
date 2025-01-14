package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.logger.Logger;

/* compiled from: DynamicRenderView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_jw extends ShakeListener {
    public final /* synthetic */ DynamicRenderView jad_pc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_jw(DynamicRenderView dynamicRenderView, Context context, float f10, float f11, float f12) {
        super(context, f10, f11, f12);
        this.jad_pc = dynamicRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        Logger.d("==== 摇一摇");
        DynamicRenderView dynamicRenderView = this.jad_pc;
        jad_an jad_anVar = dynamicRenderView.jad_wj.get(dynamicRenderView.jad_xk);
        if (jad_anVar != null) {
            DynamicRenderView dynamicRenderView2 = this.jad_pc;
            float f10 = dynamicRenderView2.jad_ju;
            float f11 = dynamicRenderView2.jad_lw;
            float f12 = dynamicRenderView2.jad_mx;
            CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
            int ordinal = adTriggerSourceType.ordinal();
            if (f12 > 0.0f) {
                if (f10 > 0.0f && f11 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
                } else if (f10 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
                } else if (f11 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal();
                }
            } else if (f10 > 0.0f && f11 > 0.0f) {
                ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
            } else if (f10 > 0.0f) {
                ordinal = adTriggerSourceType.ordinal();
            } else if (f11 > 0.0f) {
                ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal();
            }
            jad_anVar.jad_dq = ordinal;
            jad_anVar.jad_an(this.jad_pc.jad_sf);
        }
    }
}
