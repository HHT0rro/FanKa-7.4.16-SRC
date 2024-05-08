package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.match.activity.FKMatchFilterNewActivity;
import com.cupidapp.live.match.model.NearbyNoBodyViewModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKNearbyNoBodyViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearbyNoBodyViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16791c = new a(null);

    /* compiled from: FKNearbyNoBodyViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKNearbyNoBodyViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKNearbyNoBodyViewHolder(z.b(parent, R$layout.view_holder_nearby_no_body, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearbyNoBodyViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearbyNoBodyViewModel) {
            ((TextView) this.itemView.findViewById(R$id.nearby_no_body_text_view)).setText(((NearbyNoBodyViewModel) obj).getMessage());
            FKUniversalButton fKUniversalButton = (FKUniversalButton) this.itemView.findViewById(R$id.nearby_no_body_button);
            s.h(fKUniversalButton, "itemView.nearby_no_body_button");
            y.d(fKUniversalButton, new Function1<View, p>() { // from class: com.cupidapp.live.match.holder.FKNearbyNoBodyViewHolder$config$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    FKMatchFilterNewActivity.f16488t.a(FKNearbyNoBodyViewHolder.this.itemView.getContext(), true, false, "");
                }
            });
        }
    }
}
