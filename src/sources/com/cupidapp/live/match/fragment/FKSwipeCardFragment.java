package com.cupidapp.live.match.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.AlohaGuideDialog;
import com.cupidapp.live.appdialog.model.ActivationType;
import com.cupidapp.live.appdialog.wrapper.AppDialogWrapper;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.model.AlohaOrNopeGuideModel;
import com.cupidapp.live.base.network.model.DailyLikeGuideModel;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.animation.a;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.event.SuperLikeBtnShowEvent;
import com.cupidapp.live.feed.holder.OpenFeedDetailEvent;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.match.activity.FKMatchFilterNewActivity;
import com.cupidapp.live.match.activity.UnLockDailyHeartActivity;
import com.cupidapp.live.match.event.FakeUserUploadAvatarEvent;
import com.cupidapp.live.match.event.ReloadSwipeCardEvent;
import com.cupidapp.live.match.helper.FKRequestLocationDialogHelper;
import com.cupidapp.live.match.helper.FakeUserUploadAvatarDialogHelper;
import com.cupidapp.live.match.helper.LocationChangeHelper;
import com.cupidapp.live.match.model.AlohaGuideModel;
import com.cupidapp.live.match.model.MatchGroupCampaignModel;
import com.cupidapp.live.match.model.MatchMarketingModel;
import com.cupidapp.live.match.model.MatchRecommendModel;
import com.cupidapp.live.match.model.MatchRecommendType;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.view.FKFaultModel;
import com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout;
import com.cupidapp.live.match.view.FKSwipeCardFaultPromptLayout;
import com.cupidapp.live.match.view.FKSwipeCardFaultType;
import com.cupidapp.live.match.view.FKSwipeCardLayout;
import com.cupidapp.live.match.view.FKSwipeCardMoreSwipeLayout;
import com.cupidapp.live.match.view.FKSwipeCardSearchView;
import com.cupidapp.live.match.view.FKSwipeCardUploadAvatarLayout;
import com.cupidapp.live.match.view.MoreDailyHeartBoysLayout;
import com.cupidapp.live.match.view.a0;
import com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel;
import com.cupidapp.live.notify.activity.NotifyActivity;
import com.cupidapp.live.notify.fragment.NotifyPageType;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.ShowGuideBubbleEvent;
import com.cupidapp.live.profile.event.ShowMoreDailyHeartEvent;
import com.cupidapp.live.profile.event.UpdateLiveShowEvent;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superboost.dialog.SuperBoostManager;
import com.cupidapp.live.superboost.event.SuperBoostStateChangeEvent;
import com.cupidapp.live.superlike.view.SuperLikeDeliveryAnimLayout;
import com.cupidapp.live.superlike.view.SuperLikeDialogLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.model.VipPurchaseSuccessEvent;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.irisdt.client.others.OthersProtos;
import com.yuyakaido.android.cardstackview.Direction;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardFragment extends FKBaseFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f16680g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final ActivityResultLauncher<Intent> f16681h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16682i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f16683j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16684k = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f16678e = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(FKSwipeCardFragment.this);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public String f16679f = FollowPrefer.Aloha.getValue();

    /* compiled from: FKSwipeCardFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16685a;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f16685a = iArr;
        }
    }

    /* compiled from: FKSwipeCardFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.match.view.h {
        public b() {
        }

        @Override // com.cupidapp.live.match.view.h
        public void a() {
            FKSwipeCardFragment.this.H1().alohaOrNopeClick(true);
        }

        @Override // com.cupidapp.live.match.view.h
        public void b() {
            SuperBoostManager.f18580a.j(FKSwipeCardFragment.this.getContext(), FKSwipeCardFragment.this.F1(), SensorPosition.Match.getValue(), null);
        }

        @Override // com.cupidapp.live.match.view.h
        public void c() {
            FKSwipeCardFragment.this.H1().alohaOrNopeClick(false);
        }

        @Override // com.cupidapp.live.match.view.h
        public void d(int i10) {
            FKSwipeCardFragment.this.H1().superLikeClick(i10);
        }

        @Override // com.cupidapp.live.match.view.h
        public void e() {
            FKSwipeCardFragment.this.z1();
        }
    }

    /* compiled from: FKSwipeCardFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements SuperBoostManager.a {
        public c() {
        }

        @Override // com.cupidapp.live.superboost.dialog.SuperBoostManager.a
        public void a() {
            FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_click_button_layout);
            if (fKSwipeCardClickButtonLayout != null) {
                fKSwipeCardClickButtonLayout.z();
            }
        }

        @Override // com.cupidapp.live.superboost.dialog.SuperBoostManager.a
        public void b(@NotNull String remainTime, @NotNull String min, @NotNull String sec) {
            kotlin.jvm.internal.s.i(remainTime, "remainTime");
            kotlin.jvm.internal.s.i(min, "min");
            kotlin.jvm.internal.s.i(sec, "sec");
            FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_click_button_layout);
            if (fKSwipeCardClickButtonLayout != null) {
                fKSwipeCardClickButtonLayout.E(remainTime);
            }
        }

        @Override // com.cupidapp.live.superboost.dialog.SuperBoostManager.a
        public void c(boolean z10) {
        }
    }

    /* compiled from: FKSwipeCardFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements a0 {

        /* compiled from: FKSwipeCardFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a implements com.cupidapp.live.match.helper.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FKSwipeCardFragment f16689a;

            public a(FKSwipeCardFragment fKSwipeCardFragment) {
                this.f16689a = fKSwipeCardFragment;
            }

            @Override // com.cupidapp.live.match.helper.a
            public void dismiss() {
                ((FKSwipeCardLayout) this.f16689a.i1(R$id.swipe_card_layout)).D();
            }
        }

        public d() {
        }

        @Override // com.cupidapp.live.match.view.a0
        public void j() {
            FKSwipeCardViewModel.setAlohaOrNopeButtonVisible$default(FKSwipeCardFragment.this.H1(), true, 0.0f, 2, null);
            FKSwipeCardFragment.this.H1().setCancelNopeButtonVisible(true);
            FKSwipeCardFragment.this.H1().checkSwipeNumToShowPurchase();
        }

        @Override // com.cupidapp.live.match.view.a0
        public void k() {
            FKSwipeCardFragment.this.H1().setSwipeCardCount(false);
            FKSwipeCardFragment.this.H1().setNopeCardData(null);
            FKSwipeCardViewModel.setAlohaOrNopeButtonVisible$default(FKSwipeCardFragment.this.H1(), FKSwipeCardFragment.this.E1() instanceof MatchRecommendUserModel, 0.0f, 2, null);
        }

        @Override // com.cupidapp.live.match.view.a0
        public void l(@NotNull MatchRecommendUserModel model) {
            kotlin.jvm.internal.s.i(model, "model");
            if (FKSwipeCardFragment.this.H1().checkHasAlohaOrNopeNum()) {
                FKSwipeCardFragment.this.c2(model);
                GroupSocialLog.f18708a.u(SensorScene.Match.getValue(), model.getUser().userId(), model.getRecommendContext(), true, model.getUser());
            } else {
                FKSwipeCardFragment.this.H1().checkSwipeNumToShowPurchase();
            }
        }

        @Override // com.cupidapp.live.match.view.a0
        public void m() {
            FKSwipeCardFragment.this.H1().changeGuideAnimLiveData(true);
        }

        @Override // com.cupidapp.live.match.view.a0
        public void n(@NotNull MatchRecommendModel model) {
            kotlin.jvm.internal.s.i(model, "model");
            if (model instanceof MatchRecommendUserModel) {
                FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_click_button_layout);
                String individuationFrameConfig = ((MatchRecommendUserModel) model).getUser().getIndividuationFrameConfig();
                fKSwipeCardClickButtonLayout.s(individuationFrameConfig == null || individuationFrameConfig.length() == 0);
            } else if (model instanceof MatchGroupCampaignModel) {
                FKSwipeCardFragment.this.e2(model);
            } else if (model instanceof MatchMarketingModel) {
                FKSwipeCardFragment.this.e2(model);
            }
        }

        @Override // com.cupidapp.live.match.view.a0
        public void o() {
            FKSwipeCardFragment.this.j2();
        }

        @Override // com.cupidapp.live.match.view.a0
        public void p(@Nullable String str) {
            FKSwipeCardFragment.this.g2(str);
        }

        @Override // com.cupidapp.live.match.view.a0
        public void q() {
            FKSwipeCardFragment.this.H1().setWindowClickable(false);
        }

        @Override // com.cupidapp.live.match.view.a0
        public void r() {
            FKSwipeCardFragment.this.H1().getRecommendLiveData();
        }

        @Override // com.cupidapp.live.match.view.a0
        public void s(float f10) {
            FKSwipeCardFragment.this.H1().setAlohaOrNopeButtonVisible(true, f10);
            FKSwipeCardFragment.this.H1().setCancelNopeButtonVisible(false);
        }

        @Override // com.cupidapp.live.match.view.a0
        public void t(@NotNull LiveShowModel liveShow) {
            kotlin.jvm.internal.s.i(liveShow, "liveShow");
            Intent intent = new Intent(FKSwipeCardFragment.this.getContext(), (Class<?>) FKLiveForViewerActivity.class);
            z0.g.c(intent, new FKLiveForViewerViewModel(liveShow, null, new LiveInRoomSensorModel("MATCH", null, SensorScene.Match, SensorPosition.Match, null, null, 48, null), false, 8, null));
            FKSwipeCardFragment.this.f16681h.launch(intent);
        }

        @Override // com.cupidapp.live.match.view.a0
        public void u() {
            Context context = FKSwipeCardFragment.this.getContext();
            if (context != null) {
                FKSwipeCardFragment fKSwipeCardFragment = FKSwipeCardFragment.this;
                FakeUserUploadAvatarDialogHelper.f16755a.g(fKSwipeCardFragment.G1(), context, SensorPosition.Match, new a(fKSwipeCardFragment));
            }
        }

        @Override // com.cupidapp.live.match.view.a0
        public void v() {
            FKSwipeCardFragment.this.H1().prefetchSwipeCardData();
        }

        @Override // com.cupidapp.live.match.view.a0
        public void w() {
            SensorsLogKeyButtonClick.Match.UndoNope.click();
            FKSwipeCardFragment.this.z1();
        }

        @Override // com.cupidapp.live.match.view.a0
        public void x(@Nullable Direction direction, @NotNull Object card, @Nullable Object obj, int i10, boolean z10) {
            kotlin.jvm.internal.s.i(card, "card");
            if (card instanceof MatchRecommendUserModel) {
                FKSwipeCardFragment.this.y2((MatchRecommendUserModel) card, direction, i10);
            } else if (card instanceof MatchGroupCampaignModel) {
                FKSwipeCardFragment.this.x2((MatchGroupCampaignModel) card, direction, z10);
            } else if (card instanceof MatchMarketingModel) {
                FKSwipeCardFragment.this.w2((MatchMarketingModel) card, direction, z10);
            }
            boolean z11 = obj instanceof MatchRecommendUserModel;
            if (z11) {
                FKSwipeCardFragment.this.H1().setUploadAvatarVisible(((MatchRecommendUserModel) obj).getFakeTipView());
            }
            FKSwipeCardViewModel.setAlohaOrNopeButtonVisible$default(FKSwipeCardFragment.this.H1(), z11, 0.0f, 2, null);
            FKSwipeCardFragment.this.H1().setCancelNopeButtonVisible(obj instanceof MatchRecommendModel);
        }
    }

    /* compiled from: FKSwipeCardFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements com.cupidapp.live.base.view.animation.a {
        public e() {
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationCancel(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            FrameLayout frameLayout = (FrameLayout) FKSwipeCardFragment.this.i1(R$id.swipe_guide_cl);
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationEnd(@Nullable Animator animator) {
            FrameLayout frameLayout = (FrameLayout) FKSwipeCardFragment.this.i1(R$id.swipe_guide_cl);
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(8);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationPause(@Nullable Animator animator) {
            a.C0145a.c(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationRepeat(@NotNull Animator animator) {
            a.C0145a.d(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationResume(@Nullable Animator animator) {
            a.C0145a.e(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationStart(@Nullable Animator animator) {
            a.C0145a.f(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationUpdate(@NotNull ValueAnimator valueAnimator) {
            a.C0145a.g(this, valueAnimator);
        }
    }

    public FKSwipeCardFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f16680g = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(FKSwipeCardViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.match.fragment.p
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FKSwipeCardFragment.i2(FKSwipeCardFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.s.h(registerForActivityResult, "registerForActivityResul…}\n            }\n        }");
        this.f16681h = registerForActivityResult;
        this.f16683j = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$purchaseDialogManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PurchaseDialogManager invoke() {
                Context context = FKSwipeCardFragment.this.getContext();
                Lifecycle lifecycle = FKSwipeCardFragment.this.getLifecycle();
                kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
                return new PurchaseDialogManager(context, lifecycle);
            }
        });
    }

    public static final void K1(FKSwipeCardFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSwipeCardUploadAvatarLayout fKSwipeCardUploadAvatarLayout = (FKSwipeCardUploadAvatarLayout) this$0.i1(R$id.upload_avatar_layout);
        kotlin.jvm.internal.s.h(it, "it");
        fKSwipeCardUploadAvatarLayout.g(it.booleanValue());
    }

    public static final void L1(FKSwipeCardFragment this$0, DailyLikeGuideModel dailyLikeGuideModel) {
        Context context;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (dailyLikeGuideModel == null || dailyLikeGuideModel.getDescribe() == null || (context = this$0.getContext()) == null) {
            return;
        }
        MoreDailyHeartBoysLayout more_heart_boys_layout = (MoreDailyHeartBoysLayout) this$0.i1(R$id.more_heart_boys_layout);
        if (more_heart_boys_layout != null) {
            kotlin.jvm.internal.s.h(more_heart_boys_layout, "more_heart_boys_layout");
            MoreDailyHeartBoysLayout.g(more_heart_boys_layout, z0.t.a(dailyLikeGuideModel.getDescribe(), ContextCompat.getColor(context, R$color.outstanding_yellow)), null, R$drawable.shape_black_70_bg_twelve_corners, ContextCompat.getColor(context, R$color.app_white), null, null, 50, null);
        }
        GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
        OthersProtos.Enum_type enum_type = OthersProtos.Enum_type.DAILY_HEART_GUIDE;
        Integer popType = dailyLikeGuideModel.getPopType();
        groupOthersLog.q(enum_type, popType != null ? popType.toString() : null);
    }

    public static final void M1(FKSwipeCardFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) this$0.i1(R$id.swipe_card_layout);
        kotlin.jvm.internal.s.h(it, "it");
        fKSwipeCardLayout.d0(it.booleanValue());
    }

    public static final void N1(final FKSwipeCardFragment this$0, Pair pair) {
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        final String str = pair != null ? (String) pair.getFirst() : null;
        final String str2 = pair != null ? (String) pair.getSecond() : null;
        if (str != null) {
            FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout2 = (FKSwipeCardClickButtonLayout) this$0.i1(R$id.swipe_card_click_button_layout);
            if (fKSwipeCardClickButtonLayout2 != null) {
                fKSwipeCardClickButtonLayout2.post(new Runnable() { // from class: com.cupidapp.live.match.fragment.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        FKSwipeCardFragment.O1(FKSwipeCardFragment.this, str);
                    }
                });
                return;
            }
            return;
        }
        if (str2 == null || (fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) this$0.i1(R$id.swipe_card_click_button_layout)) == null) {
            return;
        }
        fKSwipeCardClickButtonLayout.post(new Runnable() { // from class: com.cupidapp.live.match.fragment.o
            @Override // java.lang.Runnable
            public final void run() {
                FKSwipeCardFragment.P1(FKSwipeCardFragment.this, str2);
            }
        });
    }

    public static final void O1(FKSwipeCardFragment this$0, String str) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) this$0.i1(R$id.swipe_card_click_button_layout);
        if (fKSwipeCardClickButtonLayout != null) {
            fKSwipeCardClickButtonLayout.M(str);
        }
    }

    public static final void P1(FKSwipeCardFragment this$0, String str) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) this$0.i1(R$id.swipe_card_click_button_layout);
        if (fKSwipeCardClickButtonLayout != null) {
            fKSwipeCardClickButtonLayout.P(str);
        }
    }

    public static final void Q1(FKSwipeCardFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            Object data = stateResult.getData();
            kotlin.jvm.internal.s.f(data);
            List<? extends MatchRecommendModel> list = (List) ((Pair) data).getFirst();
            boolean booleanValue = ((Boolean) ((Pair) stateResult.getData()).getSecond()).booleanValue();
            ((FKSwipeCardLayout) this$0.i1(R$id.swipe_card_layout)).G(list, !booleanValue);
            if (this$0.v2()) {
                this$0.H1().setSwipeCardFault(true, true);
            } else {
                this$0.r2();
            }
            if (booleanValue) {
                LocationChangeHelper locationChangeHelper = LocationChangeHelper.f16770a;
                locationChangeHelper.f(true);
                Context context = this$0.getContext();
                if (context != null) {
                    locationChangeHelper.g(context);
                }
            }
            FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) this$0.i1(R$id.swipe_card_click_button_layout);
            if (fKSwipeCardClickButtonLayout != null) {
                fKSwipeCardClickButtonLayout.q();
            }
        }
    }

    public static final void R1(FKSwipeCardFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            this$0.o2((FKFaultModel) pair.getSecond());
        } else {
            ((FKSwipeCardFaultPromptLayout) this$0.i1(R$id.swipe_card_fault_layout)).setVisibility(8);
        }
    }

    public static final void S1(FKSwipeCardFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        this$0.k2(it.booleanValue());
    }

    public static final void T1(FKSwipeCardFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.I1(((Boolean) pair.getFirst()).booleanValue(), (SwipeCardUserLikeResult) pair.getSecond());
    }

    public static final void U1(FKSwipeCardFragment this$0, List it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) this$0.i1(R$id.swipe_card_layout);
        kotlin.jvm.internal.s.h(it, "it");
        fKSwipeCardLayout.F(it);
    }

    public static final void V1(FKSwipeCardFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        this$0.n2(it.booleanValue());
    }

    public static final void W1(FKSwipeCardFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeCardClickButtonLayout) this$0.i1(R$id.swipe_card_click_button_layout)).Q(((Boolean) pair.getFirst()).booleanValue(), ((Number) pair.getSecond()).floatValue());
    }

    public static final boolean Z1(FKSwipeCardFragment this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        view.performClick();
        FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) this$0.i1(R$id.guide_lottie_view);
        if (fKLottieAnimationView == null) {
            return false;
        }
        fKLottieAnimationView.M();
        return false;
    }

    public static final void b2(FKSwipeCardFragment this$0) {
        FKSwipeCardLayout fKSwipeCardLayout;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        MatchRecommendModel E1 = this$0.E1();
        if ((E1 instanceof MatchGroupCampaignModel) && ((MatchGroupCampaignModel) E1).getHasSeeContent() && (fKSwipeCardLayout = (FKSwipeCardLayout) this$0.i1(R$id.swipe_card_layout)) != null) {
            fKSwipeCardLayout.f0(false);
        }
    }

    public static final void i2(FKSwipeCardFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) this$0.i1(R$id.swipe_card_layout);
            if ((fKSwipeCardLayout != null ? FKSwipeCardLayout.K(fKSwipeCardLayout, 0, 1, null) : null) instanceof LiveShowModel) {
                this$0.f16682i = true;
                this$0.H1().alohaOrNopeClick(false);
            }
        }
    }

    public final void A1() {
        int i10 = R$id.swipe_card_click_button_layout;
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) i1(i10);
        SuperLikeDeliveryAnimLayout superlike_delivery = (SuperLikeDeliveryAnimLayout) i1(R$id.superlike_delivery);
        kotlin.jvm.internal.s.h(superlike_delivery, "superlike_delivery");
        Lifecycle lifecycle = getLifecycle();
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        fKSwipeCardClickButtonLayout.t(superlike_delivery, lifecycle);
        ((FKSwipeCardClickButtonLayout) i1(i10)).setSwipeCardClickListener(new b());
    }

    public final void A2() {
        if (v2()) {
            j2();
        }
    }

    public final void B1() {
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) i1(R$id.swipe_card_click_button_layout);
        if (fKSwipeCardClickButtonLayout != null) {
            fKSwipeCardClickButtonLayout.p(false);
        }
    }

    public final void C1() {
        H1().setCancelNopeButtonVisible(((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).getLiveShowCard() == null);
    }

    public final void D1() {
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) i1(R$id.swipe_card_click_button_layout);
        if (fKSwipeCardClickButtonLayout != null) {
            fKSwipeCardClickButtonLayout.p(true);
        }
    }

    @Nullable
    public final MatchRecommendModel E1() {
        FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) i1(R$id.swipe_card_layout);
        Object K = fKSwipeCardLayout != null ? FKSwipeCardLayout.K(fKSwipeCardLayout, 0, 1, null) : null;
        if (K instanceof MatchRecommendModel) {
            return (MatchRecommendModel) K;
        }
        return null;
    }

    public final PurchaseDialogManager F1() {
        return (PurchaseDialogManager) this.f16683j.getValue();
    }

    public final xb.b G1() {
        return (xb.b) this.f16678e.getValue();
    }

    public final FKSwipeCardViewModel H1() {
        return (FKSwipeCardViewModel) this.f16680g.getValue();
    }

    public final void I1(boolean z10, SwipeCardUserLikeResult swipeCardUserLikeResult) {
        Context context;
        AppDialogWrapper.f11746a.e(getContext(), swipeCardUserLikeResult.getWindow(), SensorPosition.Match);
        if (z10 && kotlin.jvm.internal.s.d(swipeCardUserLikeResult.getNewUserCompleteFlag(), Boolean.TRUE)) {
            com.cupidapp.live.base.view.h.f12779a.c(getContext(), R$string.new_user_complete_aloha_task);
            Fragment parentFragment = getParentFragment();
            FKMatchContainerFragment fKMatchContainerFragment = parentFragment instanceof FKMatchContainerFragment ? (FKMatchContainerFragment) parentFragment : null;
            if (fKMatchContainerFragment != null) {
                fKMatchContainerFragment.K1();
            }
        }
        if (!swipeCardUserLikeResult.getJumpDailyLike() || (context = getContext()) == null) {
            return;
        }
        UnLockDailyHeartActivity.f16573t.a(context);
    }

    public final void J1() {
        H1().getSuperLikeEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10) {
                String str;
                Context context = FKSwipeCardFragment.this.getContext();
                FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_layout);
                final Object K = fKSwipeCardLayout != null ? FKSwipeCardLayout.K(fKSwipeCardLayout, 0, 1, null) : null;
                if (context == null || !(K instanceof MatchRecommendUserModel)) {
                    return;
                }
                MatchRecommendUserModel matchRecommendUserModel = (MatchRecommendUserModel) K;
                String json = GsonUtil.f12000a.b().toJson(matchRecommendUserModel.getRecommendContext());
                SuperLikeDialogLayout.Companion companion = SuperLikeDialogLayout.f18632h;
                Lifecycle lifecycle = FKSwipeCardFragment.this.getLifecycle();
                kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
                String userId = matchRecommendUserModel.getUser().userId();
                str = FKSwipeCardFragment.this.f16679f;
                VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.SuperLikeMatch;
                SensorPosition sensorPosition = SensorPosition.Match;
                final FKSwipeCardFragment fKSwipeCardFragment = FKSwipeCardFragment.this;
                Function1<SwipeCardUserLikeResult, kotlin.p> function1 = new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        invoke2(swipeCardUserLikeResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SwipeCardUserLikeResult it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        w2.a.f54095a.c();
                        p1.g.f52734a.M0().d(Long.valueOf(System.currentTimeMillis()));
                        ((MatchRecommendUserModel) Object.this).getUser().setSuperLikedByMe(true);
                        ((MatchRecommendUserModel) Object.this).getUser().setSuperLikedByMeCombos(it.getUser().getSuperLikedByMeCombos());
                        ((FKSwipeCardLayout) fKSwipeCardFragment.i1(R$id.swipe_card_layout)).f0(true);
                        fKSwipeCardFragment.I1(true, it);
                    }
                };
                final FKSwipeCardFragment fKSwipeCardFragment2 = FKSwipeCardFragment.this;
                companion.b(context, lifecycle, userId, json, str, vipPurchaseEntranceType, (r27 & 64) != 0 ? null : null, sensorPosition, (r27 & 256) != 0 ? 1 : i10, function1, (r27 & 1024) != 0 ? null : new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        invoke2(swipeCardUserLikeResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SwipeCardUserLikeResult it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        FKSwipeCardFragment.this.H1().groupMatchLog(true, (MatchRecommendUserModel) K, it.getUser().getSuperLikedByMeCombos(), true, ((FKSwipeCardLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_layout)).getCurrentCardIndexOfPhoto());
                    }
                });
            }
        }));
        H1().getSwipeCardLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.Q1(FKSwipeCardFragment.this, (StateResult) obj);
            }
        });
        H1().getClearSwipeCardEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((FKSwipeCardLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_layout)).E();
            }
        }));
        H1().getSwipeCardFaultLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.R1(FKSwipeCardFragment.this, (Pair) obj);
            }
        });
        H1().getFaultActionEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<FKSwipeCardFaultType, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$5

            /* compiled from: FKSwipeCardFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f16691a;

                static {
                    int[] iArr = new int[FKSwipeCardFaultType.values().length];
                    try {
                        iArr[FKSwipeCardFaultType.NoEligibleUsers.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[FKSwipeCardFaultType.NoLocationPermission.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[FKSwipeCardFaultType.UnAvailableInternet.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f16691a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FKSwipeCardFaultType fKSwipeCardFaultType) {
                invoke2(fKSwipeCardFaultType);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FKSwipeCardFaultType it) {
                kotlin.jvm.internal.s.i(it, "it");
                int i10 = a.f16691a[it.ordinal()];
                if (i10 == 1) {
                    FKMatchFilterNewActivity.f16488t.a(FKSwipeCardFragment.this.getContext(), false, false, "");
                    return;
                }
                if (i10 != 2) {
                    if (i10 != 3) {
                        return;
                    }
                    FKSwipeCardFragment.this.j2();
                } else {
                    FKRequestLocationDialogHelper fKRequestLocationDialogHelper = FKRequestLocationDialogHelper.f16752a;
                    Context context = FKSwipeCardFragment.this.getContext();
                    xb.b G1 = FKSwipeCardFragment.this.G1();
                    final FKSwipeCardFragment fKSwipeCardFragment = FKSwipeCardFragment.this;
                    fKRequestLocationDialogHelper.b(context, G1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$5.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ kotlin.p invoke() {
                            invoke2();
                            return kotlin.p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            FKSwipeCardFragment.this.j2();
                        }
                    });
                }
            }
        }));
        H1().getSwipeCardNewUserGuideLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                if (str == null || str.length() == 0) {
                    FKSwipeCardFragment.this.H1().changeGuideAnimLiveData(true);
                } else {
                    FKSwipeCardFragment.this.q2(str);
                }
            }
        }));
        H1().getWindowClickLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.S1(FKSwipeCardFragment.this, (Boolean) obj);
            }
        });
        H1().getAlohaOrNopeResultLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.T1(FKSwipeCardFragment.this, (Pair) obj);
            }
        });
        H1().getSwipeCardLiveShowLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.U1(FKSwipeCardFragment.this, (List) obj);
            }
        });
        H1().getCancelNopeButtonVisibleLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.V1(FKSwipeCardFragment.this, (Boolean) obj);
            }
        });
        H1().getNopeCardClickEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<MatchRecommendModel, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MatchRecommendModel matchRecommendModel) {
                invoke2(matchRecommendModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MatchRecommendModel matchRecommendModel) {
                ((FKSwipeCardLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_layout)).X(matchRecommendModel);
            }
        }));
        H1().getAlohaOrNopeButtonVisibleLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.W1(FKSwipeCardFragment.this, (Pair) obj);
            }
        });
        H1().getAlohaOrNopeClickEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((FKSwipeCardLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_layout)).f0(z10);
            }
        }));
        H1().getUploadAvatarVisibleLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.K1(FKSwipeCardFragment.this, (Boolean) obj);
            }
        });
        H1().getDailyGuideTipLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.L1(FKSwipeCardFragment.this, (DailyLikeGuideModel) obj);
            }
        });
        H1().getStartOrStopPlayStreamLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.M1(FKSwipeCardFragment.this, (Boolean) obj);
            }
        });
        H1().getShowSuperBoostOrSuperLikeNumLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKSwipeCardFragment.N1(FKSwipeCardFragment.this, (Pair) obj);
            }
        });
        H1().getShowGetAlohaDialogLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<AlohaGuideModel, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$18
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(AlohaGuideModel alohaGuideModel) {
                invoke2(alohaGuideModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AlohaGuideModel it) {
                kotlin.jvm.internal.s.i(it, "it");
                String newAlohaText = it.getNewAlohaText();
                if (newAlohaText == null || newAlohaText.length() == 0) {
                    return;
                }
                FKSwipeCardFragment.this.l2(it);
            }
        }));
        H1().getAlohaOrNopeResidueNumLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$19
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke2(num);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num) {
                if (num != null && num.intValue() == 0) {
                    ((FKSwipeCardLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_layout)).p(kotlin.collections.s.j());
                } else {
                    ((FKSwipeCardLayout) FKSwipeCardFragment.this.i1(R$id.swipe_card_layout)).p(kotlin.collections.s.m(Direction.Left, Direction.Right));
                }
            }
        }));
        H1().getShowVipOrPlusDialogEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<VipPurchaseEntranceType, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(VipPurchaseEntranceType vipPurchaseEntranceType) {
                invoke2(vipPurchaseEntranceType);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VipPurchaseEntranceType it) {
                kotlin.jvm.internal.s.i(it, "it");
                PurchaseDialogManager.j(FKSwipeCardFragment.this.F1(), it, null, null, false, 14, null);
            }
        }));
        H1().getAlohaOrNopeGuideLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<AlohaOrNopeGuideModel, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$initObserve$21
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(AlohaOrNopeGuideModel alohaOrNopeGuideModel) {
                invoke2(alohaOrNopeGuideModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable AlohaOrNopeGuideModel alohaOrNopeGuideModel) {
                FKSwipeCardFragment.this.m2(alohaOrNopeGuideModel);
            }
        }));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16684k.clear();
    }

    public final void X1() {
        SuperBoostManager.f18580a.r(new c());
    }

    public final void Y1() {
        ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).setSwipeCardListener(new d());
        FrameLayout frameLayout = (FrameLayout) i1(R$id.swipe_guide_cl);
        if (frameLayout != null) {
            frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.match.fragment.i
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean Z1;
                    Z1 = FKSwipeCardFragment.Z1(FKSwipeCardFragment.this, view, motionEvent);
                    return Z1;
                }
            });
        }
    }

    public final void a2(String str) {
        FeedDetailActivity.a aVar = FeedDetailActivity.Q;
        Context context = getContext();
        SensorPosition sensorPosition = SensorPosition.Match;
        FeedDetailActivity.a.b(aVar, context, null, false, new FeedSensorContext(sensorPosition, sensorPosition, null, SensorScene.Match), false, false, null, null, null, str, 496, null);
    }

    public final void c2(MatchRecommendUserModel matchRecommendUserModel) {
        UserProfileActivity.a aVar = UserProfileActivity.G;
        Context context = getContext();
        User user = matchRecommendUserModel.getUser();
        String value = ViewProfilePrefer.AlohaToProfile.getValue();
        boolean me2 = matchRecommendUserModel.getUser().getMe();
        SensorPosition sensorPosition = SensorPosition.Match;
        UserProfileActivity.a.b(aVar, context, user, new ProfileSensorContext(value, null, me2, sensorPosition, sensorPosition, SensorScene.Match), true, matchRecommendUserModel.getRecommendContext(), null, null, false, 224, null);
    }

    public final void d2(MatchRecommendModel matchRecommendModel, GroupSocialLog.CampaignOperateAction campaignOperateAction) {
        if (matchRecommendModel instanceof MatchGroupCampaignModel) {
            String type = matchRecommendModel.getType();
            if (kotlin.jvm.internal.s.d(type, MatchRecommendType.GroupCampaign.getType())) {
                MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) matchRecommendModel;
                GroupSocialLog.f18708a.b(matchGroupCampaignModel.getTitle(), campaignOperateAction, matchGroupCampaignModel.getActivityId());
                return;
            } else {
                if (kotlin.jvm.internal.s.d(type, MatchRecommendType.HighEndDating.getType())) {
                    GroupSocialLog.f18708a.p(((MatchGroupCampaignModel) matchRecommendModel).getTitle(), campaignOperateAction);
                    return;
                }
                return;
            }
        }
        if (matchRecommendModel instanceof MatchMarketingModel) {
            GroupSocialLog.f18708a.p(((MatchMarketingModel) matchRecommendModel).getTitle(), campaignOperateAction);
        }
    }

    public final void e2(MatchRecommendModel matchRecommendModel) {
        H1().campaignExposure(matchRecommendModel);
        if (matchRecommendModel instanceof MatchGroupCampaignModel) {
            String type = matchRecommendModel.getType();
            if (kotlin.jvm.internal.s.d(type, MatchRecommendType.GroupCampaign.getType())) {
                MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) matchRecommendModel;
                GroupSocialLog.f18708a.c(matchGroupCampaignModel.getTitle(), matchGroupCampaignModel.getActivityId());
                return;
            } else {
                if (kotlin.jvm.internal.s.d(type, MatchRecommendType.HighEndDating.getType())) {
                    GroupSocialLog.f18708a.q(((MatchGroupCampaignModel) matchRecommendModel).getTitle());
                    return;
                }
                return;
            }
        }
        if (matchRecommendModel instanceof MatchMarketingModel) {
            GroupSocialLog.f18708a.q(((MatchMarketingModel) matchRecommendModel).getTitle());
        }
    }

    public final void f2() {
        int i10 = R$id.swipe_card_layout;
        if (((FKSwipeCardLayout) i1(i10)) == null) {
            return;
        }
        FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) i1(i10);
        if (fKSwipeCardLayout != null) {
            fKSwipeCardLayout.E();
        }
        j2();
    }

    public final void g2(String str) {
        p1.g.f52734a.y1().d(Boolean.FALSE);
        boolean z10 = true;
        H1().setWindowClickable(true);
        if (str != null && str.length() != 0) {
            z10 = false;
        }
        if (z10) {
            return;
        }
        j.a aVar = com.cupidapp.live.base.router.j.f12156c;
        Context context = getContext();
        Fragment parentFragment = getParentFragment();
        FKMatchContainerFragment fKMatchContainerFragment = parentFragment instanceof FKMatchContainerFragment ? (FKMatchContainerFragment) parentFragment : null;
        aVar.a(context, str, new WebStyleViewModel(null, false, fKMatchContainerFragment != null ? fKMatchContainerFragment.C1() : null, 3, null));
    }

    public final void h2() {
        j1.c.b(j1.c.f50228a, SensorPosition.Match, null, null, 6, null);
    }

    @Nullable
    public View i1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16684k;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void j2() {
        ((FKSwipeCardSearchView) i1(R$id.swipe_card_search_view)).g();
        H1().setCancelNopeButtonVisible(false);
        FKSwipeCardViewModel.setAlohaOrNopeButtonVisible$default(H1(), false, 0.0f, 2, null);
        ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).P(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$searchSwipeCardData$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKSwipeCardFragment.this.H1().getSwipeCardData();
            }
        });
        FKSwipeCardViewModel.setSwipeCardFault$default(H1(), false, false, 2, null);
    }

    public final void k2(boolean z10) {
        Window window;
        Window window2;
        Window window3;
        Window window4;
        if (z10) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window4 = activity.getWindow()) != null) {
                window4.clearFlags(16);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 == null || (window3 = activity2.getWindow()) == null) {
                return;
            }
            window3.clearFlags(8);
            return;
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (window2 = activity3.getWindow()) != null) {
            window2.setFlags(16, 16);
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 == null || (window = activity4.getWindow()) == null) {
            return;
        }
        window.setFlags(8, 8);
    }

    public final void l2(AlohaGuideModel alohaGuideModel) {
        AlohaGuideDialog.f11651d.a(getContext()).c(alohaGuideModel, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$showAlohaGuideDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NotifyActivity.f17492s.a(FKSwipeCardFragment.this.getContext(), NotifyPageType.Follow, true);
            }
        }).e();
    }

    public final void m2(AlohaOrNopeGuideModel alohaOrNopeGuideModel) {
        ((FKSwipeCardMoreSwipeLayout) i1(R$id.earn_more_layout)).h(alohaOrNopeGuideModel, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$showAlohaGuideTip$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKSwipeCardFragment.this.H1().showVipOrPlusPurchaseDialog(VipPurchaseEntranceType.UnLimitSwipeCard);
            }
        });
    }

    public final void n2(boolean z10) {
        ((FKSwipeCardClickButtonLayout) i1(R$id.swipe_card_click_button_layout)).r(z10);
    }

    public final void o2(FKFaultModel fKFaultModel) {
        ((FKSwipeCardSearchView) i1(R$id.swipe_card_search_view)).h();
        ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).setVisibility(8);
        ((FKSwipeCardFaultPromptLayout) i1(R$id.swipe_card_fault_layout)).j(fKFaultModel, new Function1<FKSwipeCardFaultType, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$showFaultPrompt$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FKSwipeCardFaultType fKSwipeCardFaultType) {
                invoke2(fKSwipeCardFaultType);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FKSwipeCardFaultType type) {
                kotlin.jvm.internal.s.i(type, "type");
                FKSwipeCardFragment.this.H1().setFaultClickEvent(type);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_swipe_card, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) i1(R$id.guide_lottie_view);
        if (fKLottieAnimationView != null) {
            fKLottieAnimationView.J();
        }
        SuperBoostManager.f18580a.y();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenFeedDetailEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (H1().checkHasAlohaOrNopeNum()) {
            a2(event.getPostId());
        } else {
            H1().checkSwipeNumToShowPurchase();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            u2();
            D1();
            return;
        }
        C1();
        h2();
        s2();
        t2();
        B1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (z2()) {
            ((FKSwipeCardSearchView) i1(R$id.swipe_card_search_view)).h();
            u2();
            B1();
        } else {
            D1();
        }
        ((FKSwipeCardClickButtonLayout) i1(R$id.swipe_card_click_button_layout)).D((SuperLikeDeliveryAnimLayout) i1(R$id.superlike_delivery));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FKSwipeCardViewModel H1 = H1();
        p1.g gVar = p1.g.f52734a;
        H1.setFilterSetting(gVar.l0().c());
        if (gVar.l()) {
            gVar.Y1(false);
            H1().setClearEvent();
        } else if (!v2()) {
            ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).postDelayed(new Runnable() { // from class: com.cupidapp.live.match.fragment.m
                @Override // java.lang.Runnable
                public final void run() {
                    FKSwipeCardFragment.b2(FKSwipeCardFragment.this);
                }
            }, 200L);
        }
        A2();
        if (z2()) {
            h2();
            if (!this.f16682i) {
                t2();
            } else {
                this.f16682i = false;
            }
            B1();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        Y1();
        J1();
        A1();
        X1();
        H1().checkShowSuperBoostGuide();
        FKRequestLocationDialogHelper.f16752a.a();
        H1().loadAlohaCard();
    }

    public final boolean p2() {
        return z2() && !v2();
    }

    public final void q2(String str) {
        p1.g.f52734a.U2(false);
        int i10 = R$id.guide_lottie_view;
        FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) i1(i10);
        if (fKLottieAnimationView != null) {
            fKLottieAnimationView.L();
        }
        TextView textView = (TextView) i1(R$id.guide_content);
        if (textView != null) {
            textView.setText(str);
        }
        FrameLayout frameLayout = (FrameLayout) i1(R$id.swipe_guide_cl);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FKLottieAnimationView fKLottieAnimationView2 = (FKLottieAnimationView) i1(i10);
        if (fKLottieAnimationView2 != null) {
            fKLottieAnimationView2.F(new e());
        }
        GroupOthersLog.f18702a.K(GroupOthersLog.GuideType.NEW_USER_ANM_AE, SensorPosition.Match, SensorScene.Match, str);
    }

    public final void r2() {
        int i10 = R$id.swipe_card_layout;
        if (((FKSwipeCardLayout) i1(i10)).getVisibility() == 0) {
            return;
        }
        ((FKSwipeCardSearchView) i1(R$id.swipe_card_search_view)).h();
        ((FKSwipeCardLayout) i1(i10)).c0(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$showSwipeCard$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKSwipeCardFragment.this.H1().setCancelNopeButtonVisible(true);
                FKSwipeCardViewModel.setAlohaOrNopeButtonVisible$default(FKSwipeCardFragment.this.H1(), FKSwipeCardFragment.this.E1() instanceof MatchRecommendUserModel, 0.0f, 2, null);
                FKSwipeCardFragment.this.s2();
            }
        });
        FKSwipeCardViewModel.setSwipeCardFault$default(H1(), false, false, 2, null);
    }

    public final void s2() {
        if (p2()) {
            if (kotlin.jvm.internal.s.d(p1.g.f52734a.y1().c(), Boolean.TRUE)) {
                ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).Z();
                H1().closeShowNewUserGuide();
                H1().changeGuideAnimLiveData(false);
                return;
            }
            H1().checkShowNewUserGuide();
        }
    }

    public final void t2() {
        H1().setStartOrStopPlayStream(false);
        ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).e0(false);
    }

    public final void u2() {
        H1().setStartOrStopPlayStream(true);
        ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).e0(true);
    }

    public final boolean v2() {
        List<Object> swipeCardData;
        FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) i1(R$id.swipe_card_layout);
        if (fKSwipeCardLayout == null || (swipeCardData = fKSwipeCardLayout.getSwipeCardData()) == null) {
            return false;
        }
        return swipeCardData.isEmpty();
    }

    public final void w2(MatchMarketingModel matchMarketingModel, Direction direction, boolean z10) {
        int i10 = direction == null ? -1 : a.f16685a[direction.ordinal()];
        if (i10 == 1) {
            H1().nopeCampaign(matchMarketingModel);
            if (z10) {
                d2(matchMarketingModel, GroupSocialLog.CampaignOperateAction.NOPE);
                return;
            }
            return;
        }
        if (i10 == 2 && z10) {
            j.a.b(com.cupidapp.live.base.router.j.f12156c, getContext(), matchMarketingModel.getJumpUrl(), null, 4, null);
            d2(matchMarketingModel, GroupSocialLog.CampaignOperateAction.ALOHA);
        }
    }

    public final void x2(MatchGroupCampaignModel matchGroupCampaignModel, Direction direction, boolean z10) {
        int i10 = direction == null ? -1 : a.f16685a[direction.ordinal()];
        if (i10 == 1) {
            H1().nopeCampaign(matchGroupCampaignModel);
            if (z10) {
                d2(matchGroupCampaignModel, GroupSocialLog.CampaignOperateAction.NOPE);
                return;
            }
            return;
        }
        if (i10 != 2) {
            return;
        }
        H1().nopeCampaign(matchGroupCampaignModel);
        if (z10) {
            j.a.b(com.cupidapp.live.base.router.j.f12156c, getContext(), matchGroupCampaignModel.getJumpUrl(), null, 4, null);
            d2(matchGroupCampaignModel, GroupSocialLog.CampaignOperateAction.ALOHA);
        }
    }

    public final void y2(MatchRecommendUserModel matchRecommendUserModel, Direction direction, int i10) {
        int i11 = direction == null ? -1 : a.f16685a[direction.ordinal()];
        if (i11 == 1) {
            H1().setSwipeCardCount(true);
            H1().nopeCard(matchRecommendUserModel, this.f16679f, i10);
            this.f16679f = FollowPrefer.Aloha.getValue();
            FKRequestLocationDialogHelper.d(FKRequestLocationDialogHelper.f16752a, getContext(), G1(), null, 4, null);
            return;
        }
        if (i11 != 2) {
            return;
        }
        H1().setSwipeCardCount(true);
        if (!matchRecommendUserModel.getUser().getSuperLikedByMe()) {
            H1().alohaCard(matchRecommendUserModel, this.f16679f, i10);
            this.f16679f = FollowPrefer.Aloha.getValue();
        }
        if (matchRecommendUserModel.isOfficial()) {
            return;
        }
        FKRequestLocationDialogHelper.d(FKRequestLocationDialogHelper.f16752a, getContext(), G1(), null, 4, null);
    }

    public final void z1() {
        H1().setNopeCardClick();
        H1().setCancelNopeButtonVisible(false);
    }

    public final boolean z2() {
        if (!isHidden()) {
            Fragment parentFragment = getParentFragment();
            if ((parentFragment == null || parentFragment.isHidden()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) i1(R$id.swipe_card_layout);
        Object K = fKSwipeCardLayout != null ? FKSwipeCardLayout.K(fKSwipeCardLayout, 0, 1, null) : null;
        if (K instanceof MatchRecommendUserModel) {
            User user = event.getUser();
            if (kotlin.jvm.internal.s.d(((MatchRecommendUserModel) K).getUser().userId(), user.userId()) && event.getNotifyMatchCardSwipe() && user.getAloha()) {
                this.f16679f = ViewProfilePrefer.AlohaToProfile.getValue();
                H1().alohaOrNopeClick(true);
            }
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SuperBoostStateChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        SuperBoostManager.p(SuperBoostManager.f18580a, null, 1, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FakeUserUploadAvatarEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        if (p1.g.f52734a.i() != null) {
            ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).E();
            j2();
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ReloadSwipeCardEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        f2();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull final ShowMoreDailyHeartEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        final Context context = getContext();
        if (context != null) {
            MoreDailyHeartBoysLayout moreDailyHeartBoysLayout = (MoreDailyHeartBoysLayout) i1(R$id.more_heart_boys_layout);
            if (moreDailyHeartBoysLayout != null) {
                moreDailyHeartBoysLayout.f(new SpannableString(event.getModel().getDescribe()), event.getModel().getViewList(), R$drawable.shape_dialog_heart_bg, ContextCompat.getColor(context, R$color.yellow_925A0E), Integer.valueOf(R$mipmap.yellow_icon_arrow_right), new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKSwipeCardFragment$onEvent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.p invoke() {
                        invoke2();
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MoreDailyHeartBoysLayout moreDailyHeartBoysLayout2 = (MoreDailyHeartBoysLayout) FKSwipeCardFragment.this.i1(R$id.more_heart_boys_layout);
                        if (moreDailyHeartBoysLayout2 != null) {
                            moreDailyHeartBoysLayout2.setVisibility(8);
                        }
                        NotifyActivity.f17492s.a(context, NotifyPageType.DailyHeart, false);
                        GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                        OthersProtos.Enum_type enum_type = OthersProtos.Enum_type.DAILY_HEART_GUIDE;
                        Integer popType = event.getModel().getPopType();
                        groupOthersLog.o(enum_type, popType != null ? popType.toString() : null, event.getModel().getDescribe());
                    }
                });
            }
            GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
            OthersProtos.Enum_type enum_type = OthersProtos.Enum_type.DAILY_HEART_GUIDE;
            Integer popType = event.getModel().getPopType();
            groupOthersLog.q(enum_type, popType != null ? popType.toString() : null);
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UpdateLiveShowEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        FKSwipeCardLayout fKSwipeCardLayout = (FKSwipeCardLayout) i1(R$id.swipe_card_layout);
        Object K = fKSwipeCardLayout != null ? FKSwipeCardLayout.K(fKSwipeCardLayout, 0, 1, null) : null;
        if (K instanceof MatchRecommendUserModel) {
            LiveShowModel liveShow = event.getLiveShow();
            if (kotlin.jvm.internal.s.d(liveShow.getUser().userId(), ((MatchRecommendUserModel) K).getUser().userId()) && liveShow.getUser().getAloha()) {
                this.f16679f = FollowPrefer.LiveShow.getValue();
                H1().alohaOrNopeClick(true);
            }
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        if (H1().checkHasAlohaOrNopeNum()) {
            return;
        }
        ((FKSwipeCardLayout) i1(R$id.swipe_card_layout)).E();
        j2();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowGuideBubbleEvent event) {
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout;
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        int i10 = R$id.swipe_card_click_button_layout;
        FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout2 = (FKSwipeCardClickButtonLayout) i1(i10);
        if (fKSwipeCardClickButtonLayout2 != null) {
            fKSwipeCardClickButtonLayout2.q();
        }
        String type = event.getType();
        if (kotlin.jvm.internal.s.d(type, ActivationType.SuperLike.getValue())) {
            FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout3 = (FKSwipeCardClickButtonLayout) i1(i10);
            if (fKSwipeCardClickButtonLayout3 != null) {
                fKSwipeCardClickButtonLayout3.N();
            }
            EventBus.c().o(new SuperLikeBtnShowEvent());
            return;
        }
        if (!kotlin.jvm.internal.s.d(type, ActivationType.SuperBoost.getValue()) || (fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) i1(i10)) == null) {
            return;
        }
        fKSwipeCardClickButtonLayout.K();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull VipPurchaseSuccessEvent event) {
        FKSwipeCardLayout fKSwipeCardLayout;
        kotlin.jvm.internal.s.i(event, "event");
        if (isResumed() && isVisible()) {
            Fragment parentFragment = getParentFragment();
            boolean z10 = false;
            if (parentFragment != null && parentFragment.isVisible()) {
                z10 = true;
            }
            if (z10 && (E1() instanceof MatchMarketingModel) && (fKSwipeCardLayout = (FKSwipeCardLayout) i1(R$id.swipe_card_layout)) != null) {
                fKSwipeCardLayout.f0(true);
            }
        }
    }
}
