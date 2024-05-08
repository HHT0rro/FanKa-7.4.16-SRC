package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.bg;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusLineSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a, reason: collision with root package name */
    private IBusLineSearch f8380a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i10);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f8380a = null;
        try {
            this.f8380a = new bg(context, busLineQuery);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (e2 instanceof AMapException) {
                throw ((AMapException) e2);
            }
        }
    }

    public BusLineQuery getQuery() {
        IBusLineSearch iBusLineSearch = this.f8380a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.getQuery();
        }
        return null;
    }

    public BusLineResult searchBusLine() throws AMapException {
        IBusLineSearch iBusLineSearch = this.f8380a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.searchBusLine();
        }
        return null;
    }

    public void searchBusLineAsyn() {
        IBusLineSearch iBusLineSearch = this.f8380a;
        if (iBusLineSearch != null) {
            iBusLineSearch.searchBusLineAsyn();
        }
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        IBusLineSearch iBusLineSearch = this.f8380a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setOnBusLineSearchListener(onBusLineSearchListener);
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        IBusLineSearch iBusLineSearch = this.f8380a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setQuery(busLineQuery);
        }
    }
}
