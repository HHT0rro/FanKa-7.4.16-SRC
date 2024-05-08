package com.cupidapp.live.base.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKFooterWithSpaceViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFooterWithSpaceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12037c = new a(null);

    /* compiled from: FKFooterWithSpaceViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFooterWithSpaceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FKFooterWithSpaceViewHolder fKFooterWithSpaceViewHolder = new FKFooterWithSpaceViewHolder(z.b(parent, R$layout.view_holder_with_space_footer, false, 2, null));
            fKFooterWithSpaceViewHolder.q();
            return fKFooterWithSpaceViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFooterWithSpaceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKFooterWithSpaceModel) {
            FKFooterWithSpaceModel fKFooterWithSpaceModel = (FKFooterWithSpaceModel) obj;
            if (fKFooterWithSpaceModel.getBottomSpaceHeight() > 0) {
                View view = this.itemView;
                int i10 = R$id.footer_space;
                view.findViewById(i10).setVisibility(0);
                View findViewById = this.itemView.findViewById(i10);
                s.h(findViewById, "itemView.footer_space");
                y.o(findViewById, null, Integer.valueOf(fKFooterWithSpaceModel.getBottomSpaceHeight()), 1, null);
            } else {
                this.itemView.findViewById(R$id.footer_space).setVisibility(8);
            }
            if (!fKFooterWithSpaceModel.getShowProgress() && !fKFooterWithSpaceModel.getShowText()) {
                ((LinearLayout) this.itemView.findViewById(R$id.progress_root)).setVisibility(8);
                return;
            }
            View view2 = this.itemView;
            int i11 = R$id.progress_root;
            ((LinearLayout) view2.findViewById(i11)).setVisibility(0);
            ((ProgressBar) this.itemView.findViewById(R$id.footerSpaceProgressBarView)).setVisibility(fKFooterWithSpaceModel.getShowProgress() ? 0 : 8);
            if (fKFooterWithSpaceModel.getShowText()) {
                View view3 = this.itemView;
                int i12 = R$id.footerSpaceTextView;
                ((TextView) view3.findViewById(i12)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i12)).setText(fKFooterWithSpaceModel.getText());
                ((TextView) this.itemView.findViewById(i12)).setTextColor(fKFooterWithSpaceModel.getTextColor());
            } else {
                ((TextView) this.itemView.findViewById(R$id.footerSpaceTextView)).setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(i11);
            s.h(linearLayout, "itemView.progress_root");
            y.o(linearLayout, null, Integer.valueOf(h.c(this, fKFooterWithSpaceModel.getHeight())), 1, null);
        }
    }
}
