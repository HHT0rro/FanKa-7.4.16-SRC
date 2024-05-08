package com.cupidapp.live.base.web.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: FKWebActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKWebActivity extends FKBaseWebActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13053u = new LinkedHashMap();

    @Override // com.cupidapp.live.base.web.activity.FKBaseWebActivity
    public void l1() {
        finish();
    }

    @Override // com.cupidapp.live.base.web.activity.FKBaseWebActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_web);
        Intent intent = getIntent();
        s.h(intent, "intent");
        WebStyleViewModel webStyleViewModel = (WebStyleViewModel) g.a(intent, WebStyleViewModel.class);
        if (webStyleViewModel == null) {
            webStyleViewModel = new WebStyleViewModel(null, false, null, 7, null);
        }
        n1(FKWebViewFragment.f13075p.d(getIntent().getStringExtra("UrlKey"), this, new WebConfigViewModel(false, false, webStyleViewModel.isShowCloseIcon(), false, false, null, false, 123, null)));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FKWebViewFragment m12 = m1();
        s.f(m12);
        beginTransaction.replace(R$id.fragmentContainerLayout, m12).commit();
        if (webStyleViewModel.getWebStyle() == WebStyleEnum.BottomToTopStyle) {
            d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FKBaseWebActivity.f13036s.b(true);
    }
}
