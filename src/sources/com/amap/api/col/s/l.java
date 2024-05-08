package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchKeywordsHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class l extends j<CloudSearch.Query, CloudResult> {

    /* renamed from: g, reason: collision with root package name */
    private int f7972g;

    public l(Context context, CloudSearch.Query query) {
        super(context, query);
        this.f7972g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str != null && !str.equals("")) {
            try {
                arrayList = d(new JSONObject(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            T t2 = ((e) this).f7860b;
            return CloudResult.createPagedResult((CloudSearch.Query) t2, this.f7972g, ((CloudSearch.Query) t2).getBound(), ((CloudSearch.Query) ((e) this).f7860b).getPageSize(), arrayList);
        }
        T t10 = ((e) this).f7860b;
        return CloudResult.createPagedResult((CloudSearch.Query) t10, this.f7972g, ((CloudSearch.Query) t10).getBound(), ((CloudSearch.Query) ((e) this).f7860b).getPageSize(), null);
    }

    private ArrayList<CloudItem> d(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray a10 = j.a(jSONObject);
        if (a10 == null) {
            return arrayList;
        }
        this.f7972g = j.b(jSONObject);
        for (int i10 = 0; i10 < a10.length(); i10++) {
            JSONObject optJSONObject = a10.optJSONObject(i10);
            CloudItemDetail c4 = j.c(optJSONObject);
            j.a(c4, optJSONObject);
            arrayList.add(c4);
        }
        return arrayList;
    }

    private static String e(String str) {
        return str != null ? str.replace("&&", "%26%26") : str;
    }

    private static String g(String str) {
        try {
        } catch (Throwable th) {
            dc.a(th, "ut", "sPa");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = e(str);
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        String f10 = f(stringBuffer.toString());
        if (f10.length() > 1) {
            return (String) f10.subSequence(0, f10.length() - 1);
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        return ((CloudSearch.Query) ((e) this).f7860b).getSortingrules() != null ? ((CloudSearch.Query) ((e) this).f7860b).getSortingrules().toString() : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String z() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) ((e) this).f7860b).getFilterString();
        String filterNumString = ((CloudSearch.Query) ((e) this).f7860b).getFilterNumString();
        stringBuffer.append(filterString);
        if (!n.a(filterString) && !n.a(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dz
    public final String b() {
        String str = m.e() + "/datasearch";
        String shape = ((CloudSearch.Query) ((e) this).f7860b).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        }
        if (!shape.equals("Polygon") && !shape.equals("Rectangle")) {
            if (!shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                return str;
            }
            return str + "/local";
        }
        return str + "/polygon";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e, com.amap.api.col.s.dz
    public final Map<String, String> f() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", bw.f(((e) this).f7863e));
        hashtable.put("output", "json");
        if (((CloudSearch.Query) ((e) this).f7860b).getBound() != null) {
            if (((CloudSearch.Query) ((e) this).f7860b).getBound().getShape().equals("Bound")) {
                hashtable.put(CSSAlignValue.AlignKey.CENTER, n.a(((CloudSearch.Query) ((e) this).f7860b).getBound().getCenter().getLongitude()) + "," + n.a(((CloudSearch.Query) ((e) this).f7860b).getBound().getCenter().getLatitude()));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(((CloudSearch.Query) ((e) this).f7860b).getBound().getRange());
                hashtable.put("radius", sb2.toString());
            } else if (((CloudSearch.Query) ((e) this).f7860b).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) ((e) this).f7860b).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) ((e) this).f7860b).getBound().getUpperRight();
                double a10 = n.a(lowerLeft.getLatitude());
                double a11 = n.a(lowerLeft.getLongitude());
                double a12 = n.a(upperRight.getLatitude());
                hashtable.put("polygon", a11 + "," + a10 + ";" + n.a(upperRight.getLongitude()) + "," + a12);
            } else if (((CloudSearch.Query) ((e) this).f7860b).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) ((e) this).f7860b).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", n.a(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) ((e) this).f7860b).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put(DistrictSearchQuery.KEYWORDS_CITY, ((CloudSearch.Query) ((e) this).f7860b).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) ((e) this).f7860b).getTableID());
        if (!n.a(j())) {
            hashtable.put("sortrule", j());
        }
        String z10 = z();
        if (!n.a(z10)) {
            hashtable.put(Attributes.Style.FILTER, z10);
        }
        String queryString = ((CloudSearch.Query) ((e) this).f7860b).getQueryString();
        if (queryString != null && !"".equals(queryString)) {
            hashtable.put("keywords", queryString);
        } else {
            hashtable.put("keywords", "");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) ((e) this).f7860b).getPageSize());
        hashtable.put("pageSize", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((CloudSearch.Query) ((e) this).f7860b).getPageNum());
        hashtable.put("pageNum", sb4.toString());
        String a13 = bz.a();
        String a14 = bz.a(((e) this).f7863e, a13, a(hashtable));
        hashtable.put("ts", a13);
        hashtable.put("scode", a14);
        return hashtable;
    }

    private static String a(Map<String, String> map) {
        return g(b(map));
    }

    private static String b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue());
        }
        return sb2.toString();
    }

    private static String f(String str) {
        return str != null ? str.replace("%26%26", "&&") : str;
    }
}
