package com.wangmai.appsdkdex.Iparameter;

import android.view.ViewGroup;
import com.wangmai.common.Ibase.IBaseParameter;
import com.wangmai.common.Ilistener.XAdNativeExpressListener;
import com.wangmai.common.bean.NativeExpressBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface INativeExpressParameter extends IBaseParameter<NativeExpressBean> {
    XAdNativeExpressListener getNativeExpressListener();

    ViewGroup getNativeExpressViewGroup();
}
