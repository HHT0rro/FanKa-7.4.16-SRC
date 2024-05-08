package com.huawei.quickcard;

import android.content.Context;
import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.elexecutor.ICSSRender;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IExpressionContextProxy;
import com.huawei.quickcard.elexecutor.IQuickCardProvider;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.exposure.extend.ExtendExposureManager;
import com.huawei.quickcard.exposure.extend.IQuickCardAreaCalculator;
import com.huawei.quickcard.extension.global.impl.CountDownTimerImpl;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.bean.ThemeBean;
import com.huawei.quickcard.framework.event.CardEventBus;
import com.huawei.quickcard.framework.pool.ViewPool;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface CardContext {
    public static final String ON_BIND_FUNC = "onBind";
    public static final String ON_PRE_BIND_FUNC = "onPrebind";
    public static final String ON_RENDER_FUNC = "onRender";
    public static final String ON_UNBIND_FUNC = "onUnbind";

    void addCleanQueue(@NonNull Cleanable cleanable);

    void addLifeListenerQueue(LifeListener lifeListener);

    void batchUpdateExp(Collection<Watcher> collection, boolean z10);

    int bindData(IQuickCardProvider iQuickCardProvider);

    Object call(@NonNull Object obj, Object... objArr);

    boolean callLifeCycleMethod(IExpressionContext iExpressionContext, String str, Map<String, Object> map, boolean z10);

    boolean doActions(String str, View view, Map<String, Object> map);

    CardEventBus eventBus();

    Object executeExpr(String str);

    Object executeExpr(String str, boolean z10);

    Object executeWatcher(Watcher watcher);

    int getCardMinPlatformVer();

    float getConfigDensity(Context context);

    float getConfigFontScale(Context context);

    ICSSRender getCssRender();

    Set<String> getCurrentTheme();

    IExpressionContextProxy getDataContext();

    ExposureManager getExposureManager();

    ExtendExposureManager getExtendExposureManager();

    SparseArray<CountDownTimerImpl> getIntervalTimers();

    SparseArray<Component> getRefsToComponents();

    SparseArray<View> getRefsToViews();

    QuickCardRoot getRoot();

    ThemeBean getThemeBean();

    ThemeMode getThemeMode();

    SparseArray<CountDownTimerImpl> getTimeoutTimers();

    @NonNull
    ViewPool getViewPool();

    @NonNull
    IWatcherManager getWatcherManager();

    void init(QuickCardBean quickCardBean, @NonNull IQuickCardProvider iQuickCardProvider, Configuration configuration);

    void initOtherConfigInfo(Context context);

    boolean isResume();

    void lockDensity(boolean z10, float f10);

    void notifyDataChange(String str, Object obj, Object obj2);

    void onConfigChanged(List<String> list, Configuration configuration, boolean z10);

    void onPause();

    void onRendered();

    void onResume();

    void onScreenStateChanged(int i10);

    void onThemeChange(Set<String> set);

    boolean onViewStateChanged(View view, String str, boolean z10, long j10);

    void release();

    void setCardActionListener(IQuickCardListener iQuickCardListener);

    void setParams(Map<String, Object> map);

    void setQuickCardAreaCalculator(IQuickCardAreaCalculator iQuickCardAreaCalculator);

    void setThemeMode(@NonNull ThemeMode themeMode);

    int unbind(IQuickCardProvider iQuickCardProvider);
}
