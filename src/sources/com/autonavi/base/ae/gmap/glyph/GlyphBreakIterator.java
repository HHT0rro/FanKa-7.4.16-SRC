package com.autonavi.base.ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult = new ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i10) {
        this.mBreakMode = i10;
    }

    public int[] setText(String str) {
        BreakIterator breakIterator = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i10 = this.mBreakMode;
        if (i10 == 1) {
            breakIterator = BreakIterator.getWordInstance();
        } else if (i10 == 2) {
            breakIterator = BreakIterator.getCharacterInstance();
        }
        breakIterator.setText(str);
        int first = breakIterator.first();
        while (true) {
            int i11 = first;
            first = breakIterator.next();
            if (first == -1) {
                break;
            }
            this.breakResult.add(Integer.valueOf(i11));
        }
        this.breakResult.add(Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        Integer[] numArr = new Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr[i12] = numArr[i12].intValue();
        }
        return iArr;
    }
}
