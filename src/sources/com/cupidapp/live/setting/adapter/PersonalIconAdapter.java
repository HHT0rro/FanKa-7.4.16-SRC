package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.holder.PersonalIconViewHolder;
import com.cupidapp.live.setting.model.AppIconLocalDataModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PersonalIconAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PersonalIconAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public final int f18096f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f18097g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f18098h;

    public PersonalIconAdapter(int i10) {
        this.f18096f = i10;
        k().add(AppIconLocalDataModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        s.i(holder, "holder");
        if (holder instanceof PersonalIconViewHolder) {
            PersonalIconViewHolder personalIconViewHolder = (PersonalIconViewHolder) holder;
            personalIconViewHolder.r(this.f18097g);
            personalIconViewHolder.s(this.f18098h);
        }
        super.onBindViewHolder(holder, i10);
    }

    public final void u(@NotNull String selectIconId) {
        s.i(selectIconId, "selectIconId");
        this.f18097g = selectIconId;
    }

    public final void v(@NotNull String isUsingIconId) {
        s.i(isUsingIconId, "isUsingIconId");
        this.f18098h = isUsingIconId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        PersonalIconViewHolder a10 = PersonalIconViewHolder.f18191f.a(parent, this.f18097g, this.f18098h, this.f18096f);
        a10.k(l());
        return a10;
    }
}
