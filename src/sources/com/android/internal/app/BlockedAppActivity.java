package com.android.internal.app;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Slog;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BlockedAppActivity extends AlertActivity {
    private static final String EXTRA_BLOCKED_PACKAGE = "com.android.internal.app.extra.BLOCKED_PACKAGE";
    private static final String PACKAGE_NAME = "com.android.internal.app";
    private static final String TAG = "BlockedAppActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.AlertActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int userId = intent.getIntExtra("android.intent.extra.USER_ID", -1);
        if (userId < 0) {
            Slog.wtf(TAG, "Invalid user: " + userId);
            finish();
            return;
        }
        String packageName = intent.getStringExtra(EXTRA_BLOCKED_PACKAGE);
        if (TextUtils.isEmpty(packageName)) {
            Slog.wtf(TAG, "Invalid package: " + packageName);
            finish();
            return;
        }
        CharSequence appLabel = getAppLabel(userId, packageName);
        this.mAlertParams.mTitle = getString(17039687);
        this.mAlertParams.mMessage = getString(17039686, new Object[]{appLabel});
        this.mAlertParams.mPositiveButtonText = getString(17039370);
        setupAlert();
    }

    private CharSequence getAppLabel(int userId, String packageName) {
        PackageManager pm = getPackageManager();
        try {
            ApplicationInfo aInfo = pm.getApplicationInfoAsUser(packageName, 0, userId);
            return aInfo.loadLabel(pm);
        } catch (PackageManager.NameNotFoundException ne2) {
            Slog.e(TAG, "Package " + packageName + " not found", ne2);
            return packageName;
        }
    }

    public static Intent createIntent(int userId, String packageName) {
        return new Intent().setClassName("android", BlockedAppActivity.class.getName()).putExtra("android.intent.extra.USER_ID", userId).putExtra(EXTRA_BLOCKED_PACKAGE, packageName);
    }
}
