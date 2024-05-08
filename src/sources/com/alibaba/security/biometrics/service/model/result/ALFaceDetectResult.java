package com.alibaba.security.biometrics.service.model.result;

import android.graphics.Rect;
import android.graphics.RectF;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALFaceDetectResult implements Serializable {
    public static final int FACE_CHECK_FACE_UNEVEN = 9;
    public static final int FACE_CHECK_GESTURE_SMALL = 7;
    public static final int FACE_CHECK_NONE = 0;
    public static final int FACE_CHECK_NOTINREGION = 1;
    public static final int FACE_CHECK_PITCH_TOO_BIG = 8;
    public static final int FACE_CHECK_SHAKE = 5;
    public static final int FACE_CHECK_TOOCLOSE = 6;
    public static final int FACE_CHECK_TOOFAR = 2;
    public static final int FACE_CHECK_TOO_DARK = 4;
    public static final int FACE_CHECK_YAW_TOO_BIG = 3;
    public static final String KEY_FACEDETECT_RESULT = "KEY_FACEDETECT_RESULT";
    private static final long serialVersionUID = 1;
    public float backHighlight;
    public byte[] bestImageData;
    public float blinkScore;
    public float brightDiff;
    public int[] errors;
    public RectF facePosition;
    public Rect faceSize;
    public float faceSpeed;
    public int imageHeight;
    public int imageWidth;
    public float landmarkScore;
    public float mouthScore;
    public float pitchScore;
    public float yawScore;
    public int facesDetected = 0;
    public float brightness = -1.0f;
    public float gaussianBlur = -1.0f;
    public float motionBlur = -1.0f;
    public float faceQuality = -1.0f;
    public int checkResult = 0;
    public boolean success = false;

    public int facesDetected() {
        return this.facesDetected;
    }

    public float getBackHighlight() {
        return this.backHighlight;
    }

    public byte[] getBestImageData() {
        return this.bestImageData;
    }

    public float getBlinkScore() {
        return this.blinkScore;
    }

    public float getBrightDiff() {
        return this.brightDiff;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public int getCheckResult() {
        return this.checkResult;
    }

    public int[] getErrors() {
        return this.errors;
    }

    public RectF getFacePosition() {
        return this.facePosition;
    }

    public float getFaceQuality() {
        return this.faceQuality;
    }

    public Rect getFaceSize() {
        return this.faceSize;
    }

    public float getFaceSpeed() {
        return this.faceSpeed;
    }

    public int getFacesDetected() {
        return this.facesDetected;
    }

    public float getGaussianBlur() {
        return this.gaussianBlur;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public float getLandmarkScore() {
        return this.landmarkScore;
    }

    public float getMotionBlur() {
        return this.motionBlur;
    }

    public float getMouthScore() {
        return this.mouthScore;
    }

    public float getPitchScore() {
        return this.pitchScore;
    }

    public float getYawScore() {
        return this.yawScore;
    }

    public boolean hasFace() {
        return facesDetected() > 0;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public ALFaceDetectResult setBackHighlight(float f10) {
        this.backHighlight = f10;
        return this;
    }

    public void setBestImageData(byte[] bArr) {
        this.bestImageData = bArr;
    }

    public ALFaceDetectResult setBlinkScore(float f10) {
        this.blinkScore = f10;
        return this;
    }

    public ALFaceDetectResult setBrightDiff(float f10) {
        this.brightDiff = f10;
        return this;
    }

    public void setBrightness(float f10) {
        this.brightness = f10;
    }

    public ALFaceDetectResult setCheckResult(int i10) {
        this.checkResult = i10;
        return this;
    }

    public void setErrors(int[] iArr) {
        this.errors = iArr;
    }

    public void setFacePosition(RectF rectF) {
        this.facePosition = rectF;
    }

    public void setFaceQuality(float f10) {
        this.faceQuality = f10;
    }

    public void setFaceSize(Rect rect) {
        this.faceSize = rect;
    }

    public ALFaceDetectResult setFaceSpeed(float f10) {
        this.faceSpeed = f10;
        return this;
    }

    public void setFacesDetected(int i10) {
        this.facesDetected = i10;
    }

    public void setGaussianBlur(float f10) {
        this.gaussianBlur = f10;
    }

    public void setImageHeight(int i10) {
        this.imageHeight = i10;
    }

    public void setImageWidth(int i10) {
        this.imageWidth = i10;
    }

    public ALFaceDetectResult setLandmarkScore(float f10) {
        this.landmarkScore = f10;
        return this;
    }

    public void setMotionBlur(float f10) {
        this.motionBlur = f10;
    }

    public ALFaceDetectResult setMouthScore(float f10) {
        this.mouthScore = f10;
        return this;
    }

    public ALFaceDetectResult setPitchScore(float f10) {
        this.pitchScore = f10;
        return this;
    }

    public void setSuccess(boolean z10) {
        this.success = z10;
    }

    public ALFaceDetectResult setYawScore(float f10) {
        this.yawScore = f10;
        return this;
    }
}
