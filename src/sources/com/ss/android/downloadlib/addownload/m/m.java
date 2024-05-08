package com.ss.android.downloadlib.addownload.m;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.dk;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.dk.n;
import com.ss.android.downloadlib.e;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {
    private static m dk = null;

    /* renamed from: m, reason: collision with root package name */
    private static final String f38635m = "m";

    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.dk.m> ej;

    /* renamed from: l, reason: collision with root package name */
    private boolean f38636l = false;

    /* renamed from: n, reason: collision with root package name */
    private dk f38637n;
    private String np;

    /* renamed from: com.ss.android.downloadlib.addownload.m.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0575m {
        void m();
    }

    private m() {
        dk dkVar = new dk();
        this.f38637n = dkVar;
        this.ej = dkVar.m("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static m m() {
        if (dk == null) {
            dk = new m();
        }
        return dk;
    }

    public void dk(String str) {
        if (TextUtils.isEmpty(str)) {
            this.np = "";
        } else if (TextUtils.equals(this.np, str)) {
            this.np = "";
        }
    }

    private boolean m(Activity activity, DownloadInfo downloadInfo, boolean z10, InterfaceC0575m interfaceC0575m) {
        if (downloadInfo == null) {
            try {
                if (this.ej.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z11 = true;
            if (downloadInfo != null && this.ej.isEmpty()) {
                m(activity, new com.ss.android.downloadlib.addownload.dk.m(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z10, interfaceC0575m);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.dk.m> copyOnWriteArrayList = this.ej;
            ListIterator<com.ss.android.downloadlib.addownload.dk.m> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z11 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.dk.m previous = listIterator.previous();
                if (previous != null && !ve.np(c.getContext(), previous.f38578l) && ve.m(previous.f38577hc)) {
                    if (new File(previous.f38577hc).lastModified() >= lastModified) {
                        m(activity, previous, z10, interfaceC0575m);
                    } else {
                        m(activity, new com.ss.android.downloadlib.addownload.dk.m(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z10, interfaceC0575m);
                    }
                }
            }
            com.ss.android.downloadlib.hc.c.m(f38635m, "tryShowInstallDialog isShow:" + z11, null);
            return z11;
        }
        return false;
    }

    @MainThread
    public boolean m(Activity activity, boolean z10, InterfaceC0575m interfaceC0575m) {
        if (c.w().optInt("disable_install_app_dialog") == 1 || this.f38636l) {
            return false;
        }
        return m(activity, m(activity), z10, interfaceC0575m);
    }

    public void m(Context context, com.ss.android.downloadlib.addownload.dk.m mVar, boolean z10, InterfaceC0575m interfaceC0575m) {
        this.ej.clear();
        m(context, mVar, interfaceC0575m, z10);
        this.f38636l = true;
        e.m(context).ej();
        this.f38637n.dk("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.hc.c.m(f38635m, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo m(Context context) {
        long dk2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            dk2 = e.m(context).dk();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (c.w().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j10 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !ve.np(context, downloadInfo2.getPackageName()) && ve.m(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= dk2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j10 == 0 || lastModified > j10)) {
                                downloadInfo = downloadInfo2;
                                j10 = lastModified;
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void m(long j10, long j11, long j12, String str, String str2, String str3, String str4) {
        for (int i10 = 0; i10 < this.ej.size(); i10++) {
            com.ss.android.downloadlib.addownload.dk.m mVar = this.ej.get(i10);
            if (mVar != null && mVar.dk == j11) {
                this.ej.set(i10, new com.ss.android.downloadlib.addownload.dk.m(j10, j11, j12, str, str2, str3, str4));
                this.f38637n.m("sp_ad_install_back_dialog", "key_uninstalled_list", this.ej);
                return;
            }
        }
        this.ej.add(new com.ss.android.downloadlib.addownload.dk.m(j10, j11, j12, str, str2, str3, str4));
        this.f38637n.m("sp_ad_install_back_dialog", "key_uninstalled_list", this.ej);
    }

    private void m(final Context context, final com.ss.android.downloadlib.addownload.dk.m mVar, final InterfaceC0575m interfaceC0575m, boolean z10) {
        final com.ss.android.downloadad.api.m.dk l10 = n.m().l(mVar.dk);
        if (l10 == null) {
            com.ss.android.downloadlib.np.ej.m().m("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.ve ej = c.ej();
        dk.m m10 = new dk.m(context).m(z10 ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(mVar.np) ? "刚刚下载的应用" : mVar.np;
        ej.dk(m10.dk(String.format("%1$s下载完成，是否立即安装？", objArr)).ej("立即安装").l(z10 ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).m(false).m(ve.m(context, mVar.f38577hc)).m(new dk.InterfaceC0572dk() { // from class: com.ss.android.downloadlib.addownload.m.m.1
            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void dk(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.l.m.m().dk("backdialog_exit", l10);
                InterfaceC0575m interfaceC0575m2 = interfaceC0575m;
                if (interfaceC0575m2 != null) {
                    interfaceC0575m2.m();
                }
                m.this.dk("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void ej(DialogInterface dialogInterface) {
                m.this.dk("");
            }

            @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
            public void m(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.l.m.m().dk("backdialog_install", l10);
                com.ss.android.socialbase.appdownloader.l.m(context, (int) mVar.f38579m);
                dialogInterface.dismiss();
            }
        }).m(1).m());
        com.ss.android.downloadlib.l.m.m().dk("backdialog_show", l10);
        this.np = mVar.f38578l;
    }

    public boolean m(String str) {
        return TextUtils.equals(this.np, str);
    }

    public void m(com.ss.android.downloadad.api.m.dk dkVar) {
        if (c.w().optInt("enable_open_app_dialog", 0) == 1 && !dkVar.p() && dkVar.t() && Build.VERSION.SDK_INT < 34) {
            dkVar.c(true);
            TTDelegateActivity.m(dkVar);
        }
    }
}
