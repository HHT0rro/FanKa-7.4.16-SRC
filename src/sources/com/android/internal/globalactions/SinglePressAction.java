package com.android.internal.globalactions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class SinglePressAction implements Action {
    private final Drawable mIcon;
    private final int mIconResId;
    private final CharSequence mMessage;
    private final int mMessageResId;

    @Override // com.android.internal.globalactions.Action
    public abstract void onPress();

    protected SinglePressAction(int iconResId, int messageResId) {
        this.mIconResId = iconResId;
        this.mMessageResId = messageResId;
        this.mMessage = null;
        this.mIcon = null;
    }

    protected SinglePressAction(int iconResId, Drawable icon, CharSequence message) {
        this.mIconResId = iconResId;
        this.mMessageResId = 0;
        this.mMessage = message;
        this.mIcon = icon;
    }

    @Override // com.android.internal.globalactions.Action
    public boolean isEnabled() {
        return true;
    }

    public String getStatus() {
        return null;
    }

    @Override // com.android.internal.globalactions.Action
    public CharSequence getLabelForAccessibility(Context context) {
        CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            return charSequence;
        }
        return context.getString(this.mMessageResId);
    }

    @Override // com.android.internal.globalactions.Action
    public View create(Context context, View convertView, ViewGroup parent, LayoutInflater inflater) {
        View v2 = inflater.inflate(17367173, parent, false);
        ImageView icon = (ImageView) v2.findViewById(16908294);
        TextView messageView = (TextView) v2.findViewById(16908299);
        TextView statusView = (TextView) v2.findViewById(16909572);
        String status = getStatus();
        if (statusView != null) {
            if (!TextUtils.isEmpty(status)) {
                statusView.setText(status);
            } else {
                statusView.setVisibility(8);
            }
        }
        if (icon != null) {
            Drawable drawable = this.mIcon;
            if (drawable != null) {
                icon.setImageDrawable(drawable);
                icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                int i10 = this.mIconResId;
                if (i10 != 0) {
                    icon.setImageDrawable(context.getDrawable(i10));
                }
            }
        }
        if (messageView != null) {
            CharSequence charSequence = this.mMessage;
            if (charSequence != null) {
                messageView.setText(charSequence);
            } else {
                messageView.setText(this.mMessageResId);
            }
        }
        return v2;
    }
}
