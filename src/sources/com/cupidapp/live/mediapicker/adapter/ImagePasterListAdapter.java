package com.cupidapp.live.mediapicker.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.mediapicker.activity.ImagePasterViewModel;
import com.cupidapp.live.mediapicker.model.PasterModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePasterListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePasterListAdapter extends RecyclerView.Adapter<ImagePasterListViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final ImagePasterViewModel f17156a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<PasterModel> f17157b;

    public ImagePasterListAdapter(@NotNull ImagePasterViewModel viewModel) {
        s.i(viewModel, "viewModel");
        this.f17156a = viewModel;
        this.f17157b = new ArrayList();
    }

    @Nullable
    public final PasterModel c(int i10) {
        if (i10 < 0 || i10 >= this.f17157b.size()) {
            return null;
        }
        return this.f17157b.get(i10);
    }

    public final void d(@NotNull List<PasterModel> list) {
        s.i(list, "list");
        this.f17157b.clear();
        this.f17157b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ImagePasterListViewHolder holder, int i10) {
        s.i(holder, "holder");
        holder.i(this.f17156a, c(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ImagePasterListViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        return ImagePasterListViewHolder.f17158b.a(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f17157b.size();
    }
}
