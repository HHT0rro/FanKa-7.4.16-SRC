package com.wangmai.appsdkdex.Iparameter;

import android.view.ViewGroup;
import com.wangmai.common.Ibase.IBaseParameter;
import com.wangmai.common.Ilistener.XAdBannerListener;
import com.wangmai.common.bean.BannerBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IBannerParameter extends IBaseParameter<BannerBean> {
    XAdBannerListener getBannerListener();

    ViewGroup getBannerViewGroup();
}
