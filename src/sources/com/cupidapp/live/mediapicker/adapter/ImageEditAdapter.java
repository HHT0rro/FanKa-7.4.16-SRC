package com.cupidapp.live.mediapicker.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.holder.AddImageViewHolder;
import com.cupidapp.live.mediapicker.holder.ImageEditViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ImageEditAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageEditAdapter extends FKBaseRecyclerViewAdapter {
    public ImageEditAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(ImageEditViewModel.class);
        k10.add(AddImageViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder d10;
        s.i(parent, "parent");
        if (i10 == 0) {
            d10 = ImageEditViewHolder.f17252c.d(parent);
        } else if (i10 != 1) {
            d10 = AddImageViewHolder.f17247c.a(parent);
        } else {
            d10 = AddImageViewHolder.f17247c.a(parent);
        }
        d10.k(l());
        return d10;
    }
}
