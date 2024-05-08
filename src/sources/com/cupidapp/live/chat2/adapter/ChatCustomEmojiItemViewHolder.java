package com.cupidapp.live.chat2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ChatCustomEmojiItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatCustomEmojiItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13302c = new a(null);

    /* compiled from: ChatCustomEmojiItemAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatCustomEmojiItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatCustomEmojiItemViewHolder(z.b(parent, R$layout.view_holder_chat_custom_emoji_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatCustomEmojiItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatCustomEmojiItemUiModel) {
            ChatCustomEmojiItemUiModel chatCustomEmojiItemUiModel = (ChatCustomEmojiItemUiModel) obj;
            ((ImageView) this.itemView.findViewById(R$id.chat_custom_emoji_item_img)).setImageResource(chatCustomEmojiItemUiModel.getImageResId());
            ((TextView) this.itemView.findViewById(R$id.chat_custom_emoji_item_name)).setText(chatCustomEmojiItemUiModel.getName());
        }
    }
}
