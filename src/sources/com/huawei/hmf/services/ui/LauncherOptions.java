package com.huawei.hmf.services.ui;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.services.ui.internal.SecurityIntent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LauncherOptions {
    private static final String ACTIVITY_OPTIONS = "__LAUNCHER_OPTIONS_ACTIVITY_OPTIONS__";
    private final Intent mIntent;

    private LauncherOptions(Intent intent) {
        this.mIntent = intent;
    }

    public static LauncherOptions createFrom(Intent intent) {
        return new LauncherOptions(intent);
    }

    public Bundle getActivityOptions() {
        Intent intent = this.mIntent;
        if (intent != null) {
            return SecurityIntent.from(intent).getBundleExtra(ACTIVITY_OPTIONS);
        }
        return null;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public void removeActivityOptions() {
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.removeExtra(ACTIVITY_OPTIONS);
        }
    }

    public LauncherOptions setActivityOptions(Bundle bundle) {
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.putExtra(ACTIVITY_OPTIONS, bundle);
        }
        return this;
    }
}
