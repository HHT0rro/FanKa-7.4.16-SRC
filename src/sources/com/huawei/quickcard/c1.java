package com.huawei.quickcard;

import com.huawei.quickcard.views.list.QRecyclerView;
import com.huawei.quickcard.watcher.IWatchAttrCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c1 extends BaseRecyclerAdapter<QRecyclerView> implements IWatchAttrCallback {
    @Override // com.huawei.quickcard.watcher.IWatchAttrCallback
    public void onUpdate(String str, Object obj) {
        notifyDataSetChanged();
    }
}
