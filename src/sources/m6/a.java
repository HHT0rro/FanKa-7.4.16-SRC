package m6;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import e6.a;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: Mp4WebvttDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends e6.c {

    /* renamed from: o, reason: collision with root package name */
    public final ParsableByteArray f51877o;

    public a() {
        super("Mp4WebvttDecoder");
        this.f51877o = new ParsableByteArray();
    }

    public static e6.a B(ParsableByteArray parsableByteArray, int i10) throws SubtitleDecoderException {
        CharSequence charSequence = null;
        a.b bVar = null;
        while (i10 > 0) {
            if (i10 >= 8) {
                int n10 = parsableByteArray.n();
                int n11 = parsableByteArray.n();
                int i11 = n10 - 8;
                String F = j0.F(parsableByteArray.d(), parsableByteArray.e(), i11);
                parsableByteArray.Q(i11);
                i10 = (i10 - 8) - i11;
                if (n11 == 1937011815) {
                    bVar = f.o(F);
                } else if (n11 == 1885436268) {
                    charSequence = f.q(null, F.trim(), Collections.emptyList());
                }
            } else {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (bVar != null) {
            return bVar.o(charSequence).a();
        }
        return f.l(charSequence);
    }

    @Override // e6.c
    public e6.e A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        this.f51877o.N(bArr, i10);
        ArrayList arrayList = new ArrayList();
        while (this.f51877o.a() > 0) {
            if (this.f51877o.a() >= 8) {
                int n10 = this.f51877o.n();
                if (this.f51877o.n() == 1987343459) {
                    arrayList.add(B(this.f51877o, n10 - 8));
                } else {
                    this.f51877o.Q(n10 - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new b(arrayList);
    }
}
