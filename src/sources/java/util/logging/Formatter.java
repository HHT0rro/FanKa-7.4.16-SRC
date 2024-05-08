package java.util.logging;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Formatter {
    public abstract String format(LogRecord logRecord);

    public String getHead(Handler h10) {
        return "";
    }

    public String getTail(Handler h10) {
        return "";
    }

    public synchronized String formatMessage(LogRecord record) {
        String format = record.getMessage();
        ResourceBundle catalog = record.getResourceBundle();
        if (catalog != null) {
            try {
                format = catalog.getString(record.getMessage());
            } catch (MissingResourceException e2) {
                format = record.getMessage();
            }
        }
        try {
            Object[] parameters = record.getParameters();
            if (parameters != null && parameters.length != 0) {
                if (format.indexOf("{0") < 0 && format.indexOf("{1") < 0 && format.indexOf("{2") < 0 && format.indexOf("{3") < 0) {
                    return format;
                }
                return MessageFormat.format(format, parameters);
            }
            return format;
        } catch (Exception e10) {
            return format;
        }
    }
}
