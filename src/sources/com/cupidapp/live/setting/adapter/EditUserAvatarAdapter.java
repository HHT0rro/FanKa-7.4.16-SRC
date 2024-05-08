package com.cupidapp.live.setting.adapter;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.holder.AddNewAvatarViewVipModel;
import com.cupidapp.live.setting.holder.AddNewAvatarViewWithVipHolder;
import com.cupidapp.live.setting.holder.EditUserAvatarUiModel;
import com.cupidapp.live.setting.holder.EditUserAvatarViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import z0.h;

/* compiled from: EditUserAvatarAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserAvatarAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f18085f = new a(null);

    /* compiled from: EditUserAvatarAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Size a(@NotNull View view) {
            s.i(view, "view");
            int l10 = ((h.l(view) - (h.c(this, 11.5f) * 2)) - (h.c(this, 16.0f) * 2)) / 3;
            return new Size(h.c(this, 9.0f) + l10, ((l10 * 4) / 3) + h.c(this, 12.0f));
        }
    }

    public EditUserAvatarAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(EditUserAvatarUiModel.class);
        k10.add(AddNewAvatarViewVipModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = EditUserAvatarViewHolder.f18188c.a(parent);
        } else {
            a10 = AddNewAvatarViewWithVipHolder.f18186c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
