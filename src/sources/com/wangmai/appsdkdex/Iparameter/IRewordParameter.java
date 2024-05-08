package com.wangmai.appsdkdex.Iparameter;

import com.wangmai.common.Ibase.IBaseParameter;
import com.wangmai.common.Ilistener.XAdRewardVideoListener;
import com.wangmai.common.bean.RewordBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IRewordParameter extends IBaseParameter<RewordBean> {
    int getOrientation();

    XAdRewardVideoListener getRewardListener();
}
