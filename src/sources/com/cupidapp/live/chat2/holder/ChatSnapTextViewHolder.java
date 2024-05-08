package com.cupidapp.live.chat2.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.chat2.helper.ChatViewHolderFactory;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.model.OtherSnapTextMsgBindClickEvent;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
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

/* compiled from: ChatSnapTextViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSnapTextViewHolder extends BaseChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13388d = new a(null);

    /* compiled from: ChatSnapTextViewHolder.kt */
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
            return new ChatSnapTextViewHolder(z.b(parent, z10 ? R$layout.view_holder_chat_snap_text_right : R$layout.view_holder_chat_snap_text_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSnapTextViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_snap_text_avatar_image);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatMessageStateView B() {
        return (ChatMessageStateView) this.itemView.findViewById(R$id.right_snap_text_message_state_view);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatTimeStampView C() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.chat_snap_text_time_stamp_view);
    }

    public final void D(ChatMessageModel chatMessageModel, TextView textView) {
        if (chatMessageModel.passwordIsNullOrEmpty()) {
            textView.setText(chatMessageModel.getText());
            return;
        }
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        String completePassword = chatMessageModel.getCompletePassword(context);
        if (completePassword == null || completePassword.length() == 0) {
            return;
        }
        String text = chatMessageModel.getText();
        textView.setText(text != null ? l1.a.d(text, completePassword) : null);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        if (model.getMine()) {
            return kotlin.collections.s.f(LongClickActionType.Copy, LongClickActionType.Destroy);
        }
        return null;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void y(@NotNull final ChatMessageModel model) {
        s.i(model, "model");
        if (s.d(model.getUnread(), Boolean.TRUE)) {
            ((TextView) this.itemView.findViewById(R$id.left_snap_text_content_text)).setText(R$string.snap_chat);
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.left_snap_text_content_linear_layout);
            s.h(linearLayout, "itemView.left_snap_text_content_linear_layout");
            y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.ChatSnapTextViewHolder$fillLeftView$1
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
                    EventBus.c().l(new OtherSnapTextMsgBindClickEvent(ChatMessageModel.this));
                }
            });
            return;
        }
        TextView textView = (TextView) this.itemView.findViewById(R$id.left_snap_text_content_text);
        s.h(textView, "itemView.left_snap_text_content_text");
        D(model, textView);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void z(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        TextView textView = (TextView) this.itemView.findViewById(R$id.right_snap_text_content_text);
        s.h(textView, "itemView.right_snap_text_content_text");
        D(model, textView);
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.right_snap_text_content_linear_layout);
        s.h(linearLayout, "itemView.right_snap_text_content_linear_layout");
        t(linearLayout, model);
    }
}
