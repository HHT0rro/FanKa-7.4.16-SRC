package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationInitCLassLoader implements Bridge {
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        Class<?> cls2;
        if (i10 == 8100) {
            MediationInitConfig create = MediationInitConfig.create(valueSet);
            try {
                if (create.isCustom() && create.getCustomInitConfigValueSet() != null) {
                    cls2 = Class.forName(create.getCustomInitConfigValueSet().stringValue(8536));
                } else {
                    cls2 = Class.forName(create.getClassName());
                }
                Object newInstance = cls2.newInstance();
                if (newInstance instanceof Bridge) {
                    MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                    create2.add(8009, TTAppContextHolder.getContext());
                    create2.add(8424, valueSet);
                    ((Bridge) newInstance).call(8240, create2.build(), null);
                }
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InstantiationException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
