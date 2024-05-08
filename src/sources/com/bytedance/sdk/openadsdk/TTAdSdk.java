package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCodeGroupRit;
import com.bytedance.sdk.openadsdk.api.ej;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.api.plugin.np;
import com.bytedance.sdk.openadsdk.live.dk;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import com.huawei.hms.ml.scan.HmsScanResult;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TTAdSdk {
    public static final String BRANCH = "v5600-csjm";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle.m";
    public static final String C_H = "c8ac979";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = false;
    public static final boolean IS_P = true;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final int SDK_VERSION_CODE = 5603;
    public static final String SDK_VERSION_NAME = "5.6.0.3";
    public static final String S_C = "main";
    private static TTAdConfig dk;

    /* renamed from: m, reason: collision with root package name */
    private static final m f11068m = new np();
    private static long ej = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface Callback extends InitCallback {
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InitCallback {
        void fail(int i10, String str);

        void success();
    }

    public static TTAdManager getAdManager() {
        m mVar = f11068m;
        if (mVar != null) {
            return mVar.dk();
        }
        return null;
    }

    public static void getCodeGroupRit(final long j10, final TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
        m mVar = f11068m;
        if (mVar != null) {
            mVar.dk().register(new CodeGroupRitObject() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.1
                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public long getCodeGroupId() {
                    return j10;
                }

                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public TTCodeGroupRit.TTCodeGroupRitListener getListener() {
                    return tTCodeGroupRitListener;
                }
            });
        } else if (tTCodeGroupRitListener != null) {
            tTCodeGroupRitListener.onFail(HmsScanResult.SCAN_UNDEREXPOSED, "please init sdk first!");
        }
    }

    public static IMediationManager getMediationManager() {
        if (f11068m != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    @Deprecated
    public static void init(Context context, TTAdConfig tTAdConfig, InitCallback initCallback) {
        Context applicationContext = context.getApplicationContext();
        m(context, tTAdConfig);
        ej.m("为避免收入损失，请在 23 年 9 月前切换为新 start 接口，该接口将在5700版本正式停用！！！");
        m mVar = f11068m;
        if (mVar == null) {
            initCallback.fail(HmsScanResult.SCAN_UNDEREXPOSED, "Load initializer failed");
        } else {
            mVar.m(applicationContext, tTAdConfig, initCallback);
        }
    }

    public static boolean isInitSuccess() {
        m mVar = f11068m;
        if (mVar != null) {
            return mVar.m();
        }
        return false;
    }

    public static boolean isOnePointFiveAdType(TTNativeExpressAd tTNativeExpressAd) {
        Map<String, Object> mediaExtraInfo;
        if (tTNativeExpressAd == null) {
            mediaExtraInfo = null;
        } else {
            try {
                mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mediaExtraInfo == null || !mediaExtraInfo.containsKey("_tt_ad_type_onepointfive")) {
            return false;
        }
        return ((Boolean) mediaExtraInfo.get("_tt_ad_type_onepointfive")).booleanValue();
    }

    private static void m(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            ej.m();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            ej.m("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        m(context, "Context is null, please check.");
        m(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static void start(Callback callback) {
        m(dk, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        if (SystemClock.elapsedRealtime() - ej > 300) {
            ej.m("请尽可能在 TTAdSdk.init(初始化）之后尽快调用 TTAdSdk.start 方法，建议间隔时间不超过300ms，以避免广告加载时长过长造成损失");
        }
        m mVar = f11068m;
        if (mVar == null) {
            callback.fail(HmsScanResult.SCAN_UNDEREXPOSED, "Load initializer failed");
        } else {
            mVar.m(TTAppContextHolder.getContext(), dk, callback);
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        m.ej dk2;
        if (tTAdConfig == null || (dk2 = f11068m.dk()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (bundle.keySet().isEmpty()) {
            return;
        }
        dk2.getExtra(ValueSet.class, bundle);
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            return;
        }
        dk.m().m(tTAdConfig.getInjectionAuth());
    }

    public static void updatePaid(boolean z10) {
        m.ej dk2 = f11068m.dk();
        if (dk2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z10);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        dk2.getExtra(ValueSet.class, bundle);
    }

    public static void init(Context context, TTAdConfig tTAdConfig) {
        dk = tTAdConfig;
        m(context, tTAdConfig);
        ej = SystemClock.elapsedRealtime();
    }

    private static void m(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
