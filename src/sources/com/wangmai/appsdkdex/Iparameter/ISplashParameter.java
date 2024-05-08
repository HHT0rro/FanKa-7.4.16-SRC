package com.wangmai.appsdkdex.Iparameter;

import android.view.ViewGroup;
import com.wangmai.common.Ibase.IBaseParameter;
import com.wangmai.common.Ilistener.XAdSplashListener;
import com.wangmai.common.bean.SplashBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ISplashParameter extends IBaseParameter<SplashBean> {
    XAdSplashListener getSplashListener();

    ViewGroup getSplashViewGroup();
}
