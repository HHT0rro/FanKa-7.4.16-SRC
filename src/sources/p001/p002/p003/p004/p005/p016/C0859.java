package p001.p002.p003.p004.p005.p016;

import android.util.Base64;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import com.taobao.wireless.security.adapter.common.SPUtility2;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.к.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0859 implements IStaticKeyEncryptComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f636 = null;

    public C0859(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    private int m3903(String str, byte[] bArr) throws SecException {
        if (str == null || str.length() <= 0 || bArr == null || bArr.length <= 0) {
            throw new SecException(701);
        }
        byte[] m3908 = m3908(704, str.getBytes(), bArr);
        if (m3908 != null && m3908.length > 0) {
            String readFromSPUnified = SPUtility2.readFromSPUnified("StaticKey", str, null);
            if (SPUtility2.saveToSPUnified("StaticKey", str, new String(m3908), true)) {
                return (readFromSPUnified == null || readFromSPUnified.length() <= 0) ? 1 : 2;
            }
        }
        return 0;
    }

    /* renamed from: а, reason: contains not printable characters */
    private boolean m3904(String str) {
        String readFromSPUnified = SPUtility2.readFromSPUnified("StaticKey", str, null);
        return readFromSPUnified != null && readFromSPUnified.length() > 0;
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3905(int i10, int i11, byte[] bArr, byte[] bArr2) {
        return (byte[]) this.f636.getRouter().doCommand(10605, Integer.valueOf(i10), Integer.valueOf(i11), bArr, bArr2);
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3906(int i10, String str, String str2) throws SecException {
        String readFromSPUnified = SPUtility2.readFromSPUnified("StaticKey", str, null);
        String readFromSPUnified2 = SPUtility2.readFromSPUnified("StaticKey", str2, null);
        if (readFromSPUnified == null || readFromSPUnified.length() == 0) {
            throw new SecException(703);
        }
        if (readFromSPUnified2 == null || readFromSPUnified2.length() == 0) {
            throw new SecException(703);
        }
        byte[] m3905 = m3905(703, i10, readFromSPUnified.getBytes(), readFromSPUnified2.getBytes());
        if (m3905 == null || m3905.length <= 0) {
            return m3905;
        }
        try {
            return Base64.decode(m3905, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3907(int i10, String str, byte[] bArr) throws SecException {
        String readFromSPUnified = SPUtility2.readFromSPUnified("StaticKey", str, null);
        if (readFromSPUnified == null || readFromSPUnified.length() <= 0) {
            throw new SecException(703);
        }
        return m3905(702, i10, readFromSPUnified.getBytes(), Base64.encode(bArr, 2));
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3908(int i10, byte[] bArr, byte[] bArr2) {
        return (byte[]) this.f636.getRouter().doCommand(10605, Integer.valueOf(i10), bArr, bArr2);
    }

    /* renamed from: б, reason: contains not printable characters */
    private int m3909(String str) {
        if (SPUtility2.readFromSPUnified("StaticKey", str, null) == null) {
            return 2;
        }
        return SPUtility2.removeFromSPUnified("StaticKey", str, true) ? 1 : 0;
    }

    /* renamed from: б, reason: contains not printable characters */
    private byte[] m3910(int i10, String str, byte[] bArr) throws SecException {
        String readFromSPUnified = SPUtility2.readFromSPUnified("StaticKey", str, null);
        if (readFromSPUnified == null || readFromSPUnified.length() <= 0) {
            throw new SecException(703);
        }
        byte[] m3905 = m3905(701, i10, readFromSPUnified.getBytes(), bArr);
        return (m3905 == null || m3905.length <= 0) ? m3905 : Base64.decode(m3905, 0);
    }

    @Override // com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent
    public byte[] decrypt(int i10, String str, byte[] bArr) throws SecException {
        if (str == null || str.length() <= 0 || bArr == null || bArr.length <= 0 || i10 < 16 || i10 > 18) {
            throw new SecException(701);
        }
        return m3907(i10, str, bArr);
    }

    @Override // com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent
    public byte[] encrypt(int i10, String str, byte[] bArr) throws SecException {
        if (str == null || str.length() <= 0 || bArr == null || bArr.length <= 0 || i10 < 16 || i10 > 18) {
            throw new SecException(701);
        }
        return m3910(i10, str, bArr);
    }

    @Override // com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent
    public byte[] encryptSecretData(int i10, String str, String str2) throws SecException {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || i10 < 16 || i10 > 18) {
            throw new SecException(701);
        }
        return m3906(i10, str, str2);
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f636 = iSecurityGuardPlugin;
        return 0;
    }

    @Override // com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent
    public boolean isSecretExist(String str) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException(701);
        }
        return m3904(str);
    }

    @Override // com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent
    public int removeSecret(String str) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException(701);
        }
        return m3909(str);
    }

    @Override // com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent
    public int saveSecret(String str, byte[] bArr) throws SecException {
        if (str == null || str.length() <= 0 || bArr == null || bArr.length <= 0) {
            throw new SecException(701);
        }
        return m3903(str, bArr);
    }
}
