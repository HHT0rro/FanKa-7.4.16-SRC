package org.apache.commons.io.input;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file, TailerListener tailerListener) {
        this(file, tailerListener, 1000L);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j10, boolean z10, int i10) {
        Tailer tailer = new Tailer(file, tailerListener, j10, z10, i10);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int read;
        StringBuilder sb2 = new StringBuilder();
        long filePointer = randomAccessFile.getFilePointer();
        long j10 = filePointer;
        boolean z10 = false;
        while (this.run && (read = randomAccessFile.read(this.inbuf)) != -1) {
            for (int i10 = 0; i10 < read; i10++) {
                byte b4 = this.inbuf[i10];
                if (b4 == 10) {
                    this.listener.handle(sb2.toString());
                    sb2.setLength(0);
                    filePointer = i10 + j10 + 1;
                    z10 = false;
                } else if (b4 != 13) {
                    if (z10) {
                        this.listener.handle(sb2.toString());
                        sb2.setLength(0);
                        filePointer = i10 + j10 + 1;
                        z10 = false;
                    }
                    sb2.append((char) b4);
                } else {
                    if (z10) {
                        sb2.append(CharUtils.CR);
                    }
                    z10 = true;
                }
            }
            j10 = randomAccessFile.getFilePointer();
        }
        randomAccessFile.seek(filePointer);
        return filePointer;
    }

    public long getDelay() {
        return this.delayMillis;
    }

    public File getFile() {
        return this.file;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:32|(1:34)(8:(1:57)|36|(1:38)|39|40|41|(5:46|47|48|49|50)|51)|35|36|(0)|39|40|41|(1:53)(7:43|44|46|47|48|49|50)|51) */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c A[Catch: all -> 0x00a7, Exception -> 0x00a9, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a9, blocks: (B:3:0x0005, B:8:0x000d, B:12:0x001d, B:18:0x0023, B:20:0x0027, B:21:0x0030, B:25:0x0016, B:28:0x0038, B:30:0x003c, B:59:0x004c, B:61:0x0051, B:68:0x0066, B:34:0x006e, B:36:0x0088, B:38:0x008c, B:40:0x008f, B:41:0x0094, B:44:0x0098, B:47:0x009c, B:57:0x007c), top: B:2:0x0005 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r14 = this;
            r0 = 0
            r2 = 0
            r3 = r0
            r5 = r3
        L5:
            boolean r7 = r14.run     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.lang.String r8 = "r"
            if (r7 == 0) goto L38
            if (r2 != 0) goto L38
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch: java.io.FileNotFoundException -> L16 java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.io.File r9 = r14.file     // Catch: java.io.FileNotFoundException -> L16 java.lang.Throwable -> La7 java.lang.Exception -> La9
            r7.<init>(r9, r8)     // Catch: java.io.FileNotFoundException -> L16 java.lang.Throwable -> La7 java.lang.Exception -> La9
            r2 = r7
            goto L1b
        L16:
            org.apache.commons.io.input.TailerListener r7 = r14.listener     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r7.fileNotFound()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
        L1b:
            if (r2 != 0) goto L23
            long r7 = r14.delayMillis     // Catch: java.lang.InterruptedException -> L5 java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.lang.Thread.sleep(r7)     // Catch: java.lang.InterruptedException -> L5 java.lang.Throwable -> La7 java.lang.Exception -> La9
            goto L5
        L23:
            boolean r3 = r14.end     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            if (r3 == 0) goto L2f
            java.io.File r3 = r14.file     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            long r3 = r3.length()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r5 = r3
            goto L30
        L2f:
            r5 = r0
        L30:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r2.seek(r5)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            goto L5
        L38:
            boolean r7 = r14.run     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            if (r7 == 0) goto Laf
            java.io.File r7 = r14.file     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            boolean r7 = org.apache.commons.io.FileUtils.isFileNewer(r7, r3)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.io.File r9 = r14.file     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            long r9 = r9.length()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 >= 0) goto L6c
            org.apache.commons.io.input.TailerListener r7 = r14.listener     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r7.fileRotated()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch: java.io.FileNotFoundException -> L66 java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.io.File r9 = r14.file     // Catch: java.io.FileNotFoundException -> L66 java.lang.Throwable -> La7 java.lang.Exception -> La9
            r7.<init>(r9, r8)     // Catch: java.io.FileNotFoundException -> L66 java.lang.Throwable -> La7 java.lang.Exception -> La9
            org.apache.commons.io.IOUtils.closeQuietly(r2)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61 java.io.FileNotFoundException -> L64
            r5 = r0
        L5c:
            r2 = r7
            goto L38
        L5e:
            r0 = move-exception
            r2 = r7
            goto Lb3
        L61:
            r0 = move-exception
            r2 = r7
            goto Laa
        L64:
            r5 = r0
            r2 = r7
        L66:
            org.apache.commons.io.input.TailerListener r7 = r14.listener     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r7.fileNotFound()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            goto L38
        L6c:
            if (r11 <= 0) goto L7a
            long r3 = r14.readLines(r2)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
        L76:
            r12 = r3
            r3 = r5
            r5 = r12
            goto L88
        L7a:
            if (r7 == 0) goto L88
            r2.seek(r0)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            long r3 = r14.readLines(r2)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            goto L76
        L88:
            boolean r7 = r14.reOpen     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            if (r7 == 0) goto L8f
            org.apache.commons.io.IOUtils.closeQuietly(r2)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
        L8f:
            long r9 = r14.delayMillis     // Catch: java.lang.InterruptedException -> L94 java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.lang.Thread.sleep(r9)     // Catch: java.lang.InterruptedException -> L94 java.lang.Throwable -> La7 java.lang.Exception -> La9
        L94:
            boolean r7 = r14.run     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            if (r7 == 0) goto L38
            boolean r7 = r14.reOpen     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            if (r7 == 0) goto L38
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.io.File r9 = r14.file     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r7.<init>(r9, r8)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r7.seek(r5)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            goto L5c
        La7:
            r0 = move-exception
            goto Lb3
        La9:
            r0 = move-exception
        Laa:
            org.apache.commons.io.input.TailerListener r1 = r14.listener     // Catch: java.lang.Throwable -> La7
            r1.handle(r0)     // Catch: java.lang.Throwable -> La7
        Laf:
            org.apache.commons.io.IOUtils.closeQuietly(r2)
            return
        Lb3:
            org.apache.commons.io.IOUtils.closeQuietly(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.Tailer.run():void");
    }

    public void stop() {
        this.run = false;
    }

    public Tailer(File file, TailerListener tailerListener, long j10) {
        this(file, tailerListener, j10, false);
    }

    public Tailer(File file, TailerListener tailerListener, long j10, boolean z10) {
        this(file, tailerListener, j10, z10, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j10, boolean z10, boolean z11) {
        this(file, tailerListener, j10, z10, z11, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j10, boolean z10, int i10) {
        this(file, tailerListener, j10, z10, false, i10);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j10, boolean z10, boolean z11, int i10) {
        Tailer tailer = new Tailer(file, tailerListener, j10, z10, z11, i10);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public Tailer(File file, TailerListener tailerListener, long j10, boolean z10, boolean z11, int i10) {
        this.run = true;
        this.file = file;
        this.delayMillis = j10;
        this.end = z10;
        this.inbuf = new byte[i10];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z11;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j10, boolean z10) {
        return create(file, tailerListener, j10, z10, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j10, boolean z10, boolean z11) {
        return create(file, tailerListener, j10, z10, z11, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j10) {
        return create(file, tailerListener, j10, false);
    }

    public static Tailer create(File file, TailerListener tailerListener) {
        return create(file, tailerListener, 1000L, false);
    }
}
