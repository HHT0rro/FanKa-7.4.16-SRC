package z4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

/* compiled from: Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface c<I, O, E extends DecoderException> {
    @Nullable
    I a() throws DecoderException;

    @Nullable
    O c() throws DecoderException;

    void d(I i10) throws DecoderException;

    void flush();

    void release();
}
