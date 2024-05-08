package javax.sql;

import java.util.EventListener;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface StatementEventListener extends EventListener {
    void statementClosed(StatementEvent statementEvent);

    void statementErrorOccurred(StatementEvent statementEvent);
}
