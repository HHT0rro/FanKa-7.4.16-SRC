package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ActivityTopMenuViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityTopMenuViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13680c = new a(null);

    /* compiled from: ActivityTopMenuViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ActivityTopMenuViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ActivityTopMenuViewHolder(z.b(parent, R$layout.view_holder_activity_top_menu, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityTopMenuViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ActivityTopMenuModel) {
            View findViewById = this.itemView.findViewById(R$id.new_order_view);
            s.h(findViewById, "itemView.new_order_view");
            ActivityTopMenuModel activityTopMenuModel = (ActivityTopMenuModel) obj;
            findViewById.setVisibility(activityTopMenuModel.getNewOrder() ? 0 : 8);
            String myCoinUrl = activityTopMenuModel.getMyCoinUrl();
            if (myCoinUrl == null || myCoinUrl.length() == 0) {
                ((ImageView) this.itemView.findViewById(R$id.activity_scan_img)).setImageResource(R$mipmap.icon_activity_scan);
                ((TextView) this.itemView.findViewById(R$id.activity_scan_txt)).setText(this.itemView.getContext().getString(R$string.scan));
            } else {
                ((ImageView) this.itemView.findViewById(R$id.activity_scan_img)).setImageResource(R$mipmap.icon_activity_coin);
                ((TextView) this.itemView.findViewById(R$id.activity_scan_txt)).setText(this.itemView.getContext().getString(R$string.my_coins));
            }
        }
    }
}
