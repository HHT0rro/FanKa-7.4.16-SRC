package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: PostLimitPrivateViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostLimitPrivateViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17816c = new a(null);

    /* compiled from: PostLimitPrivateViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostLimitPrivateViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new PostLimitPrivateViewHolder(z.b(parent, R$layout.item_post_limit_private, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitPrivateViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof PostLimitDetailModel) {
            int l10 = (h.l(this) - h.c(this, 12.0f)) / 3;
            View view = this.itemView;
            int i10 = R$id.post_private_img;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView, "itemView.post_private_img");
            y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf((l10 * 4) / 3));
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.post_private_img");
            ImageLoaderView.g(imageLoaderView2, ((PostLimitDetailModel) obj).getImage(), null, null, 6, null);
        }
    }
}
