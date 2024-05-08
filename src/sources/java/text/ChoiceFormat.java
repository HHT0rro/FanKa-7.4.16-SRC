package java.text;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ChoiceFormat extends NumberFormat {
    private static final long serialVersionUID = 1795184449645032964L;
    private String[] choiceFormats;
    private double[] choiceLimits;

    public void applyPattern(String newPattern) {
        String str = newPattern;
        StringBuffer[] segments = new StringBuffer[2];
        for (int i10 = 0; i10 < segments.length; i10++) {
            segments[i10] = new StringBuffer();
        }
        double[] newChoiceLimits = new double[30];
        String[] newChoiceFormats = new String[30];
        int count = 0;
        int part = 0;
        double startValue = ShadowDrawableWrapper.COS_45;
        double oldStartValue = Double.NaN;
        boolean inQuote = false;
        int i11 = 0;
        while (i11 < newPattern.length()) {
            char ch = str.charAt(i11);
            if (ch == '\'') {
                if (i11 + 1 < newPattern.length() && str.charAt(i11 + 1) == ch) {
                    segments[part].append(ch);
                    i11++;
                } else {
                    inQuote = !inQuote;
                }
            } else if (inQuote) {
                segments[part].append(ch);
            } else if (ch == '<' || ch == '#' || ch == 8804) {
                if (segments[0].length() == 0) {
                    throw new IllegalArgumentException("Each interval must contain a number before a format");
                }
                String tempBuffer = segments[0].toString();
                if (tempBuffer.equals("∞")) {
                    startValue = Double.POSITIVE_INFINITY;
                } else if (tempBuffer.equals("-∞")) {
                    startValue = Double.NEGATIVE_INFINITY;
                } else {
                    startValue = Double.parseDouble(tempBuffer);
                }
                if (ch == '<' && startValue != Double.POSITIVE_INFINITY && startValue != Double.NEGATIVE_INFINITY) {
                    startValue = nextDouble(startValue);
                }
                if (startValue <= oldStartValue) {
                    throw new IllegalArgumentException("Incorrect order of intervals, must be in ascending order");
                }
                segments[0].setLength(0);
                part = 1;
            } else if (ch == '|') {
                if (count == newChoiceLimits.length) {
                    newChoiceLimits = doubleArraySize(newChoiceLimits);
                    newChoiceFormats = doubleArraySize(newChoiceFormats);
                }
                newChoiceLimits[count] = startValue;
                newChoiceFormats[count] = segments[1].toString();
                count++;
                oldStartValue = startValue;
                segments[1].setLength(0);
                part = 0;
            } else {
                segments[part].append(ch);
            }
            i11++;
            str = newPattern;
        }
        if (part == 1) {
            if (count == newChoiceLimits.length) {
                double[] newChoiceLimits2 = doubleArraySize(newChoiceLimits);
                newChoiceFormats = doubleArraySize(newChoiceFormats);
                newChoiceLimits = newChoiceLimits2;
            }
            newChoiceLimits[count] = startValue;
            newChoiceFormats[count] = segments[1].toString();
            count++;
        }
        double[] dArr = new double[count];
        this.choiceLimits = dArr;
        System.arraycopy((Object) newChoiceLimits, 0, (Object) dArr, 0, count);
        String[] strArr = new String[count];
        this.choiceFormats = strArr;
        System.arraycopy(newChoiceFormats, 0, strArr, 0, count);
    }

    public String toPattern() {
        StringBuilder result = new StringBuilder();
        for (int i10 = 0; i10 < this.choiceLimits.length; i10++) {
            if (i10 != 0) {
                result.append('|');
            }
            double less = previousDouble(this.choiceLimits[i10]);
            double tryLessOrEqual = Math.abs(Math.IEEEremainder(this.choiceLimits[i10], 1.0d));
            double tryLess = Math.abs(Math.IEEEremainder(less, 1.0d));
            if (tryLessOrEqual < tryLess) {
                result.append(this.choiceLimits[i10]);
                result.append('#');
            } else {
                double d10 = this.choiceLimits[i10];
                if (d10 == Double.POSITIVE_INFINITY) {
                    result.append("∞");
                } else if (d10 == Double.NEGATIVE_INFINITY) {
                    result.append("-∞");
                } else {
                    result.append(less);
                }
                result.append('<');
            }
            String text = this.choiceFormats[i10];
            boolean needQuote = text.indexOf(60) >= 0 || text.indexOf(35) >= 0 || text.indexOf(8804) >= 0 || text.indexOf(124) >= 0;
            if (needQuote) {
                result.append('\'');
            }
            if (text.indexOf(39) < 0) {
                result.append(text);
            } else {
                for (int j10 = 0; j10 < text.length(); j10++) {
                    char c4 = text.charAt(j10);
                    result.append(c4);
                    if (c4 == '\'') {
                        result.append(c4);
                    }
                }
            }
            if (needQuote) {
                result.append('\'');
            }
        }
        return result.toString();
    }

    public ChoiceFormat(String newPattern) {
        applyPattern(newPattern);
    }

    public ChoiceFormat(double[] limits, String[] formats) {
        setChoices(limits, formats);
    }

    public void setChoices(double[] limits, String[] formats) {
        if (limits.length != formats.length) {
            throw new IllegalArgumentException("Array and limit arrays must be of the same length.");
        }
        this.choiceLimits = Arrays.copyOf(limits, limits.length);
        this.choiceFormats = (String[]) Arrays.copyOf(formats, formats.length);
    }

    public double[] getLimits() {
        double[] dArr = this.choiceLimits;
        double[] newLimits = Arrays.copyOf(dArr, dArr.length);
        return newLimits;
    }

    public Object[] getFormats() {
        String[] strArr = this.choiceFormats;
        Object[] newFormats = Arrays.copyOf(strArr, strArr.length);
        return newFormats;
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition status) {
        return format(number, toAppendTo, status);
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition status) {
        int i10 = 0;
        while (true) {
            double[] dArr = this.choiceLimits;
            if (i10 >= dArr.length || number < dArr[i10]) {
                break;
            }
            i10++;
        }
        int i11 = i10 - 1;
        if (i11 < 0) {
            i11 = 0;
        }
        return toAppendTo.append(this.choiceFormats[i11]);
    }

    @Override // java.text.NumberFormat
    public Number parse(String text, ParsePosition status) {
        int start = status.index;
        int furthest = start;
        double bestNumber = Double.NaN;
        int i10 = 0;
        while (true) {
            String[] strArr = this.choiceFormats;
            if (i10 >= strArr.length) {
                break;
            }
            String tempString = strArr[i10];
            if (text.regionMatches(start, tempString, 0, tempString.length())) {
                status.index = tempString.length() + start;
                double tempNumber = this.choiceLimits[i10];
                if (status.index > furthest) {
                    furthest = status.index;
                    bestNumber = tempNumber;
                    if (furthest == text.length()) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            i10++;
        }
        status.index = furthest;
        if (status.index == start) {
            status.errorIndex = furthest;
        }
        return Double.valueOf(bestNumber);
    }

    public static final double nextDouble(double d10) {
        return Math.nextUp(d10);
    }

    public static final double previousDouble(double d10) {
        return Math.nextDown(d10);
    }

    @Override // java.text.NumberFormat, java.text.Format
    public Object clone() {
        ChoiceFormat other = (ChoiceFormat) super.clone();
        other.choiceLimits = (double[]) this.choiceLimits.clone();
        other.choiceFormats = (String[]) this.choiceFormats.clone();
        return other;
    }

    @Override // java.text.NumberFormat
    public int hashCode() {
        int result = this.choiceLimits.length;
        String[] strArr = this.choiceFormats;
        if (strArr.length > 0) {
            return result ^ strArr[strArr.length - 1].hashCode();
        }
        return result;
    }

    @Override // java.text.NumberFormat
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ChoiceFormat other = (ChoiceFormat) obj;
        if (!Arrays.equals(this.choiceLimits, other.choiceLimits) || !Arrays.equals(this.choiceFormats, other.choiceFormats)) {
            return false;
        }
        return true;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (this.choiceLimits.length != this.choiceFormats.length) {
            throw new InvalidObjectException("limits and format arrays of different length.");
        }
    }

    public static double nextDouble(double d10, boolean positive) {
        return positive ? Math.nextUp(d10) : Math.nextDown(d10);
    }

    private static double[] doubleArraySize(double[] array) {
        int oldSize = array.length;
        double[] newArray = new double[oldSize * 2];
        System.arraycopy((Object) array, 0, (Object) newArray, 0, oldSize);
        return newArray;
    }

    private String[] doubleArraySize(String[] array) {
        int oldSize = array.length;
        String[] newArray = new String[oldSize * 2];
        System.arraycopy(array, 0, newArray, 0, oldSize);
        return newArray;
    }
}
