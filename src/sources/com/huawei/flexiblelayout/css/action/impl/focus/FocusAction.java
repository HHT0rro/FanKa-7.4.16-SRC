package com.huawei.flexiblelayout.css.action.impl.focus;

import android.view.View;
import com.huawei.flexiblelayout.css.action.CSSAction;
import com.huawei.flexiblelayout.css.action.impl.focus.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FocusAction extends CSSAction implements a.InterfaceC0269a {
    public static final String NAME = ":focus";

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public boolean answerActionSelf(View view) {
        return view.isFocusable();
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void attach() {
        if (answerActionSelf(this.mView)) {
            View.OnFocusChangeListener onFocusChangeListener = this.mView.getOnFocusChangeListener();
            if (onFocusChangeListener instanceof a) {
                return;
            }
            a aVar = new a(this);
            aVar.a(onFocusChangeListener);
            this.mView.setOnFocusChangeListener(aVar);
        }
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public String getName() {
        return ":focus";
    }

    @Override // com.huawei.flexiblelayout.css.action.impl.focus.a.InterfaceC0269a
    public void onFocus() {
        doAction();
        doLinkedActions();
    }

    @Override // com.huawei.flexiblelayout.css.action.impl.focus.a.InterfaceC0269a
    public void onUnFocus() {
        reset();
        resetLinkedViews();
    }
}
