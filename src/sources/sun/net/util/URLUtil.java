package sun.net.util;

import com.huawei.openalliance.ad.constant.u;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class URLUtil {
    public static String urlNoFragString(URL url) {
        StringBuilder strForm = new StringBuilder();
        String protocol = url.getProtocol();
        if (protocol != null) {
            strForm.append(protocol.toLowerCase());
            strForm.append("://");
        }
        String host = url.getHost();
        if (host != null) {
            strForm.append(host.toLowerCase());
            int port = url.getPort();
            if (port == -1) {
                port = url.getDefaultPort();
            }
            if (port != -1) {
                strForm.append(u.bD).append(port);
            }
        }
        String file = url.getFile();
        if (file != null) {
            strForm.append(file);
        }
        return strForm.toString();
    }
}
