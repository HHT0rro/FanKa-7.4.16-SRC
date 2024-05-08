package com.amap.api.services.weather;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LocalWeatherForecastResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f9113a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherForecast f9114b;

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f9113a = weatherSearchQuery;
        this.f9114b = localWeatherForecast;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.f9114b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f9113a;
    }
}
