package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Wrapper {
    boolean isWrapperFor(Class<?> cls) throws SQLException;

    <T> T unwrap(Class<T> cls) throws SQLException;
}
