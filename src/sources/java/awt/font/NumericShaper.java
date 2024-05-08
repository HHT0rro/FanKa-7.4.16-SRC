package java.awt.font;

import android.view.SurfaceControl;
import android.view.WindowManager;
import android.window.TransitionInfo;
import com.alibaba.wireless.security.SecExceptionCode;
import com.amap.api.services.core.AMapException;
import com.android.internal.logging.nano.MetricsProto;
import com.qq.e.comm.constants.ErrorCode;
import com.tencent.connect.common.Constants;
import com.tencent.turingface.sdk.mfa.ITuringIoTFeatureMap;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Set;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class NumericShaper implements Serializable {
    public static final int ALL_RANGES = 524287;
    public static final int ARABIC = 2;
    private static final int ARABIC_KEY = 1;
    public static final int BENGALI = 16;
    private static final int BENGALI_KEY = 4;
    private static final int BSEARCH_THRESHOLD = 3;
    private static final int CONTEXTUAL_MASK = Integer.MIN_VALUE;
    public static final int DEVANAGARI = 8;
    private static final int DEVANAGARI_KEY = 3;
    public static final int EASTERN_ARABIC = 4;
    private static final int EASTERN_ARABIC_KEY = 2;
    public static final int ETHIOPIC = 65536;
    private static final int ETHIOPIC_KEY = 16;
    public static final int EUROPEAN = 1;
    private static final int EUROPEAN_KEY = 0;
    public static final int GUJARATI = 64;
    private static final int GUJARATI_KEY = 6;
    public static final int GURMUKHI = 32;
    private static final int GURMUKHI_KEY = 5;
    public static final int KANNADA = 1024;
    private static final int KANNADA_KEY = 10;
    public static final int KHMER = 131072;
    private static final int KHMER_KEY = 17;
    public static final int LAO = 8192;
    private static final int LAO_KEY = 13;
    public static final int MALAYALAM = 2048;
    private static final int MALAYALAM_KEY = 11;
    public static final int MONGOLIAN = 262144;
    private static final int MONGOLIAN_KEY = 18;
    public static final int MYANMAR = 32768;
    private static final int MYANMAR_KEY = 15;
    private static final int NUM_KEYS = 19;
    public static final int ORIYA = 128;
    private static final int ORIYA_KEY = 7;
    public static final int TAMIL = 256;
    private static final int TAMIL_KEY = 8;
    public static final int TELUGU = 512;
    private static final int TELUGU_KEY = 9;
    public static final int THAI = 4096;
    private static final int THAI_KEY = 12;
    public static final int TIBETAN = 16384;
    private static final int TIBETAN_KEY = 14;
    private static int ctCacheLimit = 0;
    private static final long serialVersionUID = -8022764705923730308L;
    private int key;
    private int mask;
    private transient Range[] rangeArray;
    private transient Set<Range> rangeSet;
    private Range shapingRange;
    private static final char[] bases = {0, 1584, 1728, 2358, 2486, 2614, 2742, 2870, 2998, 3126, 3254, 3382, 3616, 3744, 3824, 4112, 4920, 6064, 6112};
    private static final char[] contexts = {0, 768, 1536, 1920, 1536, 1920, 2304, 2432, 2432, 2560, 2560, 2688, 2688, 2816, 2816, 2944, 2944, 3072, 3072, 3200, 3200, 3328, 3328, 3456, 3584, 3712, 3712, 3840, 3840, 4096, 4096, 4224, 4608, 4992, 6016, 6144, 6144, 6400, 65535};
    private static int ctCache = 0;
    private static int[] strongTable = {0, 65, 91, 97, 123, 170, 171, 181, 182, 186, 187, 192, 215, 216, 247, 248, MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_PROCESS_OUTGOING_CALLS, 699, 706, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, MetricsProto.MetricsEvent.ACTION_PERMISSION_REQUEST_RECEIVE_MMS, MetricsProto.MetricsEvent.ACTION_PERMISSION_REQUEST_READ_PHONE_NUMBERS, 741, MetricsProto.MetricsEvent.SETTINGS_LANGUAGE_CATEGORY, MetricsProto.MetricsEvent.SETTINGS_GESTURE_SWIPE_TO_NOTIFICATION, MetricsProto.MetricsEvent.FIELD_SETTINGS_SEARCH_INLINE_RESULT_VALUE, MetricsProto.MetricsEvent.ACTION_APPOP_GRANT_ACCESS_NOTIFICATIONS, MetricsProto.MetricsEvent.ACTION_APPOP_REVOKE_ACCESS_NOTIFICATIONS, MetricsProto.MetricsEvent.ACTION_APPOP_REVOKE_WRITE_SETTINGS, 902, 903, 904, 1014, 1015, 1155, 1162, MetricsProto.MetricsEvent.FIELD_BATTERY_LEVEL_START, 1470, 1471, 1472, 1473, 1475, 1476, 1478, 1479, 1488, 1536, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_SHORT_COMPONENT_NAME, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_PROCESS_NAME, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_IS_NO_DISPLAY, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_MILLIS_SINCE_LAST_VISIBLE, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_RESULT_TO_PKG_NAME, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_RESULT_TO_SHORT_COMPONENT_NAME, MetricsProto.MetricsEvent.FIELD_EMERGENCY_DIALER_PHONE_NUMBER_TYPE, 1611, MetricsProto.MetricsEvent.ACTION_SET_NEW_PASSWORD, MetricsProto.MetricsEvent.NOTIFICATION_SMART_REPLY_MODIFIED_BEFORE_SENDING, MetricsProto.MetricsEvent.FIELD_SHARESHEET_MIMETYPE, MetricsProto.MetricsEvent.SETTINGS_AWARE_DISPLAY, 1765, 1767, 1774, 1776, 1786, AMapException.CODE_AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION, AMapException.CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION, 1840, 1869, 1958, 1969, WindowManager.LayoutParams.TYPE_MAGNIFICATION_OVERLAY, 2036, 2038, 2042, 2070, 2074, 2075, 2084, 2085, 2088, 2089, 2096, 2137, 2142, 2276, 2307, 2362, 2363, 2364, 2365, 2369, 2377, 2381, 2382, 2385, 2392, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_NO_APPKEY, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_MINIWUA_FAILED, 2433, 2434, 2492, 2493, 2497, 2503, 2509, 2510, 2530, 2534, 2546, 2548, 2555, 2563, 2620, 2622, 2625, 2649, 2672, 2674, 2677, 2691, 2748, 2749, 2753, 2761, 2765, 2768, 2786, 2790, 2801, 2818, 2876, 2877, 2879, 2880, 2881, 2887, 2893, 2903, 2914, 2918, 2946, 2947, ITuringIoTFeatureMap.RIOT_CAMERA_SERIAL, ITuringIoTFeatureMap.RIOT_CPU_ID, 3021, 3024, 3059, 3073, 3134, 3137, 3142, 3160, 3170, 3174, 3192, 3199, 3260, 3261, 3276, 3285, 3298, 3302, 3393, 3398, 3405, 3406, 3426, 3430, 3530, 3535, 3538, 3544, 3633, 3634, 3636, 3648, 3655, 3663, 3761, 3762, 3764, 3773, 3784, 3792, 3864, 3866, 3893, 3894, 3895, 3896, 3897, 3902, 3953, 3967, Utf8.MASK_2BYTES, 3973, 3974, 3976, 3981, 4030, 4038, 4039, 4141, 4145, 4146, 4152, 4153, 4155, 4157, 4159, 4184, 4186, 4190, 4193, 4209, 4213, 4226, 4227, 4229, 4231, 4237, 4238, 4253, 4254, 4957, 4960, 5008, ErrorCode.METHOD_CALL_ERROR, 5120, 5121, 5760, 5761, 5787, 5792, 5906, 5920, 5938, 5941, 5970, 5984, 6002, 6016, 6068, 6070, 6071, 6078, 6086, 6087, 6089, 6100, 6107, 6108, 6109, 6112, 6128, 6160, 6313, 6314, 6432, 6435, 6439, 6441, 6450, 6451, 6457, 6470, 6622, Constants.CODE_REQUEST_MAX, 6679, 6681, 6742, 6743, 6744, 6753, 6754, 6755, 6757, 6765, 6771, 6784, 6912, 6916, 6964, 6965, 6966, 6971, 6972, 6973, 6978, 6979, 7019, 7028, 7040, 7042, 7074, 7078, 7080, 7082, 7083, 7084, 7142, 7143, 7144, 7146, 7149, 7150, 7151, 7154, 7212, 7220, 7222, 7227, 7376, 7379, 7380, 7393, 7394, 7401, 7405, 7406, 7412, 7413, 7616, 7680, 8125, 8126, 8127, 8130, 8141, 8144, 8157, 8160, 8173, 8178, 8189, 8206, 8208, 8305, 8308, 8319, 8320, 8336, 8352, 8450, 8451, 8455, 8456, 8458, 8468, 8469, 8470, 8473, 8478, 8484, 8485, 8486, 8487, 8488, 8489, 8490, 8494, 8495, 8506, 8508, 8512, 8517, 8522, 8526, 8528, 8544, 8585, 9014, 9083, 9109, 9110, 9372, 9450, 9900, 9901, 10240, 10496, 11264, 11493, 11499, 11503, 11506, 11513, 11520, 11647, 11648, 11744, 12293, 12296, 12321, 12330, 12337, 12342, 12344, 12349, 12353, 12441, 12445, 12448, 12449, 12539, 12540, 12736, 12784, 12829, 12832, 12880, 12896, 12924, 12927, 12977, 12992, 13004, 13008, 13175, 13179, 13278, 13280, 13311, 13312, 19904, 19968, 42128, 42192, 42509, 42512, 42607, 42624, 42655, 42656, 42736, 42738, 42752, 42786, 42888, 42889, 43010, 43011, 43014, 43015, 43019, 43020, 43045, 43047, 43048, 43056, 43064, 43072, 43124, 43136, 43204, 43214, 43232, 43250, 43302, 43310, 43335, 43346, 43392, 43395, 43443, 43444, 43446, 43450, 43452, 43453, 43561, 43567, 43569, 43571, 43573, 43584, 43587, 43588, 43596, 43597, 43696, 43697, 43698, 43701, 43703, 43705, 43710, 43712, 43713, 43714, 43756, 43758, 43766, 43777, 44005, 44006, 44008, 44009, 44013, 44016, 64286, 64287, 64297, 64298, 64830, 64848, 65021, 65136, 65279, 65313, 65339, 65345, 65371, 65382, 65504, 65536, 65793, TransitionInfo.FLAGS_IS_NON_APP_WINDOW, 65856, 66000, 66045, 66176, 67871, 67872, 68097, 68112, 68152, 68160, 68409, 68416, 69216, 69632, 69633, 69634, 69688, 69703, 69714, 69734, 69760, 69762, 69811, 69815, 69817, 69819, 69888, 69891, 69927, 69932, 69933, 69942, 70016, 70018, 70070, 70079, 71339, 71340, 71341, 71342, 71344, 71350, 71351, 71360, 94095, 94099, 119143, 119146, 119155, 119171, 119173, 119180, 119210, 119214, 119296, 119648, 120539, 120540, 120597, 120598, 120655, 120656, 120713, 120714, 120771, 120772, 120782, 126464, 126704, 127248, 127338, 127344, 127744, 128140, 128141, 128292, 128293, 131072, 917505, SurfaceControl.FX_SURFACE_MASK, 1114110, Character.MAX_CODE_POINT};
    private volatile transient Range currentRange = Range.EUROPEAN;
    private volatile transient int stCache = 0;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Range {
        private final int base;
        private final int end;
        private final int start;
        public static final Range EUROPEAN = new Range("EUROPEAN", 0, 48, 0, 768);
        public static final Range ARABIC = new Range("ARABIC", 1, MetricsProto.MetricsEvent.SETTINGS_AWARE, 1536, 1920);
        public static final Range EASTERN_ARABIC = new Range("EASTERN_ARABIC", 2, 1776, 1536, 1920);
        public static final Range DEVANAGARI = new Range("DEVANAGARI", 3, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_UMT_FAILED, 2304, 2432);
        public static final Range BENGALI = new Range("BENGALI", 4, 2534, 2432, 2560);
        public static final Range GURMUKHI = new Range("GURMUKHI", 5, 2662, 2560, 2688);
        public static final Range GUJARATI = new Range("GUJARATI", 6, 2790, 2816, 2944);
        public static final Range ORIYA = new Range("ORIYA", 7, 2918, 2816, 2944);
        public static final Range TAMIL = new Range("TAMIL", 8, 3046, 2944, 3072);
        public static final Range TELUGU = new Range("TELUGU", 9, 3174, 3072, 3200);
        public static final Range KANNADA = new Range("KANNADA", 10, 3302, 3200, 3328);
        public static final Range MALAYALAM = new Range("MALAYALAM", 11, 3430, 3328, 3456);
        public static final Range THAI = new Range("THAI", 12, 3664, 3584, 3712);
        public static final Range LAO = new Range("LAO", 13, 3792, 3712, 3840);
        public static final Range TIBETAN = new Range("TIBETAN", 14, 3872, 3840, 4096);
        public static final Range MYANMAR = new Range("MYANMAR", 15, 4160, 4096, 4224);
        public static final Range ETHIOPIC = new AnonymousClass1("ETHIOPIC", 16, 4969, 4608, 4992);
        public static final Range KHMER = new Range("KHMER", 17, 6112, 6016, 6144);
        public static final Range MONGOLIAN = new Range("MONGOLIAN", 18, 6160, 6144, 6400);
        public static final Range NKO = new Range("NKO", 19, 1984, 1984, 2048);
        public static final Range MYANMAR_SHAN = new Range("MYANMAR_SHAN", 20, 4240, 4096, 4256);
        public static final Range LIMBU = new Range("LIMBU", 21, 6470, 6400, 6480);
        public static final Range NEW_TAI_LUE = new Range("NEW_TAI_LUE", 22, 6608, 6528, 6624);
        public static final Range BALINESE = new Range("BALINESE", 23, 6992, 6912, 7040);
        public static final Range SUNDANESE = new Range("SUNDANESE", 24, 7088, 7040, 7104);
        public static final Range LEPCHA = new Range("LEPCHA", 25, 7232, 7168, 7248);
        public static final Range OL_CHIKI = new Range("OL_CHIKI", 26, 7248, 7248, 7296);
        public static final Range VAI = new Range("VAI", 27, 42528, 42240, 42560);
        public static final Range SAURASHTRA = new Range("SAURASHTRA", 28, 43216, 43136, 43232);
        public static final Range KAYAH_LI = new Range("KAYAH_LI", 29, 43264, 43264, 43312);
        public static final Range CHAM = new Range("CHAM", 30, 43600, 43520, 43616);
        public static final Range TAI_THAM_HORA = new Range("TAI_THAM_HORA", 31, 6784, 6688, 6832);
        public static final Range TAI_THAM_THAM = new Range("TAI_THAM_THAM", 32, 6800, 6688, 6832);
        public static final Range JAVANESE = new Range("JAVANESE", 33, 43472, 43392, 43488);
        public static final Range MEETEI_MAYEK = new Range("MEETEI_MAYEK", 34, 44016, 43968, 44032);
        private static final /* synthetic */ Range[] $VALUES = $values();

        private static /* synthetic */ Range[] $values() {
            return new Range[]{EUROPEAN, ARABIC, EASTERN_ARABIC, DEVANAGARI, BENGALI, GURMUKHI, GUJARATI, ORIYA, TAMIL, TELUGU, KANNADA, MALAYALAM, THAI, LAO, TIBETAN, MYANMAR, ETHIOPIC, KHMER, MONGOLIAN, NKO, MYANMAR_SHAN, LIMBU, NEW_TAI_LUE, BALINESE, SUNDANESE, LEPCHA, OL_CHIKI, VAI, SAURASHTRA, KAYAH_LI, CHAM, TAI_THAM_HORA, TAI_THAM_THAM, JAVANESE, MEETEI_MAYEK};
        }

        public static Range valueOf(String name) {
            return (Range) Enum.valueOf(Range.class, name);
        }

        public static Range[] values() {
            return (Range[]) $VALUES.clone();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.awt.font.NumericShaper$Range$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass1 extends Range {
            private AnonymousClass1(String str, int i10, int base, int start, int end) {
                super(str, i10, base, start, end);
            }

            @Override // java.awt.font.NumericShaper.Range
            char getNumericBase() {
                return (char) 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int toRangeIndex(Range script) {
            int index = script.ordinal();
            if (index < 19) {
                return index;
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Range indexToRange(int index) {
            if (index < 19) {
                return values()[index];
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int toRangeMask(Set<Range> ranges) {
            int m10 = 0;
            for (Range range : ranges) {
                int index = range.ordinal();
                if (index < 19) {
                    m10 |= 1 << index;
                }
            }
            return m10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Set<Range> maskToRangeSet(int mask) {
            Set<Range> set = EnumSet.noneOf(Range.class);
            Range[] a10 = values();
            for (int i10 = 0; i10 < 19; i10++) {
                if (((1 << i10) & mask) != 0) {
                    set.add(a10[i10]);
                }
            }
            return set;
        }

        private Range(String str, int i10, int base, int start, int end) {
            this.base = base - (getNumericBase() + '0');
            this.start = start;
            this.end = end;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getDigitBase() {
            return this.base;
        }

        char getNumericBase() {
            return (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean inRange(int c4) {
            return this.start <= c4 && c4 < this.end;
        }
    }

    static {
        ctCacheLimit = r0.length - 2;
    }

    private static int getContextKey(char c4) {
        char[] cArr = contexts;
        int i10 = ctCache;
        if (c4 < cArr[i10]) {
            while (true) {
                int i11 = ctCache;
                if (i11 <= 0 || c4 >= contexts[i11]) {
                    break;
                }
                ctCache = i11 - 1;
            }
        } else if (c4 >= cArr[i10 + 1]) {
            while (true) {
                int i12 = ctCache;
                if (i12 >= ctCacheLimit || c4 < contexts[i12 + 1]) {
                    break;
                }
                ctCache = i12 + 1;
            }
        }
        int i13 = ctCache;
        if ((i13 & 1) == 0) {
            return i13 / 2;
        }
        return 0;
    }

    private Range rangeForCodePoint(int codepoint) {
        if (this.currentRange.inRange(codepoint)) {
            return this.currentRange;
        }
        Range[] ranges = this.rangeArray;
        if (ranges.length > 3) {
            int lo = 0;
            int hi = ranges.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                Range range = ranges[mid];
                if (codepoint < range.start) {
                    hi = mid - 1;
                } else if (codepoint >= range.end) {
                    lo = mid + 1;
                } else {
                    this.currentRange = range;
                    return range;
                }
            }
        } else {
            for (int i10 = 0; i10 < ranges.length; i10++) {
                if (ranges[i10].inRange(codepoint)) {
                    return ranges[i10];
                }
            }
        }
        return Range.EUROPEAN;
    }

    private boolean isStrongDirectional(char c4) {
        int cachedIndex = this.stCache;
        int[] iArr = strongTable;
        if (c4 < iArr[cachedIndex]) {
            cachedIndex = search(c4, iArr, 0, cachedIndex);
        } else if (c4 >= iArr[cachedIndex + 1]) {
            cachedIndex = search(c4, iArr, cachedIndex + 1, (iArr.length - cachedIndex) - 1);
        }
        boolean val = (cachedIndex & 1) == 1;
        this.stCache = cachedIndex;
        return val;
    }

    private static int getKeyFromMask(int mask) {
        int key = 0;
        while (key < 19 && ((1 << key) & mask) == 0) {
            key++;
        }
        if (key == 19 || ((~(1 << key)) & mask) != 0) {
            throw new IllegalArgumentException("invalid shaper: " + Integer.toHexString(mask));
        }
        return key;
    }

    public static NumericShaper getShaper(int singleRange) {
        int key = getKeyFromMask(singleRange);
        return new NumericShaper(key, singleRange);
    }

    public static NumericShaper getShaper(Range singleRange) {
        return new NumericShaper(singleRange, EnumSet.of(singleRange));
    }

    public static NumericShaper getContextualShaper(int ranges) {
        return new NumericShaper(0, ranges | Integer.MIN_VALUE);
    }

    public static NumericShaper getContextualShaper(Set<Range> ranges) {
        NumericShaper shaper = new NumericShaper(Range.EUROPEAN, ranges);
        shaper.mask = Integer.MIN_VALUE;
        return shaper;
    }

    public static NumericShaper getContextualShaper(int ranges, int defaultContext) {
        int key = getKeyFromMask(defaultContext);
        return new NumericShaper(key, ranges | Integer.MIN_VALUE);
    }

    public static NumericShaper getContextualShaper(Set<Range> ranges, Range defaultContext) {
        if (defaultContext == null) {
            throw new NullPointerException();
        }
        NumericShaper shaper = new NumericShaper(defaultContext, ranges);
        shaper.mask = Integer.MIN_VALUE;
        return shaper;
    }

    private NumericShaper(int key, int mask) {
        this.key = key;
        this.mask = mask;
    }

    private NumericShaper(Range defaultContext, Set<Range> ranges) {
        this.shapingRange = defaultContext;
        EnumSet copyOf = EnumSet.copyOf((Collection) ranges);
        this.rangeSet = copyOf;
        if (copyOf.contains(Range.EASTERN_ARABIC) && this.rangeSet.contains(Range.ARABIC)) {
            this.rangeSet.remove(Range.ARABIC);
        }
        if (this.rangeSet.contains(Range.TAI_THAM_THAM) && this.rangeSet.contains(Range.TAI_THAM_HORA)) {
            this.rangeSet.remove(Range.TAI_THAM_HORA);
        }
        Set<Range> set = this.rangeSet;
        Range[] rangeArr = (Range[]) set.toArray(new Range[set.size()]);
        this.rangeArray = rangeArr;
        if (rangeArr.length > 3) {
            Arrays.sort(rangeArr, new Comparator<Range>() { // from class: java.awt.font.NumericShaper.1
                @Override // java.util.Comparator
                public int compare(Range s12, Range s2) {
                    if (s12.base > s2.base) {
                        return 1;
                    }
                    return s12.base == s2.base ? 0 : -1;
                }
            });
        }
    }

    public void shape(char[] text, int start, int count) {
        checkParams(text, start, count);
        if (isContextual()) {
            if (this.rangeSet == null) {
                shapeContextually(text, start, count, this.key);
                return;
            } else {
                shapeContextually(text, start, count, this.shapingRange);
                return;
            }
        }
        shapeNonContextually(text, start, count);
    }

    public void shape(char[] text, int start, int count, int context) {
        checkParams(text, start, count);
        if (isContextual()) {
            int ctxKey = getKeyFromMask(context);
            if (this.rangeSet == null) {
                shapeContextually(text, start, count, ctxKey);
                return;
            } else {
                shapeContextually(text, start, count, Range.values()[ctxKey]);
                return;
            }
        }
        shapeNonContextually(text, start, count);
    }

    public void shape(char[] text, int start, int count, Range context) {
        checkParams(text, start, count);
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        if (isContextual()) {
            if (this.rangeSet != null) {
                shapeContextually(text, start, count, context);
                return;
            }
            int key = Range.toRangeIndex(context);
            if (key >= 0) {
                shapeContextually(text, start, count, key);
                return;
            } else {
                shapeContextually(text, start, count, this.shapingRange);
                return;
            }
        }
        shapeNonContextually(text, start, count);
    }

    private void checkParams(char[] text, int start, int count) {
        if (text == null) {
            throw new NullPointerException("text is null");
        }
        if (start < 0 || start > text.length || start + count < 0 || start + count > text.length) {
            throw new IndexOutOfBoundsException("bad start or count for text of length " + text.length);
        }
    }

    public boolean isContextual() {
        return (this.mask & Integer.MIN_VALUE) != 0;
    }

    public int getRanges() {
        return this.mask & Integer.MAX_VALUE;
    }

    public Set<Range> getRangeSet() {
        Set<Range> set = this.rangeSet;
        if (set != null) {
            return EnumSet.copyOf((Collection) set);
        }
        return Range.maskToRangeSet(this.mask);
    }

    private void shapeNonContextually(char[] cArr, int i10, int i11) {
        int i12;
        char c4 = '0';
        Range range = this.shapingRange;
        if (range != null) {
            int digitBase = range.getDigitBase();
            c4 = (char) (this.shapingRange.getNumericBase() + '0');
            i12 = digitBase;
        } else {
            char[] cArr2 = bases;
            int i13 = this.key;
            char c10 = cArr2[i13];
            i12 = c10;
            if (i13 == 16) {
                c4 = (char) (48 + 1);
                i12 = c10;
            }
        }
        int i14 = i10 + i11;
        for (int i15 = i10; i15 < i14; i15++) {
            char c11 = cArr[i15];
            if (c11 >= c4 && c11 <= '9') {
                cArr[i15] = (char) (c11 + i12);
            }
        }
    }

    private synchronized void shapeContextually(char[] text, int start, int count, int ctxKey) {
        int ctxKey2;
        int newkey;
        if ((this.mask & (1 << ctxKey)) != 0) {
            ctxKey2 = ctxKey;
        } else {
            ctxKey2 = 0;
        }
        int lastkey = ctxKey2;
        char c4 = bases[ctxKey2];
        char minDigit = ctxKey2 == 16 ? '1' : '0';
        synchronized (NumericShaper.class) {
            int e2 = start + count;
            char minDigit2 = minDigit;
            int base = c4;
            int lastkey2 = lastkey;
            for (int ctxKey3 = start; ctxKey3 < e2; ctxKey3++) {
                try {
                    char c10 = text[ctxKey3];
                    if (c10 >= minDigit2 && c10 <= '9') {
                        text[ctxKey3] = (char) (c10 + base);
                    }
                    if (isStrongDirectional(c10) && (newkey = getContextKey(c10)) != lastkey2) {
                        lastkey2 = newkey;
                        int ctxKey4 = newkey;
                        int i10 = this.mask;
                        if ((i10 & 4) != 0 && (ctxKey4 == 1 || ctxKey4 == 2)) {
                            ctxKey4 = 2;
                        } else if ((i10 & 2) != 0 && (ctxKey4 == 1 || ctxKey4 == 2)) {
                            ctxKey4 = 1;
                        } else if (((1 << ctxKey4) & i10) == 0) {
                            ctxKey4 = 0;
                        }
                        char c11 = bases[ctxKey4];
                        minDigit2 = ctxKey4 == 16 ? '1' : '0';
                        base = c11;
                    }
                } finally {
                    th = th;
                    while (true) {
                        try {
                            break;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            }
        }
    }

    private void shapeContextually(char[] text, int start, int count, Range ctxKey) {
        Range ctxKey2;
        if (ctxKey == null || !this.rangeSet.contains(ctxKey)) {
            ctxKey = Range.EUROPEAN;
        }
        Range lastKey = ctxKey;
        int base = ctxKey.getDigitBase();
        char minDigit = (char) (ctxKey.getNumericBase() + '0');
        int end = start + count;
        for (int i10 = start; i10 < end; i10++) {
            char c4 = text[i10];
            if (c4 >= minDigit && c4 <= '9') {
                text[i10] = (char) (c4 + base);
            } else if (isStrongDirectional(c4) && (ctxKey2 = rangeForCodePoint(c4)) != lastKey) {
                lastKey = ctxKey2;
                base = ctxKey2.getDigitBase();
                minDigit = (char) (ctxKey2.getNumericBase() + '0');
            }
        }
    }

    public int hashCode() {
        int hash = this.mask;
        Set<Range> set = this.rangeSet;
        if (set != null) {
            return (hash & Integer.MIN_VALUE) ^ set.hashCode();
        }
        return hash;
    }

    public boolean equals(Object o10) {
        if (o10 != null) {
            try {
                NumericShaper rhs = (NumericShaper) o10;
                if (this.rangeSet != null) {
                    return rhs.rangeSet != null ? isContextual() == rhs.isContextual() && this.rangeSet.equals(rhs.rangeSet) && this.shapingRange == rhs.shapingRange : isContextual() == rhs.isContextual() && this.rangeSet.equals(Range.maskToRangeSet(rhs.mask)) && this.shapingRange == Range.indexToRange(rhs.key);
                }
                if (rhs.rangeSet == null) {
                    return rhs.mask == this.mask && rhs.key == this.key;
                }
                Set<Range> rset = Range.maskToRangeSet(this.mask);
                Range srange = Range.indexToRange(this.key);
                return isContextual() == rhs.isContextual() && rset.equals(rhs.rangeSet) && srange == rhs.shapingRange;
            } catch (ClassCastException e2) {
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(super.toString());
        buf.append("[contextual:").append(isContextual());
        if (isContextual()) {
            buf.append(", context:");
            Range range = this.shapingRange;
            if (range == null) {
                range = Range.values()[this.key];
            }
            buf.append((Object) range);
        }
        if (this.rangeSet == null) {
            buf.append(", range(s): ");
            boolean first = true;
            for (int i10 = 0; i10 < 19; i10++) {
                if ((this.mask & (1 << i10)) != 0) {
                    if (first) {
                        first = false;
                    } else {
                        buf.append(", ");
                    }
                    buf.append((Object) Range.values()[i10]);
                }
            }
        } else {
            buf.append(", range set: ").append((Object) this.rangeSet);
        }
        buf.append(']');
        return buf.toString();
    }

    private static int getHighBit(int value) {
        if (value <= 0) {
            return -32;
        }
        int bit = 0;
        if (value >= 65536) {
            value >>= 16;
            bit = 0 + 16;
        }
        if (value >= 256) {
            value >>= 8;
            bit += 8;
        }
        if (value >= 16) {
            value >>= 4;
            bit += 4;
        }
        if (value >= 4) {
            value >>= 2;
            bit += 2;
        }
        if (value >= 2) {
            return bit + 1;
        }
        return bit;
    }

    private static int search(int value, int[] array, int start, int length) {
        int power = 1 << getHighBit(length);
        int extra = length - power;
        int probe = power;
        int index = start;
        if (value >= array[index + extra]) {
            index += extra;
        }
        while (probe > 1) {
            probe >>= 1;
            if (value >= array[index + probe]) {
                index += probe;
            }
        }
        return index;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        int index;
        Range range = this.shapingRange;
        if (range != null && (index = Range.toRangeIndex(range)) >= 0) {
            this.key = index;
        }
        Set<Range> set = this.rangeSet;
        if (set != null) {
            this.mask = Range.toRangeMask(set) | this.mask;
        }
        stream.defaultWriteObject();
    }
}
