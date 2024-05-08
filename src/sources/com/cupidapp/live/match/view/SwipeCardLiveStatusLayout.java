package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwipeCardLiveStatusLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwipeCardLiveStatusLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16998b;

    /* compiled from: SwipeCardLiveStatusLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends com.cupidapp.live.liveshow.entity.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveShowModel f17000b;

        public a(LiveShowModel liveShowModel) {
            this.f17000b = liveShowModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
        
            if ((r9.vkbps == com.google.android.material.shadow.ShadowDrawableWrapper.COS_45) != false) goto L15;
         */
        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPlayQualityUpdate(@org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.Nullable com.zego.zegoliveroom.entity.ZegoPlayStreamQuality r9) {
            /*
                r7 = this;
                super.onPlayQualityUpdate(r8, r9)
                com.cupidapp.live.match.view.SwipeCardLiveStatusLayout r8 = com.cupidapp.live.match.view.SwipeCardLiveStatusLayout.this
                int r0 = com.cupidapp.live.R$id.swipe_card_live_cover_imageview
                android.view.View r8 = r8.a(r0)
                com.cupidapp.live.base.imageloader.ImageLoaderView r8 = (com.cupidapp.live.base.imageloader.ImageLoaderView) r8
                java.lang.String r0 = "swipe_card_live_cover_imageview"
                kotlin.jvm.internal.s.h(r8, r0)
                if (r9 == 0) goto L1b
                double r0 = r9.vdecFps
                java.lang.Double r0 = java.lang.Double.valueOf(r0)
                goto L1c
            L1b:
                r0 = 0
            L1c:
                r1 = 0
                boolean r0 = kotlin.jvm.internal.s.a(r0, r1)
                r3 = 1
                r4 = 0
                if (r0 == 0) goto L32
                double r5 = r9.vkbps
                int r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r9 != 0) goto L2e
                r9 = 1
                goto L2f
            L2e:
                r9 = 0
            L2f:
                if (r9 == 0) goto L32
                goto L33
            L32:
                r3 = 0
            L33:
                if (r3 == 0) goto L36
                goto L38
            L36:
                r4 = 8
            L38:
                r8.setVisibility(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.SwipeCardLiveStatusLayout.a.onPlayQualityUpdate(java.lang.String, com.zego.zegoliveroom.entity.ZegoPlayStreamQuality):void");
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayStateUpdate(int i10, @Nullable String str) {
            super.onPlayStateUpdate(i10, str);
            if (i10 != 0) {
                SwipeCardLiveStatusLayout swipeCardLiveStatusLayout = SwipeCardLiveStatusLayout.this;
                int i11 = R$id.swipe_card_live_cover_imageview;
                ImageLoaderView swipe_card_live_cover_imageview = (ImageLoaderView) swipeCardLiveStatusLayout.a(i11);
                kotlin.jvm.internal.s.h(swipe_card_live_cover_imageview, "swipe_card_live_cover_imageview");
                swipe_card_live_cover_imageview.setVisibility(0);
                ImageLoaderView swipe_card_live_cover_imageview2 = (ImageLoaderView) SwipeCardLiveStatusLayout.this.a(i11);
                kotlin.jvm.internal.s.h(swipe_card_live_cover_imageview2, "swipe_card_live_cover_imageview");
                ImageLoaderView.g(swipe_card_live_cover_imageview2, this.f17000b.getCoverImage(), null, null, 6, null);
            }
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onVideoSizeChangedTo(@Nullable String str, int i10, int i11) {
            super.onVideoSizeChangedTo(str, i10, i11);
            ImageLoaderView swipe_card_live_cover_imageview = (ImageLoaderView) SwipeCardLiveStatusLayout.this.a(R$id.swipe_card_live_cover_imageview);
            kotlin.jvm.internal.s.h(swipe_card_live_cover_imageview, "swipe_card_live_cover_imageview");
            swipe_card_live_cover_imageview.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeCardLiveStatusLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16998b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16998b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(@Nullable LiveShowModel liveShowModel) {
        if (liveShowModel != null) {
            setVisibility(0);
            ImageLoaderView swipe_card_live_cover_imageview = (ImageLoaderView) a(R$id.swipe_card_live_cover_imageview);
            kotlin.jvm.internal.s.h(swipe_card_live_cover_imageview, "swipe_card_live_cover_imageview");
            ImageLoaderView.g(swipe_card_live_cover_imageview, liveShowModel.getCoverImage(), null, null, 6, null);
            if (liveShowModel.getRedPacketInfo() != null) {
                int i10 = R$id.red_envelope_tag_imageview;
                ImageLoaderView red_envelope_tag_imageview = (ImageLoaderView) a(i10);
                kotlin.jvm.internal.s.h(red_envelope_tag_imageview, "red_envelope_tag_imageview");
                red_envelope_tag_imageview.setVisibility(0);
                ImageLoaderView red_envelope_tag_imageview2 = (ImageLoaderView) a(i10);
                kotlin.jvm.internal.s.h(red_envelope_tag_imageview2, "red_envelope_tag_imageview");
                ImageLoaderView.g(red_envelope_tag_imageview2, liveShowModel.getRedPacketInfo().getRedPacketIcon(), null, null, 6, null);
                return;
            }
            ImageLoaderView red_envelope_tag_imageview3 = (ImageLoaderView) a(R$id.red_envelope_tag_imageview);
            kotlin.jvm.internal.s.h(red_envelope_tag_imageview3, "red_envelope_tag_imageview");
            red_envelope_tag_imageview3.setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public final void c() {
        z0.z.a(this, R$layout.layout_swipe_card_live_status, true);
        setVisibility(8);
        ((TextView) a(R$id.live_status_textview)).getPaint().setFakeBoldText(true);
        float c4 = z0.h.c(this, 6.0f);
        ((RoundedFrameLayout) a(R$id.swipe_card_live_status_layout)).setCornerRadius(c4, 0.0f, c4, 0.0f);
    }

    public final void d(@NotNull LiveShowModel liveShow) {
        kotlin.jvm.internal.s.i(liveShow, "liveShow");
        if (getVisibility() == 0) {
            FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodEnterMatch, false, true, 2, null);
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
            if (!kotlin.jvm.internal.s.d(liveShowModel != null ? liveShowModel.getItemId() : null, liveShow.getItemId())) {
                fKLiveConstantsData.setFkLiveShowResult(LiveShowResult.Companion.a(liveShow));
            }
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            a aVar = new a(liveShow);
            String itemId = liveShow.getItemId();
            TextureView swipe_card_live_status_texture = (TextureView) a(R$id.swipe_card_live_status_texture);
            kotlin.jvm.internal.s.h(swipe_card_live_status_texture, "swipe_card_live_status_texture");
            fKLiveUtil.j(aVar, itemId, swipe_card_live_status_texture, false);
            FKSVGAImageView living_imageview = (FKSVGAImageView) a(R$id.living_imageview);
            kotlin.jvm.internal.s.h(living_imageview, "living_imageview");
            FKSVGAImageView.F(living_imageview, "swipe_card_live_status.svga", null, null, 6, null);
        }
    }

    public final void e() {
        if (getVisibility() == 0) {
            ImageLoaderView swipe_card_live_cover_imageview = (ImageLoaderView) a(R$id.swipe_card_live_cover_imageview);
            kotlin.jvm.internal.s.h(swipe_card_live_cover_imageview, "swipe_card_live_cover_imageview");
            swipe_card_live_cover_imageview.setVisibility(0);
            FKLiveUtil.f14913a.m();
            ((FKSVGAImageView) a(R$id.living_imageview)).K();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeCardLiveStatusLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16998b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeCardLiveStatusLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16998b = new LinkedHashMap();
        c();
    }
}
