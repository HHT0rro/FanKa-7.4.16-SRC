package com.android.internal.app;

import android.content.Context;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.app.AbstractMultiProfilePagerAdapter;
import com.android.internal.app.ChooserActivity;
import com.android.internal.widget.GridLayoutManager;
import com.android.internal.widget.RecyclerView;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ChooserMultiProfilePagerAdapter extends AbstractMultiProfilePagerAdapter {
    private static final int SINGLE_CELL_SPAN_SIZE = 1;
    private int mBottomOffset;
    private IChooserMultiProfilePagerAdapterExt mCMPPExt;
    private final ChooserProfileDescriptor[] mItems;
    private int mMaxTargetsPerRow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChooserMultiProfilePagerAdapter(Context context, ChooserActivity.ChooserGridAdapter adapter, AbstractMultiProfilePagerAdapter.EmptyStateProvider emptyStateProvider, AbstractMultiProfilePagerAdapter.QuietModeManager quietModeManager, UserHandle workProfileUserHandle, UserHandle cloneUserHandle, int maxTargetsPerRow) {
        super(context, 0, emptyStateProvider, quietModeManager, workProfileUserHandle, cloneUserHandle);
        this.mCMPPExt = (IChooserMultiProfilePagerAdapterExt) ExtLoader.type(IChooserMultiProfilePagerAdapterExt.class).base(this).create();
        this.mItems = new ChooserProfileDescriptor[]{createProfileDescriptor(adapter)};
        this.mMaxTargetsPerRow = maxTargetsPerRow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChooserMultiProfilePagerAdapter(Context context, ChooserActivity.ChooserGridAdapter personalAdapter, ChooserActivity.ChooserGridAdapter workAdapter, AbstractMultiProfilePagerAdapter.EmptyStateProvider emptyStateProvider, AbstractMultiProfilePagerAdapter.QuietModeManager quietModeManager, int defaultProfile, UserHandle workProfileUserHandle, UserHandle cloneUserHandle, int maxTargetsPerRow) {
        super(context, defaultProfile, emptyStateProvider, quietModeManager, workProfileUserHandle, cloneUserHandle);
        this.mCMPPExt = (IChooserMultiProfilePagerAdapterExt) ExtLoader.type(IChooserMultiProfilePagerAdapterExt.class).base(this).create();
        this.mItems = new ChooserProfileDescriptor[]{createProfileDescriptor(personalAdapter), createProfileDescriptor(workAdapter)};
        this.mMaxTargetsPerRow = maxTargetsPerRow;
    }

    private ChooserProfileDescriptor createProfileDescriptor(ChooserActivity.ChooserGridAdapter adapter) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewGroup rootView = this.mCMPPExt.getChooserProfileDescriptor(inflater);
        ChooserProfileDescriptor profileDescriptor = new ChooserProfileDescriptor(rootView, adapter);
        profileDescriptor.recyclerView.setAccessibilityDelegateCompat(new ChooserRecyclerViewAccessibilityDelegate(profileDescriptor.recyclerView));
        return profileDescriptor;
    }

    public void setMaxTargetsPerRow(int maxTargetsPerRow) {
        this.mMaxTargetsPerRow = maxTargetsPerRow;
    }

    RecyclerView getListViewForIndex(int index) {
        return getItem(index).recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserProfileDescriptor getItem(int pageIndex) {
        return this.mItems[pageIndex];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public int getItemCount() {
        return this.mItems.length;
    }

    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserActivity.ChooserGridAdapter getAdapterForIndex(int pageIndex) {
        return this.mItems[pageIndex].chooserGridAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserListAdapter getListAdapterForUserHandle(UserHandle userHandle) {
        if (getPersonalListAdapter().getUserHandle().equals(userHandle) || userHandle.equals(getCloneUserHandle())) {
            return getPersonalListAdapter();
        }
        if (getWorkListAdapter() != null && getWorkListAdapter().getUserHandle().equals(userHandle)) {
            return getWorkListAdapter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public void setupListAdapter(int pageIndex) {
        RecyclerView recyclerView = getItem(pageIndex).recyclerView;
        final ChooserActivity.ChooserGridAdapter chooserGridAdapter = getItem(pageIndex).chooserGridAdapter;
        final GridLayoutManager glm = recyclerView.getLayoutManager();
        glm.setSpanCount(this.mMaxTargetsPerRow);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.android.internal.app.ChooserMultiProfilePagerAdapter.1
            public int getSpanSize(int position) {
                if (chooserGridAdapter.shouldCellSpan(position)) {
                    return 1;
                }
                return glm.getSpanCount();
            }
        });
    }

    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserListAdapter getActiveListAdapter() {
        return getAdapterForIndex(getCurrentPage()).getListAdapter();
    }

    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserListAdapter getInactiveListAdapter() {
        if (getCount() == 1) {
            return null;
        }
        return getAdapterForIndex(1 - getCurrentPage()).getListAdapter();
    }

    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserListAdapter getPersonalListAdapter() {
        return getAdapterForIndex(0).getListAdapter();
    }

    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserListAdapter getWorkListAdapter() {
        if (getCount() == 1) {
            return null;
        }
        return getAdapterForIndex(1).getListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public ChooserActivity.ChooserGridAdapter getCurrentRootAdapter() {
        return getAdapterForIndex(getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public RecyclerView getActiveAdapterView() {
        return getListViewForIndex(getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public RecyclerView getInactiveAdapterView() {
        if (getCount() == 1) {
            return null;
        }
        return getListViewForIndex(1 - getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEmptyStateBottomOffset(int bottomOffset) {
        this.mBottomOffset = bottomOffset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter
    public void setupContainerPadding(View container) {
        int initialBottomPadding = getContext().getResources().getDimensionPixelSize(17105519);
        container.setPadding(container.getPaddingLeft(), container.getPaddingTop(), container.getPaddingRight(), this.mBottomOffset + initialBottomPadding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ChooserProfileDescriptor extends AbstractMultiProfilePagerAdapter.ProfileDescriptor {
        private ChooserActivity.ChooserGridAdapter chooserGridAdapter;
        private RecyclerView recyclerView;

        ChooserProfileDescriptor(ViewGroup rootView, ChooserActivity.ChooserGridAdapter adapter) {
            super(rootView);
            this.chooserGridAdapter = adapter;
            this.recyclerView = rootView.findViewById(16909442);
        }
    }
}
