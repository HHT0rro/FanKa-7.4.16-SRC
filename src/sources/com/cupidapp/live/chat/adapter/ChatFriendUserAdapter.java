package com.cupidapp.live.chat.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.chat.service.ChatStateEntranceModel;
import com.cupidapp.live.chat.service.SuperBoostEntranceModel;
import com.cupidapp.live.chat.viewholder.ChatStateEntranceViewHolder;
import com.cupidapp.live.chat.viewholder.FKNewMatchUserItemViewHolder;
import com.cupidapp.live.chat.viewholder.NewMatchUserModel;
import com.cupidapp.live.chat.viewholder.SuperBoostEntranceViewHolder;
import com.cupidapp.live.track.group.GroupSocialLog;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatFriendUserAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatFriendUserAdapter extends FKBaseRecyclerViewAdapter {
    public ChatFriendUserAdapter(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        k().add(ChatStateEntranceModel.class);
        k().add(SuperBoostEntranceModel.class);
        k().add(NewMatchUserModel.class);
        t(new RecyclerExposureHelper(ExposureScene.NewMatchList, recyclerView, 0.0f, 0L, null, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.chat.adapter.ChatFriendUserAdapter.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                s.i(itemList, "itemList");
                Iterator<a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof NewMatchUserModel) {
                        NewMatchUserModel newMatchUserModel = (NewMatchUserModel) a10;
                        GroupSocialLog.f18708a.t(newMatchUserModel.getUser().userId(), newMatchUserModel.getUser().getNewMatch(), newMatchUserModel.getUser().getTag());
                    }
                }
            }
        }, 28, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = ChatStateEntranceViewHolder.f13249c.a(parent);
        } else if (i10 != 1) {
            a10 = FKNewMatchUserItemViewHolder.f13253c.a(parent);
        } else {
            a10 = SuperBoostEntranceViewHolder.f13258c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
