package com.cupidapp.live.chat2.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.chat2.holder.SurveyChatOptionsMessageViewHolder;
import com.cupidapp.live.chat2.holder.SurveyChatSystemMessageViewHolder;
import com.cupidapp.live.chat2.holder.SurveyChatTextMessageViewHolder;
import com.cupidapp.live.chat2.model.SurveyChatOptionsMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatSystemMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatTextMessageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SurveyChatAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatAdapter extends FKBaseRecyclerViewAdapter {
    public SurveyChatAdapter() {
        k().add(SurveyChatSystemMessageModel.class);
        k().add(SurveyChatTextMessageModel.class);
        k().add(SurveyChatOptionsMessageModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        if (i10 == 0) {
            return SurveyChatSystemMessageViewHolder.f13396c.a(parent);
        }
        if (i10 == 1) {
            return SurveyChatTextMessageViewHolder.f13400c.a(parent);
        }
        if (i10 != 2) {
            return SurveyChatSystemMessageViewHolder.f13396c.a(parent);
        }
        return SurveyChatOptionsMessageViewHolder.f13395c.a(parent);
    }
}
