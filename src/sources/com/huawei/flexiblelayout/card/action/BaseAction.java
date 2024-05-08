package com.huawei.flexiblelayout.card.action;

import android.view.View;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.action.CardActionService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BaseAction {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27808a = "BaseAction";

    public static void bindTo(final FLContext fLContext, final View view, final FLCell<? extends FLCardData> fLCell) {
        if (view == null) {
            Log.i(f27808a, "bindTo view == null");
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.flexiblelayout.card.action.BaseAction.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    CardActionService cardActionService = (CardActionService) FLEngine.getInstance(View.this.getContext()).getService(CardActionService.class);
                    if (cardActionService != null) {
                        cardActionService.click(fLContext, fLCell, new CardActionService.Action(CardActionService.CARD_CLICK_ACTION));
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.huawei.flexiblelayout.card.action.BaseAction.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    CardActionService cardActionService = (CardActionService) FLEngine.getInstance(View.this.getContext()).getService(CardActionService.class);
                    if (cardActionService != null) {
                        return cardActionService.click(fLContext, fLCell, new CardActionService.Action(CardActionService.CARD_LONG_CLICK_ACTION));
                    }
                    return false;
                }
            });
        }
    }
}
