package com.huawei.quickcard.framework.touch;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ITouchEventManager {
    void registerTouchListener(View view, IQuickCardTouchEventListener iQuickCardTouchEventListener);

    void unRegisterTouchListenerByTarget(View view);
}
