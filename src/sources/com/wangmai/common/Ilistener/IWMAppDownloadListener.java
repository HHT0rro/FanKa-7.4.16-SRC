package com.wangmai.common.Ilistener;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IWMAppDownloadListener {
    void handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

    void onDownloadDialogDismiss();

    void onDownloadDialogShow();

    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadPaused();

    void onDownloadResumed();

    void onDownloadStarted();

    void onProgressUpdate(int i10);
}
