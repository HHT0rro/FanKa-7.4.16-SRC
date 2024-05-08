package com.huawei.flexiblelayout.css.action.impl;

import android.view.MotionEvent;
import android.view.View;
import com.huawei.flexiblelayout.common.d;
import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.CSSSelector;
import com.huawei.flexiblelayout.css.CSSView;
import com.huawei.flexiblelayout.css.action.CSSAction;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ActiveAction extends CSSAction {
    public static final String NAME = ":active";

    /* renamed from: e, reason: collision with root package name */
    private static final String f27969e = "ActiveAction";

    /* renamed from: f, reason: collision with root package name */
    private static final int f27970f = 300;

    /* renamed from: b, reason: collision with root package name */
    private boolean f27971b;

    /* renamed from: c, reason: collision with root package name */
    private int f27972c;

    /* renamed from: d, reason: collision with root package name */
    private int f27973d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            b(motionEvent);
            return false;
        }
        if (motionEvent.getAction() == 2) {
            a(motionEvent);
            return false;
        }
        reset();
        return false;
    }

    private void b(MotionEvent motionEvent) {
        if (this.mActionValue.a() == null) {
            return;
        }
        doAction();
        doLinkedActions();
        this.f27972c = (int) motionEvent.getX();
        this.f27973d = (int) motionEvent.getY();
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public boolean answerActionSelf(View view) {
        return view.isClickable();
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void attach() {
        if (answerActionSelf(this.mView)) {
            this.mView.setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.flexiblelayout.css.action.impl.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean a10;
                    a10 = ActiveAction.this.a(view, motionEvent);
                    return a10;
                }
            });
        }
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void doAction() {
        super.doAction();
        this.f27971b = false;
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void fillLinkedActions(View view) {
        super.fillLinkedActions(view);
        if (!answerActionSelf(view)) {
            return;
        }
        CSSRule parent = this.mActionValue.getParent();
        CSSLink parent2 = parent != null ? parent.getParent() : null;
        while (true) {
            Object parent3 = view.getParent();
            if (!(parent3 instanceof View)) {
                return;
            }
            view = (View) parent3;
            com.huawei.flexiblelayout.css.action.value.a a10 = a(view);
            if (a10 != null) {
                a(view, a10);
            } else if (parent2 != null) {
                a(view, parent2);
            }
        }
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public String getName() {
        return ":active";
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void reset() {
        if (this.f27971b) {
            return;
        }
        this.f27971b = true;
        super.reset();
        resetLinkedViews();
    }

    private void a(View view, CSSLink cSSLink) {
        CSSRule rule;
        CSSValue propertyValue;
        String a10 = e.a(view);
        if (a10 == null || answerActionSelf(view) || (rule = CSSSelector.build(a10).getRule(cSSLink)) == null || (propertyValue = rule.getPropertyValue(getName())) == null) {
            return;
        }
        CSSAction cSSAction = getCSSAction(getName(), view);
        cSSAction.bind(view, propertyValue);
        this.mLinkedActions.add(cSSAction);
    }

    private com.huawei.flexiblelayout.css.action.value.a a(View view) {
        Object a10 = d.a(view, CSSRule.CSSRULE_TAG, (Class<Object>) Object.class);
        if (a10 instanceof CSSRule) {
            return (com.huawei.flexiblelayout.css.action.value.a) ((CSSRule) a10).getPropertyValue(getName());
        }
        return null;
    }

    private void a(View view, com.huawei.flexiblelayout.css.action.value.a aVar) {
        CSSAction cSSAction = getCSSAction(getName(), view);
        cSSAction.bind(view, aVar);
        this.mLinkedActions.add(cSSAction);
    }

    private void a(MotionEvent motionEvent) {
        if (this.f27971b) {
            return;
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (a(this.f27972c, x10) || a(this.f27973d, y10)) {
            this.f27971b = true;
            onFinished(this.mView);
            CSSView.wrap(this.mView, this.mActionValue.b()).renderSelf();
            resetLinkedViews();
        }
    }

    private boolean a(int i10, int i11) {
        return Math.abs(i11 - i10) > 300;
    }
}
