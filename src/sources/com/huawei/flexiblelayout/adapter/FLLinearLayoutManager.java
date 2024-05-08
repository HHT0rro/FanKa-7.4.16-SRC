package com.huawei.flexiblelayout.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27723a = "FLLinearLayoutManager";

    public FLLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException unused) {
            Log.w(f27723a, "onLayoutChildren exception");
        }
    }

    public FLLinearLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public FLLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
