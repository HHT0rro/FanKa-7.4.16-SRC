package com.huawei.uikit.hwcommon.drawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwDrawableWrapper extends DrawableWrapper {

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f34933a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f34934b;

    /* renamed from: c, reason: collision with root package name */
    public OnStateChangedListener f34935c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnStateChangedListener {
        void onStateChanged(int[] iArr, int[] iArr2, int i10, int i11);
    }

    public HwDrawableWrapper(@NonNull Drawable drawable, @NonNull ColorStateList colorStateList) {
        super(drawable instanceof HwDrawableWrapper ? ((HwDrawableWrapper) drawable).getDrawable() : drawable);
        this.f34933a = colorStateList;
    }

    public OnStateChangedListener getOnStateChangedListener() {
        return this.f34935c;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f34933a.isStateful();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (getDrawable() != null) {
            int colorForState = this.f34933a.getColorForState(iArr, 0);
            int colorForState2 = this.f34933a.getColorForState(this.f34934b, 0);
            OnStateChangedListener onStateChangedListener = this.f34935c;
            if (onStateChangedListener != null) {
                onStateChangedListener.onStateChanged(iArr, this.f34934b, colorForState, colorForState2);
            }
        }
        return super.onStateChange(iArr);
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f34935c = onStateChangedListener;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        int[] state = getState();
        this.f34934b = Arrays.copyOf(state, state.length);
        return super.setState(iArr);
    }
}
