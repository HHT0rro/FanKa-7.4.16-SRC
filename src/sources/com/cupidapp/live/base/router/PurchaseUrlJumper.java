package com.cupidapp.live.base.router;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.activity.DefaultEvent;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.AlipayHelper;
import com.cupidapp.live.base.router.WeChatPayHelper;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserRankModel;
import com.cupidapp.live.wxapi.event.WXEntryPayResultEvent;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: PurchaseUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PurchaseUrlJumper implements h, LifecycleObserver {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f12108b = kotlin.c.b(new Function0<AlipayHelper>() { // from class: com.cupidapp.live.base.router.PurchaseUrlJumper$alipayHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AlipayHelper invoke() {
            return new AlipayHelper();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f12109c = kotlin.c.b(new Function0<WeChatPayHelper>() { // from class: com.cupidapp.live.base.router.PurchaseUrlJumper$wechatPayHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final WeChatPayHelper invoke() {
            return new WeChatPayHelper();
        }
    });

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f12110d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKWebView f12111e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Activity f12112f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Uri f12113g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12114h;

    /* compiled from: PurchaseUrlJumper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AlipayHelper.b {
        public a() {
        }

        @Override // com.cupidapp.live.base.router.AlipayHelper.b
        public void a() {
        }

        @Override // com.cupidapp.live.base.router.AlipayHelper.b
        public boolean b(@NotNull Throwable t2) {
            s.i(t2, "t");
            FKWebView h10 = PurchaseUrlJumper.this.h();
            if (h10 == null) {
                return true;
            }
            com.cupidapp.live.base.web.bridge.b.f13062a.j(h10, PurchaseStatus.UNPAID.getValue(), t2.getMessage());
            return true;
        }

        @Override // com.cupidapp.live.base.router.AlipayHelper.b
        public void c(@NotNull OrderDataResult orderDataResult, @NotNull PurchaseStatus purchaseStatus) {
            s.i(orderDataResult, "orderDataResult");
            s.i(purchaseStatus, "purchaseStatus");
            FKWebView h10 = PurchaseUrlJumper.this.h();
            if (h10 != null) {
                com.cupidapp.live.base.web.bridge.b.f13062a.j(h10, purchaseStatus.getValue(), "");
            }
            PurchaseUrlJumper.this.k();
        }

        @Override // com.cupidapp.live.base.router.AlipayHelper.b
        public void d() {
        }
    }

    /* compiled from: PurchaseUrlJumper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends WeChatPayHelper.a {
        public b() {
        }

        @Override // com.cupidapp.live.base.router.WeChatPayHelper.a
        public boolean b(@NotNull Throwable t2) {
            s.i(t2, "t");
            FKWebView h10 = PurchaseUrlJumper.this.h();
            if (h10 == null) {
                return true;
            }
            com.cupidapp.live.base.web.bridge.b.f13062a.j(h10, PurchaseStatus.UNPAID.getValue(), "");
            return true;
        }

        @Override // com.cupidapp.live.base.router.WeChatPayHelper.a
        public void c(@NotNull OrderDataResult orderDataResult, @NotNull PurchaseStatus purchaseStatus, @NotNull String orderId) {
            s.i(orderDataResult, "orderDataResult");
            s.i(purchaseStatus, "purchaseStatus");
            s.i(orderId, "orderId");
            FKWebView h10 = PurchaseUrlJumper.this.h();
            if (h10 != null) {
                com.cupidapp.live.base.web.bridge.b.f13062a.j(h10, purchaseStatus.getValue(), "");
            }
            PurchaseUrlJumper.this.k();
        }

        @Override // com.cupidapp.live.base.router.WeChatPayHelper.a
        public void d() {
        }
    }

    public static final void j(PurchaseUrlJumper this$0) {
        FKWebView fKWebView;
        s.i(this$0, "this$0");
        if (!this$0.f12114h || (fKWebView = this$0.f12111e) == null) {
            return;
        }
        com.cupidapp.live.base.web.bridge.b.f13062a.j(fKWebView, PurchaseStatus.CLOSED.getValue(), "");
    }

    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        s.i(uri, "uri");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        this.f12112f = activity;
        this.f12111e = (FKWebView) activity.findViewById(R$id.appWebView);
        this.f12113g = uri;
        String host = uri.getHost();
        if (host != null && host.hashCode() == 110760 && host.equals("pay")) {
            l(uri, "paymentType");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("PurchaseUrlJumper", "jump uri:" + ((Object) uri));
    }

    public final void e(Uri uri) {
        String queryParameter = uri.getQueryParameter("orderId");
        String queryParameter2 = uri.getQueryParameter("payInfo");
        this.f12110d = uri.getQueryParameter("callback");
        if (queryParameter2 == null || queryParameter2.length() == 0) {
            return;
        }
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        f(queryParameter, queryParameter2);
    }

    public final void f(String str, String str2) {
        AlipayHelper g3;
        Activity activity = this.f12112f;
        if (activity == null || (g3 = g()) == null) {
            return;
        }
        g3.h(activity, str2, str, new a());
    }

    public final AlipayHelper g() {
        return (AlipayHelper) this.f12108b.getValue();
    }

    @Nullable
    public final FKWebView h() {
        return this.f12111e;
    }

    public final WeChatPayHelper i() {
        return (WeChatPayHelper) this.f12109c.getValue();
    }

    public final void k() {
        User X = p1.g.f52734a.X();
        if (X == null || this.f12112f == null) {
            return;
        }
        NetworkClient networkClient = NetworkClient.f11868a;
        Observable z10 = a.C0836a.z(networkClient.N(), X.userId(), null, null, false, null, 30, null);
        ComponentCallbacks2 componentCallbacks2 = this.f12112f;
        PurchaseUrlJumper$refreshLocalUser$2 purchaseUrlJumper$refreshLocalUser$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.router.PurchaseUrlJumper$refreshLocalUser$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.FALSE;
            }
        };
        com.cupidapp.live.base.network.g gVar = componentCallbacks2 instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) componentCallbacks2 : null;
        Disposable disposed = z10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.base.router.PurchaseUrlJumper$refreshLocalUser$$inlined$handleByContext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2463invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2463invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                p1.g gVar2 = p1.g.f52734a;
                gVar2.A2(profileResult2.getUser());
                gVar2.W1(profileResult2.getUser().getBalance());
                EventBus.c().o(new PurchaseSuccessEvent());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(purchaseUrlJumper$refreshLocalUser$2, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
        Observable<Result<UserRankModel>> a10 = networkClient.M().a();
        ComponentCallbacks2 componentCallbacks22 = this.f12112f;
        PurchaseUrlJumper$refreshLocalUser$4 purchaseUrlJumper$refreshLocalUser$4 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.router.PurchaseUrlJumper$refreshLocalUser$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar2 = componentCallbacks22 instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) componentCallbacks22 : null;
        Disposable disposed2 = a10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserRankModel, p>() { // from class: com.cupidapp.live.base.router.PurchaseUrlJumper$refreshLocalUser$$inlined$handleByContext$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserRankModel userRankModel) {
                m2464invoke(userRankModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2464invoke(UserRankModel userRankModel) {
                UserRankModel userRankModel2 = userRankModel;
                j1.n.f50241a.b(userRankModel2);
                p1.g.f52734a.F1().d(userRankModel2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(purchaseUrlJumper$refreshLocalUser$4, gVar2)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
            if (gVar2 != null) {
                gVar2.H(disposed2);
            }
        }
        s.h(disposed2, "disposed");
    }

    public final void l(Uri uri, String str) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            int hashCode = queryParameter.hashCode();
            if (hashCode == -1533216788) {
                if (queryParameter.equals("WeixinOpen")) {
                    m(uri);
                }
            } else if (hashCode == 1963873898 && queryParameter.equals("Alipay")) {
                e(uri);
            }
        }
    }

    public final void m(Uri uri) {
        WeChatPayHelper i10;
        String queryParameter = uri.getQueryParameter("orderId");
        String queryParameter2 = uri.getQueryParameter(CardUriUtils.PARAM_SIGN);
        String queryParameter3 = uri.getQueryParameter("prepayId");
        String queryParameter4 = uri.getQueryParameter("nonceStr");
        String queryParameter5 = uri.getQueryParameter("timestamp");
        this.f12110d = uri.getQueryParameter("callback");
        this.f12114h = true;
        Activity activity = this.f12112f;
        if (activity == null || (i10 = i()) == null) {
            return;
        }
        i10.f(activity, queryParameter3, queryParameter4, queryParameter5, queryParameter2, queryParameter, new Function0<p>() { // from class: com.cupidapp.live.base.router.PurchaseUrlJumper$wechatPay$1$1
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
                PurchaseUrlJumper.this.f12114h = false;
                FKWebView h10 = PurchaseUrlJumper.this.h();
                if (h10 != null) {
                    com.cupidapp.live.base.web.bridge.b.f13062a.j(h10, PurchaseStatus.CLOSED.getValue(), "");
                }
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        WeChatPayHelper i10 = i();
        if (i10 != null) {
            i10.n();
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DefaultEvent event) {
        s.i(event, "event");
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull WXEntryPayResultEvent event) {
        s.i(event, "event");
        this.f12114h = false;
        Activity activity = this.f12112f;
        if (activity == null) {
            return;
        }
        EventBus.c().r(event);
        WeChatPayHelper i10 = i();
        if (i10 != null) {
            i10.i(event, new b(), activity);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        y0.a.f54658a.c(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        y0.a.b(y0.a.f54658a, this, null, 2, null);
        AppApplication.f11612d.h().j().postDelayed(new Runnable() { // from class: com.cupidapp.live.base.router.i
            @Override // java.lang.Runnable
            public final void run() {
                PurchaseUrlJumper.j(PurchaseUrlJumper.this);
            }
        }, 500L);
    }
}
