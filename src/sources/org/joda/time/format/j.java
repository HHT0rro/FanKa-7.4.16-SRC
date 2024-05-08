package org.joda.time.format;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: ISOPeriodFormat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static n f52644a;

    public static n a() {
        if (f52644a == null) {
            f52644a = new o().f("P").o().l("Y").h().l("M").n().l("W").b().l("D").k(ExifInterface.GPS_DIRECTION_TRUE).e().l("H").g().l("M").i().l(ExifInterface.LATITUDE_SOUTH).s();
        }
        return f52644a;
    }
}
