package com.android.internal.accessibility.dialog;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import com.android.internal.accessibility.util.AccessibilityUtils;
import com.android.internal.accessibility.util.ShortcutUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InvisibleToggleAccessibilityServiceTarget extends AccessibilityServiceTarget {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InvisibleToggleAccessibilityServiceTarget(Context context, int shortcutType, AccessibilityServiceInfo serviceInfo) {
        super(context, shortcutType, 1, serviceInfo);
    }

    @Override // com.android.internal.accessibility.dialog.AccessibilityTarget, com.android.internal.accessibility.dialog.OnTargetCheckedChangeListener
    public void onCheckedChanged(boolean isChecked) {
        ComponentName componentName = ComponentName.unflattenFromString(getId());
        if (!isComponentIdExistingInOtherShortcut()) {
            AccessibilityUtils.setAccessibilityServiceState(getContext(), componentName, isChecked);
        }
        super.onCheckedChanged(isChecked);
    }

    private boolean isComponentIdExistingInOtherShortcut() {
        switch (getShortcutType()) {
            case 0:
                return ShortcutUtils.isComponentIdExistingInSettings(getContext(), 2, getId());
            case 1:
                return ShortcutUtils.isComponentIdExistingInSettings(getContext(), 1, getId());
            default:
                throw new IllegalStateException("Unexpected shortcut type");
        }
    }
}
