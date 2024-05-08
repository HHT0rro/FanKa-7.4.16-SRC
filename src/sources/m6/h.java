package m6;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;

/* compiled from: WebvttDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h extends e6.c {

    /* renamed from: o, reason: collision with root package name */
    public final ParsableByteArray f51928o;

    /* renamed from: p, reason: collision with root package name */
    public final c f51929p;

    public h() {
        super("WebvttDecoder");
        this.f51928o = new ParsableByteArray();
        this.f51929p = new c();
    }

    public static int B(ParsableByteArray parsableByteArray) {
        int i10 = -1;
        int i11 = 0;
        while (i10 == -1) {
            i11 = parsableByteArray.e();
            String p10 = parsableByteArray.p();
            if (p10 == null) {
                i10 = 0;
            } else if ("STYLE".equals(p10)) {
                i10 = 2;
            } else {
                i10 = p10.startsWith("NOTE") ? 1 : 3;
            }
        }
        parsableByteArray.P(i11);
        return i10;
    }

    public static void C(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.p()));
    }

    @Override // e6.c
    public e6.e A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        e m10;
        this.f51928o.N(bArr, i10);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.f51928o);
            do {
            } while (!TextUtils.isEmpty(this.f51928o.p()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int B = B(this.f51928o);
                if (B == 0) {
                    return new k(arrayList2);
                }
                if (B == 1) {
                    C(this.f51928o);
                } else if (B == 2) {
                    if (arrayList2.isEmpty()) {
                        this.f51928o.p();
                        arrayList.addAll(this.f51929p.d(this.f51928o));
                    } else {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                } else if (B == 3 && (m10 = f.m(this.f51928o, arrayList)) != null) {
                    arrayList2.add(m10);
                }
            }
        } catch (ParserException e2) {
            throw new SubtitleDecoderException(e2);
        }
    }
}
