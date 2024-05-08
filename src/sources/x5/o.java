package x5;

import java.util.NoSuchElementException;

/* compiled from: MediaChunkIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f54558a = new a();

    /* compiled from: MediaChunkIterator.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements o {
        @Override // x5.o
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // x5.o
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // x5.o
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
