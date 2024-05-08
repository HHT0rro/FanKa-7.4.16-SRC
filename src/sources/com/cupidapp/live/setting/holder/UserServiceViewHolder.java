package com.cupidapp.live.setting.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.EquityModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: UserServiceViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserServiceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18197c = new a(null);

    /* compiled from: UserServiceViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserServiceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new UserServiceViewHolder(z.b(parent, R$layout.item_equity, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserServiceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof EquityModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.service_img);
            s.h(imageLoaderView, "itemView.service_img");
            EquityModel equityModel = (EquityModel) obj;
            ImageLoaderView.g(imageLoaderView, equityModel.getIcon(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.service_title_txt)).setText(equityModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.service_des_txt)).setText(equityModel.getDescription());
        }
    }
}
