package com.cupidapp.live.liveshow.fanclub.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.view.music.view.FKConflictListRecyclerView;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKFanClubForAnchorAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubTaskProgressViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14958d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f14959c;

    /* compiled from: FKFanClubForAnchorAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFanClubTaskProgressViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKFanClubTaskProgressViewHolder(z.b(parent, R$layout.view_holder_fan_club_task_progress, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFanClubTaskProgressViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14959c = c.b(new Function0<FKFanClubTaskProgressAdapter>() { // from class: com.cupidapp.live.liveshow.fanclub.adapter.FKFanClubTaskProgressViewHolder$progressAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKFanClubTaskProgressAdapter invoke() {
                return new FKFanClubTaskProgressAdapter();
            }
        });
        FKConflictListRecyclerView fKConflictListRecyclerView = (FKConflictListRecyclerView) itemView.findViewById(R$id.taskProgressRecyclerView);
        fKConflictListRecyclerView.setAdapter(r());
        fKConflictListRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), 1, false));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKTaskProgressModel) {
            r().e(((FKTaskProgressModel) obj).getList());
            r().notifyItemRangeChanged(0, r().getItemCount());
        }
    }

    public final FKFanClubTaskProgressAdapter r() {
        return (FKFanClubTaskProgressAdapter) this.f14959c.getValue();
    }
}
