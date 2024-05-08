package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.FKSVipImgLayout;
import com.cupidapp.live.match.model.SuperVipTitleUiModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SuperVipTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperVipTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16823c = new a(null);

    /* compiled from: SuperVipTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SuperVipTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SuperVipTitleViewHolder(z.b(parent, R$layout.item_super_vip_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperVipTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof SuperVipTitleUiModel) {
            SuperVipTitleUiModel superVipTitleUiModel = (SuperVipTitleUiModel) obj;
            ((TextView) this.itemView.findViewById(R$id.item_super_title)).setText(superVipTitleUiModel.getTitle());
            ((FKSVipImgLayout) this.itemView.findViewById(R$id.svip_img_layout)).c(superVipTitleUiModel.getDescription());
        }
    }
}
