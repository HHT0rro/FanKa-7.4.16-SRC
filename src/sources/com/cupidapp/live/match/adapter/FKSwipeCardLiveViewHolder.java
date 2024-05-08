package com.cupidapp.live.match.adapter;

import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.entity.c;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKSwipeCardAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardLiveViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16623c = new a(null);

    /* compiled from: FKSwipeCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKSwipeCardLiveViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKSwipeCardLiveViewHolder(z.b(parent, R$layout.view_holder_swipe_card_live, false, 2, null));
        }
    }

    /* compiled from: FKSwipeCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveShowModel f16625b;

        public b(LiveShowModel liveShowModel) {
            this.f16625b = liveShowModel;
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayStateUpdate(int i10, @Nullable String str) {
            super.onPlayStateUpdate(i10, str);
            if (i10 != 0) {
                FKSwipeCardLiveViewHolder.this.s(this.f16625b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardLiveViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveShowModel) {
            t((LiveShowModel) obj);
        }
    }

    public final void s(LiveShowModel liveShowModel) {
        ((LinearLayout) this.itemView.findViewById(R$id.live_user_info_layout)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.enter_live_room_layout)).setVisibility(8);
        ((RelativeLayout) this.itemView.findViewById(R$id.live_end_layout)).setVisibility(0);
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.user_avatar_image);
        s.h(imageLoaderView, "itemView.user_avatar_image");
        ImageLoaderView.g(imageLoaderView, liveShowModel.getUser().getAvatarImage(), null, null, 6, null);
        ((TextView) this.itemView.findViewById(R$id.live_end_user_name)).setText(liveShowModel.getUser().getName());
    }

    public final void t(LiveShowModel liveShowModel) {
        ((CardView) this.itemView.findViewById(R$id.swipe_card_live_container)).setRadius(h.c(this, 8.0f));
        ((LinearLayout) this.itemView.findViewById(R$id.live_user_info_layout)).setVisibility(0);
        ((LinearLayout) this.itemView.findViewById(R$id.enter_live_room_layout)).setVisibility(0);
        ((RelativeLayout) this.itemView.findViewById(R$id.live_end_layout)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.user_basic_info_text)).setText(liveShowModel.getUserProfileSummaryInfo());
        ((TextView) this.itemView.findViewById(R$id.user_name_text)).setText(liveShowModel.getUser().getName());
        if (liveShowModel.getRedPacketInfo() != null) {
            View view = this.itemView;
            int i10 = R$id.red_envelope_tag_imageview;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView, "itemView.red_envelope_tag_imageview");
            imageLoaderView.setVisibility(0);
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.red_envelope_tag_imageview");
            ImageLoaderView.g(imageLoaderView2, liveShowModel.getRedPacketInfo().getRedPacketIcon(), null, null, 6, null);
            return;
        }
        ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(R$id.red_envelope_tag_imageview);
        s.h(imageLoaderView3, "itemView.red_envelope_tag_imageview");
        imageLoaderView3.setVisibility(8);
    }

    public final void u(@NotNull LiveShowModel liveShow) {
        s.i(liveShow, "liveShow");
        FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodEnterMatch, false, true, 2, null);
        FKLiveConstantsData.INSTANCE.setFkLiveShowResult(LiveShowResult.Companion.a(liveShow));
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        b bVar = new b(liveShow);
        String itemId = liveShow.getItemId();
        TextureView textureView = (TextureView) this.itemView.findViewById(R$id.swipe_card_live_texture);
        s.h(textureView, "itemView.swipe_card_live_texture");
        fKLiveUtil.j(bVar, itemId, textureView, false);
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) this.itemView.findViewById(R$id.swipe_card_living_image);
        s.h(fKSVGAImageView, "itemView.swipe_card_living_image");
        FKSVGAImageView.F(fKSVGAImageView, "match_live_label.svga", null, null, 6, null);
    }

    public final void v() {
        FKLiveUtil.f14913a.m();
        ((FKSVGAImageView) this.itemView.findViewById(R$id.swipe_card_living_image)).K();
    }
}
