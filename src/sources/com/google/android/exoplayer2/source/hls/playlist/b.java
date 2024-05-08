package com.google.android.exoplayer2.source.hls.playlist;

import a6.e;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: HlsMasterPlaylist.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends e {

    /* renamed from: n, reason: collision with root package name */
    public static final b f21669n = new b("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d, reason: collision with root package name */
    public final List<Uri> f21670d;

    /* renamed from: e, reason: collision with root package name */
    public final List<C0198b> f21671e;

    /* renamed from: f, reason: collision with root package name */
    public final List<a> f21672f;

    /* renamed from: g, reason: collision with root package name */
    public final List<a> f21673g;

    /* renamed from: h, reason: collision with root package name */
    public final List<a> f21674h;

    /* renamed from: i, reason: collision with root package name */
    public final List<a> f21675i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final Format f21676j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final List<Format> f21677k;

    /* renamed from: l, reason: collision with root package name */
    public final Map<String, String> f21678l;

    /* renamed from: m, reason: collision with root package name */
    public final List<DrmInitData> f21679m;

    /* compiled from: HlsMasterPlaylist.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f21680a;

        /* renamed from: b, reason: collision with root package name */
        public final Format f21681b;

        /* renamed from: c, reason: collision with root package name */
        public final String f21682c;

        /* renamed from: d, reason: collision with root package name */
        public final String f21683d;

        public a(@Nullable Uri uri, Format format, String str, String str2) {
            this.f21680a = uri;
            this.f21681b = format;
            this.f21682c = str;
            this.f21683d = str2;
        }
    }

    /* compiled from: HlsMasterPlaylist.java */
    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0198b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f21684a;

        /* renamed from: b, reason: collision with root package name */
        public final Format f21685b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f21686c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f21687d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f21688e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f21689f;

        public C0198b(Uri uri, Format format, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f21684a = uri;
            this.f21685b = format;
            this.f21686c = str;
            this.f21687d = str2;
            this.f21688e = str3;
            this.f21689f = str4;
        }

        public static C0198b b(Uri uri) {
            return new C0198b(uri, new Format.b().S("0").K("application/x-mpegURL").E(), null, null, null, null);
        }

        public C0198b a(Format format) {
            return new C0198b(this.f21684a, format, this.f21686c, this.f21687d, this.f21688e, this.f21689f);
        }
    }

    public b(String str, List<String> list, List<C0198b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, @Nullable Format format, @Nullable List<Format> list7, boolean z10, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z10);
        this.f21670d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f21671e = Collections.unmodifiableList(list2);
        this.f21672f = Collections.unmodifiableList(list3);
        this.f21673g = Collections.unmodifiableList(list4);
        this.f21674h = Collections.unmodifiableList(list5);
        this.f21675i = Collections.unmodifiableList(list6);
        this.f21676j = format;
        this.f21677k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f21678l = Collections.unmodifiableMap(map);
        this.f21679m = Collections.unmodifiableList(list8);
    }

    public static void b(List<a> list, List<Uri> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Uri uri = list.get(i10).f21680a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public static <T> List<T> d(List<T> list, int i10, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            T t2 = list.get(i11);
            int i12 = 0;
            while (true) {
                if (i12 < list2.size()) {
                    StreamKey streamKey = list2.get(i12);
                    if (streamKey.f21020c == i10 && streamKey.f21021d == i11) {
                        arrayList.add(t2);
                        break;
                    }
                    i12++;
                }
            }
        }
        return arrayList;
    }

    public static b e(String str) {
        return new b("", Collections.emptyList(), Collections.singletonList(C0198b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    public static List<Uri> f(List<C0198b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            Uri uri = list.get(i10).f21684a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    @Override // u5.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(List<StreamKey> list) {
        return new b(this.f711a, this.f712b, d(this.f21671e, 0, list), Collections.emptyList(), d(this.f21673g, 1, list), d(this.f21674h, 2, list), Collections.emptyList(), this.f21676j, this.f21677k, this.f713c, this.f21678l, this.f21679m);
    }
}
