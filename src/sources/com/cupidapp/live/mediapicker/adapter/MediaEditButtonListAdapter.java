package com.cupidapp.live.mediapicker.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.holder.ImageEditFrameViewHolder;
import com.cupidapp.live.mediapicker.holder.MediaEditButtonViewHolder;
import com.cupidapp.live.mediapicker.model.FrameViewModel;
import com.cupidapp.live.mediapicker.model.MediaEditButtonViewModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MediaEditButtonListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaEditButtonListAdapter extends FKBaseRecyclerViewAdapter {
    public MediaEditButtonListAdapter() {
        k().add(MediaEditButtonViewModel.class);
        k().add(FrameViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = MediaEditButtonViewHolder.f17254c.a(parent);
        } else {
            a10 = ImageEditFrameViewHolder.f17251c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
