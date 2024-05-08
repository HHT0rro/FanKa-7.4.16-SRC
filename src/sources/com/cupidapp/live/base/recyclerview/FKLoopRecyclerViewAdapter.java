package com.cupidapp.live.base.recyclerview;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLoopRecyclerViewAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKLoopRecyclerViewAdapter extends FKBaseRecyclerViewAdapter {
    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (j().size() > 1) {
            return Integer.MAX_VALUE;
        }
        return j().size();
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (k().isEmpty() || j().isEmpty()) {
            return 0;
        }
        int size = j().size();
        int u10 = u(i10);
        int i11 = -1;
        for (Class<? extends Object> cls : k()) {
            if (size > u10 && cls.isInstance(j().get(u10))) {
                i11 = k().indexOf(cls);
            }
        }
        if (i11 != -1) {
            return i11;
        }
        throw new IllegalStateException(("not find model class int type list:" + j().get(u10)).toString());
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        s.i(holder, "holder");
        int u10 = u(i10);
        if (u10 < 0 || u10 >= j().size()) {
            return;
        }
        holder.p(j().get(u10));
    }

    public final int u(int i10) {
        if (i10 < 0 || !(!j().isEmpty())) {
            return 0;
        }
        return i10 % j().size();
    }
}
