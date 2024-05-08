package com.cupidapp.live.match.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.model.IntelligentFilterUiModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.UpdateFilterKeyWordEvent;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: IntelligentFilterNewViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class IntelligentFilterNewViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16800d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16801c;

    /* compiled from: IntelligentFilterNewViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntelligentFilterNewViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new IntelligentFilterNewViewHolder(z.b(parent, R$layout.item_intelligent_filter_new, false, 2, null), z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentFilterNewViewHolder(@NotNull View itemView, boolean z10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16801c = z10;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        List t02;
        if (obj instanceof IntelligentFilterUiModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.intelligent_filter_enter_title);
            s.h(textView, "itemView.intelligent_filter_enter_title");
            u.a(textView);
            IntelligentFilterUiModel intelligentFilterUiModel = (IntelligentFilterUiModel) obj;
            List<String> matchKeywords = intelligentFilterUiModel.getMatchKeywords();
            String str = matchKeywords != null ? (String) CollectionsKt___CollectionsKt.V(matchKeywords) : null;
            if (str == null || str.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.intelligent_filter_enter_tips)).setVisibility(0);
                ((ConstraintLayout) this.itemView.findViewById(R$id.intelligent_filter_enter_keyword_layout)).setVisibility(8);
            } else {
                ((TextView) this.itemView.findViewById(R$id.intelligent_filter_enter_tips)).setVisibility(8);
                ((ConstraintLayout) this.itemView.findViewById(R$id.intelligent_filter_enter_keyword_layout)).setVisibility(0);
                TextView textView2 = (TextView) this.itemView.findViewById(R$id.intelligent_filter_enter_keyword);
                List<String> matchKeywords2 = intelligentFilterUiModel.getMatchKeywords();
                textView2.setText(matchKeywords2 != null ? (String) CollectionsKt___CollectionsKt.V(matchKeywords2) : null);
            }
            List<String> recommendWords = intelligentFilterUiModel.getRecommendWords();
            if (recommendWords != null && (recommendWords.isEmpty() ^ true)) {
                ((TextView) this.itemView.findViewById(R$id.people_search)).setVisibility(0);
                View view = this.itemView;
                int i10 = R$id.search_key_linear;
                ((LinearLayout) view.findViewById(i10)).setVisibility(0);
                ((LinearLayout) this.itemView.findViewById(i10)).removeAllViews();
                List<String> recommendWords2 = intelligentFilterUiModel.getRecommendWords();
                if (recommendWords2 == null || (t02 = CollectionsKt___CollectionsKt.t0(recommendWords2, 4)) == null) {
                    return;
                }
                Iterator<E> iterator2 = t02.iterator2();
                while (iterator2.hasNext()) {
                    View s2 = s((String) iterator2.next());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                    layoutParams.setMarginEnd(h.c(layoutParams, 6.0f));
                    s2.setLayoutParams(layoutParams);
                    ((LinearLayout) this.itemView.findViewById(R$id.search_key_linear)).addView(s2);
                }
                return;
            }
            ((TextView) this.itemView.findViewById(R$id.people_search)).setVisibility(8);
            ((LinearLayout) this.itemView.findViewById(R$id.search_key_linear)).setVisibility(8);
        }
    }

    public final View s(final String str) {
        View itemView = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.item_intelligent_rcmd_word, (ViewGroup) this.itemView.findViewById(R$id.search_key_linear), false);
        TextView textView = (TextView) itemView.findViewById(R$id.item_con_txt);
        s.h(textView, "textView");
        u.a(textView);
        textView.setText(str);
        s.h(itemView, "itemView");
        y.d(itemView, new Function1<View, p>() { // from class: com.cupidapp.live.match.holder.IntelligentFilterNewViewHolder$getItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                boolean z10;
                if (!c.f17839a.b()) {
                    z10 = IntelligentFilterNewViewHolder.this.f16801c;
                    if (z10) {
                        EventBus.c().l(new ShowPurchaseDialogEvent(VipPurchaseEntranceType.IntelligentFilterInMatch, null, PurchaseProductType.SSVIP));
                        return;
                    }
                }
                EventBus.c().l(new UpdateFilterKeyWordEvent(str));
            }
        });
        return itemView;
    }
}