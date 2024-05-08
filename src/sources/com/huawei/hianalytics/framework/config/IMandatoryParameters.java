package com.huawei.hianalytics.framework.config;

import android.content.Context;
import com.huawei.hianalytics.core.transport.ITransportHandler;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IMandatoryParameters {
    boolean checkDebugModeEnabled();

    List<String> getAllTags();

    String getAppVer();

    String getCaCertificatePath();

    CipherType getCipherType();

    Context getContext();

    String getDebugModeUrl();

    String getLoadWorkKey();

    String getModel();

    String[] getPreInstallURL();

    String getProcessName();

    ITransportHandler.Protocols getProtocols();

    String getRsaPublicKeyFromNetWork(String str, String str2);

    boolean isFlashKey();

    boolean isGCMParameterSpec();

    boolean isHighCipher();

    void refreshKey(String str, int i10);
}
