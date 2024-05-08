package com.kwad.sdk.core.download.b;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements d {
    private static c auA;
    private static HashMap<String, WeakReference<Bitmap>> auz = new HashMap<>();
    private static final Handler auB = new HandlerC0524a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class HandlerC0524a extends Handler {
        private final SparseArray<Long> auC;

        public HandlerC0524a() {
            super(Looper.getMainLooper());
            this.auC = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z10 = message.arg1 == 1;
            int i10 = message.arg2;
            boolean z11 = i10 == 1;
            boolean z12 = i10 == 2;
            Long l10 = this.auC.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.xL().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.xL().bS(message.what) == null && !z12) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z10 && l10 != null && System.currentTimeMillis() - l10.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l10.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z11) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.auC.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        private static String auD = "ksad_notification_default_icon";
        private String aaw;
        private String auE;
        private String auF;
        private String auH;
        private String name;
        private int progress;
        private File auG = null;
        private boolean auI = false;

        private b() {
        }

        public static String Dk() {
            return auD;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File bV = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bV(downloadParams.mAppIcon);
                if (bV != null && bV.exists()) {
                    bVar.auG = bV;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.auI = downloadTask.isPaused();
            bVar.aaw = str;
            bVar.auH = str2;
            bVar.auE = a.ai(downloadTask.getSmallFileSoFarBytes()) + " / " + a.ai(downloadTask.getSmallFileTotalBytes());
            bVar.auF = a.ai((long) downloadTask.getSmallFileTotalBytes());
            bVar.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        public final String Dl() {
            return this.auE;
        }

        public final String Dm() {
            return this.auF;
        }

        public final String Dn() {
            return this.aaw;
        }

        public final File Do() {
            return this.auG;
        }

        public final String Dp() {
            return "正在下载 " + this.progress + "%";
        }

        public final String Dq() {
            return this.auH;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.auI;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File bV;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (bV = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bV(downloadParams.mAppIcon)) != null && bV.exists()) {
                bVar.auG = bV;
            }
            bVar.aaw = str;
            bVar.auF = a.ai(downloadParams.mAppSize);
            bVar.auH = str2;
            return bVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends BroadcastReceiver {
        private static void d(@NonNull Intent intent) {
            DownloadTask f10 = f(intent);
            if (f10 == null) {
                return;
            }
            com.kwad.sdk.c.xL().bU(f10.getId());
        }

        private static void e(@NonNull Intent intent) {
            DownloadTask f10 = f(intent);
            if (f10 == null) {
                return;
            }
            f10.setNotificationRemoved(true);
        }

        @Nullable
        private static DownloadTask f(Intent intent) {
            int i10 = intent.getExtras().getInt(DBDefinition.TASK_ID, 0);
            if (i10 == 0) {
                return null;
            }
            return com.kwad.sdk.c.xL().bS(i10);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                d(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                e(intent);
            }
        }
    }

    private static void Dj() {
        if (auA != null) {
            return;
        }
        auA = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.KO().registerReceiver(auA, intentFilter, 2);
        } else {
            ServiceProvider.KO().registerReceiver(auA, intentFilter);
        }
    }

    private static Bitmap E(Context context, String str) {
        WeakReference<Bitmap> weakReference = auz.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(as.cu(context), as.at(context, str));
        auz.put(str, new WeakReference<>(decodeResource));
        return decodeResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i10, Notification notification) {
        Dj();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.KO().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i10, notification);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ai(long j10) {
        return String.format("%.2fMB", Float.valueOf((((float) j10) / 1000.0f) / 1000.0f));
    }

    private static DownloadParams m(DownloadTask downloadTask) {
        DownloadParams downloadParams;
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            downloadParams = (DownloadParams) tag;
        } else {
            downloadParams = new DownloadParams();
        }
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static Bitmap q(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = auz.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
        auz.put(absolutePath, new WeakReference<>(decodeFile));
        return decodeFile;
    }

    @Override // com.kwad.sdk.d
    public final void bT(String str) {
        Context KO = ServiceProvider.KO();
        DownloadParams cT = com.kwad.sdk.core.a.Bc().cT(str);
        com.kwad.sdk.core.a.Bc().cU(str);
        if (KO == null || cT == null) {
            return;
        }
        com.kwad.sdk.core.a.Bc().cU(cT.filePath);
        b a10 = b.a(cT, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.b.b aY = com.kwad.sdk.core.download.b.b.aY(KO);
        if (aY == null) {
            return;
        }
        a(KO, aY, a10);
        a(KO, aY.build(), false, false, al.d(KO, cT.mPkgname, cT.mTaskId), cT.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void bV(int i10) {
        Context KO = ServiceProvider.KO();
        if (KO == null) {
            return;
        }
        ((NotificationManager) KO.getSystemService("notification")).cancel(i10);
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context KO = ServiceProvider.KO();
        if (KO == null) {
            return;
        }
        DownloadParams cT = com.kwad.sdk.core.a.Bc().cT(file.getAbsolutePath());
        com.kwad.sdk.core.a.Bc().cU(file.getAbsolutePath());
        if (cT == null) {
            return;
        }
        AdTemplate cV = com.kwad.sdk.core.a.Bc().cV(cT.mDownloadid);
        if (cV != null) {
            cV.installFrom = "recall";
        }
        b a10 = b.a(cT, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b aY = com.kwad.sdk.core.download.b.b.aY(KO);
        if (aY == null) {
            return;
        }
        a(KO, aY, a10);
        a(KO, aY.build(), false, false, al.a(KO, file, cT.mTaskId, cT.requestInstallPermission), cT.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File bV = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bV(str);
            if (bV == null || !bV.exists()) {
                ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        Context KO = ServiceProvider.KO();
        if (KO == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        b a10 = b.a(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        com.kwad.sdk.core.download.b.c a11 = com.kwad.sdk.core.download.b.c.a(KO, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a11 == null) {
            return;
        }
        a(KO, a11, a10);
        a(KO, a11.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams m10;
        com.kwad.sdk.core.download.b.b aY;
        Context KO = ServiceProvider.KO();
        if (KO == null || (m10 = m(downloadTask)) == null || (aY = com.kwad.sdk.core.download.b.b.aY(KO)) == null) {
            return;
        }
        a(KO, aY, b.a(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.Bc().a(downloadTask.getTargetFilePath(), m10);
        com.kwad.sdk.core.a.Bc().a(m10.mPkgname, m10);
        a(KO, aY.build(), false, false, al.a(KO, new File(downloadTask.getTargetFilePath()), m10.mTaskId, m10.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z10) {
        com.kwad.sdk.core.download.b.c a10;
        Context KO = ServiceProvider.KO();
        if (KO == null || downloadTask.isNotificationRemoved() || (a10 = com.kwad.sdk.core.download.b.c.a(KO, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        a(KO, a10, b.a(downloadTask, "正在下载", (String) null));
        a(KO, a10.build(), false, true, null, downloadTask.getId(), z10 ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            com.kwad.sdk.service.c.gatherException(e2);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(E(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            com.kwad.sdk.service.c.gatherException(e2);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            com.kwad.sdk.service.c.gatherException(e2);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(E(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            com.kwad.sdk.service.c.gatherException(e2);
            return false;
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z10, boolean z11, @Nullable PendingIntent pendingIntent, int i10, int i11, int i12) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(as.getAppIconId(context));
        a(builder, remoteViews);
        if (z11) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra(DBDefinition.TASK_ID, i10);
            builder.setDeleteIntent(al.a(context, i10, intent));
        }
        Handler handler = auB;
        handler.removeMessages(i10);
        handler.obtainMessage(i10, i11, i12, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File Do = bVar.Do();
        if (!((Do == null || !Do.exists()) ? false : a(cVar, Do))) {
            a(context, cVar, b.Dk());
        }
        cVar.setStatus(bVar.Dn());
        cVar.setSize(bVar.Dl());
        cVar.setPercentNum(bVar.Dp());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File Do = bVar2.Do();
        if (!((Do == null || !Do.exists()) ? false : a(bVar, Do))) {
            a(context, bVar, b.Dk());
        }
        bVar.setStatus(bVar2.Dn());
        bVar.setSize(bVar2.Dm());
        bVar.setInstallText(bVar2.Dq());
    }
}
