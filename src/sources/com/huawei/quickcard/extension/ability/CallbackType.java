package com.huawei.quickcard.extension.ability;

import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum CallbackType {
    SUCCESS("success"),
    FAIL(bg.b.S),
    COMPLETE("complete"),
    EMPTY(""),
    CANCEL(CardEventType.CLICK_ACTION_CANCEL);


    /* renamed from: a, reason: collision with root package name */
    private final String f33643a;

    CallbackType(String str) {
        this.f33643a = str;
    }

    public String getType() {
        return this.f33643a;
    }
}
