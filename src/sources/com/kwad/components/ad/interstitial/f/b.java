package com.kwad.components.ad.interstitial.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    private View mRootView;

    public b(@NonNull View view, int i10) {
        super(view, 100);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean dW() {
        return bq.o(this.mRootView, 100);
    }
}
