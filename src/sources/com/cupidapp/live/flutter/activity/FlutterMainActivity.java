package com.cupidapp.live.flutter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.flutter.model.BaseTransModel;
import com.cupidapp.live.flutter.model.PageChannel;
import com.cupidapp.live.flutter.model.PageName;
import io.flutter.embedding.android.FlutterFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlutterMainActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FlutterMainActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f14650t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public FlutterFragment f14651q;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14653s = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f14652r = c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.flutter.activity.FlutterMainActivity$position$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SensorPosition invoke() {
            SensorPosition sensorPosition = (SensorPosition) FlutterMainActivity.this.getIntent().getSerializableExtra("DATA_SENSOR_POSITION");
            return sensorPosition == null ? SensorPosition.Flutter : sensorPosition;
        }
    });

    /* compiled from: FlutterMainActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable SensorPosition sensorPosition, @NotNull PageName pageName, @Nullable PageChannel pageChannel, @Nullable BaseTransModel baseTransModel) {
            s.i(context, "context");
            s.i(pageName, "pageName");
            Intent intent = new Intent(context, (Class<?>) FlutterMainActivity.class);
            intent.putExtra("page_name", pageName.getValue());
            intent.putExtra("channel_name", pageChannel != null ? pageChannel.getValue() : null);
            intent.putExtra("trans_model", baseTransModel);
            intent.putExtra("position", sensorPosition);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return k1();
    }

    public final void j1(String str, String str2, BaseTransModel baseTransModel) {
        g2.a aVar = g2.a.f49362a;
        Context applicationContext = getApplicationContext();
        s.h(applicationContext, "this.applicationContext");
        aVar.a(applicationContext, str, str2, baseTransModel, this);
        this.f14651q = FlutterFragment.withCachedEngine(str).build();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FlutterFragment flutterFragment = this.f14651q;
        s.f(flutterFragment);
        beginTransaction.replace(R$id.fragment_container, flutterFragment).commitAllowingStateLoss();
    }

    public final SensorPosition k1() {
        return (SensorPosition) this.f14652r.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        FlutterFragment flutterFragment = this.f14651q;
        if (flutterFragment != null) {
            flutterFragment.onActivityResult(i10, i11, intent);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FlutterFragment flutterFragment = this.f14651q;
        if (flutterFragment != null) {
            flutterFragment.onBackPressed();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_flutter_main);
        String stringExtra = getIntent().getStringExtra("page_name");
        String stringExtra2 = getIntent().getStringExtra("channel_name");
        BaseTransModel baseTransModel = (BaseTransModel) getIntent().getSerializableExtra("trans_model");
        if (stringExtra == null) {
            return;
        }
        j1(stringExtra, stringExtra2, baseTransModel);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        s.i(intent, "intent");
        super.onNewIntent(intent);
        FlutterFragment flutterFragment = this.f14651q;
        if (flutterFragment != null) {
            flutterFragment.onNewIntent(intent);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        FlutterFragment flutterFragment = this.f14651q;
        if (flutterFragment != null) {
            flutterFragment.onPostResume();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, @NotNull String[] permissions, @NotNull int[] grantResults) {
        s.i(permissions, "permissions");
        s.i(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        FlutterFragment flutterFragment = this.f14651q;
        if (flutterFragment != null) {
            flutterFragment.onRequestPermissionsResult(i10, permissions, grantResults);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        FlutterFragment flutterFragment = this.f14651q;
        if (flutterFragment != null) {
            flutterFragment.onTrimMemory(i10);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        FlutterFragment flutterFragment = this.f14651q;
        if (flutterFragment != null) {
            flutterFragment.onUserLeaveHint();
        }
    }
}
