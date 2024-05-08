package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SlideTipsView extends FrameLayout {
    public SlideTipsView(@NonNull Context context) {
        this(context, null);
    }

    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_SlideTipsView, i10, 0);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.ksad_SlideTipsView_ksad_is_left_slide, true);
        obtainStyledAttributes.recycle();
        l.inflate(context, z10 ? R.layout.ksad_interstitial_left_slide_to_next : R.layout.ksad_interstitial_right_slide_to_return, this);
    }
}
