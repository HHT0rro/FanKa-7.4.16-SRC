package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.mj;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.ej;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.downloadlib.hc.sy;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np implements hc, sy.m {

    /* renamed from: m, reason: collision with root package name */
    private static final String f38658m = "np";

    /* renamed from: c, reason: collision with root package name */
    private boolean f38659c;
    private SoftReference<IDownloadButtonClickListener> dh;
    private final com.ss.android.downloadlib.hc.sy dk;

    /* renamed from: e, reason: collision with root package name */
    private DownloadInfo f38660e;
    private e ej;

    /* renamed from: f, reason: collision with root package name */
    private SoftReference<OnItemClickListener> f38661f;

    /* renamed from: hc, reason: collision with root package name */
    private DownloadShortInfo f38662hc;

    /* renamed from: k, reason: collision with root package name */
    private DownloadEventConfig f38663k;

    /* renamed from: l, reason: collision with root package name */
    private l f38664l;
    private final boolean mj;

    /* renamed from: n, reason: collision with root package name */
    private final Map<Integer, Object> f38665n;
    private WeakReference<Context> np;

    /* renamed from: oa, reason: collision with root package name */
    private final IDownloadListener f38666oa;

    /* renamed from: q, reason: collision with root package name */
    private DownloadModel f38667q;

    /* renamed from: r, reason: collision with root package name */
    private long f38668r;
    private String sy;

    /* renamed from: t, reason: collision with root package name */
    private DownloadController f38669t;
    private long ve;

    /* renamed from: w, reason: collision with root package name */
    private ej f38670w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f38671x;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface dk {
        void m(long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface m {
        void m();
    }

    public np() {
        com.ss.android.downloadlib.hc.sy syVar = new com.ss.android.downloadlib.hc.sy(Looper.getMainLooper(), this);
        this.dk = syVar;
        this.f38665n = new ConcurrentHashMap();
        this.f38666oa = new e.m(syVar);
        this.f38668r = -1L;
        this.f38667q = null;
        this.f38663k = null;
        this.f38669t = null;
        this.ej = new e(this);
        this.f38664l = new l(syVar);
        this.mj = DownloadSetting.obtainGlobal().optBugFix("ttdownloader_callback_twice");
    }

    private void c() {
        SoftReference<OnItemClickListener> softReference = this.f38661f;
        if (softReference != null && softReference.get() != null) {
            this.f38661f.get().onItemClick(this.f38667q, ve(), sy());
            this.f38661f = null;
        } else {
            c.dk().m(getContext(), this.f38667q, sy(), ve());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.np;
        if (weakReference != null && weakReference.get() != null) {
            return this.np.get();
        }
        return c.getContext();
    }

    private void k() {
        ej ejVar = this.f38670w;
        if (ejVar != null && ejVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f38670w.cancel(true);
        }
        this.f38670w = new ej();
        if (!TextUtils.isEmpty(this.sy)) {
            com.ss.android.downloadlib.hc.dk.m(this.f38670w, this.f38667q.getDownloadUrl(), this.f38667q.getPackageName(), this.sy);
        } else {
            com.ss.android.downloadlib.hc.dk.m(this.f38670w, this.f38667q.getDownloadUrl(), this.f38667q.getPackageName());
        }
    }

    private boolean q() {
        if (DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            DownloadInfo downloadInfo = this.f38660e;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.f38660e.getCurBytes() <= 0) || this.f38660e.getStatus() == 0 || this.f38660e.getStatus() == -4) {
                return true;
            }
            return DownloadUtils.isDownloadSuccessAndFileNotExist(this.f38660e.getStatus(), this.f38660e.getSavePath(), this.f38660e.getName());
        }
        DownloadInfo downloadInfo2 = this.f38660e;
        if (downloadInfo2 == null) {
            return true;
        }
        return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(c.getContext()).canResume(this.f38660e.getId())) || this.f38660e.getStatus() == 0;
    }

    private void r() {
        String str = f38658m;
        com.ss.android.downloadlib.hc.c.m(str, "pICD", null);
        if (this.ej.l(this.f38660e)) {
            com.ss.android.downloadlib.hc.c.m(str, "pICD BC", null);
            n(false);
        } else {
            com.ss.android.downloadlib.hc.c.m(str, "pICD IC", null);
            c();
        }
    }

    @NonNull
    private DownloadController sy() {
        if (this.f38669t == null) {
            this.f38669t = new com.ss.android.download.api.download.dk();
        }
        return this.f38669t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo t() {
        if (this.f38662hc == null) {
            this.f38662hc = new DownloadShortInfo();
        }
        return this.f38662hc;
    }

    @NonNull
    private DownloadEventConfig ve() {
        DownloadEventConfig downloadEventConfig = this.f38663k;
        return downloadEventConfig == null ? new ej.m().m() : downloadEventConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z10) {
        Iterator<DownloadStatusChangeListener> iterator2 = e.m(this.f38665n).iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onDownloadStart(this.f38667q, sy());
        }
        int m10 = this.ej.m(c.getContext(), this.f38666oa);
        String str = f38658m;
        com.ss.android.downloadlib.hc.c.m(str, "beginDown id:" + m10, null);
        if (m10 != 0) {
            if (this.f38660e != null && !DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
                this.ej.m(this.f38660e, false);
            } else if (z10) {
                this.ej.m();
            }
        } else {
            DownloadInfo build = new DownloadInfo.Builder(this.f38667q.getDownloadUrl()).build();
            build.setStatus(-1);
            m(build);
            com.ss.android.downloadlib.l.m.m().m(this.f38668r, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.np.ej.m().dk("beginDown");
        }
        if (this.ej.m(ej())) {
            com.ss.android.downloadlib.hc.c.m(str, "beginDown IC id:" + m10, null);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(final boolean z10) {
        this.f38664l.m(new com.ss.android.downloadlib.addownload.dk.np(this.f38668r, this.f38667q, ve(), sy()));
        this.f38664l.m(0, 0L, 0L, new m() { // from class: com.ss.android.downloadlib.addownload.np.9
            @Override // com.ss.android.downloadlib.addownload.np.m
            public void m() {
                if (np.this.f38664l.m()) {
                    return;
                }
                np.this.e(z10);
            }
        });
    }

    public boolean ej() {
        DownloadInfo downloadInfo = this.f38660e;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public long l() {
        return this.ve;
    }

    public void n() {
        this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.np.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> iterator2 = e.m((Map<Integer, Object>) np.this.f38665n).iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onInstalled(np.this.t());
                }
            }
        });
    }

    public boolean np() {
        return c.w().optInt("quick_app_enable_switch", 0) == 0 && this.f38667q.getQuickAppModel() != null && !TextUtils.isEmpty(this.f38667q.getQuickAppModel().m()) && com.ss.android.downloadlib.addownload.ej.m(this.f38660e) && com.ss.android.downloadlib.hc.ve.m(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.f38667q.getQuickAppModel().m())));
    }

    public boolean w() {
        SoftReference<IDownloadButtonClickListener> softReference = this.dh;
        if (softReference == null) {
            return false;
        }
        return w.m(this.f38667q, softReference.get());
    }

    private boolean ej(int i10) {
        if (!np()) {
            return false;
        }
        int i11 = -1;
        String m10 = this.f38667q.getQuickAppModel().m();
        if (i10 == 1) {
            i11 = 5;
        } else if (i10 == 2) {
            i11 = 4;
        }
        DownloadModel downloadModel = this.f38667q;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean ej2 = com.ss.android.downloadlib.hc.w.ej(c.getContext(), m10);
        if (ej2) {
            com.ss.android.downloadlib.l.m.m().m(this.f38668r, i10);
            Message obtain = Message.obtain();
            obtain.what = i11;
            obtain.obj = Long.valueOf(this.f38667q.getId());
            com.ss.android.downloadlib.addownload.ej.m().m(this, i11, this.f38667q);
        } else {
            com.ss.android.downloadlib.l.m.m().m(this.f38668r, false, 0);
        }
        return ej2;
    }

    private void n(final boolean z10) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = f38658m;
        com.ss.android.downloadlib.hc.c.m(str, "pBCD", null);
        if (q()) {
            com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(this.f38668r);
            if (this.f38671x) {
                if (w()) {
                    if (l(false) && (downloadController2 = np.f38585l) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        m(z10, true);
                        return;
                    }
                    return;
                }
                m(z10, true);
                return;
            }
            if (this.f38667q.isAd() && (downloadController = np.f38585l) != null && downloadController.enableShowComplianceDialog() && np.dk != null && com.ss.android.downloadlib.addownload.compliance.dk.m().m(np.dk) && com.ss.android.downloadlib.addownload.compliance.dk.m().m(np)) {
                return;
            }
            m(z10, true);
            return;
        }
        com.ss.android.downloadlib.hc.c.m(str, "pBCD continue download, status:" + this.f38660e.getStatus(), null);
        DownloadInfo downloadInfo = this.f38660e;
        if (downloadInfo != null && (downloadModel = this.f38667q) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.f38660e.getStatus();
        final int id2 = this.f38660e.getId();
        final com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(this.f38660e);
        if (status != -2 && status != -1) {
            if (sy.m(status)) {
                if (this.f38667q.enablePause()) {
                    this.f38664l.m(true);
                    com.ss.android.downloadlib.ej.e.m().dk(com.ss.android.downloadlib.addownload.dk.n.m().l(this.f38668r));
                    if (com.ss.android.downloadlib.hc.np.m(m10).optInt("cancel_pause_optimise_switch", 0) == 1) {
                        com.ss.android.downloadlib.addownload.l.l.m().m(m10, status, new com.ss.android.downloadlib.addownload.l.e() { // from class: com.ss.android.downloadlib.addownload.np.6
                            @Override // com.ss.android.downloadlib.addownload.l.e
                            public void m(com.ss.android.downloadad.api.m.dk dkVar) {
                                if (np.this.f38660e == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                                    np.this.f38660e = Downloader.getInstance(c.getContext()).getDownloadInfo(id2);
                                }
                                np.this.ej.m(np.this.f38660e, z10);
                                if (np.this.f38660e != null && DownloadUtils.isWifi(c.getContext()) && np.this.f38660e.isPauseReserveOnWifi()) {
                                    np.this.f38660e.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.l.m.m().m("cancel_pause_reserve_wifi_cancel_on_wifi", m10);
                                } else {
                                    np npVar = np.this;
                                    npVar.m(id2, status, npVar.f38660e);
                                }
                            }
                        }, new com.ss.android.downloadlib.addownload.m.ej() { // from class: com.ss.android.downloadlib.addownload.np.5
                            @Override // com.ss.android.downloadlib.addownload.m.ej
                            public void delete() {
                                np.this.m(true);
                            }
                        });
                        return;
                    } else {
                        com.ss.android.downloadlib.addownload.l.c.m().m(m10, status, new com.ss.android.downloadlib.addownload.l.e() { // from class: com.ss.android.downloadlib.addownload.np.7
                            @Override // com.ss.android.downloadlib.addownload.l.e
                            public void m(com.ss.android.downloadad.api.m.dk dkVar) {
                                if (np.this.f38660e == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                                    np.this.f38660e = Downloader.getInstance(c.getContext()).getDownloadInfo(id2);
                                }
                                np.this.ej.m(np.this.f38660e, z10);
                                if (np.this.f38660e != null && DownloadUtils.isWifi(c.getContext()) && np.this.f38660e.isPauseReserveOnWifi()) {
                                    np.this.f38660e.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.l.m.m().dk("pause_reserve_wifi_cancel_on_wifi", m10);
                                } else {
                                    np npVar = np.this;
                                    npVar.m(id2, status, npVar.f38660e);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.ej.m(this.f38660e, z10);
            m(id2, status, this.f38660e);
            return;
        }
        this.ej.m(this.f38660e, z10);
        if (m10 != null) {
            m10.e(System.currentTimeMillis());
            m10.w(this.f38660e.getCurBytes());
        }
        this.f38660e.setDownloadFromReserveWifi(false);
        this.f38664l.m(new com.ss.android.downloadlib.addownload.dk.np(this.f38668r, this.f38667q, ve(), sy()));
        this.f38664l.m(id2, this.f38660e.getCurBytes(), this.f38660e.getTotalBytes(), new m() { // from class: com.ss.android.downloadlib.addownload.np.3
            @Override // com.ss.android.downloadlib.addownload.np.m
            public void m() {
                if (np.this.f38664l.m()) {
                    return;
                }
                np npVar = np.this;
                npVar.m(id2, status, npVar.f38660e);
            }
        });
        if (status == -2 && com.ss.android.downloadlib.hc.np.m(m10).optInt("show_pause_continue_toast", 0) == 1) {
            com.ss.android.downloadlib.hc.m().dk().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.np.4
                @Override // java.lang.Runnable
                public void run() {
                    c.ej().m(13, c.getContext(), np.this.f38667q, "已恢复下载", null, 0);
                }
            }, 500L);
        }
    }

    public boolean l(boolean z10) {
        SoftReference<IDownloadButtonClickListener> softReference = this.dh;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z10) {
                    this.dh.get().handleComplianceDialog(true);
                } else {
                    this.dh.get().handleMarketFailedComplianceDialog();
                }
                this.dh = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.np.ej.m().dk("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.np.ej.m().dk("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void hc() {
        if (this.f38665n.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> iterator2 = e.m(this.f38665n).iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onIdle();
        }
        DownloadInfo downloadInfo = this.f38660e;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public np dk(Context context) {
        if (context != null) {
            this.np = new WeakReference<>(context);
        }
        c.dk(context);
        return this;
    }

    private void np(boolean z10) {
        if (com.ss.android.downloadlib.hc.np.dk(this.f38667q).optInt("notification_opt_2") == 1 && this.f38660e != null) {
            DownloadNotificationManager.getInstance().cancelNotification(this.f38660e.getId());
        }
        n(z10);
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public np dk(int i10, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (c.w().optInt("back_use_softref_listener") == 1) {
                this.f38665n.put(Integer.valueOf(i10), downloadStatusChangeListener);
            } else if (c.w().optInt("use_weakref_listener") == 1) {
                this.f38665n.put(Integer.valueOf(i10), new WeakReference(downloadStatusChangeListener));
            } else {
                this.f38665n.put(Integer.valueOf(i10), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public boolean dk() {
        return this.f38659c;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public void dk(final int i10) {
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.ej.m(this.f38668r);
        if (!com.ss.android.downloadlib.addownload.dk.n.m().np(this.f38668r).u()) {
            com.ss.android.downloadlib.np.ej.m().m("handleDownload ModelBox !isStrictValid");
        }
        if (this.ej.m(i10, this.f38667q)) {
            com.ss.android.downloadlib.addownload.compliance.n.m().m(this.ej.f38591m, new com.ss.android.downloadlib.addownload.compliance.e() { // from class: com.ss.android.downloadlib.addownload.np.1
                @Override // com.ss.android.downloadlib.addownload.compliance.e
                public void m(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.ss.android.downloadlib.hc.e.m(np.this.getContext(), np.this.ej.f38591m, str, jSONObject, true, i10)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.n.m().m(1, np.this.ej.f38591m, jSONObject);
                            int i11 = i10;
                            if (i11 == 1) {
                                Logger.d(np.f38658m, "miui new rollback fail: handleDownload id:" + np.this.f38668r + ",tryPerformButtonClick:", null);
                                np.this.ej(true);
                            } else if (i11 == 2) {
                                Logger.d(np.f38658m, "miui new rollback fail: handleDownload id:" + np.this.f38668r + ",tryPerformButtonClick:", null);
                                np.this.dk(true);
                            }
                        } else {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.ss.android.downloadlib.addownload.compliance.n.m().m(0, np.this.ej.f38591m, jSONObject);
                        }
                    } catch (Exception e2) {
                        com.ss.android.downloadlib.np.ej.m().m(e2, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.e
                public void m() {
                    int i11 = i10;
                    if (i11 == 1) {
                        Logger.d(np.f38658m, "miui new get miui deeplink fail: handleDownload id:" + np.this.f38668r + ",tryPerformButtonClick:", null);
                        np.this.ej(true);
                        return;
                    }
                    if (i11 != 2) {
                        return;
                    }
                    Logger.d(np.f38658m, "miui new get miui deeplink fail: handleDownload id:" + np.this.f38668r + ",tryPerformButtonClick:", null);
                    np.this.dk(true);
                }
            });
            return;
        }
        if (this.ej.m(getContext(), i10, this.f38671x)) {
            return;
        }
        boolean ej2 = ej(i10);
        if (i10 == 1) {
            if (ej2) {
                return;
            }
            com.ss.android.downloadlib.hc.c.m(f38658m, "handleDownload id:" + this.f38668r + ",pIC:", null);
            ej(true);
            return;
        }
        if (i10 == 2 && !ej2) {
            com.ss.android.downloadlib.hc.c.m(f38658m, "handleDownload id:" + this.f38668r + ",pBC:", null);
            dk(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public np dk(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.np.ej.m().m("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.np.ej.m().m(false, "setDownloadModel id=0");
                if (DownloadSetting.obtainGlobal().optBugFix("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.dk.n.m().m(downloadModel);
            this.f38668r = downloadModel.getId();
            this.f38667q = downloadModel;
            if (w.m(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(this.f38668r);
                if (l10 != null && l10.ve() != 3) {
                    l10.np(3L);
                    com.ss.android.downloadlib.addownload.dk.w.m().m(l10);
                }
            }
        }
        return this;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ej extends AsyncTask<String, Void, DownloadInfo> {
        private ej() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (np.this.f38667q != null && !TextUtils.isEmpty(np.this.f38667q.getFilePath())) {
                if (TextUtils.isEmpty(str)) {
                    downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(str2, np.this.f38667q.getFilePath());
                } else {
                    downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(Downloader.getInstance(c.getContext()).getDownloadId(str, np.this.f38667q.getFilePath()));
                }
            }
            if (downloadInfo != null) {
                return downloadInfo;
            }
            if (!TextUtils.isEmpty(str)) {
                return com.ss.android.socialbase.appdownloader.l.oa().m(c.getContext(), str);
            }
            return com.ss.android.socialbase.appdownloader.l.oa().m(c.getContext(), str2);
        }

        @Override // android.os.AsyncTask
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || np.this.f38667q == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.dk.ej m10 = com.ss.android.downloadlib.hc.ve.m(np.this.f38667q.getPackageName(), np.this.f38667q.getVersionCode(), np.this.f38667q.getVersionName());
                com.ss.android.downloadlib.addownload.dk.e.m().m(np.this.f38667q.getVersionCode(), m10.dk(), com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo));
                boolean m11 = m10.m();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (m11 || !Downloader.getInstance(c.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(c.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (np.this.f38660e == null || np.this.f38660e.getStatus() != -4) {
                        np.this.f38660e = downloadInfo;
                        if (np.this.mj) {
                            Downloader.getInstance(c.getContext()).setMainThreadListener(np.this.f38660e.getId(), np.this.f38666oa, false);
                        } else {
                            Downloader.getInstance(c.getContext()).setMainThreadListener(np.this.f38660e.getId(), np.this.f38666oa);
                        }
                    } else {
                        np.this.f38660e = null;
                    }
                    np.this.ej.m(np.this.f38660e, np.this.t(), e.m((Map<Integer, Object>) np.this.f38665n));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(c.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                        np.this.f38660e = null;
                    }
                    if (np.this.f38660e != null) {
                        Downloader.getInstance(c.getContext()).removeTaskMainListener(np.this.f38660e.getId());
                        if (np.this.mj) {
                            Downloader.getInstance(np.this.getContext()).setMainThreadListener(np.this.f38660e.getId(), np.this.f38666oa, false);
                        } else {
                            Downloader.getInstance(np.this.getContext()).setMainThreadListener(np.this.f38660e.getId(), np.this.f38666oa);
                        }
                    }
                    if (!m11) {
                        Iterator<DownloadStatusChangeListener> iterator2 = e.m((Map<Integer, Object>) np.this.f38665n).iterator2();
                        while (iterator2.hasNext()) {
                            iterator2.next().onIdle();
                        }
                        np.this.f38660e = null;
                    } else {
                        np npVar = np.this;
                        npVar.f38660e = new DownloadInfo.Builder(npVar.f38667q.getDownloadUrl()).build();
                        np.this.f38660e.setStatus(-3);
                        np.this.ej.m(np.this.f38660e, np.this.t(), e.m((Map<Integer, Object>) np.this.f38665n));
                    }
                }
                np.this.ej.ej(np.this.f38660e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void ej(boolean z10) {
        if (z10) {
            com.ss.android.downloadlib.l.m.m().m(this.f38668r, 1);
        }
        r();
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public void e() {
        com.ss.android.downloadlib.addownload.dk.n.m().n(this.f38668r);
    }

    public void dk(boolean z10) {
        np(z10);
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public np dk(DownloadController downloadController) {
        JSONObject extra;
        this.f38669t = downloadController;
        if (com.ss.android.downloadlib.hc.np.dk(this.f38667q).optInt("force_auto_open") == 1) {
            sy().setLinkMode(1);
        }
        if (DownloadSetting.obtainGlobal().optBugFix("fix_show_dialog") && (extra = this.f38667q.getExtra()) != null && extra.optInt("subprocess") > 0) {
            sy().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.dk.n.m().m(this.f38668r, sy());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public np dk(DownloadEventConfig downloadEventConfig) {
        this.f38663k = downloadEventConfig;
        this.f38671x = ve().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.dk.n.m().m(this.f38668r, ve());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public hc m(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.f38661f = null;
        } else {
            this.f38661f = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public void m() {
        this.f38659c = true;
        com.ss.android.downloadlib.addownload.dk.n.m().m(this.f38668r, ve());
        com.ss.android.downloadlib.addownload.dk.n.m().m(this.f38668r, sy());
        this.ej.m(this.f38668r);
        k();
        if (c.w().optInt("enable_empty_listener", 1) == 1 && this.f38665n.get(Integer.MIN_VALUE) == null) {
            dk(Integer.MIN_VALUE, new com.ss.android.download.api.config.m());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public boolean m(int i10) {
        if (i10 == 0) {
            this.f38665n.clear();
        } else {
            this.f38665n.remove(Integer.valueOf(i10));
        }
        if (this.f38665n.isEmpty()) {
            this.f38659c = false;
            this.ve = System.currentTimeMillis();
            if (this.f38660e != null) {
                Downloader.getInstance(c.getContext()).removeTaskMainListener(this.f38660e.getId());
            }
            ej ejVar = this.f38670w;
            if (ejVar != null && ejVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f38670w.cancel(true);
            }
            this.ej.m(this.f38660e);
            String str = f38658m;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f38660e;
            sb2.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.hc.c.m(str, sb2.toString(), null);
            this.dk.removeCallbacksAndMessages(null);
            this.f38662hc = null;
            this.f38660e = null;
            return true;
        }
        if (this.f38665n.size() == 1 && this.f38665n.containsKey(Integer.MIN_VALUE)) {
            this.ej.dk(this.f38660e);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public void m(boolean z10) {
        if (this.f38660e != null) {
            if (z10) {
                com.ss.android.socialbase.appdownloader.ej.l dk2 = com.ss.android.socialbase.appdownloader.l.oa().dk();
                if (dk2 != null) {
                    dk2.m(this.f38660e);
                }
                Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(this.f38660e.getId(), true);
                return;
            }
            Intent intent = new Intent(c.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f38660e.getId());
            c.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public hc m(long j10) {
        if (j10 != 0) {
            DownloadModel m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(j10);
            if (m10 != null) {
                this.f38667q = m10;
                this.f38668r = j10;
                this.ej.m(j10);
            }
        } else {
            com.ss.android.downloadlib.np.ej.m().m(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.hc.sy.m
    public void m(Message message) {
        if (message != null && this.f38659c && message.what == 3) {
            this.f38660e = (DownloadInfo) message.obj;
            this.ej.m(message, t(), this.f38665n);
        }
    }

    public void m(boolean z10, final boolean z11) {
        if (z10) {
            com.ss.android.downloadlib.l.m.m().m(this.f38668r, 2);
        }
        if (!com.ss.android.downloadlib.hc.ve.m()) {
            if (!com.ss.android.downloadlib.hc.oa.dk(g.f36124j) && !sy().enableNewActivity()) {
                this.f38667q.setFilePath(this.ej.dk());
            }
        } else if (!com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_VIDEO") && !sy().enableNewActivity()) {
            this.f38667q.setFilePath(this.ej.dk());
        }
        if (com.ss.android.downloadlib.hc.np.ej(this.f38667q) == 0) {
            com.ss.android.downloadlib.hc.c.m(f38658m, "pBCD not start", null);
            this.ej.m(new mj() { // from class: com.ss.android.downloadlib.addownload.np.8
                @Override // com.ss.android.download.api.config.mj
                public void m() {
                    com.ss.android.downloadlib.hc.c.m(np.f38658m, "pBCD start download", null);
                    np.this.hc(z11);
                }

                @Override // com.ss.android.download.api.config.mj
                public void m(String str) {
                    com.ss.android.downloadlib.hc.c.m(np.f38658m, "pBCD onDenied", null);
                }
            });
        } else {
            hc(z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i10, int i11, @NonNull DownloadInfo downloadInfo) {
        if (DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            if (i11 != -3 && !DownloadProcessDispatcher.getInstance().canResume(i10)) {
                m(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.l.oa().m(c.getContext(), i10, i11);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.l.oa().m(c.getContext(), i10, i11);
    }

    private void m(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.dk.sendMessage(obtain);
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public hc m(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.sy = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.hc
    public hc m(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.dh = null;
        } else {
            this.dh = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
