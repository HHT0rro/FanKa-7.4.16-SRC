package com.effectsar.labcv.effectsdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefVideoClsInfo {
    public BefVideoClsType[] classes;
    public int n_classes;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefVideoClsType {
        public float confidence;

        /* renamed from: id, reason: collision with root package name */
        public int f19185id;
        public float thres;

        public float getConfidence() {
            return this.confidence;
        }

        public int getId() {
            return this.f19185id;
        }

        public float getThres() {
            return this.thres;
        }

        public String toString() {
            return "BefVideoClsType{id=" + this.f19185id + ", confidence=" + this.confidence + ", thres=" + this.thres + '}';
        }
    }

    public BefVideoClsType[] getClasses() {
        return this.classes;
    }

    public int getN_classes() {
        return this.n_classes;
    }

    public String toString() {
        return "BefVideoClsInfo{n_classes=" + this.n_classes + ", classes=" + Arrays.toString(this.classes) + '}';
    }

    public BefVideoClsType[] topN(int i10) {
        ArrayList arrayList = new ArrayList();
        Arrays.sort(this.classes, new Comparator<BefVideoClsType>() { // from class: com.effectsar.labcv.effectsdk.BefVideoClsInfo.1
            @Override // java.util.Comparator
            public int compare(BefVideoClsType befVideoClsType, BefVideoClsType befVideoClsType2) {
                float f10 = befVideoClsType2.confidence - befVideoClsType.confidence;
                if (f10 > 0.0f) {
                    return 1;
                }
                return f10 < 0.0f ? -1 : 0;
            }
        });
        for (int i11 = 0; i11 < i10; i11++) {
            BefVideoClsType[] befVideoClsTypeArr = this.classes;
            if (i11 >= befVideoClsTypeArr.length) {
                break;
            }
            if (befVideoClsTypeArr[i11].confidence > befVideoClsTypeArr[i11].thres) {
                arrayList.add(befVideoClsTypeArr[i11]);
            }
        }
        return (BefVideoClsType[]) arrayList.toArray(new BefVideoClsType[0]);
    }
}
