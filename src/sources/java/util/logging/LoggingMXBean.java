package java.util.logging;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface LoggingMXBean {
    String getLoggerLevel(String str);

    List<String> getLoggerNames();

    String getParentLoggerName(String str);

    void setLoggerLevel(String str, String str2);
}
