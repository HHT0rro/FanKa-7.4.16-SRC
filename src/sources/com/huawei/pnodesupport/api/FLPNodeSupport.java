package com.huawei.pnodesupport.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.card.FLPNode;
import com.huawei.flexiblelayout.card.IndicatorCard;
import com.huawei.flexiblelayout.creator.FLDefaultNodeResolver;
import com.huawei.hwwidgetsupport.api.HwWidgetService;
import com.huawei.hwwidgetsupport.api.platforms.base.BaseWidgetService;
import com.huawei.pnodesupport.impl.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FLPNodeSupport {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f33065a;

    public static void init(@NonNull Context context) {
        if (f33065a) {
            return;
        }
        f33065a = true;
        FLEngine fLEngine = FLEngine.getInstance(context);
        fLEngine.registerService(FLPNodeService.class, new a());
        fLEngine.registerNode(FLPNode.TYPE, new FLDefaultNodeResolver(FLPNode.class));
        fLEngine.register(IndicatorCard.f27793e, IndicatorCard.class);
        if (fLEngine.getService(HwWidgetService.class) == null) {
            fLEngine.registerService(HwWidgetService.class, new BaseWidgetService());
        }
    }
}
