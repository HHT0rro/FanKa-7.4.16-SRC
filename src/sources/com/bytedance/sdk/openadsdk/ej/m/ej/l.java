package com.bytedance.sdk.openadsdk.ej.m.ej;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l {
    public static final ValueSet m(final TTCustomController tTCustomController) {
        a b4 = a.b();
        if (tTCustomController == null) {
            return null;
        }
        b4.h(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseLocation());
            }
        });
        b4.h(262102, new ValueSet.ValueGetter<ValueSet>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public ValueSet get() {
                return ej.m(TTCustomController.this.getTTLocation());
            }
        });
        b4.h(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.alist());
            }
        });
        b4.h(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePhoneState());
            }
        });
        b4.h(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public String get() {
                return TTCustomController.this.getDevImei();
            }
        });
        b4.h(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWifiState());
            }
        });
        b4.h(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public String get() {
                return TTCustomController.this.getMacAddress();
            }
        });
        b4.h(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWriteExternal());
            }
        });
        b4.h(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public String get() {
                return TTCustomController.this.getDevOaid();
            }
        });
        b4.h(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseAndroidId());
            }
        });
        b4.h(262113, tTCustomController.getMediationPrivacyConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.m.m.m.dk.m(tTCustomController.getMediationPrivacyConfig()) : null);
        b4.h(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public String get() {
                return TTCustomController.this.getAndroidId();
            }
        });
        b4.h(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.l.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePermissionRecordAudio());
            }
        });
        return b4.a();
    }
}
