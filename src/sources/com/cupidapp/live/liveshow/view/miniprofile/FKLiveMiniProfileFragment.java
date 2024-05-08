package com.cupidapp.live.liveshow.view.miniprofile;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowUtil;
import com.cupidapp.live.liveshow.model.ActionModel;
import com.cupidapp.live.liveshow.model.CardInfoModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.MiniProfileUserTagModel;
import com.cupidapp.live.liveshow.model.UserProfileInfoResult;
import com.cupidapp.live.liveshow.view.tag.UserGiftWallLayout;
import com.cupidapp.live.liveshow.view.tag.UserLiveShowRanksLinearLayout;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.helper.CancelAttentionHelper;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;
import x2.a;
import z0.g;
import z0.y;

/* compiled from: FKLiveMiniProfileFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniProfileFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f15750k = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public UserProfileInfoResult f15752f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15753g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15754h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15755i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15756j = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15751e = kotlin.c.b(new Function0<ShowLiveMiniProfileViewModel>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$miniProfile$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final ShowLiveMiniProfileViewModel invoke() {
            Bundle arguments = FKLiveMiniProfileFragment.this.getArguments();
            if (arguments != null) {
                return (ShowLiveMiniProfileViewModel) g.b(arguments, ShowLiveMiniProfileViewModel.class);
            }
            return null;
        }
    });

    /* compiled from: FKLiveMiniProfileFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKLiveMiniProfileFragment a(@Nullable FragmentManager fragmentManager, @NotNull ShowLiveMiniProfileViewModel miniProfile, @Nullable String str) {
            s.i(miniProfile, "miniProfile");
            if (fragmentManager == null) {
                return null;
            }
            FKLiveMiniProfileFragment fKLiveMiniProfileFragment = new FKLiveMiniProfileFragment();
            Bundle bundle = new Bundle();
            g.d(bundle, miniProfile);
            bundle.putString("ENTER_SOURCE", str);
            fKLiveMiniProfileFragment.setArguments(bundle);
            fKLiveMiniProfileFragment.show(fragmentManager, FKLiveMiniProfileFragment.class.getSimpleName());
            return fKLiveMiniProfileFragment;
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
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
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
            ((TextView) FKLiveMiniProfileFragment.this.V0(R$id.photoCountTextView)).setVisibility(0);
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            ((TextView) FKLiveMiniProfileFragment.this.V0(R$id.photoCountTextView)).setVisibility(4);
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

    public final void A1(String str) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.N().s(itemId, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$kickOut$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                h.f12779a.b(R$string.operation_successful);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void B1() {
        u2.a r10 = NetworkClient.f11868a.r();
        ShowLiveMiniProfileViewModel x12 = x1();
        String userId = x12 != null ? x12.getUserId() : null;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        Disposable disposed = a.C0826a.l(r10, userId, liveShowModel != null ? liveShowModel.getItemId() : null, 0, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UserProfileInfoResult, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$loadMiniProfileData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserProfileInfoResult userProfileInfoResult) {
                m2654invoke(userProfileInfoResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2654invoke(UserProfileInfoResult userProfileInfoResult) {
                UserProfileInfoResult userProfileInfoResult2 = userProfileInfoResult;
                FKLiveMiniProfileFragment.this.f15752f = userProfileInfoResult2;
                FKLiveMiniProfileFragment.this.p1(userProfileInfoResult2);
                FKLiveMiniProfileFragment.this.q1(userProfileInfoResult2);
                FKLiveMiniProfileFragment.this.r1(userProfileInfoResult2);
                FKLiveMiniProfileFragment.this.n1(userProfileInfoResult2);
                FKLiveMiniProfileFragment.this.o1(userProfileInfoResult2);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void C1(User user) {
        FKLiveMiniWindowUtil.f15095a.f(getActivity(), "miniProfile查看资料", false);
        G1(user);
    }

    public final void D1(String str) {
        Disposable disposed = NetworkClient.f11868a.N().z(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$setAdmin$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                h.f12779a.b(R$string.set_success);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void E1() {
        int i10 = R$id.photoCountTextView;
        ObjectAnimator showAnimation$lambda$2 = ObjectAnimator.ofFloat((TextView) V0(i10), (Property<TextView, Float>) View.TRANSLATION_Y, z0.h.c(this, 39.0f), 0.0f);
        showAnimation$lambda$2.setStartDelay(300L);
        showAnimation$lambda$2.setDuration(200L);
        s.h(showAnimation$lambda$2, "showAnimation$lambda$2");
        showAnimation$lambda$2.addListener(new b());
        this.f15754h = showAnimation$lambda$2;
        ObjectAnimator showAnimation$lambda$4 = ObjectAnimator.ofFloat((TextView) V0(i10), (Property<TextView, Float>) View.ALPHA, 1.0f, 0.0f);
        showAnimation$lambda$4.setStartDelay(3300L);
        showAnimation$lambda$4.setDuration(200L);
        s.h(showAnimation$lambda$4, "showAnimation$lambda$4");
        showAnimation$lambda$4.addListener(new c());
        this.f15755i = showAnimation$lambda$4;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f15754h).with(this.f15755i);
        this.f15753g = animatorSet;
        animatorSet.start();
    }

    public final void F1(UserProfileInfoResult userProfileInfoResult) {
        final User user = userProfileInfoResult.getUser();
        if (user == null) {
            return;
        }
        LiveRoomManagementHelper.f15768a.f(getContext(), userProfileInfoResult.getShowLiveBan(), userProfileInfoResult.getShowKickOut(), userProfileInfoResult.getShowSetAdmin(), user.getBan(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$showManageMenu$1
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
                LiveRoomManagementHelper liveRoomManagementHelper = LiveRoomManagementHelper.f15768a;
                Context context = FKLiveMiniProfileFragment.this.getContext();
                boolean ban = user.getBan();
                String name = user.getName();
                final FKLiveMiniProfileFragment fKLiveMiniProfileFragment = FKLiveMiniProfileFragment.this;
                final User user2 = user;
                liveRoomManagementHelper.d(context, ban, name, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$showManageMenu$1.1
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
                        FKLiveMiniProfileFragment.this.l1(user2);
                    }
                });
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$showManageMenu$2
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
                LiveRoomManagementHelper liveRoomManagementHelper = LiveRoomManagementHelper.f15768a;
                Context context = FKLiveMiniProfileFragment.this.getContext();
                String name = user.getName();
                final FKLiveMiniProfileFragment fKLiveMiniProfileFragment = FKLiveMiniProfileFragment.this;
                final User user2 = user;
                liveRoomManagementHelper.e(context, name, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$showManageMenu$2.1
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
                        FKLiveMiniProfileFragment.this.A1(user2.userId());
                    }
                });
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$showManageMenu$3
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
                LiveRoomManagementHelper liveRoomManagementHelper = LiveRoomManagementHelper.f15768a;
                Context context = FKLiveMiniProfileFragment.this.getContext();
                String name = user.getName();
                final FKLiveMiniProfileFragment fKLiveMiniProfileFragment = FKLiveMiniProfileFragment.this;
                final User user2 = user;
                liveRoomManagementHelper.g(context, name, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$showManageMenu$3.1
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
                        FKLiveMiniProfileFragment.this.D1(user2.userId());
                    }
                });
            }
        });
    }

    public final void G1(User user) {
        UserProfileActivity.G.a(getActivity(), user, new ProfileSensorContext(ViewProfilePrefer.LiveShowMiniProfileToProfile.getValue(), null, user.getMe(), SensorPosition.MiniProfile, SensorPosition.LiveShowRoom, SensorScene.Live), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15756j.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15756j;
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

    public final void l1(final User user) {
        LiveShowModel liveShowModel;
        String itemId;
        if (user == null || (liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel()) == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        if (user.getBan()) {
            Disposable disposed = NetworkClient.f11868a.N().T(itemId, user.userId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$banUser$$inlined$handle$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    User.this.setBan(false);
                    h.f12779a.c(this.getContext(), R$string.unban_success);
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
            return;
        }
        Disposable disposed2 = NetworkClient.f11868a.N().t(itemId, user.userId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$banUser$$inlined$handle$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                User.this.setBan(true);
                h.f12779a.c(this.getContext(), R$string.ban_success);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
            H(disposed2);
        }
        s.h(disposed2, "disposed");
    }

    public final void m1(User user, FKLiveMiniProfileActionView fKLiveMiniProfileActionView) {
        if (user.getMatch()) {
            if (fKLiveMiniProfileActionView != null) {
                fKLiveMiniProfileActionView.b(R$mipmap.icon_live_profile_matched, R$string.already_matched);
            }
        } else if (user.getAloha()) {
            if (fKLiveMiniProfileActionView != null) {
                fKLiveMiniProfileActionView.b(R$mipmap.icon_live_profile_un_like, R$string.have_follow);
            }
        } else if (fKLiveMiniProfileActionView != null) {
            fKLiveMiniProfileActionView.b(R$mipmap.icon_live_profile_like, R$string.follow);
        }
    }

    public final void n1(UserProfileInfoResult userProfileInfoResult) {
        View t12;
        View s12;
        View u12;
        User user = userProfileInfoResult.getUser();
        if (user == null || user.getMe()) {
            return;
        }
        int i10 = R$id.profileMenuLayout;
        ((LinearLayout) V0(i10)).removeAllViews();
        if ((userProfileInfoResult.getShowLiveBan() || userProfileInfoResult.getShowKickOut() || userProfileInfoResult.getShowSetAdmin()) && (t12 = t1(userProfileInfoResult)) != null) {
            ((LinearLayout) V0(i10)).addView(t12);
        }
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean z10 = false;
        if (liveShowModel != null && !liveShowModel.isStreamer()) {
            z10 = true;
        }
        if (z10 && FKLiveUtil.f14913a.b() == null && (u12 = u1(user)) != null) {
            ((LinearLayout) V0(i10)).addView(u12);
        }
        List<ActionModel> actionList = userProfileInfoResult.getActionList();
        if (actionList != null) {
            Iterator<ActionModel> iterator2 = actionList.iterator2();
            while (iterator2.hasNext()) {
                if (s.d(iterator2.next().getType(), "Aloha") && (s12 = s1(user)) != null) {
                    ((LinearLayout) V0(R$id.profileMenuLayout)).addView(s12);
                }
            }
        }
    }

    public final void o1(UserProfileInfoResult userProfileInfoResult) {
        if (userProfileInfoResult.getGiftWall() == null) {
            ((UserGiftWallLayout) V0(R$id.user_gift_wall_layout)).setVisibility(8);
            return;
        }
        int i10 = R$id.user_gift_wall_layout;
        ((UserGiftWallLayout) V0(i10)).setVisibility(0);
        ((UserGiftWallLayout) V0(i10)).b(userProfileInfoResult.getGiftWall(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$configUserGiftWall$1
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
                FKLiveMiniProfileFragment.this.dismiss();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_mini_profile, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((FKWebpAnimationView) V0(R$id.bg_animation_view)).i();
        ((FKWebpAnimationView) V0(R$id.avatar_bg_animation_view)).i();
        ObjectAnimator objectAnimator = this.f15754h;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f15755i;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
        }
        AnimatorSet animatorSet = this.f15753g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BaseBottomSheetDialogFragment.S0(this, 3, false, 2, null);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.1f);
        }
        y1();
        B1();
    }

    public final void p1(UserProfileInfoResult userProfileInfoResult) {
        User user = userProfileInfoResult.getUser();
        if (user == null) {
            return;
        }
        GroupSocialLog.F(GroupSocialLog.f18708a, SensorScene.Live.getValue(), userProfileInfoResult.getUser().userId(), null, false, false, 28, null);
        ImageLoaderView miniProfileUserAvatar = (ImageLoaderView) V0(R$id.miniProfileUserAvatar);
        s.h(miniProfileUserAvatar, "miniProfileUserAvatar");
        ImageLoaderView.g(miniProfileUserAvatar, user.getAvatarImage(), null, null, 6, null);
        boolean z10 = true;
        int i10 = 4;
        if (userProfileInfoResult.getPopularFeedList().size() > 1) {
            E1();
        } else {
            ((TextView) V0(R$id.photoCountTextView)).setVisibility(4);
        }
        if (userProfileInfoResult.getAvatarBackgroundImage() == null) {
            ImageLoaderView miniProfileAvatarBackgroundImage = (ImageLoaderView) V0(R$id.miniProfileAvatarBackgroundImage);
            s.h(miniProfileAvatarBackgroundImage, "miniProfileAvatarBackgroundImage");
            miniProfileAvatarBackgroundImage.setVisibility(4);
        } else {
            int i11 = R$id.miniProfileAvatarBackgroundImage;
            ImageLoaderView miniProfileAvatarBackgroundImage2 = (ImageLoaderView) V0(i11);
            s.h(miniProfileAvatarBackgroundImage2, "miniProfileAvatarBackgroundImage");
            miniProfileAvatarBackgroundImage2.setVisibility(0);
            ImageLoaderView miniProfileAvatarBackgroundImage3 = (ImageLoaderView) V0(i11);
            s.h(miniProfileAvatarBackgroundImage3, "miniProfileAvatarBackgroundImage");
            ImageLoaderView.g(miniProfileAvatarBackgroundImage3, userProfileInfoResult.getAvatarBackgroundImage(), null, null, 6, null);
        }
        String avatarBackgroundAnimation = userProfileInfoResult.getAvatarBackgroundAnimation();
        if (avatarBackgroundAnimation == null || avatarBackgroundAnimation.length() == 0) {
            FKWebpAnimationView avatar_bg_animation_view = (FKWebpAnimationView) V0(R$id.avatar_bg_animation_view);
            s.h(avatar_bg_animation_view, "avatar_bg_animation_view");
            avatar_bg_animation_view.setVisibility(4);
        } else {
            int i12 = R$id.avatar_bg_animation_view;
            FKWebpAnimationView avatar_bg_animation_view2 = (FKWebpAnimationView) V0(i12);
            s.h(avatar_bg_animation_view2, "avatar_bg_animation_view");
            avatar_bg_animation_view2.setVisibility(0);
            FKWebpAnimationView avatar_bg_animation_view3 = (FKWebpAnimationView) V0(i12);
            s.h(avatar_bg_animation_view3, "avatar_bg_animation_view");
            FKWebpAnimationView.h(avatar_bg_animation_view3, userProfileInfoResult.getAvatarBackgroundAnimation(), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$configUserInfo$1
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
                    ImageLoaderView miniProfileAvatarBackgroundImage4 = (ImageLoaderView) FKLiveMiniProfileFragment.this.V0(R$id.miniProfileAvatarBackgroundImage);
                    s.h(miniProfileAvatarBackgroundImage4, "miniProfileAvatarBackgroundImage");
                    miniProfileAvatarBackgroundImage4.setVisibility(4);
                }
            }, null, 10, null);
        }
        if (userProfileInfoResult.getBackgroundImage() == null) {
            ImageLoaderView miniProfileBackGroundImage = (ImageLoaderView) V0(R$id.miniProfileBackGroundImage);
            s.h(miniProfileBackGroundImage, "miniProfileBackGroundImage");
            miniProfileBackGroundImage.setVisibility(4);
        } else {
            int i13 = R$id.miniProfileBackGroundImage;
            ImageLoaderView miniProfileBackGroundImage2 = (ImageLoaderView) V0(i13);
            s.h(miniProfileBackGroundImage2, "miniProfileBackGroundImage");
            miniProfileBackGroundImage2.setVisibility(0);
            ImageLoaderView miniProfileBackGroundImage3 = (ImageLoaderView) V0(i13);
            s.h(miniProfileBackGroundImage3, "miniProfileBackGroundImage");
            ImageLoaderView.g(miniProfileBackGroundImage3, userProfileInfoResult.getBackgroundImage(), null, null, 6, null);
        }
        String backgroundAnimation = userProfileInfoResult.getBackgroundAnimation();
        if (backgroundAnimation != null && backgroundAnimation.length() != 0) {
            z10 = false;
        }
        if (z10) {
            FKWebpAnimationView bg_animation_view = (FKWebpAnimationView) V0(R$id.bg_animation_view);
            s.h(bg_animation_view, "bg_animation_view");
            bg_animation_view.setVisibility(4);
        } else {
            int i14 = R$id.bg_animation_view;
            FKWebpAnimationView bg_animation_view2 = (FKWebpAnimationView) V0(i14);
            s.h(bg_animation_view2, "bg_animation_view");
            bg_animation_view2.setVisibility(0);
            FKWebpAnimationView bg_animation_view3 = (FKWebpAnimationView) V0(i14);
            s.h(bg_animation_view3, "bg_animation_view");
            FKWebpAnimationView.h(bg_animation_view3, userProfileInfoResult.getBackgroundAnimation(), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$configUserInfo$2
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
                    ImageLoaderView miniProfileBackGroundImage4 = (ImageLoaderView) FKLiveMiniProfileFragment.this.V0(R$id.miniProfileBackGroundImage);
                    s.h(miniProfileBackGroundImage4, "miniProfileBackGroundImage");
                    miniProfileBackGroundImage4.setVisibility(4);
                }
            }, null, 10, null);
        }
        ((TextView) V0(R$id.miniProfileUserName)).setText(user.getName());
        ((TextView) V0(R$id.miniProfileUserInfo)).setText(user.getUserProfileSummaryInfo());
        TextView textView = (TextView) V0(R$id.alohaGetLabel);
        if (user.getAlohaGet() && !user.getAloha() && !user.getMatch() && user.getAlohaGetShow()) {
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    public final void q1(UserProfileInfoResult userProfileInfoResult) {
        List<CardInfoModel> liveCardList = userProfileInfoResult.getLiveCardList();
        if (liveCardList == null || liveCardList.isEmpty()) {
            ((UserLiveShowRanksLinearLayout) V0(R$id.user_rank_ll)).setVisibility(8);
            return;
        }
        int i10 = R$id.user_rank_ll;
        ((UserLiveShowRanksLinearLayout) V0(i10)).setVisibility(0);
        UserLiveShowRanksLinearLayout userLiveShowRanksLinearLayout = (UserLiveShowRanksLinearLayout) V0(i10);
        List<CardInfoModel> liveCardList2 = userProfileInfoResult.getLiveCardList();
        User user = userProfileInfoResult.getUser();
        userLiveShowRanksLinearLayout.a(liveCardList2, user != null ? user.userId() : null);
    }

    public final void r1(UserProfileInfoResult userProfileInfoResult) {
        LinearLayout firstInfoLayout = (LinearLayout) V0(R$id.firstInfoLayout);
        s.h(firstInfoLayout, "firstInfoLayout");
        v1(firstInfoLayout, userProfileInfoResult.getFirstTagList());
        ((FKLiveMiniProfileTagLayout) V0(R$id.miniProfileTagLayout)).c(userProfileInfoResult.getSecondTagList());
    }

    public final View s1(final User user) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        final FKLiveMiniProfileActionView fKLiveMiniProfileActionView = new FKLiveMiniProfileActionView(context);
        m1(user, fKLiveMiniProfileActionView);
        y.d(fKLiveMiniProfileActionView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$createAlohaView$1$1$1
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
                FKLiveMiniProfileFragment.this.w1(user, fKLiveMiniProfileActionView);
            }
        });
        return fKLiveMiniProfileActionView;
    }

    public final View t1(final UserProfileInfoResult userProfileInfoResult) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        FKLiveMiniProfileActionView fKLiveMiniProfileActionView = new FKLiveMiniProfileActionView(context);
        fKLiveMiniProfileActionView.b(R$mipmap.icon_live_room_admin, R$string.push_manage);
        y.d(fKLiveMiniProfileActionView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$createBanUserView$1$1$1
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
                FKLiveMiniProfileFragment.this.F1(userProfileInfoResult);
            }
        });
        return fKLiveMiniProfileActionView;
    }

    public final View u1(final User user) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        FKLiveMiniProfileActionView fKLiveMiniProfileActionView = new FKLiveMiniProfileActionView(context);
        fKLiveMiniProfileActionView.b(R$mipmap.ic_jump_profile, R$string.watch_profile);
        y.d(fKLiveMiniProfileActionView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$createWatchProfileView$1$1$1
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
                FKLiveMiniProfileFragment.this.dismiss();
                FKLiveMiniProfileFragment.this.C1(user);
            }
        });
        return fKLiveMiniProfileActionView;
    }

    public final void v1(ViewGroup viewGroup, List<MiniProfileUserTagModel> list) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        viewGroup.removeAllViews();
        if (list != null) {
            for (MiniProfileUserTagModel miniProfileUserTagModel : list) {
                FKLiveMiniProfileTagView fKLiveMiniProfileTagView = new FKLiveMiniProfileTagView(context);
                fKLiveMiniProfileTagView.b(miniProfileUserTagModel, viewGroup.getHeight());
                viewGroup.addView(fKLiveMiniProfileTagView);
            }
        }
    }

    public final void w1(final User user, final FKLiveMiniProfileActionView fKLiveMiniProfileActionView) {
        if (z1(user)) {
            CancelAttentionHelper.f18615a.b(getContext(), user, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$followUser$1
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
                    SensorsLogFeed.f12208a.b(SensorScene.Live.getValue(), User.this.userId(), SensorPosition.MiniProfile, User.this.getSuperLikedByMe());
                    Observable<Result<SwipeCardUserLikeResult>> D0 = NetworkClient.f11868a.N().D0(User.this.userId(), null, FollowPrefer.MiniProfile.getValue());
                    final FKLiveMiniProfileFragment fKLiveMiniProfileFragment = this;
                    final User user2 = User.this;
                    final FKLiveMiniProfileActionView fKLiveMiniProfileActionView2 = fKLiveMiniProfileActionView;
                    Disposable disposed = D0.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$followUser$1$invoke$$inlined$handle$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                            m2653invoke(swipeCardUserLikeResult);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2653invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                            ShowLiveMiniProfileViewModel x12;
                            SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                            boolean z10 = false;
                            User.this.setAloha(false);
                            User.this.setMatch(false);
                            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                            if (liveShowModel != null && s.d(liveShowModel.getUser().userId(), swipeCardUserLikeResult2.getUser().userId())) {
                                liveShowModel.getUser().setAloha(swipeCardUserLikeResult2.getUser().getAloha());
                                liveShowModel.getUser().setMatch(swipeCardUserLikeResult2.getUser().getMatch());
                            }
                            fKLiveMiniProfileFragment.m1(swipeCardUserLikeResult2.getUser(), fKLiveMiniProfileActionView2);
                            x12 = fKLiveMiniProfileFragment.x1();
                            if (x12 != null && x12.getCareFollowAction()) {
                                z10 = true;
                            }
                            if (z10) {
                                EventBus.c().l(new FollowActorEvent(User.this));
                            }
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(null, fKLiveMiniProfileFragment)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (fKLiveMiniProfileFragment != null) {
                            fKLiveMiniProfileFragment.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            });
            return;
        }
        x2.a N = NetworkClient.f11868a.N();
        String userId = user.userId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        Disposable disposed = a.C0836a.o(N, userId, null, liveShowModel != null ? liveShowModel.getItemId() : null, FollowPrefer.MiniProfile.getValue(), 0, null, null, null, 242, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$followUser$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2652invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2652invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                ShowLiveMiniProfileViewModel x12;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                if (User.this.getAlohaGet()) {
                    User.this.setMatch(true);
                }
                User.this.setAloha(true);
                LiveShowModel liveShowModel2 = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel2 != null && s.d(liveShowModel2.getUser().userId(), swipeCardUserLikeResult2.getUser().userId())) {
                    liveShowModel2.getUser().setAloha(swipeCardUserLikeResult2.getUser().getAloha());
                    liveShowModel2.getUser().setMatch(swipeCardUserLikeResult2.getUser().getMatch());
                }
                h.f12779a.c(this.getContext(), R$string.follow_success);
                this.m1(swipeCardUserLikeResult2.getUser(), fKLiveMiniProfileActionView);
                x12 = this.x1();
                if (x12 != null && x12.getCareFollowAction()) {
                    EventBus.c().l(new FollowActorEvent(User.this));
                }
                GroupSocialLog.f18708a.B(true, SensorScene.Live.getValue(), User.this.userId(), (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult2.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final ShowLiveMiniProfileViewModel x1() {
        return (ShowLiveMiniProfileViewModel) this.f15751e.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0067, code lost:
    
        if (((r3 == null || r3.getCanReport()) ? false : true) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y1() {
        /*
            r8 = this;
            int r0 = com.cupidapp.live.R$id.bg_container_layout
            android.view.View r0 = r8.V0(r0)
            r1 = r0
            com.cupidapp.live.base.view.RoundedFrameLayout r1 = (com.cupidapp.live.base.view.RoundedFrameLayout) r1
            java.lang.String r0 = "bg_container_layout"
            kotlin.jvm.internal.s.h(r1, r0)
            r0 = 1102053376(0x41b00000, float:22.0)
            int r2 = z0.h.c(r8, r0)
            float r2 = (float) r2
            int r0 = z0.h.c(r8, r0)
            float r4 = (float) r0
            r3 = 0
            r5 = 0
            r6 = 10
            r7 = 0
            com.cupidapp.live.base.view.m.a.d(r1, r2, r3, r4, r5, r6, r7)
            int r0 = com.cupidapp.live.R$id.miniProfileReportView
            android.view.View r1 = r8.V0(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.text.TextPaint r1 = r1.getPaint()
            r2 = 1
            r1.setFakeBoldText(r2)
            android.view.View r1 = r8.V0(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel r3 = r8.x1()
            r4 = 0
            if (r3 == 0) goto L44
            java.lang.String r3 = r3.getUserId()
            goto L45
        L44:
            r3 = r4
        L45:
            p1.g r5 = p1.g.f52734a
            com.cupidapp.live.profile.model.User r5 = r5.X()
            if (r5 == 0) goto L51
            java.lang.String r4 = r5.userId()
        L51:
            boolean r3 = kotlin.jvm.internal.s.d(r3, r4)
            r4 = 0
            if (r3 != 0) goto L69
            com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel r3 = r8.x1()
            if (r3 == 0) goto L66
            boolean r3 = r3.getCanReport()
            if (r3 != 0) goto L66
            r3 = 1
            goto L67
        L66:
            r3 = 0
        L67:
            if (r3 == 0) goto L6b
        L69:
            r4 = 8
        L6b:
            r1.setVisibility(r4)
            int r1 = com.cupidapp.live.R$id.miniProfileUserName
            android.view.View r1 = r8.V0(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.text.TextPaint r1 = r1.getPaint()
            r1.setFakeBoldText(r2)
            int r1 = com.cupidapp.live.R$id.closeMiniProfileImage
            android.view.View r1 = r8.V0(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r2 = "closeMiniProfileImage"
            kotlin.jvm.internal.s.h(r1, r2)
            com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$initView$1 r2 = new com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$initView$1
            r2.<init>()
            z0.y.d(r1, r2)
            android.view.View r0 = r8.V0(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "miniProfileReportView"
            kotlin.jvm.internal.s.h(r0, r1)
            com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$initView$2 r1 = new com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$initView$2
            r1.<init>()
            z0.y.d(r0, r1)
            int r0 = com.cupidapp.live.R$id.miniProfileUserAvatar
            android.view.View r0 = r8.V0(r0)
            com.cupidapp.live.base.imageloader.ImageLoaderView r0 = (com.cupidapp.live.base.imageloader.ImageLoaderView) r0
            java.lang.String r1 = "miniProfileUserAvatar"
            kotlin.jvm.internal.s.h(r0, r1)
            com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$initView$3 r1 = new com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment$initView$3
            r1.<init>()
            z0.y.d(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment.y1():void");
    }

    public final boolean z1(User user) {
        return user.getAloha() || user.getMatch();
    }
}
