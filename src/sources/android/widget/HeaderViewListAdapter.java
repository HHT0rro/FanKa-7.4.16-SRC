package android.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class HeaderViewListAdapter implements WrapperListAdapter, Filterable {
    static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<>();
    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    private final boolean mIsFilterable;

    public HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> headerViewInfos, ArrayList<ListView.FixedViewInfo> footerViewInfos, ListAdapter adapter) {
        this.mAdapter = adapter;
        this.mIsFilterable = adapter instanceof Filterable;
        if (headerViewInfos == null) {
            this.mHeaderViewInfos = EMPTY_INFO_LIST;
        } else {
            this.mHeaderViewInfos = headerViewInfos;
        }
        if (footerViewInfos == null) {
            this.mFooterViewInfos = EMPTY_INFO_LIST;
        } else {
            this.mFooterViewInfos = footerViewInfos;
        }
        this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos);
    }

    public int getHeadersCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFootersCount() {
        return this.mFooterViewInfos.size();
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.mAdapter;
        return listAdapter == null || listAdapter.isEmpty();
    }

    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        if (infos != null) {
            Iterator<ListView.FixedViewInfo> iterator2 = infos.iterator2();
            while (iterator2.hasNext()) {
                ListView.FixedViewInfo info = iterator2.next();
                if (!info.isSelectable) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public boolean removeHeader(View v2) {
        int i10 = 0;
        while (true) {
            boolean z10 = false;
            if (i10 >= this.mHeaderViewInfos.size()) {
                return false;
            }
            ListView.FixedViewInfo info = this.mHeaderViewInfos.get(i10);
            if (info.view != v2) {
                i10++;
            } else {
                this.mHeaderViewInfos.remove(i10);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z10 = true;
                }
                this.mAreAllFixedViewsSelectable = z10;
                return true;
            }
        }
    }

    public boolean removeFooter(View v2) {
        int i10 = 0;
        while (true) {
            boolean z10 = false;
            if (i10 >= this.mFooterViewInfos.size()) {
                return false;
            }
            ListView.FixedViewInfo info = this.mFooterViewInfos.get(i10);
            if (info.view != v2) {
                i10++;
            } else {
                this.mFooterViewInfos.remove(i10);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z10 = true;
                }
                this.mAreAllFixedViewsSelectable = z10;
                return true;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mAdapter != null) {
            return getFootersCount() + getHeadersCount() + this.mAdapter.getCount();
        }
        return getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return this.mAreAllFixedViewsSelectable && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return this.mHeaderViewInfos.get(position).isSelectable;
        }
        int adjPosition = position - numHeaders;
        int adapterCount = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && adjPosition < (adapterCount = listAdapter.getCount())) {
            return this.mAdapter.isEnabled(adjPosition);
        }
        return this.mFooterViewInfos.get(adjPosition - adapterCount).isSelectable;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return this.mHeaderViewInfos.get(position).data;
        }
        int adjPosition = position - numHeaders;
        int adapterCount = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && adjPosition < (adapterCount = listAdapter.getCount())) {
            return this.mAdapter.getItem(adjPosition);
        }
        return this.mFooterViewInfos.get(adjPosition - adapterCount).data;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        int numHeaders = getHeadersCount();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && position >= numHeaders) {
            int adjPosition = position - numHeaders;
            int adapterCount = listAdapter.getCount();
            if (adjPosition < adapterCount) {
                return this.mAdapter.getItemId(adjPosition);
            }
            return -1L;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return this.mHeaderViewInfos.get(position).view;
        }
        int adjPosition = position - numHeaders;
        int adapterCount = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && adjPosition < (adapterCount = listAdapter.getCount())) {
            return this.mAdapter.getView(adjPosition, convertView, parent);
        }
        return this.mFooterViewInfos.get(adjPosition - adapterCount).view;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int position) {
        int numHeaders = getHeadersCount();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && position >= numHeaders) {
            int adjPosition = position - numHeaders;
            int adapterCount = listAdapter.getCount();
            if (adjPosition < adapterCount) {
                return this.mAdapter.getItemViewType(adjPosition);
            }
            return -2;
        }
        return -2;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver observer) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(observer);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver observer) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(observer);
        }
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mIsFilterable) {
            return ((Filterable) this.mAdapter).getFilter();
        }
        return null;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }
}
