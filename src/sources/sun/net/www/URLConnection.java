package sun.net.www;

import com.alipay.sdk.packet.e;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class URLConnection extends java.net.URLConnection {
    private static HashMap<String, Void> proxiedHosts = new HashMap<>();
    private int contentLength;
    private String contentType;
    protected MessageHeader properties;

    public URLConnection(URL u10) {
        super(u10);
        this.contentLength = -1;
        this.properties = new MessageHeader();
    }

    public MessageHeader getProperties() {
        return this.properties;
    }

    public void setProperties(MessageHeader properties) {
        this.properties = properties;
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String key, String value) {
        if (this.connected) {
            throw new IllegalAccessError("Already connected");
        }
        if (key == null) {
            throw new NullPointerException("key cannot be null");
        }
        this.properties.set(key, value);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String key, String value) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (key == null) {
            throw new NullPointerException("key is null");
        }
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String key) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        return null;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        return Collections.emptyMap();
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String name) {
        try {
            getInputStream();
            MessageHeader messageHeader = this.properties;
            if (messageHeader == null) {
                return null;
            }
            return messageHeader.findValue(name);
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public String getHeaderFieldKey(int n10) {
        try {
            getInputStream();
            MessageHeader props = this.properties;
            if (props == null) {
                return null;
            }
            return props.getKey(n10);
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public String getHeaderField(int n10) {
        try {
            getInputStream();
            MessageHeader props = this.properties;
            if (props == null) {
                return null;
            }
            return props.getValue(n10);
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (this.contentType == null) {
            this.contentType = getHeaderField(e.f4632d);
        }
        if (this.contentType == null) {
            String ct = null;
            try {
                ct = guessContentTypeFromStream(getInputStream());
            } catch (IOException e2) {
            }
            String ce2 = this.properties.findValue(GrpcUtil.CONTENT_ENCODING);
            if (ct == null && (ct = this.properties.findValue(e.f4632d)) == null) {
                if (this.url.getFile().endsWith("/")) {
                    ct = "text/html";
                } else {
                    ct = guessContentTypeFromName(this.url.getFile());
                }
            }
            if (ct == null || (ce2 != null && !ce2.equalsIgnoreCase("7bit") && !ce2.equalsIgnoreCase("8bit") && !ce2.equalsIgnoreCase("binary"))) {
                ct = "content/unknown";
            }
            setContentType(ct);
        }
        String ct2 = this.contentType;
        return ct2;
    }

    public void setContentType(String type) {
        this.contentType = type;
        this.properties.set(e.f4632d, type);
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        try {
            getInputStream();
            int l10 = this.contentLength;
            if (l10 < 0) {
                try {
                    l10 = Integer.parseInt(this.properties.findValue("content-length"));
                    setContentLength(l10);
                    return l10;
                } catch (Exception e2) {
                    return l10;
                }
            }
            return l10;
        } catch (Exception e10) {
            return -1;
        }
    }

    protected void setContentLength(int length) {
        this.contentLength = length;
        this.properties.set("content-length", String.valueOf(length));
    }

    public boolean canCache() {
        return this.url.getFile().indexOf(63) < 0;
    }

    public void close() {
        this.url = null;
    }

    public static synchronized void setProxiedHost(String host) {
        synchronized (URLConnection.class) {
            proxiedHosts.put(host.toLowerCase(), null);
        }
    }

    public static synchronized boolean isProxiedHost(String host) {
        boolean containsKey;
        synchronized (URLConnection.class) {
            containsKey = proxiedHosts.containsKey(host.toLowerCase());
        }
        return containsKey;
    }
}
