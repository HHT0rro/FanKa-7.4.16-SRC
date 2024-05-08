package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.jaq.securitybody.IJAQVerificationComponent;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecurityVerification {
    private Context context;

    public SecurityVerification(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
    }

    public String doJAQVerfificationSync(HashMap<String, String> hashMap, int i10) throws JAQException {
        try {
            return ((IJAQVerificationComponent) SecurityGuardManager.getInstance(this.context).getInterface(IJAQVerificationComponent.class)).doJAQVerfificationSync(hashMap, i10);
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }
}
