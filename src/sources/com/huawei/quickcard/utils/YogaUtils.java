package com.huawei.quickcard.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaUnit;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.ui.YogaContainer;
import com.huawei.quickcard.views.div.CardYogaLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class YogaUtils {
    public static float getNodeHeight(View view) {
        YogaNode yogaNode = getYogaNode(view);
        if (yogaNode != null && yogaNode.j().f19202b == YogaUnit.POINT) {
            return yogaNode.j().f19201a;
        }
        return 0.0f;
    }

    public static float getNodeWidth(View view) {
        YogaNode yogaNode = getYogaNode(view);
        if (yogaNode != null && yogaNode.q().f19202b == YogaUnit.POINT) {
            return yogaNode.q().f19201a;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static YogaNode getYogaNode(View view) {
        if (view instanceof YogaContainer) {
            return ((YogaContainer) view).getYogaNode();
        }
        ViewParent viewParent = (ViewGroup) view.getParent();
        if (viewParent instanceof YogaContainer) {
            return ((YogaContainer) viewParent).getYogaNodeForView(view);
        }
        CardLogUtils.e("not a support node");
        return null;
    }

    public static boolean isParentYogaLayout(View view) {
        return view != null && (view.getParent() instanceof CardYogaLayout);
    }
}
