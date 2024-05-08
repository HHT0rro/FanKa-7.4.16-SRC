package com.cupidapp.live.hashtag.list;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.hashtag.model.HashTag;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagContentAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagContentAdapter extends RecyclerView.Adapter<HashTagContentViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final HashTagListViewModel f14713a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<HashTag> f14714b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14715c;

    public HashTagContentAdapter(@NotNull HashTagListViewModel viewModel) {
        s.i(viewModel, "viewModel");
        this.f14713a = viewModel;
        this.f14714b = new ArrayList();
    }

    @Nullable
    public final HashTag c(int i10) {
        if (i10 < 0 || i10 >= this.f14714b.size()) {
            return null;
        }
        return this.f14714b.get(i10);
    }

    public final void d(@NotNull List<HashTag> list, boolean z10) {
        s.i(list, "list");
        this.f14715c = z10;
        this.f14714b.clear();
        this.f14714b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull HashTagContentViewHolder holder, int i10) {
        s.i(holder, "holder");
        holder.i(this.f14713a, c(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public HashTagContentViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        return HashTagContentViewHolder.f14716b.a(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14714b.size();
    }
}
