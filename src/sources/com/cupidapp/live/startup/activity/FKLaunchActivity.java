package com.cupidapp.live.startup.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import com.cupidapp.live.base.utils.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLaunchActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLaunchActivity extends AppCompatActivity {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18305d = new LinkedHashMap();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        SplashScreen.Companion.installSplashScreen(this);
        super.onCreate(bundle);
        j.f12332a.a("FKLaunchActivity", "data:" + ((Object) getIntent().getData()) + "  extras:" + ((Object) getIntent().getExtras()));
        if (!isTaskRoot() && getIntent() != null && getIntent().hasCategory("android.intent.category.LAUNCHER") && s.d(getIntent().getAction(), "android.intent.action.MAIN")) {
            finish();
        } else {
            FKStartupActivity.f18306u.a(this, getIntent().getData(), getIntent().getExtras());
            finish();
        }
    }
}
