package com.cupidapp.live.base.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.model.FKBlankSpaceModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKBlankSpaceViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKBlankSpaceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12032c = new a(null);

    /* compiled from: FKBlankSpaceViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKBlankSpaceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKBlankSpaceViewHolder(z.b(parent, R$layout.item_blank, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBlankSpaceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKBlankSpaceModel) {
            FKBlankSpaceModel fKBlankSpaceModel = (FKBlankSpaceModel) obj;
            if (fKBlankSpaceModel.getHeight() != null) {
                View findViewById = this.itemView.findViewById(R$id.root);
                s.h(findViewById, "itemView.root");
                y.o(findViewById, null, fKBlankSpaceModel.getHeight(), 1, null);
            }
        }
    }
}
