package com.mobile.auth.s;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.manager.RequestCallback;
import com.mobile.auth.gatewayauth.manager.a;
import com.mobile.auth.gatewayauth.model.MonitorStruct;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends com.mobile.auth.gatewayauth.manager.a {

    /* renamed from: i, reason: collision with root package name */
    private a f37623i;

    public d(Context context, com.mobile.auth.gatewayauth.manager.d dVar) {
        super(context, dVar, Constant.VENDOR_CMCC, null);
        this.f37623i = a.a(this.f37249d);
    }

    public static /* synthetic */ com.mobile.auth.q.a a(d dVar) {
        try {
            return dVar.f37253h;
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

    public static /* synthetic */ void a(d dVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            dVar.a((RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(d dVar, String str, String str2, String str3, boolean z10, String str4, MonitorStruct monitorStruct) {
        try {
            dVar.a(str, str2, str3, z10, str4, monitorStruct);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a b(d dVar) {
        try {
            return dVar.f37253h;
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

    public static /* synthetic */ void b(d dVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            dVar.a((RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void b(d dVar, String str, String str2, String str3, boolean z10, String str4, MonitorStruct monitorStruct) {
        try {
            dVar.a(str, str2, str3, z10, str4, monitorStruct);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ a c(d dVar) {
        try {
            return dVar.f37623i;
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

    public static /* synthetic */ void c(d dVar, RequestCallback requestCallback, String str, String str2, String str3, String str4, MonitorStruct monitorStruct, String str5) {
        try {
            dVar.a((RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b>) requestCallback, str, str2, str3, str4, monitorStruct, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void c(d dVar, String str, String str2, String str3, boolean z10, String str4, MonitorStruct monitorStruct) {
        try {
            dVar.a(str, str2, str3, z10, str4, monitorStruct);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a d(d dVar) {
        try {
            return dVar.f37253h;
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
    public void a(long j10) {
        try {
            super.a(j10);
            this.f37623i.a(this.f37248c);
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
            this.f37623i.a(str);
            this.f37623i.b(str2);
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
        try {
            com.mobile.auth.g.e.a(z10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
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
                case 1448695583:
                    if (str.equals("102101")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1448695585:
                    if (str.equals("102103")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1448696546:
                    if (str.equals("102203")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 1448699433:
                    if (str.equals("102507")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 1477264254:
                    if (str.equals("200022")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 1477264255:
                    if (str.equals("200023")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1477264256:
                    if (str.equals("200024")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 1477264259:
                    if (str.equals("200027")) {
                        c4 = 3;
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
                    return Constant.CODE_ERROR_NO_MOBILE_NETWORK_FAIL;
                case 5:
                case 6:
                case 7:
                    return ResultCode.CODE_ERROR_FUNCTION_TIME_OUT;
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
        try {
            this.f37623i.c();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.manager.a
    public synchronized void d(final RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, a.b bVar) {
        final MonitorStruct monitorStruct;
        try {
            monitorStruct = new MonitorStruct();
            monitorStruct.putApiParam("timeout", String.valueOf(this.f37248c));
            monitorStruct.setSessionId(bVar.c());
            monitorStruct.setRequestId(bVar.b());
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setAction(Constant.ACTION_CMCC_LOGIN_CODE);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f37249d, true));
        } finally {
            return;
        }
        if (!TextUtils.isEmpty(this.f37246a) && !TextUtils.isEmpty(this.f37247b)) {
            this.f37623i.a(new com.mobile.auth.g.b() { // from class: com.mobile.auth.s.d.1
                /* JADX WARN: Removed duplicated region for block: B:12:0x0085 A[Catch: all -> 0x00ca, TryCatch #0 {all -> 0x00ca, blocks: (B:3:0x0006, B:5:0x0011, B:6:0x0016, B:8:0x0024, B:10:0x0041, B:12:0x0085, B:15:0x00b8, B:17:0x002a, B:19:0x0030, B:20:0x0035, B:22:0x003b), top: B:2:0x0006 }] */
                /* JADX WARN: Removed duplicated region for block: B:15:0x00b8 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #0 {all -> 0x00ca, blocks: (B:3:0x0006, B:5:0x0011, B:6:0x0016, B:8:0x0024, B:10:0x0041, B:12:0x0085, B:15:0x00b8, B:17:0x002a, B:19:0x0030, B:20:0x0035, B:22:0x003b), top: B:2:0x0006 }] */
                @Override // com.mobile.auth.g.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a(int r12, org.json.JSONObject r13) {
                    /*
                        r11 = this;
                        java.lang.String r12 = "resultString"
                        java.lang.String r0 = "desc"
                        java.lang.String r1 = "resultDesc"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r2 = r2     // Catch: java.lang.Throwable -> Lca
                        long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lca
                        r2.setCarrierReturnTime(r3)     // Catch: java.lang.Throwable -> Lca
                        if (r13 != 0) goto L16
                        org.json.JSONObject r13 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lca
                        r13.<init>()     // Catch: java.lang.Throwable -> Lca
                    L16:
                        java.lang.String r2 = "resultCode"
                        java.lang.String r5 = r13.optString(r2)     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r2 = ""
                        boolean r3 = r13.has(r1)     // Catch: java.lang.Throwable -> Lca
                        if (r3 == 0) goto L2a
                        java.lang.String r12 = r13.optString(r1)     // Catch: java.lang.Throwable -> Lca
                    L28:
                        r6 = r12
                        goto L41
                    L2a:
                        boolean r1 = r13.has(r0)     // Catch: java.lang.Throwable -> Lca
                        if (r1 == 0) goto L35
                        java.lang.String r12 = r13.optString(r0)     // Catch: java.lang.Throwable -> Lca
                        goto L28
                    L35:
                        boolean r0 = r13.has(r12)     // Catch: java.lang.Throwable -> Lca
                        if (r0 == 0) goto L40
                        java.lang.String r12 = r13.optString(r12)     // Catch: java.lang.Throwable -> Lca
                        goto L28
                    L40:
                        r6 = r2
                    L41:
                        java.lang.String r12 = "traceId"
                        java.lang.String r12 = r13.optString(r12)     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r0 = "securityphone"
                        java.lang.String r0 = r13.optString(r0)     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.s.d r1 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.q.a r1 = com.mobile.auth.s.d.a(r1)     // Catch: java.lang.Throwable -> Lca
                        r2 = 7
                        java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lca
                        r3 = 0
                        java.lang.String r4 = "cmcc："
                        r2[r3] = r4     // Catch: java.lang.Throwable -> Lca
                        r3 = 1
                        java.lang.String r4 = "getLoginInfo:code="
                        r2[r3] = r4     // Catch: java.lang.Throwable -> Lca
                        r3 = 2
                        r2[r3] = r5     // Catch: java.lang.Throwable -> Lca
                        r3 = 3
                        java.lang.String r4 = ",msg="
                        r2[r3] = r4     // Catch: java.lang.Throwable -> Lca
                        r3 = 4
                        r2[r3] = r6     // Catch: java.lang.Throwable -> Lca
                        r3 = 5
                        java.lang.String r4 = ",json="
                        r2[r3] = r4     // Catch: java.lang.Throwable -> Lca
                        r3 = 6
                        java.lang.String r4 = r13.toString()     // Catch: java.lang.Throwable -> Lca
                        r2[r3] = r4     // Catch: java.lang.Throwable -> Lca
                        r1.a(r2)     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.gatewayauth.model.MonitorStruct r1 = r2     // Catch: java.lang.Throwable -> Lca
                        r1.setCarrierTraceId(r12)     // Catch: java.lang.Throwable -> Lca
                        boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lca
                        if (r12 != 0) goto Lb8
                        com.mobile.auth.gatewayauth.manager.RequestCallback r12 = r3     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.gatewayauth.manager.a$a$a r13 = com.mobile.auth.gatewayauth.manager.a.C0558a.a()     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.gatewayauth.manager.a$a$a r13 = r13.a(r0)     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r1 = "中国移动认证服务条款"
                        com.mobile.auth.gatewayauth.manager.a$a$a r13 = r13.c(r1)     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r1 = "https://wap.cmpassport.com/resources/html/contract.html"
                        com.mobile.auth.gatewayauth.manager.a$a$a r13 = r13.d(r1)     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.gatewayauth.manager.a$a r13 = r13.a()     // Catch: java.lang.Throwable -> Lca
                        r12.onSuccess(r13)     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.gatewayauth.model.MonitorStruct r12 = r2     // Catch: java.lang.Throwable -> Lca
                        r12.setPhoneNumber(r0)     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.s.d r3 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r12 = ""
                        java.lang.String r6 = ""
                        r7 = 1
                        java.lang.String r8 = "cm_zyhl"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r9 = r2     // Catch: java.lang.Throwable -> Lca
                        r4 = r5
                        r5 = r12
                        com.mobile.auth.s.d.a(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lca
                        goto Ld3
                    Lb8:
                        com.mobile.auth.s.d r3 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Lca
                        com.mobile.auth.gatewayauth.manager.RequestCallback r4 = r3     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r7 = r13.toString()     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r8 = "cm_zyhl"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r9 = r2     // Catch: java.lang.Throwable -> Lca
                        java.lang.String r10 = "600012"
                        com.mobile.auth.s.d.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lca
                        goto Ld3
                    Lca:
                        r12 = move-exception
                        com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r12)     // Catch: java.lang.Throwable -> Lcf
                        goto Ld3
                    Lcf:
                        r12 = move-exception
                        com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r12)
                    Ld3:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.s.d.AnonymousClass1.a(int, org.json.JSONObject):void");
                }
            });
            return;
        }
        a(requestCallback, ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, ResultCode.MSG_ERROR_ANALYZE_SDK_INFO, "", Constant.VENDOR_CMCC, monitorStruct, ResultCode.CODE_GET_MASK_FAIL);
    }

    @Override // com.mobile.auth.gatewayauth.manager.a
    public synchronized void e(final RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, a.b bVar) {
        try {
            final MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.putApiParam("timeout", String.valueOf(this.f37248c));
            monitorStruct.setSessionId(bVar.c());
            monitorStruct.setRequestId(bVar.b());
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setAction(Constant.ACTION_CMCC_LOGIN_TOKEN);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f37249d, true));
            this.f37623i.c(new com.mobile.auth.g.b() { // from class: com.mobile.auth.s.d.2
                /* JADX WARN: Removed duplicated region for block: B:12:0x0085 A[Catch: all -> 0x00db, TryCatch #1 {all -> 0x00db, blocks: (B:3:0x0008, B:5:0x0013, B:6:0x0018, B:8:0x0026, B:10:0x0043, B:12:0x0085, B:15:0x00c9, B:17:0x002c, B:19:0x0032, B:20:0x0037, B:22:0x003d), top: B:2:0x0008 }] */
                /* JADX WARN: Removed duplicated region for block: B:15:0x00c9 A[Catch: all -> 0x00db, TRY_LEAVE, TryCatch #1 {all -> 0x00db, blocks: (B:3:0x0008, B:5:0x0013, B:6:0x0018, B:8:0x0026, B:10:0x0043, B:12:0x0085, B:15:0x00c9, B:17:0x002c, B:19:0x0032, B:20:0x0037, B:22:0x003d), top: B:2:0x0008 }] */
                @Override // com.mobile.auth.g.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a(int r13, org.json.JSONObject r14) {
                    /*
                        r12 = this;
                        java.lang.String r13 = "resultString"
                        java.lang.String r0 = "desc"
                        java.lang.String r1 = "resultDesc"
                        java.lang.String r2 = "token"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r3 = r2     // Catch: java.lang.Throwable -> Ldb
                        long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ldb
                        r3.setCarrierReturnTime(r4)     // Catch: java.lang.Throwable -> Ldb
                        if (r14 != 0) goto L18
                        org.json.JSONObject r14 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ldb
                        r14.<init>()     // Catch: java.lang.Throwable -> Ldb
                    L18:
                        java.lang.String r3 = "resultCode"
                        java.lang.String r6 = r14.optString(r3)     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r3 = ""
                        boolean r4 = r14.has(r1)     // Catch: java.lang.Throwable -> Ldb
                        if (r4 == 0) goto L2c
                        java.lang.String r13 = r14.optString(r1)     // Catch: java.lang.Throwable -> Ldb
                    L2a:
                        r7 = r13
                        goto L43
                    L2c:
                        boolean r1 = r14.has(r0)     // Catch: java.lang.Throwable -> Ldb
                        if (r1 == 0) goto L37
                        java.lang.String r13 = r14.optString(r0)     // Catch: java.lang.Throwable -> Ldb
                        goto L2a
                    L37:
                        boolean r0 = r14.has(r13)     // Catch: java.lang.Throwable -> Ldb
                        if (r0 == 0) goto L42
                        java.lang.String r13 = r14.optString(r13)     // Catch: java.lang.Throwable -> Ldb
                        goto L2a
                    L42:
                        r7 = r3
                    L43:
                        java.lang.String r13 = "traceId"
                        java.lang.String r13 = r14.optString(r13)     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r0 = r14.optString(r2)     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.gatewayauth.model.MonitorStruct r1 = r2     // Catch: java.lang.Throwable -> Ldb
                        r1.setCarrierTraceId(r13)     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.s.d r13 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.q.a r13 = com.mobile.auth.s.d.b(r13)     // Catch: java.lang.Throwable -> Ldb
                        r1 = 7
                        java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> Ldb
                        r3 = 0
                        java.lang.String r4 = "cmcc："
                        r1[r3] = r4     // Catch: java.lang.Throwable -> Ldb
                        r3 = 1
                        java.lang.String r4 = "getLoginToken:code="
                        r1[r3] = r4     // Catch: java.lang.Throwable -> Ldb
                        r3 = 2
                        r1[r3] = r6     // Catch: java.lang.Throwable -> Ldb
                        r3 = 3
                        java.lang.String r4 = ",msg="
                        r1[r3] = r4     // Catch: java.lang.Throwable -> Ldb
                        r3 = 4
                        r1[r3] = r7     // Catch: java.lang.Throwable -> Ldb
                        r3 = 5
                        java.lang.String r4 = ",json="
                        r1[r3] = r4     // Catch: java.lang.Throwable -> Ldb
                        r3 = 6
                        java.lang.String r4 = r14.toString()     // Catch: java.lang.Throwable -> Ldb
                        r1[r3] = r4     // Catch: java.lang.Throwable -> Ldb
                        r13.a(r1)     // Catch: java.lang.Throwable -> Ldb
                        boolean r13 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Ldb
                        if (r13 != 0) goto Lc9
                        com.mobile.auth.gatewayauth.model.MonitorStruct r13 = r2     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r0 = r14.optString(r2)     // Catch: java.lang.Throwable -> Ldb
                        r13.setAccessCode(r0)     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.s.d r13 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.s.a r13 = com.mobile.auth.s.d.c(r13)     // Catch: java.lang.Throwable -> Ldb
                        r13.a()     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.s.d r4 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r13 = ""
                        java.lang.String r7 = ""
                        r8 = 1
                        java.lang.String r9 = "cm_zyhl"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r10 = r2     // Catch: java.lang.Throwable -> Ldb
                        r5 = r6
                        r6 = r13
                        com.mobile.auth.s.d.b(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.gatewayauth.manager.RequestCallback r13 = r3     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.gatewayauth.manager.a$a$a r0 = com.mobile.auth.gatewayauth.manager.a.C0558a.a()     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r14 = r14.optString(r2)     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.gatewayauth.manager.a$a$a r14 = r0.b(r14)     // Catch: java.lang.Throwable -> Ldb
                        long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ldb
                        r2 = 120000(0x1d4c0, double:5.9288E-319)
                        long r0 = r0 + r2
                        com.mobile.auth.gatewayauth.manager.a$a$a r14 = r14.a(r0)     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.gatewayauth.manager.a$a r14 = r14.a()     // Catch: java.lang.Throwable -> Ldb
                        r13.onSuccess(r14)     // Catch: java.lang.Throwable -> Ldb
                        goto Le4
                    Lc9:
                        com.mobile.auth.s.d r4 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Ldb
                        com.mobile.auth.gatewayauth.manager.RequestCallback r5 = r3     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r8 = r14.toString()     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r9 = "cm_zyhl"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r10 = r2     // Catch: java.lang.Throwable -> Ldb
                        java.lang.String r11 = "600011"
                        com.mobile.auth.s.d.b(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Ldb
                        goto Le4
                    Ldb:
                        r13 = move-exception
                        com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r13)     // Catch: java.lang.Throwable -> Le0
                        goto Le4
                    Le0:
                        r13 = move-exception
                        com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r13)
                    Le4:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.s.d.AnonymousClass2.a(int, org.json.JSONObject):void");
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

    @Override // com.mobile.auth.gatewayauth.manager.a
    public synchronized void f(final RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, a.b bVar) {
        final MonitorStruct monitorStruct;
        try {
            monitorStruct = new MonitorStruct();
            monitorStruct.putApiParam("timeout", String.valueOf(this.f37248c));
            monitorStruct.setSessionId(bVar.c());
            monitorStruct.setRequestId(bVar.b());
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setAction(Constant.ACTION_CMCC_AUTH_TOKEN);
            monitorStruct.setNetworkType(com.mobile.auth.gatewayauth.utils.c.a(this.f37249d, true));
        } finally {
            return;
        }
        if (!TextUtils.isEmpty(this.f37246a) && !TextUtils.isEmpty(this.f37247b)) {
            this.f37623i.b(new com.mobile.auth.g.b() { // from class: com.mobile.auth.s.d.3
                /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:3:0x0006, B:5:0x0011, B:6:0x0016, B:8:0x0024, B:10:0x0041, B:12:0x0053, B:15:0x00a8, B:17:0x002a, B:19:0x0030, B:20:0x0035, B:22:0x003b), top: B:2:0x0006 }] */
                /* JADX WARN: Removed duplicated region for block: B:15:0x00a8 A[Catch: all -> 0x00ba, TRY_LEAVE, TryCatch #0 {all -> 0x00ba, blocks: (B:3:0x0006, B:5:0x0011, B:6:0x0016, B:8:0x0024, B:10:0x0041, B:12:0x0053, B:15:0x00a8, B:17:0x002a, B:19:0x0030, B:20:0x0035, B:22:0x003b), top: B:2:0x0006 }] */
                @Override // com.mobile.auth.g.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a(int r12, org.json.JSONObject r13) {
                    /*
                        r11 = this;
                        java.lang.String r12 = "resultString"
                        java.lang.String r0 = "desc"
                        java.lang.String r1 = "resultDesc"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r2 = r2     // Catch: java.lang.Throwable -> Lba
                        long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lba
                        r2.setCarrierReturnTime(r3)     // Catch: java.lang.Throwable -> Lba
                        if (r13 != 0) goto L16
                        org.json.JSONObject r13 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lba
                        r13.<init>()     // Catch: java.lang.Throwable -> Lba
                    L16:
                        java.lang.String r2 = "resultCode"
                        java.lang.String r5 = r13.optString(r2)     // Catch: java.lang.Throwable -> Lba
                        java.lang.String r2 = ""
                        boolean r3 = r13.has(r1)     // Catch: java.lang.Throwable -> Lba
                        if (r3 == 0) goto L2a
                        java.lang.String r12 = r13.optString(r1)     // Catch: java.lang.Throwable -> Lba
                    L28:
                        r6 = r12
                        goto L41
                    L2a:
                        boolean r1 = r13.has(r0)     // Catch: java.lang.Throwable -> Lba
                        if (r1 == 0) goto L35
                        java.lang.String r12 = r13.optString(r0)     // Catch: java.lang.Throwable -> Lba
                        goto L28
                    L35:
                        boolean r0 = r13.has(r12)     // Catch: java.lang.Throwable -> Lba
                        if (r0 == 0) goto L40
                        java.lang.String r12 = r13.optString(r12)     // Catch: java.lang.Throwable -> Lba
                        goto L28
                    L40:
                        r6 = r2
                    L41:
                        java.lang.String r12 = "traceId"
                        java.lang.String r12 = r13.optString(r12)     // Catch: java.lang.Throwable -> Lba
                        java.lang.String r0 = "token"
                        java.lang.String r0 = r13.optString(r0)     // Catch: java.lang.Throwable -> Lba
                        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lba
                        if (r1 != 0) goto La8
                        com.mobile.auth.s.d r1 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.q.a r1 = com.mobile.auth.s.d.d(r1)     // Catch: java.lang.Throwable -> Lba
                        r2 = 3
                        java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lba
                        r3 = 0
                        java.lang.String r4 = "cmcc："
                        r2[r3] = r4     // Catch: java.lang.Throwable -> Lba
                        r3 = 1
                        java.lang.String r4 = "getAccessCode:"
                        r2[r3] = r4     // Catch: java.lang.Throwable -> Lba
                        r3 = 2
                        java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> Lba
                        r2[r3] = r13     // Catch: java.lang.Throwable -> Lba
                        r1.a(r2)     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.gatewayauth.model.MonitorStruct r13 = r2     // Catch: java.lang.Throwable -> Lba
                        r13.setCarrierTraceId(r12)     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.gatewayauth.model.MonitorStruct r12 = r2     // Catch: java.lang.Throwable -> Lba
                        r12.setAccessCode(r0)     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.s.d r3 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Lba
                        java.lang.String r12 = ""
                        java.lang.String r6 = ""
                        r7 = 1
                        java.lang.String r8 = "cm_zyhl"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r9 = r2     // Catch: java.lang.Throwable -> Lba
                        r4 = r5
                        r5 = r12
                        com.mobile.auth.s.d.c(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.gatewayauth.manager.RequestCallback r12 = r3     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.gatewayauth.manager.a$a$a r13 = com.mobile.auth.gatewayauth.manager.a.C0558a.a()     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.gatewayauth.manager.a$a$a r13 = r13.b(r0)     // Catch: java.lang.Throwable -> Lba
                        long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lba
                        r2 = 120000(0x1d4c0, double:5.9288E-319)
                        long r0 = r0 + r2
                        com.mobile.auth.gatewayauth.manager.a$a$a r13 = r13.a(r0)     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.gatewayauth.manager.a$a r13 = r13.a()     // Catch: java.lang.Throwable -> Lba
                        r12.onSuccess(r13)     // Catch: java.lang.Throwable -> Lba
                        goto Lc3
                    La8:
                        com.mobile.auth.s.d r3 = com.mobile.auth.s.d.this     // Catch: java.lang.Throwable -> Lba
                        com.mobile.auth.gatewayauth.manager.RequestCallback r4 = r3     // Catch: java.lang.Throwable -> Lba
                        java.lang.String r7 = r13.toString()     // Catch: java.lang.Throwable -> Lba
                        java.lang.String r8 = "cm_zyhl"
                        com.mobile.auth.gatewayauth.model.MonitorStruct r9 = r2     // Catch: java.lang.Throwable -> Lba
                        java.lang.String r10 = "600011"
                        com.mobile.auth.s.d.c(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lba
                        goto Lc3
                    Lba:
                        r12 = move-exception
                        com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r12)     // Catch: java.lang.Throwable -> Lbf
                        goto Lc3
                    Lbf:
                        r12 = move-exception
                        com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r12)
                    Lc3:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.s.d.AnonymousClass3.a(int, org.json.JSONObject):void");
                }
            });
            return;
        }
        a(requestCallback, ResultCode.CODE_ERROR_ANALYZE_SDK_INFO, ResultCode.MSG_ERROR_ANALYZE_SDK_INFO, "", Constant.VENDOR_CMCC, monitorStruct, ResultCode.CODE_GET_TOKEN_FAIL);
    }
}
