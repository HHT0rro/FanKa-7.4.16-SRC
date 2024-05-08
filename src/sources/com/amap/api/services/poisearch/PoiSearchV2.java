package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.bp;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.android.internal.logging.nano.MetricsProto;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PoiSearchV2 {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearchV2 f8662a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItemV2 poiItemV2, int i10);

        void onPoiSearched(PoiResultV2 poiResultV2, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PremiumType {
        DEFAULT(""),
        ENTIRETY("entirety_poi");


        /* renamed from: a, reason: collision with root package name */
        private final String f8664a;

        PremiumType(String str) {
            this.f8664a = str;
        }

        public final String a() {
            return this.f8664a;
        }

        public static PremiumType a(String str) {
            PremiumType premiumType = DEFAULT;
            if (str.equals(premiumType.a())) {
                return premiumType;
            }
            PremiumType premiumType2 = ENTIRETY;
            return str.equals(premiumType2.a()) ? premiumType2 : premiumType;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f8665a;

        /* renamed from: b, reason: collision with root package name */
        private String f8666b;

        /* renamed from: c, reason: collision with root package name */
        private String f8667c;

        /* renamed from: d, reason: collision with root package name */
        private int f8668d;

        /* renamed from: e, reason: collision with root package name */
        private int f8669e;

        /* renamed from: f, reason: collision with root package name */
        private String f8670f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8671g;

        /* renamed from: h, reason: collision with root package name */
        private String f8672h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f8673i;

        /* renamed from: j, reason: collision with root package name */
        private LatLonPoint f8674j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f8675k;

        /* renamed from: l, reason: collision with root package name */
        private String f8676l;

        /* renamed from: m, reason: collision with root package name */
        private String f8677m;

        /* renamed from: n, reason: collision with root package name */
        private ShowFields f8678n;

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
            String str = this.f8666b;
            if (str == null) {
                if (query.f8666b != null) {
                    return false;
                }
            } else if (!str.equals(query.f8666b)) {
                return false;
            }
            String str2 = this.f8667c;
            if (str2 == null) {
                if (query.f8667c != null) {
                    return false;
                }
            } else if (!str2.equals(query.f8667c)) {
                return false;
            }
            String str3 = this.f8670f;
            if (str3 == null) {
                if (query.f8670f != null) {
                    return false;
                }
            } else if (!str3.equals(query.f8670f)) {
                return false;
            }
            if (this.f8668d != query.f8668d || this.f8669e != query.f8669e) {
                return false;
            }
            String str4 = this.f8665a;
            if (str4 == null) {
                if (query.f8665a != null) {
                    return false;
                }
            } else if (!str4.equals(query.f8665a)) {
                return false;
            }
            String str5 = this.f8676l;
            if (str5 == null) {
                if (query.f8676l != null) {
                    return false;
                }
            } else if (!str5.equals(query.f8676l)) {
                return false;
            }
            String str6 = this.f8677m;
            if (str6 == null) {
                if (query.f8677m != null) {
                    return false;
                }
            } else if (!str6.equals(query.f8677m)) {
                return false;
            }
            String str7 = this.f8672h;
            if (str7 == null) {
                if (query.f8672h != null) {
                    return false;
                }
            } else if (!str7.equals(query.f8672h)) {
                return false;
            }
            if (this.f8671g != query.f8671g || this.f8675k != query.f8675k) {
                return false;
            }
            int i10 = this.f8678n.value;
            return true;
        }

        public String getBuilding() {
            return this.f8672h;
        }

        public String getCategory() {
            String str = this.f8666b;
            if (str != null && !str.equals("00") && !this.f8666b.equals("00|")) {
                return this.f8666b;
            }
            return a();
        }

        public String getChannel() {
            return this.f8676l;
        }

        public String getCity() {
            return this.f8667c;
        }

        public boolean getCityLimit() {
            return this.f8671g;
        }

        public LatLonPoint getLocation() {
            return this.f8674j;
        }

        public int getPageNum() {
            return this.f8668d;
        }

        public int getPageSize() {
            return this.f8669e;
        }

        public String getPremium() {
            return this.f8677m;
        }

        public String getQueryLanguage() {
            return this.f8670f;
        }

        public String getQueryString() {
            return this.f8665a;
        }

        public ShowFields getShowFields() {
            return this.f8678n;
        }

        public int hashCode() {
            String str = this.f8666b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f8676l;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f8677m;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f8667c;
            int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + (this.f8671g ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT)) * 31;
            String str5 = this.f8670f;
            int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f8668d) * 31) + this.f8669e) * 31;
            String str6 = this.f8665a;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.f8672h;
            return ((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + (this.f8678n.value % 1024);
        }

        public boolean isDistanceSort() {
            return this.f8673i;
        }

        public boolean isSpecial() {
            return this.f8675k;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearchV2.b(query.f8665a, this.f8665a) && PoiSearchV2.b(query.f8666b, this.f8666b) && PoiSearchV2.b(query.f8670f, this.f8670f) && PoiSearchV2.b(query.f8667c, this.f8667c) && PoiSearchV2.b(query.f8672h, this.f8672h) && PoiSearchV2.b(query.f8676l, this.f8676l) && PoiSearchV2.b(query.f8677m, this.f8677m) && query.f8671g == this.f8671g && query.f8669e == this.f8669e && query.f8673i == this.f8673i && query.f8675k == this.f8675k && query.f8678n.value == this.f8678n.value;
        }

        public void setBuilding(String str) {
            this.f8672h = str;
        }

        public void setChannel(String str) {
            this.f8676l = str;
        }

        public void setCityLimit(boolean z10) {
            this.f8671g = z10;
        }

        public void setDistanceSort(boolean z10) {
            this.f8673i = z10;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f8674j = latLonPoint;
        }

        public void setPageNum(int i10) {
            if (i10 <= 0) {
                i10 = 1;
            }
            this.f8668d = i10;
        }

        public void setPageSize(int i10) {
            if (i10 <= 0) {
                this.f8669e = 20;
            } else if (i10 > 30) {
                this.f8669e = 30;
            } else {
                this.f8669e = i10;
            }
        }

        public void setPremium(PremiumType premiumType) {
            if (premiumType == null) {
                return;
            }
            this.f8677m = premiumType.a();
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f8670f = "en";
            } else {
                this.f8670f = "zh-CN";
            }
        }

        public void setShowFields(ShowFields showFields) {
            if (showFields == null) {
                this.f8678n = new ShowFields();
            } else {
                this.f8678n = showFields;
            }
        }

        public void setSpecial(boolean z10) {
            this.f8675k = z10;
        }

        public Query(String str, String str2, String str3) {
            this.f8668d = 1;
            this.f8669e = 20;
            this.f8670f = "zh-CN";
            this.f8671g = false;
            this.f8673i = true;
            this.f8675k = true;
            this.f8677m = PremiumType.DEFAULT.a();
            this.f8678n = new ShowFields();
            this.f8665a = str;
            this.f8666b = str2;
            this.f8667c = str3;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m1979clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f8665a, this.f8666b, this.f8667c);
            query.setPageNum(this.f8668d);
            query.setPageSize(this.f8669e);
            query.setQueryLanguage(this.f8670f);
            query.setCityLimit(this.f8671g);
            query.setBuilding(this.f8672h);
            query.setLocation(this.f8674j);
            query.setDistanceSort(this.f8673i);
            query.setSpecial(this.f8675k);
            query.setChannel(this.f8676l);
            query.setPremium(PremiumType.a(this.f8677m));
            query.setShowFields(new ShowFields(this.f8678n.value));
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
        private LatLonPoint f8679a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f8680b;

        /* renamed from: c, reason: collision with root package name */
        private int f8681c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f8682d;

        /* renamed from: e, reason: collision with root package name */
        private String f8683e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8684f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f8685g;

        public SearchBound(LatLonPoint latLonPoint, int i10) {
            this.f8684f = true;
            this.f8683e = "Bound";
            this.f8681c = i10;
            this.f8682d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8679a = latLonPoint;
            this.f8680b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f8680b.getLatitude() || this.f8679a.getLongitude() >= this.f8680b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f8682d = new LatLonPoint((this.f8679a.getLatitude() + this.f8680b.getLatitude()) / 2.0d, (this.f8679a.getLongitude() + this.f8680b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f8682d;
            if (latLonPoint == null) {
                if (searchBound.f8682d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f8682d)) {
                return false;
            }
            if (this.f8684f != searchBound.f8684f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f8679a;
            if (latLonPoint2 == null) {
                if (searchBound.f8679a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f8679a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f8680b;
            if (latLonPoint3 == null) {
                if (searchBound.f8680b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f8680b)) {
                return false;
            }
            List<LatLonPoint> list = this.f8685g;
            if (list == null) {
                if (searchBound.f8685g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f8685g)) {
                return false;
            }
            if (this.f8681c != searchBound.f8681c) {
                return false;
            }
            String str = this.f8683e;
            if (str == null) {
                if (searchBound.f8683e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.f8683e)) {
                return false;
            }
            return true;
        }

        public LatLonPoint getCenter() {
            return this.f8682d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f8679a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f8685g;
        }

        public int getRange() {
            return this.f8681c;
        }

        public String getShape() {
            return this.f8683e;
        }

        public LatLonPoint getUpperRight() {
            return this.f8680b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f8682d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f8684f ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT)) * 31;
            LatLonPoint latLonPoint2 = this.f8679a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f8680b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f8685g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f8681c) * 31;
            String str = this.f8683e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f8684f;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m1980clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f8679a, this.f8680b, this.f8681c, this.f8682d, this.f8683e, this.f8685g, this.f8684f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i10, boolean z10) {
            this.f8683e = "Bound";
            this.f8681c = i10;
            this.f8682d = latLonPoint;
            this.f8684f = z10;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8681c = 1500;
            this.f8684f = true;
            this.f8683e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f8681c = 1500;
            this.f8684f = true;
            this.f8683e = "Polygon";
            this.f8685g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i10, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z10) {
            this.f8679a = latLonPoint;
            this.f8680b = latLonPoint2;
            this.f8681c = i10;
            this.f8682d = latLonPoint3;
            this.f8683e = str;
            this.f8685g = list;
            this.f8684f = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int BUSINESS = 2;
        public static final int CHILDREN = 1;
        public static final int DEFAULT = 0;
        public static final int INDOOR = 4;
        public static final int NAVI = 8;
        public static final int PHOTOS = 16;
        public int value;

        public ShowFields() {
            this.value = 0;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i10) {
            this.value = i10;
        }

        public ShowFields(int i10) {
            this.value = i10;
        }
    }

    public PoiSearchV2(Context context, Query query) throws AMapException {
        this.f8662a = null;
        try {
            this.f8662a = new bp(context, query);
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
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getBound();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getQuery();
        }
        return null;
    }

    public PoiResultV2 searchPOI() throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIAsyn();
        }
    }

    public PoiItemV2 searchPOIId(String str) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setBound(searchBound);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearchV2 iPoiSearchV2 = this.f8662a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setQuery(query);
        }
    }
}
