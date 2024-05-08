package com.cupidapp.live.consult.adapter;

import android.os.CountDownTimer;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.fragment.ConsultViewerFragment;
import com.cupidapp.live.consult.model.ConsultLiveNextListResult;
import com.cupidapp.live.track.group.EnterConsultRoomSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.collections.x;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.z;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultViewerPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultViewerPagerAdapter extends FragmentStateAdapter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final ConsultViewerActivity.Config f13744b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final a f13745c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13746d;

    /* renamed from: e, reason: collision with root package name */
    public int f13747e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ConsultViewerActivity.Config f13748f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final List<ConsultViewerActivity.Config> f13749g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f13750h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public CountDownTimer f13751i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13752j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public String f13753k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public ConsultViewerFragment f13754l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public ConsultViewerFragment f13755m;

    /* compiled from: ConsultViewerPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void Q(@NotNull List<String> list, @Nullable String str, @NotNull Function1<? super ConsultLiveNextListResult, p> function1, @NotNull Function0<p> function0);
    }

    /* compiled from: ConsultViewerPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConsultViewerPagerAdapter f13756a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j10, ConsultViewerPagerAdapter consultViewerPagerAdapter) {
            super(j10, j10);
            this.f13756a = consultViewerPagerAdapter;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f13756a.m();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultViewerPagerAdapter(@NotNull FragmentActivity activity, @NotNull ConsultViewerActivity.Config mConfig, @NotNull a mListener) {
        super(activity);
        s.i(activity, "activity");
        s.i(mConfig, "mConfig");
        s.i(mListener, "mListener");
        this.f13744b = mConfig;
        this.f13745c = mListener;
        this.f13746d = true;
        this.f13747e = View.LAST_APP_AUTOFILL_ID;
        this.f13749g = new ArrayList();
        this.f13750h = c.b(new Function0<List<ConsultViewerActivity.Config>>() { // from class: com.cupidapp.live.consult.adapter.ConsultViewerPagerAdapter$mCachedConfigs$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<ConsultViewerActivity.Config> invoke() {
                ConsultViewerActivity.Config config;
                ArrayList arrayList = new ArrayList();
                config = ConsultViewerPagerAdapter.this.f13744b;
                arrayList.add(config);
                return arrayList;
            }
        });
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int i10) {
        ConsultViewerFragment a10 = ConsultViewerFragment.f13790q.a();
        this.f13755m = a10;
        ConsultViewerActivity.Config config = this.f13748f;
        if (i10 == this.f13747e && config != null) {
            a10.J1(config);
            this.f13754l = this.f13755m;
        }
        return a10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public final void j() {
        CountDownTimer countDownTimer = this.f13751i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f13751i = null;
    }

    @Nullable
    public final ConsultViewerFragment k() {
        return this.f13754l;
    }

    public final List<ConsultViewerActivity.Config> l() {
        return (List) this.f13750h.getValue();
    }

    public final void m() {
        if (this.f13752j) {
            return;
        }
        this.f13752j = true;
        j();
        List<ConsultViewerActivity.Config> list = this.f13749g;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<ConsultViewerActivity.Config> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getRoomId());
        }
        this.f13745c.Q(arrayList, this.f13753k, new Function1<ConsultLiveNextListResult, p>() { // from class: com.cupidapp.live.consult.adapter.ConsultViewerPagerAdapter$loadNewestData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultLiveNextListResult consultLiveNextListResult) {
                invoke2(consultLiveNextListResult);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
            
                if ((r7 == null || r7.length() == 0) == false) goto L25;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.NotNull com.cupidapp.live.consult.model.ConsultLiveNextListResult r17) {
                /*
                    Method dump skipped, instructions count: 283
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.consult.adapter.ConsultViewerPagerAdapter$loadNewestData$1.invoke2(com.cupidapp.live.consult.model.ConsultLiveNextListResult):void");
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.consult.adapter.ConsultViewerPagerAdapter$loadNewestData$2
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
                ConsultViewerPagerAdapter.this.p(5L);
                ConsultViewerPagerAdapter.this.f13752j = false;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.cupidapp.live.consult.activity.ConsultViewerActivity$Config, T, java.lang.Object] */
    public final ConsultViewerActivity.Config n(boolean z10) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = CollectionsKt___CollectionsKt.V(l());
        z.a(l()).remove(ref$ObjectRef.element);
        if (ref$ObjectRef.element == 0) {
            List<ConsultViewerActivity.Config> list = this.f13749g;
            ?? r12 = (ConsultViewerActivity.Config) (z10 ? CollectionsKt___CollectionsKt.V(list) : CollectionsKt___CollectionsKt.f0(list));
            ref$ObjectRef.element = r12;
            z.a(this.f13749g).remove(r12);
        } else {
            x.B(this.f13749g, new Function1<ConsultViewerActivity.Config, Boolean>() { // from class: com.cupidapp.live.consult.adapter.ConsultViewerPagerAdapter$newConfig$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ConsultViewerActivity.Config it) {
                    s.i(it, "it");
                    return Boolean.valueOf(s.d(it.getRoomId(), ref$ObjectRef.element.getRoomId()));
                }
            });
        }
        ConsultViewerActivity.Config config = (ConsultViewerActivity.Config) ref$ObjectRef.element;
        if (config != null) {
            if (z10) {
                this.f13749g.add(config);
            } else {
                this.f13749g.add(0, config);
            }
        }
        return (ConsultViewerActivity.Config) ref$ObjectRef.element;
    }

    public final void o(int i10) {
        ConsultViewerActivity.Config config;
        if (this.f13746d && i10 == this.f13747e) {
            this.f13746d = false;
            config = (ConsultViewerActivity.Config) CollectionsKt___CollectionsKt.V(l());
            z.a(l()).remove(config);
            if (config != null) {
                this.f13749g.add(new ConsultViewerActivity.Config(config.getRoomId(), config.getCategory(), SensorPosition.CONSULT_ROOM.getValue(), EnterConsultRoomSource.Switch.getSource(), null, 16, null));
            }
        } else {
            int Y = CollectionsKt___CollectionsKt.Y(this.f13749g, this.f13748f);
            if (Y == -1) {
                Y = 0;
            }
            int i11 = this.f13747e;
            if (i11 > i10) {
                if (Y <= 0) {
                    config = n(false);
                } else {
                    config = this.f13749g.get(Y - 1);
                }
            } else if (i11 >= i10) {
                config = null;
            } else if (Y >= kotlin.collections.s.l(this.f13749g)) {
                config = n(true);
            } else {
                config = this.f13749g.get(Y + 1);
            }
            ConsultViewerFragment consultViewerFragment = this.f13754l;
            if (consultViewerFragment != null) {
                consultViewerFragment.S1();
            }
        }
        this.f13747e = i10;
        this.f13748f = config;
        if (l().size() < 3 && (!this.f13749g.isEmpty())) {
            m();
        }
        if (config != null) {
            ConsultViewerFragment consultViewerFragment2 = this.f13755m;
            if (consultViewerFragment2 != null) {
                consultViewerFragment2.J1(config);
            }
            this.f13754l = this.f13755m;
        }
    }

    public final void p(long j10) {
        j();
        b bVar = new b(j10 * 1000, this);
        this.f13751i = bVar;
        bVar.start();
    }
}
