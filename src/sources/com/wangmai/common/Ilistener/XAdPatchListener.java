package com.wangmai.common.Ilistener;

import com.wangmai.common.Ibase.XAdBaseListener;
import com.wangmai.common.enums.EnumPatchType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface XAdPatchListener extends XAdBaseListener {
    void onAdClose();

    void onAdLoad(EnumPatchType enumPatchType);

    void onVideoComplete();

    void onVideoError(String str);
}
