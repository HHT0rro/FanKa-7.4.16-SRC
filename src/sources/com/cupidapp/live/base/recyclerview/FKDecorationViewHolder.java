package com.cupidapp.live.base.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.model.FKDecorationModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKDecorationViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKDecorationViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12033c = new a(null);

    /* compiled from: FKDecorationViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKDecorationViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKDecorationViewHolder(z.b(parent, R$layout.item_decoration, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKDecorationViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKDecorationModel) {
            FKDecorationModel fKDecorationModel = (FKDecorationModel) obj;
            this.itemView.findViewById(R$id.decoration_view).setBackgroundColor(fKDecorationModel.getLineColor());
            RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.root);
            s.h(relativeLayout, "itemView.root");
            y.o(relativeLayout, null, Integer.valueOf(fKDecorationModel.getHeight()), 1, null);
        }
    }
}
