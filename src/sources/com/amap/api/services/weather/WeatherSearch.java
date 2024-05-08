package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.s.bu;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class WeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    private IWeatherSearch f9126a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i10);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i10);
    }

    public WeatherSearch(Context context) throws AMapException {
        this.f9126a = null;
        try {
            this.f9126a = new bu(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (e2 instanceof AMapException) {
                throw ((AMapException) e2);
            }
        }
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch iWeatherSearch = this.f9126a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void searchWeatherAsyn() {
        IWeatherSearch iWeatherSearch = this.f9126a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        IWeatherSearch iWeatherSearch = this.f9126a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        IWeatherSearch iWeatherSearch = this.f9126a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }
}
