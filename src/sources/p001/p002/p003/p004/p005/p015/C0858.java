package p001.p002.p003.p004.p005.p015;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.й.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0858 implements IStaticDataStoreComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f635 = null;

    public C0858(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    @Override // com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent
    public String getAppKeyByIndex(int i10, String str) throws SecException {
        return (String) this.f635.getRouter().doCommand(10602, Integer.valueOf(i10), str);
    }

    @Override // com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent
    public String getExtraData(String str, String str2) throws SecException {
        return (String) this.f635.getRouter().doCommand(10603, str, str2);
    }

    @Override // com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent
    public int getKeyType(String str, String str2) throws SecException {
        return ((Integer) this.f635.getRouter().doCommand(10604, str, str2)).intValue();
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f635 = iSecurityGuardPlugin;
        return 0;
    }
}
