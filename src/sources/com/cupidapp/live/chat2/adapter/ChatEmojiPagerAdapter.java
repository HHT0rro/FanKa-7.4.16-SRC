package com.cupidapp.live.chat2.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.chat2.holder.ChatCustomEmojiPagerUiModel;
import com.cupidapp.live.chat2.holder.ChatCustomEmojiPagerViewHolder;
import com.cupidapp.live.chat2.holder.ChatSystemEmojiPagerUiModel;
import com.cupidapp.live.chat2.holder.ChatSystemEmojiPagerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatEmojiPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatEmojiPagerAdapter extends FKBaseRecyclerViewAdapter {
    public ChatEmojiPagerAdapter() {
        k().add(ChatSystemEmojiPagerUiModel.class);
        k().add(ChatCustomEmojiPagerUiModel.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        if (i10 == 0) {
            return ChatSystemEmojiPagerViewHolder.f13391d.a(parent);
        }
        if (i10 != 1) {
            return FKEmptyListViewHolder.f12034c.a(parent);
        }
        return ChatCustomEmojiPagerViewHolder.f13373d.a(parent);
    }
}
