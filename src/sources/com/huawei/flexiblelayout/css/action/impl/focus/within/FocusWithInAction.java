package com.huawei.flexiblelayout.css.action.impl.focus.within;

import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.flexiblelayout.css.action.CSSAction;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FocusWithInAction extends CSSAction {

    /* renamed from: c, reason: collision with root package name */
    private static final String f27977c = ":focus-within";

    /* renamed from: b, reason: collision with root package name */
    private b f27978b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FocusWithInAction.this.c();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FocusWithInAction.this.d();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements ViewTreeObserver.OnGlobalFocusChangeListener {
        private b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            if (view2 == FocusWithInAction.this.mView) {
                FocusWithInAction.this.onFocus();
            } else if (FocusWithInAction.this.mView.findFocus() != null) {
                FocusWithInAction.this.onFocus();
            } else {
                FocusWithInAction.this.onUnFocus();
            }
        }

        public /* synthetic */ b(FocusWithInAction focusWithInAction, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFocus() {
        doAction();
        doLinkedActions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnFocus() {
        reset();
        resetLinkedViews();
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public boolean answerActionSelf(View view) {
        return true;
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void attach() {
        com.huawei.flexiblelayout.css.action.impl.focus.within.a.a().a(this.mView, this);
        if (this.mView.isAttachedToWindow()) {
            c();
        } else {
            this.mView.addOnAttachStateChangeListener(new a());
        }
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void doAction() {
        com.huawei.flexiblelayout.css.action.impl.focus.within.a.a().a(this.mView);
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public CSSAction getCSSAction(String str, View view) {
        FocusWithInAction b4 = com.huawei.flexiblelayout.css.action.impl.focus.within.a.a().b(view);
        return b4 == null ? super.getCSSAction(str, view) : b4;
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public String getName() {
        return ":focus-within";
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void reset() {
        com.huawei.flexiblelayout.css.action.impl.focus.within.a.a().c(this.mView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f27978b == null) {
            this.f27978b = new b(this, null);
            this.mView.getViewTreeObserver().addOnGlobalFocusChangeListener(this.f27978b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f27978b != null) {
            this.mView.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f27978b);
            this.f27978b = null;
        }
    }

    public void a() {
        super.doAction();
    }

    public void b() {
        super.reset();
    }
}
