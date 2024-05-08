package com.cupidapp.live.chat.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ChatStatusViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStatusViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13250c = new a(null);

    /* compiled from: ChatStatusViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatStatusViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatStatusViewHolder(z.b(parent, R$layout.item_chat_status, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatStatusViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatStatusItemModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.status_icon);
            s.h(imageLoaderView, "itemView.status_icon");
            ChatStatusItemModel chatStatusItemModel = (ChatStatusItemModel) obj;
            ImageLoaderView.g(imageLoaderView, chatStatusItemModel.getIcon(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.status_name;
            ((TextView) view.findViewById(i10)).setText(chatStatusItemModel.getContent());
            TextView textView = (TextView) this.itemView.findViewById(i10);
            s.h(textView, "itemView.status_name");
            u.a(textView);
        }
    }
}
