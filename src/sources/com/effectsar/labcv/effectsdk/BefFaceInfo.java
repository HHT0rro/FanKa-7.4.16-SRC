package com.effectsar.labcv.effectsdk;

import android.graphics.PointF;
import android.graphics.Rect;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefFaceInfo {
    private FaceAttri[] attris;
    private ExtraInfo[] extras;
    private Face106[] face106s;
    private FaceMaskInfo[] faceMask;
    private FaceMaskInfo[] mouthMask;
    private FaceMaskInfo[] teethMask;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ExtraInfo {
        public static final int EYE_BROW_POINTS_NUM = 13;
        public static final int EYE_IRIS_POINTS_NUM = 20;
        public static final int EYE_POINTS_NUM = 22;
        public static final int LIP_POINTS_NUM = 64;
        public int eye_count;
        public FacePoint[] eye_left;
        public FacePoint[] eye_right;
        public int eyebrow_count;
        public FacePoint[] eyebrow_left;
        public FacePoint[] eyebrow_right;
        public int iris_count;
        public FacePoint[] left_iris;
        public FacePoint[] lips;
        public int lips_count;
        public FacePoint[] right_iris;

        public FacePoint[] getEye_left() {
            FacePoint[] facePointArr = this.eye_left;
            return facePointArr == null ? new FacePoint[0] : facePointArr;
        }

        public FacePoint[] getEye_right() {
            FacePoint[] facePointArr = this.eye_right;
            return facePointArr == null ? new FacePoint[0] : facePointArr;
        }

        public FacePoint[] getEyebrow_left() {
            FacePoint[] facePointArr = this.eyebrow_left;
            return facePointArr == null ? new FacePoint[0] : facePointArr;
        }

        public FacePoint[] getEyebrow_right() {
            FacePoint[] facePointArr = this.eyebrow_right;
            return facePointArr == null ? new FacePoint[0] : facePointArr;
        }

        public FacePoint[] getLeft_iris() {
            FacePoint[] facePointArr = this.left_iris;
            return facePointArr == null ? new FacePoint[0] : facePointArr;
        }

        public FacePoint[] getLips() {
            FacePoint[] facePointArr = this.lips;
            return facePointArr == null ? new FacePoint[0] : facePointArr;
        }

        public FacePoint[] getRight_iris() {
            FacePoint[] facePointArr = this.right_iris;
            return facePointArr == null ? new FacePoint[0] : facePointArr;
        }

        public String toString() {
            return "ExtraInfo{eye_count=" + this.eye_count + ", eyebrow_count=" + this.eyebrow_count + ", lips_count=" + this.lips_count + ", iris_count=" + this.iris_count + ", eye_left=" + Arrays.toString(this.eye_left) + ", eye_right=" + Arrays.toString(this.eye_right) + ", eyebrow_left=" + Arrays.toString(this.eyebrow_left) + ", eyebrow_right=" + Arrays.toString(this.eyebrow_right) + ", lips=" + Arrays.toString(this.lips) + ", left_iris=" + Arrays.toString(this.left_iris) + ", right_iris=" + Arrays.toString(this.right_iris) + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Face106 {
        public int ID;
        public int action;
        public float eye_dist;
        public float pitch;
        public FacePoint[] points_array;
        public FaceRect rect;
        public float roll;
        public float score;
        public float[] visibility_array;
        public float yaw;

        public int getAction() {
            return this.action;
        }

        public float getEye_dist() {
            return this.eye_dist;
        }

        public int getID() {
            return this.ID;
        }

        public float getPitch() {
            return this.pitch;
        }

        public FacePoint[] getPoints_array() {
            return this.points_array;
        }

        public FaceRect getRect() {
            return this.rect;
        }

        public float getRoll() {
            return this.roll;
        }

        public float getScore() {
            return this.score;
        }

        public float[] getVisibility_array() {
            return this.visibility_array;
        }

        public float getYaw() {
            return this.yaw;
        }

        public String toString() {
            return "Face106{rect=" + ((Object) this.rect) + ", score=" + this.score + ", points_array=" + Arrays.toString(this.points_array) + ", visibility_array=" + Arrays.toString(this.visibility_array) + ", yaw=" + this.yaw + ", pitch=" + this.pitch + ", roll=" + this.roll + ", eye_dist=" + this.eye_dist + ", action=" + this.action + ", ID=" + this.ID + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceAttri {
        public float confuse_prob;
        public float[] exp_probs;
        public float age = 0.0f;
        public float boy_prob = 0.0f;
        public float attractive = 0.0f;
        public float happy_score = 0.0f;
        public int expression_type = 0;

        public float getAge() {
            return this.age;
        }

        public float getAttractive() {
            return this.attractive;
        }

        public float getBoy_prob() {
            return this.boy_prob;
        }

        public float getConfuseProb() {
            return this.confuse_prob;
        }

        public float[] getExp_probs() {
            float[] fArr = this.exp_probs;
            return fArr == null ? new float[0] : fArr;
        }

        public int getExpression_type() {
            return this.expression_type;
        }

        public float getHappy_score() {
            return this.happy_score;
        }

        public void setAge(float f10) {
            this.age = f10;
        }

        public void setAttractive(float f10) {
            this.attractive = f10;
        }

        public void setBoy_prob(float f10) {
            this.boy_prob = f10;
        }

        public void setExp_probs(float[] fArr) {
            this.exp_probs = fArr;
        }

        public void setExpression_type(int i10) {
            this.expression_type = i10;
        }

        public void setHappy_score(float f10) {
            this.happy_score = f10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceMaskInfo {
        public int ID;
        public byte[] mask;
        public int mask_size;
        public double[] warp_mat;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FacePoint {

        /* renamed from: x, reason: collision with root package name */
        public float f19164x;

        /* renamed from: y, reason: collision with root package name */
        public float f19165y;

        public FacePoint(float f10, float f11) {
            this.f19164x = f10;
            this.f19165y = f11;
        }

        public PointF asPoint() {
            return new PointF(this.f19164x, this.f19165y);
        }

        public float getX() {
            return this.f19164x;
        }

        public float getY() {
            return this.f19165y;
        }

        public void setX(float f10) {
            this.f19164x = f10;
        }

        public void setY(float f10) {
            this.f19165y = f10;
        }

        public String toString() {
            return "FacePoint{x=" + this.f19164x + ", y=" + this.f19165y + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceRect {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public FaceRect(int i10, int i11, int i12, int i13) {
            this.left = i10;
            this.right = i12;
            this.top = i11;
            this.bottom = i13;
        }

        public int getBottom() {
            return this.bottom;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getTop() {
            return this.top;
        }

        public void setBottom(int i10) {
            this.bottom = i10;
        }

        public void setLeft(int i10) {
            this.left = i10;
        }

        public void setRight(int i10) {
            this.right = i10;
        }

        public void setTop(int i10) {
            this.top = i10;
        }

        public Rect toRect() {
            return new Rect(this.left, this.top, this.right, this.bottom);
        }

        public String toString() {
            return "FaceRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
    }

    public FaceAttri[] getAttris() {
        FaceAttri[] faceAttriArr = this.attris;
        return faceAttriArr == null ? new FaceAttri[0] : faceAttriArr;
    }

    public ExtraInfo[] getExtras() {
        ExtraInfo[] extraInfoArr = this.extras;
        return extraInfoArr == null ? new ExtraInfo[0] : extraInfoArr;
    }

    public Face106[] getFace106s() {
        Face106[] face106Arr = this.face106s;
        return face106Arr != null ? face106Arr : new Face106[0];
    }

    public FaceMaskInfo[] getFaceMaskInfo() {
        FaceMaskInfo[] faceMaskInfoArr = this.faceMask;
        return faceMaskInfoArr == null ? new FaceMaskInfo[0] : faceMaskInfoArr;
    }

    public FaceMaskInfo[] getMouthMaskInfo() {
        FaceMaskInfo[] faceMaskInfoArr = this.mouthMask;
        return faceMaskInfoArr == null ? new FaceMaskInfo[0] : faceMaskInfoArr;
    }

    public FaceMaskInfo[] getTeethMaskInfo() {
        FaceMaskInfo[] faceMaskInfoArr = this.teethMask;
        return faceMaskInfoArr == null ? new FaceMaskInfo[0] : faceMaskInfoArr;
    }

    public String toString() {
        return "BefFaceInfo{face106s=" + Arrays.toString(this.face106s) + ", extras=" + Arrays.toString(this.extras) + ", attris=" + Arrays.toString(this.attris) + ", mouthMask=" + Arrays.toString(this.mouthMask) + ", teethMask=" + Arrays.toString(this.teethMask) + ", faceMask=" + Arrays.toString(this.faceMask) + '}';
    }
}
