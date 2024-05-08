package com.cupidapp.live.mediapicker.newmediapicker.holder;

import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.cupidapp.live.mediapicker.view.MediaCheckedView;
import java.util.Arrays;
import java.util.Locale;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: MediaPickerViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPickerViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17321d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public boolean f17322c;

    /* compiled from: MediaPickerViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPickerViewHolder(@NotNull View itemView, boolean z10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f17322c = z10;
        itemView.getLayoutParams().height = h.l(this) / 4;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LocalMedia) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.ilvMediaPickerImage);
            s.h(imageLoaderView, "itemView.ilvMediaPickerImage");
            LocalMedia localMedia = (LocalMedia) obj;
            ImageLoaderView.f(imageLoaderView, new b(false, localMedia.d(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
            boolean a10 = MimeType.Companion.a(localMedia.c());
            if (a10) {
                this.itemView.findViewById(R$id.video_duration_bg).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.tvDuration)).setVisibility(4);
            } else {
                this.itemView.findViewById(R$id.video_duration_bg).setVisibility(0);
                View view = this.itemView;
                int i10 = R$id.tvDuration;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(r(localMedia.a()));
            }
            if (this.f17322c) {
                if (a10) {
                    ((MediaCheckedView) this.itemView.findViewById(R$id.mcvMediaCheckedView)).setVisibility(0);
                    this.itemView.findViewById(R$id.mediaPickerCover).setVisibility(8);
                } else {
                    ((MediaCheckedView) this.itemView.findViewById(R$id.mcvMediaCheckedView)).setVisibility(8);
                    this.itemView.findViewById(R$id.mediaPickerCover).setVisibility(ImagePickedData.INSTANCE.isEmpty() ? 8 : 0);
                }
                int index = ImagePickedData.INSTANCE.index(localMedia);
                if (index == -1) {
                    ((MediaCheckedView) this.itemView.findViewById(R$id.mcvMediaCheckedView)).c();
                    return;
                } else {
                    ((MediaCheckedView) this.itemView.findViewById(R$id.mcvMediaCheckedView)).setCheckBoxNum(index);
                    return;
                }
            }
            ((MediaCheckedView) this.itemView.findViewById(R$id.mcvMediaCheckedView)).setVisibility(8);
        }
    }

    public final String r(long j10) {
        long j11 = j10 / 1000;
        long j12 = 60;
        long j13 = j11 % j12;
        long j14 = j11 / j12;
        y yVar = y.f51038a;
        String format = String.format(Locale.CHINA, "%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j14), Long.valueOf(j13)}, 2));
        s.h(format, "format(locale, format, *args)");
        return format;
    }
}
