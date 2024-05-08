package com.cupidapp.live.liveshow.viewholder;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
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
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.model.LiveCoverTagModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.view.LiveShowCoverTagView;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKLiveStreamViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveStreamViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16048d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16049c;

    /* compiled from: FKLiveStreamViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveStreamViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveStreamViewHolder(z.b(parent, R$layout.item_live_stream, false, 2, null));
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            ((ImageLoaderView) FKLiveStreamViewHolder.this.itemView.findViewById(R$id.liveStreamImg)).setVisibility(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* compiled from: FKLiveStreamViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends com.cupidapp.live.liveshow.entity.c {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayQualityUpdate(@Nullable String str, @Nullable ZegoPlayStreamQuality zegoPlayStreamQuality) {
            super.onPlayQualityUpdate(str, zegoPlayStreamQuality);
            if (s.a(zegoPlayStreamQuality != null ? Double.valueOf(zegoPlayStreamQuality.vdecFps) : null, ShadowDrawableWrapper.COS_45)) {
                if (zegoPlayStreamQuality.vkbps == ShadowDrawableWrapper.COS_45) {
                    FKLiveStreamViewHolder.this.t(true);
                }
            }
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayStateUpdate(int i10, @Nullable String str) {
            super.onPlayStateUpdate(i10, str);
            if (i10 == 0) {
                FKLiveStreamViewHolder.this.v();
            } else {
                FKLiveStreamViewHolder.this.u();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveStreamViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.live_leve_textview);
        s.h(textView, "itemView.live_leve_textview");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.live_title_textview);
        s.h(textView2, "itemView.live_title_textview");
        u.a(textView2);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveStreamModel) {
            LiveShowModel liveShow = ((LiveStreamModel) obj).getLiveShow();
            int l10 = h.l(this) - h.c(this, 4.0f);
            CardView cardView = (CardView) this.itemView.findViewById(R$id.live_streamer_card_view);
            s.h(cardView, "itemView.live_streamer_card_view");
            y.n(cardView, Integer.valueOf(l10), Integer.valueOf(l10));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.liveStreamImg);
            s.h(imageLoaderView, "itemView.liveStreamImg");
            ImageLoaderView.g(imageLoaderView, liveShow.getCoverImage(), null, null, 6, null);
            if (liveShow.getLevelBadgeImage() != null) {
                RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.live_badge_layout);
                s.h(relativeLayout, "itemView.live_badge_layout");
                relativeLayout.setVisibility(0);
                int scaleWidthByHeight = liveShow.getLevelBadgeImage().getScaleWidthByHeight(h.c(this, 16.0f));
                View view = this.itemView;
                int i10 = R$id.live_badge_imageView;
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) view.findViewById(i10);
                s.h(imageLoaderView2, "itemView.live_badge_imageView");
                y.o(imageLoaderView2, Integer.valueOf(scaleWidthByHeight), null, 2, null);
                ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView3, "itemView.live_badge_imageView");
                ImageLoaderView.g(imageLoaderView3, liveShow.getLevelBadgeImage(), null, null, 6, null);
                ((TextView) this.itemView.findViewById(R$id.live_leve_textview)).setText(String.valueOf(liveShow.getAnchorLevel()));
                TextView textView = (TextView) this.itemView.findViewById(R$id.live_user_name_textview);
                s.h(textView, "itemView.live_user_name_textview");
                y.m(textView, Integer.valueOf(h.c(this, 4.0f)), null, null, null, 14, null);
            } else {
                RelativeLayout relativeLayout2 = (RelativeLayout) this.itemView.findViewById(R$id.live_badge_layout);
                s.h(relativeLayout2, "itemView.live_badge_layout");
                relativeLayout2.setVisibility(8);
                TextView textView2 = (TextView) this.itemView.findViewById(R$id.live_user_name_textview);
                s.h(textView2, "itemView.live_user_name_textview");
                y.m(textView2, Integer.valueOf(h.c(this, 16.0f)), null, null, null, 14, null);
            }
            ((TextView) this.itemView.findViewById(R$id.live_title_textview)).setText(liveShow.getTitle());
            ((TextView) this.itemView.findViewById(R$id.live_user_name_textview)).setText(liveShow.getUser().getName());
            ((TextView) this.itemView.findViewById(R$id.live_heat_textview)).setText(liveShow.getFormatHeatValue());
            if (liveShow.getDeco() == null) {
                ((ImageLoaderView) this.itemView.findViewById(R$id.live_tag_img)).setVisibility(8);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.live_tag_img;
                ((ImageLoaderView) view2.findViewById(i11)).setVisibility(0);
                ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(i11);
                s.h(imageLoaderView4, "itemView.live_tag_img");
                ImageLoaderView.g(imageLoaderView4, liveShow.getDeco().getIconImage(), null, null, 6, null);
            }
            View view3 = this.itemView;
            int i12 = R$id.live_stream_cover_tag_layout;
            ((LinearLayout) view3.findViewById(i12)).removeAllViews();
            List<LiveCoverTagModel> coverTags = liveShow.getCoverTags();
            if (coverTags == null || coverTags.isEmpty()) {
                ((LinearLayout) this.itemView.findViewById(i12)).setVisibility(8);
                return;
            }
            ((LinearLayout) this.itemView.findViewById(i12)).setVisibility(0);
            for (LiveCoverTagModel liveCoverTagModel : liveShow.getCoverTags()) {
                Context context = this.itemView.getContext();
                s.h(context, "itemView.context");
                LiveShowCoverTagView liveShowCoverTagView = new LiveShowCoverTagView(context);
                liveShowCoverTagView.b(liveCoverTagModel, h.c(liveShowCoverTagView, 20.0f));
                ((LinearLayout) this.itemView.findViewById(R$id.live_stream_cover_tag_layout)).addView(liveShowCoverTagView);
                y.m(liveShowCoverTagView, null, null, Integer.valueOf(h.c(this, 8.0f)), null, 11, null);
            }
        }
    }

    public final void t(boolean z10) {
        if (z10) {
            ObjectAnimator objectAnimator = this.f16049c;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            ObjectAnimator objectAnimator2 = this.f16049c;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            View view = this.itemView;
            int i10 = R$id.liveStreamImg;
            ((ImageLoaderView) view.findViewById(i10)).setAlpha(1.0f);
            ((ImageLoaderView) this.itemView.findViewById(i10)).setVisibility(0);
            return;
        }
        ObjectAnimator changeLiveStreamShowState$lambda$3 = ObjectAnimator.ofFloat((ImageLoaderView) this.itemView.findViewById(R$id.liveStreamImg), (Property<ImageLoaderView, Float>) View.ALPHA, 1.0f, 0.0f);
        changeLiveStreamShowState$lambda$3.setDuration(300L);
        s.h(changeLiveStreamShowState$lambda$3, "changeLiveStreamShowState$lambda$3");
        changeLiveStreamShowState$lambda$3.addListener(new b());
        this.f16049c = changeLiveStreamShowState$lambda$3;
        changeLiveStreamShowState$lambda$3.start();
    }

    public final void u() {
        t(true);
    }

    public final void v() {
        t(false);
    }

    public final void w() {
        Object o10 = o();
        LiveStreamModel liveStreamModel = o10 instanceof LiveStreamModel ? (LiveStreamModel) o10 : null;
        LiveShowModel liveShow = liveStreamModel != null ? liveStreamModel.getLiveShow() : null;
        if (liveShow != null) {
            FKLiveConstantsData.INSTANCE.setFkLiveShowResult(LiveShowResult.Companion.a(liveShow));
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            c cVar = new c();
            String itemId = liveShow.getItemId();
            TextureView textureView = (TextureView) this.itemView.findViewById(R$id.liveStreamTexture);
            s.h(textureView, "itemView.liveStreamTexture");
            fKLiveUtil.j(cVar, itemId, textureView, false);
        }
    }

    public final void x() {
        LiveShowModel liveShow;
        t(true);
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        Object o10 = o();
        LiveStreamModel liveStreamModel = o10 instanceof LiveStreamModel ? (LiveStreamModel) o10 : null;
        FKLiveUtil.J(fKLiveUtil, (liveStreamModel == null || (liveShow = liveStreamModel.getLiveShow()) == null) ? null : liveShow.getStreamId(), false, 2, null);
    }
}
