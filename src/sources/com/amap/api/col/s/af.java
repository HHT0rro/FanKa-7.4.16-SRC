package com.amap.api.col.s;

import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import com.amap.api.col.s.am;
import com.amap.api.col.s.ao;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchKeywordsHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class af extends ac<aj, PoiResult> {

    /* renamed from: g, reason: collision with root package name */
    private int f7076g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7077h;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f7078i;

    /* renamed from: j, reason: collision with root package name */
    private List<SuggestionCity> f7079j;

    public af(Context context, aj ajVar) {
        super(context, ajVar);
        this.f7076g = 0;
        this.f7077h = false;
        this.f7078i = new ArrayList();
        this.f7079j = new ArrayList();
    }

    private static String b(boolean z10) {
        return z10 ? "distance" : ActivityChooserModel.ATTRIBUTE_WEIGHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public PoiResult a(String str) throws AMapException {
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            T t2 = ((e) this).f7860b;
            return PoiResult.createPagedResult(((aj) t2).f7087a, ((aj) t2).f7088b, this.f7078i, this.f7079j, ((aj) t2).f7087a.getPageSize(), this.f7076g, arrayList);
        }
        try {
            jSONObject = new JSONObject(str);
            this.f7076g = jSONObject.optInt("count");
            arrayList = v.c(jSONObject);
        } catch (JSONException e2) {
            n.a(e2, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e10) {
            n.a(e10, "PoiSearchKeywordHandler", "paseJSONException");
        }
        if (!jSONObject.has("suggestion")) {
            T t10 = ((e) this).f7860b;
            return PoiResult.createPagedResult(((aj) t10).f7087a, ((aj) t10).f7088b, this.f7078i, this.f7079j, ((aj) t10).f7087a.getPageSize(), this.f7076g, arrayList);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            T t11 = ((e) this).f7860b;
            return PoiResult.createPagedResult(((aj) t11).f7087a, ((aj) t11).f7088b, this.f7078i, this.f7079j, ((aj) t11).f7087a.getPageSize(), this.f7076g, arrayList);
        }
        this.f7079j = v.a(optJSONObject);
        this.f7078i = v.b(optJSONObject);
        T t12 = ((e) this).f7860b;
        return PoiResult.createPagedResult(((aj) t12).f7087a, ((aj) t12).f7088b, this.f7078i, this.f7079j, ((aj) t12).f7087a.getPageSize(), this.f7076g, arrayList);
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
        String str = m.a() + "/place";
        T t2 = ((e) this).f7860b;
        if (((aj) t2).f7088b == null) {
            return str + "/text?";
        }
        if (((aj) t2).f7088b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f7077h = true;
            return str2;
        }
        if (!((aj) ((e) this).f7860b).f7088b.getShape().equals("Rectangle") && !((aj) ((e) this).f7860b).f7088b.getShape().equals("Polygon")) {
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
        if (((aj) t2).f7088b != null) {
            if (((aj) t2).f7088b.getShape().equals("Bound")) {
                if (z10) {
                    double a10 = n.a(((aj) ((e) this).f7860b).f7088b.getCenter().getLongitude());
                    double a11 = n.a(((aj) ((e) this).f7860b).f7088b.getCenter().getLatitude());
                    sb2.append("&location=");
                    sb2.append(a10 + "," + a11);
                }
                sb2.append("&radius=");
                sb2.append(((aj) ((e) this).f7860b).f7088b.getRange());
                sb2.append("&sortrule=");
                sb2.append(b(((aj) ((e) this).f7860b).f7088b.isDistanceSort()));
            } else if (((aj) ((e) this).f7860b).f7088b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((aj) ((e) this).f7860b).f7088b.getLowerLeft();
                LatLonPoint upperRight = ((aj) ((e) this).f7860b).f7088b.getUpperRight();
                double a12 = n.a(lowerLeft.getLatitude());
                double a13 = n.a(lowerLeft.getLongitude());
                double a14 = n.a(upperRight.getLatitude());
                sb2.append("&polygon=" + a13 + "," + a12 + ";" + n.a(upperRight.getLongitude()) + "," + a14);
            } else if (((aj) ((e) this).f7860b).f7088b.getShape().equals("Polygon") && (polyGonList = ((aj) ((e) this).f7860b).f7088b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb2.append("&polygon=" + n.a(polyGonList));
            }
        }
        String city = ((aj) ((e) this).f7860b).f7087a.getCity();
        if (!ac.c(city)) {
            String b4 = f.b(city);
            sb2.append("&city=");
            sb2.append(b4);
        }
        String b10 = f.b(((aj) ((e) this).f7860b).f7087a.getQueryString());
        if (!ac.c(b10)) {
            sb2.append("&keywords=");
            sb2.append(b10);
        }
        sb2.append("&offset=");
        sb2.append(((aj) ((e) this).f7860b).f7087a.getPageSize());
        sb2.append("&page=");
        sb2.append(((aj) ((e) this).f7860b).f7087a.getPageNum());
        String building = ((aj) ((e) this).f7860b).f7087a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb2.append("&building=");
            sb2.append(((aj) ((e) this).f7860b).f7087a.getBuilding());
        }
        String b11 = f.b(((aj) ((e) this).f7860b).f7087a.getCategory());
        if (!ac.c(b11)) {
            sb2.append("&types=");
            sb2.append(b11);
        }
        if (!ac.c(((aj) ((e) this).f7860b).f7087a.getExtensions())) {
            sb2.append("&extensions=");
            sb2.append(((aj) ((e) this).f7860b).f7087a.getExtensions());
        } else {
            sb2.append("&extensions=base");
        }
        sb2.append("&key=");
        sb2.append(bw.f(((e) this).f7863e));
        if (((aj) ((e) this).f7860b).f7087a.getCityLimit()) {
            sb2.append("&citylimit=true");
        } else {
            sb2.append("&citylimit=false");
        }
        if (((aj) ((e) this).f7860b).f7087a.isRequireSubPois()) {
            sb2.append("&children=1");
        } else {
            sb2.append("&children=0");
        }
        if (this.f7077h) {
            if (((aj) ((e) this).f7860b).f7087a.isSpecial()) {
                sb2.append("&special=1");
            } else {
                sb2.append("&special=0");
            }
        }
        T t10 = ((e) this).f7860b;
        if (((aj) t10).f7088b == null && ((aj) t10).f7087a.getLocation() != null) {
            sb2.append("&sortrule=");
            sb2.append(b(((aj) ((e) this).f7860b).f7087a.isDistanceSort()));
            double a15 = n.a(((aj) ((e) this).f7860b).f7087a.getLocation().getLongitude());
            double a16 = n.a(((aj) ((e) this).f7860b).f7087a.getLocation().getLatitude());
            sb2.append("&location=");
            sb2.append(a15 + "," + a16);
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.e
    public final am.b e() {
        am.b bVar = new am.b();
        if (this.f7077h) {
            ao j10 = j();
            double d10 = ShadowDrawableWrapper.COS_45;
            if (j10 != null) {
                d10 = j10.a();
            }
            double d11 = d10;
            bVar.f7098a = b() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((aj) ((e) this).f7860b).f7088b.getShape().equals("Bound")) {
                bVar.f7099b = new ao.a(n.a(((aj) ((e) this).f7860b).f7088b.getCenter().getLatitude()), n.a(((aj) ((e) this).f7860b).f7088b.getCenter().getLongitude()), d11);
            }
        } else {
            bVar.f7098a = b() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }
}
