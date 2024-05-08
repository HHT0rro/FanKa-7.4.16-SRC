package com.cupidapp.live.liveshow.view.bottommenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.BubbleGuideModel;
import com.cupidapp.live.base.view.FKPopupWindowBubbleGuideView;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.model.LiveMenuBtnModel;
import com.cupidapp.live.liveshow.model.LivePkIconModel;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.irisdt.client.live.LiveProtos;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveForStreamerBottomMenuLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForStreamerBottomMenuLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f15316d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15317e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public LivePkType f15318f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public FKPopupWindowBubbleGuideView f15319g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15320h;

    /* compiled from: FKLiveForStreamerBottomMenuLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e(@NotNull LivePkType livePkType);

        void f();

        void g();

        void h(boolean z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForStreamerBottomMenuLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15320h = new LinkedHashMap();
        x();
    }

    public static final void C(FKLiveForStreamerBottomMenuLayout this$0) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        int i10 = R$id.pkImageButton;
        ((ImageView) this$0.g(i10)).getLocationInWindow(iArr);
        int width = iArr[0] + (((ImageView) this$0.g(i10)).getWidth() / 2);
        int i11 = iArr[1];
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = this$0.f15319g;
        this$0.A(BadgeDrawable.TOP_START, width, i11 - (fKPopupWindowBubbleGuideView != null ? fKPopupWindowBubbleGuideView.getMeasuredHeight() : 0), 5);
    }

    public static final void E(FKLiveForStreamerBottomMenuLayout this$0) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        int i10 = R$id.muteImageButton;
        ((ImageView) this$0.g(i10)).getLocationInWindow(iArr);
        int width = (iArr[0] + (((ImageView) this$0.g(i10)).getWidth() / 2)) - (z0.h.l(this$0) / 2);
        int i11 = iArr[1];
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = this$0.f15319g;
        this$0.A(49, width, i11 - (fKPopupWindowBubbleGuideView != null ? fKPopupWindowBubbleGuideView.getMeasuredHeight() : 0), 2);
    }

    public final void A(int i10, int i11, int i12, int i13) {
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = this.f15319g;
        if (fKPopupWindowBubbleGuideView != null) {
            fKPopupWindowBubbleGuideView.e(this, i10, i11, i12, (r17 & 16) != 0 ? null : Integer.valueOf(i13), (r17 & 32) != 0 ? false : false, (r17 & 64) != 0 ? false : false);
        }
    }

    public final void B() {
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult != null ? s.d(fkLiveShowResult.getShowMultiPlayer(), Boolean.FALSE) : false) {
            return;
        }
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.Z0().c(), Boolean.TRUE)) {
            gVar.Z0().d(Boolean.FALSE);
            r(R$mipmap.multi_pk_guide);
            ((ImageView) g(R$id.pkImageButton)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.bottommenu.b
                @Override // java.lang.Runnable
                public final void run() {
                    FKLiveForStreamerBottomMenuLayout.C(FKLiveForStreamerBottomMenuLayout.this);
                }
            });
        }
    }

    public final void D() {
        p1.g gVar = p1.g.f52734a;
        Boolean c4 = gVar.b1().c();
        Boolean bool = Boolean.TRUE;
        if (s.d(c4, bool)) {
            return;
        }
        gVar.b1().d(bool);
        r(R$mipmap.icon_live_pk_mute_guide);
        ((ImageView) g(R$id.muteImageButton)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.bottommenu.a
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveForStreamerBottomMenuLayout.E(FKLiveForStreamerBottomMenuLayout.this);
            }
        });
    }

    public final void F(@NotNull LiveShowResult result) {
        s.i(result, "result");
        LiveMenuBtnModel magicRefine = result.getMagicRefine();
        boolean unread = magicRefine != null ? magicRefine.getUnread() : false;
        LiveMenuBtnModel giftWall = result.getGiftWall();
        boolean unread2 = giftWall != null ? giftWall.getUnread() : false;
        LiveMenuBtnModel stickerEntryInfo = result.getStickerEntryInfo();
        G(unread || unread2 || (stickerEntryInfo != null ? stickerEntryInfo.getUnread() : false));
    }

    public final void G(boolean z10) {
        g(R$id.more_img_red_dot_view).setVisibility(z10 ? 0 : 8);
    }

    public final void I() {
        int i10 = R$id.connectWebpImageView;
        ((FKWebpAnimationView) g(i10)).i();
        ((FKWebpAnimationView) g(i10)).setVisibility(8);
        ((ImageView) g(R$id.connectImageButton)).setVisibility(0);
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f15320h;
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

    public final void o() {
        ImageView pkImageButton = (ImageView) g(R$id.pkImageButton);
        s.h(pkImageButton, "pkImageButton");
        y.d(pkImageButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
            
                r0 = r1.this$0.f15316d;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r2) {
                /*
                    r1 = this;
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.this
                    boolean r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.k(r2)
                    if (r2 == 0) goto L21
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.this
                    com.cupidapp.live.liveshow.model.LivePkType r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.j(r2)
                    if (r2 == 0) goto L1b
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout r0 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.this
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$a r0 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.i(r0)
                    if (r0 == 0) goto L1b
                    r0.e(r2)
                L1b:
                    com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick$AnchorLiveShowRoom r2 = com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.AnchorLiveShowRoom.EndPk
                    r2.click()
                    goto L38
                L21:
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.this
                    r2.v()
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.this
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$a r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.i(r2)
                    if (r2 == 0) goto L31
                    r2.c()
                L31:
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout r2 = com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.this
                    com.irisdt.client.live.LiveProtos$Type r0 = com.irisdt.client.live.LiveProtos.Type.PK
                    com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.l(r2, r0)
                L38:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$1.invoke2(android.view.View):void");
            }
        });
        RelativeLayout connectLayout = (RelativeLayout) g(R$id.connectLayout);
        s.h(connectLayout, "connectLayout");
        y.d(connectLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$2
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
                FKLiveForStreamerBottomMenuLayout.a aVar;
                FKLiveForStreamerBottomMenuLayout.this.I();
                FKLiveForStreamerBottomMenuLayout.this.y(LiveProtos.Type.CONNECT);
                aVar = FKLiveForStreamerBottomMenuLayout.this.f15316d;
                if (aVar != null) {
                    aVar.f();
                }
            }
        });
        ImageView beautyImageButton = (ImageView) g(R$id.beautyImageButton);
        s.h(beautyImageButton, "beautyImageButton");
        y.d(beautyImageButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$3
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
                FKLiveForStreamerBottomMenuLayout.this.p();
            }
        });
        ImageView moreImageButton = (ImageView) g(R$id.moreImageButton);
        s.h(moreImageButton, "moreImageButton");
        y.d(moreImageButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$4
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
                FKLiveForStreamerBottomMenuLayout.a aVar;
                FKLiveForStreamerBottomMenuLayout.this.y(LiveProtos.Type.MORE);
                SensorsLogKeyButtonClick.AnchorLiveShowRoom.MoreOperation.click();
                aVar = FKLiveForStreamerBottomMenuLayout.this.f15316d;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        ImageView muteImageButton = (ImageView) g(R$id.muteImageButton);
        s.h(muteImageButton, "muteImageButton");
        y.d(muteImageButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$5
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
                FKLiveForStreamerBottomMenuLayout.a aVar;
                LiveShowModel pkLiveShow;
                FKLiveForStreamerBottomMenuLayout fKLiveForStreamerBottomMenuLayout = FKLiveForStreamerBottomMenuLayout.this;
                int i10 = R$id.muteImageButton;
                ((ImageView) fKLiveForStreamerBottomMenuLayout.g(i10)).setSelected(!((ImageView) FKLiveForStreamerBottomMenuLayout.this.g(i10)).isSelected());
                com.cupidapp.live.base.view.h.f12779a.r(FKLiveForStreamerBottomMenuLayout.this.getContext(), ((ImageView) FKLiveForStreamerBottomMenuLayout.this.g(i10)).isSelected() ? R$string.close_others_live_sound_for_actor : R$string.open_others_live_sound_for_actor);
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult != null && (pkLiveShow = fkLiveShowResult.getPkLiveShow()) != null) {
                    FKLiveUtil.f14913a.w(((ImageView) FKLiveForStreamerBottomMenuLayout.this.g(i10)).isSelected(), pkLiveShow.getStreamId());
                }
                aVar = FKLiveForStreamerBottomMenuLayout.this.f15316d;
                if (aVar != null) {
                    aVar.h(((ImageView) FKLiveForStreamerBottomMenuLayout.this.g(i10)).isSelected());
                }
            }
        });
        ImageView liveTaskButton = (ImageView) g(R$id.liveTaskButton);
        s.h(liveTaskButton, "liveTaskButton");
        y.d(liveTaskButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$6
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
                FKLiveForStreamerBottomMenuLayout.a aVar;
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel != null) {
                    SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), liveShowModel.getUser().userId(), LiveProtos.Type.ANCHOR_TASK, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
                }
                aVar = FKLiveForStreamerBottomMenuLayout.this.f15316d;
                if (aVar != null) {
                    aVar.g();
                }
            }
        });
        ImageView red_envelope_imageview = (ImageView) g(R$id.red_envelope_imageview);
        s.h(red_envelope_imageview, "red_envelope_imageview");
        y.d(red_envelope_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout$bindClickEvent$7
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
                FKLiveForStreamerBottomMenuLayout.a aVar;
                aVar = FKLiveForStreamerBottomMenuLayout.this.f15316d;
                if (aVar != null) {
                    aVar.b();
                }
                FKLiveForStreamerBottomMenuLayout.this.y(LiveProtos.Type.BOTTOM_RED_PACKET);
            }
        });
    }

    public final void p() {
        a aVar = this.f15316d;
        if (aVar != null) {
            aVar.d();
        }
        y(LiveProtos.Type.BEAUTY);
        SensorsLogKeyButtonClick.AnchorLiveShowRoom.BeautySwitch.click();
    }

    public final void q(int i10, boolean z10) {
        if (i10 == 0) {
            I();
            ((ImageView) g(R$id.connectImageButton)).setImageResource(R$mipmap.icon_live_connect_unselected_button);
            ((TextView) g(R$id.connectCountView)).setVisibility(8);
            return;
        }
        if (z10) {
            z();
        } else {
            I();
        }
        ((ImageView) g(R$id.connectImageButton)).setImageResource(R$mipmap.icon_live_connect_selected_button);
        int i11 = R$id.connectCountView;
        ((TextView) g(i11)).setVisibility(0);
        ((TextView) g(i11)).setText(String.valueOf(i10));
    }

    public final void r(int i10) {
        Context context = getContext();
        s.h(context, "context");
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = new FKPopupWindowBubbleGuideView(context);
        fKPopupWindowBubbleGuideView.c(new BubbleGuideModel(null, 0, Integer.valueOf(i10), 0, 11, null));
        this.f15319g = fKPopupWindowBubbleGuideView;
        fKPopupWindowBubbleGuideView.measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
    }

    public final void s(@Nullable LivePkIconModel livePkIconModel) {
        boolean z10 = livePkIconModel != null;
        ((ImageView) g(R$id.pkImageButton)).setVisibility(z10 ? 0 : 8);
        if (z10) {
            B();
        }
    }

    public final void setClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f15316d = listener;
    }

    public final void setConnectLayoutVisible(boolean z10) {
        ((RelativeLayout) g(R$id.connectLayout)).setVisibility(z10 ? 0 : 8);
    }

    public final void t(@NotNull LivePkType pkType, boolean z10) {
        s.i(pkType, "pkType");
        this.f15318f = z10 ? pkType : null;
        this.f15317e = z10;
        if (z10) {
            ((ImageView) g(R$id.pkImageButton)).setImageResource(R$mipmap.icon_hang_up);
        } else {
            ((ImageView) g(R$id.pkImageButton)).setImageResource(R$mipmap.icon_live_pk_button);
        }
        if (pkType == LivePkType.DoublePk) {
            ((ImageView) g(R$id.muteImageButton)).setVisibility(z10 ? 0 : 8);
            if (z10) {
                D();
                return;
            }
            return;
        }
        ((ImageView) g(R$id.muteImageButton)).setVisibility(8);
    }

    public final void u(boolean z10) {
        ImageView red_envelope_imageview = (ImageView) g(R$id.red_envelope_imageview);
        s.h(red_envelope_imageview, "red_envelope_imageview");
        red_envelope_imageview.setVisibility(z10 ? 0 : 8);
    }

    public final void v() {
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = this.f15319g;
        if (fKPopupWindowBubbleGuideView != null) {
            fKPopupWindowBubbleGuideView.g();
        }
        this.f15319g = null;
    }

    public final void w() {
        LiveMenuBtnModel stickerEntryInfo;
        LiveMenuBtnModel giftWall;
        LiveMenuBtnModel magicRefine;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
        boolean unread = (fkLiveShowResult == null || (magicRefine = fkLiveShowResult.getMagicRefine()) == null) ? false : magicRefine.getUnread();
        LiveShowResult fkLiveShowResult2 = fKLiveConstantsData.getFkLiveShowResult();
        boolean unread2 = (fkLiveShowResult2 == null || (giftWall = fkLiveShowResult2.getGiftWall()) == null) ? false : giftWall.getUnread();
        LiveShowResult fkLiveShowResult3 = fKLiveConstantsData.getFkLiveShowResult();
        G(unread || unread2 || ((fkLiveShowResult3 == null || (stickerEntryInfo = fkLiveShowResult3.getStickerEntryInfo()) == null) ? false : stickerEntryInfo.getUnread()));
    }

    public final void x() {
        z.a(this, R$layout.layout_live_show_for_streamer_bottom_menu, true);
        o();
    }

    public final void y(LiveProtos.Type type) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), liveShowModel.getUser().userId(), type, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        }
    }

    public final void z() {
        ((ImageView) g(R$id.connectImageButton)).setVisibility(8);
        int i10 = R$id.connectWebpImageView;
        ((FKWebpAnimationView) g(i10)).setVisibility(0);
        FKWebpAnimationView connectWebpImageView = (FKWebpAnimationView) g(i10);
        s.h(connectWebpImageView, "connectWebpImageView");
        FKWebpAnimationView.d(connectWebpImageView, "live_show_connect.webp", 0, null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForStreamerBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15320h = new LinkedHashMap();
        x();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForStreamerBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15320h = new LinkedHashMap();
        x();
    }
}
