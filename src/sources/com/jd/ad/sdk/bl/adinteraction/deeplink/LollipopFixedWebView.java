package com.jd.ad.sdk.bl.adinteraction.deeplink;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LollipopFixedWebView extends WebView {
    public LollipopFixedWebView(Context context) {
        super(jad_an(context));
    }

    public static Context jad_an(Context context) {
        return Build.VERSION.SDK_INT < 23 ? context.createConfigurationContext(new Configuration()) : context;
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet) {
        super(jad_an(context), attributeSet);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i10) {
        super(jad_an(context), attributeSet, i10);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(jad_an(context), attributeSet, i10, i11);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i10, boolean z10) {
        super(jad_an(context), attributeSet, i10, z10);
    }
}
