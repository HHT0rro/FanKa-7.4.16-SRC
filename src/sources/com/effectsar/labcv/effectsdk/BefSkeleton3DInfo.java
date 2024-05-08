package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefSkeleton3DInfo {
    public static final int SKELETON_3D_EXTENDED_JOINT_NUM = 64;
    public static final int SKELETON_3D_HEATMAP_KEYPOINT_NUM = 27;
    public static final int SKELETON_3D_MAX_TARGET_NUM = 5;
    public float focal_length;
    public TargetInfo[] targetInfos = new TargetInfo[5];
    public int target_num;
    public int tracking;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class TargetInfo {
        public int joint_num;
        public int new_target;
        public int tracking_id;
        public float[] quaternion = new float[256];
        public float[] betas = new float[10];
        public float[] root = new float[3];
        public float[] joints = new float[192];
        public float[] scores = new float[64];
        public float[] joint_valid = new float[64];
        public float[] heatmap_kpts_2d = new float[54];
        public float[] box = new float[4];

        public String toString() {
            return "TargetInfo{quaternion=" + Arrays.toString(this.quaternion) + ", betas=" + Arrays.toString(this.betas) + ", root=" + Arrays.toString(this.root) + ", joints=" + Arrays.toString(this.joints) + ", scores=" + Arrays.toString(this.scores) + ", joint_valid=" + Arrays.toString(this.joint_valid) + ", heatmap_kpts_2d=" + Arrays.toString(this.heatmap_kpts_2d) + ", box=" + Arrays.toString(this.box) + ", joint_num=" + this.joint_num + ", tracking_id=" + this.tracking_id + ", new_target=" + this.new_target + '}';
        }
    }

    public BefSkeleton3DInfo() {
        int i10 = 0;
        while (true) {
            TargetInfo[] targetInfoArr = this.targetInfos;
            if (i10 >= targetInfoArr.length) {
                return;
            }
            targetInfoArr[i10] = new TargetInfo();
            i10++;
        }
    }

    public float getFocal_length() {
        return this.focal_length;
    }

    public TargetInfo[] getTargetInfos() {
        return this.targetInfos;
    }

    public int getTarget_num() {
        return this.target_num;
    }

    public int getTracking() {
        return this.tracking;
    }

    public void setFocal_length(float f10) {
        this.focal_length = f10;
    }

    public void setTargetInfos(TargetInfo[] targetInfoArr) {
        this.targetInfos = targetInfoArr;
    }

    public void setTarget_num(int i10) {
        this.target_num = i10;
    }

    public void setTracking(int i10) {
        this.tracking = i10;
    }

    public String toString() {
        return "BefSkeleton3DInfo{targetInfos=" + Arrays.toString(this.targetInfos) + ", target_num=" + this.target_num + ", focal_length=" + this.focal_length + ", tracking=" + this.tracking + '}';
    }
}
