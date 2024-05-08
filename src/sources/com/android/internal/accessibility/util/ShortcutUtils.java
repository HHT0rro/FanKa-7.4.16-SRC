package com.android.internal.accessibility.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.util.List;
import java.util.StringJoiner;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ShortcutUtils {
    private static final TextUtils.SimpleStringSplitter sStringColonSplitter = new TextUtils.SimpleStringSplitter(ShortcutConstants.SERVICES_SEPARATOR);

    private ShortcutUtils() {
    }

    public static void optInValueToSettings(Context context, int shortcutType, String componentId) {
        StringJoiner joiner = new StringJoiner(String.valueOf(ShortcutConstants.SERVICES_SEPARATOR));
        String targetKey = convertToKey(shortcutType);
        String targetString = Settings.Secure.getString(context.getContentResolver(), targetKey);
        if (isComponentIdExistingInSettings(context, shortcutType, componentId)) {
            return;
        }
        if (!TextUtils.isEmpty(targetString)) {
            joiner.add(targetString);
        }
        joiner.add(componentId);
        Settings.Secure.putString(context.getContentResolver(), targetKey, joiner.toString());
    }

    public static void optOutValueFromSettings(Context context, int shortcutType, String componentId) {
        StringJoiner joiner = new StringJoiner(String.valueOf(ShortcutConstants.SERVICES_SEPARATOR));
        String targetsKey = convertToKey(shortcutType);
        String targetsValue = Settings.Secure.getString(context.getContentResolver(), targetsKey);
        if (TextUtils.isEmpty(targetsValue)) {
            return;
        }
        sStringColonSplitter.setString(targetsValue);
        while (true) {
            TextUtils.SimpleStringSplitter simpleStringSplitter = sStringColonSplitter;
            if (simpleStringSplitter.hasNext()) {
                String id2 = simpleStringSplitter.next();
                if (!TextUtils.isEmpty(id2) && !componentId.equals(id2)) {
                    joiner.add(id2);
                }
            } else {
                Settings.Secure.putString(context.getContentResolver(), targetsKey, joiner.toString());
                return;
            }
        }
    }

    public static boolean isComponentIdExistingInSettings(Context context, int shortcutType, String componentId) {
        String id2;
        String targetKey = convertToKey(shortcutType);
        String targetString = Settings.Secure.getString(context.getContentResolver(), targetKey);
        if (TextUtils.isEmpty(targetString)) {
            return false;
        }
        sStringColonSplitter.setString(targetString);
        do {
            TextUtils.SimpleStringSplitter simpleStringSplitter = sStringColonSplitter;
            if (!simpleStringSplitter.hasNext()) {
                return false;
            }
            id2 = simpleStringSplitter.next();
        } while (!componentId.equals(id2));
        return true;
    }

    public static boolean isShortcutContained(Context context, int shortcutType, String componentId) {
        AccessibilityManager am = (AccessibilityManager) context.getSystemService("accessibility");
        List<String> requiredTargets = am.getAccessibilityShortcutTargets(shortcutType);
        return requiredTargets.contains(componentId);
    }

    public static String convertToKey(int type) {
        switch (type) {
            case 1:
                return "accessibility_button_targets";
            case 2:
                return "accessibility_shortcut_target_service";
            case 3:
            default:
                throw new IllegalArgumentException("Unsupported user shortcut type: " + type);
            case 4:
                return "accessibility_display_magnification_enabled";
        }
    }

    public static int convertToUserType(int type) {
        switch (type) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                throw new IllegalArgumentException("Unsupported shortcut type:" + type);
        }
    }
}
