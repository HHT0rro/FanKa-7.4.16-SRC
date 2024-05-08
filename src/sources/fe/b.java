package fe;

import org.jetbrains.annotations.NotNull;

/* compiled from: Dispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b extends e {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final b f49326h = new b();

    public b() {
        super(k.f49338b, k.f49339c, k.f49340d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }
}
