package com.cupidapp.live.base.view.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlingBehavior.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FlingBehavior extends AppBarLayout.Behavior {

    /* renamed from: a, reason: collision with root package name */
    public final int f12634a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12635b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Rect f12636c;

    public FlingBehavior() {
        this.f12634a = 1;
        this.f12636c = new Rect();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean onNestedFling(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout child, @NotNull View target, float f10, float f11, boolean z10) {
        s.i(coordinatorLayout, "coordinatorLayout");
        s.i(child, "child");
        s.i(target, "target");
        if ((f11 > 0.0f && !this.f12635b) || (f11 < 0.0f && this.f12635b)) {
            f11 *= -1;
        }
        float f12 = f11;
        if ((target instanceof RecyclerView) && f12 < 0.0f) {
            RecyclerView recyclerView = (RecyclerView) target;
            z10 = false;
            if (recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) > this.f12634a) {
                z10 = true;
            }
        }
        return super.onNestedFling(coordinatorLayout, child, target, f10, f12, z10);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout child, @NotNull View target, int i10, int i11, @NotNull int[] consumed, int i12) {
        s.i(coordinatorLayout, "coordinatorLayout");
        s.i(child, "child");
        s.i(target, "target");
        s.i(consumed, "consumed");
        super.onNestedPreScroll(coordinatorLayout, child, target, i10, i11, consumed, i12);
        this.f12635b = i11 > 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlingBehavior(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        s.i(context, "context");
        s.i(attrs, "attrs");
        this.f12634a = 1;
        this.f12636c = new Rect();
    }
}
