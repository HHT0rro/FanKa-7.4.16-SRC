package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: CloudSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bi implements ICloudSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f7166a;

    /* renamed from: b, reason: collision with root package name */
    private CloudSearch.OnCloudSearchListener f7167b;

    /* renamed from: c, reason: collision with root package name */
    private CloudSearch.Query f7168c;

    /* renamed from: d, reason: collision with root package name */
    private int f7169d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, CloudResult> f7170e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f7171f;

    public bi(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7166a = context.getApplicationContext();
            this.f7171f = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bi.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 12;
                            obtainMessage.what = 700;
                            y.e eVar = new y.e();
                            eVar.f7999b = bi.this.f7167b;
                            obtainMessage.obj = eVar;
                            eVar.f7998a = bi.this.a(query);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        bi.this.f7171f.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bi.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 12;
                            obtainMessage.what = 701;
                            y.d dVar = new y.d();
                            dVar.f7997b = bi.this.f7167b;
                            obtainMessage.obj = dVar;
                            dVar.f7996a = bi.this.a(str, str2);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        bi.this.f7171f.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.f7167b = onCloudSearchListener;
    }

    private boolean b(int i10) {
        return i10 <= this.f7169d && i10 > 0;
    }

    private static boolean b(CloudSearch.Query query) {
        if (query == null || n.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i10 = 0; i10 < polyGonList.size(); i10++) {
            if (polyGonList.get(i10) == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.amap.api.services.cloud.CloudResult] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public CloudResult a(CloudSearch.Query query) throws AMapException {
        CloudResult cloudResult = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (b(query)) {
            if (!query.queryEquals(this.f7168c)) {
                this.f7169d = 0;
                this.f7168c = query.m1974clone();
                HashMap<Integer, CloudResult> hashMap = this.f7170e;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            ?? r12 = this.f7169d;
            try {
            } catch (Throwable th2) {
                th = th2;
                cloudResult = r12;
                n.a(th, "CloudSearch", "searchCloud");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return cloudResult;
                }
                throw th;
            }
            if (r12 == 0) {
                CloudResult c4 = new l(this.f7166a, query).c();
                a(c4, query);
                r12 = c4;
            } else {
                cloudResult = a(query.getPageNum());
                if (cloudResult == null) {
                    CloudResult c10 = new l(this.f7166a, query).c();
                    this.f7170e.put(Integer.valueOf(query.getPageNum()), c10);
                    r12 = c10;
                }
                return cloudResult;
            }
            return r12;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloudItemDetail a(String str, String str2) throws AMapException {
        if (str != null && !str.trim().equals("")) {
            if (str2 != null && !str2.trim().equals("")) {
                try {
                    return new k(this.f7166a, new ai(str, str2)).c();
                } catch (Throwable th) {
                    n.a(th, "CloudSearch", "searchCloudDetail");
                    if (!(th instanceof AMapException)) {
                        th.printStackTrace();
                        return null;
                    }
                    throw th;
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private void a(CloudResult cloudResult, CloudSearch.Query query) {
        HashMap<Integer, CloudResult> hashMap = new HashMap<>();
        this.f7170e = hashMap;
        if (this.f7169d > 0) {
            hashMap.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    private CloudResult a(int i10) {
        if (b(i10)) {
            return this.f7170e.get(Integer.valueOf(i10));
        }
        throw new IllegalArgumentException("page out of range");
    }
}
