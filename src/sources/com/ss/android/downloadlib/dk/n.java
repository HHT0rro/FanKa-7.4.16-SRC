package com.ss.android.downloadlib.dk;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.ipc.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {

    /* renamed from: m, reason: collision with root package name */
    private static Handler f38709m = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(@NonNull final com.ss.android.downloadad.api.m.dk dkVar, final int i10) {
        if (i10 <= 0) {
            return;
        }
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.dk.n.2
            @Override // java.lang.Runnable
            public void run() {
                int i11 = 1;
                if (ve.ej(com.ss.android.downloadad.api.m.dk.this.np())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!com.ss.android.downloadad.api.m.dk.this.sa()) {
                            i11 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i11));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    com.ss.android.downloadlib.l.m.m().m("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.m.dk.this);
                    return;
                }
                n.dk(com.ss.android.downloadad.api.m.dk.this, i10 - 1);
            }
        }, w(dkVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long e(com.ss.android.downloadad.api.m.dk dkVar) {
        return com.ss.android.downloadlib.hc.np.m(dkVar).optLong("app_link_check_timeout", u.as);
    }

    public static boolean ej(com.ss.android.downloadad.api.m.dk dkVar) {
        return com.ss.android.downloadlib.hc.np.m(dkVar).optInt("app_link_opt_invoke_switch") == 1;
    }

    public static boolean l(com.ss.android.downloadad.api.m.dk dkVar) {
        return com.ss.android.downloadlib.hc.np.m(dkVar).optInt("app_link_opt_dialog_switch") == 1;
    }

    public static long np(com.ss.android.downloadad.api.m.dk dkVar) {
        return dkVar == null ? c.Code : com.ss.android.downloadlib.hc.np.m(dkVar).optInt("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int oa(com.ss.android.downloadad.api.m.dk dkVar) {
        return com.ss.android.downloadlib.hc.np.m(dkVar).optInt("app_link_check_count", 10);
    }

    private static int w(com.ss.android.downloadad.api.m.dk dkVar) {
        return com.ss.android.downloadlib.hc.np.m(dkVar).optInt("app_link_check_delay", 1);
    }

    public static void m(final com.ss.android.downloadad.api.m.dk dkVar, @NonNull final e eVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            ve.ej();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        boolean z10 = !isAppForeground && isAppForeground2;
        if (dkVar != null) {
            dkVar.ve(z10);
        }
        eVar.m(z10);
        if (dkVar == null) {
            return;
        }
        dk(dkVar, oa(dkVar));
        if (isAppForeground2) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.dk.n.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.dk.n.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean ej = ve.ej(com.ss.android.downloadad.api.m.dk.this.np());
                        long np = n.np(com.ss.android.downloadad.api.m.dk.this);
                        if (!ej || np >= System.currentTimeMillis() - currentTimeMillis) {
                            long e2 = n.e(com.ss.android.downloadad.api.m.dk.this);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (currentTimeMillis2 - currentTimeMillis > e2) {
                                com.ss.android.downloadlib.l.m.m().m("deeplink_delay_timeout", com.ss.android.downloadad.api.m.dk.this);
                                return;
                            }
                            com.ss.android.downloadad.api.m.dk.this.ve(true);
                            com.ss.android.downloadlib.l.m.m().m("deeplink_delay_invoke", com.ss.android.downloadad.api.m.dk.this);
                            eVar.m(true);
                            com.ss.android.downloadad.api.m.dk dkVar2 = com.ss.android.downloadad.api.m.dk.this;
                            n.dk(dkVar2, n.oa(dkVar2));
                        }
                    }
                });
            }
        });
    }

    public static boolean dk(com.ss.android.downloadad.api.m.dk dkVar) {
        return com.ss.android.downloadlib.hc.np.m(dkVar).optInt("app_link_opt_install_switch") == 1;
    }

    public static boolean m(com.ss.android.downloadad.api.m.dk dkVar) {
        return com.ss.android.downloadlib.hc.np.m(dkVar).optInt("app_link_opt_switch") == 1;
    }
}
