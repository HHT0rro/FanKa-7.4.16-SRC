package com.effectsar.labcv.effectsdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefC1Info {
    public BefC1CategoryItem[] items;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefC1CategoryItem {

        /* renamed from: id, reason: collision with root package name */
        public int f19160id;
        public float prob;
        public boolean satisfied;

        public int getId() {
            return this.f19160id;
        }

        public float getProb() {
            return this.prob;
        }

        public boolean isSatisfied() {
            return this.satisfied;
        }

        public String toString() {
            return "BefC1CategoryItem{id=" + this.f19160id + ", prob=" + this.prob + ", satisfied=" + this.satisfied + '}';
        }
    }

    public BefC1CategoryItem[] getItems() {
        return this.items;
    }

    public void setItems(BefC1CategoryItem[] befC1CategoryItemArr) {
        this.items = befC1CategoryItemArr;
    }

    public String toString() {
        return "BefC1Info{items=" + Arrays.toString(this.items) + '}';
    }

    public BefC1CategoryItem[] topN(int i10) {
        Arrays.sort(this.items, new Comparator<BefC1CategoryItem>() { // from class: com.effectsar.labcv.effectsdk.BefC1Info.1
            @Override // java.util.Comparator
            public int compare(BefC1CategoryItem befC1CategoryItem, BefC1CategoryItem befC1CategoryItem2) {
                float f10 = befC1CategoryItem2.prob - befC1CategoryItem.prob;
                if (f10 > 0.0f) {
                    return 1;
                }
                return f10 < 0.0f ? -1 : 0;
            }
        });
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            BefC1CategoryItem[] befC1CategoryItemArr = this.items;
            if (!befC1CategoryItemArr[i11].satisfied) {
                break;
            }
            arrayList.add(befC1CategoryItemArr[i11]);
        }
        return (BefC1CategoryItem[]) arrayList.toArray(new BefC1CategoryItem[0]);
    }
}
