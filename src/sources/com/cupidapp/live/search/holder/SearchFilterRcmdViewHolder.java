package com.cupidapp.live.search.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.IntelligentFilterKeywordResult;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.view.IntelligentFilterRcmdWordLayout;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SearchFilterRcmdViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchFilterRcmdViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17917c = new a(null);

    /* compiled from: SearchFilterRcmdViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchFilterRcmdViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SearchFilterRcmdViewHolder(z.b(parent, R$layout.item_search_filter_rcmd, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterRcmdViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof IntelligentFilterKeywordResult) {
            IntelligentFilterKeywordResult intelligentFilterKeywordResult = (IntelligentFilterKeywordResult) obj;
            Map<String, List<String>> matchKeywords = intelligentFilterKeywordResult.getMatchKeywords();
            if (matchKeywords != null && (matchKeywords.isEmpty() ^ true)) {
                ((ConstraintLayout) this.itemView.findViewById(R$id.root)).setVisibility(0);
                ((IntelligentFilterRcmdWordLayout) this.itemView.findViewById(R$id.search_filter_rcmd_layout)).f(intelligentFilterKeywordResult.getMatchKeywords(), new Function1<String, p>() { // from class: com.cupidapp.live.search.holder.SearchFilterRcmdViewHolder$config$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(String str) {
                        invoke2(str);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        s.i(it, "it");
                        EventBus.c().l(new MatchFilterKeyClickEvent(it, PurchaseProductType.SSVIP.getValue()));
                    }
                });
            } else {
                ((ConstraintLayout) this.itemView.findViewById(R$id.root)).setVisibility(8);
            }
        }
    }
}
