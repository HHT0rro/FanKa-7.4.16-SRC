package com.huawei.flexiblelayout.css.adapter.type;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSColorList extends CSSColor {
    public static final int STATE_DEFAULT = -1;
    private Map<Integer, CSSMonoColor> colorList = new LinkedHashMap();

    public CSSColorList add(int i10, CSSMonoColor cSSMonoColor) {
        this.colorList.put(Integer.valueOf(i10), cSSMonoColor);
        return this;
    }

    public CSSColor getColor(int i10) {
        return this.colorList.get(Integer.valueOf(i10));
    }

    public ColorStateList toColorStateList() {
        int size = this.colorList.size();
        if (size == 0) {
            return null;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, size, 1);
        int[] iArr2 = new int[size];
        int i10 = 0;
        for (Map.Entry<Integer, CSSMonoColor> entry : this.colorList.entrySet()) {
            if (entry.getKey().intValue() == -1) {
                iArr[i10] = new int[0];
            } else {
                int[] iArr3 = new int[1];
                iArr3[0] = entry.getKey().intValue();
                iArr[i10] = iArr3;
            }
            iArr2[i10] = entry.getValue().getColor();
            i10++;
        }
        return new ColorStateList(iArr, iArr2);
    }

    public StateListDrawable toStateListDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (Map.Entry<Integer, CSSMonoColor> entry : this.colorList.entrySet()) {
            stateListDrawable.addState(new int[]{entry.getKey().intValue()}, new ColorDrawable(entry.getValue().getColor()));
        }
        return stateListDrawable;
    }

    public Map<Integer, CSSMonoColor> getColor() {
        return this.colorList;
    }
}
