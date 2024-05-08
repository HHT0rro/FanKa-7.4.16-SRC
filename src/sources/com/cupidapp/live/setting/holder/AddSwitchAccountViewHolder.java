package com.cupidapp.live.setting.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: AddSwitchAccountViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AddSwitchAccountViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18187c = new a(null);

    /* compiled from: AddSwitchAccountViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AddSwitchAccountViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AddSwitchAccountViewHolder(z.b(parent, R$layout.view_holder_add_switch_account, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddSwitchAccountViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AddSwitchAccountUiModel) {
            if (((AddSwitchAccountUiModel) obj).isVisible()) {
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                y.o(itemView, null, Integer.valueOf(h.c(this, 72.0f)), 1, null);
                this.itemView.setVisibility(0);
                return;
            }
            View itemView2 = this.itemView;
            s.h(itemView2, "itemView");
            y.o(itemView2, null, Integer.valueOf(h.c(this, 0.0f)), 1, null);
            this.itemView.setVisibility(8);
        }
    }
}
