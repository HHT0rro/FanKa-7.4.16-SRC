package com.cupidapp.live.mediapicker.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.holder.LocationViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocationAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocationAdapter extends FKBaseRecyclerViewAdapter {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        LocationViewHolder a10 = LocationViewHolder.f17253c.a(parent);
        a10.k(l());
        return a10;
    }
}