package com.cupidapp.live.liveshow.adapter;

import android.os.CountDownTimer;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowNextListResult;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.view.FollowLiveStatusLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.z;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveForViewerPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForViewerPagerAdapter extends FragmentStateAdapter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<LiveShowModel> f14813b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.liveshow.adapter.a f14814c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14815d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final LiveInRoomSensorModel f14816e;

    /* renamed from: f, reason: collision with root package name */
    public int f14817f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public LiveShowModel f14818g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<LiveShowModel> f14819h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f14820i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public CountDownTimer f14821j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14822k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public String f14823l;

    /* compiled from: FKLiveForViewerPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends CountDownTimer {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FKLiveForViewerPagerAdapter.this.n();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    public /* synthetic */ FKLiveForViewerPagerAdapter(FragmentActivity fragmentActivity, List list, com.cupidapp.live.liveshow.adapter.a aVar, boolean z10, LiveInRoomSensorModel liveInRoomSensorModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, list, aVar, (i10 & 8) != 0 ? true : z10, liveInRoomSensorModel);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int i10) {
        return FKLiveForViewerFragment.f15014v.a(this.f14816e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public final void j() {
        CountDownTimer countDownTimer = this.f14821j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f14821j = null;
    }

    public final List<LiveShowModel> k() {
        return (List) this.f14820i.getValue();
    }

    public final LiveShowModel l(boolean z10) {
        Object V = CollectionsKt___CollectionsKt.V(k());
        z.a(k()).remove(V);
        if (V == null) {
            List<LiveShowModel> list = this.f14819h;
            V = (LiveShowModel) (z10 ? CollectionsKt___CollectionsKt.V(list) : CollectionsKt___CollectionsKt.f0(list));
            z.a(this.f14819h).remove(V);
        } else {
            List<LiveShowModel> list2 = this.f14819h;
            ArrayList arrayList = new ArrayList();
            for (LiveShowModel liveShowModel : list2) {
                if (s.d(liveShowModel.getItemId(), ((LiveShowModel) V).getItemId())) {
                    arrayList.add(liveShowModel);
                }
            }
            this.f14819h.removeAll(arrayList);
        }
        LiveShowModel liveShowModel2 = (LiveShowModel) V;
        if (liveShowModel2 != null) {
            if (z10) {
                this.f14819h.add(liveShowModel2);
            } else {
                this.f14819h.add(0, liveShowModel2);
            }
        }
        return liveShowModel2;
    }

    public final void m(int i10) {
        LiveShowModel liveShowModel;
        if (this.f14815d && i10 == this.f14817f) {
            this.f14815d = false;
            liveShowModel = (LiveShowModel) CollectionsKt___CollectionsKt.V(k());
            z.a(k()).remove(liveShowModel);
            if (liveShowModel != null) {
                this.f14819h.add(liveShowModel);
            }
        } else {
            int Y = CollectionsKt___CollectionsKt.Y(this.f14819h, this.f14818g);
            if (Y == -1) {
                Y = 0;
            }
            int i11 = this.f14817f;
            if (i11 > i10) {
                if (Y <= 0) {
                    liveShowModel = l(false);
                } else {
                    liveShowModel = this.f14819h.get(Y - 1);
                }
            } else if (i11 >= i10) {
                liveShowModel = null;
            } else if (Y >= kotlin.collections.s.l(this.f14819h)) {
                liveShowModel = l(true);
            } else {
                liveShowModel = this.f14819h.get(Y + 1);
            }
            o();
            LiveInRoomSensorModel liveInRoomSensorModel = this.f14816e;
            if (liveInRoomSensorModel != null) {
                liveInRoomSensorModel.setEnterSource("SWITCH");
                liveInRoomSensorModel.setSensorPosition(SensorPosition.LiveShowRoom);
                liveInRoomSensorModel.setListIndex(null);
            }
        }
        this.f14817f = i10;
        this.f14818g = liveShowModel;
        if (k().size() < 3 && this.f14819h.size() > 0) {
            n();
        }
        if (liveShowModel != null) {
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            fKLiveConstantsData.resetLiveConstantsData();
            fKLiveConstantsData.setFkLiveShowResult(LiveShowResult.Companion.a(liveShowModel));
        }
    }

    public final void n() {
        if (this.f14822k) {
            return;
        }
        this.f14822k = true;
        j();
        List<LiveShowModel> list = this.f14819h;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<LiveShowModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getItemId());
        }
        this.f14814c.C(arrayList, this.f14823l, new Function1<LiveShowNextListResult, p>() { // from class: com.cupidapp.live.liveshow.adapter.FKLiveForViewerPagerAdapter$refreshRecommendLiveShow$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowNextListResult liveShowNextListResult) {
                invoke2(liveShowNextListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LiveShowNextListResult it) {
                List k10;
                List k11;
                List list2;
                List k12;
                List k13;
                s.i(it, "it");
                k10 = FKLiveForViewerPagerAdapter.this.k();
                k10.clear();
                k11 = FKLiveForViewerPagerAdapter.this.k();
                k11.addAll(it.getList());
                FKLiveForViewerPagerAdapter.this.f14823l = it.getData();
                list2 = FKLiveForViewerPagerAdapter.this.f14819h;
                ArrayList arrayList2 = new ArrayList(t.t(list2, 10));
                Iterator<E> iterator22 = list2.iterator2();
                while (iterator22.hasNext()) {
                    arrayList2.add(((LiveShowModel) iterator22.next()).getItemId());
                }
                k12 = FKLiveForViewerPagerAdapter.this.k();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : k12) {
                    if (arrayList2.contains(((LiveShowModel) obj).getItemId())) {
                        arrayList3.add(obj);
                    }
                }
                k13 = FKLiveForViewerPagerAdapter.this.k();
                k13.removeAll(arrayList3);
                FKLiveForViewerPagerAdapter.this.p(it.getTtl());
                FKLiveForViewerPagerAdapter.this.f14822k = false;
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.adapter.FKLiveForViewerPagerAdapter$refreshRecommendLiveShow$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveForViewerPagerAdapter.this.p(5L);
                FKLiveForViewerPagerAdapter.this.f14822k = false;
            }
        });
    }

    public final void o() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel != null && fKLiveConstantsData.getLiveShowViewDuration() != null) {
            SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
            String itemId = liveShowModel.getItemId();
            String userId = liveShowModel.getUser().userId();
            Boolean valueOf = Boolean.valueOf(liveShowModel.getUser().getAloha());
            Long liveShowViewDuration = fKLiveConstantsData.getLiveShowViewDuration();
            s.f(liveShowViewDuration);
            int longValue = (int) liveShowViewDuration.longValue();
            LiveInRoomSensorModel liveInRoomSensorModel = this.f14816e;
            SensorScene scene = liveInRoomSensorModel != null ? liveInRoomSensorModel.getScene() : null;
            String fkLiveStrategyId = fKLiveConstantsData.getFkLiveStrategyId();
            LiveInRoomSensorModel liveInRoomSensorModel2 = this.f14816e;
            sensorsLogLiveShow.d(itemId, userId, valueOf, longValue, scene, fkLiveStrategyId, liveInRoomSensorModel2 != null ? liveInRoomSensorModel2.getEnterSource() : null, fKLiveConstantsData.getFkLiveType(), Boolean.FALSE);
        }
        fKLiveConstantsData.leaveRoomResetData();
        FollowLiveStatusLayout.f15289g.k();
    }

    public final void p(long j10) {
        j();
        long j11 = j10 * 1000;
        a aVar = new a(j11, j11);
        this.f14821j = aVar;
        aVar.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForViewerPagerAdapter(@NotNull FragmentActivity activity, @NotNull List<LiveShowModel> list, @NotNull com.cupidapp.live.liveshow.adapter.a dataSource, boolean z10, @Nullable LiveInRoomSensorModel liveInRoomSensorModel) {
        super(activity);
        s.i(activity, "activity");
        s.i(list, "list");
        s.i(dataSource, "dataSource");
        this.f14813b = list;
        this.f14814c = dataSource;
        this.f14815d = z10;
        this.f14816e = liveInRoomSensorModel;
        this.f14817f = View.LAST_APP_AUTOFILL_ID;
        this.f14819h = new ArrayList();
        this.f14820i = c.b(new Function0<List<LiveShowModel>>() { // from class: com.cupidapp.live.liveshow.adapter.FKLiveForViewerPagerAdapter$cachedLiveShowModels$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<LiveShowModel> invoke() {
                List list2;
                ArrayList arrayList = new ArrayList();
                list2 = FKLiveForViewerPagerAdapter.this.f14813b;
                arrayList.addAll(list2);
                return arrayList;
            }
        });
    }
}
