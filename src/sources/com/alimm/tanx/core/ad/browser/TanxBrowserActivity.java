package com.alimm.tanx.core.ad.browser;

import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.AdClickUtAnalytics;
import com.alimm.tanx.core.utils.LogUtils;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxBrowserActivity extends tanxc_do {
    public TanxBrowserContainer tanxc_byte;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_byte;
        if (tanxBrowserContainer == null || tanxBrowserContainer.tanxc_byte()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_byte() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_byte;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_int();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_case() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_byte;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_try();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public boolean tanxc_for() {
        try {
            TanxBrowserContainer tanxBrowserContainer = (TanxBrowserContainer) findViewById(R$id.xadclick_webview_container);
            this.tanxc_byte = tanxBrowserContainer;
            tanxBrowserContainer.tanxc_do(this.tanxc_for, this.tanxc_do);
            if (!this.tanxc_byte.tanxc_do()) {
                LogUtils.i("AdSystemWebViewActivity", "initView: failed to create WebView.");
                AdClickUtAnalytics.recordActivityCreateFail(null, "AdSystemWebViewActivity", "webview_init_fail");
                finish();
                return false;
            }
            this.tanxc_byte.tanxc_do(this.tanxc_new);
            this.tanxc_byte.tanxc_do(this.tanxc_if);
            this.tanxc_byte.tanxc_do(this.tanxc_try);
            tanxc_do();
            return true;
        } catch (Exception e2) {
            LogUtils.e("AdSystemWebViewActivity", e2);
            finish();
            TanxBaseUt.utError(1, "AdSystemWebViewActivity", e2, "");
            return false;
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public int tanxc_if() {
        return R$layout.tanx_layout_activity_browser;
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public String tanxc_int() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_byte;
        return tanxBrowserContainer != null ? tanxBrowserContainer.tanxc_if() : "";
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_new() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_byte;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_for();
        }
    }

    @Override // com.alimm.tanx.core.ad.browser.tanxc_do
    public void tanxc_try() {
        TanxBrowserContainer tanxBrowserContainer = this.tanxc_byte;
        if (tanxBrowserContainer != null) {
            tanxBrowserContainer.tanxc_new();
        }
    }
}
