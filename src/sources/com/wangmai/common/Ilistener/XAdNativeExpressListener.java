package com.wangmai.common.Ilistener;

import android.view.View;
import com.wangmai.common.Ibase.XAdBaseListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface XAdNativeExpressListener extends XAdBaseListener {
    void onADIsVideo(boolean z10);

    void onAdClose();

    void onRenderSuccess(View view, int i10, int i11);
}
