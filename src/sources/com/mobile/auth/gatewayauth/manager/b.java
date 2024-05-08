package com.mobile.auth.gatewayauth.manager;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.ConfigRule;
import com.mobile.auth.gatewayauth.network.UTSharedPreferencesHelper;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.RequestQueue;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f37279a;

    /* renamed from: b, reason: collision with root package name */
    private com.mobile.auth.q.a f37280b;

    /* renamed from: c, reason: collision with root package name */
    private volatile ConfigRule f37281c;

    /* renamed from: d, reason: collision with root package name */
    private VendorSdkInfoManager f37282d;

    public b(Context context, VendorSdkInfoManager vendorSdkInfoManager, d dVar) {
        Context applicationContext = context.getApplicationContext();
        this.f37279a = applicationContext;
        this.f37281c = UTSharedPreferencesHelper.readSDKConfig(applicationContext);
        this.f37282d = vendorSdkInfoManager;
        this.f37280b = dVar.a();
        if (this.f37281c != null) {
            this.f37280b.a(this.f37281c);
        }
    }

    public static /* synthetic */ ConfigRule a(b bVar) {
        try {
            return bVar.f37281c;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ ConfigRule a(b bVar, ConfigRule configRule) {
        try {
            bVar.f37281c = configRule;
            return configRule;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a b(b bVar) {
        try {
            return bVar.f37280b;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ Context c(b bVar) {
        try {
            return bVar.f37279a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private boolean s() {
        try {
            return this.f37281c != null;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    private boolean t() {
        try {
            if (Boolean.parseBoolean(this.f37281c.getAuth_token().getIs_limited())) {
                return this.f37281c.getAuth_token().getLimit_time_hour() > 0;
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    private boolean u() {
        try {
            if (Boolean.parseBoolean(this.f37281c.getLogin_token().getIs_limited())) {
                return this.f37281c.getLogin_token().getLimit_time_hour() > 0;
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    private boolean v() {
        try {
            if (Boolean.parseBoolean(this.f37281c.getSls().getIs_limited())) {
                return this.f37281c.getSls().getLimit_time_hour() > 0;
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    private boolean w() {
        try {
            if (Boolean.parseBoolean(this.f37281c.getGet_vendor_list().getIs_limited())) {
                return this.f37281c.getGet_vendor_list().getLimit_time_hour() > 0;
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    private boolean x() {
        try {
            if (Boolean.parseBoolean(this.f37281c.getLogin_page().getIs_limited())) {
                return this.f37281c.getLogin_page().getLimit_time_hour() > 0;
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    private boolean y() {
        try {
            if (Boolean.parseBoolean(this.f37281c.getLogin_phone().getIs_limited())) {
                return this.f37281c.getLogin_phone().getLimit_time_hour() > 0;
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    private boolean z() {
        try {
            if (Boolean.parseBoolean(this.f37281c.getGet_config().getIs_limited())) {
                return this.f37281c.getGet_config().getLimit_time_hour() > 0;
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void a(final RequestCallback<ConfigRule, Void> requestCallback) {
        try {
            if (r()) {
                requestCallback.onError(null);
                return;
            }
            q();
            RequestQueue.getInstance().pushRequest(new com.mobile.auth.v.a(new Callback<com.mobile.auth.w.c>(ThreadStrategy.THREAD, 2000L) { // from class: com.mobile.auth.gatewayauth.manager.b.1
                public void a(com.mobile.auth.w.c cVar) {
                    try {
                        if (cVar.a() == null) {
                            requestCallback.onError(null);
                            return;
                        }
                        ConfigRule a10 = cVar.a();
                        if (b.a(b.this) == null || !b.a(b.this).toString().equals(a10.toString())) {
                            b.a(b.this, a10);
                            b.b(b.this).a(b.a(b.this));
                            UTSharedPreferencesHelper.clearLimitCount(b.c(b.this));
                            UTSharedPreferencesHelper.saveSDKConfig(b.c(b.this), b.a(b.this).toJsonString());
                        }
                        requestCallback.onSuccess(b.a(b.this));
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.nirvana.tools.requestqueue.Callback
                public /* synthetic */ void onResult(com.mobile.auth.w.c cVar) {
                    try {
                        a(cVar);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, new com.mobile.auth.r.c(this.f37279a, this.f37282d, this.f37280b), 5000L, com.mobile.auth.w.c.class));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean a() {
        try {
            if (s()) {
                return Boolean.parseBoolean(this.f37281c.getIs_demoted());
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public boolean a(int i10) {
        try {
            switch (i10) {
                case 1:
                    return h();
                case 2:
                    return j();
                case 3:
                    return p();
                case 4:
                    return d();
                case 5:
                    return f();
                case 6:
                    return n();
                case 7:
                    return l();
                default:
                    return false;
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void b(int i10) {
        try {
            switch (i10) {
                case 1:
                    i();
                    break;
                case 2:
                    k();
                    break;
                case 3:
                    q();
                    break;
                case 4:
                    e();
                    break;
                case 5:
                    g();
                    break;
                case 6:
                    o();
                    break;
                case 7:
                    m();
                    break;
                default:
                    return;
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean b() {
        try {
            if (!s()) {
                return false;
            }
            if (!a()) {
                if (!Boolean.parseBoolean(this.f37281c.getIs_auth_demoted())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public boolean c() {
        try {
            if (!s()) {
                return false;
            }
            if (!a()) {
                if (!Boolean.parseBoolean(this.f37281c.getIs_login_demoted())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public boolean d() {
        try {
            if (s() && t()) {
                return UTSharedPreferencesHelper.readAuthTokenLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getAuth_token().getLimit_time_hour())) >= this.f37281c.getAuth_token().getLimit_count();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void e() {
        try {
            if (s() && t()) {
                UTSharedPreferencesHelper.saveAuthTokenLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getAuth_token().getLimit_time_hour()));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean f() {
        try {
            if (s() && u()) {
                return UTSharedPreferencesHelper.readLoginTokenLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getLogin_token().getLimit_time_hour())) >= this.f37281c.getLogin_token().getLimit_count();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void g() {
        try {
            if (s() && u()) {
                UTSharedPreferencesHelper.saveLoginTokenLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getLogin_token().getLimit_time_hour()));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean h() {
        try {
            if (s() && v()) {
                return UTSharedPreferencesHelper.readSLSLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getSls().getLimit_time_hour())) >= this.f37281c.getSls().getLimit_count();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void i() {
        try {
            if (s() && v()) {
                UTSharedPreferencesHelper.saveSLSLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getSls().getLimit_time_hour()));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean j() {
        try {
            if (s() && w()) {
                return UTSharedPreferencesHelper.readVendorLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getGet_vendor_list().getLimit_time_hour())) >= this.f37281c.getGet_vendor_list().getLimit_count();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void k() {
        try {
            if (s() && w()) {
                UTSharedPreferencesHelper.saveVendorLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getGet_vendor_list().getLimit_time_hour()));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean l() {
        try {
            if (s() && x()) {
                return UTSharedPreferencesHelper.readLoginPageLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getLogin_page().getLimit_time_hour())) >= this.f37281c.getLogin_page().getLimit_count();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void m() {
        try {
            if (s() && x()) {
                UTSharedPreferencesHelper.saveLoginPageLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getLogin_page().getLimit_time_hour()));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean n() {
        try {
            if (s() && y()) {
                return UTSharedPreferencesHelper.readLoginPhoneLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getLogin_phone().getLimit_time_hour())) >= this.f37281c.getLogin_phone().getLimit_count();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void o() {
        try {
            if (s() && y()) {
                UTSharedPreferencesHelper.saveLoginPhoneLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getLogin_phone().getLimit_time_hour()));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean p() {
        try {
            if (s() && z()) {
                return UTSharedPreferencesHelper.readConfigLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getGet_config().getLimit_time_hour())) >= this.f37281c.getGet_config().getLimit_count();
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void q() {
        try {
            if (s() && z()) {
                UTSharedPreferencesHelper.saveConfigLimitCount(this.f37279a, com.mobile.auth.gatewayauth.utils.a.a(this.f37281c.getGet_config().getLimit_time_hour()));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean r() {
        try {
            String readSDKConfigLimitFlag = UTSharedPreferencesHelper.readSDKConfigLimitFlag(this.f37279a);
            if ((TextUtils.isEmpty(readSDKConfigLimitFlag) || !com.mobile.auth.gatewayauth.utils.a.a(readSDKConfigLimitFlag)) && !UTSharedPreferencesHelper.readSDKConfigCloseFlag(this.f37279a)) {
                return p();
            }
            return true;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }
}
