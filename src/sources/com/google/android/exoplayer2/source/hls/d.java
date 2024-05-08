package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.service.build.ah;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ts.g0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.f0;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultHlsExtractorFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements g {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f21496d = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b, reason: collision with root package name */
    public final int f21497b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21498c;

    public d() {
        this(0, true);
    }

    public static void b(int i10, List<Integer> list) {
        if (Ints.h(f21496d, i10) == -1 || list.contains(Integer.valueOf(i10))) {
            return;
        }
        list.add(Integer.valueOf(i10));
    }

    public static com.google.android.exoplayer2.extractor.mp4.f e(f0 f0Var, Format format, @Nullable List<Format> list) {
        int i10 = g(format) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new com.google.android.exoplayer2.extractor.mp4.f(i10, f0Var, null, list);
    }

    public static g0 f(int i10, boolean z10, Format format, @Nullable List<Format> list, f0 f0Var) {
        int i11 = i10 | 16;
        if (list != null) {
            i11 |= 32;
        } else if (z10) {
            list = Collections.singletonList(new Format.b().e0("application/cea-608").E());
        } else {
            list = Collections.emptyList();
        }
        String str = format.f19541j;
        if (!TextUtils.isEmpty(str)) {
            if (!com.google.android.exoplayer2.util.q.b(str, "audio/mp4a-latm")) {
                i11 |= 2;
            }
            if (!com.google.android.exoplayer2.util.q.b(str, ah.f2598d)) {
                i11 |= 4;
            }
        }
        return new g0(2, f0Var, new com.google.android.exoplayer2.extractor.ts.j(i11, list));
    }

    public static boolean g(Format format) {
        Metadata metadata = format.f19542k;
        if (metadata == null) {
            return false;
        }
        for (int i10 = 0; i10 < metadata.d(); i10++) {
            if (metadata.c(i10) instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) r2).f21480d.isEmpty();
            }
        }
        return false;
    }

    public static boolean h(Extractor extractor, d5.d dVar) throws IOException {
        try {
            boolean g3 = extractor.g(dVar);
            dVar.m();
            return g3;
        } catch (EOFException unused) {
            dVar.m();
            return false;
        } catch (Throwable th) {
            dVar.m();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.hls.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(Uri uri, Format format, @Nullable List<Format> list, f0 f0Var, Map<String, List<String>> map, d5.d dVar) throws IOException {
        int a10 = com.google.android.exoplayer2.util.h.a(format.f19544m);
        int b4 = com.google.android.exoplayer2.util.h.b(map);
        int c4 = com.google.android.exoplayer2.util.h.c(uri);
        int[] iArr = f21496d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(a10, arrayList);
        b(b4, arrayList);
        b(c4, arrayList);
        for (int i10 : iArr) {
            b(i10, arrayList);
        }
        Extractor extractor = null;
        dVar.m();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            int intValue = ((Integer) arrayList.get(i11)).intValue();
            Extractor extractor2 = (Extractor) com.google.android.exoplayer2.util.a.e(d(intValue, format, list, f0Var));
            if (h(extractor2, dVar)) {
                return new b(extractor2, format, f0Var);
            }
            if (extractor == null && (intValue == a10 || intValue == b4 || intValue == c4 || intValue == 11)) {
                extractor = extractor2;
            }
        }
        return new b((Extractor) com.google.android.exoplayer2.util.a.e(extractor), format, f0Var);
    }

    @Nullable
    public final Extractor d(int i10, Format format, @Nullable List<Format> list, f0 f0Var) {
        if (i10 == 0) {
            return new com.google.android.exoplayer2.extractor.ts.b();
        }
        if (i10 == 1) {
            return new com.google.android.exoplayer2.extractor.ts.e();
        }
        if (i10 == 2) {
            return new com.google.android.exoplayer2.extractor.ts.h();
        }
        if (i10 == 7) {
            return new j5.f(0, 0L);
        }
        if (i10 == 8) {
            return e(f0Var, format, list);
        }
        if (i10 == 11) {
            return f(this.f21497b, this.f21498c, format, list, f0Var);
        }
        if (i10 != 13) {
            return null;
        }
        return new r(format.f19535d, f0Var);
    }

    public d(int i10, boolean z10) {
        this.f21497b = i10;
        this.f21498c = z10;
    }
}
