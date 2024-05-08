package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.holder.PushChannelHolder;
import com.cupidapp.live.setting.model.PushChannelModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PushChannelAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushChannelAdapter extends FKBaseRecyclerViewAdapter {
    public PushChannelAdapter() {
        k().add(PushChannelModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        PushChannelHolder a10 = PushChannelHolder.f18195c.a(parent);
        a10.k(l());
        return a10;
    }
}
