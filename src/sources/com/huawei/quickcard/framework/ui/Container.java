package com.huawei.quickcard.framework.ui;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.processor.FlexContainerStyle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class Container<T extends ViewGroup> extends Component<T> {
    public Container() {
        FlexContainerStyle flexContainerStyle = new FlexContainerStyle();
        addProcessor("flexDirection", flexContainerStyle);
        addProcessor(Attributes.Style.FLEX_WRAP, flexContainerStyle);
        addProcessor(Attributes.Style.JUSTIFY_CONTENT, flexContainerStyle);
        addProcessor(Attributes.Style.ALIGN_ITEMS, flexContainerStyle);
        addProcessor(Attributes.Style.ALIGN_SELF, flexContainerStyle);
        addProcessor(Attributes.Style.ALIGN_CONTENT, flexContainerStyle);
    }

    public void addView(T t2, View view) {
        t2.addView(view, -1);
    }

    public View getChildAt(T t2, int i10) {
        return t2.getChildAt(i10);
    }

    public int getChildCount(T t2) {
        return t2.getChildCount();
    }

    public void addView(T t2, View view, int i10) {
        t2.addView(view, i10);
    }
}
