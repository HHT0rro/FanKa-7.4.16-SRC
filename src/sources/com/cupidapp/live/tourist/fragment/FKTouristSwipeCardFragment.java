package com.cupidapp.live.tourist.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import com.cupidapp.live.match.model.MatchCardItemModel;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout;
import com.cupidapp.live.match.view.FKSwipeCardSearchView;
import com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout;
import com.cupidapp.live.match.view.FKSwipeCardUserInfoModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.helper.PersonalizedRecommendHelper;
import com.cupidapp.live.tourist.model.FKTouristViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;
import z3.f;

/* compiled from: FKTouristSwipeCardFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKTouristSwipeCardFragment extends FKBaseFragment {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18687e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18688f = new LinkedHashMap();

    /* compiled from: FKTouristSwipeCardFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            if (FKTouristSwipeCardFragment.this.isVisible()) {
                FKTouristSwipeCardFragment fKTouristSwipeCardFragment = FKTouristSwipeCardFragment.this;
                int i10 = R$id.click_layout;
                FKSwipeCardClickButtonLayout fKSwipeCardClickButtonLayout = (FKSwipeCardClickButtonLayout) fKTouristSwipeCardFragment.T0(i10);
                if (fKSwipeCardClickButtonLayout != null) {
                    fKSwipeCardClickButtonLayout.setVisibility(0);
                }
                ((FKSwipeCardClickButtonLayout) FKTouristSwipeCardFragment.this.T0(i10)).q();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            ((ConstraintLayout) FKTouristSwipeCardFragment.this.T0(R$id.swipe_card_container_layout)).setVisibility(0);
        }
    }

    public FKTouristSwipeCardFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.tourist.fragment.FKTouristSwipeCardFragment$special$$inlined$viewModels$default$1
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
        this.f18687e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(FKTouristViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.tourist.fragment.FKTouristSwipeCardFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
    }

    public static final void W0(FKTouristSwipeCardFragment this$0, MatchRecommendUserModel matchRecommendUserModel) {
        String userProfileSummaryInfo;
        s.i(this$0, "this$0");
        List<MatchCardItemModel> multiAvatars = matchRecommendUserModel.getMultiAvatars();
        if (multiAvatars == null || multiAvatars.isEmpty()) {
            return;
        }
        ((FKSwipeCardSearchView) this$0.T0(R$id.swipe_card_search_view)).h();
        int i10 = R$id.top_indicator_layout;
        ((TopIndicatorLayout) this$0.T0(i10)).setPagerCount(matchRecommendUserModel.getMultiAvatars().size());
        ((TopIndicatorLayout) this$0.T0(i10)).setCurrentPager(0);
        ImageModel avatar = matchRecommendUserModel.getMultiAvatars().get(0).getAvatar();
        ImageLoaderView swipe_card_avatar_image = (ImageLoaderView) this$0.T0(R$id.swipe_card_avatar_image);
        s.h(swipe_card_avatar_image, "swipe_card_avatar_image");
        ImageLoaderView.g(swipe_card_avatar_image, avatar, null, null, 6, null);
        User user = matchRecommendUserModel.getUser();
        if (user.getAge() != null) {
            String userProfileSummaryInfo2 = user.getUserProfileSummaryInfo();
            if (!(userProfileSummaryInfo2 == null || userProfileSummaryInfo2.length() == 0)) {
                userProfileSummaryInfo = this$0.getString(R$string.age_and_basic_info, user.getAge(), user.getUserProfileSummaryInfo());
            } else {
                userProfileSummaryInfo = this$0.getString(R$string.comma_and_user_age, user.getAge());
            }
        } else {
            userProfileSummaryInfo = user.getUserProfileSummaryInfo();
        }
        ((FKSwipeCardUserInfoLayout) this$0.T0(R$id.user_info_layout)).m(new FKSwipeCardUserInfoModel(user.getName(), user.getUserVipModel(), user.getActiveDesc(), userProfileSummaryInfo, user.getUserTags(), user.getUserTagsEmptyText(), matchRecommendUserModel.getMultiAvatars().get(0), user.getNewUserTag(), user.getProfileLevelIcon(), user.getGroupMedal(), user.getZodiacInfo(), user.getMbtiInfo()), false, new Function1<String, p>() { // from class: com.cupidapp.live.tourist.fragment.FKTouristSwipeCardFragment$initObserve$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
            }
        });
        this$0.Y0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18688f.clear();
    }

    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18688f;
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

    public final FKTouristViewModel U0() {
        return (FKTouristViewModel) this.f18687e.getValue();
    }

    public final void V0() {
        U0().getRecommendCard();
        U0().getRecommendCardLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.tourist.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKTouristSwipeCardFragment.W0(FKTouristSwipeCardFragment.this, (MatchRecommendUserModel) obj);
            }
        });
    }

    public final void X0() {
        FKTitleBarLayout initView$lambda$0 = (FKTitleBarLayout) T0(R$id.swipe_card_title_layout);
        s.h(initView$lambda$0, "initView$lambda$0");
        FKTitleBarLayout.f(initView$lambda$0, new com.cupidapp.live.base.view.p(kotlin.collections.s.m(getString(PersonalizedRecommendHelper.f18179a.d()), getString(R$string.match_nearby)), 0.0f, 0, 0, false, 30, null), null, 0, null, 12, null);
        ((FKSwipeCardSearchView) T0(R$id.swipe_card_search_view)).g();
    }

    public final void Y0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ConstraintLayout) T0(R$id.swipe_card_container_layout), (Property<ConstraintLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new a());
        ofFloat.start();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_tourist_swipe_card, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            return;
        }
        f.f54838a.b(SensorPosition.Match);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isHidden()) {
            return;
        }
        f.f54838a.b(SensorPosition.Match);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        X0();
        V0();
    }
}
