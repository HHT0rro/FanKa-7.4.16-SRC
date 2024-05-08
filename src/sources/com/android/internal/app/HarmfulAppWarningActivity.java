package com.android.internal.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.internal.app.AlertController;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class HarmfulAppWarningActivity extends AlertActivity implements DialogInterface.OnClickListener {
    private static final String EXTRA_HARMFUL_APP_WARNING = "harmful_app_warning";
    private static final String TAG = HarmfulAppWarningActivity.class.getSimpleName();
    private String mHarmfulAppWarning;
    private String mPackageName;
    private IntentSender mTarget;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.AlertActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addSystemFlags(524288);
        Intent intent = getIntent();
        this.mPackageName = intent.getStringExtra("android.intent.extra.PACKAGE_NAME");
        this.mTarget = (IntentSender) intent.getParcelableExtra("android.intent.extra.INTENT", IntentSender.class);
        String stringExtra = intent.getStringExtra(EXTRA_HARMFUL_APP_WARNING);
        this.mHarmfulAppWarning = stringExtra;
        if (this.mPackageName == null || this.mTarget == null || stringExtra == null) {
            Log.wtf(TAG, "Invalid intent: " + intent.toString());
            finish();
        }
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(this.mPackageName, 0);
            AlertController.AlertParams p10 = this.mAlertParams;
            p10.mTitle = getString(17040477);
            p10.mView = createView(applicationInfo);
            p10.mPositiveButtonText = getString(17040478);
            p10.mPositiveButtonListener = this;
            p10.mNegativeButtonText = getString(17040476);
            p10.mNegativeButtonListener = this;
            this.mAlert.installContent(this.mAlertParams);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "Could not show warning because package does not exist ", e2);
            finish();
        }
    }

    private View createView(ApplicationInfo applicationInfo) {
        View view = getLayoutInflater().inflate(17367176, (ViewGroup) null);
        ((TextView) view.findViewById(16908789)).setText(applicationInfo.loadSafeLabel(getPackageManager(), 1000.0f, 5));
        ((TextView) view.findViewById(16908299)).setText(this.mHarmfulAppWarning);
        return view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case -2:
                getPackageManager().setHarmfulAppWarning(this.mPackageName, null);
                IntentSender target = (IntentSender) getIntent().getParcelableExtra("android.intent.extra.INTENT", IntentSender.class);
                Bundle activityOptions = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle();
                try {
                    startIntentSenderForResult(target, -1, null, 0, 0, 0, activityOptions);
                } catch (IntentSender.SendIntentException e2) {
                    Log.e(TAG, "Error while starting intent sender", e2);
                }
                EventLogTags.writeHarmfulAppWarningLaunchAnyway(this.mPackageName);
                finish();
                return;
            case -1:
                getPackageManager().deletePackage(this.mPackageName, null, 0);
                EventLogTags.writeHarmfulAppWarningUninstall(this.mPackageName);
                finish();
                return;
            default:
                return;
        }
    }

    public static Intent createHarmfulAppWarningIntent(Context context, String targetPackageName, IntentSender target, CharSequence harmfulAppWarning) {
        Intent intent = new Intent();
        intent.setClass(context, HarmfulAppWarningActivity.class);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", targetPackageName);
        intent.putExtra("android.intent.extra.INTENT", target);
        intent.putExtra(EXTRA_HARMFUL_APP_WARNING, harmfulAppWarning);
        return intent;
    }
}
