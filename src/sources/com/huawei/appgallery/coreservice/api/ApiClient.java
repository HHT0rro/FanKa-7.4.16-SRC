package com.huawei.appgallery.coreservice.api;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import w9.a;
import w9.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ApiClient {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f27560a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<ConnectionCallback> f27561b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public String f27562c;

        /* renamed from: d, reason: collision with root package name */
        public String f27563d;

        /* renamed from: e, reason: collision with root package name */
        public ConnectConfig f27564e;

        public Builder(Context context) {
            this.f27560a = context.getApplicationContext();
        }

        public Builder addConnectionCallbacks(ConnectionCallback connectionCallback) {
            this.f27561b.add(connectionCallback);
            return this;
        }

        public ApiClient build() {
            if (!TextUtils.isEmpty(this.f27563d)) {
                i.b().c(this.f27560a, this.f27563d);
            }
            if (!TextUtils.isEmpty(this.f27562c)) {
                i.b().e(this.f27560a, this.f27562c);
            }
            return new a(this.f27560a, this.f27561b, this.f27564e);
        }

        @Deprecated
        public Builder setGrsAppName(String str) {
            this.f27563d = str;
            return this;
        }

        public Builder setHomeCountry(String str) {
            this.f27562c = str;
            return this;
        }

        public Builder setVendorConnectInfo(ConnectConfig connectConfig) {
            if (connectConfig != null && !TextUtils.isEmpty(connectConfig.getConnectServiceAction()) && !TextUtils.isEmpty(connectConfig.getConnectAppPkg()) && !TextUtils.isEmpty(connectConfig.getInstallAppName()) && !TextUtils.isEmpty(connectConfig.getAppSignCertchain()) && !TextUtils.isEmpty(connectConfig.getAppFingerprintSignature())) {
                this.f27564e = connectConfig.m2856clone();
            }
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed(IConnectionResult iConnectionResult);

        void onConnectionSuspended(int i10);
    }

    void connect();

    void disconnect();

    Context getContext();

    ApiClient getDelegate();

    boolean isConnected();

    boolean isConnecting();
}
