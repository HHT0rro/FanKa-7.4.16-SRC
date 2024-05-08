package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.EmptyCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ILiveOuterPreviewCoverView {
    void cancelAutoEnterGuide(boolean z10);

    void onShow();

    void release();

    void setCustomBottomView(View view);

    void setOnDislikeCallback(EmptyCallback emptyCallback);

    void stream(String str);
}
