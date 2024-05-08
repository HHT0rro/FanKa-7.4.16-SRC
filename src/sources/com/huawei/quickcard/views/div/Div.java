package com.huawei.quickcard.views.div;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.processor.LockDensityProcessor;
import com.huawei.quickcard.framework.ui.Container;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Div extends Container<DivLayout> {
    public Div() {
        addProcessor(Attributes.Style.LOCKED_DENSITY, new LockDensityProcessor());
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return Attributes.Component.DIV;
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public DivLayout createViewImpl(Context context) {
        return new DivLayout(context);
    }
}
