package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.compliance.l;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.hc.ve;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m extends Dialog {

    /* renamed from: c, reason: collision with root package name */
    private long f38516c;
    private TextView dk;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f38517e;
    private TextView ej;

    /* renamed from: hc, reason: collision with root package name */
    private ClipImageView f38518hc;

    /* renamed from: l, reason: collision with root package name */
    private TextView f38519l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f38520m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f38521n;
    private TextView np;

    /* renamed from: oa, reason: collision with root package name */
    private final long f38522oa;
    private final com.ss.android.downloadlib.addownload.dk.dk ve;

    /* renamed from: w, reason: collision with root package name */
    private Activity f38523w;

    public m(@NonNull Activity activity, long j10) {
        super(activity);
        this.f38523w = activity;
        this.f38522oa = j10;
        this.ve = ej.m().get(Long.valueOf(j10));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.ej.m(this.f38523w);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ve == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f38516c = this.ve.dk;
        m();
        hc.dk("lp_app_dialog_show", this.f38516c);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.m.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                hc.m("lp_app_dialog_cancel", m.this.f38516c);
            }
        });
    }

    private void m() {
        this.f38520m = (TextView) findViewById(R.id.tv_app_name);
        this.dk = (TextView) findViewById(R.id.tv_app_version);
        this.ej = (TextView) findViewById(R.id.tv_app_developer);
        this.f38519l = (TextView) findViewById(R.id.tv_app_detail);
        this.np = (TextView) findViewById(R.id.tv_app_privacy);
        this.f38521n = (TextView) findViewById(R.id.tv_give_up);
        this.f38518hc = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f38517e = (LinearLayout) findViewById(R.id.ll_download);
        this.f38520m.setText(ve.m(this.ve.np, "--"));
        this.dk.setText("版本号：" + ve.m(this.ve.f38562n, "--"));
        this.ej.setText("开发者：" + ve.m(this.ve.f38559hc, "应用信息正在完善中"));
        this.f38518hc.setRoundRadius(ve.m(c.getContext(), 8.0f));
        this.f38518hc.setBackgroundColor(Color.parseColor("#EBEBEB"));
        l.m().m(this.f38522oa, new l.m() { // from class: com.ss.android.downloadlib.addownload.compliance.m.2
            @Override // com.ss.android.downloadlib.addownload.compliance.l.m
            public void m(Bitmap bitmap) {
                if (bitmap != null) {
                    m.this.f38518hc.setImageBitmap(bitmap);
                } else {
                    hc.m(8, m.this.f38516c);
                }
            }
        });
        this.f38519l.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dk.m().m(m.this.f38523w);
                AppDetailInfoActivity.m(m.this.f38523w, m.this.f38522oa);
                hc.m("lp_app_dialog_click_detail", m.this.f38516c);
            }
        });
        this.np.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dk.m().m(m.this.f38523w);
                AppPrivacyPolicyActivity.m(m.this.f38523w, m.this.f38522oa);
                hc.m("lp_app_dialog_click_privacy", m.this.f38516c);
            }
        });
        this.f38521n.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.dismiss();
                hc.m("lp_app_dialog_click_giveup", m.this.f38516c);
            }
        });
        this.f38517e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hc.m("lp_app_dialog_click_download", m.this.f38516c);
                dk.m().dk(m.this.f38516c);
                m.this.dismiss();
            }
        });
    }
}
