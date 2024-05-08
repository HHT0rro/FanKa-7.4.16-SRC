package com.huawei.secure.android.common.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.huawei.secure.android.common.intent.SafeIntent;
import ra.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafePreferenceActivity extends PreferenceActivity {

    /* renamed from: b, reason: collision with root package name */
    public static final String f34763b = SafePreferenceActivity.class.getSimpleName();

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception e2) {
            a.e(f34763b, "finish exception : " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        try {
            super.finishAffinity();
        } catch (Exception e2) {
            a.e(f34763b, "finishAffinity: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        try {
            return new SafeIntent(super.getIntent());
        } catch (Exception e2) {
            a.e(f34763b, "getIntent: " + e2.getMessage(), true);
            return new SafeIntent(new Intent());
        }
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        try {
            return super.getReferrer();
        } catch (Exception e2) {
            a.e(f34763b, "getReferrer: " + e2.getMessage(), true);
            return null;
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        try {
            super.onActivityResult(i10, i11, new SafeIntent(intent));
        } catch (Exception e2) {
            a.e(f34763b, "onActivityResult exception : " + e2.getMessage(), true);
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (wa.a.a(super.getIntent())) {
            finish();
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e2) {
            a.e(f34763b, "onDestroy exception : " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34763b, "onRestart : hasIntentBomb");
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34763b, "onResume : hasIntentBomb");
        }
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34763b, "onStart : hasIntentBomb");
        }
        super.onStart();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onStop() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34763b, "onStop : hasIntentBomb");
        }
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e2) {
            a.e(f34763b, "startActivities: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            super.startActivity(new SafeIntent(intent));
        } catch (Exception unused) {
            a.c(f34763b, "startActivity Exception ");
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10) {
        try {
            super.startActivityForResult(new SafeIntent(intent), i10);
        } catch (Exception e2) {
            a.e(f34763b, "startActivity: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i10) {
        try {
            return super.startActivityIfNeeded(intent, i10);
        } catch (Exception e2) {
            a.e(f34763b, "startActivityIfNeeded: " + e2.getMessage(), true);
            return false;
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        try {
            super.startActivities(intentArr, bundle);
        } catch (Exception e2) {
            a.e(f34763b, "startActivities: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        try {
            super.startActivity(new SafeIntent(intent), bundle);
        } catch (Exception e2) {
            a.e(f34763b, "startActivity: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        try {
            super.startActivityForResult(new SafeIntent(intent), i10, bundle);
        } catch (Exception e2) {
            a.e(f34763b, "startActivity: " + e2.getMessage(), true);
        }
    }
}
