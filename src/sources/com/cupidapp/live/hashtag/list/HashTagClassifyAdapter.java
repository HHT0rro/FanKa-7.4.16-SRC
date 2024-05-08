package com.cupidapp.live.hashtag.list;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: HashTagClassifyAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagClassifyAdapter extends RecyclerView.Adapter<HashTagClassifyViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final HashTagListViewModel f14709a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<HashTagClassifyModel> f14710b;

    public HashTagClassifyAdapter(@NotNull HashTagListViewModel viewModel) {
        s.i(viewModel, "viewModel");
        this.f14709a = viewModel;
        this.f14710b = new ArrayList();
    }

    public final void c(@NotNull List<HashTagClassifyModel> list) {
        s.i(list, "list");
        this.f14710b.clear();
        this.f14710b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull HashTagClassifyViewHolder holder, int i10) {
        s.i(holder, "holder");
        if (i10 == -1) {
            return;
        }
        holder.i(this.f14709a, this.f14710b.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public HashTagClassifyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        return HashTagClassifyViewHolder.f14711b.a(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14710b.size();
    }
}
