package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface LottieFetchResult extends Closeable {
    @NonNull
    InputStream bodyByteStream() throws IOException;

    @Nullable
    String contentType();

    @Nullable
    String error();

    boolean isSuccessful();
}
