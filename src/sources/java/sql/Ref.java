package java.sql;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Ref {
    String getBaseTypeName() throws SQLException;

    Object getObject() throws SQLException;

    Object getObject(Map<String, Class<?>> map) throws SQLException;

    void setObject(Object obj) throws SQLException;
}
