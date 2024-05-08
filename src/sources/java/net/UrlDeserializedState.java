package java.net;

import com.huawei.openalliance.ad.constant.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: URL.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class UrlDeserializedState {
    private final String authority;
    private final String file;
    private final int hashCode;
    private final String host;
    private final int port;
    private final String protocol;
    private final String ref;

    public UrlDeserializedState(String protocol, String host, int port, String authority, String file, String ref, int hashCode) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.authority = authority;
        this.file = file;
        this.ref = ref;
        this.hashCode = hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getProtocol() {
        return this.protocol;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getHost() {
        return this.host;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAuthority() {
        return this.authority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPort() {
        return this.port;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFile() {
        return this.file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRef() {
        return this.ref;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHashCode() {
        return this.hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String reconstituteUrlString() {
        int len = this.protocol.length() + 1;
        String str = this.authority;
        if (str != null && str.length() > 0) {
            len += this.authority.length() + 2;
        }
        String str2 = this.file;
        if (str2 != null) {
            len += str2.length();
        }
        String str3 = this.ref;
        if (str3 != null) {
            len += str3.length() + 1;
        }
        StringBuilder result = new StringBuilder(len);
        result.append(this.protocol);
        result.append(u.bD);
        String str4 = this.authority;
        if (str4 != null && str4.length() > 0) {
            result.append("//");
            result.append(this.authority);
        }
        String str5 = this.file;
        if (str5 != null) {
            result.append(str5);
        }
        if (this.ref != null) {
            result.append("#");
            result.append(this.ref);
        }
        return result.toString();
    }
}
