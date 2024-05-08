package com.amap.api.services.weather;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LocalWeatherLiveResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f9124a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherLive f9125b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f9124a = weatherSearchQuery;
        this.f9125b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.f9125b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f9124a;
    }
}
