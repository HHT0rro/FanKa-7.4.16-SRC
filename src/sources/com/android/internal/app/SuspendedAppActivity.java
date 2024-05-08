package com.android.internal.app;

import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.KeyguardManager;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.SuspendDialogInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.app.AlertController;
import com.android.internal.util.ArrayUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SuspendedAppActivity extends AlertActivity implements DialogInterface.OnClickListener {
    public static final String EXTRA_ACTIVITY_OPTIONS = "com.android.internal.app.extra.ACTIVITY_OPTIONS";
    public static final String EXTRA_DIALOG_INFO = "com.android.internal.app.extra.DIALOG_INFO";
    public static final String EXTRA_SUSPENDED_PACKAGE = "com.android.internal.app.extra.SUSPENDED_PACKAGE";
    public static final String EXTRA_SUSPENDING_PACKAGE = "com.android.internal.app.extra.SUSPENDING_PACKAGE";
    public static final String EXTRA_UNSUSPEND_INTENT = "com.android.internal.app.extra.UNSUSPEND_INTENT";
    private static final String PACKAGE_NAME = "com.android.internal.app";
    private static final String TAG = SuspendedAppActivity.class.getSimpleName();
    private Intent mMoreDetailsIntent;
    private int mNeutralButtonAction;
    private IntentSender mOnUnsuspend;
    private Bundle mOptions;
    private PackageManager mPm;
    private SuspendDialogInfo mSuppliedDialogInfo;
    private BroadcastReceiver mSuspendModifiedReceiver = new BroadcastReceiver() { // from class: com.android.internal.app.SuspendedAppActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.PACKAGES_SUSPENSION_CHANGED".equals(intent.getAction())) {
                String[] modified = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
                if (ArrayUtils.contains(modified, SuspendedAppActivity.this.mSuspendedPackage) && !SuspendedAppActivity.this.isFinishing()) {
                    Slog.w(SuspendedAppActivity.TAG, "Package " + SuspendedAppActivity.this.mSuspendedPackage + " has modified suspension conditions while dialog was visible. Finishing.");
                    SuspendedAppActivity.this.finish();
                }
            }
        }
    };
    private String mSuspendedPackage;
    private Resources mSuspendingAppResources;
    private String mSuspendingPackage;
    private int mUserId;
    private UsageStatsManager mUsm;

    private CharSequence getAppLabel(String packageName) {
        try {
            return this.mPm.getApplicationInfoAsUser(packageName, 0, this.mUserId).loadLabel(this.mPm);
        } catch (PackageManager.NameNotFoundException ne2) {
            Slog.e(TAG, "Package " + packageName + " not found", ne2);
            return packageName;
        }
    }

    private Intent getMoreDetailsActivity() {
        Intent moreDetailsIntent = new Intent("android.intent.action.SHOW_SUSPENDED_APP_DETAILS").setPackage(this.mSuspendingPackage);
        ResolveInfo resolvedInfo = this.mPm.resolveActivityAsUser(moreDetailsIntent, 786432, this.mUserId);
        if (resolvedInfo != null && resolvedInfo.activityInfo != null && "android.permission.SEND_SHOW_SUSPENDED_APP_DETAILS".equals(resolvedInfo.activityInfo.permission)) {
            moreDetailsIntent.putExtra("android.intent.extra.PACKAGE_NAME", this.mSuspendedPackage).setFlags(335544320);
            return moreDetailsIntent;
        }
        return null;
    }

    private Drawable resolveIcon() {
        Resources resources;
        SuspendDialogInfo suspendDialogInfo = this.mSuppliedDialogInfo;
        int iconId = suspendDialogInfo != null ? suspendDialogInfo.getIconResId() : 0;
        if (iconId != 0 && (resources = this.mSuspendingAppResources) != null) {
            try {
                return resources.getDrawable(iconId, getTheme());
            } catch (Resources.NotFoundException e2) {
                Slog.e(TAG, "Could not resolve drawable resource id " + iconId);
                return null;
            }
        }
        return null;
    }

    private String resolveTitle() {
        Resources resources;
        SuspendDialogInfo suspendDialogInfo = this.mSuppliedDialogInfo;
        if (suspendDialogInfo != null) {
            int titleId = suspendDialogInfo.getTitleResId();
            String title = this.mSuppliedDialogInfo.getTitle();
            if (titleId != 0 && (resources = this.mSuspendingAppResources) != null) {
                try {
                    return resources.getString(titleId);
                } catch (Resources.NotFoundException e2) {
                    Slog.e(TAG, "Could not resolve string resource id " + titleId);
                }
            } else if (title != null) {
                return title;
            }
        }
        return getString(17039713);
    }

    private String resolveDialogMessage() {
        Resources resources;
        CharSequence suspendedAppLabel = getAppLabel(this.mSuspendedPackage);
        SuspendDialogInfo suspendDialogInfo = this.mSuppliedDialogInfo;
        if (suspendDialogInfo != null) {
            int messageId = suspendDialogInfo.getDialogMessageResId();
            String message = this.mSuppliedDialogInfo.getDialogMessage();
            if (messageId != 0 && (resources = this.mSuspendingAppResources) != null) {
                try {
                    return resources.getString(messageId, suspendedAppLabel);
                } catch (Resources.NotFoundException e2) {
                    Slog.e(TAG, "Could not resolve string resource id " + messageId);
                }
            } else if (message != null) {
                return String.format(getResources().getConfiguration().getLocales().get(0), message, suspendedAppLabel);
            }
        }
        return getString(17039711, new Object[]{suspendedAppLabel, getAppLabel(this.mSuspendingPackage)});
    }

    private String resolveNeutralButtonText() {
        int defaultButtonTextId;
        Resources resources;
        switch (this.mNeutralButtonAction) {
            case 0:
                if (this.mMoreDetailsIntent != null) {
                    defaultButtonTextId = 17039712;
                    break;
                } else {
                    return null;
                }
            case 1:
                defaultButtonTextId = 17039714;
                break;
            default:
                Slog.w(TAG, "Unknown neutral button action: " + this.mNeutralButtonAction);
                return null;
        }
        SuspendDialogInfo suspendDialogInfo = this.mSuppliedDialogInfo;
        if (suspendDialogInfo != null) {
            int buttonTextId = suspendDialogInfo.getNeutralButtonTextResId();
            String buttonText = this.mSuppliedDialogInfo.getNeutralButtonText();
            if (buttonTextId != 0 && (resources = this.mSuspendingAppResources) != null) {
                try {
                    return resources.getString(buttonTextId);
                } catch (Resources.NotFoundException e2) {
                    Slog.e(TAG, "Could not resolve string resource id " + buttonTextId);
                }
            } else if (buttonText != null) {
                return buttonText;
            }
        }
        return getString(defaultButtonTextId);
    }

    @Override // com.android.internal.app.AlertActivity, android.app.Activity
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.mPm = getPackageManager();
        this.mUsm = (UsageStatsManager) getSystemService(UsageStatsManager.class);
        getWindow().setType(2008);
        Intent intent = getIntent();
        this.mOptions = intent.getBundleExtra(EXTRA_ACTIVITY_OPTIONS);
        int intExtra = intent.getIntExtra("android.intent.extra.USER_ID", -1);
        this.mUserId = intExtra;
        if (intExtra < 0) {
            Slog.wtf(TAG, "Invalid user: " + this.mUserId);
            finish();
            return;
        }
        this.mSuspendedPackage = intent.getStringExtra(EXTRA_SUSPENDED_PACKAGE);
        this.mSuspendingPackage = intent.getStringExtra(EXTRA_SUSPENDING_PACKAGE);
        this.mSuppliedDialogInfo = (SuspendDialogInfo) intent.getParcelableExtra(EXTRA_DIALOG_INFO, SuspendDialogInfo.class);
        this.mOnUnsuspend = (IntentSender) intent.getParcelableExtra(EXTRA_UNSUSPEND_INTENT, IntentSender.class);
        if (this.mSuppliedDialogInfo != null) {
            try {
                this.mSuspendingAppResources = createContextAsUser(UserHandle.of(this.mUserId), 0).getPackageManager().getResourcesForApplication(this.mSuspendingPackage);
            } catch (PackageManager.NameNotFoundException ne2) {
                Slog.e(TAG, "Could not find resources for " + this.mSuspendingPackage, ne2);
            }
        }
        SuspendDialogInfo suspendDialogInfo = this.mSuppliedDialogInfo;
        int neutralButtonAction = suspendDialogInfo != null ? suspendDialogInfo.getNeutralButtonAction() : 0;
        this.mNeutralButtonAction = neutralButtonAction;
        this.mMoreDetailsIntent = neutralButtonAction == 0 ? getMoreDetailsActivity() : null;
        AlertController.AlertParams ap = this.mAlertParams;
        ap.mIcon = resolveIcon();
        ap.mTitle = resolveTitle();
        ap.mMessage = resolveDialogMessage();
        ap.mPositiveButtonText = getString(17039370);
        ap.mNeutralButtonText = resolveNeutralButtonText();
        ap.mNeutralButtonListener = this;
        ap.mPositiveButtonListener = this;
        requestDismissKeyguardIfNeeded(ap.mMessage);
        setupAlert();
        IntentFilter suspendModifiedFilter = new IntentFilter("android.intent.action.PACKAGES_SUSPENSION_CHANGED");
        registerReceiverAsUser(this.mSuspendModifiedReceiver, UserHandle.of(this.mUserId), suspendModifiedFilter, null, null);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mSuspendModifiedReceiver);
    }

    private void requestDismissKeyguardIfNeeded(CharSequence dismissMessage) {
        KeyguardManager km = (KeyguardManager) getSystemService(KeyguardManager.class);
        if (km.isKeyguardLocked()) {
            km.requestDismissKeyguard(this, dismissMessage, new KeyguardManager.KeyguardDismissCallback() { // from class: com.android.internal.app.SuspendedAppActivity.2
                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissError() {
                    Slog.e(SuspendedAppActivity.TAG, "Error while dismissing keyguard. Keeping the dialog visible.");
                }

                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissCancelled() {
                    Slog.w(SuspendedAppActivity.TAG, "Keyguard dismiss was cancelled. Finishing.");
                    SuspendedAppActivity.this.finish();
                }
            });
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case -3:
                switch (this.mNeutralButtonAction) {
                    case 0:
                        Intent intent = this.mMoreDetailsIntent;
                        if (intent != null) {
                            startActivityAsUser(intent, this.mOptions, UserHandle.of(this.mUserId));
                            break;
                        } else {
                            Slog.wtf(TAG, "Neutral button should not have existed!");
                            break;
                        }
                    case 1:
                        IPackageManager ipm = AppGlobals.getPackageManager();
                        try {
                            String[] errored = ipm.setPackagesSuspendedAsUser(new String[]{this.mSuspendedPackage}, false, (PersistableBundle) null, (PersistableBundle) null, (SuspendDialogInfo) null, this.mSuspendingPackage, this.mUserId);
                            if (ArrayUtils.contains(errored, this.mSuspendedPackage)) {
                                Slog.e(TAG, "Could not unsuspend " + this.mSuspendedPackage);
                                break;
                            } else {
                                Intent reportUnsuspend = new Intent().setAction("android.intent.action.PACKAGE_UNSUSPENDED_MANUALLY").putExtra("android.intent.extra.PACKAGE_NAME", this.mSuspendedPackage).setPackage(this.mSuspendingPackage).addFlags(16777216);
                                sendBroadcastAsUser(reportUnsuspend, UserHandle.of(this.mUserId));
                                if (this.mOnUnsuspend != null) {
                                    Bundle activityOptions = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle();
                                    try {
                                        this.mOnUnsuspend.sendIntent(this, 0, null, null, null, null, activityOptions);
                                        break;
                                    } catch (IntentSender.SendIntentException e2) {
                                        Slog.e(TAG, "Error while starting intent " + ((Object) this.mOnUnsuspend), e2);
                                        break;
                                    }
                                }
                            }
                        } catch (RemoteException re) {
                            Slog.e(TAG, "Can't talk to system process", re);
                            break;
                        }
                        break;
                    default:
                        Slog.e(TAG, "Unexpected action on neutral button: " + this.mNeutralButtonAction);
                        break;
                }
        }
        this.mUsm.reportUserInteraction(this.mSuspendingPackage, this.mUserId);
        finish();
    }

    public static Intent createSuspendedAppInterceptIntent(String suspendedPackage, String suspendingPackage, SuspendDialogInfo dialogInfo, Bundle options, IntentSender onUnsuspend, int userId) {
        return new Intent().setClassName("android", SuspendedAppActivity.class.getName()).putExtra(EXTRA_SUSPENDED_PACKAGE, suspendedPackage).putExtra(EXTRA_DIALOG_INFO, (Parcelable) dialogInfo).putExtra(EXTRA_SUSPENDING_PACKAGE, suspendingPackage).putExtra(EXTRA_UNSUSPEND_INTENT, onUnsuspend).putExtra(EXTRA_ACTIVITY_OPTIONS, options).putExtra("android.intent.extra.USER_ID", userId).setFlags(276824064);
    }
}
