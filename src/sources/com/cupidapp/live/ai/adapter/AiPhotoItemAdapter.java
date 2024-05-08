package com.cupidapp.live.ai.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AiPhotoItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiPhotoItemAdapter extends FKBaseRecyclerViewAdapter {
    public AiPhotoItemAdapter() {
        k().add(ImageModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        AiPhotoItemViewHolder a10 = AiPhotoItemViewHolder.f11646c.a(parent);
        a10.k(l());
        return a10;
    }
}
