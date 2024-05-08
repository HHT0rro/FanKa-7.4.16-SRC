package p001.p002.p003.p004.p005.p009;

import com.alibaba.wireless.security.mainplugin.C0074;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import p001.p002.p003.p004.p005.p007.C0848;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.г.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0850 implements IDynamicDataEncryptComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f624 = null;

    public C0850(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    private String m3872(int i10, String str, boolean z10) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("Input data string is empty", 401);
        }
        byte[] bArr = (byte[]) this.f624.getRouter().doCommand(10501, Integer.valueOf(i10), Boolean.valueOf(z10), str);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    return new String(bArr, "UTF-8");
                }
            } catch (Exception unused) {
                throw new SecException("dynamic crypt return with invalid string data", 499);
            }
        }
        throw new SecException("dynamic crypt return with null data", 499);
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3873(int i10, byte[] bArr, boolean z10) throws SecException {
        if (bArr == null || bArr.length <= 0) {
            throw new SecException("Input byte data is empty", 401);
        }
        return (byte[]) this.f624.getRouter().doCommand(10501, Integer.valueOf(i10), Boolean.valueOf(z10), C0848.m3870(bArr));
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public String dynamicDecrypt(String str) throws SecException {
        return m3872(2, str, false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public byte[] dynamicDecryptByteArray(byte[] bArr) throws SecException {
        if (bArr == null || bArr.length <= 0) {
            throw new SecException(401);
        }
        return C0848.m3871(m3872(2, new String(bArr), false));
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public byte[] dynamicDecryptByteArrayDDp(byte[] bArr) throws SecException {
        if (bArr == null || bArr.length <= 0) {
            throw new SecException(401);
        }
        return C0848.m3871(m3872(4, new String(bArr), true));
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public String dynamicDecryptDDp(String str) throws SecException {
        C0074.m1923("dynamicDecryptDDp");
        String m3872 = m3872(4, str, true);
        C0074.m1922("dynamicDecryptDDp");
        return m3872;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public String dynamicEncrypt(String str) throws SecException {
        return m3872(1, str, false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public byte[] dynamicEncryptByteArray(byte[] bArr) throws SecException {
        return m3873(1, bArr, false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public byte[] dynamicEncryptByteArrayDDp(byte[] bArr) throws SecException {
        return m3873(3, bArr, true);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public String dynamicEncryptDDp(String str) throws SecException {
        C0074.m1923("dynamicEncryptDDp");
        String m3872 = m3872(3, str, true);
        C0074.m1922("dynamicEncryptDDp");
        return m3872;
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f624 = iSecurityGuardPlugin;
        return 0;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent
    public boolean isVerifyCrypt(String str) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException(401);
        }
        return str.length() > 9 && str.charAt(8) == '@';
    }
}
