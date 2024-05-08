package com.bytedance.sdk.openadsdk.mediation.m.m.m;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.ej.m.m.w;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.mediation.m.m.dk.np;
import java.util.List;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements IMediationManager {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11380m;

    public dk(Bridge bridge) {
        this.f11380m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        return (Map) this.f11380m.call(270024, a.c(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        a c4 = a.c(3);
        c4.h(0, context);
        c4.h(1, adSlot);
        c4.h(2, new com.bytedance.sdk.openadsdk.mediation.m.m.dk.m(iMediationDrawAdTokenCallback));
        this.f11380m.call(270022, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        a c4 = a.c(3);
        c4.h(0, context);
        c4.h(1, adSlot);
        c4.h(2, new com.bytedance.sdk.openadsdk.mediation.m.m.dk.ej(iMediationNativeAdTokenCallback));
        this.f11380m.call(270021, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i10, ValueSet valueSet) {
        a c4 = a.c(2);
        c4.f(0, i10);
        c4.h(1, valueSet);
        return this.f11380m.call(271043, c4.a(), Object.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i10, int i11) {
        a c4 = a.c(4);
        c4.h(0, activity);
        c4.h(1, list);
        c4.f(2, i10);
        c4.f(3, i11);
        this.f11380m.call(270013, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        a c4 = a.c(1);
        c4.h(0, context);
        this.f11380m.call(270017, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        a c4 = a.c(1);
        c4.i(0, str);
        this.f11380m.call(270015, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i10) {
        a c4 = a.c(1);
        c4.f(0, i10);
        this.f11380m.call(270019, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        a c4 = a.c(1);
        c4.h(0, mediationConfigUserInfoForSegment);
        this.f11380m.call(270014, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        a c4 = a.c(1);
        c4.h(0, new np(mediationAppDialogClickListener));
        return ((Integer) this.f11380m.call(270020, c4.a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        a c4 = a.c(1);
        c4.h(0, new w(tTCustomController));
        this.f11380m.call(270016, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        a c4 = a.c(2);
        c4.h(0, context);
        c4.h(1, iArr);
        this.f11380m.call(270018, c4.a(), Void.class);
    }
}
