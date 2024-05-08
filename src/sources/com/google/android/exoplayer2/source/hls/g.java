package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.f0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: HlsExtractorFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f21529a = new d();

    j a(Uri uri, Format format, @Nullable List<Format> list, f0 f0Var, Map<String, List<String>> map, d5.d dVar) throws IOException;
}
