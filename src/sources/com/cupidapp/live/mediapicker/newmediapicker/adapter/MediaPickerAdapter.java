package com.cupidapp.live.mediapicker.newmediapicker.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.holder.CameraViewHolder;
import com.cupidapp.live.mediapicker.newmediapicker.holder.MediaPickerViewHolder;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import d3.a;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import z0.z;

/* compiled from: MediaPickerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaPickerAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public boolean f17274f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17275g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MediaPickerAdapter() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.newmediapicker.adapter.MediaPickerAdapter.<init>():void");
    }

    public /* synthetic */ MediaPickerAdapter(boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11);
    }

    public final void u() {
        j().clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder mediaPickerViewHolder;
        s.i(parent, "parent");
        if (this.f17274f && i10 == 0) {
            mediaPickerViewHolder = new CameraViewHolder(z.b(parent, R$layout.recycler_item_camera, false, 2, null));
        } else {
            mediaPickerViewHolder = new MediaPickerViewHolder(z.b(parent, R$layout.view_holder_media_picker_item, false, 2, null), this.f17275g);
        }
        mediaPickerViewHolder.k(l());
        return mediaPickerViewHolder;
    }

    public MediaPickerAdapter(boolean z10, boolean z11) {
        this.f17274f = z10;
        this.f17275g = z11;
        List<Class<? extends Object>> k10 = k();
        if (z10) {
            k10.add(a.class);
        }
        k10.add(LocalMedia.class);
    }
}
