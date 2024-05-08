package com.cupidapp.live.push;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.match.fragment.FKMatchContainerFragment;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PushNotificationActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushNotificationActivity extends FKBaseActivity {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17890q = new LinkedHashMap();

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (a1()) {
            finish();
            return;
        }
        Intent a10 = FKMatchContainerFragment.f16640u.a(this, FKMatchContainerFragment.MatchTabType.Match);
        Serializable serializableExtra = getIntent().getSerializableExtra("pushModel");
        a10.putExtra("pushModel", serializableExtra instanceof FKPushMessageModel ? (FKPushMessageModel) serializableExtra : null);
        startActivity(a10);
    }
}
