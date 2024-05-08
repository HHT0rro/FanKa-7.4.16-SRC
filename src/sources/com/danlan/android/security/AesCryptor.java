package com.danlan.android.security;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AesCryptor {
    public static String DK1;
    public static String EK1;

    static {
        System.loadLibrary("sec_cryptor");
        EK1 = "65c8ac6576a8c16ce02587882902754d6b942687191429ce2edf5e097de72c920177f9e71ff576d8d68907e22e67f8f2f0cb6ddd160e21dafcad674e806ce375fa6337664ec40cf8b480fdb832978185596ff16d8899907559fb76853f4efa811c6ba3a44363a19f66c66cb32cc29c7ad98798ce4040630d7164ff17d40b2e69a840a3929a0f12266729c249055737956d48d6eee23abbd11ac6934cb2c6d8e883003589b80ae06713ca1afd074fd77b9dceb924";
        DK1 = "2604df275c9b8d22a674d733e0f9aada81e0c36cc1f0c383a59966d3107bb08db0be1a4ac08f8c3bf4e37a08a60cd0c966ed624fcc96bde77937497e1e06da054f6c82bcc4c938d8f4cd0dac8a2afa2ed40a44dbde8af7f53ab0fa70b67538f0e7fb2783dc092ecb514636d9a0090d6d576e2958f55e61c3ea9ab2a91fbbaa7e41064406b625d1c8e45fdafe2e3d39b4426c808f8450cca57fe6d0571b48791dfbedf9789d0ff5e8bb7e174e74408bfdb7b77afc";
    }

    public static native byte[] aesDecryptByteArry(byte[] bArr, String str, byte[] bArr2);

    public static native byte[] aesEncryptByteArry(byte[] bArr, String str, byte[] bArr2);
}
