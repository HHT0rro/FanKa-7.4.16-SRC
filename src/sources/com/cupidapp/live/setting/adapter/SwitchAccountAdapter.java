package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.setting.holder.AddSwitchAccountUiModel;
import com.cupidapp.live.setting.holder.AddSwitchAccountViewHolder;
import com.cupidapp.live.setting.holder.SwitchAccountUserViewHolder;
import com.cupidapp.live.setting.model.SwitchAccountUserModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwitchAccountAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f18099f = new a(null);

    /* compiled from: SwitchAccountAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SwitchAccountAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(SwitchAccountUserModel.class);
        k10.add(AddSwitchAccountUiModel.class);
    }

    public final void u(@NotNull List<SwitchAccountUserModel> list, @Nullable SensorPosition sensorPosition) {
        s.i(list, "list");
        j().clear();
        Iterator<SwitchAccountUserModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().setSensorPosition(sensorPosition);
        }
        j().addAll(list);
        notifyItemRangeInserted(0, list.size());
        AddSwitchAccountUiModel addSwitchAccountUiModel = new AddSwitchAccountUiModel(list.size() < 4);
        int size = j().size();
        j().add(size, addSwitchAccountUiModel);
        notifyItemChanged(size);
    }

    public final void v(boolean z10) {
        int i10;
        Iterator<Object> iterator2 = j().iterator2();
        while (true) {
            if (iterator2.hasNext()) {
                Object next = iterator2.next();
                if (next instanceof SwitchAccountUserModel) {
                    ((SwitchAccountUserModel) next).setRemoveState(z10);
                }
                if (next instanceof AddSwitchAccountUiModel) {
                    if (z10) {
                        ((AddSwitchAccountUiModel) next).setVisible(false);
                    } else {
                        List<Object> j10 = j();
                        if ((j10 instanceof Collection) && j10.isEmpty()) {
                            i10 = 0;
                        } else {
                            Iterator<Object> iterator22 = j10.iterator2();
                            i10 = 0;
                            while (iterator22.hasNext()) {
                                if ((iterator22.next() instanceof SwitchAccountUserModel) && (i10 = i10 + 1) < 0) {
                                    kotlin.collections.s.r();
                                }
                            }
                        }
                        ((AddSwitchAccountUiModel) next).setVisible(i10 < 4);
                    }
                }
            } else {
                notifyItemRangeChanged(0, j().size());
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = SwitchAccountUserViewHolder.f18196c.a(parent);
        } else if (i10 != 1) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = AddSwitchAccountViewHolder.f18187c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void x(@NotNull SwitchAccountUserModel model) {
        s.i(model, "model");
        int indexOf = j().indexOf(model);
        if (f(indexOf)) {
            j().remove(indexOf);
            notifyItemRemoved(indexOf);
        }
    }
}
