package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class MediationCustomInitLoader implements IMediationInit {

    /* renamed from: m, reason: collision with root package name */
    private Bridge f11300m;

    private void m() {
        if (this.f11300m != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8402, this);
            this.f11300m.call(8216, create.build(), String.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 8240) {
            initAdn((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else {
            if (i10 == 8139) {
                return (T) getBiddingToken((Context) valueSet.objectValue(8009, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i10 == 8217) {
                return (T) getSdkInfo((Context) valueSet.objectValue(8009, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i10 == 8218) {
                return (T) getNetworkSdkVersion();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public final void callInitSuccess() {
        Bridge bridge = this.f11300m;
        if (bridge != null) {
            bridge.call(8219, null, String.class);
        }
    }

    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract String getNetworkSdkVersion();

    public String getSdkInfo(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit
    public final void initAdn(Context context, ValueSet valueSet) {
        MediationInitConfig create = MediationInitConfig.create(valueSet);
        initInnerADN(context, new MediationCustomInitConfig(create.getCustomInitConfigValueSet()), create.getCustomInitMap(), create.getCustomGMConfiguration());
    }

    public final void initInnerADN(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map, Bridge bridge) {
        this.f11300m = bridge;
        m();
        try {
            initializeADN(context, mediationCustomInitConfig, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract void initializeADN(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map);

    public final boolean isInit() {
        Bridge bridge = this.f11300m;
        if (bridge != null) {
            return ((Boolean) bridge.call(8220, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
