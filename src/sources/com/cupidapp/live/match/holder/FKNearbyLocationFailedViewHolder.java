package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.NearbyLocationFailedViewModel;
import com.huawei.openalliance.ad.constant.u;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKNearbyLocationFailedViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearbyLocationFailedViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16790c = new a(null);

    /* compiled from: FKNearbyLocationFailedViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKNearbyLocationFailedViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKNearbyLocationFailedViewHolder(z.b(parent, R$layout.view_holder_nearby_location_failed, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearbyLocationFailedViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String string;
        if (obj instanceof NearbyLocationFailedViewModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.nearby_location_fail_text);
            NearbyLocationFailedViewModel nearbyLocationFailedViewModel = (NearbyLocationFailedViewModel) obj;
            if (nearbyLocationFailedViewModel.getErrorCode() != null) {
                string = this.itemView.getContext().getString(R$string.location_failed) + u.bD + ((Object) nearbyLocationFailedViewModel.getErrorCode());
            } else {
                string = this.itemView.getContext().getString(R$string.location_failed);
            }
            textView.setText(string);
        }
    }
}
