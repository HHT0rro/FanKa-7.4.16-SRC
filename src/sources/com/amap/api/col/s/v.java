package com.amap.api.col.s;

import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.poisearch.SubPoiItemV2;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusPathV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.BusStepV2;
import com.amap.api.services.route.ChargeStationInfo;
import com.amap.api.services.route.Cost;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePathV2;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.DriveStepV2;
import com.amap.api.services.route.ElecConsumeInfo;
import com.amap.api.services.route.Navi;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TaxiItemV2;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.quickcard.base.Attributes;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f7977a = {"010", "021", "022", "023", "1852", "1853"};

    private static WalkStep A(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, "orientation"));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(t(a(jSONObject, "distance")));
        walkStep.setDuration(t(a(jSONObject, "duration")));
        walkStep.setPolyline(d(jSONObject, "polyline"));
        walkStep.setAction(a(jSONObject, "action"));
        walkStep.setAssistantAction(a(jSONObject, "assistant_action"));
        return walkStep;
    }

    private static WalkStep B(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, "orientation"));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(t(a(jSONObject, "distance")));
        walkStep.setDuration(t(a(jSONObject, "duration")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            walkStep.setPolyline(d(optJSONObject, "polyline"));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("navi");
        if (optJSONObject2 != null) {
            walkStep.setAction(a(optJSONObject2, "action"));
            walkStep.setAssistantAction(a(optJSONObject2, "assistant_action"));
            walkStep.setRoadType(s(a(optJSONObject2, "walk_type")));
        }
        return walkStep;
    }

    private static RouteBusLineItem C(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(F(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(F(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(t(a(jSONObject, "distance")));
        routeBusLineItem.setDuration(t(a(jSONObject, "duration")));
        routeBusLineItem.setPolyline(d(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(n.d(a(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(n.d(a(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(s(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(E(jSONObject));
        return routeBusLineItem;
    }

    private static RouteBusLineItem D(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(F(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(F(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(t(a(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusLineItem.setDuration(t(a(optJSONObject, "duration")));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("polyline");
        if (optJSONObject2 != null) {
            routeBusLineItem.setPolyline(d(optJSONObject2, "polyline"));
        }
        routeBusLineItem.setFirstBusTime(n.d(a(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(n.d(a(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(s(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(E(jSONObject));
        return routeBusLineItem;
    }

    private static List<BusStationItem> E(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(F(optJSONObject));
            }
        }
        return arrayList;
    }

    private static BusStationItem F(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(c(jSONObject, "location"));
        return busStationItem;
    }

    private static RouteRailwayItem G(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("id") || !jSONObject.has("name")) {
            return null;
        }
        RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
        routeRailwayItem.setID(a(jSONObject, "id"));
        routeRailwayItem.setName(a(jSONObject, "name"));
        routeRailwayItem.setTime(a(jSONObject, "time"));
        routeRailwayItem.setTrip(a(jSONObject, "trip"));
        routeRailwayItem.setDistance(t(a(jSONObject, "distance")));
        routeRailwayItem.setType(a(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(H(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(H(jSONObject.optJSONObject("arrival_stop")));
        routeRailwayItem.setViastops(I(jSONObject));
        routeRailwayItem.setAlters(J(jSONObject));
        routeRailwayItem.setSpaces(K(jSONObject));
        return routeRailwayItem;
    }

    private static RailwayStationItem H(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(c(jSONObject, "location"));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, "time"));
        railwayStationItem.setisStart(w(a(jSONObject, "start")));
        railwayStationItem.setisEnd(w(a(jSONObject, "end")));
        railwayStationItem.setWait(t(a(jSONObject, "wait")));
        return railwayStationItem;
    }

    private static List<RailwayStationItem> I(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(H(optJSONObject));
            }
        }
        return arrayList;
    }

    private static List<Railway> J(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(a(optJSONObject, "id"));
                railway.setName(a(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    private static List<RailwaySpace> K(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(L(optJSONObject));
            }
        }
        return arrayList;
    }

    private static RailwaySpace L(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(a(jSONObject, "code"), t(a(jSONObject, "cost")));
    }

    private static TaxiItem M(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(c(jSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
        taxiItem.setDestination(c(jSONObject, com.huawei.openalliance.ad.constant.as.aq));
        taxiItem.setDistance(t(a(jSONObject, "distance")));
        taxiItem.setDuration(t(a(jSONObject, "duration")));
        taxiItem.setSname(a(jSONObject, "sname"));
        taxiItem.setTname(a(jSONObject, "tname"));
        return taxiItem;
    }

    private static TaxiItemV2 N(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItemV2 taxiItemV2 = new TaxiItemV2();
        taxiItemV2.setOrigin(c(jSONObject, "startpoint"));
        taxiItemV2.setDestination(c(jSONObject, "endpoint"));
        taxiItemV2.setDistance(t(a(jSONObject, "distance")));
        taxiItemV2.setDuration(t(a(jSONObject, "drivetime")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            taxiItemV2.setPolyline(d(optJSONObject, "polyline"));
        }
        taxiItemV2.setSname(a(jSONObject, "startname"));
        taxiItemV2.setTname(a(jSONObject, "endname"));
        return taxiItemV2;
    }

    private static ElecConsumeInfo O(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(c(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(b(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(b(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("left_energy");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i10)));
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseElecConsumeInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static Navi P(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(a(jSONObject, "action"));
            navi.setAssistantAction(a(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseNavi");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<Photo> Q(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            Photo photo = new Photo();
            photo.setTitle(a(optJSONObject, "title"));
            photo.setUrl(a(optJSONObject, "url"));
            arrayList.add(photo);
        }
        return arrayList;
    }

    private static RoutePOIItem R(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(c(jSONObject, "location"));
        routePOIItem.setDistance(t(a(jSONObject, "distance")));
        routePOIItem.setDuration(t(a(jSONObject, "duration")));
        routePOIItem.setCPID(a(jSONObject, "cpid"));
        return routePOIItem;
    }

    private static RidePath S(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(t(a(jSONObject, "distance")));
            ridePath.setDuration(v(a(jSONObject, "duration")));
            if (jSONObject.has(Attributes.AnimationTiming.STEPS)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(Attributes.AnimationTiming.STEPS);
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road"));
                        rideStep.setDistance(t(a(optJSONObject, "distance")));
                        rideStep.setDuration(t(a(optJSONObject, "duration")));
                        rideStep.setPolyline(d(optJSONObject, "polyline"));
                        rideStep.setAction(a(optJSONObject, "action"));
                        rideStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                d(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static RidePath T(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(t(a(jSONObject, "distance")));
            ridePath.setDuration(v(a(jSONObject, "duration")));
            if (jSONObject.has(Attributes.AnimationTiming.STEPS)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(Attributes.AnimationTiming.STEPS);
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road_name"));
                        rideStep.setDistance(t(a(optJSONObject, "step_distance")));
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                        if (optJSONObject2 != null) {
                            rideStep.setDuration(t(a(optJSONObject2, "duration")));
                        }
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("navi");
                        if (optJSONObject3 != null) {
                            rideStep.setAction(a(optJSONObject3, "action"));
                            rideStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                            rideStep.setRoadType(s(a(optJSONObject3, "work_type")));
                        }
                        rideStep.setPolyline(d(optJSONObject, "polyline"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                d(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseRidePathV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> a(org.json.JSONObject r16, boolean r17) throws org.json.JSONException {
        /*
            java.lang.String r0 = "datas"
            r1 = r16
            org.json.JSONArray r0 = r1.optJSONArray(r0)
            if (r0 == 0) goto L86
            int r1 = r0.length()
            if (r1 != 0) goto L12
            goto L86
        L12:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.length()
            r3 = 0
            r4 = 0
        L1d:
            if (r4 >= r2) goto L85
            org.json.JSONObject r5 = r0.optJSONObject(r4)
            java.lang.String r6 = "userid"
            java.lang.String r6 = a(r5, r6)
            java.lang.String r7 = "location"
            java.lang.String r7 = a(r5, r7)
            r8 = 0
            if (r7 == 0) goto L4e
            java.lang.String r10 = ","
            java.lang.String[] r7 = r7.split(r10)
            int r10 = r7.length
            r11 = 2
            if (r10 != r11) goto L4e
            r8 = r7[r3]
            double r8 = u(r8)
            r10 = 1
            r7 = r7[r10]
            double r10 = u(r7)
            r14 = r8
            r8 = r10
            r10 = r14
            goto L4f
        L4e:
            r10 = r8
        L4f:
            java.lang.String r7 = "distance"
            java.lang.String r7 = a(r5, r7)
            java.lang.String r12 = "updatetime"
            java.lang.String r5 = a(r5, r12)
            long r12 = v(r5)
            int r5 = s(r7)
            com.amap.api.services.core.LatLonPoint r7 = new com.amap.api.services.core.LatLonPoint
            r7.<init>(r8, r10)
            com.amap.api.services.nearby.NearbyInfo r8 = new com.amap.api.services.nearby.NearbyInfo
            r8.<init>()
            r8.setUserID(r6)
            r8.setTimeStamp(r12)
            r8.setPoint(r7)
            if (r17 == 0) goto L7c
            r8.setDrivingDistance(r5)
            goto L7f
        L7c:
            r8.setDistance(r5)
        L7f:
            r1.add(r8)
            int r4 = r4 + 1
            goto L1d
        L85:
            return r1
        L86:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.v.a(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    public static ArrayList<String> b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            arrayList.add(optJSONArray.optString(i10));
        }
        return arrayList;
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pois")) != null && optJSONArray.length() != 0) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    arrayList.add(e(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<PoiItemV2> d(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    arrayList.add(f(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static PoiItem e(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, TextClassifier.TYPE_ADDRESS));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        if (jSONObject.has("distance")) {
            String a10 = a(jSONObject, "distance");
            if (!i(a10)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(a10));
                } catch (NumberFormatException e2) {
                    n.a(e2, "JSONHelper", "parseBasePoi");
                } catch (Exception e10) {
                    n.a(e10, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, "tel"));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(c(jSONObject, "entr_location"));
        poiItem.setExit(c(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, com.alibaba.security.realidentity.build.cg.f3316f));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        String a11 = a(jSONObject, "business_area");
        if (i(a11)) {
            a11 = a(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(a11);
        poiItem.setEmail(a(jSONObject, "email"));
        if (r(a(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        arrayList.add(l(optJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(e(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(i(jSONObject, "biz_ext"));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        a(poiItem, jSONObject);
        return poiItem;
    }

    public static PoiItemV2 f(JSONObject jSONObject) throws JSONException {
        PoiItemV2 poiItemV2 = new PoiItemV2(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, TextClassifier.TYPE_ADDRESS));
        poiItemV2.setTypeDes(a(jSONObject, "type"));
        poiItemV2.setTypeCode(a(jSONObject, "typecode"));
        poiItemV2.setProvinceName(a(jSONObject, "pname"));
        poiItemV2.setCityName(a(jSONObject, "cityname"));
        poiItemV2.setAdName(a(jSONObject, "adname"));
        poiItemV2.setProvinceCode(a(jSONObject, "pcode"));
        poiItemV2.setAdCode(a(jSONObject, "adcode"));
        poiItemV2.setCityCode(a(jSONObject, "citycode"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        arrayList.add(m(optJSONObject));
                    }
                }
            }
            poiItemV2.setSubPois(arrayList);
        }
        poiItemV2.setBusiness(g(jSONObject, "business"));
        poiItemV2.setIndoorData(f(jSONObject, "indoor"));
        poiItemV2.setPoiNavi(h(jSONObject, "navi"));
        a(poiItemV2, jSONObject);
        return poiItemV2;
    }

    public static ArrayList<BusStationItem> g(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    arrayList.add(n(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<BusLineItem> h(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(q(optJSONObject));
            }
        }
        return arrayList;
    }

    public static ArrayList<GeocodeAddress> i(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(a(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    geocodeAddress.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    geocodeAddress.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                    geocodeAddress.setTownship(a(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(a(optJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(a(optJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(a(optJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(c(optJSONObject, "location"));
                    geocodeAddress.setLevel(a(optJSONObject, DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL));
                    geocodeAddress.setCountry(a(optJSONObject, "country"));
                    geocodeAddress.setPostcode(a(optJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<Tip> j(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                tip.setName(a(optJSONObject, "name"));
                tip.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(a(optJSONObject, "adcode"));
                tip.setID(a(optJSONObject, "id"));
                tip.setAddress(a(optJSONObject, TextClassifier.TYPE_ADDRESS));
                tip.setTypeCode(a(optJSONObject, "typecode"));
                String a10 = a(optJSONObject, "location");
                if (!TextUtils.isEmpty(a10)) {
                    String[] split = a10.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static ArrayList<RoutePOIItem> k(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    arrayList.add(R(optJSONObject));
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(R(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    private static SubPoiItem l(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, TextClassifier.TYPE_ADDRESS));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a10 = a(jSONObject, "distance");
            if (!i(a10)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(a10));
                } catch (NumberFormatException e2) {
                    n.a(e2, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e10) {
                    n.a(e10, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    private static SubPoiItemV2 m(JSONObject jSONObject) throws JSONException {
        SubPoiItemV2 subPoiItemV2 = new SubPoiItemV2(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, TextClassifier.TYPE_ADDRESS));
        subPoiItemV2.setSubTypeDes(a(jSONObject, "subtype"));
        subPoiItemV2.setTypeCode(a(jSONObject, "typecode"));
        return subPoiItemV2;
    }

    private static BusStationItem n(JSONObject jSONObject) throws JSONException {
        BusStationItem o10 = o(jSONObject);
        o10.setAdCode(a(jSONObject, "adcode"));
        o10.setCityCode(a(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            o10.setBusLineItems(arrayList);
            return o10;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(p(optJSONObject));
            }
        }
        o10.setBusLineItems(arrayList);
        return o10;
    }

    private static BusStationItem o(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(c(jSONObject, "location"));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    private static BusLineItem p(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(d(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    private static BusLineItem q(JSONObject jSONObject) throws JSONException {
        BusLineItem p10 = p(jSONObject);
        p10.setFirstBusTime(n.d(a(jSONObject, "start_time")));
        p10.setLastBusTime(n.d(a(jSONObject, "end_time")));
        p10.setBusCompany(a(jSONObject, "company"));
        p10.setDistance(t(a(jSONObject, "distance")));
        p10.setBasicPrice(t(a(jSONObject, "basic_price")));
        p10.setTotalPrice(t(a(jSONObject, "total_price")));
        p10.setBounds(d(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            p10.setBusStations(arrayList);
            return p10;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(o(optJSONObject));
            }
        }
        p10.setBusStations(arrayList);
        return p10;
    }

    private static DistrictItem r(JSONObject jSONObject) throws JSONException {
        String optString;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(a(jSONObject, "citycode"));
        districtItem.setAdcode(a(jSONObject, "adcode"));
        districtItem.setName(a(jSONObject, "name"));
        districtItem.setLevel(a(jSONObject, DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL));
        districtItem.setCenter(c(jSONObject, CSSAlignValue.AlignKey.CENTER));
        if (jSONObject.has("polyline") && (optString = jSONObject.optString("polyline")) != null && optString.length() > 0) {
            districtItem.setDistrictBoundary(optString.split("\\|"));
        }
        a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    private static List<BusinessArea> s(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    businessArea.setCenterPoint(c(optJSONObject, "location"));
                    businessArea.setName(a(optJSONObject, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        return arrayList;
    }

    private static BusStep t(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(v(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(x(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(z(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStep.setExit(z(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(G(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(M(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    private static BusStepV2 u(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStepV2 busStepV2 = new BusStepV2();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStepV2.setWalk(w(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStepV2.setBusLines(y(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStepV2.setEntrance(z(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStepV2.setExit(z(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStepV2.setRailway(G(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStepV2.setTaxi(N(optJSONObject6));
        }
        if ((busStepV2.getWalk() == null || busStepV2.getWalk().getSteps().size() == 0) && busStepV2.getBusLines().size() == 0 && busStepV2.getRailway() == null && busStepV2.getTaxi() == null) {
            return null;
        }
        return busStepV2;
    }

    private static RouteBusWalkItem v(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(c(jSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
        routeBusWalkItem.setDestination(c(jSONObject, com.huawei.openalliance.ad.constant.as.aq));
        routeBusWalkItem.setDistance(t(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(v(a(jSONObject, "duration")));
        if (!jSONObject.has(Attributes.AnimationTiming.STEPS) || (optJSONArray = jSONObject.optJSONArray(Attributes.AnimationTiming.STEPS)) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(A(optJSONObject));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        a(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    private static RouteBusWalkItem w(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(c(jSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
        routeBusWalkItem.setDestination(c(jSONObject, com.huawei.openalliance.ad.constant.as.aq));
        routeBusWalkItem.setDistance(t(a(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusWalkItem.setDuration(v(a(optJSONObject, "duration")));
        }
        if (!jSONObject.has(Attributes.AnimationTiming.STEPS) || (optJSONArray = jSONObject.optJSONArray(Attributes.AnimationTiming.STEPS)) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
            if (optJSONObject2 != null) {
                arrayList.add(B(optJSONObject2));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        a(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    private static List<RouteBusLineItem> x(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(C(optJSONObject));
            }
        }
        return arrayList;
    }

    private static List<RouteBusLineItem> y(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(D(optJSONObject));
            }
        }
        return arrayList;
    }

    private static Doorway z(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(c(jSONObject, "location"));
        return doorway;
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                regeocodeRoad.setId(a(optJSONObject, "id"));
                regeocodeRoad.setName(a(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(c(optJSONObject, "location"));
                regeocodeRoad.setDirection(a(optJSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                regeocodeRoad.setDistance(t(a(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    private static boolean o(String str) {
        if (str != null && str.length() > 0) {
            for (String str2 : f7977a) {
                if (str.trim().equals(str2.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static LocalWeatherForecast h(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
            JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject == null) {
                    return localWeatherForecast;
                }
                localWeatherForecast.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                localWeatherForecast.setAdCode(a(optJSONObject, "adcode"));
                localWeatherForecast.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                localWeatherForecast.setReportTime(a(optJSONObject, "reporttime"));
                if (!optJSONObject.has("casts")) {
                    return localWeatherForecast;
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                        LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                        if (optJSONObject2 != null) {
                            localDayWeatherForecast.setDate(a(optJSONObject2, "date"));
                            localDayWeatherForecast.setWeek(a(optJSONObject2, "week"));
                            localDayWeatherForecast.setDayWeather(a(optJSONObject2, "dayweather"));
                            localDayWeatherForecast.setNightWeather(a(optJSONObject2, "nightweather"));
                            localDayWeatherForecast.setDayTemp(a(optJSONObject2, "daytemp"));
                            localDayWeatherForecast.setNightTemp(a(optJSONObject2, "nighttemp"));
                            localDayWeatherForecast.setDayWindDirection(a(optJSONObject2, "daywind"));
                            localDayWeatherForecast.setNightWindDirection(a(optJSONObject2, "nightwind"));
                            localDayWeatherForecast.setDayWindPower(a(optJSONObject2, "daypower"));
                            localDayWeatherForecast.setNightWindPower(a(optJSONObject2, "nightpower"));
                            arrayList.add(localDayWeatherForecast);
                        }
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                    return localWeatherForecast;
                }
                localWeatherForecast.setWeatherForecast(arrayList);
            }
            return localWeatherForecast;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherLive g(String str) throws AMapException {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            LocalWeatherLive localWeatherLive = new LocalWeatherLive();
            JSONArray optJSONArray = jSONObject.optJSONArray("lives");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return localWeatherLive;
            }
            localWeatherLive.setAdCode(a(optJSONObject, "adcode"));
            localWeatherLive.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
            localWeatherLive.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
            localWeatherLive.setWeather(a(optJSONObject, "weather"));
            localWeatherLive.setTemperature(a(optJSONObject, "temperature"));
            localWeatherLive.setWindDirection(a(optJSONObject, "winddirection"));
            localWeatherLive.setWindPower(a(optJSONObject, "windpower"));
            localWeatherLive.setHumidity(a(optJSONObject, "humidity"));
            localWeatherLive.setReportTime(a(optJSONObject, "reporttime"));
            return localWeatherLive;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static DriveRouteResult c(String str) throws AMapException {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            if (optJSONObject == null) {
                return driveRouteResult;
            }
            driveRouteResult.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            driveRouteResult.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            driveRouteResult.setTaxiCost(t(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 < optJSONArray.length()) {
                DrivePath drivePath = new DrivePath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                if (optJSONObject2 != null) {
                    drivePath.setDistance(t(a(optJSONObject2, "distance")));
                    drivePath.setDuration(v(a(optJSONObject2, "duration")));
                    drivePath.setStrategy(a(optJSONObject2, "strategy"));
                    drivePath.setTolls(t(a(optJSONObject2, "tolls")));
                    drivePath.setTollDistance(t(a(optJSONObject2, "toll_distance")));
                    drivePath.setTotalTrafficlights(s(a(optJSONObject2, "traffic_lights")));
                    drivePath.setRestriction(s(a(optJSONObject2, "restriction")));
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray(Attributes.AnimationTiming.STEPS);
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i11 = 0;
                        while (i11 < optJSONArray2.length()) {
                            DriveStep driveStep = new DriveStep();
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i11);
                            if (optJSONObject3 != null) {
                                jSONArray2 = optJSONArray;
                                driveStep.setInstruction(a(optJSONObject3, "instruction"));
                                driveStep.setOrientation(a(optJSONObject3, "orientation"));
                                driveStep.setRoad(a(optJSONObject3, "road"));
                                driveStep.setDistance(t(a(optJSONObject3, "distance")));
                                driveStep.setTolls(t(a(optJSONObject3, "tolls")));
                                driveStep.setTollDistance(t(a(optJSONObject3, "toll_distance")));
                                driveStep.setTollRoad(a(optJSONObject3, "toll_road"));
                                driveStep.setDuration(t(a(optJSONObject3, "duration")));
                                driveStep.setPolyline(d(optJSONObject3, "polyline"));
                                driveStep.setAction(a(optJSONObject3, "action"));
                                driveStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                b(driveStep, optJSONObject3);
                                a(driveStep, optJSONObject3);
                                arrayList2.add(driveStep);
                            } else {
                                jSONArray2 = optJSONArray;
                            }
                            i11++;
                            optJSONArray = jSONArray2;
                        }
                        jSONArray = optJSONArray;
                        drivePath.setSteps(arrayList2);
                        b(drivePath, arrayList2);
                        arrayList.add(drivePath);
                        i10++;
                        optJSONArray = jSONArray;
                    }
                }
                jSONArray = optJSONArray;
                i10++;
                optJSONArray = jSONArray;
            }
            driveRouteResult.setPaths(arrayList);
            return driveRouteResult;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            n.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static DriveRouteResultV2 d(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return null;
            }
            DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            if (optJSONObject == null) {
                return driveRouteResultV2;
            }
            driveRouteResultV2.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            driveRouteResultV2.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            driveRouteResultV2.setTaxiCost(t(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResultV2;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                DrivePathV2 drivePathV2 = new DrivePathV2();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                if (optJSONObject2 != null) {
                    drivePathV2.setDistance(t(a(optJSONObject2, "distance")));
                    drivePathV2.setStrategy(a(optJSONObject2, "strategy"));
                    drivePathV2.setRestriction(s(a(optJSONObject2, "restriction")));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                    if (optJSONObject3 != null) {
                        Cost cost = new Cost();
                        a(cost, optJSONObject3);
                        drivePathV2.setCost(cost);
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("elec_consume_info");
                    if (optJSONObject4 != null) {
                        drivePathV2.setElecConsumeInfo(O(optJSONObject4));
                    }
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("charge_station_info");
                    if (optJSONArray2 != null) {
                        drivePathV2.setChargeStationInfo(c(optJSONArray2));
                    }
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray(Attributes.AnimationTiming.STEPS);
                    if (optJSONArray3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i11 = 0; i11 < optJSONArray3.length(); i11++) {
                            DriveStepV2 driveStepV2 = new DriveStepV2();
                            JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i11);
                            if (optJSONObject5 != null) {
                                driveStepV2.setInstruction(a(optJSONObject5, "instruction"));
                                driveStepV2.setOrientation(a(optJSONObject5, "orientation"));
                                driveStepV2.setStepDistance(s(a(optJSONObject5, "step_distance")));
                                driveStepV2.setRoad(a(optJSONObject5, "road_name"));
                                driveStepV2.setPolyline(d(optJSONObject5, "polyline"));
                                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("cost");
                                if (optJSONObject6 != null) {
                                    Cost cost2 = new Cost();
                                    a(cost2, optJSONObject6);
                                    driveStepV2.setCostDetail(cost2);
                                }
                                JSONObject optJSONObject7 = optJSONObject5.optJSONObject("navi");
                                if (optJSONObject7 != null) {
                                    driveStepV2.setNavi(P(optJSONObject7));
                                }
                                JSONArray optJSONArray4 = optJSONObject5.optJSONArray("cities");
                                if (optJSONArray4 != null) {
                                    driveStepV2.setRouteSearchCityList(e(optJSONArray4));
                                }
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("tmcs");
                                if (optJSONArray5 != null) {
                                    driveStepV2.setTMCs(d(optJSONArray5));
                                }
                                arrayList2.add(driveStepV2);
                            }
                        }
                        drivePathV2.setSteps(arrayList2);
                        c(drivePathV2, arrayList2);
                        arrayList.add(drivePathV2);
                    }
                }
            }
            driveRouteResultV2.setPaths(arrayList);
            return driveRouteResultV2;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            n.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TruckRouteRestult m(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            truckRouteRestult.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            truckRouteRestult.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return truckRouteRestult;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                TruckPath truckPath = new TruckPath();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                truckPath.setDistance(t(a(jSONObject2, "distance")));
                truckPath.setDuration(v(a(jSONObject2, "duration")));
                truckPath.setStrategy(a(jSONObject2, "strategy"));
                truckPath.setTolls(t(a(jSONObject2, "tolls")));
                truckPath.setTollDistance(t(a(jSONObject2, "toll_distance")));
                truckPath.setTotalTrafficlights(s(a(jSONObject2, "traffic_lights")));
                truckPath.setRestriction(s(a(jSONObject2, "restriction")));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray(Attributes.AnimationTiming.STEPS);
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                        TruckStep truckStep = new TruckStep();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i11);
                        if (optJSONObject2 != null) {
                            truckStep.setInstruction(a(optJSONObject2, "instruction"));
                            truckStep.setOrientation(a(optJSONObject2, "orientation"));
                            truckStep.setRoad(a(optJSONObject2, "road"));
                            truckStep.setDistance(t(a(optJSONObject2, "distance")));
                            truckStep.setTolls(t(a(optJSONObject2, "tolls")));
                            truckStep.setTollDistance(t(a(optJSONObject2, "toll_distance")));
                            truckStep.setTollRoad(a(optJSONObject2, "toll_road"));
                            truckStep.setDuration(t(a(optJSONObject2, "duration")));
                            truckStep.setPolyline(d(optJSONObject2, "polyline"));
                            truckStep.setAction(a(optJSONObject2, "action"));
                            truckStep.setAssistantAction(a(optJSONObject2, "assistant_action"));
                            a(truckStep, optJSONObject2);
                            b(truckStep, optJSONObject2);
                            arrayList2.add(truckStep);
                        }
                    }
                    truckPath.setSteps(arrayList2);
                    arrayList.add(truckPath);
                }
            }
            truckRouteRestult.setPaths(arrayList);
            return truckRouteRestult;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static ArrayList<LatLonPoint> p(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(";")) {
            arrayList.add(q(str2));
        }
        return arrayList;
    }

    private static int s(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            n.a(e2, "JSONHelper", "str2int");
            return 0;
        }
    }

    public static RideRouteResultV2 k(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return null;
            }
            RideRouteResultV2 rideRouteResultV2 = new RideRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            rideRouteResultV2.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            rideRouteResultV2.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResultV2.setPaths(arrayList);
                return rideRouteResultV2;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    RidePath T = T(optJSONArray.optJSONObject(i10));
                    if (T != null) {
                        arrayList.add(T);
                    }
                }
            }
            rideRouteResultV2.setPaths(arrayList);
            return rideRouteResultV2;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseRideRouteV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x01a4 A[Catch: all -> 0x021b, JSONException -> 0x021d, TryCatch #3 {JSONException -> 0x021d, all -> 0x021b, blocks: (B:37:0x00cf, B:39:0x00e2, B:51:0x00eb, B:53:0x00fa, B:57:0x0102, B:60:0x010f, B:63:0x0116, B:64:0x011c, B:66:0x0122, B:68:0x012d, B:70:0x0134, B:72:0x0147, B:73:0x014d, B:75:0x0153, B:77:0x015e, B:83:0x0199, B:85:0x01a4, B:86:0x01ac, B:88:0x01b2, B:90:0x01bf, B:92:0x01e2, B:96:0x01e9, B:98:0x01f6, B:103:0x01ff, B:105:0x020e, B:111:0x0217), top: B:36:0x00cf }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.amap.api.services.route.DriveRoutePlanResult n(java.lang.String r20) throws com.amap.api.services.core.AMapException {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.v.n(java.lang.String):com.amap.api.services.route.DriveRoutePlanResult");
    }

    public static DistanceResult l(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                distanceItem.setOriginId(s(a(jSONObject2, "origin_id")));
                distanceItem.setDestId(s(a(jSONObject2, "dest_id")));
                distanceItem.setDistance(t(a(jSONObject2, "distance")));
                distanceItem.setDuration(t(a(jSONObject2, "duration")));
                String a10 = a(jSONObject2, "info");
                if (!TextUtils.isEmpty(a10)) {
                    distanceItem.setErrorInfo(a10);
                    distanceItem.setErrorCode(s(a(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static boolean r(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    private static long v(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            n.a(e2, "JSONHelper", "str2long");
            return 0L;
        }
    }

    public static BusRouteResultV2 b(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return null;
            }
            BusRouteResultV2 busRouteResultV2 = new BusRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            if (optJSONObject == null) {
                return busRouteResultV2;
            }
            busRouteResultV2.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            busRouteResultV2.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            busRouteResultV2.setDistance(t(a(optJSONObject, "distance")));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
            if (optJSONObject2 != null) {
                busRouteResultV2.setTaxiCost(t(a(optJSONObject2, "taxi_fee")));
            }
            if (!optJSONObject.has("transits") || (optJSONArray = optJSONObject.optJSONArray("transits")) == null) {
                return busRouteResultV2;
            }
            busRouteResultV2.setPaths(b(optJSONArray));
            return busRouteResultV2;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static boolean w(String str) {
        return (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) ? false : true;
    }

    private static LatLonPoint q(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    private static float t(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e2) {
            n.a(e2, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    private static double u(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return ShadowDrawableWrapper.COS_45;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e2) {
            n.a(e2, "JSONHelper", "str2float");
            return ShadowDrawableWrapper.COS_45;
        }
    }

    public static RideRouteResult j(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            rideRouteResult.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    RidePath S = S(optJSONArray.optJSONObject(i10));
                    if (S != null) {
                        arrayList.add(S);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has("path")) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath S2 = S(optJSONObject2.optJSONObject("path"));
                if (S2 != null) {
                    arrayList.add(S2);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static boolean i(String str) {
        return str == null || str.equals("");
    }

    private static PoiItemExtension i(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
        } else {
            str3 = a(optJSONObject, "open_time");
            str2 = a(optJSONObject, "rating");
        }
        return new PoiItemExtension(str3, str2);
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (!jSONObject.has("cities") || (optJSONArray = jSONObject.optJSONArray("cities")) == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(new SuggestionCity(a(optJSONObject, "name"), a(optJSONObject, "citycode"), a(optJSONObject, "adcode"), s(a(optJSONObject, "num"))));
            }
        }
        return arrayList;
    }

    private static Business g(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        JSONObject optJSONObject;
        String str11 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
        } else {
            String a10 = a(optJSONObject, "business_area");
            String a11 = a(optJSONObject, "opentime_today");
            String a12 = a(optJSONObject, "opentime_week");
            String a13 = a(optJSONObject, "tel");
            String a14 = a(optJSONObject, "tag");
            String a15 = a(optJSONObject, "rating");
            String a16 = a(optJSONObject, "cost");
            str2 = a10;
            str3 = a11;
            str4 = a12;
            str5 = a13;
            str6 = a14;
            str7 = a15;
            str8 = a16;
            str9 = a(optJSONObject, "parking_type");
            str10 = a(optJSONObject, "alias");
            str11 = a(optJSONObject, "cpid");
        }
        Business business = new Business(str2, str3, str4, str5, str6, str7, str8, str9, str10);
        business.setCPID(str11);
        return business;
    }

    public static WalkRouteResultV2 f(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return null;
            }
            WalkRouteResultV2 walkRouteResultV2 = new WalkRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            walkRouteResultV2.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            walkRouteResultV2.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            if (!optJSONObject.has("paths")) {
                return walkRouteResultV2;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResultV2.setPaths(arrayList);
                return walkRouteResultV2;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(t(a(optJSONObject2, "distance")));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                    if (optJSONObject3 != null) {
                        walkPath.setDuration(v(a(optJSONObject3, "duration")));
                    }
                    if (optJSONObject2.has(Attributes.AnimationTiming.STEPS)) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray(Attributes.AnimationTiming.STEPS);
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i11);
                                if (optJSONObject4 != null) {
                                    walkStep.setInstruction(a(optJSONObject4, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject4, "orientation"));
                                    walkStep.setRoad(a(optJSONObject4, "road_name"));
                                    walkStep.setDistance(t(a(optJSONObject4, "step_distance")));
                                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject("cost");
                                    if (optJSONObject5 != null) {
                                        walkStep.setDuration(t(a(optJSONObject5, "duration")));
                                    }
                                    JSONObject optJSONObject6 = optJSONObject4.optJSONObject("navi");
                                    if (optJSONObject6 != null) {
                                        walkStep.setAction(a(optJSONObject6, "action"));
                                        walkStep.setAssistantAction(a(optJSONObject6, "assistant_action"));
                                        walkStep.setRoadType(s(a(optJSONObject6, "work_type")));
                                    }
                                    walkStep.setPolyline(d(optJSONObject4, "polyline"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            a(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResultV2.setPaths(arrayList);
            return walkRouteResultV2;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<BusPathV2> b(JSONArray jSONArray) throws JSONException {
        BusStepV2 u10;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            BusPathV2 busPathV2 = new BusPathV2();
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busPathV2.setDuration(v(a(optJSONObject2, "duration")));
                    busPathV2.setCost(t(a(optJSONObject2, "transit_fee")));
                }
                busPathV2.setDistance(t(a(optJSONObject, "distance")));
                busPathV2.setNightBus(w(a(optJSONObject, "nightflag")));
                busPathV2.setWalkDistance(t(a(optJSONObject, "walking_distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray(DBDefinition.SEGMENT_TABLE_NAME);
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f10 = 0.0f;
                    float f11 = 0.0f;
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i11);
                        if (optJSONObject3 != null && (u10 = u(optJSONObject3)) != null) {
                            arrayList2.add(u10);
                            if (u10.getWalk() != null) {
                                f11 += u10.getWalk().getDistance();
                            }
                            if (u10.getBusLines() != null && u10.getBusLines().size() > 0) {
                                f10 += u10.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPathV2.setSteps(arrayList2);
                    busPathV2.setBusDistance(f10);
                    busPathV2.setWalkDistance(f11);
                    arrayList.add(busPathV2);
                }
            }
        }
        return arrayList;
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(r(optJSONObject));
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    private static PoiNavi h(JSONObject jSONObject, String str) throws JSONException {
        LatLonPoint latLonPoint;
        String str2;
        JSONObject optJSONObject;
        LatLonPoint latLonPoint2 = null;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            latLonPoint = null;
            str2 = "";
        } else {
            str3 = a(optJSONObject, "navi_poiid");
            latLonPoint2 = c(optJSONObject, "entr_location");
            latLonPoint = c(optJSONObject, "exit_location");
            str2 = a(optJSONObject, "gridcode");
        }
        return new PoiNavi(str3, latLonPoint2, latLonPoint, str2);
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                crossroad.setId(a(optJSONObject, "id"));
                crossroad.setDirection(a(optJSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                crossroad.setDistance(t(a(optJSONObject, "distance")));
                crossroad.setCenterPoint(c(optJSONObject, "location"));
                crossroad.setFirstRoadId(a(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    private static List<RouteSearchCity> e(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            } catch (JSONException e2) {
                n.a(e2, "JSONHelper", "parseCrossCity");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(a(jSONObject, "country"));
        regeocodeAddress.setCountryCode(a(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(a(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(a(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(optJSONObject, "street"));
        streetNumber.setNumber(a(optJSONObject, "number"));
        streetNumber.setLatLonPoint(c(optJSONObject, "location"));
        streetNumber.setDirection(a(optJSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        streetNumber.setDistance(t(a(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(s(jSONObject));
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        a(regeocodeAddress);
    }

    private static List<ChargeStationInfo> c(JSONArray jSONArray) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(a(jSONObject, "name"));
                chargeStationInfo.setPoiId(a(jSONObject, "poiid"));
                chargeStationInfo.setBrandName(a(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(c(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(c(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(b(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(b(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(b(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(b(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(b(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(b(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(b(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
            }
            return arrayList;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseChargeStationInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static WalkRouteResult e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            walkRouteResult.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            walkRouteResult.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(t(a(optJSONObject2, "distance")));
                    walkPath.setDuration(v(a(optJSONObject2, "duration")));
                    if (optJSONObject2.has(Attributes.AnimationTiming.STEPS)) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray(Attributes.AnimationTiming.STEPS);
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i11);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(a(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject3, "orientation"));
                                    walkStep.setRoad(a(optJSONObject3, "road"));
                                    walkStep.setDistance(t(a(optJSONObject3, "distance")));
                                    walkStep.setDuration(t(a(optJSONObject3, "duration")));
                                    walkStep.setPolyline(d(optJSONObject3, "polyline"));
                                    walkStep.setAction(a(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            a(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<TMC> d(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                TMC tmc = new TMC();
                JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    tmc.setDistance(s(a(optJSONObject, "tmc_distance")));
                    tmc.setStatus(a(optJSONObject, "tmc_status"));
                    tmc.setPolyline(d(optJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
            } catch (JSONException e2) {
                n.a(e2, "JSONHelper", "parseTMCsV5");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    private static IndoorDataV2 f(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        int i10;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
            i10 = 0;
        } else {
            r2 = s(a(optJSONObject, "indoor_map")) == 1;
            str3 = a(optJSONObject, "cpid");
            i10 = s(a(optJSONObject, "floor"));
            str2 = a(optJSONObject, "truefloor");
        }
        return new IndoorDataV2(r2, str3, i10, str2);
    }

    private static int b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return -1;
    }

    private static void b(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    tmc.setDistance(s(a(optJSONObject, "distance")));
                    tmc.setStatus(a(optJSONObject, "status"));
                    tmc.setPolyline(d(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static ArrayList<LatLonPoint> d(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return p(jSONObject.optString(str));
        }
        return null;
    }

    private static void d(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static LatLonPoint c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return q(jSONObject.optString(str));
        }
        return null;
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                aoiItem.setId(a(optJSONObject, "id"));
                aoiItem.setName(a(optJSONObject, "name"));
                aoiItem.setAdcode(a(optJSONObject, "adcode"));
                aoiItem.setLocation(c(optJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(t(a(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    private static void a(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && o(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    public static BusRouteResult a(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            if (optJSONObject == null) {
                return busRouteResult;
            }
            busRouteResult.setStartPos(c(optJSONObject, com.alibaba.security.realidentity.build.cc.f3296y));
            busRouteResult.setTargetPos(c(optJSONObject, com.huawei.openalliance.ad.constant.as.aq));
            busRouteResult.setTaxiCost(t(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("transits") || (optJSONArray = optJSONObject.optJSONArray("transits")) == null) {
                return busRouteResult;
            }
            busRouteResult.setPaths(a(optJSONArray));
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static void c(Path path, List<DriveStepV2> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStepV2 driveStepV2 : list) {
            if (driveStepV2 != null && driveStepV2.getPolyline() != null) {
                polyline.addAll(driveStepV2.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static List<BusPath> a(JSONArray jSONArray) throws JSONException {
        BusStep t2;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                busPath.setCost(t(a(optJSONObject, "cost")));
                busPath.setDuration(v(a(optJSONObject, "duration")));
                busPath.setNightBus(w(a(optJSONObject, "nightflag")));
                busPath.setWalkDistance(t(a(optJSONObject, "walking_distance")));
                busPath.setDistance(t(a(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray(DBDefinition.SEGMENT_TABLE_NAME);
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f10 = 0.0f;
                    float f11 = 0.0f;
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i11);
                        if (optJSONObject2 != null && (t2 = t(optJSONObject2)) != null) {
                            arrayList2.add(t2);
                            if (t2.getWalk() != null) {
                                f11 += t2.getWalk().getDistance();
                            }
                            if (t2.getBusLines() != null && t2.getBusLines().size() > 0) {
                                f10 += t2.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f10);
                    busPath.setWalkDistance(f11);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    private static IndoorData e(JSONObject jSONObject, String str) throws JSONException {
        int i10;
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null && optJSONObject.has("cpid") && optJSONObject.has("floor")) {
            str3 = a(optJSONObject, "cpid");
            i10 = s(a(optJSONObject, "floor"));
            str2 = a(optJSONObject, "truefloor");
        } else {
            i10 = 0;
            str2 = "";
        }
        return new IndoorData(str3, i10, str2);
    }

    private static void a(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(t(a(jSONObject, "tolls")));
            cost.setTollDistance(t(a(jSONObject, "toll_distance")));
            cost.setTollRoad(a(jSONObject, "toll_road"));
            cost.setDuration(t(a(jSONObject, "duration")));
            cost.setTrafficLights(s(a(jSONObject, "traffic_lights")));
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseCostDetail");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    tmc.setDistance(s(a(optJSONObject, "distance")));
                    tmc.setStatus(a(optJSONObject, "status"));
                    tmc.setPolyline(d(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        district.setDistrictName(a(optJSONObject, "name"));
                        district.setDistrictAdcode(a(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e2) {
                n.a(e2, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals("[]")) ? "" : jSONObject.optString(str).trim();
    }

    private static void a(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> Q = Q(jSONObject.optJSONObject("deep_info"));
        if (Q.size() == 0) {
            Q = Q(jSONObject);
        }
        poiItem.setPhotos(Q);
    }

    private static void a(PoiItemV2 poiItemV2, JSONObject jSONObject) throws JSONException {
        poiItemV2.setPhotos(Q(jSONObject));
    }

    private static void a(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e2) {
            n.a(e2, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }
}
