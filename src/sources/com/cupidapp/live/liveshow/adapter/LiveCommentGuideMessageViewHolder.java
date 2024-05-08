package com.cupidapp.live.liveshow.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.view.comment.LiveCommentGuideMessageLayout;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentGuideMessageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14829c = new a(null);

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
        public final LiveCommentGuideMessageViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            Context context = parent.getContext();
            s.h(context, "parent.context");
            return new LiveCommentGuideMessageViewHolder(new LiveCommentGuideMessageLayout(context));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentGuideMessageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveCommentMessageGuideModel) {
            View view = this.itemView;
            if (view instanceof LiveCommentGuideMessageLayout) {
                LiveCommentGuideMessageLayout liveCommentGuideMessageLayout = view instanceof LiveCommentGuideMessageLayout ? (LiveCommentGuideMessageLayout) view : null;
                if (liveCommentGuideMessageLayout != null) {
                    liveCommentGuideMessageLayout.b((LiveCommentMessageGuideModel) obj);
                }
            }
        }
    }
}
