package com.cupidapp.live.maskparty.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MaskPartyChatUserInfoViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatUserInfoViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16359c = new a(null);

    /* compiled from: MaskPartyChatUserInfoViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MaskPartyChatUserInfoViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MaskPartyChatUserInfoViewHolder(z.b(parent, R$layout.view_holder_mask_party_chat_user_info, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatUserInfoViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MaskPartyChatUserInfoUiModel) {
            MaskPartyChatUserInfoUiModel maskPartyChatUserInfoUiModel = (MaskPartyChatUserInfoUiModel) obj;
            ImageModel maskOrRealAvatarImage = maskPartyChatUserInfoUiModel.getUser().getMaskOrRealAvatarImage(maskPartyChatUserInfoUiModel.isMask());
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.mask_party_user_info_avatar);
            s.h(imageLoaderView, "itemView.mask_party_user_info_avatar");
            ImageLoaderView.g(imageLoaderView, maskOrRealAvatarImage, null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.mask_party_user_info_desc)).setText(maskPartyChatUserInfoUiModel.getUser().getDesc());
            String summary = maskPartyChatUserInfoUiModel.getUser().getSummary();
            if (summary == null || summary.length() == 0) {
                ((Group) this.itemView.findViewById(R$id.mask_party_user_info_introduction_group)).setVisibility(8);
            } else {
                ((Group) this.itemView.findViewById(R$id.mask_party_user_info_introduction_group)).setVisibility(0);
                ((TextView) this.itemView.findViewById(R$id.mask_party_user_info_introduction_content)).setText(maskPartyChatUserInfoUiModel.getUser().getSummary());
            }
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.mask_party_user_info_match_imageview);
            s.h(imageView, "itemView.mask_party_user_info_match_imageview");
            imageView.setVisibility(maskPartyChatUserInfoUiModel.getUser().getMatch() ? 0 : 8);
        }
    }
}
