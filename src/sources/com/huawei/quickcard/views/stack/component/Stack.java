package com.huawei.quickcard.views.stack.component;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.ui.Container;
import com.huawei.quickcard.views.stack.view.StackLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Stack extends Container<StackLayout> {
    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return Attributes.Component.STACK;
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public StackLayout createViewImpl(Context context) {
        return new StackLayout(context);
    }
}
