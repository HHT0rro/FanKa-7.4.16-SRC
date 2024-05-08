package d9;

import android.content.Context;
import com.huawei.appgallery.agd.api.AgdApiClient;
import com.huawei.appgallery.agd.api.ConnectionResult;
import com.huawei.appgallery.agd.internal.support.log.AgdLog;
import com.huawei.appgallery.agd.internalapi.CrossClientApi;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements AgdApiClient {

    /* renamed from: a, reason: collision with root package name */
    public final ApiClient f48654a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f48655b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<AgdApiClient.ConnectionCallbacks> f48656c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f48657d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f48658e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f48659f = false;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f48660g;

    /* renamed from: d9.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class C0720a implements ApiClient.ConnectionCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f48661a;

        public C0720a(Set set) {
            this.f48661a = set;
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnected() {
            a.this.b(true);
            if (a.this.f48657d) {
                return;
            }
            Iterator iterator2 = this.f48661a.iterator2();
            while (iterator2.hasNext()) {
                ((AgdApiClient.ConnectionCallbacks) iterator2.next()).onConnected();
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionFailed(IConnectionResult iConnectionResult) {
            a.this.b(false);
            if (a.this.f48657d) {
                return;
            }
            Iterator iterator2 = this.f48661a.iterator2();
            while (iterator2.hasNext()) {
                ((AgdApiClient.ConnectionCallbacks) iterator2.next()).onConnectionFailed(new ConnectionResult(iConnectionResult));
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionSuspended(int i10) {
            a.this.b(false);
            if (a.this.f48657d) {
                return;
            }
            Iterator iterator2 = this.f48661a.iterator2();
            while (iterator2.hasNext()) {
                ((AgdApiClient.ConnectionCallbacks) iterator2.next()).onConnectionSuspended(i10);
            }
        }
    }

    public a(ApiClient.Builder builder, Context context, Set<AgdApiClient.ConnectionCallbacks> set) {
        builder.addConnectionCallbacks(new C0720a(set));
        this.f48654a = builder.build();
        this.f48655b = context;
        this.f48656c = set;
        if (CrossClientApi.needCrossClient(context)) {
            CrossClientApi.init(context);
        }
    }

    public final void b(boolean z10) {
        this.f48658e = z10;
        this.f48659f = false;
        Runnable runnable = this.f48660g;
        if (runnable == null || !z10) {
            return;
        }
        runnable.run();
        this.f48660g = null;
    }

    public final boolean c() {
        return CoreServiceApi.getAppGalleryPkg(this.f48655b) != null;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public void connect() {
        if (!CrossClientApi.needCrossClient(this.f48655b)) {
            this.f48654a.connect();
            this.f48659f = true;
            return;
        }
        this.f48657d = true;
        Set<AgdApiClient.ConnectionCallbacks> set = this.f48656c;
        if (set != null) {
            Iterator<AgdApiClient.ConnectionCallbacks> iterator2 = set.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onConnected();
            }
        }
        AgdLog.LOG.i("AgdApiClientImpl", "AG not exist, connect by cross client");
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public void disconnect() {
        if (this.f48657d) {
            Iterator<AgdApiClient.ConnectionCallbacks> iterator2 = this.f48656c.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onConnectionSuspended(0);
            }
        }
        this.f48657d = false;
        this.f48654a.disconnect();
        this.f48658e = false;
        this.f48659f = false;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public Context getContext() {
        return this.f48655b;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public ApiClient getDelegate() {
        return this.f48654a;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnected() {
        return this.f48658e || this.f48657d;
    }

    @Override // com.huawei.appgallery.agd.api.AgdApiClient, com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnecting() {
        return c() && this.f48659f;
    }
}
