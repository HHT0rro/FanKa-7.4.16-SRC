package com.bytedance.sdk.openadsdk.mediation.bridge.native_ad;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationNativeAd implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private MediationAdLoaderImpl f11317m;
    public Bridge mGMAd;

    public MediationNativeAd(MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge) {
        this.f11317m = mediationAdLoaderImpl;
        this.mGMAd = bridge;
        m();
    }

    private void m() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8035, this);
        this.mGMAd.call(8128, create.build(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public String getAdm() {
        MediationAdLoaderImpl mediationAdLoaderImpl = this.f11317m;
        return mediationAdLoaderImpl != null ? mediationAdLoaderImpl.getAdm() : "";
    }

    public double getCpm() {
        Bridge bridge = this.mGMAd;
        return bridge != null ? ((Double) bridge.call(8143, null, Double.class)).doubleValue() : ShadowDrawableWrapper.COS_45;
    }

    public int getImageMode() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Integer) bridge.call(6069, null, Integer.class)).intValue();
        }
        return 0;
    }

    public boolean isClientBidding() {
        return this.f11317m.isClientBidding();
    }

    public boolean isExpress() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Boolean) bridge.call(8196, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isMultiBidding() {
        return this.f11317m.isMultiBidding();
    }

    public boolean isServerBidding() {
        return this.f11317m.isServerBidding();
    }

    public boolean isUseCustomVideo() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Boolean) bridge.call(8160, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public void notifyDislikeClick(String str, Map map) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8036, str);
            create.add(8037, map);
            this.mGMAd.call(8131, create.build(), Void.class);
        }
    }

    public void notifyDislikeOnCancel() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8184, null, Void.class);
        }
    }

    public void notifyDislikeOnShow() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8185, null, Void.class);
        }
    }

    public void notifyDislikeSelect(int i10, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8038, i10);
            create.add(8039, str);
            this.mGMAd.call(8132, create.build(), Void.class);
        }
    }

    public void notifyNativeValue(ValueSet valueSet) {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8140, valueSet, Void.class);
        }
    }

    public void notifyOnClickAd() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8130, null, Void.class);
        }
    }

    public void notifyOnDownloadFailed(long j10, long j11, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8063, j11);
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8157, create.build(), Void.class);
        }
    }

    public void notifyOnDownloadFinished(long j10, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8155, create.build(), Void.class);
        }
    }

    public void notifyOnDownloadPause(long j10, long j11, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8063, j11);
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8158, create.build(), Void.class);
        }
    }

    public void notifyOnDownloadStarted() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8153, null, Void.class);
        }
    }

    public void notifyOnIdel() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8152, null, Void.class);
        }
    }

    public void notifyOnInstalled(String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8156, create.build(), Void.class);
        }
    }

    public void notifyOnProgressUpdate(long j10, long j11, int i10, int i11) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8063, j11);
            create.add(8064, i10);
            create.add(8065, i11);
            this.mGMAd.call(8187, create.build(), Void.class);
        }
    }

    public void notifyOnShowAd() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8113, null, Void.class);
        }
    }

    public void notifyOnVideoComplete() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8118, null, Void.class);
        }
    }

    public void notifyOnVideoError(int i10, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8014, i10);
            create.add(8015, str);
            this.mGMAd.call(8117, create.build(), Void.class);
        }
    }

    public void notifyOnVideoPause() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8146, null, Void.class);
        }
    }

    public void notifyOnVideoResume() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8150, null, Void.class);
        }
    }

    public void notifyOnVideoStart() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8145, null, Void.class);
        }
    }

    public void notifyRenderFail(View view, int i10, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8042, view);
            create.add(8014, i10);
            create.add(8015, str);
            this.mGMAd.call(8134, create.build(), Void.class);
        }
    }

    public void notifyRenderSuccess(float f10, float f11) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8040, f10);
            create.add(8041, f11);
            this.mGMAd.call(8133, create.build(), Void.class);
        }
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void shakeViewDismissed() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8197, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
