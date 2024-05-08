package com.cupidapp.live.liveshow.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.view.comment.FKLiveCommentMessageLayout;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCommentMessageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14809c = new a(null);

    /* compiled from: FKLiveCommentAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveCommentMessageViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            Context context = parent.getContext();
            s.h(context, "parent.context");
            return new FKLiveCommentMessageViewHolder(new FKLiveCommentMessageLayout(context, z10));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveCommentMessageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveCommentMessageViewModel) {
            View view = this.itemView;
            if (view instanceof FKLiveCommentMessageLayout) {
                FKLiveCommentMessageLayout fKLiveCommentMessageLayout = view instanceof FKLiveCommentMessageLayout ? (FKLiveCommentMessageLayout) view : null;
                if (fKLiveCommentMessageLayout == null) {
                    return;
                }
                fKLiveCommentMessageLayout.setCommentMessageModel((FKLiveCommentMessageViewModel) obj);
            }
        }
    }
}
