package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public int getOffsetAfter(CharSequence charSequence, int i10) {
        int charCount;
        int length = charSequence.length();
        int i11 = length - 1;
        if (i10 >= i11) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i10);
        int charCount2 = Character.charCount(codePointAt);
        int i12 = i10 + charCount2;
        int i13 = 0;
        if (i12 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i12) == 13) {
                charCount2++;
            }
            return i10 + charCount2;
        }
        if (isRegionalIndicatorSymbol(codePointAt)) {
            if (i12 >= i11 || !isRegionalIndicatorSymbol(Character.codePointAt(charSequence, i12))) {
                return i12;
            }
            int i14 = i10;
            while (i14 > 0 && isRegionalIndicatorSymbol(Character.codePointBefore(charSequence, i10))) {
                i14 -= Character.charCount(Character.codePointBefore(charSequence, i10));
                i13++;
            }
            if (i13 % 2 == 0) {
                charCount2 += 2;
            }
            return i10 + charCount2;
        }
        if (isKeycapBase(codePointAt)) {
            charCount2 += Character.charCount(codePointAt);
        }
        if (codePointAt == 8419) {
            int codePointBefore = Character.codePointBefore(charSequence, i12);
            int charCount3 = i12 + Character.charCount(codePointBefore);
            if (charCount3 < length && isVariationSelector(codePointBefore)) {
                int codePointAt2 = Character.codePointAt(charSequence, charCount3);
                if (isKeycapBase(codePointAt2)) {
                    charCount2 += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                }
            } else if (isKeycapBase(codePointBefore)) {
                charCount2 += Character.charCount(codePointBefore);
            }
            return i10 + charCount2;
        }
        if (isEmoji(codePointAt)) {
            boolean z10 = false;
            int i15 = 0;
            do {
                if (z10) {
                    charCount2 += Character.charCount(codePointAt) + i15 + 1;
                    z10 = false;
                }
                if (isEmojiModifier(codePointAt)) {
                    break;
                }
                if (i12 < length) {
                    codePointAt = Character.codePointAt(charSequence, i12);
                    i12 += Character.charCount(codePointAt);
                    if (codePointAt == 8419) {
                        int codePointBefore2 = Character.codePointBefore(charSequence, i12);
                        int charCount4 = i12 + Character.charCount(codePointBefore2);
                        if (charCount4 < length && isVariationSelector(codePointBefore2)) {
                            int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                            if (isKeycapBase(codePointAt3)) {
                                charCount2 += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                            }
                        } else if (isKeycapBase(codePointBefore2)) {
                            charCount2 += Character.charCount(codePointBefore2);
                        }
                        return i10 + charCount2;
                    }
                    if (isEmojiModifier(codePointAt)) {
                        charCount = Character.charCount(codePointAt);
                    } else if (!isVariationSelector(codePointAt)) {
                        if (codePointAt == 8205) {
                            codePointAt = Character.codePointAt(charSequence, i12);
                            i12 += Character.charCount(codePointAt);
                            if (i12 < length && isVariationSelector(codePointAt)) {
                                codePointAt = Character.codePointAt(charSequence, i12);
                                int charCount5 = Character.charCount(codePointAt);
                                i12 += Character.charCount(codePointAt);
                                i15 = charCount5;
                                z10 = true;
                                if (i12 < length || !z10) {
                                    break;
                                    break;
                                }
                            } else {
                                z10 = true;
                            }
                        }
                    } else {
                        charCount = Character.charCount(codePointAt);
                    }
                    charCount2 += charCount + 0;
                    break;
                }
                i15 = 0;
                if (i12 < length) {
                    break;
                }
            } while (isEmoji(codePointAt));
        }
        return i10 + charCount2;
    }

    public int getOffsetBefore(CharSequence charSequence, int i10) {
        int codePointBefore;
        int charCount;
        int charCount2;
        int i11 = 0;
        int i12 = 1;
        if (i10 <= 1 || (charCount2 = i10 - (charCount = Character.charCount((codePointBefore = Character.codePointBefore(charSequence, i10))))) == 0) {
            return 0;
        }
        if (codePointBefore == 10) {
            if (Character.codePointBefore(charSequence, charCount2) == 13) {
                charCount++;
            }
            return i10 - charCount;
        }
        if (isRegionalIndicatorSymbol(codePointBefore)) {
            int codePointBefore2 = Character.codePointBefore(charSequence, charCount2);
            int charCount3 = charCount2 - Character.charCount(codePointBefore2);
            while (charCount3 > 0 && isRegionalIndicatorSymbol(codePointBefore2)) {
                codePointBefore2 = Character.codePointBefore(charSequence, charCount3);
                charCount3 -= Character.charCount(codePointBefore2);
                i12++;
            }
            if (i12 % 2 == 0) {
                charCount += 2;
            }
            return i10 - charCount;
        }
        if (codePointBefore == 8419) {
            int codePointBefore3 = Character.codePointBefore(charSequence, charCount2);
            int charCount4 = charCount2 - Character.charCount(codePointBefore3);
            if (charCount4 > 0 && isVariationSelector(codePointBefore3)) {
                int codePointBefore4 = Character.codePointBefore(charSequence, charCount4);
                if (isKeycapBase(codePointBefore4)) {
                    charCount += Character.charCount(codePointBefore3) + Character.charCount(codePointBefore4);
                }
            } else if (isKeycapBase(codePointBefore3)) {
                charCount += Character.charCount(codePointBefore3);
            }
            return i10 - charCount;
        }
        if (codePointBefore == 917631) {
            codePointBefore = Character.codePointBefore(charSequence, charCount2);
            int charCount5 = Character.charCount(codePointBefore);
            while (true) {
                charCount2 -= charCount5;
                if (charCount2 <= 0 || !isTagSpecChar(codePointBefore)) {
                    break;
                }
                charCount += Character.charCount(codePointBefore);
                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                charCount5 = Character.charCount(codePointBefore);
            }
            if (!isEmoji(codePointBefore)) {
                return i10 - 2;
            }
            charCount += Character.charCount(codePointBefore);
        }
        if (isVariationSelector(codePointBefore)) {
            codePointBefore = Character.codePointBefore(charSequence, charCount2);
            if (!isEmoji(codePointBefore)) {
                return i10 - charCount;
            }
            charCount += Character.charCount(codePointBefore);
            charCount2 -= charCount;
        }
        if (isEmoji(codePointBefore)) {
            boolean z10 = false;
            int i13 = 0;
            while (true) {
                if (z10) {
                    charCount += Character.charCount(codePointBefore) + i13 + 1;
                    z10 = false;
                }
                if (isEmojiModifier(codePointBefore)) {
                    int codePointBefore5 = Character.codePointBefore(charSequence, charCount2);
                    int charCount6 = charCount2 - Character.charCount(codePointBefore5);
                    if (charCount6 > 0 && isVariationSelector(codePointBefore5)) {
                        codePointBefore5 = Character.codePointBefore(charSequence, charCount6);
                        if (!isEmoji(codePointBefore5)) {
                            return i10 - charCount;
                        }
                        i11 = Character.charCount(codePointBefore5);
                        Character.charCount(codePointBefore5);
                    }
                    if (isEmojiModifierBase(codePointBefore5)) {
                        charCount += i11 + Character.charCount(codePointBefore5);
                    }
                } else {
                    if (charCount2 > 0) {
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        charCount2 -= Character.charCount(codePointBefore);
                        if (codePointBefore == 8205) {
                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                            charCount2 -= Character.charCount(codePointBefore);
                            if (charCount2 > 0 && isVariationSelector(codePointBefore)) {
                                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                int charCount7 = Character.charCount(codePointBefore);
                                charCount2 -= Character.charCount(codePointBefore);
                                i13 = charCount7;
                                z10 = true;
                                if (charCount2 != 0 || !z10 || !isEmoji(codePointBefore)) {
                                    break;
                                    break;
                                }
                            } else {
                                z10 = true;
                            }
                        }
                    }
                    i13 = 0;
                    if (charCount2 != 0) {
                        break;
                    }
                }
            }
        }
        return i10 - charCount;
    }

    public boolean isEmoji(int i10) {
        return this.flutterJNI.isCodePointEmoji(i10);
    }

    public boolean isEmojiModifier(int i10) {
        return this.flutterJNI.isCodePointEmojiModifier(i10);
    }

    public boolean isEmojiModifierBase(int i10) {
        return this.flutterJNI.isCodePointEmojiModifierBase(i10);
    }

    public boolean isKeycapBase(int i10) {
        return (48 <= i10 && i10 <= 57) || i10 == 35 || i10 == 42;
    }

    public boolean isRegionalIndicatorSymbol(int i10) {
        return this.flutterJNI.isCodePointRegionalIndicator(i10);
    }

    public boolean isTagSpecChar(int i10) {
        return 917536 <= i10 && i10 <= 917630;
    }

    public boolean isVariationSelector(int i10) {
        return this.flutterJNI.isCodePointVariantSelector(i10);
    }
}
