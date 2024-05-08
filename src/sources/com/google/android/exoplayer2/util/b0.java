package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.android.internal.os.PowerProfile;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* compiled from: SntpClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f22953a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f22954b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("valueLock")
    public static boolean f22955c = false;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("valueLock")
    public static long f22956d = 0;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("valueLock")
    public static String f22957e = "time.android.com";

    /* compiled from: SntpClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(IOException iOException);

        void b();
    }

    /* compiled from: SntpClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Loader.b<Loader.e> {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final b f22958b;

        public c(@Nullable b bVar) {
            this.f22958b = bVar;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void n(Loader.e eVar, long j10, long j11, boolean z10) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void o(Loader.e eVar, long j10, long j11) {
            if (this.f22958b != null) {
                if (!b0.k()) {
                    this.f22958b.a(new IOException(new ConcurrentModificationException()));
                } else {
                    this.f22958b.b();
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public Loader.c q(Loader.e eVar, long j10, long j11, IOException iOException, int i10) {
            b bVar = this.f22958b;
            if (bVar != null) {
                bVar.a(iOException);
            }
            return Loader.f22732f;
        }
    }

    /* compiled from: SntpClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements Loader.e {
        public d() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void load() throws IOException {
            synchronized (b0.f22953a) {
                synchronized (b0.f22954b) {
                    if (b0.f22955c) {
                        return;
                    }
                    long e2 = b0.e();
                    synchronized (b0.f22954b) {
                        long unused = b0.f22956d = e2;
                        boolean unused2 = b0.f22955c = true;
                    }
                }
            }
        }
    }

    public static /* synthetic */ long e() throws IOException {
        return l();
    }

    public static void g(byte b4, byte b10, int i10, long j10) throws IOException {
        if (b4 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b10 != 4 && b10 != 5) {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("SNTP: Untrusted mode: ");
            sb2.append((int) b10);
            throw new IOException(sb2.toString());
        }
        if (i10 != 0 && i10 <= 15) {
            if (j10 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            StringBuilder sb3 = new StringBuilder(36);
            sb3.append("SNTP: Untrusted stratum: ");
            sb3.append(i10);
            throw new IOException(sb3.toString());
        }
    }

    public static long h() {
        long j10;
        synchronized (f22954b) {
            j10 = f22955c ? f22956d : -9223372036854775807L;
        }
        return j10;
    }

    public static String i() {
        String str;
        synchronized (f22954b) {
            str = f22957e;
        }
        return str;
    }

    public static void j(@Nullable Loader loader, @Nullable b bVar) {
        if (k()) {
            if (bVar != null) {
                bVar.b();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.n(new d(), new c(bVar), 1);
        }
    }

    public static boolean k() {
        boolean z10;
        synchronized (f22954b) {
            z10 = f22955c;
        }
        return z10;
    }

    public static long l() throws IOException {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            o(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j10 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b4 = (byte) ((bArr[0] >> 6) & 3);
            byte b10 = (byte) (bArr[0] & 7);
            int i10 = bArr[1] & 255;
            long n10 = n(bArr, 24);
            long n11 = n(bArr, 32);
            long n12 = n(bArr, 40);
            g(b4, b10, i10, n12);
            long j11 = (j10 + (((n11 - n10) + (n12 - j10)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j11;
        } catch (Throwable th) {
            try {
                datagramSocket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long m(byte[] bArr, int i10) {
        int i11 = bArr[i10];
        int i12 = bArr[i10 + 1];
        int i13 = bArr[i10 + 2];
        int i14 = bArr[i10 + 3];
        if ((i11 & 128) == 128) {
            i11 = (i11 & 127) + 128;
        }
        if ((i12 & 128) == 128) {
            i12 = (i12 & 127) + 128;
        }
        if ((i13 & 128) == 128) {
            i13 = (i13 & 127) + 128;
        }
        if ((i14 & 128) == 128) {
            i14 = (i14 & 127) + 128;
        }
        return (i11 << 24) + (i12 << 16) + (i13 << 8) + i14;
    }

    public static long n(byte[] bArr, int i10) {
        long m10 = m(bArr, i10);
        long m11 = m(bArr, i10 + 4);
        if (m10 == 0 && m11 == 0) {
            return 0L;
        }
        return ((m10 - 2208988800L) * 1000) + ((m11 * 1000) / PowerProfile.SUBSYSTEM_MODEM);
    }

    public static void o(byte[] bArr, int i10, long j10) {
        if (j10 == 0) {
            Arrays.fill(bArr, i10, i10 + 8, (byte) 0);
            return;
        }
        long j11 = j10 / 1000;
        long j12 = j10 - (j11 * 1000);
        long j13 = j11 + 2208988800L;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (j13 >> 24);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j13 >> 16);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (j13 >> 8);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (j13 >> 0);
        long j14 = (j12 * PowerProfile.SUBSYSTEM_MODEM) / 1000;
        int i15 = i14 + 1;
        bArr[i14] = (byte) (j14 >> 24);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (j14 >> 16);
        bArr[i16] = (byte) (j14 >> 8);
        bArr[i16 + 1] = (byte) (Math.random() * 255.0d);
    }
}
