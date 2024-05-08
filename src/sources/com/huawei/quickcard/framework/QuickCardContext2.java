package com.huawei.quickcard.framework;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.QuickCardRoot;
import com.huawei.quickcard.action.ActionsManager;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.JsonUtils;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IExpressionContextProxy;
import com.huawei.quickcard.elexecutor.IQuickCardProvider;
import com.huawei.quickcard.framework.bean.I18nBean;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.bean.ThemeBean;
import com.huawei.quickcard.utils.ExpressionUtils;
import com.huawei.quickcard.utils.I18nUtils;
import com.huawei.quickcard.v;
import com.huawei.quickcard.w;
import com.huawei.quickcard.watcher.Watcher;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardContext2 extends a {

    /* renamed from: z, reason: collision with root package name */
    private static final String f33735z = "QuickCardContext2";

    public QuickCardContext2(QuickCardRoot quickCardRoot) {
        super(quickCardRoot);
        this.configurationManager = new v(this);
    }

    @NonNull
    private Map<String, String> a(@NonNull I18nBean i18nBean, @NonNull Configuration configuration) {
        HashMap hashMap = new HashMap();
        this.wm.setMessageKeys(a(i18nBean, configuration.locale, hashMap));
        return hashMap;
    }

    private void d() {
        if (this.expressionContextProxy.get(QuickCardField.ACTION_OBJECT) instanceof ActionsManager) {
            return;
        }
        this.expressionContextProxy.set(QuickCardField.ACTION_OBJECT, this.actionsManager);
    }

    @Override // com.huawei.quickcard.framework.a, com.huawei.quickcard.CardContext
    public int bindData(IQuickCardProvider iQuickCardProvider) {
        if (iQuickCardProvider.getExpressionContext(this.scriptEngine, this.toolkitLevel) == null) {
            CardLogUtils.e(f33735z, "data context is null in bind data");
            return 13;
        }
        return super.bindData(iQuickCardProvider);
    }

    @Override // com.huawei.quickcard.framework.a
    public void collectVars(@NonNull IExpressionContext iExpressionContext, @Nullable Collection<String> collection) {
        Object wrap = WrapDataUtils.wrap(iExpressionContext.evaluate(ExpressionUtils.computeExpression(this.dataContextProvider.getCardId())));
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

    @Override // com.huawei.quickcard.framework.a
    public String composeWatcherScript(@NonNull Watcher watcher, boolean z10) {
        if (z10) {
            return ExpressionUtils.watcherScript(watcher.getScript().replace("\"", "\\\""));
        }
        return super.composeWatcherScript(watcher, true);
    }

    @Override // com.huawei.quickcard.framework.a
    public w createConfigurationManager() {
        return new v(this);
    }

    @Override // com.huawei.quickcard.framework.a
    public void doOnBindLifeCycle(@NonNull IExpressionContext iExpressionContext) {
        this.actionsManager.initActions();
        this.actionsManager.bindActions(iExpressionContext, this, getRoot().getRootViewGroup());
        try {
            iExpressionContext.evaluate(ExpressionUtils.composeLifeCycle(this.dataContextProvider.getCardId()));
        } catch (Exception e2) {
            CardLogUtils.e(f33735z, "execute bind lifeCycle method::error" + e2.getMessage());
        }
    }

    @Override // com.huawei.quickcard.framework.a, com.huawei.quickcard.CardContext
    public IExpressionContextProxy getDataContext() {
        IExpressionContext expressionContext;
        IQuickCardProvider iQuickCardProvider = this.dataContextProvider;
        if (iQuickCardProvider == null || (expressionContext = iQuickCardProvider.getExpressionContext(this.scriptEngine)) == null) {
            return null;
        }
        this.expressionContextProxy.setSrcExpressionContext(expressionContext);
        return this.expressionContextProxy;
    }

    @Override // com.huawei.quickcard.framework.a, com.huawei.quickcard.CardContext
    public void init(QuickCardBean quickCardBean, @NonNull IQuickCardProvider iQuickCardProvider, Configuration configuration) {
        this.dataContextProvider = iQuickCardProvider;
        String script = quickCardBean.getScript();
        this.script = script;
        iQuickCardProvider.setTemplate(script);
        this.scriptEngine = quickCardBean.getScriptEngine();
        Map<String, String> a10 = a(quickCardBean.getI18n(), configuration);
        a10.put(QuickCardField.CONFIGURATION, this.configurationManager.c());
        a10.put(QuickCardField.HOST_PARAMS, JsonUtils.toJsonString(this.hostParams));
        iQuickCardProvider.setOptions(a10);
        if (quickCardBean.getThemeBean() != null) {
            this.mThemeBean = new ThemeBean(quickCardBean.getThemeBean());
        }
        resetConfig();
        d();
    }

    @Override // com.huawei.quickcard.framework.a, com.huawei.quickcard.CardContext
    public void onRendered() {
        getDataContext();
    }

    @Override // com.huawei.quickcard.framework.a
    public void postUpdateByVar(List<String> list) {
        HashSet hashSet = new HashSet(list);
        this.wm.updateByScripts(hashSet);
        if (hashSet.contains("$configuration.deviceInfo.screenDensity")) {
            this.wm.updateDPWatchers();
            this.configurationManager.d(this.quickCardRoot.getRootViewGroup().getContext());
        } else if (hashSet.contains("$configuration.deviceInfo.fontScale")) {
            this.wm.updateSPWatchers();
        }
    }

    private Set<String> a(I18nBean i18nBean, Locale locale, Map<String, String> map) {
        if (i18nBean == null) {
            return new HashSet(1);
        }
        String c4 = i18nBean.c();
        if (c4 == null) {
            c4 = I18nUtils.mixFinalLocaleCode(locale, i18nBean.b(), i18nBean.a());
        }
        JSONObject optJSONObject = i18nBean.a().optJSONObject(c4);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            HashSet hashSet = new HashSet(1);
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null) {
                    map.put(next, optJSONObject2.toString());
                    hashSet.add(next);
                }
            }
            return hashSet;
        }
        return new HashSet(1);
    }
}
