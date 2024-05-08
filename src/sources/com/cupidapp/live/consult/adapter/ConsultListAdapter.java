package com.cupidapp.live.consult.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.consult.model.ConsultListModel;
import com.cupidapp.live.consult.viewholder.ConsultBannerListModel;
import com.cupidapp.live.consult.viewholder.ConsultBannerViewHolder;
import com.cupidapp.live.consult.viewholder.ConsultListViewHolder;
import com.cupidapp.live.profile.model.User;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsultListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultListAdapter extends MutableColumnRecyclerAdapter {
    public ConsultListAdapter() {
        k().add(ConsultListModel.class);
        k().add(ConsultBannerListModel.class);
        k().add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof ConsultListModel)) {
            return v();
        }
        return 1;
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
        if (i10 == 0) {
            a10 = ConsultListViewHolder.f13895c.a(parent);
        } else if (i10 != 1) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = ConsultBannerViewHolder.f13893c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void y(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        t(new RecyclerExposureHelper(ExposureScene.ConsultList, recyclerView, 0.0f, 0L, null, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.consult.adapter.ConsultListAdapter$setExposureHelper$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> list) {
                s.i(list, "list");
                Iterator<a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof ConsultListModel) {
                        z3.a aVar = z3.a.f54827a;
                        ConsultListModel consultListModel = (ConsultListModel) a10;
                        String id2 = consultListModel.getId();
                        User user = consultListModel.getUser();
                        aVar.f(id2, user != null ? user.userId() : null, SensorPosition.ConsultList.getValue(), consultListModel.getViewerCount(), consultListModel.getChating(), consultListModel.getCategory());
                    }
                }
            }
        }, 28, null));
    }
}
