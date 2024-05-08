package com.cupidapp.live.maskparty.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.maskparty.activity.ChatLookImageActivity;
import com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity;
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

/* compiled from: MaskPartyChatSnapImageViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatSnapImageViewHolder extends BaseMaskPartyChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16357d = new a(null);

    /* compiled from: MaskPartyChatSnapImageViewHolder.kt */
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
            return new MaskPartyChatSnapImageViewHolder(z.b(parent, z10 ? R$layout.view_holder_mask_party_chat_snap_image_right : R$layout.view_holder_mask_party_chat_snap_image_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatSnapImageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatMessageStateView A() {
        return (MaskPartyChatMessageStateView) this.itemView.findViewById(R$id.right_snap_image_message_state_view);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatTimeStampView B() {
        return (MaskPartyChatTimeStampView) this.itemView.findViewById(R$id.chat_snap_image_time_stamp_view);
    }

    public final void C(View view, final MaskPartyChatMessageModel maskPartyChatMessageModel) {
        y.d(view, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.holder.MaskPartyChatSnapImageViewHolder$bindClickEvent$1
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
                if (MaskPartyChatMessageModel.this.getMine()) {
                    ChatLookImageActivity.f16224r.a(this.itemView.getContext(), MaskPartyChatMessageModel.this.assembleChatLookImageData());
                    return;
                }
                MaskPartyLookSnapImageActivity.a aVar = MaskPartyLookSnapImageActivity.f16234x;
                aVar.a(MaskPartyChatMessageModel.this);
                aVar.b(this.itemView.getContext());
            }
        });
        if (maskPartyChatMessageModel.getMine()) {
            s(view, maskPartyChatMessageModel);
        }
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ArrayList<MaskPartyLongClickActionType> u(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        if (model.getMine()) {
            return kotlin.collections.s.f(MaskPartyLongClickActionType.Destroy);
        }
        return null;
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void w(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.left_snap_image_content_linear_layout);
        s.h(linearLayout, "itemView.left_snap_image_content_linear_layout");
        C(linearLayout, model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void x(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.right_snap_image_content_linear_layout);
        s.h(linearLayout, "itemView.right_snap_image_content_linear_layout");
        C(linearLayout, model);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ImageLoaderView y() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_snap_image_avatar_image);
    }
}
