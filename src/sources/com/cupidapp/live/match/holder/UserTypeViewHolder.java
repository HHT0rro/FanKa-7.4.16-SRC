package com.cupidapp.live.match.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.UserTypeModel;
import com.cupidapp.live.match.view.UserTypeItemLayout;
import com.cupidapp.live.match.view.g0;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: UserTypeViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserTypeViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16828d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16829c;

    /* compiled from: UserTypeViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserTypeViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new UserTypeViewHolder(z.b(parent, R$layout.item_user_type, false, 2, null), z10);
        }
    }

    /* compiled from: UserTypeViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements g0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FilterOption f16831b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f16832c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ UserTypeItemLayout f16833d;

        public b(FilterOption filterOption, Object obj, UserTypeItemLayout userTypeItemLayout) {
            this.f16831b = filterOption;
            this.f16832c = obj;
            this.f16833d = userTypeItemLayout;
        }

        @Override // com.cupidapp.live.match.view.g0
        public void a(boolean z10) {
            if (UserTypeViewHolder.this.r() && PurchaseProductType.Companion.e(this.f16831b.getId(), ((UserTypeModel) this.f16832c).getProductType(), VipPurchaseEntranceType.SuperFilter)) {
                this.f16833d.setChecked(false);
            } else {
                this.f16831b.setChecked(z10);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTypeViewHolder(@NotNull View itemView, boolean z10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16829c = z10;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof UserTypeModel) {
            ((LinearLayout) this.itemView.findViewById(R$id.user_type_linear)).removeAllViews();
            List<FilterOption> options = ((UserTypeModel) obj).getOptions();
            if (options != null) {
                for (FilterOption filterOption : options) {
                    Context context = this.itemView.getContext();
                    s.h(context, "itemView.context");
                    UserTypeItemLayout userTypeItemLayout = new UserTypeItemLayout(context);
                    userTypeItemLayout.g(filterOption, new b(filterOption, obj, userTypeItemLayout));
                    ((LinearLayout) this.itemView.findViewById(R$id.user_type_linear)).addView(userTypeItemLayout);
                }
            }
        }
    }

    public final boolean r() {
        return this.f16829c;
    }
}
