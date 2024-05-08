package com.cupidapp.live.match.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.club.model.ClubInfoModel;
import com.cupidapp.live.match.event.CloseNearbyUserProfileEvent;
import com.cupidapp.live.match.event.UserDataChangeEvent;
import com.cupidapp.live.match.fragment.NearByMiniProfileFragment;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import com.cupidapp.live.match.model.NearbyUserResult;
import com.cupidapp.live.match.view.MatchFKProfileLayout;
import com.cupidapp.live.match.view.TipUiModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.ShowMoreDailyHeartEvent;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.helper.CancelAttentionHelper;
import com.cupidapp.live.superlike.view.SuperLikeDialogLayout;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.track.group.MiniProfileShowType;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: NearByMiniProfileFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByMiniProfileFragment extends FKBaseFragment {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f16699r = new a(null);

    /* renamed from: s, reason: collision with root package name */
    public static boolean f16700s;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16706j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public NearbyUserModel f16707k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16708l;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public NearbyUserProfileModel f16712p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16713q = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f16701e = kotlin.c.b(new Function0<SensorScene>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$scene$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final SensorScene invoke() {
            Bundle arguments = NearByMiniProfileFragment.this.getArguments();
            if (arguments != null) {
                return (SensorScene) z0.g.b(arguments, SensorScene.class);
            }
            return null;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f16702f = kotlin.c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$source$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final SensorPosition invoke() {
            Bundle arguments = NearByMiniProfileFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("data_source") : null;
            if (serializable instanceof SensorPosition) {
                return (SensorPosition) serializable;
            }
            return null;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f16703g = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$isUsingMap$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            Bundle arguments = NearByMiniProfileFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("isUsingMap") : false);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f16704h = kotlin.c.b(new Function0<VipPurchaseEntranceType>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$type$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final VipPurchaseEntranceType invoke() {
            Bundle arguments = NearByMiniProfileFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("data_type") : null;
            VipPurchaseEntranceType vipPurchaseEntranceType = serializable instanceof VipPurchaseEntranceType ? (VipPurchaseEntranceType) serializable : null;
            return vipPurchaseEntranceType == null ? VipPurchaseEntranceType.NearbyCardHeart : vipPurchaseEntranceType;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f16705i = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = NearByMiniProfileFragment.this.getContext();
            Lifecycle lifecycle = NearByMiniProfileFragment.this.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f16709m = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$mSensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            Bundle arguments = NearByMiniProfileFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("data_source") : null;
            SensorPosition sensorPosition = serializable instanceof SensorPosition ? (SensorPosition) serializable : null;
            SensorPosition O0 = NearByMiniProfileFragment.this.O0();
            if (sensorPosition == null) {
                sensorPosition = SensorPosition.Nearby;
            }
            Bundle arguments2 = NearByMiniProfileFragment.this.getArguments();
            return new FKSensorContext(O0, sensorPosition, null, arguments2 != null ? (SensorScene) z0.g.b(arguments2, SensorScene.class) : null);
        }
    });

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f16710n = kotlin.c.b(new Function0<ClubInfoModel>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$clubInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final ClubInfoModel invoke() {
            Bundle arguments = NearByMiniProfileFragment.this.getArguments();
            if (arguments != null) {
                return (ClubInfoModel) z0.g.b(arguments, ClubInfoModel.class);
            }
            return null;
        }
    });

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final Lazy f16711o = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$fromSpecialExposure$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            Bundle arguments = NearByMiniProfileFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("IS_FROM_SPECIAL_EXPOSURE") : false);
        }
    });

    /* compiled from: NearByMiniProfileFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return NearByMiniProfileFragment.f16700s;
        }

        @NotNull
        public final NearByMiniProfileFragment b(@NotNull NearbyUserModel model, @NotNull SensorScene scene, boolean z10, @Nullable TipUiModel tipUiModel, boolean z11, @Nullable VipPurchaseEntranceType vipPurchaseEntranceType, @Nullable SensorPosition sensorPosition, @Nullable MiniProfileShowType miniProfileShowType, @Nullable ClubInfoModel clubInfoModel, boolean z12) {
            kotlin.jvm.internal.s.i(model, "model");
            kotlin.jvm.internal.s.i(scene, "scene");
            NearByMiniProfileFragment nearByMiniProfileFragment = new NearByMiniProfileFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, model);
            z0.g.d(bundle, scene);
            bundle.putSerializable("tip", tipUiModel);
            bundle.putSerializable("data_type", vipPurchaseEntranceType);
            bundle.putSerializable("data_source", sensorPosition);
            bundle.putBoolean("isUsingMap", z10);
            bundle.putBoolean("data_need_buy", z11);
            if (miniProfileShowType != null) {
                z0.g.d(bundle, miniProfileShowType);
            }
            if (clubInfoModel != null) {
                z0.g.d(bundle, clubInfoModel);
            }
            bundle.putBoolean("IS_FROM_SPECIAL_EXPOSURE", z12);
            nearByMiniProfileFragment.setArguments(bundle);
            return nearByMiniProfileFragment;
        }
    }

    /* compiled from: NearByMiniProfileFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16714a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16715b;

        static {
            int[] iArr = new int[SensorScene.values().length];
            try {
                iArr[SensorScene.Nearby.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorScene.MapFind.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SensorScene.NearbySameCityRecommend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16714a = iArr;
            int[] iArr2 = new int[SensorPosition.values().length];
            try {
                iArr2[SensorPosition.HeartUnlock.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SensorPosition.DailyHeart.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SensorPosition.Nearby.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SensorPosition.SuperExposure.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SensorPosition.Feed.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SensorPosition.RainbowRecommend.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            f16715b = iArr2;
        }
    }

    /* compiled from: NearByMiniProfileFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            FragmentActivity activity = NearByMiniProfileFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final SensorScene A1() {
        return (SensorScene) this.f16701e.getValue();
    }

    public final SensorPosition B1() {
        return (SensorPosition) this.f16702f.getValue();
    }

    public final VipPurchaseEntranceType C1() {
        return (VipPurchaseEntranceType) this.f16704h.getValue();
    }

    public final void D1(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        SensorScene A1 = A1();
        int i10 = A1 == null ? -1 : b.f16714a[A1.ordinal()];
        Disposable disposed = NetworkClient.f11868a.A().b(str, (i10 == 1 || i10 == 2 || i10 == 3) ? ViewProfilePrefer.NearbyToProfile.getValue() : null, G1()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NearbyUserResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$getUserData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NearbyUserResult nearbyUserResult) {
                m2714invoke(nearbyUserResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2714invoke(NearbyUserResult nearbyUserResult) {
                SensorScene A12;
                NearbyUserModel nearbyUserModel;
                MiniProfileShowType miniProfileShowType;
                boolean x12;
                boolean z10;
                NearbyUserResult nearbyUserResult2 = nearbyUserResult;
                NearByMiniProfileFragment.this.E1(nearbyUserResult2.getUser());
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                A12 = NearByMiniProfileFragment.this.A1();
                String value = A12 != null ? A12.getValue() : null;
                nearbyUserModel = NearByMiniProfileFragment.this.f16707k;
                String id2 = nearbyUserModel != null ? nearbyUserModel.getId() : null;
                Bundle arguments = NearByMiniProfileFragment.this.getArguments();
                if (arguments != null) {
                    kotlin.jvm.internal.s.h(arguments, "arguments");
                    miniProfileShowType = (MiniProfileShowType) z0.g.b(arguments, MiniProfileShowType.class);
                } else {
                    miniProfileShowType = null;
                }
                x12 = NearByMiniProfileFragment.this.x1();
                String travelCity = nearbyUserResult2.getUser().getTravelCity();
                if (travelCity != null) {
                    if (travelCity.length() > 0) {
                        z10 = true;
                        groupSocialLog.E(value, id2, miniProfileShowType, x12, z10);
                    }
                }
                z10 = false;
                groupSocialLog.E(value, id2, miniProfileShowType, x12, z10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void E1(NearbyUserProfileModel nearbyUserProfileModel) {
        this.f16712p = nearbyUserProfileModel;
        ((MatchFKProfileLayout) S0(R$id.profileCardView)).k(nearbyUserProfileModel, this.f16706j);
        r1(nearbyUserProfileModel);
        L1(nearbyUserProfileModel.getTravelCity());
        if (nearbyUserProfileModel.isMyself()) {
            ((ImageView) S0(R$id.followImage)).setVisibility(8);
            ((ImageView) S0(R$id.startChatButton)).setVisibility(8);
            ((ImageView) S0(R$id.nearby_mini_profile_super_like_btn)).setVisibility(8);
            return;
        }
        t1(nearbyUserProfileModel.getMatch(), nearbyUserProfileModel.getAloha(), nearbyUserProfileModel.isNotShowSuperLikeBtn(), nearbyUserProfileModel.isMyself());
    }

    public final void F1() {
        int i10 = R$id.profileCardView;
        ((MatchFKProfileLayout) S0(i10)).getLayoutParams().height = (z0.h.l(this) / 3) * 4;
        MatchFKProfileLayout matchFKProfileLayout = (MatchFKProfileLayout) S0(i10);
        NearbyUserModel nearbyUserModel = this.f16707k;
        Bundle arguments = getArguments();
        matchFKProfileLayout.setData(nearbyUserModel, (TipUiModel) (arguments != null ? arguments.getSerializable("tip") : null));
        if (this.f16706j) {
            int i11 = R$id.heart_beat_buy_btn;
            ((TextView) S0(i11)).setVisibility(0);
            TextView heart_beat_buy_btn = (TextView) S0(i11);
            kotlin.jvm.internal.s.h(heart_beat_buy_btn, "heart_beat_buy_btn");
            z0.u.a(heart_beat_buy_btn);
            ((RelativeLayout) S0(R$id.like_rl)).setVisibility(8);
            ((ImageView) S0(R$id.nearby_mini_profile_super_like_btn)).setVisibility(8);
            TextView heart_beat_buy_btn2 = (TextView) S0(i11);
            kotlin.jvm.internal.s.h(heart_beat_buy_btn2, "heart_beat_buy_btn");
            z0.y.d(heart_beat_buy_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$initView$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                    invoke2(view);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    PurchaseDialogManager z1;
                    VipPurchaseEntranceType C1;
                    SensorsLogKeyButtonClick.NearbyCoverCard.UNLOCK.click();
                    z1 = NearByMiniProfileFragment.this.z1();
                    C1 = NearByMiniProfileFragment.this.C1();
                    PurchaseDialogManager.q(z1, C1, null, null, false, false, 30, null);
                }
            });
        } else {
            ((TextView) S0(R$id.heart_beat_buy_btn)).setVisibility(8);
        }
        ImageView more_btn_imageview = (ImageView) S0(R$id.more_btn_imageview);
        kotlin.jvm.internal.s.h(more_btn_imageview, "more_btn_imageview");
        ClubInfoModel w12 = w1();
        more_btn_imageview.setVisibility(w12 != null ? w12.getCanKickOut() : false ? 0 : 8);
    }

    public final boolean G1() {
        return ((Boolean) this.f16703g.getValue()).booleanValue();
    }

    public final void H1() {
        String clubId;
        NearbyUserModel nearbyUserModel;
        String id2;
        ClubInfoModel w12 = w1();
        if (w12 == null || (clubId = w12.getClubId()) == null || (nearbyUserModel = this.f16707k) == null || (id2 = nearbyUserModel.getId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.u().g(clubId, id2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$kickOutClub$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FragmentActivity activity = NearByMiniProfileFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void I1(String str) {
        SensorsLogKeyButtonClick.NearbyCoverCard.Chat.click();
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$openChatDetail$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2715invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2715invoke(ProfileResult profileResult) {
                FKSensorContext y1;
                ProfileResult profileResult2 = profileResult;
                User user = profileResult2.getUser();
                String userId = profileResult2.getUser().userId();
                y1 = NearByMiniProfileFragment.this.y1();
                ChatDetailActivity.f13276r.a(NearByMiniProfileFragment.this.getContext(), new ChatBundleData(user, userId, y1, null, false, false, false, false, false, 504, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void J1(String str) {
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$openProfile$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2716invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2716invoke(ProfileResult profileResult) {
                SensorPosition B1;
                boolean x12;
                ViewProfilePrefer viewProfilePrefer;
                SensorScene A1;
                boolean G1;
                ProfileResult profileResult2 = profileResult;
                B1 = NearByMiniProfileFragment.this.B1();
                int i10 = B1 == null ? -1 : NearByMiniProfileFragment.b.f16715b[B1.ordinal()];
                if (i10 == 3 || i10 == 4) {
                    x12 = NearByMiniProfileFragment.this.x1();
                    viewProfilePrefer = x12 ? ViewProfilePrefer.SpecialExposureToProfile : ViewProfilePrefer.NearbyToProfile;
                } else if (i10 != 5 && i10 != 6) {
                    viewProfilePrefer = ViewProfilePrefer.NearbyToProfile;
                } else {
                    viewProfilePrefer = ViewProfilePrefer.SpecialExposureToProfile;
                }
                String value = viewProfilePrefer.getValue();
                boolean me2 = profileResult2.getUser().getMe();
                SensorPosition sensorPosition = SensorPosition.NearbyCoverCard;
                SensorPosition sensorPosition2 = SensorPosition.Nearby;
                A1 = NearByMiniProfileFragment.this.A1();
                ProfileSensorContext profileSensorContext = new ProfileSensorContext(value, null, me2, sensorPosition, sensorPosition2, A1);
                UserProfileActivity.a aVar = UserProfileActivity.G;
                Context context = NearByMiniProfileFragment.this.getContext();
                User user = profileResult2.getUser();
                G1 = NearByMiniProfileFragment.this.G1();
                aVar.a(context, user, profileSensorContext, (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : G1);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void K1() {
        F1();
        NearbyUserModel nearbyUserModel = this.f16707k;
        D1(nearbyUserModel != null ? nearbyUserModel.getId() : null);
        q1();
        M1();
    }

    public final void L1(String str) {
        Context context = getContext();
        if (context != null) {
            if (str == null || str.length() == 0) {
                ((TextView) S0(R$id.travelTipTextView)).setVisibility(8);
                return;
            }
            int i10 = R$id.travelTipTextView;
            TextView textView = (TextView) S0(i10);
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
            String string = context.getString(R$string.he_will_come_your_city);
            kotlin.jvm.internal.s.h(string, "it.getString(R.string.he_will_come_your_city)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            kotlin.jvm.internal.s.h(format, "format(format, *args)");
            textView.setText(format);
            ((TextView) S0(i10)).setVisibility(0);
        }
    }

    public final void M1() {
        p1.g gVar = p1.g.f52734a;
        if (kotlin.jvm.internal.s.d(gVar.r0(), Boolean.TRUE)) {
            gVar.S2(Boolean.FALSE);
            AnimatorSet animatorSet = new AnimatorSet();
            int i10 = R$id.tipTextView;
            animatorSet.play(ObjectAnimator.ofFloat((TextView) S0(i10), (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f)).with(ObjectAnimator.ofFloat((TextView) S0(i10), (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f, ((TextView) S0(i10)).getY() + z0.h.c(this, 80.0f))).before(ObjectAnimator.ofFloat((TextView) S0(i10), (Property<TextView, Float>) View.TRANSLATION_Y, ((TextView) S0(i10)).getY() + z0.h.c(this, 80.0f), 0.0f));
            ((TextView) S0(i10)).setVisibility(0);
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.start();
        }
        ObjectAnimator.ofFloat((MatchFKProfileLayout) S0(R$id.profileCardView), (Property<MatchFKProfileLayout, Float>) View.Y, z0.h.k(this), (r0 - ((z0.h.l(this) / 3) * 4)) / 2.0f).setDuration(200L).start();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16713q.clear();
    }

    public final void N1() {
        int i10 = R$id.profileCardView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((MatchFKProfileLayout) S0(i10), (Property<MatchFKProfileLayout, Float>) View.Y, ((MatchFKProfileLayout) S0(i10)).getY(), z0.h.k(this));
        ofFloat.setDuration(200L);
        ofFloat.addListener(new c());
        ofFloat.start();
        ((TextView) S0(R$id.travelTipTextView)).setVisibility(8);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.NearbyCoverCard;
    }

    public final void O1() {
        FKActionSheetDialog.f12692f.a(getContext()).f(kotlin.collections.s.o(new FKActionSheetItemModel(R$string.kick_out_club, ActionSheetItemType.Warning, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$showKickOutClubDialog$itemList$1
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
                NearByMiniProfileFragment.this.P1();
            }
        }, 28, null))).h();
    }

    public final void P1() {
        String str;
        String clubName;
        NearbyUserModel nearbyUserModel = this.f16707k;
        String str2 = "";
        if (nearbyUserModel == null || (str = nearbyUserModel.getName()) == null) {
            str = "";
        }
        ClubInfoModel w12 = w1();
        if (w12 != null && (clubName = w12.getClubName()) != null) {
            str2 = clubName;
        }
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null).D(R$string.tips).n(getString(R$string.kick_out_club_prompt, str, str2)), R$string.determine, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$showKickOutConfirmDialog$1
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
                NearByMiniProfileFragment.this.H1();
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
    }

    public final void Q1(final NearbyUserProfileModel nearbyUserProfileModel) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        SuperLikeDialogLayout.Companion companion = SuperLikeDialogLayout.f18632h;
        Lifecycle lifecycle = getLifecycle();
        String id2 = nearbyUserProfileModel.getId();
        String value = FollowPrefer.Nearby.getValue();
        VipPurchaseEntranceType C1 = C1();
        SensorPosition O0 = O0();
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        companion.b(context, lifecycle, id2, null, value, C1, (r27 & 64) != 0 ? null : null, O0, (r27 & 256) != 0 ? 1 : 0, new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$superLikeUser$1
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
                NearByMiniProfileFragment.this.v1(true, nearbyUserProfileModel, it);
            }
        }, (r27 & 1024) != 0 ? null : new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$superLikeUser$2
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
            public final void invoke2(@NotNull SwipeCardUserLikeResult result) {
                SensorScene A1;
                boolean z10;
                kotlin.jvm.internal.s.i(result, "result");
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                A1 = NearByMiniProfileFragment.this.A1();
                String value2 = A1 != null ? A1.getValue() : null;
                String id3 = nearbyUserProfileModel.getId();
                boolean isAlohaMatched = result.getUser().isAlohaMatched();
                Map<String, Object> recommendContext = result.getRecommendContext();
                SensorPosition O02 = NearByMiniProfileFragment.this.O0();
                boolean z11 = result.getUser().getProfileLevelIcon() != null;
                String travelCity = nearbyUserProfileModel.getTravelCity();
                if (travelCity != null) {
                    if (travelCity.length() > 0) {
                        z10 = true;
                        groupSocialLog.B(true, value2, id3, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : O02, (r52 & 512) != 0 ? false : true, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : Boolean.valueOf(z11), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z10));
                    }
                }
                z10 = false;
                groupSocialLog.B(true, value2, id3, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : O02, (r52 & 512) != 0 ? false : true, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : Boolean.valueOf(z11), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z10));
            }
        });
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16713q;
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

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z0.z.b(viewGroup, R$layout.fragment_nearby_profile, false, 2, null);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String id2;
        super.onDestroy();
        f16700s = false;
        if (B1() == SensorPosition.Nearby) {
            EventBus.c().o(new CloseNearbyUserProfileEvent());
            return;
        }
        if (B1() == SensorPosition.DailyHeart && this.f16708l) {
            EventBus c4 = EventBus.c();
            NearbyUserModel nearbyUserModel = this.f16707k;
            id2 = nearbyUserModel != null ? nearbyUserModel.getId() : null;
            NearbyUserProfileModel nearbyUserProfileModel = this.f16712p;
            c4.o(new UserDataChangeEvent(id2, nearbyUserProfileModel != null ? kotlin.jvm.internal.s.d(nearbyUserProfileModel.getAloha(), Boolean.TRUE) : false));
            return;
        }
        if (A1() == SensorScene.FeedRainbowRecommend) {
            EventBus c10 = EventBus.c();
            NearbyUserModel nearbyUserModel2 = this.f16707k;
            id2 = nearbyUserModel2 != null ? nearbyUserModel2.getId() : null;
            NearbyUserProfileModel nearbyUserProfileModel2 = this.f16712p;
            c10.o(new UserDataChangeEvent(id2, nearbyUserProfileModel2 != null ? kotlin.jvm.internal.s.d(nearbyUserProfileModel2.getAloha(), Boolean.TRUE) : false));
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        this.f16708l = true;
        User user = event.getUser();
        NearbyUserProfileModel nearbyUserProfileModel = this.f16712p;
        if (nearbyUserProfileModel != null) {
            nearbyUserProfileModel.setAloha(Boolean.valueOf(user.getAloha()));
            nearbyUserProfileModel.setAlohaGet(Boolean.valueOf(user.getAlohaGet()));
            nearbyUserProfileModel.setMatch(Boolean.valueOf(user.getMatch()));
        }
        t1(Boolean.valueOf(user.getMatch()), Boolean.valueOf(user.getAloha()), user.isNotShowSuperLikeBtn(), user.isMyself());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        f16700s = true;
        Bundle arguments = getArguments();
        this.f16707k = arguments != null ? (NearbyUserModel) z0.g.b(arguments, NearbyUserModel.class) : null;
        Bundle arguments2 = getArguments();
        this.f16706j = arguments2 != null ? arguments2.getBoolean("data_need_buy") : false;
        if (this.f16707k == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        } else {
            K1();
        }
        Context context = getContext();
        if (context != null) {
            ImageView more_btn_imageview = (ImageView) S0(R$id.more_btn_imageview);
            kotlin.jvm.internal.s.h(more_btn_imageview, "more_btn_imageview");
            com.cupidapp.live.base.view.s.b(context, more_btn_imageview);
        }
    }

    public final void q1() {
        ConstraintLayout profileAnimationLayout = (ConstraintLayout) S0(R$id.profileAnimationLayout);
        kotlin.jvm.internal.s.h(profileAnimationLayout, "profileAnimationLayout");
        z0.y.d(profileAnimationLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindCommonClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                NearByMiniProfileFragment.this.N1();
            }
        });
        int i10 = R$id.profileCardView;
        ((MatchFKProfileLayout) S0(i10)).setBackEvent(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindCommonClickEvent$2
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
                NearByMiniProfileFragment.this.N1();
            }
        });
        MatchFKProfileLayout matchFKProfileLayout = (MatchFKProfileLayout) S0(i10);
        if (matchFKProfileLayout != null) {
            matchFKProfileLayout.setMoveEvent(new Function2<Float, Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindCommonClickEvent$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Float f10, Boolean bool) {
                    invoke(f10.floatValue(), bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(float f10, boolean z10) {
                    if (z10) {
                        ((ConstraintLayout) NearByMiniProfileFragment.this.S0(R$id.profileAnimationLayout)).setY(0.0f);
                    } else {
                        ((ConstraintLayout) NearByMiniProfileFragment.this.S0(R$id.profileAnimationLayout)).setY(f10);
                    }
                }
            });
        }
        ImageView more_btn_imageview = (ImageView) S0(R$id.more_btn_imageview);
        kotlin.jvm.internal.s.h(more_btn_imageview, "more_btn_imageview");
        z0.y.d(more_btn_imageview, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindCommonClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                NearByMiniProfileFragment.this.O1();
            }
        });
    }

    public final void r1(final NearbyUserProfileModel nearbyUserProfileModel) {
        ImageView followImage = (ImageView) S0(R$id.followImage);
        kotlin.jvm.internal.s.h(followImage, "followImage");
        z0.y.d(followImage, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindRelationClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                NearByMiniProfileFragment.this.u1(nearbyUserProfileModel);
            }
        });
        ImageView nearby_mini_profile_super_like_btn = (ImageView) S0(R$id.nearby_mini_profile_super_like_btn);
        kotlin.jvm.internal.s.h(nearby_mini_profile_super_like_btn, "nearby_mini_profile_super_like_btn");
        z0.y.d(nearby_mini_profile_super_like_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindRelationClickEvent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                NearByMiniProfileFragment.this.Q1(nearbyUserProfileModel);
            }
        });
        ImageView cancelFollowButton = (ImageView) S0(R$id.cancelFollowButton);
        kotlin.jvm.internal.s.h(cancelFollowButton, "cancelFollowButton");
        z0.y.d(cancelFollowButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindRelationClickEvent$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                NearByMiniProfileFragment.this.s1(nearbyUserProfileModel);
            }
        });
        ImageView startChatButton = (ImageView) S0(R$id.startChatButton);
        kotlin.jvm.internal.s.h(startChatButton, "startChatButton");
        z0.y.d(startChatButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindRelationClickEvent$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                NearByMiniProfileFragment.this.I1(nearbyUserProfileModel.getId());
            }
        });
        ((MatchFKProfileLayout) S0(R$id.profileCardView)).setMenuClick(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$bindRelationClickEvent$5
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
                boolean z10;
                z10 = NearByMiniProfileFragment.this.f16706j;
                if (z10) {
                    return;
                }
                NearByMiniProfileFragment.this.J1(nearbyUserProfileModel.getId());
            }
        });
    }

    public final void s1(final NearbyUserProfileModel nearbyUserProfileModel) {
        CancelAttentionHelper.f18615a.a(getContext(), nearbyUserProfileModel, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$cancelFollow$1
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
                SensorScene A1;
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                A1 = NearByMiniProfileFragment.this.A1();
                sensorsLogFeed.b(A1 != null ? A1.getValue() : null, nearbyUserProfileModel.getId(), SensorPosition.NearbyCoverCard, nearbyUserProfileModel.getSuperLikedByMe());
                Observable n10 = a.C0836a.n(NetworkClient.f11868a.N(), nearbyUserProfileModel.getId(), null, null, 4, null);
                final NearByMiniProfileFragment nearByMiniProfileFragment = NearByMiniProfileFragment.this;
                final NearbyUserProfileModel nearbyUserProfileModel2 = nearbyUserProfileModel;
                Disposable disposed = n10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$cancelFollow$1$invoke$$inlined$handle$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        m2712invoke(swipeCardUserLikeResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2712invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                        NearbyUserProfileModel.this.setMatch(Boolean.valueOf(swipeCardUserLikeResult2.getUser().getMatch()));
                        NearbyUserProfileModel.this.setAloha(Boolean.valueOf(swipeCardUserLikeResult2.getUser().getAloha()));
                        NearByMiniProfileFragment nearByMiniProfileFragment2 = nearByMiniProfileFragment;
                        Boolean bool = Boolean.FALSE;
                        nearByMiniProfileFragment2.t1(bool, bool, false, NearbyUserProfileModel.this.isMyself());
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, nearByMiniProfileFragment)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (nearByMiniProfileFragment != null) {
                        nearByMiniProfileFragment.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
                NearByMiniProfileFragment.this.f16708l = true;
            }
        });
    }

    public final void t1(Boolean bool, Boolean bool2, boolean z10, boolean z11) {
        int i10;
        RelativeLayout relativeLayout = (RelativeLayout) S0(R$id.like_rl);
        if (this.f16706j || z11) {
            i10 = 8;
        } else {
            Boolean bool3 = Boolean.TRUE;
            if (kotlin.jvm.internal.s.d(bool, bool3)) {
                ((ImageView) S0(R$id.startChatButton)).setVisibility(0);
                ((ImageView) S0(R$id.followImage)).setVisibility(8);
                ((ImageView) S0(R$id.cancelFollowButton)).setVisibility(8);
            } else if (kotlin.jvm.internal.s.d(bool2, bool3)) {
                ((ImageView) S0(R$id.startChatButton)).setVisibility(8);
                ((ImageView) S0(R$id.followImage)).setVisibility(8);
                ((ImageView) S0(R$id.cancelFollowButton)).setVisibility(0);
            } else {
                ((ImageView) S0(R$id.cancelFollowButton)).setVisibility(8);
                ((ImageView) S0(R$id.startChatButton)).setVisibility(8);
                ((ImageView) S0(R$id.followImage)).setVisibility(0);
            }
            i10 = 0;
        }
        relativeLayout.setVisibility(i10);
        ((ImageView) S0(R$id.nearby_mini_profile_super_like_btn)).setVisibility((z11 || z10 || this.f16706j || !p1.g.f52734a.M3()) ? 8 : 0);
    }

    public final void u1(final NearbyUserProfileModel nearbyUserProfileModel) {
        FollowPrefer followPrefer;
        SensorPosition B1 = B1();
        switch (B1 == null ? -1 : b.f16715b[B1.ordinal()]) {
            case 1:
            case 2:
                followPrefer = FollowPrefer.DailyLike;
                break;
            case 3:
            case 4:
                if (!x1()) {
                    followPrefer = FollowPrefer.Nearby;
                    break;
                } else {
                    followPrefer = FollowPrefer.NearbySpecialExposure;
                    break;
                }
            case 5:
            case 6:
                followPrefer = FollowPrefer.PostSpecialExposure;
                break;
            default:
                followPrefer = FollowPrefer.Nearby;
                break;
        }
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), nearbyUserProfileModel.getId(), null, null, followPrefer.getValue(), 0, null, null, null, 246, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.NearByMiniProfileFragment$followClick$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2713invoke(swipeCardUserLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2713invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                NearByMiniProfileFragment.this.v1(false, nearbyUserProfileModel, swipeCardUserLikeResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void v1(boolean z10, NearbyUserProfileModel nearbyUserProfileModel, SwipeCardUserLikeResult swipeCardUserLikeResult) {
        FragmentActivity activity;
        boolean z11;
        this.f16708l = true;
        nearbyUserProfileModel.setSuperLikedByMe(z10);
        nearbyUserProfileModel.setMatch(Boolean.valueOf(swipeCardUserLikeResult.getUser().getMatch()));
        nearbyUserProfileModel.setAloha(Boolean.valueOf(swipeCardUserLikeResult.getUser().getAloha()));
        AppDialogModel window = swipeCardUserLikeResult.getWindow();
        if (window != null) {
            FKAppRatingLayout.f11658f.c(kotlin.collections.r.e(window));
        }
        t1(Boolean.valueOf(swipeCardUserLikeResult.getUser().getMatch()), Boolean.valueOf(swipeCardUserLikeResult.getUser().getAloha()), swipeCardUserLikeResult.getUser().isNotShowSuperLikeBtn(), swipeCardUserLikeResult.getUser().isMyself());
        if (!z10) {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            SensorScene A1 = A1();
            String value = A1 != null ? A1.getValue() : null;
            String id2 = nearbyUserProfileModel.getId();
            boolean isAlohaMatched = swipeCardUserLikeResult.getUser().isAlohaMatched();
            Map<String, Object> recommendContext = swipeCardUserLikeResult.getRecommendContext();
            SensorPosition O0 = O0();
            boolean z12 = swipeCardUserLikeResult.getUser().getProfileLevelIcon() != null;
            boolean x12 = x1();
            String travelCity = nearbyUserProfileModel.getTravelCity();
            if (travelCity != null) {
                if (travelCity.length() > 0) {
                    z11 = true;
                    groupSocialLog.B(true, value, id2, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : O0, (r52 & 512) != 0 ? false : z10, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : Boolean.valueOf(z12), (524288 & r52) != 0 ? null : Boolean.valueOf(x12), (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z11));
                }
            }
            z11 = false;
            groupSocialLog.B(true, value, id2, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : O0, (r52 & 512) != 0 ? false : z10, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : Boolean.valueOf(z12), (524288 & r52) != 0 ? null : Boolean.valueOf(x12), (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z11));
        }
        if (swipeCardUserLikeResult.getDailyLikePopInfo() != null) {
            EventBus.c().o(new ShowMoreDailyHeartEvent(swipeCardUserLikeResult.getDailyLikePopInfo()));
        }
        if (B1() != SensorPosition.DailyHeart || (activity = getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    public final ClubInfoModel w1() {
        return (ClubInfoModel) this.f16710n.getValue();
    }

    public final boolean x1() {
        return ((Boolean) this.f16711o.getValue()).booleanValue();
    }

    public final FKSensorContext y1() {
        return (FKSensorContext) this.f16709m.getValue();
    }

    public final PurchaseDialogManager z1() {
        return (PurchaseDialogManager) this.f16705i.getValue();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        if (this.f16706j && com.cupidapp.live.profile.logic.c.f17839a.d()) {
            this.f16706j = false;
            K1();
        }
    }
}
