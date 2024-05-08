package com.cupidapp.live.consult.helper;

import android.content.Context;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.consult.view.ConsultConnectGuideLayout;
import com.cupidapp.live.consult.view.ConsultRoomFirstEnterGuideLayout;
import com.cupidapp.live.consult.view.StayGuideShowTimeModel;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.v;

/* compiled from: ConsultRoomGuideHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultRoomGuideHelper {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public i f13822a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13823b;

    public final void b() {
        f();
        ConsultConnectGuideLayout.f13854e.a();
    }

    public final void c(@Nullable Context context, @Nullable Integer num, @NotNull Function0<p> finished) {
        s.i(finished, "finished");
        if (context == null) {
            return;
        }
        g gVar = g.f52734a;
        if (s.d(gVar.X0(), Boolean.TRUE)) {
            gVar.o3(Boolean.FALSE);
            ConsultRoomFirstEnterGuideLayout.f13868d.a(context);
        } else if (num != null) {
            d(num.intValue(), finished);
        }
    }

    public final void d(int i10, final Function0<p> function0) {
        this.f13823b = true;
        i iVar = this.f13822a;
        if (iVar != null) {
            iVar.g();
        }
        i iVar2 = new i();
        this.f13822a = iVar2;
        iVar2.c(Integer.valueOf(i10), 1, new Function0<p>() { // from class: com.cupidapp.live.consult.helper.ConsultRoomGuideHelper$showStayRoomGuide$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                function0.invoke();
                this.f13823b = false;
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.consult.helper.ConsultRoomGuideHelper$showStayRoomGuide$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                j.f12332a.a("ConsultRoomGuideHelper", "tick: " + i11);
            }
        });
    }

    public final void e(@Nullable Context context, @NotNull User user, @Nullable Integer num, @NotNull Function0<p> connectCallback) {
        s.i(user, "user");
        s.i(connectCallback, "connectCallback");
        if (context == null || num == null) {
            return;
        }
        num.intValue();
        g gVar = g.f52734a;
        StayGuideShowTimeModel V0 = gVar.V0();
        if (V0 == null) {
            V0 = new StayGuideShowTimeModel(new ArrayList());
        }
        List<Long> timeList = V0.getTimeList();
        Long l10 = (Long) CollectionsKt___CollectionsKt.f0(timeList);
        long currentTimeMillis = System.currentTimeMillis();
        if (l10 != null) {
            if (!v.m(l10.longValue(), currentTimeMillis)) {
                timeList.clear();
                timeList.add(Long.valueOf(currentTimeMillis));
            } else if (timeList.size() >= num.intValue()) {
                return;
            } else {
                timeList.add(Long.valueOf(currentTimeMillis));
            }
        } else {
            timeList.add(Long.valueOf(currentTimeMillis));
        }
        gVar.m3(V0);
        ConsultConnectGuideLayout.f13854e.b(context, user, connectCallback);
    }

    public final void f() {
        if (this.f13823b) {
            i iVar = this.f13822a;
            if (iVar != null) {
                iVar.g();
            }
            this.f13822a = null;
            this.f13823b = false;
        }
    }
}
