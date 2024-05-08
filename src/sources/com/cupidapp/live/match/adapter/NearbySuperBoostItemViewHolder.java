package com.cupidapp.live.match.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.NearbyListModel;
import com.cupidapp.live.match.view.NearByExposureUserLayout;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearbySuperBoostAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbySuperBoostItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16638c = new a(null);

    /* compiled from: NearbySuperBoostAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NearbySuperBoostItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            Context context = parent.getContext();
            s.h(context, "parent.context");
            return new NearbySuperBoostItemViewHolder(new NearByExposureUserLayout(context));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbySuperBoostItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearbyListModel) {
            View view = this.itemView;
            NearByExposureUserLayout nearByExposureUserLayout = view instanceof NearByExposureUserLayout ? (NearByExposureUserLayout) view : null;
            if (nearByExposureUserLayout != null) {
                nearByExposureUserLayout.b((NearbyListModel) obj);
            }
        }
    }
}
