package org.joda.time.tz;

/* compiled from: ZoneInfoLogger.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadLocal<Boolean> f52708a = new a();

    /* compiled from: ZoneInfoLogger.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends ThreadLocal<Boolean> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    public static boolean a() {
        return f52708a.get().booleanValue();
    }
}
