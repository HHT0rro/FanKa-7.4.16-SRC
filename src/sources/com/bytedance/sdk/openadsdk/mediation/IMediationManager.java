package com.bytedance.sdk.openadsdk.mediation;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IMediationManager {
    Map<String, Object> getMediationExtraInfo();

    void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback);

    void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback);

    Object mtool(int i10, ValueSet valueSet);

    void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i10, int i11);

    void requestPermissionIfNecessary(Context context);

    void requestPermissionIfNecessary(Context context, int[] iArr);

    void setPulisherDid(String str);

    void setThemeStatus(int i10);

    void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment);

    int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener);

    void updatePrivacyConfig(TTCustomController tTCustomController);
}
