package com.cupidapp.live.chat.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat.viewholder.ChatRecommendImageUiModel;
import com.cupidapp.live.chat.viewholder.ChatRecommendViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatRecommendAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatRecommendAdapter extends FKBaseRecyclerViewAdapter {
    public ChatRecommendAdapter() {
        k().add(ChatRecommendImageUiModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        ChatRecommendViewHolder a10 = ChatRecommendViewHolder.f13245d.a(parent);
        a10.k(l());
        return a10;
    }
}
