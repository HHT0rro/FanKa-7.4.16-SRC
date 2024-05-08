package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.view.textclassifier.ConversationAction;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.ss.android.download.api.config.mj;
import com.ss.android.download.api.model.dk;
import com.ss.android.downloadad.api.m.dk;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.dk.n;
import com.ss.android.downloadlib.addownload.m.np;
import com.ss.android.downloadlib.addownload.sy;
import com.ss.android.downloadlib.e;
import com.ss.android.downloadlib.guide.install.m;
import com.ss.android.downloadlib.hc.oa;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.appdownloader.ej;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: l, reason: collision with root package name */
    private static m f38476l;
    private boolean dk;
    private dk ej;

    /* renamed from: m, reason: collision with root package name */
    public Intent f38477m = null;

    public static void dk(String str, com.ss.android.downloadad.api.m.m mVar) {
        Intent ej = ej(mVar);
        ej.addFlags(268435456);
        ej.putExtra("type", 11);
        ej.putExtra("package_name", str);
        if (c.getContext() != null) {
            c.getContext().startActivity(ej);
        }
    }

    private static Intent ej(@NonNull com.ss.android.downloadad.api.m.m mVar) {
        return new Intent(c.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void m(String str, String[] strArr) {
        Intent intent = new Intent(c.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (c.getContext() != null) {
            c.getContext().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        dk();
        this.f38477m = getIntent();
        c.dk(this);
        m();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f38477m = intent;
        c.dk(this);
        m();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        c.np().m(this, i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        dk dkVar;
        DownloadInfo dk;
        super.onStop();
        if (!this.dk || (dkVar = this.ej) == null) {
            return;
        }
        if (!TextUtils.isEmpty(dkVar.ch())) {
            dk = e.m(c.getContext()).m(this.ej.ch(), null, true);
        } else {
            dk = e.m(c.getContext()).dk(this.ej.m());
        }
        if (dk == null || dk.getCurBytes() < dk.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ej() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.ej():void");
    }

    public static void dk(String str, long j10, String str2) {
        Intent intent = new Intent(c.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        intent.putExtra("market_app_id", str2);
        if (c.getContext() != null) {
            c.getContext().startActivity(intent);
        }
    }

    public static void m(String str, com.ss.android.downloadad.api.m.m mVar) {
        Intent ej = ej(mVar);
        ej.addFlags(268435456);
        ej.putExtra("type", 2);
        ej.putExtra(ConversationAction.TYPE_OPEN_URL, str);
        if (c.getContext() != null) {
            c.getContext().startActivity(ej);
        }
    }

    public static void m(com.ss.android.downloadad.api.m.m mVar) {
        Intent ej = ej(mVar);
        ej.addFlags(268435456);
        ej.putExtra("type", 4);
        ej.putExtra("model_id", mVar.dk());
        if (c.getContext() != null) {
            c.getContext().startActivity(ej);
        }
    }

    public static void dk(@NonNull com.ss.android.downloadad.api.m.m mVar) {
        m(mVar, 5, "", "", "", "");
    }

    public static void dk(@NonNull com.ss.android.downloadad.api.m.m mVar, String str, String str2, String str3) {
        m(mVar, 7, str, str2, str3, "");
    }

    public static void dk(@NonNull com.ss.android.downloadad.api.m.m mVar, String str, String str2, String str3, String str4) {
        m(mVar, 20, str, str2, str3, str4);
    }

    private void dk() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void m(com.ss.android.downloadad.api.m.m mVar, m mVar2) {
        Intent ej = ej(mVar);
        ej.addFlags(268435456);
        ej.putExtra("type", 9);
        f38476l = mVar2;
        if (c.getContext() != null) {
            c.getContext().startActivity(ej);
        }
    }

    private void dk(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            mj mjVar = new mj() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                private WeakReference<Activity> ej;

                {
                    this.ej = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.mj
                public void m() {
                    oa.m(str);
                    ej.m(this.ej.get());
                }

                @Override // com.ss.android.download.api.config.mj
                public void m(String str2) {
                    oa.m(str, str2);
                    ej.m(this.ej.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    c.np().m(this, strArr, mjVar);
                    return;
                } catch (Exception e2) {
                    c.mj().m(e2, "requestPermission");
                    mjVar.m();
                    return;
                }
            }
            mjVar.m();
            return;
        }
        ej.m((Activity) this);
    }

    public static void m(long j10) {
        Intent intent = new Intent(c.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j10);
        if (c.getContext() != null) {
            c.getContext().startActivity(intent);
        }
    }

    private void dk(String str) {
        Intent hc2 = ve.hc(this, str);
        if (hc2 == null) {
            return;
        }
        try {
            try {
                hc2.addFlags(268435456);
                hc2.putExtra("start_only_for_android", true);
                startActivity(hc2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            ej.m((Activity) this);
        }
    }

    public static void m(String str, long j10, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(c.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (c.getContext() != null) {
            c.getContext().startActivity(intent);
        }
    }

    private void dk(long j10) {
        final dk l10 = n.m().l(j10);
        if (l10 == null) {
            com.ss.android.downloadlib.np.ej.m().m("showOpenAppDialogInner nativeModel null");
            ej.m((Activity) this);
            return;
        }
        com.ss.android.download.api.config.ve ej = c.ej();
        dk.m m10 = new dk.m(this).m("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(l10.un()) ? "刚刚下载的应用" : l10.un();
        ej.dk(m10.dk(String.format("%1$s已安装完成，是否立即打开？", objArr)).ej("打开").l("取消").m(false).m(ve.l(this, l10.np())).m(new dk.InterfaceC0572dk() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void dk(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.l.m.m().dk("market_openapp_cancel", l10);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                ej.m((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void ej(DialogInterface dialogInterface) {
                ej.m((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void m(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.dk.m.dk(l10);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                ej.m((Activity) TTDelegateActivity.this);
            }
        }).m(2).m());
        com.ss.android.downloadlib.l.m.m().dk("market_openapp_window_show", l10);
    }

    public static void m(String str, long j10, String str2) {
        Intent intent = new Intent(c.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        intent.putExtra("need_comment", str2);
        if (c.getContext() != null) {
            c.getContext().startActivity(intent);
        }
    }

    public static void m(String str, long j10) {
        Intent intent = new Intent(c.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        if (c.getContext() != null) {
            c.getContext().startActivity(intent);
        }
    }

    private void ej(long j10) {
        new com.ss.android.downloadlib.addownload.compliance.m(this, j10).show();
    }

    public static void m(@NonNull com.ss.android.downloadad.api.m.m mVar, String str) {
        m(mVar, 19, "", "", "", str);
    }

    public static void m(@NonNull com.ss.android.downloadad.api.m.m mVar, String str, String str2, String str3) {
        m(mVar, 8, str, str2, str3, "");
    }

    public static void m(@NonNull com.ss.android.downloadad.api.m.m mVar, String str, String str2, String str3, String str4) {
        m(mVar, 21, str, str2, str3, str4);
    }

    private static void m(@NonNull com.ss.android.downloadad.api.m.m mVar, int i10, String str, String str2, String str3, String str4) {
        Intent ej = ej(mVar);
        ej.addFlags(268435456);
        ej.putExtra("type", i10);
        if (!TextUtils.isEmpty(str2)) {
            ej.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            ej.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            ej.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            ej.putExtra("message_text", str);
        }
        ej.putExtra("model_id", mVar.dk());
        if (c.getContext() != null) {
            c.getContext().startActivity(ej);
        }
    }

    public void m() {
        Intent intent = this.f38477m;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                dk(this.f38477m.getStringExtra("permission_id_key"), this.f38477m.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                m(this.f38477m.getStringExtra(ConversationAction.TYPE_OPEN_URL));
                break;
            case 3:
            case 6:
            case 16:
            case 17:
            case 18:
            default:
                ej.m((Activity) this);
                break;
            case 4:
                dk(this.f38477m.getLongExtra("model_id", 0L));
                break;
            case 5:
                m(this.f38477m.getLongExtra("model_id", 0L), "");
                break;
            case 7:
            case 8:
            case 20:
            case 21:
                ej();
                break;
            case 9:
                m mVar = f38476l;
                if (mVar != null) {
                    mVar.m();
                }
                ej.m((Activity) this);
                break;
            case 10:
                ej(this.f38477m.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                dk(this.f38477m.getStringExtra("package_name"));
                break;
            case 12:
                com.ss.android.downloadlib.hc.e.m(this, this.f38477m.getStringExtra("package_name"), this.f38477m.getLongExtra("model_id", 0L), this.f38477m.getStringExtra("param"), this.f38477m.getStringExtra("ext_json"));
                ej.m((Activity) this);
                break;
            case 13:
                com.ss.android.downloadlib.hc.e.m(this, this.f38477m.getStringExtra("package_name"), this.f38477m.getLongExtra("model_id", 0L), this.f38477m.getStringExtra("need_comment"));
                ej.m((Activity) this);
                break;
            case 14:
                com.ss.android.downloadlib.hc.e.dk(this, this.f38477m.getStringExtra("package_name"), this.f38477m.getLongExtra("model_id", 0L), this.f38477m.getStringExtra("market_app_id"));
                ej.m((Activity) this);
                break;
            case 15:
                com.ss.android.downloadlib.hc.e.m(this, this.f38477m.getStringExtra("package_name"), this.f38477m.getLongExtra("model_id", 0L));
                ej.m((Activity) this);
                break;
            case 19:
                m(this.f38477m.getLongExtra("model_id", 0L), this.f38477m.getStringExtra("delete_button_text"));
                break;
        }
        this.f38477m = null;
    }

    private void m(long j10, String str) {
        if (sy.m() == null) {
            return;
        }
        com.ss.android.downloadad.api.m.dk l10 = n.m().l(j10);
        if (l10 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(l10.x());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - l10.fh()));
                jSONObject.putOpt("click_download_size", Long.valueOf(l10.iz()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.l.m.m().m("cancel_pause_reserve_wifi_dialog_show", jSONObject, l10);
            } else {
                com.ss.android.downloadlib.l.m.m().dk("pause_reserve_wifi_dialog_show", jSONObject, l10);
            }
        }
        np.m m10 = new np.m(this).m(false).m(sy.m());
        if (!TextUtils.isEmpty(str)) {
            m10.l(str).m(sy.dk());
        }
        m10.m().show();
        this.dk = true;
        this.ej = l10;
    }

    private void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra(ConversationAction.TYPE_OPEN_URL, str);
                intent.addFlags(268435456);
                if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            ej.m((Activity) this);
        }
    }
}
