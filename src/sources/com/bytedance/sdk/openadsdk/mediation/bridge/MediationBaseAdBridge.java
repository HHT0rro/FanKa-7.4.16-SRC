package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class MediationBaseAdBridge implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private MediationAdSlotValueSet f11293m;
    public Bridge mGMAd;

    public MediationBaseAdBridge(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
        this.mGMAd = bridge;
        this.f11293m = mediationAdSlotValueSet;
    }

    public double getCpm() {
        Bridge bridge = this.mGMAd;
        Double d10 = bridge != null ? (Double) bridge.call(8143, null, Double.class) : null;
        return d10 == null ? ShadowDrawableWrapper.COS_45 : d10.doubleValue();
    }

    public Map<String, Object> getCustomData() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getExtraObject();
        }
        return null;
    }

    public Object getGdtVideoOption() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getGdtVideoOption();
        }
        return null;
    }

    public int getOrientation() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getOrientation();
        }
        return 2;
    }

    public int getRewardAmount() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardAmount();
        }
        return 0;
    }

    public String getRewardName() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardName();
        }
        return null;
    }

    public MediationAdSlotValueSet getSlotValueSet() {
        return this.f11293m;
    }

    public String getUserID() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getUserId();
        }
        return null;
    }

    public float getVolume() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getVolume();
        }
        return 0.0f;
    }

    public abstract boolean hasDestroyed();

    public boolean isMuted() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f11293m;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isMuted();
        }
        return false;
    }

    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void onDestroy();

    public void setCpm(double d10) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8016, d10);
            this.mGMAd.call(8111, create.build(), Void.class);
        }
    }

    public void setCpmLevel(String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8058, str);
            this.mGMAd.call(8207, create.build(), Void.class);
        }
    }

    public void setExpress() {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8033, true);
            this.mGMAd.call(8129, create.build(), Void.class);
        }
    }

    public void setImageMode(int i10) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8060, i10);
            this.mGMAd.call(8209, create.build(), Void.class);
        }
    }

    public void setLevelTag(String str) {
        if (TextUtils.isEmpty(str) || this.mGMAd == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8058, str);
        this.mGMAd.call(8208, create.build(), Void.class);
    }

    public void setSlotValueSet(MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.f11293m = mediationAdSlotValueSet;
    }
}
