package com.huawei.quickcard.views.list;

import com.huawei.quickcard.base.annotation.QuickMethod;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IQRecyclerView {
    @QuickMethod
    Object getShowIndexes();

    @QuickMethod
    void notifyDataSetChanged();

    @QuickMethod
    void notifyItemChanged(int i10);

    @QuickMethod
    void scrollBy(Object obj);

    @QuickMethod
    void scrollTo(Object obj);
}
