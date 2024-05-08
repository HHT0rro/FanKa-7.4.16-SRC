package android.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Adapter {
    public static final int IGNORE_ITEM_VIEW_TYPE = -1;
    public static final int NO_SELECTION = Integer.MIN_VALUE;

    int getCount();

    Object getItem(int i10);

    long getItemId(int i10);

    int getItemViewType(int i10);

    View getView(int i10, View view, ViewGroup viewGroup);

    int getViewTypeCount();

    boolean hasStableIds();

    boolean isEmpty();

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);

    default CharSequence[] getAutofillOptions() {
        return null;
    }
}
