package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecurityInit {
    public static int Initialize(Context context) throws JAQException {
        try {
            return SecurityGuardManager.getInitializer().initialize(context);
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public static boolean setGlobalUserData(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.setGlobalUserData(str, str2);
        } catch (SecException e2) {
            throw new JAQException(e2.getErrorCode());
        }
    }
}
