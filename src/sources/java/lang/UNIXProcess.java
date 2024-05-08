package java.lang;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ProcessBuilder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class UNIXProcess extends Process {
    private static final Executor processReaperExecutor = (Executor) AccessController.doPrivileged(new PrivilegedAction<Executor>() { // from class: java.lang.UNIXProcess.1
        @Override // java.security.PrivilegedAction
        public Executor run() {
            return Executors.newCachedThreadPool(new ProcessReaperThreadFactory());
        }
    });
    private int exitcode;
    private boolean hasExited;
    private final int pid;
    private InputStream stderr;
    private OutputStream stdin;
    private InputStream stdout;

    private static native void destroyProcess(int i10);

    private native int forkAndExec(byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, int i11, byte[] bArr4, int[] iArr, boolean z10) throws IOException;

    private static native void initIDs();

    /* JADX INFO: Access modifiers changed from: private */
    public native int waitForProcessExit(int i10);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ProcessReaperThreadFactory implements ThreadFactory {
        private static final ThreadGroup group = getRootThreadGroup();

        private ProcessReaperThreadFactory() {
        }

        private static ThreadGroup getRootThreadGroup() {
            return (ThreadGroup) AccessController.doPrivileged(new PrivilegedAction<ThreadGroup>() { // from class: java.lang.UNIXProcess.ProcessReaperThreadFactory.1
                @Override // java.security.PrivilegedAction
                public ThreadGroup run() {
                    ThreadGroup root = Thread.currentThread().getThreadGroup();
                    while (root.getParent() != null) {
                        root = root.getParent();
                    }
                    return root;
                }
            });
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable grimReaper) {
            Thread t2 = new Thread(group, grimReaper, "process reaper", PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
            t2.setDaemon(true);
            t2.setPriority(10);
            return t2;
        }
    }

    static {
        initIDs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UNIXProcess(byte[] prog, byte[] argBlock, int argc, byte[] envBlock, int envc, byte[] dir, final int[] fds, boolean redirectErrorStream) throws IOException {
        this.pid = forkAndExec(prog, argBlock, argc, envBlock, envc, dir, fds, redirectErrorStream);
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.lang.UNIXProcess.2
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    UNIXProcess.this.initStreams(fds);
                    return null;
                }
            });
        } catch (PrivilegedActionException ex) {
            throw ((IOException) ex.getException());
        }
    }

    static FileDescriptor newFileDescriptor(int fd2) {
        FileDescriptor fileDescriptor = new FileDescriptor();
        fileDescriptor.setInt$(fd2);
        return fileDescriptor;
    }

    void initStreams(int[] fds) throws IOException {
        OutputStream processPipeOutputStream;
        InputStream processPipeInputStream;
        InputStream processPipeInputStream2;
        if (fds[0] == -1) {
            processPipeOutputStream = ProcessBuilder.NullOutputStream.INSTANCE;
        } else {
            processPipeOutputStream = new ProcessPipeOutputStream(fds[0]);
        }
        this.stdin = processPipeOutputStream;
        if (fds[1] == -1) {
            processPipeInputStream = ProcessBuilder.NullInputStream.INSTANCE;
        } else {
            processPipeInputStream = new ProcessPipeInputStream(fds[1]);
        }
        this.stdout = processPipeInputStream;
        if (fds[2] == -1) {
            processPipeInputStream2 = ProcessBuilder.NullInputStream.INSTANCE;
        } else {
            processPipeInputStream2 = new ProcessPipeInputStream(fds[2]);
        }
        this.stderr = processPipeInputStream2;
        processReaperExecutor.execute(new Runnable() { // from class: java.lang.UNIXProcess.3
            @Override // java.lang.Runnable
            public void run() {
                UNIXProcess uNIXProcess = UNIXProcess.this;
                int exitcode = uNIXProcess.waitForProcessExit(uNIXProcess.pid);
                UNIXProcess.this.processExited(exitcode);
            }
        });
    }

    void processExited(int exitcode) {
        synchronized (this) {
            this.exitcode = exitcode;
            this.hasExited = true;
            notifyAll();
        }
        InputStream inputStream = this.stdout;
        if (inputStream instanceof ProcessPipeInputStream) {
            ((ProcessPipeInputStream) inputStream).processExited();
        }
        InputStream inputStream2 = this.stderr;
        if (inputStream2 instanceof ProcessPipeInputStream) {
            ((ProcessPipeInputStream) inputStream2).processExited();
        }
        OutputStream outputStream = this.stdin;
        if (outputStream instanceof ProcessPipeOutputStream) {
            ((ProcessPipeOutputStream) outputStream).processExited();
        }
    }

    @Override // java.lang.Process
    public OutputStream getOutputStream() {
        return this.stdin;
    }

    @Override // java.lang.Process
    public InputStream getInputStream() {
        return this.stdout;
    }

    @Override // java.lang.Process
    public InputStream getErrorStream() {
        return this.stderr;
    }

    @Override // java.lang.Process
    public synchronized int waitFor() throws InterruptedException {
        while (!this.hasExited) {
            wait();
        }
        return this.exitcode;
    }

    @Override // java.lang.Process
    public synchronized int exitValue() {
        if (!this.hasExited) {
            throw new IllegalThreadStateException("process hasn't exited");
        }
        return this.exitcode;
    }

    @Override // java.lang.Process
    public void destroy() {
        synchronized (this) {
            if (!this.hasExited) {
                destroyProcess(this.pid);
            }
        }
        try {
            this.stdin.close();
        } catch (IOException e2) {
        }
        try {
            this.stdout.close();
        } catch (IOException e10) {
        }
        try {
            this.stderr.close();
        } catch (IOException e11) {
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Process[pid=");
        sb2.append(this.pid);
        if (this.hasExited) {
            sb2.append(" ,hasExited=true, exitcode=");
            sb2.append(this.exitcode);
            sb2.append("]");
        } else {
            sb2.append(", hasExited=false]");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ProcessPipeInputStream extends BufferedInputStream {
        ProcessPipeInputStream(int fd2) {
            super(new FileInputStream(UNIXProcess.newFileDescriptor(fd2), true));
        }

        private static byte[] drainInputStream(InputStream in) throws IOException {
            if (in == null) {
                return null;
            }
            int n10 = 0;
            byte[] a10 = null;
            while (true) {
                int j10 = in.available();
                if (j10 <= 0) {
                    break;
                }
                a10 = a10 == null ? new byte[j10] : Arrays.copyOf(a10, n10 + j10);
                n10 += in.read(a10, n10, j10);
            }
            return (a10 == null || n10 == a10.length) ? a10 : Arrays.copyOf(a10, n10);
        }

        synchronized void processExited() {
            InputStream byteArrayInputStream;
            try {
                InputStream in = this.in;
                if (in != null) {
                    try {
                        byte[] stragglers = drainInputStream(in);
                        in.close();
                        if (stragglers == null) {
                            byteArrayInputStream = ProcessBuilder.NullInputStream.INSTANCE;
                        } else {
                            byteArrayInputStream = new ByteArrayInputStream(stragglers);
                        }
                        this.in = byteArrayInputStream;
                        if (this.buf == null) {
                            this.in = null;
                        }
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ProcessPipeOutputStream extends BufferedOutputStream {
        ProcessPipeOutputStream(int fd2) {
            super(new FileOutputStream(UNIXProcess.newFileDescriptor(fd2), true));
        }

        synchronized void processExited() {
            OutputStream out = this.out;
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e2) {
                }
                this.out = ProcessBuilder.NullOutputStream.INSTANCE;
            }
        }
    }
}
