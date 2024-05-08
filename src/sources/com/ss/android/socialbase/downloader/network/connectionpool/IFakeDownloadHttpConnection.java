package com.ss.android.socialbase.downloader.network.connectionpool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IFakeDownloadHttpConnection {
    void execute() throws Exception;

    boolean isRequesting();

    boolean isSuccessful();

    boolean isValid();

    void joinExecute() throws InterruptedException;
}
