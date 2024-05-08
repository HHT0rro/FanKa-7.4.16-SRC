package c8;

import a8.f;
import a8.g;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.UtcDates;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: JsonDataEncoderBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d implements b8.b<d> {

    /* renamed from: e, reason: collision with root package name */
    public static final a8.d<Object> f1566e = c8.a.b();

    /* renamed from: f, reason: collision with root package name */
    public static final f<String> f1567f = c8.b.b();

    /* renamed from: g, reason: collision with root package name */
    public static final f<Boolean> f1568g = c.b();

    /* renamed from: h, reason: collision with root package name */
    public static final b f1569h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f1570a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f1571b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public a8.d<Object> f1572c = f1566e;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1573d = false;

    /* compiled from: JsonDataEncoderBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements a8.a {
        public a() {
        }

        @Override // a8.a
        public void a(@NonNull Object obj, @NonNull Writer writer) throws IOException {
            e eVar = new e(writer, d.this.f1570a, d.this.f1571b, d.this.f1572c, d.this.f1573d);
            eVar.g(obj, false);
            eVar.n();
        }

        @Override // a8.a
        public String b(@NonNull Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* compiled from: JsonDataEncoderBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b implements f<Date> {

        /* renamed from: a, reason: collision with root package name */
        public static final DateFormat f1575a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f1575a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        }

        public b() {
        }

        @Override // a8.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull Date date, @NonNull g gVar) throws IOException {
            gVar.a(f1575a.format(date));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f1567f);
        m(Boolean.class, f1568g);
        m(Date.class, f1569h);
    }

    public static /* synthetic */ void i(Object obj, a8.e eVar) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    @NonNull
    public a8.a f() {
        return new a();
    }

    @NonNull
    public d g(@NonNull b8.a aVar) {
        aVar.a(this);
        return this;
    }

    @NonNull
    public d h(boolean z10) {
        this.f1573d = z10;
        return this;
    }

    @Override // b8.b
    @NonNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public <T> d a(@NonNull Class<T> cls, @NonNull a8.d<? super T> dVar) {
        this.f1570a.put(cls, dVar);
        this.f1571b.remove(cls);
        return this;
    }

    @NonNull
    public <T> d m(@NonNull Class<T> cls, @NonNull f<? super T> fVar) {
        this.f1571b.put(cls, fVar);
        this.f1570a.remove(cls);
        return this;
    }
}
