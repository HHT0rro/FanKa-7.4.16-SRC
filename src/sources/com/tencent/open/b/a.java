package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f45196a = a.class.getName();

    /* renamed from: b, reason: collision with root package name */
    private Rect f45197b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f45198c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0650a f45199d;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0650a {
        void a();

        void a(int i10);
    }

    public a(Context context) {
        super(context);
        this.f45197b = null;
        this.f45198c = false;
        this.f45199d = null;
        this.f45197b = new Rect();
    }

    public void a(InterfaceC0650a interfaceC0650a) {
        this.f45199d = interfaceC0650a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f45197b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f45197b.top) - size;
        InterfaceC0650a interfaceC0650a = this.f45199d;
        if (interfaceC0650a != null && size != 0) {
            if (height > 100) {
                interfaceC0650a.a((Math.abs(this.f45197b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0650a.a();
            }
        }
        super.onMeasure(i10, i11);
    }
}
