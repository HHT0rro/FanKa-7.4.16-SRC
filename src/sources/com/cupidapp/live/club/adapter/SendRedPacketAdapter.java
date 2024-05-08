package com.cupidapp.live.club.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.club.model.ClubRedPacketModel;
import com.cupidapp.live.club.viewholder.SendRedPacketViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SendRedPacketAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendRedPacketAdapter extends FKBaseRecyclerViewAdapter {
    public SendRedPacketAdapter() {
        k().add(ClubRedPacketModel.class);
    }

    public final void u(@NotNull List<ClubRedPacketModel> list) {
        s.i(list, "list");
        j().clear();
        if (!list.isEmpty()) {
            list.get(0).setSelected(true);
        }
        e(list);
        notifyItemRangeInserted(0, list.size());
    }

    public final void v(@NotNull ClubRedPacketModel selectedModel) {
        s.i(selectedModel, "selectedModel");
        for (Object obj : j()) {
            if (obj instanceof ClubRedPacketModel) {
                ((ClubRedPacketModel) obj).setSelected(s.d(obj, selectedModel));
            }
        }
        notifyItemRangeChanged(0, j().size());
    }

    @Nullable
    public final ClubRedPacketModel w() {
        Object obj;
        Iterator<Object> iterator2 = j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            }
            obj = iterator2.next();
            if ((obj instanceof ClubRedPacketModel) && ((ClubRedPacketModel) obj).isSelected()) {
                break;
            }
        }
        if (obj instanceof ClubRedPacketModel) {
            return (ClubRedPacketModel) obj;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        SendRedPacketViewHolder a10 = SendRedPacketViewHolder.f13697c.a(parent);
        a10.k(l());
        return a10;
    }
}
