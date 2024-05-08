package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface e {
    File Hp();

    void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch);
}
