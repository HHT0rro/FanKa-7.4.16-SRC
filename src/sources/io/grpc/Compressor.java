package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Compressor {
    OutputStream compress(OutputStream outputStream) throws IOException;

    String getMessageEncoding();
}
