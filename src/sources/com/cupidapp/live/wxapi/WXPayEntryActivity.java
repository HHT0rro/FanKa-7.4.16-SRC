package com.cupidapp.live.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.wxapi.event.WXEntryPayResultEvent;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WXPayEntryActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WXPayEntryActivity extends FKBaseActivity implements IWXAPIEventHandler {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f19040q = new LinkedHashMap();

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_wxentry);
        IWXAPI P = NetworkClient.f11868a.P(this);
        if (P != null) {
            P.handleIntent(getIntent(), this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        s.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        IWXAPI P = NetworkClient.f11868a.P(this);
        if (P != null) {
            P.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(@NotNull BaseReq req) {
        s.i(req, "req");
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(@NotNull BaseResp resp) {
        s.i(resp, "resp");
        if (resp.getType() == 5) {
            EventBus.c().o(new WXEntryPayResultEvent(Integer.valueOf(resp.errCode)));
            finish();
        } else {
            finish();
        }
    }
}
