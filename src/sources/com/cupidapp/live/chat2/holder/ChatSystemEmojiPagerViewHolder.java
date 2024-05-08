package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.decoration.FKSingleColumnDecoration;
import com.cupidapp.live.chat2.adapter.ChatSystemEmojiItemAdapter;
import com.cupidapp.live.chat2.model.ChatSendEmojiMessageEvent;
import com.cupidapp.live.chat2.view.ChatEmojiType;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: ChatSystemEmojiPagerViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSystemEmojiPagerViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13391d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f13392c;

    /* compiled from: ChatSystemEmojiPagerViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatSystemEmojiPagerViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatSystemEmojiPagerViewHolder(z.b(parent, R$layout.view_holder_chat_system_emoji_pager, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSystemEmojiPagerViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f13392c = kotlin.c.b(new Function0<ChatSystemEmojiItemAdapter>() { // from class: com.cupidapp.live.chat2.holder.ChatSystemEmojiPagerViewHolder$mItemAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChatSystemEmojiItemAdapter invoke() {
                ChatSystemEmojiItemAdapter chatSystemEmojiItemAdapter = new ChatSystemEmojiItemAdapter();
                chatSystemEmojiItemAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat2.holder.ChatSystemEmojiPagerViewHolder$mItemAdapter$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof String) {
                            EventBus.c().l(new ChatSendEmojiMessageEvent(ChatEmojiType.SYSTEM, (String) obj));
                        }
                    }
                });
                return chatSystemEmojiItemAdapter;
            }
        });
        RecyclerView _init_$lambda$0 = (RecyclerView) itemView.findViewById(R$id.chat_system_emoji_pager_recycler_view);
        _init_$lambda$0.setLayoutManager(new GridLayoutManager(itemView.getContext(), 7));
        _init_$lambda$0.setAdapter(r());
        s.h(_init_$lambda$0, "_init_$lambda$0");
        int c4 = h.c(_init_$lambda$0, 4.0f);
        _init_$lambda$0.addItemDecoration(new FKSingleColumnDecoration(c4, h.c(_init_$lambda$0, 8.0f), c4, 0, 8, null));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatSystemEmojiPagerUiModel) {
            r().j().clear();
            ChatSystemEmojiPagerUiModel chatSystemEmojiPagerUiModel = (ChatSystemEmojiPagerUiModel) obj;
            r().e(chatSystemEmojiPagerUiModel.getEmojiList());
            r().notifyItemRangeInserted(0, chatSystemEmojiPagerUiModel.getEmojiList().size());
        }
    }

    public final ChatSystemEmojiItemAdapter r() {
        return (ChatSystemEmojiItemAdapter) this.f13392c.getValue();
    }
}
