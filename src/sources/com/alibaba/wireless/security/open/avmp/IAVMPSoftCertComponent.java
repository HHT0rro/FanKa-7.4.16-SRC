package com.alibaba.wireless.security.open.avmp;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IAVMPSoftCertComponent extends IComponent {
    byte[] generateCSR(String str, String str2, int i10) throws SecException;

    String getCert(String str) throws SecException;

    boolean initAVMPSoftCert(String str) throws SecException;

    boolean installCert(String str, String str2) throws SecException;

    byte[] signWithCert(String str, byte[] bArr, int i10) throws SecException;

    boolean verifyWithCert(String str, byte[] bArr, byte[] bArr2, int i10) throws SecException;
}
