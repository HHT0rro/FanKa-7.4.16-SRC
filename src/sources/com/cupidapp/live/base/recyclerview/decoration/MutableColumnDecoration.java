package com.cupidapp.live.base.recyclerview.decoration;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import g1.a;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MutableColumnDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MutableColumnDecoration extends FKRecyclerViewDecoration {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final a f12086c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableColumnDecoration(@NotNull a decoration, int i10) {
        super(i10);
        s.i(decoration, "decoration");
        this.f12086c = decoration;
    }

    @Override // com.cupidapp.live.base.recyclerview.decoration.FKRecyclerViewDecoration
    public int c(int i10, int i11) {
        return this.f12086c.a(i10);
    }

    @Override // com.cupidapp.live.base.recyclerview.decoration.FKRecyclerViewDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        s.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        if (this.f12086c.b(((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition())) {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }
}
