package com.android.internal.accessibility.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class ButtonTargetAdapter extends TargetAdapter {
    private List<AccessibilityTarget> mTargets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ButtonTargetAdapter(List<AccessibilityTarget> targets) {
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
        Context context = parent.getContext();
        View root = LayoutInflater.from(context).inflate(17367065, parent, false);
        AccessibilityTarget target = this.mTargets.get(position);
        ImageView iconView = (ImageView) root.findViewById(16908700);
        TextView labelView = (TextView) root.findViewById(16908701);
        iconView.setImageDrawable(target.getIcon());
        labelView.setText(target.getLabel());
        return root;
    }
}
