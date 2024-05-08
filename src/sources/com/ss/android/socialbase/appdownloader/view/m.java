package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.ss.android.socialbase.appdownloader.np.l;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m extends Fragment {
    public static Intent l() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Intent n() {
        Context np = np();
        if (np == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = np.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i10 = np.getApplicationInfo().uid;
        intent.putExtra("uid", i10);
        intent.putExtra("app_uid", i10);
        return intent;
    }

    private Context np() {
        Context appContext = DownloadComponentManager.getAppContext();
        return (appContext != null || getActivity() == null || getActivity().isFinishing()) ? appContext : getActivity().getApplicationContext();
    }

    public Intent dk() {
        Context np = np();
        if (np == null) {
            return null;
        }
        String packageName = np.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(DownloadConstants.LOWER_OPPO)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains(ADEvent.VIVO)) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + np.getPackageName()));
    }

    public Intent ej() {
        Context np = np();
        if (np == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + np.getPackageName()));
    }

    public void m() {
        try {
            try {
                try {
                    startActivityForResult(n(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(dk(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(l(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(ej(), 1000);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (l.m()) {
            l.m(true);
        } else {
            l.m(false);
        }
    }
}
