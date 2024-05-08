package com.cupidapp.live.mediapicker.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MediaGridItemDecoration.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaGridItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f17420a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17421b;

    public MediaGridItemDecoration(int i10, boolean z10) {
        this.f17420a = i10;
        this.f17421b = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager == null) {
            return;
        }
        int orientation = gridLayoutManager.getOrientation();
        int spanCount = gridLayoutManager.getSpanCount();
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i10 = childAdapterPosition % spanCount;
        if (!this.f17421b) {
            if (orientation == 0) {
                if (childAdapterPosition >= spanCount) {
                    outRect.left = this.f17420a;
                }
                int i11 = this.f17420a;
                outRect.top = (i10 * i11) / spanCount;
                outRect.bottom = i11 - (((i10 + 1) * i11) / spanCount);
                return;
            }
            if (orientation != 1) {
                return;
            }
            int i12 = this.f17420a;
            outRect.left = (i10 * i12) / spanCount;
            outRect.right = i12 - (((i10 + 1) * i12) / spanCount);
            if (childAdapterPosition >= spanCount) {
                outRect.top = i12;
                return;
            }
            return;
        }
        if (orientation == 0) {
            if (childAdapterPosition < spanCount) {
                outRect.left = this.f17420a;
            }
            int i13 = this.f17420a;
            outRect.right = i13;
            outRect.top = i13 - ((i10 * i13) / spanCount);
            outRect.bottom = ((i10 + 1) * i13) / spanCount;
            return;
        }
        if (orientation != 1) {
            return;
        }
        int i14 = this.f17420a;
        outRect.left = i14 - ((i10 * i14) / spanCount);
        outRect.right = ((i10 + 1) * i14) / spanCount;
        if (childAdapterPosition < spanCount) {
            outRect.top = i14;
        }
        outRect.bottom = i14;
    }
}
