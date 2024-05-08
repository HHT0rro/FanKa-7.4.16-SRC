package com.huawei.flexiblelayout.services.action;

import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface CardActionService {
    public static final String CARD_CLICK_ACTION = "FL_CARD_CLICK_ACTION";
    public static final String CARD_LONG_CLICK_ACTION = "FL_CARD_LONG_CLICK_ACTION";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Action {

        /* renamed from: a, reason: collision with root package name */
        private String f28503a;

        /* renamed from: b, reason: collision with root package name */
        private Object f28504b;

        public Action(String str) {
            this(str, null);
        }

        public Object getParam() {
            return this.f28504b;
        }

        public String getType() {
            return this.f28503a;
        }

        public Action(String str, Object obj) {
            this.f28503a = str;
            this.f28504b = obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ActionHandler {
        boolean onAction(FLContext fLContext, FLCell<? extends FLCardData> fLCell, Action action);
    }

    boolean click(FLContext fLContext, FLCell<? extends FLCardData> fLCell, Action action);

    void registerActionHandler(ActionHandler actionHandler);

    void unregisterActionHandler(ActionHandler actionHandler);
}
