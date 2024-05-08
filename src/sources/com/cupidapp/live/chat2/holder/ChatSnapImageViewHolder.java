package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.chat.util.FKDeleteSessionUtil;
import com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity;
import com.cupidapp.live.chat2.helper.ChatViewHolderFactory;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.maskparty.activity.ChatLookImageActivity;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.y;
import z0.z;

/* compiled from: ChatSnapImageViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSnapImageViewHolder extends BaseChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13387d = new a(null);

    /* compiled from: ChatSnapImageViewHolder.kt */
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
            return new ChatSnapImageViewHolder(z.b(parent, z10 ? R$layout.view_holder_chat_snap_image_right : R$layout.view_holder_chat_snap_image_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSnapImageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_snap_image_avatar_image);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatMessageStateView B() {
        return (ChatMessageStateView) this.itemView.findViewById(R$id.right_snap_image_message_state_view);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatTimeStampView C() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.chat_snap_image_time_stamp_view);
    }

    public final void E(View view, final ChatMessageModel chatMessageModel) {
        y.d(view, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.ChatSnapImageViewHolder$bindClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                if (ChatMessageModel.this.getMine()) {
                    ChatLookImageActivity.f16224r.a(this.itemView.getContext(), ChatMessageModel.this.assembleChatLookImageData());
                } else {
                    this.F(ChatMessageModel.this);
                }
            }
        });
        if (chatMessageModel.getMine()) {
            t(view, chatMessageModel);
        }
    }

    public final void F(ChatMessageModel chatMessageModel) {
        Boolean b4 = FKDeleteSessionUtil.f13177a.b();
        Boolean bool = Boolean.TRUE;
        if (s.d(b4, bool) && s.d(chatMessageModel.getUnread(), bool)) {
            g gVar = g.f52734a;
            if (s.d(gVar.q1(), bool)) {
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this.itemView.getContext(), false, 2, null), R$string.snap_image_read_prompt, 0, 2, null), R$string.all_right, null, null, 6, null), null, 1, null);
                gVar.A3(Boolean.FALSE);
                z3.b.f54828a.f();
                return;
            }
        }
        ChatLookSnapImageActivity.f13280x.b(this.itemView.getContext(), chatMessageModel);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        if (!model.getMine()) {
            return null;
        }
        String itemId = model.getItemId();
        if (itemId == null || itemId.length() == 0) {
            return null;
        }
        return kotlin.collections.s.f(LongClickActionType.Destroy);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void y(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.left_snap_image_content_linear_layout);
        s.h(linearLayout, "itemView.left_snap_image_content_linear_layout");
        E(linearLayout, model);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void z(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.right_snap_image_content_linear_layout);
        s.h(linearLayout, "itemView.right_snap_image_content_linear_layout");
        E(linearLayout, model);
    }
}
