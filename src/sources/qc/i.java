package qc;

import com.facebook.soloader.MinElf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ElfParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public final int f53212b = MinElf.ELF_MAGIC;

    /* renamed from: c, reason: collision with root package name */
    public final FileChannel f53213c;

    public i(File file) {
        if (file != null && file.exists()) {
            this.f53213c = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public final long a(d dVar, long j10, long j11) {
        for (long j12 = 0; j12 < j10; j12++) {
            e b4 = dVar.b(j12);
            if (b4.f53205a == 1) {
                long j13 = b4.f53207c;
                if (j13 <= j11 && j11 <= b4.f53208d + j13) {
                    return (j11 - j13) + b4.f53206b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d b() {
        this.f53213c.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (k(allocate, 0L) == 1179403647) {
            short d10 = d(allocate, 4L);
            boolean z10 = d(allocate, 5L) == 2;
            if (d10 == 1) {
                return new g(z10, this);
            }
            if (d10 == 2) {
                return new h(z10, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f53213c.close();
    }

    public short d(ByteBuffer byteBuffer, long j10) {
        e(byteBuffer, j10, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public void e(ByteBuffer byteBuffer, long j10, int i10) {
        byteBuffer.position(0);
        byteBuffer.limit(i10);
        long j11 = 0;
        while (j11 < i10) {
            int read = this.f53213c.read(byteBuffer, j10 + j11);
            if (read == -1) {
                throw new EOFException();
            }
            j11 += read;
        }
        byteBuffer.position(0);
    }

    public int f(ByteBuffer byteBuffer, long j10) {
        e(byteBuffer, j10, 2);
        return byteBuffer.getShort() & 65535;
    }

    public List<String> g() {
        long j10;
        this.f53213c.position(0L);
        ArrayList arrayList = new ArrayList();
        d b4 = b();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(b4.f53196a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = b4.f53201f;
        int i10 = 0;
        if (j11 == 65535) {
            j11 = b4.c(0).f53209a;
        }
        long j12 = 0;
        while (true) {
            if (j12 >= j11) {
                j10 = 0;
                break;
            }
            e b10 = b4.b(j12);
            if (b10.f53205a == 2) {
                j10 = b10.f53206b;
                break;
            }
            j12++;
        }
        if (j10 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j13 = 0;
        while (true) {
            c a10 = b4.a(j10, i10);
            long j14 = j10;
            long j15 = a10.f53194a;
            if (j15 == 1) {
                arrayList2.add(Long.valueOf(a10.f53195b));
            } else if (j15 == 5) {
                j13 = a10.f53195b;
            }
            i10++;
            if (a10.f53194a == 0) {
                break;
            }
            j10 = j14;
        }
        if (j13 != 0) {
            long a11 = a(b4, j11, j13);
            Iterator<E> iterator2 = arrayList2.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(j(allocate, ((Long) iterator2.next()).longValue() + a11));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    public long i(ByteBuffer byteBuffer, long j10) {
        e(byteBuffer, j10, 8);
        return byteBuffer.getLong();
    }

    public String j(ByteBuffer byteBuffer, long j10) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j11 = 1 + j10;
            short d10 = d(byteBuffer, j10);
            if (d10 != 0) {
                sb2.append((char) d10);
                j10 = j11;
            } else {
                return sb2.toString();
            }
        }
    }

    public long k(ByteBuffer byteBuffer, long j10) {
        e(byteBuffer, j10, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
