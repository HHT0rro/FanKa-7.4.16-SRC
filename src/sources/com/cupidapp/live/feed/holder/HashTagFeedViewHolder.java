package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.profile.holder.ProfilePostMediaViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: HashTagFeedViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagFeedViewHolder extends ProfilePostMediaViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14394d = new a(null);

    /* compiled from: HashTagFeedViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagFeedViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new HashTagFeedViewHolder(z.b(parent, R$layout.view_holder_profile_post_meida, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashTagFeedViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.profile.holder.ProfilePostMediaViewHolder, com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        super.n(obj);
        View view = this.itemView;
        int i10 = R$id.feedRankingTextView;
        ((TextView) view.findViewById(i10)).setVisibility(0);
        int adapterPosition = getAdapterPosition();
        if (1 <= adapterPosition && adapterPosition < 11) {
            ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.rank_number, Integer.valueOf(getAdapterPosition())));
        } else {
            ((TextView) this.itemView.findViewById(i10)).setText("");
        }
    }
}
