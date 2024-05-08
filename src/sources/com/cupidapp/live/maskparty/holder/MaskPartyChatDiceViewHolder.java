package com.cupidapp.live.maskparty.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.maskparty.helper.MaskPartyChatViewHolderFactory;
import com.cupidapp.live.maskparty.model.DicePoint;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyLongClickActionType;
import com.cupidapp.live.maskparty.view.MaskPartyChatMessageStateView;
import com.cupidapp.live.maskparty.view.MaskPartyChatTimeStampView;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MaskPartyChatDiceViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatDiceViewHolder extends BaseMaskPartyChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16353d = new a(null);

    /* compiled from: MaskPartyChatDiceViewHolder.kt */
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
            return new MaskPartyChatDiceViewHolder(z.b(parent, z10 ? R$layout.view_holder_mask_party_chat_dice_right : R$layout.view_holder_mask_party_chat_dice_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatDiceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static /* synthetic */ void D(MaskPartyChatDiceViewHolder maskPartyChatDiceViewHolder, MaskPartyChatMessageModel maskPartyChatMessageModel, boolean z10, FKSVGAImageView fKSVGAImageView, ImageView imageView, Function1 function1, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            function1 = null;
        }
        maskPartyChatDiceViewHolder.C(maskPartyChatMessageModel, z10, fKSVGAImageView, imageView, function1);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatMessageStateView A() {
        return null;
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public MaskPartyChatTimeStampView B() {
        return (MaskPartyChatTimeStampView) this.itemView.findViewById(R$id.chat_dice_time_stamp_view);
    }

    public final void C(MaskPartyChatMessageModel maskPartyChatMessageModel, boolean z10, final FKSVGAImageView fKSVGAImageView, final ImageView imageView, final Function1<? super MaskPartyChatDiceModel, p> function1) {
        final MaskPartyChatDiceModel diceModel = maskPartyChatMessageModel.getDiceModel();
        if (diceModel == null) {
            return;
        }
        final DicePoint a10 = DicePoint.Companion.a(z10 ? diceModel.getMyDiceNum() : diceModel.getTargetDiceNum());
        if (maskPartyChatMessageModel.isShow()) {
            maskPartyChatMessageModel.setShow(false);
            imageView.setVisibility(8);
            fKSVGAImageView.setVisibility(0);
            FKSVGAImageView.F(fKSVGAImageView, "play_dice.svga", null, new Function0<p>() { // from class: com.cupidapp.live.maskparty.holder.MaskPartyChatDiceViewHolder$configAnimation$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKSVGAImageView.this.setVisibility(4);
                    imageView.setVisibility(0);
                    DicePoint dicePoint = a10;
                    if (dicePoint != null) {
                        imageView.setImageResource(dicePoint.getIcon());
                    }
                    Function1<MaskPartyChatDiceModel, p> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(diceModel);
                    }
                }
            }, 2, null);
            return;
        }
        imageView.setVisibility(0);
        fKSVGAImageView.setVisibility(4);
        if (a10 != null) {
            imageView.setImageResource(a10.getIcon());
        }
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ArrayList<MaskPartyLongClickActionType> u(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        return null;
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void w(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) this.itemView.findViewById(R$id.left_dice_svga_view);
        s.h(fKSVGAImageView, "itemView.left_dice_svga_view");
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.left_dice_img);
        s.h(imageView, "itemView.left_dice_img");
        D(this, model, false, fKSVGAImageView, imageView, null, 16, null);
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    public void x(@NotNull MaskPartyChatMessageModel model) {
        s.i(model, "model");
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) this.itemView.findViewById(R$id.right_dice_svga_view);
        s.h(fKSVGAImageView, "itemView.right_dice_svga_view");
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.right_dice_img);
        s.h(imageView, "itemView.right_dice_img");
        C(model, true, fKSVGAImageView, imageView, new MaskPartyChatDiceViewHolder$fillRightView$1(this));
    }

    @Override // com.cupidapp.live.maskparty.holder.BaseMaskPartyChatViewHolder
    @Nullable
    public ImageLoaderView y() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.left_dice_avatar_image);
    }
}
