package com.kwad.components.offline.api.core.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.h;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BaseKsWebView extends FrameLayout {
    private boolean enableScroll;
    public DeepLinkListener mDeeplinkListener;
    public String mUniqueId;
    private h mViewRCHelper;
    public WebLoadListener mWebLoadListener;
    public WebViewStateListener mWebViewStateListener;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface DeepLinkListener {
        void onFailed();

        void onSuccess();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface WebLoadListener {
        void onDownloadStart(String str, String str2, String str3, String str4, long j10);

        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i10, String str, String str2);

        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface WebViewStateListener {
        void onFocusChanged(boolean z10, int i10, Rect rect);

        void onScrollChanged(int i10, int i11, int i12, int i13);

        void onSizeChanged(int i10, int i11, int i12, int i13);

        void onVisibilityChanged(View view, int i10);

        void onWindowFocusChanged(boolean z10);
    }

    public BaseKsWebView(@NonNull Context context) {
        super(context);
        this.enableScroll = true;
        init(context, null);
    }

    private float[] getRadius(float f10, float f11, float f12, float f13) {
        return new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract void callJs(String str);

    public abstract void callJs(String str, String str2);

    public abstract boolean canGoBack();

    public abstract boolean canGoForward();

    public abstract void destroy();

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    public String getUniqueId() {
        if (this.mUniqueId == null) {
            this.mUniqueId = UUID.randomUUID().toString();
        }
        return this.mUniqueId;
    }

    public abstract void goBack();

    public abstract void goForward();

    public abstract void loadUrl(String str);

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onFocusChanged(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onScrollChanged(i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mViewRCHelper.onSizeChanged(i10, i11);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onSizeChanged(i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onVisibilityChanged(view, i10);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onWindowFocusChanged(z10);
        }
    }

    @Override // android.view.View
    public abstract void scrollBy(int i10, int i11);

    @Override // android.view.View
    public abstract void scrollTo(int i10, int i11);

    public abstract void setAcceptThirdPartyCookies(boolean z10);

    public abstract void setAdCacheId(int i10, String str);

    public abstract void setAdTemplateString(String str);

    public abstract void setAllowContentAccess(boolean z10);

    public abstract void setAllowFileAccess(boolean z10);

    public abstract void setAllowFileAccessFromFileURLs(boolean z10);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z10);

    public abstract void setCacheMode(int i10);

    public abstract void setContextUniqId(int i10);

    public abstract void setDebugEnabled(boolean z10);

    public abstract void setDeeplinkEnabled(boolean z10);

    public void setDeeplinkListener(DeepLinkListener deepLinkListener) {
        this.mDeeplinkListener = deepLinkListener;
    }

    public abstract void setEnableScroll(boolean z10);

    public abstract void setEnableWebCache(boolean z10);

    public abstract void setInnerDownloadEnabled(boolean z10);

    public abstract void setJavaScriptEnabled(boolean z10);

    public abstract void setMixedContentMode(int i10);

    public void setRadius(float f10, float f11, float f12, float f13) {
        this.mViewRCHelper.setRadius(getRadius(f10, f11, f12, f13));
        postInvalidate();
    }

    public abstract void setSavePassword(boolean z10);

    public abstract void setTextZoom(int i10);

    public void setWebLoadListener(WebLoadListener webLoadListener) {
        this.mWebLoadListener = webLoadListener;
    }

    public void setWebViewStateListener(WebViewStateListener webViewStateListener) {
        this.mWebViewStateListener = webViewStateListener;
    }

    public BaseKsWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableScroll = true;
        init(context, attributeSet);
    }

    public BaseKsWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.enableScroll = true;
        init(context, attributeSet);
    }
}
