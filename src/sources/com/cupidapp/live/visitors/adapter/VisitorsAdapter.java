package com.cupidapp.live.visitors.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.visitors.model.RenewViewModel;
import com.cupidapp.live.visitors.model.VisitorsSquareStyleModel;
import com.cupidapp.live.visitors.model.VisitorsStripStyleModel;
import com.cupidapp.live.visitors.model.VisitorsTitleModel;
import com.cupidapp.live.visitors.model.VisitorsViewModel;
import com.cupidapp.live.visitors.viewholder.RenewViewHolder;
import com.cupidapp.live.visitors.viewholder.VisitorMarketingUIModel;
import com.cupidapp.live.visitors.viewholder.VisitorMarksViewHolder;
import com.cupidapp.live.visitors.viewholder.VisitorsSquareStyleViewHolder;
import com.cupidapp.live.visitors.viewholder.VisitorsStripStyleViewHolder;
import com.cupidapp.live.visitors.viewholder.VisitorsTitleViewHolder;
import com.cupidapp.live.visitors.viewholder.VisitorsViewHolder;
import com.cupidapp.live.visitors.viewholder.a;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsAdapter extends MutableColumnRecyclerAdapter {

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final a f18937g;

    public VisitorsAdapter(@Nullable a aVar) {
        this.f18937g = aVar;
        List<Class<? extends Object>> k10 = k();
        k10.add(RenewViewModel.class);
        k10.add(VisitorsViewModel.class);
        k10.add(FKEmptyViewModel.class);
        k10.add(VisitorMarketingUIModel.class);
        k10.add(VisitorsTitleModel.class);
        k10.add(VisitorsSquareStyleModel.class);
        k10.add(VisitorsStripStyleModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 < 0) {
            return v();
        }
        if (j().get(i10) instanceof VisitorsSquareStyleModel) {
            return 1;
        }
        return v();
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        switch (i10) {
            case 0:
                a10 = RenewViewHolder.f18964c.a(parent);
                break;
            case 1:
                a10 = VisitorsViewHolder.f18970c.a(parent);
                break;
            case 2:
                a10 = FKEmptyListViewHolder.f12034c.a(parent);
                break;
            case 3:
                a10 = VisitorMarksViewHolder.f18965d.a(parent, this.f18937g);
                break;
            case 4:
                a10 = VisitorsTitleViewHolder.f18969c.a(parent);
                break;
            case 5:
                a10 = VisitorsSquareStyleViewHolder.f18967c.a(parent);
                break;
            case 6:
                a10 = VisitorsStripStyleViewHolder.f18968c.a(parent);
                break;
            default:
                a10 = FKFooterViewHolder.f12036c.a(parent);
                break;
        }
        a10.k(l());
        return a10;
    }
}
