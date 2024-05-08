package com.cupidapp.live.liveshow.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.activity.FKNearbyLiveListActivity;
import com.cupidapp.live.liveshow.activity.LiveshowOpenSource;
import com.cupidapp.live.liveshow.adapter.FKFollowOrNearbyLiveShowAdapter;
import com.cupidapp.live.liveshow.adapter.FKFollowOrNearbyLiveShowModel;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKFollowOrNearbyUserLiveViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKFollowOrNearbyUserLiveViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16032d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f16033c;

    /* compiled from: FKFollowOrNearbyUserLiveViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFollowOrNearbyUserLiveViewHolder a(@NotNull ViewGroup parent, @NotNull SensorPosition position) {
            s.i(parent, "parent");
            s.i(position, "position");
            return new FKFollowOrNearbyUserLiveViewHolder(z.b(parent, R$layout.view_holder_live_show_follow_tips, false, 2, null), position);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFollowOrNearbyUserLiveViewHolder(@NotNull final View itemView, @NotNull final SensorPosition position) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(position, "position");
        this.f16033c = c.b(new Function0<FKFollowOrNearbyLiveShowAdapter>() { // from class: com.cupidapp.live.liveshow.viewholder.FKFollowOrNearbyUserLiveViewHolder$userAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKFollowOrNearbyLiveShowAdapter invoke() {
                RecyclerView recyclerView = (RecyclerView) View.this.findViewById(R$id.followUserLiveRecyclerView);
                s.h(recyclerView, "itemView.followUserLiveRecyclerView");
                FKFollowOrNearbyLiveShowAdapter fKFollowOrNearbyLiveShowAdapter = new FKFollowOrNearbyLiveShowAdapter(recyclerView, position);
                final View view = View.this;
                final SensorPosition sensorPosition = position;
                fKFollowOrNearbyLiveShowAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.viewholder.FKFollowOrNearbyUserLiveViewHolder$userAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof FKFollowOrNearbyLiveShowModel) {
                            FKFollowOrNearbyLiveShowModel fKFollowOrNearbyLiveShowModel = (FKFollowOrNearbyLiveShowModel) obj;
                            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, View.this.getContext(), new FKLiveForViewerViewModel(fKFollowOrNearbyLiveShowModel.getLiveShow(), LiveshowOpenSource.Follow, new LiveInRoomSensorModel(fKFollowOrNearbyLiveShowModel.getEnterSource().name(), null, SensorScene.Live, sensorPosition, null, null, 48, null), false, 8, null), false, 4, null);
                        }
                    }
                });
                return fKFollowOrNearbyLiveShowAdapter;
            }
        });
        RecyclerView _init_$lambda$0 = (RecyclerView) itemView.findViewById(R$id.followUserLiveRecyclerView);
        _init_$lambda$0.setAdapter(r());
        _init_$lambda$0.setLayoutManager(new LinearLayoutManager(itemView.getContext(), 0, false));
        s.h(_init_$lambda$0, "_init_$lambda$0");
        int c4 = h.c(_init_$lambda$0, 2.0f);
        _init_$lambda$0.addItemDecoration(new ExtraSpacingDecoration(c4, 0, c4, 0, h.c(_init_$lambda$0, 8.0f)));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FollowOrNearbyUserLiveViewModel) {
            FollowOrNearbyUserLiveViewModel followOrNearbyUserLiveViewModel = (FollowOrNearbyUserLiveViewModel) obj;
            String title = followOrNearbyUserLiveViewModel.getTitle();
            if (title == null || title.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.followOrNearbyUserLiveTitle)).setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.followOrNearbyUserLiveTitle;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(followOrNearbyUserLiveViewModel.getTitle());
            }
            if (followOrNearbyUserLiveViewModel.getEnterSource() == SensorsLogLiveShow.EnterLiveShowSource.LIVE_NEARBY && followOrNearbyUserLiveViewModel.getHaveMore()) {
                View view2 = this.itemView;
                int i11 = R$id.moreNearbyLive;
                ((LinearLayout) view2.findViewById(i11)).setVisibility(0);
                LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(i11);
                s.h(linearLayout, "itemView.moreNearbyLive");
                y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.viewholder.FKFollowOrNearbyUserLiveViewHolder$config$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view3) {
                        invoke2(view3);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view3) {
                        FKNearbyLiveListActivity.a aVar = FKNearbyLiveListActivity.f14788r;
                        Context context = FKFollowOrNearbyUserLiveViewHolder.this.itemView.getContext();
                        s.h(context, "itemView.context");
                        aVar.a(context);
                    }
                });
            } else {
                ((LinearLayout) this.itemView.findViewById(R$id.moreNearbyLive)).setVisibility(8);
            }
            r().j().clear();
            r().e(followOrNearbyUserLiveViewModel.getLiveList());
            r().notifyDataSetChanged();
        }
    }

    public final FKFollowOrNearbyLiveShowAdapter r() {
        return (FKFollowOrNearbyLiveShowAdapter) this.f16033c.getValue();
    }
}
