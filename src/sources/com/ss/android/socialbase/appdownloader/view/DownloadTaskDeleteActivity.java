package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.ej.c;
import com.ss.android.socialbase.appdownloader.ej.ej;
import com.ss.android.socialbase.appdownloader.ej.ve;
import com.ss.android.socialbase.appdownloader.l;
import com.ss.android.socialbase.appdownloader.w;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private Intent dk;

    /* renamed from: m, reason: collision with root package name */
    private c f38962m;

    private void dk() {
        Intent intent;
        if (this.f38962m != null || (intent = this.dk) == null) {
            return;
        }
        try {
            final boolean z10 = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                return;
            }
            String format = String.format(getString(w.m(this, "tt_appdownloader_notification_download_delete")), title);
            ej m10 = l.oa().m();
            ve m11 = m10 != null ? m10.m(this) : null;
            if (m11 == null) {
                m11 = new com.ss.android.socialbase.appdownloader.l.m(this);
            }
            int m12 = w.m(this, "tt_appdownloader_tip");
            int m13 = w.m(this, "tt_appdownloader_label_ok");
            int m14 = w.m(this, "tt_appdownloader_label_cancel");
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.CANCEL_WITH_NET_OPT, 0) == 1 && DownloadUtils.isNoWifiAndInNet() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z10 = true;
            }
            if (z10) {
                m13 = w.m(this, "tt_appdownloader_label_reserve_wifi");
                m14 = w.m(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(w.m(this, "tt_appdownloader_resume_in_wifi"));
            }
            m11.m(m12).m(format).m(m13, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (!z10) {
                        DownloadTaskDeleteActivity.this.m(downloadInfo, intExtra);
                    } else {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).dk(m14, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (z10) {
                        DownloadTaskDeleteActivity.this.m(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).m(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.f38962m = m11.m();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        m();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.dk = getIntent();
        dk();
        c cVar = this.f38962m;
        if (cVar != null && !cVar.dk()) {
            this.f38962m.m();
        } else if (this.f38962m == null) {
            finish();
        }
    }

    private void m() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(DownloadInfo downloadInfo, int i10) {
        com.ss.android.socialbase.appdownloader.ej.l dk = l.oa().dk();
        if (dk != null) {
            dk.m(downloadInfo);
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadNotificationEventListener(i10);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.onNotificationEvent(10, downloadInfo, "", "");
        }
        if (DownloadComponentManager.getAppContext() != null) {
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i10);
        }
    }
}
