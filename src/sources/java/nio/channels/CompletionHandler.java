package java.nio.channels;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CompletionHandler<V, A> {
    void completed(V v2, A a10);

    void failed(Throwable th, A a10);
}
