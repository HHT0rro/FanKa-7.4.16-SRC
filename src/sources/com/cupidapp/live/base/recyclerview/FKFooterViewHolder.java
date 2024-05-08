package com.cupidapp.live.base.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKFooterViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFooterViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12036c = new a(null);

    /* compiled from: FKFooterViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFooterViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FKFooterViewHolder fKFooterViewHolder = new FKFooterViewHolder(z.b(parent, R$layout.view_holder_footer, false, 2, null));
            fKFooterViewHolder.q();
            return fKFooterViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFooterViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKFooterViewModel) {
            FKFooterViewModel fKFooterViewModel = (FKFooterViewModel) obj;
            ((ProgressBar) this.itemView.findViewById(R$id.footerProgressBarView)).setVisibility(fKFooterViewModel.getShowProgress() ? 0 : 8);
            if (fKFooterViewModel.getShowText()) {
                View view = this.itemView;
                int i10 = R$id.footerTextView;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(fKFooterViewModel.getText());
                ((TextView) this.itemView.findViewById(i10)).setTextColor(fKFooterViewModel.getTextColor());
            } else {
                ((TextView) this.itemView.findViewById(R$id.footerTextView)).setVisibility(8);
            }
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            y.o(itemView, null, Integer.valueOf(h.c(this, fKFooterViewModel.getHeight())), 1, null);
            this.itemView.setBackgroundColor(fKFooterViewModel.getBgColor());
        }
    }
}
