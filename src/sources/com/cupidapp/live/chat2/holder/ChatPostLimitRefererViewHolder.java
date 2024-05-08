package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.chat2.helper.ChatViewHolderFactory;
import com.cupidapp.live.chat2.model.ChatGoToPostLimitDetailPageEvent;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ChatPostLimitRefererViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatPostLimitRefererViewHolder extends BaseChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13384d = new a(null);

    /* compiled from: ChatPostLimitRefererViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements ChatViewHolderFactory {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.cupidapp.live.chat2.helper.ChatViewHolderFactory
        @NotNull
        public BaseChatViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new ChatPostLimitRefererViewHolder(z.b(parent, R$layout.view_holder_chat_post_limit_referer, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatPostLimitRefererViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return null;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatMessageStateView B() {
        return null;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatTimeStampView C() {
        return null;
    }

    public final void D(final ChatMessageModel chatMessageModel) {
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.chat_post_limit_referer_image);
        s.h(imageLoaderView, "itemView.chat_post_limit_referer_image");
        PostLimitDetailModel postLimit = chatMessageModel.getPostLimit();
        ImageLoaderView.g(imageLoaderView, postLimit != null ? postLimit.getImage() : null, null, null, 6, null);
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.chat_post_limit_referer_linear_layout);
        s.h(linearLayout, "itemView.chat_post_limit_referer_linear_layout");
        y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.ChatPostLimitRefererViewHolder$fillViewAndBindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                User user;
                EventBus c4 = EventBus.c();
                PostLimitDetailModel postLimit2 = ChatMessageModel.this.getPostLimit();
                String str = null;
                String id2 = postLimit2 != null ? postLimit2.getId() : null;
                String itemId = ChatMessageModel.this.getItemId();
                PostLimitDetailModel postLimit3 = ChatMessageModel.this.getPostLimit();
                if (postLimit3 != null && (user = postLimit3.getUser()) != null) {
                    str = user.userId();
                }
                c4.l(new ChatGoToPostLimitDetailPageEvent(id2, itemId, str));
            }
        });
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        return null;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void y(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        D(model);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void z(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        D(model);
    }
}
