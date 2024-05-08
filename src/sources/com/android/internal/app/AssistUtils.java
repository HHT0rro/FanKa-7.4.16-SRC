package com.android.internal.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.app.IVoiceInteractionManagerService;
import java.util.ArrayList;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AssistUtils {
    public static final int INVOCATION_TYPE_ASSIST_BUTTON = 7;
    public static final int INVOCATION_TYPE_GESTURE = 1;
    public static final int INVOCATION_TYPE_HOME_BUTTON_LONG_PRESS = 5;
    public static final String INVOCATION_TYPE_KEY = "invocation_type";
    public static final int INVOCATION_TYPE_PHYSICAL_GESTURE = 2;
    public static final int INVOCATION_TYPE_POWER_BUTTON_LONG_PRESS = 6;
    public static final int INVOCATION_TYPE_QUICK_SEARCH_BAR = 4;
    public static final int INVOCATION_TYPE_UNKNOWN = 0;
    public static final int INVOCATION_TYPE_VOICE = 3;
    private static final String TAG = "AssistUtils";
    private final Context mContext;
    private final IVoiceInteractionManagerService mVoiceInteractionManagerService = IVoiceInteractionManagerService.Stub.asInterface(ServiceManager.getService("voiceinteraction"));

    public AssistUtils(Context context) {
        this.mContext = context;
    }

    @Deprecated
    public boolean showSessionForActiveService(Bundle args, int sourceFlags, IVoiceInteractionSessionShowCallback showCallback, IBinder activityToken) {
        return showSessionForActiveServiceInternal(args, sourceFlags, null, showCallback, activityToken);
    }

    public boolean showSessionForActiveService(Bundle args, int sourceFlags, String attributionTag, IVoiceInteractionSessionShowCallback showCallback, IBinder activityToken) {
        return showSessionForActiveServiceInternal(args, sourceFlags, attributionTag, showCallback, activityToken);
    }

    private boolean showSessionForActiveServiceInternal(Bundle args, int sourceFlags, String attributionTag, IVoiceInteractionSessionShowCallback showCallback, IBinder activityToken) {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                return iVoiceInteractionManagerService.showSessionForActiveService(args, sourceFlags, attributionTag, showCallback, activityToken);
            }
            return false;
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call showSessionForActiveService", e2);
            return false;
        }
    }

    public void getActiveServiceSupportedActions(Set<String> voiceActions, IVoiceActionCheckCallback callback) {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                iVoiceInteractionManagerService.getActiveServiceSupportedActions(new ArrayList(voiceActions), callback);
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call activeServiceSupportedActions", e2);
            try {
                callback.onComplete(null);
            } catch (RemoteException e10) {
            }
        }
    }

    public void launchVoiceAssistFromKeyguard() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                iVoiceInteractionManagerService.launchVoiceAssistFromKeyguard();
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call launchVoiceAssistFromKeyguard", e2);
        }
    }

    public boolean activeServiceSupportsAssistGesture() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                return iVoiceInteractionManagerService.activeServiceSupportsAssist();
            }
            return false;
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call activeServiceSupportsAssistGesture", e2);
            return false;
        }
    }

    public boolean activeServiceSupportsLaunchFromKeyguard() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                return iVoiceInteractionManagerService.activeServiceSupportsLaunchFromKeyguard();
            }
            return false;
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call activeServiceSupportsLaunchFromKeyguard", e2);
            return false;
        }
    }

    public ComponentName getActiveServiceComponentName() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService == null) {
                return null;
            }
            return iVoiceInteractionManagerService.getActiveServiceComponentName();
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call getActiveServiceComponentName", e2);
            return null;
        }
    }

    public boolean isSessionRunning() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                return iVoiceInteractionManagerService.isSessionRunning();
            }
            return false;
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call isSessionRunning", e2);
            return false;
        }
    }

    public void hideCurrentSession() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                iVoiceInteractionManagerService.hideCurrentSession();
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call hideCurrentSession", e2);
        }
    }

    public void onLockscreenShown() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                iVoiceInteractionManagerService.onLockscreenShown();
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call onLockscreenShown", e2);
        }
    }

    public void registerVoiceInteractionSessionListener(IVoiceInteractionSessionListener listener) {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                iVoiceInteractionManagerService.registerVoiceInteractionSessionListener(listener);
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to register voice interaction listener", e2);
        }
    }

    public void enableVisualQueryDetection(IVisualQueryDetectionAttentionListener listener) {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                iVoiceInteractionManagerService.enableVisualQueryDetection(listener);
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to register visual query detection attention listener", e2);
        }
    }

    public void disableVisualQueryDetection() {
        try {
            IVoiceInteractionManagerService iVoiceInteractionManagerService = this.mVoiceInteractionManagerService;
            if (iVoiceInteractionManagerService != null) {
                iVoiceInteractionManagerService.disableVisualQueryDetection();
            }
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to register visual query detection attention listener", e2);
        }
    }

    public ComponentName getAssistComponentForUser(int userId) {
        String setting = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "assistant", userId);
        if (setting != null) {
            return ComponentName.unflattenFromString(setting);
        }
        return null;
    }

    public static boolean isPreinstalledAssistant(Context context, ComponentName assistant) {
        if (assistant == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(assistant.getPackageName(), 0);
            return applicationInfo.isSystemApp() || applicationInfo.isUpdatedSystemApp();
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public static boolean isDisclosureEnabled(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "assist_disclosure_enabled", 0) != 0;
    }

    public static boolean shouldDisclose(Context context, ComponentName assistant) {
        return (allowDisablingAssistDisclosure(context) && !isDisclosureEnabled(context) && isPreinstalledAssistant(context, assistant)) ? false : true;
    }

    public static boolean allowDisablingAssistDisclosure(Context context) {
        return context.getResources().getBoolean(17891352);
    }
}
