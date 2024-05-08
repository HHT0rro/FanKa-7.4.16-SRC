package java.nio.channels;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface NetworkChannel extends Channel {
    NetworkChannel bind(SocketAddress socketAddress) throws IOException;

    SocketAddress getLocalAddress() throws IOException;

    <T> T getOption(SocketOption<T> socketOption) throws IOException;

    <T> NetworkChannel setOption(SocketOption<T> socketOption, T t2) throws IOException;

    Set<SocketOption<?>> supportedOptions();
}
