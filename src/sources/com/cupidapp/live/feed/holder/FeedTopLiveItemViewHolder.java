package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedTopLiveItemViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTopLiveItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14391c = new a(null);

    /* compiled from: FeedTopLiveItemViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedTopLiveItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedTopLiveItemViewHolder(z.b(parent, R$layout.view_holder_feed_top_live_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTopLiveItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveShowModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.liveItemUserAvatar);
            s.h(imageLoaderView, "itemView.liveItemUserAvatar");
            LiveShowModel liveShowModel = (LiveShowModel) obj;
            ImageLoaderView.g(imageLoaderView, liveShowModel.getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.liveItemUserName)).setText(liveShowModel.getUser().getName());
        }
    }
}
