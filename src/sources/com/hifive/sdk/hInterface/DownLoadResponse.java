package com.hifive.sdk.hInterface;

import java.io.File;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: DownLoadResponse.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DownLoadResponse {
    void fail(@NotNull String str);

    void progress(long j10, long j11);

    void size(long j10);

    void succeed(@NotNull File file);
}
