package t5;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import n5.d;
import n5.f;

/* compiled from: SpliceInfoDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f53766a = new ParsableByteArray();

    /* renamed from: b, reason: collision with root package name */
    public final u f53767b = new u();

    /* renamed from: c, reason: collision with root package name */
    public f0 f53768c;

    @Override // n5.f
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        f0 f0Var = this.f53768c;
        if (f0Var == null || dVar.f52128j != f0Var.e()) {
            f0 f0Var2 = new f0(dVar.f19884f);
            this.f53768c = f0Var2;
            f0Var2.a(dVar.f19884f - dVar.f52128j);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f53766a.N(array, limit);
        this.f53767b.o(array, limit);
        this.f53767b.r(39);
        long h10 = (this.f53767b.h(1) << 32) | this.f53767b.h(32);
        this.f53767b.r(20);
        int h11 = this.f53767b.h(12);
        int h12 = this.f53767b.h(8);
        Metadata.Entry entry = null;
        this.f53766a.Q(14);
        if (h12 == 0) {
            entry = new SpliceNullCommand();
        } else if (h12 == 255) {
            entry = PrivateCommand.a(this.f53766a, h11, h10);
        } else if (h12 == 4) {
            entry = SpliceScheduleCommand.a(this.f53766a);
        } else if (h12 == 5) {
            entry = SpliceInsertCommand.a(this.f53766a, h10, this.f53768c);
        } else if (h12 == 6) {
            entry = TimeSignalCommand.a(this.f53766a, h10, this.f53768c);
        }
        return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
    }
}
