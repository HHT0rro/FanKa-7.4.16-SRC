package com.cupidapp.live.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKErrorViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.recyclerview.model.FKTitleUiModel;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseListFragment<T> extends FKBaseFragment {

    /* renamed from: e, reason: collision with root package name */
    public FKBaseRecyclerViewAdapter f11790e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f11791f;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11793h = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f11792g = kotlin.c.b(new Function0<FKLoadMoreListener>(this) { // from class: com.cupidapp.live.base.fragment.FKBaseListFragment$loadMoreListener$2
        public final /* synthetic */ FKBaseListFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FKBaseListFragment<T> fKBaseListFragment = this.this$0;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.base.fragment.FKBaseListFragment$loadMoreListener$2.1
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
                    String str;
                    String str2;
                    str = fKBaseListFragment.f11791f;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    FKBaseListFragment<T> fKBaseListFragment2 = fKBaseListFragment;
                    str2 = fKBaseListFragment2.f11791f;
                    fKBaseListFragment2.f1(str2);
                }
            });
        }
    });

    public static /* synthetic */ void g1(FKBaseListFragment fKBaseListFragment, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResultList");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        fKBaseListFragment.f1(str);
    }

    public static final void j1(FKBaseListFragment this$0) {
        s.i(this$0, "this$0");
        g1(this$0, null, 1, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f11793h.clear();
    }

    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f11793h;
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

    public void Y0(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Nullable
    public FKEmptyViewModel Z0() {
        return null;
    }

    @Nullable
    public FKErrorViewModel a1() {
        return null;
    }

    @Nullable
    public final String b1() {
        return this.f11791f;
    }

    @NotNull
    public final FKLoadMoreListener c1() {
        return (FKLoadMoreListener) this.f11792g.getValue();
    }

    @NotNull
    public abstract FKBaseRecyclerViewAdapter d1();

    @Nullable
    public abstract Observable<Result<ListResult<T>>> e1(@Nullable String str);

    public final void f1(final String str) {
        Observable<Result<ListResult<T>>> e12 = e1(str);
        if (e12 != null) {
            Disposable disposed = e12.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<T>, p>() { // from class: com.cupidapp.live.base.fragment.FKBaseListFragment$getResultList$$inlined$handle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListResult<T> listResult) {
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter;
                    FKTitleUiModel h12;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter2;
                    String str2;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter3;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter4;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter5;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter6;
                    ListResult<T> listResult2 = listResult;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter7 = null;
                    if (String.this == null) {
                        fKBaseRecyclerViewAdapter5 = this.f11790e;
                        if (fKBaseRecyclerViewAdapter5 == null) {
                            s.A("recyclerAdapter");
                            fKBaseRecyclerViewAdapter5 = null;
                        }
                        fKBaseRecyclerViewAdapter5.j().clear();
                        fKBaseRecyclerViewAdapter6 = this.f11790e;
                        if (fKBaseRecyclerViewAdapter6 == null) {
                            s.A("recyclerAdapter");
                            fKBaseRecyclerViewAdapter6 = null;
                        }
                        fKBaseRecyclerViewAdapter6.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                    }
                    this.f11791f = listResult2.getNextCursorId();
                    List<T> list = listResult2.getList();
                    boolean z10 = true;
                    if (list == null || list.isEmpty()) {
                        FKEmptyViewModel Z0 = this.Z0();
                        if (Z0 != null) {
                            fKBaseRecyclerViewAdapter4 = this.f11790e;
                            if (fKBaseRecyclerViewAdapter4 == null) {
                                s.A("recyclerAdapter");
                                fKBaseRecyclerViewAdapter4 = null;
                            }
                            fKBaseRecyclerViewAdapter4.d(Z0);
                        }
                    } else {
                        if (String.this == null && (h12 = this.h1()) != null) {
                            fKBaseRecyclerViewAdapter2 = this.f11790e;
                            if (fKBaseRecyclerViewAdapter2 == null) {
                                s.A("recyclerAdapter");
                                fKBaseRecyclerViewAdapter2 = null;
                            }
                            fKBaseRecyclerViewAdapter2.d(h12);
                        }
                        fKBaseRecyclerViewAdapter = this.f11790e;
                        if (fKBaseRecyclerViewAdapter == null) {
                            s.A("recyclerAdapter");
                            fKBaseRecyclerViewAdapter = null;
                        }
                        fKBaseRecyclerViewAdapter.e(listResult2.getList());
                    }
                    str2 = this.f11791f;
                    if (str2 != null && str2.length() != 0) {
                        z10 = false;
                    }
                    if (z10) {
                        fKBaseRecyclerViewAdapter3 = this.f11790e;
                        if (fKBaseRecyclerViewAdapter3 == null) {
                            s.A("recyclerAdapter");
                        } else {
                            fKBaseRecyclerViewAdapter7 = fKBaseRecyclerViewAdapter3;
                        }
                        fKBaseRecyclerViewAdapter7.s();
                    }
                    this.k1();
                    ((FKSwipeRefreshLayout) this.T0(R$id.refreshLayout)).setRefreshing(false);
                    this.c1().c(false);
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.fragment.FKBaseListFragment$getResultList$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter;
                    FKErrorViewModel a12;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter2;
                    FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter3;
                    s.i(it, "it");
                    if (String.this == null) {
                        fKBaseRecyclerViewAdapter = this.f11790e;
                        FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter4 = null;
                        if (fKBaseRecyclerViewAdapter == null) {
                            s.A("recyclerAdapter");
                            fKBaseRecyclerViewAdapter = null;
                        }
                        List<Object> j10 = fKBaseRecyclerViewAdapter.j();
                        if ((j10 == null || j10.isEmpty()) && (a12 = this.a1()) != null) {
                            FKBaseListFragment<T> fKBaseListFragment = this;
                            fKBaseRecyclerViewAdapter2 = fKBaseListFragment.f11790e;
                            if (fKBaseRecyclerViewAdapter2 == null) {
                                s.A("recyclerAdapter");
                                fKBaseRecyclerViewAdapter2 = null;
                            }
                            fKBaseRecyclerViewAdapter2.d(a12);
                            fKBaseRecyclerViewAdapter3 = fKBaseListFragment.f11790e;
                            if (fKBaseRecyclerViewAdapter3 == null) {
                                s.A("recyclerAdapter");
                            } else {
                                fKBaseRecyclerViewAdapter4 = fKBaseRecyclerViewAdapter3;
                            }
                            fKBaseRecyclerViewAdapter4.notifyDataSetChanged();
                        }
                    }
                    ((FKSwipeRefreshLayout) this.T0(R$id.refreshLayout)).setRefreshing(false);
                    this.c1().c(false);
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    @Nullable
    public FKTitleUiModel h1() {
        return null;
    }

    public final void i1(boolean z10) {
        ((FKSwipeRefreshLayout) T0(R$id.refreshLayout)).setEnabled(z10);
    }

    public final void k1() {
        FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter = this.f11790e;
        if (fKBaseRecyclerViewAdapter == null) {
            s.A("recyclerAdapter");
            fKBaseRecyclerViewAdapter = null;
        }
        fKBaseRecyclerViewAdapter.notifyDataSetChanged();
    }

    public final void l1() {
        ((FKSwipeRefreshLayout) T0(R$id.refreshLayout)).setRefreshing(true);
        g1(this, null, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_base_sample_list, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        this.f11790e = d1();
        RecyclerView recyclerView = (RecyclerView) T0(R$id.baseSampleListRecyclerView);
        s.h(recyclerView, "this");
        Y0(recyclerView);
        FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter = this.f11790e;
        if (fKBaseRecyclerViewAdapter == null) {
            s.A("recyclerAdapter");
            fKBaseRecyclerViewAdapter = null;
        }
        recyclerView.setAdapter(fKBaseRecyclerViewAdapter);
        recyclerView.addOnScrollListener(c1());
        ((FKSwipeRefreshLayout) T0(R$id.refreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.base.fragment.c
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FKBaseListFragment.j1(FKBaseListFragment.this);
            }
        });
        g1(this, null, 1, null);
    }
}
