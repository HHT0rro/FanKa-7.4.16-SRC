package p001.p002.p003.p004.p005.p011;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.litevm.LiteVMParameterWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.е.б, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
class C0854 {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f629;

    /* renamed from: б, reason: contains not printable characters */
    private volatile long f630;

    /* renamed from: в, reason: contains not printable characters */
    private AtomicBoolean f631 = new AtomicBoolean(false);

    private C0854(ISecurityGuardPlugin iSecurityGuardPlugin, long j10, String str, String str2) {
        this.f630 = j10;
        this.f629 = iSecurityGuardPlugin;
        this.f631.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: а, reason: contains not printable characters */
    public static C0854 m3892(ISecurityGuardPlugin iSecurityGuardPlugin, String str, String str2, byte[] bArr, long j10) {
        return new C0854(iSecurityGuardPlugin, ((Long) iSecurityGuardPlugin.getRouter().doCommand(12501, str, str2, bArr, Long.valueOf(j10))).longValue(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: а, reason: contains not printable characters */
    public static C0854 m3893(ISecurityGuardPlugin iSecurityGuardPlugin, String str, String str2, byte[] bArr, Object[] objArr) {
        return new C0854(iSecurityGuardPlugin, ((Long) iSecurityGuardPlugin.getRouter().doCommand(12501, str, str2, bArr, 0L)).longValue(), str, str2);
    }

    /* renamed from: в, reason: contains not printable characters */
    private Long m3894() {
        return Long.valueOf(this.f630);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: а, reason: contains not printable characters */
    public Object m3895(int i10, LiteVMParameterWrapper[] liteVMParameterWrapperArr, int i11, int i12) throws SecException {
        if (!m3898()) {
            throw new SecException("LVM instance not valid", 2101);
        }
        return this.f629.getRouter().doCommand(i12, Long.valueOf(m3894().longValue()), Integer.valueOf(liteVMParameterWrapperArr != null ? liteVMParameterWrapperArr.length : 0), liteVMParameterWrapperArr, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: а, reason: contains not printable characters */
    public void m3896() throws SecException {
        if (!m3898()) {
            throw new SecException("LVM instance not valid", 2101);
        }
        this.f631.set(false);
        this.f629.getRouter().doCommand(12503, Long.valueOf(m3894().longValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: а, reason: contains not printable characters */
    public void m3897(byte[] bArr) throws SecException {
        if (!m3898()) {
            throw new SecException("LVM instance not valid", 2101);
        }
        this.f629.getRouter().doCommand(12502, Long.valueOf(m3894().longValue()), bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: б, reason: contains not printable characters */
    public boolean m3898() {
        return this.f631.get();
    }
}
