package com.huawei.flexiblelayout.view;

import android.view.View;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.data.changed.FLDataChangedRequest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface LayoutView {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum ScrollDirection {
        VERTICAL,
        HORIZONTAL
    }

    ScrollDirection getScrollDirection();

    View getView();

    void mount(FLayout fLayout);

    void onDataSourceChanged();

    void requestDataChanged(FLDataChangedRequest fLDataChangedRequest);
}
