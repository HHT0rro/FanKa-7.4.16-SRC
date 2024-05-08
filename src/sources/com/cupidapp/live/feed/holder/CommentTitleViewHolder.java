package com.cupidapp.live.feed.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.profile.model.User;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.m;
import z0.z;

/* compiled from: CommentTitleViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CommentTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14373c = new a(null);

    /* compiled from: CommentTitleViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommentTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new CommentTitleViewHolder(z.b(parent, R$layout.view_holder_comment_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedDetailCommentTitleModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.commentTitleAvatar);
            s.h(imageLoaderView, "itemView.commentTitleAvatar");
            User X = p1.g.f52734a.X();
            String str = null;
            ImageLoaderView.g(imageLoaderView, X != null ? X.getAvatarImage() : null, null, null, 6, null);
            FeedDetailCommentTitleModel feedDetailCommentTitleModel = (FeedDetailCommentTitleModel) obj;
            FeedModel feedModel = feedDetailCommentTitleModel.getFeedModel();
            if ((feedModel != null ? feedModel.getCommentCount() : 0) > 0) {
                View view = this.itemView;
                int i10 = R$id.commentNumber;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                TextView textView = (TextView) this.itemView.findViewById(i10);
                FeedModel feedModel2 = feedDetailCommentTitleModel.getFeedModel();
                if (feedModel2 != null) {
                    int commentCount = feedModel2.getCommentCount();
                    Context context = this.itemView.getContext();
                    s.h(context, "itemView.context");
                    str = m.e(commentCount, context);
                }
                textView.setText(String.valueOf(str));
                return;
            }
            ((TextView) this.itemView.findViewById(R$id.commentNumber)).setVisibility(4);
        }
    }
}
