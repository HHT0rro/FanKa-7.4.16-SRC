package com.kwad.framework.filedownloader.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FileDownloadNetworkPolicyException extends FileDownloadGiveUpRetryException {
    public FileDownloadNetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type");
    }
}
