package com.cupidapp.live.club.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.club.fragment.ActivityOrderType;
import com.cupidapp.live.club.model.ActivityModel;
import com.cupidapp.live.club.model.ClubWonderfulActModel;
import com.cupidapp.live.club.viewholder.ActivityListItemViewHolder;
import com.cupidapp.live.club.viewholder.ActivityTopMenuModel;
import com.cupidapp.live.club.viewholder.ActivityTopMenuViewHolder;
import com.cupidapp.live.club.viewholder.ClubListTitleModel;
import com.cupidapp.live.club.viewholder.ClubListTitleViewHolder;
import com.cupidapp.live.club.viewholder.EmptyListModel;
import com.cupidapp.live.club.viewholder.EmptyListViewHolder;
import com.cupidapp.live.club.viewholder.WonderfulActivityViewHolder;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import h1.a;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityListAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final SensorPosition f13503f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f13504g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public ActivityOrderType f13505h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public WonderfulActivityViewHolder f13506i;

    /* renamed from: j, reason: collision with root package name */
    public int f13507j;

    /* compiled from: ActivityListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13508a;

        static {
            int[] iArr = new int[ActivityOrderType.values().length];
            try {
                iArr[ActivityOrderType.RecommendOrder.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActivityOrderType.DistanceOrder.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActivityOrderType.CommentCountOrder.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13508a = iArr;
        }
    }

    public ActivityListAdapter(@NotNull SensorPosition sensorPosition) {
        s.i(sensorPosition, "sensorPosition");
        this.f13503f = sensorPosition;
        this.f13505h = ActivityOrderType.RecommendOrder;
        k().add(ActivityTopMenuModel.class);
        k().add(ActivityModel.class);
        k().add(ClubListTitleModel.class);
        k().add(ClubWonderfulActModel.class);
        k().add(EmptyListModel.class);
        k().add(FKFooterViewModel.class);
    }

    @NotNull
    public final ActivityOrderType A() {
        return this.f13505h;
    }

    public final PostAndSocialProtos.Enum_type B(ActivityOrderType activityOrderType) {
        int i10 = a.f13508a[activityOrderType.ordinal()];
        if (i10 == 1) {
            return PostAndSocialProtos.Enum_type.RECOMMEND;
        }
        if (i10 == 2) {
            return PostAndSocialProtos.Enum_type.DISTANCE;
        }
        if (i10 == 3) {
            return PostAndSocialProtos.Enum_type.SCORE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder fKBaseRecyclerViewHolder;
        s.i(parent, "parent");
        if (i10 == 0) {
            fKBaseRecyclerViewHolder = ActivityTopMenuViewHolder.f13680c.a(parent);
        } else if (i10 == 1) {
            fKBaseRecyclerViewHolder = ActivityListItemViewHolder.f13679c.a(parent);
        } else if (i10 == 2) {
            fKBaseRecyclerViewHolder = ClubListTitleViewHolder.f13692d.a(parent, this.f13504g);
        } else if (i10 == 3) {
            WonderfulActivityViewHolder a10 = WonderfulActivityViewHolder.f13698e.a(parent, this.f13503f);
            this.f13506i = a10;
            s.f(a10);
            fKBaseRecyclerViewHolder = a10;
        } else if (i10 != 4) {
            fKBaseRecyclerViewHolder = FKFooterViewHolder.f12036c.a(parent);
        } else {
            fKBaseRecyclerViewHolder = EmptyListViewHolder.f13694c.a(parent);
        }
        fKBaseRecyclerViewHolder.k(l());
        return fKBaseRecyclerViewHolder;
    }

    public final void D() {
        this.f13507j = 0;
    }

    public final void E() {
        WonderfulActivityViewHolder wonderfulActivityViewHolder = this.f13506i;
        if (wonderfulActivityViewHolder != null) {
            wonderfulActivityViewHolder.t();
        }
    }

    public final void F(@NotNull RecyclerView recyclerView, @NotNull final SensorPosition position) {
        s.i(recyclerView, "recyclerView");
        s.i(position, "position");
        t(new RecyclerExposureHelper(ExposureScene.ActivityList, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.club.adapter.ActivityListAdapter$setExposureHelper$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
            
                r1 = r7.f13506i;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.NotNull java.util.List<h1.a> r9) {
                /*
                    r8 = this;
                    java.lang.String r0 = "itemList"
                    kotlin.jvm.internal.s.i(r9, r0)
                    com.cupidapp.live.base.sensorslog.SensorPosition r0 = com.cupidapp.live.base.sensorslog.SensorPosition.this
                    com.cupidapp.live.club.adapter.ActivityListAdapter r7 = r2
                    java.util.Iterator r9 = r9.iterator2()
                Ld:
                    boolean r1 = r9.hasNext()
                    if (r1 == 0) goto L4d
                    java.lang.Object r1 = r9.next()
                    h1.a r1 = (h1.a) r1
                    java.lang.Object r1 = r1.a()
                    boolean r2 = r1 instanceof com.cupidapp.live.club.model.ActivityModel
                    if (r2 == 0) goto L3f
                    com.cupidapp.live.track.group.GroupSocialLog r2 = com.cupidapp.live.track.group.GroupSocialLog.f18708a
                    com.cupidapp.live.club.model.ActivityModel r1 = (com.cupidapp.live.club.model.ActivityModel) r1
                    java.lang.String r3 = r1.getActivityId()
                    com.cupidapp.live.track.group.GroupSocialLog$CardType r4 = com.cupidapp.live.track.group.GroupSocialLog.CardType.Activity
                    int r5 = com.cupidapp.live.club.adapter.ActivityListAdapter.u(r7, r1)
                    com.cupidapp.live.club.fragment.ActivityOrderType r1 = r7.A()
                    com.irisdt.client.post.PostAndSocialProtos$Enum_type r6 = com.cupidapp.live.club.adapter.ActivityListAdapter.v(r7, r1)
                    r1 = r2
                    r2 = r3
                    r3 = r4
                    r4 = r0
                    r1.h(r2, r3, r4, r5, r6)
                    goto Ld
                L3f:
                    boolean r1 = r1 instanceof com.cupidapp.live.club.model.ClubWonderfulActModel
                    if (r1 == 0) goto Ld
                    com.cupidapp.live.club.viewholder.WonderfulActivityViewHolder r1 = com.cupidapp.live.club.adapter.ActivityListAdapter.w(r7)
                    if (r1 == 0) goto Ld
                    r1.s()
                    goto Ld
                L4d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.adapter.ActivityListAdapter$setExposureHelper$1.invoke2(java.util.List):void");
            }
        }, 28, null));
    }

    public final void G(@NotNull ActivityOrderType activityOrderType) {
        s.i(activityOrderType, "<set-?>");
        this.f13505h = activityOrderType;
    }

    public final void H(@Nullable Function1<? super Integer, p> function1) {
        this.f13504g = function1;
    }

    public final void x(@NotNull ActivityModel model, @NotNull SensorPosition position) {
        s.i(model, "model");
        s.i(position, "position");
        GroupSocialLog.f18708a.g(model.getActivityId(), GroupSocialLog.CardType.Activity, position, z(model), position == SensorPosition.ClubGroupActivity ? null : B(this.f13505h));
    }

    public final void y() {
        this.f13507j++;
    }

    public final int z(ActivityModel activityModel) {
        return Math.max((j().indexOf(activityModel) - this.f13507j) + 1, 0);
    }
}
