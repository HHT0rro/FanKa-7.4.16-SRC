package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import com.amap.api.col.p0003l.db;
import com.amap.api.col.p0003l.du;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.fl;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.fu;
import com.amap.api.col.p0003l.gy;
import com.amap.api.col.p0003l.hy;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AMapLoader implements hy.a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private hy downloadManager;
    public ADataRequestParam mDataRequestParam;
    private int mEngineID;
    public GLMapEngine mGLMapEngine;
    private volatile boolean isCanceled = false;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;
    private boolean mRequestCancel = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class AMapGridDownloadRequest extends db {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.col.p0003l.id
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.col.p0003l.id
        public String getIPV6URL() {
            return dx.a(getURL());
        }

        @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.id
        public Map<String, String> getRequestHead() {
            fu a10 = dx.a();
            String b4 = a10 != null ? a10.b() : null;
            String f10 = fj.f(this.mContext);
            try {
                f10 = URLEncoder.encode(f10, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b4, "3dmap"));
            hashtable.put("x-INFO", fl.a(this.mContext));
            hashtable.put("key", f10);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.col.p0003l.id
        public String getURL() {
            return this.sUrl;
        }

        @Override // com.amap.api.col.p0003l.id
        public boolean isSupportIPV6() {
            return true;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    public AMapLoader(int i10, GLMapEngine gLMapEngine, ADataRequestParam aDataRequestParam) {
        this.mEngineID = 0;
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i10;
        this.mGLMapEngine = gLMapEngine;
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String f10 = fj.f(this.mGLMapEngine.getContext());
        try {
            f10 = URLEncoder.encode(f10, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(f10);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String a10 = fl.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a10)));
        stringBuffer.append("&scode=" + fl.a(context, a10, sortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String getNetworkFailedReason(String str) {
        return !this.mGLMapEngine.isNetworkConnected() ? "无网络" : str;
    }

    private void onCancel() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.netCancel(this.mEngineID, aDataRequestParam.handler, -1);
    }

    private String sortReEncoderParams(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private void staticNetworkPerformance() {
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null) {
            du.a(gLMapEngine.getContext(), this.mGLMapEngine.hashCode(), System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
        }
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            gy.b(e2, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e10) {
            gy.b(e10, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
                this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
            } finally {
            }
        }
    }

    public void doCancelAndNotify() {
        onCancel();
        doCancel();
    }

    public void doRequest() {
        if (fr.a(this.mGLMapEngine.getContext(), dx.a()).f5947a == fr.c.SuccessCode && !this.mRequestCancel) {
            ADataRequestParam aDataRequestParam = this.mDataRequestParam;
            String str = aDataRequestParam.requestBaseUrl;
            String str2 = aDataRequestParam.requestUrl;
            if (!str.endsWith(SymbolValues.QUESTION_EN_SYMBOL)) {
                str = str + SymbolValues.QUESTION_EN_SYMBOL;
            }
            String requestParams = getRequestParams(str2.replaceAll(";", getEncodeRequestParams(";").toString()), str != null && str.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(requestParams);
                stringBuffer.append("&csid=" + UUID.randomUUID().toString());
            } else {
                stringBuffer.append("csid=" + UUID.randomUUID().toString());
            }
            try {
                AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.mGLMapEngine.getContext(), str + generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()), this.mGLMapEngine.getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(30000);
                aMapGridDownloadRequest.setSoTimeout(30000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
                }
                this.requestMapDataTimestamp = System.currentTimeMillis();
                this.requestMapDataPackageSize = aMapGridDownloadRequest.getEntityBytes() == null ? 0L : aMapGridDownloadRequest.getEntityBytes().length;
                hy hyVar = new hy(aMapGridDownloadRequest, 0L, -1L, MapsInitializer.getProtocol() == 2);
                this.downloadManager = hyVar;
                hyVar.a(this);
            } catch (Throwable th) {
                try {
                    onException(th);
                } finally {
                    doCancel();
                }
            }
        }
    }

    public String getRequestParams(String str, boolean z10, int i10) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z10) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.3l.hy.a
    public void onDownload(byte[] bArr, long j10) {
        GLMapEngine gLMapEngine;
        ADataRequestParam aDataRequestParam;
        if (bArr == null || (gLMapEngine = this.mGLMapEngine) == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.receiveNetData(this.mEngineID, aDataRequestParam.handler, bArr, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r0 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
    
        com.amap.api.col.p0003l.gy.b(r11, "AMapLoader", "download onException");
        com.amap.api.col.p0003l.dz.b(com.amap.api.col.p0003l.dy.f5399e, "map loader exception " + r11.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0091, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        com.amap.api.col.p0003l.du.a(r0.getContext(), r10.mGLMapEngine.hashCode(), !r10.mGLMapEngine.isNetworkConnected() ? 1 : 0, getNetworkFailedReason(r11.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if (r0 == null) goto L26;
     */
    @Override // com.amap.api.col.3l.hy.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onException(java.lang.Throwable r11) {
        /*
            r10 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = r11.getMessage()     // Catch: java.lang.Throwable -> L40
            byte[] r2 = r2.getBytes(r0)     // Catch: java.lang.Throwable -> L40
            r1.<init>(r2, r0)     // Catch: java.lang.Throwable -> L40
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L40
            r2 = -1
            if (r0 != 0) goto L2a
            java.lang.String r0 = "网络异常状态码："
            int r0 = r1.indexOf(r0)     // Catch: java.lang.Throwable -> L40
            if (r0 == r2) goto L2a
            int r0 = r0 + 8
            java.lang.String r0 = r1.substring(r0)     // Catch: java.lang.Throwable -> L40
            int r2 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L40
            r8 = r2
            goto L2b
        L2a:
            r8 = -1
        L2b:
            com.autonavi.base.ae.gmap.GLMapEngine r3 = r10.mGLMapEngine
            if (r3 == 0) goto L3b
            com.autonavi.base.amap.mapcore.maploader.AMapLoader$ADataRequestParam r0 = r10.mDataRequestParam
            if (r0 == 0) goto L3b
            int r4 = r10.mEngineID
            long r5 = r0.handler
            r7 = -1
            r3.netError(r4, r5, r7, r8)
        L3b:
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r10.mGLMapEngine
            if (r0 == 0) goto L73
            goto L56
        L40:
            com.autonavi.base.ae.gmap.GLMapEngine r4 = r10.mGLMapEngine
            if (r4 == 0) goto L52
            com.autonavi.base.amap.mapcore.maploader.AMapLoader$ADataRequestParam r0 = r10.mDataRequestParam
            if (r0 == 0) goto L52
            int r5 = r10.mEngineID
            long r6 = r0.handler
            r8 = -1
            r9 = -1
            r4.netError(r5, r6, r8, r9)
        L52:
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r10.mGLMapEngine
            if (r0 == 0) goto L73
        L56:
            android.content.Context r0 = r0.getContext()
            com.autonavi.base.ae.gmap.GLMapEngine r1 = r10.mGLMapEngine
            int r1 = r1.hashCode()
            com.autonavi.base.ae.gmap.GLMapEngine r2 = r10.mGLMapEngine
            boolean r2 = r2.isNetworkConnected()
            r2 = r2 ^ 1
            java.lang.String r3 = r11.getMessage()
            java.lang.String r3 = r10.getNetworkFailedReason(r3)
            com.amap.api.col.p0003l.du.a(r0, r1, r2, r3)
        L73:
            java.lang.String r0 = "AMapLoader"
            java.lang.String r1 = "download onException"
            com.amap.api.col.p0003l.gy.b(r11, r0, r1)
            java.lang.String r0 = com.amap.api.col.p0003l.dy.f5399e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "map loader exception "
            r1.<init>(r2)
            java.lang.String r11 = r11.getMessage()
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            com.amap.api.col.p0003l.dz.b(r0, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.maploader.AMapLoader.onException(java.lang.Throwable):void");
    }

    @Override // com.amap.api.col.3l.hy.a
    public void onFinish() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.finishDownLoad(this.mEngineID, aDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    @Override // com.amap.api.col.3l.hy.a
    public void onStop() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.netStop(this.mEngineID, aDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}
