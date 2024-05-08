package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Parcelable.Creator<Barcode> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        Point[] pointArr = null;
        Barcode.Email email = null;
        Barcode.Phone phone = null;
        Barcode.Sms sms = null;
        Barcode.WiFi wiFi = null;
        Barcode.UrlBookmark urlBookmark = null;
        Barcode.GeoPoint geoPoint = null;
        Barcode.CalendarEvent calendarEvent = null;
        Barcode.ContactInfo contactInfo = null;
        Barcode.DriverLicense driverLicense = null;
        byte[] bArr = null;
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 2:
                    i10 = SafeParcelReader.B(parcel, z11);
                    break;
                case 3:
                    str = SafeParcelReader.p(parcel, z11);
                    break;
                case 4:
                    str2 = SafeParcelReader.p(parcel, z11);
                    break;
                case 5:
                    i11 = SafeParcelReader.B(parcel, z11);
                    break;
                case 6:
                    pointArr = (Point[]) SafeParcelReader.s(parcel, z11, Point.CREATOR);
                    break;
                case 7:
                    email = (Barcode.Email) SafeParcelReader.o(parcel, z11, Barcode.Email.CREATOR);
                    break;
                case 8:
                    phone = (Barcode.Phone) SafeParcelReader.o(parcel, z11, Barcode.Phone.CREATOR);
                    break;
                case 9:
                    sms = (Barcode.Sms) SafeParcelReader.o(parcel, z11, Barcode.Sms.CREATOR);
                    break;
                case 10:
                    wiFi = (Barcode.WiFi) SafeParcelReader.o(parcel, z11, Barcode.WiFi.CREATOR);
                    break;
                case 11:
                    urlBookmark = (Barcode.UrlBookmark) SafeParcelReader.o(parcel, z11, Barcode.UrlBookmark.CREATOR);
                    break;
                case 12:
                    geoPoint = (Barcode.GeoPoint) SafeParcelReader.o(parcel, z11, Barcode.GeoPoint.CREATOR);
                    break;
                case 13:
                    calendarEvent = (Barcode.CalendarEvent) SafeParcelReader.o(parcel, z11, Barcode.CalendarEvent.CREATOR);
                    break;
                case 14:
                    contactInfo = (Barcode.ContactInfo) SafeParcelReader.o(parcel, z11, Barcode.ContactInfo.CREATOR);
                    break;
                case 15:
                    driverLicense = (Barcode.DriverLicense) SafeParcelReader.o(parcel, z11, Barcode.DriverLicense.CREATOR);
                    break;
                case 16:
                    bArr = SafeParcelReader.g(parcel, z11);
                    break;
                case 17:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode(i10, str, str2, i11, pointArr, email, phone, sms, wiFi, urlBookmark, geoPoint, calendarEvent, contactInfo, driverLicense, bArr, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode[] newArray(int i10) {
        return new Barcode[i10];
    }
}
