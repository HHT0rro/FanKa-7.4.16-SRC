package com.huawei.secure.android.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.secure.android.common.intent.SafeIntent;
import ra.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafeActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public static final String f34760b = "SafeActivity";

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception e2) {
            a.c(f34760b, "finish exception : " + e2.getMessage());
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        try {
            super.finishAffinity();
        } catch (Exception e2) {
            a.d(f34760b, "finishAffinity: " + e2.getMessage(), e2);
        }
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        try {
            return new SafeIntent(super.getIntent());
        } catch (Exception e2) {
            a.c(f34760b, "getIntent: " + e2.getMessage());
            return new SafeIntent(new Intent());
        }
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        try {
            return super.getReferrer();
        } catch (Exception e2) {
            a.c(f34760b, "getReferrer: " + e2.getMessage());
            return null;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        try {
            super.onActivityResult(i10, i11, new SafeIntent(intent));
        } catch (Exception e2) {
            a.d(f34760b, "onActivityResult exception : " + e2.getMessage(), e2);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (wa.a.a(super.getIntent())) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e2) {
            a.c(f34760b, "onDestroy exception : " + e2.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34760b, "onRestart : hasIntentBomb");
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34760b, "onResume : hasIntentBomb");
        }
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34760b, "onStart : hasIntentBomb");
        }
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        if (wa.a.a(super.getIntent())) {
            a.c(f34760b, "onStop : hasIntentBomb");
        }
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e2) {
            a.c(f34760b, "startActivities: " + e2.getMessage());
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            super.startActivity(intent);
        } catch (Exception e2) {
            a.c(f34760b, "startActivity Exception : " + e2.getMessage());
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10) {
        try {
            super.startActivityForResult(intent, i10);
        } catch (Exception e2) {
            a.d(f34760b, "startActivity: " + e2.getMessage(), e2);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i10) {
        try {
            return super.startActivityIfNeeded(intent, i10);
        } catch (Exception e2) {
            a.d(f34760b, "startActivityIfNeeded: " + e2.getMessage(), e2);
            return false;
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        try {
            super.startActivities(intentArr, bundle);
        } catch (Exception e2) {
            a.d(f34760b, "startActivities: " + e2.getMessage(), e2);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        try {
            super.startActivity(intent, bundle);
        } catch (Exception e2) {
            a.d(f34760b, "startActivity: " + e2.getMessage(), e2);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        try {
            super.startActivityForResult(intent, i10, bundle);
        } catch (Exception e2) {
            a.d(f34760b, "startActivity: " + e2.getMessage(), e2);
        }
    }
}
