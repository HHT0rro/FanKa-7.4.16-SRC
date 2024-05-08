package java.util.zip;

import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Checksum {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.zip.Checksum$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ boolean $assertionsDisabled = false;
    }

    long getValue();

    void reset();

    void update(int i10);

    void update(byte[] bArr, int i10, int i11);

    static {
        boolean z10 = AnonymousClass1.$assertionsDisabled;
    }

    default void update(byte[] b4) {
        update(b4, 0, b4.length);
    }

    default void update(ByteBuffer buffer) {
        int pos = buffer.position();
        int limit = buffer.limit();
        if (!AnonymousClass1.$assertionsDisabled && pos > limit) {
            throw new AssertionError();
        }
        int rem = limit - pos;
        if (rem <= 0) {
            return;
        }
        if (buffer.hasArray()) {
            update(buffer.array(), buffer.arrayOffset() + pos, rem);
        } else {
            byte[] b4 = new byte[Math.min(buffer.remaining(), 4096)];
            while (buffer.hasRemaining()) {
                int length = Math.min(buffer.remaining(), b4.length);
                buffer.get(b4, 0, length);
                update(b4, 0, length);
            }
        }
        buffer.position(limit);
    }
}
