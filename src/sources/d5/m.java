package d5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import r5.b;

/* compiled from: Id3Peeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f48641a = new ParsableByteArray(10);

    @Nullable
    public Metadata a(d dVar, @Nullable b.a aVar) throws IOException {
        Metadata metadata = null;
        int i10 = 0;
        while (true) {
            try {
                dVar.j(this.f48641a.d(), 0, 10);
                this.f48641a.P(0);
                if (this.f48641a.G() != 4801587) {
                    break;
                }
                this.f48641a.Q(3);
                int C = this.f48641a.C();
                int i11 = C + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy((Object) this.f48641a.d(), 0, (Object) bArr, 0, 10);
                    dVar.j(bArr, 10, C);
                    metadata = new r5.b(aVar).e(bArr, i11);
                } else {
                    dVar.q(C);
                }
                i10 += i11;
            } catch (EOFException unused) {
            }
        }
        dVar.m();
        dVar.q(i10);
        return metadata;
    }
}
