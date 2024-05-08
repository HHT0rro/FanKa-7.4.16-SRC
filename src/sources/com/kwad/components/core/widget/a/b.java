package com.kwad.components.core.widget.a;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends a {
    private View mRootView;

    public b(@NonNull View view, int i10) {
        super(view, i10);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public boolean dW() {
        return bq.a(this.mRootView, 70, true);
    }
}
