package com.cupidapp.live.mediapicker.helper;

import android.graphics.Canvas;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.mediapicker.holder.ImageEditViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: ImageEditTouchHelperCallback.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageEditTouchHelperCallback extends ItemTouchHelper.Callback {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17231c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public b f17232a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17233b;

    /* compiled from: ImageEditTouchHelperCallback.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ImageEditTouchHelperCallback.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(float f10);

        void b(@NotNull RecyclerView.ViewHolder viewHolder);

        void c(@Nullable RecyclerView.ViewHolder viewHolder, int i10);
    }

    public final void a(@NotNull b listener) {
        s.i(listener, "listener");
        this.f17232a = listener;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        s.i(recyclerView, "recyclerView");
        s.i(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        this.f17233b = false;
        b bVar = this.f17232a;
        if (bVar != null) {
            bVar.c(viewHolder, 5);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(@NotNull RecyclerView recyclerView, int i10, float f10, float f11) {
        s.i(recyclerView, "recyclerView");
        this.f17233b = true;
        return super.getAnimationDuration(recyclerView, i10, f10, f11);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        s.i(recyclerView, "recyclerView");
        s.i(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(@NotNull Canvas c4, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float f10, float f11, int i10, boolean z10) {
        s.i(c4, "c");
        s.i(recyclerView, "recyclerView");
        s.i(viewHolder, "viewHolder");
        super.onChildDraw(c4, recyclerView, viewHolder, f10, f11, i10, z10);
        float v2 = viewHolder instanceof ImageEditViewHolder ? ((ImageEditViewHolder) viewHolder).v() : h.c(this, 100.0f);
        if (f11 >= v2) {
            if (this.f17233b) {
                b bVar = this.f17232a;
                if (bVar != null) {
                    bVar.b(viewHolder);
                }
                this.f17233b = false;
            }
            b bVar2 = this.f17232a;
            if (bVar2 != null) {
                bVar2.c(viewHolder, 3);
                return;
            }
            return;
        }
        b bVar3 = this.f17232a;
        if (bVar3 != null) {
            bVar3.c(viewHolder, 4);
        }
        b bVar4 = this.f17232a;
        if (bVar4 != null) {
            bVar4.a(f11 / v2);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        s.i(recyclerView, "recyclerView");
        s.i(viewHolder, "viewHolder");
        s.i(target, "target");
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i10) {
        b bVar;
        super.onSelectedChanged(viewHolder, i10);
        if (i10 != 0) {
            if (i10 == 2 && (bVar = this.f17232a) != null) {
                bVar.c(viewHolder, 2);
                return;
            }
            return;
        }
        b bVar2 = this.f17232a;
        if (bVar2 != null) {
            bVar2.c(viewHolder, 0);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int i10) {
        s.i(viewHolder, "viewHolder");
    }
}
