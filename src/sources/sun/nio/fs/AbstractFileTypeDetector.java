package sun.nio.fs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractFileTypeDetector extends FileTypeDetector {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String implProbeContentType(Path path) throws IOException;

    @Override // java.nio.file.spi.FileTypeDetector
    public final String probeContentType(Path file) throws IOException {
        if (file == null) {
            throw new NullPointerException("'file' is null");
        }
        String result = implProbeContentType(file);
        if (result == null) {
            return null;
        }
        return parse(result);
    }

    private static String parse(String s2) {
        int slash = s2.indexOf(47);
        int semicolon = s2.indexOf(59);
        if (slash < 0) {
            return null;
        }
        String type = s2.substring(0, slash).trim().toLowerCase(Locale.ENGLISH);
        if (!isValidToken(type)) {
            return null;
        }
        String subtype = (semicolon < 0 ? s2.substring(slash + 1) : s2.substring(slash + 1, semicolon)).trim().toLowerCase(Locale.ENGLISH);
        if (!isValidToken(subtype)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(type.length() + subtype.length() + 1);
        sb2.append(type);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(subtype);
        return sb2.toString();
    }

    private static boolean isTokenChar(char c4) {
        return c4 > ' ' && c4 < 127 && TSPECIALS.indexOf(c4) < 0;
    }

    private static boolean isValidToken(String s2) {
        int len = s2.length();
        if (len == 0) {
            return false;
        }
        for (int i10 = 0; i10 < len; i10++) {
            if (!isTokenChar(s2.charAt(i10))) {
                return false;
            }
        }
        return true;
    }
}
