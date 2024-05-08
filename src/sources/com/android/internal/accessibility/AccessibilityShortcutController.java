package com.android.internal.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.AlertDialog;
import android.app.dialog.IOplusAlertDialogBuilderExt;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.android.internal.accessibility.AccessibilityShortcutController;
import com.android.internal.accessibility.dialog.AccessibilityTarget;
import com.android.internal.accessibility.dialog.AccessibilityTargetHelper;
import com.android.internal.os.RoSystemProperties;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import system.ext.loader.core.ExtLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AccessibilityShortcutController {
    public static final String MAGNIFICATION_CONTROLLER_NAME = "com.android.server.accessibility.MagnificationController";
    private static final String TAG = "AccessibilityShortcutController";
    private static Map<ComponentName, FrameworkFeatureInfo> sFrameworkShortcutFeaturesMap;
    private AlertDialog mAlertDialog;
    private final Context mContext;
    private boolean mEnabledOnLockScreen;
    public FrameworkObjectProvider mFrameworkObjectProvider = new FrameworkObjectProvider();
    private final Handler mHandler;
    private boolean mIsShortcutEnabled;
    private int mUserId;
    private final UserSetupCompleteObserver mUserSetupCompleteObserver;
    public static final ComponentName COLOR_INVERSION_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "ColorInversion");
    public static final ComponentName DALTONIZER_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "Daltonizer");
    public static final ComponentName MAGNIFICATION_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "Magnification");
    public static final ComponentName ONE_HANDED_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "OneHandedMode");
    public static final ComponentName REDUCE_BRIGHT_COLORS_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "ReduceBrightColors");
    public static final ComponentName FONT_SIZE_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "FontSize");
    public static final ComponentName ACCESSIBILITY_BUTTON_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "AccessibilityButton");
    public static final ComponentName ACCESSIBILITY_HEARING_AIDS_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "HearingAids");
    public static final ComponentName COLOR_INVERSION_TILE_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "ColorInversionTile");
    public static final ComponentName DALTONIZER_TILE_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "ColorCorrectionTile");
    public static final ComponentName ONE_HANDED_TILE_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "OneHandedModeTile");
    public static final ComponentName REDUCE_BRIGHT_COLORS_TILE_SERVICE_COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "ReduceBrightColorsTile");
    private static final AudioAttributes VIBRATION_ATTRIBUTES = new AudioAttributes.Builder().setContentType(4).setUsage(11).build();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private @interface DialogStatus {
        public static final int NOT_SHOWN = 0;
        public static final int SHOWN = 1;
    }

    public static Map<ComponentName, FrameworkFeatureInfo> getFrameworkShortcutFeaturesMap() {
        if (sFrameworkShortcutFeaturesMap == null) {
            Map<ComponentName, FrameworkFeatureInfo> featuresMap = new ArrayMap<>(4);
            featuresMap.put(COLOR_INVERSION_COMPONENT_NAME, new ToggleableFrameworkFeatureInfo("accessibility_display_inversion_enabled", "1", "0", 17039851));
            featuresMap.put(DALTONIZER_COMPONENT_NAME, new ToggleableFrameworkFeatureInfo("accessibility_display_daltonizer_enabled", "1", "0", 17039850));
            if (RoSystemProperties.SUPPORT_ONE_HANDED_MODE) {
                featuresMap.put(ONE_HANDED_COMPONENT_NAME, new ToggleableFrameworkFeatureInfo("one_handed_mode_activated", "1", "0", 17040999));
            }
            featuresMap.put(REDUCE_BRIGHT_COLORS_COMPONENT_NAME, new ToggleableFrameworkFeatureInfo("reduce_bright_colors_activated", "1", "0", 17041483));
            featuresMap.put(ACCESSIBILITY_HEARING_AIDS_COMPONENT_NAME, new LaunchableFrameworkFeatureInfo(17040479));
            sFrameworkShortcutFeaturesMap = Collections.unmodifiableMap(featuresMap);
        }
        return sFrameworkShortcutFeaturesMap;
    }

    public AccessibilityShortcutController(Context context, Handler handler, int initialUserId) {
        this.mContext = context;
        this.mHandler = handler;
        this.mUserId = initialUserId;
        this.mUserSetupCompleteObserver = new UserSetupCompleteObserver(handler, initialUserId);
        ContentObserver co = new ContentObserver(handler) { // from class: com.android.internal.accessibility.AccessibilityShortcutController.1
            AnonymousClass1(Handler handler2) {
                super(handler2);
            }

            public void onChange(boolean selfChange, Collection<Uri> uris, int flags, int userId) {
                if (userId == AccessibilityShortcutController.this.mUserId) {
                    AccessibilityShortcutController.this.onSettingsChanged();
                }
            }
        };
        context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_shortcut_target_service"), false, co, -1);
        context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_shortcut_on_lock_screen"), false, co, -1);
        context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_shortcut_dialog_shown"), false, co, -1);
        setCurrentUser(this.mUserId);
    }

    /* renamed from: com.android.internal.accessibility.AccessibilityShortcutController$1 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    class AnonymousClass1 extends ContentObserver {
        AnonymousClass1(Handler handler2) {
            super(handler2);
        }

        public void onChange(boolean selfChange, Collection<Uri> uris, int flags, int userId) {
            if (userId == AccessibilityShortcutController.this.mUserId) {
                AccessibilityShortcutController.this.onSettingsChanged();
            }
        }
    }

    public void setCurrentUser(int currentUserId) {
        this.mUserId = currentUserId;
        onSettingsChanged();
        this.mUserSetupCompleteObserver.onUserSwitched(currentUserId);
    }

    public boolean isAccessibilityShortcutAvailable(boolean phoneLocked) {
        return this.mIsShortcutEnabled && (!phoneLocked || this.mEnabledOnLockScreen);
    }

    public void onSettingsChanged() {
        boolean hasShortcutTarget = hasShortcutTarget();
        ContentResolver cr = this.mContext.getContentResolver();
        int dialogAlreadyShown = Settings.Secure.getIntForUser(cr, "accessibility_shortcut_dialog_shown", 0, this.mUserId);
        this.mEnabledOnLockScreen = Settings.Secure.getIntForUser(cr, "accessibility_shortcut_on_lock_screen", dialogAlreadyShown, this.mUserId) == 1;
        this.mIsShortcutEnabled = hasShortcutTarget;
    }

    public void performAccessibilityShortcut() {
        Slog.d(TAG, "Accessibility shortcut activated");
        ContentResolver cr = this.mContext.getContentResolver();
        int userId = ActivityManager.getCurrentUser();
        Vibrator vibrator = (Vibrator) this.mContext.getSystemService("vibrator");
        if (vibrator != null && vibrator.hasVibrator()) {
            long[] vibePattern = ArrayUtils.convertToLongArray(this.mContext.getResources().getIntArray(17236095));
            vibrator.vibrate(vibePattern, -1, VIBRATION_ATTRIBUTES);
        }
        if (shouldShowDialog()) {
            AlertDialog createShortcutWarningDialog = createShortcutWarningDialog(userId);
            this.mAlertDialog = createShortcutWarningDialog;
            if (createShortcutWarningDialog == null) {
                return;
            }
            if (!performTtsPrompt(createShortcutWarningDialog)) {
                playNotificationTone();
            }
            Window w3 = this.mAlertDialog.getWindow();
            WindowManager.LayoutParams attr = w3.getAttributes();
            attr.type = 2009;
            w3.setAttributes(attr);
            this.mAlertDialog.show();
            Settings.Secure.putIntForUser(cr, "accessibility_shortcut_dialog_shown", 1, userId);
            return;
        }
        playNotificationTone();
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mAlertDialog = null;
        }
        showToast();
        this.mFrameworkObjectProvider.getAccessibilityManagerInstance(this.mContext).performAccessibilityShortcut();
    }

    private boolean shouldShowDialog() {
        if (hasFeatureLeanback()) {
            return false;
        }
        ContentResolver cr = this.mContext.getContentResolver();
        int userId = ActivityManager.getCurrentUser();
        int dialogAlreadyShown = Settings.Secure.getIntForUser(cr, "accessibility_shortcut_dialog_shown", 0, userId);
        return dialogAlreadyShown == 0;
    }

    private void showToast() {
        int i10;
        AccessibilityServiceInfo serviceInfo = getInfoForTargetService();
        if (serviceInfo == null) {
            return;
        }
        String serviceName = getShortcutFeatureDescription(false);
        if (serviceName == null) {
            return;
        }
        boolean requestA11yButton = (serviceInfo.flags & 256) != 0;
        boolean isServiceEnabled = isServiceEnabled(serviceInfo);
        if (serviceInfo.getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion > 29 && requestA11yButton && isServiceEnabled) {
            return;
        }
        Context context = this.mContext;
        if (isServiceEnabled) {
            i10 = 17039594;
        } else {
            i10 = 17039595;
        }
        String toastMessageFormatString = context.getString(i10);
        String toastMessage = String.format(toastMessageFormatString, serviceName);
        Toast warningToast = this.mFrameworkObjectProvider.makeToastFromText(this.mContext, toastMessage, 1);
        warningToast.show();
    }

    private AlertDialog createShortcutWarningDialog(final int userId) {
        List<AccessibilityTarget> targets = AccessibilityTargetHelper.getTargets(this.mContext, 1);
        if (targets.size() == 0) {
            return null;
        }
        FrameworkObjectProvider frameworkObjectProvider = this.mFrameworkObjectProvider;
        AlertDialog alertDialog = frameworkObjectProvider.getAlertDialogBuilder(frameworkObjectProvider.getSystemUiContext()).setTitle(getShortcutWarningTitle(targets)).setMessage(getShortcutWarningMessage(targets)).setCancelable(false).setNegativeButton(17039602, (DialogInterface.OnClickListener) null).setPositiveButton(17039601, new DialogInterface.OnClickListener() { // from class: com.android.internal.accessibility.AccessibilityShortcutController$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                AccessibilityShortcutController.this.lambda$createShortcutWarningDialog$0(userId, dialogInterface, i10);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.internal.accessibility.AccessibilityShortcutController$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                AccessibilityShortcutController.this.lambda$createShortcutWarningDialog$1(userId, dialogInterface);
            }
        }).create();
        return alertDialog;
    }

    public /* synthetic */ void lambda$createShortcutWarningDialog$0(int userId, DialogInterface d10, int which) {
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "accessibility_shortcut_target_service", "", userId);
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "accessibility_shortcut_dialog_shown", 0, userId);
    }

    public /* synthetic */ void lambda$createShortcutWarningDialog$1(int userId, DialogInterface d10) {
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "accessibility_shortcut_dialog_shown", 0, userId);
    }

    private String getShortcutWarningTitle(List<AccessibilityTarget> targets) {
        if (targets.size() == 1) {
            return this.mContext.getString(17039604, targets.get(0).getLabel());
        }
        return this.mContext.getString(17039600);
    }

    private String getShortcutWarningMessage(List<AccessibilityTarget> targets) {
        if (targets.size() == 1) {
            return this.mContext.getString(17039603, targets.get(0).getLabel());
        }
        StringBuilder sb2 = new StringBuilder();
        for (AccessibilityTarget target : targets) {
            sb2.append(this.mContext.getString(17039598, target.getLabel()));
        }
        return this.mContext.getString(17039599, sb2.toString());
    }

    private AccessibilityServiceInfo getInfoForTargetService() {
        ComponentName targetComponentName = getShortcutTargetComponentName();
        if (targetComponentName == null) {
            return null;
        }
        AccessibilityManager accessibilityManager = this.mFrameworkObjectProvider.getAccessibilityManagerInstance(this.mContext);
        return accessibilityManager.getInstalledServiceInfoWithComponentName(targetComponentName);
    }

    private String getShortcutFeatureDescription(boolean includeSummary) {
        ComponentName targetComponentName = getShortcutTargetComponentName();
        if (targetComponentName == null) {
            return null;
        }
        FrameworkFeatureInfo frameworkFeatureInfo = getFrameworkShortcutFeaturesMap().get(targetComponentName);
        if (frameworkFeatureInfo != null) {
            return frameworkFeatureInfo.getLabel(this.mContext);
        }
        AccessibilityServiceInfo serviceInfo = this.mFrameworkObjectProvider.getAccessibilityManagerInstance(this.mContext).getInstalledServiceInfoWithComponentName(targetComponentName);
        if (serviceInfo == null) {
            return null;
        }
        PackageManager pm = this.mContext.getPackageManager();
        String label = serviceInfo.getResolveInfo().loadLabel(pm).toString();
        CharSequence summary = serviceInfo.loadSummary(pm);
        if (!includeSummary || TextUtils.isEmpty(summary)) {
            return label;
        }
        return String.format("%s\n%s", label, summary);
    }

    private boolean isServiceEnabled(AccessibilityServiceInfo serviceInfo) {
        AccessibilityManager accessibilityManager = this.mFrameworkObjectProvider.getAccessibilityManagerInstance(this.mContext);
        return accessibilityManager.getEnabledAccessibilityServiceList(-1).contains(serviceInfo);
    }

    public boolean hasFeatureLeanback() {
        return this.mContext.getPackageManager().hasSystemFeature("android.software.leanback");
    }

    public void playNotificationTone() {
        int audioAttributesUsage;
        if (hasFeatureLeanback()) {
            audioAttributesUsage = 11;
        } else {
            audioAttributesUsage = 10;
        }
        Uri ringtoneUri = Uri.parse("file://" + this.mContext.getString(17039907));
        Ringtone tone = this.mFrameworkObjectProvider.getRingtone(this.mContext, ringtoneUri);
        if (tone == null) {
            tone = this.mFrameworkObjectProvider.getRingtone(this.mContext, Settings.System.DEFAULT_NOTIFICATION_URI);
        }
        if (tone != null) {
            tone.setAudioAttributes(new AudioAttributes.Builder().setUsage(audioAttributesUsage).build());
            tone.play();
        }
    }

    private boolean performTtsPrompt(AlertDialog alertDialog) {
        String serviceName = getShortcutFeatureDescription(false);
        AccessibilityServiceInfo serviceInfo = getInfoForTargetService();
        if (TextUtils.isEmpty(serviceName) || serviceInfo == null || (serviceInfo.flags & 1024) == 0) {
            return false;
        }
        final TtsPrompt tts = new TtsPrompt(serviceName);
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.internal.accessibility.AccessibilityShortcutController$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccessibilityShortcutController.TtsPrompt.this.dismiss();
            }
        });
        return true;
    }

    private boolean hasShortcutTarget() {
        String shortcutTargets = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "accessibility_shortcut_target_service", this.mUserId);
        if (shortcutTargets == null) {
            shortcutTargets = this.mContext.getString(17039908);
        }
        return !TextUtils.isEmpty(shortcutTargets);
    }

    private ComponentName getShortcutTargetComponentName() {
        List<String> shortcutTargets = this.mFrameworkObjectProvider.getAccessibilityManagerInstance(this.mContext).getAccessibilityShortcutTargets(1);
        if (shortcutTargets.size() != 1) {
            return null;
        }
        return ComponentName.unflattenFromString(shortcutTargets.get(0));
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class TtsPrompt implements TextToSpeech.OnInitListener {
        private static final int RETRY_MILLIS = 1000;
        private boolean mDismiss;
        private final CharSequence mText;
        private TextToSpeech mTts;
        private int mRetryCount = 3;
        private boolean mLanguageReady = false;

        TtsPrompt(String serviceName) {
            this.mText = AccessibilityShortcutController.this.mContext.getString(17039605, serviceName);
            this.mTts = AccessibilityShortcutController.this.mFrameworkObjectProvider.getTextToSpeech(AccessibilityShortcutController.this.mContext, this);
        }

        public void dismiss() {
            this.mDismiss = true;
            AccessibilityShortcutController.this.mHandler.sendMessage(PooledLambda.obtainMessage(new Consumer() { // from class: com.android.internal.accessibility.AccessibilityShortcutController$TtsPrompt$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((TextToSpeech) obj).shutdown();
                }
            }, this.mTts));
        }

        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public void onInit(int status) {
            if (status != 0) {
                Slog.d(AccessibilityShortcutController.TAG, "Tts init fail, status=" + Integer.toString(status));
                AccessibilityShortcutController.this.playNotificationTone();
            } else {
                AccessibilityShortcutController.this.mHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityShortcutController$TtsPrompt$$ExternalSyntheticLambda1(), this));
            }
        }

        public void play() {
            if (this.mDismiss) {
                return;
            }
            int status = this.mTts.speak(this.mText, 0, null, null);
            if (status != 0) {
                Slog.d(AccessibilityShortcutController.TAG, "Tts play fail");
                AccessibilityShortcutController.this.playNotificationTone();
            }
        }

        public void waitForTtsReady() {
            if (this.mDismiss) {
                return;
            }
            boolean voiceDataInstalled = false;
            if (!this.mLanguageReady) {
                int status = this.mTts.setLanguage(Locale.getDefault());
                this.mLanguageReady = (status == -1 || status == -2) ? false : true;
            }
            if (this.mLanguageReady) {
                Voice voice = this.mTts.getVoice();
                if (voice != null && voice.getFeatures() != null && !voice.getFeatures().contains("notInstalled")) {
                    voiceDataInstalled = true;
                }
                if (voiceDataInstalled) {
                    AccessibilityShortcutController.this.mHandler.sendMessage(PooledLambda.obtainMessage(new Consumer() { // from class: com.android.internal.accessibility.AccessibilityShortcutController$TtsPrompt$$ExternalSyntheticLambda2
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((AccessibilityShortcutController.TtsPrompt) obj).play();
                        }
                    }, this));
                    return;
                }
            }
            int i10 = this.mRetryCount;
            if (i10 == 0) {
                Slog.d(AccessibilityShortcutController.TAG, "Tts not ready to speak.");
                AccessibilityShortcutController.this.playNotificationTone();
            } else {
                this.mRetryCount = i10 - 1;
                AccessibilityShortcutController.this.mHandler.sendMessageDelayed(PooledLambda.obtainMessage(new AccessibilityShortcutController$TtsPrompt$$ExternalSyntheticLambda1(), this), 1000L);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class UserSetupCompleteObserver extends ContentObserver {
        private boolean mIsRegistered;
        private int mUserId;

        UserSetupCompleteObserver(Handler handler, int userId) {
            super(handler);
            this.mIsRegistered = false;
            this.mUserId = userId;
            if (!isUserSetupComplete()) {
                registerObserver();
            }
        }

        private boolean isUserSetupComplete() {
            return Settings.Secure.getIntForUser(AccessibilityShortcutController.this.mContext.getContentResolver(), "user_setup_complete", 0, this.mUserId) == 1;
        }

        private void registerObserver() {
            if (this.mIsRegistered) {
                return;
            }
            AccessibilityShortcutController.this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, this, this.mUserId);
            this.mIsRegistered = true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            if (isUserSetupComplete()) {
                unregisterObserver();
                setEmptyShortcutTargetIfNeeded();
            }
        }

        private void unregisterObserver() {
            if (!this.mIsRegistered) {
                return;
            }
            AccessibilityShortcutController.this.mContext.getContentResolver().unregisterContentObserver(this);
            this.mIsRegistered = false;
        }

        private void setEmptyShortcutTargetIfNeeded() {
            if (AccessibilityShortcutController.this.hasFeatureLeanback()) {
                return;
            }
            ContentResolver contentResolver = AccessibilityShortcutController.this.mContext.getContentResolver();
            String shortcutTargets = Settings.Secure.getStringForUser(contentResolver, "accessibility_shortcut_target_service", this.mUserId);
            if (shortcutTargets != null) {
                return;
            }
            String defaultShortcutTarget = AccessibilityShortcutController.this.mContext.getString(17039908);
            List<AccessibilityServiceInfo> enabledServices = AccessibilityShortcutController.this.mFrameworkObjectProvider.getAccessibilityManagerInstance(AccessibilityShortcutController.this.mContext).getEnabledAccessibilityServiceList(-1);
            for (int i10 = enabledServices.size() - 1; i10 >= 0; i10--) {
                if (TextUtils.equals(defaultShortcutTarget, enabledServices.get(i10).getId())) {
                    return;
                }
            }
            Settings.Secure.putStringForUser(contentResolver, "accessibility_shortcut_target_service", "", this.mUserId);
        }

        void onUserSwitched(int userId) {
            if (this.mUserId == userId) {
                return;
            }
            unregisterObserver();
            this.mUserId = userId;
            if (!isUserSetupComplete()) {
                registerObserver();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class FrameworkFeatureInfo {
        private final int mLabelStringResourceId;
        private final String mSettingKey;
        private final String mSettingOffValue;
        private final String mSettingOnValue;

        FrameworkFeatureInfo(String settingKey, String settingOnValue, String settingOffValue, int labelStringResourceId) {
            this.mSettingKey = settingKey;
            this.mSettingOnValue = settingOnValue;
            this.mSettingOffValue = settingOffValue;
            this.mLabelStringResourceId = labelStringResourceId;
        }

        public String getSettingKey() {
            return this.mSettingKey;
        }

        public String getSettingOnValue() {
            return this.mSettingOnValue;
        }

        public String getSettingOffValue() {
            return this.mSettingOffValue;
        }

        public String getLabel(Context context) {
            return context.getString(this.mLabelStringResourceId);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ToggleableFrameworkFeatureInfo extends FrameworkFeatureInfo {
        ToggleableFrameworkFeatureInfo(String settingKey, String settingOnValue, String settingOffValue, int labelStringResourceId) {
            super(settingKey, settingOnValue, settingOffValue, labelStringResourceId);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LaunchableFrameworkFeatureInfo extends FrameworkFeatureInfo {
        LaunchableFrameworkFeatureInfo(int labelStringResourceId) {
            super(null, null, null, labelStringResourceId);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class FrameworkObjectProvider {
        public AccessibilityManager getAccessibilityManagerInstance(Context context) {
            return AccessibilityManager.getInstance(context);
        }

        public AlertDialog.Builder getAlertDialogBuilder(Context context) {
            boolean inNightMode = (context.getResources().getConfiguration().uiMode & 48) == 32;
            if (inNightMode) {
            }
            IOplusAlertDialogBuilderExt mOplusAlertDialogBuilderExt = (IOplusAlertDialogBuilderExt) ExtLoader.type(IOplusAlertDialogBuilderExt.class).base(this).create();
            return mOplusAlertDialogBuilderExt.getCenterBuilder(context);
        }

        public Toast makeToastFromText(Context context, CharSequence charSequence, int duration) {
            return Toast.makeText(context, charSequence, duration);
        }

        public Context getSystemUiContext() {
            return ActivityThread.currentActivityThread().getSystemUiContext();
        }

        public TextToSpeech getTextToSpeech(Context ctx, TextToSpeech.OnInitListener listener) {
            return new TextToSpeech(ctx, listener);
        }

        public Ringtone getRingtone(Context ctx, Uri uri) {
            return RingtoneManager.getRingtone(ctx, uri);
        }
    }
}
