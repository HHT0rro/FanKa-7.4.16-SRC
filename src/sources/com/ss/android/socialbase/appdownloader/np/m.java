package com.ss.android.socialbase.appdownloader.np;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.np;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m extends AbsNotificationItem {
    private final Resources dk;
    private String ej;

    /* renamed from: l, reason: collision with root package name */
    private String f38960l;

    /* renamed from: m, reason: collision with root package name */
    private final Context f38961m;
    private String np;

    public m(Context context, int i10, String str, String str2, String str3, String str4) {
        super(i10, str);
        this.f38960l = str2;
        this.ej = str3;
        this.np = str4;
        Context applicationContext = context.getApplicationContext();
        this.f38961m = applicationContext;
        this.dk = applicationContext.getResources();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    private androidx.core.app.NotificationCompat.Builder dk() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.l r0 = com.ss.android.socialbase.appdownloader.l.oa()
            java.lang.String r0 = r0.w()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f38961m
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.f38961m
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.ej.dk(r0)
        L22:
            com.ss.android.socialbase.appdownloader.l r1 = com.ss.android.socialbase.appdownloader.l.oa()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.ej.sy r1 = r1.c()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.l r1 = com.ss.android.socialbase.appdownloader.l.oa()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.ej.sy r1 = r1.c()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f38961m     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.m(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f38961m     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f38961m
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.np.m.dk():androidx.core.app.NotificationCompat$Builder");
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x05b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification m(com.ss.android.socialbase.downloader.exception.BaseException r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.np.m.m(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotification(BaseException baseException, boolean z10) {
        if (this.f38961m == null) {
            return;
        }
        try {
            Notification m10 = m(baseException, z10);
            this.notification = m10;
            notify(m10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotificationItem(DownloadInfo downloadInfo) {
        super.updateNotificationItem(downloadInfo);
        this.f38960l = downloadInfo.getSavePath();
        this.ej = downloadInfo.getName();
        this.np = downloadInfo.getExtra();
    }

    private boolean m(BaseException baseException, DownloadSetting downloadSetting, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && downloadSetting.optInt(DownloadSettingKeys.NOTIFICATION_TEXT_OPT, 0) == 1;
    }

    private RemoteViews m() {
        RemoteViews remoteViews = new RemoteViews(this.f38961m.getPackageName(), np.m());
        try {
            if (com.ss.android.socialbase.appdownloader.ej.m(this.f38961m)) {
                remoteViews.setInt(np.n(), "setBackgroundColor", this.f38961m.getResources().getColor(np.f()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    private int m(int i10, int i11) {
        if (DownloadSetting.obtain(i11).optInt("notification_opt_2") == 1) {
            return np.li();
        }
        if (i10 == 1 || i10 == 4) {
            return np.mj();
        }
        if (i10 == 2) {
            return np.dh();
        }
        if (i10 == 3) {
            return np.li();
        }
        return 0;
    }

    private PendingIntent m(String str, int i10, int i11) {
        Intent intent = new Intent(this.f38961m, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i11);
        intent.putExtra("extra_click_download_type", i10);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f38961m, i11, intent, 201326592);
    }

    private int m(int i10) {
        if (DownloadSetting.obtain(i10).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 1) {
            return np.e();
        }
        return np.hc();
    }
}
