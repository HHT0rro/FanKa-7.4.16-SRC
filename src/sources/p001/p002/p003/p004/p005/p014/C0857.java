package p001.p002.p003.p004.p005.p014;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import java.io.UnsupportedEncodingException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.и.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0857 implements IStaticDataEncryptComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f634 = null;

    public C0857(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3900(int i10, int i11, int i12, String str, byte[] bArr, String str2) {
        return (byte[]) this.f634.getRouter().doCommand(10601, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), str, bArr, str2);
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3901(int i10, String str, byte[] bArr, String str2) {
        return m3900(2, i10, 0, str, bArr, str2);
    }

    /* renamed from: б, reason: contains not printable characters */
    private byte[] m3902(int i10, String str, byte[] bArr, String str2) {
        return m3900(1, i10, 0, str, bArr, str2);
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f634 = iSecurityGuardPlugin;
        return 0;
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public byte[] staticBinarySafeDecrypt(int i10, String str, byte[] bArr, String str2) throws SecException {
        if (str == null || str.length() <= 0 || i10 < 3 || i10 >= 19 || bArr == null || bArr.length <= 0) {
            throw new SecException("", 301);
        }
        return m3900(2, i10, 1, str, bArr, str2);
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public byte[] staticBinarySafeDecryptNoB64(int i10, String str, byte[] bArr, String str2) throws SecException {
        if (str == null || str.length() <= 0 || i10 < 3 || i10 >= 19 || bArr == null || bArr.length <= 0) {
            throw new SecException("", 301);
        }
        return m3901(i10, str, bArr, str2);
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public byte[] staticBinarySafeEncrypt(int i10, String str, byte[] bArr, String str2) throws SecException {
        if (str == null || str.length() <= 0 || i10 < 3 || i10 >= 19 || bArr == null || bArr.length <= 0) {
            throw new SecException("", 301);
        }
        return m3900(1, i10, 1, str, bArr, str2);
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public byte[] staticBinarySafeEncryptNoB64(int i10, String str, byte[] bArr, String str2) throws SecException {
        if (str == null || str.length() <= 0 || i10 < 3 || i10 >= 19 || bArr == null || bArr.length <= 0) {
            throw new SecException("", 301);
        }
        return m3902(i10, str, bArr, str2);
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public String staticSafeDecrypt(int i10, String str, String str2, String str3) throws SecException {
        if (str == null || str.length() <= 0 || i10 < 3 || i10 >= 19 || str2 == null || str2.length() <= 0) {
            throw new SecException("", 301);
        }
        byte[] m3900 = m3900(2, i10, 1, str, str2.getBytes(), str3);
        if (m3900 == null) {
            return null;
        }
        try {
            return new String(m3900, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent
    public String staticSafeEncrypt(int i10, String str, String str2, String str3) throws SecException {
        if (str == null || str.length() <= 0 || i10 < 3 || i10 >= 19 || str2 == null || str2.length() <= 0) {
            throw new SecException("", 301);
        }
        byte[] m3900 = m3900(1, i10, 1, str, str2.getBytes(), str3);
        if (m3900 == null) {
            return null;
        }
        try {
            return new String(m3900, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
