package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.s.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KsStyledLinearLayout extends LinearLayout implements d {
    public KsStyledLinearLayout(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        i.b(eVar, getBackground());
    }

    public KsStyledLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @RequiresApi(api = 21)
    public KsStyledLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
