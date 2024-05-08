package com.cupidapp.live.setting.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.databinding.FragmentStoryLabelBinding;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.setting.activity.FKEditStoryLabelActivity;
import com.cupidapp.live.setting.adapter.FKStoryLabelAdapter;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelListFragment extends FKBaseFragment {

    /* renamed from: e, reason: collision with root package name */
    public FragmentStoryLabelBinding f18127e;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f18129g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final ActivityResultLauncher<Intent> f18130h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18131i = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18128f = kotlin.c.b(new Function0<FKStoryLabelAdapter>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelListFragment$storyLabelAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKStoryLabelAdapter invoke() {
            FKStoryLabelAdapter fKStoryLabelAdapter = new FKStoryLabelAdapter();
            final FKStoryLabelListFragment fKStoryLabelListFragment = FKStoryLabelListFragment.this;
            fKStoryLabelAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelListFragment$storyLabelAdapter$2$1$1
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
                    if (obj instanceof FKStoryLabelItemModel) {
                        FKStoryLabelListFragment.this.d1((FKStoryLabelItemModel) obj);
                    }
                }
            });
            return fKStoryLabelAdapter;
        }
    });

    public FKStoryLabelListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelListFragment$special$$inlined$viewModels$default$1
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
        this.f18129g = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(FKStoryLabelViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelListFragment$special$$inlined$viewModels$default$2
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
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.setting.fragment.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FKStoryLabelListFragment.e1(FKStoryLabelListFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.s.h(registerForActivityResult, "registerForActivityResul….finish()\n        }\n    }");
        this.f18130h = registerForActivityResult;
    }

    public static final void a1(FKStoryLabelListFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.V0(R$id.story_label_refresh_layout)).setRefreshing(false);
    }

    public static final void c1(FKStoryLabelListFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.V0(R$id.story_label_refresh_layout)).setRefreshing(true);
        this$0.Y0().getLabelList();
    }

    public static final void e1(FKStoryLabelListFragment this$0, ActivityResult activityResult) {
        FragmentActivity activity;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (activity = this$0.getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18131i.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18131i;
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

    public final FKStoryLabelAdapter X0() {
        return (FKStoryLabelAdapter) this.f18128f.getValue();
    }

    public final FKStoryLabelViewModel Y0() {
        return (FKStoryLabelViewModel) this.f18129g.getValue();
    }

    public final void Z0() {
        Y0().getStoryLabelLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKStoryLabelListFragment.a1(FKStoryLabelListFragment.this, (StateResult) obj);
            }
        });
    }

    public final void b1() {
        RecyclerView recyclerView = (RecyclerView) V0(R$id.story_label_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(X0());
        ((FKTitleBarLayout) V0(R$id.story_label_title_layout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKStoryLabelListFragment$initView$2
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
                FragmentActivity activity = FKStoryLabelListFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        ((FKSwipeRefreshLayout) V0(R$id.story_label_refresh_layout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.setting.fragment.d
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FKStoryLabelListFragment.c1(FKStoryLabelListFragment.this);
            }
        });
    }

    public final void d1(FKStoryLabelItemModel fKStoryLabelItemModel) {
        Intent intent = new Intent(getContext(), (Class<?>) FKEditStoryLabelActivity.class);
        z0.g.c(intent, fKStoryLabelItemModel);
        this.f18130h.launch(intent);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        FragmentStoryLabelBinding b4 = FragmentStoryLabelBinding.b(inflater, viewGroup, false);
        kotlin.jvm.internal.s.h(b4, "inflate(inflater, container, false)");
        this.f18127e = b4;
        if (b4 == null) {
            kotlin.jvm.internal.s.A("binding");
            b4 = null;
        }
        return b4.getRoot();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        FragmentStoryLabelBinding fragmentStoryLabelBinding = this.f18127e;
        FragmentStoryLabelBinding fragmentStoryLabelBinding2 = null;
        if (fragmentStoryLabelBinding == null) {
            kotlin.jvm.internal.s.A("binding");
            fragmentStoryLabelBinding = null;
        }
        fragmentStoryLabelBinding.d(Y0());
        FragmentStoryLabelBinding fragmentStoryLabelBinding3 = this.f18127e;
        if (fragmentStoryLabelBinding3 == null) {
            kotlin.jvm.internal.s.A("binding");
        } else {
            fragmentStoryLabelBinding2 = fragmentStoryLabelBinding3;
        }
        fragmentStoryLabelBinding2.setLifecycleOwner(getViewLifecycleOwner());
        b1();
        Y0().getLabelList();
        Z0();
    }
}
