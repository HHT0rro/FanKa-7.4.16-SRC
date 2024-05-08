package com.ss.android.socialbase.appdownloader.np;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.ej.r;
import com.ss.android.socialbase.appdownloader.w;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private static List<r> dk = new ArrayList();
    private static com.ss.android.socialbase.appdownloader.view.m ej = null;

    /* renamed from: l, reason: collision with root package name */
    private static AlertDialog f38957l = null;

    /* renamed from: m, reason: collision with root package name */
    private static final String f38958m = "l";

    public static void dk(@NonNull Activity activity, @NonNull r rVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f38958m;
                    com.ss.android.socialbase.appdownloader.view.m mVar = (com.ss.android.socialbase.appdownloader.view.m) fragmentManager.findFragmentByTag(str);
                    ej = mVar;
                    if (mVar == null) {
                        ej = new com.ss.android.socialbase.appdownloader.view.m();
                        fragmentManager.beginTransaction().add(ej, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    ej.m();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    rVar.m();
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
        }
        rVar.m();
    }

    public static boolean m() {
        try {
            return NotificationManagerCompat.from(DownloadComponentManager.getAppContext()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void m(boolean z10) {
        synchronized (l.class) {
            try {
                AlertDialog alertDialog = f38957l;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    f38957l = null;
                }
                for (r rVar : dk) {
                    if (rVar != null) {
                        if (z10) {
                            rVar.m();
                        } else {
                            rVar.dk();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void m(@NonNull final Activity activity, @NonNull final r rVar) {
        synchronized (l.class) {
            if (rVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                    m(false);
                }
                if (!activity.isFinishing()) {
                    int m10 = w.m(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_title");
                    int m11 = w.m(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_message");
                    int m12 = w.m(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_yes");
                    int m13 = w.m(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_no");
                    dk.add(rVar);
                    AlertDialog alertDialog = f38957l;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        f38957l = new AlertDialog.Builder(activity).setTitle(m10).setMessage(m11).setPositiveButton(m12, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.np.l.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i10) {
                                l.dk(activity, rVar);
                                dialogInterface.cancel();
                                AlertDialog unused = l.f38957l = null;
                            }
                        }).setNegativeButton(m13, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.np.l.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i10) {
                                l.m(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.np.l.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                                if (i10 != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    l.m(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            }
            rVar.dk();
        }
    }
}
