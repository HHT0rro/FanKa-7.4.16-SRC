package com.wangmai.okserver.upload;

import com.wangmai.okserver.ProgressListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class UploadListener<T> implements ProgressListener<T> {
    public final Object tag;

    public UploadListener(Object obj) {
        this.tag = obj;
    }
}
