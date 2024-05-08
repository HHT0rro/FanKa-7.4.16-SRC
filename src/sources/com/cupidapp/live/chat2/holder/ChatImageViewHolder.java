package com.cupidapp.live.chat2.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
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
import z0.y;
import z0.z;

/* compiled from: ChatImageViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatImageViewHolder extends BaseChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13375d = new a(null);

    /* compiled from: ChatImageViewHolder.kt */
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
            return new ChatImageViewHolder(z.b(parent, z10 ? R$layout.view_holder_chat_image_right : R$layout.view_holder_chat_image_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatImageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_image_avatar_image);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatMessageStateView B() {
        return (ChatMessageStateView) this.itemView.findViewById(R$id.right_image_message_state_view);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ChatTimeStampView C() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.chat_image_time_stamp_view);
    }

    public final void D(ImageLoaderView imageLoaderView, final ChatMessageModel chatMessageModel) {
        String imagePath = chatMessageModel.getImagePath();
        if (!(imagePath == null || imagePath.length() == 0)) {
            ImageLoaderView.f(imageLoaderView, new com.cupidapp.live.base.imageloader.b(false, chatMessageModel.getImagePath(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        } else if (chatMessageModel.getImage() != null) {
            ImageLoaderView.g(imageLoaderView, chatMessageModel.getImage(), null, null, 6, null);
        }
        y.d(imageLoaderView, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.holder.ChatImageViewHolder$fillViewAndBindClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ChatLookImageActivity.f16224r.a(ChatImageViewHolder.this.itemView.getContext(), chatMessageModel.assembleChatLookImageData());
            }
        });
        t(imageLoaderView, chatMessageModel);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        boolean z10 = true;
        if (!model.getMine()) {
            return kotlin.collections.s.f(LongClickActionType.Delete, LongClickActionType.Report);
        }
        ArrayList<LongClickActionType> arrayList = new ArrayList<>();
        String itemId = model.getItemId();
        if (itemId != null && itemId.length() != 0) {
            z10 = false;
        }
        if (z10) {
            return arrayList;
        }
        if (model.less2Min()) {
            arrayList.add(LongClickActionType.Cancel);
        }
        arrayList.add(LongClickActionType.Delete);
        return arrayList;
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void y(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.left_image_content_image);
        s.h(imageLoaderView, "itemView.left_image_content_image");
        D(imageLoaderView, model);
    }

    @Override // com.cupidapp.live.chat2.holder.BaseChatViewHolder
    public void z(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.right_image_content_image);
        s.h(imageLoaderView, "itemView.right_image_content_image");
        D(imageLoaderView, model);
    }
}
