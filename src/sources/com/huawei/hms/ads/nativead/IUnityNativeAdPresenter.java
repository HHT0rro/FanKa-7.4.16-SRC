package com.huawei.hms.ads.nativead;

import com.huawei.hms.ads.annotation.AllApi;
import java.util.List;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IUnityNativeAdPresenter {
    int getMinEffectiveShowRatio();

    long getMinEffectiveShowTime();

    boolean onUnityAdClick();

    void onUnityAdClose(List<String> list);

    void onUnityAdPhyShow(long j10, int i10);

    void onUnityAdShow(Long l10, Integer num, Integer num2);

    void onUnityAdShowStart();

    void onUnityGoWhyShowThis();

    void updateContent();
}
