package com.mobile.auth.gatewayauth;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.alicom.tools.networking.ResultMsg;
import com.alicom.tools.serialization.JSONType;
import com.alicom.tools.serialization.JSONUtils;
import com.baidu.mobads.sdk.internal.by;
import com.mobile.auth.gatewayauth.annotations.AuthNumber;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.manager.RequestCallback;
import com.mobile.auth.gatewayauth.manager.SystemManager;
import com.mobile.auth.gatewayauth.manager.TokenMaskManager;
import com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager;
import com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor;
import com.mobile.auth.gatewayauth.manager.f;
import com.mobile.auth.gatewayauth.model.ConfigRule;
import com.mobile.auth.gatewayauth.model.LoginPhoneInfo;
import com.mobile.auth.gatewayauth.model.MonitorStruct;
import com.mobile.auth.gatewayauth.model.TokenRet;
import com.mobile.auth.gatewayauth.model.UStruct;
import com.mobile.auth.gatewayauth.network.PrivateKeyRespone;
import com.mobile.auth.gatewayauth.network.PrivateRespone;
import com.mobile.auth.gatewayauth.network.RequestState;
import com.mobile.auth.gatewayauth.network.RequestUtil;
import com.mobile.auth.gatewayauth.network.UTSharedPreferencesHelper;
import com.mobile.auth.gatewayauth.utils.EncryptUtils;
import com.mobile.auth.gatewayauth.utils.g;
import com.nirvana.tools.core.ComponentSdkCore;
import com.nirvana.tools.core.ExecutorManager;
import com.nirvana.tools.logger.UaidTracker;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PhoneNumberAuthHelperProxy {

    @AuthNumber
    public static final int SERVICE_TYPE_AUTH = 1;

    @AuthNumber
    public static final int SERVICE_TYPE_LOGIN = 2;

    /* renamed from: a, reason: collision with root package name */
    public static volatile PhoneNumberAuthHelperProxy f36885a;

    /* renamed from: b, reason: collision with root package name */
    private TokenResultListener f36886b;

    /* renamed from: c, reason: collision with root package name */
    private SystemManager f36887c;

    /* renamed from: d, reason: collision with root package name */
    private com.mobile.auth.gatewayauth.manager.b f36888d;

    /* renamed from: e, reason: collision with root package name */
    private VendorSdkInfoManager f36889e;

    /* renamed from: f, reason: collision with root package name */
    private TokenMaskManager f36890f;

    /* renamed from: g, reason: collision with root package name */
    private com.mobile.auth.gatewayauth.manager.d f36891g;

    /* renamed from: h, reason: collision with root package name */
    private f f36892h;

    /* renamed from: i, reason: collision with root package name */
    private Future<?> f36893i;

    /* renamed from: j, reason: collision with root package name */
    private com.mobile.auth.q.a f36894j;

    /* renamed from: k, reason: collision with root package name */
    private String f36895k;

    /* renamed from: n, reason: collision with root package name */
    private volatile String f36898n;

    /* renamed from: l, reason: collision with root package name */
    private final ResultCodeProcessor f36896l = new com.mobile.auth.gatewayauth.manager.compat.a();

    /* renamed from: m, reason: collision with root package name */
    private final ResultCodeProcessor f36897m = new com.mobile.auth.gatewayauth.manager.compat.b();

    /* renamed from: o, reason: collision with root package name */
    private Handler f36899o = new Handler(Looper.getMainLooper()) { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.12
        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            try {
                super.dispatchMessage(message);
                if (message.what == 0) {
                    PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this).a("", new RequestCallback<Void, String>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.12.1
                        public void a(String str) {
                            try {
                                PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("GetVendorList failed!", str);
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }

                        public void a(Void r22) {
                            try {
                                PhoneNumberAuthHelperProxy.c(PhoneNumberAuthHelperProxy.this).a(PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this));
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }

                        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                        public /* synthetic */ void onError(String str) {
                            try {
                                a(str);
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }

                        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                        public /* synthetic */ void onSuccess(Void r12) {
                            try {
                                a(r12);
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }
                    }, com.mobile.auth.gatewayauth.manager.e.a(PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this).e(), PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this), PhoneNumberAuthHelperProxy.e(PhoneNumberAuthHelperProxy.this), PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this)));
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    };

    /* renamed from: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy$10, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass10 implements RequestCallback<com.mobile.auth.gatewayauth.manager.base.b, com.mobile.auth.gatewayauth.manager.base.b> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f36901a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MonitorStruct f36902b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f36903c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ResultCodeProcessor f36904d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TokenResultListener f36905e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f36906f;

        public AnonymousClass10(c cVar, MonitorStruct monitorStruct, String str, ResultCodeProcessor resultCodeProcessor, TokenResultListener tokenResultListener, String str2) {
            this.f36901a = cVar;
            this.f36902b = monitorStruct;
            this.f36903c = str;
            this.f36904d = resultCodeProcessor;
            this.f36905e = tokenResultListener;
            this.f36906f = str2;
        }

        public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                if (this.f36901a.d()) {
                    this.f36902b.setCache(String.valueOf(bVar.e()));
                    PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, true, this.f36903c, this.f36904d, this.f36902b, bVar.d(), this.f36905e, this.f36906f);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        public void b(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                if (this.f36901a.d()) {
                    this.f36902b.setCache("false");
                    this.f36902b.setCarrierFailedResultData(bVar.d());
                    PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this, bVar.b(), bVar.c(), bVar.g(), this.f36903c, this.f36905e, this.f36904d, this.f36902b, this.f36906f);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
        public /* synthetic */ void onError(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                b(bVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
        public /* synthetic */ void onSuccess(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                a(bVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy$20, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass20 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestCallback f36949a;

        public AnonymousClass20(RequestCallback requestCallback) {
            this.f36949a = requestCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f36949a.onError(com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时"));
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy$21, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass21 implements RequestCallback<com.mobile.auth.gatewayauth.manager.base.b, com.mobile.auth.gatewayauth.manager.base.b> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f36951a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MonitorStruct f36952b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResultCodeProcessor f36953c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RequestCallback f36954d;

        public AnonymousClass21(c cVar, MonitorStruct monitorStruct, ResultCodeProcessor resultCodeProcessor, RequestCallback requestCallback) {
            this.f36951a = cVar;
            this.f36952b = monitorStruct;
            this.f36953c = resultCodeProcessor;
            this.f36954d = requestCallback;
        }

        public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                if (this.f36951a.d()) {
                    this.f36952b.setCache(String.valueOf(bVar.e()));
                    LoginPhoneInfo h10 = bVar.h();
                    this.f36952b.setPhoneNumber(h10.getPhoneNumber());
                    PhoneNumberAuthHelperProxy.this.a(h10.getPhoneNumber());
                    this.f36952b.setAuthSdkCode(this.f36953c.convertCode(Constant.CODE_GET_TOKEN_SUCCESS));
                    this.f36954d.onSuccess(h10);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        public void b(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                if (this.f36951a.d()) {
                    this.f36952b.setCache("false");
                    this.f36952b.setCarrierFailedResultData(bVar.d());
                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("justGetLoginPhone failed!", bVar.i());
                    this.f36954d.onError(bVar);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
        public /* synthetic */ void onError(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                b(bVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
        public /* synthetic */ void onSuccess(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                a(bVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy$7, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37008a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TokenResultListener f37009b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResultCodeProcessor f37010c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MonitorStruct f37011d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f37012e;

        public AnonymousClass7(String str, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str2) {
            this.f37008a = str;
            this.f37009b = tokenResultListener;
            this.f37010c = resultCodeProcessor;
            this.f37011d = monitorStruct;
            this.f37012e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时", com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时"), this.f37008a, this.f37009b, this.f37010c, this.f37011d, this.f37012e);
                PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("justGetLoginToken Timeout!");
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy$8, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass8 implements RequestCallback<com.mobile.auth.gatewayauth.manager.base.b, com.mobile.auth.gatewayauth.manager.base.b> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f37014a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MonitorStruct f37015b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f37016c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TokenResultListener f37017d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ResultCodeProcessor f37018e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f37019f;

        public AnonymousClass8(c cVar, MonitorStruct monitorStruct, String str, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, String str2) {
            this.f37014a = cVar;
            this.f37015b = monitorStruct;
            this.f37016c = str;
            this.f37017d = tokenResultListener;
            this.f37018e = resultCodeProcessor;
            this.f37019f = str2;
        }

        public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                if (this.f37014a.d()) {
                    this.f37015b.setCache(String.valueOf(bVar.e()));
                    PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, true, this.f37016c, this.f37017d, this.f37018e, bVar.d(), this.f37015b, this.f37019f);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        public void b(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                if (this.f37014a.d()) {
                    this.f37015b.setCache("false");
                    this.f37015b.setCarrierFailedResultData(bVar.d());
                    PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, bVar.b(), bVar.c(), bVar.g(), this.f37016c, this.f37017d, this.f37018e, this.f37015b, this.f37019f);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
        public /* synthetic */ void onError(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                b(bVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
        public /* synthetic */ void onSuccess(com.mobile.auth.gatewayauth.manager.base.b bVar) {
            try {
                a(bVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy$9, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass9 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37021a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TokenResultListener f37022b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResultCodeProcessor f37023c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MonitorStruct f37024d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f37025e;

        public AnonymousClass9(String str, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str2) {
            this.f37021a = str;
            this.f37022b = tokenResultListener;
            this.f37023c = resultCodeProcessor;
            this.f37024d = monitorStruct;
            this.f37025e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this, ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时", com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时"), this.f37021a, this.f37022b, this.f37023c, this.f37024d, this.f37025e);
                PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("justGetToken Timeout!");
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
        f36885a = null;
    }

    private PhoneNumberAuthHelperProxy(Context context, TokenResultListener tokenResultListener) {
        this.f36886b = tokenResultListener;
        ComponentSdkCore.register(context.getApplicationContext());
        a(context.getApplicationContext());
    }

    public static /* synthetic */ SystemManager a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36887c;
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

    private void a(Context context) {
        try {
            com.mobile.auth.gatewayauth.manager.d dVar = new com.mobile.auth.gatewayauth.manager.d(context);
            this.f36891g = dVar;
            this.f36894j = dVar.a();
            this.f36887c = new SystemManager(context, this.f36894j);
            VendorSdkInfoManager vendorSdkInfoManager = new VendorSdkInfoManager(this.f36891g, this.f36887c);
            this.f36889e = vendorSdkInfoManager;
            this.f36888d = new com.mobile.auth.gatewayauth.manager.b(context, vendorSdkInfoManager, this.f36891g);
            f fVar = new f(this.f36887c, this.f36891g);
            this.f36892h = fVar;
            this.f36891g.a(fVar);
            this.f36890f = new TokenMaskManager(this.f36888d, this.f36887c, this.f36891g, this.f36892h, this.f36889e);
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this).getSimCacheKey(false, null);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
            if (c(this.f36887c.e())) {
                this.f36893i = d();
            }
            UaidTracker.getInstance().setKey(EncryptUtils.getSecret5().substring(4, 10) + EncryptUtils.getSecret6().substring(1, 7), EncryptUtils.getSecret5().substring(15) + EncryptUtils.getSecret6().substring(38, 54), EncryptUtils.getSecret6().substring(70, 76) + EncryptUtils.getSecret6().substring(86, 92));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(Context context, boolean z10) {
        try {
            ResultMsg privateKey = RequestUtil.getPrivateKey(context, this.f36889e.c(), this.f36891g.j());
            if (!privateKey.isSuccess() || TextUtils.isEmpty(privateKey.getResult())) {
                return;
            }
            try {
                PrivateRespone privateRespone = (PrivateRespone) JSONUtils.fromJson(new JSONObject(privateKey.getResult()), (JSONType) new JSONType<PrivateRespone>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.33
                }, (List<Field>) null);
                if (by.f9988k.equals(privateRespone.getCode())) {
                    PrivateKeyRespone data = privateRespone.getData();
                    if (data.getExpiredTime() <= System.currentTimeMillis()) {
                        return;
                    }
                    UTSharedPreferencesHelper.saveAuthSDKPrivateKey(context, com.mobile.auth.gatewayauth.utils.security.a.a(data.toJson().toString().getBytes()));
                    RequestState.getInstance().setKeyRespone(data);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, int i10, ResultCodeProcessor resultCodeProcessor, boolean z10, TokenResultListener tokenResultListener) {
        try {
            phoneNumberAuthHelperProxy.justGetToken(i10, resultCodeProcessor, z10, tokenResultListener);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, long j10, PreLoginResultListener preLoginResultListener) {
        try {
            phoneNumberAuthHelperProxy.justPreVerify(j10, preLoginResultListener);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, long j10, PreLoginResultListener preLoginResultListener, ResultCodeProcessor resultCodeProcessor, boolean z10, boolean z11) {
        try {
            phoneNumberAuthHelperProxy.justPreLogin(j10, preLoginResultListener, resultCodeProcessor, z10, z11);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, long j10, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor) {
        try {
            phoneNumberAuthHelperProxy.justGetLoginToken(j10, tokenResultListener, resultCodeProcessor);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, Context context, boolean z10) {
        try {
            phoneNumberAuthHelperProxy.a(context, z10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, String str, String str2, String str3, String str4, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str5) {
        try {
            phoneNumberAuthHelperProxy.a(str, str2, str3, str4, tokenResultListener, resultCodeProcessor, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, boolean z10, boolean z11, String str, String str2, MonitorStruct monitorStruct, TokenResultListener tokenResultListener) {
        try {
            phoneNumberAuthHelperProxy.a(z10, z11, str, str2, monitorStruct, tokenResultListener);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(String str, String str2, String str3, String str4, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str5) {
        try {
            this.f36891g.h();
            if (monitorStruct.getAction().equals(this.f36887c.c(str4))) {
                a(false, false, str, str2, str3, str4, monitorStruct, tokenResultListener, resultCodeProcessor, str5);
            } else {
                a(false, true, str, str2, str3, str4, monitorStruct, tokenResultListener, resultCodeProcessor, str5);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(final String str, final boolean z10, final MonitorStruct monitorStruct, final boolean z11) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.26
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (monitorStruct != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            monitorStruct.setSuccess(z10);
                            monitorStruct.setEndTime(currentTimeMillis);
                            if (!z10) {
                                monitorStruct.setFailRet(str);
                            }
                            PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).a(PhoneNumberAuthHelperProxy.f(PhoneNumberAuthHelperProxy.this).a(monitorStruct), monitorStruct.getUrgency());
                        }
                        if (z11) {
                            PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).b();
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(final boolean z10, final String str, final TokenResultListener tokenResultListener) {
        try {
            ExecutorManager.getInstance().postMain(new ExecutorManager.SafeRunnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.25
                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void onException(Throwable th) {
                    try {
                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("TokenResultListener callback exception!", ExecutorManager.getErrorInfoFromException(th));
                    } catch (Throwable th2) {
                        try {
                            ExceptionProcessor.processException(th2);
                        } catch (Throwable th3) {
                            ExceptionProcessor.processException(th3);
                        }
                    }
                }

                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void safeRun() {
                    try {
                        if (z10) {
                            tokenResultListener.onTokenSuccess(str);
                        } else {
                            tokenResultListener.onTokenFailed(str);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(boolean z10, boolean z11, String str, String str2, MonitorStruct monitorStruct, TokenResultListener tokenResultListener) {
        if (tokenResultListener != null) {
            try {
                a(z10, str2, tokenResultListener);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return;
                }
            }
        }
        if (monitorStruct != null && !Constant.ACTION_SDK_LIFE_BODY_VERIFY.equals(monitorStruct.getAction())) {
            a(str, z10, monitorStruct, z11);
        }
    }

    public static /* synthetic */ boolean a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, boolean z10, String str, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, String str2, MonitorStruct monitorStruct, String str3) {
        try {
            return phoneNumberAuthHelperProxy.a(z10, str, tokenResultListener, resultCodeProcessor, str2, monitorStruct, str3);
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

    public static /* synthetic */ boolean a(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, boolean z10, String str, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str2, TokenResultListener tokenResultListener, String str3) {
        try {
            return phoneNumberAuthHelperProxy.a(z10, str, resultCodeProcessor, monitorStruct, str2, tokenResultListener, str3);
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

    private boolean a(final String str, String str2, final String str3) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = (str3 == null || str3.equals(str2)) ? false : true;
            final long currentTimeMillis2 = System.currentTimeMillis();
            final boolean z11 = z10;
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.28
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).a(PhoneNumberAuthHelperProxy.f(PhoneNumberAuthHelperProxy.this).a(str3, Constant.ACTION_SDK_CROSS_CARRIER_CHANGE, UStruct.newUStruct().isCarrierChanged(String.valueOf(z11)).requestId(PhoneNumberAuthHelperProxy.f(PhoneNumberAuthHelperProxy.this).e()).sessionId(str).startTime(currentTimeMillis).endTime(currentTimeMillis2).build(), ""), 2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
            return z10;
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

    private boolean a(boolean z10, String str, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, String str2, MonitorStruct monitorStruct, String str3) {
        try {
            this.f36891g.h();
            if (!TextUtils.isEmpty(str2)) {
                a(str2, str, monitorStruct, resultCodeProcessor, tokenResultListener);
                return true;
            }
            this.f36894j.e("GetLoginToken from cache is null!");
            if (z10) {
                monitorStruct.setAuthSdkCode(Constant.CODE_ERROR_UNKNOWN_FAIL);
                a(false, true, Constant.CODE_ERROR_UNKNOWN_FAIL, "未知异常", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_UNKNOWN_FAIL, "未知异常"), str, monitorStruct, tokenResultListener, resultCodeProcessor, str3);
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

    private boolean a(boolean z10, String str, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str2, TokenResultListener tokenResultListener, String str3) {
        try {
            this.f36891g.i();
            if (!TextUtils.isEmpty(str2)) {
                a(str2, str, monitorStruct, resultCodeProcessor, tokenResultListener);
                return true;
            }
            this.f36894j.e("GetVerifyToken from cache is null!");
            if (z10) {
                a(false, true, Constant.CODE_ERROR_UNKNOWN_FAIL, "未知异常", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_UNKNOWN_FAIL, "未知异常"), str, monitorStruct, tokenResultListener, resultCodeProcessor, str3);
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

    public static /* synthetic */ VendorSdkInfoManager b(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36889e;
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

    public static /* synthetic */ void b(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy, String str, String str2, String str3, String str4, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str5) {
        try {
            phoneNumberAuthHelperProxy.b(str, str2, str3, str4, tokenResultListener, resultCodeProcessor, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void b(String str, String str2, String str3, String str4, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, MonitorStruct monitorStruct, String str5) {
        try {
            this.f36891g.i();
            if (monitorStruct.getAction().equals(this.f36887c.d(str4))) {
                a(false, false, str, str2, str3, str4, monitorStruct, tokenResultListener, resultCodeProcessor, str5);
            } else {
                a(false, true, str, str2, str3, str4, monitorStruct, tokenResultListener, resultCodeProcessor, str5);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private boolean b(final Context context) {
        try {
            String readAuthSDKPrivateKey = UTSharedPreferencesHelper.readAuthSDKPrivateKey(context);
            if (TextUtils.isEmpty(readAuthSDKPrivateKey)) {
                this.f36894j.a("local pritekey is empty");
                RequestState.getInstance().setUseRequest(true);
                ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.16
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, context, true);
                        } catch (Throwable th) {
                            try {
                                ExceptionProcessor.processException(th);
                            } catch (Throwable th2) {
                                ExceptionProcessor.processException(th2);
                            }
                        }
                    }
                });
                return false;
            }
            try {
                PrivateKeyRespone privateKeyRespone = (PrivateKeyRespone) JSONUtils.fromJson(new JSONObject(new String(com.mobile.auth.gatewayauth.utils.security.a.a(readAuthSDKPrivateKey))), (JSONType) new JSONType<PrivateKeyRespone>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.27
                }, (List<Field>) null);
                if (privateKeyRespone == null) {
                    this.f36894j.a("parse local privatekey is empty");
                    RequestState.getInstance().setUseRequest(true);
                    ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.29
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, context, true);
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }
                    });
                    return false;
                }
                RequestState.getInstance().setKeyRespone(privateKeyRespone);
                if (RequestState.getInstance().checkTokenValied(30)) {
                    return true;
                }
                this.f36894j.a("local privatekey expired not enough");
                long expiredTime = privateKeyRespone.getExpiredTime();
                long currentTimeMillis = System.currentTimeMillis();
                RequestState.getInstance().setUseRequest(true);
                ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.30
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, context, true);
                        } catch (Throwable th) {
                            try {
                                ExceptionProcessor.processException(th);
                            } catch (Throwable th2) {
                                ExceptionProcessor.processException(th2);
                            }
                        }
                    }
                });
                if (expiredTime - currentTimeMillis > 0) {
                    return true;
                }
                this.f36894j.a("local privatekey has expired");
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f36894j.a("parse local privatekey error");
                RequestState.getInstance().setUseRequest(true);
                ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.31
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, context, true);
                        } catch (Throwable th) {
                            try {
                                ExceptionProcessor.processException(th);
                            } catch (Throwable th2) {
                                ExceptionProcessor.processException(th2);
                            }
                        }
                    }
                });
                return false;
            }
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

    public static /* synthetic */ f c(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36892h;
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

    private boolean c(Context context) {
        try {
            String readAuthSDKPrivateKey = UTSharedPreferencesHelper.readAuthSDKPrivateKey(context);
            if (!TextUtils.isEmpty(readAuthSDKPrivateKey)) {
                try {
                    PrivateKeyRespone privateKeyRespone = (PrivateKeyRespone) JSONUtils.fromJson(new JSONObject(new String(com.mobile.auth.gatewayauth.utils.security.a.a(readAuthSDKPrivateKey))), (JSONType) new JSONType<PrivateKeyRespone>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.32
                    }, (List<Field>) null);
                    if (privateKeyRespone == null) {
                        return false;
                    }
                    RequestState.getInstance().setKeyRespone(privateKeyRespone);
                    return RequestState.getInstance().checkTokenValied(0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f36894j.a("parse local privatekey error");
                }
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

    public static /* synthetic */ com.mobile.auth.q.a d(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36894j;
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

    private Future<?> d() {
        try {
            return ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        PhoneNumberAuthHelperProxy.e(PhoneNumberAuthHelperProxy.this).a(new RequestCallback<ConfigRule, Void>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.2.1
                            public void a(ConfigRule configRule) {
                                try {
                                    countDownLatch.countDown();
                                } catch (Throwable th) {
                                    try {
                                        ExceptionProcessor.processException(th);
                                    } catch (Throwable th2) {
                                        ExceptionProcessor.processException(th2);
                                    }
                                }
                            }

                            public void a(Void r12) {
                                try {
                                    countDownLatch.countDown();
                                } catch (Throwable th) {
                                    try {
                                        ExceptionProcessor.processException(th);
                                    } catch (Throwable th2) {
                                        ExceptionProcessor.processException(th2);
                                    }
                                }
                            }

                            @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                            public /* synthetic */ void onError(Void r12) {
                                try {
                                    a(r12);
                                } catch (Throwable th) {
                                    try {
                                        ExceptionProcessor.processException(th);
                                    } catch (Throwable th2) {
                                        ExceptionProcessor.processException(th2);
                                    }
                                }
                            }

                            @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                            public /* synthetic */ void onSuccess(ConfigRule configRule) {
                                try {
                                    a(configRule);
                                } catch (Throwable th) {
                                    try {
                                        ExceptionProcessor.processException(th);
                                    } catch (Throwable th2) {
                                        ExceptionProcessor.processException(th2);
                                    }
                                }
                            }
                        });
                        try {
                            countDownLatch.await(com.huawei.openalliance.ad.ipc.c.Code, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
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

    public static /* synthetic */ com.mobile.auth.gatewayauth.manager.b e(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36888d;
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

    public static /* synthetic */ com.mobile.auth.gatewayauth.manager.d f(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36891g;
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

    public static /* synthetic */ ResultCodeProcessor g(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36897m;
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

    @AuthNumber
    public static PhoneNumberAuthHelperProxy getInstance(Context context, TokenResultListener tokenResultListener) {
        try {
            if (f36885a == null && context != null) {
                synchronized (PhoneNumberAuthHelperProxy.class) {
                    if (f36885a == null) {
                        f36885a = new PhoneNumberAuthHelperProxy(context, tokenResultListener);
                    }
                }
            }
            f36885a.setAuthListener(tokenResultListener);
            return f36885a;
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

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:8:0x0009
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 7, instructions: 7 */
    @com.mobile.auth.gatewayauth.annotations.AuthNumber
    public static java.lang.String getVersion() {
        /*
            java.lang.String r0 = "2.13.2.1"
            return r0
        L3:
            r0 = move-exception
            r1 = 0
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r0)     // Catch: java.lang.Throwable -> L9
            return r1
        L9:
            r0 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.getVersion():java.lang.String");
    }

    public static /* synthetic */ Future h(PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy) {
        try {
            return phoneNumberAuthHelperProxy.f36893i;
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

    @SafeProtector
    private native void justGetLoginPhone(MonitorStruct monitorStruct, String str, int i10, ResultCodeProcessor resultCodeProcessor, boolean z10, RequestCallback<LoginPhoneInfo, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, String str2, String str3, int i11);

    @SafeProtector
    private native void justGetLoginToken(long j10, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor);

    @SafeProtector
    private native void justGetToken(int i10, ResultCodeProcessor resultCodeProcessor, boolean z10, TokenResultListener tokenResultListener);

    @SafeProtector
    private void justPreLogin(long j10, final PreLoginResultListener preLoginResultListener, final ResultCodeProcessor resultCodeProcessor, boolean z10, boolean z11) {
        String str;
        int i10;
        String str2;
        String str3;
        try {
            final String j11 = this.f36891g.j();
            String f10 = this.f36891g.f();
            long j12 = j10 <= 0 ? 5000L : j10;
            final String c4 = this.f36887c.c();
            final String b4 = this.f36887c.b(c4);
            final MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.setApiLevel(resultCodeProcessor.getApiLevel());
            monitorStruct.putApiParam("timeout", String.valueOf(j12));
            monitorStruct.setSessionId(f10);
            monitorStruct.setRequestId(j11);
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setVendorKey(c4);
            monitorStruct.setAction(this.f36887c.c(c4));
            monitorStruct.setUrgency(1);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f36887c.e(), true));
            if (preLoginResultListener == null) {
                a(Constant.CODE_ERROR_UNKNOWN_FAIL, "PreLoginResultListener is null", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_UNKNOWN_FAIL, "PreLoginResultListener is null"), c4, (TokenResultListener) null, resultCodeProcessor, monitorStruct, j11);
                this.f36894j.e("accelerateLoginPage errorMsg = PreLoginResultListener is null");
                return;
            }
            final TokenResultListener tokenResultListener = new TokenResultListener() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.22
                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenFailed(String str4) {
                    try {
                        preLoginResultListener.onTokenFailed(b4, str4);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenSuccess(String str4) {
                    try {
                        preLoginResultListener.onTokenSuccess(b4);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            };
            final c cVar = new c(j12, new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.23
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时", com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时"), c4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("justPreLogin errorCode = ", ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "; errorMsg = ", "请求超时", "; action = ", monitorStruct.getAction());
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
            cVar.a();
            TokenRet a10 = this.f36887c.a(resultCodeProcessor, false, c4);
            if (a10 != null && cVar.d()) {
                a(a10.getCode(), a10.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(a10.getCode(), a10.getMsg()), c4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                this.f36894j.e("justPreLogin errorCode = ", a10.getCode(), "; errorMsg = ", a10.getMsg(), "; action = ", monitorStruct.getAction());
                return;
            }
            com.mobile.auth.gatewayauth.manager.a a11 = this.f36892h.a(c4);
            if (a11 == null) {
                if (cVar.d()) {
                    str2 = "justPreLogin errorCode = ";
                    str3 = "; errorMsg = ";
                    a(ResultCode.CODE_ERROR_OPERATOR_UNKNOWN_FAIL, "无法判运营商", com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_OPERATOR_UNKNOWN_FAIL, "无法判运营商"), c4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                } else {
                    str2 = "justPreLogin errorCode = ";
                    str3 = "; errorMsg = ";
                }
                this.f36894j.e(str2, ResultCode.CODE_ERROR_OPERATOR_UNKNOWN_FAIL, str3, "无法判运营商");
                return;
            }
            if (this.f36888d.c()) {
                if (cVar.d()) {
                    i10 = 6;
                    a(Constant.CODE_ERROR_FUNCTION_DEMOTE, "系统维护，功能不可用", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_FUNCTION_DEMOTE, "系统维护，功能不可用"), c4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                } else {
                    i10 = 6;
                }
                com.mobile.auth.q.a aVar = this.f36894j;
                String[] strArr = new String[i10];
                strArr[0] = "justPreLogin errorCode = ";
                strArr[1] = Constant.CODE_ERROR_FUNCTION_DEMOTE;
                strArr[2] = "; errorMsg = ";
                strArr[3] = "系统维护，功能不可用";
                strArr[4] = "; action = ";
                strArr[5] = monitorStruct.getAction();
                aVar.e(strArr);
                return;
            }
            if (z11) {
                if (cVar.d()) {
                    a(ResultCode.CODE_ERROR_CALL_PRE_LOGIN_IN_AUTH_PAGE, ResultCode.MSG_ERROR_CALL_PRE_LOGIN_IN_AUTH_PAGE, com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_CALL_PRE_LOGIN_IN_AUTH_PAGE, ResultCode.MSG_ERROR_CALL_PRE_LOGIN_IN_AUTH_PAGE), c4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                }
                this.f36894j.e("Auth page has been showing!");
                return;
            }
            if (z10 && !this.f36889e.a()) {
                this.f36894j.e("justGetToken SceneCode = null");
                if (cVar.d()) {
                    a(ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, ResultCode.MSG_ERROR_ANALYZE_SDK_INFO, com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, ResultCode.MSG_ERROR_ANALYZE_SDK_INFO), b4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                    return;
                }
                return;
            }
            if (z10) {
                str = f10;
            } else {
                str = f10;
                if (!this.f36889e.a(str, com.mobile.auth.gatewayauth.manager.e.a(this.f36887c.e(), this.f36889e, this.f36888d, this.f36894j))) {
                    this.f36894j.e("justGetToken SceneCode = null");
                    if (cVar.d()) {
                        a(Constant.CODE_ERROR_GET_CONFIG_FAIL, "获取运营商配置信息失败", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_GET_CONFIG_FAIL, "获取运营商配置信息失败"), b4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                        return;
                    }
                    return;
                }
                this.f36892h.a(this.f36889e);
            }
            a11.a(j12);
            this.f36890f.updateMask(j12, c4, new RequestCallback<com.mobile.auth.gatewayauth.manager.base.b, com.mobile.auth.gatewayauth.manager.base.b>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.24
                public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        if (cVar.d()) {
                            monitorStruct.setCache(String.valueOf(bVar.e()));
                            monitorStruct.setAuthSdkCode(resultCodeProcessor.convertCode(Constant.CODE_GET_TOKEN_SUCCESS));
                            PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, true, false, "", b4, monitorStruct, tokenResultListener);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                public void b(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        if (cVar.d()) {
                            monitorStruct.setCache("false");
                            monitorStruct.setCarrierFailedResultData(bVar.d());
                            PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, bVar.b(), bVar.c(), bVar.g(), c4, tokenResultListener, resultCodeProcessor, monitorStruct, j11);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onError(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        b(bVar);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onSuccess(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        a(bVar);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, this.f36887c.getSimCacheKey(!z10, c4), 6, this.f36889e.a(!z10), j11, str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @SafeProtector
    private void justPreVerify(long j10, final PreLoginResultListener preLoginResultListener) {
        int i10;
        char c4;
        String str;
        String str2;
        String str3;
        String str4;
        int i11;
        char c10;
        char c11;
        long j11 = j10 <= 0 ? 5000L : j10;
        try {
            final String j12 = this.f36891g.j();
            String g3 = this.f36891g.g();
            final MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.setApiLevel(this.f36897m.getApiLevel());
            final String c12 = this.f36887c.c();
            final String b4 = this.f36887c.b(c12);
            monitorStruct.putApiParam("timeout", String.valueOf(j11));
            monitorStruct.setSessionId(g3);
            monitorStruct.setRequestId(j12);
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setVendorKey(c12);
            monitorStruct.setAction(this.f36887c.d(c12));
            monitorStruct.setUrgency(1);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f36887c.e(), true));
            if (preLoginResultListener == null) {
                b(Constant.CODE_ERROR_UNKNOWN_FAIL, "PreLoginResultListener is null", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_UNKNOWN_FAIL, "PreLoginResultListener is null"), c12, null, this.f36897m, monitorStruct, j12);
                this.f36894j.e("accelerateVerify errorMsg = PreLoginResultListener is null");
                return;
            }
            final TokenResultListener tokenResultListener = new TokenResultListener() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.15
                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenFailed(String str5) {
                    try {
                        preLoginResultListener.onTokenFailed(b4, str5);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenSuccess(String str5) {
                    try {
                        preLoginResultListener.onTokenSuccess(b4);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            };
            final c cVar = new c(j11, new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this, ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时", com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时"), c12, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), monitorStruct, j12);
                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("justPreVerify errorCode = ", ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "; errorMsg = ", "请求超时", "; action = ", monitorStruct.getAction());
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
            cVar.a();
            TokenRet a10 = this.f36887c.a(this.f36897m, false, c12);
            if (a10 != null) {
                if (cVar.d()) {
                    str3 = "justPreVerify errorCode = ";
                    str4 = "; errorMsg = ";
                    i11 = 6;
                    c10 = 0;
                    c11 = 1;
                    b(a10.getCode(), a10.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(a10.getCode(), a10.getMsg()), c12, tokenResultListener, this.f36897m, monitorStruct, j12);
                } else {
                    str3 = "justPreVerify errorCode = ";
                    str4 = "; errorMsg = ";
                    i11 = 6;
                    c10 = 0;
                    c11 = 1;
                }
                com.mobile.auth.q.a aVar = this.f36894j;
                String[] strArr = new String[i11];
                strArr[c10] = str3;
                strArr[c11] = a10.getCode();
                strArr[2] = str4;
                strArr[3] = a10.getMsg();
                strArr[4] = "; action = ";
                strArr[5] = monitorStruct.getAction();
                aVar.e(strArr);
                return;
            }
            com.mobile.auth.gatewayauth.manager.a a11 = this.f36892h.a(c12);
            if (a11 == null) {
                if (cVar.d()) {
                    str = "justPreVerify errorCode = ";
                    str2 = "; errorMsg = ";
                    b(ResultCode.CODE_ERROR_OPERATOR_UNKNOWN_FAIL, "无法判运营商", com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_OPERATOR_UNKNOWN_FAIL, "无法判运营商"), c12, tokenResultListener, this.f36897m, monitorStruct, j12);
                } else {
                    str = "justPreVerify errorCode = ";
                    str2 = "; errorMsg = ";
                }
                this.f36894j.e(str, ResultCode.CODE_ERROR_OPERATOR_UNKNOWN_FAIL, str2, "无法判运营商");
                return;
            }
            if (!this.f36888d.b()) {
                if (this.f36889e.a()) {
                    a11.a(j11);
                    this.f36890f.b(j11, c12, new RequestCallback<String, com.mobile.auth.gatewayauth.manager.base.b>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.18
                        public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                            try {
                                if (cVar.d()) {
                                    monitorStruct.setCache("false");
                                    monitorStruct.setCarrierFailedResultData(bVar.d());
                                    PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this, bVar.b(), bVar.c(), bVar.g(), c12, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), monitorStruct, j12);
                                }
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }

                        public void a(String str5) {
                            try {
                                if (cVar.d()) {
                                    monitorStruct.setCache(str5);
                                    monitorStruct.setAuthSdkCode(PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertCode(Constant.CODE_GET_TOKEN_SUCCESS));
                                    PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, true, false, "", b4, monitorStruct, tokenResultListener);
                                }
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }

                        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                        public /* synthetic */ void onError(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                            try {
                                a(bVar);
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }

                        @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                        public /* synthetic */ void onSuccess(String str5) {
                            try {
                                a(str5);
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }
                    }, this.f36887c.getSimCacheKey(false, c12), com.mobile.auth.gatewayauth.manager.c.a(c12), this.f36889e.a(false), j12, g3);
                    return;
                } else {
                    this.f36894j.e("justPreVerify SceneCode = null");
                    if (cVar.d()) {
                        b(ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, ResultCode.MSG_ERROR_ANALYZE_SDK_INFO, com.mobile.auth.gatewayauth.utils.a.a(ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, ResultCode.MSG_ERROR_ANALYZE_SDK_INFO), b4, tokenResultListener, this.f36897m, monitorStruct, j12);
                        return;
                    }
                    return;
                }
            }
            if (cVar.d()) {
                c4 = 0;
                i10 = 6;
                b(Constant.CODE_ERROR_FUNCTION_DEMOTE, "系统维护，功能不可用", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_FUNCTION_DEMOTE, "系统维护，功能不可用"), c12, tokenResultListener, this.f36897m, monitorStruct, j12);
            } else {
                i10 = 6;
                c4 = 0;
            }
            com.mobile.auth.q.a aVar2 = this.f36894j;
            String[] strArr2 = new String[i10];
            strArr2[c4] = "justPreVerify errorCode = ";
            strArr2[1] = Constant.CODE_ERROR_FUNCTION_DEMOTE;
            strArr2[2] = "; errorMsg = ";
            strArr2[3] = "系统维护，功能不可用";
            strArr2[4] = "; action = ";
            strArr2[5] = monitorStruct.getAction();
            aVar2.e(strArr2);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public SystemManager a() {
        try {
            return this.f36887c;
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

    public void a(final long j10, final TokenResultListener tokenResultListener, final ResultCodeProcessor resultCodeProcessor) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new g.a(tokenResultListener) { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.6
                @Override // com.mobile.auth.gatewayauth.utils.g.a
                public void a() {
                    try {
                        PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, j10, tokenResultListener, resultCodeProcessor);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public synchronized void a(String str) {
        try {
            this.f36898n = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(String str, String str2, MonitorStruct monitorStruct, ResultCodeProcessor resultCodeProcessor, TokenResultListener tokenResultListener) {
        if (tokenResultListener == null) {
            return;
        }
        try {
            TokenRet convertErrorInfo = resultCodeProcessor.convertErrorInfo(Constant.CODE_GET_TOKEN_SUCCESS, "获取token成功", str2);
            convertErrorInfo.setToken(str);
            convertErrorInfo.setRequestId(monitorStruct.getRequestId());
            monitorStruct.setPerformanceTrace(com.mobile.auth.gatewayauth.utils.e.a().a(monitorStruct.getRequestId()));
            monitorStruct.setAccessCode(str);
            monitorStruct.setAuthSdkCode(convertErrorInfo.getCode());
            a(true, true, "", convertErrorInfo.toJsonString(), monitorStruct, tokenResultListener);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(boolean z10, boolean z11, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor, String str5) {
        try {
            TokenRet convertErrorInfo = resultCodeProcessor.convertErrorInfo(str, str2, str4);
            if (monitorStruct != null) {
                monitorStruct.setPerformanceTrace(com.mobile.auth.gatewayauth.utils.e.a().a(str5));
                monitorStruct.setAuthSdkCode(convertErrorInfo.getCode());
                convertErrorInfo.setCarrierFailedResultData(monitorStruct.getCarrierFailedResultData());
            }
            convertErrorInfo.setRequestId(str5);
            a(z10, z11, str3, convertErrorInfo.toJsonString(), monitorStruct, tokenResultListener);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @AuthNumber
    public void accelerateLoginPage(final int i10, final PreLoginResultListener preLoginResultListener, final boolean z10) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new g.a(this.f36886b) { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.11
                @Override // com.mobile.auth.gatewayauth.utils.g.a
                public void a() {
                    try {
                        PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy = PhoneNumberAuthHelperProxy.this;
                        PhoneNumberAuthHelperProxy.a(phoneNumberAuthHelperProxy, i10, preLoginResultListener, PhoneNumberAuthHelperProxy.g(phoneNumberAuthHelperProxy), true, z10);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @AuthNumber
    public void accelerateVerify(final int i10, final PreLoginResultListener preLoginResultListener) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new g.a(new TokenResultListener() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.13
                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenFailed(String str) {
                    try {
                        PreLoginResultListener preLoginResultListener2 = preLoginResultListener;
                        if (preLoginResultListener2 != null) {
                            preLoginResultListener2.onTokenFailed("", str);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenSuccess(String str) {
                }
            }) { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.14
                @Override // com.mobile.auth.gatewayauth.utils.g.a
                public void a() {
                    try {
                        PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this, i10, preLoginResultListener);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public com.mobile.auth.gatewayauth.manager.d b() {
        try {
            return this.f36891g;
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

    public com.mobile.auth.q.a c() {
        try {
            return this.f36894j;
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

    @AuthNumber
    public void checkEnvAvailable(@IntRange(from = 1, to = 2) final int i10, final TokenResultListener tokenResultListener) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new g.a() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.4
                @Override // com.mobile.auth.gatewayauth.utils.g.a
                public void a() {
                    int i11;
                    try {
                        String c4 = PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this).c();
                        String j10 = PhoneNumberAuthHelperProxy.f(PhoneNumberAuthHelperProxy.this).j();
                        TokenRet tokenRet = null;
                        try {
                            try {
                                int i12 = i10;
                                if (i12 != 1 && i12 != 2) {
                                    TokenRet convertErrorInfo = PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertErrorInfo("600025", ResultCode.MSG_ERROR_INVALID_PARAM, c4);
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                    if (convertErrorInfo != null) {
                                        PhoneNumberAuthHelperProxy.this.a(false, false, convertErrorInfo.getCode(), convertErrorInfo.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(convertErrorInfo.getCode(), convertErrorInfo.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                        return;
                                    }
                                    return;
                                }
                                TokenRet a10 = PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this).a(PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), true, c4);
                                if (a10 != null) {
                                    try {
                                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("checkEnvAvailable errorCode = ", a10.getCode(), "; errorMsg = ", a10.getMsg());
                                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                        PhoneNumberAuthHelperProxy.this.a(false, false, a10.getCode(), a10.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(a10.getCode(), a10.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                        return;
                                    } catch (Exception e2) {
                                        e = e2;
                                        i11 = 2;
                                        e.printStackTrace();
                                        TokenRet convertErrorInfo2 = PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertErrorInfo(ResultCode.CODE_ERROR_UNKNOWN_FAIL, ExecutorManager.getErrorInfoFromException(e), c4);
                                        com.mobile.auth.q.a d10 = PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this);
                                        String[] strArr = new String[i11];
                                        strArr[0] = "checkEnvAvailable exception:";
                                        strArr[1] = convertErrorInfo2.toJsonString();
                                        d10.e(strArr);
                                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                        PhoneNumberAuthHelperProxy.this.a(false, false, convertErrorInfo2.getCode(), convertErrorInfo2.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(convertErrorInfo2.getCode(), convertErrorInfo2.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                    } catch (Throwable th) {
                                        th = th;
                                        tokenRet = a10;
                                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                        if (tokenRet != null) {
                                            PhoneNumberAuthHelperProxy.this.a(false, false, tokenRet.getCode(), tokenRet.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(tokenRet.getCode(), tokenRet.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                        }
                                        throw th;
                                    }
                                }
                                if (!PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this).a()) {
                                    TokenRet convertErrorInfo3 = PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertErrorInfo(ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, ResultCode.MSG_ERROR_ANALYZE_SDK_INFO, c4);
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("checkEnvAvailable errorCode = ", ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, "; errorMsg = ", ResultCode.MSG_ERROR_ANALYZE_SDK_INFO);
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                    if (convertErrorInfo3 != null) {
                                        PhoneNumberAuthHelperProxy.this.a(false, false, convertErrorInfo3.getCode(), convertErrorInfo3.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(convertErrorInfo3.getCode(), convertErrorInfo3.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                        return;
                                    }
                                    return;
                                }
                                if (PhoneNumberAuthHelperProxy.c(PhoneNumberAuthHelperProxy.this).a(c4) == null) {
                                    TokenRet convertErrorInfo4 = PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertErrorInfo(ResultCode.CODE_ERROR_OPERATOR_UNKNOWN_FAIL, "无法判运营商", c4);
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("checkEnvAvailable failed! Unsupported Vendor!");
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                    if (convertErrorInfo4 != null) {
                                        PhoneNumberAuthHelperProxy.this.a(false, false, convertErrorInfo4.getCode(), convertErrorInfo4.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(convertErrorInfo4.getCode(), convertErrorInfo4.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                        return;
                                    }
                                    return;
                                }
                                PhoneNumberAuthHelperProxy.b(PhoneNumberAuthHelperProxy.this).b();
                                if (PhoneNumberAuthHelperProxy.h(PhoneNumberAuthHelperProxy.this) != null) {
                                    PhoneNumberAuthHelperProxy.h(PhoneNumberAuthHelperProxy.this).get();
                                }
                                if (i10 == 1) {
                                    if (PhoneNumberAuthHelperProxy.e(PhoneNumberAuthHelperProxy.this).b()) {
                                        TokenRet convertErrorInfo5 = PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertErrorInfo(ResultCode.CODE_ERROR_FUNCTION_DEMOTE, "系统维护，功能不可用", c4);
                                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("checkEnvAvailable errorCode = ", ResultCode.CODE_ERROR_FUNCTION_DEMOTE, "; errorMsg = ", "系统维护，功能不可用");
                                        PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                        if (convertErrorInfo5 != null) {
                                            PhoneNumberAuthHelperProxy.this.a(false, false, convertErrorInfo5.getCode(), convertErrorInfo5.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(convertErrorInfo5.getCode(), convertErrorInfo5.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                            return;
                                        }
                                        return;
                                    }
                                } else if (PhoneNumberAuthHelperProxy.e(PhoneNumberAuthHelperProxy.this).c()) {
                                    TokenRet convertErrorInfo6 = PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertErrorInfo(ResultCode.CODE_ERROR_FUNCTION_DEMOTE, "系统维护，功能不可用", c4);
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).e("checkEnvAvailable errorCode = ", ResultCode.CODE_ERROR_FUNCTION_DEMOTE, "; errorMsg = ", "系统维护，功能不可用");
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                    if (convertErrorInfo6 != null) {
                                        PhoneNumberAuthHelperProxy.this.a(false, false, convertErrorInfo6.getCode(), convertErrorInfo6.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(convertErrorInfo6.getCode(), convertErrorInfo6.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                        return;
                                    }
                                    return;
                                }
                                PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy = PhoneNumberAuthHelperProxy.this;
                                i11 = 2;
                                try {
                                    phoneNumberAuthHelperProxy.a(true, false, ResultCode.CODE_ERROR_ENV_CHECK_SUCCESS, ResultCode.MSG_ERROR_ENV_CHECK_SUCCESS, "", c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(phoneNumberAuthHelperProxy), j10);
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                } catch (Exception e10) {
                                    e = e10;
                                    e.printStackTrace();
                                    TokenRet convertErrorInfo22 = PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this).convertErrorInfo(ResultCode.CODE_ERROR_UNKNOWN_FAIL, ExecutorManager.getErrorInfoFromException(e), c4);
                                    com.mobile.auth.q.a d102 = PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this);
                                    String[] strArr2 = new String[i11];
                                    strArr2[0] = "checkEnvAvailable exception:";
                                    strArr2[1] = convertErrorInfo22.toJsonString();
                                    d102.e(strArr2);
                                    PhoneNumberAuthHelperProxy.d(PhoneNumberAuthHelperProxy.this).c();
                                    PhoneNumberAuthHelperProxy.this.a(false, false, convertErrorInfo22.getCode(), convertErrorInfo22.getMsg(), com.mobile.auth.gatewayauth.utils.a.a(convertErrorInfo22.getCode(), convertErrorInfo22.getMsg()), c4, null, tokenResultListener, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), j10);
                                }
                            } catch (Exception e11) {
                                e = e11;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        try {
                            ExceptionProcessor.processException(th3);
                        } catch (Throwable th4) {
                            ExceptionProcessor.processException(th4);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x023d  */
    @com.mobile.auth.gatewayauth.annotations.AuthNumber
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkEnvAvailable() {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.checkEnvAvailable():boolean");
    }

    @AuthNumber
    public void clearPreInfo() {
        try {
            this.f36890f.a();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @AuthNumber
    public String getCurrentCarrierName() {
        try {
            return this.f36887c.d();
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

    @AuthNumber
    public String getLoginMaskPhone(int i10, final String str, final OnLoginPhoneListener onLoginPhoneListener, final boolean z10, boolean z11, final String str2) {
        try {
            final MonitorStruct monitorStruct = new MonitorStruct();
            String f10 = this.f36891g.f();
            monitorStruct.setStartTime(System.currentTimeMillis());
            justGetLoginPhone(monitorStruct, str, i10, this.f36897m, z11, new RequestCallback<LoginPhoneInfo, com.mobile.auth.gatewayauth.manager.base.b>() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.19
                public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        PhoneNumberAuthHelperProxy.f(PhoneNumberAuthHelperProxy.this).h();
                        PhoneNumberAuthHelperProxy.this.a(false, true, bVar.b(), bVar.c(), bVar.g(), str, monitorStruct, new TokenResultListener() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.19.3
                            @Override // com.mobile.auth.gatewayauth.TokenResultListener
                            public void onTokenFailed(String str3) {
                                try {
                                    onLoginPhoneListener.onGetFailed(str3);
                                } catch (Throwable th) {
                                    try {
                                        ExceptionProcessor.processException(th);
                                    } catch (Throwable th2) {
                                        ExceptionProcessor.processException(th2);
                                    }
                                }
                            }

                            @Override // com.mobile.auth.gatewayauth.TokenResultListener
                            public void onTokenSuccess(String str3) {
                            }
                        }, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), str2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                public void a(final LoginPhoneInfo loginPhoneInfo) {
                    try {
                        loginPhoneInfo.setVendor(PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this).b(str));
                        if (com.mobile.auth.gatewayauth.utils.c.e(PhoneNumberAuthHelperProxy.a(PhoneNumberAuthHelperProxy.this).e())) {
                            PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy = PhoneNumberAuthHelperProxy.this;
                            phoneNumberAuthHelperProxy.a(true, z10, "600000", "获取掩码成功", "", str, monitorStruct, null, PhoneNumberAuthHelperProxy.g(phoneNumberAuthHelperProxy), str2);
                            ExecutorManager.getInstance().postMain(new ExecutorManager.SafeRunnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.19.1
                                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                                public void onException(Throwable th) {
                                }

                                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                                public void safeRun() {
                                    try {
                                        onLoginPhoneListener.onGetLoginPhone(loginPhoneInfo);
                                    } catch (Throwable th) {
                                        try {
                                            ExceptionProcessor.processException(th);
                                        } catch (Throwable th2) {
                                            ExceptionProcessor.processException(th2);
                                        }
                                    }
                                }
                            });
                        } else {
                            PhoneNumberAuthHelperProxy.this.a(false, true, ResultCode.CODE_ERROR_NO_MOBILE_NETWORK_FAIL, ResultCode.MSG_ERROR_NO_MOBILE_NETWORK_FAIL, "", str, monitorStruct, new TokenResultListener() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.19.2
                                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                                public void onTokenFailed(String str3) {
                                    try {
                                        onLoginPhoneListener.onGetFailed(str3);
                                    } catch (Throwable th) {
                                        try {
                                            ExceptionProcessor.processException(th);
                                        } catch (Throwable th2) {
                                            ExceptionProcessor.processException(th2);
                                        }
                                    }
                                }

                                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                                public void onTokenSuccess(String str3) {
                                }
                            }, PhoneNumberAuthHelperProxy.g(PhoneNumberAuthHelperProxy.this), str2);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onError(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        a(bVar);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onSuccess(LoginPhoneInfo loginPhoneInfo) {
                    try {
                        a(loginPhoneInfo);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, str2, f10, 6);
            return str2;
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

    @AuthNumber
    public PnsReporter getReporter() {
        try {
            return this.f36891g.b();
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

    @AuthNumber
    public void getVerifyToken(final int i10, final TokenResultListener tokenResultListener) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new g.a(tokenResultListener) { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.5
                @Override // com.mobile.auth.gatewayauth.utils.g.a
                public void a() {
                    try {
                        PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy = PhoneNumberAuthHelperProxy.this;
                        PhoneNumberAuthHelperProxy.a(phoneNumberAuthHelperProxy, i10, PhoneNumberAuthHelperProxy.g(phoneNumberAuthHelperProxy), true, tokenResultListener);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @AuthNumber
    public void prohibitUseUtdid() {
        try {
            com.mobile.auth.gatewayauth.manager.d dVar = this.f36891g;
            if (dVar != null) {
                dVar.n();
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @AuthNumber
    public void setAuthListener(TokenResultListener tokenResultListener) {
        try {
            this.f36886b = tokenResultListener;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @AuthNumber
    public void setAuthSDKInfo(String str) {
        try {
            this.f36894j.a("setAuthSDKInfo secretInfo = ", str);
            this.f36887c.a(str);
            this.f36889e.setLocalVendorSdkInfo(str);
            if (!this.f36892h.a(this.f36889e)) {
                this.f36894j.e("VendorSdkFactor update local VendorConfig failed!");
                return;
            }
            com.mobile.auth.gatewayauth.utils.c.g(this.f36887c.e());
            if (!b(this.f36887c.e()) || RequestState.getInstance().checkTokenValied(1) || RequestState.getInstance().isUseRequest() || RequestState.getInstance().checkTokenValied(1)) {
                return;
            }
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelperProxy.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PhoneNumberAuthHelperProxy phoneNumberAuthHelperProxy = PhoneNumberAuthHelperProxy.this;
                        PhoneNumberAuthHelperProxy.a(phoneNumberAuthHelperProxy, PhoneNumberAuthHelperProxy.a(phoneNumberAuthHelperProxy).e(), true);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
