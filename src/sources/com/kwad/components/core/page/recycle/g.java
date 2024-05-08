package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g extends RecyclerView {
    private boolean PW;

    public g(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public void removeDetachedView(View view, boolean z10) {
        if (!this.PW) {
            super.removeDetachedView(view, z10);
        } else {
            super.removeDetachedView(view, z10);
        }
    }

    public void setIngoreTmpDetachedFlag(boolean z10) {
        this.PW = z10;
    }

    public g(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
