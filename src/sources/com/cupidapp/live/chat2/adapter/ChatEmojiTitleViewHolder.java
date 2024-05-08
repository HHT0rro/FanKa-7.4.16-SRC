package com.cupidapp.live.chat2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ChatEmojiTitleAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatEmojiTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13303c = new a(null);

    /* compiled from: ChatEmojiTitleAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatEmojiTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatEmojiTitleViewHolder(z.b(parent, R$layout.view_holder_chat_emoji_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatEmojiTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatEmojiTitleUiModel) {
            ChatEmojiTitleUiModel chatEmojiTitleUiModel = (ChatEmojiTitleUiModel) obj;
            this.itemView.findViewById(R$id.chat_emoji_title_bg).setBackgroundResource(chatEmojiTitleUiModel.isSelected() ? R$drawable.shape_e7e7e7_bg_eighteen_corners : 0);
            ((ImageView) this.itemView.findViewById(R$id.chat_emoji_title_img)).setImageResource(chatEmojiTitleUiModel.getImageResId());
        }
    }
}
