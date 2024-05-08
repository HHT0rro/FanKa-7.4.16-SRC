package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.amap.api.col.s.am;
import com.amap.api.col.s.ao;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResultV2;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchKeywordsHandlerV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ag extends ac<ak, PoiResultV2> {

    /* renamed from: g, reason: collision with root package name */
    private int f7080g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7081h;

    public ag(Context context, ak akVar) {
        super(context, akVar);
        this.f7080g = 0;
        this.f7081h = false;
    }

    private static String b(boolean z10) {
        return z10 ? "distance" : ActivityChooserModel.ATTRIBUTE_WEIGHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public PoiResultV2 a(String str) throws AMapException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        if (str == null) {
            T t2 = ((e) this).f7860b;
            return PoiResultV2.createPagedResult(((ak) t2).f7089a, ((ak) t2).f7090b, this.f7080g, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f7080g = jSONObject.optInt("count");
            arrayList = v.d(jSONObject);
        } catch (JSONException e2) {
            n.a(e2, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e10) {
            n.a(e10, "PoiSearchKeywordHandler", "paseJSONException");
        }
        T t10 = ((e) this).f7860b;
        return PoiResultV2.createPagedResult(((ak) t10).f7089a, ((ak) t10).f7090b, this.f7080g, arrayList);
    }

    private static ao j() {
        an a10 = am.a().a("regeo");
        if (a10 == null) {
            return null;
        }
        return (ao) a10;
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        return a(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dz
    public final String b() {
        String str = m.c() + "/place";
        T t2 = ((e) this).f7860b;
        if (((ak) t2).f7090b == null) {
            return str + "/text?";
        }
        if (((ak) t2).f7090b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f7081h = true;
            return str2;
        }
        if (!((ak) ((e) this).f7860b).f7090b.getShape().equals("Rectangle") && !((ak) ((e) this).f7860b).f7090b.getShape().equals("Polygon")) {
            return str;
        }
        return str + "/polygon?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String a(boolean z10) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json");
        T t2 = ((e) this).f7860b;
        if (((ak) t2).f7090b != null) {
            if (((ak) t2).f7090b.getShape().equals("Bound")) {
                if (z10) {
                    double a10 = n.a(((ak) ((e) this).f7860b).f7090b.getCenter().getLongitude());
                    double a11 = n.a(((ak) ((e) this).f7860b).f7090b.getCenter().getLatitude());
                    sb2.append("&location=");
                    sb2.append(a10 + "," + a11);
                }
                sb2.append("&radius=");
                sb2.append(((ak) ((e) this).f7860b).f7090b.getRange());
                sb2.append("&sortrule=");
                sb2.append(b(((ak) ((e) this).f7860b).f7090b.isDistanceSort()));
            } else if (((ak) ((e) this).f7860b).f7090b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((ak) ((e) this).f7860b).f7090b.getLowerLeft();
                LatLonPoint upperRight = ((ak) ((e) this).f7860b).f7090b.getUpperRight();
                double a12 = n.a(lowerLeft.getLatitude());
                double a13 = n.a(lowerLeft.getLongitude());
                double a14 = n.a(upperRight.getLatitude());
                sb2.append("&polygon=" + a13 + "," + a12 + ";" + n.a(upperRight.getLongitude()) + "," + a14);
            } else if (((ak) ((e) this).f7860b).f7090b.getShape().equals("Polygon") && (polyGonList = ((ak) ((e) this).f7860b).f7090b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb2.append("&polygon=" + n.a(polyGonList));
            }
        }
        String city = ((ak) ((e) this).f7860b).f7089a.getCity();
        if (!ac.c(city)) {
            String b4 = f.b(city);
            sb2.append("&region=");
            sb2.append(b4);
        }
        String b10 = f.b(((ak) ((e) this).f7860b).f7089a.getQueryString());
        if (!ac.c(b10)) {
            sb2.append("&keywords=");
            sb2.append(b10);
        }
        sb2.append("&page_size=");
        sb2.append(((ak) ((e) this).f7860b).f7089a.getPageSize());
        sb2.append("&page_num=");
        sb2.append(((ak) ((e) this).f7860b).f7089a.getPageNum());
        String building = ((ak) ((e) this).f7860b).f7089a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb2.append("&building=");
            sb2.append(((ak) ((e) this).f7860b).f7089a.getBuilding());
        }
        String b11 = f.b(((ak) ((e) this).f7860b).f7089a.getCategory());
        if (!ac.c(b11)) {
            sb2.append("&types=");
            sb2.append(b11);
        }
        String a15 = ac.a(((ak) ((e) this).f7860b).f7089a.getShowFields());
        if (a15 != null) {
            sb2.append("&show_fields=");
            sb2.append(a15);
        }
        sb2.append("&key=");
        sb2.append(bw.f(((e) this).f7863e));
        if (((ak) ((e) this).f7860b).f7089a.getCityLimit()) {
            sb2.append("&citylimit=true");
        } else {
            sb2.append("&citylimit=false");
        }
        if (this.f7081h) {
            if (((ak) ((e) this).f7860b).f7089a.isSpecial()) {
                sb2.append("&special=1");
            } else {
                sb2.append("&special=0");
            }
        }
        String channel = ((ak) ((e) this).f7860b).f7089a.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb2.append("&channel=");
            sb2.append(channel);
        }
        String premium = ((ak) ((e) this).f7860b).f7089a.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb2.append("&permium=");
            sb2.append(premium);
        }
        T t10 = ((e) this).f7860b;
        if (((ak) t10).f7090b == null && ((ak) t10).f7089a.getLocation() != null) {
            sb2.append("&sortrule=");
            sb2.append(b(((ak) ((e) this).f7860b).f7089a.isDistanceSort()));
            double a16 = n.a(((ak) ((e) this).f7860b).f7089a.getLocation().getLongitude());
            double a17 = n.a(((ak) ((e) this).f7860b).f7089a.getLocation().getLatitude());
            sb2.append("&location=");
            sb2.append(a16 + "," + a17);
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.e
    public final am.b e() {
        am.b bVar = new am.b();
        if (this.f7081h) {
            ao j10 = j();
            double d10 = ShadowDrawableWrapper.COS_45;
            if (j10 != null) {
                d10 = j10.a();
            }
            double d11 = d10;
            bVar.f7098a = b() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((ak) ((e) this).f7860b).f7090b.getShape().equals("Bound")) {
                bVar.f7099b = new ao.a(n.a(((ak) ((e) this).f7860b).f7090b.getCenter().getLatitude()), n.a(((ak) ((e) this).f7860b).f7090b.getCenter().getLongitude()), d11);
            }
        } else {
            bVar.f7098a = b() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }
}
