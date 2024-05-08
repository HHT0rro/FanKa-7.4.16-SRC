package m5;

import androidx.annotation.IntRange;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* compiled from: BatchBuffer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h extends DecoderInputBuffer {

    /* renamed from: j, reason: collision with root package name */
    public long f51864j;

    /* renamed from: k, reason: collision with root package name */
    public int f51865k;

    /* renamed from: l, reason: collision with root package name */
    public int f51866l;

    public h() {
        super(2);
        this.f51866l = 32;
    }

    public boolean A() {
        return this.f51865k > 0;
    }

    public void B(@IntRange(from = 1) int i10) {
        com.google.android.exoplayer2.util.a.a(i10 > 0);
        this.f51866l = i10;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, z4.a
    public void h() {
        super.h();
        this.f51865k = 0;
    }

    public boolean v(DecoderInputBuffer decoderInputBuffer) {
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.s());
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.k());
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.m());
        if (!w(decoderInputBuffer)) {
            return false;
        }
        int i10 = this.f51865k;
        this.f51865k = i10 + 1;
        if (i10 == 0) {
            this.f19884f = decoderInputBuffer.f19884f;
            if (decoderInputBuffer.n()) {
                o(1);
            }
        }
        if (decoderInputBuffer.l()) {
            o(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f19882d;
        if (byteBuffer != null) {
            q(byteBuffer.remaining());
            this.f19882d.put(byteBuffer);
        }
        this.f51864j = decoderInputBuffer.f19884f;
        return true;
    }

    public final boolean w(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!A()) {
            return true;
        }
        if (this.f51865k >= this.f51866l || decoderInputBuffer.l() != l()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f19882d;
        return byteBuffer2 == null || (byteBuffer = this.f19882d) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long x() {
        return this.f19884f;
    }

    public long y() {
        return this.f51864j;
    }

    public int z() {
        return this.f51865k;
    }
}
