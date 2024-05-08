package com.cupidapp.live.feed.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FeedClassifyAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClassifyItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14172c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f14173d;

    /* compiled from: FeedClassifyAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedClassifyItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedClassifyItemViewHolder(z.b(parent, R$layout.view_holder_feed_classify_item, false, 2, null));
        }

        public final int b() {
            return FeedClassifyItemViewHolder.f14173d;
        }
    }

    static {
        a aVar = new a(null);
        f14172c = aVar;
        f14173d = ((h.l(aVar) - h.c(aVar, 176.0f)) - h.c(aVar, 104.0f)) / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedClassifyItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.classify_name)).getPaint().setFakeBoldText(true);
        y.o(itemView, Integer.valueOf(h.c(this, 44.0f) + f14173d), null, 2, null);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedClassifyModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.classify_image);
            s.h(imageLoaderView, "itemView.classify_image");
            FeedClassifyModel feedClassifyModel = (FeedClassifyModel) obj;
            ImageLoaderView.g(imageLoaderView, feedClassifyModel.getIconImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.classify_name)).setText(feedClassifyModel.getTagName());
        }
    }
}
