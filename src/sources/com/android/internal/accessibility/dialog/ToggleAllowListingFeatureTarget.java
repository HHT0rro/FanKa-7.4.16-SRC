package com.android.internal.accessibility.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import com.android.internal.accessibility.dialog.TargetAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ToggleAllowListingFeatureTarget extends AccessibilityTarget {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ToggleAllowListingFeatureTarget(Context context, int shortcutType, boolean isShortcutSwitched, String id2, int uid, CharSequence label, Drawable icon, String key) {
        super(context, shortcutType, 2, isShortcutSwitched, id2, uid, label, icon, key);
        int statusResId;
        if (isFeatureEnabled()) {
            statusResId = 17039597;
        } else {
            statusResId = 17039596;
        }
        setStateDescription(getContext().getString(statusResId));
    }

    @Override // com.android.internal.accessibility.dialog.AccessibilityTarget, com.android.internal.accessibility.dialog.TargetOperations
    public void updateActionItem(TargetAdapter.ViewHolder holder, int shortcutMenuMode) {
        super.updateActionItem(holder, shortcutMenuMode);
        boolean isEditMenuMode = shortcutMenuMode == 1;
        holder.mStatusView.setVisibility(isEditMenuMode ? 8 : 0);
        holder.mStatusView.setText(getStateDescription());
    }

    private boolean isFeatureEnabled() {
        return Settings.Secure.getInt(getContext().getContentResolver(), getKey(), 0) == 1;
    }
}
