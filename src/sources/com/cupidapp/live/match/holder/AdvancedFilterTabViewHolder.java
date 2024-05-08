package com.cupidapp.live.match.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.adapter.FKAdvancedAdapter;
import com.cupidapp.live.match.model.AdvanceFilterUiModel;
import com.cupidapp.live.match.model.IntelligentFilterUiModel;
import com.cupidapp.live.match.view.IntelligentFilterKeywordLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AdvancedFilterTabViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AdvancedFilterTabViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16781e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16782c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final FKAdvancedAdapter f16783d;

    /* compiled from: AdvancedFilterTabViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AdvancedFilterTabViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new AdvancedFilterTabViewHolder(z.b(parent, R$layout.item_filter_advanced, false, 2, null), z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedFilterTabViewHolder(@NotNull View itemView, boolean z10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16782c = z10;
        FKAdvancedAdapter fKAdvancedAdapter = new FKAdvancedAdapter();
        Map<Integer, Function1<Object, p>> d10 = fKAdvancedAdapter.l().d();
        d10.put(Integer.valueOf(R$id.intelligent_filter_enter_stroke), new Function1<Object, p>() { // from class: com.cupidapp.live.match.holder.AdvancedFilterTabViewHolder$matchFilterAdapter$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof IntelligentFilterUiModel) {
                    AdvancedFilterTabViewHolder advancedFilterTabViewHolder = AdvancedFilterTabViewHolder.this;
                    List<String> matchKeywords = ((IntelligentFilterUiModel) obj).getMatchKeywords();
                    advancedFilterTabViewHolder.v(matchKeywords != null ? (String) CollectionsKt___CollectionsKt.V(matchKeywords) : null);
                }
            }
        });
        d10.put(Integer.valueOf(R$id.intelligent_filter_enter_delete), new Function1<Object, p>() { // from class: com.cupidapp.live.match.holder.AdvancedFilterTabViewHolder$matchFilterAdapter$1$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof IntelligentFilterUiModel) {
                    AdvancedFilterTabViewHolder.this.x(null);
                }
            }
        });
        this.f16783d = fKAdvancedAdapter;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AdvanceFilterUiModel) {
            View view = this.itemView;
            int i10 = R$id.recyclerView;
            ((RecyclerView) view.findViewById(i10)).setLayoutManager(new LinearLayoutManager(this.itemView.getContext()));
            ((RecyclerView) this.itemView.findViewById(i10)).setAdapter(this.f16783d);
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) this.itemView.findViewById(i10)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            u((AdvanceFilterUiModel) obj);
        }
    }

    public final IntelligentFilterUiModel t() {
        Object obj;
        Iterator<Object> iterator2 = this.f16783d.j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            }
            obj = iterator2.next();
            if (obj instanceof IntelligentFilterUiModel) {
                break;
            }
        }
        return (IntelligentFilterUiModel) obj;
    }

    public final void u(AdvanceFilterUiModel advanceFilterUiModel) {
        this.f16783d.j().clear();
        this.f16783d.e(advanceFilterUiModel.getList());
        this.f16783d.v(advanceFilterUiModel.getLimitTimeReward(), this.f16782c);
        this.f16783d.notifyDataSetChanged();
    }

    public final void v(String str) {
        IntelligentFilterKeywordLayout.a aVar = IntelligentFilterKeywordLayout.f16931g;
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        aVar.b(context, str, this.f16782c, new Function1<String, p>() { // from class: com.cupidapp.live.match.holder.AdvancedFilterTabViewHolder$showIntelligentFilterKeywordDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str2) {
                invoke2(str2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String keyword) {
                s.i(keyword, "keyword");
                AdvancedFilterTabViewHolder.this.x(keyword);
            }
        });
    }

    public final void w(@Nullable String str) {
        List<String> e2 = str == null || str.length() == 0 ? null : r.e(str);
        IntelligentFilterUiModel t2 = t();
        if (t2 != null) {
            t2.setMatchKeywords(e2);
        }
        this.f16783d.w(e2);
    }

    public final void x(String str) {
        List<String> e2 = str == null || str.length() == 0 ? null : r.e(str);
        IntelligentFilterUiModel t2 = t();
        if (t2 != null) {
            t2.setMatchKeywords(e2);
        }
        this.f16783d.w(e2);
    }
}
