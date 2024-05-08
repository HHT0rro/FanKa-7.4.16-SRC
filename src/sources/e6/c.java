package e6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
import z4.e;

/* compiled from: SimpleSubtitleDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class c extends z4.f<h, i, SubtitleDecoderException> implements f {

    /* renamed from: n, reason: collision with root package name */
    public final String f48919n;

    public c(String str) {
        super(new h[2], new i[2]);
        this.f48919n = str;
        u(1024);
    }

    public abstract e A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException;

    @Override // e6.f
    public void b(long j10) {
    }

    @Override // z4.f
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final h g() {
        return new h();
    }

    @Override // z4.f
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public final i h() {
        return new d(new e.a() { // from class: e6.b
            @Override // z4.e.a
            public final void a(z4.e eVar) {
                c.this.r((i) eVar);
            }
        });
    }

    @Override // z4.f
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException i(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    @Override // z4.f
    @Nullable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException j(h hVar, i iVar, boolean z10) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(hVar.f19882d);
            iVar.q(hVar.f19884f, A(byteBuffer.array(), byteBuffer.limit(), z10), hVar.f48922j);
            iVar.i(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e2) {
            return e2;
        }
    }
}
