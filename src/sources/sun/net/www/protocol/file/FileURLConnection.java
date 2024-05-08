package sun.net.www.protocol.file;

import com.alipay.sdk.packet.e;
import com.baidu.mobads.sdk.internal.an;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URL;
import java.security.Permission;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.TimeZones;
import sun.net.ProgressMonitor;
import sun.net.ProgressSource;
import sun.net.www.MessageHeader;
import sun.net.www.MeteredStream;
import sun.net.www.ParseUtil;
import sun.net.www.URLConnection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileURLConnection extends URLConnection {
    String contentType;
    boolean exists;
    File file;
    String filename;
    List<String> files;
    private boolean initializedHeaders;
    InputStream is;
    boolean isDirectory;
    long lastModified;
    long length;
    Permission permission;
    static String CONTENT_LENGTH = "content-length";
    static String CONTENT_TYPE = e.f4632d;
    static String TEXT_PLAIN = an.f9799e;
    static String LAST_MODIFIED = "last-modified";

    /* JADX INFO: Access modifiers changed from: protected */
    public FileURLConnection(URL u10, File file) {
        super(u10);
        this.isDirectory = false;
        this.exists = false;
        this.length = -1L;
        this.lastModified = 0L;
        this.initializedHeaders = false;
        this.file = file;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        if (!this.connected) {
            try {
                this.filename = this.file.toString();
                boolean isDirectory = this.file.isDirectory();
                this.isDirectory = isDirectory;
                if (isDirectory) {
                    String[] fileList = this.file.list();
                    if (fileList == null) {
                        throw new FileNotFoundException(this.filename + " exists, but is not accessible");
                    }
                    this.files = Arrays.asList(fileList);
                } else {
                    this.is = new BufferedInputStream(new FileInputStream(this.filename));
                    boolean meteredInput = ProgressMonitor.getDefault().shouldMeterInput(this.url, "GET");
                    if (meteredInput) {
                        ProgressSource pi = new ProgressSource(this.url, "GET", this.file.length());
                        this.is = new MeteredStream(this.is, pi, this.file.length());
                    }
                }
                this.connected = true;
            } catch (IOException e2) {
                throw e2;
            }
        }
    }

    private void initializeHeaders() {
        try {
            connect();
            this.exists = this.file.exists();
        } catch (IOException e2) {
        }
        if (!this.initializedHeaders || !this.exists) {
            this.length = this.file.length();
            this.lastModified = this.file.lastModified();
            if (!this.isDirectory) {
                FileNameMap map = java.net.URLConnection.getFileNameMap();
                String contentTypeFor = map.getContentTypeFor(this.filename);
                this.contentType = contentTypeFor;
                if (contentTypeFor != null) {
                    this.properties.add(CONTENT_TYPE, this.contentType);
                }
                this.properties.add(CONTENT_LENGTH, String.valueOf(this.length));
                if (this.lastModified != 0) {
                    Date date = new Date(this.lastModified);
                    SimpleDateFormat fo = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                    fo.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
                    this.properties.add(LAST_MODIFIED, fo.format(date));
                }
            } else {
                this.properties.add(CONTENT_TYPE, TEXT_PLAIN);
            }
            this.initializedHeaders = true;
        }
    }

    @Override // sun.net.www.URLConnection, java.net.URLConnection
    public String getHeaderField(String name) {
        initializeHeaders();
        return super.getHeaderField(name);
    }

    @Override // sun.net.www.URLConnection, java.net.URLConnection
    public String getHeaderField(int n10) {
        initializeHeaders();
        return super.getHeaderField(n10);
    }

    @Override // sun.net.www.URLConnection, java.net.URLConnection
    public int getContentLength() {
        initializeHeaders();
        long j10 = this.length;
        if (j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return -1;
        }
        return (int) j10;
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        initializeHeaders();
        return this.length;
    }

    @Override // sun.net.www.URLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int n10) {
        initializeHeaders();
        return super.getHeaderFieldKey(n10);
    }

    @Override // sun.net.www.URLConnection
    public MessageHeader getProperties() {
        initializeHeaders();
        return super.getProperties();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        initializeHeaders();
        return this.lastModified;
    }

    @Override // java.net.URLConnection
    public synchronized InputStream getInputStream() throws IOException {
        connect();
        if (this.is == null) {
            if (this.isDirectory) {
                java.net.URLConnection.getFileNameMap();
                StringBuffer buf = new StringBuffer();
                List<String> list = this.files;
                if (list == null) {
                    throw new FileNotFoundException(this.filename);
                }
                Collections.sort(list, Collator.getInstance());
                for (int i10 = 0; i10 < this.files.size(); i10++) {
                    String fileName = this.files.get(i10);
                    buf.append(fileName);
                    buf.append("\n");
                }
                this.is = new ByteArrayInputStream(buf.toString().getBytes());
            } else {
                throw new FileNotFoundException(this.filename);
            }
        }
        return this.is;
    }

    @Override // java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (this.permission == null) {
            String decodedPath = ParseUtil.decode(this.url.getPath());
            if (File.separatorChar == '/') {
                this.permission = new FilePermission(decodedPath, "read");
            } else {
                this.permission = new FilePermission(decodedPath.replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar), "read");
            }
        }
        return this.permission;
    }
}
