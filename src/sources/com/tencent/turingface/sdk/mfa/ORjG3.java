package com.tencent.turingface.sdk.mfa;

import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ORjG3 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f45651a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f45652b;

    /* renamed from: c, reason: collision with root package name */
    public Process f45653c;

    /* renamed from: d, reason: collision with root package name */
    public DataOutputStream f45654d;

    /* renamed from: e, reason: collision with root package name */
    public spXPg f45655e;

    /* renamed from: f, reason: collision with root package name */
    public spXPg f45656f;

    /* renamed from: g, reason: collision with root package name */
    public ByteArrayOutputStream f45657g;

    /* renamed from: h, reason: collision with root package name */
    public ByteArrayOutputStream f45658h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ShGzN {

        /* renamed from: a, reason: collision with root package name */
        public final String f45659a;

        /* renamed from: b, reason: collision with root package name */
        public final String f45660b;

        public ShGzN(String str, String str2, long j10) {
            this.f45659a = str;
            this.f45660b = str2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SkEpO {

        /* renamed from: a, reason: collision with root package name */
        public final String f45661a;

        /* renamed from: b, reason: collision with root package name */
        public final String f45662b;

        public SkEpO(String str, String str2) {
            this.f45661a = str;
            this.f45662b = str2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public InputStream f45663a;

        /* renamed from: b, reason: collision with root package name */
        public ByteArrayOutputStream f45664b;

        public spXPg(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            this.f45663a = inputStream;
            this.f45664b = byteArrayOutputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            byte[] bArr;
            try {
                bArr = new byte[1024];
            } catch (Exception unused) {
                return;
            }
            while (true) {
                int read = this.f45663a.read(bArr);
                if (read < 0) {
                    synchronized (ORjG3.this.f45652b) {
                        this.f45664b.write(":RET=EOF".getBytes());
                        this.f45664b.flush();
                    }
                    synchronized (ORjG3.this.f45651a) {
                        ORjG3.this.f45651a.notifyAll();
                    }
                    return;
                }
                if (read > 0) {
                    synchronized (ORjG3.this.f45652b) {
                        this.f45664b.write(bArr, 0, read);
                        this.f45664b.flush();
                    }
                    synchronized (ORjG3.this.f45651a) {
                        ORjG3.this.f45651a.notifyAll();
                    }
                }
                return;
            }
        }
    }

    public ORjG3() throws IllegalArgumentException, FileNotFoundException, IOException, InterruptedException {
        boolean z10;
        Object obj = new Object();
        this.f45651a = obj;
        this.f45652b = new Object();
        this.f45657g = new ByteArrayOutputStream();
        this.f45658h = new ByteArrayOutputStream();
        this.f45653c = Runtime.getRuntime().exec("sh");
        synchronized (obj) {
            obj.wait(10L);
        }
        try {
            this.f45653c.exitValue();
            z10 = true;
        } catch (Exception unused) {
            z10 = false;
        }
        if (!z10) {
            this.f45654d = new DataOutputStream(this.f45653c.getOutputStream());
            this.f45655e = new spXPg(t.f36222g, this.f45653c.getInputStream(), this.f45657g);
            this.f45656f = new spXPg("e", this.f45653c.getErrorStream(), this.f45658h);
            synchronized (this.f45651a) {
                this.f45651a.wait(10L);
            }
            this.f45655e.start();
            this.f45656f.start();
            return;
        }
        throw new IOException();
    }

    public final SkEpO a(ShGzN shGzN, long j10) throws InterruptedException {
        boolean z10;
        synchronized (this.f45651a) {
            synchronized (this.f45652b) {
                z10 = new String(this.f45657g.toByteArray()).lastIndexOf(":RET=") == -1;
            }
            if (z10) {
                this.f45651a.wait(j10);
            }
        }
        synchronized (this.f45652b) {
            byte[] byteArray = this.f45657g.toByteArray();
            byte[] byteArray2 = this.f45658h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") == -1) {
                return null;
            }
            this.f45657g.reset();
            this.f45658h.reset();
            if (str.lastIndexOf(":RET=0") != -1) {
                return new SkEpO(str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            if (str.lastIndexOf(":RET=EOF") == -1) {
                str2.lastIndexOf(":RET=EOF");
            }
            return new SkEpO(str.substring(0, str.lastIndexOf(":RET=")), str2);
        }
    }

    public final void finalize() throws Throwable {
        try {
            a();
        } catch (Throwable unused) {
        }
        super.finalize();
    }

    public final void a() {
        try {
            this.f45654d.write("exit\n".getBytes());
            this.f45654d.flush();
            this.f45653c.wait(100L);
        } catch (Exception unused) {
        }
        spXPg spxpg = this.f45655e;
        if (spxpg != null) {
            spxpg.interrupt();
            this.f45655e = null;
        }
        spXPg spxpg2 = this.f45656f;
        if (spxpg2 != null) {
            spxpg2.interrupt();
            this.f45656f = null;
        }
        Process process = this.f45653c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable unused2) {
            }
            this.f45653c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b A[Catch: all -> 0x0095, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:9:0x000f, B:14:0x001b, B:15:0x001d, B:19:0x0029, B:20:0x004c, B:24:0x0055, B:25:0x0065, B:27:0x0077, B:35:0x007f, B:36:0x0086, B:40:0x0089, B:44:0x008c, B:45:0x008d, B:46:0x0094, B:22:0x004d, B:23:0x0054, B:17:0x001e, B:18:0x0028), top: B:2:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d A[Catch: all -> 0x0095, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:9:0x000f, B:14:0x001b, B:15:0x001d, B:19:0x0029, B:20:0x004c, B:24:0x0055, B:25:0x0065, B:27:0x0077, B:35:0x007f, B:36:0x0086, B:40:0x0089, B:44:0x008c, B:45:0x008d, B:46:0x0094, B:22:0x004d, B:23:0x0054, B:17:0x001e, B:18:0x0028), top: B:2:0x0001, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.tencent.turingface.sdk.mfa.ORjG3.SkEpO a(com.tencent.turingface.sdk.mfa.ORjG3.ShGzN r9) throws java.lang.IllegalArgumentException, java.io.IOException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r9.f45659a     // Catch: java.lang.Throwable -> L95
            if (r0 == 0) goto L18
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L95
            if (r0 <= 0) goto L18
            java.lang.String r0 = r9.f45660b     // Catch: java.lang.Throwable -> L95
            if (r0 == 0) goto L18
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L95
            if (r0 > 0) goto L16
            goto L18
        L16:
            r0 = 0
            goto L19
        L18:
            r0 = 1
        L19:
            if (r0 != 0) goto L8d
            java.lang.Object r0 = r8.f45652b     // Catch: java.lang.Throwable -> L95
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L95
            java.io.ByteArrayOutputStream r1 = r8.f45657g     // Catch: java.lang.Throwable -> L8a
            r1.reset()     // Catch: java.lang.Throwable -> L8a
            java.io.ByteArrayOutputStream r1 = r8.f45658h     // Catch: java.lang.Throwable -> L8a
            r1.reset()     // Catch: java.lang.Throwable -> L8a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r0.<init>()     // Catch: java.lang.Throwable -> L95
            java.lang.String r1 = r9.f45660b     // Catch: java.lang.Throwable -> L95
            r0.append(r1)     // Catch: java.lang.Throwable -> L95
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L95
            java.io.DataOutputStream r1 = r8.f45654d     // Catch: java.lang.Throwable -> L95
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L95
            r1.write(r0)     // Catch: java.lang.Throwable -> L95
            java.io.DataOutputStream r0 = r8.f45654d     // Catch: java.lang.Throwable -> L95
            r0.flush()     // Catch: java.lang.Throwable -> L95
            java.lang.Object r0 = r8.f45651a     // Catch: java.lang.Throwable -> L95
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L95
            java.lang.Object r1 = r8.f45651a     // Catch: java.lang.Throwable -> L87
            r2 = 10
            r1.wait(r2)     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            java.io.DataOutputStream r0 = r8.f45654d     // Catch: java.lang.Throwable -> L95
            java.lang.String r1 = "echo :RET=$?\n"
            r0.writeBytes(r1)     // Catch: java.lang.Throwable -> L95
            java.io.DataOutputStream r0 = r8.f45654d     // Catch: java.lang.Throwable -> L95
            r0.flush()     // Catch: java.lang.Throwable -> L95
            long r0 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L95
        L65:
            r2 = 5000(0x1388, double:2.4703E-320)
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L95
            long r4 = r4 - r0
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r6
            long r2 = r2 - r4
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L7f
            com.tencent.turingface.sdk.mfa.ORjG3$SkEpO r2 = r8.a(r9, r2)     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L65
            monitor-exit(r8)
            return r2
        L7f:
            java.util.concurrent.TimeoutException r9 = new java.util.concurrent.TimeoutException     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = "t"
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L95
            throw r9     // Catch: java.lang.Throwable -> L95
        L87:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            throw r9     // Catch: java.lang.Throwable -> L95
        L8a:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8a
            throw r9     // Catch: java.lang.Throwable -> L95
        L8d:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = "v"
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L95
            throw r9     // Catch: java.lang.Throwable -> L95
        L95:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.ORjG3.a(com.tencent.turingface.sdk.mfa.ORjG3$ShGzN):com.tencent.turingface.sdk.mfa.ORjG3$SkEpO");
    }
}
