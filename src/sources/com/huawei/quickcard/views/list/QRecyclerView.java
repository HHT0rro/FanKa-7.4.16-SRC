package com.huawei.quickcard.views.list;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.IRecyclerHost;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.CardThreadUtils;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.c1;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.bean.CardElement;
import com.huawei.quickcard.framework.condition.ConditionalChild;
import com.huawei.quickcard.framework.ui.IViewDirection;
import com.huawei.quickcard.l0;
import com.huawei.quickcard.utils.DeviceInfoUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.views.list.BounceHandler;
import com.huawei.quickcard.views.list.layoutmanager.QGridLayoutManager;
import com.huawei.quickcard.views.list.layoutmanager.QStaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QRecyclerView extends RecyclerView implements IComponentSupport, IQRecyclerView, BounceHandler.BounceView, IViewDirection, IRecyclerHost {
    private static final String D = "QRecyclerView";
    private static final String E = "linear";
    private static final String F = "pager";
    public static final String SHOW_BEGIN_KEY = "begin";
    public static final String SHOW_END_KEY = "end";
    private d A;
    private boolean B;
    private int C;

    /* renamed from: a, reason: collision with root package name */
    public g f34578a;

    /* renamed from: b, reason: collision with root package name */
    public h f34579b;

    /* renamed from: c, reason: collision with root package name */
    public i f34580c;

    /* renamed from: d, reason: collision with root package name */
    public j f34581d;

    /* renamed from: e, reason: collision with root package name */
    public k f34582e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView.LayoutManager f34583f;

    /* renamed from: g, reason: collision with root package name */
    public int f34584g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f34585h;

    /* renamed from: i, reason: collision with root package name */
    private String f34586i;

    /* renamed from: j, reason: collision with root package name */
    private int f34587j;

    /* renamed from: k, reason: collision with root package name */
    private int f34588k;

    /* renamed from: l, reason: collision with root package name */
    private c1 f34589l;

    /* renamed from: m, reason: collision with root package name */
    private List<IListItemData> f34590m;

    /* renamed from: n, reason: collision with root package name */
    private float f34591n;

    /* renamed from: o, reason: collision with root package name */
    private float f34592o;

    /* renamed from: p, reason: collision with root package name */
    private int f34593p;

    /* renamed from: q, reason: collision with root package name */
    private int f34594q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f34595r;

    /* renamed from: s, reason: collision with root package name */
    private BounceHandler f34596s;

    /* renamed from: t, reason: collision with root package name */
    private b f34597t;

    /* renamed from: u, reason: collision with root package name */
    private RecyclerView.OnScrollListener f34598u;

    /* renamed from: v, reason: collision with root package name */
    private ExposureManager f34599v;

    /* renamed from: w, reason: collision with root package name */
    private l0 f34600w;

    /* renamed from: x, reason: collision with root package name */
    private String f34601x;

    /* renamed from: y, reason: collision with root package name */
    private float f34602y;

    /* renamed from: z, reason: collision with root package name */
    private int f34603z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends GridLayoutManager.SpanSizeLookup {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i10) {
            return 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements Interpolator {
        private b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) (1.0d - Math.pow(Math.abs(f10 - 1.0f), 2.0d));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum c {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        NONE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d extends RecyclerView.ItemDecoration {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            YogaNode yogaNode = YogaUtils.getYogaNode(view);
            if (yogaNode == null) {
                return;
            }
            float f10 = yogaNode.q().f19201a;
            int itemCount = QRecyclerView.this.f34589l.getItemCount();
            float width = recyclerView.getWidth();
            float f11 = itemCount;
            float f12 = f10 * f11;
            if (width <= f12) {
                return;
            }
            int i10 = (int) (((width - f12) / f11) / 2.0f);
            rect.left = i10;
            rect.right = i10;
        }
    }

    public QRecyclerView(@NonNull Context context) {
        super(context);
        this.f34584g = 1;
        this.f34586i = "grid";
        this.f34587j = 1;
        this.f34588k = -1;
        this.f34590m = new LinkedList();
        this.f34598u = new f(this);
        this.C = -1;
        c();
    }

    private int b(MotionEvent motionEvent) {
        return Math.abs((int) (motionEvent.getRawY() - this.f34591n));
    }

    private void c() {
        this.f34597t = new b(null);
        this.f34589l = new c1();
        ((SimpleItemAnimator) getItemAnimator()).setSupportsChangeAnimations(false);
        this.f34603z = getResources().getConfiguration().orientation;
        this.C = getResources().getConfiguration().smallestScreenWidthDp;
        this.B = false;
    }

    private boolean d() {
        return this.f34583f != null && this.f34584g == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f34589l.onDataChanged();
    }

    private void f() {
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager).scrollToPositionWithOffset(this.f34593p, this.f34594q);
        } else if (layoutManager instanceof QStaggeredGridLayoutManager) {
            ((QStaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(this.f34593p, this.f34594q);
        } else {
            CardLogUtils.e(D, "not support layouttype");
        }
    }

    private void h() {
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager).setOrientation(this.f34584g);
        } else if (layoutManager instanceof QStaggeredGridLayoutManager) {
            ((QStaggeredGridLayoutManager) layoutManager).setOrientation(this.f34584g);
        } else {
            CardLogUtils.d(D, "illegal manager");
        }
    }

    private void i() {
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager).setReverseLayout(this.f34585h);
        } else if (layoutManager instanceof QStaggeredGridLayoutManager) {
            ((QStaggeredGridLayoutManager) layoutManager).setReverseLayout(this.f34585h);
        } else {
            CardLogUtils.d(D, "illegal manager");
        }
    }

    @Override // com.huawei.quickcard.IRecyclerHost
    public void addChildItem(CardElement cardElement) {
        CardContext cardContext = ViewUtils.getCardContext(this);
        String attrString = cardElement.getAttrString("for");
        String attrString2 = cardElement.getAttrString("if");
        if (TextUtils.isEmpty(attrString) && TextUtils.isEmpty(attrString2)) {
            List<IListItemData> list = this.f34590m;
            list.add(new ListItemNormal(cardElement, list.size()));
        } else {
            this.f34590m.add(new ListItemCondition(cardContext, ConditionalChild.createConditionalChild(this, this.f34590m.size(), attrString, attrString2, cardElement)));
        }
    }

    public boolean canScrollHForQuickCard(int i10) {
        int computeHorizontalScrollOffset = computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        return i10 > 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange - 1;
    }

    public boolean canScrollVForQuickCard(int i10) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int computeVerticalScrollRange = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        return i10 > 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange - 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f34591n = motionEvent.getRawY();
            this.f34592o = motionEvent.getRawX();
        } else if (action == 2) {
            if (d()) {
                if (canScrollHForQuickCard((int) (motionEvent.getRawX() - this.f34592o)) && a(motionEvent) >= b(motionEvent)) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.f34595r = true;
                } else {
                    this.f34595r = false;
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            } else if (canScrollVForQuickCard((int) (motionEvent.getRawY() - this.f34591n)) && a(motionEvent) <= b(motionEvent)) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.f34595r = true;
            } else {
                this.f34595r = false;
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.quickcard.IRecyclerHost
    public void endAddChildItem(CardContext cardContext) {
        this.f34589l.setCardContext(cardContext);
        this.f34589l.setDataList(this.f34590m);
        setLayoutType(this.f34586i);
        setAdapter(this.f34589l);
        this.f34589l.notifyDataSetChanged();
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        com.huawei.quickcard.framework.b.a(this, obj);
    }

    public void g() {
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            this.f34593p = ((QGridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (!(layoutManager instanceof QStaggeredGridLayoutManager) || this.f34587j <= 0) {
            return;
        } else {
            this.f34593p = ((QStaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)[0];
        }
        View findViewByPosition = this.f34583f.findViewByPosition(this.f34593p);
        this.f34594q = 0;
        if (findViewByPosition != null) {
            if (this.f34584g == 1) {
                this.f34594q = findViewByPosition.getTop() - getPaddingTop();
            } else if (isRTL()) {
                this.f34594q = (DeviceInfoUtils.getDeviceScreenWidth(getContext()) - findViewByPosition.getRight()) - getPaddingRight();
            } else {
                this.f34594q = findViewByPosition.getLeft() - getPaddingLeft();
            }
        }
        RecyclerView.LayoutManager layoutManager2 = this.f34583f;
        if (layoutManager2 instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager2).a(this.f34593p, this.f34594q);
        } else {
            if (!(layoutManager2 instanceof QStaggeredGridLayoutManager) || this.f34587j <= 0) {
                return;
            }
            ((QStaggeredGridLayoutManager) layoutManager2).a(this.f34593p, this.f34594q);
        }
    }

    @Override // com.huawei.quickcard.framework.ui.IViewDirection
    public int getContentDirection() {
        int layoutDirection = getLayoutDirection();
        return this.f34585h ? layoutDirection == 1 ? 0 : 1 : layoutDirection;
    }

    @Nullable
    public RecyclerView.LayoutManager getLayoutQuickCardManager() {
        return this.f34583f;
    }

    @Override // com.huawei.quickcard.views.list.IQRecyclerView
    public Object getShowIndexes() {
        ArrayList arrayList = new ArrayList();
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            QGridLayoutManager qGridLayoutManager = (QGridLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = qGridLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = qGridLayoutManager.findLastVisibleItemPosition();
            HashMap hashMap = new HashMap();
            hashMap.put(SHOW_BEGIN_KEY, Integer.valueOf(findFirstVisibleItemPosition));
            hashMap.put("end", Integer.valueOf(findLastVisibleItemPosition));
            arrayList.add(hashMap);
        } else if ((layoutManager instanceof QStaggeredGridLayoutManager) && this.f34587j > 0) {
            QStaggeredGridLayoutManager qStaggeredGridLayoutManager = (QStaggeredGridLayoutManager) layoutManager;
            int[] findFirstVisibleItemPositions = qStaggeredGridLayoutManager.findFirstVisibleItemPositions(null);
            int[] findLastVisibleItemPositions = qStaggeredGridLayoutManager.findLastVisibleItemPositions(null);
            for (int i10 = 0; i10 < findFirstVisibleItemPositions.length && i10 < findLastVisibleItemPositions.length; i10++) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(SHOW_BEGIN_KEY, Integer.valueOf(findFirstVisibleItemPositions[i10]));
                hashMap2.put("end", Integer.valueOf(findLastVisibleItemPositions[i10]));
                arrayList.add(hashMap2);
            }
        }
        return WrapDataUtils.wrap(arrayList);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return com.huawei.quickcard.framework.c.a(this, view);
    }

    @Override // com.huawei.quickcard.views.list.BounceHandler.BounceView
    public boolean isBottom() {
        return !canScrollVForQuickCard(-1);
    }

    @Override // com.huawei.quickcard.views.list.BounceHandler.BounceView
    public boolean isLeft() {
        if (!canScrollHForQuickCard(1)) {
            return true;
        }
        if (isRTL()) {
            if (a()) {
                return true;
            }
        } else if (b()) {
            return true;
        }
        return false;
    }

    public boolean isRTL() {
        return this.f34585h ^ (getLayoutDirection() == 1);
    }

    @Override // com.huawei.quickcard.views.list.BounceHandler.BounceView
    public boolean isRight() {
        return !canScrollHForQuickCard(-1) || (!isRTL() ? !a() : !b());
    }

    public boolean isScrollBottom() {
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            return ((QGridLayoutManager) layoutManager).findLastVisibleItemPosition() == this.f34583f.getItemCount() - 1;
        }
        if (layoutManager instanceof QStaggeredGridLayoutManager) {
            if (((QStaggeredGridLayoutManager) layoutManager).getReverseLayout()) {
                if (canScrollVForQuickCard(1)) {
                    return false;
                }
            } else if (canScrollVForQuickCard(-1)) {
                return false;
            }
            return true;
        }
        CardLogUtils.i(D, "isScrollButtom: layout manager is invalid.!");
        return false;
    }

    public boolean isScrollTop() {
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            return ((QGridLayoutManager) layoutManager).findFirstVisibleItemPosition() == 0;
        }
        if (layoutManager instanceof QStaggeredGridLayoutManager) {
            if (((QStaggeredGridLayoutManager) layoutManager).getReverseLayout()) {
                if (!canScrollVForQuickCard(-1)) {
                    return true;
                }
            } else if (!canScrollVForQuickCard(1)) {
                return true;
            }
            return false;
        }
        CardLogUtils.i(D, "layout manager is invalid.");
        return false;
    }

    @Override // com.huawei.quickcard.views.list.BounceHandler.BounceView
    public boolean isTop() {
        return true ^ canScrollVForQuickCard(1);
    }

    @Override // com.huawei.quickcard.views.list.IQRecyclerView
    public void notifyDataSetChanged() {
        if (this.f34589l != null) {
            CardThreadUtils.runOnMainThread(new Runnable() { // from class: com.huawei.quickcard.views.list.l
                @Override // java.lang.Runnable
                public final void run() {
                    QRecyclerView.this.e();
                }
            });
        }
    }

    @Override // com.huawei.quickcard.views.list.IQRecyclerView
    public void notifyItemChanged(int i10) {
        c1 c1Var = this.f34589l;
        if (c1Var != null) {
            c1Var.notifyItemChanged(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnScrollListener(this.f34598u);
        ExposureManager exposureManager = this.f34599v;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i10;
        super.onConfigurationChanged(configuration);
        int i11 = this.f34603z;
        int i12 = configuration.orientation;
        if (i11 != i12) {
            this.f34603z = i12;
            if (this.B) {
                notifyDataSetChanged();
            }
            f();
            return;
        }
        if (!this.B || (i10 = configuration.smallestScreenWidthDp) == this.C) {
            return;
        }
        this.C = i10;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34599v;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
        removeOnScrollListener(this.f34598u);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f34595r && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        BounceHandler bounceHandler = this.f34596s;
        if (bounceHandler == null || !bounceHandler.a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34599v;
        if (exposureManager != null) {
            exposureManager.onScreenSateChange(this, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        l0 l0Var;
        super.onSizeChanged(i10, i11, i12, i13);
        if ((i10 == i12 && i11 == i13) || (l0Var = this.f34600w) == null) {
            return;
        }
        l0Var.a(Boolean.FALSE, Boolean.TRUE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f34595r && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        BounceHandler bounceHandler = this.f34596s;
        if (bounceHandler == null || !bounceHandler.b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void onViewCreated(CardContext cardContext) {
        com.huawei.quickcard.framework.c.b(this, cardContext);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        ExposureManager exposureManager = this.f34599v;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(true);
    }

    @Override // com.huawei.quickcard.views.list.IQRecyclerView
    public void scrollBy(Object obj) {
        Object wrap = WrapDataUtils.wrap(obj);
        if (!(wrap instanceof CardDataObject)) {
            CardLogUtils.e(D, "scrollBy param is invalid");
            return;
        }
        CardDataObject cardDataObject = (CardDataObject) wrap;
        float configDensity = ViewUtils.getConfigDensity(getContext(), ViewUtils.getCardContext(this));
        int dip2IntPx = ViewUtils.dip2IntPx(configDensity, cardDataObject.getIntValue("dx", 0));
        int dip2IntPx2 = ViewUtils.dip2IntPx(configDensity, cardDataObject.getIntValue("dy", 0));
        if (cardDataObject.getBooleanValue(Attributes.Style.SMOOTH, true)) {
            smoothScrollBy(dip2IntPx, dip2IntPx2, this.f34597t);
        } else {
            scrollBy(dip2IntPx, dip2IntPx2);
        }
    }

    @Override // com.huawei.quickcard.views.list.IQRecyclerView
    public void scrollTo(Object obj) {
        Object wrap = WrapDataUtils.wrap(obj);
        if (!(wrap instanceof CardDataObject)) {
            CardLogUtils.e(D, "scrollTo param is invalid");
            return;
        }
        CardDataObject cardDataObject = (CardDataObject) wrap;
        Integer integer = cardDataObject.getInteger(Attributes.Style.INDEX);
        if (integer == null) {
            CardLogUtils.e(D, "index is invalid");
            return;
        }
        int intValue = integer.intValue();
        boolean booleanValue = cardDataObject.getBooleanValue(Attributes.Style.SMOOTH, false);
        if (intValue >= 0) {
            a(intValue, 0, booleanValue);
        } else {
            CardLogUtils.e(D, "index must be >=0");
        }
    }

    public void setColumns(int i10) {
        this.f34587j = i10;
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager).setSpanCount(i10);
        } else if (layoutManager instanceof QStaggeredGridLayoutManager) {
            ((QStaggeredGridLayoutManager) layoutManager).setSpanCount(i10);
        } else {
            CardLogUtils.d(D, "illegal manager");
        }
    }

    public void setEnableBounce(boolean z10) {
        if (z10) {
            this.f34596s = new BounceHandler(this, this.f34584g == 1 ? 0 : 1);
        } else {
            this.f34596s = null;
        }
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34599v = exposureManager;
    }

    public void setFlexDirection(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1448970769:
                if (str.equals("row-reverse")) {
                    c4 = 0;
                    break;
                }
                break;
            case 113114:
                if (str.equals("row")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1272730475:
                if (str.equals("column-reverse")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f34584g = 0;
                this.f34585h = true;
                break;
            case 1:
                this.f34584g = 0;
                this.f34585h = false;
                break;
            case 2:
                this.f34584g = 1;
                this.f34585h = true;
                break;
            default:
                this.f34584g = 1;
                this.f34585h = false;
                break;
        }
        if (this.f34596s != null) {
            this.f34596s = new BounceHandler(this, this.f34584g != 1 ? 1 : 0);
        }
        if (this.f34583f != null) {
            h();
            i();
        }
    }

    public void setInitPos(@IntRange(from = 0) int i10) {
        this.f34588k = i10;
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager).a(i10, 0);
        } else if (layoutManager instanceof QStaggeredGridLayoutManager) {
            ((QStaggeredGridLayoutManager) layoutManager).a(i10, 0);
        } else {
            CardLogUtils.d(D, "illegal manager");
        }
    }

    public void setLayoutType(String str) {
        this.f34586i = str;
        if ("stagger".equals(str)) {
            QStaggeredGridLayoutManager qStaggeredGridLayoutManager = new QStaggeredGridLayoutManager(this);
            qStaggeredGridLayoutManager.setOrientation(this.f34584g);
            qStaggeredGridLayoutManager.setSpanCount(this.f34587j);
            int i10 = this.f34588k;
            if (i10 >= 0) {
                qStaggeredGridLayoutManager.a(i10, 0);
            }
            qStaggeredGridLayoutManager.setReverseLayout(this.f34585h);
            this.f34583f = qStaggeredGridLayoutManager;
        } else {
            QGridLayoutManager qGridLayoutManager = new QGridLayoutManager(this);
            qGridLayoutManager.setSpanSizeLookup(new a());
            qGridLayoutManager.setOrientation(this.f34584g);
            qGridLayoutManager.setSpanCount(this.f34587j);
            int i11 = this.f34588k;
            if (i11 >= 0) {
                qGridLayoutManager.a(i11, 0);
            }
            qGridLayoutManager.setReverseLayout(this.f34585h);
            this.f34583f = qGridLayoutManager;
        }
        setLayoutManager(this.f34583f);
    }

    public void setOnScrollBottomEvent(g gVar) {
        this.f34578a = gVar;
    }

    public void setOnScrollEndEvent(h hVar) {
        this.f34579b = hVar;
    }

    public void setOnScrollEvent(i iVar) {
        this.f34580c = iVar;
    }

    public void setOnScrollTopEvent(j jVar) {
        this.f34581d = jVar;
    }

    public void setOnScrollTouchUpEvent(k kVar) {
        this.f34582e = kVar;
    }

    public void setSnapGravity(String str) {
        this.f34601x = str;
        l0 l0Var = this.f34600w;
        if (l0Var != null) {
            l0Var.a(str);
        }
    }

    public void setSnapMode(String str) {
        if (!"linear".equals(str) && !F.equals(str)) {
            l0 l0Var = this.f34600w;
            if (l0Var != null) {
                l0Var.attachToRecyclerView(null);
                return;
            }
            return;
        }
        if (this.f34600w == null) {
            this.f34600w = new l0();
        }
        Context context = getContext();
        CardContext cardContext = ViewUtils.getCardContext(this);
        this.f34600w.attachToRecyclerView(this);
        this.f34600w.a(F.equals(str));
        this.f34600w.a(this.f34601x);
        this.f34600w.a(context, cardContext, this.f34602y);
    }

    public void setSnapOffset(float f10) {
        this.f34602y = f10;
        l0 l0Var = this.f34600w;
        if (l0Var != null) {
            l0Var.a(getContext(), ViewUtils.getCardContext(this), f10);
        }
    }

    public void setTabMode(boolean z10) {
        boolean z11 = this.B != z10;
        this.B = z10;
        if (z10) {
            d dVar = new d();
            this.A = dVar;
            addItemDecoration(dVar);
        } else {
            removeItemDecoration(this.A);
            this.A = null;
        }
        if (z11) {
            notifyDataSetChanged();
        }
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        com.huawei.quickcard.framework.c.c(this, viewParent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11) {
        super.smoothScrollBy(i10, i11, this.f34597t);
    }

    @Override // com.huawei.quickcard.IRecyclerHost
    public void update(String str) {
        this.f34589l.onDataChanged(str);
        f();
    }

    private int a(MotionEvent motionEvent) {
        return Math.abs((int) (motionEvent.getRawX() - this.f34592o));
    }

    private boolean b() {
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        return (layoutManager instanceof QGridLayoutManager) && ((QGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
    }

    private void a(int i10, int i11, boolean z10) {
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 > this.f34589l.getItemCount() - 1) {
            i10 = Math.max(this.f34589l.getItemCount() - 1, 0);
        } else {
            CardLogUtils.d(D, "Other cases.");
        }
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        if (layoutManager instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager).a(i10, i11);
        } else if (layoutManager instanceof QStaggeredGridLayoutManager) {
            ((QStaggeredGridLayoutManager) layoutManager).a(i10, i11);
        }
        if (z10) {
            smoothScrollToPosition(i10);
            return;
        }
        RecyclerView.LayoutManager layoutManager2 = this.f34583f;
        if (layoutManager2 instanceof QGridLayoutManager) {
            ((QGridLayoutManager) layoutManager2).scrollToPositionWithOffset(i10, i11);
        } else if (layoutManager2 instanceof QStaggeredGridLayoutManager) {
            ((QStaggeredGridLayoutManager) layoutManager2).scrollToPositionWithOffset(i10, i11);
        } else {
            CardLogUtils.d(D, "illegal layout manager.");
        }
    }

    public QRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34584g = 1;
        this.f34586i = "grid";
        this.f34587j = 1;
        this.f34588k = -1;
        this.f34590m = new LinkedList();
        this.f34598u = new f(this);
        this.C = -1;
        c();
    }

    private boolean a() {
        QGridLayoutManager qGridLayoutManager;
        int findLastCompletelyVisibleItemPosition;
        RecyclerView.LayoutManager layoutManager = this.f34583f;
        return (layoutManager instanceof QGridLayoutManager) && (findLastCompletelyVisibleItemPosition = (qGridLayoutManager = (QGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition()) != -1 && findLastCompletelyVisibleItemPosition >= a(qGridLayoutManager, this.f34589l.getItemCount());
    }

    public QRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f34584g = 1;
        this.f34586i = "grid";
        this.f34587j = 1;
        this.f34588k = -1;
        this.f34590m = new LinkedList();
        this.f34598u = new f(this);
        this.C = -1;
        c();
    }

    private int a(@NonNull QGridLayoutManager qGridLayoutManager, int i10) {
        int i11 = i10 - 1;
        while (i11 > 0) {
            View findViewByPosition = qGridLayoutManager.findViewByPosition(i11);
            if (findViewByPosition != null && findViewByPosition.getVisibility() == 0 && findViewByPosition.getWidth() != 0) {
                break;
            }
            i11--;
        }
        return i11;
    }
}
