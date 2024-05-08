package p001.p002.p003.p004.p005.p010;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.huawei.hms.ads.ContentClassification;
import java.io.UnsupportedEncodingException;
import p001.p002.p003.p004.p005.p007.C0848;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.д.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0851 implements IDynamicDataStoreComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f625;

    public C0851(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    private int m3874(String str, String str2, String str3, boolean z10) throws SecException {
        return ((Integer) this.f625.getRouter().doCommand(10502, 5, str3, Boolean.valueOf(z10), str, str2)).intValue();
    }

    /* renamed from: а, reason: contains not printable characters */
    private Object m3875(int i10, String str, byte[] bArr, int i11) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 501);
        }
        if (i10 == 8 || i10 == 9 || i10 == 13 || i10 == 12) {
            return (Boolean) this.f625.getRouter().doCommand(10503, Integer.valueOf(i10), str, bArr, Integer.valueOf(i11));
        }
        if (i10 != 10 && i10 != 11) {
            return null;
        }
        byte[] bArr2 = (byte[]) this.f625.getRouter().doCommand(10503, Integer.valueOf(i10), str, bArr, Integer.valueOf(i11));
        return i10 == 10 ? new String(bArr2) : bArr2;
    }

    /* renamed from: а, reason: contains not printable characters */
    private String m3876(String str, String str2, boolean z10) throws SecException {
        byte[] bArr = (byte[]) this.f625.getRouter().doCommand(10502, 6, str2, Boolean.valueOf(z10), str, null);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    return new String(bArr, "UTF-8");
                }
            } catch (Exception unused) {
                throw new SecException("return invalid String result", 499);
            }
        }
        throw new SecException("return null byteResult", 499);
    }

    /* renamed from: б, reason: contains not printable characters */
    private void m3877(String str, String str2, boolean z10) throws SecException {
        this.f625.getRouter().doCommand(10502, 7, str2, Boolean.valueOf(z10), str, null);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public boolean getBoolean(String str) throws SecException {
        String m3876 = m3876(str, "Z", false);
        if (m3876 == null) {
            return false;
        }
        try {
            return "1".equals(m3876);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public byte[] getByteArray(String str) throws SecException {
        String m3876 = m3876(str, "[B", false);
        if (m3876 != null) {
            try {
                return C0848.m3871(m3876);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public byte[] getByteArrayDDp(String str) throws SecException {
        String m3876 = m3876(str, "[B", true);
        if (m3876 != null) {
            try {
                return C0848.m3871(m3876);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public byte[] getByteArrayDDpEx(String str, int i10) throws SecException {
        return (byte[]) m3875(11, str, (byte[]) null, i10);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public float getFloat(String str) throws SecException {
        String m3876 = m3876(str, "F", false);
        if (m3876 != null) {
            try {
                return Float.parseFloat(m3876);
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int getInt(String str) throws SecException {
        String m3876 = m3876(str, "I", false);
        if (m3876 != null) {
            try {
                return Integer.parseInt(m3876);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public long getLong(String str) throws SecException {
        String m3876 = m3876(str, ContentClassification.AD_CONTENT_CLASSIFICATION_J, false);
        if (m3876 != null) {
            try {
                return Long.parseLong(m3876);
            } catch (Throwable unused) {
            }
        }
        return -1L;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public String getString(String str) throws SecException {
        return m3876(str, "LString", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public String getStringDDp(String str) throws SecException {
        return m3876(str, "LString", true);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public String getStringDDpEx(String str, int i10) throws SecException {
        return (String) m3875(10, str, (byte[]) null, i10);
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f625 = iSecurityGuardPlugin;
        return 0;
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putBoolean(String str, boolean z10) throws SecException {
        return m3874(str, z10 ? "1" : "0", "Z", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putByteArray(String str, byte[] bArr) throws SecException {
        return m3874(str, C0848.m3870(bArr), "[B", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putByteArrayDDp(String str, byte[] bArr) throws SecException {
        return m3874(str, C0848.m3870(bArr), "[B", true);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public boolean putByteArrayDDpEx(String str, byte[] bArr, int i10) throws SecException {
        return ((Boolean) m3875(9, str, bArr, i10)).booleanValue();
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putFloat(String str, float f10) throws SecException {
        return m3874(str, Float.toString(f10), "F", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putInt(String str, int i10) throws SecException {
        return m3874(str, Integer.toString(i10), "I", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putLong(String str, long j10) throws SecException {
        return m3874(str, Long.toString(j10), ContentClassification.AD_CONTENT_CLASSIFICATION_J, false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putString(String str, String str2) throws SecException {
        return m3874(str, str2, "LString", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public int putStringDDp(String str, String str2) throws SecException {
        return m3874(str, str2, "LString", true);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public boolean putStringDDpEx(String str, String str2, int i10) throws SecException {
        if (str2 == null || str2.length() <= 0) {
            throw new SecException("", 501);
        }
        try {
            return ((Boolean) m3875(8, str, str2.getBytes("UTF-8"), i10)).booleanValue();
        } catch (UnsupportedEncodingException unused) {
            throw new SecException("", 501);
        }
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeBoolean(String str) throws SecException {
        m3877(str, "Z", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeByteArray(String str) throws SecException {
        m3877(str, "[B", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeByteArrayDDp(String str) throws SecException {
        m3877(str, "[B", true);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeByteArrayDDpEx(String str, int i10) throws SecException {
        m3875(13, str, (byte[]) null, i10);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeFloat(String str) throws SecException {
        m3877(str, "F", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeInt(String str) throws SecException {
        m3877(str, "I", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeLong(String str) throws SecException {
        m3877(str, ContentClassification.AD_CONTENT_CLASSIFICATION_J, false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeString(String str) throws SecException {
        m3877(str, "LString", false);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeStringDDp(String str) throws SecException {
        m3877(str, "LString", true);
    }

    @Override // com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent
    public void removeStringDDpEx(String str, int i10) throws SecException {
        m3875(12, str, (byte[]) null, i10);
    }
}
