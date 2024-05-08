package com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.CSSDimensValue;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DimensWrapper implements IDimensWrapper {
    private static final String TAG = "DimensWrapper";
    private static final String UNIT_DP = "dp";
    private static final String UNIT_PX = "px";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private boolean need2px(float f10, String str) {
        return f10 > 0.0f && ("dp".equals(str) || TextUtils.isEmpty(str));
    }

    private void setCompatibleDimens(View view, Dimens dimens, Dimens dimens2) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (dimens != null && dimens.isValid()) {
                if (dimens instanceof FixedDimens) {
                    setFixedHeight(view, dimens, layoutParams);
                } else if (dimens instanceof WeightDimens) {
                    try {
                        layoutParams.height = (int) (viewGroup.getHeight() * dimens.getDimens());
                    } catch (Exception e2) {
                        Log.w(TAG, "setCompatibleDimens: viewGroup.getHeight" + e2.getMessage());
                    }
                }
            }
            if (dimens2 != null && dimens2.isValid()) {
                if (dimens2 instanceof FixedDimens) {
                    setFixedWidth(view, dimens2, layoutParams);
                } else if (dimens2 instanceof WeightDimens) {
                    try {
                        layoutParams.width = (int) (viewGroup.getWidth() * dimens2.getDimens());
                    } catch (Exception e10) {
                        Log.w(TAG, "setCompatibleDimens: viewGroup.getWidth" + e10.getMessage());
                    }
                }
            }
            view.setLayoutParams(layoutParams);
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompatibleDimensDelay(final View view, Dimens dimens, Dimens dimens2, final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        setCompatibleDimens(view, dimens, dimens2);
        view.post(new Runnable() { // from class: com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.a
            @Override // java.lang.Runnable
            public final void run() {
                DimensWrapper.a(View.this, onGlobalLayoutListener);
            }
        });
    }

    private void setFixedDimens(View view, Dimens dimens, Dimens dimens2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        if (dimens.isValid()) {
            setFixedHeight(view, dimens, layoutParams);
        }
        if (dimens2.isValid()) {
            setFixedWidth(view, dimens2, layoutParams);
        }
        view.setLayoutParams(layoutParams);
    }

    private void setFixedHeight(View view, Dimens dimens, ViewGroup.LayoutParams layoutParams) {
        try {
            float dimens2 = dimens.getDimens();
            if (need2px(dimens2, dimens.getUnit())) {
                dimens2 = com.huawei.flexiblelayout.css.util.a.a(view.getContext(), dimens2);
            }
            layoutParams.height = (int) dimens2;
        } catch (Exception e2) {
            Log.w(TAG, "setFixedHeight: " + e2.getMessage());
        }
    }

    private void setFixedWidth(View view, Dimens dimens, ViewGroup.LayoutParams layoutParams) {
        try {
            float dimens2 = dimens.getDimens();
            if (need2px(dimens2, dimens.getUnit())) {
                dimens2 = com.huawei.flexiblelayout.css.util.a.a(view.getContext(), dimens2);
            }
            layoutParams.width = (int) dimens2;
        } catch (Exception e2) {
            Log.w(TAG, "setFixedWidth: " + e2.getMessage());
        }
    }

    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.IDimensWrapper
    public void setDimens(final View view, CSSDimensValue.CSSDimens cSSDimens) {
        if (view == null || cSSDimens == null) {
            return;
        }
        final Dimens height = cSSDimens.getHeight();
        final Dimens width = cSSDimens.getWidth();
        if ((height instanceof FixedDimens) && (width instanceof FixedDimens)) {
            setFixedDimens(view, height, width);
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.DimensWrapper.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    DimensWrapper.this.setCompatibleDimensDelay(view, height, width, this);
                }
            });
        }
    }
}
