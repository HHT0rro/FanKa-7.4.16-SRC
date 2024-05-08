package com.android.internal.accessibility.dialog;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.accessibility.dialog.TargetAdapter;
import com.android.internal.accessibility.util.ShortcutUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class AccessibilityTarget implements TargetOperations, OnTargetSelectedListener, OnTargetCheckedChangeListener {
    private ComponentName mComponentName;
    private Context mContext;
    private int mFragmentType;
    private Drawable mIcon;
    private String mId;
    private String mKey;
    private CharSequence mLabel;
    private boolean mShortcutEnabled;
    private int mShortcutType;
    private CharSequence mStateDescription;
    private int mUid;

    public AccessibilityTarget(Context context, int shortcutType, int fragmentType, boolean isShortcutSwitched, String id2, int uid, CharSequence label, Drawable icon, String key) {
        this.mContext = context;
        this.mShortcutType = shortcutType;
        this.mFragmentType = fragmentType;
        this.mShortcutEnabled = isShortcutSwitched;
        this.mId = id2;
        this.mUid = uid;
        this.mComponentName = ComponentName.unflattenFromString(id2);
        this.mLabel = label;
        this.mIcon = icon;
        this.mKey = key;
    }

    @Override // com.android.internal.accessibility.dialog.TargetOperations
    public void updateActionItem(TargetAdapter.ViewHolder holder, int shortcutMenuMode) {
        holder.mCheckBoxView.setEnabled(true);
        holder.mIconView.setEnabled(true);
        holder.mLabelView.setEnabled(true);
        holder.mStatusView.setEnabled(true);
        boolean isEditMenuMode = shortcutMenuMode == 1;
        holder.mCheckBoxView.setChecked(isEditMenuMode && isShortcutEnabled());
        holder.mCheckBoxView.setVisibility(isEditMenuMode ? 0 : 8);
        holder.mIconView.setImageDrawable(getIcon());
        holder.mLabelView.setText(getLabel());
        holder.mStatusView.setVisibility(8);
    }

    @Override // com.android.internal.accessibility.dialog.OnTargetSelectedListener
    public void onSelected() {
        AccessibilityManager am = (AccessibilityManager) getContext().getSystemService(AccessibilityManager.class);
        switch (getShortcutType()) {
            case 0:
                am.notifyAccessibilityButtonClicked(getContext().getDisplayId(), getId());
                return;
            case 1:
                am.performAccessibilityShortcut(getId());
                return;
            default:
                throw new IllegalStateException("Unexpected shortcut type");
        }
    }

    @Override // com.android.internal.accessibility.dialog.OnTargetCheckedChangeListener
    public void onCheckedChanged(boolean isChecked) {
        setShortcutEnabled(isChecked);
        if (isChecked) {
            ShortcutUtils.optInValueToSettings(getContext(), ShortcutUtils.convertToUserType(getShortcutType()), getId());
        } else {
            ShortcutUtils.optOutValueFromSettings(getContext(), ShortcutUtils.convertToUserType(getShortcutType()), getId());
        }
    }

    public void setStateDescription(CharSequence stateDescription) {
        this.mStateDescription = stateDescription;
    }

    public CharSequence getStateDescription() {
        return this.mStateDescription;
    }

    public void setShortcutEnabled(boolean enabled) {
        this.mShortcutEnabled = enabled;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getShortcutType() {
        return this.mShortcutType;
    }

    public int getFragmentType() {
        return this.mFragmentType;
    }

    public boolean isShortcutEnabled() {
        return this.mShortcutEnabled;
    }

    public String getId() {
        return this.mId;
    }

    public int getUid() {
        return this.mUid;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }
}
