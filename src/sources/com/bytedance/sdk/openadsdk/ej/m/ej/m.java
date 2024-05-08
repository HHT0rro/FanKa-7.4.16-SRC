package com.bytedance.sdk.openadsdk.ej.m.ej;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m {
    public static final ValueSet m(final AdConfig adConfig) {
        a b4 = a.b();
        if (adConfig == null) {
            return null;
        }
        b4.i(261001, adConfig.getAppId());
        b4.i(261002, adConfig.getAppName());
        b4.j(261003, adConfig.isPaid());
        b4.i(261004, adConfig.getKeywords());
        b4.i(261005, adConfig.getData());
        b4.f(261006, adConfig.getTitleBarTheme());
        b4.j(261007, adConfig.isAllowShowNotify());
        b4.j(261008, adConfig.isDebug());
        b4.h(261009, adConfig.getDirectDownloadNetworkType());
        b4.j(261010, adConfig.isUseTextureView());
        b4.j(261011, adConfig.isSupportMultiProcess());
        b4.h(261012, adConfig.getCustomController() != null ? l.m(adConfig.getCustomController()) : null);
        b4.h(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.m.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        b4.h(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.m.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        b4.h(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.m.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        b4.h(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.m.m.m.m.m(adConfig.getMediationConfig()) : null);
        b4.j(261017, adConfig.isUseMediation());
        return b4.a();
    }
}
