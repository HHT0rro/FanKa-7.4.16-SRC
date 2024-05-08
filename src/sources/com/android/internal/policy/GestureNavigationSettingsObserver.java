package com.android.internal.policy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.android.internal.config.sysui.SystemUiDeviceConfigFlags;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GestureNavigationSettingsObserver extends ContentObserver {
    private Context mContext;
    private Handler mMainHandler;
    private Runnable mOnChangeRunnable;
    private final DeviceConfig.OnPropertiesChangedListener mOnPropertiesChangedListener;

    public GestureNavigationSettingsObserver(Handler handler, Context context, Runnable onChangeRunnable) {
        super(handler);
        this.mOnPropertiesChangedListener = new DeviceConfig.OnPropertiesChangedListener() { // from class: com.android.internal.policy.GestureNavigationSettingsObserver.1
            public void onPropertiesChanged(DeviceConfig.Properties properties) {
                if ("systemui".equals(properties.getNamespace()) && GestureNavigationSettingsObserver.this.mOnChangeRunnable != null) {
                    GestureNavigationSettingsObserver.this.mOnChangeRunnable.run();
                }
            }
        };
        this.mMainHandler = handler;
        this.mContext = context;
        this.mOnChangeRunnable = onChangeRunnable;
    }

    public void register() {
        ContentResolver r10 = this.mContext.getContentResolver();
        r10.registerContentObserver(Settings.Secure.getUriFor("back_gesture_inset_scale_left"), false, this, -1);
        r10.registerContentObserver(Settings.Secure.getUriFor("back_gesture_inset_scale_right"), false, this, -1);
        r10.registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, this, -1);
        DeviceConfig.addOnPropertiesChangedListener("systemui", new Executor() { // from class: com.android.internal.policy.GestureNavigationSettingsObserver$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                GestureNavigationSettingsObserver.this.lambda$register$0(runnable);
            }
        }, this.mOnPropertiesChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$register$0(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    public void registerForCallingUser() {
        ContentResolver r10 = this.mContext.getContentResolver();
        r10.registerContentObserver(Settings.Secure.getUriFor("back_gesture_inset_scale_left"), false, this);
        r10.registerContentObserver(Settings.Secure.getUriFor("back_gesture_inset_scale_right"), false, this);
        r10.registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, this);
        DeviceConfig.addOnPropertiesChangedListener("systemui", new Executor() { // from class: com.android.internal.policy.GestureNavigationSettingsObserver$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                GestureNavigationSettingsObserver.this.lambda$registerForCallingUser$1(runnable);
            }
        }, this.mOnPropertiesChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerForCallingUser$1(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    public void unregister() {
        this.mContext.getContentResolver().unregisterContentObserver(this);
        DeviceConfig.removeOnPropertiesChangedListener(this.mOnPropertiesChangedListener);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        Runnable runnable = this.mOnChangeRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    public int getLeftSensitivity(Resources userRes) {
        float scale = Settings.Secure.getFloatForUser(this.mContext.getContentResolver(), "back_gesture_inset_scale_left", 1.0f, -2);
        return (int) (getUnscaledInset(userRes) * scale);
    }

    public int getLeftSensitivityForCallingUser(Resources userRes) {
        float scale = Settings.Secure.getFloat(this.mContext.getContentResolver(), "back_gesture_inset_scale_left", 1.0f);
        return (int) (getUnscaledInset(userRes) * scale);
    }

    public int getRightSensitivity(Resources userRes) {
        float scale = Settings.Secure.getFloatForUser(this.mContext.getContentResolver(), "back_gesture_inset_scale_right", 1.0f, -2);
        return (int) (getUnscaledInset(userRes) * scale);
    }

    public int getRightSensitivityForCallingUser(Resources userRes) {
        float scale = Settings.Secure.getFloat(this.mContext.getContentResolver(), "back_gesture_inset_scale_right", 1.0f);
        return (int) (getUnscaledInset(userRes) * scale);
    }

    public boolean areNavigationButtonForcedVisible() {
        return Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "user_setup_complete", 0, -2) == 0;
    }

    private float getUnscaledInset(Resources userRes) {
        float backGestureInset;
        DisplayMetrics dm = userRes.getDisplayMetrics();
        float defaultInset = userRes.getDimension(17105070) / dm.density;
        if (defaultInset > 0.0f) {
            backGestureInset = DeviceConfig.getFloat("systemui", SystemUiDeviceConfigFlags.BACK_GESTURE_EDGE_WIDTH, defaultInset);
        } else {
            backGestureInset = defaultInset;
        }
        float inset = TypedValue.applyDimension(1, backGestureInset, dm);
        return inset;
    }
}
