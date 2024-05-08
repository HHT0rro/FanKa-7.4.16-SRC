package com.huawei.quickcard.framework;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.Cleanable;
import com.huawei.quickcard.IQuickCardListener;
import com.huawei.quickcard.LifeListener;
import com.huawei.quickcard.QuickCardEngine;
import com.huawei.quickcard.QuickCardRoot;
import com.huawei.quickcard.ThemeMode;
import com.huawei.quickcard.action.ActionsManager;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.JsonUtils;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.e2;
import com.huawei.quickcard.elexecutor.ICSSRender;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IExpressionContextProxy;
import com.huawei.quickcard.elexecutor.IQuickCardProvider;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.exposure.extend.ExtendExposureManager;
import com.huawei.quickcard.exposure.extend.IQuickCardAreaCalculator;
import com.huawei.quickcard.exposure.extend.QuickCardAreaCalculator;
import com.huawei.quickcard.extension.Experiment;
import com.huawei.quickcard.extension.global.impl.CountDownTimerImpl;
import com.huawei.quickcard.framework.animation.QAnimatorSet;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.huawei.quickcard.framework.bean.I18nBean;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.bean.ThemeBean;
import com.huawei.quickcard.framework.event.CardEventBus;
import com.huawei.quickcard.framework.pool.ViewPool;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.g2;
import com.huawei.quickcard.utils.ExpressionUtils;
import com.huawei.quickcard.utils.I18nUtils;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.w;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements CardContext {

    /* renamed from: v, reason: collision with root package name */
    private static final String f33736v = "QuickCardContext";

    /* renamed from: w, reason: collision with root package name */
    private static final String f33737w = "EXPR";

    /* renamed from: x, reason: collision with root package name */
    private static final boolean f33738x = false;

    /* renamed from: y, reason: collision with root package name */
    private static final SparseArray<Integer> f33739y = new SparseArray<>();

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<View> f33740a;
    public final ActionsManager actionsManager;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<Component> f33741b;

    /* renamed from: c, reason: collision with root package name */
    private final ExposureManager f33742c;
    public w configurationManager;

    @FloatRange(from = ShadowDrawableWrapper.COS_45)
    public float customDensity;

    /* renamed from: d, reason: collision with root package name */
    private final ExtendExposureManager f33743d;
    public IQuickCardProvider dataContextProvider;

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue<WeakReference<Cleanable>> f33744e;
    public final IExpressionContextProxy expressionContextProxy;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentLinkedQueue<WeakReference<LifeListener>> f33745f;
    public final Map<String, Object> hostParams;
    public float initialDensity;

    /* renamed from: k, reason: collision with root package name */
    private I18nBean f33750k;

    /* renamed from: l, reason: collision with root package name */
    private Map<String, Object> f33751l;
    public boolean lockedDensity;

    /* renamed from: m, reason: collision with root package name */
    private String f33752m;
    public ThemeBean mThemeBean;

    /* renamed from: n, reason: collision with root package name */
    private final Map<String, String> f33753n;

    /* renamed from: o, reason: collision with root package name */
    private SparseArray<CountDownTimerImpl> f33754o;

    /* renamed from: p, reason: collision with root package name */
    private SparseArray<CountDownTimerImpl> f33755p;

    /* renamed from: q, reason: collision with root package name */
    private final ViewPool f33756q;
    public final QuickCardRoot quickCardRoot;

    /* renamed from: r, reason: collision with root package name */
    private CardEventBus f33757r;

    /* renamed from: s, reason: collision with root package name */
    private int f33758s;
    public String script;
    public String scriptEngine;

    /* renamed from: t, reason: collision with root package name */
    private ThemeMode f33759t;
    public int toolkitLevel;

    /* renamed from: u, reason: collision with root package name */
    private ThemeMode f33760u;
    public final IWatcherManager wm;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33746g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33747h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33748i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33749j = false;

    public a(QuickCardRoot quickCardRoot) {
        ThemeMode themeMode = ThemeMode.AUTO;
        this.f33759t = themeMode;
        this.f33760u = themeMode;
        this.quickCardRoot = quickCardRoot;
        this.wm = new e2(this);
        this.f33740a = new SparseArray<>();
        this.f33741b = new SparseArray<>();
        this.actionsManager = new ActionsManager();
        this.configurationManager = new w(this);
        this.f33742c = new ExposureManager(quickCardRoot.getRootViewGroup());
        this.f33743d = new ExtendExposureManager(quickCardRoot.getRootViewGroup(), new QuickCardAreaCalculator());
        this.f33744e = new ConcurrentLinkedQueue<>();
        this.f33745f = new ConcurrentLinkedQueue<>();
        this.hostParams = new HashMap();
        this.f33753n = new HashMap();
        this.expressionContextProxy = QuickCardEngine.getExpressionFactory().createExpressionContextProxy(null);
        ViewPool viewPool = new ViewPool(quickCardRoot.getRootViewGroup().getContext());
        this.f33756q = viewPool;
        addCleanQueue(viewPool);
    }

    private void a(Locale locale) {
        IExpressionContextProxy dataContext = getDataContext();
        if (dataContext == null) {
            if (this.dataContextProvider != null) {
                CardLogUtils.e(f33736v, "data context is null on local changed");
            }
        } else {
            Iterator<String> a10 = a(this.f33750k, dataContext, locale);
            HashSet hashSet = new HashSet(1);
            while (a10.hasNext()) {
                hashSet.add(a10.next());
            }
            this.wm.setMessageKeys(hashSet);
            this.wm.updateByFields(hashSet);
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("$configuration.deviceInfo.")) {
            String substring = str.substring(26);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            b(substring, this.configurationManager.a(substring));
            return;
        }
        if ("$configuration.themes".equals(str)) {
            d(this.configurationManager.h());
        }
    }

    private void c() {
        ViewGroup rootViewGroup = this.quickCardRoot.getRootViewGroup();
        if (rootViewGroup == null) {
            return;
        }
        List<WeakReference<View>> savedAnimationList = ValueUtils.obtainPropertyCacheBeanFromView(rootViewGroup).getSavedAnimationList();
        Iterator<WeakReference<View>> iterator2 = savedAnimationList.iterator2();
        while (iterator2.hasNext()) {
            View view = iterator2.next().get();
            if (view != null) {
                QAnimatorSet qAnimatorSet = ValueUtils.obtainPropertyCacheBeanFromView(view).getQAnimatorSet(view);
                if (qAnimatorSet.c()) {
                    qAnimatorSet.f();
                }
            }
        }
        savedAnimationList.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(java.lang.Object r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L34
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.f33753n
            java.lang.String r1 = "uiMode"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L27
            com.huawei.quickcard.w r0 = r4.configurationManager
            java.lang.Object r0 = r0.a(r1)
            if (r0 == 0) goto L2a
            java.lang.String r0 = r0.toString()
            r5.add(r0)
            goto L2a
        L27:
            r5.add(r0)
        L2a:
            com.huawei.quickcard.w r0 = r4.configurationManager
            java.util.Set r0 = r0.f()
            r0.clear()
            goto L7e
        L34:
            java.util.Set r5 = r4.c(r5)
            com.huawei.quickcard.w r0 = r4.configurationManager
            java.util.Set r0 = r0.f()
            r1 = 1
            int r2 = r0.size()
            int r3 = r5.size()
            if (r2 != r3) goto L5f
            java.util.Iterator r2 = r5.iterator2()
        L4d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L60
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r0.contains(r3)
            if (r3 != 0) goto L4d
        L5f:
            r1 = 0
        L60:
            if (r1 == 0) goto L63
            return
        L63:
            r0.clear()
            r0.addAll(r5)
            com.huawei.quickcard.w r0 = r4.configurationManager
            boolean r0 = r0.a(r5)
            if (r0 != 0) goto L7e
            java.lang.String r0 = r4.b()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L7e
            r5.add(r0)
        L7e:
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L87
            r4.onThemeChange(r5)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.framework.a.d(java.lang.Object):void");
    }

    @Override // com.huawei.quickcard.CardContext
    public void addCleanQueue(@NonNull Cleanable cleanable) {
        this.f33744e.add(new WeakReference<>(cleanable));
    }

    @Override // com.huawei.quickcard.CardContext
    public void addLifeListenerQueue(LifeListener lifeListener) {
        this.f33745f.add(new WeakReference<>(lifeListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.CardContext
    public void batchUpdateExp(Collection<Watcher> collection, boolean z10) {
        IExpressionContextProxy dataContext = getDataContext();
        if (dataContext == null) {
            CardLogUtils.e(f33736v, "data context is null onRendered");
            return;
        }
        int size = collection.size();
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        int i10 = 0;
        for (Watcher watcher : collection) {
            if (!watcher.hasValue()) {
                arrayList.add(watcher);
                arrayList2.add(composeWatcherScript(watcher, z10));
                i10++;
            }
        }
        if (i10 == 0) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        Utils.collectSetterVarPath(arrayList3);
        Object[] objArr = null;
        String[] strArr = (String[]) arrayList2.toArray(new String[0]);
        try {
            objArr = dataContext.evaluate(strArr, this.toolkitLevel);
        } catch (Throwable th) {
            CardLogUtils.print2Ide(6, f33737w, "errorScript=" + Arrays.toString(strArr));
            CardLogUtils.e(f33736v, "batch update error", th);
        }
        Utils.stopCollectSetterVarPath(arrayList3);
        if (objArr == null || objArr.length < i10) {
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            ((Watcher) arrayList.get(i11)).setNewValue(objArr[i11]);
        }
        if (z10) {
            Iterator<Watcher> iterator2 = collection.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().update();
            }
        }
    }

    @Override // com.huawei.quickcard.CardContext
    public int bindData(IQuickCardProvider iQuickCardProvider) {
        this.dataContextProvider = iQuickCardProvider;
        IExpressionContextProxy dataContext = getDataContext();
        if (dataContext == null) {
            CardLogUtils.e(f33736v, "data context is null in bind data");
            return 13;
        }
        if (!TextUtils.isEmpty(this.script) && !Experiment.isTurboMode()) {
            if (QuickCardEngine.isStandardExtension()) {
                dataContext.evaluate("$bind()");
            } else {
                dataContext.callFunction("$bind", new Object[0]);
            }
        }
        this.actionsManager.initActions();
        this.actionsManager.bindActions(dataContext, this, getRoot().getRootViewGroup());
        if (!this.f33747h) {
            callLifeCycleMethod(dataContext, CardContext.ON_RENDER_FUNC, null, false);
            this.f33747h = true;
        }
        this.configurationManager.a(dataContext, iQuickCardProvider.getCardId());
        if (!TextUtils.isEmpty(this.script)) {
            doOnPreBindLifeCycle(dataContext);
        }
        Configuration cardConfiguration = getRoot().getCardConfiguration();
        ThemeMode themeMode = this.f33759t;
        if (themeMode != this.f33760u) {
            this.f33760u = themeMode;
            SystemUtils.adaptUiMode(cardConfiguration, themeMode);
            SystemUtils.refreshUiMode(this, cardConfiguration);
        } else if (themeMode == ThemeMode.AUTO) {
            SystemUtils.allowSystemUiMode(getRoot().getRootViewGroup(), cardConfiguration, this);
        }
        if (this.f33746g && !this.f33748i) {
            this.wm.updateAll();
        } else {
            this.wm.updateOnBind();
            a();
        }
        if (!TextUtils.isEmpty(this.script)) {
            doOnBindLifeCycle(dataContext);
        }
        this.f33746g = false;
        c();
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.CardContext
    public Object call(@NonNull Object obj, Object... objArr) {
        CardDataObject b4 = b(obj);
        if (b4 == null) {
            return null;
        }
        IExpressionContextProxy dataContext = getDataContext();
        if (dataContext == null) {
            CardLogUtils.e(f33736v, "data context is null in calling");
            return null;
        }
        List<String> arrayList = new ArrayList<>();
        Utils.collectSetterVarPath(arrayList);
        Object call = b4.call(objArr);
        Utils.stopCollectSetterVarPath(arrayList);
        collectVars(dataContext, arrayList);
        dataContext.evaluate(ExpressionUtils.cleanValueCollector());
        if (!arrayList.isEmpty()) {
            postUpdateByVar(arrayList);
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                b((String) iterator2.next());
            }
            c();
        }
        return call;
    }

    @Override // com.huawei.quickcard.CardContext
    public boolean callLifeCycleMethod(@NonNull IExpressionContext iExpressionContext, String str, Map<String, Object> map, boolean z10) {
        try {
            if (QuickCardEngine.isStandardExtension() && z10) {
                List<String> arrayList = new ArrayList<>();
                iExpressionContext.evaluate(ExpressionUtils.cleanValueCollector());
                iExpressionContext.callFunction(str, map);
                collectVars(getDataContext(), arrayList);
                postUpdateByVar(arrayList);
                c();
            } else {
                iExpressionContext.callFunction(str, map);
            }
            return true;
        } catch (Exception e2) {
            CardLogUtils.e(f33736v, "execute lifeCycle method::" + str + "::error" + e2.getMessage());
            return false;
        }
    }

    public void collectVars(@NonNull IExpressionContext iExpressionContext, @Nullable Collection<String> collection) {
        Object obj = iExpressionContext.get("$valueCollector");
        if (obj == null || "".equals(obj)) {
            return;
        }
        Object wrap = WrapDataUtils.wrap(obj);
        if (wrap instanceof CardDataObject) {
            CardDataObject cardDataObject = (CardDataObject) wrap;
            int size = cardDataObject.size();
            if (!cardDataObject.isArray() || size <= 0 || collection == null) {
                return;
            }
            for (int i10 = 0; i10 < size; i10++) {
                collection.add(cardDataObject.getString(i10));
            }
        }
    }

    public String composeWatcherScript(@NonNull Watcher watcher, boolean z10) {
        return watcher.getScript();
    }

    public w createConfigurationManager() {
        return new w(this);
    }

    @Override // com.huawei.quickcard.CardContext
    public boolean doActions(String str, View view, Map<String, Object> map) {
        return this.actionsManager.doAction(this, str, view, map);
    }

    public void doOnBindLifeCycle(@NonNull IExpressionContext iExpressionContext) {
        if (QuickCardEngine.isStandardExtension()) {
            try {
                executeExpr("$lifecycleBind()");
                return;
            } catch (Exception e2) {
                CardLogUtils.e(f33736v, "execute bind lifeCycle method::error" + e2.getMessage());
                return;
            }
        }
        callLifeCycleMethod(iExpressionContext, CardContext.ON_BIND_FUNC, null, false);
    }

    public void doOnPreBindLifeCycle(@NonNull IExpressionContext iExpressionContext) {
        if (QuickCardEngine.isStandardExtension()) {
            try {
                iExpressionContext.evaluate("$lifecyclePrebind()");
                return;
            } catch (Exception e2) {
                CardLogUtils.e(f33736v, "execute pre bind lifeCycle method::error" + e2.getMessage());
                return;
            }
        }
        callLifeCycleMethod(iExpressionContext, CardContext.ON_PRE_BIND_FUNC, null, false);
    }

    @Override // com.huawei.quickcard.CardContext
    public CardEventBus eventBus() {
        if (this.f33757r == null) {
            this.f33757r = new CardEventBus();
        }
        return this.f33757r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.CardContext
    public Object executeExpr(String str, boolean z10) {
        List<String> arrayList = z10 ? new ArrayList<>() : null;
        String strip = StrUtils.strip(str);
        if (z10 && !Experiment.isTurboMode()) {
            strip = ExpressionUtils.cleanValueCollector() + strip;
        }
        Object executeExpr = executeExpr(strip, arrayList, null, z10);
        if (arrayList != null && !arrayList.isEmpty()) {
            postUpdateByVar(arrayList);
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                c((String) iterator2.next(), executeExpr);
            }
            c();
        }
        return executeExpr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.CardContext
    public Object executeWatcher(Watcher watcher) {
        List<String> arrayList = new ArrayList<>();
        if (getDataContext() == null) {
            CardLogUtils.e(f33736v, "data context is null onRendered");
            return null;
        }
        Object executeExpr = executeExpr(watcher.getScript(), arrayList, null, true);
        if (!arrayList.isEmpty()) {
            postUpdateByVar(arrayList);
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                c((String) iterator2.next(), executeExpr);
            }
        }
        return executeExpr;
    }

    @Override // com.huawei.quickcard.CardContext
    public int getCardMinPlatformVer() {
        return this.f33758s;
    }

    @Override // com.huawei.quickcard.CardContext
    public float getConfigDensity(Context context) {
        return this.lockedDensity ? this.customDensity : this.configurationManager.a(context);
    }

    @Override // com.huawei.quickcard.CardContext
    public float getConfigFontScale(Context context) {
        return this.configurationManager.b(context);
    }

    @Override // com.huawei.quickcard.CardContext
    public ICSSRender getCssRender() {
        IQuickCardProvider iQuickCardProvider = this.dataContextProvider;
        if (iQuickCardProvider == null) {
            return null;
        }
        return iQuickCardProvider.getCssRender();
    }

    @Override // com.huawei.quickcard.CardContext
    public Set<String> getCurrentTheme() {
        HashSet hashSet = new HashSet();
        Set<String> f10 = this.configurationManager.f();
        hashSet.addAll(f10);
        if (!this.configurationManager.a(f10)) {
            String b4 = b();
            if (!TextUtils.isEmpty(b4)) {
                hashSet.add(b4);
            }
        }
        Object a10 = this.configurationManager.a(ConfigBean.Field.LAYOUT_DIRECTION);
        if (a10 != null) {
            String obj = a10.toString();
            if (!TextUtils.isEmpty(obj)) {
                hashSet.add(obj);
            }
        }
        Object a11 = this.configurationManager.a("orientation");
        if (a11 != null) {
            String obj2 = a11.toString();
            if (!TextUtils.isEmpty(obj2)) {
                hashSet.add(obj2);
            }
        }
        return hashSet;
    }

    @Override // com.huawei.quickcard.CardContext
    public IExpressionContextProxy getDataContext() {
        return b(getDataContextDirectly());
    }

    public IExpressionContext getDataContextDirectly() {
        IQuickCardProvider iQuickCardProvider = this.dataContextProvider;
        if (iQuickCardProvider == null) {
            return null;
        }
        return iQuickCardProvider.getExpressionContext(this.scriptEngine, this.toolkitLevel);
    }

    public String getElExecutorName() {
        return this.scriptEngine;
    }

    @Override // com.huawei.quickcard.CardContext
    public ExposureManager getExposureManager() {
        return this.f33742c;
    }

    @Override // com.huawei.quickcard.CardContext
    public ExtendExposureManager getExtendExposureManager() {
        return this.f33743d;
    }

    @Override // com.huawei.quickcard.CardContext
    public SparseArray<CountDownTimerImpl> getIntervalTimers() {
        if (this.f33754o == null) {
            this.f33754o = new SparseArray<>();
        }
        return this.f33754o;
    }

    @Override // com.huawei.quickcard.CardContext
    public SparseArray<Component> getRefsToComponents() {
        return this.f33741b;
    }

    @Override // com.huawei.quickcard.CardContext
    public SparseArray<View> getRefsToViews() {
        return this.f33740a;
    }

    @Override // com.huawei.quickcard.CardContext
    public QuickCardRoot getRoot() {
        return this.quickCardRoot;
    }

    @Override // com.huawei.quickcard.CardContext
    public ThemeBean getThemeBean() {
        return this.mThemeBean;
    }

    @Override // com.huawei.quickcard.CardContext
    public ThemeMode getThemeMode() {
        return this.f33759t;
    }

    @Override // com.huawei.quickcard.CardContext
    public SparseArray<CountDownTimerImpl> getTimeoutTimers() {
        if (this.f33755p == null) {
            this.f33755p = new SparseArray<>();
        }
        return this.f33755p;
    }

    @Override // com.huawei.quickcard.CardContext
    @NonNull
    public ViewPool getViewPool() {
        return this.f33756q;
    }

    @Override // com.huawei.quickcard.CardContext
    @NonNull
    public IWatcherManager getWatcherManager() {
        return this.wm;
    }

    @Override // com.huawei.quickcard.CardContext
    public void init(QuickCardBean quickCardBean, @NonNull IQuickCardProvider iQuickCardProvider, Configuration configuration) {
        this.dataContextProvider = iQuickCardProvider;
        this.script = quickCardBean.getScript();
        this.f33752m = quickCardBean.getCardScript();
        this.scriptEngine = quickCardBean.getScriptEngine();
        this.f33758s = quickCardBean.getMinPLatFormVer();
        this.toolkitLevel = quickCardBean.getToolkitLevel();
        IExpressionContext dataContextDirectly = getDataContextDirectly();
        a(dataContextDirectly);
        b(dataContextDirectly);
        a(quickCardBean, dataContextDirectly, configuration.locale);
        if (quickCardBean.getThemeBean() != null) {
            this.mThemeBean = new ThemeBean(quickCardBean.getThemeBean());
        }
        resetConfig();
        if (this.f33759t == ThemeMode.AUTO) {
            SystemUtils.allowSystemUiMode(getRoot().getRootViewGroup(), configuration, this);
        }
        this.configurationManager.a(dataContextDirectly);
        float appDensity = ViewUtils.getAppDensity(this.quickCardRoot.getRootViewGroup().getContext());
        this.initialDensity = appDensity;
        this.customDensity = appDensity;
    }

    @Override // com.huawei.quickcard.CardContext
    public void initOtherConfigInfo(Context context) {
        this.configurationManager.c(context);
    }

    @Override // com.huawei.quickcard.CardContext
    public boolean isResume() {
        return this.f33749j;
    }

    @Override // com.huawei.quickcard.CardContext
    public void lockDensity(boolean z10, float f10) {
        this.lockedDensity = z10;
        if (Float.compare(f10, 0.0f) == 1) {
            this.customDensity = f10;
        } else {
            this.customDensity = this.initialDensity;
        }
    }

    @Override // com.huawei.quickcard.CardContext
    public void notifyDataChange(String str, Object obj, Object obj2) {
        if (getDataContext() == null) {
            CardLogUtils.e(f33736v, "data context is null in notifyDataChange");
            return;
        }
        if (str == null) {
            return;
        }
        int lastIndexOf = str.lastIndexOf(QuickCardField.EXTRA_POINT);
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 7);
        }
        this.wm.updateByVar(str);
        if ("$configuration.deviceInfo.screenDensity".equalsIgnoreCase(str)) {
            this.wm.updateDPWatchers();
            this.configurationManager.d(this.quickCardRoot.getRootViewGroup().getContext());
        } else if ("$configuration.deviceInfo.fontScale".equalsIgnoreCase(str)) {
            this.wm.updateSPWatchers();
        }
        a(str, obj, obj2);
        c();
    }

    @Override // com.huawei.quickcard.CardContext
    public void onConfigChanged(List<String> list, Configuration configuration, boolean z10) {
        if (list.contains("locale")) {
            a(configuration.locale);
        }
        list.removeAll(this.f33753n.h());
        this.configurationManager.a(list, configuration, z10);
    }

    @Override // com.huawei.quickcard.CardContext
    public void onPause() {
        this.f33749j = false;
        Iterator<WeakReference<LifeListener>> iterator2 = this.f33745f.iterator2();
        while (iterator2.hasNext()) {
            LifeListener lifeListener = iterator2.next().get();
            if (lifeListener != null) {
                lifeListener.onPause();
            }
        }
        this.f33743d.onPause();
    }

    @Override // com.huawei.quickcard.CardContext
    public void onRendered() {
        IExpressionContextProxy dataContext = getDataContext();
        if (dataContext == null) {
            CardLogUtils.e(f33736v, "data context is null onRendered");
        } else if (callLifeCycleMethod(dataContext, CardContext.ON_RENDER_FUNC, null, false)) {
            this.f33747h = true;
        }
    }

    @Override // com.huawei.quickcard.CardContext
    public void onResume() {
        this.f33749j = true;
        Iterator<WeakReference<LifeListener>> iterator2 = this.f33745f.iterator2();
        while (iterator2.hasNext()) {
            LifeListener lifeListener = iterator2.next().get();
            if (lifeListener != null) {
                lifeListener.onResume();
            }
        }
        this.f33743d.onResume();
    }

    @Override // com.huawei.quickcard.CardContext
    public void onScreenStateChanged(int i10) {
        this.f33743d.onScreenSateChange(i10);
    }

    @Override // com.huawei.quickcard.CardContext
    public /* synthetic */ void onThemeChange(Set set) {
        g2.f(this, set);
    }

    @Override // com.huawei.quickcard.CardContext
    public /* synthetic */ boolean onViewStateChanged(View view, String str, boolean z10, long j10) {
        return g2.g(this, view, str, z10, j10);
    }

    public void postUpdateByVar(List<String> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10);
            int lastIndexOf = str.lastIndexOf(QuickCardField.EXTRA_POINT);
            if (lastIndexOf >= 0) {
                list.set(i10, str.substring(lastIndexOf + 7));
            }
        }
        HashSet hashSet = new HashSet(list);
        this.wm.updateByVars(hashSet);
        if (hashSet.contains("$configuration.deviceInfo.screenDensity")) {
            this.wm.updateDPWatchers();
            this.configurationManager.d(this.quickCardRoot.getRootViewGroup().getContext());
        } else if (hashSet.contains("$configuration.deviceInfo.fontScale")) {
            this.wm.updateSPWatchers();
        }
    }

    @Override // com.huawei.quickcard.CardContext
    public void release() {
        Iterator<WeakReference<Cleanable>> iterator2 = this.f33744e.iterator2();
        while (iterator2.hasNext()) {
            Cleanable cleanable = iterator2.next().get();
            if (cleanable != null) {
                cleanable.release();
            }
        }
        this.f33742c.release();
        this.f33744e.clear();
        this.f33745f.clear();
        IQuickCardProvider iQuickCardProvider = this.dataContextProvider;
        if (iQuickCardProvider != null) {
            IExpressionContext expressionContext = iQuickCardProvider.getExpressionContext(this.scriptEngine, this.toolkitLevel);
            if (expressionContext != null) {
                f33739y.remove(expressionContext.hashCode());
            }
            this.dataContextProvider = null;
        }
    }

    public void resetConfig() {
        ThemeBean themeBean = this.mThemeBean;
        if (themeBean != null) {
            themeBean.resetThemeBean();
        }
        this.configurationManager.j();
        this.f33753n.clear();
    }

    @Override // com.huawei.quickcard.CardContext
    public void setCardActionListener(IQuickCardListener iQuickCardListener) {
        this.actionsManager.setCardActionListener(iQuickCardListener);
    }

    @Override // com.huawei.quickcard.CardContext
    public void setParams(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.hostParams.putAll(map);
        if (getDataContext() == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(QuickCardField.HOST_PARAMS);
        this.wm.updateByFields(hashSet);
    }

    @Override // com.huawei.quickcard.CardContext
    public void setQuickCardAreaCalculator(IQuickCardAreaCalculator iQuickCardAreaCalculator) {
        this.f33743d.setQuickCardAreaCalculator(iQuickCardAreaCalculator);
    }

    @Override // com.huawei.quickcard.CardContext
    public void setThemeMode(@NonNull ThemeMode themeMode) {
        this.f33759t = themeMode;
    }

    @Override // com.huawei.quickcard.CardContext
    public int unbind(IQuickCardProvider iQuickCardProvider) {
        if (iQuickCardProvider != this.dataContextProvider) {
            CardLogUtils.e(f33736v, "provider changed!!");
        }
        this.dataContextProvider = iQuickCardProvider;
        IExpressionContextProxy dataContext = getDataContext();
        if (dataContext != null) {
            return callLifeCycleMethod(dataContext, CardContext.ON_UNBIND_FUNC, null, false) ? 0 : 16;
        }
        CardLogUtils.e(f33736v, "expression context is empty when unbind");
        return 16;
    }

    private void c(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("$configuration.deviceInfo.")) {
            String substring = str.substring(26);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            b(substring, obj);
            return;
        }
        if ("$configuration.themes".equals(str)) {
            d(obj);
        }
    }

    private void a() {
        ViewGroup rootViewGroup = this.quickCardRoot.getRootViewGroup();
        if (rootViewGroup != null) {
            Iterator<WeakReference<View>> iterator2 = ValueUtils.obtainPropertyCacheBeanFromView(rootViewGroup).getFoolProofViews().iterator2();
            while (iterator2.hasNext()) {
                View view = iterator2.next().get();
                if (view != null) {
                    PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(view);
                    obtainPropertyCacheBeanFromView.setLastClickTime(-obtainPropertyCacheBeanFromView.getFoolProofingTime());
                }
            }
        }
    }

    private void b(String str, Object obj) {
        if (obj == null) {
            a(str);
        } else {
            a(str, obj);
        }
    }

    public Object executeExpr(String str, @Nullable Collection<String> collection, @Nullable Collection<String> collection2, boolean z10) {
        IExpressionContextProxy dataContext = getDataContext();
        Object obj = null;
        if (dataContext == null) {
            CardLogUtils.e(f33736v, "data context is null onRendered");
            return null;
        }
        try {
            String strip = StrUtils.strip(str);
            if (z10) {
                Utils.collectSetterVarPath(collection);
                obj = dataContext.evaluate(strip, collection, collection2);
                this.wm.setValueByExpr(str, obj);
                Utils.stopCollectSetterVarPath(collection);
                collectVars(dataContext, collection);
            } else {
                obj = dataContext.evaluate(strip, collection, collection2);
                this.wm.setValueByExpr(str, obj);
            }
        } catch (Exception e2) {
            String str2 = "errorScript::" + str;
            CardLogUtils.e(f33737w, str2, e2);
            CardLogUtils.print2Ide(6, f33737w, str2);
        }
        return obj;
    }

    private String b() {
        String str = this.f33753n.get(ConfigBean.Field.UI_MODE);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Object a10 = this.configurationManager.a(ConfigBean.Field.UI_MODE);
        if (a10 != null) {
            return a10.toString();
        }
        return null;
    }

    private void a(String str, Object obj, Object obj2) {
        if (obj == obj2 || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("$configuration.deviceInfo.")) {
            String substring = str.substring(26);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            b(substring, obj2);
            return;
        }
        if ("$configuration.themes".equals(str)) {
            d(obj2);
        }
    }

    private IExpressionContextProxy b(IExpressionContext iExpressionContext) {
        if (iExpressionContext == null) {
            return null;
        }
        this.expressionContextProxy.setSrcExpressionContext(iExpressionContext);
        this.configurationManager.a(this.expressionContextProxy);
        int hashCode = iExpressionContext.hashCode();
        int hashCode2 = hashCode();
        if (!Objects.equals(f33739y.get(hashCode), Integer.valueOf(hashCode2))) {
            Map<String, Object> map = this.f33751l;
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    this.expressionContextProxy.set(entry.getKey(), entry.getValue());
                }
            }
            this.expressionContextProxy.set(QuickCardField.HOST_PARAMS, this.hostParams);
            this.actionsManager.onDataContextChange(this.expressionContextProxy);
            f33739y.put(hashCode, Integer.valueOf(hashCode2));
        }
        return this.expressionContextProxy;
    }

    private Set<String> c(Object obj) {
        HashSet hashSet = new HashSet();
        if (obj instanceof CardDataObject) {
            CardDataObject cardDataObject = (CardDataObject) obj;
            if (cardDataObject.isArray()) {
                for (String str : cardDataObject.keys()) {
                    Object obj2 = cardDataObject.get(str);
                    if (obj2 != null) {
                        String obj3 = obj2.toString();
                        if (obj3.trim().length() != 0) {
                            hashSet.add(obj3);
                        }
                    }
                }
            } else {
                hashSet.add(obj.toString());
            }
        } else {
            hashSet.add(obj.toString());
        }
        return hashSet;
    }

    private void a(String str, Object obj) {
        ArrayList arrayList = new ArrayList(1);
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1955718283:
                if (str.equals(ConfigBean.Field.LAYOUT_DIRECTION)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1551473093:
                if (str.equals(ConfigBean.Field.FONT_SCALE)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1360635172:
                if (str.equals(ConfigBean.Field.SCREEN_DENSITY)) {
                    c4 = 2;
                    break;
                }
                break;
            case -845983145:
                if (str.equals(ConfigBean.Field.UI_MODE)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f33753n.put(ConfigBean.Field.LAYOUT_DIRECTION, obj.toString());
                a(obj);
                break;
            case 1:
                this.f33753n.put(ConfigBean.Field.FONT_SCALE, obj.toString());
                break;
            case 2:
                this.f33753n.put(ConfigBean.Field.SCREEN_DENSITY, obj.toString());
                break;
            case 3:
                this.f33753n.put(ConfigBean.Field.UI_MODE, obj.toString());
                w wVar = this.configurationManager;
                if (!wVar.a(wVar.f())) {
                    a(obj);
                    break;
                }
                break;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        onConfigChanged(arrayList, this.quickCardRoot.getCardConfiguration(), true);
    }

    @Override // com.huawei.quickcard.CardContext
    public Object executeExpr(String str) {
        return executeExpr(str, true);
    }

    @Nullable
    private CardDataObject b(Object obj) {
        if (obj instanceof CardDataObject) {
            return (CardDataObject) obj;
        }
        Object wrap = WrapDataUtils.wrap(obj);
        if (wrap instanceof CardDataObject) {
            return (CardDataObject) wrap;
        }
        return null;
    }

    private void a(@NonNull Object obj) {
        HashSet hashSet = new HashSet();
        hashSet.add(obj.toString());
        onThemeChange(hashSet);
    }

    private void a(String str) {
        ArrayList arrayList = new ArrayList(1);
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1955718283:
                if (str.equals(ConfigBean.Field.LAYOUT_DIRECTION)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1551473093:
                if (str.equals(ConfigBean.Field.FONT_SCALE)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1360635172:
                if (str.equals(ConfigBean.Field.SCREEN_DENSITY)) {
                    c4 = 2;
                    break;
                }
                break;
            case -845983145:
                if (str.equals(ConfigBean.Field.UI_MODE)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                arrayList.add(ConfigBean.Field.LAYOUT_DIRECTION);
                this.f33753n.remove(ConfigBean.Field.LAYOUT_DIRECTION);
                break;
            case 1:
                arrayList.add(ConfigBean.Field.FONT_SCALE);
                this.f33753n.remove(ConfigBean.Field.FONT_SCALE);
                break;
            case 2:
                arrayList.add(ConfigBean.Field.SCREEN_DENSITY);
                this.f33753n.remove(ConfigBean.Field.SCREEN_DENSITY);
                break;
            case 3:
                arrayList.add(ConfigBean.Field.UI_MODE);
                this.f33753n.remove(ConfigBean.Field.UI_MODE);
                break;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        onConfigChanged(arrayList, this.quickCardRoot.getCardConfiguration(), true);
    }

    private void a(IExpressionContext iExpressionContext) {
        if (iExpressionContext != null) {
            try {
                boolean isStandardExtension = QuickCardEngine.isStandardExtension();
                String str = ExpressionUtils.ALT_TEMPLATE_V1;
                if (isStandardExtension) {
                    if (!TextUtils.isEmpty(this.script)) {
                        str = this.script;
                    }
                } else if (this.toolkitLevel >= QuickCardEngine.getMinToolkitLevel()) {
                    str = TextUtils.isEmpty(this.f33752m) ? "" : this.f33752m;
                } else if (!TextUtils.isEmpty(this.script)) {
                    str = this.script;
                }
                iExpressionContext.create(str);
            } catch (Throwable th) {
                CardLogUtils.print2Ide(6, f33737w, "errorScript=" + this.script);
                CardLogUtils.e(f33736v, "init script error.", th);
            }
        }
    }

    private void a(QuickCardBean quickCardBean, @Nullable IExpressionContext iExpressionContext, Locale locale) {
        I18nBean i18n = quickCardBean.getI18n();
        Iterator<String> a10 = a(i18n, iExpressionContext, locale);
        HashSet hashSet = new HashSet(1);
        while (a10.hasNext()) {
            hashSet.add(a10.next());
        }
        this.wm.setMessageKeys(hashSet);
        this.f33750k = i18n;
    }

    private Iterator<String> a(I18nBean i18nBean, @Nullable IExpressionContext iExpressionContext, Locale locale) {
        if (i18nBean == null) {
            return new HashMap().h().iterator2();
        }
        String c4 = i18nBean.c();
        if (c4 == null) {
            c4 = I18nUtils.mixFinalLocaleCode(locale, i18nBean.b(), i18nBean.a());
        }
        JSONObject optJSONObject = i18nBean.a().optJSONObject(c4);
        if (optJSONObject == null) {
            return new HashMap().h().iterator2();
        }
        if (iExpressionContext != null) {
            Map<String, Object> json2Map = JsonUtils.json2Map(optJSONObject, JsonUtils.MapOptions.TIER_ALL);
            this.f33751l = json2Map;
            for (Map.Entry<String, Object> entry : json2Map.entrySet()) {
                iExpressionContext.set(entry.getKey(), entry.getValue());
            }
        }
        return optJSONObject.keys();
    }
}
