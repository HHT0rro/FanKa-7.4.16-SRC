package com.cupidapp.live.notify.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.notify.fragment.NotifyContainerNewFragment;
import com.cupidapp.live.notify.fragment.NotifyPageType;
import j1.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: NotifyActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f17492s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public o f17493q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17494r = new LinkedHashMap();

    /* compiled from: NotifyActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, NotifyPageType notifyPageType, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            aVar.a(context, notifyPageType, z10);
        }

        public final void a(@Nullable Context context, @NotNull NotifyPageType pageType, boolean z10) {
            s.i(pageType, "pageType");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) NotifyActivity.class);
            g.c(intent, pageType);
            intent.putExtra("defaultShowPurchaseDialog", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: NotifyActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements o.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            k.f50238a.a(NotifyActivity.this.Q0(), (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            s.i(imageUriString, "imageUriString");
            k.f50238a.d(NotifyActivity.this.Q0(), z10);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        SensorPosition O0;
        FKBaseFragment R0 = R0();
        return (R0 == null || (O0 = R0.O0()) == null) ? SensorPosition.Unknown : O0;
    }

    public final void j1(NotifyPageType notifyPageType, boolean z10) {
        l1(notifyPageType, z10);
    }

    public final void k1() {
        o c4 = o.f12354i.c(this);
        this.f17493q = c4;
        if (c4 != null) {
            c4.l(new b());
        }
    }

    public final void l1(NotifyPageType notifyPageType, boolean z10) {
        FKBaseActivity.g1(this, NotifyContainerNewFragment.f17540h.b(notifyPageType, z10), false, R$id.notify_root_layout, false, false, 24, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_notify);
        Intent intent = getIntent();
        s.h(intent, "intent");
        NotifyPageType notifyPageType = (NotifyPageType) g.a(intent, NotifyPageType.class);
        if (notifyPageType == null) {
            notifyPageType = NotifyPageType.Follow;
        }
        j1(notifyPageType, getIntent().getBooleanExtra("defaultShowPurchaseDialog", false));
        k1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        o oVar = this.f17493q;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        o oVar = this.f17493q;
        if (oVar != null) {
            oVar.m();
        }
    }
}
