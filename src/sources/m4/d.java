package m4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.window.TaskConstants;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mobads.sdk.internal.bk;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.cct.internal.i;
import com.google.android.datatransport.cct.internal.j;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.firebase.encoders.EncodingException;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.inno.innosdk.pb.InnoMain;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import o4.k;

/* compiled from: CctTransportBackend.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final a8.a f51815a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f51816b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f51817c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f51818d;

    /* renamed from: e, reason: collision with root package name */
    public final u4.a f51819e;

    /* renamed from: f, reason: collision with root package name */
    public final u4.a f51820f;

    /* renamed from: g, reason: collision with root package name */
    public final int f51821g;

    /* compiled from: CctTransportBackend.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final URL f51822a;

        /* renamed from: b, reason: collision with root package name */
        public final i f51823b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f51824c;

        public a(URL url, i iVar, @Nullable String str) {
            this.f51822a = url;
            this.f51823b = iVar;
            this.f51824c = str;
        }

        public a a(URL url) {
            return new a(url, this.f51823b, this.f51824c);
        }
    }

    /* compiled from: CctTransportBackend.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f51825a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final URL f51826b;

        /* renamed from: c, reason: collision with root package name */
        public final long f51827c;

        public b(int i10, @Nullable URL url, long j10) {
            this.f51825a = i10;
            this.f51826b = url;
            this.f51827c = j10;
        }
    }

    public d(Context context, u4.a aVar, u4.a aVar2, int i10) {
        this.f51815a = i.b();
        this.f51817c = context;
        this.f51816b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f51818d = m(m4.a.f51805c);
        this.f51819e = aVar2;
        this.f51820f = aVar;
        this.f51821g = i10;
    }

    public static int e(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    public static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            p4.a.c("CctTransportBackend", "Unable to find version code for package", e2);
            return -1;
        }
    }

    public static TelephonyManager i(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    @VisibleForTesting
    public static long j() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static /* synthetic */ a k(a aVar, b bVar) {
        URL url = bVar.f51826b;
        if (url == null) {
            return null;
        }
        p4.a.a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f51826b);
    }

    public static InputStream l(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL m(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    @Override // o4.k
    public BackendResponse a(o4.e eVar) {
        i h10 = h(eVar);
        URL url = this.f51818d;
        if (eVar.c() != null) {
            try {
                m4.a c4 = m4.a.c(eVar.c());
                r3 = c4.d() != null ? c4.d() : null;
                if (c4.e() != null) {
                    url = m(c4.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            b bVar = (b) q4.b.a(5, new a(url, h10, r3), m4.b.a(this), c.b());
            int i10 = bVar.f51825a;
            if (i10 == 200) {
                return BackendResponse.d(bVar.f51827c);
            }
            if (i10 < 500 && i10 != 404) {
                return BackendResponse.a();
            }
            return BackendResponse.e();
        } catch (IOException e2) {
            p4.a.c("CctTransportBackend", "Could not make request to the backend", e2);
            return BackendResponse.e();
        }
    }

    @Override // o4.k
    public EventInternal b(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.f51816b.getActiveNetworkInfo();
        return eventInternal.l().a("sdk-version", Build.VERSION.SDK_INT).c(bk.f9900i, Build.MODEL).c("hardware", Build.HARDWARE).c(com.alipay.sdk.packet.e.f4642n, Build.DEVICE).c(InnoMain.INNO_KEY_PRODUCT, Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, Build.FINGERPRINT).b("tz-offset", j()).a("net-type", f(activeNetworkInfo)).a("mobile-subtype", e(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", i(this.f51817c).getSimOperator()).c("application_build", Integer.toString(g(this.f51817c))).d();
    }

    public final b d(a aVar) throws IOException {
        p4.a.a("CctTransportBackend", "Making request to: %s", aVar.f51822a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f51822a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f51821g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.2"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f51824c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f51815a.a(aVar.f51823b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    p4.a.e("CctTransportBackend", "Status Code: " + responseCode);
                    p4.a.e("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    p4.a.e("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream l10 = l(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, com.google.android.datatransport.cct.internal.k.b(new BufferedReader(new InputStreamReader(l10))).c());
                            if (l10 != null) {
                                l10.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (l10 != null) {
                                try {
                                    l10.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (EncodingException e2) {
            e = e2;
            p4.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e10) {
            e = e10;
            p4.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            p4.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            p4.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    public final i h(o4.e eVar) {
        LogEvent.Builder protoBuilder;
        HashMap hashMap = new HashMap();
        for (EventInternal eventInternal : eVar.b()) {
            String j10 = eventInternal.j();
            if (!hashMap.containsKey(j10)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                hashMap.put(j10, arrayList);
            } else {
                ((List) hashMap.get(j10)).add(eventInternal);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            j.a b4 = j.a().f(QosTier.DEFAULT).g(this.f51820f.getTime()).h(this.f51819e.getTime()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(com.google.android.datatransport.cct.internal.a.a().m(Integer.valueOf(eventInternal2.g("sdk-version"))).j(eventInternal2.b(bk.f9900i)).f(eventInternal2.b("hardware")).d(eventInternal2.b(com.alipay.sdk.packet.e.f4642n)).l(eventInternal2.b(InnoMain.INNO_KEY_PRODUCT)).k(eventInternal2.b("os-uild")).h(eventInternal2.b("manufacturer")).e(eventInternal2.b(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT)).c(eventInternal2.b("country")).g(eventInternal2.b("locale")).i(eventInternal2.b("mcc_mnc")).b(eventInternal2.b("application_build")).a()).a());
            try {
                b4.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b4.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                n4.d e2 = eventInternal3.e();
                com.google.android.datatransport.a b10 = e2.b();
                if (b10.equals(com.google.android.datatransport.a.b("proto"))) {
                    protoBuilder = LogEvent.protoBuilder(e2.a());
                } else if (b10.equals(com.google.android.datatransport.a.b("json"))) {
                    protoBuilder = LogEvent.jsonBuilder(new String(e2.a(), Charset.forName("UTF-8")));
                } else {
                    p4.a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b10);
                }
                protoBuilder.c(eventInternal3.f()).d(eventInternal3.k()).h(eventInternal3.h("tz-offset")).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.forNumber(eventInternal3.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal3.g("mobile-subtype"))).a());
                if (eventInternal3.d() != null) {
                    protoBuilder.b(eventInternal3.d());
                }
                arrayList3.add(protoBuilder.a());
            }
            b4.c(arrayList3);
            arrayList2.add(b4.a());
        }
        return i.a(arrayList2);
    }

    public d(Context context, u4.a aVar, u4.a aVar2) {
        this(context, aVar, aVar2, TaskConstants.TASK_CHILD_LAYER_TASK_OVERLAY);
    }
}
