package com.cupidapp.live.maskparty.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.maskparty.activity.ChatLookImageActivity;
import com.cupidapp.live.maskparty.helper.MaskPartyChatViewHolderFactory;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyLongClickActionType;
import com.cupidapp.live.maskparty.view.MaskPartyChatMessageStateView;
import com.cupidapp.live.maskparty.view.MaskPartyChatTimeStampView;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyChatImageViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatImageViewHolder extends BaseMaskPartyChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16354d = new a(null);

    /* compiled from: MaskPartyChatImageViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements MaskPartyChatViewHolderFactory {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.cupidapp.live.maskparty.helper.MaskPartyChatViewHolderFactory
        @NotNull
        public BaseMaskPartyChatViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new MaskPartyChatImageViewHolder(z.b(parent, z10 ? R$layout.view_holder_mask_party_chat_image_right : R$layout.view_holder_mask_party_chat_image_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatImageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatMessageStateView A() {
        return (MaskPartyChatMessageStateView) this.itemView.findViewById(R$id.right_image_message_state_view);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatTimeStampView B() {
        return (MaskPartyChatTimeStampView) this.itemView.findViewById(R$id.chat_image_time_stamp_view);
    }

    public final void C(ImageLoaderView imageLoaderView, final MaskPartyChatMessageModel maskPartyChatMessageModel) {
        if (maskPartyChatMessageModel.getImage() != null) {
            ImageLoaderView.g(imageLoaderView, maskPartyChatMessageModel.getImage(), null, null, 6, null);
        } else {
            String imagePath = maskPartyChatMessageModel.getImagePath();
            if (!(imagePath == null || imagePath.length() == 0)) {
                ImageLoaderView.f(imageLoaderView, new com.cupidapp.live.base.imageloader.b(false, maskPartyChatMessageModel.getImagePath(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
            }
        }
        y.d(imageLoaderView, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.holder.MaskPartyChatImageViewHolder$fillViewAndBindClickEvent$1
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
                ChatLookImageActivity.f16224r.a(MaskPartyChatImageViewHolder.this.itemView.getContext(), maskPartyChatMessageModel.assembleChatLookImageData());
            }
        });
        s(imageLoaderView, maskPartyChatMessageModel);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ArrayList<MaskPartyLongClickActionType> u(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        if (!model.getMine()) {
            return kotlin.collections.s.f(MaskPartyLongClickActionType.Delete, MaskPartyLongClickActionType.Report);
        }
        ArrayList<MaskPartyLongClickActionType> arrayList = new ArrayList<>();
        if (model.less2Min()) {
            arrayList.add(MaskPartyLongClickActionType.Cancel);
        }
        arrayList.add(MaskPartyLongClickActionType.Delete);
        return arrayList;
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void w(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.left_image_content_image);
        s.h(imageLoaderView, "itemView.left_image_content_image");
        C(imageLoaderView, model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void x(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.right_image_content_image);
        s.h(imageLoaderView, "itemView.right_image_content_image");
        C(imageLoaderView, model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ImageLoaderView y() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_image_avatar_image);
    }
}
