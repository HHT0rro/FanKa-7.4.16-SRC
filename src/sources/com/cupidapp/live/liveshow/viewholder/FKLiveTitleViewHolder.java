package com.cupidapp.live.liveshow.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16052c = new a(null);

    /* compiled from: FKLiveTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveTitleViewHolder(z.b(parent, R$layout.view_holder_live_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveTitleModel) {
            FKLiveTitleModel fKLiveTitleModel = (FKLiveTitleModel) obj;
            if (fKLiveTitleModel.getIcon() == null) {
                ((ImageView) this.itemView.findViewById(R$id.liveTitleImageView)).setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.liveTitleImageView;
                ((ImageView) view.findViewById(i10)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(i10)).setImageResource(fKLiveTitleModel.getIcon().intValue());
            }
            ((TextView) this.itemView.findViewById(R$id.liveTitleView)).setText(fKLiveTitleModel.getTitle());
        }
    }
}
