package com.huawei.appgallery.agd.api;

import android.content.Context;
import com.huawei.appgallery.coreservice.api.ApiClient;
import d9.a;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface AgdApiClient extends ApiClient {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f27294a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<ConnectionCallbacks> f27295b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public String f27296c;

        /* renamed from: d, reason: collision with root package name */
        public String f27297d;

        public Builder(Context context) {
            this.f27294a = context.getApplicationContext();
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            this.f27295b.add(connectionCallbacks);
            return this;
        }

        public AgdApiClient build() {
            return new a(new ApiClient.Builder(this.f27294a).setHomeCountry(this.f27296c).setGrsAppName(this.f27297d), this.f27294a, this.f27295b);
        }

        @Deprecated
        public Builder setGrsAppName(String str) {
            this.f27297d = str;
            return this;
        }

        public Builder setHomeCountry(String str) {
            this.f27296c = str;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ConnectionCallbacks {
        void onConnected();

        void onConnectionFailed(ConnectionResult connectionResult);

        void onConnectionSuspended(int i10);
    }

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    void connect();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    void disconnect();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    Context getContext();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    boolean isConnected();

    @Override // com.huawei.appgallery.coreservice.api.ApiClient
    boolean isConnecting();
}
