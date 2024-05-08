package com.wangmai.okserver.download;

import com.wangmai.okserver.ProgressListener;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class DownloadListener implements ProgressListener<File> {
    public final Object tag;

    public DownloadListener(Object obj) {
        this.tag = obj;
    }
}
