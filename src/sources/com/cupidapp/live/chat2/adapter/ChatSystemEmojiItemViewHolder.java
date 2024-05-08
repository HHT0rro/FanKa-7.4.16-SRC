package com.cupidapp.live.chat2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ChatSystemEmojiItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSystemEmojiItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13304c = new a(null);

    /* compiled from: ChatSystemEmojiItemAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatSystemEmojiItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatSystemEmojiItemViewHolder(z.b(parent, R$layout.view_holder_chat_system_emoji_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSystemEmojiItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof String) {
            View view = this.itemView;
            int i10 = R$id.chat_system_emoji_item_text;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.chat_system_emoji_item_text");
            u.a(textView);
            ((TextView) this.itemView.findViewById(i10)).setText((CharSequence) obj);
        }
    }
}
