package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecurityStorage {

    /* renamed from: а, reason: contains not printable characters */
    private Context f150;

    public SecurityStorage(Context context) {
        if (context != null) {
            this.f150 = context.getApplicationContext();
        }
    }

    public String getString(String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f150).getDynamicDataStoreComp().getString(str);
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public int putString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f150).getDynamicDataStoreComp().putString(str, str2);
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public void removeString(String str) throws JAQException {
        try {
            SecurityGuardManager.getInstance(this.f150).getDynamicDataStoreComp().removeString(str);
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }
}
