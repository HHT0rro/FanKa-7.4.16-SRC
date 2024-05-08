package com.cupidapp.live.liveshow.view.bottommenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fanclub.model.FanClubStatus;
import com.cupidapp.live.liveshow.model.FKTurnTableModel;
import com.cupidapp.live.liveshow.model.LiveMenuBtnModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.QuickGiftModel;
import com.cupidapp.live.liveshow.model.SignInInfoModel;
import com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.google.android.material.badge.BadgeDrawable;
import com.irisdt.client.live.LiveProtos;
import com.irisdt.client.others.OthersProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.y;
import z0.z;

/* compiled from: FKLiveForViewerBottomMenuLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForViewerBottomMenuLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f15324d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKPointerDialog f15325e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f15326f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public QuickGiftModel f15327g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Disposable f15328h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15329i;

    /* compiled from: FKLiveForViewerBottomMenuLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f(int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForViewerBottomMenuLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15329i = new LinkedHashMap();
        t();
    }

    public static final void D(final FKLiveForViewerBottomMenuLayout this$0, String str) {
        s.i(this$0, "this$0");
        int i10 = R$id.more_menu_layout;
        ((RelativeLayout) this$0.i(i10)).getLocationInWindow(new int[2]);
        z(this$0, str, PointerPos.BOTTOM_RIGHT, 0, ((this$0.getHeight() - ((RelativeLayout) this$0.i(i10)).getHeight()) / 2) + ((RelativeLayout) this$0.i(i10)).getHeight(), BadgeDrawable.BOTTOM_END, null, 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$showRedEnvelopeGuide$1$1
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
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(fkLiveShowResult != null ? fkLiveShowResult.getRedPacketCreateUrl() : null, false, 2, null));
                FKLiveForViewerBottomMenuLayout.this.v();
                GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_RED_PACKET, null, null, 6, null);
            }
        }, 96, null);
    }

    public static final void F(final FKLiveForViewerBottomMenuLayout this$0, String str, final OthersProtos.Enum_type type) {
        s.i(this$0, "this$0");
        s.i(type, "$type");
        int[] iArr = new int[2];
        int i10 = R$id.turn_table_button;
        ((RelativeLayout) this$0.i(i10)).getLocationInWindow(iArr);
        z(this$0, str, PointerPos.BOTTOM_CENTER, (iArr[0] + (((RelativeLayout) this$0.i(i10)).getWidth() / 2)) - (z0.h.l(this$0) / 2), ((this$0.getHeight() - ((RelativeLayout) this$0.i(i10)).getHeight()) / 2) + ((RelativeLayout) this$0.i(i10)).getHeight(), 81, Integer.valueOf(z0.h.c(this$0, 120.0f)), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$showTurnTableGuide$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FKLiveForViewerBottomMenuLayout.this.u();
                GroupOthersLog.p(GroupOthersLog.f18702a, type, null, null, 6, null);
            }
        }, 64, null);
    }

    public static final void I(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void o(FKLiveForViewerBottomMenuLayout this$0, View view) {
        s.i(this$0, "this$0");
        this$0.x();
    }

    public static /* synthetic */ void z(FKLiveForViewerBottomMenuLayout fKLiveForViewerBottomMenuLayout, String str, PointerPos pointerPos, int i10, int i11, int i12, Integer num, int i13, Function0 function0, int i14, Object obj) {
        fKLiveForViewerBottomMenuLayout.y(str, pointerPos, i10, i11, i12, (i14 & 32) != 0 ? null : num, (i14 & 64) != 0 ? 5 : i13, (i14 & 128) != 0 ? null : function0);
    }

    public final void A(boolean z10) {
        View menu_red_dot_tips_view = i(R$id.menu_red_dot_tips_view);
        s.h(menu_red_dot_tips_view, "menu_red_dot_tips_view");
        menu_red_dot_tips_view.setVisibility(z10 ? 0 : 8);
    }

    public final void B(@NotNull LiveShowResult result) {
        s.i(result, "result");
        LiveMenuBtnModel magicRefine = result.getMagicRefine();
        boolean unread = magicRefine != null ? magicRefine.getUnread() : false;
        String redPacketHoverText = result.getRedPacketHoverText();
        boolean z10 = !(redPacketHoverText == null || redPacketHoverText.length() == 0);
        LiveMenuBtnModel dressUpStoreBtn = result.getDressUpStoreBtn();
        boolean unread2 = dressUpStoreBtn != null ? dressUpStoreBtn.getUnread() : false;
        LiveMenuBtnModel dressUpBtn = result.getDressUpBtn();
        boolean unread3 = dressUpBtn != null ? dressUpBtn.getUnread() : false;
        LiveMenuBtnModel liveNobility = result.getLiveNobility();
        boolean unread4 = liveNobility != null ? liveNobility.getUnread() : false;
        LiveMenuBtnModel giftWall = result.getGiftWall();
        boolean unread5 = giftWall != null ? giftWall.getUnread() : false;
        LiveMenuBtnModel streamFollowBtn = result.getStreamFollowBtn();
        boolean unread6 = streamFollowBtn != null ? streamFollowBtn.getUnread() : false;
        SignInInfoModel signInInfo = result.getSignInInfo();
        A(unread || z10 || unread2 || unread3 || unread4 || unread5 || unread6 || ((signInInfo != null ? signInInfo.getUnreadCount() : 0) > 0));
    }

    public final void C(@Nullable final String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        ((RelativeLayout) i(R$id.more_menu_layout)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.bottommenu.e
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveForViewerBottomMenuLayout.D(FKLiveForViewerBottomMenuLayout.this, str);
            }
        });
        GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_RED_PACKET, null, 2, null);
    }

    public final void E(final String str, boolean z10) {
        final OthersProtos.Enum_type enum_type;
        if (str == null || str.length() == 0) {
            return;
        }
        if (z10) {
            enum_type = OthersProtos.Enum_type.LUCK_DRAW_BUBBLE;
        } else {
            enum_type = OthersProtos.Enum_type.LUCK_DRAW_START_TIPS_BUBBLE;
        }
        ((RelativeLayout) i(R$id.turn_table_button)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.bottommenu.f
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveForViewerBottomMenuLayout.F(FKLiveForViewerBottomMenuLayout.this, str, enum_type);
            }
        });
        GroupOthersLog.r(GroupOthersLog.f18702a, enum_type, null, 2, null);
    }

    public final void G() {
        if (this.f15328h == null) {
            ((FKSVGAImageView) i(R$id.sendGiftButton)).s();
            Observable<Long> observeOn = Observable.interval(30L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$startGiftAnimationDisposable$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                    ((FKSVGAImageView) FKLiveForViewerBottomMenuLayout.this.i(R$id.sendGiftButton)).s();
                }
            };
            this.f15328h = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.liveshow.view.bottommenu.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    FKLiveForViewerBottomMenuLayout.I(Function1.this, obj);
                }
            });
        }
    }

    public final void J() {
        Disposable disposable = this.f15328h;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f15328h = null;
    }

    @Nullable
    public final String getEnterSource() {
        return this.f15326f;
    }

    @Nullable
    public View i(int i10) {
        Map<Integer, View> map = this.f15329i;
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

    public final void m() {
        TextView startCommentButton = (TextView) i(R$id.startCommentButton);
        s.h(startCommentButton, "startCommentButton");
        y.d(startCommentButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$bindClickEvent$1
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
                FKLiveForViewerBottomMenuLayout.a aVar;
                FKLiveForViewerBottomMenuLayout.this.w(LiveProtos.Type.COMMENT);
                aVar = FKLiveForViewerBottomMenuLayout.this.f15324d;
                if (aVar != null) {
                    aVar.e();
                }
            }
        });
        View send_gift_click_view = i(R$id.send_gift_click_view);
        s.h(send_gift_click_view, "send_gift_click_view");
        y.d(send_gift_click_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$bindClickEvent$2
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
                FKLiveForViewerBottomMenuLayout.a aVar;
                FKLiveForViewerBottomMenuLayout.this.w(LiveProtos.Type.GIFT);
                SensorsLogKeyButtonClick.LiveShowRoom.SendGift.click();
                aVar = FKLiveForViewerBottomMenuLayout.this.f15324d;
                if (aVar != null) {
                    aVar.d();
                }
            }
        });
        ImageLoaderView liveRechargePackageButton = (ImageLoaderView) i(R$id.liveRechargePackageButton);
        s.h(liveRechargePackageButton, "liveRechargePackageButton");
        y.d(liveRechargePackageButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$bindClickEvent$3
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
                FKLiveForViewerBottomMenuLayout.a aVar;
                aVar = FKLiveForViewerBottomMenuLayout.this.f15324d;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
        RelativeLayout more_menu_layout = (RelativeLayout) i(R$id.more_menu_layout);
        s.h(more_menu_layout, "more_menu_layout");
        y.d(more_menu_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$bindClickEvent$4
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
                FKLiveForViewerBottomMenuLayout.a aVar;
                aVar = FKLiveForViewerBottomMenuLayout.this.f15324d;
                if (aVar != null) {
                    aVar.a();
                }
                FKLiveForViewerBottomMenuLayout.this.s();
            }
        });
        RelativeLayout turn_table_button = (RelativeLayout) i(R$id.turn_table_button);
        s.h(turn_table_button, "turn_table_button");
        y.d(turn_table_button, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$bindClickEvent$5
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
                FKLiveForViewerBottomMenuLayout.this.w(LiveProtos.Type.LUCK_DRAW);
                FKLiveForViewerBottomMenuLayout.this.u();
            }
        });
        RelativeLayout fanClubButton = (RelativeLayout) i(R$id.fanClubButton);
        s.h(fanClubButton, "fanClubButton");
        y.d(fanClubButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$bindClickEvent$6
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
                FKLiveForViewerBottomMenuLayout.a aVar;
                SensorsLogKeyButtonClick.LiveShowRoom.FanClub.click();
                FKLiveForViewerBottomMenuLayout.this.w(LiveProtos.Type.FANS_GROUP);
                aVar = FKLiveForViewerBottomMenuLayout.this.f15324d;
                if (aVar != null) {
                    aVar.c();
                }
            }
        });
        ((ImageLoaderView) i(R$id.quick_gift_img)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.liveshow.view.bottommenu.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FKLiveForViewerBottomMenuLayout.o(FKLiveForViewerBottomMenuLayout.this, view);
            }
        });
    }

    public final void p(@Nullable FKTurnTableModel fKTurnTableModel) {
        if (fKTurnTableModel != null && fKTurnTableModel.getCrit()) {
            ((ImageLoaderView) i(R$id.turn_table_image)).setVisibility(8);
            ((RelativeLayout) i(R$id.critical_hit_button)).setVisibility(0);
            ImageLoaderView critical_hit_gift_view = (ImageLoaderView) i(R$id.critical_hit_gift_view);
            s.h(critical_hit_gift_view, "critical_hit_gift_view");
            ImageLoaderView.g(critical_hit_gift_view, fKTurnTableModel.getCritIconImage(), null, null, 6, null);
            return;
        }
        int i10 = R$id.turn_table_image;
        ((ImageLoaderView) i(i10)).setVisibility(0);
        ((RelativeLayout) i(R$id.critical_hit_button)).setVisibility(8);
        ImageLoaderView turn_table_image = (ImageLoaderView) i(i10);
        s.h(turn_table_image, "turn_table_image");
        ImageLoaderView.g(turn_table_image, fKTurnTableModel != null ? fKTurnTableModel.getIconImage() : null, null, null, 6, null);
    }

    public final void q(@Nullable QuickGiftModel quickGiftModel) {
        this.f15327g = quickGiftModel;
        if (quickGiftModel == null) {
            ((FrameLayout) i(R$id.quick_gift_layout)).setVisibility(8);
            return;
        }
        ((FrameLayout) i(R$id.quick_gift_layout)).setVisibility(0);
        ImageLoaderView quick_gift_img = (ImageLoaderView) i(R$id.quick_gift_img);
        s.h(quick_gift_img, "quick_gift_img");
        ImageLoaderView.g(quick_gift_img, quickGiftModel.getGift().getImage(), null, null, 6, null);
    }

    public final void r(@Nullable FKTurnTableModel fKTurnTableModel, boolean z10, int i10) {
        if (fKTurnTableModel == null) {
            ((RelativeLayout) i(R$id.turn_table_button)).setVisibility(8);
            if (z10) {
                ((RelativeLayout) i(R$id.fanClubButton)).setVisibility(0);
                setFanClubBtnStatus(i10);
                return;
            } else {
                ((RelativeLayout) i(R$id.fanClubButton)).setVisibility(8);
                return;
            }
        }
        ((RelativeLayout) i(R$id.fanClubButton)).setVisibility(8);
        ((RelativeLayout) i(R$id.turn_table_button)).setVisibility(0);
        p(fKTurnTableModel);
        if (fKTurnTableModel.getUnread()) {
            i(R$id.turn_table_tips_view).setVisibility(0);
            GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.LUCK_DRAW_RED_DOT, null, 2, null);
        } else {
            i(R$id.turn_table_tips_view).setVisibility(8);
        }
        E(fKTurnTableModel.getHoverText(), fKTurnTableModel.getUnread());
    }

    public final void s() {
        SignInInfoModel signInInfo;
        LiveMenuBtnModel streamFollowBtn;
        LiveMenuBtnModel giftWall;
        LiveMenuBtnModel liveNobility;
        LiveMenuBtnModel dressUpBtn;
        LiveMenuBtnModel dressUpStoreBtn;
        LiveMenuBtnModel magicRefine;
        View menu_red_dot_tips_view = i(R$id.menu_red_dot_tips_view);
        s.h(menu_red_dot_tips_view, "menu_red_dot_tips_view");
        boolean z10 = true;
        if (menu_red_dot_tips_view.getVisibility() == 0) {
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
            boolean unread = (fkLiveShowResult == null || (magicRefine = fkLiveShowResult.getMagicRefine()) == null) ? false : magicRefine.getUnread();
            LiveShowResult fkLiveShowResult2 = fKLiveConstantsData.getFkLiveShowResult();
            boolean unread2 = (fkLiveShowResult2 == null || (dressUpStoreBtn = fkLiveShowResult2.getDressUpStoreBtn()) == null) ? false : dressUpStoreBtn.getUnread();
            LiveShowResult fkLiveShowResult3 = fKLiveConstantsData.getFkLiveShowResult();
            boolean unread3 = (fkLiveShowResult3 == null || (dressUpBtn = fkLiveShowResult3.getDressUpBtn()) == null) ? false : dressUpBtn.getUnread();
            LiveShowResult fkLiveShowResult4 = fKLiveConstantsData.getFkLiveShowResult();
            boolean unread4 = (fkLiveShowResult4 == null || (liveNobility = fkLiveShowResult4.getLiveNobility()) == null) ? false : liveNobility.getUnread();
            LiveShowResult fkLiveShowResult5 = fKLiveConstantsData.getFkLiveShowResult();
            boolean unread5 = (fkLiveShowResult5 == null || (giftWall = fkLiveShowResult5.getGiftWall()) == null) ? false : giftWall.getUnread();
            LiveShowResult fkLiveShowResult6 = fKLiveConstantsData.getFkLiveShowResult();
            boolean unread6 = (fkLiveShowResult6 == null || (streamFollowBtn = fkLiveShowResult6.getStreamFollowBtn()) == null) ? false : streamFollowBtn.getUnread();
            LiveShowResult fkLiveShowResult7 = fKLiveConstantsData.getFkLiveShowResult();
            boolean z11 = ((fkLiveShowResult7 == null || (signInInfo = fkLiveShowResult7.getSignInInfo()) == null) ? 0 : signInInfo.getUnreadCount()) > 0;
            if (!unread && !unread2 && !unread3 && !unread4 && !unread5 && !unread6 && !z11) {
                z10 = false;
            }
            A(z10);
        }
    }

    public final void setClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f15324d = listener;
    }

    public final void setEnterSource(@Nullable String str) {
        this.f15326f = str;
    }

    public final void setFanClubBtnStatus(int i10) {
        if (((RelativeLayout) i(R$id.fanClubButton)).getVisibility() != 0) {
            return;
        }
        if (i10 == FanClubStatus.HasJoined.getStatus()) {
            ((TextView) i(R$id.funClubTextView)).setVisibility(8);
            return;
        }
        boolean z10 = true;
        if (i10 != FanClubStatus.NotJoined.getStatus() && i10 != FanClubStatus.Exited.getStatus()) {
            z10 = false;
        }
        if (z10) {
            int i11 = R$id.funClubTextView;
            ((TextView) i(i11)).setVisibility(0);
            ((TextView) i(i11)).setText(getContext().getString(R$string.join_in));
        } else if (i10 == FanClubStatus.Expired.getStatus()) {
            int i12 = R$id.funClubTextView;
            ((TextView) i(i12)).setVisibility(0);
            ((TextView) i(i12)).setText(getContext().getString(R$string.fan_club_expired));
        }
    }

    public final void setLiveRechargePackageButtonVisible(@Nullable ImageModel imageModel) {
        if (imageModel == null) {
            ((ImageLoaderView) i(R$id.liveRechargePackageButton)).setVisibility(8);
            return;
        }
        int i10 = R$id.liveRechargePackageButton;
        ((ImageLoaderView) i(i10)).setVisibility(0);
        ImageLoaderView liveRechargePackageButton = (ImageLoaderView) i(i10);
        s.h(liveRechargePackageButton, "liveRechargePackageButton");
        ImageLoaderView.g(liveRechargePackageButton, imageModel, null, null, 6, null);
    }

    public final void t() {
        z.a(this, R$layout.layout_liveshow_for_viewer_bottom_menu, true);
        ((TextView) i(R$id.startCommentButton)).getPaint().setFakeBoldText(true);
        ((TextView) i(R$id.critical_hit_time_view)).getPaint().setFakeBoldText(true);
        m();
    }

    public final void u() {
        FKTurnTableModel lotteryBtn;
        int i10 = R$id.turn_table_tips_view;
        if (i(i10).getVisibility() == 0) {
            i(i10).setVisibility(8);
            GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.LUCK_DRAW_RED_DOT, null, null, 6, null);
        }
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        EventBus.c().l(new FKLiveOpenWebFragmentEvent((fkLiveShowResult == null || (lotteryBtn = fkLiveShowResult.getLotteryBtn()) == null) ? null : lotteryBtn.getUrl(), false, 2, null));
    }

    public final void v() {
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        String redPacketHoverText = fkLiveShowResult != null ? fkLiveShowResult.getRedPacketHoverText() : null;
        if (redPacketHoverText == null || redPacketHoverText.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().F0().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$redPacketClick$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FKLiveForViewerBottomMenuLayout.this.s();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$redPacketClick$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void w(LiveProtos.Type type) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), liveShowModel.getUser().userId(), type, (r13 & 8) != 0 ? null : this.f15326f, (r13 & 16) != 0 ? null : null);
        }
    }

    public final void x() {
        int[] iArr = new int[2];
        int i10 = R$id.quick_gift_img;
        ((ImageLoaderView) i(i10)).getLocationInWindow(iArr);
        int width = iArr[0] + (((ImageLoaderView) i(i10)).getWidth() / 2);
        a aVar = this.f15324d;
        if (aVar != null) {
            aVar.f(width);
        }
    }

    public final void y(String str, PointerPos pointerPos, int i10, int i11, int i12, Integer num, int i13, final Function0<p> function0) {
        FKPointerDialog.a aVar = FKPointerDialog.f12718p;
        Context context = getContext();
        s.h(context, "context");
        FKPointerDialog p10 = aVar.a(context).j(Float.valueOf(0.0f)).n(t.a(str, -49088)).q(pointerPos, BgColor.DEFAULT).p(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout$showBubbleGuide$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        }, true);
        this.f15325e = p10;
        if (p10 != null) {
            FKPointerDialog.t(p10, i10, i11, num, i12, i13, null, 32, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForViewerBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15329i = new LinkedHashMap();
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForViewerBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15329i = new LinkedHashMap();
        t();
    }
}
