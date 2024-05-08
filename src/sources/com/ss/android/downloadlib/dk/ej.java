package com.ss.android.downloadlib.dk;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {
    public static void m(final com.ss.android.downloadad.api.m.dk dkVar, @NonNull final com.ss.android.downloadlib.guide.install.m mVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            ve.ej();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && isAppForeground2 && dkVar != null) {
            dkVar.ve(true);
        }
        mVar.m();
        Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + isAppForeground2);
        if (isAppForeground2) {
            return;
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.dk.ej.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                if (ve.dk(com.ss.android.downloadad.api.m.dk.this)) {
                    return;
                }
                com.ss.android.downloadad.api.m.dk.this.sy(true);
                com.ss.android.downloadlib.l.m.m().m("install_delay_invoke", com.ss.android.downloadad.api.m.dk.this);
                mVar.m();
            }
        });
    }
}
