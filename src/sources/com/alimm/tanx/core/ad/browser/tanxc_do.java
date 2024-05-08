package com.alimm.tanx.core.ad.browser;

import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.view.textclassifier.TextClassifier;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.view.ActionMenu;
import com.alimm.tanx.core.ad.view.WebMenuDialog;
import com.alimm.tanx.core.constant.AdClickConstants;
import com.alimm.tanx.core.utils.AdClickUtAnalytics;
import com.alimm.tanx.core.utils.AdWebViewUtils;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.alimm.tanx.core.utils.LogUtils;
import com.wangmai.appsdkdex.R$drawable;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;
import com.wangmai.appsdkdex.R$style;
import java.util.ArrayList;

/* compiled from: TanxBaseBrowserActivity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class tanxc_do extends AppCompatActivity {
    public WebMenuDialog tanxc_byte;
    public LandingPageUtHelper tanxc_do;
    public long tanxc_else;
    public String tanxc_for;
    public OrientationEventListener tanxc_goto;
    public BidInfo tanxc_if;
    public TextView tanxc_int;
    public ProgressBar tanxc_new;
    public final boolean tanxc_case = true;
    public final IAdWebViewCallback tanxc_try = new IAdWebViewCallback() { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.1
        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onHideCustomView() {
            tanxc_do.this.tanxc_do(false);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.show();
            }
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(1);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onShowCustomView(View view) {
            tanxc_do.this.tanxc_do(true);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(10);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onTitleLoaded(String str) {
            TextView textView = tanxc_do.this.tanxc_int;
            if (textView != null) {
                textView.setText(str);
            }
        }
    };
    public boolean tanxc_char = false;
    public int tanxc_long = -2;

    private void tanxc_char() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(-16777216);
    }

    private void tanxc_else() {
        if (this.tanxc_byte == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ActionMenu.refresh);
            arrayList.add(ActionMenu.copy);
            arrayList.add(ActionMenu.gotoweb);
            this.tanxc_byte = new WebMenuDialog(this, arrayList, new WebMenuDialog.MenuClick() { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.2
                @Override // com.alimm.tanx.core.ad.view.WebMenuDialog.MenuClick
                public void click(int i10) {
                    if (i10 == 1012) {
                        tanxc_do.this.tanxc_new();
                        return;
                    }
                    if (i10 != 1013) {
                        if (i10 != 1016) {
                            return;
                        }
                        String tanxc_int = tanxc_do.this.tanxc_int();
                        if (TextUtils.isEmpty(tanxc_int)) {
                            return;
                        }
                        ((ClipboardManager) tanxc_do.this.getSystemService(TextClassifier.WIDGET_TYPE_CLIPBOARD)).setText(tanxc_int);
                        return;
                    }
                    String tanxc_int2 = tanxc_do.this.tanxc_int();
                    if (TextUtils.isEmpty(tanxc_int2)) {
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(tanxc_int2));
                        intent.setFlags(1610612740);
                        tanxc_do.this.startActivity(intent);
                    } catch (Throwable th) {
                        LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th);
                    }
                }
            });
        }
        try {
            this.tanxc_byte.show();
        } catch (Throwable th) {
            LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (isFinishing()) {
            return;
        }
        setResult(-1);
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10;
        super.onCreate(bundle);
        setTheme(R$style.Theme_AdClick_NoActionBar);
        if (getIntent() == null) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: intent is null.");
            AdClickUtAnalytics.recordActivityCreateFail(null, "BaseAdWebViewActivity", "null_intent");
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.tanxc_for = extras.getString("url");
            LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl == " + this.tanxc_for);
            i10 = extras.getInt(AdClickConstants.FORCE_ORIENTATION, 1);
            this.tanxc_else = extras.getLong(AdClickConstants.ACTIVITY_LAUNCH_TIME, 0L);
        } else {
            this.tanxc_for = getIntent().getDataString();
            LogUtils.d("BaseAdWebViewActivity", "onCreate:getDataString  mUrl == " + this.tanxc_for);
            i10 = 1;
        }
        if (TextUtils.isEmpty(this.tanxc_for)) {
            AdClickUtAnalytics.recordActivityCreateFail(null, "BaseAdWebViewActivity", "no_url");
            finish();
            return;
        }
        LandingPageUtHelper landingPageUtHelper = new LandingPageUtHelper();
        this.tanxc_do = landingPageUtHelper;
        landingPageUtHelper.setUserClickTime(this.tanxc_else);
        try {
            if (TextUtils.equals("1", Uri.parse(this.tanxc_for).getQueryParameter("hideRightMenu"))) {
                this.tanxc_char = true;
            }
        } catch (Exception e2) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: parse url exception.", e2);
        }
        this.tanxc_if = com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(this.tanxc_for);
        LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl = " + this.tanxc_for + ", mBidInfo = " + ((Object) this.tanxc_if) + ", mHideRightMenu = " + this.tanxc_char);
        setContentView(tanxc_if());
        if (!tanxc_for()) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: init view failed.");
            return;
        }
        tanxc_do(i10);
        tanxc_char();
        this.tanxc_do.setContentViewTime(System.currentTimeMillis());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R$drawable.tanx_browser_close_selector);
        }
        if (!this.tanxc_char) {
            AdWebViewUtils.setShowAsAction(menu, ActionMenu.more);
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d("BaseAdWebViewActivity", "onDestroy: mUrl = " + this.tanxc_for);
        LandingPageUtHelper landingPageUtHelper = this.tanxc_do;
        if (landingPageUtHelper != null) {
            landingPageUtHelper.setDestroyTime(System.currentTimeMillis());
            this.tanxc_do.recordLandingPageDestroy(this.tanxc_if, "2");
        }
        OrientationEventListener orientationEventListener = this.tanxc_goto;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        tanxc_case();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == ActionMenu.more.f4181id) {
            tanxc_else();
            return true;
        }
        if (menuItem.getItemId() == 16908332) {
            tanxc_case();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LogUtils.d("BaseAdWebViewActivity", "onResume: mUrl = " + this.tanxc_for);
        LandingPageUtHelper landingPageUtHelper = this.tanxc_do;
        if (landingPageUtHelper != null) {
            landingPageUtHelper.setResumeTime(System.currentTimeMillis());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LogUtils.d("BaseAdWebViewActivity", "onStart: mUrl = " + this.tanxc_for);
        tanxc_try();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LogUtils.d("BaseAdWebViewActivity", "onStop: mUrl = " + this.tanxc_for + ", mWebMenuDialog = " + ((Object) this.tanxc_byte));
        tanxc_byte();
        WebMenuDialog webMenuDialog = this.tanxc_byte;
        if (webMenuDialog == null || !webMenuDialog.isShowing()) {
            return;
        }
        LogUtils.d("BaseAdWebViewActivity", "onStop: destroy dialog.");
        this.tanxc_byte.dismiss();
        this.tanxc_byte = null;
    }

    public abstract void tanxc_byte();

    public abstract void tanxc_case();

    public abstract boolean tanxc_for();

    public abstract int tanxc_if();

    public abstract String tanxc_int();

    public abstract void tanxc_new();

    public abstract void tanxc_try();

    public void tanxc_do() {
        ProgressBar progressBar = (ProgressBar) findViewById(R$id.tanx_browser_progress);
        this.tanxc_new = progressBar;
        progressBar.setVisibility(8);
        try {
            setSupportActionBar((Toolbar) findViewById(R$id.tanx_browser_toolbar));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(getResources().getDrawable(R$drawable.tanx_browser_actionbar_bg));
                supportActionBar.setDisplayShowCustomEnabled(true);
                supportActionBar.setCustomView(View.inflate(this, R$layout.tanx_layout_browser_title, null));
                this.tanxc_int = (TextView) findViewById(R$id.tanx_browser_custom_title);
            }
        } catch (Exception e2) {
            LogUtils.d("BaseAdWebViewActivity", "setToolbar exception.", e2);
        }
    }

    public void tanxc_do(boolean z10) {
        getWindow().setFlags(z10 ? 1024 : 0, 1024);
    }

    public void tanxc_do(int i10) {
        if (i10 != 1) {
            setRequestedOrientation(i10);
            this.tanxc_goto = new OrientationEventListener(this) { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.3
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i11) {
                    tanxc_do tanxc_doVar;
                    if (tanxc_do.this.tanxc_long == -2) {
                        tanxc_do.this.tanxc_long = i11;
                    }
                    int abs = Math.abs(tanxc_do.this.tanxc_long - i11);
                    if (abs > 180) {
                        abs = 360 - abs;
                    }
                    if (abs <= 60 || (tanxc_doVar = tanxc_do.this) == null) {
                        return;
                    }
                    tanxc_doVar.setRequestedOrientation(10);
                    disable();
                }
            };
            new Handler().postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.4
                @Override // java.lang.Runnable
                public void run() {
                    if (tanxc_do.this.tanxc_goto != null) {
                        tanxc_do.this.tanxc_goto.enable();
                    }
                }
            }, 2000L);
        }
    }
}
