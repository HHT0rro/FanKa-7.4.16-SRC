package com.mobile.auth.gatewayauth.detectnet;

import android.content.Context;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.utils.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {
    public static void a(String str, String str2, String str3, final Context context, String str4, final String str5) {
        try {
            i.a("pingNet：" + str2 + "checkTimeoutDetect  transferCode：" + str);
            if (com.mobile.auth.q.a.a(context).a() && ResultCode.CODE_ERROR_FUNCTION_TIME_OUT.equals(str)) {
                e.a().a(str4).a(context, str2, str3, new a() { // from class: com.mobile.auth.gatewayauth.detectnet.f.1
                    @Override // com.mobile.auth.gatewayauth.detectnet.a
                    public void a(DetectResult detectResult) {
                        try {
                            detectResult.setVendorKey(String.this);
                            com.mobile.auth.q.a.a(context).d(detectResult.toJson());
                            i.a("pingNet：upload：" + detectResult.toJson());
                        } catch (Throwable th) {
                            try {
                                ExceptionProcessor.processException(th);
                            } catch (Throwable th2) {
                                ExceptionProcessor.processException(th2);
                            }
                        }
                    }
                });
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
