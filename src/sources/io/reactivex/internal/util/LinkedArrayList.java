package io.reactivex.internal.util;

import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LinkedArrayList {
    public final int capacityHint;
    public Object[] head;
    public int indexInTail;
    public volatile int size;
    public Object[] tail;

    public LinkedArrayList(int i10) {
        this.capacityHint = i10;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            Object[] objArr = new Object[this.capacityHint + 1];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = obj;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i10 = this.indexInTail;
        int i11 = this.capacityHint;
        if (i10 == i11) {
            Object[] objArr2 = new Object[i11 + 1];
            objArr2[0] = obj;
            this.tail[i11] = objArr2;
            this.tail = objArr2;
            this.indexInTail = 1;
            this.size++;
            return;
        }
        this.tail[i10] = obj;
        this.indexInTail = i10 + 1;
        this.size++;
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i10 = this.capacityHint;
        int i11 = this.size;
        ArrayList arrayList = new ArrayList(i11 + 1);
        Object[] head = head();
        int i12 = 0;
        while (true) {
            int i13 = 0;
            while (i12 < i11) {
                arrayList.add(head[i13]);
                i12++;
                i13++;
                if (i13 == i10) {
                    break;
                }
            }
            return arrayList.toString();
            head = head[i10];
        }
    }
}
