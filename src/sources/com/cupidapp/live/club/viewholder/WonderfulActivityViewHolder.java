package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.club.adapter.ClubBannerAdapter;
import com.cupidapp.live.club.model.ClubBannerModel;
import com.cupidapp.live.club.model.ClubWonderfulActModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: WonderfulActivityViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WonderfulActivityViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f13698e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final SensorPosition f13699c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ClubBannerAdapter f13700d;

    /* compiled from: WonderfulActivityViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WonderfulActivityViewHolder a(@NotNull ViewGroup parent, @NotNull SensorPosition sensorPosition) {
            s.i(parent, "parent");
            s.i(sensorPosition, "sensorPosition");
            return new WonderfulActivityViewHolder(z.b(parent, R$layout.item_wonderful_activity, false, 2, null), sensorPosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WonderfulActivityViewHolder(@NotNull View itemView, @NotNull SensorPosition sensorPosition) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(sensorPosition, "sensorPosition");
        this.f13699c = sensorPosition;
        RecyclerView _init_$lambda$0 = (RecyclerView) itemView.findViewById(R$id.wonderful_rv);
        _init_$lambda$0.setLayoutManager(new LinearLayoutManager(_init_$lambda$0.getContext(), 0, false));
        s.h(_init_$lambda$0, "_init_$lambda$0");
        _init_$lambda$0.addItemDecoration(new ExtraSpacingDecoration(h.c(_init_$lambda$0, 8.0f), 0, 0, 0, h.c(_init_$lambda$0, 8.0f)));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        ClubBannerAdapter clubBannerAdapter;
        List<Object> j10;
        List<Object> j11;
        if (obj instanceof ClubWonderfulActModel) {
            ClubWonderfulActModel clubWonderfulActModel = (ClubWonderfulActModel) obj;
            ((TextView) this.itemView.findViewById(R$id.wonderful_title)).setText(clubWonderfulActModel.getTitle());
            if (this.f13700d == null) {
                View view = this.itemView;
                int i10 = R$id.wonderful_rv;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(i10);
                s.h(recyclerView, "itemView.wonderful_rv");
                final ClubBannerAdapter clubBannerAdapter2 = new ClubBannerAdapter(recyclerView, this.f13699c);
                clubBannerAdapter2.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.club.viewholder.WonderfulActivityViewHolder$config$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                        invoke2(obj2);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj2) {
                        if (obj2 instanceof ClubBannerModel) {
                            ClubBannerModel clubBannerModel = (ClubBannerModel) obj2;
                            j.a.b(j.f12156c, WonderfulActivityViewHolder.this.itemView.getContext(), clubBannerModel.getJumpUrl(), null, 4, null);
                            GroupOthersLog.f18702a.i(clubBannerModel.getActId(), WonderfulActivityViewHolder.this.r(), Integer.valueOf(clubBannerAdapter2.j().indexOf(obj2) + 1));
                        }
                    }
                });
                this.f13700d = clubBannerAdapter2;
                ((RecyclerView) this.itemView.findViewById(i10)).setAdapter(this.f13700d);
            }
            ClubBannerAdapter clubBannerAdapter3 = this.f13700d;
            if (clubBannerAdapter3 != null && (j11 = clubBannerAdapter3.j()) != null) {
                j11.clear();
            }
            List<ClubBannerModel> list = clubWonderfulActModel.getList();
            if (list != null && (clubBannerAdapter = this.f13700d) != null && (j10 = clubBannerAdapter.j()) != null) {
                j10.addAll(list);
            }
            ClubBannerAdapter clubBannerAdapter4 = this.f13700d;
            if (clubBannerAdapter4 != null) {
                clubBannerAdapter4.notifyDataSetChanged();
            }
        }
    }

    @NotNull
    public final SensorPosition r() {
        return this.f13699c;
    }

    public final void s() {
        RecyclerExposureHelper g3;
        ClubBannerAdapter clubBannerAdapter = this.f13700d;
        if (clubBannerAdapter == null || (g3 = clubBannerAdapter.g()) == null) {
            return;
        }
        g3.i();
    }

    public final void t() {
        ((RecyclerView) this.itemView.findViewById(R$id.wonderful_rv)).scrollToPosition(0);
    }
}
