package com.android.internal.accessibility.dialog;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.widget.Toast;
import com.android.internal.accessibility.util.AccessibilityUtils;
import com.android.internal.accessibility.util.ShortcutUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class VolumeShortcutToggleAccessibilityServiceTarget extends AccessibilityServiceTarget {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VolumeShortcutToggleAccessibilityServiceTarget(Context context, int shortcutType, AccessibilityServiceInfo serviceInfo) {
        super(context, shortcutType, 0, serviceInfo);
    }

    @Override // com.android.internal.accessibility.dialog.AccessibilityTarget, com.android.internal.accessibility.dialog.OnTargetCheckedChangeListener
    public void onCheckedChanged(boolean isChecked) {
        switch (getShortcutType()) {
            case 0:
                onCheckedFromAccessibilityButton(isChecked);
                return;
            case 1:
                super.onCheckedChanged(isChecked);
                return;
            default:
                throw new IllegalStateException("Unexpected shortcut type");
        }
    }

    private void onCheckedFromAccessibilityButton(boolean isChecked) {
        setShortcutEnabled(isChecked);
        ComponentName componentName = ComponentName.unflattenFromString(getId());
        AccessibilityUtils.setAccessibilityServiceState(getContext(), componentName, isChecked);
        if (!isChecked) {
            ShortcutUtils.optOutValueFromSettings(getContext(), 2, getId());
            String warningText = getContext().getString(17039626, getLabel());
            Toast.makeText(getContext(), warningText, 0).show();
        }
    }
}
