package com.cupidapp.live.liveshow.viewholder;

import android.view.View;
import android.view.ViewGroup;
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

/* compiled from: FKLiveImageViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveImageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16043c = new a(null);

    /* compiled from: FKLiveImageViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveImageViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveImageViewHolder(z.b(parent, R$layout.item_image_show, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveImageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveImageModel) {
            int l10 = h.l(this) - h.c(this, 8.0f);
            View view = this.itemView;
            int i10 = R$id.imgView;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView, "itemView.imgView");
            LiveImageModel liveImageModel = (LiveImageModel) obj;
            y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf(liveImageModel.getImageModel().getScaleHeightByWidth(l10)));
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.imgView");
            ImageLoaderView.g(imageLoaderView2, liveImageModel.getImageModel(), null, null, 6, null);
        }
    }
}
