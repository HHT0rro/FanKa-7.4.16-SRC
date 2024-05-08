package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RoutePOISearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class at extends f<RoutePOISearchQuery, RoutePOISearchResult> {

    /* compiled from: RoutePOISearchHandler.java */
    /* renamed from: com.amap.api.col.s.at$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7132a;

        static {
            int[] iArr = new int[RoutePOISearch.RoutePOISearchType.values().length];
            f7132a = iArr;
            try {
                iArr[RoutePOISearch.RoutePOISearchType.TypeGasStation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeMaintenanceStation.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeATM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeToilet.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeFillingStation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeServiceArea.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeChargeStation.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeFood.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7132a[RoutePOISearch.RoutePOISearchType.TypeHotel.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public at(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public RoutePOISearchResult a(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = v.k(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) ((e) this).f7860b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bw.f(((e) this).f7863e));
        stringBuffer.append("&range=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RoutePOISearchQuery) ((e) this).f7860b).getRange());
        stringBuffer.append(sb2.toString());
        String str = "";
        try {
            switch (AnonymousClass1.f7132a[((RoutePOISearchQuery) ((e) this).f7860b).getSearchType().ordinal()]) {
                case 1:
                    str = "010100";
                    break;
                case 2:
                    str = "030000";
                    break;
                case 3:
                    str = "160300";
                    break;
                case 4:
                    str = "200300";
                    break;
                case 5:
                    str = "010300";
                    break;
                case 6:
                    str = "180300";
                    break;
                case 7:
                    str = "011100";
                    break;
                case 8:
                    str = "050000";
                    break;
                case 9:
                    str = "100000";
                    break;
            }
        } catch (Exception unused) {
        }
        if (((RoutePOISearchQuery) ((e) this).f7860b).getPolylines() != null && ((RoutePOISearchQuery) ((e) this).f7860b).getPolylines().size() > 0) {
            stringBuffer.append("&polyline=");
            stringBuffer.append(n.a(((RoutePOISearchQuery) ((e) this).f7860b).getPolylines()));
        } else {
            stringBuffer.append("&origin=");
            stringBuffer.append(n.a(((RoutePOISearchQuery) ((e) this).f7860b).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(n.a(((RoutePOISearchQuery) ((e) this).f7860b).getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(((RoutePOISearchQuery) ((e) this).f7860b).getMode());
            stringBuffer.append(sb3.toString());
        }
        String channel = ((RoutePOISearchQuery) ((e) this).f7860b).getChannel();
        if (!TextUtils.isEmpty(channel)) {
            stringBuffer.append("&channel=");
            stringBuffer.append(channel);
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/place/route?";
    }
}
