package com.android.internal.app;

import android.content.Context;
import android.util.AttributeSet;
import com.android.internal.widget.GridLayoutManager;
import com.android.internal.widget.RecyclerView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ChooserGridLayoutManager extends GridLayoutManager {
    private boolean mVerticalScrollEnabled;

    public ChooserGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mVerticalScrollEnabled = true;
    }

    public ChooserGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
        this.mVerticalScrollEnabled = true;
    }

    public ChooserGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
        this.mVerticalScrollEnabled = true;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.getRowCountForAccessibility(recycler, state) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerticalScrollEnabled(boolean verticalScrollEnabled) {
        this.mVerticalScrollEnabled = verticalScrollEnabled;
    }

    public boolean canScrollVertically() {
        return this.mVerticalScrollEnabled && super.canScrollVertically();
    }
}
