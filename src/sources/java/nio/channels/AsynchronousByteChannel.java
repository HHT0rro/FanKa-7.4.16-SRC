package java.nio.channels;

import java.nio.ByteBuffer;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface AsynchronousByteChannel extends AsynchronousChannel {
    Future<Integer> read(ByteBuffer byteBuffer);

    <A> void read(ByteBuffer byteBuffer, A a10, CompletionHandler<Integer, ? super A> completionHandler);

    Future<Integer> write(ByteBuffer byteBuffer);

    <A> void write(ByteBuffer byteBuffer, A a10, CompletionHandler<Integer, ? super A> completionHandler);
}
