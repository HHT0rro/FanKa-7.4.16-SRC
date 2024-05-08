package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.s.ah;
import com.amap.api.col.s.bi;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import com.android.internal.logging.nano.MetricsProto;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CloudSearch {

    /* renamed from: a, reason: collision with root package name */
    private ICloudSearch f8412a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i10);

        void onCloudSearched(CloudResult cloudResult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f8413a;

        /* renamed from: d, reason: collision with root package name */
        private String f8416d;

        /* renamed from: e, reason: collision with root package name */
        private SearchBound f8417e;

        /* renamed from: f, reason: collision with root package name */
        private Sortingrules f8418f;

        /* renamed from: b, reason: collision with root package name */
        private int f8414b = 1;

        /* renamed from: c, reason: collision with root package name */
        private int f8415c = 20;

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<ah> f8419g = new ArrayList<>();

        /* renamed from: h, reason: collision with root package name */
        private List<String> f8420h = new ArrayList();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (!n.a(str) && searchBound != null) {
                this.f8416d = str;
                this.f8413a = str2;
                this.f8417e = searchBound;
                return;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }

        private ArrayList<ah> a() {
            if (this.f8419g == null) {
                return null;
            }
            ArrayList<ah> arrayList = new ArrayList<>();
            arrayList.addAll(this.f8419g);
            return arrayList;
        }

        private ArrayList<String> b() {
            if (this.f8420h == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.f8420h);
            return arrayList;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.f8419g.add(new ah(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            this.f8420h.add(str + str2);
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                if (queryEquals(query) && query.f8414b == this.f8414b) {
                    return true;
                }
            }
            return false;
        }

        public SearchBound getBound() {
            return this.f8417e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f8419g.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ah ahVar = this.f8419g.get(i10);
                    stringBuffer.append(ahVar.a());
                    stringBuffer.append(">=");
                    stringBuffer.append(ahVar.b());
                    stringBuffer.append("&&");
                    stringBuffer.append(ahVar.a());
                    stringBuffer.append("<=");
                    stringBuffer.append(ahVar.c());
                    if (i10 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f8420h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    stringBuffer.append(this.f8420h.get(i10));
                    if (i10 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.f8414b;
        }

        public int getPageSize() {
            return this.f8415c;
        }

        public String getQueryString() {
            return this.f8413a;
        }

        public Sortingrules getSortingrules() {
            return this.f8418f;
        }

        public String getTableID() {
            return this.f8416d;
        }

        public int hashCode() {
            ArrayList<ah> arrayList = this.f8419g;
            int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
            List<String> list = this.f8420h;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            SearchBound searchBound = this.f8417e;
            int hashCode3 = (((((hashCode2 + (searchBound == null ? 0 : searchBound.hashCode())) * 31) + this.f8414b) * 31) + this.f8415c) * 31;
            String str = this.f8413a;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Sortingrules sortingrules = this.f8418f;
            int hashCode5 = (hashCode4 + (sortingrules == null ? 0 : sortingrules.hashCode())) * 31;
            String str2 = this.f8416d;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return CloudSearch.b(query.f8413a, this.f8413a) && CloudSearch.b(query.getTableID(), getTableID()) && CloudSearch.b(query.getFilterString(), getFilterString()) && CloudSearch.b(query.getFilterNumString(), getFilterNumString()) && query.f8415c == this.f8415c && a(query.getBound(), getBound()) && a(query.getSortingrules(), getSortingrules());
        }

        public void setBound(SearchBound searchBound) {
            this.f8417e = searchBound;
        }

        public void setPageNum(int i10) {
            this.f8414b = i10;
        }

        public void setPageSize(int i10) {
            if (i10 <= 0) {
                this.f8415c = 20;
            } else if (i10 > 100) {
                this.f8415c = 100;
            } else {
                this.f8415c = i10;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f8418f = sortingrules;
        }

        public void setTableID(String str) {
            this.f8416d = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.amap.api.services.cloud.CloudSearch.Query m1974clone() {
            /*
                r6 = this;
                super.clone()     // Catch: java.lang.CloneNotSupportedException -> L4
                goto L8
            L4:
                r0 = move-exception
                r0.printStackTrace()
            L8:
                r0 = 0
                com.amap.api.services.cloud.CloudSearch$Query r1 = new com.amap.api.services.cloud.CloudSearch$Query     // Catch: com.amap.api.services.core.AMapException -> L34
                java.lang.String r2 = r6.f8416d     // Catch: com.amap.api.services.core.AMapException -> L34
                java.lang.String r3 = r6.f8413a     // Catch: com.amap.api.services.core.AMapException -> L34
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r6.f8417e     // Catch: com.amap.api.services.core.AMapException -> L34
                r1.<init>(r2, r3, r4)     // Catch: com.amap.api.services.core.AMapException -> L34
                int r0 = r6.f8414b     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageNum(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                int r0 = r6.f8415c     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageSize(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                com.amap.api.services.cloud.CloudSearch$Sortingrules r0 = r6.getSortingrules()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setSortingrules(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.a()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f8419g = r0     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.b()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f8420h = r0     // Catch: com.amap.api.services.core.AMapException -> L32
                goto L3b
            L32:
                r0 = move-exception
                goto L38
            L34:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L38:
                r0.printStackTrace()
            L3b:
                if (r1 != 0) goto L43
                com.amap.api.services.cloud.CloudSearch$Query r0 = new com.amap.api.services.cloud.CloudSearch$Query
                r0.<init>()
                return r0
            L43:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.m1974clone():com.amap.api.services.cloud.CloudSearch$Query");
        }

        private static boolean a(SearchBound searchBound, SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        private static boolean a(Sortingrules sortingrules, Sortingrules sortingrules2) {
            if (sortingrules == null && sortingrules2 == null) {
                return true;
            }
            if (sortingrules == null || sortingrules2 == null) {
                return false;
            }
            return sortingrules.equals(sortingrules2);
        }

        private Query() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f8421a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f8422b;

        /* renamed from: c, reason: collision with root package name */
        private int f8423c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f8424d;

        /* renamed from: e, reason: collision with root package name */
        private String f8425e;

        /* renamed from: f, reason: collision with root package name */
        private List<LatLonPoint> f8426f;

        /* renamed from: g, reason: collision with root package name */
        private String f8427g;

        public SearchBound(LatLonPoint latLonPoint, int i10) {
            this.f8425e = "Bound";
            this.f8423c = i10;
            this.f8424d = latLonPoint;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8421a = latLonPoint;
            this.f8422b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.f8422b.getLatitude() && this.f8421a.getLongitude() < this.f8422b.getLongitude();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    return searchBound.f8424d.equals(this.f8424d) && searchBound.f8423c == this.f8423c;
                }
                if (getShape().equals("Polygon")) {
                    return a(searchBound.f8426f, this.f8426f);
                }
                if (getShape().equals(LOCAL_SHAPE)) {
                    return searchBound.f8427g.equals(this.f8427g);
                }
                if (searchBound.f8421a.equals(this.f8421a) && searchBound.f8422b.equals(this.f8422b)) {
                    return true;
                }
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f8424d;
        }

        public String getCity() {
            return this.f8427g;
        }

        public LatLonPoint getLowerLeft() {
            return this.f8421a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f8426f;
        }

        public int getRange() {
            return this.f8423c;
        }

        public String getShape() {
            return this.f8425e;
        }

        public LatLonPoint getUpperRight() {
            return this.f8422b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f8424d;
            int hashCode = ((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint2 = this.f8421a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f8422b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f8426f;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f8423c) * 31;
            String str = this.f8425e;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f8427g;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m1975clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.f8424d, this.f8423c);
            }
            if (getShape().equals("Polygon")) {
                return new SearchBound(a());
            }
            if (getShape().equals(LOCAL_SHAPE)) {
                return new SearchBound(this.f8427g);
            }
            return new SearchBound(this.f8421a, this.f8422b);
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8425e = "Rectangle";
            if (a(latLonPoint, latLonPoint2)) {
                return;
            }
            new IllegalArgumentException("invalid rect ").printStackTrace();
        }

        private static boolean a(List<LatLonPoint> list, List<LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!list.get(i10).equals(list2.get(i10))) {
                    return false;
                }
            }
            return true;
        }

        private List<LatLonPoint> a() {
            if (this.f8426f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint latLonPoint : this.f8426f) {
                arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f8425e = "Polygon";
            this.f8426f = list;
        }

        public SearchBound(String str) {
            this.f8425e = LOCAL_SHAPE;
            this.f8427g = str;
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.f8412a == null) {
            try {
                this.f8412a = new bi(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
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

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.f8412a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.f8412a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.f8412a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f8428a;

        /* renamed from: b, reason: collision with root package name */
        private String f8429b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8430c;

        public Sortingrules(String str, boolean z10) {
            this.f8428a = 0;
            this.f8429b = str;
            this.f8430c = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sortingrules sortingrules = (Sortingrules) obj;
            if (this.f8430c != sortingrules.f8430c) {
                return false;
            }
            String str = this.f8429b;
            if (str == null) {
                if (sortingrules.f8429b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.f8429b)) {
                return false;
            }
            return this.f8428a == sortingrules.f8428a;
        }

        public int hashCode() {
            int i10 = ((this.f8430c ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT) + 31) * 31;
            String str = this.f8429b;
            return ((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.f8428a;
        }

        public String toString() {
            if (n.a(this.f8429b)) {
                int i10 = this.f8428a;
                return i10 == 0 ? "_weight:desc" : i10 == 1 ? "_distance:asc" : "";
            }
            if (this.f8430c) {
                return this.f8429b + ":asc";
            }
            return this.f8429b + ":desc";
        }

        public Sortingrules(int i10) {
            this.f8430c = true;
            this.f8428a = i10;
        }
    }
}
