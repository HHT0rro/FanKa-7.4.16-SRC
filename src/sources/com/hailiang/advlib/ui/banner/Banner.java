package com.hailiang.advlib.ui.banner;

import androidx.annotation.Keep;
import com.hailiang.advlib.core.ICliBundle;
import com.hailiang.advlib.core.ICliUtils;
import com.hailiang.advlib.core.IMultiAdObject;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Banner {
    void OnBannerInit();

    void UpdateView(ICliBundle iCliBundle);

    void setADStateListener(IMultiAdObject.ADStateListener aDStateListener);

    void setPageUniqueId(int i10);

    void setStateListener(ICliUtils.BannerStateListener bannerStateListener);

    void updateViewWithAds(Object obj);
}
