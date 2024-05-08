package com.huawei.flexiblelayout.card;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.a;
import com.huawei.flexiblelayout.card.dnode.FLDNodeListener;
import com.huawei.flexiblelayout.card.dnode.FLDNodeService;
import com.huawei.flexiblelayout.card.dnode.FLDockingView;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDNodeData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.services.exposure.CardExposureService;
import com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper;
import com.huawei.flexiblelayout.services.exposure.impl.ExposureTaskImpl;
import com.huawei.flexiblelayout.services.exposure.impl.VisibilityListener;

/* compiled from: FLDNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c extends FLNode<FLDNodeData> {

    /* renamed from: j, reason: collision with root package name */
    public static final String f27817j = "fldnode";

    /* renamed from: k, reason: collision with root package name */
    private static final String f27818k = "DOCKING_VIEW_TAG";

    /* renamed from: g, reason: collision with root package name */
    private FLContext f27819g;

    /* renamed from: h, reason: collision with root package name */
    private com.huawei.flexiblelayout.a f27820h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f27821i = false;

    /* compiled from: FLDNode.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f27822a;

        public a(View view) {
            this.f27822a = view;
        }

        private void a(@NonNull RecyclerView recyclerView) {
            FLDNodeData data;
            Float b4;
            if (c.this.f27820h == null || (data = c.this.getData()) == null) {
                return;
            }
            Integer topDockingDistance = data.getTopDockingDistance();
            Integer bottomDockingDistance = data.getBottomDockingDistance();
            if ((topDockingDistance == null && bottomDockingDistance == null) || (b4 = c.b(this.f27822a, recyclerView)) == null) {
                return;
            }
            if (topDockingDistance != null) {
                c.this.a(b4.intValue(), topDockingDistance.intValue());
            } else {
                c.this.a((recyclerView.getHeight() - b4.intValue()) - this.f27822a.getHeight(), bottomDockingDistance.intValue());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            a(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            a(recyclerView);
        }
    }

    /* compiled from: FLDNode.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f27824a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.OnScrollListener f27825b;

        public b(RecyclerView recyclerView, RecyclerView.OnScrollListener onScrollListener) {
            this.f27824a = recyclerView;
            this.f27825b = onScrollListener;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f27824a.addOnScrollListener(this.f27825b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f27824a.removeOnScrollListener(this.f27825b);
        }
    }

    /* compiled from: FLDNode.java */
    /* renamed from: com.huawei.flexiblelayout.card.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0265c implements FLDockingView {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final FLDNodeData f27827a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final FLayout f27828b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final AbsExposureHelper f27829c;

        public /* synthetic */ C0265c(FLDNodeData fLDNodeData, FLayout fLayout, AbsExposureHelper absExposureHelper, a aVar) {
            this(fLDNodeData, fLayout, absExposureHelper);
        }

        @Override // com.huawei.flexiblelayout.card.dnode.FLDockingView
        @NonNull
        public View getView() {
            return this.f27828b.getView();
        }

        @Override // com.huawei.flexiblelayout.card.dnode.FLDockingView
        public void onVisibilityChanged(boolean z10) {
            this.f27827a.setDocking(z10);
            AbsExposureHelper absExposureHelper = this.f27829c;
            if (absExposureHelper != null) {
                absExposureHelper.onVisibilityChanged(z10);
            }
        }

        private C0265c(@NonNull FLDNodeData fLDNodeData, @NonNull FLayout fLayout, @Nullable AbsExposureHelper absExposureHelper) {
            this.f27827a = fLDNodeData;
            this.f27828b = fLayout;
            this.f27829c = absExposureHelper;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(FLDNodeData fLDNodeData, FLCardData fLCardData, FLDockingView fLDockingView, int i10, FLDNodeListener fLDNodeListener) {
        fLDNodeListener.onDockingStart(this.f27819g, fLDNodeData, fLCardData, fLDockingView);
        fLDNodeListener.onDockingChanged(this.f27819g, fLDNodeData, fLCardData, fLDockingView, i10);
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27817j;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public void unbind(FLContext fLContext) {
        super.unbind(fLContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float b(View view, View view2) {
        Float b4;
        if (view != null && view2 != null) {
            if (view.getParent() == view2) {
                return Float.valueOf(view.getY());
            }
            if ((view.getParent() instanceof View) && (b4 = b((View) view.getParent(), view2)) != null) {
                return Float.valueOf(view.getY() + b4.floatValue());
            }
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public View buildChildView(FLContext fLContext, FLDNodeData fLDNodeData, ViewGroup viewGroup) {
        this.f27819g = fLContext;
        this.f27820h = (com.huawei.flexiblelayout.a) FLEngine.getInstance(fLContext.getContext()).getService(FLDNodeService.class);
        View buildChildView = super.buildChildView(fLContext, fLDNodeData, viewGroup);
        View view = fLContext.getFLayout().getView();
        if (view instanceof RecyclerView) {
            buildChildView.addOnAttachStateChangeListener(new b((RecyclerView) view, new a(buildChildView)));
        }
        return buildChildView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Px final int i10, int i11) {
        final FLDNodeData data = getData();
        if (data == null) {
            return;
        }
        int a10 = com.huawei.flexiblelayout.common.c.a(this.f27819g.getContext(), i11);
        final C0265c a11 = a();
        final FLCardData dockingCardData = data.getDockingCardData();
        if (a11 == null || dockingCardData == null) {
            return;
        }
        if (data.isDocking()) {
            if (i10 > a10) {
                data.setDocking(false);
                this.f27820h.a(new a.InterfaceC0263a() { // from class: com.huawei.flexiblelayout.card.l
                    @Override // com.huawei.flexiblelayout.a.InterfaceC0263a
                    public final void a(FLDNodeListener fLDNodeListener) {
                        c.this.a(data, dockingCardData, a11, fLDNodeListener);
                    }
                });
                return;
            } else {
                this.f27820h.a(new a.InterfaceC0263a() { // from class: com.huawei.flexiblelayout.card.n
                    @Override // com.huawei.flexiblelayout.a.InterfaceC0263a
                    public final void a(FLDNodeListener fLDNodeListener) {
                        c.this.a(data, dockingCardData, a11, i10, fLDNodeListener);
                    }
                });
                return;
            }
        }
        if (!this.f27821i && i10 >= a10) {
            this.f27821i = true;
        }
        if (i10 > a10 || !this.f27821i) {
            return;
        }
        this.f27821i = false;
        data.setDocking(true);
        this.f27820h.a(new a.InterfaceC0263a() { // from class: com.huawei.flexiblelayout.card.m
            @Override // com.huawei.flexiblelayout.a.InterfaceC0263a
            public final void a(FLDNodeListener fLDNodeListener) {
                c.this.b(data, dockingCardData, a11, i10, fLDNodeListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FLDNodeData fLDNodeData, FLCardData fLCardData, FLDockingView fLDockingView, FLDNodeListener fLDNodeListener) {
        fLDNodeListener.onDockingEnd(this.f27819g, fLDNodeData, fLCardData, fLDockingView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FLDNodeData fLDNodeData, FLCardData fLCardData, FLDockingView fLDockingView, int i10, FLDNodeListener fLDNodeListener) {
        fLDNodeListener.onDockingChanged(this.f27819g, fLDNodeData, fLCardData, fLDockingView, i10);
    }

    private C0265c a() {
        FLNodeData dockingNodeData;
        FLDNodeData data = getData();
        a aVar = null;
        if (data == null || (dockingNodeData = data.getDockingNodeData()) == null) {
            return null;
        }
        View view = this.f27819g.getFLayout().getView();
        if (!(view instanceof RecyclerView)) {
            return null;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        SparseArray sparseArray = (SparseArray) com.huawei.flexiblelayout.common.d.a((View) recyclerView, f27818k, SparseArray.class);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            com.huawei.flexiblelayout.common.d.a(recyclerView, f27818k, sparseArray);
        }
        C0265c c0265c = (C0265c) sparseArray.get(System.identityHashCode(data));
        if (c0265c != null) {
            return c0265c;
        }
        FLayout a10 = a(new LinearLayout(this.f27819g.getContext()), a(dockingNodeData, FLDataSource.findDataGroup(data)));
        C0265c c0265c2 = new C0265c(data, a10, a(a10), aVar);
        sparseArray.put(System.identityHashCode(data), c0265c2);
        return c0265c2;
    }

    private static FLDataSource a(@NonNull FLNodeData fLNodeData, @Nullable FLDataGroup fLDataGroup) {
        FLDataGroup.Builder create = FLDataGroup.create();
        if (fLDataGroup != null) {
            create.data(fLDataGroup.getData());
        }
        FLDataGroup build = create.build();
        build.addData(fLNodeData);
        FLDataSource fLDataSource = new FLDataSource();
        fLDataSource.addGroup(build);
        return fLDataSource;
    }

    private FLayout a(@NonNull ViewGroup viewGroup, @NonNull FLDataSource fLDataSource) {
        FLayout createChildFLayout = this.f27819g.getFLayout().createChildFLayout();
        createChildFLayout.setDataSource(fLDataSource);
        createChildFLayout.bind(FLayout.viewGroup(viewGroup));
        return createChildFLayout;
    }

    private AbsExposureHelper a(FLayout fLayout) {
        ExposureTaskImpl findTask = ExposureTaskImpl.findTask(this.f27819g.getFLayout());
        if (findTask == null) {
            return null;
        }
        ((CardExposureService) FLEngine.getInstance(this.f27819g.getContext()).getService(CardExposureService.class)).setup(fLayout, AbsExposureHelper.getDerivedExposureParam(findTask.getHelper().getParam()));
        ExposureTaskImpl findTask2 = ExposureTaskImpl.findTask(fLayout);
        if (findTask2 == null) {
            return null;
        }
        final AbsExposureHelper helper = findTask2.getHelper();
        if (findTask.getViewVisibilityOwner() != null) {
            findTask.getViewVisibilityOwner().addVisibilityObserver(new VisibilityListener() { // from class: com.huawei.flexiblelayout.card.o
                @Override // com.huawei.flexiblelayout.services.exposure.impl.VisibilityListener
                public final void onVisibilityChanged(boolean z10) {
                    c.this.a(helper, z10);
                }
            });
        }
        return helper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AbsExposureHelper absExposureHelper, boolean z10) {
        if (getData() == null || !getData().isDocking()) {
            return;
        }
        absExposureHelper.onVisibilityChanged(z10);
    }
}
