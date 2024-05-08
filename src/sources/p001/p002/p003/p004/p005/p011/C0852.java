package p001.p002.p003.p004.p005.p011;

import com.alibaba.wireless.security.mainplugin.C0076;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.litevm.LiteVMInstance;
import com.alibaba.wireless.security.open.litevm.LiteVMParamType;
import com.alibaba.wireless.security.open.litevm.LiteVMParameterWrapper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.е.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0852 {

    /* renamed from: а, reason: contains not printable characters */
    private static ISecurityGuardPlugin f626;

    /* renamed from: б, reason: contains not printable characters */
    private static volatile Object f627;

    /* renamed from: в, reason: contains not printable characters */
    private static C0852 f628;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: а.а.а.а.а.е.а$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    public static class C0853 implements InvocationHandler {
        C0853() {
        }

        /* renamed from: а, reason: contains not printable characters */
        private boolean m3891(Object obj, Object obj2) {
            if (obj2 != null && obj2.getClass() == obj.getClass()) {
                try {
                    return equals(Proxy.getInvocationHandler(obj2));
                } catch (Exception unused) {
                }
            }
            return false;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            char c4;
            String name = method.getName();
            switch (name.hashCode()) {
                case -1776922004:
                    if (name.equals("toString")) {
                        c4 = '\b';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1566653364:
                    if (name.equals("callLiteVMByteMethod")) {
                        c4 = 6;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1376216685:
                    if (name.equals("reloadLiteVMInstance")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1295482945:
                    if (name.equals("equals")) {
                        c4 = '\t';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -611610698:
                    if (name.equals("createLiteVMInstance")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -514295244:
                    if (name.equals("destroyLiteVMInstance")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -320658273:
                    if (name.equals("createLiteVMInstanceWithSymbols")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 66098133:
                    if (name.equals("callLiteVMStringMethod")) {
                        c4 = 5;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 147696667:
                    if (name.equals(TTDownloadField.TT_HASHCODE)) {
                        c4 = '\n';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1109138392:
                    if (name.equals("callLiteVMVoidMethod")) {
                        c4 = 7;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1565934272:
                    if (name.equals("callLiteVMLongMethod")) {
                        c4 = 4;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                    return C0852.f628.m3879((String) objArr[0], (String) objArr[1], (byte[]) objArr[2], (Object[]) objArr[3]);
                case 1:
                    return C0852.f628.m3878((String) objArr[0], (String) objArr[1], (byte[]) objArr[2], ((Long) objArr[3]).longValue());
                case 2:
                    C0852.f628.m3887((LiteVMInstance) objArr[0], (byte[]) objArr[1]);
                    return null;
                case 3:
                    C0852.f628.m3886((LiteVMInstance) objArr[0]);
                    return null;
                case 4:
                    return C0852.f628.m3882((LiteVMInstance) objArr[0], ((Integer) objArr[1]).intValue(), (LiteVMParameterWrapper[]) objArr[2], 1);
                case 5:
                    return C0852.f628.m3882((LiteVMInstance) objArr[0], ((Integer) objArr[1]).intValue(), (LiteVMParameterWrapper[]) objArr[2], 2);
                case 6:
                    return C0852.f628.m3882((LiteVMInstance) objArr[0], ((Integer) objArr[1]).intValue(), (LiteVMParameterWrapper[]) objArr[2], 3);
                case 7:
                    C0852.f628.m3882((LiteVMInstance) objArr[0], ((Integer) objArr[1]).intValue(), (LiteVMParameterWrapper[]) objArr[2], 0);
                    return null;
                case '\b':
                    return obj.getClass().getName() + "&ID=" + hashCode();
                case '\t':
                    return Boolean.valueOf(m3891(obj, objArr[0]));
                case '\n':
                    return Integer.valueOf(hashCode());
                default:
                    return null;
            }
        }
    }

    private C0852(ISecurityGuardPlugin iSecurityGuardPlugin) throws ClassNotFoundException {
        f626 = iSecurityGuardPlugin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public LiteVMInstance m3878(String str, String str2, byte[] bArr, long j10) throws SecException {
        return new LiteVMInstance(C0854.m3892(f626, str, str2, bArr, j10), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public LiteVMInstance m3879(String str, String str2, byte[] bArr, Object[] objArr) throws SecException {
        return new LiteVMInstance(C0854.m3893(f626, str, str2, bArr, (Object[]) null), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public Object m3882(LiteVMInstance liteVMInstance, int i10, LiteVMParameterWrapper[] liteVMParameterWrapperArr, int i11) throws SecException {
        if (liteVMInstance == null || !m3890(liteVMInstance)) {
            throw new SecException("LVM instance not valid", 2101);
        }
        LiteVMParameterWrapper[] liteVMParameterWrapperArr2 = null;
        if (liteVMParameterWrapperArr != null) {
            liteVMParameterWrapperArr2 = (LiteVMParameterWrapper[]) liteVMParameterWrapperArr.clone();
            int length = liteVMParameterWrapperArr2.length;
            for (int i12 = 0; i12 < length; i12++) {
                LiteVMParameterWrapper liteVMParameterWrapper = liteVMParameterWrapperArr2[i12];
                if (liteVMParameterWrapper != null && liteVMParameterWrapper.getType() == LiteVMParamType.PARAM_TYPE.PARAM_TYPE_STRING.getValue() && liteVMParameterWrapper.getValue() != null) {
                    try {
                        byte[] bytes = ((String) liteVMParameterWrapper.getValue()).getBytes("UTF-8");
                        byte[] bArr = new byte[bytes.length + 1];
                        for (int i13 = 0; i13 < bytes.length; i13++) {
                            bArr[i13] = bytes[i13];
                        }
                        bArr[bytes.length] = 0;
                        liteVMParameterWrapperArr2[i12] = new LiteVMParameterWrapper(LiteVMParamType.PARAM_TYPE.PARAM_TYPE_STRING, bArr);
                    } catch (Exception unused) {
                        throw new SecException("LVM string param convert error", 2101);
                    }
                }
            }
        }
        return ((C0854) liteVMInstance.getImpl()).m3895(i10, liteVMParameterWrapperArr2, i11, 12504);
    }

    /* renamed from: а, reason: contains not printable characters */
    public static Object m3883(Class cls, ISecurityGuardPlugin iSecurityGuardPlugin) throws ClassNotFoundException {
        Class.forName("com.alibaba.wireless.security.open.litevm.LiteVMInstance");
        if (f627 == null) {
            synchronized (C0852.class) {
                if (f627 == null && iSecurityGuardPlugin != null) {
                    f628 = new C0852(iSecurityGuardPlugin);
                    f627 = C0076.m1924(cls, new C0853());
                }
            }
        }
        return f627;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public void m3886(LiteVMInstance liteVMInstance) throws SecException {
        if (liteVMInstance == null || !m3890(liteVMInstance)) {
            throw new SecException("LVM instance not valid", 2101);
        }
        ((C0854) liteVMInstance.getImpl()).m3896();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public void m3887(LiteVMInstance liteVMInstance, byte[] bArr) throws SecException {
        if (liteVMInstance == null || !m3890(liteVMInstance)) {
            throw new SecException("lvm instance not valid", 2101);
        }
        ((C0854) liteVMInstance.getImpl()).m3897(bArr);
    }

    /* renamed from: б, reason: contains not printable characters */
    private boolean m3890(LiteVMInstance liteVMInstance) {
        Object impl;
        if (liteVMInstance == null || (impl = liteVMInstance.getImpl()) == null || !(impl instanceof C0854)) {
            return false;
        }
        return ((C0854) impl).m3898();
    }
}
