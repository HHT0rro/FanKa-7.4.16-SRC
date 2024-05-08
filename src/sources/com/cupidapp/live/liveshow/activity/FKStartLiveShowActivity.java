package com.cupidapp.live.liveshow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKStartLiveShowActivity;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: FKStartLiveShowActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKStartLiveShowActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f14790s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14792r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f14791q = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.liveshow.activity.FKStartLiveShowActivity$liveShowId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return FKStartLiveShowActivity.this.getIntent().getStringExtra("LIVE_SHOW_ID");
        }
    });

    /* compiled from: FKStartLiveShowActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            if (context != null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) FKStartLiveShowActivity.class);
                intent.putExtra("LIVE_SHOW_ID", str);
                intent.putExtra("ENTER_SOURCE", str2);
                intent.putExtra("LIVE_FROM", str3);
                context.startActivity(intent);
            }
        }
    }

    /* compiled from: FKStartLiveShowActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            FKStartLiveShowActivity.this.finish();
        }
    }

    public final String j1() {
        return (String) this.f14791q.getValue();
    }

    public final void k1() {
        Disposable disposed = a.C0826a.g(NetworkClient.f11868a.r(), j1(), null, 2, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKStartLiveShowActivity$startLiveShow$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowResult liveShowResult) {
                m2604invoke(liveShowResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2604invoke(LiveShowResult liveShowResult) {
                LiveShowResult liveShowResult2 = liveShowResult;
                String stringExtra = FKStartLiveShowActivity.this.getIntent().getStringExtra("ENTER_SOURCE");
                if (stringExtra == null) {
                    stringExtra = "OTHERS";
                }
                String str = stringExtra;
                s.h(str, "intent.getStringExtra(EN…iveShowSource.OTHERS.name");
                SensorPosition sensorPosition = SensorPosition.DynPosition;
                String stringExtra2 = FKStartLiveShowActivity.this.getIntent().getStringExtra("LIVE_FROM");
                if (stringExtra2 == null) {
                    stringExtra2 = SensorPosition.Web.getValue();
                }
                sensorPosition.setValue(stringExtra2);
                FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, FKStartLiveShowActivity.this, new FKLiveForViewerViewModel(liveShowResult2.getLiveShow(), null, new LiveInRoomSensorModel(str, null, null, sensorPosition, null, null, 48, null), false, 8, null), false, 4, null);
                AppApplication.f11612d.h().j().post(new FKStartLiveShowActivity.b());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new FKStartLiveShowActivity$startLiveShow$2(this), this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_transparent_start_live_show);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        k1();
    }
}
