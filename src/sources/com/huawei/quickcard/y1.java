package com.huawei.quickcard;

import android.view.View;
import com.huawei.quickcard.framework.event.CardEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y1 implements CardEvent {

    /* renamed from: c, reason: collision with root package name */
    public static final String f34750c = "idEvent";

    /* renamed from: a, reason: collision with root package name */
    private final String f34751a;

    /* renamed from: b, reason: collision with root package name */
    private final View f34752b;

    public y1(String str, View view) {
        this.f34751a = str;
        this.f34752b = view;
    }

    public View a() {
        return this.f34752b;
    }

    public String b() {
        return this.f34751a;
    }

    @Override // com.huawei.quickcard.framework.event.CardEvent
    public String name() {
        return f34750c;
    }
}
