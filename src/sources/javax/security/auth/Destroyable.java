package javax.security.auth;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Destroyable {
    default void destroy() throws DestroyFailedException {
        throw new DestroyFailedException();
    }

    default boolean isDestroyed() {
        return false;
    }
}
