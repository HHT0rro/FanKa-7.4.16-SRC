package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;

    /* renamed from: a, reason: collision with root package name */
    private IShareSearch f9085a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i10);

        void onDrivingRouteShareUrlSearched(String str, int i10);

        void onLocationShareUrlSearched(String str, int i10);

        void onNaviShareUrlSearched(String str, int i10);

        void onPoiShareUrlSearched(String str, int i10);

        void onWalkRouteShareUrlSearched(String str, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ShareBusRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9086a;

        /* renamed from: b, reason: collision with root package name */
        private int f9087b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f9086a = shareFromAndTo;
            this.f9087b = i10;
        }

        public int getBusMode() {
            return this.f9087b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f9086a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ShareDrivingRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9088a;

        /* renamed from: b, reason: collision with root package name */
        private int f9089b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f9088a = shareFromAndTo;
            this.f9089b = i10;
        }

        public int getDrivingMode() {
            return this.f9089b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f9088a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ShareFromAndTo {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f9090a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f9091b;

        /* renamed from: c, reason: collision with root package name */
        private String f9092c = "起点";

        /* renamed from: d, reason: collision with root package name */
        private String f9093d = "终点";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9090a = latLonPoint;
            this.f9091b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f9090a;
        }

        public String getFromName() {
            return this.f9092c;
        }

        public LatLonPoint getTo() {
            return this.f9091b;
        }

        public String getToName() {
            return this.f9093d;
        }

        public void setFromName(String str) {
            this.f9092c = str;
        }

        public void setToName(String str) {
            this.f9093d = str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ShareNaviQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9094a;

        /* renamed from: b, reason: collision with root package name */
        private int f9095b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f9094a = shareFromAndTo;
            this.f9095b = i10;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.f9094a;
        }

        public int getNaviMode() {
            return this.f9095b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ShareWalkRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9096a;

        /* renamed from: b, reason: collision with root package name */
        private int f9097b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i10) {
            this.f9096a = shareFromAndTo;
            this.f9097b = i10;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f9096a;
        }

        public int getWalkMode() {
            return this.f9097b;
        }
    }

    public ShareSearch(Context context) throws AMapException {
        if (this.f9085a == null) {
            try {
                this.f9085a = new bt(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
            }
        }
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchLocationShareUrl(latLonSharePoint);
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchNaviShareUrl(shareNaviQuery);
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchPoiShareUrl(poiItem);
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f9085a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }
}
