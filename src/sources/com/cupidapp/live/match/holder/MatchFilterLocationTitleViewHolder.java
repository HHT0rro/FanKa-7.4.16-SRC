package com.cupidapp.live.match.holder;

import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.TitleViewModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterLocationTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterLocationTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16804c = new a(null);

    /* compiled from: MatchFilterLocationTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof TitleViewModel) {
            TitleViewModel titleViewModel = (TitleViewModel) obj;
            ((TextView) this.itemView.findViewById(R$id.titleTextView)).setText(titleViewModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.not_need_set_location_range_tip)).setVisibility(titleViewModel.getFromNearby() ? 0 : 8);
            ((ImageView) this.itemView.findViewById(R$id.titleAfterIconImageView)).setVisibility(titleViewModel.getShowVipIcon() ? 0 : 8);
        }
    }
}
