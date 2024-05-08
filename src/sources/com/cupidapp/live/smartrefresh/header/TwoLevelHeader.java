package com.cupidapp.live.smartrefresh.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.NestedScrollingParent2;
import com.cupidapp.live.smartrefresh.layout.constant.RefreshState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q3.a;
import q3.c;
import r3.b;

/* compiled from: TwoLevelHeader.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TwoLevelHeader extends RelativeLayout implements NestedScrollingParent2, a {

    /* renamed from: b, reason: collision with root package name */
    public int f18250b;

    /* renamed from: c, reason: collision with root package name */
    public float f18251c;

    /* renamed from: d, reason: collision with root package name */
    public float f18252d;

    /* renamed from: e, reason: collision with root package name */
    public float f18253e;

    /* renamed from: f, reason: collision with root package name */
    public int f18254f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18255g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public c f18256h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public o3.a f18257i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public View f18258j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public b f18259k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18260l;

    public TwoLevelHeader(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoLevelHeader(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f18260l = new LinkedHashMap();
        this.f18252d = 2.5f;
        this.f18253e = 1.9f;
        this.f18255g = true;
        this.f18259k = b.f53261c;
    }

    @Override // q3.a
    public void b(@NotNull c kernel, int i10, int i11) {
        s.i(kernel, "kernel");
        if (!((((float) (i11 + i10)) * 1.0f) / ((float) i10) == this.f18252d) && this.f18254f == 0) {
            this.f18254f = i10;
            kernel.c().b(this.f18252d);
        }
        this.f18254f = i10;
        this.f18256h = kernel;
        kernel.e(this, !this.f18255g);
    }

    @Override // s3.d
    public void c(@NotNull q3.d refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        s.i(refreshLayout, "refreshLayout");
        s.i(oldState, "oldState");
        s.i(newState, "newState");
        c cVar = this.f18256h;
        if (cVar != null) {
            if (newState == RefreshState.ReleaseToRefresh) {
                newState = RefreshState.PullDownToRefresh;
            }
            if (newState == RefreshState.TwoLevelReleased) {
                o3.a aVar = this.f18257i;
                if (cVar != null) {
                    cVar.f(aVar == null || aVar.a(refreshLayout));
                }
            }
        }
    }

    @Override // q3.a
    public void d(boolean z10, float f10, int i10, int i11, int i12) {
        c cVar = this.f18256h;
        if (z10) {
            if (cVar != null) {
                float f11 = this.f18251c;
                float f12 = this.f18253e;
                if (f11 < f12 && f10 >= f12) {
                    cVar.a(RefreshState.ReleaseToTwoLevel);
                } else if (cVar.c().getState() != RefreshState.ReleaseToTwoLevel) {
                    cVar.a(RefreshState.PullDownToRefresh);
                }
            }
            this.f18251c = f10;
        }
    }

    @NotNull
    public final TwoLevelHeader e() {
        c cVar = this.f18256h;
        if (cVar != null) {
            cVar.d();
        }
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof a) && getView() == ((a) obj).getView();
    }

    @NotNull
    public final TwoLevelHeader f(boolean z10) {
        c cVar = this.f18256h;
        if (cVar != null) {
            o3.a aVar = this.f18257i;
            cVar.f(!z10 || aVar == null || aVar.a(cVar.c()));
        }
        return this;
    }

    @NotNull
    public final TwoLevelHeader g(boolean z10) {
        c cVar = this.f18256h;
        this.f18255g = z10;
        if (cVar != null) {
            cVar.e(this, !z10);
        }
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f18250b;
    }

    @Override // q3.a
    @NotNull
    public b getSpinnerStyle() {
        b bVar = this.f18259k;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = b.f53261c;
        this.f18259k = bVar2;
        s.h(bVar2, "FixedBehind.also { mSpinnerStyle = it }");
        return bVar2;
    }

    @Override // q3.a
    @NotNull
    public View getView() {
        View view = this.f18258j;
        return view == null ? this : view;
    }

    @NotNull
    public final TwoLevelHeader h(@Nullable o3.a aVar) {
        this.f18257i = aVar;
        return this;
    }

    public int hashCode() {
        View view = this.f18258j;
        if (view != null) {
            return view.hashCode();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f18259k = b.f53262d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f18259k = b.f53261c;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(@NotNull View target, float f10, float f11, boolean z10) {
        s.i(target, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(@NotNull View target, float f10, float f11) {
        s.i(target, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(@NotNull View target, int i10, int i11, @NotNull int[] consumed) {
        s.i(target, "target");
        s.i(consumed, "consumed");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int i10, int i11, @NotNull int[] consumed, int i12) {
        s.i(target, "target");
        s.i(consumed, "consumed");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(@NotNull View target, int i10, int i11, int i12, int i13) {
        s.i(target, "target");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NotNull View target, int i10, int i11, int i12, int i13, int i14) {
        s.i(target, "target");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int i10) {
        s.i(child, "child");
        s.i(target, "target");
        this.f18250b = i10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int i10) {
        s.i(child, "child");
        s.i(target, "target");
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int i10, int i11) {
        s.i(child, "child");
        s.i(target, "target");
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(@NotNull View target) {
        s.i(target, "target");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View view, int i10) {
        s.i(view, "view");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int i10, int i11) {
        s.i(child, "child");
        s.i(target, "target");
        this.f18250b = i10;
    }

    public /* synthetic */ TwoLevelHeader(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
