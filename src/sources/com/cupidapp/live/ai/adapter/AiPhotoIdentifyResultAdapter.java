package com.cupidapp.live.ai.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AiPhotoIdentifyResultAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiPhotoIdentifyResultAdapter extends FKBaseRecyclerViewAdapter {
    public AiPhotoIdentifyResultAdapter() {
        k().add(NearbyUserProfileModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        AiPhotoIdentifyResultViewHolder a10 = AiPhotoIdentifyResultViewHolder.f11645c.a(parent);
        a10.k(l());
        return a10;
    }
}
