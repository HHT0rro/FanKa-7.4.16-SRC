package com.cupidapp.live.liveshow.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.MiniProfilePopularFeedModel;
import com.cupidapp.live.liveshow.viewholder.FKLiveMiniProfilePhotoViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveMiniProfilePhotoAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniProfilePhotoAdapter extends FKBaseRecyclerViewAdapter {
    public FKLiveMiniProfilePhotoAdapter() {
        k().add(MiniProfilePopularFeedModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FKLiveMiniProfilePhotoViewHolder a10 = FKLiveMiniProfilePhotoViewHolder.f16044c.a(parent);
        a10.k(l());
        return a10;
    }
}
