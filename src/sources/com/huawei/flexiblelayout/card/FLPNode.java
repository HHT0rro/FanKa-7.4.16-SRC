package com.huawei.flexiblelayout.card;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.card.props.CardSpecHelper;
import com.huawei.flexiblelayout.card.props.FLCardProps;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.adapter.CSSPropertyName;
import com.huawei.flexiblelayout.css.adapter.value.integrate.space.CSSSpaceValue;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.FLPNodeData;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hwwidgetsupport.api.HwWidgetService;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventQueue;
import com.huawei.jmessage.api.EventSourceManager;
import com.huawei.jmessage.api.MessageChannelPayload;
import com.huawei.jmessage.sources.MessageChannelSource;
import com.huawei.pnodesupport.api.FLPNodeDelegate;
import com.huawei.pnodesupport.api.FLPNodeParam;
import com.huawei.pnodesupport.api.FLPNodeService;
import com.huawei.pnodesupport.impl.FLPNodeScrollEventSource;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLPNode extends FLNode<FLPNodeData> {
    public static final String KEY_CONFIG = "config";
    public static final String KEY_VIEW_PAGER = "viewPager";
    public static final String MESSAGE_BIND = "bind";
    public static final String TYPE = "flpnode";

    /* renamed from: q, reason: collision with root package name */
    private static final int f27765q = 10;

    /* renamed from: a, reason: collision with root package name */
    private e f27766a;

    /* renamed from: b, reason: collision with root package name */
    private HwViewPager f27767b;

    /* renamed from: c, reason: collision with root package name */
    private FLContext f27768c;

    /* renamed from: d, reason: collision with root package name */
    private FLCardProps f27769d;

    /* renamed from: g, reason: collision with root package name */
    private FLPNodeDelegate f27772g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private com.huawei.pnodesupport.impl.e f27773h;

    /* renamed from: i, reason: collision with root package name */
    private IndicatorCard f27774i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private FLCell<FLCardData> f27775j;

    /* renamed from: n, reason: collision with root package name */
    private final d f27779n;

    /* renamed from: o, reason: collision with root package name */
    private int f27780o;

    /* renamed from: p, reason: collision with root package name */
    private final com.huawei.pnodesupport.impl.d f27781p;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final FLPNodeParam f27770e = new FLPNodeParam();

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private com.huawei.pnodesupport.impl.b f27771f = new com.huawei.pnodesupport.impl.b();

    /* renamed from: k, reason: collision with root package name */
    private final List<com.huawei.pnodesupport.impl.f> f27776k = new ArrayList(10);

    /* renamed from: l, reason: collision with root package name */
    private final List<com.huawei.pnodesupport.impl.f> f27777l = new LinkedList();

    /* renamed from: m, reason: collision with root package name */
    private final CardSpecHelper.ScreenChangedObserver f27778m = new CardSpecHelper.ScreenChangedObserver() { // from class: com.huawei.flexiblelayout.card.j
        @Override // com.huawei.flexiblelayout.card.props.CardSpecHelper.ScreenChangedObserver
        public final void update() {
            FLPNode.this.a();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FLContext f27782a;

        public a(FLContext fLContext) {
            this.f27782a = fLContext;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FLPNode fLPNode = FLPNode.this;
            fLPNode.a(fLPNode.c());
            FLEngine.getInstance(this.f27782a.getContext()).getCardSpecHelper().registerScreenChanged(FLPNode.this.f27778m);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FLEngine.getInstance(this.f27782a.getContext()).getCardSpecHelper().unregisterScreenChanged(FLPNode.this.f27778m);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends HwViewPager.SimpleOnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FLContext f27784a;

        public b(FLContext fLContext) {
            this.f27784a = fLContext;
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.SimpleOnPageChangeListener, com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            FLPNodeData data = FLPNode.this.getData();
            if (data == null) {
                return;
            }
            data.a(i10);
            if (FLPNode.this.f27775j != null) {
                FLPNode.this.f27775j.bind(this.f27784a, FLDataSource.findDataGroup(data), data.getChild(i10));
            }
            if (FLPNode.this.f27773h != null) {
                FLPNode.this.f27773h.a(FLPNode.this.f27777l, FLPNode.this.f27781p.getCount(), FLPNode.this.f27767b.getCurrentItem(), FLPNode.this.f27771f.a());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c implements EventCallback {
        public c() {
        }

        @Override // com.huawei.jmessage.api.EventCallback
        public void call(EventCallback.Message message) {
            MessageChannelSource.Payload payload;
            if (message == null || (payload = (MessageChannelSource.Payload) message.getPayload(MessageChannelSource.Payload.class)) == null) {
                return;
            }
            String method = payload.getMethod();
            method.hashCode();
            if (!method.equals("bind")) {
                payload.onNotImplemented();
                return;
            }
            FLPNode.this.f27774i = (IndicatorCard) payload.getArgument(IndicatorCard.f27794f, IndicatorCard.class);
            if (FLPNode.this.f27774i != null) {
                FLMap newJson = Jsons.newJson();
                newJson.put(FLPNode.KEY_VIEW_PAGER, FLPNode.this.f27767b);
                newJson.put(FLPNode.KEY_CONFIG, FLPNode.this.f27771f);
                FLPNode fLPNode = FLPNode.this;
                fLPNode.a(fLPNode.f27774i, new MessageChannelPayload.Builder("bind").args(newJson).build());
                payload.onSuccess(new Object[0]);
                return;
            }
            payload.onError(new Object[0]);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d implements com.huawei.pnodesupport.impl.g {
        private d() {
        }

        public /* synthetic */ d(FLPNode fLPNode, a aVar) {
            this();
        }

        @Override // com.huawei.pnodesupport.impl.g
        public void a(@NonNull FLPNodeData fLPNodeData) {
            FLDataGroup findDataGroup = FLDataSource.findDataGroup(fLPNodeData);
            for (com.huawei.pnodesupport.impl.f fVar : FLPNode.this.f27777l) {
                fVar.a().bind(FLPNode.this.f27768c, findDataGroup, fLPNodeData.getChild(fVar.b()));
            }
        }

        @Override // com.huawei.pnodesupport.impl.g
        public void a(@NonNull com.huawei.pnodesupport.impl.f fVar) {
            FLPNode.this.f27777l.remove(fVar);
            fVar.a().unbind(FLPNode.this.f27768c);
            if (FLPNode.this.f27776k.size() < 10) {
                FLPNode.this.f27776k.add(fVar);
            }
        }

        @Override // com.huawei.pnodesupport.impl.g
        public com.huawei.pnodesupport.impl.f a(int i10, @NonNull FLCardData fLCardData) {
            com.huawei.pnodesupport.impl.f a10;
            if (!FLPNode.this.f27776k.isEmpty()) {
                a10 = (com.huawei.pnodesupport.impl.f) FLPNode.this.f27776k.remove(FLPNode.this.f27776k.size() - 1);
                a10.a(i10);
                a10.a().bind(FLPNode.this.f27768c, FLDataSource.findDataGroup(fLCardData), fLCardData);
            } else {
                a10 = a(i10, fLCardData, FLPNode.this.f27766a, true);
                if (a10 == null) {
                    return null;
                }
            }
            if (FLPNode.this.f27773h != null) {
                FLPNode.this.f27773h.a(a10, FLPNode.this.f27781p.getCount(), FLPNode.this.f27767b.getCurrentItem(), FLPNode.this.f27771f.a());
            }
            FLPNode.this.f27777l.add(a10);
            return a10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.huawei.pnodesupport.impl.f a(int i10, @NonNull FLCardData fLCardData, ViewGroup viewGroup, boolean z10) {
            FLCell<FLCardData> createCard;
            if (fLCardData instanceof FLNodeData) {
                createCard = FLPNode.this.createNode(fLCardData.getType());
            } else {
                createCard = FLPNode.this.createCard(fLCardData.getType());
            }
            if (createCard == null) {
                return null;
            }
            createCard.setParent(FLPNode.this);
            createCard.build(FLPNode.this.f27768c, fLCardData, viewGroup);
            if (z10) {
                createCard.bind(FLPNode.this.f27768c, FLDataSource.findDataGroup(fLCardData), fLCardData);
            }
            return new com.huawei.pnodesupport.impl.f(i10, createCard);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        private float f27788a;

        /* renamed from: b, reason: collision with root package name */
        private float f27789b;

        /* renamed from: c, reason: collision with root package name */
        private int f27790c;

        /* renamed from: d, reason: collision with root package name */
        private View f27791d;

        public e(@NonNull Context context, FLPNodeData fLPNodeData) {
            super(context);
            this.f27790c = ViewConfiguration.get(context).getScaledTouchSlop();
            a(fLPNodeData);
        }

        private void a(FLPNodeData fLPNodeData) {
            com.huawei.pnodesupport.impl.f a10;
            if (fLPNodeData == null || fLPNodeData.getSize() == 0 || (a10 = FLPNode.this.f27779n.a(0, fLPNodeData.getChild(0), this, false)) == null) {
                return;
            }
            FLPNode.this.f27775j = a10.a();
            View rootView = FLPNode.this.f27775j.getRootView();
            this.f27791d = rootView;
            addView(rootView);
            this.f27791d.setVisibility(4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
        
            if (r0 != 4) goto L20;
         */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                int r0 = r8.getActionMasked()
                r1 = 0
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L56
                if (r0 == r3) goto L41
                if (r0 == r2) goto L14
                r3 = 3
                if (r0 == r3) goto L41
                r3 = 4
                if (r0 == r3) goto L41
                goto L7d
            L14:
                float r0 = r8.getRawX()
                float r4 = r7.f27788a
                float r0 = r0 - r4
                float r0 = java.lang.Math.abs(r0)
                float r4 = r8.getRawY()
                float r5 = r7.f27789b
                float r4 = r4 - r5
                float r4 = java.lang.Math.abs(r4)
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 <= 0) goto L37
                int r0 = r7.f27790c
                float r0 = (float) r0
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 <= 0) goto L37
                r0 = 1
                goto L38
            L37:
                r0 = 0
            L38:
                android.view.ViewParent r4 = r7.getParent()
                r0 = r0 ^ r3
                r4.requestDisallowInterceptTouchEvent(r0)
                goto L7d
            L41:
                com.huawei.flexiblelayout.card.FLPNode r0 = com.huawei.flexiblelayout.card.FLPNode.this
                com.huawei.flexiblelayout.card.IndicatorCard r3 = com.huawei.flexiblelayout.card.FLPNode.d(r0)
                com.huawei.jmessage.api.MessageChannelPayload$Builder r4 = new com.huawei.jmessage.api.MessageChannelPayload$Builder
                java.lang.String r5 = "requestStart"
                r4.<init>(r5)
                com.huawei.jmessage.api.MessageChannelPayload r4 = r4.build()
                com.huawei.flexiblelayout.card.FLPNode.a(r0, r3, r4)
                goto L7d
            L56:
                com.huawei.flexiblelayout.card.FLPNode r0 = com.huawei.flexiblelayout.card.FLPNode.this
                com.huawei.flexiblelayout.card.IndicatorCard r4 = com.huawei.flexiblelayout.card.FLPNode.d(r0)
                com.huawei.jmessage.api.MessageChannelPayload$Builder r5 = new com.huawei.jmessage.api.MessageChannelPayload$Builder
                java.lang.String r6 = "requestStop"
                r5.<init>(r6)
                com.huawei.jmessage.api.MessageChannelPayload r5 = r5.build()
                com.huawei.flexiblelayout.card.FLPNode.a(r0, r4, r5)
                float r0 = r8.getRawX()
                r7.f27788a = r0
                float r0 = r8.getRawY()
                r7.f27789b = r0
                android.view.ViewParent r0 = r7.getParent()
                r0.requestDisallowInterceptTouchEvent(r3)
            L7d:
                com.huawei.flexiblelayout.card.FLPNode r0 = com.huawei.flexiblelayout.card.FLPNode.this
                com.huawei.uikit.hwviewpager.widget.HwViewPager r0 = com.huawei.flexiblelayout.card.FLPNode.k(r0)
                boolean r0 = r0.isSupportLoop()
                if (r0 == 0) goto L9d
                com.huawei.flexiblelayout.card.FLPNode r0 = com.huawei.flexiblelayout.card.FLPNode.this
                com.huawei.uikit.hwviewpager.widget.HwViewPager r0 = com.huawei.flexiblelayout.card.FLPNode.k(r0)
                r0.dispatchTouchEvent(r8)
                com.huawei.flexiblelayout.card.FLPNode r0 = com.huawei.flexiblelayout.card.FLPNode.this
                com.huawei.uikit.hwviewpager.widget.HwViewPager r0 = com.huawei.flexiblelayout.card.FLPNode.k(r0)
                boolean r8 = r0.onTouchEvent(r8)
                return r8
            L9d:
                int r0 = r8.getActionMasked()
                if (r0 != r2) goto La4
                return r1
            La4:
                com.huawei.flexiblelayout.card.FLPNode r0 = com.huawei.flexiblelayout.card.FLPNode.this
                com.huawei.uikit.hwviewpager.widget.HwViewPager r0 = com.huawei.flexiblelayout.card.FLPNode.k(r0)
                boolean r8 = r0.dispatchTouchEvent(r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.flexiblelayout.card.FLPNode.e.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            this.f27790c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            ViewGroup.LayoutParams layoutParams = this.f27791d.getLayoutParams();
            int size = View.MeasureSpec.getSize(i10);
            int paddingStart = ((size - getPaddingStart()) - getPaddingEnd()) / FLPNode.this.f27771f.a();
            int i12 = layoutParams.height;
            int i13 = layoutParams.width;
            if (i13 > 0 && i12 > 0) {
                i12 = (int) ((paddingStart / i13) * i12);
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingStart, 1073741824);
            this.f27791d.measure(makeMeasureSpec, FrameLayout.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), i12));
            int measuredHeight = this.f27791d.getMeasuredHeight();
            FLPNode.this.f27767b.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight + getPaddingTop() + getPaddingBottom(), 1073741824));
        }
    }

    public FLPNode() {
        d dVar = new d(this, null);
        this.f27779n = dVar;
        this.f27780o = 0;
        this.f27781p = new com.huawei.pnodesupport.impl.d(dVar);
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public FLCell<FLCardData> getChildAt(int i10) {
        if (i10 < 0 || i10 >= getChildCount()) {
            return null;
        }
        return this.f27777l.get(i10).a();
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public int getChildCount() {
        return this.f27777l.size();
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return TYPE;
    }

    public HwViewPager getViewPager() {
        return this.f27767b;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public void unbind(FLContext fLContext) {
        super.unbind(fLContext);
        Iterator<com.huawei.pnodesupport.impl.f> iterator2 = this.f27777l.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a().unbind(this.f27768c);
        }
        FLCell<FLCardData> fLCell = this.f27775j;
        if (fLCell != null && fLCell.isReady()) {
            this.f27775j.unbind(fLContext);
        }
        if (this.f27780o != 0) {
            ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).unsubscribe(this.f27780o);
            this.f27780o = 0;
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public boolean visit(@NonNull Visitor visitor) {
        if (!visitor.onVisitNode(this)) {
            return false;
        }
        int count = this.f27781p.getCount();
        int currentItem = this.f27767b.getCurrentItem();
        int a10 = this.f27771f.a();
        for (com.huawei.pnodesupport.impl.f fVar : this.f27777l) {
            if (com.huawei.pnodesupport.impl.e.a(fVar.b(), count, currentItem, a10) && !fVar.a().visit(visitor)) {
                return false;
            }
        }
        return true;
    }

    private HwViewPager b(FLContext fLContext, FLPNodeData fLPNodeData) {
        FLPNodeDelegate fLPNodeDelegate = this.f27772g;
        HwViewPager createViewPager = fLPNodeDelegate != null ? fLPNodeDelegate.createViewPager(fLContext, fLPNodeData) : null;
        if (createViewPager == null) {
            createViewPager = (HwViewPager) ((HwWidgetService) FLEngine.getInstance(fLContext.getContext()).getService(HwWidgetService.class)).createWidget(HwViewPager.class, fLContext.getContext());
        }
        this.f27766a.addView(createViewPager);
        createViewPager.setClipChildren(false);
        createViewPager.setClipToPadding(false);
        createViewPager.setAdapter(this.f27781p);
        createViewPager.addOnPageChangeListener(new b(fLContext));
        FLPNodeDelegate fLPNodeDelegate2 = this.f27772g;
        if (fLPNodeDelegate2 != null) {
            fLPNodeDelegate2.onViewPagerCreated(createViewPager, fLPNodeData, this.f27770e);
        }
        return createViewPager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.pnodesupport.impl.b c() {
        com.huawei.pnodesupport.impl.b bVar = new com.huawei.pnodesupport.impl.b();
        bVar.a(FLEngine.getInstance(this.f27768c.getContext()).getCardSpecHelper().getCardNumbers(this.f27769d));
        return bVar;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public View buildChildView(FLContext fLContext, FLPNodeData fLPNodeData, ViewGroup viewGroup) {
        this.f27768c = fLContext;
        this.f27772g = ((FLPNodeService) FLEngine.getInstance(fLContext.getContext()).getService(FLPNodeService.class)).getDelegate();
        this.f27769d = com.huawei.pnodesupport.impl.c.a(fLPNodeData);
        a(fLPNodeData, viewGroup);
        this.f27766a = a(fLContext, fLPNodeData);
        this.f27767b = b(fLContext, fLPNodeData);
        if (this.f27770e.useDefaultVisibilityDispatcher) {
            this.f27773h = new com.huawei.pnodesupport.impl.e(fLContext);
        }
        this.f27766a.addOnAttachStateChangeListener(new a(fLContext));
        return this.f27766a;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public ViewGroup buildView(FLContext fLContext, FLPNodeData fLPNodeData) {
        EventSourceManager eventSourceManager = (EventSourceManager) ComponentRepository.getRepository().lookup(jmessage.name).create(EventSourceManager.class);
        if (eventSourceManager.findEventSource(FLPNodeScrollEventSource.f33066b) != null) {
            return null;
        }
        eventSourceManager.register(FLPNodeScrollEventSource.f33066b, FLPNodeScrollEventSource.class);
        return null;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public void setData(FLContext fLContext, FLDataGroup fLDataGroup, FLPNodeData fLPNodeData) {
        b();
        this.f27769d = com.huawei.pnodesupport.impl.c.a(fLPNodeData);
        if (!this.f27767b.isSupportLoop()) {
            fLPNodeData.a(0);
        }
        this.f27767b.setCurrentItem(fLPNodeData.a(), false);
        this.f27781p.a(fLPNodeData);
        FLCell<FLCardData> fLCell = this.f27775j;
        if (fLCell != null) {
            fLCell.bind(fLContext, fLDataGroup, fLPNodeData.getChild(fLPNodeData.a()));
        }
        a(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        a(c());
    }

    private void a(FLPNodeData fLPNodeData, ViewGroup viewGroup) {
        CSSSpaceValue cSSSpaceValue;
        CSSRule cssRule = fLPNodeData.getCssRule();
        if (cssRule == null || (cSSSpaceValue = (CSSSpaceValue) cssRule.getPropertyValue(CSSPropertyName.FL_MARGIN)) == null) {
            return;
        }
        if (cSSSpaceValue.getLeftSpace() > 0 || cSSSpaceValue.getRightSpace() > 0) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    private e a(FLContext fLContext, FLPNodeData fLPNodeData) {
        e eVar = new e(fLContext.getContext(), fLPNodeData);
        eVar.setClipChildren(false);
        eVar.setClipToPadding(false);
        eVar.setLayoutParams(new LinearLayout.LayoutParams(getDefaultWidth(fLContext.getFLayout()), getDefaultHeight(fLContext.getFLayout())));
        return eVar;
    }

    private void b() {
        if (this.f27780o != 0) {
            return;
        }
        this.f27780o = ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).subscribe(MessageChannelSource.TOPIC, this, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.huawei.pnodesupport.impl.b bVar) {
        if (!this.f27771f.equals(bVar)) {
            this.f27771f = bVar;
            this.f27767b.setOffscreenPageLimit(bVar.a());
            this.f27767b.setSupportLoop(this.f27781p.getCount() > bVar.a());
            this.f27766a.requestLayout();
        }
        FLMap newJson = Jsons.newJson();
        newJson.put(KEY_CONFIG, bVar);
        a(this.f27774i, new MessageChannelPayload.Builder(IndicatorCard.f27797i).args(newJson).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, MessageChannelPayload messageChannelPayload) {
        if (obj != null) {
            ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).publish(MessageChannelSource.TOPIC, messageChannelPayload, obj);
        }
    }
}
