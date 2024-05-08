package java.util.logging;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileHandler extends StreamHandler {
    private static final int MAX_LOCKS = 100;
    private static final Set<String> locks = new HashSet();
    private boolean append;
    private int count;
    private File[] files;
    private int limit;
    private FileChannel lockFileChannel;
    private String lockFileName;
    private MeteredStream meter;
    private String pattern;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class MeteredStream extends OutputStream {
        final OutputStream out;
        int written;

        MeteredStream(OutputStream out, int written) {
            this.out = out;
            this.written = written;
        }

        @Override // java.io.OutputStream
        public void write(int b4) throws IOException {
            this.out.write(b4);
            this.written++;
        }

        @Override // java.io.OutputStream
        public void write(byte[] buff) throws IOException {
            this.out.write(buff);
            this.written += buff.length;
        }

        @Override // java.io.OutputStream
        public void write(byte[] buff, int off, int len) throws IOException {
            this.out.write(buff, off, len);
            this.written += len;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.out.flush();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.out.close();
        }
    }

    private void open(File fname, boolean append) throws IOException {
        int len = 0;
        if (append) {
            len = (int) fname.length();
        }
        FileOutputStream fout = new FileOutputStream(fname.toString(), append);
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        MeteredStream meteredStream = new MeteredStream(bout, len);
        this.meter = meteredStream;
        setOutputStream(meteredStream);
    }

    private void configure() {
        LogManager manager = LogManager.getLogManager();
        String cname = getClass().getName();
        this.pattern = manager.getStringProperty(cname + ".pattern", "%h/java%u.log");
        int intProperty = manager.getIntProperty(cname + ".limit", 0);
        this.limit = intProperty;
        if (intProperty < 0) {
            this.limit = 0;
        }
        int intProperty2 = manager.getIntProperty(cname + ".count", 1);
        this.count = intProperty2;
        if (intProperty2 <= 0) {
            this.count = 1;
        }
        this.append = manager.getBooleanProperty(cname + ".append", false);
        setLevel(manager.getLevelProperty(cname + ".level", Level.ALL));
        setFilter(manager.getFilterProperty(cname + ".filter", null));
        setFormatter(manager.getFormatterProperty(cname + ".formatter", new XMLFormatter()));
        try {
            setEncoding(manager.getStringProperty(cname + ".encoding", null));
        } catch (Exception e2) {
            try {
                setEncoding(null);
            } catch (Exception e10) {
            }
        }
    }

    public FileHandler() throws IOException, SecurityException {
        checkPermission();
        configure();
        openFiles();
    }

    public FileHandler(String pattern) throws IOException, SecurityException {
        if (pattern.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern;
        this.limit = 0;
        this.count = 1;
        openFiles();
    }

    public FileHandler(String pattern, boolean append) throws IOException, SecurityException {
        if (pattern.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern;
        this.limit = 0;
        this.count = 1;
        this.append = append;
        openFiles();
    }

    public FileHandler(String pattern, int limit, int count) throws IOException, SecurityException {
        if (limit < 0 || count < 1 || pattern.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern;
        this.limit = limit;
        this.count = count;
        openFiles();
    }

    public FileHandler(String pattern, int limit, int count, boolean append) throws IOException, SecurityException {
        if (limit < 0 || count < 1 || pattern.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern;
        this.limit = limit;
        this.count = count;
        this.append = append;
        openFiles();
    }

    private boolean isParentWritable(Path path) {
        Path parent = path.getParent();
        if (parent == null) {
            parent = path.toAbsolutePath().getParent();
        }
        return parent != null && Files.isWritable(parent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
    
        java.util.logging.FileHandler.locks.add(r14.lockFileName);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
    
        r14.files = new java.io.File[r14.count];
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c7, code lost:
    
        if (r5 >= r14.count) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c9, code lost:
    
        r14.files[r5] = generate(r14.pattern, r5, r4);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d8, code lost:
    
        if (r14.append == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00da, code lost:
    
        open(r14.files[0], true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e5, code lost:
    
        r2 = r1.lastException;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e7, code lost:
    
        if (r2 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00eb, code lost:
    
        if ((r2 instanceof java.io.IOException) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ef, code lost:
    
        if ((r2 instanceof java.lang.SecurityException) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00f4, code lost:
    
        throw ((java.lang.SecurityException) r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010d, code lost:
    
        throw new java.io.IOException("Exception: " + ((java.lang.Object) r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0111, code lost:
    
        throw ((java.io.IOException) r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0112, code lost:
    
        setErrorManager(new java.util.logging.ErrorManager());
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x011a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e2, code lost:
    
        rotate();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void openFiles() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.FileHandler.openFiles():void");
    }

    private File generate(String pattern, int generation, int unique) throws IOException {
        File file;
        File file2 = null;
        String word = "";
        int ix = 0;
        boolean sawg = false;
        boolean sawu = false;
        while (ix < pattern.length()) {
            char ch = pattern.charAt(ix);
            ix++;
            char ch2 = 0;
            if (ix < pattern.length()) {
                ch2 = Character.toLowerCase(pattern.charAt(ix));
            }
            if (ch == '/') {
                if (file2 == null) {
                    file = new File(word);
                } else {
                    file = new File(file2, word);
                }
                file2 = file;
                word = "";
            } else {
                if (ch == '%') {
                    if (ch2 == 't') {
                        String tmpDir = System.getProperty("java.io.tmpdir");
                        if (tmpDir == null) {
                            tmpDir = System.getProperty("user.home");
                        }
                        file2 = new File(tmpDir);
                        ix++;
                        word = "";
                    } else if (ch2 == 'h') {
                        file2 = new File(System.getProperty("user.home"));
                        ix++;
                        word = "";
                    } else if (ch2 == 'g') {
                        word = word + generation;
                        sawg = true;
                        ix++;
                    } else if (ch2 == 'u') {
                        word = word + unique;
                        sawu = true;
                        ix++;
                    } else if (ch2 == '%') {
                        word = word + "%";
                        ix++;
                    }
                }
                word = word + ch;
            }
        }
        if (this.count > 1 && !sawg) {
            word = word + "." + generation;
        }
        if (unique > 0 && !sawu) {
            word = word + "." + unique;
        }
        if (word.length() > 0) {
            if (file2 == null) {
                File file3 = new File(word);
                return file3;
            }
            return new File(file2, word);
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rotate() {
        Level oldLevel = getLevel();
        setLevel(Level.OFF);
        super.close();
        for (int i10 = this.count - 2; i10 >= 0; i10--) {
            File[] fileArr = this.files;
            File f12 = fileArr[i10];
            File f22 = fileArr[i10 + 1];
            if (f12.exists()) {
                if (f22.exists()) {
                    f22.delete();
                }
                f12.renameTo(f22);
            }
        }
        try {
            open(this.files[0], false);
        } catch (IOException ix) {
            reportError(null, ix, 4);
        }
        setLevel(oldLevel);
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            super.publish(record);
            flush();
            if (this.limit > 0 && this.meter.written >= this.limit) {
                AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: java.util.logging.FileHandler.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        FileHandler.this.rotate();
                        return null;
                    }
                });
            }
        }
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public synchronized void close() throws SecurityException {
        super.close();
        if (this.lockFileName == null) {
            return;
        }
        try {
            this.lockFileChannel.close();
        } catch (Exception e2) {
        }
        Set<String> set = locks;
        synchronized (set) {
            set.remove(this.lockFileName);
        }
        new File(this.lockFileName).delete();
        this.lockFileName = null;
        this.lockFileChannel = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class InitializationErrorManager extends ErrorManager {
        Exception lastException;

        private InitializationErrorManager() {
        }

        @Override // java.util.logging.ErrorManager
        public void error(String msg, Exception ex, int code) {
            this.lastException = ex;
        }
    }
}
