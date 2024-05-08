package com.cupidapp.live.setting.helper;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.setting.holder.EditUserAvatarUiModel;
import com.cupidapp.live.setting.holder.EditUserAvatarViewHolder;
import java.util.Collections;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AvatarsTouchHelperCallback.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AvatarsTouchHelperCallback extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18177a;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean canDropOver(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder current, @NotNull RecyclerView.ViewHolder target) {
        s.i(recyclerView, "recyclerView");
        s.i(current, "current");
        s.i(target, "target");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof FKBaseRecyclerViewAdapter) {
            return ((FKBaseRecyclerViewAdapter) adapter).j().get(target.getAdapterPosition()) instanceof EditUserAvatarUiModel;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        s.i(recyclerView, "recyclerView");
        s.i(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof EditUserAvatarViewHolder) {
            ((EditUserAvatarViewHolder) viewHolder).r(this.f18177a);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        s.i(recyclerView, "recyclerView");
        s.i(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeFlag(2, 15);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        s.i(recyclerView, "recyclerView");
        s.i(viewHolder, "viewHolder");
        s.i(target, "target");
        this.f18177a = false;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof FKBaseRecyclerViewAdapter) {
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if (adapterPosition < adapterPosition2) {
                int i10 = adapterPosition;
                while (i10 < adapterPosition2) {
                    int i11 = i10 + 1;
                    Collections.swap((List<?>) ((FKBaseRecyclerViewAdapter) adapter).j(), i10, i11);
                    i10 = i11;
                }
            } else {
                int i12 = adapterPosition2 + 1;
                if (i12 <= adapterPosition) {
                    int i13 = adapterPosition;
                    while (true) {
                        Collections.swap((List<?>) ((FKBaseRecyclerViewAdapter) adapter).j(), i13, i13 - 1);
                        if (i13 == i12) {
                            break;
                        }
                        i13--;
                    }
                }
            }
            ((FKBaseRecyclerViewAdapter) adapter).notifyItemMoved(adapterPosition, adapterPosition2);
            this.f18177a = true;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i10) {
        super.onSelectedChanged(viewHolder, i10);
        if (viewHolder instanceof EditUserAvatarViewHolder) {
            ((EditUserAvatarViewHolder) viewHolder).s();
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int i10) {
        s.i(viewHolder, "viewHolder");
    }
}
