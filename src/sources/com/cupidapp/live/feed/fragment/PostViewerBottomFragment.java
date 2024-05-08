package com.cupidapp.live.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.feed.adapter.PostViewerAdapter;
import com.cupidapp.live.feed.viewmodel.PostViewerViewModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeDialogLayout;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostViewerBottomFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostViewerBottomFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f14258j = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f14259e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f14260f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f14261g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f14262h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14263i = new LinkedHashMap();

    /* compiled from: PostViewerBottomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostViewerBottomFragment a() {
            return new PostViewerBottomFragment();
        }
    }

    public PostViewerBottomFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$special$$inlined$viewModels$default$1
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
        this.f14259e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(PostViewerViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$special$$inlined$viewModels$default$2
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
        this.f14261g = kotlin.c.b(new Function0<PostViewerAdapter>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$listAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PostViewerAdapter invoke() {
                PostViewerAdapter postViewerAdapter = new PostViewerAdapter();
                final PostViewerBottomFragment postViewerBottomFragment = PostViewerBottomFragment.this;
                postViewerAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.viewer_relation), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$listAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof User) {
                            User user = (User) obj;
                            if (user.getCanSendInboxMessage()) {
                                PostViewerBottomFragment.this.j1(user);
                            } else {
                                PostViewerBottomFragment.this.l1(user);
                            }
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.viewer_avatar), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$listAdapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof User) {
                            PostViewerBottomFragment.this.f1((User) obj);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.viewer_name), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$listAdapter$2$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof User) {
                            PostViewerBottomFragment.this.f1((User) obj);
                        }
                    }
                })));
                return postViewerAdapter;
            }
        });
        this.f14262h = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final PostViewerBottomFragment postViewerBottomFragment = PostViewerBottomFragment.this;
                return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$loadMoreListener$2.1
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
                        String str;
                        PostViewerViewModel e12;
                        str = PostViewerBottomFragment.this.f14260f;
                        if (str != null) {
                            e12 = PostViewerBottomFragment.this.e1();
                            e12.loadMore(str);
                        }
                    }
                });
            }
        });
    }

    public static final void h1(PostViewerBottomFragment this$0, List it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.c1().j().clear();
        List<Object> j10 = this$0.c1().j();
        kotlin.jvm.internal.s.h(it, "it");
        j10.addAll(it);
        this$0.c1().notifyDataSetChanged();
        this$0.d1().c(false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f14263i.clear();
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14263i;
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

    public final PostViewerAdapter c1() {
        return (PostViewerAdapter) this.f14261g.getValue();
    }

    public final FKLoadMoreListener d1() {
        return (FKLoadMoreListener) this.f14262h.getValue();
    }

    public final PostViewerViewModel e1() {
        return (PostViewerViewModel) this.f14259e.getValue();
    }

    public final void f1(User user) {
        String value = ViewProfilePrefer.postLimitViewerListToProfile.getValue();
        boolean me2 = user.getMe();
        SensorPosition sensorPosition = SensorPosition.PostLimit;
        UserProfileActivity.G.a(getContext(), user, new ProfileSensorContext(value, null, me2, sensorPosition, sensorPosition, null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
    }

    public final void g1() {
        e1().getViewerLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.feed.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostViewerBottomFragment.h1(PostViewerBottomFragment.this, (List) obj);
            }
        });
    }

    public final void i1() {
        RecyclerView recyclerView = (RecyclerView) W0(R$id.viewer_list);
        recyclerView.setAdapter(c1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addOnScrollListener(d1());
    }

    public final void j1(User user) {
        ChatDetailActivity.f13276r.a(getContext(), new ChatBundleData(user, user.userId(), new FKSensorContext(SensorPosition.PostLimit, SensorPosition.Feed, null, SensorScene.Feed), null, false, false, false, false, false, 504, null));
    }

    public final void k1(@NotNull FragmentManager manager, @NotNull String postLimitId) {
        kotlin.jvm.internal.s.i(manager, "manager");
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        this.f14260f = postLimitId;
        super.show(manager, PostViewerBottomFragment.class.getSimpleName());
    }

    public final void l1(User user) {
        Context context = getContext();
        if (context != null) {
            SuperLikeDialogLayout.Companion companion = SuperLikeDialogLayout.f18632h;
            Lifecycle lifecycle = getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            companion.b(context, lifecycle, user.userId(), null, FollowPrefer.PostLimitViewerList.getValue(), VipPurchaseEntranceType.SuperLikePostLimit, (r27 & 64) != 0 ? null : null, SensorPosition.PostLimit, (r27 & 256) != 0 ? 1 : 0, new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.PostViewerBottomFragment$superLikeUser$1$1
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
                    PostViewerViewModel e12;
                    kotlin.jvm.internal.s.i(result, "result");
                    e12 = PostViewerBottomFragment.this.e1();
                    e12.changeUser(result.getUser());
                }
            }, (r27 & 1024) != 0 ? null : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_post_viewer, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setGravity(80);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawableResource(17170445);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setLayout(-1, -1);
            }
            Window window4 = dialog.getWindow();
            if (window4 != null) {
                window4.setWindowAnimations(R$style.dialog_translate_anim);
            }
        }
        super.onStart();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        i1();
        g1();
        String str = this.f14260f;
        if (str != null) {
            e1().loadData(str);
        }
    }
}
