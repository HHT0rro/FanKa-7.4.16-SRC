package h4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: ByteBufferWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f49496a;

    public a() {
        c(10240);
    }

    public int a() {
        return this.f49496a.position();
    }

    public void b(byte b4) {
        this.f49496a.put(b4);
    }

    public void c(int i10) {
        ByteBuffer byteBuffer = this.f49496a;
        if (byteBuffer == null || i10 > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i10);
            this.f49496a = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f49496a.clear();
    }

    @Override // h4.f
    public void close() {
    }

    public void d(int i10) {
        this.f49496a.position(i10 + a());
    }

    public byte[] e() {
        return this.f49496a.array();
    }
}
