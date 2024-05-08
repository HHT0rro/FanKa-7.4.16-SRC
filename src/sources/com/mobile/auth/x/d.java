package com.mobile.auth.x;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.logger.model.ACMMonitorRecord;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends a<ACMMonitorRecord> {
    @Override // com.mobile.auth.x.a
    public boolean a(String str) {
        try {
            com.mobile.auth.gatewayauth.b bVar = this.f37669a;
            if (bVar != null) {
                return bVar.b(str);
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
}
