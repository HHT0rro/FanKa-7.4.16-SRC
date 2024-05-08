package com.cupidapp.live.notify.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.ai.model.AiRcmdModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.notify.viewholder.AiRcmdViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AiRcmdAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiRcmdAdapter extends FKBaseRecyclerViewAdapter {
    public AiRcmdAdapter() {
        k().add(AiRcmdModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        AiRcmdViewHolder a10 = AiRcmdViewHolder.f17568c.a(parent);
        a10.k(l());
        return a10;
    }
}
