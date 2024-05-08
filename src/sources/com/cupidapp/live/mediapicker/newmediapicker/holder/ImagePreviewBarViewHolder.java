package com.cupidapp.live.mediapicker.newmediapicker.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaPicked;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ImagePreviewBarViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePreviewBarViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17317d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public boolean f17318c;

    /* compiled from: ImagePreviewBarViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImagePreviewBarViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ImagePreviewBarViewHolder(z.b(parent, R$layout.view_holder_preview_image_bar_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewBarViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LocalMediaPicked) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.ilvPreviewImage);
            s.h(imageLoaderView, "itemView.ilvPreviewImage");
            ImageLoaderView.f(imageLoaderView, new b(false, ((LocalMediaPicked) obj).getMedia().d(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        }
    }

    public final void r(boolean z10) {
        this.f17318c = z10;
        this.itemView.findViewById(R$id.previewImageFocusedFrame).setVisibility(z10 ? 0 : 8);
    }
}
