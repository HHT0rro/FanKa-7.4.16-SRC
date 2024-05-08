package com.wangmai.common.Ilistener;

import android.os.Bundle;
import com.wangmai.common.Ibase.XAdBaseListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface XAdRewardVideoListener extends XAdBaseListener {
    void onAdClose();

    void onAdLoad();

    void onRewarded(boolean z10, Bundle bundle);

    void onVideoComplete();

    void onVideoError(String str);
}
