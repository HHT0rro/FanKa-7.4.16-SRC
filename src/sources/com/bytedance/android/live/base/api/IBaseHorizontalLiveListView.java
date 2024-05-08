package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.Callback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IBaseHorizontalLiveListView {
    void refresh();

    View self();

    void setEmptyListener(Callback<Boolean> callback);

    void setErrorListener(Callback<Boolean> callback);

    void setRoomCountListener(Callback<Integer> callback);
}
