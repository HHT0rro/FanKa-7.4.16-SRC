package com.wangmai.appsdkdex.Iparameter;

import android.view.ViewGroup;
import com.wangmai.common.Ibase.IBaseParameter;
import com.wangmai.common.Ilistener.XAdPatchListener;
import com.wangmai.common.bean.PatchBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IPatchParameter extends IBaseParameter<PatchBean> {
    XAdPatchListener getPatchListener();

    ViewGroup getPatchViewGroup();
}
