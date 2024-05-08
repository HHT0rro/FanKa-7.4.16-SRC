package sun.net.www.protocol.jar;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JarURLConnection extends java.net.JarURLConnection {
    private static final boolean debug = false;
    private static final JarFileFactory factory = JarFileFactory.getInstance();
    private String contentType;
    private String entryName;
    private JarEntry jarEntry;
    private JarFile jarFile;
    private URL jarFileURL;
    private URLConnection jarFileURLConnection;
    private Permission permission;

    public JarURLConnection(URL url, Handler handler) throws MalformedURLException, IOException {
        super(url);
        URL jarFileURL = getJarFileURL();
        this.jarFileURL = jarFileURL;
        this.jarFileURLConnection = jarFileURL.openConnection();
        this.entryName = getEntryName();
    }

    @Override // java.net.JarURLConnection
    public JarFile getJarFile() throws IOException {
        connect();
        return this.jarFile;
    }

    @Override // java.net.JarURLConnection
    public JarEntry getJarEntry() throws IOException {
        connect();
        return this.jarEntry;
    }

    @Override // java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.jarFileURLConnection.getPermission();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class JarURLInputStream extends FilterInputStream {
        JarURLInputStream(InputStream src) {
            super(src);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                super.close();
            } finally {
                if (!JarURLConnection.this.getUseCaches()) {
                    JarURLConnection.this.jarFile.close();
                }
            }
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        if (!this.connected) {
            JarFileFactory jarFileFactory = factory;
            this.jarFile = jarFileFactory.get(getJarFileURL(), getUseCaches());
            if (getUseCaches()) {
                boolean oldUseCaches = this.jarFileURLConnection.getUseCaches();
                URLConnection connection = jarFileFactory.getConnection(this.jarFile);
                this.jarFileURLConnection = connection;
                connection.setUseCaches(oldUseCaches);
            }
            String str = this.entryName;
            if (str != null) {
                JarEntry jarEntry = (JarEntry) this.jarFile.getEntry(str);
                this.jarEntry = jarEntry;
                if (jarEntry == null) {
                    try {
                        if (!getUseCaches()) {
                            this.jarFile.close();
                        }
                    } catch (Exception e2) {
                    }
                    throw new FileNotFoundException("JAR entry " + this.entryName + " not found in " + this.jarFile.getName());
                }
            }
            this.connected = true;
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        connect();
        if (this.entryName == null) {
            throw new IOException("no entry name specified");
        }
        JarEntry jarEntry = this.jarEntry;
        if (jarEntry == null) {
            throw new FileNotFoundException("JAR entry " + this.entryName + " not found in " + this.jarFile.getName());
        }
        InputStream result = new JarURLInputStream(this.jarFile.getInputStream(jarEntry));
        return result;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        long result = getContentLengthLong();
        if (result > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return -1;
        }
        return (int) result;
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        long result = -1;
        try {
            connect();
            if (this.jarEntry == null) {
                result = this.jarFileURLConnection.getContentLengthLong();
            } else {
                result = getJarEntry().getSize();
            }
        } catch (IOException e2) {
        }
        return result;
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        connect();
        if (this.entryName == null) {
            Object result = this.jarFile;
            return result;
        }
        Object result2 = super.getContent();
        return result2;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (this.contentType == null) {
            if (this.entryName == null) {
                this.contentType = "x-java/jar";
            } else {
                try {
                    connect();
                    InputStream in = this.jarFile.getInputStream(this.jarEntry);
                    this.contentType = guessContentTypeFromStream(new BufferedInputStream(in));
                    in.close();
                } catch (IOException e2) {
                }
            }
            if (this.contentType == null) {
                this.contentType = guessContentTypeFromName(this.entryName);
            }
            if (this.contentType == null) {
                this.contentType = "content/unknown";
            }
        }
        return this.contentType;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String name) {
        return this.jarFileURLConnection.getHeaderField(name);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String key, String value) {
        this.jarFileURLConnection.setRequestProperty(key, value);
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String key) {
        return this.jarFileURLConnection.getRequestProperty(key);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String key, String value) {
        this.jarFileURLConnection.addRequestProperty(key, value);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.jarFileURLConnection.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean allowuserinteraction) {
        this.jarFileURLConnection.setAllowUserInteraction(allowuserinteraction);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.jarFileURLConnection.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean usecaches) {
        this.jarFileURLConnection.setUseCaches(usecaches);
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.jarFileURLConnection.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long ifmodifiedsince) {
        this.jarFileURLConnection.setIfModifiedSince(ifmodifiedsince);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean defaultusecaches) {
        this.jarFileURLConnection.setDefaultUseCaches(defaultusecaches);
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.jarFileURLConnection.getDefaultUseCaches();
    }
}
