package com.cupidapp.live.chat2.helper;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.base.utils.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KeyboardStatePopupWindow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class KeyboardStatePopupWindow extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener, DefaultLifecycleObserver {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f13351e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public int f13352b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13353c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public i f13354d;

    /* compiled from: KeyboardStatePopupWindow.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KeyboardStatePopupWindow(@Nullable Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull final View anchorView) {
        s.i(lifecycleOwner, "lifecycleOwner");
        s.i(anchorView, "anchorView");
        lifecycleOwner.getLifecycle().addObserver(this);
        View view = new View(context);
        setContentView(view);
        setWidth(0);
        setHeight(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setSoftInputMode(16);
        setInputMethodMode(1);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        anchorView.post(new Runnable() { // from class: com.cupidapp.live.chat2.helper.h
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardStatePopupWindow.b(KeyboardStatePopupWindow.this, anchorView);
            }
        });
        j.f12332a.a("KeyboardStatePopupWindow", "init 软键盘高度:" + p1.g.f52734a.a0());
    }

    public static final void b(KeyboardStatePopupWindow this$0, View anchorView) {
        s.i(this$0, "this$0");
        s.i(anchorView, "$anchorView");
        this$0.showAtLocation(anchorView, 0, 0, 0);
    }

    public final void c(@NotNull i listener) {
        s.i(listener, "listener");
        this.f13354d = listener;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        dismiss();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        getContentView().getWindowVisibleDisplayFrame(rect);
        int i10 = rect.bottom;
        if (i10 > this.f13352b) {
            this.f13352b = i10;
        }
        j.a aVar = j.f12332a;
        aVar.a("KeyboardStatePopupWindow", "rect:" + ((Object) rect) + "   rect.bottom:" + i10 + "   mMaxHeight:" + this.f13352b);
        int k10 = z0.h.k(this);
        int i11 = this.f13352b - rect.bottom;
        int i12 = k10 / 4;
        boolean z10 = i11 > i12;
        double d10 = k10 / 1.8d;
        aVar.a("KeyboardStatePopupWindow", "screenHeight:" + k10 + "   keyboardHeight:" + i11 + "   visible:" + z10 + "  /4:" + i12 + "   /1.8:" + d10);
        if (z10 && (i11 < i12 || i11 > d10)) {
            aVar.a("KeyboardStatePopupWindow", "软键盘高度不合格 return");
            return;
        }
        boolean z11 = this.f13353c;
        if (!z11 && z10) {
            this.f13353c = true;
            p1.g gVar = p1.g.f52734a;
            gVar.E2(i11);
            aVar.a("KeyboardStatePopupWindow", "已打开 软键盘高度:" + gVar.a0());
            i iVar = this.f13354d;
            if (iVar != null) {
                iVar.c(i11);
                return;
            }
            return;
        }
        if (z11 && !z10) {
            this.f13353c = false;
            aVar.a("KeyboardStatePopupWindow", "已关闭 软键盘高度:" + p1.g.f52734a.a0());
            i iVar2 = this.f13354d;
            if (iVar2 != null) {
                iVar2.a();
                return;
            }
            return;
        }
        if (z11) {
            p1.g gVar2 = p1.g.f52734a;
            if (gVar2.a0() != i11) {
                int a02 = gVar2.a0();
                gVar2.E2(i11);
                aVar.a("KeyboardStatePopupWindow", "高度已调整 软键盘高度  lastKeyboardHeight" + a02 + "   keyboardHeight:" + i11);
                i iVar3 = this.f13354d;
                if (iVar3 != null) {
                    iVar3.b(a02, i11);
                }
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.f(this, lifecycleOwner);
    }
}
