package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.FKItemLayout;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: PlaceLocationViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PlaceLocationViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17815c = new a(null);

    /* compiled from: PlaceLocationViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PlaceLocationViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new PlaceLocationViewHolder(z.b(parent, R$layout.view_holder_place_location, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaceLocationViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (p.q(str, StringUtils.NO_PRINT_CODE, false, 2, null)) {
                ((FKItemLayout) this.itemView.findViewById(R$id.placeLocationItemLayout)).setFkNextIndicator(Boolean.TRUE);
                str = str.substring(0, str.length() - 1);
                s.h(str, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                ((FKItemLayout) this.itemView.findViewById(R$id.placeLocationItemLayout)).setFkNextIndicator(Boolean.FALSE);
            }
            ((FKItemLayout) this.itemView.findViewById(R$id.placeLocationItemLayout)).setFkTitleText(str);
        }
    }
}
