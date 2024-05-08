package com.cupidapp.live.base.view.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKSingleColumnDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKAddExtraSpacingDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f12665a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12666b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12667c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12668d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12669e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12670f;

    public FKAddExtraSpacingDecoration() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public /* synthetic */ FKAddExtraSpacingDecoration(int i10, int i11, int i12, int i13, int i14, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i10, (i16 & 2) != 0 ? 0 : i11, (i16 & 4) != 0 ? 0 : i12, (i16 & 8) != 0 ? 0 : i13, (i16 & 16) != 0 ? 0 : i14, (i16 & 32) != 0 ? 0 : i15);
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
                        outRect.set(this.f12665a + this.f12669e, this.f12666b, this.f12667c, this.f12668d);
                        return;
                    } else if (childAdapterPosition == itemCount - 1) {
                        outRect.set(this.f12665a, this.f12666b, this.f12667c + this.f12669e + this.f12670f, this.f12668d);
                        return;
                    } else {
                        outRect.set(this.f12665a, this.f12666b, this.f12667c, this.f12668d);
                        return;
                    }
                }
                if (linearLayoutManager.getOrientation() == 1) {
                    if (childAdapterPosition == 0) {
                        outRect.set(this.f12665a, this.f12666b + this.f12669e, this.f12667c, this.f12668d);
                        return;
                    } else if (childAdapterPosition == itemCount - 1) {
                        outRect.set(this.f12665a, this.f12666b, this.f12667c, this.f12668d + this.f12669e + this.f12670f);
                        return;
                    } else {
                        outRect.set(this.f12665a, this.f12666b, this.f12667c, this.f12668d);
                        return;
                    }
                }
                return;
            }
            return;
        }
        super.getItemOffsets(outRect, view, parent, state);
    }

    public FKAddExtraSpacingDecoration(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f12665a = i10;
        this.f12666b = i11;
        this.f12667c = i12;
        this.f12668d = i13;
        this.f12669e = i14;
        this.f12670f = i15;
    }
}
