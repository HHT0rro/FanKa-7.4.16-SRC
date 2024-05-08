package com.cupidapp.live.mediapicker.newmediapicker.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaFolder;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MediaFolderViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaFolderViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17319d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public MediaType f17320c;

    /* compiled from: MediaFolderViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MediaFolderViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MediaFolderViewHolder(z.b(parent, R$layout.view_holder_media_folder_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFolderViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f17320c = MediaType.ALL;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LocalMediaFolder) {
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) obj;
            ((TextView) this.itemView.findViewById(R$id.tvMediaCountInFolder)).setText("(" + localMediaFolder.c() + ")");
            ((TextView) this.itemView.findViewById(R$id.tvMediaFolderName)).setText(localMediaFolder.d());
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.ilvMediaFolderIcon);
            s.h(imageLoaderView, "itemView.ilvMediaFolderIcon");
            ImageLoaderView.f(imageLoaderView, new b(false, localMediaFolder.b(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        }
    }
}
