package com.cupidapp.live.liveshow.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.HeatItemModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: HeatIntroViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HeatIntroViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16054c = new a(null);

    /* compiled from: HeatIntroViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HeatIntroViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new HeatIntroViewHolder(z.b(parent, R$layout.item_heat_intro, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeatIntroViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof HeatItemModel) {
            HeatItemModel heatItemModel = (HeatItemModel) obj;
            ((TextView) this.itemView.findViewById(R$id.heat_intro_title)).setText(heatItemModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.heat_intro_des)).setText(heatItemModel.getDesc());
            if (heatItemModel.getImage() != null) {
                View view = this.itemView;
                int i10 = R$id.heat_intro_img;
                ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
                int c4 = h.c(this, 248.0f);
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView, "itemView.heat_intro_img");
                y.n(imageLoaderView, Integer.valueOf(c4), Integer.valueOf(heatItemModel.getImage().getScaleHeightByWidth(c4)));
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView2, "itemView.heat_intro_img");
                y.o(imageLoaderView2, null, null, 3, null);
                ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView3, "itemView.heat_intro_img");
                ImageLoaderView.g(imageLoaderView3, heatItemModel.getImage(), null, null, 6, null);
                return;
            }
            ((ImageLoaderView) this.itemView.findViewById(R$id.heat_intro_img)).setVisibility(8);
        }
    }
}
