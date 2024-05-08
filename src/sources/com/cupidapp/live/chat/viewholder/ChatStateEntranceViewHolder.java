package com.cupidapp.live.chat.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat.service.ChatStateEntranceModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.y;
import z0.z;

/* compiled from: ChatStateEntranceViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStateEntranceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13249c = new a(null);

    /* compiled from: ChatStateEntranceViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatStateEntranceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatStateEntranceViewHolder(z.b(parent, R$layout.view_holder_chat_state_entrance, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatStateEntranceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatStateEntranceModel) {
            int b4 = FKNewMatchUserItemViewHolder.f13253c.b();
            ChatStateEntranceModel chatStateEntranceModel = (ChatStateEntranceModel) obj;
            ImageModel background = chatStateEntranceModel.getBackground();
            Integer valueOf = background != null ? Integer.valueOf(background.getScaleWidthByHeight(b4)) : null;
            if (valueOf != null) {
                View view = this.itemView;
                int i10 = R$id.chat_entrance_image;
                ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
                s.h(imageLoaderView, "itemView.chat_entrance_image");
                y.n(imageLoaderView, valueOf, Integer.valueOf(b4));
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView2, "itemView.chat_entrance_image");
                ImageLoaderView.g(imageLoaderView2, chatStateEntranceModel.getBackground(), null, null, 6, null);
            }
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(R$id.chat_state_img);
            s.h(imageLoaderView3, "itemView.chat_state_img");
            ImageLoaderView.g(imageLoaderView3, chatStateEntranceModel.getIcon(), null, null, 6, null);
            ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(R$id.chat_avatar);
            s.h(imageLoaderView4, "itemView.chat_avatar");
            User X = g.f52734a.X();
            ImageLoaderView.g(imageLoaderView4, X != null ? X.getAvatarImage() : null, null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.chat_state_txt)).setText(chatStateEntranceModel.getContent());
        }
    }
}
