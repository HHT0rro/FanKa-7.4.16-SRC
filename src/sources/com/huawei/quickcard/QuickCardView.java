package com.huawei.quickcard;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.bi.CardReporter;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.elexecutor.IQuickCardProvider;
import com.huawei.quickcard.exposure.extend.IQuickCardAreaCalculator;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.cache.Caches;
import com.huawei.quickcard.framework.inflater.QuickCardInflater;
import com.huawei.quickcard.framework.touch.ITouchEventManager;
import com.huawei.quickcard.framework.touch.TouchEventMgr;
import com.huawei.quickcard.utils.IntervalTimerMethodUtil;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.utils.ValueUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardView extends FrameLayout implements QuickCardRoot {

    /* renamed from: j, reason: collision with root package name */
    private static final String f33243j = "QuickCardView";

    /* renamed from: k, reason: collision with root package name */
    private static final SparseArray<String> f33244k;

    /* renamed from: a, reason: collision with root package name */
    private Configuration f33245a;

    /* renamed from: b, reason: collision with root package name */
    private String f33246b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f33247c;
    public CardContext cardContext;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33248d;

    /* renamed from: e, reason: collision with root package name */
    private IQuickCardDestroyCallback f33249e;

    /* renamed from: f, reason: collision with root package name */
    private Lifecycle f33250f;

    /* renamed from: g, reason: collision with root package name */
    private TouchEventMgr f33251g;

    /* renamed from: h, reason: collision with root package name */
    private Context f33252h;

    /* renamed from: i, reason: collision with root package name */
    private CardLifeCycleObserver f33253i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class CardLifeCycleObserver implements DefaultLifecycleObserver {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QuickCardView> f33254a;

        public CardLifeCycleObserver(QuickCardView quickCardView) {
            this.f33254a = new WeakReference<>(quickCardView);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.a(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
            CardLogUtils.d(QuickCardView.f33243j, ((Object) lifecycleOwner) + " onDestroy");
            QuickCardView quickCardView = this.f33254a.get();
            if (quickCardView != null) {
                quickCardView.destroy();
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
            QuickCardView quickCardView = this.f33254a.get();
            if (quickCardView != null) {
                quickCardView.onPause();
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
            QuickCardView quickCardView = this.f33254a.get();
            if (quickCardView != null) {
                quickCardView.onResume();
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.e(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.f(this, lifecycleOwner);
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f33244k = sparseArray;
        sparseArray.put(1073741824, ConfigBean.Field.FONT_SCALE);
        sparseArray.put(512, ConfigBean.Field.UI_MODE);
        sparseArray.put(128, "orientation");
        sparseArray.put(4, "locale");
        sparseArray.put(8192, ConfigBean.Field.LAYOUT_DIRECTION);
        sparseArray.put(4096, ConfigBean.Field.SCREEN_DENSITY);
        sparseArray.put(2048, ConfigBean.Field.EXPAND_STATE);
    }

    public QuickCardView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f33252h = context;
        Configuration configuration = new Configuration();
        this.f33245a = configuration;
        configuration.setTo(getResources().getConfiguration());
        this.f33251g = new TouchEventMgr();
        if (m1.a(context.getApplicationContext())) {
            this.cardContext = createCurrentContext();
            ArrayList arrayList = new ArrayList();
            int size = f33244k.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(f33244k.valueAt(i10));
            }
            this.cardContext.onConfigChanged(arrayList, this.f33245a, false);
            this.cardContext.initOtherConfigInfo(context);
        }
    }

    private void b() {
        IntervalTimerMethodUtil.clearAllInterval(this.cardContext);
        IntervalTimerMethodUtil.clearAllTimeout(this.cardContext);
    }

    private void c() {
        d();
        h1.f34011d.b(this);
        ValueUtils.obtainPropertyCacheBeanFromView(this).getFullScreenImpl().exitFullScreen();
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.release();
        }
        this.f33251g.unRegisterTouchListenerByRoot();
        this.f33248d = true;
        IQuickCardDestroyCallback iQuickCardDestroyCallback = this.f33249e;
        if (iQuickCardDestroyCallback != null) {
            iQuickCardDestroyCallback.onDestroyed(this);
            this.f33249e = null;
        }
        onDestroy();
    }

    private void d() {
        CardLifeCycleObserver cardLifeCycleObserver;
        Lifecycle lifecycle = this.f33250f;
        if (lifecycle == null || (cardLifeCycleObserver = this.f33253i) == null) {
            return;
        }
        lifecycle.removeObserver(cardLifeCycleObserver);
        this.f33253i = null;
        this.f33250f = null;
    }

    @UiThread
    public int bindData(IQuickCardProvider iQuickCardProvider) {
        CardLogUtils.i(f33243j, "call bindData");
        CardReporter uri = CardReporter.from(getContext()).begin().uri(this.f33246b);
        if (this.cardContext == null) {
            uri.end().code(23).msg("yoga not loaded").reportBindData();
            return 23;
        }
        b();
        int bindData = this.cardContext.bindData(iQuickCardProvider);
        uri.end().code(bindData).msg(bindData == 0 ? "bind data success" : "bind data fail").reportBindData();
        CardLogUtils.i(f33243j, "call bindData result:" + bindData + " with url:" + this.f33246b);
        return bindData;
    }

    public CardContext createCurrentContext() {
        return new com.huawei.quickcard.framework.a(this);
    }

    public void destroy() {
        CardLogUtils.d(f33243j, "destory card:" + this.f33246b);
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        this.f33251g.dispatchTouchEvent(this, motionEvent);
        return dispatchTouchEvent;
    }

    @UiThread
    public Object evaluateExpression(String str) {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            return cardContext.executeExpr(StrUtils.strip(str));
        }
        return null;
    }

    public void exitFullScreen() {
        ValueUtils.obtainPropertyCacheBeanFromView(this).getFullScreenImpl().exitFullScreen();
    }

    @Override // com.huawei.quickcard.QuickCardRoot
    @NonNull
    public Configuration getCardConfiguration() {
        return this.f33245a;
    }

    public CardContext getCardContext() {
        return this.cardContext;
    }

    @Nullable
    public JSONObject getCardOptions() {
        return this.f33247c;
    }

    @NonNull
    public String getQuickCardUri() {
        String str = this.f33246b;
        if (str != null) {
            return str;
        }
        CardLogUtils.e(f33243j, "unreachable branch");
        return "";
    }

    @Override // com.huawei.quickcard.QuickCardRoot
    public ViewGroup getRootViewGroup() {
        return this;
    }

    @Override // com.huawei.quickcard.QuickCardRoot
    public ITouchEventManager getTouchEventManager() {
        return this.f33251g;
    }

    public boolean isDestroyed() {
        return this.f33248d;
    }

    public boolean isInFullScreen() {
        return ValueUtils.obtainPropertyCacheBeanFromView(this).getFullScreenImpl().isFullScreen();
    }

    public void notifyDataChange(String str, Object obj, Object obj2) {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.notifyDataChange(str, obj, obj2);
        }
    }

    public void onActivityConfigurationChanged(@NonNull Configuration configuration) {
        int updateFrom = this.f33245a.updateFrom(configuration);
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            a(cardContext, updateFrom, this.f33245a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        h1.f34011d.a(this);
    }

    public void onDestroy() {
    }

    public void onPause() {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.onPause();
        }
    }

    public void onResume() {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.onResume();
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.onScreenStateChanged(i10);
        }
    }

    @UiThread
    public int render(String str, @NonNull IQuickCardProvider iQuickCardProvider) {
        return render(str, iQuickCardProvider, null);
    }

    public void setDestroyCallback(IQuickCardDestroyCallback iQuickCardDestroyCallback) {
        this.f33249e = iQuickCardDestroyCallback;
    }

    public void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        CardLifeCycleObserver cardLifeCycleObserver;
        Lifecycle lifecycle = this.f33250f;
        if (lifecycle != null && (cardLifeCycleObserver = this.f33253i) != null) {
            lifecycle.removeObserver(cardLifeCycleObserver);
        }
        this.f33250f = lifecycleOwner.getLifecycle();
    }

    public void setParams(Map<String, Object> map) {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.setParams(map);
        }
    }

    public void setQuickCardAreaCalculator(IQuickCardAreaCalculator iQuickCardAreaCalculator) {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.setQuickCardAreaCalculator(iQuickCardAreaCalculator);
        }
    }

    public void setQuickCardListener(IQuickCardListener iQuickCardListener) {
        CardContext cardContext = this.cardContext;
        if (cardContext != null) {
            cardContext.setCardActionListener(iQuickCardListener);
        }
    }

    @UiThread
    public int unbind(IQuickCardProvider iQuickCardProvider) {
        CardLogUtils.d(f33243j, "call unbind");
        CardContext cardContext = this.cardContext;
        if (cardContext == null) {
            return 16;
        }
        int unbind = cardContext.unbind(iQuickCardProvider);
        CardLogUtils.i(f33243j, "call unbind result:" + unbind + " with url:" + this.f33246b);
        return unbind;
    }

    @UiThread
    public int render(String str, @NonNull IQuickCardProvider iQuickCardProvider, Map<String, Object> map) {
        this.f33246b = str;
        CardLogUtils.i(f33243j, "call render:" + str);
        CardReporter uri = CardReporter.from(getContext()).begin().uri(str);
        QuickCardBean quickCardBean = Caches.get().beans().get(str);
        if (this.cardContext == null) {
            uri.end().fail(23, "yoga not loaded").reportRender();
            return 23;
        }
        if (quickCardBean != null && quickCardBean.getCard() != null) {
            this.f33247c = quickCardBean.getOptions();
            new QuickCardInflater(a(quickCardBean, iQuickCardProvider)).inflate(quickCardBean);
            this.cardContext.onRendered();
            uri.end().success().reportRender();
            return 0;
        }
        CardLogUtils.e(f33243j, "call render fail:7");
        uri.end().fail(7, "card not exist").reportRender();
        return 7;
    }

    public QuickCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public QuickCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }

    private void a() {
        if (this.f33250f == null) {
            Object obj = this.f33252h;
            if (obj instanceof LifecycleOwner) {
                this.f33250f = ((LifecycleOwner) obj).getLifecycle();
            }
        }
        if (this.f33253i != null || this.f33250f == null) {
            return;
        }
        CardLifeCycleObserver cardLifeCycleObserver = new CardLifeCycleObserver(this);
        this.f33253i = cardLifeCycleObserver;
        this.f33250f.addObserver(cardLifeCycleObserver);
    }

    private CardContext a(QuickCardBean quickCardBean, @NonNull IQuickCardProvider iQuickCardProvider) {
        this.cardContext.init(quickCardBean, iQuickCardProvider, this.f33245a);
        return this.cardContext;
    }

    private void a(@NonNull CardContext cardContext, int i10, Configuration configuration) {
        SystemUtils.adaptUiMode(configuration, cardContext.getThemeMode());
        ArrayList arrayList = new ArrayList();
        int size = f33244k.size();
        for (int i11 = 0; i11 < size; i11++) {
            SparseArray<String> sparseArray = f33244k;
            int keyAt = sparseArray.keyAt(i11);
            if ((i10 & keyAt) == keyAt) {
                arrayList.add(sparseArray.valueAt(i11));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        cardContext.onConfigChanged(arrayList, configuration, true);
    }
}
