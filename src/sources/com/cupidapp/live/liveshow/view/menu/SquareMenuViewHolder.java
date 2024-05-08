package com.cupidapp.live.liveshow.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: LiveFunctionMenuAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SquareMenuViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15748c = new a(null);

    /* compiled from: LiveFunctionMenuAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SquareMenuViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SquareMenuViewHolder(z.b(parent, R$layout.view_holder_square_menu, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMenuViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        int l10 = (h.l(this) - h.c(this, 24.0f)) / 5;
        y.n(itemView, Integer.valueOf(l10), Integer.valueOf(l10));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveFunctionMenuModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.menu_img);
            s.h(imageLoaderView, "itemView.menu_img");
            LiveFunctionMenuModel liveFunctionMenuModel = (LiveFunctionMenuModel) obj;
            ImageLoaderView.g(imageLoaderView, liveFunctionMenuModel.getIcon(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.menu_txt)).setText(liveFunctionMenuModel.getName());
            this.itemView.findViewById(R$id.unread_view).setVisibility(liveFunctionMenuModel.getUnread() ? 0 : 8);
            if (getAbsoluteAdapterPosition() / 5 == 0) {
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                y.l(itemView, Integer.valueOf(h.c(this, 4.0f)), Integer.valueOf(h.c(this, 6.0f)), Integer.valueOf(h.c(this, 2.0f)), Integer.valueOf(h.c(this, 6.0f)));
            } else if ((getAbsoluteAdapterPosition() + 1) / 5 == 0) {
                View itemView2 = this.itemView;
                s.h(itemView2, "itemView");
                y.l(itemView2, Integer.valueOf(h.c(this, 2.0f)), Integer.valueOf(h.c(this, 6.0f)), Integer.valueOf(h.c(this, 4.0f)), Integer.valueOf(h.c(this, 6.0f)));
            } else {
                View itemView3 = this.itemView;
                s.h(itemView3, "itemView");
                y.l(itemView3, Integer.valueOf(h.c(this, 2.0f)), Integer.valueOf(h.c(this, 6.0f)), Integer.valueOf(h.c(this, 2.0f)), Integer.valueOf(h.c(this, 6.0f)));
            }
        }
    }
}
