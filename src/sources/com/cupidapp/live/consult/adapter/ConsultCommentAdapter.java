package com.cupidapp.live.consult.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.consult.model.ConsultCommentModel;
import com.cupidapp.live.consult.viewholder.ConsultCommentViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCommentAdapter extends FKBaseRecyclerViewAdapter {
    public final void u(@NotNull List<ConsultCommentModel> list) {
        s.i(list, "list");
        notifyItemRangeInserted(e(list), list.size());
    }

    @Nullable
    public final Integer v() {
        int l10 = kotlin.collections.s.l(j());
        if (l10 == -1) {
            return null;
        }
        return Integer.valueOf(l10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        ConsultCommentViewHolder a10 = ConsultCommentViewHolder.f13894c.a(parent);
        a10.k(l());
        return a10;
    }
}
