package java.net;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class SocketSecrets {
    SocketSecrets() {
    }

    private static <T> void setOption(Object obj, SocketOption<T> name, T value) throws IOException {
        SocketImpl impl;
        if (obj instanceof Socket) {
            impl = ((Socket) obj).getImpl();
        } else if (obj instanceof ServerSocket) {
            impl = ((ServerSocket) obj).getImpl();
        } else {
            throw new IllegalArgumentException();
        }
        impl.setOption((SocketOption<SocketOption<T>>) name, (SocketOption<T>) value);
    }

    private static <T> T getOption(Object obj, SocketOption<T> socketOption) throws IOException {
        SocketImpl impl;
        if (obj instanceof Socket) {
            impl = ((Socket) obj).getImpl();
        } else if (obj instanceof ServerSocket) {
            impl = ((ServerSocket) obj).getImpl();
        } else {
            throw new IllegalArgumentException();
        }
        return (T) impl.getOption(socketOption);
    }

    private static <T> void setOption(DatagramSocket s2, SocketOption<T> name, T value) throws IOException {
        s2.getImpl().setOption((SocketOption<SocketOption<T>>) name, (SocketOption<T>) value);
    }

    private static <T> T getOption(DatagramSocket datagramSocket, SocketOption<T> socketOption) throws IOException {
        return (T) datagramSocket.getImpl().getOption(socketOption);
    }
}
