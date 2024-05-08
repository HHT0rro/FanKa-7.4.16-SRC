package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwKeyEventDetector {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35262a = "HwKeyEventDetector";

    /* renamed from: b, reason: collision with root package name */
    public static final int f35263b = 1;

    /* renamed from: c, reason: collision with root package name */
    public View f35264c = null;

    /* renamed from: d, reason: collision with root package name */
    public OnEditEventListener f35265d = null;

    /* renamed from: e, reason: collision with root package name */
    public OnSearchEventListener f35266e = null;

    /* renamed from: f, reason: collision with root package name */
    public OnNextTabEventListener f35267f = null;

    /* renamed from: g, reason: collision with root package name */
    public OnGlobalNextTabEventListener f35268g = null;

    /* renamed from: h, reason: collision with root package name */
    public View.OnUnhandledKeyEventListener f35269h = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnEditEventListener {
        boolean onCopy(int i10, @NonNull KeyEvent keyEvent);

        boolean onCut(int i10, @NonNull KeyEvent keyEvent);

        boolean onDelete(int i10, @NonNull KeyEvent keyEvent);

        boolean onPaste(int i10, @NonNull KeyEvent keyEvent);

        boolean onSelectAll(int i10, @NonNull KeyEvent keyEvent);

        boolean onUndo(int i10, @NonNull KeyEvent keyEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnGlobalNextTabEventListener {
        boolean onGlobalNextTab(int i10, @NonNull KeyEvent keyEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnNextTabEventListener {
        boolean onNextTab(int i10, @NonNull KeyEvent keyEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnSearchEventListener {
        boolean onSearch(int i10, @NonNull KeyEvent keyEvent);
    }

    public HwKeyEventDetector(@NonNull Context context) {
    }

    private boolean b(int i10, int i11, KeyEvent keyEvent) {
        OnEditEventListener onEditEventListener;
        if (i10 != 112 || (onEditEventListener = this.f35265d) == null) {
            return false;
        }
        return onEditEventListener.onDelete(i11, keyEvent);
    }

    @Nullable
    public static HwKeyEventDetector instantiate(@NonNull Context context) {
        Object instantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwKeyEventDetector.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwKeyEventDetector.class);
        if (instantiate instanceof HwKeyEventDetector) {
            return (HwKeyEventDetector) instantiate;
        }
        return null;
    }

    public OnEditEventListener getOnEditEventListener() {
        return this.f35265d;
    }

    public OnGlobalNextTabEventListener getOnGlobalNextTabListener() {
        return this.f35268g;
    }

    public OnNextTabEventListener getOnNextTabListener() {
        return this.f35267f;
    }

    public OnSearchEventListener getOnSearchEventListener() {
        return this.f35266e;
    }

    public void onDetachedFromWindow() {
        a(false);
    }

    public boolean onKeyEvent(int i10, @NonNull KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (keyEvent.isCtrlPressed()) {
            if (a(i10, action, keyEvent)) {
                return true;
            }
            OnNextTabEventListener onNextTabEventListener = this.f35267f;
            if (onNextTabEventListener != null && i10 == 61 && onNextTabEventListener.onNextTab(action, keyEvent)) {
                return true;
            }
            OnSearchEventListener onSearchEventListener = this.f35266e;
            return onSearchEventListener != null && i10 == 34 && onSearchEventListener.onSearch(action, keyEvent);
        }
        return b(i10, action, keyEvent);
    }

    public void setOnEditEventListener(OnEditEventListener onEditEventListener) {
        this.f35265d = onEditEventListener;
    }

    public void setOnGlobalNextTabListener(@NonNull View view, OnGlobalNextTabEventListener onGlobalNextTabEventListener) {
        this.f35264c = view;
        this.f35268g = onGlobalNextTabEventListener;
        a(onGlobalNextTabEventListener != null);
    }

    public void setOnNextTabListener(OnNextTabEventListener onNextTabEventListener) {
        this.f35267f = onNextTabEventListener;
    }

    public void setOnSearchEventListener(OnSearchEventListener onSearchEventListener) {
        this.f35266e = onSearchEventListener;
    }

    private void a(boolean z10) {
        View view;
        if (Build.VERSION.SDK_INT >= 28 && (view = this.f35264c) != null) {
            if (z10) {
                if (this.f35269h == null) {
                    a aVar = new a(this);
                    this.f35269h = aVar;
                    this.f35264c.addOnUnhandledKeyEventListener(aVar);
                    return;
                }
                return;
            }
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = this.f35269h;
            if (onUnhandledKeyEventListener != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
                this.f35269h = null;
            }
        }
    }

    private boolean a(int i10, int i11, KeyEvent keyEvent) {
        OnEditEventListener onEditEventListener = this.f35265d;
        if (onEditEventListener == null) {
            return false;
        }
        if (i10 != 29) {
            if (i10 != 31) {
                if (i10 != 50) {
                    if (i10 != 52) {
                        if (i10 == 54 && onEditEventListener.onUndo(i11, keyEvent)) {
                            return true;
                        }
                    } else if (onEditEventListener.onCut(i11, keyEvent)) {
                        return true;
                    }
                } else if (onEditEventListener.onPaste(i11, keyEvent)) {
                    return true;
                }
            } else if (onEditEventListener.onCopy(i11, keyEvent)) {
                return true;
            }
        } else if (onEditEventListener.onSelectAll(i11, keyEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, @NonNull KeyEvent keyEvent) {
        return this.f35268g != null && keyEvent.getKeyCode() == 61 && keyEvent.isCtrlPressed() && this.f35268g.onGlobalNextTab(keyEvent.getAction(), keyEvent);
    }
}
