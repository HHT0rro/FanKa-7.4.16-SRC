package java.net;

import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: URL.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Parts {
    String path;
    String query;
    String ref;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parts(String file, String host) {
        int ind = file.indexOf(35);
        this.ref = ind < 0 ? null : file.substring(ind + 1);
        String file2 = ind < 0 ? file : file.substring(0, ind);
        int q10 = file2.lastIndexOf(63);
        if (q10 != -1) {
            this.query = file2.substring(q10 + 1);
            this.path = file2.substring(0, q10);
        } else {
            this.path = file2;
        }
        String str = this.path;
        if (str != null && str.length() > 0 && this.path.charAt(0) != '/' && host != null && !host.isEmpty()) {
            this.path = IOUtils.DIR_SEPARATOR_UNIX + this.path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getPath() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getQuery() {
        return this.query;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRef() {
        return this.ref;
    }
}
