package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Barcode extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Barcode> CREATOR = new b();

    /* renamed from: b, reason: collision with root package name */
    public int f25820b;

    /* renamed from: c, reason: collision with root package name */
    @RecentlyNonNull
    public String f25821c;

    /* renamed from: d, reason: collision with root package name */
    @RecentlyNonNull
    public String f25822d;

    /* renamed from: e, reason: collision with root package name */
    public int f25823e;

    /* renamed from: f, reason: collision with root package name */
    @RecentlyNonNull
    public Point[] f25824f;

    /* renamed from: g, reason: collision with root package name */
    @RecentlyNonNull
    public Email f25825g;

    /* renamed from: h, reason: collision with root package name */
    @RecentlyNonNull
    public Phone f25826h;

    /* renamed from: i, reason: collision with root package name */
    @RecentlyNonNull
    public Sms f25827i;

    /* renamed from: j, reason: collision with root package name */
    @RecentlyNonNull
    public WiFi f25828j;

    /* renamed from: k, reason: collision with root package name */
    @RecentlyNonNull
    public UrlBookmark f25829k;

    /* renamed from: l, reason: collision with root package name */
    @RecentlyNonNull
    public GeoPoint f25830l;

    /* renamed from: m, reason: collision with root package name */
    @RecentlyNonNull
    public CalendarEvent f25831m;

    /* renamed from: n, reason: collision with root package name */
    @RecentlyNonNull
    public ContactInfo f25832n;

    /* renamed from: o, reason: collision with root package name */
    @RecentlyNonNull
    public DriverLicense f25833o;

    /* renamed from: p, reason: collision with root package name */
    @RecentlyNonNull
    public byte[] f25834p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f25835q;

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Address extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<Address> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f25836b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String[] f25837c;

        public Address() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.j(parcel, 2, this.f25836b);
            w6.a.p(parcel, 3, this.f25837c, false);
            w6.a.b(parcel, a10);
        }

        public Address(int i10, @RecentlyNonNull String[] strArr) {
            this.f25836b = i10;
            this.f25837c = strArr;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class CalendarDateTime extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<CalendarDateTime> CREATOR = new c();

        /* renamed from: b, reason: collision with root package name */
        public int f25838b;

        /* renamed from: c, reason: collision with root package name */
        public int f25839c;

        /* renamed from: d, reason: collision with root package name */
        public int f25840d;

        /* renamed from: e, reason: collision with root package name */
        public int f25841e;

        /* renamed from: f, reason: collision with root package name */
        public int f25842f;

        /* renamed from: g, reason: collision with root package name */
        public int f25843g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f25844h;

        /* renamed from: i, reason: collision with root package name */
        @RecentlyNonNull
        public String f25845i;

        public CalendarDateTime() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.j(parcel, 2, this.f25838b);
            w6.a.j(parcel, 3, this.f25839c);
            w6.a.j(parcel, 4, this.f25840d);
            w6.a.j(parcel, 5, this.f25841e);
            w6.a.j(parcel, 6, this.f25842f);
            w6.a.j(parcel, 7, this.f25843g);
            w6.a.c(parcel, 8, this.f25844h);
            w6.a.o(parcel, 9, this.f25845i, false);
            w6.a.b(parcel, a10);
        }

        public CalendarDateTime(int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, @RecentlyNonNull String str) {
            this.f25838b = i10;
            this.f25839c = i11;
            this.f25840d = i12;
            this.f25841e = i13;
            this.f25842f = i14;
            this.f25843g = i15;
            this.f25844h = z10;
            this.f25845i = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class CalendarEvent extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<CalendarEvent> CREATOR = new e();

        @RecentlyNonNull
        public String description;

        @RecentlyNonNull
        public CalendarDateTime end;

        @RecentlyNonNull
        public String location;

        @RecentlyNonNull
        public String organizer;

        @RecentlyNonNull
        public CalendarDateTime start;

        @RecentlyNonNull
        public String status;

        @RecentlyNonNull
        public String summary;

        public CalendarEvent() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.o(parcel, 2, this.summary, false);
            w6.a.o(parcel, 3, this.description, false);
            w6.a.o(parcel, 4, this.location, false);
            w6.a.o(parcel, 5, this.organizer, false);
            w6.a.o(parcel, 6, this.status, false);
            w6.a.n(parcel, 7, this.start, i10, false);
            w6.a.n(parcel, 8, this.end, i10, false);
            w6.a.b(parcel, a10);
        }

        public CalendarEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull String str4, @RecentlyNonNull String str5, @RecentlyNonNull CalendarDateTime calendarDateTime, @RecentlyNonNull CalendarDateTime calendarDateTime2) {
            this.summary = str;
            this.description = str2;
            this.location = str3;
            this.organizer = str4;
            this.status = str5;
            this.start = calendarDateTime;
            this.end = calendarDateTime2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ContactInfo extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<ContactInfo> CREATOR = new d();

        /* renamed from: b, reason: collision with root package name */
        @RecentlyNonNull
        public PersonName f25846b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25847c;

        /* renamed from: d, reason: collision with root package name */
        @RecentlyNonNull
        public String f25848d;

        /* renamed from: e, reason: collision with root package name */
        @RecentlyNonNull
        public Phone[] f25849e;

        /* renamed from: f, reason: collision with root package name */
        @RecentlyNonNull
        public Email[] f25850f;

        /* renamed from: g, reason: collision with root package name */
        @RecentlyNonNull
        public String[] f25851g;

        /* renamed from: h, reason: collision with root package name */
        @RecentlyNonNull
        public Address[] f25852h;

        public ContactInfo() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.n(parcel, 2, this.f25846b, i10, false);
            w6.a.o(parcel, 3, this.f25847c, false);
            w6.a.o(parcel, 4, this.f25848d, false);
            w6.a.r(parcel, 5, this.f25849e, i10, false);
            w6.a.r(parcel, 6, this.f25850f, i10, false);
            w6.a.p(parcel, 7, this.f25851g, false);
            w6.a.r(parcel, 8, this.f25852h, i10, false);
            w6.a.b(parcel, a10);
        }

        public ContactInfo(@RecentlyNonNull PersonName personName, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Phone[] phoneArr, @RecentlyNonNull Email[] emailArr, @RecentlyNonNull String[] strArr, @RecentlyNonNull Address[] addressArr) {
            this.f25846b = personName;
            this.f25847c = str;
            this.f25848d = str2;
            this.f25849e = phoneArr;
            this.f25850f = emailArr;
            this.f25851g = strArr;
            this.f25852h = addressArr;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DriverLicense extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<DriverLicense> CREATOR = new g();

        /* renamed from: b, reason: collision with root package name */
        @RecentlyNonNull
        public String f25853b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25854c;

        /* renamed from: d, reason: collision with root package name */
        @RecentlyNonNull
        public String f25855d;

        /* renamed from: e, reason: collision with root package name */
        @RecentlyNonNull
        public String f25856e;

        /* renamed from: f, reason: collision with root package name */
        @RecentlyNonNull
        public String f25857f;

        /* renamed from: g, reason: collision with root package name */
        @RecentlyNonNull
        public String f25858g;

        /* renamed from: h, reason: collision with root package name */
        @RecentlyNonNull
        public String f25859h;

        /* renamed from: i, reason: collision with root package name */
        @RecentlyNonNull
        public String f25860i;

        /* renamed from: j, reason: collision with root package name */
        @RecentlyNonNull
        public String f25861j;

        /* renamed from: k, reason: collision with root package name */
        @RecentlyNonNull
        public String f25862k;

        /* renamed from: l, reason: collision with root package name */
        @RecentlyNonNull
        public String f25863l;

        /* renamed from: m, reason: collision with root package name */
        @RecentlyNonNull
        public String f25864m;

        /* renamed from: n, reason: collision with root package name */
        @RecentlyNonNull
        public String f25865n;

        /* renamed from: o, reason: collision with root package name */
        @RecentlyNonNull
        public String f25866o;

        public DriverLicense() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.o(parcel, 2, this.f25853b, false);
            w6.a.o(parcel, 3, this.f25854c, false);
            w6.a.o(parcel, 4, this.f25855d, false);
            w6.a.o(parcel, 5, this.f25856e, false);
            w6.a.o(parcel, 6, this.f25857f, false);
            w6.a.o(parcel, 7, this.f25858g, false);
            w6.a.o(parcel, 8, this.f25859h, false);
            w6.a.o(parcel, 9, this.f25860i, false);
            w6.a.o(parcel, 10, this.f25861j, false);
            w6.a.o(parcel, 11, this.f25862k, false);
            w6.a.o(parcel, 12, this.f25863l, false);
            w6.a.o(parcel, 13, this.f25864m, false);
            w6.a.o(parcel, 14, this.f25865n, false);
            w6.a.o(parcel, 15, this.f25866o, false);
            w6.a.b(parcel, a10);
        }

        public DriverLicense(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull String str4, @RecentlyNonNull String str5, @RecentlyNonNull String str6, @RecentlyNonNull String str7, @RecentlyNonNull String str8, @RecentlyNonNull String str9, @RecentlyNonNull String str10, @RecentlyNonNull String str11, @RecentlyNonNull String str12, @RecentlyNonNull String str13, @RecentlyNonNull String str14) {
            this.f25853b = str;
            this.f25854c = str2;
            this.f25855d = str3;
            this.f25856e = str4;
            this.f25857f = str5;
            this.f25858g = str6;
            this.f25859h = str7;
            this.f25860i = str8;
            this.f25861j = str9;
            this.f25862k = str10;
            this.f25863l = str11;
            this.f25864m = str12;
            this.f25865n = str13;
            this.f25866o = str14;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Email extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<Email> CREATOR = new f();

        /* renamed from: b, reason: collision with root package name */
        public int f25867b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25868c;

        /* renamed from: d, reason: collision with root package name */
        @RecentlyNonNull
        public String f25869d;

        /* renamed from: e, reason: collision with root package name */
        @RecentlyNonNull
        public String f25870e;

        public Email() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.j(parcel, 2, this.f25867b);
            w6.a.o(parcel, 3, this.f25868c, false);
            w6.a.o(parcel, 4, this.f25869d, false);
            w6.a.o(parcel, 5, this.f25870e, false);
            w6.a.b(parcel, a10);
        }

        public Email(int i10, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull String str3) {
            this.f25867b = i10;
            this.f25868c = str;
            this.f25869d = str2;
            this.f25870e = str3;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class GeoPoint extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<GeoPoint> CREATOR = new i();

        /* renamed from: b, reason: collision with root package name */
        public double f25871b;

        /* renamed from: c, reason: collision with root package name */
        public double f25872c;

        public GeoPoint() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.g(parcel, 2, this.f25871b);
            w6.a.g(parcel, 3, this.f25872c);
            w6.a.b(parcel, a10);
        }

        public GeoPoint(double d10, double d11) {
            this.f25871b = d10;
            this.f25872c = d11;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class PersonName extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<PersonName> CREATOR = new h();

        /* renamed from: b, reason: collision with root package name */
        @RecentlyNonNull
        public String f25873b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25874c;

        /* renamed from: d, reason: collision with root package name */
        @RecentlyNonNull
        public String f25875d;

        /* renamed from: e, reason: collision with root package name */
        @RecentlyNonNull
        public String f25876e;

        /* renamed from: f, reason: collision with root package name */
        @RecentlyNonNull
        public String f25877f;

        /* renamed from: g, reason: collision with root package name */
        @RecentlyNonNull
        public String f25878g;

        /* renamed from: h, reason: collision with root package name */
        @RecentlyNonNull
        public String f25879h;

        public PersonName() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.o(parcel, 2, this.f25873b, false);
            w6.a.o(parcel, 3, this.f25874c, false);
            w6.a.o(parcel, 4, this.f25875d, false);
            w6.a.o(parcel, 5, this.f25876e, false);
            w6.a.o(parcel, 6, this.f25877f, false);
            w6.a.o(parcel, 7, this.f25878g, false);
            w6.a.o(parcel, 8, this.f25879h, false);
            w6.a.b(parcel, a10);
        }

        public PersonName(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull String str4, @RecentlyNonNull String str5, @RecentlyNonNull String str6, @RecentlyNonNull String str7) {
            this.f25873b = str;
            this.f25874c = str2;
            this.f25875d = str3;
            this.f25876e = str4;
            this.f25877f = str5;
            this.f25878g = str6;
            this.f25879h = str7;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Phone extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<Phone> CREATOR = new k();

        /* renamed from: b, reason: collision with root package name */
        public int f25880b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25881c;

        public Phone() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.j(parcel, 2, this.f25880b);
            w6.a.o(parcel, 3, this.f25881c, false);
            w6.a.b(parcel, a10);
        }

        public Phone(int i10, @RecentlyNonNull String str) {
            this.f25880b = i10;
            this.f25881c = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Sms extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<Sms> CREATOR = new j();

        /* renamed from: b, reason: collision with root package name */
        @RecentlyNonNull
        public String f25882b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25883c;

        public Sms() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.o(parcel, 2, this.f25882b, false);
            w6.a.o(parcel, 3, this.f25883c, false);
            w6.a.b(parcel, a10);
        }

        public Sms(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
            this.f25882b = str;
            this.f25883c = str2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class UrlBookmark extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<UrlBookmark> CREATOR = new m();

        /* renamed from: b, reason: collision with root package name */
        @RecentlyNonNull
        public String f25884b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25885c;

        public UrlBookmark() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.o(parcel, 2, this.f25884b, false);
            w6.a.o(parcel, 3, this.f25885c, false);
            w6.a.b(parcel, a10);
        }

        public UrlBookmark(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
            this.f25884b = str;
            this.f25885c = str2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class WiFi extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator<WiFi> CREATOR = new l();

        /* renamed from: b, reason: collision with root package name */
        @RecentlyNonNull
        public String f25886b;

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public String f25887c;

        /* renamed from: d, reason: collision with root package name */
        public int f25888d;

        public WiFi() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
            int a10 = w6.a.a(parcel);
            w6.a.o(parcel, 2, this.f25886b, false);
            w6.a.o(parcel, 3, this.f25887c, false);
            w6.a.j(parcel, 4, this.f25888d);
            w6.a.b(parcel, a10);
        }

        public WiFi(@RecentlyNonNull String str, @RecentlyNonNull String str2, int i10) {
            this.f25886b = str;
            this.f25887c = str2;
            this.f25888d = i10;
        }
    }

    public Barcode() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 2, this.f25820b);
        w6.a.o(parcel, 3, this.f25821c, false);
        w6.a.o(parcel, 4, this.f25822d, false);
        w6.a.j(parcel, 5, this.f25823e);
        w6.a.r(parcel, 6, this.f25824f, i10, false);
        w6.a.n(parcel, 7, this.f25825g, i10, false);
        w6.a.n(parcel, 8, this.f25826h, i10, false);
        w6.a.n(parcel, 9, this.f25827i, i10, false);
        w6.a.n(parcel, 10, this.f25828j, i10, false);
        w6.a.n(parcel, 11, this.f25829k, i10, false);
        w6.a.n(parcel, 12, this.f25830l, i10, false);
        w6.a.n(parcel, 13, this.f25831m, i10, false);
        w6.a.n(parcel, 14, this.f25832n, i10, false);
        w6.a.n(parcel, 15, this.f25833o, i10, false);
        w6.a.e(parcel, 16, this.f25834p, false);
        w6.a.c(parcel, 17, this.f25835q);
        w6.a.b(parcel, a10);
    }

    public Barcode(int i10, @RecentlyNonNull String str, @RecentlyNonNull String str2, int i11, @RecentlyNonNull Point[] pointArr, @RecentlyNonNull Email email, @RecentlyNonNull Phone phone, @RecentlyNonNull Sms sms, @RecentlyNonNull WiFi wiFi, @RecentlyNonNull UrlBookmark urlBookmark, @RecentlyNonNull GeoPoint geoPoint, @RecentlyNonNull CalendarEvent calendarEvent, @RecentlyNonNull ContactInfo contactInfo, @RecentlyNonNull DriverLicense driverLicense, @RecentlyNonNull byte[] bArr, boolean z10) {
        this.f25820b = i10;
        this.f25821c = str;
        this.f25834p = bArr;
        this.f25822d = str2;
        this.f25823e = i11;
        this.f25824f = pointArr;
        this.f25835q = z10;
        this.f25825g = email;
        this.f25826h = phone;
        this.f25827i = sms;
        this.f25828j = wiFi;
        this.f25829k = urlBookmark;
        this.f25830l = geoPoint;
        this.f25831m = calendarEvent;
        this.f25832n = contactInfo;
        this.f25833o = driverLicense;
    }
}
