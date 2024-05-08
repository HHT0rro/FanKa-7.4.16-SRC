package com.huawei.flexiblelayout.css.action.impl;

import android.view.View;
import com.huawei.flexiblelayout.css.action.CSSAction;
import com.huawei.flexiblelayout.css.adapter.CSSPropertyName;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VirtualAction extends CSSAction {
    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public boolean answerActionSelf(View view) {
        return false;
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void attach() {
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void doLinkedActions() {
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void fillLinkedActions(View view) {
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public String getName() {
        return CSSPropertyName.VIRTUAL_ACTION;
    }

    @Override // com.huawei.flexiblelayout.css.action.CSSAction
    public void resetLinkedViews() {
    }
}
