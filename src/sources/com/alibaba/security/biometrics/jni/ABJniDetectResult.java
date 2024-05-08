package com.alibaba.security.biometrics.jni;

import android.graphics.Rect;
import com.alibaba.security.biometrics.service.build.b;
import com.alibaba.security.common.json.annotation.RPJSONField;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ABJniDetectResult implements Serializable {

    @RPJSONField(name = "brightnessHistory")
    public String brightnessHistory;

    @RPJSONField(name = "brightnessScores")
    public String brightnessScores;

    @RPJSONField(serialize = false)
    public int faceHeight;

    @RPJSONField(serialize = false)
    public int faceLeft;

    @RPJSONField(serialize = false)
    public int faceTop;

    @RPJSONField(serialize = false)
    public int faceWidth;

    @RPJSONField(name = "leftEyeDataHeight")
    public int leftEyeDataHeight;

    @RPJSONField(name = "leftEyeDataWidth")
    public int leftEyeDataWidth;

    @RPJSONField(name = "reflectBrightnessFrames")
    public int reflectBrightnessFrames;

    @RPJSONField(name = "reflectBrightnessScore")
    public float reflectBrightnessScore;

    @RPJSONField(name = "reflectBrightnessScores")
    public float[] reflectBrightnessScores;

    @RPJSONField(name = "reflectDetectType")
    public int reflectDetectType;

    @RPJSONField(name = "reflectEyeFrames")
    public int reflectEyeFrames;

    @RPJSONField(name = "reflectEyeValidFrames")
    public int reflectEyeValidFrames;

    @RPJSONField(name = "reflectFrames")
    public int reflectFrames;

    @RPJSONField(name = "reflectScore")
    public float reflectScore;

    @RPJSONField(name = "rightEyeDataHeight")
    public int rightEyeDataHeight;

    @RPJSONField(name = "rightEyeDataWidth")
    public int rightEyeDataWidth;

    @RPJSONField(name = "faceExist")
    public boolean faceExist = false;

    @RPJSONField(serialize = false)
    public float[] faceKeyPoint = new float[36];

    @RPJSONField(serialize = false)
    public float[] faceKeyPointInBigImg = new float[36];

    @RPJSONField(serialize = false)
    public Rect faceRectSmooth = new Rect();

    @RPJSONField(serialize = false)
    public long initTime = 0;

    @RPJSONField(name = "iDetectType")
    public int iDetectType = 0;

    @RPJSONField(name = "iDetectTypeOld")
    public int iDetectTypeOld = 0;

    @RPJSONField(name = "iDetectState")
    public int iDetectState = 0;

    @RPJSONField(serialize = false)
    public int msecChangeDetectType = 0;

    @RPJSONField(serialize = false)
    public int msecCurrentTime = 0;

    @RPJSONField(name = "outOfRegion")
    public boolean outOfRegion = false;

    @RPJSONField(name = "tooSmall")
    public boolean tooSmall = false;

    @RPJSONField(name = "tooBig")
    public boolean tooBig = false;

    @RPJSONField(name = "still")
    public boolean still = false;

    @RPJSONField(name = "brightness")
    public float brightness = 0.0f;

    @RPJSONField(name = "quality")
    public float quality = 0.0f;

    @RPJSONField(name = "staticQuality")
    public float staticQuality = 0.0f;

    @RPJSONField(name = "pitchScore")
    public float pitchScore = 0.0f;

    @RPJSONField(name = "yawScore")
    public float yawScore = 0.0f;

    @RPJSONField(name = "mouthScore")
    public float mouthScore = 0.0f;

    @RPJSONField(name = "blinkScore")
    public float blinkScore = 0.0f;

    @RPJSONField(name = "landmarkScore")
    public float landmarkScore = -1.0f;

    @RPJSONField(name = "brightDiff")
    public float brightDiff = 0.0f;

    @RPJSONField(name = "backHightlight")
    public float backHightlight = 0.0f;

    @RPJSONField(name = "faceSpeed")
    public float faceSpeed = 0.0f;

    @RPJSONField(name = "gestureProgress")
    public float gestureProgress = 0.0f;

    @RPJSONField(name = "countPitch")
    public int countPitch = 0;

    @RPJSONField(name = "countYaw")
    public int countYaw = 0;

    @RPJSONField(name = "countMouth")
    public int countMouth = 0;

    @RPJSONField(name = "countBlink")
    public int countBlink = 0;

    @RPJSONField(name = "countFaceDisappear")
    public int countFaceDisappear = 0;

    @RPJSONField(name = "faceChange")
    public boolean faceChange = false;

    @RPJSONField(name = "mouthOcclusion")
    public boolean mouthOcclusion = false;

    @RPJSONField(name = "eyeOcclusionOnce")
    public boolean eyeOcclusionOnce = false;

    @RPJSONField(name = "confirm3D")
    public boolean confirm3D = false;

    @RPJSONField(serialize = false)
    public int msecLeft = 10000;

    @RPJSONField(name = "iPromptMessage")
    public int iPromptMessage = 0;

    @RPJSONField(name = "iFailReason")
    public int iFailReason = 0;

    @RPJSONField(serialize = false)
    public int bigImgWidth = 0;

    @RPJSONField(serialize = false)
    public int bigImgHeight = 0;

    @RPJSONField(serialize = false)
    public byte[] bigImgBuffer = null;

    @RPJSONField(serialize = false)
    public int globalImgWidth = 0;

    @RPJSONField(serialize = false)
    public int globalImgHeight = 0;

    @RPJSONField(serialize = false)
    public byte[] globalImgBuffer = null;

    @RPJSONField(serialize = false)
    public int localImgWidth = 0;

    @RPJSONField(serialize = false)
    public int localImgHeight = 0;

    @RPJSONField(serialize = false)
    public byte[] localImgBuffer = null;

    @RPJSONField(serialize = false)
    public int actionImgWidth = 0;

    @RPJSONField(serialize = false)
    public int actionImgHeight = 0;

    @RPJSONField(serialize = false)
    public byte[][] actionImgBuffer = null;

    @RPJSONField(serialize = false)
    public int frameWidth = 0;

    @RPJSONField(serialize = false)
    public int frameHeight = 0;

    @RPJSONField(serialize = false)
    public byte[] frameBuffer = null;

    @RPJSONField(serialize = false)
    public String failLog = null;

    @RPJSONField(name = "reflectResult")
    public int reflectResult = -1;

    @RPJSONField(name = "reflectBrightnessResult")
    public int reflectBrightnessResult = -1;

    @RPJSONField(name = "reflectEyeResult")
    public int reflectEyeResult = -1;

    @RPJSONField(name = "reflectLeftEyeResult")
    public int reflectLeftEyeResult = -1;

    @RPJSONField(name = "reflectRightEyeResult")
    public int reflectRightEyeResult = -1;

    @RPJSONField(name = b.bp)
    public float iso = -1.0f;

    @RPJSONField(name = b.bq)
    public float illuminance = -1.0f;

    @RPJSONField(name = "reflectCmd")
    public int reflectCmd = -1;
    public byte[] leftEyeData = null;
    public byte[] rightEyeData = null;

    /* renamed from: ec, reason: collision with root package name */
    @RPJSONField(name = "ec")
    public int f2423ec = -1;

    @RPJSONField(name = "ecpc")
    public int ecpc = -1;

    @RPJSONField(name = "etcc")
    public int etcc = -1;

    @RPJSONField(name = "ecResult")
    public String ecResult = "";

    public ABJniDetectState detectState() {
        return ABJniDetectState.values()[this.iDetectState];
    }

    public ABJniDetectType detectType() {
        return ABJniDetectType.valueOf(this.iDetectType);
    }

    public ABJniDetectType detectTypeOld() {
        return ABJniDetectType.valueOf(this.iDetectTypeOld);
    }

    public ABJniFailReason failReason() {
        return ABJniFailReason.valueOf(this.iFailReason);
    }

    public byte[][] getActionImgBuffer() {
        return this.actionImgBuffer;
    }

    public int getActionImgHeight() {
        return this.actionImgHeight;
    }

    public int getActionImgWidth() {
        return this.actionImgWidth;
    }

    public float getBackHightlight() {
        return this.backHightlight;
    }

    public byte[] getBigImgBuffer() {
        return this.bigImgBuffer;
    }

    public int getBigImgHeight() {
        return this.bigImgHeight;
    }

    public int getBigImgWidth() {
        return this.bigImgWidth;
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

    public String getBrightnessHistory() {
        return this.brightnessHistory;
    }

    public String getBrightnessScores() {
        return this.brightnessScores;
    }

    public int getCountBlink() {
        return this.countBlink;
    }

    public int getCountFaceDisappear() {
        return this.countFaceDisappear;
    }

    public int getCountMouth() {
        return this.countMouth;
    }

    public int getCountPitch() {
        return this.countPitch;
    }

    public int getCountYaw() {
        return this.countYaw;
    }

    public int getEc() {
        return this.f2423ec;
    }

    public String getEcResult() {
        return this.ecResult;
    }

    public int getEcpc() {
        return this.ecpc;
    }

    public int getEtcc() {
        return this.etcc;
    }

    public int getFaceHeight() {
        return this.faceHeight;
    }

    public float[] getFaceKeyPoint() {
        return this.faceKeyPoint;
    }

    public float[] getFaceKeyPointInBigImg() {
        return this.faceKeyPointInBigImg;
    }

    public int getFaceLeft() {
        return this.faceLeft;
    }

    public Rect getFaceRectSmooth() {
        return this.faceRectSmooth;
    }

    public float getFaceSpeed() {
        return this.faceSpeed;
    }

    public int getFaceTop() {
        return this.faceTop;
    }

    public int getFaceWidth() {
        return this.faceWidth;
    }

    public String getFailLog() {
        return this.failLog;
    }

    public byte[] getFrameBuffer() {
        return this.frameBuffer;
    }

    public int getFrameHeight() {
        return this.frameHeight;
    }

    public int getFrameWidth() {
        return this.frameWidth;
    }

    public float getGestureProgress() {
        return this.gestureProgress;
    }

    public byte[] getGlobalImgBuffer() {
        return this.globalImgBuffer;
    }

    public int getGlobalImgHeight() {
        return this.globalImgHeight;
    }

    public int getGlobalImgWidth() {
        return this.globalImgWidth;
    }

    public float getIlluminance() {
        return this.illuminance;
    }

    public long getInitTime() {
        return this.initTime;
    }

    public float getIso() {
        return this.iso;
    }

    public float getLandmarkScore() {
        return this.landmarkScore;
    }

    public byte[] getLeftEyeData() {
        return this.leftEyeData;
    }

    public int getLeftEyeDataHeight() {
        return this.leftEyeDataHeight;
    }

    public int getLeftEyeDataWidth() {
        return this.leftEyeDataWidth;
    }

    public byte[] getLocalImgBuffer() {
        return this.localImgBuffer;
    }

    public int getLocalImgHeight() {
        return this.localImgHeight;
    }

    public int getLocalImgWidth() {
        return this.localImgWidth;
    }

    public float getMouthScore() {
        return this.mouthScore;
    }

    public int getMsecChangeDetectType() {
        return this.msecChangeDetectType;
    }

    public int getMsecCurrentTime() {
        return this.msecCurrentTime;
    }

    public int getMsecLeft() {
        return this.msecLeft;
    }

    public float getPitchScore() {
        return this.pitchScore;
    }

    public float getQuality() {
        return this.quality;
    }

    public int getReflectBrightnessFrames() {
        return this.reflectBrightnessFrames;
    }

    public int getReflectBrightnessResult() {
        return this.reflectBrightnessResult;
    }

    public float getReflectBrightnessScore() {
        return this.reflectBrightnessScore;
    }

    public float[] getReflectBrightnessScores() {
        return this.reflectBrightnessScores;
    }

    public int getReflectCmd() {
        return this.reflectCmd;
    }

    public int getReflectDetectType() {
        return this.reflectDetectType;
    }

    public int getReflectEyeFrames() {
        return this.reflectEyeFrames;
    }

    public int getReflectEyeResult() {
        return this.reflectEyeResult;
    }

    public int getReflectEyeValidFrames() {
        return this.reflectEyeValidFrames;
    }

    public int getReflectFrames() {
        return this.reflectFrames;
    }

    public int getReflectLeftEyeResult() {
        return this.reflectLeftEyeResult;
    }

    public int getReflectResult() {
        return this.reflectResult;
    }

    public int getReflectRightEyeResult() {
        return this.reflectRightEyeResult;
    }

    public float getReflectScore() {
        return this.reflectScore;
    }

    public byte[] getRightEyeData() {
        return this.rightEyeData;
    }

    public int getRightEyeDataHeight() {
        return this.rightEyeDataHeight;
    }

    public int getRightEyeDataWidth() {
        return this.rightEyeDataWidth;
    }

    public float getStaticQuality() {
        return this.staticQuality;
    }

    public float getYawScore() {
        return this.yawScore;
    }

    public int getiDetectState() {
        return this.iDetectState;
    }

    public int getiDetectType() {
        return this.iDetectType;
    }

    public int getiDetectTypeOld() {
        return this.iDetectTypeOld;
    }

    public int getiFailReason() {
        return this.iFailReason;
    }

    public int getiPromptMessage() {
        return this.iPromptMessage;
    }

    public boolean isConfirm3D() {
        return this.confirm3D;
    }

    public boolean isEyeOcclusionOnce() {
        return this.eyeOcclusionOnce;
    }

    public boolean isFaceChange() {
        return this.faceChange;
    }

    public boolean isFaceExist() {
        return this.faceExist;
    }

    public boolean isMouthOcclusion() {
        return this.mouthOcclusion;
    }

    public boolean isOutOfRegion() {
        return this.outOfRegion;
    }

    public boolean isStill() {
        return this.still;
    }

    public boolean isTooBig() {
        return this.tooBig;
    }

    public boolean isTooSmall() {
        return this.tooSmall;
    }

    public ABJniPromptMessage promptMessage() {
        return ABJniPromptMessage.values()[this.iPromptMessage];
    }

    public void setActionImgBuffer(byte[][] bArr) {
        this.actionImgBuffer = bArr;
    }

    public void setActionImgHeight(int i10) {
        this.actionImgHeight = i10;
    }

    public void setActionImgWidth(int i10) {
        this.actionImgWidth = i10;
    }

    public void setBackHightlight(float f10) {
        this.backHightlight = f10;
    }

    public void setBigImgBuffer(byte[] bArr) {
        this.bigImgBuffer = bArr;
    }

    public void setBigImgHeight(int i10) {
        this.bigImgHeight = i10;
    }

    public void setBigImgWidth(int i10) {
        this.bigImgWidth = i10;
    }

    public void setBlinkScore(float f10) {
        this.blinkScore = f10;
    }

    public void setBrightDiff(float f10) {
        this.brightDiff = f10;
    }

    public void setBrightness(float f10) {
        this.brightness = f10;
    }

    public void setBrightnessHistory(String str) {
        this.brightnessHistory = str;
    }

    public void setBrightnessScores(String str) {
        this.brightnessScores = str;
    }

    public void setConfirm3D(boolean z10) {
        this.confirm3D = z10;
    }

    public void setCountBlink(int i10) {
        this.countBlink = i10;
    }

    public void setCountFaceDisappear(int i10) {
        this.countFaceDisappear = i10;
    }

    public void setCountMouth(int i10) {
        this.countMouth = i10;
    }

    public void setCountPitch(int i10) {
        this.countPitch = i10;
    }

    public void setCountYaw(int i10) {
        this.countYaw = i10;
    }

    public void setEc(int i10) {
        this.f2423ec = i10;
    }

    public void setEcResult(String str) {
        this.ecResult = str;
    }

    public void setEcpc(int i10) {
        this.ecpc = i10;
    }

    public void setEtcc(int i10) {
        this.etcc = i10;
    }

    public void setEyeOcclusionOnce(boolean z10) {
        this.eyeOcclusionOnce = z10;
    }

    public void setFaceChange(boolean z10) {
        this.faceChange = z10;
    }

    public void setFaceExist(boolean z10) {
        this.faceExist = z10;
    }

    public void setFaceHeight(int i10) {
        this.faceHeight = i10;
    }

    public void setFaceKeyPoint(float[] fArr) {
        this.faceKeyPoint = fArr;
    }

    public void setFaceKeyPointInBigImg(float[] fArr) {
        this.faceKeyPointInBigImg = fArr;
    }

    public void setFaceLeft(int i10) {
        this.faceLeft = i10;
    }

    public void setFaceRectSmooth(Rect rect) {
        this.faceRectSmooth = rect;
    }

    public void setFaceSpeed(float f10) {
        this.faceSpeed = f10;
    }

    public void setFaceTop(int i10) {
        this.faceTop = i10;
    }

    public void setFaceWidth(int i10) {
        this.faceWidth = i10;
    }

    public void setFailLog(String str) {
        this.failLog = str;
    }

    public void setFrameBuffer(byte[] bArr) {
        this.frameBuffer = bArr;
    }

    public void setFrameHeight(int i10) {
        this.frameHeight = i10;
    }

    public void setFrameWidth(int i10) {
        this.frameWidth = i10;
    }

    public void setGestureProgress(float f10) {
        this.gestureProgress = f10;
    }

    public void setGlobalImgBuffer(byte[] bArr) {
        this.globalImgBuffer = bArr;
    }

    public void setGlobalImgHeight(int i10) {
        this.globalImgHeight = i10;
    }

    public void setGlobalImgWidth(int i10) {
        this.globalImgWidth = i10;
    }

    public void setIlluminance(float f10) {
        this.illuminance = f10;
    }

    public void setInitTime(long j10) {
        this.initTime = j10;
    }

    public void setIso(float f10) {
        this.iso = f10;
    }

    public void setLandmarkScore(float f10) {
        this.landmarkScore = f10;
    }

    public void setLeftEyeData(byte[] bArr) {
        this.leftEyeData = bArr;
    }

    public void setLeftEyeDataHeight(int i10) {
        this.leftEyeDataHeight = i10;
    }

    public void setLeftEyeDataWidth(int i10) {
        this.leftEyeDataWidth = i10;
    }

    public void setLocalImgBuffer(byte[] bArr) {
        this.localImgBuffer = bArr;
    }

    public void setLocalImgHeight(int i10) {
        this.localImgHeight = i10;
    }

    public void setLocalImgWidth(int i10) {
        this.localImgWidth = i10;
    }

    public void setMouthOcclusion(boolean z10) {
        this.mouthOcclusion = z10;
    }

    public void setMouthScore(float f10) {
        this.mouthScore = f10;
    }

    public void setMsecChangeDetectType(int i10) {
        this.msecChangeDetectType = i10;
    }

    public void setMsecCurrentTime(int i10) {
        this.msecCurrentTime = i10;
    }

    public void setMsecLeft(int i10) {
        this.msecLeft = i10;
    }

    public void setOutOfRegion(boolean z10) {
        this.outOfRegion = z10;
    }

    public void setPitchScore(float f10) {
        this.pitchScore = f10;
    }

    public void setQuality(float f10) {
        this.quality = f10;
    }

    public void setReflectBrightnessFrames(int i10) {
        this.reflectBrightnessFrames = i10;
    }

    public void setReflectBrightnessResult(int i10) {
        this.reflectBrightnessResult = i10;
    }

    public void setReflectBrightnessScore(float f10) {
        this.reflectBrightnessScore = f10;
    }

    public void setReflectBrightnessScores(float[] fArr) {
        this.reflectBrightnessScores = fArr;
    }

    public void setReflectCmd(int i10) {
        this.reflectCmd = i10;
    }

    public void setReflectDetectType(int i10) {
        this.reflectDetectType = i10;
    }

    public void setReflectEyeFrames(int i10) {
        this.reflectEyeFrames = i10;
    }

    public void setReflectEyeResult(int i10) {
        this.reflectEyeResult = i10;
    }

    public void setReflectEyeValidFrames(int i10) {
        this.reflectEyeValidFrames = i10;
    }

    public void setReflectFrames(int i10) {
        this.reflectFrames = i10;
    }

    public void setReflectLeftEyeResult(int i10) {
        this.reflectLeftEyeResult = i10;
    }

    public void setReflectResult(int i10) {
        this.reflectResult = i10;
    }

    public void setReflectRightEyeResult(int i10) {
        this.reflectRightEyeResult = i10;
    }

    public void setReflectScore(float f10) {
        this.reflectScore = f10;
    }

    public void setRightEyeData(byte[] bArr) {
        this.rightEyeData = bArr;
    }

    public void setRightEyeDataHeight(int i10) {
        this.rightEyeDataHeight = i10;
    }

    public void setRightEyeDataWidth(int i10) {
        this.rightEyeDataWidth = i10;
    }

    public void setStaticQuality(float f10) {
        this.staticQuality = f10;
    }

    public void setStill(boolean z10) {
        this.still = z10;
    }

    public void setTooBig(boolean z10) {
        this.tooBig = z10;
    }

    public void setTooSmall(boolean z10) {
        this.tooSmall = z10;
    }

    public void setYawScore(float f10) {
        this.yawScore = f10;
    }

    public void setiDetectState(int i10) {
        this.iDetectState = i10;
    }

    public void setiDetectType(int i10) {
        this.iDetectType = i10;
    }

    public void setiDetectTypeOld(int i10) {
        this.iDetectTypeOld = i10;
    }

    public void setiFailReason(int i10) {
        this.iFailReason = i10;
    }

    public void setiPromptMessage(int i10) {
        this.iPromptMessage = i10;
    }

    public String toString() {
        return "face exist = " + this.faceExist + "，init time = " + this.initTime + "，current time = " + this.msecCurrentTime + "，detect type = " + ((Object) detectType()) + "，detect state = " + ((Object) detectState()) + "，change detect time = " + this.msecChangeDetectType + "，out of region = " + this.outOfRegion + "，too small = " + this.tooSmall + "，too big = " + this.tooBig + "，still = " + this.still + "，brightness = " + ((int) this.brightness) + " / " + this.brightDiff + " / " + ((int) this.backHightlight) + "，quality = " + ((int) this.quality) + " / " + ((int) this.staticQuality) + "，speed = " + this.faceSpeed + "，gesture = " + this.gestureProgress + "，yaw = " + this.countYaw + " / " + this.yawScore + "，pitch = " + this.countPitch + " / " + this.pitchScore + "，mouth = " + this.countMouth + " / " + this.mouthScore + "，blink = " + this.countBlink + " / " + this.blinkScore + "，disappear = " + this.countFaceDisappear + " / " + this.landmarkScore + "，face change = " + this.faceChange + "，occlusion = " + this.mouthOcclusion + " / " + this.eyeOcclusionOnce + "，confirm 3D = " + this.confirm3D + "，rect = " + ((Object) this.faceRectSmooth) + "，time left = " + this.msecLeft + "，detect type old = " + ((Object) detectTypeOld()) + "，fail reason = " + ((Object) failReason()) + "，fail reason message = " + failReason().getMessage() + "，failLog = " + this.failLog;
    }
}
