package com.amap.api.services.routepoisearch;

import android.content.Context;
import com.amap.api.col.s.bq;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoutePOISearch {
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;

    /* renamed from: a, reason: collision with root package name */
    private IRoutePOISearch f9074a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnRoutePOISearchListener {
        void onRoutePoiSearched(RoutePOISearchResult routePOISearchResult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum RoutePOISearchType {
        TypeGasStation,
        TypeMaintenanceStation,
        TypeATM,
        TypeToilet,
        TypeFillingStation,
        TypeServiceArea,
        TypeChargeStation,
        TypeFood,
        TypeHotel
    }

    public RoutePOISearch(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        if (this.f9074a == null) {
            try {
                this.f9074a = new bq(context, routePOISearchQuery);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
            }
        }
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        IRoutePOISearch iRoutePOISearch = this.f9074a;
        if (iRoutePOISearch != null) {
            return iRoutePOISearch.searchRoutePOI();
        }
        return null;
    }

    public void searchRoutePOIAsyn() {
        IRoutePOISearch iRoutePOISearch = this.f9074a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.searchRoutePOIAsyn();
        }
    }

    public void setPoiSearchListener(OnRoutePOISearchListener onRoutePOISearchListener) {
        IRoutePOISearch iRoutePOISearch = this.f9074a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setRoutePOISearchListener(onRoutePOISearchListener);
        }
    }

    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        IRoutePOISearch iRoutePOISearch = this.f9074a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setQuery(routePOISearchQuery);
        }
    }
}
