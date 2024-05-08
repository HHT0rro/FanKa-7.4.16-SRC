package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.dk;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.downloadlib.hc.w;
import com.ss.android.downloadlib.np.dk;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements com.ss.android.downloadad.api.dk {
    private static volatile dk dk = null;

    /* renamed from: m, reason: collision with root package name */
    private static String f38688m = "dk";
    private e ej = e.m(c.getContext());

    private dk() {
    }

    public static DownloadEventConfig ej() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog dk(Context context, String str, boolean z10, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, boolean z11, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (m(downloadModel.getId())) {
            if (z11) {
                m(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                dk(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.ej.m(context, i10, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) ve.m(downloadEventConfig, ej());
        final DownloadController downloadController2 = (DownloadController) ve.m(downloadController, dk());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.dk.m().m(downloadModel)) ? true : (c.w().optInt("disable_lp_dialog", 0) == 1) | z10) {
            this.ej.m(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        com.ss.android.downloadlib.hc.c.m(f38688m, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dk2 = c.ej().dk(new dk.m(context).m(downloadModel.getName()).dk("确认要下载此应用吗？").ej("确认").l("取消").m(new dk.InterfaceC0572dk() { // from class: com.ss.android.downloadlib.dk.2
            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void dk(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.l.m.m().m("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void ej(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.l.m.m().m("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }

            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void m(DialogInterface dialogInterface) {
                dk.this.ej.m(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.l.m.m().m("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }
        }).m(0).m());
        com.ss.android.downloadlib.l.m.m().m("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dk2;
    }

    public static dk m() {
        if (dk == null) {
            synchronized (dk.class) {
                if (dk == null) {
                    dk = new dk();
                }
            }
        }
        return dk;
    }

    @Override // com.ss.android.downloadad.api.dk
    public Dialog m(Context context, String str, boolean z10, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10) {
        return m(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, false);
    }

    @Override // com.ss.android.downloadad.api.dk
    public Dialog m(Context context, String str, boolean z10, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return m(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, false, iDownloadButtonClickListener);
    }

    public Dialog m(Context context, String str, boolean z10, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, boolean z11) {
        return m(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, z11, null);
    }

    public Dialog m(final Context context, final String str, final boolean z10, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i10, final boolean z11, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.np.dk.m(new dk.m<Dialog>() { // from class: com.ss.android.downloadlib.dk.1
            @Override // com.ss.android.downloadlib.np.dk.m
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Dialog dk() {
                return dk.this.dk(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, z11, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.dk
    public boolean m(Context context, long j10, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i10) {
        com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(j10);
        if (l10 != null) {
            this.ej.m(context, i10, downloadStatusChangeListener, l10.g());
            return true;
        }
        DownloadModel m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(j10);
        if (m10 == null) {
            return false;
        }
        this.ej.m(context, i10, downloadStatusChangeListener, m10);
        return true;
    }

    @Override // com.ss.android.downloadad.api.dk
    public boolean m(long j10, int i10) {
        DownloadModel m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(j10);
        if (m10 == null) {
            return false;
        }
        this.ej.m(m10.getDownloadUrl(), i10);
        return true;
    }

    public void m(long j10, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(j10);
        com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(j10);
        if (m10 == null && l10 != null) {
            m10 = l10.g();
        }
        if (m10 == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.ej) && !(downloadController instanceof com.ss.android.download.api.download.dk)) {
            downloadEventConfig.setDownloadScene(1);
            this.ej.m(m10.getDownloadUrl(), j10, 2, downloadEventConfig, downloadController);
        } else {
            dk(j10);
        }
    }

    public void dk(long j10) {
        DownloadModel m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(j10);
        com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(j10);
        if (m10 == null && l10 != null) {
            m10 = l10.g();
        }
        if (m10 == null) {
            return;
        }
        DownloadEventConfig dk2 = com.ss.android.downloadlib.addownload.dk.n.m().dk(j10);
        DownloadController ej = com.ss.android.downloadlib.addownload.dk.n.m().ej(j10);
        if (dk2 instanceof com.ss.android.download.api.download.ej) {
            dk2 = null;
        }
        if (ej instanceof com.ss.android.download.api.download.dk) {
            ej = null;
        }
        if (l10 == null) {
            if (dk2 == null) {
                dk2 = ej();
            }
            if (ej == null) {
                ej = dk();
            }
        } else {
            if (dk2 == null) {
                dk2 = new AdDownloadEventConfig.Builder().setClickButtonTag(l10.oa()).setRefer(l10.w()).setIsEnableV3Event(l10.sy()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (ej == null) {
                ej = l10.dp();
            }
        }
        DownloadEventConfig downloadEventConfig = dk2;
        downloadEventConfig.setDownloadScene(1);
        this.ej.m(m10.getDownloadUrl(), j10, 2, downloadEventConfig, ej);
    }

    @Override // com.ss.android.downloadad.api.dk
    public boolean m(long j10) {
        return (com.ss.android.downloadlib.addownload.dk.n.m().m(j10) == null && com.ss.android.downloadlib.addownload.dk.n.m().l(j10) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.dk
    public boolean m(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return m(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.dk
    public boolean m(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.np.dk.m(new dk.m<Boolean>() { // from class: com.ss.android.downloadlib.dk.3
            @Override // com.ss.android.downloadlib.np.dk.m
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Boolean dk() {
                return Boolean.valueOf(dk.this.dk(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController m(boolean z10) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z10) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dk(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadController2 = downloadController;
        if (!com.ss.android.download.api.ej.m.m(uri) || c.w().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? c.getContext() : context;
        String dk2 = com.ss.android.download.api.ej.m.dk(uri);
        if (downloadModel == null) {
            return w.m(context2, dk2).getType() == 5;
        }
        if (!TextUtils.isEmpty(dk2) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(dk2);
        }
        if (downloadController2 != null) {
            downloadController2.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadController2 = m(true);
        } else if (downloadModel.getDownloadUrl().startsWith("market")) {
            downloadController2 = m(true);
        } else {
            downloadController2 = dk();
        }
        com.ss.android.downloadlib.addownload.dk.np npVar = new com.ss.android.downloadlib.addownload.dk.np(downloadModel.getId(), downloadModel, (DownloadEventConfig) ve.m(downloadEventConfig, ej()), downloadController2);
        com.ss.android.downloadlib.addownload.dk.n.m().m(npVar.dk);
        com.ss.android.downloadlib.addownload.dk.n.m().m(npVar.f38586m, npVar.ej);
        com.ss.android.downloadlib.addownload.dk.n.m().m(npVar.f38586m, npVar.f38585l);
        if (ve.m(downloadModel) && DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 && com.ss.android.downloadlib.dk.m.m(npVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        ve.m(jSONObject, "market_url", uri.toString());
        ve.m(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.l.m.m().dk("market_click_open", jSONObject, npVar);
        com.ss.android.downloadlib.addownload.dk.hc m10 = w.m(context2, npVar, dk2);
        String m11 = ve.m(m10.dk(), "open_market");
        if (m10.getType() == 5) {
            com.ss.android.downloadlib.dk.m.m(m11, jSONObject, npVar, true);
            return true;
        }
        if (m10.getType() != 6) {
            return true;
        }
        ve.m(jSONObject, "error_code", Integer.valueOf(m10.m()));
        com.ss.android.downloadlib.l.m.m().dk("market_open_failed", jSONObject, npVar);
        if (com.ss.android.downloadlib.addownload.w.m(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController dk() {
        return m(false);
    }
}
