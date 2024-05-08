package com.cupidapp.live.base.utils;

import android.view.View;
import android.widget.PopupWindow;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPopupWindowWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public PopupWindow f12341a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12342b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12343c = true;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function0<kotlin.p> f12344d;

    public static /* synthetic */ l f(l lVar, View view, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = -2;
        }
        if ((i12 & 4) != 0) {
            i11 = -2;
        }
        return lVar.e(view, i10, i11);
    }

    public static final void g(l this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Function0<kotlin.p> function0 = this$0.f12344d;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @NotNull
    public final l b(boolean z10) {
        this.f12342b = z10;
        return this;
    }

    @NotNull
    public final l c(boolean z10) {
        this.f12343c = z10;
        return this;
    }

    public final void d() {
        PopupWindow popupWindow = this.f12341a;
        if (popupWindow != null && popupWindow.isShowing()) {
            PopupWindow popupWindow2 = this.f12341a;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
            this.f12341a = null;
        }
    }

    @NotNull
    public final l e(@NotNull View contentView, int i10, int i11) {
        kotlin.jvm.internal.s.i(contentView, "contentView");
        PopupWindow popupWindow = new PopupWindow(contentView, i10, i11);
        popupWindow.setFocusable(this.f12342b);
        popupWindow.setOutsideTouchable(this.f12343c);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.cupidapp.live.base.utils.k
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                l.g(l.this);
            }
        });
        this.f12341a = popupWindow;
        return this;
    }

    @NotNull
    public final l h(@NotNull Function0<kotlin.p> listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f12344d = listener;
        return this;
    }

    public final void i(@NotNull View anchorView, int i10, int i11) {
        kotlin.jvm.internal.s.i(anchorView, "anchorView");
        PopupWindow popupWindow = this.f12341a;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(anchorView, i10, i11);
        }
    }

    public final void j(@NotNull View parentView, int i10, int i11, int i12) {
        kotlin.jvm.internal.s.i(parentView, "parentView");
        PopupWindow popupWindow = this.f12341a;
        if (popupWindow != null) {
            popupWindow.showAtLocation(parentView, i10, i11, i12);
        }
    }
}
