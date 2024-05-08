package com.cupidapp.live.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.share.helper.ShareResultEvent;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.wxapi.event.WXEntryPayResultEvent;
import com.cupidapp.live.wxapi.event.WXEntrySuccessEvent;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WXEntryActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WXEntryActivity extends FKBaseActivity implements IWXAPIEventHandler {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f19039q = new LinkedHashMap();

    public static final void m1(String code, WXEntryActivity this$0, Object obj) {
        s.i(code, "$code");
        s.i(this$0, "this$0");
        EventBus.c().o(new WXEntrySuccessEvent(code));
        this$0.finish();
    }

    public static final void n1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void l1(final String str) {
        Observable observeOn = NetworkClient.f11868a.N().i0(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread());
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.wxapi.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WXEntryActivity.m1(String.this, this, obj);
            }
        };
        final Function1<Throwable, p> function1 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.wxapi.WXEntryActivity$requestWechatAuthToken$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                j jVar = j.f12008a;
                s.h(it, "it");
                j.f(jVar, it, null, null, null, 14, null);
                WXEntryActivity.this.finish();
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.wxapi.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WXEntryActivity.n1(Function1.this, obj);
            }
        });
    }

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
        int type = resp.getType();
        if (type == 1) {
            if (TextUtils.isEmpty(resp.errStr) && resp.errCode == 0) {
                String str = ((SendAuth.Resp) resp).code;
                s.h(str, "authResp.code");
                l1(str);
                return;
            } else {
                h.f12779a.r(this, R$string.wechat_bind_failure);
                finish();
                return;
            }
        }
        if (type != 2) {
            if (type != 5) {
                finish();
                return;
            } else {
                EventBus.c().o(new WXEntryPayResultEvent(Integer.valueOf(resp.errCode)));
                finish();
                return;
            }
        }
        int i10 = resp.errCode;
        if (i10 == -4) {
            com.cupidapp.live.base.share.helper.d.f12255a.m(true, "WX_AUTH_DENIED");
        } else if (i10 == -3) {
            com.cupidapp.live.base.share.helper.d.f12255a.m(true, "WX_SENT_FAILED");
        } else if (i10 == -2) {
            com.cupidapp.live.base.share.helper.d.f12255a.m(true, "WX_USER_CANCEL");
        } else if (i10 != 0) {
            com.cupidapp.live.base.share.helper.d.f12255a.m(true, "WX_OTHER");
        } else {
            com.cupidapp.live.base.share.helper.d.n(com.cupidapp.live.base.share.helper.d.f12255a, true, null, 2, null);
        }
        EventBus.c().o(new ShareResultEvent(TextUtils.isEmpty(resp.errStr) && resp.errCode == 0));
        finish();
    }
}
