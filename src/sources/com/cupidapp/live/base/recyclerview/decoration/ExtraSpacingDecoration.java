package com.cupidapp.live.base.recyclerview.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ExtraSpacingDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExtraSpacingDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public int f12078a;

    /* renamed from: b, reason: collision with root package name */
    public int f12079b;

    /* renamed from: c, reason: collision with root package name */
    public int f12080c;

    /* renamed from: d, reason: collision with root package name */
    public int f12081d;

    /* renamed from: e, reason: collision with root package name */
    public int f12082e;

    /* renamed from: f, reason: collision with root package name */
    public int f12083f;

    public ExtraSpacingDecoration(int i10, int i11, int i12, int i13, int i14) {
        this.f12078a = i10;
        this.f12079b = i11;
        this.f12080c = i12;
        this.f12081d = i13;
        this.f12082e = i14;
        this.f12083f = i14;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager.getOrientation() == 0) {
                    if (childAdapterPosition == 0) {
                        outRect.set(this.f12078a + this.f12082e, this.f12079b, this.f12080c, this.f12081d);
                        return;
                    } else if (childAdapterPosition == itemCount - 1) {
                        outRect.set(this.f12078a, this.f12079b, this.f12080c + this.f12083f, this.f12081d);
                        return;
                    } else {
                        outRect.set(this.f12078a, this.f12079b, this.f12080c, this.f12081d);
                        return;
                    }
                }
                if (linearLayoutManager.getOrientation() == 1) {
                    if (childAdapterPosition == 0) {
                        outRect.set(this.f12078a, this.f12079b + this.f12082e, this.f12080c, this.f12081d);
                        return;
                    } else if (childAdapterPosition == itemCount - 1) {
                        outRect.set(this.f12078a, this.f12079b, this.f12080c, this.f12081d + this.f12083f);
                        return;
                    } else {
                        outRect.set(this.f12078a, this.f12079b, this.f12080c, this.f12081d);
                        return;
                    }
                }
                return;
            }
            return;
        }
        super.getItemOffsets(outRect, view, parent, state);
    }

    public /* synthetic */ ExtraSpacingDecoration(int i10, int i11, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, i12, i13, (i15 & 16) != 0 ? 0 : i14);
    }

    public ExtraSpacingDecoration(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f12078a = i10;
        this.f12079b = i11;
        this.f12080c = i12;
        this.f12081d = i13;
        this.f12082e = i14;
        this.f12083f = i15;
    }
}
