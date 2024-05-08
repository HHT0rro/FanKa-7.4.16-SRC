package com.ss.android.downloadlib.dk;

import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np implements AppStatusManager.AppStatusChangeListener {

    /* renamed from: m, reason: collision with root package name */
    private long f38713m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static np f38715m = new np();
    }

    public void dk(l lVar) {
        if (lVar == null) {
            return;
        }
        m(lVar, c.w().optInt("check_an_result_delay", 1200) > 0 ? r1 : 1200);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        this.f38713m = System.currentTimeMillis();
    }

    private np() {
        this.f38713m = 0L;
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static np m() {
        return m.f38715m;
    }

    public void m(final l lVar, final long j10) {
        if (lVar == null) {
            return;
        }
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.dk.np.1
            @Override // java.lang.Runnable
            public void run() {
                if (AppStatusManager.getInstance().isAppFocus() && System.currentTimeMillis() - np.this.f38713m > j10) {
                    lVar.m(false);
                } else {
                    lVar.m(true);
                }
            }
        }, j10);
    }

    public void m(l lVar) {
        m(lVar, 5000L);
    }
}
