package com.bytedance.pangle.e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final FileInputStream f10709a;

    /* renamed from: b, reason: collision with root package name */
    private a f10710b;

    /* renamed from: c, reason: collision with root package name */
    private b[] f10711c;

    /* renamed from: d, reason: collision with root package name */
    private c[] f10712d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, c> f10713e = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f10714a;

        /* renamed from: b, reason: collision with root package name */
        public final short f10715b;

        /* renamed from: c, reason: collision with root package name */
        public final short f10716c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10717d;

        /* renamed from: e, reason: collision with root package name */
        public final long f10718e;

        /* renamed from: f, reason: collision with root package name */
        public final long f10719f;

        /* renamed from: g, reason: collision with root package name */
        public final long f10720g;

        /* renamed from: h, reason: collision with root package name */
        public final int f10721h;

        /* renamed from: i, reason: collision with root package name */
        public final short f10722i;

        /* renamed from: j, reason: collision with root package name */
        public final short f10723j;

        /* renamed from: k, reason: collision with root package name */
        public final short f10724k;

        /* renamed from: l, reason: collision with root package name */
        public final short f10725l;

        /* renamed from: m, reason: collision with root package name */
        public final short f10726m;

        /* renamed from: n, reason: collision with root package name */
        public final short f10727n;

        public /* synthetic */ a(FileChannel fileChannel, byte b4) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.f10714a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                h.a(bArr[4], 2, "bad elf class: " + ((int) bArr[4]));
                h.a(bArr[5], 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                h.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.f10715b = allocate.getShort();
                this.f10716c = allocate.getShort();
                int i10 = allocate.getInt();
                this.f10717d = i10;
                h.a(i10, 1, "bad elf version: " + i10);
                byte b4 = bArr[4];
                if (b4 == 1) {
                    this.f10718e = allocate.getInt();
                    this.f10719f = allocate.getInt();
                    this.f10720g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f10718e = allocate.getLong();
                    this.f10719f = allocate.getLong();
                    this.f10720g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.f10721h = allocate.getInt();
                this.f10722i = allocate.getShort();
                this.f10723j = allocate.getShort();
                this.f10724k = allocate.getShort();
                this.f10725l = allocate.getShort();
                this.f10726m = allocate.getShort();
                this.f10727n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10728a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10729b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10730c;

        /* renamed from: d, reason: collision with root package name */
        public final long f10731d;

        /* renamed from: e, reason: collision with root package name */
        public final long f10732e;

        /* renamed from: f, reason: collision with root package name */
        public final long f10733f;

        /* renamed from: g, reason: collision with root package name */
        public final long f10734g;

        /* renamed from: h, reason: collision with root package name */
        public final long f10735h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i10, byte b4) {
            this(byteBuffer, i10);
        }

        private b(ByteBuffer byteBuffer, int i10) {
            if (i10 == 1) {
                this.f10728a = byteBuffer.getInt();
                this.f10730c = byteBuffer.getInt();
                this.f10731d = byteBuffer.getInt();
                this.f10732e = byteBuffer.getInt();
                this.f10733f = byteBuffer.getInt();
                this.f10734g = byteBuffer.getInt();
                this.f10729b = byteBuffer.getInt();
                this.f10735h = byteBuffer.getInt();
                return;
            }
            if (i10 == 2) {
                this.f10728a = byteBuffer.getInt();
                this.f10729b = byteBuffer.getInt();
                this.f10730c = byteBuffer.getLong();
                this.f10731d = byteBuffer.getLong();
                this.f10732e = byteBuffer.getLong();
                this.f10733f = byteBuffer.getLong();
                this.f10734g = byteBuffer.getLong();
                this.f10735h = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: ".concat(String.valueOf(i10)));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10736a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10737b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10738c;

        /* renamed from: d, reason: collision with root package name */
        public final long f10739d;

        /* renamed from: e, reason: collision with root package name */
        public final long f10740e;

        /* renamed from: f, reason: collision with root package name */
        public final long f10741f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10742g;

        /* renamed from: h, reason: collision with root package name */
        public final int f10743h;

        /* renamed from: i, reason: collision with root package name */
        public final long f10744i;

        /* renamed from: j, reason: collision with root package name */
        public final long f10745j;

        /* renamed from: k, reason: collision with root package name */
        public String f10746k;

        public /* synthetic */ c(ByteBuffer byteBuffer, int i10, byte b4) {
            this(byteBuffer, i10);
        }

        private c(ByteBuffer byteBuffer, int i10) {
            if (i10 == 1) {
                this.f10736a = byteBuffer.getInt();
                this.f10737b = byteBuffer.getInt();
                this.f10738c = byteBuffer.getInt();
                this.f10739d = byteBuffer.getInt();
                this.f10740e = byteBuffer.getInt();
                this.f10741f = byteBuffer.getInt();
                this.f10742g = byteBuffer.getInt();
                this.f10743h = byteBuffer.getInt();
                this.f10744i = byteBuffer.getInt();
                this.f10745j = byteBuffer.getInt();
            } else if (i10 == 2) {
                this.f10736a = byteBuffer.getInt();
                this.f10737b = byteBuffer.getInt();
                this.f10738c = byteBuffer.getLong();
                this.f10739d = byteBuffer.getLong();
                this.f10740e = byteBuffer.getLong();
                this.f10741f = byteBuffer.getLong();
                this.f10742g = byteBuffer.getInt();
                this.f10743h = byteBuffer.getInt();
                this.f10744i = byteBuffer.getLong();
                this.f10745j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i10)));
            }
            this.f10746k = null;
        }
    }

    private h(File file) {
        c[] cVarArr;
        this.f10710b = null;
        this.f10711c = null;
        this.f10712d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f10709a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        byte b4 = 0;
        byte b10 = 0;
        this.f10710b = new a(channel, 0 == true ? 1 : 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit((int) this.f10710b.f10723j);
        allocate.order(this.f10710b.f10714a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f10710b.f10719f);
        this.f10711c = new b[this.f10710b.f10724k];
        for (int i10 = 0; i10 < this.f10711c.length; i10++) {
            b(channel, allocate, "failed to read phdr.");
            this.f10711c[i10] = new b(allocate, this.f10710b.f10714a[4], b10 == true ? 1 : 0);
        }
        channel.position(this.f10710b.f10720g);
        allocate.limit((int) this.f10710b.f10725l);
        this.f10712d = new c[this.f10710b.f10726m];
        int i11 = 0;
        while (true) {
            cVarArr = this.f10712d;
            if (i11 >= cVarArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f10712d[i11] = new c(allocate, this.f10710b.f10714a[4], b4 == true ? 1 : 0);
            i11++;
        }
        short s2 = this.f10710b.f10727n;
        if (s2 > 0) {
            c cVar = cVarArr[s2];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) cVar.f10741f);
            this.f10709a.getChannel().position(cVar.f10740e);
            b(this.f10709a.getChannel(), allocate2, "failed to read section: " + cVar.f10746k);
            for (c cVar2 : this.f10712d) {
                allocate2.position(cVar2.f10736a);
                String a10 = a(allocate2);
                cVar2.f10746k = a10;
                this.f10713e.put(a10, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f10709a.close();
        this.f10713e.clear();
        this.f10711c = null;
        this.f10712d = null;
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public static /* synthetic */ void a(int i10, int i11, String str) {
        if (i10 <= 0 || i10 > i11) {
            throw new IOException(str);
        }
    }
}
