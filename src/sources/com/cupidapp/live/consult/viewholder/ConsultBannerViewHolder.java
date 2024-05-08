package com.cupidapp.live.consult.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.consult.view.ConsultBannerLayout;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ConsultBannerViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultBannerViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13893c = new a(null);

    /* compiled from: ConsultBannerViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConsultBannerViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ConsultBannerViewHolder(z.b(parent, R$layout.view_holder_consult_banner, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBannerViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ConsultBannerListModel) {
            ((ConsultBannerLayout) this.itemView.findViewById(R$id.consult_banner_layout)).s(((ConsultBannerListModel) obj).getBanners());
        }
    }
}
