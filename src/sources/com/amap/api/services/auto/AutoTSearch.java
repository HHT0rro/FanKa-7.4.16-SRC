package com.amap.api.services.auto;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.bf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IAutoTSearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    private IAutoTSearch f8329a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class FilterBox implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FilterBox> CREATOR = new Parcelable.Creator<FilterBox>() { // from class: com.amap.api.services.auto.AutoTSearch.FilterBox.1
            private static FilterBox a(Parcel parcel) {
                return new FilterBox(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox[] newArray(int i10) {
                return a(i10);
            }

            private static FilterBox[] a(int i10) {
                return new FilterBox[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private String f8330a;

        /* renamed from: b, reason: collision with root package name */
        private String f8331b;

        /* renamed from: c, reason: collision with root package name */
        private String f8332c;

        /* renamed from: d, reason: collision with root package name */
        private String f8333d;

        /* renamed from: e, reason: collision with root package name */
        private String f8334e;

        public FilterBox() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCheckedLevel() {
            return this.f8331b;
        }

        public String getClassifyV2Data() {
            return this.f8332c;
        }

        public String getClassifyV2Level2Data() {
            return this.f8333d;
        }

        public String getClassifyV2Level3Data() {
            return this.f8334e;
        }

        public String getRetainState() {
            return this.f8330a;
        }

        public void setCheckedLevel(String str) {
            this.f8331b = str;
        }

        public void setClassifyV2Data(String str) {
            this.f8332c = str;
        }

        public void setClassifyV2Level2Data(String str) {
            this.f8333d = str;
        }

        public void setClassifyV2Level3Data(String str) {
            this.f8334e = str;
        }

        public void setRetainState(String str) {
            this.f8330a = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f8330a);
            parcel.writeString(this.f8331b);
            parcel.writeString(this.f8332c);
            parcel.writeString(this.f8333d);
            parcel.writeString(this.f8334e);
        }

        public FilterBox(Parcel parcel) {
            this.f8330a = parcel.readString();
            this.f8331b = parcel.readString();
            this.f8332c = parcel.readString();
            this.f8333d = parcel.readString();
            this.f8334e = parcel.readString();
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FilterBox m1970clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            FilterBox filterBox = new FilterBox();
            filterBox.setRetainState(this.f8330a);
            filterBox.setCheckedLevel(this.f8331b);
            filterBox.setClassifyV2Data(this.f8332c);
            filterBox.setClassifyV2Level2Data(this.f8333d);
            filterBox.setClassifyV2Level3Data(this.f8334e);
            return filterBox;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnChargeStationListener {
        void onChargeStationSearched(AutoTChargeStationResult autoTChargeStationResult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Query implements Parcelable, Cloneable {
        public static final Parcelable.Creator<Query> CREATOR = new Parcelable.Creator<Query>() { // from class: com.amap.api.services.auto.AutoTSearch.Query.1
            private static Query a(Parcel parcel) {
                return new Query(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query[] newArray(int i10) {
                return a(i10);
            }

            private static Query[] a(int i10) {
                return new Query[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private String f8335a;

        /* renamed from: b, reason: collision with root package name */
        private String f8336b;

        /* renamed from: c, reason: collision with root package name */
        private String f8337c;

        /* renamed from: d, reason: collision with root package name */
        private String f8338d;

        /* renamed from: e, reason: collision with root package name */
        private String f8339e;

        /* renamed from: f, reason: collision with root package name */
        private int f8340f;

        /* renamed from: g, reason: collision with root package name */
        private int f8341g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f8342h;

        /* renamed from: i, reason: collision with root package name */
        private String f8343i;

        /* renamed from: j, reason: collision with root package name */
        private int f8344j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f8345k;

        /* renamed from: l, reason: collision with root package name */
        private String f8346l;

        /* renamed from: m, reason: collision with root package name */
        private String f8347m;

        /* renamed from: n, reason: collision with root package name */
        private FilterBox f8348n;

        /* renamed from: o, reason: collision with root package name */
        private String f8349o;

        /* renamed from: p, reason: collision with root package name */
        private String f8350p;

        public Query() {
            this.f8342h = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAccessKey() {
            return this.f8349o;
        }

        public String getAdCode() {
            return this.f8335a;
        }

        public String getCity() {
            return this.f8336b;
        }

        public String getDataType() {
            return this.f8337c;
        }

        public FilterBox getFilterBox() {
            return this.f8348n;
        }

        public String getGeoObj() {
            return this.f8338d;
        }

        public String getKeywords() {
            return this.f8339e;
        }

        public LatLonPoint getLatLonPoint() {
            return this.f8345k;
        }

        public int getPageNum() {
            return this.f8340f;
        }

        public int getPageSize() {
            return this.f8341g;
        }

        public String getQueryType() {
            return this.f8343i;
        }

        public int getRange() {
            return this.f8344j;
        }

        public String getSecretKey() {
            return this.f8350p;
        }

        public String getUserCity() {
            return this.f8347m;
        }

        public String getUserLoc() {
            return this.f8346l;
        }

        public boolean isQii() {
            return this.f8342h;
        }

        public void setAccessKey(String str) {
            this.f8349o = str;
        }

        public void setAdCode(String str) {
            this.f8335a = str;
        }

        public void setCity(String str) {
            this.f8336b = str;
        }

        public void setDataType(String str) {
            this.f8337c = str;
        }

        public void setFilterBox(FilterBox filterBox) {
            this.f8348n = filterBox;
        }

        public void setGeoObj(String str) {
            this.f8338d = str;
        }

        public void setKeywords(String str) {
            this.f8339e = str;
        }

        public void setLatLonPoint(LatLonPoint latLonPoint) {
            this.f8345k = latLonPoint;
        }

        public void setPageNum(int i10) {
            this.f8340f = i10;
        }

        public void setPageSize(int i10) {
            this.f8341g = i10;
        }

        public void setQii(boolean z10) {
            this.f8342h = z10;
        }

        public void setQueryType(String str) {
            this.f8343i = str;
        }

        public void setRange(int i10) {
            this.f8344j = i10;
        }

        public void setSecretKey(String str) {
            this.f8350p = str;
        }

        public void setUserCity(String str) {
            this.f8347m = str;
        }

        public void setUserLoc(String str) {
            this.f8346l = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f8335a);
            parcel.writeString(this.f8336b);
            parcel.writeString(this.f8337c);
            parcel.writeString(this.f8338d);
            parcel.writeString(this.f8339e);
            parcel.writeInt(this.f8340f);
            parcel.writeInt(this.f8341g);
            parcel.writeByte(this.f8342h ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f8343i);
            parcel.writeInt(this.f8344j);
            parcel.writeParcelable(this.f8345k, i10);
            parcel.writeString(this.f8346l);
            parcel.writeString(this.f8347m);
            parcel.writeParcelable(this.f8348n, i10);
            parcel.writeString(this.f8349o);
            parcel.writeString(this.f8350p);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m1971clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            Query query = new Query();
            query.setAdCode(this.f8335a);
            query.setCity(this.f8336b);
            query.setDataType(this.f8337c);
            query.setGeoObj(this.f8338d);
            query.setKeywords(this.f8339e);
            query.setPageNum(this.f8340f);
            query.setPageSize(this.f8341g);
            query.setQii(this.f8342h);
            query.setQueryType(this.f8343i);
            query.setRange(this.f8344j);
            query.setLatLonPoint(this.f8345k);
            query.setUserLoc(this.f8346l);
            query.setUserCity(this.f8347m);
            query.setAccessKey(this.f8349o);
            query.setSecretKey(this.f8350p);
            query.setFilterBox(this.f8348n);
            return query;
        }

        public Query(Parcel parcel) {
            this.f8342h = false;
            this.f8335a = parcel.readString();
            this.f8336b = parcel.readString();
            this.f8337c = parcel.readString();
            this.f8338d = parcel.readString();
            this.f8339e = parcel.readString();
            this.f8340f = parcel.readInt();
            this.f8341g = parcel.readInt();
            this.f8342h = parcel.readByte() != 0;
            this.f8343i = parcel.readString();
            this.f8344j = parcel.readInt();
            this.f8345k = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f8346l = parcel.readString();
            this.f8347m = parcel.readString();
            this.f8348n = (FilterBox) parcel.readParcelable(FilterBox.class.getClassLoader());
            this.f8349o = parcel.readString();
            this.f8350p = parcel.readString();
        }
    }

    public AutoTSearch(Context context) throws AMapException {
        if (this.f8329a == null) {
            try {
                this.f8329a = new bf(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
            }
        }
    }

    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f8329a;
        if (iAutoTSearch == null) {
            return null;
        }
        return iAutoTSearch.searchChargeStation();
    }

    public void searchChargeStationAsync() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f8329a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.searchChargeStationAsync();
    }

    public void setChargeStationListener(OnChargeStationListener onChargeStationListener) {
        IAutoTSearch iAutoTSearch = this.f8329a;
        if (iAutoTSearch == null || onChargeStationListener == null) {
            return;
        }
        iAutoTSearch.setChargeStationListener(onChargeStationListener);
    }

    public void setQuery(Query query) {
        IAutoTSearch iAutoTSearch = this.f8329a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.setQuery(query);
    }
}
