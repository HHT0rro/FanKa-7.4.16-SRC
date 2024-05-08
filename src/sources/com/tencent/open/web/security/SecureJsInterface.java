package com.tencent.open.web.security;

import com.tencent.open.a;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SecureJsInterface extends a.b {
    public static boolean isPWDEdit;

    /* renamed from: a, reason: collision with root package name */
    private String f45332a;

    public void clearAllEdit() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void curPosFromJS(String str) {
        int i10;
        SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i10 = Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e2);
            i10 = -1;
        }
        if (i10 >= 0) {
            boolean z10 = a.f45335c;
            boolean z11 = a.f45334b;
            if (z11) {
                if (Boolean.valueOf(JniInterface.BackSpaceChar(z11, i10)).booleanValue()) {
                    a.f45334b = false;
                    return;
                }
                return;
            }
            String str2 = a.f45333a;
            this.f45332a = str2;
            JniInterface.insetTextToArray(i10, str2, str2.length());
            SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f45332a);
            return;
        }
        throw new RuntimeException("position is illegal.");
    }

    @Override // com.tencent.open.a.b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void isPasswordEdit(String str) {
        int i10;
        SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i10 = Integer.parseInt(str);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e2.getMessage());
            i10 = -1;
        }
        if (i10 != 0 && i10 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i10 == 0) {
            isPWDEdit = false;
        } else if (i10 == 1) {
            isPWDEdit = true;
        }
    }
}
