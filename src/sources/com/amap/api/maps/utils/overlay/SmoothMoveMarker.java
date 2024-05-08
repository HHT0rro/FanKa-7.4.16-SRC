package com.amap.api.maps.utils.overlay;

import android.graphics.Point;
import com.amap.api.col.p0003l.dw;
import com.amap.api.col.p0003l.jd;
import com.amap.api.col.p0003l.je;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SmoothMoveMarker {
    public static final float MIN_OFFSET_DISTANCE = 5.0f;
    private BitmapDescriptor descriptor;
    private AMap mAMap;
    private MoveListener moveListener;
    private long pauseMillis;
    private long duration = 10000;
    private long mStepDuration = 20;
    private LinkedList<LatLng> points = new LinkedList<>();
    private LinkedList<Double> eachDistance = new LinkedList<>();
    private double totalDistance = ShadowDrawableWrapper.COS_45;
    private double remainDistance = ShadowDrawableWrapper.COS_45;
    private Object mLock = new Object();
    private Marker marker = null;
    private int index = 0;
    private boolean useDefaultDescriptor = false;
    public AtomicBoolean exitFlag = new AtomicBoolean(false);
    private a moveStatus = a.ACTION_UNKNOWN;
    private long mAnimationBeginTime = System.currentTimeMillis();
    private jd mThreadPools = dw.a("AMapSmoothMoveMarkerThread");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface MoveListener {
        void move(double d10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b extends je {
        private b() {
        }

        @Override // com.amap.api.col.p0003l.je
        public final void runTask() {
            try {
                SmoothMoveMarker.this.mAnimationBeginTime = System.currentTimeMillis();
                SmoothMoveMarker.this.moveStatus = a.ACTION_START;
                SmoothMoveMarker.this.exitFlag.set(false);
                while (!SmoothMoveMarker.this.exitFlag.get() && SmoothMoveMarker.this.index <= SmoothMoveMarker.this.points.size() - 1) {
                    synchronized (SmoothMoveMarker.this.mLock) {
                        if (SmoothMoveMarker.this.exitFlag.get()) {
                            return;
                        }
                        if (SmoothMoveMarker.this.moveStatus != a.ACTION_PAUSE) {
                            IPoint curPosition = SmoothMoveMarker.this.getCurPosition(System.currentTimeMillis() - SmoothMoveMarker.this.mAnimationBeginTime);
                            if (SmoothMoveMarker.this.marker != null) {
                                SmoothMoveMarker.this.marker.setGeoPoint(curPosition);
                            }
                            SmoothMoveMarker.this.moveStatus = a.ACTION_RUNNING;
                        }
                    }
                    Thread.sleep(SmoothMoveMarker.this.mStepDuration);
                }
                SmoothMoveMarker.this.moveStatus = a.ACTION_STOP;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public /* synthetic */ b(SmoothMoveMarker smoothMoveMarker, byte b4) {
            this();
        }
    }

    public SmoothMoveMarker(AMap aMap) {
        this.mAMap = aMap;
    }

    private void checkMarkerIcon() {
        if (this.useDefaultDescriptor) {
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor == null) {
                this.useDefaultDescriptor = true;
            } else {
                this.marker.setIcon(bitmapDescriptor);
                this.useDefaultDescriptor = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPoint getCurPosition(long j10) {
        CameraPosition cameraPosition;
        MoveListener moveListener;
        long j11 = this.duration;
        int i10 = 0;
        if (j10 > j11) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            LatLng latLng = this.points.get(size);
            int i11 = this.index - 1;
            this.index = i11;
            this.index = Math.max(i11, 0);
            this.remainDistance = ShadowDrawableWrapper.COS_45;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener2 = this.moveListener;
            if (moveListener2 != null) {
                moveListener2.move(this.remainDistance);
            }
            return iPoint;
        }
        double d10 = this.totalDistance;
        double d11 = (j10 * d10) / j11;
        this.remainDistance = d10 - d11;
        int i12 = 0;
        while (true) {
            if (i12 >= this.eachDistance.size()) {
                break;
            }
            double doubleValue = this.eachDistance.get(i12).doubleValue();
            if (d11 > doubleValue) {
                d11 -= doubleValue;
                i12++;
            } else {
                r0 = doubleValue > ShadowDrawableWrapper.COS_45 ? d11 / doubleValue : 1.0d;
                i10 = i12;
            }
        }
        if (i10 != this.index && (moveListener = this.moveListener) != null) {
            moveListener.move(this.remainDistance);
        }
        this.index = i10;
        LatLng latLng2 = this.points.get(i10);
        LatLng latLng3 = this.points.get(i10 + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i13 = ((Point) iPoint3).x - ((Point) iPoint2).x;
        int i14 = ((Point) iPoint3).y - ((Point) iPoint2).y;
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 5.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.marker.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        return new IPoint((int) (((Point) iPoint2).x + (i13 * r0)), (int) (((Point) iPoint2).y + (i14 * r0)));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d10 = ((Point) iPoint2).y;
        return (float) ((Math.atan2(((Point) iPoint2).x - ((Point) iPoint).x, ((Point) iPoint).y - d10) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            a aVar = this.moveStatus;
            if (aVar == a.ACTION_RUNNING || aVar == a.ACTION_PAUSE) {
                this.exitFlag.set(true);
                this.mThreadPools.a(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
                Marker marker = this.marker;
                if (marker != null) {
                    marker.setAnimation(null);
                }
                this.moveStatus = a.ACTION_UNKNOWN;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void destroy() {
        try {
            reset();
            this.mThreadPools.e();
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor != null) {
                bitmapDescriptor.recycle();
            }
            Marker marker = this.marker;
            if (marker != null) {
                marker.destroy();
                this.marker = null;
            }
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getIndex() {
        return this.index;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getPosition() {
        Marker marker = this.marker;
        if (marker == null) {
            return null;
        }
        return marker.getPosition();
    }

    public void removeMarker() {
        Marker marker = this.marker;
        if (marker != null) {
            marker.remove();
            this.marker = null;
        }
        this.points.clear();
        this.eachDistance.clear();
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setDescriptor(BitmapDescriptor bitmapDescriptor) {
        BitmapDescriptor bitmapDescriptor2 = this.descriptor;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
        }
        this.descriptor = bitmapDescriptor;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setIcon(bitmapDescriptor);
        }
    }

    public void setMoveListener(MoveListener moveListener) {
        this.moveListener = moveListener;
    }

    public void setPoints(List<LatLng> list) {
        synchronized (this.mLock) {
            if (list != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (list.size() >= 2) {
                    stopMove();
                    this.points.clear();
                    for (LatLng latLng : list) {
                        if (latLng != null) {
                            this.points.add(latLng);
                        }
                    }
                    this.eachDistance.clear();
                    this.totalDistance = ShadowDrawableWrapper.COS_45;
                    int i10 = 0;
                    while (i10 < this.points.size() - 1) {
                        LatLng latLng2 = this.points.get(i10);
                        i10++;
                        double calculateLineDistance = AMapUtils.calculateLineDistance(latLng2, this.points.get(i10));
                        this.eachDistance.add(Double.valueOf(calculateLineDistance));
                        this.totalDistance += calculateLineDistance;
                    }
                    this.remainDistance = this.totalDistance;
                    LatLng latLng3 = this.points.get(0);
                    Marker marker = this.marker;
                    if (marker != null) {
                        marker.setPosition(latLng3);
                        checkMarkerIcon();
                    } else {
                        if (this.descriptor == null) {
                            this.useDefaultDescriptor = true;
                        }
                        this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(latLng3).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
                    }
                    reset();
                }
            }
        }
    }

    public void setPosition(LatLng latLng) {
        Marker marker = this.marker;
        if (marker != null) {
            marker.setPosition(latLng);
            checkMarkerIcon();
        } else {
            if (this.descriptor == null) {
                this.useDefaultDescriptor = true;
            }
            this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(latLng).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
        }
    }

    public void setRotate(float f10) {
        AMap aMap;
        CameraPosition cameraPosition;
        if (this.marker == null || (aMap = this.mAMap) == null || aMap == null || (cameraPosition = aMap.getCameraPosition()) == null) {
            return;
        }
        this.marker.setRotateAngle((360.0f - f10) + cameraPosition.bearing);
    }

    public void setTotalDuration(int i10) {
        this.duration = i10 * 1000;
    }

    public void setVisible(boolean z10) {
        Marker marker = this.marker;
        if (marker != null) {
            marker.setVisible(z10);
        }
    }

    public void startSmoothMove() {
        a aVar = this.moveStatus;
        if (aVar == a.ACTION_PAUSE) {
            this.moveStatus = a.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((aVar == a.ACTION_UNKNOWN || aVar == a.ACTION_STOP) && this.points.size() > 0) {
            byte b4 = 0;
            this.index = 0;
            try {
                this.mThreadPools.a(new b(this, b4));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void stopMove() {
        if (this.moveStatus == a.ACTION_RUNNING) {
            this.moveStatus = a.ACTION_PAUSE;
            this.pauseMillis = System.currentTimeMillis();
        }
    }
}
