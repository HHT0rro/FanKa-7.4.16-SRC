package com.bytedance.sdk.openadsdk.mediation.init;

import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IMediationPrivacyConfig {
    @Nullable
    List<String> getCustomAppList();

    @Nullable
    List<String> getCustomDevImeis();

    boolean isCanUseOaid();

    boolean isLimitPersonalAds();

    boolean isProgrammaticRecommend();
}
