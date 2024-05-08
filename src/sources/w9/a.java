package w9;

import android.content.Context;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.api.ConnectConfig;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements ApiClient {

    /* renamed from: a, reason: collision with root package name */
    public Context f54287a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<ApiClient.ConnectionCallback> f54288b;

    /* renamed from: c, reason: collision with root package name */
    public e f54289c;

    public a(Context context, Set<ApiClient.ConnectionCallback> set, ConnectConfig connectConfig) {
        HashSet hashSet = new HashSet();
        this.f54288b = hashSet;
        this.f54287a = context.getApplicationContext();
        hashSet.addAll(set);
        e eVar = new e(context);
        this.f54289c = eVar;
        eVar.e(connectConfig);
    }

    public c a() {
        return this.f54289c;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public void connect() {
        this.f54289c.g(this.f54288b);
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public void disconnect() {
        this.f54289c.d();
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public Context getContext() {
        return this.f54287a;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public ApiClient getDelegate() {
        return null;
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnected() {
        return this.f54289c.i();
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    public boolean isConnecting() {
        return this.f54289c.m();
    }
}
