package com.huawei.flexiblelayout.css.action;

import android.view.View;
import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.CSSSelector;
import com.huawei.flexiblelayout.css.CSSView;
import com.huawei.flexiblelayout.css.adapter.CSSPropertyName;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.e;
import com.huawei.flexiblelayout.d0;
import com.huawei.flexiblelayout.e0;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.effect.FLEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class CSSAction {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27965a = "CSSAction";
    public com.huawei.flexiblelayout.css.action.value.a mActionValue;
    public List<FLEffect> mEffects;
    public boolean mFilledLinkedActions;
    public List<CSSAction> mLinkedActions = new ArrayList();
    public View mView;

    private void a() {
        if (this.mFilledLinkedActions) {
            return;
        }
        this.mFilledLinkedActions = true;
        fillLinkedActions(this.mView);
    }

    public abstract boolean answerActionSelf(View view);

    public abstract void attach();

    public void bind(View view, CSSValue cSSValue) {
        if (view != null && (cSSValue instanceof com.huawei.flexiblelayout.css.action.value.a)) {
            this.mView = view;
            this.mActionValue = (com.huawei.flexiblelayout.css.action.value.a) cSSValue;
            attach();
        } else {
            Log.w(f27965a, "attach, view: " + ((Object) view) + ", actionValue = " + ((Object) cSSValue));
        }
    }

    public void doAction() {
        CSSRule a10 = this.mActionValue.a();
        if (a10 == null) {
            return;
        }
        onFinished(this.mView);
        this.mEffects = CSSView.wrap(this.mView, a10).renderSelf();
    }

    public void doLinkedActions() {
        a();
        List<CSSAction> list = this.mLinkedActions;
        if (list == null) {
            return;
        }
        for (CSSAction cSSAction : list) {
            if (cSSAction != null) {
                cSSAction.doAction();
            }
        }
    }

    public void fillLinkedActions(View view) {
        List<CSSValue.LinkedRule> linkedRules = this.mActionValue.getLinkedRules();
        if (linkedRules == null) {
            return;
        }
        CSSRule parent = this.mActionValue.getParent();
        CSSLink parent2 = parent != null ? parent.getParent() : null;
        if (parent2 == null) {
            Log.w(f27965a, "fillLinkedActions, parentLink == null");
            return;
        }
        for (CSSValue.LinkedRule linkedRule : linkedRules) {
            CSSRule cssRule = linkedRule.getCssRule();
            List<d0> a10 = e0.a(view, linkedRule.getSelectExpr());
            if (a10 != null) {
                Iterator<d0> iterator2 = a10.iterator2();
                while (iterator2.hasNext()) {
                    a(iterator2.next().a(), parent2, cssRule);
                }
            }
        }
    }

    public CSSAction getCSSAction(String str, View view) {
        return a.b().a(str);
    }

    public abstract String getName();

    public void onFinished(View view) {
        List<FLEffect> list = this.mEffects;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (FLEffect fLEffect : this.mEffects) {
            if (fLEffect != null) {
                fLEffect.unapply(view);
                Log.i(f27965a, "onFinished, view: " + ((Object) view));
            }
        }
        this.mEffects.clear();
    }

    public void reset() {
        onFinished(this.mView);
        CSSView.wrap(this.mView, this.mActionValue.b()).renderSelf();
    }

    public void resetLinkedViews() {
        List<CSSAction> list = this.mLinkedActions;
        if (list == null) {
            return;
        }
        for (CSSAction cSSAction : list) {
            if (cSSAction != null) {
                cSSAction.reset();
            }
        }
    }

    private void a(View view, CSSLink cSSLink, CSSRule cSSRule) {
        String a10 = e.a(view);
        if (a10 != null) {
            CSSRule rule = CSSSelector.build(a10).getRule(cSSLink);
            if (rule == null) {
                rule = new CSSRule();
                cSSLink.addRule(a10, rule);
            }
            com.huawei.flexiblelayout.css.action.value.a aVar = new com.huawei.flexiblelayout.css.action.value.a(null);
            aVar.a(cSSRule);
            aVar.b(rule);
            CSSAction cSSAction = getCSSAction(CSSPropertyName.VIRTUAL_ACTION, view);
            cSSAction.bind(view, aVar);
            this.mLinkedActions.add(cSSAction);
        }
    }
}
