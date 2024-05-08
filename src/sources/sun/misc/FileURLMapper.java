package sun.misc;

import java.io.File;
import java.net.URL;
import sun.net.www.ParseUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileURLMapper {
    String path;
    URL url;

    public FileURLMapper(URL url) {
        this.url = url;
    }

    public String getPath() {
        String str = this.path;
        if (str != null) {
            return str;
        }
        String host = this.url.getHost();
        if (host == null || "".equals(host) || "localhost".equalsIgnoreCase(host)) {
            String file = this.url.getFile();
            this.path = file;
            this.path = ParseUtil.decode(file);
        }
        return this.path;
    }

    public boolean exists() {
        String s2 = getPath();
        if (s2 == null) {
            return false;
        }
        File f10 = new File(s2);
        return f10.exists();
    }
}
