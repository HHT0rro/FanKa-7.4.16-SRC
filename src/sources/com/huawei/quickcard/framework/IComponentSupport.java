package com.huawei.quickcard.framework;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.exposure.IExposureSupport;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IComponentSupport extends IComponentFunction, IExposureSupport {
    ViewParent getViewParent(@NonNull View view);

    boolean onTouchEvent(MotionEvent motionEvent);

    void onViewCreated(@NonNull CardContext cardContext);

    void setViewParent(ViewParent viewParent);
}
