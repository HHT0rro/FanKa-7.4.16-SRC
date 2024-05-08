package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.services.action.CardActionService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: CardActionServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h1 implements CardActionService {

    /* renamed from: a, reason: collision with root package name */
    private Set<CardActionService.ActionHandler> f28146a = new HashSet();

    @Override // com.huawei.flexiblelayout.services.action.CardActionService
    public final boolean click(FLContext fLContext, FLCell<? extends FLCardData> fLCell, CardActionService.Action action) {
        Iterator<CardActionService.ActionHandler> iterator2 = this.f28146a.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            z10 |= iterator2.next().onAction(fLContext, fLCell, action);
        }
        return z10;
    }

    @Override // com.huawei.flexiblelayout.services.action.CardActionService
    public void registerActionHandler(CardActionService.ActionHandler actionHandler) {
        this.f28146a.add(actionHandler);
    }

    @Override // com.huawei.flexiblelayout.services.action.CardActionService
    public void unregisterActionHandler(CardActionService.ActionHandler actionHandler) {
        this.f28146a.remove(actionHandler);
    }
}
