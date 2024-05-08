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
import com.cupidapp.live.club.fragment.ClubOrderType;
import com.cupidapp.live.club.model.ClubModel;
import com.cupidapp.live.club.viewholder.ClubListItemViewHolder;
import com.cupidapp.live.club.viewholder.ClubListTitleModel;
import com.cupidapp.live.club.viewholder.ClubListTitleViewHolder;
import com.cupidapp.live.club.viewholder.MyClubModel;
import com.cupidapp.live.club.viewholder.MyClubViewHolder;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import h1.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f13512f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public ClubOrderType f13513g = ClubOrderType.NotJoined;

    /* compiled from: ClubListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13514a;

        static {
            int[] iArr = new int[ClubOrderType.values().length];
            try {
                iArr[ClubOrderType.All.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClubOrderType.NotJoined.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13514a = iArr;
        }
    }

    public ClubListAdapter() {
        k().add(MyClubModel.class);
        k().add(ClubListTitleModel.class);
        k().add(ClubModel.class);
        k().add(FKFooterViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = MyClubViewHolder.f13695d.a(parent);
        } else if (i10 == 1) {
            a10 = ClubListTitleViewHolder.f13692d.a(parent, this.f13512f);
        } else if (i10 != 2) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = ClubListItemViewHolder.f13691c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void B(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        t(new RecyclerExposureHelper(ExposureScene.ClubList, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.club.adapter.ClubListAdapter$setExposureHelper$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                int x10;
                PostAndSocialProtos.Enum_type z10;
                s.i(itemList, "itemList");
                ClubListAdapter clubListAdapter = ClubListAdapter.this;
                Iterator<a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof ClubModel) {
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        ClubModel clubModel = (ClubModel) a10;
                        String groupId = clubModel.getGroupId();
                        GroupSocialLog.CardType cardType = GroupSocialLog.CardType.Club;
                        SensorPosition sensorPosition = SensorPosition.ClubList;
                        x10 = clubListAdapter.x(clubModel);
                        z10 = clubListAdapter.z(clubListAdapter.y());
                        groupSocialLog.h(groupId, cardType, sensorPosition, x10, z10);
                    }
                }
            }
        }, 28, null));
    }

    public final void C(@NotNull ClubOrderType clubOrderType) {
        s.i(clubOrderType, "<set-?>");
        this.f13513g = clubOrderType;
    }

    public final void D(@Nullable Function1<? super Integer, p> function1) {
        this.f13512f = function1;
    }

    public final void w(@NotNull ClubModel model) {
        s.i(model, "model");
        GroupSocialLog.f18708a.g(model.getGroupId(), GroupSocialLog.CardType.Club, SensorPosition.ClubList, x(model), z(this.f13513g));
    }

    public final int x(ClubModel clubModel) {
        if (!j().contains(clubModel)) {
            return 0;
        }
        List<Object> j10 = j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof MyClubModel) {
                arrayList.add(obj);
            }
        }
        MyClubModel myClubModel = (MyClubModel) CollectionsKt___CollectionsKt.V(arrayList);
        int indexOf = j().indexOf(clubModel);
        return myClubModel == null ? indexOf : indexOf - 1;
    }

    @NotNull
    public final ClubOrderType y() {
        return this.f13513g;
    }

    public final PostAndSocialProtos.Enum_type z(ClubOrderType clubOrderType) {
        int i10 = a.f13514a[clubOrderType.ordinal()];
        if (i10 == 1) {
            return PostAndSocialProtos.Enum_type.ALL;
        }
        if (i10 == 2) {
            return PostAndSocialProtos.Enum_type.UN_JOIN;
        }
        throw new NoWhenBranchMatchedException();
    }
}
