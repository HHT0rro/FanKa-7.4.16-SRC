package com.amap.api.offlineservice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AMapPermissionActivity extends Activity {
    public String[] needPermissions = {g.f36124j};

    /* renamed from: a, reason: collision with root package name */
    private boolean f8325a = true;

    private List<String> b(String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                for (String str : strArr) {
                    if (a(str) != 0 || b(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        try {
            if (Build.VERSION.SDK_INT < 23 || i10 != 0 || a(iArr)) {
                return;
            }
            a();
            this.f8325a = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            if (Build.VERSION.SDK_INT < 23 || !this.f8325a) {
                return;
            }
            a(this.needPermissions);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String... strArr) {
        List<String> b4;
        try {
            if (Build.VERSION.SDK_INT < 23 || getApplicationInfo().targetSdkVersion < 23 || (b4 = b(strArr)) == null) {
                return;
            }
            if (b4.size() > 0) {
                try {
                    getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(this, (String[]) b4.toArray(new String[b4.size()]), 0);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(String str) {
        try {
            return ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", String.class).invoke(this, str)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int a(String str) {
        try {
            return ((Integer) getClass().getMethod("checkSelfPermission", String.class).invoke(this, str)).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(int[] iArr) {
        try {
            for (int i10 : iArr) {
                if (i10 != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("当前应用缺少必要权限。\n\n请点击\"设置\"-\"权限\"-打开所需权限");
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.amap.api.offlineservice.AMapPermissionActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    try {
                        AMapPermissionActivity.this.finish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            builder.setPositiveButton("设置", new DialogInterface.OnClickListener() { // from class: com.amap.api.offlineservice.AMapPermissionActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    try {
                        AMapPermissionActivity.this.b();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
