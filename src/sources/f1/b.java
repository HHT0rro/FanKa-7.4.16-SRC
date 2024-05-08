package f1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.cupidapp.live.base.utils.j;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetworkConnectStateUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public ConnectivityManager f49108a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ConnectivityManager.NetworkCallback f49109b;

    /* compiled from: NetworkConnectStateUtil.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f49110a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f49111b;

        public a(Function0<p> function0, Function0<p> function02) {
            this.f49110a = function0;
            this.f49111b = function02;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            s.i(network, "network");
            Function0<p> function0 = this.f49110a;
            if (function0 != null) {
                function0.invoke();
            }
            j.f12332a.a("registerNetworkCallback", "onAvailable network: " + ((Object) network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            s.i(network, "network");
            Function0<p> function0 = this.f49111b;
            if (function0 != null) {
                function0.invoke();
            }
            j.f12332a.a("registerNetworkCallback", "onLost network: " + ((Object) network));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(b bVar, Context context, Function0 function0, Function0 function02, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        if ((i10 & 4) != 0) {
            function02 = null;
        }
        bVar.a(context, function0, function02);
    }

    public final void a(@NotNull Context context, @Nullable Function0<p> function0, @Nullable Function0<p> function02) {
        s.i(context, "context");
        if (this.f49108a == null) {
            Object systemService = context.getSystemService("connectivity");
            s.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            this.f49108a = (ConnectivityManager) systemService;
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            this.f49109b = new a(function0, function02);
            try {
                ConnectivityManager connectivityManager = this.f49108a;
                s.f(connectivityManager);
                NetworkRequest build = builder.build();
                ConnectivityManager.NetworkCallback networkCallback = this.f49109b;
                s.f(networkCallback);
                connectivityManager.registerNetworkCallback(build, networkCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void c() {
        ConnectivityManager.NetworkCallback networkCallback = this.f49109b;
        if (networkCallback != null) {
            try {
                ConnectivityManager connectivityManager = this.f49108a;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                }
                this.f49108a = null;
                this.f49109b = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
