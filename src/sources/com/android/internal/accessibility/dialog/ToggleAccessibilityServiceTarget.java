package com.android.internal.accessibility.dialog;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import com.android.internal.accessibility.dialog.TargetAdapter;
import com.android.internal.accessibility.util.AccessibilityUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ToggleAccessibilityServiceTarget extends AccessibilityServiceTarget {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    @interface StatusViewAlphaScale {
        public static final float DISABLED = 0.5f;
        public static final float OPAQUE = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToggleAccessibilityServiceTarget(Context context, int shortcutType, AccessibilityServiceInfo serviceInfo) {
        super(context, shortcutType, 2, serviceInfo);
        int statusResId;
        if (AccessibilityUtils.isAccessibilityServiceEnabled(getContext(), getId())) {
            statusResId = 17039597;
        } else {
            statusResId = 17039596;
        }
        setStateDescription(getContext().getString(statusResId));
    }

    @Override // com.android.internal.accessibility.dialog.AccessibilityServiceTarget, com.android.internal.accessibility.dialog.AccessibilityTarget, com.android.internal.accessibility.dialog.TargetOperations
    public void updateActionItem(TargetAdapter.ViewHolder holder, int shortcutMenuMode) {
        super.updateActionItem(holder, shortcutMenuMode);
        boolean isAllowed = AccessibilityTargetHelper.isAccessibilityTargetAllowed(getContext(), getComponentName().getPackageName(), getUid());
        boolean isEditMenuMode = shortcutMenuMode == 1;
        holder.mStatusView.setVisibility(isEditMenuMode ? 8 : 0);
        holder.mStatusView.setText(getStateDescription());
        holder.mStatusView.setAlpha(isAllowed ? 1.0f : 0.5f);
    }
}
