package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.cq;
import com.baidu.mobads.sdk.internal.cs;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CpuAdView extends RelativeLayout {
    private cs mAdProd;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    public boolean canGoBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                return webView.canGoBack();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        View w3 = this.mAdProd.w();
        if (w3 instanceof WebView) {
            ((WebView) w3).destroy();
        }
    }

    public boolean onKeyBackDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    public void onPause() {
        View w3 = this.mAdProd.w();
        if (w3 instanceof WebView) {
            ((WebView) w3).onPause();
        }
    }

    public void onResume() {
        View w3 = this.mAdProd.w();
        if (w3 instanceof WebView) {
            ((WebView) w3).onResume();
        }
    }

    public void requestData() {
        cs csVar = this.mAdProd;
        if (csVar != null) {
            csVar.a();
        }
    }

    public CpuAdView(Context context, String str, int i10, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        cq cqVar = new cq(context);
        this.mAdProd = new cs(context, cqVar, str, i10, cPUWebAdRequestParam);
        addView(cqVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i10, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        cq cqVar = new cq(context);
        cs csVar = new cs(context, cqVar, str, i10, cPUWebAdRequestParam);
        this.mAdProd = csVar;
        csVar.a(cpuAdViewInternalStatusListener);
        addView(cqVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
