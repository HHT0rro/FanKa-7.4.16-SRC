package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* compiled from: ShareSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bt implements IShareSearch {

    /* renamed from: b, reason: collision with root package name */
    private static String f7280b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";

    /* renamed from: c, reason: collision with root package name */
    private static String f7281c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";

    /* renamed from: d, reason: collision with root package name */
    private static String f7282d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";

    /* renamed from: e, reason: collision with root package name */
    private static String f7283e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";

    /* renamed from: f, reason: collision with root package name */
    private static final String f7284f = "";

    /* renamed from: a, reason: collision with root package name */
    private Context f7285a;

    /* renamed from: g, reason: collision with root package name */
    private ShareSearch.OnShareSearchListener f7286g;

    public bt(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7285a = context;
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        try {
            if (shareBusRouteQuery != null) {
                int busMode = shareBusRouteQuery.getBusMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    String str = f7280b;
                    String str2 = f7284f;
                    return new au(this.f7285a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, str2, str2, str2)).c();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "ShareSearch", "searchBusRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(final ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bt.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (bt.this.f7286g == null) {
                        return;
                    }
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1103;
                    obtainMessage.obj = bt.this.f7286g;
                    try {
                        try {
                            String searchBusRouteShareUrl = bt.this.searchBusRouteShareUrl(shareBusRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchBusRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        y.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        try {
            if (shareDrivingRouteQuery != null) {
                int drivingMode = shareDrivingRouteQuery.getDrivingMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    String str = f7280b;
                    String str2 = f7284f;
                    return new au(this.f7285a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, str2, str2, str2)).c();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(final ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bt.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (bt.this.f7286g == null) {
                        return;
                    }
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1104;
                    obtainMessage.obj = bt.this.f7286g;
                    try {
                        try {
                            String searchDrivingRouteShareUrl = bt.this.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        y.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint != null) {
                return new au(this.f7285a, String.format(f7281c, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "ShareSearch", "searchLocationShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(final LatLonSharePoint latLonSharePoint) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bt.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (bt.this.f7286g == null) {
                        return;
                    }
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1101;
                    obtainMessage.obj = bt.this.f7286g;
                    try {
                        try {
                            String searchLocationShareUrl = bt.this.searchLocationShareUrl(latLonSharePoint);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchLocationShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        y.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        String format;
        try {
            if (shareNaviQuery != null) {
                ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
                if (fromAndTo.getTo() != null) {
                    LatLonPoint from = fromAndTo.getFrom();
                    LatLonPoint to = fromAndTo.getTo();
                    int naviMode = shareNaviQuery.getNaviMode();
                    if (fromAndTo.getFrom() == null) {
                        format = String.format(f7282d, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    } else {
                        format = String.format(f7282d, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    }
                    return new au(this.f7285a, format).c();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "ShareSearch", "searchNaviShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(final ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bt.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (bt.this.f7286g == null) {
                        return;
                    }
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1102;
                    obtainMessage.obj = bt.this.f7286g;
                    try {
                        try {
                            String searchNaviShareUrl = bt.this.searchNaviShareUrl(shareNaviQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchNaviShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        y.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new au(this.f7285a, String.format(f7283e, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).c();
                }
            } catch (AMapException e2) {
                n.a(e2, "ShareSearch", "searchPoiShareUrl");
                throw e2;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(final PoiItem poiItem) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bt.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (bt.this.f7286g == null) {
                        return;
                    }
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1100;
                    obtainMessage.obj = bt.this.f7286g;
                    try {
                        try {
                            String searchPoiShareUrl = bt.this.searchPoiShareUrl(poiItem);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchPoiShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        y.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        try {
            if (shareWalkRouteQuery != null) {
                int walkMode = shareWalkRouteQuery.getWalkMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    String str = f7280b;
                    String str2 = f7284f;
                    return new au(this.f7285a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, str2, str2, str2)).c();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "ShareSearch", "searchWalkRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(final ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bt.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (bt.this.f7286g == null) {
                        return;
                    }
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.arg1 = 11;
                    obtainMessage.what = 1105;
                    obtainMessage.obj = bt.this.f7286g;
                    try {
                        try {
                            String searchWalkRouteShareUrl = bt.this.searchWalkRouteShareUrl(shareWalkRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        y.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.f7286g = onShareSearchListener;
    }
}
