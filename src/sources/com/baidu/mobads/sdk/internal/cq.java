package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cq extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10107a = "ContainerView";

    /* renamed from: b, reason: collision with root package name */
    private a f10108b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        boolean onKeyDown(int i10, KeyEvent keyEvent);

        void onLayoutComplete(int i10, int i11);

        void onWindowFocusChanged(boolean z10);

        void onWindowVisibilityChanged(int i10);
    }

    public cq(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f10108b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f10108b;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f10108b;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        a aVar = this.f10108b;
        if (aVar != null) {
            return aVar.onKeyDown(i10, keyEvent);
        }
        super.onKeyDown(i10, keyEvent);
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        a aVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || (aVar = this.f10108b) == null) {
            return;
        }
        aVar.onLayoutComplete(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        a aVar = this.f10108b;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        a aVar = this.f10108b;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i10);
        }
    }
}
