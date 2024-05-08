package com.android.internal.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.graphics.drawable.Drawable;
import android.metrics.LogMaker;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.util.Log;
import android.util.Slog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.internal.R;
import com.android.internal.app.IntentForwarderActivity;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.nano.MetricsProto;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class IntentForwarderActivity extends Activity {
    public static final String EXTRA_SKIP_USER_CONFIRMATION = "com.android.internal.app.EXTRA_SKIP_USER_CONFIRMATION";
    private static final String TEL_SCHEME = "tel";
    protected ExecutorService mExecutorService;
    private Injector mInjector;
    private MetricsLogger mMetricsLogger;
    public static String TAG = "IntentForwarderActivity";
    public static String FORWARD_INTENT_TO_PARENT = "com.android.internal.app.ForwardIntentToParent";
    public static String FORWARD_INTENT_TO_MANAGED_PROFILE = "com.android.internal.app.ForwardIntentToManagedProfile";
    private static final Set<String> ALLOWED_TEXT_MESSAGE_SCHEMES = new HashSet(Arrays.asList("sms", "smsto", "mms", "mmsto"));
    private static final ComponentName RESOLVER_COMPONENT_NAME = new ComponentName("android", ResolverActivity.class.getName());

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Injector {
        IPackageManager getIPackageManager();

        PackageManager getPackageManager();

        UserManager getUserManager();

        CompletableFuture<ResolveInfo> resolveActivityAsUser(Intent intent, int i10, int i11);

        void showToast(String str, int i10);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mExecutorService.shutdown();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String userMessage;
        int targetUserId;
        UserInfo managedProfile;
        super.onCreate(savedInstanceState);
        this.mInjector = createInjector();
        this.mExecutorService = Executors.newSingleThreadExecutor();
        final Intent intentReceived = getIntent();
        final String className = intentReceived.getComponent().getClassName();
        if (className.equals(FORWARD_INTENT_TO_PARENT)) {
            String userMessage2 = getForwardToPersonalMessage();
            int targetUserId2 = getProfileParent();
            getMetricsLogger().write(new LogMaker(MetricsProto.MetricsEvent.ACTION_SWITCH_SHARE_PROFILE).setSubtype(1));
            userMessage = userMessage2;
            targetUserId = targetUserId2;
            managedProfile = null;
        } else {
            String userMessage3 = FORWARD_INTENT_TO_MANAGED_PROFILE;
            if (className.equals(userMessage3)) {
                String userMessage4 = getForwardToWorkMessage();
                UserInfo managedProfile2 = getManagedProfile();
                int targetUserId3 = managedProfile2 == null ? -10000 : managedProfile2.id;
                getMetricsLogger().write(new LogMaker(MetricsProto.MetricsEvent.ACTION_SWITCH_SHARE_PROFILE).setSubtype(2));
                userMessage = userMessage4;
                targetUserId = targetUserId3;
                managedProfile = managedProfile2;
            } else {
                String userMessage5 = TAG;
                Slog.wtf(userMessage5, IntentForwarderActivity.class.getName() + " cannot be called directly");
                userMessage = null;
                targetUserId = -10000;
                managedProfile = null;
            }
        }
        if (targetUserId == -10000) {
            finish();
            return;
        }
        if ("android.intent.action.CHOOSER".equals(intentReceived.getAction())) {
            launchChooserActivityWithCorrectTab(intentReceived, className);
            return;
        }
        final int callingUserId = getUserId();
        final Intent newIntent = canForward(intentReceived, getUserId(), targetUserId, this.mInjector.getIPackageManager(), getContentResolver());
        if (newIntent == null) {
            Slog.wtf(TAG, "the intent: " + ((Object) intentReceived) + " cannot be forwarded from user " + callingUserId + " to user " + targetUserId);
            finish();
            return;
        }
        newIntent.prepareToLeaveUser(callingUserId);
        CompletableFuture<ResolveInfo> targetResolveInfoFuture = this.mInjector.resolveActivityAsUser(newIntent, 65536, targetUserId);
        final int i10 = targetUserId;
        CompletionStage thenApplyAsync = targetResolveInfoFuture.thenApplyAsync(new Function() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ResolveInfo lambda$onCreate$0;
                lambda$onCreate$0 = IntentForwarderActivity.this.lambda$onCreate$0(intentReceived, className, newIntent, callingUserId, i10, (ResolveInfo) obj);
                return lambda$onCreate$0;
            }
        }, (Executor) this.mExecutorService);
        final String str = userMessage;
        final UserInfo userInfo = managedProfile;
        thenApplyAsync.thenAcceptAsync(new Consumer() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                IntentForwarderActivity.this.lambda$onCreate$1(className, intentReceived, str, newIntent, userInfo, (ResolveInfo) obj);
            }
        }, getApplicationContext().getMainExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ResolveInfo lambda$onCreate$0(Intent intentReceived, String className, Intent newIntent, int callingUserId, int targetUserId, ResolveInfo targetResolveInfo) {
        if (isResolverActivityResolveInfo(targetResolveInfo)) {
            launchResolverActivityWithCorrectTab(intentReceived, className, newIntent, callingUserId, targetUserId);
        } else if (className.equals(FORWARD_INTENT_TO_PARENT)) {
            startActivityAsCaller(newIntent, targetUserId);
        }
        return targetResolveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(String className, Intent intentReceived, String userMessage, Intent newIntent, UserInfo managedProfile, ResolveInfo result) {
        if (className.equals(FORWARD_INTENT_TO_PARENT)) {
            maybeShowDisclosure(intentReceived, result, userMessage);
            finish();
        } else if (className.equals(FORWARD_INTENT_TO_MANAGED_PROFILE)) {
            maybeShowUserConsentMiniResolver(result, newIntent, managedProfile);
        }
    }

    private void maybeShowUserConsentMiniResolver(ResolveInfo target, final Intent launchIntent, UserInfo managedProfile) {
        if (target == null || isIntentForwarderResolveInfo(target) || !isDeviceProvisioned()) {
            finish();
            return;
        }
        final int targetUserId = managedProfile == null ? -10000 : managedProfile.id;
        String callingPackage = getCallingPackage();
        boolean privilegedCallerAskedToSkipUserConsent = launchIntent.getBooleanExtra(EXTRA_SKIP_USER_CONFIRMATION, false) && callingPackage != null && getPackageManager().checkPermission("android.permission.INTERACT_ACROSS_USERS", callingPackage) == 0;
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService(DevicePolicyManager.class);
        ComponentName profileOwnerName = devicePolicyManager.getProfileOwnerAsUser(targetUserId);
        boolean intentToLaunchProfileOwner = profileOwnerName != null && profileOwnerName.getPackageName().equals(target.getComponentInfo().packageName);
        if (privilegedCallerAskedToSkipUserConsent || intentToLaunchProfileOwner) {
            Log.i("IntentForwarderActivity", String.format("Skipping user consent for redirection into the managed profile for intent [%s], privilegedCallerAskedToSkipUserConsent=[%s], intentToLaunchProfileOwner=[%s]", launchIntent, Boolean.valueOf(privilegedCallerAskedToSkipUserConsent), Boolean.valueOf(intentToLaunchProfileOwner)));
            startActivityAsCaller(launchIntent, targetUserId);
            finish();
            return;
        }
        Log.i("IntentForwarderActivity", String.format("Showing user consent for redirection into the managed profile for intent [%s] and  calling package [%s]", launchIntent, callingPackage));
        setContentView(17367212);
        findViewById(16909647).setElevation(0.0f);
        PackageManager packageManagerForTargetUser = createContextAsUser(UserHandle.of(targetUserId), 0).getPackageManager();
        ImageView icon = (ImageView) findViewById(16908294);
        icon.setImageDrawable(getAppIcon(target, launchIntent, targetUserId, packageManagerForTargetUser));
        View buttonContainer = findViewById(16908848);
        buttonContainer.setPadding(0, 0, 0, buttonContainer.getPaddingBottom());
        ((TextView) findViewById(16909332)).setText(getOpenInWorkMessage(launchIntent, target.loadLabel(packageManagerForTargetUser)));
        ((Button) findViewById(R.id.use_same_profile_browser)).setText(17039360);
        findViewById(R.id.use_same_profile_browser).setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntentForwarderActivity.this.lambda$maybeShowUserConsentMiniResolver$2(view);
            }
        });
        ((Button) findViewById(16908850)).setText(getOpenInWorkButtonString(launchIntent));
        findViewById(16908850).setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntentForwarderActivity.this.lambda$maybeShowUserConsentMiniResolver$3(launchIntent, targetUserId, view);
            }
        });
        View telephonyInfo = findViewById(16909250);
        if ((isDialerIntent(launchIntent) || isTextMessageIntent(launchIntent)) && devicePolicyManager.getManagedSubscriptionsPolicy().getPolicyType() == 1) {
            telephonyInfo.setVisibility(0);
            ((TextView) findViewById(16909252)).setText(getWorkTelephonyInfoSectionMessage(launchIntent));
        } else {
            telephonyInfo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maybeShowUserConsentMiniResolver$2(View v2) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maybeShowUserConsentMiniResolver$3(Intent launchIntent, int targetUserId, View v2) {
        startActivityAsCaller(launchIntent, ActivityOptions.makeCustomAnimation(getApplicationContext(), 17432591, 17432691).toBundle(), false, targetUserId);
        finish();
    }

    private Drawable getAppIcon(ResolveInfo target, Intent launchIntent, int targetUserId, PackageManager packageManagerForTargetUser) {
        if (isDialerIntent(launchIntent)) {
            TelecomManager telecomManager = (TelecomManager) getApplicationContext().getSystemService(TelecomManager.class);
            String defaultDialerPackageName = telecomManager.getDefaultDialerPackage(UserHandle.of(targetUserId));
            try {
                return packageManagerForTargetUser.getApplicationInfo(defaultDialerPackageName, 0).loadIcon(packageManagerForTargetUser);
            } catch (PackageManager.NameNotFoundException e2) {
                Slog.w(TAG, "Cannot load icon for default dialer package");
            }
        }
        return target.loadIcon(packageManagerForTargetUser);
    }

    private int getOpenInWorkButtonString(Intent launchIntent) {
        if (isDialerIntent(launchIntent)) {
            return 17040861;
        }
        if (isTextMessageIntent(launchIntent)) {
            return 17040868;
        }
        return R.string.whichViewApplicationLabel;
    }

    private String getOpenInWorkMessage(Intent launchIntent, final CharSequence targetLabel) {
        if (isDialerIntent(launchIntent)) {
            return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.MINIRESOLVER_CALL_FROM_WORK", new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$getOpenInWorkMessage$4;
                    lambda$getOpenInWorkMessage$4 = IntentForwarderActivity.this.lambda$getOpenInWorkMessage$4();
                    return lambda$getOpenInWorkMessage$4;
                }
            });
        }
        if (isTextMessageIntent(launchIntent)) {
            return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.MINIRESOLVER_SWITCH_TO_WORK", new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$getOpenInWorkMessage$5;
                    lambda$getOpenInWorkMessage$5 = IntentForwarderActivity.this.lambda$getOpenInWorkMessage$5();
                    return lambda$getOpenInWorkMessage$5;
                }
            });
        }
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.MINIRESOLVER_OPEN_WORK", new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getOpenInWorkMessage$6;
                lambda$getOpenInWorkMessage$6 = IntentForwarderActivity.this.lambda$getOpenInWorkMessage$6(targetLabel);
                return lambda$getOpenInWorkMessage$6;
            }
        }, targetLabel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getOpenInWorkMessage$4() {
        return getString(17040862);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getOpenInWorkMessage$5() {
        return getString(17040869);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getOpenInWorkMessage$6(CharSequence targetLabel) {
        return getString(17040866, new Object[]{targetLabel});
    }

    private String getWorkTelephonyInfoSectionMessage(Intent launchIntent) {
        if (isDialerIntent(launchIntent)) {
            return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.MINIRESOLVER_WORK_TELEPHONY_INFORMATION", new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda5
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$getWorkTelephonyInfoSectionMessage$7;
                    lambda$getWorkTelephonyInfoSectionMessage$7 = IntentForwarderActivity.this.lambda$getWorkTelephonyInfoSectionMessage$7();
                    return lambda$getWorkTelephonyInfoSectionMessage$7;
                }
            });
        }
        if (isTextMessageIntent(launchIntent)) {
            return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.MINIRESOLVER_WORK_TELEPHONY_INFORMATION", new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda6
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$getWorkTelephonyInfoSectionMessage$8;
                    lambda$getWorkTelephonyInfoSectionMessage$8 = IntentForwarderActivity.this.lambda$getWorkTelephonyInfoSectionMessage$8();
                    return lambda$getWorkTelephonyInfoSectionMessage$8;
                }
            });
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getWorkTelephonyInfoSectionMessage$7() {
        return getString(17040863);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getWorkTelephonyInfoSectionMessage$8() {
        return getString(17040867);
    }

    private String getForwardToPersonalMessage() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.FORWARD_INTENT_TO_PERSONAL", new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getForwardToPersonalMessage$9;
                lambda$getForwardToPersonalMessage$9 = IntentForwarderActivity.this.lambda$getForwardToPersonalMessage$9();
                return lambda$getForwardToPersonalMessage$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getForwardToPersonalMessage$9() {
        return getString(17040428);
    }

    private String getForwardToWorkMessage() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.FORWARD_INTENT_TO_WORK", new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getForwardToWorkMessage$10;
                lambda$getForwardToWorkMessage$10 = IntentForwarderActivity.this.lambda$getForwardToWorkMessage$10();
                return lambda$getForwardToWorkMessage$10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getForwardToWorkMessage$10() {
        return getString(17040429);
    }

    private boolean isIntentForwarderResolveInfo(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        if (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || !"android".equals(activityInfo.packageName)) {
            return false;
        }
        return activityInfo.name.equals(FORWARD_INTENT_TO_PARENT) || activityInfo.name.equals(FORWARD_INTENT_TO_MANAGED_PROFILE);
    }

    private boolean isResolverActivityResolveInfo(ResolveInfo resolveInfo) {
        return (resolveInfo == null || resolveInfo.activityInfo == null || !RESOLVER_COMPONENT_NAME.equals(resolveInfo.activityInfo.getComponentName())) ? false : true;
    }

    private void maybeShowDisclosure(Intent intentReceived, ResolveInfo resolveInfo, String message) {
        if (shouldShowDisclosure(resolveInfo, intentReceived) && message != null) {
            this.mInjector.showToast(message, 1);
        }
    }

    private void startActivityAsCaller(Intent newIntent, int userId) {
        try {
            startActivityAsCaller(newIntent, null, false, userId);
        } catch (RuntimeException e2) {
            Slog.wtf(TAG, "Unable to launch as UID " + getLaunchedFromUid() + " package " + getLaunchedFromPackage() + ", while running in " + ActivityThread.currentProcessName(), e2);
        }
    }

    private void launchChooserActivityWithCorrectTab(Intent intentReceived, String className) {
        int selectedProfile = findSelectedProfile(className);
        sanitizeIntent(intentReceived);
        intentReceived.putExtra("com.android.internal.app.ResolverActivity.EXTRA_SELECTED_PROFILE", selectedProfile);
        Intent innerIntent = (Intent) intentReceived.getParcelableExtra("android.intent.extra.INTENT", Intent.class);
        if (innerIntent == null) {
            Slog.wtf(TAG, "Cannot start a chooser intent with no extra android.intent.extra.INTENT");
            return;
        }
        sanitizeIntent(innerIntent);
        startActivityAsCaller(intentReceived, null, false, getUserId());
        finish();
    }

    private void launchResolverActivityWithCorrectTab(Intent intentReceived, String className, Intent newIntent, int callingUserId, int targetUserId) {
        ResolveInfo callingResolveInfo = this.mInjector.resolveActivityAsUser(newIntent, 65536, callingUserId).join();
        int userId = isIntentForwarderResolveInfo(callingResolveInfo) ? targetUserId : callingUserId;
        int selectedProfile = findSelectedProfile(className);
        sanitizeIntent(intentReceived);
        intentReceived.putExtra("com.android.internal.app.ResolverActivity.EXTRA_SELECTED_PROFILE", selectedProfile);
        intentReceived.putExtra("com.android.internal.app.ResolverActivity.EXTRA_CALLING_USER", UserHandle.of(callingUserId));
        startActivityAsCaller(intentReceived, null, false, userId);
        finish();
    }

    private int findSelectedProfile(String className) {
        if (className.equals(FORWARD_INTENT_TO_PARENT)) {
            return 0;
        }
        if (className.equals(FORWARD_INTENT_TO_MANAGED_PROFILE)) {
            return 1;
        }
        return -1;
    }

    private boolean shouldShowDisclosure(ResolveInfo ri, Intent intent) {
        if (!isDeviceProvisioned()) {
            return false;
        }
        if (ri == null || ri.activityInfo == null) {
            return true;
        }
        if (ri.activityInfo.applicationInfo.isSystemApp() && (isDialerIntent(intent) || isTextMessageIntent(intent))) {
            return false;
        }
        return true ^ isTargetResolverOrChooserActivity(ri.activityInfo);
    }

    private boolean isDeviceProvisioned() {
        return Settings.Global.getInt(getContentResolver(), "device_provisioned", 0) != 0;
    }

    private boolean isTextMessageIntent(Intent intent) {
        return ("android.intent.action.SENDTO".equals(intent.getAction()) || isViewActionIntent(intent)) && ALLOWED_TEXT_MESSAGE_SCHEMES.contains(intent.getScheme());
    }

    private boolean isDialerIntent(Intent intent) {
        return "android.intent.action.DIAL".equals(intent.getAction()) || "android.intent.action.CALL".equals(intent.getAction()) || "android.intent.action.CALL_PRIVILEGED".equals(intent.getAction()) || "android.intent.action.CALL_EMERGENCY".equals(intent.getAction()) || (isViewActionIntent(intent) && TEL_SCHEME.equals(intent.getScheme()));
    }

    private boolean isViewActionIntent(Intent intent) {
        return "android.intent.action.VIEW".equals(intent.getAction()) && intent.hasCategory("android.intent.category.BROWSABLE");
    }

    private boolean isTargetResolverOrChooserActivity(ActivityInfo activityInfo) {
        if ("android".equals(activityInfo.packageName)) {
            return ResolverActivity.class.getName().equals(activityInfo.name) || ChooserActivity.class.getName().equals(activityInfo.name);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent canForward(Intent incomingIntent, int sourceUserId, int targetUserId, IPackageManager packageManager, ContentResolver contentResolver) {
        Intent forwardIntent = new Intent(incomingIntent);
        forwardIntent.addFlags(50331648);
        sanitizeIntent(forwardIntent);
        Intent intentToCheck = forwardIntent;
        if ("android.intent.action.CHOOSER".equals(forwardIntent.getAction())) {
            return null;
        }
        if (forwardIntent.getSelector() != null) {
            intentToCheck = forwardIntent.getSelector();
        }
        String resolvedType = intentToCheck.resolveTypeIfNeeded(contentResolver);
        sanitizeIntent(intentToCheck);
        try {
        } catch (RemoteException e2) {
            Slog.e(TAG, "PackageManagerService is dead?");
        }
        if (packageManager.canForwardTo(intentToCheck, resolvedType, sourceUserId, targetUserId)) {
            return forwardIntent;
        }
        return null;
    }

    private UserInfo getManagedProfile() {
        List<UserInfo> relatedUsers = this.mInjector.getUserManager().getProfiles(UserHandle.myUserId());
        for (UserInfo userInfo : relatedUsers) {
            if (userInfo.isManagedProfile()) {
                return userInfo;
            }
        }
        Slog.wtf(TAG, FORWARD_INTENT_TO_MANAGED_PROFILE + " has been called, but there is no managed profile");
        return null;
    }

    private int getProfileParent() {
        UserInfo parent = this.mInjector.getUserManager().getProfileParent(UserHandle.myUserId());
        if (parent == null) {
            Slog.wtf(TAG, FORWARD_INTENT_TO_PARENT + " has been called, but there is no parent");
            return -10000;
        }
        return parent.id;
    }

    private static void sanitizeIntent(Intent intent) {
        intent.setPackage(null);
        intent.setComponent(null);
    }

    protected MetricsLogger getMetricsLogger() {
        if (this.mMetricsLogger == null) {
            this.mMetricsLogger = new MetricsLogger();
        }
        return this.mMetricsLogger;
    }

    protected Injector createInjector() {
        return new InjectorImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class InjectorImpl implements Injector {
        private InjectorImpl() {
        }

        @Override // com.android.internal.app.IntentForwarderActivity.Injector
        public IPackageManager getIPackageManager() {
            return AppGlobals.getPackageManager();
        }

        @Override // com.android.internal.app.IntentForwarderActivity.Injector
        public UserManager getUserManager() {
            return (UserManager) IntentForwarderActivity.this.getSystemService(UserManager.class);
        }

        @Override // com.android.internal.app.IntentForwarderActivity.Injector
        public PackageManager getPackageManager() {
            return IntentForwarderActivity.this.getPackageManager();
        }

        @Override // com.android.internal.app.IntentForwarderActivity.Injector
        public CompletableFuture<ResolveInfo> resolveActivityAsUser(final Intent intent, final int flags, final int userId) {
            return CompletableFuture.supplyAsync(new Supplier() { // from class: com.android.internal.app.IntentForwarderActivity$InjectorImpl$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    ResolveInfo lambda$resolveActivityAsUser$0;
                    lambda$resolveActivityAsUser$0 = IntentForwarderActivity.InjectorImpl.this.lambda$resolveActivityAsUser$0(intent, flags, userId);
                    return lambda$resolveActivityAsUser$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ResolveInfo lambda$resolveActivityAsUser$0(Intent intent, int flags, int userId) {
            return getPackageManager().resolveActivityAsUser(intent, flags, userId);
        }

        @Override // com.android.internal.app.IntentForwarderActivity.Injector
        public void showToast(String message, int duration) {
            Toast.makeText(IntentForwarderActivity.this, message, duration).show();
        }
    }
}
