package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bs;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends WebView {
    private boolean aDO;
    private com.kwad.sdk.core.webview.a.a aDP;

    public c(Context context) {
        super(bn(context));
        this.aDO = true;
        init();
    }

    private static Context bn(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context dp = l.dp(context);
        if (l.ds(dp)) {
            return dp;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + dp.getClass().getName() + "--classloader:" + ((Object) dp.getClass().getClassLoader()) + "--context2:" + l.dp(ServiceProvider.KO()).getClass().getName()));
        return l.dp(ServiceProvider.KO());
    }

    private void init() {
        bs.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aDP = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aDO) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public void setEnableDestroy(boolean z10) {
        this.aDO = z10;
    }

    public void setNeedHybridLoad(boolean z10) {
        this.aDP.setNeedHybridLoad(z10);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bn(context), attributeSet);
        this.aDO = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(bn(context), attributeSet, i10);
        this.aDO = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(bn(context), attributeSet, i10, i11);
        this.aDO = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i10, boolean z10) {
        super(bn(context), attributeSet, i10, z10);
        this.aDO = true;
        init();
    }
}
