package com.alibaba.wireless.security.open.staticdataencrypt;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

@InterfacePluginInfo(pluginName = "main")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IStaticDataEncryptComponent extends IComponent {
    public static final int ALGORITHM_MAX_NUMBER = 19;
    public static final int OPEN_ENUM_CIPHER_AES128 = 16;
    public static final int OPEN_ENUM_CIPHER_AES192 = 17;
    public static final int OPEN_ENUM_CIPHER_AES256 = 18;
    public static final int OPEN_ENUM_CIPHER_ARCFOUR = 3;

    byte[] staticBinarySafeDecrypt(int i10, String str, byte[] bArr, String str2) throws SecException;

    byte[] staticBinarySafeDecryptNoB64(int i10, String str, byte[] bArr, String str2) throws SecException;

    byte[] staticBinarySafeEncrypt(int i10, String str, byte[] bArr, String str2) throws SecException;

    byte[] staticBinarySafeEncryptNoB64(int i10, String str, byte[] bArr, String str2) throws SecException;

    String staticSafeDecrypt(int i10, String str, String str2, String str3) throws SecException;

    String staticSafeEncrypt(int i10, String str, String str2, String str3) throws SecException;
}
