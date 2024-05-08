package com.kwad.sdk.core.webview.a;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    @Nullable
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster != null) {
            return defaultVideoPoster;
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        createBitmap.eraseColor(0);
        return createBitmap;
    }
}
