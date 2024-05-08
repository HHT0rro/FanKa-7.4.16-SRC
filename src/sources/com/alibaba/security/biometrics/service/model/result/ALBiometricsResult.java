package com.alibaba.security.biometrics.service.model.result;

import com.alibaba.security.biometrics.service.build.b;
import com.kuaishou.weapon.p0.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALBiometricsResult implements Serializable {
    public static final int DIGETS_TYPE_HMACMD5 = 1;
    public static final int DIGETS_TYPE_HMACSHA1 = 2;
    public static final int DIGETS_TYPE_MD5 = 0;
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    private static final String TAG = "ALBiometricsResult";
    public static final int UNDEFINED = -1;
    private static final long serialVersionUID = 1;
    public String aid;
    public String bh;
    public long bt;
    public DazzleCollectDataConfig dazzleDataConfigs;
    private String dazzleVideoOssUrl;
    public String dazzleVideoPath;
    public String did;
    public String displayImagePath;
    public long et;
    public HashMap<String, String> ex;
    public ALFaceDetectResult faceDetectResult;
    public String failedVideoPath;
    public ABImageResult gi;
    public String isid;

    /* renamed from: k, reason: collision with root package name */
    public String f2895k;
    public ABImageResult li;
    public String lid;

    /* renamed from: m, reason: collision with root package name */
    public String f2896m;
    public ABImageResult oi;
    public String os;
    public ABImageResult qi;
    public int recapAvgTime;
    public int recapFrames;
    public String recapLog;
    public float[] recapScore;
    public String reflectImgDigest;
    public String reflectImgPath;
    public String resultData;
    public String sid;
    public String successfulVideoPath;
    public String uid;
    private String videoHash;
    public int reflectImgDigestType = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f2897r = 0;

    /* renamed from: v, reason: collision with root package name */
    public String f2898v = "1.0";
    public int rt = 0;
    public ArrayList<ABImageResult> continueImages = new ArrayList<>();
    public List<ABActionResult> as = new ArrayList();
    public float iso = -1.0f;
    public float illuminance = -1.0f;
    public int recapResult = -1;
    public int recognizeResult = -1;
    public float recognizeResultScore = -1.0f;
    public ABActionResult adjustAction = new ABActionResult();

    public void addActionResult(ABActionResult aBActionResult) {
        this.as.add(aBActionResult);
    }

    public void addDazzleCollectConfigs(List<? extends DazzleDataConfigItem> list) {
        if (this.dazzleDataConfigs == null) {
            this.dazzleDataConfigs = new DazzleCollectDataConfig();
        }
        if (list != null) {
            Iterator<? extends DazzleDataConfigItem> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                this.dazzleDataConfigs.addUIConfig(iterator2.next());
            }
        }
    }

    public ABActionResult getAdjustAction() {
        return this.adjustAction;
    }

    public String getAid() {
        return this.aid;
    }

    public List<ABActionResult> getAs() {
        return this.as;
    }

    public String getBgDetectResult() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.adjustAction.getEcResult());
        for (ABActionResult aBActionResult : this.as) {
            stringBuffer.append(';');
            stringBuffer.append(aBActionResult.getEcResult());
        }
        return stringBuffer.toString();
    }

    public String getBh() {
        return this.bh;
    }

    public long getBt() {
        return this.bt;
    }

    public ArrayList<ABImageResult> getContinueImages() {
        return this.continueImages;
    }

    public DazzleCollectDataConfig getDazzleDataConfigs() {
        return this.dazzleDataConfigs;
    }

    public String getDazzleVideoOssUrl() {
        return this.dazzleVideoOssUrl;
    }

    public String getDazzleVideoPath() {
        return this.dazzleVideoPath;
    }

    public String getDid() {
        return this.did;
    }

    public String getDisplayImagePath() {
        return this.displayImagePath;
    }

    public long getEt() {
        return this.et;
    }

    public HashMap<String, String> getEx() {
        return this.ex;
    }

    public ALFaceDetectResult getFaceResult() {
        if (this.faceDetectResult == null) {
            this.faceDetectResult = new ALFaceDetectResult();
        }
        return this.faceDetectResult;
    }

    public ABImageResult getGi() {
        return this.gi;
    }

    public float getIlluminance() {
        return this.illuminance;
    }

    public float getIso() {
        return this.iso;
    }

    public String getK() {
        return this.f2895k;
    }

    public ABImageResult getLi() {
        return this.li;
    }

    public String getLid() {
        return this.lid;
    }

    public String getM() {
        return this.f2896m;
    }

    public ABImageResult getOi() {
        return this.oi;
    }

    public String getOs() {
        return this.os;
    }

    public ABImageResult getQi() {
        return this.qi;
    }

    public int getR() {
        return this.f2897r;
    }

    public int getRecapAvgTime() {
        return this.recapAvgTime;
    }

    public int getRecapFrames() {
        return this.recapFrames;
    }

    public String getRecapLog() {
        return this.recapLog;
    }

    public int getRecapResult() {
        return this.recapResult;
    }

    public float getRecapScore() {
        float[] fArr = this.recapScore;
        if (fArr == null || fArr.length < 0) {
            return 0.0f;
        }
        return fArr[0];
    }

    public int getRecognizeResult() {
        return this.recognizeResult;
    }

    public float getRecognizeResultScore() {
        return this.recognizeResultScore;
    }

    public String getReflectImgDigest() {
        return this.reflectImgDigest;
    }

    public int getReflectImgDigestType() {
        return this.reflectImgDigestType;
    }

    public String getReflectImgPath() {
        return this.reflectImgPath;
    }

    public String getResultData() {
        return this.resultData;
    }

    public int getRt() {
        return this.rt;
    }

    public String getSid() {
        return this.sid;
    }

    public String getUid() {
        return this.uid;
    }

    public String getV() {
        return this.f2898v;
    }

    public String getVideoF() {
        return this.failedVideoPath;
    }

    public String getVideoHash() {
        return this.videoHash;
    }

    public String getVideoS() {
        return this.successfulVideoPath;
    }

    public void increaseRetryTime() {
        this.rt++;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setAs(List<ABActionResult> list) {
        this.as = list;
    }

    public void setBh(String str) {
        this.bh = str;
    }

    public void setBt(long j10) {
        this.bt = j10;
    }

    public void setContinueImages(ArrayList<ABImageResult> arrayList) {
        this.continueImages = arrayList;
    }

    public void setDazzleCollectRotate(int i10) {
        if (this.dazzleDataConfigs == null) {
            this.dazzleDataConfigs = new DazzleCollectDataConfig();
        }
        this.dazzleDataConfigs.setRotate(i10);
    }

    public void setDazzleVideoOssUrl(String str) {
        this.dazzleVideoOssUrl = str;
    }

    public void setDazzleVideoPath(String str) {
        this.dazzleVideoPath = str;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public ALBiometricsResult setDisplayImagePath(String str) {
        this.displayImagePath = str;
        return this;
    }

    public void setEt(long j10) {
        this.et = j10;
    }

    public void setEx(HashMap<String, String> hashMap) {
        this.ex = hashMap;
    }

    public void setFaceResult(ALFaceDetectResult aLFaceDetectResult) {
        this.faceDetectResult = aLFaceDetectResult;
    }

    public ALBiometricsResult setGi(ABImageResult aBImageResult) {
        this.gi = aBImageResult;
        return this;
    }

    public ALBiometricsResult setIlluminance(float f10) {
        this.illuminance = f10;
        return this;
    }

    public ALBiometricsResult setIso(float f10) {
        this.iso = f10;
        return this;
    }

    public void setK(String str) {
        this.f2895k = str;
    }

    public ALBiometricsResult setLi(ABImageResult aBImageResult) {
        this.li = aBImageResult;
        return this;
    }

    public ALBiometricsResult setLid(String str) {
        this.lid = str;
        return this;
    }

    public void setM(String str) {
        this.f2896m = str;
    }

    public ALBiometricsResult setOi(ABImageResult aBImageResult) {
        this.oi = aBImageResult;
        return this;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setQi(ABImageResult aBImageResult) {
        this.qi = aBImageResult;
    }

    public void setR(int i10) {
        this.f2897r = i10;
    }

    public ALBiometricsResult setRecapAvgTime(int i10) {
        this.recapAvgTime = i10;
        return this;
    }

    public ALBiometricsResult setRecapFrames(int i10) {
        this.recapFrames = i10;
        return this;
    }

    public ALBiometricsResult setRecapLog(String str) {
        this.recapLog = str;
        return this;
    }

    public ALBiometricsResult setRecapResult(int i10) {
        this.recapResult = i10;
        return this;
    }

    public ALBiometricsResult setRecapScore(float[] fArr) {
        this.recapScore = fArr;
        return this;
    }

    public void setRecognizeResult(int i10) {
        this.recognizeResult = i10;
    }

    public void setRecognizeResultScore(float f10) {
        this.recognizeResultScore = f10;
    }

    public void setReflectImgDigest(String str) {
        this.reflectImgDigest = str;
    }

    public void setReflectImgDigestType(int i10) {
        this.reflectImgDigestType = i10;
    }

    public void setReflectImgPath(String str) {
        this.reflectImgPath = str;
    }

    public void setResultData(String str) {
        this.resultData = str;
    }

    public void setRt(int i10) {
        this.rt = i10;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setV(String str) {
        this.f2898v = str;
    }

    public void setVideoF(String str) {
        this.failedVideoPath = str;
    }

    public void setVideoHash(String str) {
        this.videoHash = str;
    }

    public void setVideoS(String str) {
        this.successfulVideoPath = str;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", 2);
            jSONObject.put("os", "android");
            jSONObject.put(t.f36226k, this.f2897r);
            jSONObject.put("bt", this.bt);
            jSONObject.put("et", this.et);
            jSONObject.put("rt", this.rt);
            jSONObject.put(b.bq, this.illuminance);
            jSONObject.put("recapResult", this.recapResult);
            float[] fArr = this.recapScore;
            int i10 = 0;
            jSONObject.put("recapScore", (fArr == null || fArr.length <= 0) ? "-1" : Float.valueOf(fArr[0]));
            Object obj = this.successfulVideoPath;
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject.put("videoS", obj);
            Object obj2 = this.failedVideoPath;
            if (obj2 == null) {
                obj2 = JSONObject.NULL;
            }
            jSONObject.put("videoF", obj2);
            ABImageResult aBImageResult = this.qi;
            if (aBImageResult != null && aBImageResult.landmarks != null) {
                StringBuffer stringBuffer = new StringBuffer();
                int i11 = 0;
                while (true) {
                    float[] fArr2 = this.qi.landmarks;
                    if (i11 >= fArr2.length) {
                        break;
                    }
                    stringBuffer.append(fArr2[i11]);
                    if (i11 < this.qi.landmarks.length - 1) {
                        stringBuffer.append(",");
                    }
                    i11++;
                }
                jSONObject.put("landmarks", stringBuffer.toString());
            }
            ABImageResult aBImageResult2 = this.qi;
            if (aBImageResult2 != null && aBImageResult2.fr != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                while (true) {
                    int[] iArr = this.qi.fr;
                    if (i10 >= iArr.length) {
                        break;
                    }
                    stringBuffer2.append(iArr[i10]);
                    if (i10 < this.qi.fr.length - 1) {
                        stringBuffer2.append(",");
                    }
                    i10++;
                }
                jSONObject.put("faceRect", stringBuffer2.toString());
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String toString() {
        return "ALBiometricsResult{r=" + this.f2897r + ", v='" + this.f2898v + "', bt=" + this.bt + ", et=" + this.et + ", aid='" + this.aid + "', did='" + this.did + "', uid='" + this.uid + "', sid='" + this.sid + "', isid='" + this.isid + "', rt=" + this.rt + ", oi=" + ((Object) this.oi) + ", qi=" + ((Object) this.qi) + ", gi=" + ((Object) this.gi) + ", li=" + ((Object) this.li) + ", k='" + this.f2895k + "', os='" + this.os + "', m='" + this.f2896m + "', as=" + ((Object) this.as) + ", reflectImgPath='" + this.reflectImgPath + "', reflectImgDigest='" + this.reflectImgDigest + "', displayImagePath='" + this.displayImagePath + "', resultData='" + this.resultData + "', iso=" + this.iso + ", illuminance=" + this.illuminance + ", lid='" + this.lid + "', recapResult=" + this.recapResult + ", recapScore=" + Arrays.toString(this.recapScore) + ", recapFrames=" + this.recapFrames + ", recapAvgTime=" + this.recapAvgTime + ", recapLog='" + this.recapLog + "', recognizeResult=" + this.recognizeResult + ", recognizeResultScore=" + this.recognizeResultScore + ", reflectImgDigestType=" + this.reflectImgDigestType + ", videoS=" + this.successfulVideoPath + ", videoF=" + this.failedVideoPath + ", ex=" + ((Object) this.ex) + '}';
    }
}
