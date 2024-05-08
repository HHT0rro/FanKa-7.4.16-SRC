package com.alibaba.wireless.security.open.safetoken;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

@InterfacePluginInfo(pluginName = "main")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ISafeTokenComponent extends IComponent {
    byte[] decryptWithToken(String str, byte[] bArr, int i10) throws SecException;

    byte[] encryptWithToken(String str, byte[] bArr, int i10) throws SecException;

    byte[] getOtp(String str, int i10, String[] strArr, byte[][] bArr) throws SecException;

    byte[] getOtp(String str, int i10, String[] strArr, byte[][] bArr, String str2) throws SecException;

    boolean isTokenExisted(String str) throws SecException;

    void removeToken(String str) throws SecException;

    boolean saveToken(String str, String str2, String str3, int i10) throws SecException;

    String signWithToken(String str, byte[] bArr, int i10) throws SecException;
}
