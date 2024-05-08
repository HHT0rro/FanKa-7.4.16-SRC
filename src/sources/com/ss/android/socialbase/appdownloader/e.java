package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {
    private boolean dk;
    private long ej;

    /* renamed from: hc, reason: collision with root package name */
    private Runnable f38851hc;

    /* renamed from: l, reason: collision with root package name */
    private long f38852l;

    /* renamed from: m, reason: collision with root package name */
    private final Queue<Integer> f38853m;

    /* renamed from: n, reason: collision with root package name */
    private Handler f38854n;
    private SoftReference<JumpUnknownSourceActivity> np;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static final e f38860m = new e();
    }

    private e() {
        this.f38853m = new ArrayDeque();
        this.dk = false;
        this.f38854n = new Handler(Looper.getMainLooper());
        this.f38851hc = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.ej();
            }
        };
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.socialbase.appdownloader.e.2
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (e.this.f38853m.isEmpty()) {
                    return;
                }
                long optLong = DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", 120000L);
                long currentTimeMillis = System.currentTimeMillis() - e.this.f38852l;
                if (currentTimeMillis < optLong) {
                    if (e.this.f38854n.hasCallbacks(e.this.f38851hc)) {
                        return;
                    }
                    e.this.f38854n.postDelayed(e.this.f38851hc, optLong - currentTimeMillis);
                } else {
                    e.this.f38852l = System.currentTimeMillis();
                    e.this.ej();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dk(Context context, int i10, boolean z10) {
        int dk = ej.dk(context, i10, z10);
        if (dk == 1) {
            this.dk = true;
        }
        this.ej = System.currentTimeMillis();
        return dk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground()) {
            synchronized (this.f38853m) {
                poll = this.f38853m.poll();
            }
            this.f38854n.removeCallbacks(this.f38851hc);
            if (poll != null) {
                final Context appContext = DownloadComponentManager.getAppContext();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f38854n.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.dk(appContext, poll.intValue(), false);
                        }
                    });
                } else {
                    dk(appContext, poll.intValue(), false);
                }
                this.f38854n.postDelayed(this.f38851hc, 20000L);
                return;
            }
            this.dk = false;
        }
    }

    private boolean l() {
        return System.currentTimeMillis() - this.ej < 1000;
    }

    public void m(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        ej();
    }

    public JumpUnknownSourceActivity dk() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.np;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.np = null;
        return jumpUnknownSourceActivity;
    }

    public static e m() {
        return m.f38860m;
    }

    public int m(final Context context, final int i10, final boolean z10) {
        if (z10) {
            return dk(context, i10, z10);
        }
        if (l()) {
            this.f38854n.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.m(context, i10, z10);
                }
            }, 1000L);
            return 1;
        }
        if (AppStatusManager.getInstance().isAppForeground()) {
            Logger.i("leaves", "on Foreground");
            return dk(context, i10, z10);
        }
        if (dk.m()) {
            return 1;
        }
        boolean z11 = Build.VERSION.SDK_INT < 29;
        if (this.f38853m.isEmpty() && !this.dk && z11) {
            return dk(context, i10, z10);
        }
        int optInt = DownloadSetting.obtainGlobal().optInt("install_queue_size", 3);
        synchronized (this.f38853m) {
            while (this.f38853m.size() > optInt) {
                this.f38853m.poll();
            }
        }
        if (z11) {
            this.f38854n.removeCallbacks(this.f38851hc);
            this.f38854n.postDelayed(this.f38851hc, DownloadSetting.obtain(i10).optLong("install_queue_timeout", 20000L));
        }
        synchronized (this.f38853m) {
            if (!this.f38853m.contains(Integer.valueOf(i10))) {
                this.f38853m.offer(Integer.valueOf(i10));
            }
        }
        return 1;
    }

    public void m(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.np = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
