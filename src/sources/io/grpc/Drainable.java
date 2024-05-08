package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Drainable {
    int drainTo(OutputStream outputStream) throws IOException;
}
