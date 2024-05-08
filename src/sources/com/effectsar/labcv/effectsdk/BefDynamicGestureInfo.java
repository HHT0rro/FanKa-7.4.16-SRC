package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefDynamicGestureInfo {
    private GestureInfo[] gestureInfos;
    private int gestureNum;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class GestureInfo {
        private int actionType = 0;
        private float actionScore = 0.0f;

        public float getActionScore() {
            return this.actionScore;
        }

        public int getActionType() {
            return this.actionType;
        }

        public String toString() {
            return "GestureInfo{actionType=" + this.actionType + ", actionType=" + this.actionType + '}';
        }
    }

    public GestureInfo[] getGestureInfos() {
        return this.gestureInfos;
    }

    public int getGestureNum() {
        return this.gestureNum;
    }

    public void setGestureInfos(GestureInfo[] gestureInfoArr) {
        this.gestureInfos = gestureInfoArr;
    }

    public void setGestureNum(int i10) {
        this.gestureNum = i10;
    }
}
