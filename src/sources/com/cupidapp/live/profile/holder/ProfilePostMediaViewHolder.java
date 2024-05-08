package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: ProfilePostMediaViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ProfilePostMediaViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17828c = new a(null);

    /* compiled from: ProfilePostMediaViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfilePostMediaViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ProfilePostMediaViewHolder(z.b(parent, R$layout.view_holder_profile_post_meida, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfilePostMediaViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        FeedModel feedModel;
        ImageModel imageListFirst;
        if (!(obj instanceof FeedModel) || (imageListFirst = (feedModel = (FeedModel) obj).getImageListFirst()) == null) {
            return;
        }
        float width = imageListFirst.getWidth() / imageListFirst.getHeight();
        if (width > 1.0f) {
            width = 1.0f;
        } else if (width < 0.75f) {
            width = 0.75f;
        }
        int l10 = (h.l(this) - h.c(this, 2.0f)) / 2;
        View view = this.itemView;
        int i10 = R$id.profilePostCoverImageView;
        ViewGroup.LayoutParams layoutParams = ((ImageLoaderView) view.findViewById(i10)).getLayoutParams();
        layoutParams.width = l10;
        layoutParams.height = (int) (l10 / width);
        ((ImageLoaderView) this.itemView.findViewById(i10)).setLayoutParams(layoutParams);
        if (feedModel.getVideo() == null && feedModel.getImageListCount() <= 1) {
            ((ImageView) this.itemView.findViewById(R$id.videoOrMultiImageIcon)).setVisibility(8);
        } else {
            View view2 = this.itemView;
            int i11 = R$id.videoOrMultiImageIcon;
            ((ImageView) view2.findViewById(i11)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(i11)).setImageResource(feedModel.getVideo() != null ? R$mipmap.icon_video_play : R$mipmap.icon_multi_images);
        }
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
        s.h(imageLoaderView, "itemView.profilePostCoverImageView");
        ImageLoaderView.g(imageLoaderView, imageListFirst, null, null, 6, null);
        r(feedModel);
    }

    public final void r(FeedModel feedModel) {
        ((TextView) this.itemView.findViewById(R$id.post_top_tag)).setVisibility(s.d(feedModel.getDynamicTop(), Boolean.TRUE) ? 0 : 8);
    }
}
