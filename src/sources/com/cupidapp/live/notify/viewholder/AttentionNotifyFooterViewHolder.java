package com.cupidapp.live.notify.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AttentionNotifyFooterViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionNotifyFooterViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17571c = new a(null);

    /* compiled from: AttentionNotifyFooterViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AttentionNotifyFooterViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AttentionNotifyFooterViewHolder(z.b(parent, R$layout.view_holder_attention_notify_footer_view, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionNotifyFooterViewHolder(@NotNull View itemView) {
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
                int i10 = R$id.alohaNotifyFooterView;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).getPaint().setFakeBoldText(true);
                ((TextView) this.itemView.findViewById(i10)).setText(fKFooterViewModel.getText());
                View view2 = this.itemView;
                int i11 = R$id.seeAllFollowingUsers;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).getPaint().setFakeBoldText(true);
                return;
            }
            ((TextView) this.itemView.findViewById(R$id.alohaNotifyFooterView)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R$id.seeAllFollowingUsers)).setVisibility(8);
        }
    }
}
