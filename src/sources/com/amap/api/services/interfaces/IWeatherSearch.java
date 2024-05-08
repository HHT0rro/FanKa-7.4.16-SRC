package com.amap.api.services.interfaces;

import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IWeatherSearch {
    WeatherSearchQuery getQuery();

    void searchWeatherAsyn();

    void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener);

    void setQuery(WeatherSearchQuery weatherSearchQuery);
}
