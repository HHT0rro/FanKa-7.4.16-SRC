package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.BefPublicDefine;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefDynamicActionInfo {
    private int personCount;
    private DynamicActionInfo[] persons;
    private DynamicSkInfo[] skInfos;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DynamicActionInfo {
        private int action;
        private int actionDuration;
        private float actionScore;

        /* renamed from: id, reason: collision with root package name */
        private int f19162id;
        private int personId;
        private BefPublicDefine.BefRect rect;
        private BefPublicDefine.BefRect rectStl;

        public int getAction() {
            return this.action;
        }

        public int getActionDuration() {
            return this.actionDuration;
        }

        public float getActionScore() {
            return this.actionScore;
        }

        public int getId() {
            return this.f19162id;
        }

        public int getPersonId() {
            return this.personId;
        }

        public BefPublicDefine.BefRect getRect() {
            return this.rect;
        }

        public BefPublicDefine.BefRect getRectStl() {
            return this.rectStl;
        }

        public String toString() {
            return "DynamicActionInfo{id=" + this.f19162id + ", personId=" + this.personId + ", rect=" + ((Object) this.rect) + ", rectStl=" + ((Object) this.rectStl) + ", action=" + this.action + ", actionDuration=" + this.actionDuration + ", actionScore=" + this.actionScore + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DynamicSkInfo {

        /* renamed from: id, reason: collision with root package name */
        private int f19163id;
        private BefPublicDefine.BefKeyPoint[] keyPoints;
        private BefPublicDefine.BefRect rect;

        public int getId() {
            return this.f19163id;
        }

        public BefPublicDefine.BefKeyPoint[] getKeyPoints() {
            return this.keyPoints;
        }

        public BefPublicDefine.BefRect getRect() {
            return this.rect;
        }

        public void setId(int i10) {
            this.f19163id = i10;
        }

        public void setKeyPoints(BefPublicDefine.BefKeyPoint[] befKeyPointArr) {
            this.keyPoints = befKeyPointArr;
        }

        public void setRect(BefPublicDefine.BefRect befRect) {
            this.rect = befRect;
        }

        public String toString() {
            return "DynamicSkInfo{id=" + this.f19163id + ", rect=" + ((Object) this.rect) + ", keyPoints=" + Arrays.toString(this.keyPoints) + '}';
        }
    }

    public int getPersonCount() {
        return this.personCount;
    }

    public DynamicActionInfo[] getPersons() {
        return this.persons;
    }

    public DynamicSkInfo[] getSkInfos() {
        return this.skInfos;
    }
}
