package com.cupidapp.live.liveshow.pk.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.LivePkChatConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkEndConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkUpdateConnectorMessage;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.activity.FKLiveCloseWebFragmentEvent;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LivePkingInfoModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowPkWarResult;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.view.miniprofile.FollowActorEvent;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.v;
import z0.x;
import z0.y;
import z0.z;

/* compiled from: FKLivePkWarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkWarLayout extends BaseLayout {

    /* renamed from: o */
    @NotNull
    public static final a f15162o = new a(null);

    /* renamed from: d */
    public float f15163d;

    /* renamed from: e */
    public float f15164e;

    /* renamed from: f */
    @NotNull
    public final com.cupidapp.live.base.utils.i f15165f;

    /* renamed from: g */
    @Nullable
    public c f15166g;

    /* renamed from: h */
    public int f15167h;

    /* renamed from: i */
    @Nullable
    public Runnable f15168i;

    /* renamed from: j */
    @Nullable
    public SensorsLogLiveShow.LivePkResult f15169j;

    /* renamed from: k */
    @Nullable
    public Long f15170k;

    /* renamed from: l */
    public boolean f15171l;

    /* renamed from: m */
    @Nullable
    public ObjectAnimator f15172m;

    /* renamed from: n */
    @NotNull
    public Map<Integer, View> f15173n;

    /* compiled from: FKLivePkWarLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FKLivePkWarLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15174a;

        static {
            int[] iArr = new int[FKLivePkStatus.values().length];
            try {
                iArr[FKLivePkStatus.LivePkInProgress.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKLivePkStatus.LivePkInteractive.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15174a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkWarLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15173n = new LinkedHashMap();
        this.f15165f = new com.cupidapp.live.base.utils.i();
        W();
    }

    public static /* synthetic */ void N(FKLivePkWarLayout fKLivePkWarLayout, List list, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        fKLivePkWarLayout.M(list, str, str2, z10);
    }

    public static final void l0(FKLivePkWarLayout this$0) {
        s.i(this$0, "this$0");
        ((LinearLayout) this$0.g(R$id.clickGuideLayout)).setVisibility(8);
    }

    public static final void x0(FKLivePkWarLayout this$0) {
        s.i(this$0, "this$0");
        c cVar = this$0.f15166g;
        if (cVar != null) {
            int i10 = R$id.leftPkActorTextureView;
            cVar.a(((TextureView) this$0.g(i10)).getWidth(), ((TextureView) this$0.g(i10)).getHeight());
        }
    }

    public final void A0(String str, boolean z10) {
        if (!z10) {
            FKLiveUtil.f14913a.t(3);
        }
        FKLiveUtil.J(FKLiveUtil.f14913a, str, false, 2, null);
        setVisibility(8);
        c cVar = this.f15166g;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void B0(boolean z10) {
        String itemId;
        Observable<Result<Object>> t02;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        String e2 = FKLiveGrpcEntity.f14907e.a().e();
        if (z10) {
            t02 = NetworkClient.f11868a.r().j0(e2, itemId);
        } else {
            t02 = NetworkClient.f11868a.r().t0(e2, itemId);
        }
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = t02.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$streamerClickEndButton$$inlined$handleByContext$default$1
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
                FKLivePkWarLayout.this.R(false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void C(boolean z10) {
        if (z10) {
            int i10 = R$id.progressContainerLayout;
            ((ConstraintLayout) g(i10)).getLocationInWindow(new int[2]);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ConstraintLayout) g(i10), (Property<ConstraintLayout, Float>) View.TRANSLATION_Y, 0.0f, ((z0.h.k(this) + z0.h.m(getContext())) - z0.h.c(this, 408.0f)) - (r1[1] + z0.h.c(this, 64.0f)));
            ofFloat.setStartDelay(150L);
            ofFloat.setDuration(100L);
            this.f15172m = ofFloat;
            ofFloat.start();
            return;
        }
        ObjectAnimator objectAnimator = this.f15172m;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f15172m = null;
        ((ConstraintLayout) g(R$id.progressContainerLayout)).setTranslationY(0.0f);
    }

    public final void D(final String str) {
        x2.a N = NetworkClient.f11868a.N();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        Disposable disposed = a.C0836a.o(N, str, null, liveShowModel != null ? liveShowModel.getItemId() : null, FollowPrefer.LiveShow.getValue(), 0, null, null, null, 242, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$alohaOthers$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2634invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2634invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                GroupSocialLog.f18708a.B(true, SensorScene.Live.getValue(), String.this, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult2.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
                this.r0(swipeCardUserLikeResult2.getUser().getAloha());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void E(@NotNull LiveShowModel leftLiveModel, @NotNull LiveShowModel rightLiveModel, @Nullable Map<String, ? extends List<User>> map, @Nullable String str, boolean z10, boolean z11, boolean z12) {
        s.i(leftLiveModel, "leftLiveModel");
        s.i(rightLiveModel, "rightLiveModel");
        LivePkingInfoModel pkingInfo = leftLiveModel.getPkingInfo();
        if (pkingInfo != null) {
            FKLiveGrpcEntity.a aVar = FKLiveGrpcEntity.f14907e;
            aVar.a().t(pkingInfo.getChatting() ? FKLivePkStatus.LivePkInteractive : FKLivePkStatus.LivePkInProgress);
            aVar.a().s(pkingInfo.getMatchId());
        }
        LivePkingInfoModel pkingInfo2 = leftLiveModel.getPkingInfo();
        Float valueOf = pkingInfo2 != null ? Float.valueOf(pkingInfo2.getCredit()) : null;
        LivePkingInfoModel pkingInfo3 = rightLiveModel.getPkingInfo();
        L(valueOf, pkingInfo3 != null ? Float.valueOf(pkingInfo3.getCredit()) : null, true);
        LivePkingInfoModel pkingInfo4 = leftLiveModel.getPkingInfo();
        if (pkingInfo4 != null) {
            if (z10 && !pkingInfo4.getChatting() && pkingInfo4.getCountdownMillis() / 1000 >= 8) {
                z0(z12);
            }
            y0(pkingInfo4.getChatting(), pkingInfo4.getCountdownMillis());
        }
        P(rightLiveModel.getUser(), z11);
        LivePkingInfoModel pkingInfo5 = leftLiveModel.getPkingInfo();
        N(this, pkingInfo5 != null ? pkingInfo5.getWinnerLiveShowIds() : null, leftLiveModel.getItemId(), rightLiveModel.getItemId(), false, 8, null);
        G(map);
        I(str, z11);
        k0(z11);
    }

    public final void G(Map<String, ? extends List<User>> map) {
        String itemId;
        LiveShowModel pkLiveShowModel;
        String itemId2;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || (pkLiveShowModel = fKLiveConstantsData.getPkLiveShowModel()) == null || (itemId2 = pkLiveShowModel.getItemId()) == null) {
            return;
        }
        LinearLayout leftTopListLayout = (LinearLayout) g(R$id.leftTopListLayout);
        s.h(leftTopListLayout, "leftTopListLayout");
        J(leftTopListLayout, map != null ? map.get(itemId) : null, true);
        LinearLayout rightTopListLayout = (LinearLayout) g(R$id.rightTopListLayout);
        s.h(rightTopListLayout, "rightTopListLayout");
        J(rightTopListLayout, map != null ? map.get(itemId2) : null, false);
    }

    public final void I(String str, boolean z10) {
        FKLiveConstantsData fKLiveConstantsData;
        LiveShowModel liveShowModel;
        String itemId;
        LiveShowModel pkLiveShowModel;
        String itemId2;
        LiveShowModel liveShowModel2;
        LivePkingInfoModel pkingInfo;
        String matchId;
        if (str == null || (liveShowModel = (fKLiveConstantsData = FKLiveConstantsData.INSTANCE).getLiveShowModel()) == null || (itemId = liveShowModel.getItemId()) == null || (pkLiveShowModel = fKLiveConstantsData.getPkLiveShowModel()) == null || (itemId2 = pkLiveShowModel.getItemId()) == null || (liveShowModel2 = fKLiveConstantsData.getLiveShowModel()) == null || (pkingInfo = liveShowModel2.getPkingInfo()) == null || (matchId = pkingInfo.getMatchId()) == null) {
            return;
        }
        LinearLayout leftTopListLayout = (LinearLayout) g(R$id.leftTopListLayout);
        s.h(leftTopListLayout, "leftTopListLayout");
        K(leftTopListLayout, str, itemId, matchId, z10, true);
        LinearLayout rightTopListLayout = (LinearLayout) g(R$id.rightTopListLayout);
        s.h(rightTopListLayout, "rightTopListLayout");
        K(rightTopListLayout, str, itemId2, matchId, z10, false);
    }

    public final void J(LinearLayout linearLayout, List<User> list, boolean z10) {
        User user;
        linearLayout.removeAllViews();
        for (int i10 = 0; i10 < 3; i10++) {
            ImageModel avatarImage = (list == null || (user = (User) CollectionsKt___CollectionsKt.W(list, i10)) == null) ? null : user.getAvatarImage();
            Context context = getContext();
            s.h(context, "context");
            FKLivePkSofaItemView fKLivePkSofaItemView = new FKLivePkSofaItemView(context);
            fKLivePkSofaItemView.b(avatarImage, z10, i10);
            if (z10) {
                linearLayout.addView(fKLivePkSofaItemView, 0);
            } else {
                linearLayout.addView(fKLivePkSofaItemView);
            }
        }
    }

    public final void K(LinearLayout linearLayout, final String str, final String str2, final String str3, boolean z10, boolean z11) {
        final int i10 = z10 ? z11 ? 3 : 4 : z11 ? 1 : 2;
        y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$configLiveTopListClick$1
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
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(x.a(x.a(x.a(String.this, "liveShowId", str2), "matchId", str3), "flag", String.valueOf(i10)), false, 2, null));
            }
        });
    }

    public final void L(Float f10, Float f11, boolean z10) {
        if (z10) {
            this.f15163d = 0.0f;
            this.f15164e = 0.0f;
        }
        if (f10 != null && f10.floatValue() >= this.f15163d) {
            this.f15163d = f10.floatValue();
        }
        if (f11 != null && f11.floatValue() >= this.f15164e) {
            this.f15164e = f11.floatValue();
        }
        ((TextView) g(R$id.leftGiftCountTextView)).setText(String.valueOf(this.f15163d));
        ((TextView) g(R$id.rightGiftCountTextView)).setText(String.valueOf(this.f15164e));
        float f12 = this.f15163d;
        float f13 = (f12 / (this.f15164e + f12)) * 100;
        if (Float.isNaN(f13)) {
            f13 = 50.0f;
        }
        int l10 = (int) ((f13 / 100.0f) * (z0.h.l(this) - z0.h.c(this, 4.0f)));
        int l11 = (z0.h.l(this) - z0.h.c(this, 4.0f)) - l10;
        ProgressBar leftLivePkProgressBar = (ProgressBar) g(R$id.leftLivePkProgressBar);
        s.h(leftLivePkProgressBar, "leftLivePkProgressBar");
        y.o(leftLivePkProgressBar, Integer.valueOf(l10), null, 2, null);
        ProgressBar rightLivePkProgressBar = (ProgressBar) g(R$id.rightLivePkProgressBar);
        s.h(rightLivePkProgressBar, "rightLivePkProgressBar");
        y.o(rightLivePkProgressBar, Integer.valueOf(l11), null, 2, null);
    }

    public final void M(List<String> list, String str, String str2, boolean z10) {
        boolean contains = list != null ? list.contains(str) : false;
        boolean contains2 = list != null ? list.contains(str2) : false;
        if (!(list == null || list.isEmpty())) {
            ((LinearLayout) g(R$id.rightPkActorInfoLayout)).setVisibility(8);
        }
        if (contains && contains2) {
            ImageView leftPkActorWinnerImageView = (ImageView) g(R$id.leftPkActorWinnerImageView);
            s.h(leftPkActorWinnerImageView, "leftPkActorWinnerImageView");
            h0(leftPkActorWinnerImageView, R$mipmap.icon_live_pk_draw);
            ImageView rightPkActorWinnerImageView = (ImageView) g(R$id.rightPkActorWinnerImageView);
            s.h(rightPkActorWinnerImageView, "rightPkActorWinnerImageView");
            h0(rightPkActorWinnerImageView, R$mipmap.icon_live_pk_draw);
            return;
        }
        if (contains) {
            if (z10) {
                c cVar = this.f15166g;
                if (cVar != null) {
                    cVar.b(true);
                    return;
                }
                return;
            }
            O(true);
            return;
        }
        if (!contains2) {
            ((ImageView) g(R$id.leftPkActorWinnerImageView)).setVisibility(8);
            ((ImageView) g(R$id.rightPkActorWinnerImageView)).setVisibility(8);
        } else {
            if (z10) {
                c cVar2 = this.f15166g;
                if (cVar2 != null) {
                    cVar2.b(false);
                    return;
                }
                return;
            }
            O(false);
        }
    }

    public final void O(boolean z10) {
        if (z10) {
            ImageView leftPkActorWinnerImageView = (ImageView) g(R$id.leftPkActorWinnerImageView);
            s.h(leftPkActorWinnerImageView, "leftPkActorWinnerImageView");
            h0(leftPkActorWinnerImageView, R$mipmap.icon_live_pk_left_win);
            ImageView rightPkActorWinnerImageView = (ImageView) g(R$id.rightPkActorWinnerImageView);
            s.h(rightPkActorWinnerImageView, "rightPkActorWinnerImageView");
            h0(rightPkActorWinnerImageView, R$mipmap.icon_live_pk_fail);
            return;
        }
        ImageView leftPkActorWinnerImageView2 = (ImageView) g(R$id.leftPkActorWinnerImageView);
        s.h(leftPkActorWinnerImageView2, "leftPkActorWinnerImageView");
        h0(leftPkActorWinnerImageView2, R$mipmap.icon_live_pk_fail);
        ImageView rightPkActorWinnerImageView2 = (ImageView) g(R$id.rightPkActorWinnerImageView);
        s.h(rightPkActorWinnerImageView2, "rightPkActorWinnerImageView");
        h0(rightPkActorWinnerImageView2, R$mipmap.icon_live_pk_right_win);
    }

    public final void P(final User user, final boolean z10) {
        ImageLoaderView rightPkActorAvatarView = (ImageLoaderView) g(R$id.rightPkActorAvatarView);
        s.h(rightPkActorAvatarView, "rightPkActorAvatarView");
        ImageLoaderView.g(rightPkActorAvatarView, user.getAvatarImage(), null, null, 6, null);
        ((TextView) g(R$id.rightPkActorNameTextView)).setText(user.getName());
        r0(user.getAloha());
        LinearLayout rightPkActorInfoLayout = (LinearLayout) g(R$id.rightPkActorInfoLayout);
        s.h(rightPkActorInfoLayout, "rightPkActorInfoLayout");
        y.d(rightPkActorInfoLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$configRightPkActorInfo$1
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
                FKLivePkWarLayout.this.q0(user);
            }
        });
        RoundedFrameLayout rightPkRoundLayout = (RoundedFrameLayout) g(R$id.rightPkRoundLayout);
        s.h(rightPkRoundLayout, "rightPkRoundLayout");
        y.d(rightPkRoundLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$configRightPkActorInfo$2
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
                if (z10) {
                    this.j0();
                } else {
                    this.q0(user);
                }
            }
        });
        TextView alohaButton = (TextView) g(R$id.alohaButton);
        s.h(alohaButton, "alohaButton");
        y.d(alohaButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$configRightPkActorInfo$3
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
                FKLivePkWarLayout.this.D(user.userId());
            }
        });
    }

    public final void Q(boolean z10, boolean z11, @Nullable com.cupidapp.live.liveshow.entity.c cVar) {
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult != null) {
            if (z10) {
                String streamId = fkLiveShowResult.getLiveShow().getStreamId();
                LiveShowModel pkLiveShow = fkLiveShowResult.getPkLiveShow();
                w0(streamId, pkLiveShow != null ? pkLiveShow.getStreamId() : null, z11, cVar);
            } else {
                LiveShowModel pkLiveShow2 = fkLiveShowResult.getPkLiveShow();
                A0(pkLiveShow2 != null ? pkLiveShow2.getStreamId() : null, z11);
            }
        }
    }

    public final void R(boolean z10) {
        this.f15165f.g();
        Q(false, z10, null);
        b0();
    }

    public final void S() {
        LiveShowModel pkLiveShowModel = FKLiveConstantsData.INSTANCE.getPkLiveShowModel();
        if (pkLiveShowModel != null) {
            Context context = getContext();
            FKLiveForViewerActivity fKLiveForViewerActivity = context instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) context : null;
            if (fKLiveForViewerActivity != null) {
                fKLiveForViewerActivity.T1();
            }
            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, getContext(), new FKLiveForViewerViewModel(pkLiveShowModel, null, new LiveInRoomSensorModel(null, null, SensorScene.Live, SensorPosition.LiveShowRoom, null, null, 48, null), true), false, 4, null);
        }
    }

    public final void T() {
        int i10 = b.f15174a[FKLiveGrpcEntity.f14907e.a().f().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            o0();
        } else if (this.f15167h >= 3) {
            n0();
        } else {
            s0();
        }
    }

    @Nullable
    public final SensorsLogLiveShow.LivePkResult U(@Nullable List<String> list) {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
        LiveShowModel pkLiveShowModel = fKLiveConstantsData.getPkLiveShowModel();
        String itemId2 = pkLiveShowModel != null ? pkLiveShowModel.getItemId() : null;
        boolean L = list != null ? CollectionsKt___CollectionsKt.L(list, itemId) : false;
        boolean L2 = list != null ? CollectionsKt___CollectionsKt.L(list, itemId2) : false;
        if (L && L2) {
            this.f15169j = SensorsLogLiveShow.LivePkResult.LivePkDraw;
        } else if (L) {
            this.f15169j = SensorsLogLiveShow.LivePkResult.LivePkWin;
        } else if (L2) {
            this.f15169j = SensorsLogLiveShow.LivePkResult.LivePkFailed;
        }
        return this.f15169j;
    }

    public final void V(@Nullable String str) {
        if (str == null) {
            return;
        }
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (s.d(str, liveShowModel != null ? liveShowModel.getStreamId() : null)) {
            ((ImageView) g(R$id.leftNoPicturePrompt)).setVisibility(8);
            return;
        }
        LiveShowModel pkLiveShowModel = fKLiveConstantsData.getPkLiveShowModel();
        if (s.d(str, pkLiveShowModel != null ? pkLiveShowModel.getStreamId() : null)) {
            ((ImageView) g(R$id.rightNoPicturePrompt)).setVisibility(8);
        }
    }

    public final void W() {
        z.a(this, R$layout.layout_live_pk_war, true);
        setVisibility(8);
        float c4 = z0.h.c(this, 20.0f);
        ((RoundedFrameLayout) g(R$id.leftPkRoundLayout)).setCornerRadius(c4);
        ((RoundedFrameLayout) g(R$id.rightPkRoundLayout)).setCornerRadius(c4);
        ((RoundedFrameLayout) g(R$id.pk_progress_container)).setCornerRadius(z0.h.c(this, 6.0f));
        ((TextureView) g(R$id.leftPkActorTextureView)).getLayoutParams().height = (int) ((z0.h.l(this) / 2.0f) * 1.5555556f);
    }

    public final void X(@NotNull final LivePkChatConnectorMessage messageModel, final boolean z10) {
        s.i(messageModel, "messageModel");
        FKLiveGrpcEntity.f14907e.a().h(FKLivePkStatus.LivePkInteractive, messageModel.getEntity().getMatchId(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$livePkChatConnector$1
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
                FKLivePkWarLayout.this.u0(z10);
                FKLivePkWarLayout.this.M(messageModel.getEntity().getWinnerLiveShowIds(), messageModel.getLiveShowId(), messageModel.getEntity().getPkLiveShowId(), true);
                ((TextView) FKLivePkWarLayout.this.g(R$id.livePkCountDownTimerView)).setText(FKLivePkWarLayout.this.getContext().getString(R$string.interacting));
                FKLivePkWarLayout.this.f15170k = Long.valueOf(System.currentTimeMillis());
                FKLivePkWarLayout.this.f0();
                FKLivePkWarLayout.this.d0();
            }
        });
    }

    public final void Y(final boolean z10, @NotNull LivePkEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveGrpcEntity.f14907e.a().h(FKLivePkStatus.LivePkEnd, messageModel.getEntity().getMatchId(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$livePkEndConnector$1
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
                FKLivePkWarLayout.this.R(z10);
                FKLiveGrpcEntity.f14907e.a().q();
            }
        });
    }

    public final void Z(@NotNull LiveShowPkWarResult pkResult, boolean z10, @Nullable com.cupidapp.live.liveshow.entity.c cVar) {
        LiveShowModel pkLiveShow;
        s.i(pkResult, "pkResult");
        this.f15167h = pkResult.getPkTodayHangupCount();
        EventBus.c().l(new FKLiveCloseWebFragmentEvent());
        ((ImageView) g(R$id.leftNoPicturePrompt)).setVisibility(8);
        Q(true, z10, cVar);
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult == null || (pkLiveShow = fkLiveShowResult.getPkLiveShow()) == null) {
            return;
        }
        E(fkLiveShowResult.getLiveShow(), pkLiveShow, pkResult.getSofa(), pkResult.getPkContributionPath(), true, z10, true);
    }

    public final void a0(@NotNull LivePkUpdateConnectorMessage messageModel) {
        LiveShowModel pkLiveShow;
        s.i(messageModel, "messageModel");
        FKLiveGrpcEntity.a aVar = FKLiveGrpcEntity.f14907e;
        if ((aVar.a().e().length() > 0) && s.d(aVar.a().e(), messageModel.getEntity().getMatchId())) {
            Float f10 = messageModel.getEntity().getPkCreditMap().get(messageModel.getLiveShowId());
            LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
            String itemId = (fkLiveShowResult == null || (pkLiveShow = fkLiveShowResult.getPkLiveShow()) == null) ? null : pkLiveShow.getItemId();
            L(f10, itemId != null ? messageModel.getEntity().getPkCreditMap().get(itemId) : null, false);
            G(messageModel.getEntity().getPkSofaMap());
        }
    }

    public final void b0() {
        c0();
        e0();
        d0();
        f0();
    }

    public final void c0() {
        ((LinearLayout) g(R$id.clickGuideLayout)).removeCallbacks(this.f15168i);
        this.f15168i = null;
    }

    public final void d0() {
        this.f15171l = false;
        int i10 = R$id.fireWebpImageView;
        ((FKWebpAnimationView) g(i10)).i();
        ((FKWebpAnimationView) g(i10)).setVisibility(8);
    }

    public final void e0() {
        int i10 = R$id.startPkWebpImageView;
        ((FKWebpAnimationView) g(i10)).i();
        ((FKWebpAnimationView) g(i10)).setVisibility(8);
    }

    public final void f0() {
        int i10 = R$id.livePkSVGAImageView;
        ((FKSVGAImageView) g(i10)).K();
        ((FKSVGAImageView) g(i10)).setVisibility(8);
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f15173n;
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

    public final void g0(boolean z10) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.l(FKLiveGrpcEntity.f14907e.a().e(), liveShowModel.getItemId(), liveShowModel.getUser().userId(), z10);
        }
    }

    public final float getMyGiftCountInPk() {
        return this.f15163d;
    }

    public final int getPkDurationOrPunishDuration() {
        Long l10;
        int i10 = b.f15174a[FKLiveGrpcEntity.f14907e.a().f().ordinal()];
        if (i10 == 1) {
            return (int) this.f15165f.a();
        }
        if (i10 == 2 && (l10 = this.f15170k) != null) {
            return (int) ((System.currentTimeMillis() - l10.longValue()) / 1000);
        }
        return 0;
    }

    @Nullable
    public final SensorsLogLiveShow.LivePkResult getPkResult() {
        return this.f15169j;
    }

    public final void h0(ImageView imageView, int i10) {
        imageView.setVisibility(0);
        imageView.setImageResource(i10);
    }

    public final void i0(boolean z10, boolean z11) {
        String string;
        if (z10) {
            if (z11) {
                string = getContext().getString(R$string.close_others_live_sound);
            } else {
                string = getContext().getString(R$string.open_others_live_sound);
            }
        } else if (z11) {
            string = getContext().getString(R$string.close_your_live_sound);
        } else {
            string = getContext().getString(R$string.open_your_live_sound);
        }
        s.h(string, "if (isViewer) {\n        …)\n            }\n        }");
        com.cupidapp.live.base.view.h.f12779a.s(getContext(), string);
    }

    public final void j0() {
        p1.g gVar = p1.g.f52734a;
        Integer c4 = gVar.v().c();
        int intValue = c4 != null ? c4.intValue() : 0;
        if (intValue >= 3) {
            S();
        } else {
            gVar.v().d(Integer.valueOf(intValue + 1));
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.A(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null).D(R$string.enter_others_live_room_prompt), R$string.enter_others_live_room_description, 0, 2, null).j(false).C(true, R$string.do_not_remind_me_next_time), 0, new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showEnterOthersLiveRoomDialog$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z10) {
                    if (z10) {
                        p1.g.f52734a.v().d(3);
                    }
                    FKLivePkWarLayout.this.S();
                }
            }, 1, null), 0, null, 3, null), null, 1, null);
        }
    }

    public final void k0(boolean z10) {
        if (z10) {
            p1.g gVar = p1.g.f52734a;
            Boolean c4 = gVar.a1().c();
            Boolean bool = Boolean.TRUE;
            if (s.d(c4, bool)) {
                return;
            }
            gVar.a1().d(bool);
            int i10 = R$id.clickGuideLayout;
            ((LinearLayout) g(i10)).setVisibility(0);
            this.f15168i = new Runnable() { // from class: com.cupidapp.live.liveshow.pk.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    FKLivePkWarLayout.l0(FKLivePkWarLayout.this);
                }
            };
            ((LinearLayout) g(i10)).postDelayed(this.f15168i, 2000L);
        }
    }

    public final void m0(@NotNull String liveShowId) {
        s.i(liveShowId, "liveShowId");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            if (s.d(liveShowId, liveShowModel.getItemId())) {
                int i10 = R$id.leftFirstBloodSVGAImageView;
                ((FKSVGAImageView) g(i10)).setVisibility(0);
                FKSVGAImageView leftFirstBloodSVGAImageView = (FKSVGAImageView) g(i10);
                s.h(leftFirstBloodSVGAImageView, "leftFirstBloodSVGAImageView");
                FKSVGAImageView.F(leftFirstBloodSVGAImageView, "first_blood_prompt.svga", null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showFirstBloodPrompt$1$1
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
                        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) FKLivePkWarLayout.this.g(R$id.leftFirstBloodSVGAImageView);
                        if (fKSVGAImageView == null) {
                            return;
                        }
                        fKSVGAImageView.setVisibility(8);
                    }
                }, 2, null);
                return;
            }
            int i11 = R$id.rightFirstBloodSVGAImageView;
            ((FKSVGAImageView) g(i11)).setVisibility(0);
            FKSVGAImageView rightFirstBloodSVGAImageView = (FKSVGAImageView) g(i11);
            s.h(rightFirstBloodSVGAImageView, "rightFirstBloodSVGAImageView");
            FKSVGAImageView.F(rightFirstBloodSVGAImageView, "first_blood_prompt.svga", null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showFirstBloodPrompt$1$2
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
                    FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) FKLivePkWarLayout.this.g(R$id.rightFirstBloodSVGAImageView);
                    if (fKSVGAImageView == null) {
                        return;
                    }
                    fKSVGAImageView.setVisibility(8);
                }
            }, 2, null);
        }
    }

    public final void n0() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.hang_up_limit_prompt, 0, 2, null), 0, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showHangUpLimitPrompt$1
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
                FKLivePkWarLayout.this.B0(false);
                FKLivePkWarLayout.this.g0(true);
            }
        }, 3, null), 0, null, 3, null), null, 1, null);
    }

    public final void o0() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.end_of_interactive_tips, 0, 2, null), R$string.the_end_of_interactive, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showInteractiveDialog$1
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
                FKLivePkWarLayout.this.B0(true);
                FKLivePkWarLayout.this.g0(false);
            }
        }, 2, null), R$string.continue_to_interactive, null, 2, null), null, 1, null);
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15165f.g();
        b0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FollowActorEvent event) {
        User user;
        s.i(event, "event");
        String userId = event.getUserModel().userId();
        LiveShowModel pkLiveShowModel = FKLiveConstantsData.INSTANCE.getPkLiveShowModel();
        if (s.d(userId, (pkLiveShowModel == null || (user = pkLiveShowModel.getUser()) == null) ? null : user.userId())) {
            r0(event.getUserModel().getAloha());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        c cVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (getVisibility() == 0 && z10 && (cVar = this.f15166g) != null) {
            cVar.c(i11);
        }
    }

    public final void p0() {
        int i10 = R$id.livePkCountDownImageView;
        ((FKSVGAImageView) g(i10)).setVisibility(0);
        FKSVGAImageView livePkCountDownImageView = (FKSVGAImageView) g(i10);
        s.h(livePkCountDownImageView, "livePkCountDownImageView");
        FKSVGAImageView.F(livePkCountDownImageView, "pk_count_down.svga", null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showLivePkCountDownAnimation$1
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
                FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) FKLivePkWarLayout.this.g(R$id.livePkCountDownImageView);
                if (fKSVGAImageView == null) {
                    return;
                }
                fKSVGAImageView.setVisibility(8);
            }
        }, 2, null);
    }

    public final void q0(User user) {
        EventBus.c().l(new ShowLiveMiniProfileViewModel(user.userId(), SensorsLogMatch.AlohaGetPosition.PkAnchor, null, false, false, true, 28, null));
    }

    public final void r0(boolean z10) {
        ((LinearLayout) g(R$id.rightPkActorInfoLayout)).setVisibility(z10 ? 8 : 0);
    }

    public final void s0() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.end_of_PK_tips, 0, 2, null), R$string.exit_the_PK, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showPkDialog$1
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
                FKLivePkWarLayout.this.B0(false);
                FKLivePkWarLayout.this.g0(true);
            }
        }, 2, null), R$string.continue_the_PK, null, 2, null), null, 1, null);
    }

    public final void setFKLivePkWarCallback(@NotNull c pkWarCallback) {
        s.i(pkWarCallback, "pkWarCallback");
        this.f15166g = pkWarCallback;
    }

    public final void setPkResult(@Nullable SensorsLogLiveShow.LivePkResult livePkResult) {
        this.f15169j = livePkResult;
    }

    public final void t0() {
        int i10 = R$id.fireWebpImageView;
        ((FKWebpAnimationView) g(i10)).setVisibility(0);
        FKWebpAnimationView fireWebpImageView = (FKWebpAnimationView) g(i10);
        s.h(fireWebpImageView, "fireWebpImageView");
        FKWebpAnimationView.d(fireWebpImageView, "live_pk_fire.webp", 0, null, 4, null);
    }

    public final void u0(boolean z10) {
        if (z10) {
            return;
        }
        p1.g gVar = p1.g.f52734a;
        Boolean c4 = gVar.l1().c();
        Boolean bool = Boolean.TRUE;
        if (s.d(c4, bool)) {
            return;
        }
        gVar.l1().d(bool);
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.pk_punish_prompt, 0, 2, null), R$string.all_right, null, null, 6, null), null, 1, null);
    }

    public final void v0(String str) {
        int i10 = R$id.livePkSVGAImageView;
        ((FKSVGAImageView) g(i10)).setVisibility(0);
        FKSVGAImageView livePkSVGAImageView = (FKSVGAImageView) g(i10);
        s.h(livePkSVGAImageView, "livePkSVGAImageView");
        FKSVGAImageView.F(livePkSVGAImageView, str, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$showSVGAAnimation$1
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
                FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) FKLivePkWarLayout.this.g(R$id.livePkSVGAImageView);
                if (fKSVGAImageView == null) {
                    return;
                }
                fKSVGAImageView.setVisibility(8);
            }
        }, 2, null);
    }

    public final void w0(String str, String str2, boolean z10, com.cupidapp.live.liveshow.entity.c cVar) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        setVisibility(0);
        if (z10) {
            int i10 = R$id.leftPkActorTextureView;
            ((TextureView) g(i10)).setVisibility(0);
            c cVar2 = this.f15166g;
            if (cVar2 != null) {
                cVar2.a(0, 0);
            }
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            TextureView leftPkActorTextureView = (TextureView) g(i10);
            s.h(leftPkActorTextureView, "leftPkActorTextureView");
            fKLiveUtil.M(str, leftPkActorTextureView);
        } else {
            FKLiveUtil.f14913a.t(2);
            ((TextureView) g(R$id.leftPkActorTextureView)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.pk.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    FKLivePkWarLayout.x0(FKLivePkWarLayout.this);
                }
            });
        }
        FKLiveUtil fKLiveUtil2 = FKLiveUtil.f14913a;
        List<String> c4 = fKLiveUtil2.c();
        if (c4 != null && c4.contains(str2)) {
            TextureView rightPkActorTextureView = (TextureView) g(R$id.rightPkActorTextureView);
            s.h(rightPkActorTextureView, "rightPkActorTextureView");
            fKLiveUtil2.M(str2, rightPkActorTextureView);
            return;
        }
        FKLiveUtil.D(fKLiveUtil2, str2, (TextureView) g(R$id.rightPkActorTextureView), cVar, null, 8, null);
    }

    public final void y0(boolean z10, long j10) {
        if (z10) {
            ((TextView) g(R$id.livePkCountDownTimerView)).setText(getContext().getString(R$string.interacting));
        } else {
            this.f15165f.c(Integer.valueOf((int) (j10 / 1000)), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$startPkProcessCountDownTime$1
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
                    com.cupidapp.live.base.utils.i iVar;
                    iVar = FKLivePkWarLayout.this.f15165f;
                    iVar.g();
                    ((TextView) FKLivePkWarLayout.this.g(R$id.livePkCountDownTimerView)).setText(FKLivePkWarLayout.this.getContext().getString(R$string.interacting));
                    FKLivePkWarLayout.this.d0();
                    FKLivePkWarLayout.this.f0();
                }
            }, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$startPkProcessCountDownTime$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Integer num) {
                    invoke(num.intValue());
                    return p.f51048a;
                }

                public final void invoke(int i10) {
                    boolean z11;
                    ((TextView) FKLivePkWarLayout.this.g(R$id.livePkCountDownTimerView)).setText(v.u(i10 * 1000));
                    if (i10 <= 60) {
                        z11 = FKLivePkWarLayout.this.f15171l;
                        if (!z11) {
                            FKLivePkWarLayout.this.f15171l = true;
                            FKLivePkWarLayout.this.t0();
                            return;
                        }
                    }
                    if (i10 == 30) {
                        FKLivePkWarLayout.this.v0("steal_tower.svga");
                    } else if (i10 == 10) {
                        FKLivePkWarLayout.this.p0();
                    }
                }
            });
        }
    }

    public final void z0(final boolean z10) {
        if (AppApplication.f11612d.e()) {
            int i10 = R$id.startPkWebpImageView;
            ((FKWebpAnimationView) g(i10)).setVisibility(0);
            FKWebpAnimationView startPkWebpImageView = (FKWebpAnimationView) g(i10);
            s.h(startPkWebpImageView, "startPkWebpImageView");
            FKWebpAnimationView.d(startPkWebpImageView, "start_pk.webp", 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout$startPkStartAnimation$1
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
                    FKLivePkWarLayout.this.e0();
                    if (z10) {
                        FKLivePkWarLayout.this.v0("first_blood.svga");
                    }
                }
            }, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkWarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15173n = new LinkedHashMap();
        this.f15165f = new com.cupidapp.live.base.utils.i();
        W();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkWarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15173n = new LinkedHashMap();
        this.f15165f = new com.cupidapp.live.base.utils.i();
        W();
    }
}
