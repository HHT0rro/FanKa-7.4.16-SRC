package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.n;
import com.android.internal.logging.nano.MetricsProto;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new Parcelable.Creator<DistrictSearchQuery>() { // from class: com.amap.api.services.district.DistrictSearchQuery.1
        private static DistrictSearchQuery a(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.setKeywords(parcel.readString());
            districtSearchQuery.setKeywordsLevel(parcel.readString());
            districtSearchQuery.setPageNum(parcel.readInt());
            districtSearchQuery.setPageSize(parcel.readInt());
            districtSearchQuery.setShowChild(parcel.readByte() == 1);
            districtSearchQuery.setShowBoundary(parcel.readByte() == 1);
            districtSearchQuery.setShowBusinessArea(parcel.readByte() == 1);
            districtSearchQuery.setSubDistrict(parcel.readInt());
            return districtSearchQuery;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery[] newArray(int i10) {
            return a(i10);
        }

        private static DistrictSearchQuery[] a(int i10) {
            return new DistrictSearchQuery[i10];
        }
    };
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a, reason: collision with root package name */
    private int f8503a;

    /* renamed from: b, reason: collision with root package name */
    private int f8504b;

    /* renamed from: c, reason: collision with root package name */
    private String f8505c;

    /* renamed from: d, reason: collision with root package name */
    private String f8506d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8507e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8508f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8509g;

    /* renamed from: h, reason: collision with root package name */
    private int f8510h;

    public DistrictSearchQuery() {
        this.f8503a = 1;
        this.f8504b = 20;
        this.f8507e = true;
        this.f8508f = false;
        this.f8509g = false;
        this.f8510h = 1;
    }

    public boolean checkKeyWords() {
        String str = this.f8505c;
        return (str == null || str.trim().equalsIgnoreCase("")) ? false : true;
    }

    public boolean checkLevels() {
        String str = this.f8506d;
        if (str == null) {
            return false;
        }
        return str.trim().equals("country") || this.f8506d.trim().equals(KEYWORDS_PROVINCE) || this.f8506d.trim().equals(KEYWORDS_CITY) || this.f8506d.trim().equals(KEYWORDS_DISTRICT) || this.f8506d.trim().equals(KEYWORDS_BUSINESS);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.f8509g != districtSearchQuery.f8509g) {
            return false;
        }
        String str = this.f8505c;
        if (str == null) {
            if (districtSearchQuery.f8505c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f8505c)) {
            return false;
        }
        return this.f8503a == districtSearchQuery.f8503a && this.f8504b == districtSearchQuery.f8504b && this.f8507e == districtSearchQuery.f8507e && this.f8510h == districtSearchQuery.f8510h;
    }

    public String getKeywords() {
        return this.f8505c;
    }

    public String getKeywordsLevel() {
        return this.f8506d;
    }

    public int getPageNum() {
        int i10 = this.f8503a;
        if (i10 <= 0) {
            return 1;
        }
        return i10;
    }

    public int getPageSize() {
        return this.f8504b;
    }

    public int getSubDistrict() {
        return this.f8510h;
    }

    public int hashCode() {
        boolean z10 = this.f8509g;
        int i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
        int i11 = ((z10 ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT) + 31) * 31;
        String str = this.f8505c;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8506d;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f8503a) * 31) + this.f8504b) * 31;
        if (!this.f8507e) {
            i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        }
        return ((hashCode2 + i10) * 31) + this.f8510h;
    }

    public boolean isShowBoundary() {
        return this.f8509g;
    }

    public boolean isShowBusinessArea() {
        return this.f8508f;
    }

    public boolean isShowChild() {
        return this.f8507e;
    }

    public void setKeywords(String str) {
        this.f8505c = str;
    }

    public void setKeywordsLevel(String str) {
        this.f8506d = str;
    }

    public void setPageNum(int i10) {
        this.f8503a = i10;
    }

    public void setPageSize(int i10) {
        this.f8504b = i10;
    }

    public void setShowBoundary(boolean z10) {
        this.f8509g = z10;
    }

    public void setShowBusinessArea(boolean z10) {
        this.f8508f = z10;
    }

    public void setShowChild(boolean z10) {
        this.f8507e = z10;
    }

    public void setSubDistrict(int i10) {
        this.f8510h = i10;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.f8505c;
        if (str == null) {
            if (districtSearchQuery.f8505c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f8505c)) {
            return false;
        }
        return this.f8504b == districtSearchQuery.f8504b && this.f8507e == districtSearchQuery.f8507e && this.f8509g == districtSearchQuery.f8509g && this.f8510h == districtSearchQuery.f8510h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8505c);
        parcel.writeString(this.f8506d);
        parcel.writeInt(this.f8503a);
        parcel.writeInt(this.f8504b);
        parcel.writeByte(this.f8507e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8509g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8508f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f8510h);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DistrictSearchQuery m1976clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            n.a(e2, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.f8505c);
        districtSearchQuery.setKeywordsLevel(this.f8506d);
        districtSearchQuery.setPageNum(this.f8503a);
        districtSearchQuery.setPageSize(this.f8504b);
        districtSearchQuery.setShowChild(this.f8507e);
        districtSearchQuery.setSubDistrict(this.f8510h);
        districtSearchQuery.setShowBoundary(this.f8509g);
        districtSearchQuery.setShowBusinessArea(this.f8508f);
        return districtSearchQuery;
    }

    public DistrictSearchQuery(String str, String str2, int i10) {
        this.f8504b = 20;
        this.f8507e = true;
        this.f8508f = false;
        this.f8509g = false;
        this.f8510h = 1;
        this.f8505c = str;
        this.f8506d = str2;
        this.f8503a = i10;
    }

    public DistrictSearchQuery(String str, String str2, int i10, boolean z10, int i11) {
        this(str, str2, i10);
        this.f8507e = z10;
        this.f8504b = i11;
    }
}
