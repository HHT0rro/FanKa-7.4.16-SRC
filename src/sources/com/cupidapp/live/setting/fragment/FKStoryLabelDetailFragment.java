package com.cupidapp.live.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.databinding.FragmentStoryLabelDetailBinding;
import com.cupidapp.live.profile.holder.FKProfileStoryLabelModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.adapter.FKStoryLabelDetailAdapter;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;
import com.cupidapp.live.superlike.helper.CancelAttentionHelper;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.huawei.openalliance.ad.constant.ad;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FKStoryLabelDetailFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelDetailFragment extends FKBaseFragment {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f18119l = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public FragmentStoryLabelDetailBinding f18120e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18121f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f18122g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f18123h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18124i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f18125j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18126k = new LinkedHashMap();

    /* compiled from: FKStoryLabelDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKStoryLabelDetailFragment a(@NotNull FKProfileStoryLabelModel profileLabelModel, @Nullable FKSensorContext fKSensorContext) {
            kotlin.jvm.internal.s.i(profileLabelModel, "profileLabelModel");
            FKStoryLabelDetailFragment fKStoryLabelDetailFragment = new FKStoryLabelDetailFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, profileLabelModel);
            if (fKSensorContext != null) {
                z0.g.d(bundle, fKSensorContext);
            }
            fKStoryLabelDetailFragment.setArguments(bundle);
            return fKStoryLabelDetailFragment;
        }
    }

    public FKStoryLabelDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$special$$inlined$viewModels$default$1
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
        this.f18121f = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(FKStoryLabelViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$special$$inlined$viewModels$default$2
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
        this.f18122g = kotlin.c.b(new Function0<FKStoryLabelDetailAdapter>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$labelDetailAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKStoryLabelDetailAdapter invoke() {
                return new FKStoryLabelDetailAdapter();
            }
        });
        this.f18123h = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$sensorContext$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final FKSensorContext invoke() {
                Bundle arguments = FKStoryLabelDetailFragment.this.getArguments();
                if (arguments != null) {
                    return (FKSensorContext) z0.g.b(arguments, FKSensorContext.class);
                }
                return null;
            }
        });
        this.f18125j = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$mSensorContext$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKSensorContext invoke() {
                SensorPosition sensorPosition;
                Bundle arguments = FKStoryLabelDetailFragment.this.getArguments();
                FKSensorContext fKSensorContext = arguments != null ? (FKSensorContext) z0.g.b(arguments, FKSensorContext.class) : null;
                if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                    sensorPosition = SensorPosition.Profile;
                }
                return new FKSensorContext(FKStoryLabelDetailFragment.this.O0(), sensorPosition, fKSensorContext != null ? fKSensorContext.getSource() : null, fKSensorContext != null ? fKSensorContext.getScene() : null);
            }
        });
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18126k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.StoryLabel;
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18126k;
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

    public final void X0() {
        final User user;
        FKProfileStoryLabelModel value = b1().getStoryLabelDetailLiveData().getValue();
        if (value == null || (user = value.getUser()) == null) {
            return;
        }
        ImageView story_label_chat_image = (ImageView) S0(R$id.story_label_chat_image);
        kotlin.jvm.internal.s.h(story_label_chat_image, "story_label_chat_image");
        y.d(story_label_chat_image, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$bindClickEvent$1
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
                FKStoryLabelDetailFragment.this.e1(user);
            }
        });
        ImageView relation_image = (ImageView) S0(R$id.relation_image);
        kotlin.jvm.internal.s.h(relation_image, "relation_image");
        y.d(relation_image, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$bindClickEvent$2
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
                FKStoryLabelViewModel b12;
                if (User.this.getAloha()) {
                    CancelAttentionHelper cancelAttentionHelper = CancelAttentionHelper.f18615a;
                    Context context = this.getContext();
                    User user2 = User.this;
                    final FKStoryLabelDetailFragment fKStoryLabelDetailFragment = this;
                    cancelAttentionHelper.b(context, user2, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$bindClickEvent$2.1
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
                            FKStoryLabelViewModel b13;
                            b13 = FKStoryLabelDetailFragment.this.b1();
                            b13.cancelFollow();
                        }
                    });
                    return;
                }
                b12 = this.b1();
                b12.followUser();
            }
        });
    }

    public final FKStoryLabelDetailAdapter Y0() {
        return (FKStoryLabelDetailAdapter) this.f18122g.getValue();
    }

    public final FKSensorContext Z0() {
        return (FKSensorContext) this.f18125j.getValue();
    }

    public final FKSensorContext a1() {
        return (FKSensorContext) this.f18123h.getValue();
    }

    public final FKStoryLabelViewModel b1() {
        return (FKStoryLabelViewModel) this.f18121f.getValue();
    }

    public final void c1() {
        b1().getAlohaOrNopeEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$initObserve$1
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
                FKSensorContext a12;
                SensorScene scene;
                FKSensorContext a13;
                SensorScene scene2;
                kotlin.jvm.internal.s.i(result, "result");
                User user = result.getUser();
                FKStoryLabelDetailFragment.this.f18124i = user.getAloha();
                String str = null;
                if (user.getAloha()) {
                    GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                    boolean aloha = user.getAloha();
                    a13 = FKStoryLabelDetailFragment.this.a1();
                    if (a13 != null && (scene2 = a13.getScene()) != null) {
                        str = scene2.getValue();
                    }
                    groupSocialLog.B(aloha, str, user.userId(), (r52 & 8) != 0 ? 1 : 0, (r52 & 16) != 0 ? null : Boolean.valueOf(user.getMatch()), (r52 & 32) != 0 ? null : result.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : user, (r52 & 256) != 0 ? null : SensorPosition.StoryLabel, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
                    return;
                }
                GroupSocialLog groupSocialLog2 = GroupSocialLog.f18708a;
                a12 = FKStoryLabelDetailFragment.this.a1();
                if (a12 != null && (scene = a12.getScene()) != null) {
                    str = scene.getValue();
                }
                groupSocialLog2.d(str, user.userId(), SensorPosition.StoryLabel, Boolean.FALSE);
            }
        }));
    }

    public final void d1() {
        ((FKTitleBarLayout) S0(R$id.story_label_detail_title_layout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment$initView$1
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
                FragmentActivity activity = FKStoryLabelDetailFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) S0(R$id.story_label_detail_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(Y0());
    }

    public final void e1(User user) {
        ChatDetailActivity.f13276r.a(getContext(), new ChatBundleData(user, user.userId(), Z0(), null, true, false, true, false, false, ad.f32204q, null));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        FragmentStoryLabelDetailBinding b4 = FragmentStoryLabelDetailBinding.b(inflater, viewGroup, false);
        kotlin.jvm.internal.s.h(b4, "inflate(inflater, container, false)");
        this.f18120e = b4;
        if (b4 == null) {
            kotlin.jvm.internal.s.A("binding");
            b4 = null;
        }
        return b4.getRoot();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.c().o(new StoryLabelFollowEvent(this.f18124i));
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        FragmentStoryLabelDetailBinding fragmentStoryLabelDetailBinding = null;
        FKProfileStoryLabelModel fKProfileStoryLabelModel = arguments != null ? (FKProfileStoryLabelModel) z0.g.b(arguments, FKProfileStoryLabelModel.class) : null;
        if (fKProfileStoryLabelModel == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        FragmentStoryLabelDetailBinding fragmentStoryLabelDetailBinding2 = this.f18120e;
        if (fragmentStoryLabelDetailBinding2 == null) {
            kotlin.jvm.internal.s.A("binding");
            fragmentStoryLabelDetailBinding2 = null;
        }
        fragmentStoryLabelDetailBinding2.d(b1());
        FragmentStoryLabelDetailBinding fragmentStoryLabelDetailBinding3 = this.f18120e;
        if (fragmentStoryLabelDetailBinding3 == null) {
            kotlin.jvm.internal.s.A("binding");
        } else {
            fragmentStoryLabelDetailBinding = fragmentStoryLabelDetailBinding3;
        }
        fragmentStoryLabelDetailBinding.setLifecycleOwner(getViewLifecycleOwner());
        b1().setStoryLabelDetail(fKProfileStoryLabelModel);
        d1();
        c1();
        X0();
    }
}
