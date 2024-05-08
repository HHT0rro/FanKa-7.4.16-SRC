package com.effectsar.labcv.effectsdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefC2Info {
    public BefC2CategoryItem[] items;
    public int n_classes;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefC2CategoryItem {
        public float confidence;

        /* renamed from: id, reason: collision with root package name */
        public int f19161id;
        public int index;
        public boolean satisfied;
        public float thres;

        public float getConfidence() {
            return this.confidence;
        }

        public int getId() {
            return this.f19161id;
        }

        public int getIndex() {
            return this.index;
        }

        public float getThres() {
            return this.thres;
        }

        public boolean isSatisfied() {
            return this.satisfied;
        }

        public String toString() {
            return "BefC2CategoryItem{index=" + this.index + ", id=" + this.f19161id + ", confidence=" + this.confidence + ", thres=" + this.thres + ", satisfied=" + this.satisfied + '}';
        }
    }

    public BefC2CategoryItem[] getItems() {
        return this.items;
    }

    public int getN_classes() {
        return this.n_classes;
    }

    public String toString() {
        return "BefC2Info{n_classes=" + this.n_classes + ", items=" + Arrays.toString(this.items) + '}';
    }

    public BefC2CategoryItem[] topN(int i10) {
        Arrays.sort(this.items, new Comparator<BefC2CategoryItem>() { // from class: com.effectsar.labcv.effectsdk.BefC2Info.1
            @Override // java.util.Comparator
            public int compare(BefC2CategoryItem befC2CategoryItem, BefC2CategoryItem befC2CategoryItem2) {
                float f10 = befC2CategoryItem2.confidence - befC2CategoryItem.confidence;
                if (f10 > 0.0f) {
                    return 1;
                }
                return f10 < 0.0f ? -1 : 0;
            }
        });
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            BefC2CategoryItem[] befC2CategoryItemArr = this.items;
            if (befC2CategoryItemArr[i11].confidence > befC2CategoryItemArr[i11].thres) {
                arrayList.add(befC2CategoryItemArr[i11]);
            }
        }
        return (BefC2CategoryItem[]) arrayList.toArray(new BefC2CategoryItem[0]);
    }
}
