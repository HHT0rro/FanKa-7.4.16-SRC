package com.cupidapp.live.base.view.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SingleColumnDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SingleColumnDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f12679a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12680b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12681c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12682d;

    public SingleColumnDecoration() {
        this(0, 0, 0, 0, 15, null);
    }

    public /* synthetic */ SingleColumnDecoration(int i10, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? 0 : i13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        outRect.set(this.f12679a, this.f12680b, this.f12681c, this.f12682d);
    }

    public SingleColumnDecoration(int i10, int i11, int i12, int i13) {
        this.f12679a = i10;
        this.f12680b = i11;
        this.f12681c = i12;
        this.f12682d = i13;
    }
}
