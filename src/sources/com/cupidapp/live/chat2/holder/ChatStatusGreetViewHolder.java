package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
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

/* compiled from: ChatStatusGreetViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStatusGreetViewHolder extends BaseChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13389d = new a(null);

    /* compiled from: ChatStatusGreetViewHolder.kt */
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
            return new ChatStatusGreetViewHolder(z.b(parent, R$layout.view_holder_chat_status_greet, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatStatusGreetViewHolder(@NotNull View itemView) {
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

    public final void D(ChatMessageModel chatMessageModel) {
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.chat_status_greet_img);
        s.h(imageLoaderView, "itemView.chat_status_greet_img");
        ImageLoaderView.f(imageLoaderView, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.icon_chat_state_greet), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
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
