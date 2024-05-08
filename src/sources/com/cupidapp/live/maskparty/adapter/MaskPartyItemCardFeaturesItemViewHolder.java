package com.cupidapp.live.maskparty.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.ItemCardType;
import com.cupidapp.live.maskparty.model.RoleType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: MaskPartyItemCardFeaturesAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardFeaturesItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16256c = new a(null);

    /* compiled from: MaskPartyItemCardFeaturesAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MaskPartyItemCardFeaturesItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MaskPartyItemCardFeaturesItemViewHolder(z.b(parent, R$layout.view_holder_mask_party_item_card_features_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardFeaturesItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.features_title_textview)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.user_item_card_textview)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String string;
        if (obj instanceof ItemCardFeaturesItemModel) {
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            ItemCardFeaturesItemModel itemCardFeaturesItemModel = (ItemCardFeaturesItemModel) obj;
            y.i(itemView, (r18 & 1) != 0 ? 0.0f : h.c(this, 8.0f), kotlin.collections.s.m(Integer.valueOf(com.cupidapp.live.base.utils.h.a(-9603585, 0.16f)), Integer.valueOf(com.cupidapp.live.base.utils.h.a(-3514113, 0.16f))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR, (r18 & 8) != 0 ? null : itemCardFeaturesItemModel.getSelected() ? Integer.valueOf(h.c(this, 2.0f)) : null, (r18 & 16) != 0 ? null : itemCardFeaturesItemModel.getSelected() ? -7442689 : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            ((ImageLoaderView) this.itemView.findViewById(R$id.features_imageview)).setImageResource(itemCardFeaturesItemModel.getBigIcon());
            ((TextView) this.itemView.findViewById(R$id.features_title_textview)).setText(this.itemView.getContext().getString(itemCardFeaturesItemModel.getTitle()));
            ((TextView) this.itemView.findViewById(R$id.features_content_textview)).setText(this.itemView.getContext().getString(itemCardFeaturesItemModel.getContent()));
            if (itemCardFeaturesItemModel.getType() == ItemCardType.AttackMatch) {
                View view = this.itemView;
                int i10 = R$id.choose_role_textview;
                TextView textView = (TextView) view.findViewById(i10);
                s.h(textView, "itemView.choose_role_textview");
                textView.setVisibility(0);
                List<RoleType> O0 = g.f52734a.O0();
                if (!(O0 == null || O0.isEmpty())) {
                    if (O0.size() <= 1) {
                        ((TextView) this.itemView.findViewById(i10)).setText(((RoleType) CollectionsKt___CollectionsKt.T(O0)).getValue());
                    } else {
                        TextView textView2 = (TextView) this.itemView.findViewById(i10);
                        Context context = this.itemView.getContext();
                        Object[] objArr = new Object[1];
                        ArrayList arrayList = new ArrayList(t.t(O0, 10));
                        Iterator<RoleType> iterator2 = O0.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(iterator2.next().getValue());
                        }
                        Iterator<E> iterator22 = arrayList.iterator2();
                        if (iterator22.hasNext()) {
                            Object next = iterator22.next();
                            while (iterator22.hasNext()) {
                                next = ((String) next) + "," + ((String) iterator22.next());
                            }
                            objArr[0] = next;
                            textView2.setText(context.getString(R$string.choose_roles, objArr));
                        } else {
                            throw new UnsupportedOperationException("Empty collection can't be reduced.");
                        }
                    }
                } else {
                    ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.choose_role));
                }
            } else {
                TextView textView3 = (TextView) this.itemView.findViewById(R$id.choose_role_textview);
                s.h(textView3, "itemView.choose_role_textview");
                textView3.setVisibility(8);
            }
            if (itemCardFeaturesItemModel.getType() == ItemCardType.MatchNumber) {
                string = this.itemView.getContext().getString(R$string.exchange);
            } else if (itemCardFeaturesItemModel.getSelected()) {
                string = this.itemView.getContext().getString(R$string.chosen);
            } else {
                string = this.itemView.getContext().getString(R$string.go_to_use);
            }
            s.h(string, "if (model.type == ItemCa….go_to_use)\n            }");
            r(string, itemCardFeaturesItemModel.getSelected());
        }
    }

    public final void r(String str, boolean z10) {
        TextView configUserButton$lambda$2 = (TextView) this.itemView.findViewById(R$id.user_item_card_textview);
        configUserButton$lambda$2.setText(str);
        s.h(configUserButton$lambda$2, "configUserButton$lambda$2");
        y.i(configUserButton$lambda$2, (r18 & 1) != 0 ? 0.0f : h.c(configUserButton$lambda$2, 20.0f), z10 ? r.e(Integer.valueOf(com.cupidapp.live.base.utils.h.a(-1, 0.17f))) : kotlin.collections.s.m(-9603585, -4954625), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }
}
