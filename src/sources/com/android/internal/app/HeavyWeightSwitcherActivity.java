package com.android.internal.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.ActivityThread;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class HeavyWeightSwitcherActivity extends Activity {
    public static final String KEY_CUR_APP = "cur_app";
    public static final String KEY_CUR_TASK = "cur_task";
    public static final String KEY_HAS_RESULT = "has_result";
    public static final String KEY_INTENT = "intent";
    public static final String KEY_NEW_APP = "new_app";
    String mCurApp;
    int mCurTask;
    boolean mHasResult;
    String mNewApp;
    IntentSender mStartIntent;
    private View.OnClickListener mSwitchOldListener = new View.OnClickListener() { // from class: com.android.internal.app.HeavyWeightSwitcherActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v2) {
            try {
                ActivityThread thread = ActivityThread.currentActivityThread();
                ActivityTaskManager.getService().moveTaskToFront(thread.getApplicationThread(), HeavyWeightSwitcherActivity.this.getPackageName(), HeavyWeightSwitcherActivity.this.mCurTask, 0, (Bundle) null);
            } catch (RemoteException e2) {
            }
            HeavyWeightSwitcherActivity.this.finish();
        }
    };
    private View.OnClickListener mSwitchNewListener = new View.OnClickListener() { // from class: com.android.internal.app.HeavyWeightSwitcherActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v2) {
            try {
                ActivityManager.getService().finishHeavyWeightApp();
            } catch (RemoteException e2) {
            }
            try {
                if (HeavyWeightSwitcherActivity.this.mHasResult) {
                    HeavyWeightSwitcherActivity heavyWeightSwitcherActivity = HeavyWeightSwitcherActivity.this;
                    heavyWeightSwitcherActivity.startIntentSenderForResult(heavyWeightSwitcherActivity.mStartIntent, -1, null, 33554432, 33554432, 0);
                } else {
                    ActivityOptions activityOptions = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1);
                    HeavyWeightSwitcherActivity heavyWeightSwitcherActivity2 = HeavyWeightSwitcherActivity.this;
                    heavyWeightSwitcherActivity2.startIntentSenderForResult(heavyWeightSwitcherActivity2.mStartIntent, -1, null, 0, 0, 0, activityOptions.toBundle());
                }
            } catch (IntentSender.SendIntentException ex) {
                Log.w("HeavyWeightSwitcherActivity", "Failure starting", ex);
            }
            HeavyWeightSwitcherActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        this.mStartIntent = (IntentSender) getIntent().getParcelableExtra("intent", IntentSender.class);
        this.mHasResult = getIntent().getBooleanExtra(KEY_HAS_RESULT, false);
        this.mCurApp = getIntent().getStringExtra(KEY_CUR_APP);
        this.mCurTask = getIntent().getIntExtra(KEY_CUR_TASK, 0);
        this.mNewApp = getIntent().getStringExtra(KEY_NEW_APP);
        setContentView(17367177);
        setIconAndText(16909327, 16909326, 0, this.mCurApp, this.mNewApp, 17040996, 0);
        setIconAndText(16909282, 16909280, 16909281, this.mNewApp, this.mCurApp, 17040917, 17040918);
        View button = findViewById(16909589);
        button.setOnClickListener(this.mSwitchOldListener);
        View button2 = findViewById(16909588);
        button2.setOnClickListener(this.mSwitchNewListener);
    }

    void setText(int id2, CharSequence text) {
        ((TextView) findViewById(id2)).setText(text);
    }

    void setDrawable(int id2, Drawable dr) {
        if (dr != null) {
            ((ImageView) findViewById(id2)).setImageDrawable(dr);
        }
    }

    void setIconAndText(int iconId, int actionId, int descriptionId, String packageName, String otherPackageName, int actionStr, int descriptionStr) {
        CharSequence appName = packageName;
        Drawable appIcon = null;
        if (packageName != null) {
            try {
                ApplicationInfo info = getPackageManager().getApplicationInfo(packageName, 0);
                appName = info.loadLabel(getPackageManager());
                appIcon = info.loadIcon(getPackageManager());
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        setDrawable(iconId, appIcon);
        setText(actionId, getString(actionStr, new Object[]{appName}));
        if (descriptionId != 0) {
            CharSequence otherAppName = otherPackageName;
            if (otherPackageName != null) {
                try {
                    otherAppName = getPackageManager().getApplicationInfo(otherPackageName, 0).loadLabel(getPackageManager());
                } catch (PackageManager.NameNotFoundException e10) {
                }
            }
            setText(descriptionId, getString(descriptionStr, new Object[]{otherAppName}));
        }
    }
}
