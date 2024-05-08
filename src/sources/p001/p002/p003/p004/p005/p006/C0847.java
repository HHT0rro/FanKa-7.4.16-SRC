package p001.p002.p003.p004.p005.p006;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.io.UnsupportedEncodingException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.а.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0847 implements IAtlasEncryptComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f621;

    public C0847(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3869(String str, String str2, String str3) {
        return (byte[]) this.f621.getRouter().doCommand(11901, str, str2, str3);
    }

    @Override // com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent
    public String atlasSafeEncrypt(String str, String str2) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1001);
        }
        byte[] m3869 = m3869("a", str, str2);
        if (m3869 == null) {
            return null;
        }
        try {
            return new String(m3869, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f621 = iSecurityGuardPlugin;
        return 0;
    }
}
