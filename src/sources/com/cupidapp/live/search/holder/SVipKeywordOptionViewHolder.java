package com.cupidapp.live.search.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.FKSVipImgLayout;
import com.cupidapp.live.match.model.KeyWordOptionModel;
import com.cupidapp.live.match.model.SVipKeywordOptionModel;
import com.cupidapp.live.match.view.IntelligentFilterRcmdWordLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SVipKeywordOptionViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SVipKeywordOptionViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17916c = new a(null);

    /* compiled from: SVipKeywordOptionViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SVipKeywordOptionViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SVipKeywordOptionViewHolder(z.b(parent, R$layout.item_svip_keyword_option, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVipKeywordOptionViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof SVipKeywordOptionModel) {
            SVipKeywordOptionModel sVipKeywordOptionModel = (SVipKeywordOptionModel) obj;
            ((TextView) this.itemView.findViewById(R$id.search_filter_tip)).setText(sVipKeywordOptionModel.getTitle());
            Map<String, List<KeyWordOptionModel>> options = sVipKeywordOptionModel.getOptions();
            if (options != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, List<KeyWordOptionModel>> entry : options.entrySet()) {
                    String key = entry.getKey();
                    List<KeyWordOptionModel> value = entry.getValue();
                    ArrayList arrayList = new ArrayList(t.t(value, 10));
                    Iterator<KeyWordOptionModel> iterator2 = value.iterator2();
                    while (iterator2.hasNext()) {
                        arrayList.add(iterator2.next().getLabel());
                    }
                    linkedHashMap.put(key, arrayList);
                }
                ((IntelligentFilterRcmdWordLayout) this.itemView.findViewById(R$id.search_filter_rcmd_layout)).f(linkedHashMap, new Function1<String, p>() { // from class: com.cupidapp.live.search.holder.SVipKeywordOptionViewHolder$config$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(String str) {
                        invoke2(str);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        s.i(it, "it");
                        EventBus.c().l(new MatchFilterKeyClickEvent(it, ((SVipKeywordOptionModel) Object.this).getProductType()));
                    }
                });
            }
            FKSVipImgLayout fKSVipImgLayout = (FKSVipImgLayout) this.itemView.findViewById(R$id.svip_img_layout);
            s.h(fKSVipImgLayout, "itemView.svip_img_layout");
            FKSVipImgLayout.g(fKSVipImgLayout, sVipKeywordOptionModel.getProductType(), null, 2, null);
        }
    }
}
