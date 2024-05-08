package com.android.internal.accessibility.util;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.text.ParcelableSpan;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.ArraySet;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import libcore.util.EmptyArray;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class AccessibilityUtils {
    public static final ComponentName ACCESSIBILITY_MENU_IN_SYSTEM = new ComponentName("com.android.systemui.accessibility.accessibilitymenu", "com.android.systemui.accessibility.accessibilitymenu.AccessibilityMenuService");
    public static final String MENU_SERVICE_RELATIVE_CLASS_NAME = ".AccessibilityMenuService";
    public static final int NONE = 0;
    public static final int PARCELABLE_SPAN = 2;
    public static final int TEXT = 1;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface A11yTextChangeType {
    }

    private AccessibilityUtils() {
    }

    public static Set<ComponentName> getEnabledServicesFromSettings(Context context, int userId) {
        String enabledServicesSetting = Settings.Secure.getStringForUser(context.getContentResolver(), "enabled_accessibility_services", userId);
        if (TextUtils.isEmpty(enabledServicesSetting)) {
            return Collections.emptySet();
        }
        Set<ComponentName> enabledServices = new HashSet<>();
        TextUtils.StringSplitter<String> colonSplitter = new TextUtils.SimpleStringSplitter(ShortcutConstants.SERVICES_SEPARATOR);
        colonSplitter.setString(enabledServicesSetting);
        for (String componentNameString : colonSplitter) {
            ComponentName enabledService = ComponentName.unflattenFromString(componentNameString);
            if (enabledService != null) {
                enabledServices.add(enabledService);
            }
        }
        return enabledServices;
    }

    public static void setAccessibilityServiceState(Context context, ComponentName componentName, boolean enabled) {
        setAccessibilityServiceState(context, componentName, enabled, UserHandle.myUserId());
    }

    public static void setAccessibilityServiceState(Context context, ComponentName componentName, boolean enabled, int userId) {
        Set<ComponentName> enabledServices = getEnabledServicesFromSettings(context, userId);
        if (enabledServices.isEmpty()) {
            enabledServices = new ArraySet(1);
        }
        if (enabled) {
            enabledServices.add(componentName);
        } else {
            enabledServices.remove(componentName);
        }
        StringBuilder enabledServicesBuilder = new StringBuilder();
        for (ComponentName enabledService : enabledServices) {
            enabledServicesBuilder.append(enabledService.flattenToString());
            enabledServicesBuilder.append(ShortcutConstants.SERVICES_SEPARATOR);
        }
        int enabledServicesBuilderLength = enabledServicesBuilder.length();
        if (enabledServicesBuilderLength > 0) {
            enabledServicesBuilder.deleteCharAt(enabledServicesBuilderLength - 1);
        }
        Settings.Secure.putStringForUser(context.getContentResolver(), "enabled_accessibility_services", enabledServicesBuilder.toString(), userId);
    }

    public static int getAccessibilityServiceFragmentType(AccessibilityServiceInfo accessibilityServiceInfo) {
        int targetSdk = accessibilityServiceInfo.getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion;
        boolean requestA11yButton = (accessibilityServiceInfo.flags & 256) != 0;
        if (targetSdk <= 29) {
            return 0;
        }
        return requestA11yButton ? 1 : 2;
    }

    public static boolean isAccessibilityServiceEnabled(Context context, String componentId) {
        AccessibilityManager am = (AccessibilityManager) context.getSystemService("accessibility");
        List<AccessibilityServiceInfo> enabledServices = am.getEnabledAccessibilityServiceList(-1);
        for (AccessibilityServiceInfo info : enabledServices) {
            String id2 = info.getComponentName().flattenToString();
            if (id2.equals(componentId)) {
                return true;
            }
        }
        return false;
    }

    public static boolean interceptHeadsetHookForActiveCall(Context context) {
        TelecomManager telecomManager = (TelecomManager) context.getSystemService(TelecomManager.class);
        int callState = telecomManager != null ? telecomManager.getCallState() : 0;
        if (callState == 1) {
            telecomManager.acceptRingingCall();
            return true;
        }
        if (callState != 2) {
            return false;
        }
        telecomManager.endCall();
        return true;
    }

    public static boolean isUserSetupCompleted(Context context) {
        return Settings.Secure.getIntForUser(context.getContentResolver(), "user_setup_complete", 0, -2) != 0;
    }

    public static int textOrSpanChanged(CharSequence before, CharSequence after) {
        if (!TextUtils.equals(before, after)) {
            return 1;
        }
        if (((before instanceof Spanned) || (after instanceof Spanned)) && !parcelableSpansEquals(before, after)) {
            return 2;
        }
        return 0;
    }

    private static boolean parcelableSpansEquals(CharSequence before, CharSequence after) {
        Object[] spansA = EmptyArray.OBJECT;
        Object[] spansB = EmptyArray.OBJECT;
        Spanned a10 = null;
        Spanned b4 = null;
        if (before instanceof Spanned) {
            a10 = (Spanned) before;
            spansA = a10.getSpans(0, a10.length(), ParcelableSpan.class);
        }
        if (after instanceof Spanned) {
            b4 = (Spanned) after;
            spansB = b4.getSpans(0, b4.length(), ParcelableSpan.class);
        }
        if (spansA.length != spansB.length) {
            return false;
        }
        for (int i10 = 0; i10 < spansA.length; i10++) {
            Object thisSpan = spansA[i10];
            Object otherSpan = spansB[i10];
            if (thisSpan.getClass() != otherSpan.getClass() || a10.getSpanStart(thisSpan) != b4.getSpanStart(otherSpan) || a10.getSpanEnd(thisSpan) != b4.getSpanEnd(otherSpan) || a10.getSpanFlags(thisSpan) != b4.getSpanFlags(otherSpan)) {
                return false;
            }
        }
        return true;
    }

    public static ComponentName getAccessibilityMenuComponentToMigrate(PackageManager packageManager, int userId) {
        Set<ComponentName> menuComponentNames = findA11yMenuComponentNames(packageManager, userId);
        Optional<ComponentName> menuOutsideSystem = menuComponentNames.stream().filter(new Predicate() { // from class: com.android.internal.accessibility.util.AccessibilityUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AccessibilityUtils.lambda$getAccessibilityMenuComponentToMigrate$0((ComponentName) obj);
            }
        }).findFirst();
        boolean shouldMigrateToMenuInSystem = menuComponentNames.size() == 2 && menuComponentNames.contains(ACCESSIBILITY_MENU_IN_SYSTEM) && menuOutsideSystem.isPresent();
        if (shouldMigrateToMenuInSystem) {
            return menuOutsideSystem.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getAccessibilityMenuComponentToMigrate$0(ComponentName name) {
        return !name.equals(ACCESSIBILITY_MENU_IN_SYSTEM);
    }

    private static Set<ComponentName> findA11yMenuComponentNames(PackageManager packageManager, int userId) {
        Set<ComponentName> result = new ArraySet<>();
        PackageManager.ResolveInfoFlags flags = PackageManager.ResolveInfoFlags.of(786944L);
        for (ResolveInfo resolveInfo : packageManager.queryIntentServicesAsUser(new Intent("android.accessibilityservice.AccessibilityService"), flags, userId)) {
            ComponentName componentName = resolveInfo.serviceInfo.getComponentName();
            if (componentName.getClassName().endsWith(MENU_SERVICE_RELATIVE_CLASS_NAME)) {
                result.add(componentName);
            }
        }
        return result;
    }
}
