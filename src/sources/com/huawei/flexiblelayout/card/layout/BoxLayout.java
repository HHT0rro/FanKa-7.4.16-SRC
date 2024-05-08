package com.huawei.flexiblelayout.card.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BoxLayout extends FrameLayout {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        @NonNull
        public static LayoutParams wrapLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
                }
                return new LayoutParams(layoutParams);
            }
            return new LayoutParams(-2, -2);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }
    }

    public BoxLayout(@NonNull Context context) {
        super(context);
    }

    public BoxLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BoxLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public BoxLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
