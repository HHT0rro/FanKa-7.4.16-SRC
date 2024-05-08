package com.alibaba.security.cloud;

import android.content.Context;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.realidentity.ALRealIdentityCallback;
import com.alibaba.security.realidentity.ALRealIdentityCallbackExt;
import com.alibaba.security.realidentity.ALRealIdentityResult;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CloudRealIdentityTrigger {

    /* renamed from: a, reason: collision with root package name */
    private static ALBiometricsConfig f2909a;

    private static RPEventListener a(final ALRealIdentityCallback aLRealIdentityCallback) {
        return new RPEventListener() { // from class: com.alibaba.security.cloud.CloudRealIdentityTrigger.1
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsFinish(int i10) {
                ALRealIdentityCallback aLRealIdentityCallback2 = ALRealIdentityCallback.this;
                if (aLRealIdentityCallback2 == null || !(aLRealIdentityCallback2 instanceof ALRealIdentityCallbackExt)) {
                    return;
                }
                ((ALRealIdentityCallbackExt) aLRealIdentityCallback2).onBiometricsStop(i10 == 0);
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsStart() {
                ALRealIdentityCallback aLRealIdentityCallback2 = ALRealIdentityCallback.this;
                if (aLRealIdentityCallback2 == null || !(aLRealIdentityCallback2 instanceof ALRealIdentityCallbackExt)) {
                    return;
                }
                ((ALRealIdentityCallbackExt) aLRealIdentityCallback2).onBiometricsStart();
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str, String str2) {
                ALRealIdentityCallback aLRealIdentityCallback2 = ALRealIdentityCallback.this;
                if (aLRealIdentityCallback2 != null) {
                    aLRealIdentityCallback2.onAuditResult(CloudRealIdentityTrigger.a(rPResult), str);
                }
            }
        };
    }

    private static ALRealIdentityResult b(RPResult rPResult) {
        if (rPResult == RPResult.AUDIT_FAIL) {
            return ALRealIdentityResult.AUDIT_FAIL;
        }
        if (rPResult == RPResult.AUDIT_PASS) {
            return ALRealIdentityResult.AUDIT_PASS;
        }
        if (rPResult == RPResult.AUDIT_IN_AUDIT) {
            return ALRealIdentityResult.AUDIT_IN_AUDIT;
        }
        if (rPResult == RPResult.AUDIT_EXCEPTION) {
            return ALRealIdentityResult.AUDIT_EXCEPTION;
        }
        return ALRealIdentityResult.AUDIT_NOT;
    }

    @Deprecated
    public static void initialize(Context context) {
        initialize(context, false, null);
    }

    @Deprecated
    public static void start(Context context, String str, ALRealIdentityCallback aLRealIdentityCallback) {
        RPVerify.start(context, str, a(f2909a), a(aLRealIdentityCallback));
    }

    @Deprecated
    public static void startVerifyByNative(Context context, String str, ALRealIdentityCallback aLRealIdentityCallback) {
        RPVerify.startByNative(context, str, a(f2909a), a(aLRealIdentityCallback));
    }

    @Deprecated
    public static void startVerifyWithUrl(Context context, String str, ALRealIdentityCallback aLRealIdentityCallback) {
        RPVerify.startWithUrl(context, str, a(f2909a), a(aLRealIdentityCallback));
    }

    private static RPConfig a(ALBiometricsConfig aLBiometricsConfig) {
        if (aLBiometricsConfig == null) {
            return null;
        }
        RPConfig.Builder builder = new RPConfig.Builder();
        builder.setTransitionMode(aLBiometricsConfig.getTransitionMode());
        builder.setNeedSound(aLBiometricsConfig.isNeedSound());
        builder.setNeedFailResultPage(aLBiometricsConfig.isNeedFailResultPage());
        return builder.build();
    }

    @Deprecated
    public static void initialize(Context context, ALBiometricsConfig aLBiometricsConfig) {
        initialize(context, false, aLBiometricsConfig);
    }

    @Deprecated
    public static void initialize(Context context, boolean z10) {
        initialize(context, z10, null);
    }

    @Deprecated
    public static void initialize(Context context, boolean z10, ALBiometricsConfig aLBiometricsConfig) {
        f2909a = aLBiometricsConfig;
        RPVerify.init(context, z10);
    }

    public static /* synthetic */ ALRealIdentityResult a(RPResult rPResult) {
        if (rPResult == RPResult.AUDIT_FAIL) {
            return ALRealIdentityResult.AUDIT_FAIL;
        }
        if (rPResult == RPResult.AUDIT_PASS) {
            return ALRealIdentityResult.AUDIT_PASS;
        }
        if (rPResult == RPResult.AUDIT_IN_AUDIT) {
            return ALRealIdentityResult.AUDIT_IN_AUDIT;
        }
        if (rPResult == RPResult.AUDIT_EXCEPTION) {
            return ALRealIdentityResult.AUDIT_EXCEPTION;
        }
        return ALRealIdentityResult.AUDIT_NOT;
    }
}
