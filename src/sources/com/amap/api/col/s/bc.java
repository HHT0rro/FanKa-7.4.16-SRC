package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherLiveHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bc extends bd<WeatherSearchQuery, LocalWeatherLive> {

    /* renamed from: g, reason: collision with root package name */
    private LocalWeatherLive f7143g;

    public bc(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f7143g = new LocalWeatherLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public LocalWeatherLive a(String str) throws AMapException {
        LocalWeatherLive g3 = v.g(str);
        this.f7143g = g3;
        return g3;
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
        stringBuffer.append("&extensions=base");
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
