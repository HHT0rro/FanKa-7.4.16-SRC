package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.FeedRcmdDivideUiModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: FeedRcmdDivideViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRcmdDivideViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14388c = new a(null);

    /* compiled from: FeedRcmdDivideViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedRcmdDivideViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedRcmdDivideViewHolder(z.b(parent, R$layout.item_rcmd_feed_divide, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedRcmdDivideViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedRcmdDivideUiModel) {
            View view = this.itemView;
            int i10 = R$id.rcmd_feed_divide_txt;
            ((TextView) view.findViewById(i10)).setText(((FeedRcmdDivideUiModel) obj).getTitle());
            TextView textView = (TextView) this.itemView.findViewById(i10);
            s.h(textView, "itemView.rcmd_feed_divide_txt");
            u.a(textView);
        }
    }
}
