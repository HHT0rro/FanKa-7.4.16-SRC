package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UdpDataSource extends o6.f {

    /* renamed from: e, reason: collision with root package name */
    public final int f22757e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f22758f;

    /* renamed from: g, reason: collision with root package name */
    public final DatagramPacket f22759g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Uri f22760h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public DatagramSocket f22761i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public MulticastSocket f22762j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public InetAddress f22763k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public InetSocketAddress f22764l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22765m;

    /* renamed from: n, reason: collision with root package name */
    public int f22766n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i10) {
            super(th, i10);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws UdpDataSourceException {
        Uri uri = bVar.f22767a;
        this.f22760h = uri;
        String host = uri.getHost();
        int port = this.f22760h.getPort();
        v(bVar);
        try {
            this.f22763k = InetAddress.getByName(host);
            this.f22764l = new InetSocketAddress(this.f22763k, port);
            if (this.f22763k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.f22764l);
                this.f22762j = multicastSocket;
                multicastSocket.joinGroup(this.f22763k);
                this.f22761i = this.f22762j;
            } else {
                this.f22761i = new DatagramSocket(this.f22764l);
            }
            this.f22761i.setSoTimeout(this.f22757e);
            this.f22765m = true;
            w(bVar);
            return -1L;
        } catch (IOException e2) {
            throw new UdpDataSourceException(e2, 2001);
        } catch (SecurityException e10) {
            throw new UdpDataSourceException(e10, 2006);
        }
    }

    public int c() {
        DatagramSocket datagramSocket = this.f22761i;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        this.f22760h = null;
        MulticastSocket multicastSocket = this.f22762j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f22763k);
            } catch (IOException unused) {
            }
            this.f22762j = null;
        }
        DatagramSocket datagramSocket = this.f22761i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f22761i = null;
        }
        this.f22763k = null;
        this.f22764l = null;
        this.f22766n = 0;
        if (this.f22765m) {
            this.f22765m = false;
            u();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f22760h;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws UdpDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        if (this.f22766n == 0) {
            try {
                this.f22761i.receive(this.f22759g);
                int length = this.f22759g.getLength();
                this.f22766n = length;
                t(length);
            } catch (SocketTimeoutException e2) {
                throw new UdpDataSourceException(e2, 2002);
            } catch (IOException e10) {
                throw new UdpDataSourceException(e10, 2001);
            }
        }
        int length2 = this.f22759g.getLength();
        int i12 = this.f22766n;
        int min = Math.min(i12, i11);
        System.arraycopy((Object) this.f22758f, length2 - i12, (Object) bArr, i10, min);
        this.f22766n -= min;
        return min;
    }

    public UdpDataSource(int i10) {
        this(i10, 8000);
    }

    public UdpDataSource(int i10, int i11) {
        super(true);
        this.f22757e = i11;
        byte[] bArr = new byte[i10];
        this.f22758f = bArr;
        this.f22759g = new DatagramPacket(bArr, 0, i10);
    }
}
