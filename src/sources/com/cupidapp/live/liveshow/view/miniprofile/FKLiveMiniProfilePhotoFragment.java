package com.cupidapp.live.liveshow.view.miniprofile;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.fragment.CloseBottomSheetFragmentEvent;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.liveshow.adapter.FKLiveMiniProfilePhotoAdapter;
import com.cupidapp.live.liveshow.model.MiniProfilePopularFeedModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;

/* compiled from: FKLiveMiniProfilePhotoFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniProfilePhotoFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f15759g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15761f = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15760e = c.b(new Function0<FKMiniProfilePhotoViewModel>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfilePhotoFragment$photoModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FKMiniProfilePhotoViewModel invoke() {
            Bundle arguments = FKLiveMiniProfilePhotoFragment.this.getArguments();
            if (arguments != null) {
                return (FKMiniProfilePhotoViewModel) g.b(arguments, FKMiniProfilePhotoViewModel.class);
            }
            return null;
        }
    });

    /* compiled from: FKLiveMiniProfilePhotoFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, @Nullable FKMiniProfilePhotoViewModel fKMiniProfilePhotoViewModel) {
            if (fragmentManager == null) {
                return;
            }
            FKLiveMiniProfilePhotoFragment fKLiveMiniProfilePhotoFragment = new FKLiveMiniProfilePhotoFragment();
            Bundle bundle = new Bundle();
            if (fKMiniProfilePhotoViewModel != null) {
                g.d(bundle, fKMiniProfilePhotoViewModel);
            }
            fKLiveMiniProfilePhotoFragment.setArguments(bundle);
            fKLiveMiniProfilePhotoFragment.show(fragmentManager, FKLiveMiniProfilePhotoFragment.class.getSimpleName());
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15761f.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15761f;
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

    public final void W0() {
        ImageView closePhotoImage = (ImageView) V0(R$id.closePhotoImage);
        s.h(closePhotoImage, "closePhotoImage");
        y.d(closePhotoImage, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfilePhotoFragment$bindClickEvent$1
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
                FKLiveMiniProfilePhotoFragment.this.dismiss();
            }
        });
    }

    public final FKMiniProfilePhotoViewModel X0() {
        return (FKMiniProfilePhotoViewModel) this.f15760e.getValue();
    }

    public final void Y0() {
        User user;
        List<AvatarProfileModel> avatarProfile;
        FKLiveMiniProfilePhotoAdapter fKLiveMiniProfilePhotoAdapter = new FKLiveMiniProfilePhotoAdapter();
        fKLiveMiniProfilePhotoAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfilePhotoFragment$initView$photoAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                FKLiveMiniProfilePhotoFragment.this.dismiss();
            }
        });
        int i10 = R$id.miniProfilePhotoViewPager;
        ((ViewPager2) V0(i10)).setAdapter(fKLiveMiniProfilePhotoAdapter);
        ((ViewPager2) V0(i10)).setOffscreenPageLimit(2);
        FKMiniProfilePhotoViewModel X0 = X0();
        List<MiniProfilePopularFeedModel> popularFeedList = X0 != null ? X0.getPopularFeedList() : null;
        if (popularFeedList == null || popularFeedList.isEmpty()) {
            FKMiniProfilePhotoViewModel X02 = X0();
            AvatarProfileModel avatarProfileModel = (X02 == null || (user = X02.getUser()) == null || (avatarProfile = user.getAvatarProfile()) == null) ? null : (AvatarProfileModel) CollectionsKt___CollectionsKt.V(avatarProfile);
            popularFeedList = r.e(new MiniProfilePopularFeedModel(null, null, avatarProfileModel != null ? avatarProfileModel.getAvatarVideo() : null, avatarProfileModel != null ? avatarProfileModel.getAvatarImage() : null, 3, null));
        }
        fKLiveMiniProfilePhotoAdapter.e(popularFeedList);
        fKLiveMiniProfilePhotoAdapter.notifyDataSetChanged();
        if (!(popularFeedList == null || popularFeedList.isEmpty()) && popularFeedList.size() > 1) {
            int i11 = R$id.miniProfilePhotoPagerIndicator;
            ((PagerIndicatorLayout) V0(i11)).setVisibility(0);
            ((PagerIndicatorLayout) V0(i11)).setPagerCount(popularFeedList.size());
        } else {
            ((PagerIndicatorLayout) V0(R$id.miniProfilePhotoPagerIndicator)).setVisibility(8);
        }
        ((ViewPager2) V0(i10)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfilePhotoFragment$initView$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i12) {
                ((PagerIndicatorLayout) FKLiveMiniProfilePhotoFragment.this.V0(R$id.miniProfilePhotoPagerIndicator)).setCurrentPager(i12);
            }
        });
    }

    public final void Z0() {
        User user;
        String userId;
        FKMiniProfilePhotoViewModel X0 = X0();
        if (X0 == null || (user = X0.getUser()) == null || (userId = user.userId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().p(userId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfilePhotoFragment$liveVisitorRecord$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_mini_profile_photo, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull CloseBottomSheetFragmentEvent event) {
        s.i(event, "event");
        Q0();
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
            z0.d.g(dialog, 1.0f);
        }
        Y0();
        W0();
        Z0();
    }
}
