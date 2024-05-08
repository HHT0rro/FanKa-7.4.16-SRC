package p001.p002.p003.p004.p005.p017;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.ё.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0860 implements IOpenSDKComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f637;

    public C0860(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    private long m3911(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(bArr, 0, bArr.length);
        allocate.flip();
        return allocate.getLong();
    }

    /* renamed from: а, reason: contains not printable characters */
    private byte[] m3912(String str, String str2, String str3, byte[] bArr, String str4) {
        return (byte[]) this.f637.getRouter().doCommand(11601, str, str2, str3, bArr, str4);
    }

    @Override // com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent
    public Long analyzeOpenId(String str, String str2, String str3, byte[] bArr, String str4) throws SecException {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str2.length() == 0 || bArr == null || bArr.length == 0) {
            throw new SecException(1101);
        }
        byte[] m3912 = m3912(str, str2, str3, bArr, str4);
        if (m3912 == null || m3912.length > 8 || m3912.length <= 0) {
            return null;
        }
        return Long.valueOf(m3911(m3912));
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f637 = iSecurityGuardPlugin;
        return 0;
    }
}
