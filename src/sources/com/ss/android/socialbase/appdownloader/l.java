package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.ej.oa;
import com.ss.android.socialbase.appdownloader.ej.sy;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private static volatile l dk = null;

    /* renamed from: hc, reason: collision with root package name */
    private static boolean f38869hc = false;

    /* renamed from: m, reason: collision with root package name */
    private static final String f38870m = "l";

    /* renamed from: n, reason: collision with root package name */
    private static boolean f38871n;

    /* renamed from: c, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.ej.e f38872c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38873e = false;
    private String ej;

    /* renamed from: k, reason: collision with root package name */
    private IInstallAppHandler f38874k;

    /* renamed from: l, reason: collision with root package name */
    private String f38875l;
    private DownloadReceiver np;

    /* renamed from: oa, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.ej.l f38876oa;

    /* renamed from: q, reason: collision with root package name */
    private oa f38877q;

    /* renamed from: r, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.ej.n f38878r;
    private sy sy;

    /* renamed from: t, reason: collision with root package name */
    private IOpenInstallerListener f38879t;
    private com.ss.android.socialbase.appdownloader.ej.hc ve;

    /* renamed from: w, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.ej.ej f38880w;

    private l() {
    }

    private void f() {
        RetryScheduler.setRetryScheduleHandler(new RetryScheduler.RetryScheduleHandler() { // from class: com.ss.android.socialbase.appdownloader.l.1
            @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
            public void cancelRetry(int i10) {
                RetryJobSchedulerService.m(i10);
            }

            @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
            public void scheduleRetry(DownloadInfo downloadInfo, long j10, boolean z10, int i10) {
                RetryJobSchedulerService.m(downloadInfo, j10, z10, i10);
            }
        });
    }

    public static l oa() {
        if (dk == null) {
            synchronized (l.class) {
                if (dk == null) {
                    dk = new l();
                }
            }
        }
        return dk;
    }

    private void t() {
        if (f38869hc) {
            return;
        }
        if (this.np == null) {
            this.np = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme("package");
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme("file");
            DownloadComponentManager.getAppContext().registerReceiver(this.np, intentFilter);
            DownloadComponentManager.getAppContext().registerReceiver(this.np, intentFilter2);
            DownloadComponentManager.getAppContext().registerReceiver(this.np, intentFilter3);
            f38869hc = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public sy c() {
        return this.sy;
    }

    public com.ss.android.socialbase.appdownloader.ej.l dk() {
        return this.f38876oa;
    }

    public File e() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir();
    }

    public com.ss.android.socialbase.appdownloader.ej.e ej() {
        return this.f38872c;
    }

    public oa hc() {
        return this.f38877q;
    }

    public String l() {
        return this.f38875l;
    }

    public boolean n() {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PACKAGE_FLAG_CONFIG, 1) == 1;
    }

    public com.ss.android.socialbase.appdownloader.ej.n np() {
        return this.f38878r;
    }

    public IOpenInstallerListener q() {
        return this.f38879t;
    }

    public IInstallAppHandler r() {
        return this.f38874k;
    }

    public IReserveWifiStatusListener sy() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
    }

    public com.ss.android.socialbase.appdownloader.ej.hc ve() {
        return this.ve;
    }

    public String w() {
        return this.ej;
    }

    private void ej(Context context) {
        if (context == null || f38871n) {
            return;
        }
        DownloadConstants.setMimeApk("application/vnd.android.package-archive");
        DownloadComponentManager.setAppContext(context);
        DownloadComponentManager.setDownloadLaunchHandler(new com.ss.android.socialbase.appdownloader.l.dk());
        t();
        f();
        f38871n = true;
    }

    public void dk(String str) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDefaultSavePath(str);
    }

    private DownloadInfo dk(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public com.ss.android.socialbase.appdownloader.ej.ej m() {
        return this.f38880w;
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f38875l = str;
    }

    public List<DownloadInfo> dk(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void m(oa oaVar) {
        this.f38877q = oaVar;
    }

    @Deprecated
    public void m(Context context, String str, com.ss.android.socialbase.appdownloader.ej.ej ejVar, com.ss.android.socialbase.appdownloader.ej.l lVar, com.ss.android.socialbase.appdownloader.ej.e eVar) {
        if (ejVar != null) {
            this.f38880w = ejVar;
        }
        if (lVar != null) {
            this.f38876oa = lVar;
        }
        if (eVar != null) {
            this.f38872c = eVar;
        }
        ej(context);
    }

    public static boolean m(Context context, int i10) {
        return ej.m(context, i10, true) == 1;
    }

    public void m(Context context, int i10, int i11) {
        try {
            switch (i11) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i10);
                    break;
                case -3:
                    ej.m(context, i10, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i10);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i10);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:37|(1:39)|40|(2:44|45)|48|(1:116)(1:55)|56|(2:62|(1:64)(19:65|66|(1:68)|69|(3:71|(2:74|72)|75)|76|77|78|(1:80)(1:113)|81|82|(6:87|(1:110)(1:91)|92|(1:96)|(1:(1:108)(1:107))|109)|111|(1:89)|110|92|(2:94|96)|(0)|109))|115|66|(0)|69|(0)|76|77|78|(0)(0)|81|82|(8:84|87|(0)|110|92|(0)|(0)|109)|111|(0)|110|92|(0)|(0)|109) */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0175 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:78:0x0169, B:80:0x016f, B:81:0x017a, B:113:0x0175), top: B:77:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0142 A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151 A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016f A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:78:0x0169, B:80:0x016f, B:81:0x017a, B:113:0x0175), top: B:77:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a2 A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x033b A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0122, B:66:0x013c, B:68:0x0142, B:69:0x0147, B:71:0x0151, B:72:0x0155, B:74:0x015b, B:76:0x0165, B:82:0x0190, B:84:0x0196, B:89:0x01a2, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x034e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m(com.ss.android.socialbase.appdownloader.n r23) {
        /*
            Method dump skipped, instructions count: 965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.l.m(com.ss.android.socialbase.appdownloader.n):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(DownloadTask downloadTask, int i10, boolean z10) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i10);
        }
        if (downloadInfo == null || !z10) {
            return;
        }
        downloadInfo.setSavePathRedirected(z10);
    }

    private List<HttpHeader> m(List<HttpHeader> list) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue())) {
                    if (httpHeader.getName().equals("User-Agent")) {
                        z10 = true;
                    }
                    arrayList.add(new HttpHeader(httpHeader.getName(), httpHeader.getValue()));
                }
            }
        }
        if (!z10) {
            arrayList.add(new HttpHeader("User-Agent", com.ss.android.socialbase.appdownloader.dk.m.f38843m));
        }
        return arrayList;
    }

    public String m(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || ej.ej(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private IDownloadNotificationEventListener m(final com.ss.android.socialbase.appdownloader.ej.np npVar) {
        if (npVar == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() { // from class: com.ss.android.socialbase.appdownloader.l.4
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public String getNotifyProcessName() {
                return npVar.m();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public boolean interceptAfterNotificationSuccess(boolean z10) {
                return npVar.m(z10);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public void onNotificationEvent(int i10, DownloadInfo downloadInfo, String str, String str2) {
                if (i10 != 1 && i10 != 3) {
                    switch (i10) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            npVar.m(i10, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            npVar.m(DownloadComponentManager.getAppContext(), str);
                            return;
                        case 10:
                            npVar.m(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                npVar.m(i10, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
        };
    }

    public DownloadInfo m(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo m10 = m(context, str, e());
                if (m10 == null) {
                    m10 = m(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (m10 == null) {
                    m10 = m(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (m10 == null) {
                    m10 = m(context, str, context.getFilesDir());
                }
                return (m10 == null && DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) ? dk(context, str) : m10;
            } catch (Throwable th) {
                Logger.d(f38870m, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo m(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> m(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void m(com.ss.android.socialbase.appdownloader.ej.hc hcVar) {
        this.ve = hcVar;
    }

    public void m(IReserveWifiStatusListener iReserveWifiStatusListener) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void m(IInstallAppHandler iInstallAppHandler) {
        this.f38874k = iInstallAppHandler;
    }

    public void m(IOpenInstallerListener iOpenInstallerListener) {
        this.f38879t = iOpenInstallerListener;
    }
}
