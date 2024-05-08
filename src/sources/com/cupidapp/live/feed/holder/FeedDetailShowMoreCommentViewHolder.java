package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedDetailShowMoreCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailShowMoreCommentViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14381c = new a(null);

    /* compiled from: FeedDetailShowMoreCommentViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedDetailShowMoreCommentViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedDetailShowMoreCommentViewHolder(z.b(parent, R$layout.view_holder_feed_detail_comment_show_more, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailShowMoreCommentViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedDetailShowMoreCommentViewModel) {
            FeedDetailShowMoreCommentViewModel feedDetailShowMoreCommentViewModel = (FeedDetailShowMoreCommentViewModel) obj;
            if (feedDetailShowMoreCommentViewModel.getNotLoadCommentCount() != null && !feedDetailShowMoreCommentViewModel.getShowMoreText()) {
                ((TextView) this.itemView.findViewById(R$id.commentShowMoreTextView)).setText(this.itemView.getContext().getString(R$string.show_more_comment_of_count, feedDetailShowMoreCommentViewModel.getNotLoadCommentCount()));
            } else {
                ((TextView) this.itemView.findViewById(R$id.commentShowMoreTextView)).setText(this.itemView.getContext().getString(R$string.show_more_comment));
            }
        }
    }
}
