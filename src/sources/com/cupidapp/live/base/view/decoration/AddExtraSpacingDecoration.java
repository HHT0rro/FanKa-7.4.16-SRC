package com.cupidapp.live.base.view.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SingleColumnDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AddExtraSpacingDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f12660a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12661b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12662c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12663d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12664e;

    public AddExtraSpacingDecoration() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public /* synthetic */ AddExtraSpacingDecoration(int i10, int i11, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? 0 : i10, (i15 & 2) != 0 ? 0 : i11, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
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
                        outRect.set(this.f12660a + this.f12664e, this.f12661b, this.f12662c, this.f12663d);
                        return;
                    } else if (childAdapterPosition == itemCount - 1) {
                        outRect.set(this.f12660a, this.f12661b, this.f12662c + this.f12664e, this.f12663d);
                        return;
                    } else {
                        outRect.set(this.f12660a, this.f12661b, this.f12662c, this.f12663d);
                        return;
                    }
                }
                if (linearLayoutManager.getOrientation() == 1) {
                    if (childAdapterPosition == 0) {
                        outRect.set(this.f12660a, this.f12661b + this.f12664e, this.f12662c, this.f12663d);
                        return;
                    } else if (childAdapterPosition == itemCount - 1) {
                        outRect.set(this.f12660a, this.f12661b, this.f12662c, this.f12663d + this.f12664e);
                        return;
                    } else {
                        outRect.set(this.f12660a, this.f12661b, this.f12662c, this.f12663d);
                        return;
                    }
                }
                return;
            }
            return;
        }
        super.getItemOffsets(outRect, view, parent, state);
    }

    public AddExtraSpacingDecoration(int i10, int i11, int i12, int i13, int i14) {
        this.f12660a = i10;
        this.f12661b = i11;
        this.f12662c = i12;
        this.f12663d = i13;
        this.f12664e = i14;
    }
}
