package com.kwad.sdk.api.core;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;

@KsAdSdkDynamicApi("com.kwad.sdk.KsAdSDKImpl")
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IKsAdSDK {
    @Keep
    void addHp(@NonNull Map<String, String> map);

    @Keep
    Object dM(String str, Object... objArr);

    @KsAdSdkDynamicApi
    @Keep
    void deleteCache();

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    KsLoadManager getAdManager();

    @KsAdSdkDynamicApi
    @Keep
    String getApiVersion();

    @KsAdSdkDynamicApi
    @Keep
    int getApiVersionCode();

    @KsAdSdkDynamicApi
    @Keep
    String getAppId();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getAppInfo();

    @KsAdSdkDynamicApi
    @Keep
    String getAppName();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Context getContext();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getDeviceInfo();

    @KsAdSdkDynamicApi
    @Keep
    String getDid();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getNetworkInfo();

    @Keep
    String getRD(String str);

    @Keep
    String getRM(String str);

    @KsAdSdkDynamicApi
    @Keep
    int getSDKType();

    @KsAdSdkDynamicApi
    @Keep
    String getSDKVersion();

    @KsAdSdkDynamicApi
    @Keep
    int getSDKVersionCode();

    @KsAdSdkDynamicApi
    @Keep
    void init(Context context, SdkConfig sdkConfig);

    @KsAdSdkDynamicApi
    @Keep
    boolean isDebugLogEnable();

    @KsAdSdkDynamicApi
    @Keep
    <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj);

    @KsAdSdkDynamicApi
    @Keep
    <T> T newInstance(Class<T> cls);

    @KsAdSdkDynamicApi
    @Keep
    void pauseCurrentPlayer();

    @Keep
    void re(Object obj);

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    void reportBatchEvent(int i10, Map<String, Object> map);

    @KsAdSdkDynamicApi
    @Keep
    void resumeCurrentPlayer();

    @Keep
    void sR(String str, Map<String, String> map, String str2);

    @KsAdSdkApi
    @Keep
    void setAdxEnable(boolean z10);

    @KsAdSdkDynamicApi
    @Keep
    void setApiVersion(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setApiVersionCode(int i10);

    @KsAdSdkDynamicApi
    @Keep
    void setAppTag(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setIsExternal(boolean z10);

    @KsAdSdkDynamicApi
    @Keep
    void setLaunchTime(long j10);

    @KsAdSdkDynamicApi
    @Keep
    void setLoadingLottieAnimation(boolean z10, @RawRes int i10);

    @KsAdSdkDynamicApi
    @Keep
    void setLoadingLottieAnimationColor(boolean z10, @ColorInt int i10);

    @KsAdSdkDynamicApi
    @Keep
    void setPersonalRecommend(boolean z10);

    @KsAdSdkDynamicApi
    @Keep
    void setProgrammaticRecommend(boolean z10);

    @KsAdSdkDynamicApi
    @Keep
    void setThemeMode(int i10);

    @KsAdSdkDynamicApi
    @Keep
    void unInit();
}
