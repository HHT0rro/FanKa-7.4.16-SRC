package com.kwad.components.offline.api.core.api;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getFileSha256(File file);

    String getMD5(String str);

    String getResponseData(String str);

    String getSha256(String str);
}
