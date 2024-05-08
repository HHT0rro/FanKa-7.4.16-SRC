package com.huawei.quickcard.framework.ui;

import android.view.View;
import com.facebook.yoga.YogaNode;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface YogaContainer {
    YogaNode getYogaNode();

    YogaNode getYogaNodeForView(View view);

    Map<View, YogaNode> getYogaNodes();

    void invalidate(View view);
}
