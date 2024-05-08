package com.mobile.auth.t;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.a.c;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.manager.RequestCallback;
import com.mobile.auth.gatewayauth.manager.a;
import com.mobile.auth.gatewayauth.manager.base.b;
import com.mobile.auth.gatewayauth.manager.d;
import com.mobile.auth.gatewayauth.model.MonitorStruct;
import com.mobile.auth.gatewayauth.model.ctcctoken.CTCCTokenRet;
import com.mobile.auth.gatewayauth.model.ctcctoken.Data;
import com.nirvana.tools.core.ExecutorManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.mobile.auth.gatewayauth.manager.a {

    /* renamed from: i, reason: collision with root package name */
    private c f37633i;

    public a(Context context, d dVar) {
        super(context, dVar, Constant.VENDOR_CTCC, null);
        this.f37633i = new c() { // from class: com.mobile.auth.t.a.1
            @Override // com.mobile.auth.a.c
            public void a(String str, String str2) {
                try {
                    a.a(a.this).a(str, str2);
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            }

            @Override // com.mobile.auth.a.c
            public void a(String str, String str2, Throwable th) {
                try {
                    if (th != null) {
                        a.b(a.this).c(str, str2, ExecutorManager.getErrorInfoFromException(th));
                    } else {
                        a.c(a.this).c(str, str2);
                    }
                } catch (Throwable th2) {
                    try {
                        ExceptionProcessor.processException(th2);
                    } catch (Throwable th3) {
                        ExceptionProcessor.processException(th3);
                    }
                }
            }
        };
    }

    public static /* synthetic */ com.mobile.auth.q.a a(a aVar) {
        try {
            return aVar.f37253h;
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

    private synchronized void a(final RequestCallback<a.C0558a, b> requestCallback, final MonitorStruct monitorStruct, final String str) {
        try {
            com.mobile.auth.a.a.a((int) this.f37248c, (int) this.f37248c, (int) this.f37248c, this.f37633i);
            com.mobile.auth.a.a.a(this.f37249d, this.f37246a, this.f37247b, new com.mobile.auth.a.b() { // from class: com.mobile.auth.t.a.2
                @Override // com.mobile.auth.a.b
                public void a(String str2) {
                    try {
                        monitorStruct.setCarrierReturnTime(System.currentTimeMillis());
                        a.d(a.this).a("ctcc：", "getLoginInfo:", str2);
                        if (TextUtils.isEmpty(str2)) {
                            a.a(a.this, requestCallback, Constant.CODE_ERROR_UNKNOWN_FAIL, "CTCC 获得的手机授权码结果为空", "", Constant.VENDOR_CTCC, monitorStruct, str);
                            return;
                        }
                        try {
                            CTCCTokenRet fromJson = CTCCTokenRet.fromJson(str2);
                            if (fromJson != null) {
                                monitorStruct.setCarrierTraceId(fromJson.getReqId());
                                if (fromJson.getResult() != 0 || fromJson.getData() == null) {
                                    a.d(a.this, requestCallback, String.valueOf(fromJson.getResult()), fromJson.getMsg(), str2, Constant.VENDOR_CTCC, monitorStruct, str);
                                    return;
                                }
                                Data data = fromJson.getData();
                                String number = data.getNumber();
                                String accessCode = data.getAccessCode();
                                if (TextUtils.isEmpty(number)) {
                                    a.c(a.this, requestCallback, String.valueOf(fromJson.getResult()), fromJson.getMsg(), str2, Constant.VENDOR_CTCC, monitorStruct, str);
                                    return;
                                }
                                requestCallback.onSuccess(a.C0558a.a().a(number).c(Constant.CTCC_PROTOCOL).d(Constant.CTCC_PROTOCOL_URL).b(accessCode).a(System.currentTimeMillis() + (data.getExpiredTime() * 1000)).a());
                                monitorStruct.setPhoneNumber(number);
                                monitorStruct.setAccessCode(accessCode);
                                a.a(a.this, String.valueOf(fromJson.getResult()), "", "", true, Constant.VENDOR_CTCC, monitorStruct);
                            }
                        } catch (Exception e2) {
                            a.e(a.this).e("CTCCValidManager init exception:", ExecutorManager.getErrorInfoFromException(e2));
                            a.b(a.this, requestCallback, Constant.CODE_ERROR_UNKNOWN_FAIL, "JSON转换失败", str2, Constant.VENDOR_CTCC, monitorStruct, str);
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

    public static /* synthetic */ void a(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(a aVar, String str, String str2, String str3, boolean z10, String str4, MonitorStruct monitorStruct) {
        try {
            aVar.a(str, str2, str3, z10, str4, monitorStruct);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a b(a aVar) {
        try {
            return aVar.f37253h;
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

    public static /* synthetic */ void b(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void b(a aVar, String str, String str2, String str3, boolean z10, String str4, MonitorStruct monitorStruct) {
        try {
            aVar.a(str, str2, str3, z10, str4, monitorStruct);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a c(a aVar) {
        try {
            return aVar.f37253h;
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

    public static /* synthetic */ void c(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a d(a aVar) {
        try {
            return aVar.f37253h;
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

    public static /* synthetic */ void d(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a e(a aVar) {
        try {
            return aVar.f37253h;
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

    public static /* synthetic */ void e(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a f(a aVar) {
        try {
            return aVar.f37253h;
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

    public static /* synthetic */ void f(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a g(a aVar) {
        try {
            return aVar.f37253h;
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

    public static /* synthetic */ void g(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void h(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            aVar.a((RequestCallback<a.C0558a, b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.manager.a
    public void a(boolean z10) {
    }

    @Override // com.mobile.auth.gatewayauth.manager.a
    public String b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                Integer valueOf = Integer.valueOf(Integer.parseInt(str));
                if (valueOf.intValue() >= 10000) {
                    if (valueOf.intValue() <= 40000) {
                        return str2;
                    }
                }
            } catch (Exception unused) {
            }
            char c4 = 65535;
            switch (str.hashCode()) {
                case -1389750326:
                    if (str.equals("-720002")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 43274408:
                    if (str.equals("-8003")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 43274409:
                    if (str.equals("-8004")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case 43275366:
                    if (str.equals("-8100")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 53194808:
                    if (str.equals("80000")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 53194811:
                    if (str.equals("80003")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 53194812:
                    if (str.equals("80004")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case 53194813:
                    if (str.equals("80005")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 53202496:
                    if (str.equals("80800")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 1335041958:
                    if (str.equals(Constant.CODE_ERROR_GET_CONFIG_FAIL)) {
                        c4 = 0;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    return "600025";
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return ResultCode.CODE_ERROR_FUNCTION_TIME_OUT;
                case 6:
                case 7:
                case '\b':
                case '\t':
                    return Constant.CODE_ERROR_NO_MOBILE_NETWORK_FAIL;
                default:
                    return str2;
            }
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

    @Override // com.mobile.auth.gatewayauth.manager.a
    public void c() {
    }

    @Override // com.mobile.auth.gatewayauth.manager.a
    public synchronized void d(RequestCallback<a.C0558a, b> requestCallback, a.b bVar) {
        try {
            MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.putApiParam("timeout", String.valueOf(this.f37248c));
            monitorStruct.setSessionId(bVar.c());
            monitorStruct.setRequestId(bVar.b());
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setAction(Constant.ACTION_CTCC_LOGIN_CODE);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f37249d, true));
            a(requestCallback, monitorStruct, ResultCode.CODE_GET_MASK_FAIL);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.manager.a
    public synchronized void e(RequestCallback<a.C0558a, b> requestCallback, a.b bVar) {
        try {
            MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.putApiParam("timeout", String.valueOf(this.f37248c));
            monitorStruct.setSessionId(bVar.c());
            monitorStruct.setRequestId(bVar.b());
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setAction(Constant.ACTION_CTCC_LOGIN_TOKEN);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f37249d, true));
            a(requestCallback, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.manager.a
    public synchronized void f(final RequestCallback<a.C0558a, b> requestCallback, a.b bVar) {
        try {
            final MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.putApiParam("timeout", String.valueOf(this.f37248c));
            monitorStruct.setSessionId(bVar.c());
            monitorStruct.setRequestId(bVar.b());
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setAction(Constant.ACTION_CTCC_AUTH_TOKEN);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f37249d, true));
            com.mobile.auth.a.a.a((int) this.f37248c, (int) this.f37248c, (int) this.f37248c, this.f37633i);
            com.mobile.auth.a.a.a(this.f37249d, this.f37246a, this.f37247b, new com.mobile.auth.a.b() { // from class: com.mobile.auth.t.a.3
                @Override // com.mobile.auth.a.b
                public void a(String str) {
                    try {
                        monitorStruct.setCarrierReturnTime(System.currentTimeMillis());
                        a.f(a.this).a("ctcc：", "getVerifyInfo:", str);
                        if (TextUtils.isEmpty(str)) {
                            a.e(a.this, requestCallback, Constant.CODE_ERROR_UNKNOWN_FAIL, "CTCC 获得认证Token结果为空", "", Constant.VENDOR_CTCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
                            return;
                        }
                        try {
                            CTCCTokenRet fromJson = CTCCTokenRet.fromJson(str);
                            if (fromJson != null) {
                                monitorStruct.setCarrierTraceId(fromJson.getReqId());
                                if (fromJson.getResult() != 0 || fromJson.getData() == null) {
                                    a.h(a.this, requestCallback, String.valueOf(fromJson.getResult()), fromJson.getMsg(), str, Constant.VENDOR_CTCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
                                    return;
                                }
                                String accessCode = fromJson.getData().getAccessCode();
                                if (TextUtils.isEmpty(accessCode)) {
                                    a.g(a.this, requestCallback, String.valueOf(fromJson.getResult()), fromJson.getMsg(), str, Constant.VENDOR_CTCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
                                    return;
                                }
                                monitorStruct.setAccessCode(accessCode);
                                a.b(a.this, String.valueOf(fromJson.getResult()), fromJson.getMsg(), "", true, Constant.VENDOR_CTCC, monitorStruct);
                                requestCallback.onSuccess(a.C0558a.a().b(accessCode).a(System.currentTimeMillis() + (r1.getExpiredTime() * 1000)).a());
                            }
                        } catch (Exception e2) {
                            a.g(a.this).e("CTCCValidManager init exception:", ExecutorManager.getErrorInfoFromException(e2));
                            a.f(a.this, requestCallback, Constant.CODE_ERROR_UNKNOWN_FAIL, "JSON转换失败", str, Constant.VENDOR_CTCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
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
}
