package com.kwad.components.offline.api.core.api;

import androidx.annotation.WorkerThread;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDownloader {
    @WorkerThread
    boolean downloadSync(File file, String str);
}
