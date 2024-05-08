package p001.p002.p003.p004.p005.p012;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import java.io.UnsupportedEncodingException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.ж.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0855 implements ISafeTokenComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f632;

    public C0855(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    private Object m3899(int i10, String str, byte[] bArr, String str2, int i11) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1601);
        }
        if (i10 > 0 && i10 < 4) {
            return (Boolean) this.f632.getRouter().doCommand(12101, Integer.valueOf(i10), str, bArr, str2, Integer.valueOf(i11));
        }
        if (i10 <= 3 || i10 > 6) {
            return null;
        }
        byte[] bArr2 = (byte[]) this.f632.getRouter().doCommand(12101, Integer.valueOf(i10), str, bArr, str2, Integer.valueOf(i11));
        return i10 == 6 ? new String(bArr2) : bArr2;
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public byte[] decryptWithToken(String str, byte[] bArr, int i10) throws SecException {
        return (byte[]) m3899(5, str, bArr, null, i10);
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public byte[] encryptWithToken(String str, byte[] bArr, int i10) throws SecException {
        return (byte[]) m3899(4, str, bArr, null, i10);
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public byte[] getOtp(String str, int i10, String[] strArr, byte[][] bArr) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1601);
        }
        return (byte[]) this.f632.getRouter().doCommand(12102, str, Integer.valueOf(i10), strArr, bArr, "");
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public byte[] getOtp(String str, int i10, String[] strArr, byte[][] bArr, String str2) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1601);
        }
        return (byte[]) this.f632.getRouter().doCommand(12102, str, Integer.valueOf(i10), strArr, bArr, str2);
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f632 = iSecurityGuardPlugin;
        return 0;
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public boolean isTokenExisted(String str) throws SecException {
        return ((Boolean) m3899(2, str, null, null, 0)).booleanValue();
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public void removeToken(String str) throws SecException {
        m3899(3, str, null, null, 0);
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public boolean saveToken(String str, String str2, String str3, int i10) throws SecException {
        if (str2 == null || str2.length() <= 0) {
            throw new SecException("", 1601);
        }
        try {
            return ((Boolean) m3899(1, str, str2.getBytes("UTF-8"), str3, i10)).booleanValue();
        } catch (UnsupportedEncodingException unused) {
            throw new SecException("", 1601);
        }
    }

    @Override // com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent
    public String signWithToken(String str, byte[] bArr, int i10) throws SecException {
        return (String) m3899(6, str, bArr, null, i10);
    }
}
