package com.cupidapp.live.vip.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.vip.model.PurchaseTabModel;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VipPurchaseTabViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseTabViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18736c = new a(null);

    /* compiled from: VipPurchaseTabViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VipPurchaseTabViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new VipPurchaseTabViewHolder(z.b(parent, R$layout.view_holder_vip_purchase_tab, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseTabViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof PurchaseTabModel) {
            PurchaseTabModel purchaseTabModel = (PurchaseTabModel) obj;
            ((ConstraintLayout) this.itemView.findViewById(R$id.root)).setPadding(h.c(this, purchaseTabModel.getPaddingStart()), h.c(this, 6.0f), h.c(this, purchaseTabModel.getPaddingEnd()), h.c(this, 2.0f));
            View view = this.itemView;
            int i10 = R$id.vip_tab_title_textview;
            ((TextView) view.findViewById(i10)).setText(purchaseTabModel.getTitle());
            ((TextView) this.itemView.findViewById(i10)).setTextSize(purchaseTabModel.getTextSize());
            if (purchaseTabModel.getContent().length() > 0) {
                View view2 = this.itemView;
                int i11 = R$id.vip_tab_textview;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(purchaseTabModel.getContent());
            } else {
                ((TextView) this.itemView.findViewById(R$id.vip_tab_textview)).setVisibility(8);
            }
            if (purchaseTabModel.getSelect()) {
                if (purchaseTabModel.getTitleSelectColor().size() > 1) {
                    TextView textView = (TextView) this.itemView.findViewById(i10);
                    s.h(textView, "itemView.vip_tab_title_textview");
                    u.g(textView, purchaseTabModel.getTitleSelectColor());
                } else {
                    TextView textView2 = (TextView) this.itemView.findViewById(i10);
                    textView2.setTextColor(((Number) CollectionsKt___CollectionsKt.T(purchaseTabModel.getTitleSelectColor())).intValue());
                    textView2.getPaint().setShader(null);
                }
                if (purchaseTabModel.getContentSelector().size() > 1) {
                    TextView config$lambda$1 = (TextView) this.itemView.findViewById(R$id.vip_tab_textview);
                    s.h(config$lambda$1, "config$lambda$1");
                    u.g(config$lambda$1, purchaseTabModel.getContentSelector());
                    config$lambda$1.getPaint().setFakeBoldText(true);
                } else {
                    TextView textView3 = (TextView) this.itemView.findViewById(R$id.vip_tab_textview);
                    textView3.setTextColor(((Number) CollectionsKt___CollectionsKt.T(purchaseTabModel.getContentSelector())).intValue());
                    textView3.getPaint().setShader(null);
                    textView3.getPaint().setFakeBoldText(true);
                }
                if (purchaseTabModel.getIndicatorSelectShow()) {
                    View view3 = this.itemView;
                    int i12 = R$id.vip_indicator_view;
                    view3.findViewById(i12).setVisibility(0);
                    List<Integer> indicatorColor = purchaseTabModel.getIndicatorColor();
                    if (indicatorColor != null) {
                        View findViewById = this.itemView.findViewById(i12);
                        s.h(findViewById, "itemView.vip_indicator_view");
                        y.i(findViewById, (r18 & 1) != 0 ? 0.0f : 3.0f, indicatorColor, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
                        return;
                    }
                    return;
                }
                this.itemView.findViewById(R$id.vip_indicator_view).setVisibility(8);
                return;
            }
            this.itemView.findViewById(R$id.vip_indicator_view).setVisibility(8);
            TextView textView4 = (TextView) this.itemView.findViewById(i10);
            textView4.setTextColor(purchaseTabModel.getUnSelectColor());
            textView4.getPaint().setShader(null);
            TextView textView5 = (TextView) this.itemView.findViewById(R$id.vip_tab_textview);
            textView5.setTextColor(purchaseTabModel.getUnSelectColor());
            textView5.getPaint().setShader(null);
            textView5.getPaint().setFakeBoldText(false);
        }
    }
}
