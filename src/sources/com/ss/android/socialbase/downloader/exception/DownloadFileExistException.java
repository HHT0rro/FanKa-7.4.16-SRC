package com.ss.android.socialbase.downloader.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadFileExistException extends BaseException {
    private String existTargetFileName;

    public DownloadFileExistException(String str) {
        this.existTargetFileName = str;
    }

    public String getExistTargetFileName() {
        return this.existTargetFileName;
    }
}
