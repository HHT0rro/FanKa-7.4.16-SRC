package l1;

import com.cupidapp.live.base.utils.crypt.FKWaterView;
import com.google.android.material.badge.BadgeDrawable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.c;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: FKRequestDigest.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f51580a = new b();

    /* compiled from: Comparisons.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t2, T t10) {
            return qd.a.a((String) ((Pair) t2).getFirst(), (String) ((Pair) t10).getFirst());
        }
    }

    public final String a(String str, String str2, String str3, String str4) {
        String str5;
        synchronized (this) {
            byte[] onDeetory = FKWaterView.onDeetory();
            s.h(onDeetory, "onDeetory()");
            str5 = str + str2 + str4 + str3 + new String(onDeetory, c.f51097b);
            p pVar = p.f51048a;
        }
        if (str5 == null || str5.length() == 0) {
            return "";
        }
        s.f(str5);
        return l1.a.e(str5);
    }

    @NotNull
    public final Request.Builder b(@NotNull Request request, @NotNull Map<String, String> headers) {
        boolean z10;
        s.i(request, "request");
        s.i(headers, "headers");
        RequestBody body = request.body();
        Request.Builder newBuilder = request.newBuilder();
        String str = "_t=" + System.currentTimeMillis();
        List<String> e2 = e(request, str);
        String query = request.url().query();
        if (!(query == null || kotlin.text.p.t(query)) || (body instanceof MultipartBody)) {
            z10 = false;
            str = CollectionsKt___CollectionsKt.c0(e2, "&", null, null, 0, null, null, 62, null);
        } else {
            z10 = false;
        }
        String c02 = CollectionsKt___CollectionsKt.c0(e2, "&", null, null, 0, null, null, 62, null);
        newBuilder.method(request.method(), body).url(request.url().newBuilder().encodedQuery(str).build());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            if (kotlin.text.p.F(entry.getKey(), "X-App", z10, 2, null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            b bVar = f51580a;
            String str2 = (String) entry2.getKey();
            Locale locale = Locale.getDefault();
            s.h(locale, "getDefault()");
            String lowerCase = str2.toLowerCase(locale);
            s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            arrayList.add(bVar.c(lowerCase) + "=" + bVar.c((String) entry2.getValue()));
        }
        return newBuilder.addHeader("Digest", a(request.url().encodedPath(), request.method(), c02, CollectionsKt___CollectionsKt.c0(CollectionsKt___CollectionsKt.r0(arrayList), "&", null, null, 0, null, null, 62, null)));
    }

    public final String c(String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            s.h(encode, "encode(value, \"utf-8\")");
            return kotlin.text.p.A(encode, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20", false, 4, null);
        } catch (Exception e2) {
            throw new RuntimeException("encode fail: " + str, e2);
        }
    }

    public final List<String> d(Request request, String str) {
        List<String> z02;
        List o10 = kotlin.collections.s.o(str);
        String query = request.url().query();
        if (query != null && (z02 = StringsKt__StringsKt.z0(query, new String[]{"&"}, false, 0, 6, null)) != null) {
            for (String str2 : z02) {
                String str3 = (String) CollectionsKt___CollectionsKt.V(StringsKt__StringsKt.z0(str2, new String[]{"="}, false, 0, 6, null));
                String str4 = (String) CollectionsKt___CollectionsKt.f0(StringsKt__StringsKt.z0(str2, new String[]{"="}, false, 0, 6, null));
                if (str4 != null) {
                    str4 = f51580a.c(str4);
                }
                o10.add(str3 + "=" + str4);
            }
        }
        return CollectionsKt___CollectionsKt.r0(o10);
    }

    public final List<String> e(Request request, String str) {
        if (request.body() == null) {
            return d(request, str);
        }
        return f(request, str);
    }

    public final List<String> f(Request request, String str) {
        List<String> list;
        List<String> list2;
        List<String> z02;
        RequestBody body = request.body();
        if (body == null) {
            return kotlin.collections.s.j();
        }
        ArrayList arrayList = new ArrayList();
        String query = request.url().query();
        if (query != null && (z02 = StringsKt__StringsKt.z0(query, new String[]{"&"}, false, 0, 6, null)) != null) {
            for (String str2 : z02) {
                String str3 = (String) CollectionsKt___CollectionsKt.V(StringsKt__StringsKt.z0(str2, new String[]{"="}, false, 0, 6, null));
                String str4 = (String) CollectionsKt___CollectionsKt.f0(StringsKt__StringsKt.z0(str2, new String[]{"="}, false, 0, 6, null));
                if (str4 != null) {
                    str4 = f51580a.c(str4);
                }
                arrayList.add(str3 + "=" + str4);
            }
        }
        if (body instanceof FormBody) {
            FormBody formBody = (FormBody) body;
            List o10 = kotlin.collections.s.o(new Pair(str, Integer.valueOf(formBody.size())));
            int size = formBody.size();
            for (int i10 = 0; i10 < size; i10++) {
                o10.add(new Pair(formBody.encodedName(i10), Integer.valueOf(i10)));
            }
            for (Pair pair : CollectionsKt___CollectionsKt.s0(o10, new a())) {
                if (((Number) pair.getSecond()).intValue() == formBody.size()) {
                    arrayList.add(pair.getFirst());
                } else {
                    arrayList.add(formBody.encodedName(((Number) pair.getSecond()).intValue()) + "=" + formBody.encodedValue(((Number) pair.getSecond()).intValue()));
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(str);
            }
            return arrayList;
        }
        if (body instanceof MultipartBody) {
            arrayList.add(str);
            List<MultipartBody.Part> parts = ((MultipartBody) body).parts();
            if (parts.size() > 0) {
                for (MultipartBody.Part part : parts) {
                    Headers headers = part.headers();
                    Map<String, List<String>> multimap = headers != null ? headers.toMultimap() : null;
                    String str5 = (multimap == null || (list2 = multimap.get("content-disposition")) == null) ? null : (String) CollectionsKt___CollectionsKt.V(list2);
                    String str6 = (multimap == null || (list = multimap.get("content-transfer-encoding")) == null) ? null : (String) CollectionsKt___CollectionsKt.V(list);
                    if ((str5 == null || StringsKt__StringsKt.K(str5, FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, false, 2, null)) ? false : true) {
                        String str7 = (String) CollectionsKt___CollectionsKt.f0(StringsKt__StringsKt.z0(str5, new String[]{"name="}, false, 0, 6, null));
                        String A = str7 != null ? kotlin.text.p.A(str7, "\"", "", false, 4, null) : null;
                        Buffer buffer = new Buffer();
                        part.body().writeTo(buffer);
                        String readUtf8 = buffer.readUtf8();
                        if (s.d(str6, "binary")) {
                            readUtf8 = f51580a.c(readUtf8);
                        }
                        if (A != null) {
                            arrayList.add(A + "=" + readUtf8);
                        }
                    }
                }
            }
            return CollectionsKt___CollectionsKt.r0(arrayList);
        }
        arrayList.add(str);
        return CollectionsKt___CollectionsKt.r0(arrayList);
    }
}
