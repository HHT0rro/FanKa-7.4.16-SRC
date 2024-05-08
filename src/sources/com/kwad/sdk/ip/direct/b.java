package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bn;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static Handler aIn = new Handler(Looper.getMainLooper());
    public static int aIx = 80;
    public static int port = 80;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends Thread {
        public LinkedList aIz = new LinkedList();
        public volatile boolean aIA = false;
        public Selector aIy = Selector.open();

        public a() {
            setName("Connector");
        }

        private void IN() {
            synchronized (this.aIz) {
                while (this.aIz.size() > 0) {
                    C0539b c0539b = (C0539b) this.aIz.removeFirst();
                    try {
                        c0539b.aIE.register(this.aIy, 8, c0539b);
                    } catch (Throwable th) {
                        c0539b.aIE.close();
                        c0539b.aIF = th;
                    }
                }
            }
        }

        private void IO() {
            Iterator<SelectionKey> iterator2 = this.aIy.selectedKeys().iterator2();
            while (iterator2.hasNext()) {
                SelectionKey next = iterator2.next();
                iterator2.remove();
                C0539b c0539b = (C0539b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0539b.aIJ = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bn.c(socketChannel);
                    c0539b.aIF = th;
                }
            }
        }

        public final void a(C0539b c0539b) {
            final SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
            } catch (Throwable th) {
                th = th;
                socketChannel = null;
            }
            try {
                socketChannel.configureBlocking(false);
                boolean connect = socketChannel.connect(c0539b.aID);
                c0539b.aIE = socketChannel;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                c0539b.aII = elapsedRealtime;
                if (connect) {
                    c0539b.aIJ = elapsedRealtime;
                    bn.c(socketChannel);
                } else {
                    synchronized (this.aIz) {
                        this.aIz.add(c0539b);
                    }
                    Selector selector = this.aIy;
                    if (selector != null) {
                        try {
                            selector.wakeup();
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    bn.c(socketChannel);
                    c0539b.aIF = th;
                    try {
                        b.aIn.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bn.c(socketChannel);
                            }
                        }, c0539b.aIH);
                    } catch (Throwable unused2) {
                    }
                } finally {
                    try {
                        b.aIn.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bn.c(socketChannel);
                            }
                        }, c0539b.aIH);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aIy.select() > 0) {
                        IO();
                    }
                    IN();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.aIA) {
                    Selector selector = this.aIy;
                    if (selector != null) {
                        try {
                            selector.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        public final void shutdown() {
            this.aIA = true;
            Selector selector = this.aIy;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0539b {
        public InetSocketAddress aID;
        public SocketChannel aIE;
        public Throwable aIF;
        private float aIG;
        public long aIH;
        public long aII;
        public long aIJ = 0;
        public boolean aIK = false;
        private boolean success;

        public C0539b(String str) {
            try {
                this.aID = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aIF = th;
            }
        }

        public final void IP() {
            String str;
            if (this.aIJ != 0) {
                str = Long.toString(this.aIJ - this.aII) + "ms";
                this.aIG = (float) (this.aIJ - this.aII);
                this.success = true;
            } else {
                Throwable th = this.aIF;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.e.c.d("IpDirect_Ping", ((Object) this.aID) + " : " + str);
            this.aIK = true;
        }
    }

    public static c f(String str, long j10) {
        a aVar;
        long j11 = j10 / 5;
        com.kwad.sdk.core.e.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i10 = 0; i10 < cVar.IQ(); i10++) {
                C0539b c0539b = new C0539b(str);
                c0539b.aIH = j10 + j11;
                linkedList.add(c0539b);
                try {
                    aVar.a(c0539b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j10 + j11);
                try {
                    aVar.shutdown();
                    aVar.join();
                    float f10 = 0.0f;
                    Iterator<E> it = linkedList.iterator2();
                    boolean z10 = true;
                    while (it.hasNext()) {
                        C0539b c0539b2 = (C0539b) it.next();
                        c0539b2.IP();
                        z10 &= c0539b2.success;
                        cVar.bC(z10);
                        f10 += c0539b2.aIG;
                    }
                    com.kwad.sdk.core.e.c.d("IpDirect_Ping", "sum:" + f10 + "*size:" + linkedList.size());
                    cVar.i(f10 / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
