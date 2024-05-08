package com.cupidapp.live.liveshow.beauty.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.liveshow.beauty.view.FKLiveFilterViewModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveFilterAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveFilterViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14831c = new a(null);

    /* compiled from: FKLiveFilterAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveFilterViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveFilterViewHolder(z.b(parent, R$layout.view_holder_live_filter_edit_button, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveFilterViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveFilterViewModel) {
            View view = this.itemView;
            int i10 = R$id.buttonNameTextView;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            FKLiveFilterViewModel fKLiveFilterViewModel = (FKLiveFilterViewModel) obj;
            ((TextView) this.itemView.findViewById(i10)).setTextColor(fKLiveFilterViewModel.isSelected() ? -15066598 : -3750202);
            ((TextView) this.itemView.findViewById(i10)).setText(fKLiveFilterViewModel.getFilterName());
            ((ImageView) this.itemView.findViewById(R$id.buttonIconImageView)).setImageResource(fKLiveFilterViewModel.getFilterIcon());
            if (fKLiveFilterViewModel.getFilterResource() != null) {
                if (fKLiveFilterViewModel.isSelected()) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(h.a(-16777216, 0.7f));
                    gradientDrawable.setCornerRadius(z0.h.c(gradientDrawable, 36.0f));
                    View view2 = this.itemView;
                    int i11 = R$id.filterIntensityImageView;
                    ((ImageView) view2.findViewById(i11)).setBackground(gradientDrawable);
                    ((ImageView) this.itemView.findViewById(i11)).setVisibility(0);
                    return;
                }
                ((ImageView) this.itemView.findViewById(R$id.filterIntensityImageView)).setVisibility(8);
            }
        }
    }
}
