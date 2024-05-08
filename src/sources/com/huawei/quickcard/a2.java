package com.huawei.quickcard;

import android.view.View;
import com.huawei.quickcard.framework.IVirtualViewParent;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.watcher.IWatcherManager;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a2 {
    public static void a(IVirtualViewParent iVirtualViewParent, String str, String str2, Map<String, QuickCardValue> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, QuickCardValue> entry : map.entrySet()) {
            b(iVirtualViewParent, str, str2, entry.getKey(), entry.getValue());
        }
    }

    public static void b(IVirtualViewParent iVirtualViewParent, String str, String str2, Map<String, Map<String, QuickCardValue>> map) {
        for (Map.Entry<String, Map<String, QuickCardValue>> entry : map.entrySet()) {
            Iterator<Map.Entry<String, QuickCardValue>> iterator2 = entry.getValue().entrySet().iterator2();
            while (iterator2.hasNext()) {
                b(iVirtualViewParent, str, str2, entry.getKey(), iterator2.next().getValue());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(IVirtualViewParent iVirtualViewParent, String str, String str2, String str3, QuickCardValue quickCardValue) {
        IWatcherManager watcherManager = ViewUtils.getCardContext((View) iVirtualViewParent).getWatcherManager();
        if (quickCardValue.isExpression()) {
            watcherManager.watchVirtualViewAttr(str, str2, str3, quickCardValue.getExpression(), new z1(iVirtualViewParent));
        }
    }

    private static void b(IVirtualViewParent iVirtualViewParent, String str, String str2, String str3, QuickCardValue quickCardValue) {
        if (quickCardValue.isExpression()) {
            a(iVirtualViewParent, str, str2, str3, quickCardValue);
        } else {
            iVirtualViewParent.setChildProperties(str, str2, str3, quickCardValue);
        }
    }
}
