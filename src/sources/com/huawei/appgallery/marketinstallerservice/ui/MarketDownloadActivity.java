package com.huawei.appgallery.marketinstallerservice.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.appgallery.marketinstallerservice.R$id;
import com.huawei.appgallery.marketinstallerservice.R$layout;
import com.huawei.appgallery.marketinstallerservice.R$string;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.ui.a;
import com.huawei.secure.android.common.activity.SafeActivity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MarketDownloadActivity extends SafeActivity implements ka.b, a.InterfaceC0259a {

    /* renamed from: c, reason: collision with root package name */
    public ka.a f27631c = new ka.c(this, this);

    /* renamed from: d, reason: collision with root package name */
    public TextView f27632d = null;

    /* renamed from: e, reason: collision with root package name */
    public TextView f27633e = null;

    /* renamed from: f, reason: collision with root package name */
    public ProgressBar f27634f = null;

    /* renamed from: g, reason: collision with root package name */
    public View f27635g = null;

    /* renamed from: h, reason: collision with root package name */
    public AlertDialog f27636h = null;

    /* renamed from: i, reason: collision with root package name */
    public AlertDialog f27637i = null;

    /* renamed from: j, reason: collision with root package name */
    public AlertDialog f27638j = null;

    /* renamed from: k, reason: collision with root package name */
    public AlertDialog f27639k = null;

    /* renamed from: l, reason: collision with root package name */
    public int f27640l = 0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f27641m = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarketDownloadActivity.this.f();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            MarketDownloadActivity.this.g();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (dialogInterface == null || MarketDownloadActivity.this.isFinishing()) {
                return;
            }
            dialogInterface.dismiss();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
            intent.putExtra("use_emui_ui", true);
            intent.setPackage("com.android.settings");
            try {
                MarketDownloadActivity.this.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                fa.a.b("MarketDownloadActivity", "can not go Settings", e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e implements DialogInterface.OnDismissListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (MarketDownloadActivity.this.f27631c != null) {
                MarketDownloadActivity.this.f27631c.a(-1, 0, 0);
            }
            MarketDownloadActivity.this.finish();
        }
    }

    @Override // com.huawei.appgallery.marketinstallerservice.ui.a.InterfaceC0259a
    public void a() {
        this.f27631c.a();
    }

    @Override // ka.b
    public void a(int i10) {
        e(i10);
    }

    @Override // ka.b
    public void a(int i10, int i11) {
        View view;
        TextView textView;
        if (i10 == 1 && this.f27634f != null && (textView = this.f27633e) != null) {
            textView.setText(ea.a.a(i11));
            this.f27634f.setProgress(i11);
            return;
        }
        if (i10 != 3 || (view = this.f27635g) == null) {
            return;
        }
        view.setClickable(false);
        TextView textView2 = this.f27632d;
        if (textView2 != null && this.f27633e != null) {
            textView2.setText(getResources().getString(R$string.market_install_installing_market));
            this.f27633e.setVisibility(8);
        }
        AlertDialog alertDialog = this.f27639k;
        if (alertDialog == null || !alertDialog.isShowing() || isFinishing()) {
            return;
        }
        this.f27639k.setCancelable(false);
        this.f27639k.dismiss();
    }

    @Override // ka.b
    public void a(MarketInfo marketInfo) {
        TextView textView = this.f27632d;
        if (textView != null) {
            textView.setText(this.f27641m ? getResources().getString(R$string.market_install_updating_market) : getResources().getString(R$string.market_install_app_dl_installing, ""));
        }
    }

    @Override // com.huawei.appgallery.marketinstallerservice.ui.a.InterfaceC0259a
    public void b() {
        this.f27631c.e();
        finish();
    }

    public final void b(Dialog dialog) {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        dialog.show();
    }

    @Override // ka.b
    public void c() {
        fa.a.d("MarketDownloadActivity", "show net setting dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R$string.market_install_no_available_network_prompt);
        builder.setPositiveButton(R$string.market_install_net_setting, new d());
        builder.setNegativeButton(R$string.market_install_cancel, (DialogInterface.OnClickListener) null);
        builder.setOnDismissListener(new e());
        AlertDialog create = builder.create();
        this.f27637i = create;
        create.setCancelable(true);
        b(this.f27637i);
    }

    @Override // ka.b
    public void d() {
        fa.a.d("MarketDownloadActivity", "show market download dialog.");
        this.f27636h = new AlertDialog.Builder(this).create();
        View inflate = LayoutInflater.from(this).inflate(getResources().getLayout(R$layout.market_install_app_dl_progress_dialog), (ViewGroup) null);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R$id.third_app_dl_progressbar);
        this.f27634f = progressBar;
        progressBar.setMax(100);
        this.f27632d = (TextView) inflate.findViewById(R$id.third_app_warn_text);
        this.f27633e = (TextView) inflate.findViewById(R$id.third_app_dl_progress_text);
        View findViewById = inflate.findViewById(R$id.cancel_bg);
        this.f27635g = findViewById;
        findViewById.setOnClickListener(new a());
        this.f27636h.setView(inflate);
        this.f27636h.setCancelable(false);
        this.f27636h.setCanceledOnTouchOutside(false);
        this.f27633e.setText(ea.a.a(0));
        b(this.f27636h);
    }

    public final void e(int i10) {
        AlertDialog alertDialog = this.f27636h;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f27636h.dismiss();
        }
        AlertDialog alertDialog2 = this.f27637i;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.f27637i.dismiss();
        }
        int i11 = this.f27640l;
        if (i11 == 0) {
            Toast.makeText(this, getResources().getString(R$string.market_install_install_failed), 0).show();
        } else if (i11 == 2) {
            AlertDialog a10 = com.huawei.appgallery.marketinstallerservice.ui.a.a(this, i10, this, this.f27631c.d().getAppName());
            this.f27638j = a10;
            b(a10);
            return;
        }
        finish();
    }

    public void f() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getText(R$string.market_install_app_download_cancels));
        builder.setPositiveButton(getResources().getText(R$string.market_install_confirm), new b());
        builder.setNegativeButton(R$string.market_install_cancel, (DialogInterface.OnClickListener) null);
        builder.setOnDismissListener(new c());
        AlertDialog create = builder.create();
        this.f27639k = create;
        create.show();
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void finish() {
        if (isFinishing()) {
            return;
        }
        super.finish();
    }

    public final void g() {
        fa.a.d("MarketDownloadActivity", "market cancelDownload");
        ka.a aVar = this.f27631c;
        if (aVar != null) {
            aVar.c();
            this.f27631c.a(-5, 0, 0);
        }
        this.f27636h.dismiss();
        finish();
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (1000 == i10 && this.f27631c != null) {
            int intExtra = intent != null ? intent.getIntExtra("android.intent.extra.INSTALL_RESULT", -10000) : -10000;
            if (i11 == -1) {
                fa.a.d("MarketDownloadActivity", "market install succeed");
                this.f27631c.a(0, 0, 0);
            } else {
                if (i11 != 0) {
                    fa.a.d("MarketDownloadActivity", "market install failed");
                    e(-2);
                    this.f27631c.b(-2, 0, 0, intExtra);
                    return;
                }
                fa.a.d("MarketDownloadActivity", "market install userCancel");
                this.f27631c.a(-5, 0, 0);
            }
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            r0 = 1
            r8.requestWindowFeature(r0)
            super.onCreate(r9)
            com.huawei.secure.android.common.intent.SafeIntent r9 = new com.huawei.secure.android.common.intent.SafeIntent
            android.content.Intent r0 = r8.getIntent()
            r9.<init>(r0)
            java.lang.String r0 = "callback_key"
            java.lang.String r0 = r9.getStringExtra(r0)
            java.lang.String r1 = "market_info_key"
            java.util.ArrayList r1 = r9.getParcelableArrayListExtra(r1)
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L33
            int r4 = r1.size()
            if (r4 == 0) goto L33
            java.lang.Object r1 = r1.get(r2)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            boolean r4 = r1 instanceof com.huawei.appgallery.marketinstallerservice.api.MarketInfo
            if (r4 == 0) goto L33
            com.huawei.appgallery.marketinstallerservice.api.MarketInfo r1 = (com.huawei.appgallery.marketinstallerservice.api.MarketInfo) r1
            goto L34
        L33:
            r1 = r3
        L34:
            if (r1 != 0) goto L4c
            java.lang.String r3 = "service_url_key"
            java.lang.String r3 = r9.getStringExtra(r3)
            java.lang.String r4 = "sub_system_key"
            java.lang.String r4 = r9.getStringExtra(r4)
            java.lang.String r5 = "market_pkg_key"
            java.lang.String r5 = r9.getStringExtra(r5)
            r7 = r5
            r5 = r3
            r3 = r7
            goto L4e
        L4c:
            r4 = r3
            r5 = r4
        L4e:
            java.lang.String r6 = "fail_result_type_key"
            int r6 = r9.getIntExtra(r6, r2)
            r8.f27640l = r6
            com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec r6 = new com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec
            r6.<init>()
            r6.setMarketInfo(r1)
            r6.setServerUrl(r5)
            r6.setSubsystem(r4)
            r6.setMarketPkg(r3)
            int r1 = r8.f27640l
            r6.setFailResultPromptType(r1)
            java.lang.String r1 = "is_update_key"
            boolean r9 = r9.getBooleanExtra(r1, r2)
            r8.f27641m = r9
            ka.a r9 = r8.f27631c
            if (r9 == 0) goto L7b
            r9.a(r6, r0)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f27636h;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f27636h.dismiss();
        }
        AlertDialog alertDialog2 = this.f27637i;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.f27637i.dismiss();
        }
        AlertDialog alertDialog3 = this.f27638j;
        if (alertDialog3 == null || !alertDialog3.isShowing()) {
            return;
        }
        this.f27638j.dismiss();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.f27631c != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            int i10 = extras.getInt("android.content.pm.extra.STATUS");
            if (i10 != 0) {
                this.f27631c.b(-2, 0, 0, i10);
                e(-2);
                return;
            }
            this.f27631c.a(0, 0, 0);
        }
        finish();
    }
}
