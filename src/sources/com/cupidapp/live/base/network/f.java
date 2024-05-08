package com.cupidapp.live.base.network;

import java.io.File;
import kotlin.jvm.internal.s;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: RequestBodyExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {
    @NotNull
    public static final RequestBody a(@NotNull File file) {
        s.i(file, "<this>");
        return RequestBody.Companion.create(file, MediaType.Companion.parse("application/octet-stream"));
    }
}
