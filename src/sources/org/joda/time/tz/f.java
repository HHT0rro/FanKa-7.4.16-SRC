package org.joda.time.tz;

import com.google.android.material.datepicker.UtcDates;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTimeZone;

/* compiled from: ZoneInfoProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    public final File f52709a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52710b;

    /* renamed from: c, reason: collision with root package name */
    public final ClassLoader f52711c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f52712d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<String> f52713e;

    /* compiled from: ZoneInfoProvider.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements PrivilegedAction<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f52714a;

        public a(String str) {
            this.f52714a = str;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            if (f.this.f52711c != null) {
                return f.this.f52711c.getResourceAsStream(this.f52714a);
            }
            return ClassLoader.getSystemResourceAsStream(this.f52714a);
        }
    }

    public f(File file) throws IOException {
        if (file != null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    this.f52709a = file;
                    this.f52710b = null;
                    this.f52711c = null;
                    Map<String, Object> e2 = e(f("ZoneInfoMap"));
                    this.f52712d = e2;
                    this.f52713e = Collections.unmodifiableSortedSet(new TreeSet(e2.h()));
                    return;
                }
                throw new IOException("File doesn't refer to a directory: " + ((Object) file));
            }
            throw new IOException("File directory doesn't exist: " + ((Object) file));
        }
        throw new IllegalArgumentException("No file directory provided");
    }

    public static Map<String, Object> e(InputStream inputStream) throws IOException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            g(dataInputStream, concurrentHashMap);
            concurrentHashMap.put(UtcDates.UTC, new SoftReference(DateTimeZone.UTC));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void g(DataInputStream dataInputStream, Map<String, Object> map) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        for (int i10 = 0; i10 < readUnsignedShort; i10++) {
            strArr[i10] = dataInputStream.readUTF().intern();
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        for (int i11 = 0; i11 < readUnsignedShort2; i11++) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }

    @Override // org.joda.time.tz.c
    public DateTimeZone a(String str) {
        Object obj;
        if (str == null || (obj = this.f52712d.get(str)) == null) {
            return null;
        }
        if (obj instanceof SoftReference) {
            DateTimeZone dateTimeZone = (DateTimeZone) ((SoftReference) obj).get();
            return dateTimeZone != null ? dateTimeZone : d(str);
        }
        if (str.equals(obj)) {
            return d(str);
        }
        return a((String) obj);
    }

    @Override // org.joda.time.tz.c
    public Set<String> b() {
        return this.f52713e;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x001a */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.joda.time.DateTimeZone d(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.InputStream r1 = r5.f(r6)     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L20
            org.joda.time.DateTimeZone r2 = org.joda.time.tz.DateTimeZoneBuilder.b(r1, r6)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.f52712d     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            r3.put(r6, r4)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            if (r1 == 0) goto L18
            r1.close()     // Catch: java.io.IOException -> L18
        L18:
            return r2
        L19:
            r6 = move-exception
            r0 = r1
            goto L30
        L1c:
            r2 = move-exception
            goto L22
        L1e:
            r6 = move-exception
            goto L30
        L20:
            r2 = move-exception
            r1 = r0
        L22:
            r5.h(r2)     // Catch: java.lang.Throwable -> L19
            java.util.Map<java.lang.String, java.lang.Object> r2 = r5.f52712d     // Catch: java.lang.Throwable -> L19
            r2.remove(r6)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.io.IOException -> L2f
        L2f:
            return r0
        L30:
            if (r0 == 0) goto L35
            r0.close()     // Catch: java.io.IOException -> L35
        L35:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.f.d(java.lang.String):org.joda.time.DateTimeZone");
    }

    public final InputStream f(String str) throws IOException {
        if (this.f52709a != null) {
            return new FileInputStream(new File(this.f52709a, str));
        }
        String concat = this.f52710b.concat(str);
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a(concat));
        if (inputStream != null) {
            return inputStream;
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Resource not found: \"");
        sb2.append(concat);
        sb2.append("\" ClassLoader: ");
        ClassLoader classLoader = this.f52711c;
        sb2.append(classLoader != null ? classLoader.toString() : "system");
        throw new IOException(sb2.toString());
    }

    public void h(Exception exc) {
        exc.printStackTrace();
    }

    public f(String str) throws IOException {
        this(str, null, false);
    }

    public f(String str, ClassLoader classLoader, boolean z10) throws IOException {
        if (str != null) {
            if (!str.endsWith("/")) {
                str = str + IOUtils.DIR_SEPARATOR_UNIX;
            }
            this.f52709a = null;
            this.f52710b = str;
            if (classLoader == null && !z10) {
                classLoader = getClass().getClassLoader();
            }
            this.f52711c = classLoader;
            Map<String, Object> e2 = e(f("ZoneInfoMap"));
            this.f52712d = e2;
            this.f52713e = Collections.unmodifiableSortedSet(new TreeSet(e2.h()));
            return;
        }
        throw new IllegalArgumentException("No resource path provided");
    }
}
