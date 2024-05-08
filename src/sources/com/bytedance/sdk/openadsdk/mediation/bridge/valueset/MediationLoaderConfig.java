package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationLoaderConfig {

    /* renamed from: m, reason: collision with root package name */
    private final ValueSet f11322m;

    private MediationLoaderConfig(ValueSet valueSet) {
        this.f11322m = valueSet;
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean m() {
        ValueSet valueSet = this.f11322m;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getADNName() {
        return m() ? this.f11322m.stringValue(8003) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (m()) {
            return (ValueSet) this.f11322m.objectValue(8548, ValueSet.class);
        }
        return null;
    }

    public int getAdType() {
        if (m()) {
            return this.f11322m.intValue(8008);
        }
        return 0;
    }

    public String getClassName() {
        return m() ? this.f11322m.stringValue(8010) : "";
    }

    public Context getContext() {
        if (m()) {
            return (Context) this.f11322m.objectValue(8009, Context.class);
        }
        return null;
    }

    public Bridge getGMCustomAdLoader() {
        if (m()) {
            return (Bridge) this.f11322m.objectValue(8011, Bridge.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (m()) {
            return (ValueSet) this.f11322m.objectValue(8546, ValueSet.class);
        }
        return null;
    }
}
