package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.AddressModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: SearchLocationHistoryViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchLocationHistoryViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16820c = new a(null);

    /* compiled from: SearchLocationHistoryViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchLocationHistoryViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SearchLocationHistoryViewHolder(z.b(parent, R$layout.item_search_location_history, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchLocationHistoryViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AddressModel) {
            View view = this.itemView;
            int i10 = R$id.location_name;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.location_name");
            u.a(textView);
            AddressModel addressModel = (AddressModel) obj;
            ((TextView) this.itemView.findViewById(i10)).setText(addressModel.getName());
            ((TextView) this.itemView.findViewById(R$id.location_distance)).setText(addressModel.getDistance());
        }
    }
}
