package com.kwad.components.core.page.widget;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 14)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends TextureView {
    public b(Context context) {
        super(context);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}