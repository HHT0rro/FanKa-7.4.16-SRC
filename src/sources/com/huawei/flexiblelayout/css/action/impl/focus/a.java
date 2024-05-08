package com.huawei.flexiblelayout.css.action.impl.focus;

import android.view.View;

/* compiled from: OnFocusChangeImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0269a f27975a;

    /* renamed from: b, reason: collision with root package name */
    private View.OnFocusChangeListener f27976b;

    /* compiled from: OnFocusChangeImpl.java */
    /* renamed from: com.huawei.flexiblelayout.css.action.impl.focus.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterfaceC0269a {
        void onFocus();

        void onUnFocus();
    }

    public a(InterfaceC0269a interfaceC0269a) {
        this.f27975a = interfaceC0269a;
    }

    public void a(View.OnFocusChangeListener onFocusChangeListener) {
        this.f27976b = onFocusChangeListener;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        View.OnFocusChangeListener onFocusChangeListener = this.f27976b;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z10);
        }
        InterfaceC0269a interfaceC0269a = this.f27975a;
        if (interfaceC0269a != null) {
            if (z10) {
                interfaceC0269a.onFocus();
            } else {
                interfaceC0269a.onUnFocus();
            }
        }
    }
}
