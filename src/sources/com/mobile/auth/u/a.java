package com.mobile.auth.u;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.manager.RequestCallback;
import com.mobile.auth.gatewayauth.manager.a;
import com.mobile.auth.gatewayauth.manager.base.b;
import com.mobile.auth.gatewayauth.manager.d;
import com.mobile.auth.gatewayauth.model.MonitorStruct;
import com.mobile.auth.gatewayauth.utils.c;
import com.mobile.auth.gatewayauth.utils.i;
import com.unicom.online.account.shield.ResultListener;
import com.unicom.online.account.shield.UniAccountHelper;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.mobile.auth.gatewayauth.manager.a {
    public a(Context context, d dVar) {
        super(context, dVar, Constant.VENDOR_CUCC, null);
    }

    private synchronized void a(final RequestCallback<a.C0558a, b> requestCallback, final MonitorStruct monitorStruct, final String str) {
        try {
            UniAccountHelper.getInstance().cuGetToken((int) this.f37248c, new ResultListener() { // from class: com.mobile.auth.u.a.1
                @Override // com.unicom.online.account.shield.ResultListener
                public void onResult(String str2) {
                    try {
                        try {
                            TextUtils.isEmpty("");
                            JSONObject jSONObject = new JSONObject(str2);
                            int optInt = jSONObject.optInt("resultCode");
                            String optString = jSONObject.optString("resultMsg");
                            JSONObject optJSONObject = jSONObject.optJSONObject("resultData");
                            if (optInt == 100) {
                                if (optJSONObject != null) {
                                    String optString2 = optJSONObject.optString("fakeMobile");
                                    String optString3 = optJSONObject.optString("accessCode");
                                    long optLong = optJSONObject.optLong("exp");
                                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                                        requestCallback.onSuccess(a.C0558a.a().a(optString2).c(Constant.CUCC_WOPROTOCOL).d(Constant.CUCC_WOPROTOCOL_URL).b(optString3).a(optLong).a());
                                        monitorStruct.setAccessCode(optString3);
                                        monitorStruct.setPhoneNumber(optString2);
                                        a.a(a.this, String.valueOf(optInt), "", "", true, Constant.VENDOR_CUCC, monitorStruct);
                                    } else if ("1202".equals(Integer.valueOf(optInt))) {
                                        a.a(a.this, requestCallback, String.valueOf(optInt), ResultCode.MSG_ERROR_ANALYZE_SDK_BLACKLIST_INFO, str2, Constant.VENDOR_CUCC, monitorStruct, str);
                                    } else {
                                        a.b(a.this, requestCallback, String.valueOf(optInt), optString, str2, Constant.VENDOR_CUCC, monitorStruct, str);
                                    }
                                }
                            } else if ("1202".equals(Integer.valueOf(optInt))) {
                                a.c(a.this, requestCallback, String.valueOf(optInt), ResultCode.MSG_ERROR_ANALYZE_SDK_BLACKLIST_INFO, str2, Constant.VENDOR_CUCC, monitorStruct, str);
                            } else {
                                a.d(a.this, requestCallback, String.valueOf(optInt), optString, str2, Constant.VENDOR_CUCC, monitorStruct, str);
                            }
                        } catch (Exception e2) {
                            a.e(a.this, requestCallback, Constant.CODE_ERROR_UNKNOWN_FAIL, "JSON转换失败", e2.toString(), Constant.VENDOR_CUCC, monitorStruct, str);
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

    public static /* synthetic */ void i(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
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

    public static /* synthetic */ void j(a aVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
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
    public void a(String str, String str2) {
        try {
            super.a(str, str2);
            UniAccountHelper.getInstance().setLogEnable(i.b());
            UniAccountHelper.getInstance().init(this.f37249d, str);
            UniAccountHelper.getInstance().setUseCacheFlag(false);
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
            char c4 = 65535;
            switch (str.hashCode()) {
                case 1535446013:
                    if (str.equals("410000")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 1535446014:
                    if (str.equals("410001")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1535446015:
                    if (str.equals("410002")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1535446016:
                    if (str.equals("410003")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 1535446017:
                    if (str.equals("410004")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 1535446018:
                    if (str.equals("410005")) {
                        c4 = 5;
                        break;
                    }
                    break;
            }
            return c4 != 0 ? (c4 == 1 || c4 == 2) ? "600025" : (c4 == 3 || c4 == 4 || c4 == 5) ? Constant.CODE_ERROR_NO_MOBILE_NETWORK_FAIL : str2 : ResultCode.CODE_ERROR_FUNCTION_TIME_OUT;
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
            monitorStruct.setAction(Constant.ACTION_CUCC_LOGIN_CODE);
            monitorStruct.setUrgency(1);
            monitorStruct.setNetworkType(c.a(this.f37249d, true));
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
    public synchronized void e(final RequestCallback<a.C0558a, b> requestCallback, a.b bVar) {
        try {
            MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.putApiParam("timeout", String.valueOf(this.f37248c));
            monitorStruct.setSessionId(bVar.c());
            monitorStruct.setRequestId(bVar.b());
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setAction(Constant.ACTION_CUCC_LOGIN_TOKEN);
            monitorStruct.setNetworkType(c.a(this.f37249d, true));
            a(new RequestCallback<a.C0558a, b>() { // from class: com.mobile.auth.u.a.2
                public void a(a.C0558a c0558a) {
                    try {
                        requestCallback.onSuccess(c0558a);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                public void a(b bVar2) {
                    try {
                        requestCallback.onError(bVar2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onError(b bVar2) {
                    try {
                        a(bVar2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onSuccess(a.C0558a c0558a) {
                    try {
                        a(c0558a);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
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
            monitorStruct.setAction(Constant.ACTION_CUCC_AUTH_TOKEN);
            monitorStruct.setNetworkType(c.a(this.f37249d, true));
            UniAccountHelper.getInstance().cuMobileAuth((int) this.f37248c, new ResultListener() { // from class: com.mobile.auth.u.a.3
                @Override // com.unicom.online.account.shield.ResultListener
                public void onResult(String str) {
                    try {
                        try {
                            TextUtils.isEmpty("");
                            JSONObject jSONObject = new JSONObject(str);
                            int optInt = jSONObject.optInt("resultCode");
                            String optString = jSONObject.optString("resultMsg");
                            JSONObject optJSONObject = jSONObject.optJSONObject("resultData");
                            if (optInt == 100) {
                                if (optJSONObject != null) {
                                    String optString2 = optJSONObject.optString("accessCode");
                                    long optLong = optJSONObject.optLong("exp");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        requestCallback.onSuccess(a.C0558a.a().c(Constant.CUCC_WOPROTOCOL).d(Constant.CUCC_WOPROTOCOL_URL).b(optString2).a(optLong).a());
                                        monitorStruct.setAccessCode(optString2);
                                        a.b(a.this, String.valueOf(optInt), "", "", true, Constant.VENDOR_CUCC, monitorStruct);
                                    } else if ("1202".equals(Integer.valueOf(optInt))) {
                                        a.f(a.this, requestCallback, String.valueOf(optInt), ResultCode.MSG_ERROR_ANALYZE_SDK_BLACKLIST_INFO, str, Constant.VENDOR_CUCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
                                    } else {
                                        a.g(a.this, requestCallback, String.valueOf(optInt), optString, str, Constant.VENDOR_CUCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
                                    }
                                }
                            } else if ("1202".equals(Integer.valueOf(optInt))) {
                                a.h(a.this, requestCallback, String.valueOf(optInt), ResultCode.MSG_ERROR_ANALYZE_SDK_BLACKLIST_INFO, str, Constant.VENDOR_CUCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
                            } else {
                                a.i(a.this, requestCallback, String.valueOf(optInt), optString, str, Constant.VENDOR_CUCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
                            }
                        } catch (Throwable th) {
                            try {
                                ExceptionProcessor.processException(th);
                            } catch (Throwable th2) {
                                ExceptionProcessor.processException(th2);
                            }
                        }
                    } catch (Exception e2) {
                        a.j(a.this, requestCallback, Constant.CODE_ERROR_UNKNOWN_FAIL, "JSON转换失败", e2.toString(), Constant.VENDOR_CUCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
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
