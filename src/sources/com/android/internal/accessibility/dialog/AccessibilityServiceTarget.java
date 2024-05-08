package com.android.internal.accessibility.dialog;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import com.android.internal.accessibility.dialog.TargetAdapter;
import com.android.internal.accessibility.util.ShortcutUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AccessibilityServiceTarget extends AccessibilityTarget {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessibilityServiceTarget(Context context, int shortcutType, int fragmentType, AccessibilityServiceInfo serviceInfo) {
        super(context, shortcutType, fragmentType, ShortcutUtils.isShortcutContained(context, shortcutType, serviceInfo.getComponentName().flattenToString()), serviceInfo.getComponentName().flattenToString(), serviceInfo.getResolveInfo().serviceInfo.applicationInfo.uid, serviceInfo.getResolveInfo().loadLabel(context.getPackageManager()), serviceInfo.getResolveInfo().loadIcon(context.getPackageManager()), ShortcutUtils.convertToKey(ShortcutUtils.convertToUserType(shortcutType)));
    }

    @Override // com.android.internal.accessibility.dialog.AccessibilityTarget, com.android.internal.accessibility.dialog.TargetOperations
    public void updateActionItem(TargetAdapter.ViewHolder holder, int shortcutMenuMode) {
        super.updateActionItem(holder, shortcutMenuMode);
        boolean isAllowed = AccessibilityTargetHelper.isAccessibilityTargetAllowed(getContext(), getComponentName().getPackageName(), getUid());
        boolean enabled = false;
        boolean isEditMenuMode = shortcutMenuMode == 1;
        if (isAllowed || (isEditMenuMode && isShortcutEnabled())) {
            enabled = true;
        }
        holder.mCheckBoxView.setEnabled(enabled);
        holder.mIconView.setEnabled(enabled);
        holder.mLabelView.setEnabled(enabled);
        holder.mStatusView.setEnabled(enabled);
    }
}
