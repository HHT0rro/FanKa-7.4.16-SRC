package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecurityCipher {

    /* renamed from: а, reason: contains not printable characters */
    private Context f148;

    public SecurityCipher(Context context) {
        if (context != null) {
            this.f148 = context.getApplicationContext();
        }
    }

    public String atlasEncryptString(String str) throws JAQException {
        try {
            IAtlasEncryptComponent atlasEncryptComp = SecurityGuardManager.getInstance(this.f148).getAtlasEncryptComp();
            if (atlasEncryptComp != null) {
                return atlasEncryptComp.atlasSafeEncrypt(str, "0335");
            }
            throw new SecException(1098);
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public byte[] decryptBinary(byte[] bArr, String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f148).getStaticDataEncryptComp().staticBinarySafeDecrypt(16, str, bArr, "0335");
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public String decryptString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f148).getStaticDataEncryptComp().staticSafeDecrypt(16, str2, str, "0335");
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public byte[] encryptBinary(byte[] bArr, String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f148).getStaticDataEncryptComp().staticBinarySafeEncrypt(16, str, bArr, "0335");
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public String encryptString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f148).getStaticDataEncryptComp().staticSafeEncrypt(16, str2, str, "0335");
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }
}
