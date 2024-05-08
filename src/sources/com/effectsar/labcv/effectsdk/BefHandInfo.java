package com.effectsar.labcv.effectsdk;

import android.graphics.PointF;
import android.graphics.Rect;
import com.alipay.sdk.util.i;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefHandInfo {
    private int handCount = 0;
    private BefHand[] hands;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefHand {
        private int action;

        /* renamed from: id, reason: collision with root package name */
        private int f19166id;
        private BefKeyPoint[] keyPoints;
        private BefKeyPoint[] keyPointsExt;
        private Rect rect;
        private float rotAngle;
        private float rotAngleBothhand;
        private float score;
        private int seqAction;

        public int getAction() {
            return this.action;
        }

        public int getId() {
            return this.f19166id;
        }

        public BefKeyPoint[] getKeyPoints() {
            return this.keyPoints;
        }

        public BefKeyPoint[] getKeyPointsExt() {
            return this.keyPointsExt;
        }

        public Rect getRect() {
            return this.rect;
        }

        public float getRotAngle() {
            return this.rotAngle;
        }

        public float getRotAngleBothhand() {
            return this.rotAngleBothhand;
        }

        public float getScore() {
            return this.score;
        }

        public int getSeqAction() {
            return this.seqAction;
        }

        public String toString() {
            return "BefHand{id=" + this.f19166id + ", rect=" + ((Object) this.rect) + ", action=" + this.action + ", rotAngle=" + this.rotAngle + ", score=" + this.score + ", rotAngleBothhand=" + this.rotAngleBothhand + ", keyPoints=" + Arrays.toString(this.keyPoints) + ", keyPointsExt=" + Arrays.toString(this.keyPointsExt) + ", seqAction=" + this.seqAction + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefKeyPoint {
        public boolean is_detect;

        /* renamed from: x, reason: collision with root package name */
        public float f19167x;

        /* renamed from: y, reason: collision with root package name */
        public float f19168y;

        public BefKeyPoint(float f10, float f11, boolean z10) {
            this.f19167x = f10;
            this.f19168y = f11;
            this.is_detect = z10;
        }

        public PointF asPoint() {
            return new PointF(this.f19167x, this.f19168y);
        }

        public String toString() {
            return "BefKeyPoint { x =" + this.f19167x + " y =" + this.f19168y + " is_detect =" + this.is_detect + i.f4738d;
        }
    }

    public int getHandCount() {
        return this.handCount;
    }

    public BefHand[] getHands() {
        return this.hands;
    }

    public String toString() {
        return "BefHandInfo{hands=" + Arrays.toString(this.hands) + ", handCount=" + this.handCount + '}';
    }
}
