package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.chat.view.BigImageRichMessageLayout;
import com.cupidapp.live.chat.view.MiniImageRichMessageLeftLayout;
import com.cupidapp.live.chat.view.MiniImageRichMessageRightLayout;
import com.cupidapp.live.chat.view.MiniTitleRichMessageLayout;
import com.cupidapp.live.chat2.helper.ChatViewHolderFactory;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ChatRichViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatRichViewHolder extends BaseChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13386d = new a(null);

    /* compiled from: ChatRichViewHolder.kt */
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
            return new ChatRichViewHolder(z.b(parent, R$layout.view_holder_chat_rich, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRichViewHolder(@NotNull View itemView) {
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
        return (ChatTimeStampView) this.itemView.findViewById(R$id.chat_rich_time_stamp_view);
    }

    public final void D(ChatMessageModel chatMessageModel) {
        View view = this.itemView;
        int i10 = R$id.chat_rich_big_image_layout;
        ((BigImageRichMessageLayout) view.findViewById(i10)).setVisibility(0);
        ((BigImageRichMessageLayout) this.itemView.findViewById(i10)).b(chatMessageModel);
        ((MiniImageRichMessageRightLayout) this.itemView.findViewById(R$id.chat_rich_mini_image_right_layout)).setVisibility(8);
        ((MiniImageRichMessageLeftLayout) this.itemView.findViewById(R$id.chat_rich_mini_image_left_layout)).setVisibility(8);
        ((MiniTitleRichMessageLayout) this.itemView.findViewById(R$id.chat_rich_mini_title_layout)).setVisibility(8);
    }

    public final void E(ChatMessageModel chatMessageModel) {
        View view = this.itemView;
        int i10 = R$id.chat_rich_mini_image_right_layout;
        ((MiniImageRichMessageRightLayout) view.findViewById(i10)).setVisibility(chatMessageModel.getMine() ? 0 : 8);
        View view2 = this.itemView;
        int i11 = R$id.chat_rich_mini_image_left_layout;
        ((MiniImageRichMessageLeftLayout) view2.findViewById(i11)).setVisibility(chatMessageModel.getMine() ? 8 : 0);
        if (chatMessageModel.getMine()) {
            ((MiniImageRichMessageRightLayout) this.itemView.findViewById(i10)).b(chatMessageModel);
        } else {
            ((MiniImageRichMessageLeftLayout) this.itemView.findViewById(i11)).b(chatMessageModel);
        }
    }

    public final void F(ChatMessageModel chatMessageModel) {
        View view = this.itemView;
        int i10 = R$id.chat_rich_mini_title_layout;
        ((MiniTitleRichMessageLayout) view.findViewById(i10)).setVisibility(0);
        ((MiniTitleRichMessageLayout) this.itemView.findViewById(i10)).b(chatMessageModel);
        ((BigImageRichMessageLayout) this.itemView.findViewById(R$id.chat_rich_big_image_layout)).setVisibility(8);
        ((MiniImageRichMessageRightLayout) this.itemView.findViewById(R$id.chat_rich_mini_image_right_layout)).setVisibility(8);
        ((MiniImageRichMessageLeftLayout) this.itemView.findViewById(R$id.chat_rich_mini_image_left_layout)).setVisibility(8);
    }

    public final void G(ChatMessageModel chatMessageModel) {
        String templateType = chatMessageModel.getTemplateType();
        if (templateType != null) {
            switch (templateType.hashCode()) {
                case 49:
                    if (templateType.equals("1")) {
                        D(chatMessageModel);
                        return;
                    }
                    return;
                case 50:
                    if (templateType.equals("2")) {
                        E(chatMessageModel);
                        return;
                    }
                    return;
                case 51:
                    if (templateType.equals("3")) {
                        F(chatMessageModel);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
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
        G(model);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void z(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        G(model);
    }
}
