package com.effectsar.labcv.effectsdk;

import android.graphics.Rect;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefGeneralObjectInfo {
    private ObjectInfo[] infos;
    private int num;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ObjectInfo {
        private ObjectRect box;
        private int label;

        public ObjectRect getBox() {
            return this.box;
        }

        public int getLabel() {
            return this.label;
        }

        public String toString() {
            return "ObjectInfo{label=" + this.label + ", box=" + ((Object) this.box) + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ObjectRect {
        private int bottom;
        private int left;
        private int right;
        private int top;

        public ObjectRect(int i10, int i11, int i12, int i13) {
            this.left = i10;
            this.top = i11;
            this.right = i12;
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

        public Rect toRect() {
            return new Rect(this.left, this.top, this.right, this.bottom);
        }

        public String toString() {
            return "ObjectRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
    }

    public ObjectInfo[] getInfos() {
        return this.infos;
    }

    public int getNum() {
        return this.num;
    }

    public String toString() {
        return "BefGeneralObjectInfo{num=" + this.num + ", infos=" + Arrays.toString(this.infos) + '}';
    }
}
