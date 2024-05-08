package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.os.PowerProfile;
import com.huawei.flexiblelayout.n;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AntiCheatUtil implements NotConfused {
    public static volatile AntiCheatUtil instance;

    private boolean canDrawOverlays(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23) {
            return true;
        }
        if (i10 >= 27) {
            return Settings.canDrawOverlays(context);
        }
        if (Settings.canDrawOverlays(context)) {
            return true;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            View view = new View(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, i10 >= 26 ? 2038 : 2003, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean checkFloatPermission(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            try {
                Class<?> cls = Class.forName("android.content.Context");
                Field declaredField = cls.getDeclaredField("APP_OPS_SERVICE");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(cls);
                if (!(obj instanceof String)) {
                    return false;
                }
                Object invoke = cls.getMethod("getSystemService", String.class).invoke(context, (String) obj);
                Class<?> cls2 = Class.forName("android.app.AppOpsManager");
                Field declaredField2 = cls2.getDeclaredField("MODE_ALLOWED");
                declaredField2.setAccessible(true);
                Class<Integer> cls3 = Integer.TYPE;
                return ((Integer) cls2.getMethod("checkOp", cls3, cls3, String.class).invoke(invoke, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == declaredField2.getInt(cls2);
            } catch (Exception unused) {
                return false;
            }
        }
        return Settings.canDrawOverlays(context);
    }

    public static AntiCheatUtil getInstance() {
        if (instance == null) {
            synchronized (AntiCheatUtil.class) {
                if (instance == null) {
                    instance = new AntiCheatUtil();
                }
            }
        }
        return instance;
    }

    public boolean accessibilityEnabled(Context context) {
        AccessibilityManager accessibilityManager;
        if (context == null || (accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility")) == null) {
            return false;
        }
        return accessibilityManager.isEnabled();
    }

    public float getBatteryPercentage(Context context) {
        Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return (registerReceiver.getIntExtra(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, -1) / registerReceiver.getIntExtra(n.f28264e, -1)) * 100.0f;
    }

    public int getCurrentVolume(Context context) {
        AudioManager audioManager;
        if (context == null || (audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO)) == null) {
            return -1;
        }
        return audioManager.getStreamVolume(3);
    }

    public boolean isCharging(Context context) {
        Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public boolean isSystemAlertPermissions(Context context) {
        if (context == null) {
            return false;
        }
        return checkFloatPermission(context);
    }
}
