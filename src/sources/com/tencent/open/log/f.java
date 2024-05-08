package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f implements Iterable<String> {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f45269a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f45270b;

    public f() {
        this.f45269a = null;
        this.f45270b = null;
        this.f45269a = new ConcurrentLinkedQueue<>();
        this.f45270b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f45269a.add(str);
        return this.f45270b.addAndGet(length);
    }

    public void b() {
        this.f45269a.clear();
        this.f45270b.set(0);
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<String> iterator2() {
        return this.f45269a.iterator2();
    }

    public void a(Writer[] writerArr, char[] cArr) throws IOException {
        if (writerArr == null || cArr == null || cArr.length == 0 || writerArr.length < 2) {
            return;
        }
        Writer writer = writerArr[0];
        Writer writer2 = writerArr[1];
        int length = cArr.length;
        Iterator<String> iterator2 = iterator2();
        int i10 = length;
        int i11 = 0;
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            int length2 = next.length();
            int i12 = 0;
            while (length2 > 0) {
                int i13 = i10 > length2 ? length2 : i10;
                int i14 = i12 + i13;
                next.getChars(i12, i14, cArr, i11);
                i10 -= i13;
                i11 += i13;
                length2 -= i13;
                if (i10 == 0) {
                    if (writer != null) {
                        try {
                            writer.write(cArr, 0, length);
                        } catch (Exception unused) {
                        }
                    }
                    if (writer2 != null) {
                        try {
                            writer2.write(cArr, 0, length);
                        } catch (Exception unused2) {
                        }
                    }
                    i10 = length;
                    i12 = i14;
                    i11 = 0;
                } else {
                    i12 = i14;
                }
            }
        }
        if (i11 > 0) {
            if (writer != null) {
                try {
                    writer.write(cArr, 0, i11);
                } catch (Exception unused3) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.write(cArr, 0, i11);
                } catch (Exception unused4) {
                }
            }
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (Exception unused5) {
            }
        }
        if (writer2 != null) {
            try {
                writer2.flush();
            } catch (Exception unused6) {
            }
        }
    }

    public int a() {
        return this.f45270b.get();
    }
}
