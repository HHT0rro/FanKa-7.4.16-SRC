package com.bytedance.sdk.openadsdk.mediation.init.m.m.m;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk {
    public static final ValueSet m(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        a b4 = a.b();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        b4.h(262114, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.m.m.m.dk.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomAppList();
            }
        });
        b4.h(262115, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.m.m.m.dk.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomDevImeis();
            }
        });
        b4.h(262116, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.m.m.m.dk.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isCanUseOaid());
            }
        });
        b4.h(262117, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.m.m.m.dk.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isLimitPersonalAds());
            }
        });
        b4.h(262118, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.m.m.m.dk.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isProgrammaticRecommend());
            }
        });
        return b4.a();
    }
}
