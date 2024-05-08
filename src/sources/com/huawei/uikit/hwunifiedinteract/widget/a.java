package com.huawei.uikit.hwunifiedinteract.widget;

import android.view.KeyEvent;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements View.OnUnhandledKeyEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwKeyEventDetector f35285a;

    public a(HwKeyEventDetector hwKeyEventDetector) {
        this.f35285a = hwKeyEventDetector;
    }

    @Override // android.view.View.OnUnhandledKeyEventListener
    public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        boolean a10;
        a10 = this.f35285a.a(view, keyEvent);
        return a10;
    }
}
