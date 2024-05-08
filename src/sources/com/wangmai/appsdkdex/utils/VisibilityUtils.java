package com.wangmai.appsdkdex.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import com.wangmai.common.utils.DebugLog;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VisibilityUtils {
    public static final String TAG = b.a("WjtjcjmjuzVujmt");
    public static VisibilityUtils visibilityUtils;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class GlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final View view;

        public GlobalLayoutListener(View view, boolean z10, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.view = view;
            this.isVisible = z10;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                if (VisibilityUtils.this.checkViewVisibility(this.view)) {
                    if (!this.isVisible) {
                        this.isVisible = true;
                        ViewVisibilityChangeListener viewVisibilityChangeListener = this.listener;
                        if (viewVisibilityChangeListener != null) {
                            viewVisibilityChangeListener.visible();
                        }
                    }
                } else if (this.isVisible) {
                    this.isVisible = false;
                    ViewVisibilityChangeListener viewVisibilityChangeListener2 = this.listener;
                    if (viewVisibilityChangeListener2 != null) {
                        viewVisibilityChangeListener2.invisible();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final View view;

        public ScrollChangedListener(View view, boolean z10, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.view = view;
            this.isVisible = z10;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (VisibilityUtils.this.checkViewVisibility(this.view)) {
                    if (!this.isVisible) {
                        this.isVisible = true;
                        ViewVisibilityChangeListener viewVisibilityChangeListener = this.listener;
                        if (viewVisibilityChangeListener != null) {
                            viewVisibilityChangeListener.visible();
                        }
                    }
                } else if (this.isVisible) {
                    this.isVisible = false;
                    ViewVisibilityChangeListener viewVisibilityChangeListener2 = this.listener;
                    if (viewVisibilityChangeListener2 != null) {
                        viewVisibilityChangeListener2.invisible();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ViewVisibilityChangeListener {
        void invisible();

        void visible();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class WindowFocusChangeListener implements ViewTreeObserver.OnWindowFocusChangeListener {
        public boolean isVisible;
        public ViewVisibilityChangeListener listener;
        public final View view;

        public WindowFocusChangeListener(View view, boolean z10, ViewVisibilityChangeListener viewVisibilityChangeListener) {
            this.view = view;
            this.isVisible = z10;
            this.listener = viewVisibilityChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z10) {
            try {
                if (z10) {
                    if (VisibilityUtils.this.checkViewVisibility(this.view)) {
                        if (!this.isVisible) {
                            this.isVisible = true;
                            ViewVisibilityChangeListener viewVisibilityChangeListener = this.listener;
                            if (viewVisibilityChangeListener != null) {
                                viewVisibilityChangeListener.visible();
                            }
                        }
                    } else if (this.isVisible) {
                        this.isVisible = false;
                        ViewVisibilityChangeListener viewVisibilityChangeListener2 = this.listener;
                        if (viewVisibilityChangeListener2 != null) {
                            viewVisibilityChangeListener2.invisible();
                        }
                    }
                } else {
                    this.isVisible = false;
                    ViewVisibilityChangeListener viewVisibilityChangeListener3 = this.listener;
                    if (viewVisibilityChangeListener3 != null) {
                        viewVisibilityChangeListener3.invisible();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkViewVisibility(View view) {
        try {
            if (!ViewCompat.isAttachedToWindow(view) || !unCover(view)) {
                return false;
            }
            while (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                if (((ViewGroup) view.getParent()).getVisibility() != 0) {
                    return false;
                }
                view = (View) view.getParent();
            }
            return true;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("difdlWjfxWjtjcjmjuz;") + th.toString());
            return true;
        }
    }

    public static VisibilityUtils getInstance() {
        if (visibilityUtils == null) {
            synchronized (VisibilityUtils.class) {
                if (visibilityUtils == null) {
                    visibilityUtils = new VisibilityUtils();
                }
            }
        }
        return visibilityUtils;
    }

    private boolean unCover(View view) {
        boolean z10 = true;
        try {
            Rect rect = new Rect();
            z10 = view.getLocalVisibleRect(rect);
            if (!z10) {
                return z10;
            }
            if (rect.width() >= view.getMeasuredWidth() / 2) {
                if (rect.height() >= view.getMeasuredHeight() / 2) {
                    return z10;
                }
            }
            return false;
        } catch (Throwable th) {
            DebugLog.W(b.a("DpwfsfeVujmt"), b.a("jtDpwfs�") + th.toString());
            return z10;
        }
    }

    public void addVisibleChangedListener(final View view, ViewVisibilityChangeListener viewVisibilityChangeListener) {
        if (view != null && viewVisibilityChangeListener != null) {
            try {
                final GlobalLayoutListener globalLayoutListener = new GlobalLayoutListener(view, false, viewVisibilityChangeListener);
                view.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
                final ScrollChangedListener scrollChangedListener = new ScrollChangedListener(view, false, viewVisibilityChangeListener);
                view.getViewTreeObserver().addOnScrollChangedListener(scrollChangedListener);
                final WindowFocusChangeListener windowFocusChangeListener = new WindowFocusChangeListener(view, false, viewVisibilityChangeListener);
                view.getViewTreeObserver().addOnWindowFocusChangeListener(windowFocusChangeListener);
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.wangmai.appsdkdex.utils.VisibilityUtils.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                        try {
                            view.getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
                            view.getViewTreeObserver().removeOnScrollChangedListener(scrollChangedListener);
                            view.getViewTreeObserver().removeOnWindowFocusChangeListener(windowFocusChangeListener);
                            view.removeOnAttachStateChangeListener(this);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            } catch (Throwable th) {
                DebugLog.W(TAG, b.a("beeWjfxWjtjcmfMjtufofs;") + th.toString());
                return;
            }
        }
        DebugLog.W(TAG, b.a("Wjfx!ps!Mjtufofs!jt!ovmm"));
    }
}
