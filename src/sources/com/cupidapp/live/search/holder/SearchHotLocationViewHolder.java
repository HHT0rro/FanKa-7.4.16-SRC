package com.cupidapp.live.search.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.AddressModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SearchHotLocationViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchHotLocationViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17918c = new a(null);

    /* compiled from: SearchHotLocationViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchHotLocationViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SearchHotLocationViewHolder(z.b(parent, R$layout.item_serach_hot_location, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchHotLocationViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AddressModel) {
            int absoluteAdapterPosition = getAbsoluteAdapterPosition() + 1;
            if (absoluteAdapterPosition == 1) {
                View view = this.itemView;
                int i10 = R$id.location_number;
                ((TextView) view.findViewById(i10)).setText("");
                ((TextView) this.itemView.findViewById(i10)).setBackgroundResource(R$mipmap.ic_number_1);
            } else if (absoluteAdapterPosition == 2) {
                View view2 = this.itemView;
                int i11 = R$id.location_number;
                ((TextView) view2.findViewById(i11)).setText("");
                ((TextView) this.itemView.findViewById(i11)).setBackgroundResource(R$mipmap.ic_number_2);
            } else if (absoluteAdapterPosition != 3) {
                View view3 = this.itemView;
                int i12 = R$id.location_number;
                ((TextView) view3.findViewById(i12)).setBackgroundDrawable(null);
                ((TextView) this.itemView.findViewById(i12)).setText(String.valueOf(absoluteAdapterPosition));
            } else {
                View view4 = this.itemView;
                int i13 = R$id.location_number;
                ((TextView) view4.findViewById(i13)).setText("");
                ((TextView) this.itemView.findViewById(i13)).setBackgroundResource(R$mipmap.ic_number_3);
            }
            AddressModel addressModel = (AddressModel) obj;
            ((TextView) this.itemView.findViewById(R$id.location_name)).setText(addressModel.getName());
            ((TextView) this.itemView.findViewById(R$id.location_click_count)).setText(addressModel.getClickCount());
        }
    }
}
