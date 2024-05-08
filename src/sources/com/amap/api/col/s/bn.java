package com.amap.api.col.s;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: NearbySearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bn implements INearbySearch {

    /* renamed from: e, reason: collision with root package name */
    private static long f7203e;

    /* renamed from: b, reason: collision with root package name */
    private String f7205b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7206c;

    /* renamed from: d, reason: collision with root package name */
    private y f7207d;

    /* renamed from: f, reason: collision with root package name */
    private ExecutorService f7208f;

    /* renamed from: k, reason: collision with root package name */
    private UploadInfoCallback f7213k;

    /* renamed from: l, reason: collision with root package name */
    private TimerTask f7214l;

    /* renamed from: a, reason: collision with root package name */
    private List<NearbySearch.NearbyListener> f7204a = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private LatLonPoint f7209g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f7210h = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7211i = false;

    /* renamed from: j, reason: collision with root package name */
    private Timer f7212j = new Timer();

    /* compiled from: NearbySearchCore.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends TimerTask {
        private a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (bn.this.f7213k != null) {
                    int b4 = bn.this.b(bn.this.f7213k.OnUploadInfoCallback());
                    Message obtainMessage = bn.this.f7207d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bn.this.f7204a;
                    obtainMessage.what = b4;
                    bn.this.f7207d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                n.a(th, "NearbySearch", "UpdateDataTask");
            }
        }

        public /* synthetic */ a(bn bnVar, byte b4) {
            this();
        }
    }

    public bn(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7206c = context.getApplicationContext();
            this.f7207d = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f7204a.add(nearbyListener);
        } catch (Throwable th) {
            n.a(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bn.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = bn.this.f7207d.obtainMessage();
                    obtainMessage.arg1 = 8;
                    obtainMessage.obj = bn.this.f7204a;
                    try {
                        try {
                            bn.this.a();
                            obtainMessage.what = 1000;
                            if (bn.this.f7207d == null) {
                                return;
                            }
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                            n.a(e2, "NearbySearch", "clearUserInfoAsyn");
                            if (bn.this.f7207d == null) {
                                return;
                            }
                        }
                        bn.this.f7207d.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        if (bn.this.f7207d != null) {
                            bn.this.f7207d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.f7212j.cancel();
        } catch (Throwable th) {
            n.a(th, "NearbySearch", "destryoy");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.f7204a.remove(nearbyListener);
        } catch (Throwable th) {
            n.a(th, "NearbySearch", "removeNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            w.a(this.f7206c);
            if (a(nearbyQuery)) {
                return new aa(this.f7206c, nearbyQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            n.a(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bn.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = bn.this.f7207d.obtainMessage();
                    obtainMessage.arg1 = 9;
                    y.g gVar = new y.g();
                    gVar.f8002a = bn.this.f7204a;
                    obtainMessage.obj = gVar;
                    try {
                        try {
                            gVar.f8003b = bn.this.searchNearbyInfo(nearbyQuery);
                            obtainMessage.what = 1000;
                            if (bn.this.f7207d == null) {
                                return;
                            }
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                            n.a(e2, "NearbySearch", "searchNearbyInfoAsyn");
                            if (bn.this.f7207d == null) {
                                return;
                            }
                        }
                        bn.this.f7207d.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        if (bn.this.f7207d != null) {
                            bn.this.f7207d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.f7205b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i10) {
        TimerTask timerTask;
        if (i10 < 7000) {
            i10 = 7000;
        }
        try {
            this.f7213k = uploadInfoCallback;
            if (this.f7211i && (timerTask = this.f7214l) != null) {
                timerTask.cancel();
            }
            this.f7211i = true;
            a aVar = new a(this, (byte) 0);
            this.f7214l = aVar;
            this.f7212j.schedule(aVar, 0L, i10);
        } catch (Throwable th) {
            n.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        try {
            TimerTask timerTask = this.f7214l;
            if (timerTask != null) {
                timerTask.cancel();
            }
        } finally {
            this.f7211i = false;
            this.f7214l = null;
        }
        this.f7211i = false;
        this.f7214l = null;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f7208f == null) {
            this.f7208f = Executors.newSingleThreadExecutor();
        }
        this.f7208f.submit(new Runnable() { // from class: com.amap.api.col.s.bn.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Message obtainMessage = bn.this.f7207d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bn.this.f7204a;
                    obtainMessage.what = bn.this.a(uploadInfo);
                    bn.this.f7207d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    n.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (!this.f7211i) {
                if (a(this.f7205b)) {
                    w.a(this.f7206c);
                    return new z(this.f7206c, this.f7205b).c().intValue();
                }
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
        } catch (AMapException e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(UploadInfo uploadInfo) {
        try {
            w.a(this.f7206c);
            if (uploadInfo == null) {
                return 2202;
            }
            long time = new Date().getTime();
            if (time - f7203e < 6500) {
                return 2203;
            }
            f7203e = time;
            String userID = uploadInfo.getUserID();
            if (!a(userID)) {
                return 2201;
            }
            if (TextUtils.isEmpty(this.f7210h)) {
                this.f7210h = userID;
            }
            if (!userID.equals(this.f7210h)) {
                return 2201;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point != null && !point.equals(this.f7209g)) {
                new ab(this.f7206c, uploadInfo).c();
                this.f7209g = point.copy();
                return 1000;
            }
            return 2204;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        if (this.f7211i) {
            return 2200;
        }
        return b(uploadInfo);
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    private static boolean a(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }
}
