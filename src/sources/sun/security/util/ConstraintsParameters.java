package sun.security.util;

import java.security.Key;
import java.util.Date;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ConstraintsParameters {
    boolean anchorIsJdkCA();

    String extendedExceptionMsg();

    Date getDate();

    Set<Key> getKeys();

    String getVariant();
}
