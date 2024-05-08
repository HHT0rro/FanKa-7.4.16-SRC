package com.cupidapp.live.search.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.AddressModel;
import com.cupidapp.live.match.model.IntelligentFilterKeywordResult;
import com.cupidapp.live.match.model.SVipKeywordOptionModel;
import com.cupidapp.live.search.holder.SVipKeywordOptionViewHolder;
import com.cupidapp.live.search.holder.SearchFilterRcmdViewHolder;
import com.cupidapp.live.search.holder.SearchHotLocationViewHolder;
import com.cupidapp.live.search.holder.SearchUserViewHolder;
import com.cupidapp.live.search.model.SearchModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SearchResultAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchResultAdapter extends FKBaseRecyclerViewAdapter {
    public SearchResultAdapter() {
        k().add(SearchModel.class);
        k().add(IntelligentFilterKeywordResult.class);
        k().add(SVipKeywordOptionModel.class);
        k().add(AddressModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = SearchUserViewHolder.f17919c.a(parent);
        } else if (i10 == 1) {
            a10 = SearchFilterRcmdViewHolder.f17917c.a(parent);
        } else if (i10 != 3) {
            a10 = SVipKeywordOptionViewHolder.f17916c.a(parent);
        } else {
            a10 = SearchHotLocationViewHolder.f17918c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
