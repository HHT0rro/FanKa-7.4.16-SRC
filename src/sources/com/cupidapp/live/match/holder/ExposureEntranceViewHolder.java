package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.ExposureEntranceModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.z;

/* compiled from: ExposureEntranceViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ExposureEntranceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16789c = new a(null);

    /* compiled from: ExposureEntranceViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExposureEntranceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ExposureEntranceViewHolder(z.b(parent, R$layout.item_exposure_entrance, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposureEntranceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ExposureEntranceModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.travel_entrance_txt);
            String travelboostMarketingMsg = ((ExposureEntranceModel) obj).getTravelboostMarketingMsg();
            textView.setText(travelboostMarketingMsg != null ? t.a(travelboostMarketingMsg, -360943) : null);
        }
    }
}
