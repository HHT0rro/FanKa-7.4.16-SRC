package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.Channel;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SelChImpl extends Channel {
    FileDescriptor getFD();

    int getFDVal();

    void kill() throws IOException;

    void translateAndSetInterestOps(int i10, SelectionKeyImpl selectionKeyImpl);

    boolean translateAndSetReadyOps(int i10, SelectionKeyImpl selectionKeyImpl);

    boolean translateAndUpdateReadyOps(int i10, SelectionKeyImpl selectionKeyImpl);

    int validOps();

    default void park(int event, long nanos) throws IOException {
        long millis;
        if (nanos <= 0) {
            millis = -1;
        } else {
            millis = TimeUnit.NANOSECONDS.toMillis(nanos);
        }
        Net.poll(getFD(), event, millis);
    }

    default void park(int event) throws IOException {
        park(event, 0L);
    }
}
