package com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class MediationCustomRewardVideoLoader extends MediationCustomAdBaseLoader {
    public final void callAdVideoCache() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(8112, null, String.class);
        }
    }

    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            this.mGmAdLoader.call(8107, MediationValueSetBuilder.create().build(), String.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 != 8113) {
            if (i10 != 8121) {
                return null;
            }
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader isReadyCondition");
            return (T) isReadyCondition();
        }
        MediationApiLog.i("TTMediationSDK", "MediationCustomRewardVideoLoader showAd");
        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
        if (activity == null) {
            return null;
        }
        showAd(activity);
        return null;
    }

    public final void callRewardVideoAdClick() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1009, null, String.class);
        }
    }

    public final void callRewardVideoAdClosed() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1014, null, String.class);
        }
    }

    public final void callRewardVideoAdShow() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1008, null, String.class);
        }
    }

    public final void callRewardVideoComplete() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1026, null, String.class);
        }
    }

    public final void callRewardVideoError() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1021, null, String.class);
        }
    }

    public final void callRewardVideoRewardVerify(MediationRewardItem mediationRewardItem) {
        if (this.mGmAdLoader == null || mediationRewardItem == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8017, mediationRewardItem.rewardVerify());
        create.add(8018, mediationRewardItem.getAmount());
        create.add(8019, mediationRewardItem.getRewardName());
        create.add(8075, mediationRewardItem.getCustomData());
        this.mGmAdLoader.call(1018, create.build(), String.class);
    }

    public final void callRewardVideoSkippedVideo() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(DownloadErrorCode.ERROR_TARGET_FILE_DELETE_FAILED, null, String.class);
        }
    }

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void showAd(Activity activity);

    public final void callLoadSuccess(double d10) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8409, d10);
            this.mGmAdLoader.call(8107, create.build(), String.class);
        }
    }

    public final void callLoadSuccess(Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8075, map);
            this.mGmAdLoader.call(8107, create.build(), String.class);
        }
    }

    public final void callLoadSuccess(double d10, Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8409, d10);
            create.add(8075, map);
            this.mGmAdLoader.call(8107, create.build(), String.class);
        }
    }
}
