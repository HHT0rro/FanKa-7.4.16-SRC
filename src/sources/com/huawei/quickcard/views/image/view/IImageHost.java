package com.huawei.quickcard.views.image.view;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.ui.CommandOptions;
import com.huawei.quickcard.views.image.IImageHostView;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IImageHost extends IImageHostView, CommandOptions {
    public static final String TAG = "IImageHostView";

    void onEnd();

    void onStart();
}
