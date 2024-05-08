package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.bo;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.android.internal.logging.nano.MetricsProto;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearch f8641a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i10);

        void onPoiSearched(PoiResult poiResult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f8642a;

        /* renamed from: b, reason: collision with root package name */
        private String f8643b;

        /* renamed from: c, reason: collision with root package name */
        private String f8644c;

        /* renamed from: d, reason: collision with root package name */
        private int f8645d;

        /* renamed from: e, reason: collision with root package name */
        private int f8646e;

        /* renamed from: f, reason: collision with root package name */
        private String f8647f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8648g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f8649h;

        /* renamed from: i, reason: collision with root package name */
        private String f8650i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f8651j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f8652k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f8653l;

        /* renamed from: m, reason: collision with root package name */
        private String f8654m;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        private static String a() {
            return "";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            String str = this.f8643b;
            if (str == null) {
                if (query.f8643b != null) {
                    return false;
                }
            } else if (!str.equals(query.f8643b)) {
                return false;
            }
            String str2 = this.f8644c;
            if (str2 == null) {
                if (query.f8644c != null) {
                    return false;
                }
            } else if (!str2.equals(query.f8644c)) {
                return false;
            }
            String str3 = this.f8647f;
            if (str3 == null) {
                if (query.f8647f != null) {
                    return false;
                }
            } else if (!str3.equals(query.f8647f)) {
                return false;
            }
            if (this.f8645d != query.f8645d || this.f8646e != query.f8646e) {
                return false;
            }
            String str4 = this.f8642a;
            if (str4 == null) {
                if (query.f8642a != null) {
                    return false;
                }
            } else if (!str4.equals(query.f8642a)) {
                return false;
            }
            String str5 = this.f8650i;
            if (str5 == null) {
                if (query.f8650i != null) {
                    return false;
                }
            } else if (!str5.equals(query.f8650i)) {
                return false;
            }
            if (this.f8648g != query.f8648g || this.f8649h != query.f8649h || this.f8653l != query.f8653l) {
                return false;
            }
            String str6 = this.f8654m;
            if (str6 == null) {
                if (query.f8654m != null) {
                    return false;
                }
            } else if (!str6.equals(query.f8654m)) {
                return false;
            }
            return true;
        }

        public String getBuilding() {
            return this.f8650i;
        }

        public String getCategory() {
            String str = this.f8643b;
            if (str != null && !str.equals("00") && !this.f8643b.equals("00|")) {
                return this.f8643b;
            }
            return a();
        }

        public String getCity() {
            return this.f8644c;
        }

        public boolean getCityLimit() {
            return this.f8648g;
        }

        public String getExtensions() {
            return this.f8654m;
        }

        public LatLonPoint getLocation() {
            return this.f8652k;
        }

        public int getPageNum() {
            return this.f8645d;
        }

        public int getPageSize() {
            return this.f8646e;
        }

        public String getQueryLanguage() {
            return this.f8647f;
        }

        public String getQueryString() {
            return this.f8642a;
        }

        public int hashCode() {
            String str = this.f8643b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f8644c;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            boolean z10 = this.f8648g;
            int i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
            int i11 = (hashCode2 + (z10 ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT)) * 31;
            if (!this.f8649h) {
                i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
            }
            int i12 = (i11 + i10) * 31;
            String str3 = this.f8647f;
            int hashCode3 = (((((i12 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f8645d) * 31) + this.f8646e) * 31;
            String str4 = this.f8642a;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f8650i;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f8651j;
        }

        public boolean isRequireSubPois() {
            return this.f8649h;
        }

        public boolean isSpecial() {
            return this.f8653l;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.b(query.f8642a, this.f8642a) && PoiSearch.b(query.f8643b, this.f8643b) && PoiSearch.b(query.f8647f, this.f8647f) && PoiSearch.b(query.f8644c, this.f8644c) && PoiSearch.b(query.f8654m, this.f8654m) && PoiSearch.b(query.f8650i, this.f8650i) && query.f8648g == this.f8648g && query.f8646e == this.f8646e && query.f8651j == this.f8651j && query.f8653l == this.f8653l;
        }

        public void requireSubPois(boolean z10) {
            this.f8649h = z10;
        }

        public void setBuilding(String str) {
            this.f8650i = str;
        }

        public void setCityLimit(boolean z10) {
            this.f8648g = z10;
        }

        public void setDistanceSort(boolean z10) {
            this.f8651j = z10;
        }

        public void setExtensions(String str) {
            this.f8654m = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f8652k = latLonPoint;
        }

        public void setPageNum(int i10) {
            if (i10 <= 0) {
                i10 = 1;
            }
            this.f8645d = i10;
        }

        public void setPageSize(int i10) {
            if (i10 <= 0) {
                this.f8646e = 20;
            } else if (i10 > 30) {
                this.f8646e = 30;
            } else {
                this.f8646e = i10;
            }
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f8647f = "en";
            } else {
                this.f8647f = "zh-CN";
            }
        }

        public void setSpecial(boolean z10) {
            this.f8653l = z10;
        }

        public Query(String str, String str2, String str3) {
            this.f8645d = 1;
            this.f8646e = 20;
            this.f8647f = "zh-CN";
            this.f8648g = false;
            this.f8649h = false;
            this.f8651j = true;
            this.f8653l = true;
            this.f8654m = "base";
            this.f8642a = str;
            this.f8643b = str2;
            this.f8644c = str3;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m1977clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f8642a, this.f8643b, this.f8644c);
            query.setPageNum(this.f8645d);
            query.setPageSize(this.f8646e);
            query.setQueryLanguage(this.f8647f);
            query.setCityLimit(this.f8648g);
            query.requireSubPois(this.f8649h);
            query.setBuilding(this.f8650i);
            query.setLocation(this.f8652k);
            query.setDistanceSort(this.f8651j);
            query.setSpecial(this.f8653l);
            query.setExtensions(this.f8654m);
            return query;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f8655a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f8656b;

        /* renamed from: c, reason: collision with root package name */
        private int f8657c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f8658d;

        /* renamed from: e, reason: collision with root package name */
        private String f8659e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8660f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f8661g;

        public SearchBound(LatLonPoint latLonPoint, int i10) {
            this.f8660f = true;
            this.f8659e = "Bound";
            this.f8657c = i10;
            this.f8658d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8655a = latLonPoint;
            this.f8656b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f8656b.getLatitude() || this.f8655a.getLongitude() >= this.f8656b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f8658d = new LatLonPoint((this.f8655a.getLatitude() + this.f8656b.getLatitude()) / 2.0d, (this.f8655a.getLongitude() + this.f8656b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f8658d;
            if (latLonPoint == null) {
                if (searchBound.f8658d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f8658d)) {
                return false;
            }
            if (this.f8660f != searchBound.f8660f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f8655a;
            if (latLonPoint2 == null) {
                if (searchBound.f8655a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f8655a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f8656b;
            if (latLonPoint3 == null) {
                if (searchBound.f8656b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f8656b)) {
                return false;
            }
            List<LatLonPoint> list = this.f8661g;
            if (list == null) {
                if (searchBound.f8661g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f8661g)) {
                return false;
            }
            if (this.f8657c != searchBound.f8657c) {
                return false;
            }
            String str = this.f8659e;
            if (str == null) {
                if (searchBound.f8659e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.f8659e)) {
                return false;
            }
            return true;
        }

        public LatLonPoint getCenter() {
            return this.f8658d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f8655a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f8661g;
        }

        public int getRange() {
            return this.f8657c;
        }

        public String getShape() {
            return this.f8659e;
        }

        public LatLonPoint getUpperRight() {
            return this.f8656b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f8658d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f8660f ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT)) * 31;
            LatLonPoint latLonPoint2 = this.f8655a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f8656b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f8661g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f8657c) * 31;
            String str = this.f8659e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f8660f;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m1978clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f8655a, this.f8656b, this.f8657c, this.f8658d, this.f8659e, this.f8661g, this.f8660f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i10, boolean z10) {
            this.f8659e = "Bound";
            this.f8657c = i10;
            this.f8658d = latLonPoint;
            this.f8660f = z10;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8657c = 1500;
            this.f8660f = true;
            this.f8659e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f8657c = 1500;
            this.f8660f = true;
            this.f8659e = "Polygon";
            this.f8661g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i10, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z10) {
            this.f8655a = latLonPoint;
            this.f8656b = latLonPoint2;
            this.f8657c = i10;
            this.f8658d = latLonPoint3;
            this.f8659e = str;
            this.f8661g = list;
            this.f8660f = z10;
        }
    }

    public PoiSearch(Context context, Query query) throws AMapException {
        this.f8641a = null;
        try {
            this.f8641a = new bo(context, query);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (e2 instanceof AMapException) {
                throw ((AMapException) e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.f8641a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }
}
