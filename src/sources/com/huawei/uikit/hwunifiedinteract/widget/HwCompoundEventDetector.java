package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwCompoundEventDetector {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35237a = "HwCompoundEventDetector";

    /* renamed from: b, reason: collision with root package name */
    public static final int f35238b = 1;

    /* renamed from: c, reason: collision with root package name */
    public OnZoomEventListener f35239c = null;

    /* renamed from: d, reason: collision with root package name */
    public OnMultiSelectListener f35240d = null;

    /* renamed from: e, reason: collision with root package name */
    public View f35241e = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnMultiSelectListener {
        boolean onCancel(@NonNull MotionEvent motionEvent);

        boolean onSelectContinuous(boolean z10, @NonNull MotionEvent motionEvent);

        boolean onSelectDiscrete(@NonNull MotionEvent motionEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnZoomEventListener {
        boolean onZoom(float f10, @NonNull MotionEvent motionEvent);
    }

    public HwCompoundEventDetector(@NonNull Context context) {
    }

    @Nullable
    public static HwCompoundEventDetector instantiate(@NonNull Context context) {
        Object instantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwCompoundEventDetector.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwCompoundEventDetector.class);
        if (instantiate instanceof HwCompoundEventDetector) {
            return (HwCompoundEventDetector) instantiate;
        }
        return null;
    }

    public OnMultiSelectListener getOnMultiSelectEventListener() {
        return this.f35240d;
    }

    public OnZoomEventListener getOnZoomEventListener() {
        return this.f35239c;
    }

    public void onDetachedFromWindow() {
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        if (!motionEvent.isFromSource(2)) {
            return false;
        }
        int action = motionEvent.getAction();
        if ((motionEvent.getMetaState() & 4096) != 0 && this.f35239c != null && action == 8) {
            float axisValue = motionEvent.getAxisValue(10);
            if (Float.compare(axisValue, 0.0f) == 0) {
                axisValue = motionEvent.getAxisValue(9);
            }
            if (Float.compare(axisValue, 0.0f) != 0 && this.f35239c.onZoom(axisValue, motionEvent)) {
                return true;
            }
        }
        if (action == 11 && Build.VERSION.SDK_INT >= 23 && motionEvent.getActionButton() == 1 && this.f35240d != null) {
            if ((motionEvent.getMetaState() & 4096) != 0 && this.f35240d.onSelectDiscrete(motionEvent)) {
                return true;
            }
            if ((motionEvent.getMetaState() & 1) != 0 && this.f35240d.onSelectContinuous(false, motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyEvent(int i10, @NonNull KeyEvent keyEvent) {
        return false;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return false;
    }

    public void setOnMultiSelectEventListener(@NonNull View view, OnMultiSelectListener onMultiSelectListener) {
        this.f35241e = view;
        this.f35240d = onMultiSelectListener;
    }

    public void setOnZoomEventListener(@NonNull View view, OnZoomEventListener onZoomEventListener) {
        this.f35241e = view;
        this.f35239c = onZoomEventListener;
    }
}
