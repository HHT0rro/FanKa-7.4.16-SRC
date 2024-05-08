package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherForecastHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bb extends bd<WeatherSearchQuery, LocalWeatherForecast> {

    /* renamed from: g, reason: collision with root package name */
    private LocalWeatherForecast f7142g;

    public bb(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f7142g = new LocalWeatherForecast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public LocalWeatherForecast a(String str) throws AMapException {
        LocalWeatherForecast h10 = v.h(str);
        this.f7142g = h10;
        return h10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) ((e) this).f7860b).getCity();
        if (!v.i(city)) {
            String b4 = f.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b4);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + bw.f(((e) this).f7863e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.bd, com.amap.api.col.s.dz
    public final /* bridge */ /* synthetic */ String b() {
        return super.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.amap.api.services.weather.WeatherSearchQuery] */
    @Override // com.amap.api.col.s.bd
    public final /* bridge */ /* synthetic */ WeatherSearchQuery c_() {
        return super.c_();
    }
}
