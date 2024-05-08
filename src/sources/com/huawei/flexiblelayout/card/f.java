package com.huawei.flexiblelayout.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.text.TextUtilsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.AdapterBuilder;
import com.huawei.flexiblelayout.adapter.CardAdapter;
import com.huawei.flexiblelayout.adapter.FLLinearLayoutManager;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.card.snode.FLSNodeController;
import com.huawei.flexiblelayout.card.snode.FLSNodeDelegate;
import com.huawei.flexiblelayout.card.snode.FLSNodeService;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLSNodeData;
import com.huawei.flexiblelayout.data.changed.FLDataChangedRequest;
import com.huawei.flexiblelayout.data.changed.FLRefreshDataRequest;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.csslink.CSSLinkManager;
import com.huawei.flexiblelayout.parser.csslink.LinkProvider;
import com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer;
import com.huawei.flexiblelayout.view.LayoutView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: FLSNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f extends FLNode<FLSNodeData> implements FLayoutContainer {

    /* renamed from: m, reason: collision with root package name */
    private static final String f27832m = "FLSNode";

    /* renamed from: n, reason: collision with root package name */
    public static final String f27833n = "flsnode";

    /* renamed from: o, reason: collision with root package name */
    private static final String f27834o = "_snodectrl_";

    /* renamed from: g, reason: collision with root package name */
    private FLayout f27835g;

    /* renamed from: h, reason: collision with root package name */
    private FLSNodeData f27836h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f27837i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayoutManager f27838j;

    /* renamed from: k, reason: collision with root package name */
    private FLSNodeDelegate f27839k;

    /* renamed from: l, reason: collision with root package name */
    private c f27840l;

    /* compiled from: FLSNode.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements LayoutView {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LayoutView f27841a;

        public a(LayoutView layoutView) {
            this.f27841a = layoutView;
        }

        @Override // com.huawei.flexiblelayout.view.LayoutView
        public LayoutView.ScrollDirection getScrollDirection() {
            return this.f27841a.getScrollDirection();
        }

        @Override // com.huawei.flexiblelayout.view.LayoutView
        public View getView() {
            return this.f27841a.getView();
        }

        @Override // com.huawei.flexiblelayout.view.LayoutView
        public void mount(FLayout fLayout) {
            this.f27841a.mount(fLayout);
        }

        @Override // com.huawei.flexiblelayout.view.LayoutView
        public void onDataSourceChanged() {
            this.f27841a.onDataSourceChanged();
        }

        @Override // com.huawei.flexiblelayout.view.LayoutView
        public void requestDataChanged(FLDataChangedRequest fLDataChangedRequest) {
            this.f27841a.requestDataChanged(new FLRefreshDataRequest());
        }
    }

    /* compiled from: FLSNode.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements AdapterBuilder {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<f> f27843a;

        /* renamed from: b, reason: collision with root package name */
        private FLContext f27844b;

        public /* synthetic */ b(FLContext fLContext, f fVar, a aVar) {
            this(fLContext, fVar);
        }

        @Override // com.huawei.flexiblelayout.adapter.AdapterBuilder
        public RecyclerView.Adapter newAdapter(@NonNull Context context, @NonNull FLDataSource fLDataSource) {
            WeakReference<f> weakReference = this.f27843a;
            if (weakReference == null) {
                return new CardAdapter(fLDataSource);
            }
            f fVar = weakReference.get();
            if (fVar != null) {
                FLSNodeData fLSNodeData = fVar.f27836h;
                if (fLSNodeData != null) {
                    FLayout fLayout = fVar.f27835g;
                    if (fLayout != null) {
                        FLSNodeDelegate fLSNodeDelegate = fVar.f27839k;
                        if (fLSNodeDelegate == null) {
                            return new CardAdapter(fLDataSource);
                        }
                        RecyclerView.Adapter onCreateAdapter = fLSNodeDelegate.onCreateAdapter(this.f27844b, fLayout, fLSNodeData);
                        return onCreateAdapter == null ? new CardAdapter(fLDataSource) : onCreateAdapter;
                    }
                    Log.e(f.f27832m, "fLayout == null");
                    return null;
                }
                Log.e(f.f27832m, "nodeData == null");
                return null;
            }
            Log.e(f.f27832m, "sNode == null");
            return null;
        }

        private b(FLContext fLContext, f fVar) {
            this.f27843a = new WeakReference<>(fVar);
            this.f27844b = fLContext;
        }
    }

    /* compiled from: FLSNode.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        private FLSNodeData f27845a;

        /* renamed from: b, reason: collision with root package name */
        private LinearLayoutManager f27846b;

        public /* synthetic */ c(FLSNodeData fLSNodeData, LinearLayoutManager linearLayoutManager, a aVar) {
            this(fLSNodeData, linearLayoutManager);
        }

        public FLSNodeData a() {
            return this.f27845a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                a(this.f27845a);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
        }

        private c(FLSNodeData fLSNodeData, LinearLayoutManager linearLayoutManager) {
            this.f27845a = fLSNodeData;
            this.f27846b = linearLayoutManager;
        }

        private void a(FLSNodeData fLSNodeData) {
            LinearLayoutManager linearLayoutManager = this.f27846b;
            if (linearLayoutManager == null) {
                Log.w(f.f27832m, "savePosition, recyclerview created by developers sets a non LinearLayoutManager");
                return;
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = this.f27846b.findLastCompletelyVisibleItemPosition();
            if (this.f27846b.getItemCount() > 0 && findLastCompletelyVisibleItemPosition == this.f27846b.getItemCount() - 1) {
                fLSNodeData.setLastPosition(findLastCompletelyVisibleItemPosition);
            } else {
                fLSNodeData.setLastPosition(findFirstVisibleItemPosition);
            }
            fLSNodeData.setSpaceOffset(0);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public View buildChildView(FLContext fLContext, FLSNodeData fLSNodeData, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer
    public /* synthetic */ FLayoutContainer.BoundFLayout getBoundFLayout() {
        return com.huawei.flexiblelayout.services.exposure.impl.f.a(this);
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public FLCell<FLCardData> getChildAt(int i10) {
        return null;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public int getChildCount() {
        return 0;
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer
    @NonNull
    public FLayout getFLayout() {
        return this.f27835g;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27833n;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public void unbind(FLContext fLContext) {
        super.unbind(fLContext);
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public boolean visit(@NonNull Visitor visitor) {
        return visitor.onVisitNode(this);
    }

    private void b(FLContext fLContext, FLDataGroup fLDataGroup, FLSNodeData fLSNodeData) {
        FLSNodeController b4;
        FLDataSource a10 = a(fLContext, fLSNodeData, fLDataGroup);
        FLDataSource dataSource = this.f27835g.getDataSource();
        if (dataSource != a10) {
            if (dataSource != null && (b4 = b(this.f27836h)) != null) {
                b4.onDetach(this.f27837i);
            }
            this.f27836h = fLSNodeData;
            this.f27835g.setDataSource(a10);
            FLSNodeController b10 = b(fLSNodeData);
            if (b10 != null) {
                b10.onAttach(this.f27837i);
            }
        }
    }

    private void c(FLSNodeData fLSNodeData) {
        LinearLayoutManager linearLayoutManager = this.f27838j;
        if (linearLayoutManager == null) {
            Log.w(f27832m, "restore, recyclerview created by developers sets a non LinearLayoutManager");
        } else if (fLSNodeData != null) {
            linearLayoutManager.scrollToPositionWithOffset(fLSNodeData.getLastPosition(), fLSNodeData.getSpaceOffset());
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewGroup buildView(FLContext fLContext, FLSNodeData fLSNodeData) {
        this.f27839k = ((FLSNodeService) FLEngine.getInstance(fLContext.getContext()).getService(FLSNodeService.class)).getDelegate();
        FLayout a10 = a(fLContext);
        this.f27835g = a10;
        RecyclerView a11 = a(fLContext, a10);
        this.f27837i = a11;
        this.f27835g.bind(new a(FLayout.recyclerView(a11, new b(fLContext, this, null))));
        FLSNodeDelegate fLSNodeDelegate = this.f27839k;
        if (fLSNodeDelegate != null) {
            fLSNodeDelegate.onViewCreated(fLContext, this.f27835g, this.f27837i);
        }
        return this.f27837i;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public FLSNodeData getData() {
        return this.f27836h;
    }

    private FLSNodeController b(FLSNodeData fLSNodeData) {
        if (fLSNodeData == null) {
            return null;
        }
        Object tag = fLSNodeData.getTag(f27834o);
        if (tag instanceof FLSNodeController) {
            return (FLSNodeController) tag;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setData(FLContext fLContext, FLDataGroup fLDataGroup, FLSNodeData fLSNodeData) {
        a(fLSNodeData);
        b(fLContext, fLDataGroup, fLSNodeData);
        c(fLSNodeData);
    }

    private void b(FLContext fLContext, FLSNodeData fLSNodeData) {
        FLSNodeController onCreateController;
        FLSNodeDelegate fLSNodeDelegate = this.f27839k;
        if (fLSNodeDelegate == null || (onCreateController = fLSNodeDelegate.onCreateController(fLContext, this.f27835g, fLSNodeData)) == null) {
            return;
        }
        fLSNodeData.setTag(f27834o, onCreateController);
    }

    private FLDataSource a(FLContext fLContext, FLSNodeData fLSNodeData, FLDataGroup fLDataGroup) {
        FLDataSource dataSource = fLSNodeData.getDataSource();
        if (dataSource != null) {
            return dataSource;
        }
        FLDataSource fLDataSource = new FLDataSource();
        fLDataSource.addGroup(a(fLSNodeData, fLDataGroup));
        fLSNodeData.setDataSource(fLDataSource);
        b(fLContext, fLSNodeData);
        return fLDataSource;
    }

    private void a(FLSNodeData fLSNodeData) {
        c cVar = this.f27840l;
        if (cVar == null || cVar.a() != fLSNodeData) {
            a(this.f27840l);
            c cVar2 = new c(fLSNodeData, this.f27838j, null);
            this.f27840l = cVar2;
            this.f27837i.addOnScrollListener(cVar2);
        }
    }

    private void a(RecyclerView.OnScrollListener onScrollListener) {
        if (onScrollListener != null) {
            this.f27837i.removeOnScrollListener(onScrollListener);
        }
    }

    private FLayout a(FLContext fLContext) {
        if (this.f27835g == null) {
            FLayout createChildFLayout = fLContext.getFLayout().createChildFLayout();
            this.f27835g = createChildFLayout;
            createChildFLayout.registerLayoutDelegate(fLContext.getFLayout().getLayoutDelegate());
        }
        return this.f27835g;
    }

    private RecyclerView a(FLContext fLContext, FLayout fLayout) {
        if (this.f27837i == null) {
            FLSNodeDelegate fLSNodeDelegate = this.f27839k;
            if (fLSNodeDelegate != null) {
                this.f27837i = fLSNodeDelegate.onCreateView(fLContext, fLayout);
            }
            if (this.f27837i == null) {
                this.f27837i = new RecyclerView(fLContext.getContext());
            }
            RecyclerView.LayoutManager layoutManager = this.f27837i.getLayoutManager();
            if (layoutManager == null) {
                this.f27838j = new FLLinearLayoutManager(fLContext.getContext(), 0, false);
                if (a()) {
                    this.f27837i.setLayoutDirection(1);
                }
                this.f27837i.setLayoutManager(this.f27838j);
            } else if (layoutManager instanceof LinearLayoutManager) {
                this.f27838j = (LinearLayoutManager) layoutManager;
            }
            a(this.f27837i);
        }
        return this.f27837i;
    }

    private void a(RecyclerView recyclerView) {
        recyclerView.setOnFlingListener(null);
        com.huawei.flexiblelayout.card.snode.b bVar = new com.huawei.flexiblelayout.card.snode.b(8388611);
        bVar.a(3.0f);
        bVar.b(50.0f);
        bVar.attachToRecyclerView(recyclerView);
    }

    private FLDataGroup a(FLSNodeData fLSNodeData, FLDataGroup fLDataGroup) {
        FLDataGroup build = FLDataGroup.create().id(fLDataGroup.getId()).data(fLDataGroup.getData()).build();
        fLSNodeData.appendToGroup(build);
        LinkProvider linkProvider = CSSLinkManager.getInstance().getLinkProvider(fLDataGroup);
        if (linkProvider != null) {
            CSSLinkManager.getInstance().putLinkProvider(build, linkProvider);
        }
        return build;
    }

    private static boolean a() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
}
