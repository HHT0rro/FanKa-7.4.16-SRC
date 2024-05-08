package com.huawei.quickcard.base.grs;

import com.huawei.quickcard.base.interfaces.ICardHAUrl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardServerConfig {
    public static final int CARD_MODE_ONLINE = 0;
    public static final int CARD_MODE_TEST = 1;

    /* renamed from: a, reason: collision with root package name */
    private static int f33333a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile ICardServerUrl f33334b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ICardHAUrl f33335c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile INetworkAccessProvider f33336d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile IServiceCountryProvider f33337e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile IAgcAuthProvider f33338f;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String a(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(boolean z10) {
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String b(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String c(String str) {
        return str;
    }

    public static IAgcAuthProvider getAgcAuthProvider() {
        return f33338f;
    }

    public static String getHAUrl() {
        return f33335c != null ? f33335c.getHAUrl() : "";
    }

    public static int getMode() {
        return f33333a;
    }

    public static INetworkAccessProvider getNetworkAccessProvider() {
        return f33336d;
    }

    public static String getServerCountry() {
        return f33337e != null ? f33337e.getServiceCountryCode() : "";
    }

    public static String getUrl() {
        return f33334b != null ? f33334b.getUrl() : "";
    }

    public static void setAgcAuthProvider(IAgcAuthProvider iAgcAuthProvider) {
        f33338f = iAgcAuthProvider;
    }

    public static void setHAUrl(final String str) {
        setHAUrl(new ICardHAUrl() { // from class: com.huawei.quickcard.base.grs.d
            @Override // com.huawei.quickcard.base.interfaces.ICardHAUrl
            public final String getHAUrl() {
                String a10;
                a10 = CardServerConfig.a(String.this);
                return a10;
            }
        });
    }

    public static void setMode(int i10) {
        f33333a = i10;
    }

    public static void setNetworkAccess(final boolean z10) {
        setNetworkAccessProvider(new INetworkAccessProvider() { // from class: com.huawei.quickcard.base.grs.b
            @Override // com.huawei.quickcard.base.grs.INetworkAccessProvider
            public final boolean isNetworkAccessEnable() {
                boolean a10;
                a10 = CardServerConfig.a(z10);
                return a10;
            }
        });
    }

    public static void setNetworkAccessProvider(INetworkAccessProvider iNetworkAccessProvider) {
        f33336d = iNetworkAccessProvider;
    }

    public static void setServiceCountry(final String str) {
        setServiceCountryProvider(new IServiceCountryProvider() { // from class: com.huawei.quickcard.base.grs.c
            @Override // com.huawei.quickcard.base.grs.IServiceCountryProvider
            public final String getServiceCountryCode() {
                String b4;
                b4 = CardServerConfig.b(String.this);
                return b4;
            }
        });
    }

    public static void setServiceCountryProvider(IServiceCountryProvider iServiceCountryProvider) {
        f33337e = iServiceCountryProvider;
        CardGrsClientHelper.notifyCountryChanged(iServiceCountryProvider.getServiceCountryCode());
    }

    public static void setUrl(final String str) {
        setUrl(new ICardServerUrl() { // from class: com.huawei.quickcard.base.grs.a
            @Override // com.huawei.quickcard.base.grs.ICardServerUrl
            public final String getUrl() {
                String c4;
                c4 = CardServerConfig.c(String.this);
                return c4;
            }
        });
    }

    public static void setHAUrl(ICardHAUrl iCardHAUrl) {
        f33335c = iCardHAUrl;
    }

    public static void setUrl(ICardServerUrl iCardServerUrl) {
        f33334b = iCardServerUrl;
    }
}
