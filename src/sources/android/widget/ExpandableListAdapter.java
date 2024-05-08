package android.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ExpandableListAdapter {
    boolean areAllItemsEnabled();

    Object getChild(int i10, int i11);

    long getChildId(int i10, int i11);

    View getChildView(int i10, int i11, boolean z10, View view, ViewGroup viewGroup);

    int getChildrenCount(int i10);

    long getCombinedChildId(long j10, long j11);

    long getCombinedGroupId(long j10);

    Object getGroup(int i10);

    int getGroupCount();

    long getGroupId(int i10);

    View getGroupView(int i10, boolean z10, View view, ViewGroup viewGroup);

    boolean hasStableIds();

    boolean isChildSelectable(int i10, int i11);

    boolean isEmpty();

    void onGroupCollapsed(int i10);

    void onGroupExpanded(int i10);

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
