package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReadWrite.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j implements kotlin.sequences.g<String> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final BufferedReader f50975a;

    /* compiled from: ReadWrite.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<String>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public String f50976b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f50977c;

        public a() {
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (hasNext()) {
                String str = this.f50976b;
                this.f50976b = null;
                s.f(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f50976b == null && !this.f50977c) {
                String readLine = j.this.f50975a.readLine();
                this.f50976b = readLine;
                if (readLine == null) {
                    this.f50977c = true;
                }
            }
            return this.f50976b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public j(@NotNull BufferedReader reader) {
        s.i(reader, "reader");
        this.f50975a = reader;
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<String> iterator() {
        return new a();
    }
}
