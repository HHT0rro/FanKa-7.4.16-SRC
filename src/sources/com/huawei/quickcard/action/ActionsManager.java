package com.huawei.quickcard.action;

import android.view.View;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.IQuickCardListener;
import com.huawei.quickcard.QuickCardEngine;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IExpressionContextProxy;
import com.huawei.quickcard.framework.QuickCardField;
import com.huawei.quickcard.framework.a;
import com.huawei.quickcard.utils.ValueUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ActionsManager {

    /* renamed from: f, reason: collision with root package name */
    private static final String f33263f = "ActionsManager";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, AbsQuickCardAction> f33264a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f33265b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private boolean f33266c;

    /* renamed from: d, reason: collision with root package name */
    private IQuickCardListener f33267d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33268e;

    private void a(CardContext cardContext, View view) {
        Iterator<Map.Entry<String, AbsQuickCardAction>> iterator2 = this.f33264a.entrySet().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().getValue().bindTargetContext(cardContext, view);
        }
    }

    public void bindActions(IExpressionContext iExpressionContext, CardContext cardContext, View view) {
        if (this.f33264a.isEmpty()) {
            return;
        }
        if (this.f33268e) {
            a(cardContext, view);
        } else {
            a(iExpressionContext, cardContext, view);
            this.f33268e = true;
        }
    }

    public boolean doAction(a aVar, String str, View view, Map<String, Object> map) {
        IExpressionContextProxy dataContext = aVar.getDataContext();
        if (dataContext == null) {
            return false;
        }
        initActions();
        if (map == null) {
            map = new HashMap<>();
        }
        dataContext.set(QuickCardField.ACTION_EVENT_KEY, map);
        bindActions(dataContext, aVar, view);
        try {
            aVar.executeExpr(str);
            return true;
        } catch (Exception e2) {
            CardLogUtils.e(f33263f, "execute action error", e2);
            if (this.f33267d != null) {
                this.f33267d.onActionRunFailed(e2.getMessage());
            }
            return false;
        }
    }

    public void initActions() {
        if (this.f33266c) {
            return;
        }
        this.f33264a.putAll(a(ActionsHelper.getInnerActions(), (IQuickCardListener) null));
        this.f33264a.putAll(a(QuickCardEngine.getActionsMap(), this.f33267d));
        this.f33266c = true;
    }

    public void onDataContextChange(IExpressionContext iExpressionContext) {
        if (iExpressionContext != null) {
            iExpressionContext.set(QuickCardField.ACTION_PREFIX, this.f33265b);
        }
    }

    public void setCardActionListener(IQuickCardListener iQuickCardListener) {
        this.f33267d = iQuickCardListener;
    }

    private void a(IExpressionContext iExpressionContext, CardContext cardContext, View view) {
        for (Map.Entry<String, AbsQuickCardAction> entry : this.f33264a.entrySet()) {
            AbsQuickCardAction value = entry.getValue();
            value.bindTargetContext(cardContext, view);
            ValueUtils.putToMap(this.f33265b, value, entry.getKey().split("\\."));
            Map<String, Object> nativeApi = value.getNativeApi();
            if (nativeApi.size() > 0) {
                for (Map.Entry<String, Object> entry2 : nativeApi.entrySet()) {
                    ValueUtils.putToMap(this.f33265b, entry2.getValue(), entry2.getKey().split("\\."));
                }
            }
        }
        iExpressionContext.set(QuickCardField.ACTION_PREFIX, this.f33265b);
    }

    private static Map<String, AbsQuickCardAction> a(Map<String, Class<? extends AbsQuickCardAction>> map, IQuickCardListener iQuickCardListener) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Class<? extends AbsQuickCardAction>> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                AbsQuickCardAction newInstance = entry.getValue().newInstance();
                hashMap.put(key, newInstance);
                if (iQuickCardListener != null && newInstance.shouldTriggerListener()) {
                    iQuickCardListener.onActionCreated(newInstance);
                }
            } catch (IllegalAccessException | InstantiationException e2) {
                CardLogUtils.e(f33263f, "inits action error", e2);
            }
        }
        return hashMap;
    }
}
