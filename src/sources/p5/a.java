package p5;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.Arrays;
import n5.d;
import n5.f;

/* compiled from: EventMessageDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends f {
    @Override // n5.f
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        return new Metadata(c(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(ParsableByteArray parsableByteArray) {
        return new EventMessage((String) com.google.android.exoplayer2.util.a.e(parsableByteArray.x()), (String) com.google.android.exoplayer2.util.a.e(parsableByteArray.x()), parsableByteArray.w(), parsableByteArray.w(), Arrays.copyOfRange(parsableByteArray.d(), parsableByteArray.e(), parsableByteArray.f()));
    }
}
