package n5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;

/* compiled from: SimpleMetadataDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f implements b {
    @Override // n5.b
    @Nullable
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(dVar.f19882d);
        com.google.android.exoplayer2.util.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (dVar.l()) {
            return null;
        }
        return b(dVar, byteBuffer);
    }

    @Nullable
    public abstract Metadata b(d dVar, ByteBuffer byteBuffer);
}
