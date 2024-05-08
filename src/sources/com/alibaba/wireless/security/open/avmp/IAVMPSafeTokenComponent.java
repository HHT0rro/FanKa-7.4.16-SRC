package com.alibaba.wireless.security.open.avmp;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IAVMPSafeTokenComponent extends IComponent {
    byte[] decryptWithToken(String str, byte[] bArr, int i10) throws SecException;

    byte[] encryptWithToken(String str, byte[] bArr, int i10) throws SecException;

    int getOTP(String str, int i10) throws SecException;

    boolean initAVMPSafeToken(String str) throws SecException;

    boolean isTokenExisted(String str) throws SecException;

    boolean removeToken(String str) throws SecException;

    boolean saveToken(String str, String str2, String str3, int i10) throws SecException;

    String signWithToken(String str, byte[] bArr, int i10) throws SecException;
}
