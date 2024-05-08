package com.android.internal.accessibility.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.accessibility.dialog.TargetAdapter;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ShortcutTargetAdapter extends TargetAdapter {
    private int mShortcutMenuMode = 0;
    private final List<AccessibilityTarget> mTargets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortcutTargetAdapter(List<AccessibilityTarget> targets) {
        this.mTargets = targets;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mTargets.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mTargets.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TargetAdapter.ViewHolder holder;
        Context context = parent.getContext();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(17367067, parent, false);
            holder = new TargetAdapter.ViewHolder();
            holder.mCheckBoxView = (CheckBox) convertView.findViewById(16908714);
            holder.mIconView = (ImageView) convertView.findViewById(16908715);
            holder.mLabelView = (TextView) convertView.findViewById(16908716);
            holder.mStatusView = (TextView) convertView.findViewById(16908717);
            convertView.setTag(holder);
        } else {
            holder = (TargetAdapter.ViewHolder) convertView.getTag();
        }
        AccessibilityTarget target = this.mTargets.get(position);
        target.updateActionItem(holder, this.mShortcutMenuMode);
        return convertView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShortcutMenuMode(int shortcutMenuMode) {
        this.mShortcutMenuMode = shortcutMenuMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getShortcutMenuMode() {
        return this.mShortcutMenuMode;
    }
}
