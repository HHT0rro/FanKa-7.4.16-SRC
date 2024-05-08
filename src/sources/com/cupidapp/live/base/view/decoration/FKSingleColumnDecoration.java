package com.cupidapp.live.base.view.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKSingleColumnDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSingleColumnDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f12671a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12672b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12673c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12674d;

    public FKSingleColumnDecoration() {
        this(0, 0, 0, 0, 15, null);
    }

    public /* synthetic */ FKSingleColumnDecoration(int i10, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? 0 : i13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        outRect.set(this.f12671a, this.f12672b, this.f12673c, this.f12674d);
    }

    public FKSingleColumnDecoration(int i10, int i11, int i12, int i13) {
        this.f12671a = i10;
        this.f12672b = i11;
        this.f12673c = i12;
        this.f12674d = i13;
    }
}
