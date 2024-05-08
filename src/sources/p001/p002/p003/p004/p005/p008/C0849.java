package p001.p002.p003.p004.p005.p008;

import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.taobao.wireless.security.adapter.datacollection.C0599;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.в.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0849 implements IDataCollectionComponent {

    /* renamed from: а, reason: contains not printable characters */
    private C0599 f623;

    public C0849(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    @Override // com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent
    public String getNick() {
        return this.f623.m2894();
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f623 = C0599.m2892(iSecurityGuardPlugin);
        return 0;
    }

    @Override // com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent
    public boolean setNick(String str) {
        return this.f623.m2896(str);
    }
}
