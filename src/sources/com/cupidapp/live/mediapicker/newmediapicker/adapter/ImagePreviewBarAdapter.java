package com.cupidapp.live.mediapicker.newmediapicker.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.newmediapicker.holder.ImagePreviewBarViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ImagePreviewBarAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePreviewBarAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public int f17273f = -1;

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        s.i(holder, "holder");
        super.onBindViewHolder(holder, i10);
        ((ImagePreviewBarViewHolder) holder).r(i10 == this.f17273f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        ImagePreviewBarViewHolder a10 = ImagePreviewBarViewHolder.f17317d.a(parent);
        a10.k(l());
        return a10;
    }

    public final void v(int i10) {
        this.f17273f = i10;
    }
}
