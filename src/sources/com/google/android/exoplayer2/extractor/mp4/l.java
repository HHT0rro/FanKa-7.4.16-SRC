package com.google.android.exoplayer2.extractor.mp4;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.base.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SefReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l {

    /* renamed from: d, reason: collision with root package name */
    public static final q f20219d = q.e(ShortcutConstants.SERVICES_SEPARATOR);

    /* renamed from: e, reason: collision with root package name */
    public static final q f20220e = q.e('*');

    /* renamed from: a, reason: collision with root package name */
    public final List<a> f20221a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f20222b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f20223c;

    /* compiled from: SefReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f20224a;

        /* renamed from: b, reason: collision with root package name */
        public final long f20225b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20226c;

        public a(int i10, long j10, int i11) {
            this.f20224a = i10;
            this.f20225b = j10;
            this.f20226c = i11;
        }
    }

    public static int b(String str) throws ParserException {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1711564334:
                if (str.equals("SlowMotion_Data")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1332107749:
                if (str.equals("Super_SlowMotion_Edit_Data")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals("Super_SlowMotion_Data")) {
                    c4 = 2;
                    break;
                }
                break;
            case -830665521:
                if (str.equals("Super_SlowMotion_Deflickering_On")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals("Super_SlowMotion_BGM")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 2192;
            case 1:
                return 2819;
            case 2:
                return 2816;
            case 3:
                return 2820;
            case 4:
                return 2817;
            default:
                throw ParserException.createForMalformedContainer("Invalid SEF name", null);
        }
    }

    public static SlowMotionData f(ParsableByteArray parsableByteArray, int i10) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> h10 = f20220e.h(parsableByteArray.A(i10));
        for (int i11 = 0; i11 < h10.size(); i11++) {
            List<String> h11 = f20219d.h(h10.get(i11));
            if (h11.size() == 3) {
                try {
                    arrayList.add(new SlowMotionData.Segment(Long.parseLong(h11.get(0)), Long.parseLong(h11.get(1)), 1 << (Integer.parseInt(h11.get(2)) - 1)));
                } catch (NumberFormatException e2) {
                    throw ParserException.createForMalformedContainer(null, e2);
                }
            } else {
                throw ParserException.createForMalformedContainer(null, null);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public final void a(d5.d dVar, d5.n nVar) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        dVar.readFully(parsableByteArray.d(), 0, 8);
        this.f20223c = parsableByteArray.q() + 8;
        if (parsableByteArray.n() != 1397048916) {
            nVar.f48642a = 0L;
        } else {
            nVar.f48642a = dVar.getPosition() - (this.f20223c - 12);
            this.f20222b = 2;
        }
    }

    public int c(d5.d dVar, d5.n nVar, List<Metadata.Entry> list) throws IOException {
        int i10 = this.f20222b;
        long j10 = 0;
        if (i10 == 0) {
            long b4 = dVar.b();
            if (b4 != -1 && b4 >= 8) {
                j10 = b4 - 8;
            }
            nVar.f48642a = j10;
            this.f20222b = 1;
        } else if (i10 == 1) {
            a(dVar, nVar);
        } else if (i10 == 2) {
            d(dVar, nVar);
        } else if (i10 == 3) {
            e(dVar, list);
            nVar.f48642a = 0L;
        } else {
            throw new IllegalStateException();
        }
        return 1;
    }

    public final void d(d5.d dVar, d5.n nVar) throws IOException {
        long b4 = dVar.b();
        int i10 = (this.f20223c - 12) - 8;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i10);
        dVar.readFully(parsableByteArray.d(), 0, i10);
        for (int i11 = 0; i11 < i10 / 12; i11++) {
            parsableByteArray.Q(2);
            short s2 = parsableByteArray.s();
            if (s2 != 2192 && s2 != 2816 && s2 != 2817 && s2 != 2819 && s2 != 2820) {
                parsableByteArray.Q(8);
            } else {
                this.f20221a.add(new a(s2, (b4 - this.f20223c) - parsableByteArray.q(), parsableByteArray.q()));
            }
        }
        if (this.f20221a.isEmpty()) {
            nVar.f48642a = 0L;
        } else {
            this.f20222b = 3;
            nVar.f48642a = this.f20221a.get(0).f20225b;
        }
    }

    public final void e(d5.d dVar, List<Metadata.Entry> list) throws IOException {
        long position = dVar.getPosition();
        int b4 = (int) ((dVar.b() - dVar.getPosition()) - this.f20223c);
        ParsableByteArray parsableByteArray = new ParsableByteArray(b4);
        dVar.readFully(parsableByteArray.d(), 0, b4);
        for (int i10 = 0; i10 < this.f20221a.size(); i10++) {
            a aVar = this.f20221a.get(i10);
            parsableByteArray.P((int) (aVar.f20225b - position));
            parsableByteArray.Q(4);
            int q10 = parsableByteArray.q();
            int b10 = b(parsableByteArray.A(q10));
            int i11 = aVar.f20226c - (q10 + 8);
            if (b10 == 2192) {
                list.add(f(parsableByteArray, i11));
            } else if (b10 != 2816 && b10 != 2817 && b10 != 2819 && b10 != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.f20221a.clear();
        this.f20222b = 0;
    }
}
