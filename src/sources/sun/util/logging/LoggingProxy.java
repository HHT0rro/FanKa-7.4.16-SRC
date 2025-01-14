package sun.util.logging;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface LoggingProxy {
    Object getLevel(Object obj);

    String getLevelName(Object obj);

    int getLevelValue(Object obj);

    Object getLogger(String str);

    String getLoggerLevel(String str);

    List<String> getLoggerNames();

    String getParentLoggerName(String str);

    String getProperty(String str);

    boolean isLoggable(Object obj, Object obj2);

    void log(Object obj, Object obj2, String str);

    void log(Object obj, Object obj2, String str, Throwable th);

    void log(Object obj, Object obj2, String str, Object... objArr);

    Object parseLevel(String str);

    void setLevel(Object obj, Object obj2);

    void setLoggerLevel(String str, String str2);
}
