package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InputtipsHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class u extends f<InputtipsQuery, ArrayList<Tip>> {
    public u(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> c(String str) throws AMapException {
        try {
            return v.j(new JSONObject(str));
        } catch (JSONException e2) {
            n.a(e2, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String b4 = f.b(((InputtipsQuery) ((e) this).f7860b).getKeyword());
        if (!TextUtils.isEmpty(b4)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(b4);
        }
        String city = ((InputtipsQuery) ((e) this).f7860b).getCity();
        if (!v.i(city)) {
            String b10 = f.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b10);
        }
        String type = ((InputtipsQuery) ((e) this).f7860b).getType();
        if (!v.i(type)) {
            String b11 = f.b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(b11);
        }
        if (((InputtipsQuery) ((e) this).f7860b).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) ((e) this).f7860b).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(bw.f(((e) this).f7863e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/assistant/inputtips?";
    }
}
