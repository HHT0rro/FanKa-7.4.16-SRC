package com.android.internal.policy;

import android.app.KeyguardManager;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.session.MediaSessionManager;
import android.net.Uri;
import android.os.UserHandle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.FallbackEventHandler;
import android.view.KeyEvent;
import android.view.View;
import com.android.internal.os.PowerProfile;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PhoneFallbackEventHandler implements FallbackEventHandler {
    private static final boolean DEBUG = false;
    private static String TAG = "PhoneFallbackEventHandler";
    AudioManager mAudioManager;
    Context mContext;
    KeyguardManager mKeyguardManager;
    MediaSessionManager mMediaSessionManager;
    private IPhoneFallbackEventHandlerExt mPFEHExt = (IPhoneFallbackEventHandlerExt) ExtLoader.type(IPhoneFallbackEventHandlerExt.class).create();
    SearchManager mSearchManager;
    TelephonyManager mTelephonyManager;
    View mView;

    public PhoneFallbackEventHandler(Context context) {
        this.mContext = context;
    }

    @Override // android.view.FallbackEventHandler
    public void setView(View v2) {
        this.mView = v2;
    }

    @Override // android.view.FallbackEventHandler
    public void preDispatchKeyEvent(KeyEvent event) {
        getAudioManager().preDispatchKeyEvent(event, Integer.MIN_VALUE);
    }

    @Override // android.view.FallbackEventHandler
    public boolean dispatchKeyEvent(KeyEvent event) {
        this.mPFEHExt.inputLog(TAG, " dispatchKeyEvent  " + ((Object) event));
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        if (action == 0) {
            return onKeyDown(keyCode, event);
        }
        return onKeyUp(keyCode, event);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    boolean onKeyDown(int keyCode, KeyEvent event) {
        KeyEvent.DispatcherState dispatcher = this.mView.getKeyDispatcherState();
        switch (keyCode) {
            case 5:
                if (!isNotInstantAppAndKeyguardRestricted(dispatcher)) {
                    if (event.getRepeatCount() == 0) {
                        dispatcher.startTracking(event, this);
                    } else if (event.isLongPress() && dispatcher.isTracking(event)) {
                        dispatcher.performedLongPress(event);
                        if (isUserSetupComplete()) {
                            this.mView.performHapticFeedback(0);
                            Intent intent = new Intent("android.intent.action.VOICE_COMMAND");
                            intent.setFlags(268435456);
                            try {
                                this.mContext.startActivity(intent);
                            } catch (ActivityNotFoundException e2) {
                                startCallActivity();
                            }
                        } else {
                            Log.i(TAG, "Not starting call activity because user setup is in progress.");
                        }
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
            case 164:
                handleVolumeKeyEvent(event);
                return true;
            case 27:
                if (!isNotInstantAppAndKeyguardRestricted(dispatcher)) {
                    if (event.getRepeatCount() == 0) {
                        dispatcher.startTracking(event, this);
                    } else if (event.isLongPress() && dispatcher.isTracking(event)) {
                        dispatcher.performedLongPress(event);
                        if (isUserSetupComplete()) {
                            this.mView.performHapticFeedback(0);
                            Intent intent2 = new Intent("android.intent.action.CAMERA_BUTTON", (Uri) null);
                            intent2.addFlags(268435456);
                            intent2.putExtra("android.intent.extra.KEY_EVENT", event);
                            this.mContext.sendOrderedBroadcastAsUser(intent2, UserHandle.CURRENT_OR_SELF, null, null, null, 0, null, null);
                        } else {
                            Log.i(TAG, "Not dispatching CAMERA long press because user setup is in progress.");
                        }
                    }
                    return true;
                }
                return false;
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 126:
            case 127:
            case 130:
            case 222:
                handleMediaKeyEvent(event);
                return true;
            case 84:
                if (!isNotInstantAppAndKeyguardRestricted(dispatcher)) {
                    if (event.getRepeatCount() == 0) {
                        dispatcher.startTracking(event, this);
                    } else if (event.isLongPress() && dispatcher.isTracking(event)) {
                        Configuration config = this.mContext.getResources().getConfiguration();
                        if (config.keyboard == 1 || config.hardKeyboardHidden == 2) {
                            if (isUserSetupComplete()) {
                                Intent intent3 = new Intent("android.intent.action.SEARCH_LONG_PRESS");
                                intent3.setFlags(268435456);
                                try {
                                    this.mView.performHapticFeedback(0);
                                    getSearchManager().stopSearch();
                                    this.mContext.startActivity(intent3);
                                    dispatcher.performedLongPress(event);
                                    return true;
                                } catch (ActivityNotFoundException e10) {
                                }
                            } else {
                                Log.i(TAG, "Not dispatching SEARCH long press because user setup is in progress.");
                            }
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }

    private boolean isNotInstantAppAndKeyguardRestricted(KeyEvent.DispatcherState dispatcher) {
        return !this.mContext.getPackageManager().isInstantApp() && (getKeyguardManager().inKeyguardRestrictedInputMode() || dispatcher == null);
    }

    boolean onKeyUp(int keyCode, KeyEvent event) {
        KeyEvent.DispatcherState dispatcher = this.mView.getKeyDispatcherState();
        if (dispatcher != null) {
            dispatcher.handleUpEvent(event);
        }
        switch (keyCode) {
            case 5:
                if (!isNotInstantAppAndKeyguardRestricted(dispatcher)) {
                    if (event.isTracking() && !event.isCanceled()) {
                        if (isUserSetupComplete()) {
                            startCallActivity();
                        } else {
                            Log.i(TAG, "Not starting call activity because user setup is in progress.");
                        }
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
            case 164:
                if (!event.isCanceled()) {
                    handleVolumeKeyEvent(event);
                }
                return true;
            case 27:
                if (!isNotInstantAppAndKeyguardRestricted(dispatcher)) {
                    if (event.isTracking()) {
                        event.isCanceled();
                    }
                    return true;
                }
                return false;
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 126:
            case 127:
            case 130:
            case 222:
                handleMediaKeyEvent(event);
                return true;
            default:
                return false;
        }
    }

    void startCallActivity() {
        Intent intent = new Intent("android.intent.action.CALL_BUTTON");
        intent.setFlags(268435456);
        try {
            this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            Log.w(TAG, "No activity found for android.intent.action.CALL_BUTTON.");
        }
    }

    SearchManager getSearchManager() {
        if (this.mSearchManager == null) {
            this.mSearchManager = (SearchManager) this.mContext.getSystemService("search");
        }
        return this.mSearchManager;
    }

    TelephonyManager getTelephonyManager() {
        if (this.mTelephonyManager == null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        }
        return this.mTelephonyManager;
    }

    KeyguardManager getKeyguardManager() {
        if (this.mKeyguardManager == null) {
            this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        }
        return this.mKeyguardManager;
    }

    AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService(PowerProfile.POWER_AUDIO);
        }
        return this.mAudioManager;
    }

    MediaSessionManager getMediaSessionManager() {
        if (this.mMediaSessionManager == null) {
            this.mMediaSessionManager = (MediaSessionManager) this.mContext.getSystemService("media_session");
        }
        return this.mMediaSessionManager;
    }

    private void handleVolumeKeyEvent(KeyEvent keyEvent) {
        this.mPFEHExt.inputLog(TAG, " MediaSession handleVolumeKeyEvent in PhoneFallbackEventHandler : " + ((Object) keyEvent));
        getMediaSessionManager().dispatchVolumeKeyEventAsSystemService(keyEvent, Integer.MIN_VALUE);
    }

    private void handleMediaKeyEvent(KeyEvent keyEvent) {
        this.mPFEHExt.inputLog(TAG, " MediaSession handleMediaKeyEvent in PhoneFallbackEventHandler : " + ((Object) keyEvent));
        getMediaSessionManager().dispatchMediaKeyEventAsSystemService(keyEvent);
    }

    private boolean isUserSetupComplete() {
        return Settings.Secure.getInt(this.mContext.getContentResolver(), "user_setup_complete", 0) != 0;
    }
}
