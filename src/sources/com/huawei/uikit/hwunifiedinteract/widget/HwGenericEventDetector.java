package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwGenericEventDetector {
    public static final int SCROLL_SENSITIVITY_FAST = 0;
    public static final int SCROLL_SENSITIVITY_NORMAL = 1;
    public static final int SCROLL_SENSITIVITY_SLOW = 2;

    /* renamed from: a, reason: collision with root package name */
    public static final float f35242a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public static final float f35243b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    public static final float f35244c = 0.6f;

    /* renamed from: d, reason: collision with root package name */
    public static final String f35245d = "HwGenericEventDetector";

    /* renamed from: e, reason: collision with root package name */
    public static final int f35246e = 9;

    /* renamed from: f, reason: collision with root package name */
    public static final float f35247f = -1.0f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f35248g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f35249h = 64;

    /* renamed from: o, reason: collision with root package name */
    public float f35256o;

    /* renamed from: p, reason: collision with root package name */
    public float f35257p;

    /* renamed from: q, reason: collision with root package name */
    public int f35258q;

    /* renamed from: t, reason: collision with root package name */
    public View f35261t;

    /* renamed from: i, reason: collision with root package name */
    public OnChangePageListener f35250i = null;

    /* renamed from: j, reason: collision with root package name */
    public OnChangeProgressListener f35251j = null;

    /* renamed from: k, reason: collision with root package name */
    public OnScrollListener f35252k = null;

    /* renamed from: l, reason: collision with root package name */
    public float f35253l = -1.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f35254m = -1.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f35255n = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    public float f35259r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    public float f35260s = 1.0f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnChangePageListener {
        boolean onChangePage(float f10, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnChangeProgressListener {
        boolean onChangeProgress(int i10, int i11, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnChangeProgressListener2 extends OnChangeProgressListener {
        boolean onBegin();

        boolean onEnd(float f10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnScrollListener {
        boolean onScrollBy(float f10, float f11, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnScrollListener2 extends OnScrollListener {
        boolean onBegin();

        boolean onEnd(float f10);
    }

    public HwGenericEventDetector(@NonNull Context context) {
        DisplayMetrics displayMetrics;
        this.f35256o = 0.0f;
        this.f35257p = 0.0f;
        this.f35258q = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f35256o = viewConfiguration.getScaledHorizontalScrollFactor();
            this.f35257p = viewConfiguration.getScaledVerticalScrollFactor();
        } else {
            Resources resources = context.getResources();
            if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
                return;
            }
            float applyDimension = TypedValue.applyDimension(1, 64.0f, displayMetrics);
            this.f35256o = applyDimension;
            this.f35257p = applyDimension;
        }
        this.f35258q = viewConfiguration.getScaledTouchSlop();
    }

    private boolean a(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        float f10 = this.f35253l;
        float f11 = this.f35255n;
        if (f10 - f11 <= x10 && x10 <= f10 + f11) {
            float f12 = this.f35254m;
            if (f12 - f11 <= y10 && y10 <= f12 + f11) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static HwGenericEventDetector instantiate(@NonNull Context context) {
        Object instantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwGenericEventDetector.class, HwWidgetInstantiator.getCurrentType(context, 9, 1)), HwGenericEventDetector.class);
        if (instantiate instanceof HwGenericEventDetector) {
            return (HwGenericEventDetector) instantiate;
        }
        return null;
    }

    public float getHorizontalScrollFactor() {
        return this.f35256o * this.f35260s;
    }

    public OnChangePageListener getOnChangePageListener() {
        return this.f35250i;
    }

    public OnChangeProgressListener getOnChangeProgressListener() {
        return this.f35251j;
    }

    public OnScrollListener getOnScrollListener() {
        return this.f35252k;
    }

    public float getSensitivity() {
        return this.f35260s;
    }

    public float getStepValue() {
        return this.f35259r;
    }

    public View getTargetView() {
        return this.f35261t;
    }

    public int getTouchSlop() {
        return this.f35258q;
    }

    public float getVelocity() {
        return 0.0f;
    }

    public float getVerticalScrollFactor() {
        return this.f35257p * this.f35260s;
    }

    public boolean interceptGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        if (this.f35252k == null) {
            return false;
        }
        if (Float.compare(this.f35253l, -1.0f) == 0 && Float.compare(this.f35254m, -1.0f) == 0) {
            return false;
        }
        if (a(motionEvent)) {
            this.f35253l = -1.0f;
            this.f35254m = -1.0f;
            return false;
        }
        return onGenericMotionEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.isFromSource(2) && motionEvent.getAction() == 8) {
            float axisValue = motionEvent.getAxisValue(10);
            float axisValue2 = motionEvent.getAxisValue(9);
            if (Float.compare(axisValue, 0.0f) == 0 && Float.compare(axisValue2, 0.0f) == 0) {
                return false;
            }
            float f10 = Float.compare(axisValue, 0.0f) == 0 ? -axisValue2 : axisValue;
            OnChangePageListener onChangePageListener = this.f35250i;
            if (onChangePageListener != null && onChangePageListener.onChangePage(f10, motionEvent)) {
                return true;
            }
            OnChangeProgressListener onChangeProgressListener = this.f35251j;
            if (onChangeProgressListener != null && onChangeProgressListener.onChangeProgress(((int) (-axisValue)) * 1, ((int) axisValue2) * 1, motionEvent)) {
                return true;
            }
            if (this.f35252k != null) {
                if (this.f35252k.onScrollBy(Math.round(getHorizontalScrollFactor() * axisValue), Math.round(getVerticalScrollFactor() * (-axisValue2)), motionEvent)) {
                    if (this.f35253l < 0.0f || this.f35254m < 0.0f) {
                        this.f35253l = motionEvent.getX();
                        this.f35254m = motionEvent.getY();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void setOnChangePageListener(OnChangePageListener onChangePageListener) {
        this.f35250i = onChangePageListener;
    }

    public void setOnChangeProgressListener(OnChangeProgressListener onChangeProgressListener) {
        this.f35251j = onChangeProgressListener;
    }

    public void setOnScrollListener(@NonNull View view, OnScrollListener onScrollListener) {
        this.f35252k = onScrollListener;
        this.f35261t = view;
    }

    public void setSensitivity(float f10) {
        this.f35260s = f10;
    }

    public void setSensitivityMode(int i10) {
        if (i10 == 0) {
            this.f35260s = 1.0f;
        } else if (i10 == 2) {
            this.f35260s = 0.6f;
        } else {
            this.f35260s = 1.0f;
        }
    }

    public void setStepValue(float f10) {
        this.f35259r = f10;
    }

    public void setOnChangeProgressListener(@NonNull View view, OnChangeProgressListener onChangeProgressListener) {
        this.f35251j = onChangeProgressListener;
        this.f35261t = view;
    }
}
