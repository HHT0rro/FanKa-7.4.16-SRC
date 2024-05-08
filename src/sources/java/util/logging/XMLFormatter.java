package java.util.logging;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.nio.charset.Charset;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class XMLFormatter extends Formatter {
    private LogManager manager = LogManager.getLogManager();

    private void a2(StringBuilder sb2, int x10) {
        if (x10 < 10) {
            sb2.append('0');
        }
        sb2.append(x10);
    }

    private void appendISO8601(StringBuilder sb2, long millis) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(millis);
        sb2.append(cal.get(1));
        sb2.append('-');
        a2(sb2, cal.get(2) + 1);
        sb2.append('-');
        a2(sb2, cal.get(5));
        sb2.append('T');
        a2(sb2, cal.get(11));
        sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        a2(sb2, cal.get(12));
        sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        a2(sb2, cal.get(13));
    }

    private void escape(StringBuilder sb2, String text) {
        if (text == null) {
            text = "<null>";
        }
        for (int i10 = 0; i10 < text.length(); i10++) {
            char ch = text.charAt(i10);
            if (ch == '<') {
                sb2.append("&lt;");
            } else if (ch == '>') {
                sb2.append("&gt;");
            } else if (ch == '&') {
                sb2.append("&amp;");
            } else {
                sb2.append(ch);
            }
        }
    }

    @Override // java.util.logging.Formatter
    public String format(LogRecord record) {
        StringBuilder sb2 = new StringBuilder(500);
        sb2.append("<record>\n");
        sb2.append("  <date>");
        appendISO8601(sb2, record.getMillis());
        sb2.append("</date>\n");
        sb2.append("  <millis>");
        sb2.append(record.getMillis());
        sb2.append("</millis>\n");
        sb2.append("  <sequence>");
        sb2.append(record.getSequenceNumber());
        sb2.append("</sequence>\n");
        String name = record.getLoggerName();
        if (name != null) {
            sb2.append("  <logger>");
            escape(sb2, name);
            sb2.append("</logger>\n");
        }
        sb2.append("  <level>");
        escape(sb2, record.getLevel().toString());
        sb2.append("</level>\n");
        if (record.getSourceClassName() != null) {
            sb2.append("  <class>");
            escape(sb2, record.getSourceClassName());
            sb2.append("</class>\n");
        }
        if (record.getSourceMethodName() != null) {
            sb2.append("  <method>");
            escape(sb2, record.getSourceMethodName());
            sb2.append("</method>\n");
        }
        sb2.append("  <thread>");
        sb2.append(record.getThreadID());
        sb2.append("</thread>\n");
        if (record.getMessage() != null) {
            String message = formatMessage(record);
            sb2.append("  <message>");
            escape(sb2, message);
            sb2.append("</message>");
            sb2.append("\n");
        } else {
            sb2.append("<message/>");
            sb2.append("\n");
        }
        ResourceBundle bundle = record.getResourceBundle();
        if (bundle != null) {
            try {
                if (bundle.getString(record.getMessage()) != null) {
                    sb2.append("  <key>");
                    escape(sb2, record.getMessage());
                    sb2.append("</key>\n");
                    sb2.append("  <catalog>");
                    escape(sb2, record.getResourceBundleName());
                    sb2.append("</catalog>\n");
                }
            } catch (Exception e2) {
            }
        }
        Object[] parameters = record.getParameters();
        if (parameters != null && parameters.length != 0 && record.getMessage().indexOf("{") == -1) {
            for (Object obj : parameters) {
                sb2.append("  <param>");
                try {
                    escape(sb2, obj.toString());
                } catch (Exception e10) {
                    sb2.append("???");
                }
                sb2.append("</param>\n");
            }
        }
        if (record.getThrown() != null) {
            Throwable th = record.getThrown();
            sb2.append("  <exception>\n");
            sb2.append("    <message>");
            escape(sb2, th.toString());
            sb2.append("</message>\n");
            StackTraceElement[] trace = th.getStackTrace();
            for (StackTraceElement frame : trace) {
                sb2.append("    <frame>\n");
                sb2.append("      <class>");
                escape(sb2, frame.getClassName());
                sb2.append("</class>\n");
                sb2.append("      <method>");
                escape(sb2, frame.getMethodName());
                sb2.append("</method>\n");
                if (frame.getLineNumber() >= 0) {
                    sb2.append("      <line>");
                    sb2.append(frame.getLineNumber());
                    sb2.append("</line>\n");
                }
                sb2.append("    </frame>\n");
            }
            sb2.append("  </exception>\n");
        }
        sb2.append("</record>\n");
        return sb2.toString();
    }

    @Override // java.util.logging.Formatter
    public String getHead(Handler h10) {
        String encoding;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<?xml version=\"1.0\"");
        if (h10 != null) {
            encoding = h10.getEncoding();
        } else {
            encoding = null;
        }
        if (encoding == null) {
            encoding = Charset.defaultCharset().name();
        }
        try {
            Charset cs = Charset.forName(encoding);
            encoding = cs.name();
        } catch (Exception e2) {
        }
        sb2.append(" encoding=\"");
        sb2.append(encoding);
        sb2.append("\"");
        sb2.append(" standalone=\"no\"?>\n");
        sb2.append("<!DOCTYPE log SYSTEM \"logger.dtd\">\n");
        sb2.append("<log>\n");
        return sb2.toString();
    }

    @Override // java.util.logging.Formatter
    public String getTail(Handler h10) {
        return "</log>\n";
    }
}
