package java.lang;

import android.view.SurfaceControl;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.os.Zygote;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.qq.e.comm.constants.ErrorCode;
import com.tencent.connect.common.Constants;
import com.zego.ve.HwAudioKit;
import dalvik.annotation.optimization.FastNative;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Character implements Serializable, Comparable<Character> {
    public static final int BYTES = 2;
    public static final byte COMBINING_SPACING_MARK = 8;
    public static final byte CONNECTOR_PUNCTUATION = 23;
    public static final byte CONTROL = 15;
    public static final byte CURRENCY_SYMBOL = 26;
    public static final byte DASH_PUNCTUATION = 20;
    public static final byte DECIMAL_DIGIT_NUMBER = 9;
    public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6;
    public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9;
    public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5;
    public static final byte DIRECTIONALITY_FIRST_STRONG_ISOLATE = 21;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_ISOLATE = 19;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15;
    public static final byte DIRECTIONALITY_NONSPACING_MARK = 8;
    public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13;
    public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10;
    public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18;
    public static final byte DIRECTIONALITY_POP_DIRECTIONAL_ISOLATE = 22;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ISOLATE = 20;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17;
    public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11;
    public static final byte DIRECTIONALITY_UNDEFINED = -1;
    public static final byte DIRECTIONALITY_WHITESPACE = 12;
    public static final byte ENCLOSING_MARK = 7;
    public static final byte END_PUNCTUATION = 22;
    static final int ERROR = -1;
    public static final byte FINAL_QUOTE_PUNCTUATION = 30;
    public static final byte FORMAT = 16;
    public static final byte INITIAL_QUOTE_PUNCTUATION = 29;
    public static final byte LETTER_NUMBER = 10;
    public static final byte LINE_SEPARATOR = 13;
    public static final byte LOWERCASE_LETTER = 2;
    public static final byte MATH_SYMBOL = 25;
    public static final int MAX_CODE_POINT = 1114111;
    public static final char MAX_HIGH_SURROGATE = 56319;
    public static final char MAX_LOW_SURROGATE = 57343;
    public static final int MAX_RADIX = 36;
    public static final char MAX_SURROGATE = 57343;
    public static final char MAX_VALUE = 65535;
    public static final int MIN_CODE_POINT = 0;
    public static final char MIN_HIGH_SURROGATE = 55296;
    public static final char MIN_LOW_SURROGATE = 56320;
    public static final int MIN_RADIX = 2;
    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 65536;
    public static final char MIN_SURROGATE = 55296;
    public static final char MIN_VALUE = 0;
    public static final byte MODIFIER_LETTER = 4;
    public static final byte MODIFIER_SYMBOL = 27;
    public static final byte NON_SPACING_MARK = 6;
    public static final byte OTHER_LETTER = 5;
    public static final byte OTHER_NUMBER = 11;
    public static final byte OTHER_PUNCTUATION = 24;
    public static final byte OTHER_SYMBOL = 28;
    public static final byte PARAGRAPH_SEPARATOR = 14;
    public static final byte PRIVATE_USE = 18;
    public static final int SIZE = 16;
    public static final byte SPACE_SEPARATOR = 12;
    public static final byte START_PUNCTUATION = 21;
    public static final byte SURROGATE = 19;
    public static final byte TITLECASE_LETTER = 3;
    public static final byte UNASSIGNED = 0;
    public static final byte UPPERCASE_LETTER = 1;
    private static final long serialVersionUID = 3786198910865385080L;
    private final char value;
    public static final Class<Character> TYPE = Class.getPrimitiveClass("char");
    private static final byte[] DIRECTIONALITY = {0, 1, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 2, 16, 17, 18, 8, 9};

    @FastNative
    static native int digitImpl(int i10, int i11);

    @FastNative
    static native byte getDirectionalityImpl(int i10);

    private static native String getNameImpl(int i10);

    @FastNative
    static native int getNumericValueImpl(int i10);

    @FastNative
    static native int getTypeImpl(int i10);

    @FastNative
    static native boolean isAlphabeticImpl(int i10);

    @FastNative
    static native boolean isDefinedImpl(int i10);

    @FastNative
    static native boolean isDigitImpl(int i10);

    @FastNative
    static native boolean isIdentifierIgnorableImpl(int i10);

    @FastNative
    static native boolean isIdeographicImpl(int i10);

    @FastNative
    static native boolean isLetterImpl(int i10);

    @FastNative
    static native boolean isLetterOrDigitImpl(int i10);

    @FastNative
    static native boolean isLowerCaseImpl(int i10);

    @FastNative
    static native boolean isMirroredImpl(int i10);

    @FastNative
    static native boolean isSpaceCharImpl(int i10);

    @FastNative
    static native boolean isTitleCaseImpl(int i10);

    @FastNative
    static native boolean isUnicodeIdentifierPartImpl(int i10);

    @FastNative
    static native boolean isUnicodeIdentifierStartImpl(int i10);

    @FastNative
    static native boolean isUpperCaseImpl(int i10);

    @FastNative
    static native boolean isWhitespaceImpl(int i10);

    @FastNative
    static native int toLowerCaseImpl(int i10);

    @FastNative
    static native int toTitleCaseImpl(int i10);

    @FastNative
    static native int toUpperCaseImpl(int i10);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Subset {
        private String name;

        protected Subset(String name) {
            if (name == null) {
                throw new NullPointerException("name");
            }
            this.name = name;
        }

        public final boolean equals(Object obj) {
            return this == obj;
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return this.name;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UnicodeBlock extends Subset {
        public static final UnicodeBlock ADLAM;
        public static final UnicodeBlock AEGEAN_NUMBERS;
        public static final UnicodeBlock AHOM;
        public static final UnicodeBlock ALCHEMICAL_SYMBOLS;
        public static final UnicodeBlock ALPHABETIC_PRESENTATION_FORMS;
        public static final UnicodeBlock ANATOLIAN_HIEROGLYPHS;
        public static final UnicodeBlock ANCIENT_GREEK_MUSICAL_NOTATION;
        public static final UnicodeBlock ANCIENT_GREEK_NUMBERS;
        public static final UnicodeBlock ANCIENT_SYMBOLS;
        public static final UnicodeBlock ARABIC;
        public static final UnicodeBlock ARABIC_EXTENDED_A;
        public static final UnicodeBlock ARABIC_MATHEMATICAL_ALPHABETIC_SYMBOLS;
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_A;
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_B;
        public static final UnicodeBlock ARABIC_SUPPLEMENT;
        public static final UnicodeBlock ARMENIAN;
        public static final UnicodeBlock ARROWS;
        public static final UnicodeBlock AVESTAN;
        public static final UnicodeBlock BALINESE;
        public static final UnicodeBlock BAMUM;
        public static final UnicodeBlock BAMUM_SUPPLEMENT;
        public static final UnicodeBlock BASIC_LATIN;
        public static final UnicodeBlock BASSA_VAH;
        public static final UnicodeBlock BATAK;
        public static final UnicodeBlock BENGALI;
        public static final UnicodeBlock BHAIKSUKI;
        public static final UnicodeBlock BLOCK_ELEMENTS;
        public static final UnicodeBlock BOPOMOFO;
        public static final UnicodeBlock BOPOMOFO_EXTENDED;
        public static final UnicodeBlock BOX_DRAWING;
        public static final UnicodeBlock BRAHMI;
        public static final UnicodeBlock BRAILLE_PATTERNS;
        public static final UnicodeBlock BUGINESE;
        public static final UnicodeBlock BUHID;
        public static final UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS;
        public static final UnicodeBlock CARIAN;
        public static final UnicodeBlock CAUCASIAN_ALBANIAN;
        public static final UnicodeBlock CHAKMA;
        public static final UnicodeBlock CHAM;
        public static final UnicodeBlock CHEROKEE;
        public static final UnicodeBlock CHEROKEE_SUPPLEMENT;
        public static final UnicodeBlock CHESS_SYMBOLS;
        public static final UnicodeBlock CHORASMIAN;
        public static final UnicodeBlock CJK_COMPATIBILITY;
        public static final UnicodeBlock CJK_COMPATIBILITY_FORMS;
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS;
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT;
        public static final UnicodeBlock CJK_RADICALS_SUPPLEMENT;
        public static final UnicodeBlock CJK_STROKES;
        public static final UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_E;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_G;
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS;
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS_EXTENDED;
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS_SUPPLEMENT;
        public static final UnicodeBlock COMBINING_HALF_MARKS;
        public static final UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS;
        public static final UnicodeBlock COMMON_INDIC_NUMBER_FORMS;
        public static final UnicodeBlock CONTROL_PICTURES;
        public static final UnicodeBlock COPTIC;
        public static final UnicodeBlock COPTIC_EPACT_NUMBERS;
        public static final UnicodeBlock COUNTING_ROD_NUMERALS;
        public static final UnicodeBlock CUNEIFORM;
        public static final UnicodeBlock CUNEIFORM_NUMBERS_AND_PUNCTUATION;
        public static final UnicodeBlock CURRENCY_SYMBOLS;
        public static final UnicodeBlock CYPRIOT_SYLLABARY;
        public static final UnicodeBlock CYRILLIC;
        public static final UnicodeBlock CYRILLIC_EXTENDED_A;
        public static final UnicodeBlock CYRILLIC_EXTENDED_B;
        public static final UnicodeBlock CYRILLIC_EXTENDED_C;
        public static final UnicodeBlock CYRILLIC_SUPPLEMENTARY;
        public static final UnicodeBlock DESERET;
        public static final UnicodeBlock DEVANAGARI;
        public static final UnicodeBlock DEVANAGARI_EXTENDED;
        public static final UnicodeBlock DINGBATS;
        public static final UnicodeBlock DIVES_AKURU;
        public static final UnicodeBlock DOGRA;
        public static final UnicodeBlock DOMINO_TILES;
        public static final UnicodeBlock DUPLOYAN;
        public static final UnicodeBlock EARLY_DYNASTIC_CUNEIFORM;
        public static final UnicodeBlock EGYPTIAN_HIEROGLYPHS;
        public static final UnicodeBlock EGYPTIAN_HIEROGLYPH_FORMAT_CONTROLS;
        public static final UnicodeBlock ELBASAN;
        public static final UnicodeBlock ELYMAIC;
        public static final UnicodeBlock EMOTICONS;
        public static final UnicodeBlock ENCLOSED_ALPHANUMERICS;
        public static final UnicodeBlock ENCLOSED_ALPHANUMERIC_SUPPLEMENT;
        public static final UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS;
        public static final UnicodeBlock ENCLOSED_IDEOGRAPHIC_SUPPLEMENT;
        public static final UnicodeBlock ETHIOPIC;
        public static final UnicodeBlock ETHIOPIC_EXTENDED;
        public static final UnicodeBlock ETHIOPIC_EXTENDED_A;
        public static final UnicodeBlock ETHIOPIC_SUPPLEMENT;
        public static final UnicodeBlock GENERAL_PUNCTUATION;
        public static final UnicodeBlock GEOMETRIC_SHAPES;
        public static final UnicodeBlock GEOMETRIC_SHAPES_EXTENDED;
        public static final UnicodeBlock GEORGIAN;
        public static final UnicodeBlock GEORGIAN_EXTENDED;
        public static final UnicodeBlock GEORGIAN_SUPPLEMENT;
        public static final UnicodeBlock GLAGOLITIC;
        public static final UnicodeBlock GLAGOLITIC_SUPPLEMENT;
        public static final UnicodeBlock GOTHIC;
        public static final UnicodeBlock GRANTHA;
        public static final UnicodeBlock GREEK;
        public static final UnicodeBlock GREEK_EXTENDED;
        public static final UnicodeBlock GUJARATI;
        public static final UnicodeBlock GUNJALA_GONDI;
        public static final UnicodeBlock GURMUKHI;
        public static final UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS;
        public static final UnicodeBlock HANGUL_COMPATIBILITY_JAMO;
        public static final UnicodeBlock HANGUL_JAMO;
        public static final UnicodeBlock HANGUL_JAMO_EXTENDED_A;
        public static final UnicodeBlock HANGUL_JAMO_EXTENDED_B;
        public static final UnicodeBlock HANGUL_SYLLABLES;
        public static final UnicodeBlock HANIFI_ROHINGYA;
        public static final UnicodeBlock HANUNOO;
        public static final UnicodeBlock HATRAN;
        public static final UnicodeBlock HEBREW;
        public static final UnicodeBlock HIGH_PRIVATE_USE_SURROGATES;
        public static final UnicodeBlock HIGH_SURROGATES;
        public static final UnicodeBlock HIRAGANA;
        public static final UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS;
        public static final UnicodeBlock IDEOGRAPHIC_SYMBOLS_AND_PUNCTUATION;
        public static final UnicodeBlock IMPERIAL_ARAMAIC;
        public static final UnicodeBlock INDIC_SIYAQ_NUMBERS;
        public static final UnicodeBlock INSCRIPTIONAL_PAHLAVI;
        public static final UnicodeBlock INSCRIPTIONAL_PARTHIAN;
        public static final UnicodeBlock IPA_EXTENSIONS;
        public static final UnicodeBlock JAVANESE;
        public static final UnicodeBlock KAITHI;
        public static final UnicodeBlock KANA_EXTENDED_A;
        public static final UnicodeBlock KANA_SUPPLEMENT;
        public static final UnicodeBlock KANBUN;
        public static final UnicodeBlock KANGXI_RADICALS;
        public static final UnicodeBlock KANNADA;
        public static final UnicodeBlock KATAKANA;
        public static final UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS;
        public static final UnicodeBlock KAYAH_LI;
        public static final UnicodeBlock KHAROSHTHI;
        public static final UnicodeBlock KHITAN_SMALL_SCRIPT;
        public static final UnicodeBlock KHMER;
        public static final UnicodeBlock KHMER_SYMBOLS;
        public static final UnicodeBlock KHOJKI;
        public static final UnicodeBlock KHUDAWADI;
        public static final UnicodeBlock LAO;
        public static final UnicodeBlock LATIN_1_SUPPLEMENT;
        public static final UnicodeBlock LATIN_EXTENDED_A;
        public static final UnicodeBlock LATIN_EXTENDED_ADDITIONAL;
        public static final UnicodeBlock LATIN_EXTENDED_B;
        public static final UnicodeBlock LATIN_EXTENDED_C;
        public static final UnicodeBlock LATIN_EXTENDED_D;
        public static final UnicodeBlock LATIN_EXTENDED_E;
        public static final UnicodeBlock LEPCHA;
        public static final UnicodeBlock LETTERLIKE_SYMBOLS;
        public static final UnicodeBlock LIMBU;
        public static final UnicodeBlock LINEAR_A;
        public static final UnicodeBlock LINEAR_B_IDEOGRAMS;
        public static final UnicodeBlock LINEAR_B_SYLLABARY;
        public static final UnicodeBlock LISU;
        public static final UnicodeBlock LISU_SUPPLEMENT;
        public static final UnicodeBlock LOW_SURROGATES;
        public static final UnicodeBlock LYCIAN;
        public static final UnicodeBlock LYDIAN;
        public static final UnicodeBlock MAHAJANI;
        public static final UnicodeBlock MAHJONG_TILES;
        public static final UnicodeBlock MAKASAR;
        public static final UnicodeBlock MALAYALAM;
        public static final UnicodeBlock MANDAIC;
        public static final UnicodeBlock MANICHAEAN;
        public static final UnicodeBlock MARCHEN;
        public static final UnicodeBlock MASARAM_GONDI;
        public static final UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS;
        public static final UnicodeBlock MATHEMATICAL_OPERATORS;
        public static final UnicodeBlock MAYAN_NUMERALS;
        public static final UnicodeBlock MEDEFAIDRIN;
        public static final UnicodeBlock MEETEI_MAYEK;
        public static final UnicodeBlock MEETEI_MAYEK_EXTENSIONS;
        public static final UnicodeBlock MENDE_KIKAKUI;
        public static final UnicodeBlock MEROITIC_CURSIVE;
        public static final UnicodeBlock MEROITIC_HIEROGLYPHS;
        public static final UnicodeBlock MIAO;
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A;
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B;
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS;
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS;
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS;
        public static final UnicodeBlock MISCELLANEOUS_TECHNICAL;
        public static final UnicodeBlock MODI;
        public static final UnicodeBlock MODIFIER_TONE_LETTERS;
        public static final UnicodeBlock MONGOLIAN;
        public static final UnicodeBlock MONGOLIAN_SUPPLEMENT;
        public static final UnicodeBlock MRO;
        public static final UnicodeBlock MULTANI;
        public static final UnicodeBlock MUSICAL_SYMBOLS;
        public static final UnicodeBlock MYANMAR;
        public static final UnicodeBlock MYANMAR_EXTENDED_A;
        public static final UnicodeBlock MYANMAR_EXTENDED_B;
        public static final UnicodeBlock NABATAEAN;
        public static final UnicodeBlock NANDINAGARI;
        public static final UnicodeBlock NEWA;
        public static final UnicodeBlock NEW_TAI_LUE;
        public static final UnicodeBlock NKO;
        public static final UnicodeBlock NUMBER_FORMS;
        private static final int NUM_ENTITIES = 684;
        public static final UnicodeBlock NUSHU;
        public static final UnicodeBlock NYIAKENG_PUACHUE_HMONG;
        public static final UnicodeBlock OGHAM;
        public static final UnicodeBlock OLD_HUNGARIAN;
        public static final UnicodeBlock OLD_ITALIC;
        public static final UnicodeBlock OLD_NORTH_ARABIAN;
        public static final UnicodeBlock OLD_PERMIC;
        public static final UnicodeBlock OLD_PERSIAN;
        public static final UnicodeBlock OLD_SOGDIAN;
        public static final UnicodeBlock OLD_SOUTH_ARABIAN;
        public static final UnicodeBlock OLD_TURKIC;
        public static final UnicodeBlock OL_CHIKI;
        public static final UnicodeBlock OPTICAL_CHARACTER_RECOGNITION;
        public static final UnicodeBlock ORIYA;
        public static final UnicodeBlock ORNAMENTAL_DINGBATS;
        public static final UnicodeBlock OSAGE;
        public static final UnicodeBlock OSMANYA;
        public static final UnicodeBlock OTTOMAN_SIYAQ_NUMBERS;
        public static final UnicodeBlock PAHAWH_HMONG;
        public static final UnicodeBlock PALMYRENE;
        public static final UnicodeBlock PAU_CIN_HAU;
        public static final UnicodeBlock PHAGS_PA;
        public static final UnicodeBlock PHAISTOS_DISC;
        public static final UnicodeBlock PHOENICIAN;
        public static final UnicodeBlock PHONETIC_EXTENSIONS;
        public static final UnicodeBlock PHONETIC_EXTENSIONS_SUPPLEMENT;
        public static final UnicodeBlock PLAYING_CARDS;
        public static final UnicodeBlock PRIVATE_USE_AREA;
        public static final UnicodeBlock PSALTER_PAHLAVI;
        public static final UnicodeBlock REJANG;
        public static final UnicodeBlock RUMI_NUMERAL_SYMBOLS;
        public static final UnicodeBlock RUNIC;
        public static final UnicodeBlock SAMARITAN;
        public static final UnicodeBlock SAURASHTRA;
        public static final UnicodeBlock SHARADA;
        public static final UnicodeBlock SHAVIAN;
        public static final UnicodeBlock SHORTHAND_FORMAT_CONTROLS;
        public static final UnicodeBlock SIDDHAM;
        public static final UnicodeBlock SINHALA;
        public static final UnicodeBlock SINHALA_ARCHAIC_NUMBERS;
        public static final UnicodeBlock SMALL_FORM_VARIANTS;
        public static final UnicodeBlock SMALL_KANA_EXTENSION;
        public static final UnicodeBlock SOGDIAN;
        public static final UnicodeBlock SORA_SOMPENG;
        public static final UnicodeBlock SOYOMBO;
        public static final UnicodeBlock SPACING_MODIFIER_LETTERS;
        public static final UnicodeBlock SPECIALS;
        public static final UnicodeBlock SUNDANESE;
        public static final UnicodeBlock SUNDANESE_SUPPLEMENT;
        public static final UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS;
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_A;
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_B;
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_C;
        public static final UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS;
        public static final UnicodeBlock SUPPLEMENTAL_PUNCTUATION;
        public static final UnicodeBlock SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS;
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A;
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B;

        @Deprecated(since = "1.5")
        public static final UnicodeBlock SURROGATES_AREA;
        public static final UnicodeBlock SUTTON_SIGNWRITING;
        public static final UnicodeBlock SYLOTI_NAGRI;
        public static final UnicodeBlock SYMBOLS_AND_PICTOGRAPHS_EXTENDED_A;
        public static final UnicodeBlock SYMBOLS_FOR_LEGACY_COMPUTING;
        public static final UnicodeBlock SYRIAC;
        public static final UnicodeBlock SYRIAC_SUPPLEMENT;
        public static final UnicodeBlock TAGALOG;
        public static final UnicodeBlock TAGBANWA;
        public static final UnicodeBlock TAGS;
        public static final UnicodeBlock TAI_LE;
        public static final UnicodeBlock TAI_THAM;
        public static final UnicodeBlock TAI_VIET;
        public static final UnicodeBlock TAI_XUAN_JING_SYMBOLS;
        public static final UnicodeBlock TAKRI;
        public static final UnicodeBlock TAMIL;
        public static final UnicodeBlock TAMIL_SUPPLEMENT;
        public static final UnicodeBlock TANGUT;
        public static final UnicodeBlock TANGUT_COMPONENTS;
        public static final UnicodeBlock TANGUT_SUPPLEMENT;
        public static final UnicodeBlock TELUGU;
        public static final UnicodeBlock THAANA;
        public static final UnicodeBlock THAI;
        public static final UnicodeBlock TIBETAN;
        public static final UnicodeBlock TIFINAGH;
        public static final UnicodeBlock TIRHUTA;
        public static final UnicodeBlock TRANSPORT_AND_MAP_SYMBOLS;
        public static final UnicodeBlock UGARITIC;
        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS;
        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED;
        public static final UnicodeBlock VAI;
        public static final UnicodeBlock VARIATION_SELECTORS;
        public static final UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT;
        public static final UnicodeBlock VEDIC_EXTENSIONS;
        public static final UnicodeBlock VERTICAL_FORMS;
        public static final UnicodeBlock WANCHO;
        public static final UnicodeBlock WARANG_CITI;
        public static final UnicodeBlock YEZIDI;
        public static final UnicodeBlock YIJING_HEXAGRAM_SYMBOLS;
        public static final UnicodeBlock YI_RADICALS;
        public static final UnicodeBlock YI_SYLLABLES;
        public static final UnicodeBlock ZANABAZAR_SQUARE;
        private static final int[] blockStarts;
        private static final UnicodeBlock[] blocks;
        private static Map<String, UnicodeBlock> map = new HashMap(913);

        static {
            UnicodeBlock unicodeBlock = new UnicodeBlock("BASIC_LATIN", "BASIC LATIN", "BASICLATIN");
            BASIC_LATIN = unicodeBlock;
            UnicodeBlock unicodeBlock2 = new UnicodeBlock("LATIN_1_SUPPLEMENT", "LATIN-1 SUPPLEMENT", "LATIN-1SUPPLEMENT");
            LATIN_1_SUPPLEMENT = unicodeBlock2;
            UnicodeBlock unicodeBlock3 = new UnicodeBlock("LATIN_EXTENDED_A", "LATIN EXTENDED-A", "LATINEXTENDED-A");
            LATIN_EXTENDED_A = unicodeBlock3;
            UnicodeBlock unicodeBlock4 = new UnicodeBlock("LATIN_EXTENDED_B", "LATIN EXTENDED-B", "LATINEXTENDED-B");
            LATIN_EXTENDED_B = unicodeBlock4;
            UnicodeBlock unicodeBlock5 = new UnicodeBlock("IPA_EXTENSIONS", "IPA EXTENSIONS", "IPAEXTENSIONS");
            IPA_EXTENSIONS = unicodeBlock5;
            UnicodeBlock unicodeBlock6 = new UnicodeBlock("SPACING_MODIFIER_LETTERS", "SPACING MODIFIER LETTERS", "SPACINGMODIFIERLETTERS");
            SPACING_MODIFIER_LETTERS = unicodeBlock6;
            UnicodeBlock unicodeBlock7 = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS", "COMBINING DIACRITICAL MARKS", "COMBININGDIACRITICALMARKS");
            COMBINING_DIACRITICAL_MARKS = unicodeBlock7;
            UnicodeBlock unicodeBlock8 = new UnicodeBlock("GREEK", "GREEK AND COPTIC", "GREEKANDCOPTIC");
            GREEK = unicodeBlock8;
            UnicodeBlock unicodeBlock9 = new UnicodeBlock("CYRILLIC");
            CYRILLIC = unicodeBlock9;
            UnicodeBlock unicodeBlock10 = new UnicodeBlock("ARMENIAN");
            ARMENIAN = unicodeBlock10;
            UnicodeBlock unicodeBlock11 = new UnicodeBlock("HEBREW");
            HEBREW = unicodeBlock11;
            UnicodeBlock unicodeBlock12 = new UnicodeBlock("ARABIC");
            ARABIC = unicodeBlock12;
            UnicodeBlock unicodeBlock13 = new UnicodeBlock("DEVANAGARI");
            DEVANAGARI = unicodeBlock13;
            UnicodeBlock unicodeBlock14 = new UnicodeBlock("BENGALI");
            BENGALI = unicodeBlock14;
            UnicodeBlock unicodeBlock15 = new UnicodeBlock("GURMUKHI");
            GURMUKHI = unicodeBlock15;
            UnicodeBlock unicodeBlock16 = new UnicodeBlock("GUJARATI");
            GUJARATI = unicodeBlock16;
            UnicodeBlock unicodeBlock17 = new UnicodeBlock("ORIYA");
            ORIYA = unicodeBlock17;
            UnicodeBlock unicodeBlock18 = new UnicodeBlock("TAMIL");
            TAMIL = unicodeBlock18;
            UnicodeBlock unicodeBlock19 = new UnicodeBlock("TELUGU");
            TELUGU = unicodeBlock19;
            UnicodeBlock unicodeBlock20 = new UnicodeBlock("KANNADA");
            KANNADA = unicodeBlock20;
            UnicodeBlock unicodeBlock21 = new UnicodeBlock("MALAYALAM");
            MALAYALAM = unicodeBlock21;
            UnicodeBlock unicodeBlock22 = new UnicodeBlock("THAI");
            THAI = unicodeBlock22;
            UnicodeBlock unicodeBlock23 = new UnicodeBlock("LAO");
            LAO = unicodeBlock23;
            UnicodeBlock unicodeBlock24 = new UnicodeBlock("TIBETAN");
            TIBETAN = unicodeBlock24;
            UnicodeBlock unicodeBlock25 = new UnicodeBlock("GEORGIAN");
            GEORGIAN = unicodeBlock25;
            UnicodeBlock unicodeBlock26 = new UnicodeBlock("HANGUL_JAMO", "HANGUL JAMO", "HANGULJAMO");
            HANGUL_JAMO = unicodeBlock26;
            UnicodeBlock unicodeBlock27 = new UnicodeBlock("LATIN_EXTENDED_ADDITIONAL", "LATIN EXTENDED ADDITIONAL", "LATINEXTENDEDADDITIONAL");
            LATIN_EXTENDED_ADDITIONAL = unicodeBlock27;
            UnicodeBlock unicodeBlock28 = new UnicodeBlock("GREEK_EXTENDED", "GREEK EXTENDED", "GREEKEXTENDED");
            GREEK_EXTENDED = unicodeBlock28;
            UnicodeBlock unicodeBlock29 = new UnicodeBlock("GENERAL_PUNCTUATION", "GENERAL PUNCTUATION", "GENERALPUNCTUATION");
            GENERAL_PUNCTUATION = unicodeBlock29;
            UnicodeBlock unicodeBlock30 = new UnicodeBlock("SUPERSCRIPTS_AND_SUBSCRIPTS", "SUPERSCRIPTS AND SUBSCRIPTS", "SUPERSCRIPTSANDSUBSCRIPTS");
            SUPERSCRIPTS_AND_SUBSCRIPTS = unicodeBlock30;
            UnicodeBlock unicodeBlock31 = new UnicodeBlock("CURRENCY_SYMBOLS", "CURRENCY SYMBOLS", "CURRENCYSYMBOLS");
            CURRENCY_SYMBOLS = unicodeBlock31;
            UnicodeBlock unicodeBlock32 = new UnicodeBlock("COMBINING_MARKS_FOR_SYMBOLS", "COMBINING DIACRITICAL MARKS FOR SYMBOLS", "COMBININGDIACRITICALMARKSFORSYMBOLS", "COMBINING MARKS FOR SYMBOLS", "COMBININGMARKSFORSYMBOLS");
            COMBINING_MARKS_FOR_SYMBOLS = unicodeBlock32;
            UnicodeBlock unicodeBlock33 = new UnicodeBlock("LETTERLIKE_SYMBOLS", "LETTERLIKE SYMBOLS", "LETTERLIKESYMBOLS");
            LETTERLIKE_SYMBOLS = unicodeBlock33;
            UnicodeBlock unicodeBlock34 = new UnicodeBlock("NUMBER_FORMS", "NUMBER FORMS", "NUMBERFORMS");
            NUMBER_FORMS = unicodeBlock34;
            UnicodeBlock unicodeBlock35 = new UnicodeBlock("ARROWS");
            ARROWS = unicodeBlock35;
            UnicodeBlock unicodeBlock36 = new UnicodeBlock("MATHEMATICAL_OPERATORS", "MATHEMATICAL OPERATORS", "MATHEMATICALOPERATORS");
            MATHEMATICAL_OPERATORS = unicodeBlock36;
            UnicodeBlock unicodeBlock37 = new UnicodeBlock("MISCELLANEOUS_TECHNICAL", "MISCELLANEOUS TECHNICAL", "MISCELLANEOUSTECHNICAL");
            MISCELLANEOUS_TECHNICAL = unicodeBlock37;
            UnicodeBlock unicodeBlock38 = new UnicodeBlock("CONTROL_PICTURES", "CONTROL PICTURES", "CONTROLPICTURES");
            CONTROL_PICTURES = unicodeBlock38;
            UnicodeBlock unicodeBlock39 = new UnicodeBlock("OPTICAL_CHARACTER_RECOGNITION", "OPTICAL CHARACTER RECOGNITION", "OPTICALCHARACTERRECOGNITION");
            OPTICAL_CHARACTER_RECOGNITION = unicodeBlock39;
            UnicodeBlock unicodeBlock40 = new UnicodeBlock("ENCLOSED_ALPHANUMERICS", "ENCLOSED ALPHANUMERICS", "ENCLOSEDALPHANUMERICS");
            ENCLOSED_ALPHANUMERICS = unicodeBlock40;
            UnicodeBlock unicodeBlock41 = new UnicodeBlock("BOX_DRAWING", "BOX DRAWING", "BOXDRAWING");
            BOX_DRAWING = unicodeBlock41;
            UnicodeBlock unicodeBlock42 = new UnicodeBlock("BLOCK_ELEMENTS", "BLOCK ELEMENTS", "BLOCKELEMENTS");
            BLOCK_ELEMENTS = unicodeBlock42;
            UnicodeBlock unicodeBlock43 = new UnicodeBlock("GEOMETRIC_SHAPES", "GEOMETRIC SHAPES", "GEOMETRICSHAPES");
            GEOMETRIC_SHAPES = unicodeBlock43;
            UnicodeBlock unicodeBlock44 = new UnicodeBlock("MISCELLANEOUS_SYMBOLS", "MISCELLANEOUS SYMBOLS", "MISCELLANEOUSSYMBOLS");
            MISCELLANEOUS_SYMBOLS = unicodeBlock44;
            UnicodeBlock unicodeBlock45 = new UnicodeBlock("DINGBATS");
            DINGBATS = unicodeBlock45;
            UnicodeBlock unicodeBlock46 = new UnicodeBlock("CJK_SYMBOLS_AND_PUNCTUATION", "CJK SYMBOLS AND PUNCTUATION", "CJKSYMBOLSANDPUNCTUATION");
            CJK_SYMBOLS_AND_PUNCTUATION = unicodeBlock46;
            UnicodeBlock unicodeBlock47 = new UnicodeBlock("HIRAGANA");
            HIRAGANA = unicodeBlock47;
            UnicodeBlock unicodeBlock48 = new UnicodeBlock("KATAKANA");
            KATAKANA = unicodeBlock48;
            UnicodeBlock unicodeBlock49 = new UnicodeBlock("BOPOMOFO");
            BOPOMOFO = unicodeBlock49;
            UnicodeBlock unicodeBlock50 = new UnicodeBlock("HANGUL_COMPATIBILITY_JAMO", "HANGUL COMPATIBILITY JAMO", "HANGULCOMPATIBILITYJAMO");
            HANGUL_COMPATIBILITY_JAMO = unicodeBlock50;
            UnicodeBlock unicodeBlock51 = new UnicodeBlock("KANBUN");
            KANBUN = unicodeBlock51;
            UnicodeBlock unicodeBlock52 = new UnicodeBlock("ENCLOSED_CJK_LETTERS_AND_MONTHS", "ENCLOSED CJK LETTERS AND MONTHS", "ENCLOSEDCJKLETTERSANDMONTHS");
            ENCLOSED_CJK_LETTERS_AND_MONTHS = unicodeBlock52;
            UnicodeBlock unicodeBlock53 = new UnicodeBlock("CJK_COMPATIBILITY", "CJK COMPATIBILITY", "CJKCOMPATIBILITY");
            CJK_COMPATIBILITY = unicodeBlock53;
            UnicodeBlock unicodeBlock54 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS", "CJK UNIFIED IDEOGRAPHS", "CJKUNIFIEDIDEOGRAPHS");
            CJK_UNIFIED_IDEOGRAPHS = unicodeBlock54;
            UnicodeBlock unicodeBlock55 = new UnicodeBlock("HANGUL_SYLLABLES", "HANGUL SYLLABLES", "HANGULSYLLABLES");
            HANGUL_SYLLABLES = unicodeBlock55;
            UnicodeBlock unicodeBlock56 = new UnicodeBlock("PRIVATE_USE_AREA", "PRIVATE USE AREA", "PRIVATEUSEAREA");
            PRIVATE_USE_AREA = unicodeBlock56;
            UnicodeBlock unicodeBlock57 = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS", "CJK COMPATIBILITY IDEOGRAPHS", "CJKCOMPATIBILITYIDEOGRAPHS");
            CJK_COMPATIBILITY_IDEOGRAPHS = unicodeBlock57;
            UnicodeBlock unicodeBlock58 = new UnicodeBlock("ALPHABETIC_PRESENTATION_FORMS", "ALPHABETIC PRESENTATION FORMS", "ALPHABETICPRESENTATIONFORMS");
            ALPHABETIC_PRESENTATION_FORMS = unicodeBlock58;
            UnicodeBlock unicodeBlock59 = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_A", "ARABIC PRESENTATION FORMS-A", "ARABICPRESENTATIONFORMS-A");
            ARABIC_PRESENTATION_FORMS_A = unicodeBlock59;
            UnicodeBlock unicodeBlock60 = new UnicodeBlock("COMBINING_HALF_MARKS", "COMBINING HALF MARKS", "COMBININGHALFMARKS");
            COMBINING_HALF_MARKS = unicodeBlock60;
            UnicodeBlock unicodeBlock61 = new UnicodeBlock("CJK_COMPATIBILITY_FORMS", "CJK COMPATIBILITY FORMS", "CJKCOMPATIBILITYFORMS");
            CJK_COMPATIBILITY_FORMS = unicodeBlock61;
            UnicodeBlock unicodeBlock62 = new UnicodeBlock("SMALL_FORM_VARIANTS", "SMALL FORM VARIANTS", "SMALLFORMVARIANTS");
            SMALL_FORM_VARIANTS = unicodeBlock62;
            UnicodeBlock unicodeBlock63 = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_B", "ARABIC PRESENTATION FORMS-B", "ARABICPRESENTATIONFORMS-B");
            ARABIC_PRESENTATION_FORMS_B = unicodeBlock63;
            UnicodeBlock unicodeBlock64 = new UnicodeBlock("HALFWIDTH_AND_FULLWIDTH_FORMS", "HALFWIDTH AND FULLWIDTH FORMS", "HALFWIDTHANDFULLWIDTHFORMS");
            HALFWIDTH_AND_FULLWIDTH_FORMS = unicodeBlock64;
            UnicodeBlock unicodeBlock65 = new UnicodeBlock("SPECIALS");
            SPECIALS = unicodeBlock65;
            SURROGATES_AREA = new UnicodeBlock("SURROGATES_AREA", false);
            UnicodeBlock unicodeBlock66 = new UnicodeBlock("SYRIAC");
            SYRIAC = unicodeBlock66;
            UnicodeBlock unicodeBlock67 = new UnicodeBlock("THAANA");
            THAANA = unicodeBlock67;
            UnicodeBlock unicodeBlock68 = new UnicodeBlock("SINHALA");
            SINHALA = unicodeBlock68;
            UnicodeBlock unicodeBlock69 = new UnicodeBlock("MYANMAR");
            MYANMAR = unicodeBlock69;
            UnicodeBlock unicodeBlock70 = new UnicodeBlock("ETHIOPIC");
            ETHIOPIC = unicodeBlock70;
            UnicodeBlock unicodeBlock71 = new UnicodeBlock("CHEROKEE");
            CHEROKEE = unicodeBlock71;
            UnicodeBlock unicodeBlock72 = new UnicodeBlock("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS", "UNIFIED CANADIAN ABORIGINAL SYLLABICS", "UNIFIEDCANADIANABORIGINALSYLLABICS");
            UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = unicodeBlock72;
            UnicodeBlock unicodeBlock73 = new UnicodeBlock("OGHAM");
            OGHAM = unicodeBlock73;
            UnicodeBlock unicodeBlock74 = new UnicodeBlock("RUNIC");
            RUNIC = unicodeBlock74;
            UnicodeBlock unicodeBlock75 = new UnicodeBlock("KHMER");
            KHMER = unicodeBlock75;
            UnicodeBlock unicodeBlock76 = new UnicodeBlock("MONGOLIAN");
            MONGOLIAN = unicodeBlock76;
            UnicodeBlock unicodeBlock77 = new UnicodeBlock("BRAILLE_PATTERNS", "BRAILLE PATTERNS", "BRAILLEPATTERNS");
            BRAILLE_PATTERNS = unicodeBlock77;
            UnicodeBlock unicodeBlock78 = new UnicodeBlock("CJK_RADICALS_SUPPLEMENT", "CJK RADICALS SUPPLEMENT", "CJKRADICALSSUPPLEMENT");
            CJK_RADICALS_SUPPLEMENT = unicodeBlock78;
            UnicodeBlock unicodeBlock79 = new UnicodeBlock("KANGXI_RADICALS", "KANGXI RADICALS", "KANGXIRADICALS");
            KANGXI_RADICALS = unicodeBlock79;
            UnicodeBlock unicodeBlock80 = new UnicodeBlock("IDEOGRAPHIC_DESCRIPTION_CHARACTERS", "IDEOGRAPHIC DESCRIPTION CHARACTERS", "IDEOGRAPHICDESCRIPTIONCHARACTERS");
            IDEOGRAPHIC_DESCRIPTION_CHARACTERS = unicodeBlock80;
            UnicodeBlock unicodeBlock81 = new UnicodeBlock("BOPOMOFO_EXTENDED", "BOPOMOFO EXTENDED", "BOPOMOFOEXTENDED");
            BOPOMOFO_EXTENDED = unicodeBlock81;
            UnicodeBlock unicodeBlock82 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A", "CJK UNIFIED IDEOGRAPHS EXTENSION A", "CJKUNIFIEDIDEOGRAPHSEXTENSIONA");
            CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = unicodeBlock82;
            UnicodeBlock unicodeBlock83 = new UnicodeBlock("YI_SYLLABLES", "YI SYLLABLES", "YISYLLABLES");
            YI_SYLLABLES = unicodeBlock83;
            UnicodeBlock unicodeBlock84 = new UnicodeBlock("YI_RADICALS", "YI RADICALS", "YIRADICALS");
            YI_RADICALS = unicodeBlock84;
            UnicodeBlock unicodeBlock85 = new UnicodeBlock("CYRILLIC_SUPPLEMENTARY", "CYRILLIC SUPPLEMENTARY", "CYRILLICSUPPLEMENTARY", "CYRILLIC SUPPLEMENT", "CYRILLICSUPPLEMENT");
            CYRILLIC_SUPPLEMENTARY = unicodeBlock85;
            UnicodeBlock unicodeBlock86 = new UnicodeBlock("TAGALOG");
            TAGALOG = unicodeBlock86;
            UnicodeBlock unicodeBlock87 = new UnicodeBlock("HANUNOO");
            HANUNOO = unicodeBlock87;
            UnicodeBlock unicodeBlock88 = new UnicodeBlock("BUHID");
            BUHID = unicodeBlock88;
            UnicodeBlock unicodeBlock89 = new UnicodeBlock("TAGBANWA");
            TAGBANWA = unicodeBlock89;
            UnicodeBlock unicodeBlock90 = new UnicodeBlock("LIMBU");
            LIMBU = unicodeBlock90;
            UnicodeBlock unicodeBlock91 = new UnicodeBlock("TAI_LE", "TAI LE", "TAILE");
            TAI_LE = unicodeBlock91;
            UnicodeBlock unicodeBlock92 = new UnicodeBlock("KHMER_SYMBOLS", "KHMER SYMBOLS", "KHMERSYMBOLS");
            KHMER_SYMBOLS = unicodeBlock92;
            UnicodeBlock unicodeBlock93 = new UnicodeBlock("PHONETIC_EXTENSIONS", "PHONETIC EXTENSIONS", "PHONETICEXTENSIONS");
            PHONETIC_EXTENSIONS = unicodeBlock93;
            UnicodeBlock unicodeBlock94 = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A", "MISCELLANEOUS MATHEMATICAL SYMBOLS-A", "MISCELLANEOUSMATHEMATICALSYMBOLS-A");
            MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = unicodeBlock94;
            UnicodeBlock unicodeBlock95 = new UnicodeBlock("SUPPLEMENTAL_ARROWS_A", "SUPPLEMENTAL ARROWS-A", "SUPPLEMENTALARROWS-A");
            SUPPLEMENTAL_ARROWS_A = unicodeBlock95;
            UnicodeBlock unicodeBlock96 = new UnicodeBlock("SUPPLEMENTAL_ARROWS_B", "SUPPLEMENTAL ARROWS-B", "SUPPLEMENTALARROWS-B");
            SUPPLEMENTAL_ARROWS_B = unicodeBlock96;
            UnicodeBlock unicodeBlock97 = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B", "MISCELLANEOUS MATHEMATICAL SYMBOLS-B", "MISCELLANEOUSMATHEMATICALSYMBOLS-B");
            MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = unicodeBlock97;
            UnicodeBlock unicodeBlock98 = new UnicodeBlock("SUPPLEMENTAL_MATHEMATICAL_OPERATORS", "SUPPLEMENTAL MATHEMATICAL OPERATORS", "SUPPLEMENTALMATHEMATICALOPERATORS");
            SUPPLEMENTAL_MATHEMATICAL_OPERATORS = unicodeBlock98;
            UnicodeBlock unicodeBlock99 = new UnicodeBlock("MISCELLANEOUS_SYMBOLS_AND_ARROWS", "MISCELLANEOUS SYMBOLS AND ARROWS", "MISCELLANEOUSSYMBOLSANDARROWS");
            MISCELLANEOUS_SYMBOLS_AND_ARROWS = unicodeBlock99;
            UnicodeBlock unicodeBlock100 = new UnicodeBlock("KATAKANA_PHONETIC_EXTENSIONS", "KATAKANA PHONETIC EXTENSIONS", "KATAKANAPHONETICEXTENSIONS");
            KATAKANA_PHONETIC_EXTENSIONS = unicodeBlock100;
            UnicodeBlock unicodeBlock101 = new UnicodeBlock("YIJING_HEXAGRAM_SYMBOLS", "YIJING HEXAGRAM SYMBOLS", "YIJINGHEXAGRAMSYMBOLS");
            YIJING_HEXAGRAM_SYMBOLS = unicodeBlock101;
            UnicodeBlock unicodeBlock102 = new UnicodeBlock("VARIATION_SELECTORS", "VARIATION SELECTORS", "VARIATIONSELECTORS");
            VARIATION_SELECTORS = unicodeBlock102;
            UnicodeBlock unicodeBlock103 = new UnicodeBlock("LINEAR_B_SYLLABARY", "LINEAR B SYLLABARY", "LINEARBSYLLABARY");
            LINEAR_B_SYLLABARY = unicodeBlock103;
            UnicodeBlock unicodeBlock104 = new UnicodeBlock("LINEAR_B_IDEOGRAMS", "LINEAR B IDEOGRAMS", "LINEARBIDEOGRAMS");
            LINEAR_B_IDEOGRAMS = unicodeBlock104;
            UnicodeBlock unicodeBlock105 = new UnicodeBlock("AEGEAN_NUMBERS", "AEGEAN NUMBERS", "AEGEANNUMBERS");
            AEGEAN_NUMBERS = unicodeBlock105;
            UnicodeBlock unicodeBlock106 = new UnicodeBlock("OLD_ITALIC", "OLD ITALIC", "OLDITALIC");
            OLD_ITALIC = unicodeBlock106;
            UnicodeBlock unicodeBlock107 = new UnicodeBlock("GOTHIC");
            GOTHIC = unicodeBlock107;
            UnicodeBlock unicodeBlock108 = new UnicodeBlock("UGARITIC");
            UGARITIC = unicodeBlock108;
            UnicodeBlock unicodeBlock109 = new UnicodeBlock("DESERET");
            DESERET = unicodeBlock109;
            UnicodeBlock unicodeBlock110 = new UnicodeBlock("SHAVIAN");
            SHAVIAN = unicodeBlock110;
            UnicodeBlock unicodeBlock111 = new UnicodeBlock("OSMANYA");
            OSMANYA = unicodeBlock111;
            UnicodeBlock unicodeBlock112 = new UnicodeBlock("CYPRIOT_SYLLABARY", "CYPRIOT SYLLABARY", "CYPRIOTSYLLABARY");
            CYPRIOT_SYLLABARY = unicodeBlock112;
            UnicodeBlock unicodeBlock113 = new UnicodeBlock("BYZANTINE_MUSICAL_SYMBOLS", "BYZANTINE MUSICAL SYMBOLS", "BYZANTINEMUSICALSYMBOLS");
            BYZANTINE_MUSICAL_SYMBOLS = unicodeBlock113;
            UnicodeBlock unicodeBlock114 = new UnicodeBlock("MUSICAL_SYMBOLS", "MUSICAL SYMBOLS", "MUSICALSYMBOLS");
            MUSICAL_SYMBOLS = unicodeBlock114;
            UnicodeBlock unicodeBlock115 = new UnicodeBlock("TAI_XUAN_JING_SYMBOLS", "TAI XUAN JING SYMBOLS", "TAIXUANJINGSYMBOLS");
            TAI_XUAN_JING_SYMBOLS = unicodeBlock115;
            UnicodeBlock unicodeBlock116 = new UnicodeBlock("MATHEMATICAL_ALPHANUMERIC_SYMBOLS", "MATHEMATICAL ALPHANUMERIC SYMBOLS", "MATHEMATICALALPHANUMERICSYMBOLS");
            MATHEMATICAL_ALPHANUMERIC_SYMBOLS = unicodeBlock116;
            UnicodeBlock unicodeBlock117 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B", "CJK UNIFIED IDEOGRAPHS EXTENSION B", "CJKUNIFIEDIDEOGRAPHSEXTENSIONB");
            CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = unicodeBlock117;
            UnicodeBlock unicodeBlock118 = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT", "CJK COMPATIBILITY IDEOGRAPHS SUPPLEMENT", "CJKCOMPATIBILITYIDEOGRAPHSSUPPLEMENT");
            CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = unicodeBlock118;
            UnicodeBlock unicodeBlock119 = new UnicodeBlock("TAGS");
            TAGS = unicodeBlock119;
            UnicodeBlock unicodeBlock120 = new UnicodeBlock("VARIATION_SELECTORS_SUPPLEMENT", "VARIATION SELECTORS SUPPLEMENT", "VARIATIONSELECTORSSUPPLEMENT");
            VARIATION_SELECTORS_SUPPLEMENT = unicodeBlock120;
            UnicodeBlock unicodeBlock121 = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_A", "SUPPLEMENTARY PRIVATE USE AREA-A", "SUPPLEMENTARYPRIVATEUSEAREA-A");
            SUPPLEMENTARY_PRIVATE_USE_AREA_A = unicodeBlock121;
            UnicodeBlock unicodeBlock122 = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_B", "SUPPLEMENTARY PRIVATE USE AREA-B", "SUPPLEMENTARYPRIVATEUSEAREA-B");
            SUPPLEMENTARY_PRIVATE_USE_AREA_B = unicodeBlock122;
            UnicodeBlock unicodeBlock123 = new UnicodeBlock("HIGH_SURROGATES", "HIGH SURROGATES", "HIGHSURROGATES");
            HIGH_SURROGATES = unicodeBlock123;
            UnicodeBlock unicodeBlock124 = new UnicodeBlock("HIGH_PRIVATE_USE_SURROGATES", "HIGH PRIVATE USE SURROGATES", "HIGHPRIVATEUSESURROGATES");
            HIGH_PRIVATE_USE_SURROGATES = unicodeBlock124;
            UnicodeBlock unicodeBlock125 = new UnicodeBlock("LOW_SURROGATES", "LOW SURROGATES", "LOWSURROGATES");
            LOW_SURROGATES = unicodeBlock125;
            UnicodeBlock unicodeBlock126 = new UnicodeBlock("ARABIC_SUPPLEMENT", "ARABIC SUPPLEMENT", "ARABICSUPPLEMENT");
            ARABIC_SUPPLEMENT = unicodeBlock126;
            UnicodeBlock unicodeBlock127 = new UnicodeBlock("NKO");
            NKO = unicodeBlock127;
            UnicodeBlock unicodeBlock128 = new UnicodeBlock("SAMARITAN");
            SAMARITAN = unicodeBlock128;
            UnicodeBlock unicodeBlock129 = new UnicodeBlock("MANDAIC");
            MANDAIC = unicodeBlock129;
            UnicodeBlock unicodeBlock130 = new UnicodeBlock("ETHIOPIC_SUPPLEMENT", "ETHIOPIC SUPPLEMENT", "ETHIOPICSUPPLEMENT");
            ETHIOPIC_SUPPLEMENT = unicodeBlock130;
            UnicodeBlock unicodeBlock131 = new UnicodeBlock("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED", "UNIFIED CANADIAN ABORIGINAL SYLLABICS EXTENDED", "UNIFIEDCANADIANABORIGINALSYLLABICSEXTENDED");
            UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED = unicodeBlock131;
            UnicodeBlock unicodeBlock132 = new UnicodeBlock("NEW_TAI_LUE", "NEW TAI LUE", "NEWTAILUE");
            NEW_TAI_LUE = unicodeBlock132;
            UnicodeBlock unicodeBlock133 = new UnicodeBlock("BUGINESE");
            BUGINESE = unicodeBlock133;
            UnicodeBlock unicodeBlock134 = new UnicodeBlock("TAI_THAM", "TAI THAM", "TAITHAM");
            TAI_THAM = unicodeBlock134;
            UnicodeBlock unicodeBlock135 = new UnicodeBlock("BALINESE");
            BALINESE = unicodeBlock135;
            UnicodeBlock unicodeBlock136 = new UnicodeBlock("SUNDANESE");
            SUNDANESE = unicodeBlock136;
            UnicodeBlock unicodeBlock137 = new UnicodeBlock("BATAK");
            BATAK = unicodeBlock137;
            UnicodeBlock unicodeBlock138 = new UnicodeBlock("LEPCHA");
            LEPCHA = unicodeBlock138;
            UnicodeBlock unicodeBlock139 = new UnicodeBlock("OL_CHIKI", "OL CHIKI", "OLCHIKI");
            OL_CHIKI = unicodeBlock139;
            UnicodeBlock unicodeBlock140 = new UnicodeBlock("VEDIC_EXTENSIONS", "VEDIC EXTENSIONS", "VEDICEXTENSIONS");
            VEDIC_EXTENSIONS = unicodeBlock140;
            UnicodeBlock unicodeBlock141 = new UnicodeBlock("PHONETIC_EXTENSIONS_SUPPLEMENT", "PHONETIC EXTENSIONS SUPPLEMENT", "PHONETICEXTENSIONSSUPPLEMENT");
            PHONETIC_EXTENSIONS_SUPPLEMENT = unicodeBlock141;
            UnicodeBlock unicodeBlock142 = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS_SUPPLEMENT", "COMBINING DIACRITICAL MARKS SUPPLEMENT", "COMBININGDIACRITICALMARKSSUPPLEMENT");
            COMBINING_DIACRITICAL_MARKS_SUPPLEMENT = unicodeBlock142;
            UnicodeBlock unicodeBlock143 = new UnicodeBlock("GLAGOLITIC");
            GLAGOLITIC = unicodeBlock143;
            UnicodeBlock unicodeBlock144 = new UnicodeBlock("LATIN_EXTENDED_C", "LATIN EXTENDED-C", "LATINEXTENDED-C");
            LATIN_EXTENDED_C = unicodeBlock144;
            UnicodeBlock unicodeBlock145 = new UnicodeBlock("COPTIC");
            COPTIC = unicodeBlock145;
            UnicodeBlock unicodeBlock146 = new UnicodeBlock("GEORGIAN_SUPPLEMENT", "GEORGIAN SUPPLEMENT", "GEORGIANSUPPLEMENT");
            GEORGIAN_SUPPLEMENT = unicodeBlock146;
            UnicodeBlock unicodeBlock147 = new UnicodeBlock("TIFINAGH");
            TIFINAGH = unicodeBlock147;
            UnicodeBlock unicodeBlock148 = new UnicodeBlock("ETHIOPIC_EXTENDED", "ETHIOPIC EXTENDED", "ETHIOPICEXTENDED");
            ETHIOPIC_EXTENDED = unicodeBlock148;
            UnicodeBlock unicodeBlock149 = new UnicodeBlock("CYRILLIC_EXTENDED_A", "CYRILLIC EXTENDED-A", "CYRILLICEXTENDED-A");
            CYRILLIC_EXTENDED_A = unicodeBlock149;
            UnicodeBlock unicodeBlock150 = new UnicodeBlock("SUPPLEMENTAL_PUNCTUATION", "SUPPLEMENTAL PUNCTUATION", "SUPPLEMENTALPUNCTUATION");
            SUPPLEMENTAL_PUNCTUATION = unicodeBlock150;
            UnicodeBlock unicodeBlock151 = new UnicodeBlock("CJK_STROKES", "CJK STROKES", "CJKSTROKES");
            CJK_STROKES = unicodeBlock151;
            UnicodeBlock unicodeBlock152 = new UnicodeBlock("LISU");
            LISU = unicodeBlock152;
            UnicodeBlock unicodeBlock153 = new UnicodeBlock("VAI");
            VAI = unicodeBlock153;
            UnicodeBlock unicodeBlock154 = new UnicodeBlock("CYRILLIC_EXTENDED_B", "CYRILLIC EXTENDED-B", "CYRILLICEXTENDED-B");
            CYRILLIC_EXTENDED_B = unicodeBlock154;
            UnicodeBlock unicodeBlock155 = new UnicodeBlock("BAMUM");
            BAMUM = unicodeBlock155;
            UnicodeBlock unicodeBlock156 = new UnicodeBlock("MODIFIER_TONE_LETTERS", "MODIFIER TONE LETTERS", "MODIFIERTONELETTERS");
            MODIFIER_TONE_LETTERS = unicodeBlock156;
            UnicodeBlock unicodeBlock157 = new UnicodeBlock("LATIN_EXTENDED_D", "LATIN EXTENDED-D", "LATINEXTENDED-D");
            LATIN_EXTENDED_D = unicodeBlock157;
            UnicodeBlock unicodeBlock158 = new UnicodeBlock("SYLOTI_NAGRI", "SYLOTI NAGRI", "SYLOTINAGRI");
            SYLOTI_NAGRI = unicodeBlock158;
            UnicodeBlock unicodeBlock159 = new UnicodeBlock("COMMON_INDIC_NUMBER_FORMS", "COMMON INDIC NUMBER FORMS", "COMMONINDICNUMBERFORMS");
            COMMON_INDIC_NUMBER_FORMS = unicodeBlock159;
            UnicodeBlock unicodeBlock160 = new UnicodeBlock("PHAGS_PA", "PHAGS-PA");
            PHAGS_PA = unicodeBlock160;
            UnicodeBlock unicodeBlock161 = new UnicodeBlock("SAURASHTRA");
            SAURASHTRA = unicodeBlock161;
            UnicodeBlock unicodeBlock162 = new UnicodeBlock("DEVANAGARI_EXTENDED", "DEVANAGARI EXTENDED", "DEVANAGARIEXTENDED");
            DEVANAGARI_EXTENDED = unicodeBlock162;
            UnicodeBlock unicodeBlock163 = new UnicodeBlock("KAYAH_LI", "KAYAH LI", "KAYAHLI");
            KAYAH_LI = unicodeBlock163;
            UnicodeBlock unicodeBlock164 = new UnicodeBlock("REJANG");
            REJANG = unicodeBlock164;
            UnicodeBlock unicodeBlock165 = new UnicodeBlock("HANGUL_JAMO_EXTENDED_A", "HANGUL JAMO EXTENDED-A", "HANGULJAMOEXTENDED-A");
            HANGUL_JAMO_EXTENDED_A = unicodeBlock165;
            UnicodeBlock unicodeBlock166 = new UnicodeBlock("JAVANESE");
            JAVANESE = unicodeBlock166;
            UnicodeBlock unicodeBlock167 = new UnicodeBlock("CHAM");
            CHAM = unicodeBlock167;
            UnicodeBlock unicodeBlock168 = new UnicodeBlock("MYANMAR_EXTENDED_A", "MYANMAR EXTENDED-A", "MYANMAREXTENDED-A");
            MYANMAR_EXTENDED_A = unicodeBlock168;
            UnicodeBlock unicodeBlock169 = new UnicodeBlock("TAI_VIET", "TAI VIET", "TAIVIET");
            TAI_VIET = unicodeBlock169;
            UnicodeBlock unicodeBlock170 = new UnicodeBlock("ETHIOPIC_EXTENDED_A", "ETHIOPIC EXTENDED-A", "ETHIOPICEXTENDED-A");
            ETHIOPIC_EXTENDED_A = unicodeBlock170;
            UnicodeBlock unicodeBlock171 = new UnicodeBlock("MEETEI_MAYEK", "MEETEI MAYEK", "MEETEIMAYEK");
            MEETEI_MAYEK = unicodeBlock171;
            UnicodeBlock unicodeBlock172 = new UnicodeBlock("HANGUL_JAMO_EXTENDED_B", "HANGUL JAMO EXTENDED-B", "HANGULJAMOEXTENDED-B");
            HANGUL_JAMO_EXTENDED_B = unicodeBlock172;
            UnicodeBlock unicodeBlock173 = new UnicodeBlock("VERTICAL_FORMS", "VERTICAL FORMS", "VERTICALFORMS");
            VERTICAL_FORMS = unicodeBlock173;
            UnicodeBlock unicodeBlock174 = new UnicodeBlock("ANCIENT_GREEK_NUMBERS", "ANCIENT GREEK NUMBERS", "ANCIENTGREEKNUMBERS");
            ANCIENT_GREEK_NUMBERS = unicodeBlock174;
            UnicodeBlock unicodeBlock175 = new UnicodeBlock("ANCIENT_SYMBOLS", "ANCIENT SYMBOLS", "ANCIENTSYMBOLS");
            ANCIENT_SYMBOLS = unicodeBlock175;
            UnicodeBlock unicodeBlock176 = new UnicodeBlock("PHAISTOS_DISC", "PHAISTOS DISC", "PHAISTOSDISC");
            PHAISTOS_DISC = unicodeBlock176;
            UnicodeBlock unicodeBlock177 = new UnicodeBlock("LYCIAN");
            LYCIAN = unicodeBlock177;
            UnicodeBlock unicodeBlock178 = new UnicodeBlock("CARIAN");
            CARIAN = unicodeBlock178;
            UnicodeBlock unicodeBlock179 = new UnicodeBlock("OLD_PERSIAN", "OLD PERSIAN", "OLDPERSIAN");
            OLD_PERSIAN = unicodeBlock179;
            UnicodeBlock unicodeBlock180 = new UnicodeBlock("IMPERIAL_ARAMAIC", "IMPERIAL ARAMAIC", "IMPERIALARAMAIC");
            IMPERIAL_ARAMAIC = unicodeBlock180;
            UnicodeBlock unicodeBlock181 = new UnicodeBlock("PHOENICIAN");
            PHOENICIAN = unicodeBlock181;
            UnicodeBlock unicodeBlock182 = new UnicodeBlock("LYDIAN");
            LYDIAN = unicodeBlock182;
            UnicodeBlock unicodeBlock183 = new UnicodeBlock("KHAROSHTHI");
            KHAROSHTHI = unicodeBlock183;
            UnicodeBlock unicodeBlock184 = new UnicodeBlock("OLD_SOUTH_ARABIAN", "OLD SOUTH ARABIAN", "OLDSOUTHARABIAN");
            OLD_SOUTH_ARABIAN = unicodeBlock184;
            UnicodeBlock unicodeBlock185 = new UnicodeBlock("AVESTAN");
            AVESTAN = unicodeBlock185;
            UnicodeBlock unicodeBlock186 = new UnicodeBlock("INSCRIPTIONAL_PARTHIAN", "INSCRIPTIONAL PARTHIAN", "INSCRIPTIONALPARTHIAN");
            INSCRIPTIONAL_PARTHIAN = unicodeBlock186;
            UnicodeBlock unicodeBlock187 = new UnicodeBlock("INSCRIPTIONAL_PAHLAVI", "INSCRIPTIONAL PAHLAVI", "INSCRIPTIONALPAHLAVI");
            INSCRIPTIONAL_PAHLAVI = unicodeBlock187;
            UnicodeBlock unicodeBlock188 = new UnicodeBlock("OLD_TURKIC", "OLD TURKIC", "OLDTURKIC");
            OLD_TURKIC = unicodeBlock188;
            UnicodeBlock unicodeBlock189 = new UnicodeBlock("RUMI_NUMERAL_SYMBOLS", "RUMI NUMERAL SYMBOLS", "RUMINUMERALSYMBOLS");
            RUMI_NUMERAL_SYMBOLS = unicodeBlock189;
            UnicodeBlock unicodeBlock190 = new UnicodeBlock("BRAHMI");
            BRAHMI = unicodeBlock190;
            UnicodeBlock unicodeBlock191 = new UnicodeBlock("KAITHI");
            KAITHI = unicodeBlock191;
            UnicodeBlock unicodeBlock192 = new UnicodeBlock("CUNEIFORM");
            CUNEIFORM = unicodeBlock192;
            UnicodeBlock unicodeBlock193 = new UnicodeBlock("CUNEIFORM_NUMBERS_AND_PUNCTUATION", "CUNEIFORM NUMBERS AND PUNCTUATION", "CUNEIFORMNUMBERSANDPUNCTUATION");
            CUNEIFORM_NUMBERS_AND_PUNCTUATION = unicodeBlock193;
            UnicodeBlock unicodeBlock194 = new UnicodeBlock("EGYPTIAN_HIEROGLYPHS", "EGYPTIAN HIEROGLYPHS", "EGYPTIANHIEROGLYPHS");
            EGYPTIAN_HIEROGLYPHS = unicodeBlock194;
            UnicodeBlock unicodeBlock195 = new UnicodeBlock("BAMUM_SUPPLEMENT", "BAMUM SUPPLEMENT", "BAMUMSUPPLEMENT");
            BAMUM_SUPPLEMENT = unicodeBlock195;
            UnicodeBlock unicodeBlock196 = new UnicodeBlock("KANA_SUPPLEMENT", "KANA SUPPLEMENT", "KANASUPPLEMENT");
            KANA_SUPPLEMENT = unicodeBlock196;
            UnicodeBlock unicodeBlock197 = new UnicodeBlock("ANCIENT_GREEK_MUSICAL_NOTATION", "ANCIENT GREEK MUSICAL NOTATION", "ANCIENTGREEKMUSICALNOTATION");
            ANCIENT_GREEK_MUSICAL_NOTATION = unicodeBlock197;
            UnicodeBlock unicodeBlock198 = new UnicodeBlock("COUNTING_ROD_NUMERALS", "COUNTING ROD NUMERALS", "COUNTINGRODNUMERALS");
            COUNTING_ROD_NUMERALS = unicodeBlock198;
            UnicodeBlock unicodeBlock199 = new UnicodeBlock("MAHJONG_TILES", "MAHJONG TILES", "MAHJONGTILES");
            MAHJONG_TILES = unicodeBlock199;
            UnicodeBlock unicodeBlock200 = new UnicodeBlock("DOMINO_TILES", "DOMINO TILES", "DOMINOTILES");
            DOMINO_TILES = unicodeBlock200;
            UnicodeBlock unicodeBlock201 = new UnicodeBlock("PLAYING_CARDS", "PLAYING CARDS", "PLAYINGCARDS");
            PLAYING_CARDS = unicodeBlock201;
            UnicodeBlock unicodeBlock202 = new UnicodeBlock("ENCLOSED_ALPHANUMERIC_SUPPLEMENT", "ENCLOSED ALPHANUMERIC SUPPLEMENT", "ENCLOSEDALPHANUMERICSUPPLEMENT");
            ENCLOSED_ALPHANUMERIC_SUPPLEMENT = unicodeBlock202;
            UnicodeBlock unicodeBlock203 = new UnicodeBlock("ENCLOSED_IDEOGRAPHIC_SUPPLEMENT", "ENCLOSED IDEOGRAPHIC SUPPLEMENT", "ENCLOSEDIDEOGRAPHICSUPPLEMENT");
            ENCLOSED_IDEOGRAPHIC_SUPPLEMENT = unicodeBlock203;
            UnicodeBlock unicodeBlock204 = new UnicodeBlock("MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS", "MISCELLANEOUS SYMBOLS AND PICTOGRAPHS", "MISCELLANEOUSSYMBOLSANDPICTOGRAPHS");
            MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS = unicodeBlock204;
            UnicodeBlock unicodeBlock205 = new UnicodeBlock("EMOTICONS");
            EMOTICONS = unicodeBlock205;
            UnicodeBlock unicodeBlock206 = new UnicodeBlock("TRANSPORT_AND_MAP_SYMBOLS", "TRANSPORT AND MAP SYMBOLS", "TRANSPORTANDMAPSYMBOLS");
            TRANSPORT_AND_MAP_SYMBOLS = unicodeBlock206;
            UnicodeBlock unicodeBlock207 = new UnicodeBlock("ALCHEMICAL_SYMBOLS", "ALCHEMICAL SYMBOLS", "ALCHEMICALSYMBOLS");
            ALCHEMICAL_SYMBOLS = unicodeBlock207;
            UnicodeBlock unicodeBlock208 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C", "CJK UNIFIED IDEOGRAPHS EXTENSION C", "CJKUNIFIEDIDEOGRAPHSEXTENSIONC");
            CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C = unicodeBlock208;
            UnicodeBlock unicodeBlock209 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D", "CJK UNIFIED IDEOGRAPHS EXTENSION D", "CJKUNIFIEDIDEOGRAPHSEXTENSIOND");
            CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D = unicodeBlock209;
            UnicodeBlock unicodeBlock210 = new UnicodeBlock("ARABIC_EXTENDED_A", "ARABIC EXTENDED-A", "ARABICEXTENDED-A");
            ARABIC_EXTENDED_A = unicodeBlock210;
            UnicodeBlock unicodeBlock211 = new UnicodeBlock("SUNDANESE_SUPPLEMENT", "SUNDANESE SUPPLEMENT", "SUNDANESESUPPLEMENT");
            SUNDANESE_SUPPLEMENT = unicodeBlock211;
            UnicodeBlock unicodeBlock212 = new UnicodeBlock("MEETEI_MAYEK_EXTENSIONS", "MEETEI MAYEK EXTENSIONS", "MEETEIMAYEKEXTENSIONS");
            MEETEI_MAYEK_EXTENSIONS = unicodeBlock212;
            UnicodeBlock unicodeBlock213 = new UnicodeBlock("MEROITIC_HIEROGLYPHS", "MEROITIC HIEROGLYPHS", "MEROITICHIEROGLYPHS");
            MEROITIC_HIEROGLYPHS = unicodeBlock213;
            UnicodeBlock unicodeBlock214 = new UnicodeBlock("MEROITIC_CURSIVE", "MEROITIC CURSIVE", "MEROITICCURSIVE");
            MEROITIC_CURSIVE = unicodeBlock214;
            UnicodeBlock unicodeBlock215 = new UnicodeBlock("SORA_SOMPENG", "SORA SOMPENG", "SORASOMPENG");
            SORA_SOMPENG = unicodeBlock215;
            UnicodeBlock unicodeBlock216 = new UnicodeBlock("CHAKMA");
            CHAKMA = unicodeBlock216;
            UnicodeBlock unicodeBlock217 = new UnicodeBlock("SHARADA");
            SHARADA = unicodeBlock217;
            UnicodeBlock unicodeBlock218 = new UnicodeBlock("TAKRI");
            TAKRI = unicodeBlock218;
            UnicodeBlock unicodeBlock219 = new UnicodeBlock("MIAO");
            MIAO = unicodeBlock219;
            UnicodeBlock unicodeBlock220 = new UnicodeBlock("ARABIC_MATHEMATICAL_ALPHABETIC_SYMBOLS", "ARABIC MATHEMATICAL ALPHABETIC SYMBOLS", "ARABICMATHEMATICALALPHABETICSYMBOLS");
            ARABIC_MATHEMATICAL_ALPHABETIC_SYMBOLS = unicodeBlock220;
            UnicodeBlock unicodeBlock221 = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS_EXTENDED", "COMBINING DIACRITICAL MARKS EXTENDED", "COMBININGDIACRITICALMARKSEXTENDED");
            COMBINING_DIACRITICAL_MARKS_EXTENDED = unicodeBlock221;
            UnicodeBlock unicodeBlock222 = new UnicodeBlock("MYANMAR_EXTENDED_B", "MYANMAR EXTENDED-B", "MYANMAREXTENDED-B");
            MYANMAR_EXTENDED_B = unicodeBlock222;
            UnicodeBlock unicodeBlock223 = new UnicodeBlock("LATIN_EXTENDED_E", "LATIN EXTENDED-E", "LATINEXTENDED-E");
            LATIN_EXTENDED_E = unicodeBlock223;
            UnicodeBlock unicodeBlock224 = new UnicodeBlock("COPTIC_EPACT_NUMBERS", "COPTIC EPACT NUMBERS", "COPTICEPACTNUMBERS");
            COPTIC_EPACT_NUMBERS = unicodeBlock224;
            UnicodeBlock unicodeBlock225 = new UnicodeBlock("OLD_PERMIC", "OLD PERMIC", "OLDPERMIC");
            OLD_PERMIC = unicodeBlock225;
            UnicodeBlock unicodeBlock226 = new UnicodeBlock("ELBASAN");
            ELBASAN = unicodeBlock226;
            UnicodeBlock unicodeBlock227 = new UnicodeBlock("CAUCASIAN_ALBANIAN", "CAUCASIAN ALBANIAN", "CAUCASIANALBANIAN");
            CAUCASIAN_ALBANIAN = unicodeBlock227;
            UnicodeBlock unicodeBlock228 = new UnicodeBlock("LINEAR_A", "LINEAR A", "LINEARA");
            LINEAR_A = unicodeBlock228;
            UnicodeBlock unicodeBlock229 = new UnicodeBlock("PALMYRENE");
            PALMYRENE = unicodeBlock229;
            UnicodeBlock unicodeBlock230 = new UnicodeBlock("NABATAEAN");
            NABATAEAN = unicodeBlock230;
            UnicodeBlock unicodeBlock231 = new UnicodeBlock("OLD_NORTH_ARABIAN", "OLD NORTH ARABIAN", "OLDNORTHARABIAN");
            OLD_NORTH_ARABIAN = unicodeBlock231;
            UnicodeBlock unicodeBlock232 = new UnicodeBlock("MANICHAEAN");
            MANICHAEAN = unicodeBlock232;
            UnicodeBlock unicodeBlock233 = new UnicodeBlock("PSALTER_PAHLAVI", "PSALTER PAHLAVI", "PSALTERPAHLAVI");
            PSALTER_PAHLAVI = unicodeBlock233;
            UnicodeBlock unicodeBlock234 = new UnicodeBlock("MAHAJANI");
            MAHAJANI = unicodeBlock234;
            UnicodeBlock unicodeBlock235 = new UnicodeBlock("SINHALA_ARCHAIC_NUMBERS", "SINHALA ARCHAIC NUMBERS", "SINHALAARCHAICNUMBERS");
            SINHALA_ARCHAIC_NUMBERS = unicodeBlock235;
            UnicodeBlock unicodeBlock236 = new UnicodeBlock("KHOJKI");
            KHOJKI = unicodeBlock236;
            UnicodeBlock unicodeBlock237 = new UnicodeBlock("KHUDAWADI");
            KHUDAWADI = unicodeBlock237;
            UnicodeBlock unicodeBlock238 = new UnicodeBlock("GRANTHA");
            GRANTHA = unicodeBlock238;
            UnicodeBlock unicodeBlock239 = new UnicodeBlock("TIRHUTA");
            TIRHUTA = unicodeBlock239;
            UnicodeBlock unicodeBlock240 = new UnicodeBlock("SIDDHAM");
            SIDDHAM = unicodeBlock240;
            UnicodeBlock unicodeBlock241 = new UnicodeBlock("MODI");
            MODI = unicodeBlock241;
            UnicodeBlock unicodeBlock242 = new UnicodeBlock("WARANG_CITI", "WARANG CITI", "WARANGCITI");
            WARANG_CITI = unicodeBlock242;
            UnicodeBlock unicodeBlock243 = new UnicodeBlock("PAU_CIN_HAU", "PAU CIN HAU", "PAUCINHAU");
            PAU_CIN_HAU = unicodeBlock243;
            UnicodeBlock unicodeBlock244 = new UnicodeBlock("MRO");
            MRO = unicodeBlock244;
            UnicodeBlock unicodeBlock245 = new UnicodeBlock("BASSA_VAH", "BASSA VAH", "BASSAVAH");
            BASSA_VAH = unicodeBlock245;
            UnicodeBlock unicodeBlock246 = new UnicodeBlock("PAHAWH_HMONG", "PAHAWH HMONG", "PAHAWHHMONG");
            PAHAWH_HMONG = unicodeBlock246;
            UnicodeBlock unicodeBlock247 = new UnicodeBlock("DUPLOYAN");
            DUPLOYAN = unicodeBlock247;
            UnicodeBlock unicodeBlock248 = new UnicodeBlock("SHORTHAND_FORMAT_CONTROLS", "SHORTHAND FORMAT CONTROLS", "SHORTHANDFORMATCONTROLS");
            SHORTHAND_FORMAT_CONTROLS = unicodeBlock248;
            UnicodeBlock unicodeBlock249 = new UnicodeBlock("MENDE_KIKAKUI", "MENDE KIKAKUI", "MENDEKIKAKUI");
            MENDE_KIKAKUI = unicodeBlock249;
            UnicodeBlock unicodeBlock250 = new UnicodeBlock("ORNAMENTAL_DINGBATS", "ORNAMENTAL DINGBATS", "ORNAMENTALDINGBATS");
            ORNAMENTAL_DINGBATS = unicodeBlock250;
            UnicodeBlock unicodeBlock251 = new UnicodeBlock("GEOMETRIC_SHAPES_EXTENDED", "GEOMETRIC SHAPES EXTENDED", "GEOMETRICSHAPESEXTENDED");
            GEOMETRIC_SHAPES_EXTENDED = unicodeBlock251;
            UnicodeBlock unicodeBlock252 = new UnicodeBlock("SUPPLEMENTAL_ARROWS_C", "SUPPLEMENTAL ARROWS-C", "SUPPLEMENTALARROWS-C");
            SUPPLEMENTAL_ARROWS_C = unicodeBlock252;
            UnicodeBlock unicodeBlock253 = new UnicodeBlock("CHEROKEE_SUPPLEMENT", "CHEROKEE SUPPLEMENT", "CHEROKEESUPPLEMENT");
            CHEROKEE_SUPPLEMENT = unicodeBlock253;
            UnicodeBlock unicodeBlock254 = new UnicodeBlock("HATRAN");
            HATRAN = unicodeBlock254;
            UnicodeBlock unicodeBlock255 = new UnicodeBlock("OLD_HUNGARIAN", "OLD HUNGARIAN", "OLDHUNGARIAN");
            OLD_HUNGARIAN = unicodeBlock255;
            UnicodeBlock unicodeBlock256 = new UnicodeBlock("MULTANI");
            MULTANI = unicodeBlock256;
            UnicodeBlock unicodeBlock257 = new UnicodeBlock("AHOM");
            AHOM = unicodeBlock257;
            UnicodeBlock unicodeBlock258 = new UnicodeBlock("EARLY_DYNASTIC_CUNEIFORM", "EARLY DYNASTIC CUNEIFORM", "EARLYDYNASTICCUNEIFORM");
            EARLY_DYNASTIC_CUNEIFORM = unicodeBlock258;
            UnicodeBlock unicodeBlock259 = new UnicodeBlock("ANATOLIAN_HIEROGLYPHS", "ANATOLIAN HIEROGLYPHS", "ANATOLIANHIEROGLYPHS");
            ANATOLIAN_HIEROGLYPHS = unicodeBlock259;
            UnicodeBlock unicodeBlock260 = new UnicodeBlock("SUTTON_SIGNWRITING", "SUTTON SIGNWRITING", "SUTTONSIGNWRITING");
            SUTTON_SIGNWRITING = unicodeBlock260;
            UnicodeBlock unicodeBlock261 = new UnicodeBlock("SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS", "SUPPLEMENTAL SYMBOLS AND PICTOGRAPHS", "SUPPLEMENTALSYMBOLSANDPICTOGRAPHS");
            SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS = unicodeBlock261;
            UnicodeBlock unicodeBlock262 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_E", "CJK UNIFIED IDEOGRAPHS EXTENSION E", "CJKUNIFIEDIDEOGRAPHSEXTENSIONE");
            CJK_UNIFIED_IDEOGRAPHS_EXTENSION_E = unicodeBlock262;
            UnicodeBlock unicodeBlock263 = new UnicodeBlock("SYRIAC_SUPPLEMENT", "SYRIAC SUPPLEMENT", "SYRIACSUPPLEMENT");
            SYRIAC_SUPPLEMENT = unicodeBlock263;
            UnicodeBlock unicodeBlock264 = new UnicodeBlock("CYRILLIC_EXTENDED_C", "CYRILLIC EXTENDED-C", "CYRILLICEXTENDED-C");
            CYRILLIC_EXTENDED_C = unicodeBlock264;
            UnicodeBlock unicodeBlock265 = new UnicodeBlock("OSAGE");
            OSAGE = unicodeBlock265;
            UnicodeBlock unicodeBlock266 = new UnicodeBlock("NEWA");
            NEWA = unicodeBlock266;
            UnicodeBlock unicodeBlock267 = new UnicodeBlock("MONGOLIAN_SUPPLEMENT", "MONGOLIAN SUPPLEMENT", "MONGOLIANSUPPLEMENT");
            MONGOLIAN_SUPPLEMENT = unicodeBlock267;
            UnicodeBlock unicodeBlock268 = new UnicodeBlock("MARCHEN");
            MARCHEN = unicodeBlock268;
            UnicodeBlock unicodeBlock269 = new UnicodeBlock("IDEOGRAPHIC_SYMBOLS_AND_PUNCTUATION", "IDEOGRAPHIC SYMBOLS AND PUNCTUATION", "IDEOGRAPHICSYMBOLSANDPUNCTUATION");
            IDEOGRAPHIC_SYMBOLS_AND_PUNCTUATION = unicodeBlock269;
            UnicodeBlock unicodeBlock270 = new UnicodeBlock("TANGUT");
            TANGUT = unicodeBlock270;
            UnicodeBlock unicodeBlock271 = new UnicodeBlock("TANGUT_COMPONENTS", "TANGUT COMPONENTS", "TANGUTCOMPONENTS");
            TANGUT_COMPONENTS = unicodeBlock271;
            UnicodeBlock unicodeBlock272 = new UnicodeBlock("KANA_EXTENDED_A", "KANA EXTENDED-A", "KANAEXTENDED-A");
            KANA_EXTENDED_A = unicodeBlock272;
            UnicodeBlock unicodeBlock273 = new UnicodeBlock("GLAGOLITIC_SUPPLEMENT", "GLAGOLITIC SUPPLEMENT", "GLAGOLITICSUPPLEMENT");
            GLAGOLITIC_SUPPLEMENT = unicodeBlock273;
            UnicodeBlock unicodeBlock274 = new UnicodeBlock("ADLAM");
            ADLAM = unicodeBlock274;
            UnicodeBlock unicodeBlock275 = new UnicodeBlock("MASARAM_GONDI", "MASARAM GONDI", "MASARAMGONDI");
            MASARAM_GONDI = unicodeBlock275;
            UnicodeBlock unicodeBlock276 = new UnicodeBlock("ZANABAZAR_SQUARE", "ZANABAZAR SQUARE", "ZANABAZARSQUARE");
            ZANABAZAR_SQUARE = unicodeBlock276;
            UnicodeBlock unicodeBlock277 = new UnicodeBlock("NUSHU");
            NUSHU = unicodeBlock277;
            UnicodeBlock unicodeBlock278 = new UnicodeBlock("SOYOMBO");
            SOYOMBO = unicodeBlock278;
            UnicodeBlock unicodeBlock279 = new UnicodeBlock("BHAIKSUKI");
            BHAIKSUKI = unicodeBlock279;
            UnicodeBlock unicodeBlock280 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F", "CJK UNIFIED IDEOGRAPHS EXTENSION F", "CJKUNIFIEDIDEOGRAPHSEXTENSIONF");
            CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F = unicodeBlock280;
            UnicodeBlock unicodeBlock281 = new UnicodeBlock("GEORGIAN_EXTENDED", "GEORGIAN EXTENDED", "GEORGIANEXTENDED");
            GEORGIAN_EXTENDED = unicodeBlock281;
            UnicodeBlock unicodeBlock282 = new UnicodeBlock("HANIFI_ROHINGYA", "HANIFI ROHINGYA", "HANIFIROHINGYA");
            HANIFI_ROHINGYA = unicodeBlock282;
            UnicodeBlock unicodeBlock283 = new UnicodeBlock("OLD_SOGDIAN", "OLD SOGDIAN", "OLDSOGDIAN");
            OLD_SOGDIAN = unicodeBlock283;
            UnicodeBlock unicodeBlock284 = new UnicodeBlock("SOGDIAN");
            SOGDIAN = unicodeBlock284;
            UnicodeBlock unicodeBlock285 = new UnicodeBlock("DOGRA");
            DOGRA = unicodeBlock285;
            UnicodeBlock unicodeBlock286 = new UnicodeBlock("GUNJALA_GONDI", "GUNJALA GONDI", "GUNJALAGONDI");
            GUNJALA_GONDI = unicodeBlock286;
            UnicodeBlock unicodeBlock287 = new UnicodeBlock("MAKASAR");
            MAKASAR = unicodeBlock287;
            UnicodeBlock unicodeBlock288 = new UnicodeBlock("MEDEFAIDRIN");
            MEDEFAIDRIN = unicodeBlock288;
            UnicodeBlock unicodeBlock289 = new UnicodeBlock("MAYAN_NUMERALS", "MAYAN NUMERALS", "MAYANNUMERALS");
            MAYAN_NUMERALS = unicodeBlock289;
            UnicodeBlock unicodeBlock290 = new UnicodeBlock("INDIC_SIYAQ_NUMBERS", "INDIC SIYAQ NUMBERS", "INDICSIYAQNUMBERS");
            INDIC_SIYAQ_NUMBERS = unicodeBlock290;
            UnicodeBlock unicodeBlock291 = new UnicodeBlock("CHESS_SYMBOLS", "CHESS SYMBOLS", "CHESSSYMBOLS");
            CHESS_SYMBOLS = unicodeBlock291;
            UnicodeBlock unicodeBlock292 = new UnicodeBlock("ELYMAIC");
            ELYMAIC = unicodeBlock292;
            UnicodeBlock unicodeBlock293 = new UnicodeBlock("NANDINAGARI");
            NANDINAGARI = unicodeBlock293;
            UnicodeBlock unicodeBlock294 = new UnicodeBlock("TAMIL_SUPPLEMENT", "TAMIL SUPPLEMENT", "TAMILSUPPLEMENT");
            TAMIL_SUPPLEMENT = unicodeBlock294;
            UnicodeBlock unicodeBlock295 = new UnicodeBlock("EGYPTIAN_HIEROGLYPH_FORMAT_CONTROLS", "EGYPTIAN HIEROGLYPH FORMAT CONTROLS", "EGYPTIANHIEROGLYPHFORMATCONTROLS");
            EGYPTIAN_HIEROGLYPH_FORMAT_CONTROLS = unicodeBlock295;
            UnicodeBlock unicodeBlock296 = new UnicodeBlock("SMALL_KANA_EXTENSION", "SMALL KANA EXTENSION", "SMALLKANAEXTENSION");
            SMALL_KANA_EXTENSION = unicodeBlock296;
            UnicodeBlock unicodeBlock297 = new UnicodeBlock("NYIAKENG_PUACHUE_HMONG", "NYIAKENG PUACHUE HMONG", "NYIAKENGPUACHUEHMONG");
            NYIAKENG_PUACHUE_HMONG = unicodeBlock297;
            UnicodeBlock unicodeBlock298 = new UnicodeBlock("WANCHO");
            WANCHO = unicodeBlock298;
            UnicodeBlock unicodeBlock299 = new UnicodeBlock("OTTOMAN_SIYAQ_NUMBERS", "OTTOMAN SIYAQ NUMBERS", "OTTOMANSIYAQNUMBERS");
            OTTOMAN_SIYAQ_NUMBERS = unicodeBlock299;
            UnicodeBlock unicodeBlock300 = new UnicodeBlock("SYMBOLS_AND_PICTOGRAPHS_EXTENDED_A", "SYMBOLS AND PICTOGRAPHS EXTENDED-A", "SYMBOLSANDPICTOGRAPHSEXTENDED-A");
            SYMBOLS_AND_PICTOGRAPHS_EXTENDED_A = unicodeBlock300;
            UnicodeBlock unicodeBlock301 = new UnicodeBlock("YEZIDI");
            YEZIDI = unicodeBlock301;
            UnicodeBlock unicodeBlock302 = new UnicodeBlock("CHORASMIAN");
            CHORASMIAN = unicodeBlock302;
            UnicodeBlock unicodeBlock303 = new UnicodeBlock("DIVES_AKURU", "DIVES AKURU", "DIVESAKURU");
            DIVES_AKURU = unicodeBlock303;
            UnicodeBlock unicodeBlock304 = new UnicodeBlock("LISU_SUPPLEMENT", "LISU SUPPLEMENT", "LISUSUPPLEMENT");
            LISU_SUPPLEMENT = unicodeBlock304;
            UnicodeBlock unicodeBlock305 = new UnicodeBlock("KHITAN_SMALL_SCRIPT", "KHITAN SMALL SCRIPT", "KHITANSMALLSCRIPT");
            KHITAN_SMALL_SCRIPT = unicodeBlock305;
            UnicodeBlock unicodeBlock306 = new UnicodeBlock("TANGUT_SUPPLEMENT", "TANGUT SUPPLEMENT", "TANGUTSUPPLEMENT");
            TANGUT_SUPPLEMENT = unicodeBlock306;
            UnicodeBlock unicodeBlock307 = new UnicodeBlock("SYMBOLS_FOR_LEGACY_COMPUTING", "SYMBOLS FOR LEGACY COMPUTING", "SYMBOLSFORLEGACYCOMPUTING");
            SYMBOLS_FOR_LEGACY_COMPUTING = unicodeBlock307;
            UnicodeBlock unicodeBlock308 = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_G", "CJK UNIFIED IDEOGRAPHS EXTENSION G", "CJKUNIFIEDIDEOGRAPHSEXTENSIONG");
            CJK_UNIFIED_IDEOGRAPHS_EXTENSION_G = unicodeBlock308;
            blockStarts = new int[]{0, 128, 256, 384, MetricsProto.MetricsEvent.DIALOG_USER_ENABLE_CALLING, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_ADD_VOICEMAIL, 768, MetricsProto.MetricsEvent.FIELD_SETTINGS_SEARCH_INLINE_RESULT_VALUE, 1024, 1280, MetricsProto.MetricsEvent.ACTION_PANEL_VIEW_EXPAND, MetricsProto.MetricsEvent.ACTION_USB_AUDIO_CONNECTED, 1536, 1792, 1872, 1920, 1984, 2048, 2112, 2144, 2160, SecExceptionCode.SEC_ERROR_LBSRISK_GET_WUA_FAILED, 2304, 2432, 2560, 2688, 2816, 2944, 3072, 3200, 3328, 3456, 3584, 3712, 3840, 4096, 4256, 4352, 4608, 4992, ErrorCode.METHOD_CALL_ERROR, 5120, 5760, 5792, 5888, 5920, 5952, 5984, 6016, 6144, 6320, 6400, 6480, 6528, 6624, Constants.CODE_REQUEST_MAX, 6688, 6832, 6912, 7040, 7104, 7168, 7248, 7296, 7312, 7360, 7376, 7424, 7552, 7616, 7680, 7936, 8192, 8304, 8352, 8400, 8448, 8528, 8592, 8704, 8960, 9216, 9280, 9312, 9472, 9600, 9632, 9728, 9984, 10176, 10224, 10240, 10496, 10624, 10752, 11008, 11264, 11360, 11392, 11520, 11568, 11648, 11744, 11776, 11904, 12032, 12256, 12272, Zygote.API_ENFORCEMENT_POLICY_MASK, 12352, 12448, 12544, 12592, 12688, 12704, 12736, 12784, 12800, 13056, 13312, 19904, 19968, 40960, 42128, 42192, 42240, 42560, 42656, 42752, 42784, 43008, 43056, 43072, 43136, 43232, 43264, 43312, 43360, 43392, 43488, 43520, 43616, 43648, 43744, 43776, 43824, 43888, 43968, 44032, 55216, 55296, 56192, Utf8.LOG_SURROGATE_HEADER, 57344, 63744, 64256, 64336, 65024, 65040, 65056, 65072, 65104, 65136, 65280, 65520, 65536, 65664, 65792, 65856, 65936, 66000, 66048, 66176, 66208, 66272, 66304, 66352, 66384, 66432, 66464, 66528, 66560, 66640, 66688, 66736, 66816, 66864, 66928, 67072, 67456, 67584, 67648, 67680, 67712, 67760, 67808, 67840, 67872, 67904, 67968, 68000, 68096, 68192, 68224, 68256, 68288, 68352, 68416, 68448, 68480, 68528, 68608, 68688, 68736, 68864, 68928, 69216, 69248, 69312, 69376, 69424, 69488, 69552, 69600, 69632, 69760, 69840, 69888, 69968, 70016, 70112, 70144, 70224, 70272, 70320, 70400, 70528, 70656, 70784, 70880, 71040, 71168, 71264, 71296, 71376, 71424, 71488, 71680, 71760, 71840, 71936, 72032, 72096, 72192, 72272, 72368, 72384, 72448, 72704, 72816, 72896, 72960, 73056, 73136, 73440, 73472, 73648, 73664, 73728, 74752, 74880, 75088, 77824, 78896, 78912, 82944, 83584, 92160, 92736, 92784, 92880, 92928, 93072, 93760, 93856, 93952, 94112, 94176, 94208, 100352, 101120, 101632, 101776, 110592, 110848, 110896, 110960, 111360, 113664, 113824, 113840, 118784, 119040, 119296, 119376, 119520, 119552, 119648, 119680, 119808, 120832, 121520, 122880, 122928, 123136, 123216, 123584, 123648, 124928, 125152, 125184, 125280, 126064, 126144, 126208, 126288, 126464, 126720, 126976, 127024, 127136, 127232, 127488, 127744, 128512, 128592, 128640, 128768, 128896, 129024, 129280, 129536, 129648, 129792, 130048, 131072, 173792, 173824, 177984, 178208, 183984, 191472, 194560, 195104, 196608, 201552, 917504, 917632, 917760, 918000, SurfaceControl.FX_SURFACE_MASK, 1048576};
            blocks = new UnicodeBlock[]{unicodeBlock, unicodeBlock2, unicodeBlock3, unicodeBlock4, unicodeBlock5, unicodeBlock6, unicodeBlock7, unicodeBlock8, unicodeBlock9, unicodeBlock85, unicodeBlock10, unicodeBlock11, unicodeBlock12, unicodeBlock66, unicodeBlock126, unicodeBlock67, unicodeBlock127, unicodeBlock128, unicodeBlock129, unicodeBlock263, null, unicodeBlock210, unicodeBlock13, unicodeBlock14, unicodeBlock15, unicodeBlock16, unicodeBlock17, unicodeBlock18, unicodeBlock19, unicodeBlock20, unicodeBlock21, unicodeBlock68, unicodeBlock22, unicodeBlock23, unicodeBlock24, unicodeBlock69, unicodeBlock25, unicodeBlock26, unicodeBlock70, unicodeBlock130, unicodeBlock71, unicodeBlock72, unicodeBlock73, unicodeBlock74, unicodeBlock86, unicodeBlock87, unicodeBlock88, unicodeBlock89, unicodeBlock75, unicodeBlock76, unicodeBlock131, unicodeBlock90, unicodeBlock91, unicodeBlock132, unicodeBlock92, unicodeBlock133, unicodeBlock134, unicodeBlock221, unicodeBlock135, unicodeBlock136, unicodeBlock137, unicodeBlock138, unicodeBlock139, unicodeBlock264, unicodeBlock281, unicodeBlock211, unicodeBlock140, unicodeBlock93, unicodeBlock141, unicodeBlock142, unicodeBlock27, unicodeBlock28, unicodeBlock29, unicodeBlock30, unicodeBlock31, unicodeBlock32, unicodeBlock33, unicodeBlock34, unicodeBlock35, unicodeBlock36, unicodeBlock37, unicodeBlock38, unicodeBlock39, unicodeBlock40, unicodeBlock41, unicodeBlock42, unicodeBlock43, unicodeBlock44, unicodeBlock45, unicodeBlock94, unicodeBlock95, unicodeBlock77, unicodeBlock96, unicodeBlock97, unicodeBlock98, unicodeBlock99, unicodeBlock143, unicodeBlock144, unicodeBlock145, unicodeBlock146, unicodeBlock147, unicodeBlock148, unicodeBlock149, unicodeBlock150, unicodeBlock78, unicodeBlock79, null, unicodeBlock80, unicodeBlock46, unicodeBlock47, unicodeBlock48, unicodeBlock49, unicodeBlock50, unicodeBlock51, unicodeBlock81, unicodeBlock151, unicodeBlock100, unicodeBlock52, unicodeBlock53, unicodeBlock82, unicodeBlock101, unicodeBlock54, unicodeBlock83, unicodeBlock84, unicodeBlock152, unicodeBlock153, unicodeBlock154, unicodeBlock155, unicodeBlock156, unicodeBlock157, unicodeBlock158, unicodeBlock159, unicodeBlock160, unicodeBlock161, unicodeBlock162, unicodeBlock163, unicodeBlock164, unicodeBlock165, unicodeBlock166, unicodeBlock222, unicodeBlock167, unicodeBlock168, unicodeBlock169, unicodeBlock212, unicodeBlock170, unicodeBlock223, unicodeBlock253, unicodeBlock171, unicodeBlock55, unicodeBlock172, unicodeBlock123, unicodeBlock124, unicodeBlock125, unicodeBlock56, unicodeBlock57, unicodeBlock58, unicodeBlock59, unicodeBlock102, unicodeBlock173, unicodeBlock60, unicodeBlock61, unicodeBlock62, unicodeBlock63, unicodeBlock64, unicodeBlock65, unicodeBlock103, unicodeBlock104, unicodeBlock105, unicodeBlock174, unicodeBlock175, unicodeBlock176, null, unicodeBlock177, unicodeBlock178, unicodeBlock224, unicodeBlock106, unicodeBlock107, unicodeBlock225, unicodeBlock108, unicodeBlock179, null, unicodeBlock109, unicodeBlock110, unicodeBlock111, unicodeBlock265, unicodeBlock226, unicodeBlock227, null, unicodeBlock228, null, unicodeBlock112, unicodeBlock180, unicodeBlock229, unicodeBlock230, null, unicodeBlock254, unicodeBlock181, unicodeBlock182, null, unicodeBlock213, unicodeBlock214, unicodeBlock183, unicodeBlock184, unicodeBlock231, null, unicodeBlock232, unicodeBlock185, unicodeBlock186, unicodeBlock187, unicodeBlock233, null, unicodeBlock188, null, unicodeBlock255, unicodeBlock282, null, unicodeBlock189, unicodeBlock301, null, unicodeBlock283, unicodeBlock284, null, unicodeBlock302, unicodeBlock292, unicodeBlock190, unicodeBlock191, unicodeBlock215, unicodeBlock216, unicodeBlock234, unicodeBlock217, unicodeBlock235, unicodeBlock236, null, unicodeBlock256, unicodeBlock237, unicodeBlock238, null, unicodeBlock266, unicodeBlock239, null, unicodeBlock240, unicodeBlock241, unicodeBlock267, unicodeBlock218, null, unicodeBlock257, null, unicodeBlock285, null, unicodeBlock242, unicodeBlock303, null, unicodeBlock293, unicodeBlock276, unicodeBlock278, null, unicodeBlock243, null, unicodeBlock279, unicodeBlock268, null, unicodeBlock275, unicodeBlock286, null, unicodeBlock287, null, unicodeBlock304, unicodeBlock294, unicodeBlock192, unicodeBlock193, unicodeBlock258, null, unicodeBlock194, unicodeBlock295, null, unicodeBlock259, null, unicodeBlock195, unicodeBlock244, null, unicodeBlock245, unicodeBlock246, null, unicodeBlock288, null, unicodeBlock219, null, unicodeBlock269, unicodeBlock270, unicodeBlock271, unicodeBlock305, unicodeBlock306, null, unicodeBlock196, unicodeBlock272, unicodeBlock296, unicodeBlock277, null, unicodeBlock247, unicodeBlock248, null, unicodeBlock113, unicodeBlock114, unicodeBlock197, null, unicodeBlock289, unicodeBlock115, unicodeBlock198, null, unicodeBlock116, unicodeBlock260, null, unicodeBlock273, null, unicodeBlock297, null, unicodeBlock298, null, unicodeBlock249, null, unicodeBlock274, null, unicodeBlock290, null, unicodeBlock299, null, unicodeBlock220, null, unicodeBlock199, unicodeBlock200, unicodeBlock201, unicodeBlock202, unicodeBlock203, unicodeBlock204, unicodeBlock205, unicodeBlock250, unicodeBlock206, unicodeBlock207, unicodeBlock251, unicodeBlock252, unicodeBlock261, unicodeBlock291, unicodeBlock300, unicodeBlock307, null, unicodeBlock117, null, unicodeBlock208, unicodeBlock209, unicodeBlock262, unicodeBlock280, null, unicodeBlock118, null, unicodeBlock308, null, unicodeBlock119, null, unicodeBlock120, null, unicodeBlock121, unicodeBlock122};
        }

        private UnicodeBlock(String idName) {
            super(idName);
            map.put(idName, this);
        }

        private UnicodeBlock(String idName, boolean isMap) {
            super(idName);
            if (isMap) {
                map.put(idName, this);
            }
        }

        private UnicodeBlock(String idName, String alias) {
            this(idName);
            map.put(alias, this);
        }

        private UnicodeBlock(String idName, String... aliases) {
            this(idName);
            for (String alias : aliases) {
                map.put(alias, this);
            }
        }

        public static UnicodeBlock of(char c4) {
            return of((int) c4);
        }

        public static UnicodeBlock of(int codePoint) {
            if (!Character.isValidCodePoint(codePoint)) {
                throw new IllegalArgumentException(String.format("Not a valid Unicode code point: 0x%X", Integer.valueOf(codePoint)));
            }
            int bottom = 0;
            int top = blockStarts.length;
            int current = top / 2;
            while (top - bottom > 1) {
                if (codePoint >= blockStarts[current]) {
                    bottom = current;
                } else {
                    top = current;
                }
                current = (top + bottom) / 2;
            }
            return blocks[current];
        }

        public static final UnicodeBlock forName(String blockName) {
            UnicodeBlock block = map.get(blockName.toUpperCase(Locale.US));
            if (block == null) {
                throw new IllegalArgumentException("Not a valid block name: " + blockName);
            }
            return block;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum UnicodeScript {
        COMMON,
        LATIN,
        GREEK,
        CYRILLIC,
        ARMENIAN,
        HEBREW,
        ARABIC,
        SYRIAC,
        THAANA,
        DEVANAGARI,
        BENGALI,
        GURMUKHI,
        GUJARATI,
        ORIYA,
        TAMIL,
        TELUGU,
        KANNADA,
        MALAYALAM,
        SINHALA,
        THAI,
        LAO,
        TIBETAN,
        MYANMAR,
        GEORGIAN,
        HANGUL,
        ETHIOPIC,
        CHEROKEE,
        CANADIAN_ABORIGINAL,
        OGHAM,
        RUNIC,
        KHMER,
        MONGOLIAN,
        HIRAGANA,
        KATAKANA,
        BOPOMOFO,
        HAN,
        YI,
        OLD_ITALIC,
        GOTHIC,
        DESERET,
        INHERITED,
        TAGALOG,
        HANUNOO,
        BUHID,
        TAGBANWA,
        LIMBU,
        TAI_LE,
        LINEAR_B,
        UGARITIC,
        SHAVIAN,
        OSMANYA,
        CYPRIOT,
        BRAILLE,
        BUGINESE,
        COPTIC,
        NEW_TAI_LUE,
        GLAGOLITIC,
        TIFINAGH,
        SYLOTI_NAGRI,
        OLD_PERSIAN,
        KHAROSHTHI,
        BALINESE,
        CUNEIFORM,
        PHOENICIAN,
        PHAGS_PA,
        NKO,
        SUNDANESE,
        BATAK,
        LEPCHA,
        OL_CHIKI,
        VAI,
        SAURASHTRA,
        KAYAH_LI,
        REJANG,
        LYCIAN,
        CARIAN,
        LYDIAN,
        CHAM,
        TAI_THAM,
        TAI_VIET,
        AVESTAN,
        EGYPTIAN_HIEROGLYPHS,
        SAMARITAN,
        MANDAIC,
        LISU,
        BAMUM,
        JAVANESE,
        MEETEI_MAYEK,
        IMPERIAL_ARAMAIC,
        OLD_SOUTH_ARABIAN,
        INSCRIPTIONAL_PARTHIAN,
        INSCRIPTIONAL_PAHLAVI,
        OLD_TURKIC,
        BRAHMI,
        KAITHI,
        MEROITIC_HIEROGLYPHS,
        MEROITIC_CURSIVE,
        SORA_SOMPENG,
        CHAKMA,
        SHARADA,
        TAKRI,
        MIAO,
        CAUCASIAN_ALBANIAN,
        BASSA_VAH,
        DUPLOYAN,
        ELBASAN,
        GRANTHA,
        PAHAWH_HMONG,
        KHOJKI,
        LINEAR_A,
        MAHAJANI,
        MANICHAEAN,
        MENDE_KIKAKUI,
        MODI,
        MRO,
        OLD_NORTH_ARABIAN,
        NABATAEAN,
        PALMYRENE,
        PAU_CIN_HAU,
        OLD_PERMIC,
        PSALTER_PAHLAVI,
        SIDDHAM,
        KHUDAWADI,
        TIRHUTA,
        WARANG_CITI,
        AHOM,
        ANATOLIAN_HIEROGLYPHS,
        HATRAN,
        MULTANI,
        OLD_HUNGARIAN,
        SIGNWRITING,
        ADLAM,
        BHAIKSUKI,
        MARCHEN,
        NEWA,
        OSAGE,
        TANGUT,
        MASARAM_GONDI,
        NUSHU,
        SOYOMBO,
        ZANABAZAR_SQUARE,
        HANIFI_ROHINGYA,
        OLD_SOGDIAN,
        SOGDIAN,
        DOGRA,
        GUNJALA_GONDI,
        MAKASAR,
        MEDEFAIDRIN,
        ELYMAIC,
        NANDINAGARI,
        NYIAKENG_PUACHUE_HMONG,
        WANCHO,
        YEZIDI,
        CHORASMIAN,
        DIVES_AKURU,
        KHITAN_SMALL_SCRIPT,
        UNKNOWN;

        private static final HashMap<String, UnicodeScript> aliases;
        private static final int[] scriptStarts;
        private static final UnicodeScript[] scripts;

        static {
            UnicodeScript unicodeScript = COMMON;
            UnicodeScript unicodeScript2 = LATIN;
            UnicodeScript unicodeScript3 = GREEK;
            UnicodeScript unicodeScript4 = CYRILLIC;
            UnicodeScript unicodeScript5 = ARMENIAN;
            UnicodeScript unicodeScript6 = HEBREW;
            UnicodeScript unicodeScript7 = ARABIC;
            UnicodeScript unicodeScript8 = SYRIAC;
            UnicodeScript unicodeScript9 = THAANA;
            UnicodeScript unicodeScript10 = DEVANAGARI;
            UnicodeScript unicodeScript11 = BENGALI;
            UnicodeScript unicodeScript12 = GURMUKHI;
            UnicodeScript unicodeScript13 = GUJARATI;
            UnicodeScript unicodeScript14 = ORIYA;
            UnicodeScript unicodeScript15 = TAMIL;
            UnicodeScript unicodeScript16 = TELUGU;
            UnicodeScript unicodeScript17 = KANNADA;
            UnicodeScript unicodeScript18 = MALAYALAM;
            UnicodeScript unicodeScript19 = SINHALA;
            UnicodeScript unicodeScript20 = THAI;
            UnicodeScript unicodeScript21 = LAO;
            UnicodeScript unicodeScript22 = TIBETAN;
            UnicodeScript unicodeScript23 = MYANMAR;
            UnicodeScript unicodeScript24 = GEORGIAN;
            UnicodeScript unicodeScript25 = HANGUL;
            UnicodeScript unicodeScript26 = ETHIOPIC;
            UnicodeScript unicodeScript27 = CHEROKEE;
            UnicodeScript unicodeScript28 = CANADIAN_ABORIGINAL;
            UnicodeScript unicodeScript29 = OGHAM;
            UnicodeScript unicodeScript30 = RUNIC;
            UnicodeScript unicodeScript31 = KHMER;
            UnicodeScript unicodeScript32 = MONGOLIAN;
            UnicodeScript unicodeScript33 = HIRAGANA;
            UnicodeScript unicodeScript34 = KATAKANA;
            UnicodeScript unicodeScript35 = BOPOMOFO;
            UnicodeScript unicodeScript36 = HAN;
            UnicodeScript unicodeScript37 = YI;
            UnicodeScript unicodeScript38 = OLD_ITALIC;
            UnicodeScript unicodeScript39 = GOTHIC;
            UnicodeScript unicodeScript40 = DESERET;
            UnicodeScript unicodeScript41 = INHERITED;
            UnicodeScript unicodeScript42 = TAGALOG;
            UnicodeScript unicodeScript43 = HANUNOO;
            UnicodeScript unicodeScript44 = BUHID;
            UnicodeScript unicodeScript45 = TAGBANWA;
            UnicodeScript unicodeScript46 = LIMBU;
            UnicodeScript unicodeScript47 = TAI_LE;
            UnicodeScript unicodeScript48 = LINEAR_B;
            UnicodeScript unicodeScript49 = UGARITIC;
            UnicodeScript unicodeScript50 = SHAVIAN;
            UnicodeScript unicodeScript51 = OSMANYA;
            UnicodeScript unicodeScript52 = CYPRIOT;
            UnicodeScript unicodeScript53 = BRAILLE;
            UnicodeScript unicodeScript54 = BUGINESE;
            UnicodeScript unicodeScript55 = COPTIC;
            UnicodeScript unicodeScript56 = NEW_TAI_LUE;
            UnicodeScript unicodeScript57 = GLAGOLITIC;
            UnicodeScript unicodeScript58 = TIFINAGH;
            UnicodeScript unicodeScript59 = SYLOTI_NAGRI;
            UnicodeScript unicodeScript60 = OLD_PERSIAN;
            UnicodeScript unicodeScript61 = KHAROSHTHI;
            UnicodeScript unicodeScript62 = BALINESE;
            UnicodeScript unicodeScript63 = CUNEIFORM;
            UnicodeScript unicodeScript64 = PHOENICIAN;
            UnicodeScript unicodeScript65 = PHAGS_PA;
            UnicodeScript unicodeScript66 = NKO;
            UnicodeScript unicodeScript67 = SUNDANESE;
            UnicodeScript unicodeScript68 = BATAK;
            UnicodeScript unicodeScript69 = LEPCHA;
            UnicodeScript unicodeScript70 = OL_CHIKI;
            UnicodeScript unicodeScript71 = VAI;
            UnicodeScript unicodeScript72 = SAURASHTRA;
            UnicodeScript unicodeScript73 = KAYAH_LI;
            UnicodeScript unicodeScript74 = REJANG;
            UnicodeScript unicodeScript75 = LYCIAN;
            UnicodeScript unicodeScript76 = CARIAN;
            UnicodeScript unicodeScript77 = LYDIAN;
            UnicodeScript unicodeScript78 = CHAM;
            UnicodeScript unicodeScript79 = TAI_THAM;
            UnicodeScript unicodeScript80 = TAI_VIET;
            UnicodeScript unicodeScript81 = AVESTAN;
            UnicodeScript unicodeScript82 = EGYPTIAN_HIEROGLYPHS;
            UnicodeScript unicodeScript83 = SAMARITAN;
            UnicodeScript unicodeScript84 = MANDAIC;
            UnicodeScript unicodeScript85 = LISU;
            UnicodeScript unicodeScript86 = BAMUM;
            UnicodeScript unicodeScript87 = JAVANESE;
            UnicodeScript unicodeScript88 = MEETEI_MAYEK;
            UnicodeScript unicodeScript89 = IMPERIAL_ARAMAIC;
            UnicodeScript unicodeScript90 = OLD_SOUTH_ARABIAN;
            UnicodeScript unicodeScript91 = INSCRIPTIONAL_PARTHIAN;
            UnicodeScript unicodeScript92 = INSCRIPTIONAL_PAHLAVI;
            UnicodeScript unicodeScript93 = OLD_TURKIC;
            UnicodeScript unicodeScript94 = BRAHMI;
            UnicodeScript unicodeScript95 = KAITHI;
            UnicodeScript unicodeScript96 = MEROITIC_HIEROGLYPHS;
            UnicodeScript unicodeScript97 = MEROITIC_CURSIVE;
            UnicodeScript unicodeScript98 = SORA_SOMPENG;
            UnicodeScript unicodeScript99 = CHAKMA;
            UnicodeScript unicodeScript100 = SHARADA;
            UnicodeScript unicodeScript101 = TAKRI;
            UnicodeScript unicodeScript102 = MIAO;
            UnicodeScript unicodeScript103 = CAUCASIAN_ALBANIAN;
            UnicodeScript unicodeScript104 = BASSA_VAH;
            UnicodeScript unicodeScript105 = DUPLOYAN;
            UnicodeScript unicodeScript106 = ELBASAN;
            UnicodeScript unicodeScript107 = GRANTHA;
            UnicodeScript unicodeScript108 = PAHAWH_HMONG;
            UnicodeScript unicodeScript109 = KHOJKI;
            UnicodeScript unicodeScript110 = LINEAR_A;
            UnicodeScript unicodeScript111 = MAHAJANI;
            UnicodeScript unicodeScript112 = MANICHAEAN;
            UnicodeScript unicodeScript113 = MENDE_KIKAKUI;
            UnicodeScript unicodeScript114 = MODI;
            UnicodeScript unicodeScript115 = MRO;
            UnicodeScript unicodeScript116 = OLD_NORTH_ARABIAN;
            UnicodeScript unicodeScript117 = NABATAEAN;
            UnicodeScript unicodeScript118 = PALMYRENE;
            UnicodeScript unicodeScript119 = PAU_CIN_HAU;
            UnicodeScript unicodeScript120 = OLD_PERMIC;
            UnicodeScript unicodeScript121 = PSALTER_PAHLAVI;
            UnicodeScript unicodeScript122 = SIDDHAM;
            UnicodeScript unicodeScript123 = KHUDAWADI;
            UnicodeScript unicodeScript124 = TIRHUTA;
            UnicodeScript unicodeScript125 = WARANG_CITI;
            UnicodeScript unicodeScript126 = AHOM;
            UnicodeScript unicodeScript127 = ANATOLIAN_HIEROGLYPHS;
            UnicodeScript unicodeScript128 = HATRAN;
            UnicodeScript unicodeScript129 = MULTANI;
            UnicodeScript unicodeScript130 = OLD_HUNGARIAN;
            UnicodeScript unicodeScript131 = SIGNWRITING;
            UnicodeScript unicodeScript132 = ADLAM;
            UnicodeScript unicodeScript133 = BHAIKSUKI;
            UnicodeScript unicodeScript134 = MARCHEN;
            UnicodeScript unicodeScript135 = NEWA;
            UnicodeScript unicodeScript136 = OSAGE;
            UnicodeScript unicodeScript137 = TANGUT;
            UnicodeScript unicodeScript138 = MASARAM_GONDI;
            UnicodeScript unicodeScript139 = NUSHU;
            UnicodeScript unicodeScript140 = SOYOMBO;
            UnicodeScript unicodeScript141 = ZANABAZAR_SQUARE;
            UnicodeScript unicodeScript142 = HANIFI_ROHINGYA;
            UnicodeScript unicodeScript143 = OLD_SOGDIAN;
            UnicodeScript unicodeScript144 = SOGDIAN;
            UnicodeScript unicodeScript145 = DOGRA;
            UnicodeScript unicodeScript146 = GUNJALA_GONDI;
            UnicodeScript unicodeScript147 = MAKASAR;
            UnicodeScript unicodeScript148 = MEDEFAIDRIN;
            UnicodeScript unicodeScript149 = ELYMAIC;
            UnicodeScript unicodeScript150 = NANDINAGARI;
            UnicodeScript unicodeScript151 = NYIAKENG_PUACHUE_HMONG;
            UnicodeScript unicodeScript152 = WANCHO;
            UnicodeScript unicodeScript153 = YEZIDI;
            UnicodeScript unicodeScript154 = CHORASMIAN;
            UnicodeScript unicodeScript155 = DIVES_AKURU;
            UnicodeScript unicodeScript156 = KHITAN_SMALL_SCRIPT;
            UnicodeScript unicodeScript157 = UNKNOWN;
            scriptStarts = new int[]{0, 65, 91, 97, 123, 170, 171, 186, 187, 192, 215, 216, 247, 248, MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_PROCESS_OUTGOING_CALLS, MetricsProto.MetricsEvent.ACTION_PERMISSION_REQUEST_READ_PHONE_NUMBERS, 741, 746, MetricsProto.MetricsEvent.SETTINGS_APP_NOTIF_CATEGORY, 768, MetricsProto.MetricsEvent.FIELD_SETTINGS_SEARCH_INLINE_RESULT_VALUE, MetricsProto.MetricsEvent.ACTION_APPOP_GRANT_ACCESS_NOTIFICATIONS, MetricsProto.MetricsEvent.ACTION_APPOP_DENIED_ACCESS_NOTIFICATIONS, MetricsProto.MetricsEvent.ACTION_APPOP_GRANT_SYSTEM_ALERT_WINDOW, MetricsProto.MetricsEvent.ACTION_APPOP_REVOKE_SYSTEM_ALERT_WINDOW, MetricsProto.MetricsEvent.ACTION_APPOP_REVOKE_WRITE_SETTINGS, MetricsProto.MetricsEvent.ACTION_APPOP_REQUEST_REQUEST_INSTALL_PACKAGES, 896, 900, 901, 902, 903, 904, 907, 908, 909, MetricsProto.MetricsEvent.AUTOFILL_FILL_UI, MetricsProto.MetricsEvent.ACTION_QS_DATE, MetricsProto.MetricsEvent.ACTION_NAV_BUTTON_EVENT, MetricsProto.MetricsEvent.FIELD_SETTINGS_PREFERENCE_CHANGE_LONG_VALUE, 1008, 1024, 1157, 1159, MetricsProto.MetricsEvent.ACTION_PANEL_VIEW_EXPAND, MetricsProto.MetricsEvent.FIELD_DEVICE_ROTATION, MetricsProto.MetricsEvent.ACTION_ANOMALY_TRIGGERED, MetricsProto.MetricsEvent.SETTINGS_CONDITION_DEVICE_VIBRATE, MetricsProto.MetricsEvent.FIELD_BATTERY_LEVEL_END, MetricsProto.MetricsEvent.FIELD_PLUG_TYPE, MetricsProto.MetricsEvent.ACTION_USB_AUDIO_CONNECTED, MetricsProto.MetricsEvent.FIELD_USB_AUDIO_VIDPID, 1480, 1488, MetricsProto.MetricsEvent.FIELD_CALLING_PACKAGE_NAME, MetricsProto.MetricsEvent.FIELD_REAL_CALLING_UID_PROC_STATE, MetricsProto.MetricsEvent.FIELD_TARGET_WHITELIST_TAG, 1536, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_TARGET_ACTIVITY, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_FLAGS, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_MILLIS_SINCE_LAST_VISIBLE, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_RESULT_TO_PKG_NAME, MetricsProto.MetricsEvent.FIELD_EMERGENCY_DIALER_PHONE_NUMBER_TYPE, MetricsProto.MetricsEvent.FIELD_EMERGENCY_DIALER_PHONE_NUMBER_HAS_SHORTCUT, MetricsProto.MetricsEvent.FIELD_EMERGENCY_DIALER_IN_POCKET, MetricsProto.MetricsEvent.EMERGENCY_DIALER_SHORTCUT_CONFIRM_TAP, MetricsProto.MetricsEvent.FIELD_EMERGENCY_DIALER_SHORTCUT_TAPS_INTERVAL, MetricsProto.MetricsEvent.POWER_MENU, 1600, 1601, 1611, 1622, MetricsProto.MetricsEvent.NOTIFICATION_SMART_REPLY_MODIFIED_BEFORE_SENDING, MetricsProto.MetricsEvent.FIELD_SHARESHEET_MIMETYPE, 1757, 1758, 1792, 1806, HwAudioKit.PARAME_VALUE_ERROR, 1867, 1869, 1872, 1920, 1970, 1984, 2043, 2045, 2048, 2094, 2096, 2111, 2112, 2140, 2142, 2143, 2144, 2155, SecExceptionCode.SEC_ERROR_LBSRISK_GET_WUA_FAILED, 2229, 2230, 2248, 2259, 2274, 2275, 2304, 2385, 2389, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_MINIWUA_FAILED, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_UMT_FAILED, 2432, 2436, 2437, 2445, 2447, 2449, 2451, 2473, 2474, 2481, 2482, 2483, 2486, 2490, 2492, GLMapStaticValue.AM_PARAMETERNAME_ON_OFF_ASYN_TASK, 2503, 2505, 2507, 2511, 2519, 2520, 2524, 2526, 2527, 2532, 2534, 2559, 2561, 2564, 2565, 2571, 2575, 2577, 2579, GLMapStaticValue.AM_PARAMETERNAME_ON_OFF_DBLITE, GLMapStaticValue.AM_PARAMETERNAME_CACHE, 2609, 2610, 2612, 2613, 2615, 2616, 2618, 2620, 2621, 2622, 2627, 2631, 2633, 2635, 2638, 2641, 2642, 2649, 2653, 2654, 2655, 2662, 2679, 2689, 2692, 2693, GLMapStaticValue.AM_PARAMETERNAME_SHOW_CONTENT, 2703, 2706, 2707, 2729, 2730, 2737, 2738, 2740, 2741, 2746, 2748, 2758, 2759, 2762, 2763, 2766, 2768, 2769, 2784, 2788, 2790, 2802, 2809, 2816, 2817, 2820, 2821, 2829, 2831, 2833, 2835, 2857, 2858, 2865, 2866, 2868, 2869, 2874, 2876, 2885, 2887, 2889, 2891, 2894, SecExceptionCode.SEC_ERROR_UT_ANDROID_INVALID_PARA, 2904, 2908, 2910, 2911, 2916, 2918, 2936, 2946, 2948, 2949, 2955, 2958, 2961, 2962, 2966, 2969, 2971, 2972, 2973, 2974, 2976, 2979, 2981, 2984, 2987, 2990, 3002, 3006, 3011, 3014, 3017, 3018, 3022, 3024, 3025, 3031, 3032, 3046, 3067, 3072, 3085, 3086, 3089, 3090, 3113, 3114, 3130, 3133, 3141, 3142, 3145, 3146, 3150, 3157, 3159, 3160, 3163, 3168, 3172, 3174, 3184, 3191, 3200, 3213, 3214, 3217, 3218, 3241, 3242, 3252, 3253, 3258, 3260, 3269, 3270, 3273, 3274, 3278, 3285, 3287, 3294, 3295, 3296, 3300, 3302, 3312, 3313, 3315, 3328, 3341, 3342, 3345, 3346, 3397, 3398, 3401, 3402, 3408, 3412, 3428, 3430, 3456, 3457, 3460, 3461, 3479, 3482, 3506, 3507, 3516, 3517, 3518, 3520, 3527, 3530, 3531, 3535, 3541, 3542, 3543, 3544, 3552, 3558, 3568, 3570, 3573, 3585, 3643, 3647, 3648, 3676, 3713, 3715, 3716, 3717, 3718, 3723, 3724, 3748, 3749, 3750, 3751, 3774, 3776, 3781, 3782, 3783, 3784, 3790, 3792, 3802, 3804, 3808, 3840, 3912, 3913, 3949, 3953, 3992, 3993, 4029, 4030, 4045, 4046, 4053, 4057, 4059, 4096, 4256, 4294, 4295, 4296, 4301, 4302, 4304, 4347, 4348, 4352, 4608, 4681, 4682, 4686, 4688, 4695, 4696, 4697, 4698, 4702, 4704, 4745, 4746, 4750, 4752, 4785, 4786, 4790, 4792, 4799, 4800, 4801, 4802, 4806, 4808, 4823, 4824, 4881, 4882, 4886, 4888, 4955, 4957, 4989, 4992, ErrorCode.AD_POS_ID_BLOCKED, ErrorCode.METHOD_CALL_ERROR, 5110, 5112, 5118, 5120, 5760, 5789, 5792, 5867, 5870, 5881, 5888, 5901, 5902, 5909, 5920, 5941, 5943, 5952, 5972, 5984, 5997, 5998, 6001, 6002, 6004, 6016, 6110, 6112, 6122, 6128, 6138, 6144, 6146, 6148, 6149, 6150, 6159, 6160, 6170, 6176, 6265, 6272, 6315, 6320, 6390, 6400, 6431, 6432, 6444, 6448, 6460, 6464, 6465, 6468, 6480, 6510, 6512, 6517, 6528, 6572, 6576, 6602, 6608, 6619, 6622, 6624, Constants.CODE_REQUEST_MAX, 6684, 6686, 6688, 6751, 6752, 6781, 6783, 6794, 6800, 6810, 6816, 6830, 6832, 6849, 6912, 6988, 6992, 7037, 7040, 7104, 7156, 7164, 7168, 7224, 7227, 7242, 7245, 7248, 7296, 7305, 7312, 7355, 7357, 7360, 7368, 7376, 7379, 7380, 7393, 7394, 7401, 7405, 7406, 7412, 7413, 7416, 7418, 7419, 7424, 7462, 7467, 7468, 7517, 7522, 7526, 7531, 7544, 7545, 7615, 7616, 7674, 7675, 7680, 7936, 7958, 7960, 7966, 7968, 8006, 8008, 8014, 8016, 8024, 8025, 8026, 8027, 8028, 8029, 8030, 8031, 8062, 8064, 8117, 8118, 8133, 8134, 8148, 8150, 8156, 8157, 8176, 8178, 8181, 8182, HmsScanBase.ALL_SCAN_TYPE, 8192, 8204, 8206, 8293, 8294, 8305, 8306, 8308, 8319, 8320, 8335, 8336, 8349, 8352, 8384, 8400, 8433, 8448, 8486, 8487, 8490, 8492, 8498, 8499, 8526, 8527, 8544, 8585, 8588, 8592, 9255, 9280, 9291, 9312, 10240, 10496, 11124, 11126, 11158, 11159, 11264, 11311, 11312, 11359, 11360, 11392, 11508, 11513, 11520, 11558, 11559, 11560, 11565, 11566, 11568, 11624, 11631, 11633, 11647, 11648, 11671, 11680, 11687, 11688, 11695, 11696, 11703, 11704, 11711, 11712, 11719, 11720, 11727, 11728, 11735, 11736, 11743, 11744, 11776, 11859, 11904, 11930, 11931, 12020, 12032, 12246, 12272, 12284, Zygote.API_ENFORCEMENT_POLICY_MASK, 12293, 12294, 12295, 12296, 12321, 12330, 12334, 12336, 12344, 12348, 12352, 12353, 12439, 12441, 12443, 12445, 12448, 12449, 12539, 12541, 12544, 12549, 12592, 12593, 12687, 12688, 12704, 12736, 12772, 12784, 12800, 12831, 12832, 12896, 12927, 13008, 13055, 13056, 13144, 13312, 19904, 19968, 40957, 40960, 42125, 42128, 42183, 42192, 42240, 42540, 42560, 42656, 42744, 42752, 42786, 42888, 42891, 42944, 42946, 42955, 42997, 43008, 43053, 43056, 43066, 43072, 43128, 43136, 43206, 43214, 43226, 43232, 43264, 43310, 43311, 43312, 43348, 43359, 43360, 43389, 43392, 43470, 43471, 43472, 43482, 43486, 43488, 43519, 43520, 43575, 43584, 43598, 43600, 43610, 43612, 43616, 43648, 43715, 43739, 43744, 43767, 43777, 43783, 43785, 43791, 43793, 43799, 43808, 43815, 43816, 43823, 43824, 43867, 43868, 43877, 43878, 43882, 43884, 43888, 43968, 44014, 44016, 44026, 44032, 55204, 55216, 55239, 55243, 55292, 63744, 64110, 64112, 64218, 64256, 64263, 64275, 64280, 64285, 64311, 64312, 64317, 64318, 64319, 64320, 64322, 64323, 64325, 64326, 64336, 64450, 64467, 64830, 64832, 64848, 64912, 64914, 64968, 65008, 65022, 65024, 65040, 65050, 65056, 65070, 65072, 65107, 65108, 65127, 65128, 65132, 65136, 65141, 65142, 65277, 65279, 65280, 65281, 65313, 65339, 65345, 65371, 65382, 65392, 65393, 65438, 65440, 65471, 65474, 65480, 65482, 65488, 65490, 65496, 65498, 65501, 65504, 65511, 65512, 65519, 65529, 65534, 65536, 65548, 65549, 65575, 65576, 65595, 65596, 65598, 65599, 65614, 65616, 65630, 65664, 65787, 65792, 65795, 65799, 65844, 65847, 65856, 65935, 65936, 65949, 65952, 65953, 66000, 66045, 66046, 66176, 66205, 66208, 66257, 66272, 66273, 66300, 66304, 66340, 66349, 66352, 66379, 66384, 66427, 66432, 66462, 66463, 66464, 66500, 66504, 66518, 66560, 66640, 66688, 66718, 66720, 66730, 66736, 66772, 66776, 66812, 66816, 66856, 66864, 66916, 66927, 66928, 67072, 67383, 67392, 67414, 67424, 67432, 67584, 67590, 67592, 67593, 67594, 67638, 67639, 67641, 67644, 67645, 67647, 67648, 67670, 67671, 67680, 67712, 67743, 67751, 67760, 67808, 67827, 67828, 67830, 67835, 67840, 67868, 67871, 67872, 67898, 67903, 67904, 67968, 68000, 68024, 68028, 68048, 68050, 68096, 68100, 68101, 68103, 68108, 68116, 68117, 
            68120, 68121, 68150, 68152, 68155, 68159, 68169, 68176, 68185, 68192, 68224, 68256, 68288, 68327, 68331, 68343, 68352, 68406, 68409, 68416, 68438, 68440, 68448, 68467, 68472, 68480, 68498, 68505, 68509, 68521, 68528, 68608, 68681, 68736, 68787, 68800, 68851, 68858, 68864, 68904, 68912, 68922, 69216, 69247, 69248, 69290, 69291, 69294, 69296, 69298, 69376, 69416, 69424, 69466, 69552, 69580, 69600, 69623, 69632, 69710, 69714, 69744, 69759, 69760, 69826, 69837, 69838, 69840, 69865, 69872, 69882, 69888, 69941, 69942, 69960, 69968, 70007, 70016, 70112, 70113, 70133, 70144, 70162, 70163, 70207, 70272, 70279, 70280, 70281, 70282, 70286, 70287, 70302, 70303, 70314, 70320, 70379, 70384, 70394, 70400, 70404, 70405, 70413, 70415, 70417, 70419, 70441, 70442, 70449, 70450, 70452, 70453, 70458, 70459, 70460, 70469, 70471, 70473, 70475, 70478, 70480, 70481, 70487, 70488, 70493, 70500, 70502, 70509, 70512, 70517, 70656, 70748, 70749, 70754, 70784, 70856, 70864, 70874, 71040, 71094, 71096, 71134, 71168, 71237, 71248, 71258, 71264, 71277, 71296, 71353, 71360, 71370, 71424, 71451, 71453, 71468, 71472, 71488, 71680, 71740, 71840, 71923, 71935, 71936, 71943, 71945, 71946, 71948, 71956, 71957, 71959, 71960, 71990, 71991, 71993, 71995, 72007, 72016, 72026, 72096, 72104, 72106, 72152, 72154, 72165, 72192, 72264, 72272, 72355, 72384, 72441, 72704, 72713, 72714, 72759, 72760, 72774, 72784, 72813, 72816, 72848, 72850, 72872, 72873, 72887, 72960, 72967, 72968, 72970, 72971, 73015, 73018, 73019, 73020, 73022, 73023, 73032, 73040, 73050, 73056, 73062, 73063, 73065, 73066, 73103, 73104, 73106, 73107, 73113, 73120, 73130, 73440, 73465, 73648, 73649, 73664, 73714, 73727, 73728, 74650, 74752, 74863, 74864, 74869, 74880, 75076, 77824, 78895, 78896, 78905, 82944, 83527, 92160, 92729, 92736, 92767, 92768, 92778, 92782, 92784, 92880, 92910, 92912, 92918, 92928, 92998, 93008, 93018, 93019, 93026, 93027, 93048, 93053, 93072, 93760, 93851, 93952, 94027, 94031, 94088, 94095, 94112, 94176, 94177, 94178, 94180, 94181, 94192, 94194, 94208, 100344, 100352, 101120, 101590, 101632, 101641, 110592, 110593, 110879, 110928, 110931, 110948, 110952, 110960, 111356, 113664, 113771, 113776, 113789, 113792, 113801, 113808, 113818, 113820, 113824, 113828, 118784, 119030, 119040, 119079, 119081, 119143, 119146, 119163, 119171, 119173, 119180, 119210, 119214, 119273, 119296, 119366, 119520, 119540, 119552, 119639, 119648, 119673, 119808, 119893, 119894, 119965, 119966, 119968, 119970, 119971, 119973, 119975, 119977, 119981, 119982, 119994, 119995, 119996, 119997, 120004, 120005, 120070, 120071, 120075, 120077, 120085, 120086, 120093, 120094, 120122, 120123, 120127, 120128, 120133, 120134, 120135, 120138, 120145, 120146, 120486, 120488, 120780, 120782, 120832, 121484, 121499, 121504, 121505, 121520, 122880, 122887, 122888, 122905, 122907, 122914, 122915, 122917, 122918, 122923, 123136, 123181, 123184, 123198, 123200, 123210, 123214, 123216, 123584, 123642, 123647, 123648, 124928, 125125, 125127, 125143, 125184, 125260, 125264, 125274, 125278, 125280, 126065, 126133, 126209, 126270, 126464, 126468, 126469, 126496, 126497, 126499, 126500, 126501, 126503, 126504, 126505, 126515, 126516, 126520, 126521, 126522, 126523, 126524, 126530, 126531, 126535, 126536, 126537, 126538, 126539, 126540, 126541, 126544, 126545, 126547, 126548, 126549, 126551, 126552, 126553, 126554, 126555, 126556, 126557, 126558, 126559, 126560, 126561, 126563, 126564, 126565, 126567, 126571, 126572, 126579, 126580, 126584, 126585, 126589, 126590, 126591, 126592, 126602, 126603, 126620, 126625, 126628, 126629, 126634, 126635, 126652, 126704, 126706, 126976, 127020, 127024, 127124, 127136, 127151, 127153, 127168, 127169, 127184, 127185, 127222, 127232, 127406, 127462, 127488, 127489, 127491, 127504, 127548, 127552, 127561, 127568, 127570, 127584, 127590, 127744, 128728, 128736, 128749, 128752, 128765, 128768, 128884, 128896, 128985, 128992, 129004, 129024, 129036, 129040, 129096, 129104, 129114, 129120, 129160, 129168, 129198, 129200, 129202, 129280, 129401, 129402, 129484, 129485, 129620, 129632, 129646, 129648, 129653, 129656, 129659, 129664, 129671, 129680, 129705, 129712, 129719, 129728, 129731, 129744, 129751, 129792, 129939, 129940, 129995, 130032, 130042, 131072, 173790, 173824, 177973, 177984, 178206, 178208, 183970, 183984, 191457, 194560, 195102, 196608, 201547, 917505, 917506, 917536, 917632, 917760, 918000};
            scripts = new UnicodeScript[]{unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript35, unicodeScript, unicodeScript41, unicodeScript3, unicodeScript, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript, unicodeScript3, unicodeScript, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript55, unicodeScript3, unicodeScript4, unicodeScript41, unicodeScript4, unicodeScript157, unicodeScript5, unicodeScript157, unicodeScript5, unicodeScript157, unicodeScript5, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript7, unicodeScript, unicodeScript7, unicodeScript, unicodeScript7, unicodeScript, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript, unicodeScript7, unicodeScript, unicodeScript7, unicodeScript41, unicodeScript7, unicodeScript41, unicodeScript7, unicodeScript, unicodeScript7, unicodeScript8, unicodeScript157, unicodeScript8, unicodeScript157, unicodeScript8, unicodeScript7, unicodeScript9, unicodeScript157, unicodeScript66, unicodeScript157, unicodeScript66, unicodeScript83, unicodeScript157, unicodeScript83, unicodeScript157, unicodeScript84, unicodeScript157, unicodeScript84, unicodeScript157, unicodeScript8, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript, unicodeScript7, unicodeScript10, unicodeScript41, unicodeScript10, unicodeScript, unicodeScript10, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript11, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript12, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript13, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript14, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript157, unicodeScript16, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript17, unicodeScript157, unicodeScript18, unicodeScript157, unicodeScript18, unicodeScript157, unicodeScript18, unicodeScript157, unicodeScript18, unicodeScript157, unicodeScript18, unicodeScript157, unicodeScript18, unicodeScript157, unicodeScript18, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript20, unicodeScript157, unicodeScript, unicodeScript20, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript21, unicodeScript157, unicodeScript22, unicodeScript157, unicodeScript22, unicodeScript157, unicodeScript22, unicodeScript157, unicodeScript22, unicodeScript157, unicodeScript22, unicodeScript157, unicodeScript22, unicodeScript, unicodeScript22, unicodeScript157, unicodeScript23, unicodeScript24, unicodeScript157, unicodeScript24, unicodeScript157, unicodeScript24, unicodeScript157, unicodeScript24, unicodeScript, unicodeScript24, unicodeScript25, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript27, unicodeScript157, unicodeScript27, unicodeScript157, unicodeScript28, unicodeScript29, unicodeScript157, unicodeScript30, unicodeScript, unicodeScript30, unicodeScript157, unicodeScript42, unicodeScript157, unicodeScript42, unicodeScript157, unicodeScript43, unicodeScript, unicodeScript157, unicodeScript44, unicodeScript157, unicodeScript45, unicodeScript157, unicodeScript45, unicodeScript157, unicodeScript45, unicodeScript157, unicodeScript31, unicodeScript157, unicodeScript31, unicodeScript157, unicodeScript31, unicodeScript157, unicodeScript32, unicodeScript, unicodeScript32, unicodeScript, unicodeScript32, unicodeScript157, unicodeScript32, unicodeScript157, unicodeScript32, unicodeScript157, unicodeScript32, unicodeScript157, unicodeScript28, unicodeScript157, unicodeScript46, unicodeScript157, unicodeScript46, unicodeScript157, unicodeScript46, unicodeScript157, unicodeScript46, unicodeScript157, unicodeScript46, unicodeScript47, unicodeScript157, unicodeScript47, unicodeScript157, unicodeScript56, unicodeScript157, unicodeScript56, unicodeScript157, unicodeScript56, unicodeScript157, unicodeScript56, unicodeScript31, unicodeScript54, unicodeScript157, unicodeScript54, unicodeScript79, unicodeScript157, unicodeScript79, unicodeScript157, unicodeScript79, unicodeScript157, unicodeScript79, unicodeScript157, unicodeScript79, unicodeScript157, unicodeScript41, unicodeScript157, unicodeScript62, unicodeScript157, unicodeScript62, unicodeScript157, unicodeScript67, unicodeScript68, unicodeScript157, unicodeScript68, unicodeScript69, unicodeScript157, unicodeScript69, unicodeScript157, unicodeScript69, unicodeScript70, unicodeScript4, unicodeScript157, unicodeScript24, unicodeScript157, unicodeScript24, unicodeScript67, unicodeScript157, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript157, unicodeScript2, unicodeScript3, unicodeScript4, unicodeScript2, unicodeScript3, unicodeScript2, unicodeScript3, unicodeScript2, unicodeScript4, unicodeScript2, unicodeScript3, unicodeScript41, unicodeScript157, unicodeScript41, unicodeScript2, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript, unicodeScript41, unicodeScript, unicodeScript157, unicodeScript, unicodeScript2, unicodeScript157, unicodeScript, unicodeScript2, unicodeScript, unicodeScript157, unicodeScript2, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript41, unicodeScript157, unicodeScript, unicodeScript3, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript53, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript57, unicodeScript157, unicodeScript57, unicodeScript157, unicodeScript2, unicodeScript55, unicodeScript157, unicodeScript55, unicodeScript24, unicodeScript157, unicodeScript24, unicodeScript157, unicodeScript24, unicodeScript157, unicodeScript58, unicodeScript157, unicodeScript58, unicodeScript157, unicodeScript58, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript4, unicodeScript, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript36, unicodeScript, unicodeScript36, unicodeScript, unicodeScript36, unicodeScript41, unicodeScript25, unicodeScript, unicodeScript36, unicodeScript, unicodeScript157, unicodeScript33, unicodeScript157, unicodeScript41, unicodeScript, unicodeScript33, unicodeScript, unicodeScript34, unicodeScript, unicodeScript34, unicodeScript157, unicodeScript35, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript, unicodeScript35, unicodeScript, unicodeScript157, unicodeScript34, unicodeScript25, unicodeScript157, unicodeScript, unicodeScript25, unicodeScript, unicodeScript34, unicodeScript, unicodeScript34, unicodeScript, unicodeScript36, unicodeScript, unicodeScript36, unicodeScript157, unicodeScript37, unicodeScript157, unicodeScript37, unicodeScript157, unicodeScript85, unicodeScript71, unicodeScript157, unicodeScript4, unicodeScript86, unicodeScript157, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript157, unicodeScript2, unicodeScript157, unicodeScript2, unicodeScript59, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript65, unicodeScript157, unicodeScript72, unicodeScript157, unicodeScript72, unicodeScript157, unicodeScript10, unicodeScript73, unicodeScript, unicodeScript73, unicodeScript74, unicodeScript157, unicodeScript74, unicodeScript25, unicodeScript157, unicodeScript87, unicodeScript157, unicodeScript, unicodeScript87, unicodeScript157, unicodeScript87, unicodeScript23, unicodeScript157, unicodeScript78, unicodeScript157, unicodeScript78, unicodeScript157, unicodeScript78, unicodeScript157, unicodeScript78, unicodeScript23, unicodeScript80, unicodeScript157, unicodeScript80, unicodeScript88, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript26, unicodeScript157, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript3, unicodeScript2, unicodeScript, unicodeScript157, unicodeScript27, unicodeScript88, unicodeScript157, unicodeScript88, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript2, unicodeScript157, unicodeScript5, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript6, unicodeScript157, unicodeScript6, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript41, unicodeScript, unicodeScript157, unicodeScript41, unicodeScript4, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript2, unicodeScript, unicodeScript2, unicodeScript, unicodeScript34, unicodeScript, unicodeScript34, unicodeScript, unicodeScript25, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript25, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript48, unicodeScript157, unicodeScript48, unicodeScript157, unicodeScript48, unicodeScript157, unicodeScript48, unicodeScript157, unicodeScript48, unicodeScript157, unicodeScript48, unicodeScript157, unicodeScript48, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript3, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript, unicodeScript41, unicodeScript157, unicodeScript75, unicodeScript157, unicodeScript76, unicodeScript157, unicodeScript41, unicodeScript, unicodeScript157, unicodeScript38, unicodeScript157, unicodeScript38, unicodeScript39, unicodeScript157, unicodeScript120, unicodeScript157, unicodeScript49, unicodeScript157, unicodeScript49, unicodeScript60, unicodeScript157, unicodeScript60, unicodeScript157, unicodeScript40, unicodeScript50, unicodeScript51, unicodeScript157, unicodeScript51, unicodeScript157, unicodeScript136, unicodeScript157, unicodeScript136, unicodeScript157, unicodeScript106, unicodeScript157, unicodeScript103, unicodeScript157, unicodeScript103, unicodeScript157, unicodeScript110, unicodeScript157, unicodeScript110, unicodeScript157, unicodeScript110, unicodeScript157, unicodeScript52, unicodeScript157, unicodeScript52, unicodeScript157, unicodeScript52, unicodeScript157, unicodeScript52, unicodeScript157, unicodeScript52, unicodeScript157, unicodeScript52, unicodeScript89, unicodeScript157, unicodeScript89, unicodeScript118, unicodeScript117, unicodeScript157, unicodeScript117, unicodeScript157, unicodeScript128, unicodeScript157, unicodeScript128, unicodeScript157, unicodeScript128, unicodeScript64, unicodeScript157, unicodeScript64, unicodeScript77, unicodeScript157, unicodeScript77, unicodeScript157, unicodeScript96, unicodeScript97, unicodeScript157, unicodeScript97, unicodeScript157, unicodeScript97, unicodeScript61, unicodeScript157, unicodeScript61, unicodeScript157, unicodeScript61, unicodeScript157, unicodeScript61, 
            unicodeScript157, unicodeScript61, unicodeScript157, unicodeScript61, unicodeScript157, unicodeScript61, unicodeScript157, unicodeScript61, unicodeScript157, unicodeScript90, unicodeScript116, unicodeScript157, unicodeScript112, unicodeScript157, unicodeScript112, unicodeScript157, unicodeScript81, unicodeScript157, unicodeScript81, unicodeScript91, unicodeScript157, unicodeScript91, unicodeScript92, unicodeScript157, unicodeScript92, unicodeScript121, unicodeScript157, unicodeScript121, unicodeScript157, unicodeScript121, unicodeScript157, unicodeScript93, unicodeScript157, unicodeScript130, unicodeScript157, unicodeScript130, unicodeScript157, unicodeScript130, unicodeScript142, unicodeScript157, unicodeScript142, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript153, unicodeScript157, unicodeScript153, unicodeScript157, unicodeScript153, unicodeScript157, unicodeScript143, unicodeScript157, unicodeScript144, unicodeScript157, unicodeScript154, unicodeScript157, unicodeScript149, unicodeScript157, unicodeScript94, unicodeScript157, unicodeScript94, unicodeScript157, unicodeScript94, unicodeScript95, unicodeScript157, unicodeScript95, unicodeScript157, unicodeScript98, unicodeScript157, unicodeScript98, unicodeScript157, unicodeScript99, unicodeScript157, unicodeScript99, unicodeScript157, unicodeScript111, unicodeScript157, unicodeScript100, unicodeScript157, unicodeScript19, unicodeScript157, unicodeScript109, unicodeScript157, unicodeScript109, unicodeScript157, unicodeScript129, unicodeScript157, unicodeScript129, unicodeScript157, unicodeScript129, unicodeScript157, unicodeScript129, unicodeScript157, unicodeScript129, unicodeScript157, unicodeScript123, unicodeScript157, unicodeScript123, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript41, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript107, unicodeScript157, unicodeScript135, unicodeScript157, unicodeScript135, unicodeScript157, unicodeScript124, unicodeScript157, unicodeScript124, unicodeScript157, unicodeScript122, unicodeScript157, unicodeScript122, unicodeScript157, unicodeScript114, unicodeScript157, unicodeScript114, unicodeScript157, unicodeScript32, unicodeScript157, unicodeScript101, unicodeScript157, unicodeScript101, unicodeScript157, unicodeScript126, unicodeScript157, unicodeScript126, unicodeScript157, unicodeScript126, unicodeScript157, unicodeScript145, unicodeScript157, unicodeScript125, unicodeScript157, unicodeScript125, unicodeScript155, unicodeScript157, unicodeScript155, unicodeScript157, unicodeScript155, unicodeScript157, unicodeScript155, unicodeScript157, unicodeScript155, unicodeScript157, unicodeScript155, unicodeScript157, unicodeScript155, unicodeScript157, unicodeScript155, unicodeScript157, unicodeScript150, unicodeScript157, unicodeScript150, unicodeScript157, unicodeScript150, unicodeScript157, unicodeScript141, unicodeScript157, unicodeScript140, unicodeScript157, unicodeScript119, unicodeScript157, unicodeScript133, unicodeScript157, unicodeScript133, unicodeScript157, unicodeScript133, unicodeScript157, unicodeScript133, unicodeScript157, unicodeScript134, unicodeScript157, unicodeScript134, unicodeScript157, unicodeScript134, unicodeScript157, unicodeScript138, unicodeScript157, unicodeScript138, unicodeScript157, unicodeScript138, unicodeScript157, unicodeScript138, unicodeScript157, unicodeScript138, unicodeScript157, unicodeScript138, unicodeScript157, unicodeScript138, unicodeScript157, unicodeScript146, unicodeScript157, unicodeScript146, unicodeScript157, unicodeScript146, unicodeScript157, unicodeScript146, unicodeScript157, unicodeScript146, unicodeScript157, unicodeScript146, unicodeScript157, unicodeScript147, unicodeScript157, unicodeScript85, unicodeScript157, unicodeScript15, unicodeScript157, unicodeScript15, unicodeScript63, unicodeScript157, unicodeScript63, unicodeScript157, unicodeScript63, unicodeScript157, unicodeScript63, unicodeScript157, unicodeScript82, unicodeScript157, unicodeScript82, unicodeScript157, unicodeScript127, unicodeScript157, unicodeScript86, unicodeScript157, unicodeScript115, unicodeScript157, unicodeScript115, unicodeScript157, unicodeScript115, unicodeScript157, unicodeScript104, unicodeScript157, unicodeScript104, unicodeScript157, unicodeScript108, unicodeScript157, unicodeScript108, unicodeScript157, unicodeScript108, unicodeScript157, unicodeScript108, unicodeScript157, unicodeScript108, unicodeScript157, unicodeScript148, unicodeScript157, unicodeScript102, unicodeScript157, unicodeScript102, unicodeScript157, unicodeScript102, unicodeScript157, unicodeScript137, unicodeScript139, unicodeScript, unicodeScript156, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript137, unicodeScript157, unicodeScript137, unicodeScript156, unicodeScript157, unicodeScript137, unicodeScript157, unicodeScript34, unicodeScript33, unicodeScript157, unicodeScript33, unicodeScript157, unicodeScript34, unicodeScript157, unicodeScript139, unicodeScript157, unicodeScript105, unicodeScript157, unicodeScript105, unicodeScript157, unicodeScript105, unicodeScript157, unicodeScript105, unicodeScript157, unicodeScript105, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript41, unicodeScript, unicodeScript157, unicodeScript3, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript131, unicodeScript157, unicodeScript131, unicodeScript157, unicodeScript131, unicodeScript157, unicodeScript57, unicodeScript157, unicodeScript57, unicodeScript157, unicodeScript57, unicodeScript157, unicodeScript57, unicodeScript157, unicodeScript57, unicodeScript157, unicodeScript151, unicodeScript157, unicodeScript151, unicodeScript157, unicodeScript151, unicodeScript157, unicodeScript151, unicodeScript157, unicodeScript152, unicodeScript157, unicodeScript152, unicodeScript157, unicodeScript113, unicodeScript157, unicodeScript113, unicodeScript157, unicodeScript132, unicodeScript157, unicodeScript132, unicodeScript157, unicodeScript132, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript7, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript33, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript36, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript, unicodeScript157, unicodeScript41, unicodeScript157};
            HashMap<String, UnicodeScript> hashMap = new HashMap<>(210);
            aliases = hashMap;
            hashMap.put("ADLM", unicodeScript132);
            hashMap.put("AGHB", unicodeScript103);
            hashMap.put("AHOM", unicodeScript126);
            hashMap.put("ARAB", unicodeScript7);
            hashMap.put("ARMI", unicodeScript89);
            hashMap.put("ARMN", unicodeScript5);
            hashMap.put("AVST", unicodeScript81);
            hashMap.put("BALI", unicodeScript62);
            hashMap.put("BAMU", unicodeScript86);
            hashMap.put("BASS", unicodeScript104);
            hashMap.put("BATK", unicodeScript68);
            hashMap.put("BENG", unicodeScript11);
            hashMap.put("BHKS", unicodeScript133);
            hashMap.put("BOPO", unicodeScript35);
            hashMap.put("BRAH", unicodeScript94);
            hashMap.put("BRAI", unicodeScript53);
            hashMap.put("BUGI", unicodeScript54);
            hashMap.put("BUHD", unicodeScript44);
            hashMap.put("CAKM", unicodeScript99);
            hashMap.put("CANS", unicodeScript28);
            hashMap.put("CARI", unicodeScript76);
            hashMap.put("CHAM", unicodeScript78);
            hashMap.put("CHER", unicodeScript27);
            hashMap.put("CHRS", unicodeScript154);
            hashMap.put("COPT", unicodeScript55);
            hashMap.put("CPRT", unicodeScript52);
            hashMap.put("CYRL", unicodeScript4);
            hashMap.put("DEVA", unicodeScript10);
            hashMap.put("DIAK", unicodeScript155);
            hashMap.put("DOGR", unicodeScript145);
            hashMap.put("DSRT", unicodeScript40);
            hashMap.put("DUPL", unicodeScript105);
            hashMap.put("EGYP", unicodeScript82);
            hashMap.put("ELBA", unicodeScript106);
            hashMap.put("ELYM", unicodeScript149);
            hashMap.put("ETHI", unicodeScript26);
            hashMap.put("GEOR", unicodeScript24);
            hashMap.put("GLAG", unicodeScript57);
            hashMap.put("GONM", unicodeScript138);
            hashMap.put("GOTH", unicodeScript39);
            hashMap.put("GONG", unicodeScript146);
            hashMap.put("GRAN", unicodeScript107);
            hashMap.put("GREK", unicodeScript3);
            hashMap.put("GUJR", unicodeScript13);
            hashMap.put("GURU", unicodeScript12);
            hashMap.put("HANG", unicodeScript25);
            hashMap.put("HANI", unicodeScript36);
            hashMap.put("HANO", unicodeScript43);
            hashMap.put("HATR", unicodeScript128);
            hashMap.put("HEBR", unicodeScript6);
            hashMap.put("HIRA", unicodeScript33);
            hashMap.put("HLUW", unicodeScript127);
            hashMap.put("HMNG", unicodeScript108);
            hashMap.put("HMNP", unicodeScript151);
            hashMap.put("HUNG", unicodeScript130);
            hashMap.put("ITAL", unicodeScript38);
            hashMap.put("JAVA", unicodeScript87);
            hashMap.put("KALI", unicodeScript73);
            hashMap.put("KANA", unicodeScript34);
            hashMap.put("KHAR", unicodeScript61);
            hashMap.put("KHMR", unicodeScript31);
            hashMap.put("KHOJ", unicodeScript109);
            hashMap.put("KITS", unicodeScript156);
            hashMap.put("KNDA", unicodeScript17);
            hashMap.put("KTHI", unicodeScript95);
            hashMap.put("LANA", unicodeScript79);
            hashMap.put("LAOO", unicodeScript21);
            hashMap.put("LATN", unicodeScript2);
            hashMap.put("LEPC", unicodeScript69);
            hashMap.put("LIMB", unicodeScript46);
            hashMap.put("LINA", unicodeScript110);
            hashMap.put("LINB", unicodeScript48);
            hashMap.put("LISU", unicodeScript85);
            hashMap.put("LYCI", unicodeScript75);
            hashMap.put("LYDI", unicodeScript77);
            hashMap.put("MAHJ", unicodeScript111);
            hashMap.put("MAKA", unicodeScript147);
            hashMap.put("MARC", unicodeScript134);
            hashMap.put("MAND", unicodeScript84);
            hashMap.put("MANI", unicodeScript112);
            hashMap.put("MEDF", unicodeScript148);
            hashMap.put("MEND", unicodeScript113);
            hashMap.put("MERC", unicodeScript97);
            hashMap.put("MERO", unicodeScript96);
            hashMap.put("MLYM", unicodeScript18);
            hashMap.put("MODI", unicodeScript114);
            hashMap.put("MONG", unicodeScript32);
            hashMap.put("MROO", unicodeScript115);
            hashMap.put("MTEI", unicodeScript88);
            hashMap.put("MULT", unicodeScript129);
            hashMap.put("MYMR", unicodeScript23);
            hashMap.put("NAND", unicodeScript150);
            hashMap.put("NARB", unicodeScript116);
            hashMap.put("NBAT", unicodeScript117);
            hashMap.put("NEWA", unicodeScript135);
            hashMap.put("NKOO", unicodeScript66);
            hashMap.put("NSHU", unicodeScript139);
            hashMap.put("OGAM", unicodeScript29);
            hashMap.put("OLCK", unicodeScript70);
            hashMap.put("ORKH", unicodeScript93);
            hashMap.put("ORYA", unicodeScript14);
            hashMap.put("OSGE", unicodeScript136);
            hashMap.put("OSMA", unicodeScript51);
            hashMap.put("PALM", unicodeScript118);
            hashMap.put("PAUC", unicodeScript119);
            hashMap.put("PERM", unicodeScript120);
            hashMap.put("PHAG", unicodeScript65);
            hashMap.put("PHLI", unicodeScript92);
            hashMap.put("PHLP", unicodeScript121);
            hashMap.put("PHNX", unicodeScript64);
            hashMap.put("PLRD", unicodeScript102);
            hashMap.put("PRTI", unicodeScript91);
            hashMap.put("RJNG", unicodeScript74);
            hashMap.put("ROHG", unicodeScript142);
            hashMap.put("RUNR", unicodeScript30);
            hashMap.put("SAMR", unicodeScript83);
            hashMap.put("SARB", unicodeScript90);
            hashMap.put("SAUR", unicodeScript72);
            hashMap.put("SGNW", unicodeScript131);
            hashMap.put("SHAW", unicodeScript50);
            hashMap.put("SHRD", unicodeScript100);
            hashMap.put("SIDD", unicodeScript122);
            hashMap.put("SIND", unicodeScript123);
            hashMap.put("SINH", unicodeScript19);
            hashMap.put("SOGD", unicodeScript144);
            hashMap.put("SOGO", unicodeScript143);
            hashMap.put("SORA", unicodeScript98);
            hashMap.put("SOYO", unicodeScript140);
            hashMap.put("SUND", unicodeScript67);
            hashMap.put("SYLO", unicodeScript59);
            hashMap.put("SYRC", unicodeScript8);
            hashMap.put("TAGB", unicodeScript45);
            hashMap.put("TAKR", unicodeScript101);
            hashMap.put("TALE", unicodeScript47);
            hashMap.put("TALU", unicodeScript56);
            hashMap.put("TAML", unicodeScript15);
            hashMap.put("TANG", unicodeScript137);
            hashMap.put("TAVT", unicodeScript80);
            hashMap.put("TELU", unicodeScript16);
            hashMap.put("TFNG", unicodeScript58);
            hashMap.put("TGLG", unicodeScript42);
            hashMap.put("THAA", unicodeScript9);
            hashMap.put("THAI", unicodeScript20);
            hashMap.put("TIBT", unicodeScript22);
            hashMap.put("TIRH", unicodeScript124);
            hashMap.put("UGAR", unicodeScript49);
            hashMap.put("VAII", unicodeScript71);
            hashMap.put("WARA", unicodeScript125);
            hashMap.put("WCHO", unicodeScript152);
            hashMap.put("XPEO", unicodeScript60);
            hashMap.put("XSUX", unicodeScript63);
            hashMap.put("YIII", unicodeScript37);
            hashMap.put("YEZI", unicodeScript153);
            hashMap.put("ZANB", unicodeScript141);
            hashMap.put("ZINH", unicodeScript41);
            hashMap.put("ZYYY", unicodeScript);
            hashMap.put("ZZZZ", unicodeScript157);
        }

        public static UnicodeScript of(int codePoint) {
            if (!Character.isValidCodePoint(codePoint)) {
                throw new IllegalArgumentException(String.format("Not a valid Unicode code point: 0x%X", Integer.valueOf(codePoint)));
            }
            int type = Character.getType(codePoint);
            if (type == 0) {
                return UNKNOWN;
            }
            int index = Arrays.binarySearch(scriptStarts, codePoint);
            if (index < 0) {
                index = (-index) - 2;
            }
            return scripts[index];
        }

        public static final UnicodeScript forName(String scriptName) {
            String scriptName2 = scriptName.toUpperCase(Locale.ENGLISH);
            UnicodeScript sc2 = aliases.get(scriptName2);
            if (sc2 != null) {
                return sc2;
            }
            return valueOf(scriptName2);
        }
    }

    @Deprecated(since = "9")
    public Character(char value) {
        this.value = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CharacterCache {
        static Character[] archivedCache;
        static final Character[] cache;

        private CharacterCache() {
        }

        static {
            Character[] chArr = archivedCache;
            if (chArr == null || chArr.length != 128) {
                Character[] c4 = new Character[128];
                for (int i10 = 0; i10 < 128; i10++) {
                    c4[i10] = new Character((char) i10);
                }
                archivedCache = c4;
            }
            cache = archivedCache;
        }
    }

    public static Character valueOf(char c4) {
        if (c4 <= 127) {
            return CharacterCache.cache[c4];
        }
        return new Character(c4);
    }

    public char charValue() {
        return this.value;
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(char value) {
        return value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Character) && this.value == ((Character) obj).charValue();
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public static String toString(char c4) {
        return String.valueOf(c4);
    }

    public static boolean isValidCodePoint(int codePoint) {
        int plane = codePoint >>> 16;
        return plane < 17;
    }

    public static boolean isBmpCodePoint(int codePoint) {
        return (codePoint >>> 16) == 0;
    }

    public static boolean isSupplementaryCodePoint(int codePoint) {
        return codePoint >= 65536 && codePoint < 1114112;
    }

    public static boolean isHighSurrogate(char ch) {
        return ch >= 55296 && ch < 56320;
    }

    public static boolean isLowSurrogate(char ch) {
        return ch >= 56320 && ch < 57344;
    }

    public static boolean isSurrogate(char ch) {
        return ch >= 55296 && ch < 57344;
    }

    public static boolean isSurrogatePair(char high, char low) {
        return isHighSurrogate(high) && isLowSurrogate(low);
    }

    public static int charCount(int codePoint) {
        return codePoint >= 65536 ? 2 : 1;
    }

    public static int toCodePoint(char high, char low) {
        return ((high << '\n') + low) - 56613888;
    }

    public static int codePointAt(CharSequence seq, int index) {
        int index2;
        char c12 = seq.charAt(index);
        if (isHighSurrogate(c12) && (index2 = index + 1) < seq.length()) {
            char c22 = seq.charAt(index2);
            if (isLowSurrogate(c22)) {
                return toCodePoint(c12, c22);
            }
        }
        return c12;
    }

    public static int codePointAt(char[] a10, int index) {
        return codePointAtImpl(a10, index, a10.length);
    }

    public static int codePointAt(char[] a10, int index, int limit) {
        if (index >= limit || limit < 0 || limit > a10.length) {
            throw new IndexOutOfBoundsException();
        }
        return codePointAtImpl(a10, index, limit);
    }

    static int codePointAtImpl(char[] a10, int index, int limit) {
        int index2;
        char c12 = a10[index];
        if (isHighSurrogate(c12) && (index2 = index + 1) < limit) {
            char c22 = a10[index2];
            if (isLowSurrogate(c22)) {
                return toCodePoint(c12, c22);
            }
        }
        return c12;
    }

    public static int codePointBefore(CharSequence seq, int index) {
        int index2 = index - 1;
        char c22 = seq.charAt(index2);
        if (isLowSurrogate(c22) && index2 > 0) {
            char c12 = seq.charAt(index2 - 1);
            if (isHighSurrogate(c12)) {
                return toCodePoint(c12, c22);
            }
        }
        return c22;
    }

    public static int codePointBefore(char[] a10, int index) {
        return codePointBeforeImpl(a10, index, 0);
    }

    public static int codePointBefore(char[] a10, int index, int start) {
        if (index <= start || start < 0 || start >= a10.length) {
            throw new IndexOutOfBoundsException();
        }
        return codePointBeforeImpl(a10, index, start);
    }

    static int codePointBeforeImpl(char[] a10, int index, int start) {
        int index2 = index - 1;
        char c22 = a10[index2];
        if (isLowSurrogate(c22) && index2 > start) {
            char c12 = a10[index2 - 1];
            if (isHighSurrogate(c12)) {
                return toCodePoint(c12, c22);
            }
        }
        return c22;
    }

    public static char highSurrogate(int codePoint) {
        return (char) ((codePoint >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
    }

    public static char lowSurrogate(int codePoint) {
        return (char) ((codePoint & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    public static int toChars(int codePoint, char[] dst, int dstIndex) {
        if (isBmpCodePoint(codePoint)) {
            dst[dstIndex] = (char) codePoint;
            return 1;
        }
        if (isValidCodePoint(codePoint)) {
            toSurrogates(codePoint, dst, dstIndex);
            return 2;
        }
        throw new IllegalArgumentException(String.format("Not a valid Unicode code point: 0x%X", Integer.valueOf(codePoint)));
    }

    public static char[] toChars(int codePoint) {
        if (isBmpCodePoint(codePoint)) {
            return new char[]{(char) codePoint};
        }
        if (isValidCodePoint(codePoint)) {
            char[] result = new char[2];
            toSurrogates(codePoint, result, 0);
            return result;
        }
        throw new IllegalArgumentException(String.format("Not a valid Unicode code point: 0x%X", Integer.valueOf(codePoint)));
    }

    static void toSurrogates(int codePoint, char[] dst, int index) {
        dst[index + 1] = lowSurrogate(codePoint);
        dst[index] = highSurrogate(codePoint);
    }

    public static int codePointCount(CharSequence seq, int beginIndex, int endIndex) {
        int length = seq.length();
        if (beginIndex < 0 || endIndex > length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        int n10 = endIndex - beginIndex;
        int i10 = beginIndex;
        while (i10 < endIndex) {
            int i11 = i10 + 1;
            if (!isHighSurrogate(seq.charAt(i10)) || i11 >= endIndex || !isLowSurrogate(seq.charAt(i11))) {
                i10 = i11;
            } else {
                n10--;
                i10 = i11 + 1;
            }
        }
        return n10;
    }

    public static int codePointCount(char[] a10, int offset, int count) {
        if (count > a10.length - offset || offset < 0 || count < 0) {
            throw new IndexOutOfBoundsException();
        }
        return codePointCountImpl(a10, offset, count);
    }

    static int codePointCountImpl(char[] a10, int offset, int count) {
        int endIndex = offset + count;
        int n10 = count;
        int i10 = offset;
        while (i10 < endIndex) {
            int i11 = i10 + 1;
            if (!isHighSurrogate(a10[i10]) || i11 >= endIndex || !isLowSurrogate(a10[i11])) {
                i10 = i11;
            } else {
                n10--;
                i10 = i11 + 1;
            }
        }
        return n10;
    }

    public static int offsetByCodePoints(CharSequence seq, int index, int codePointOffset) {
        int length = seq.length();
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        int x10 = index;
        if (codePointOffset >= 0) {
            int i10 = 0;
            while (x10 < length && i10 < codePointOffset) {
                int x11 = x10 + 1;
                if (isHighSurrogate(seq.charAt(x10)) && x11 < length && isLowSurrogate(seq.charAt(x11))) {
                    x11++;
                }
                x10 = x11;
                i10++;
            }
            if (i10 < codePointOffset) {
                throw new IndexOutOfBoundsException();
            }
        } else {
            int i11 = codePointOffset;
            while (x10 > 0 && i11 < 0) {
                x10--;
                if (isLowSurrogate(seq.charAt(x10)) && x10 > 0 && isHighSurrogate(seq.charAt(x10 - 1))) {
                    x10--;
                }
                i11++;
            }
            if (i11 < 0) {
                throw new IndexOutOfBoundsException();
            }
        }
        return x10;
    }

    public static int offsetByCodePoints(char[] a10, int start, int count, int index, int codePointOffset) {
        if (count > a10.length - start || start < 0 || count < 0 || index < start || index > start + count) {
            throw new IndexOutOfBoundsException();
        }
        return offsetByCodePointsImpl(a10, start, count, index, codePointOffset);
    }

    static int offsetByCodePointsImpl(char[] a10, int start, int count, int index, int codePointOffset) {
        int x10 = index;
        if (codePointOffset >= 0) {
            int limit = start + count;
            int i10 = 0;
            while (x10 < limit && i10 < codePointOffset) {
                int x11 = x10 + 1;
                if (isHighSurrogate(a10[x10]) && x11 < limit && isLowSurrogate(a10[x11])) {
                    x11++;
                }
                x10 = x11;
                i10++;
            }
            if (i10 < codePointOffset) {
                throw new IndexOutOfBoundsException();
            }
        } else {
            int i11 = codePointOffset;
            while (x10 > start && i11 < 0) {
                x10--;
                if (isLowSurrogate(a10[x10]) && x10 > start && isHighSurrogate(a10[x10 - 1])) {
                    x10--;
                }
                i11++;
            }
            if (i11 < 0) {
                throw new IndexOutOfBoundsException();
            }
        }
        return x10;
    }

    public static boolean isLowerCase(char ch) {
        return isLowerCase((int) ch);
    }

    public static boolean isLowerCase(int codePoint) {
        return isLowerCaseImpl(codePoint);
    }

    public static boolean isUpperCase(char ch) {
        return isUpperCase((int) ch);
    }

    public static boolean isUpperCase(int codePoint) {
        return isUpperCaseImpl(codePoint);
    }

    public static boolean isTitleCase(char ch) {
        return isTitleCase((int) ch);
    }

    public static boolean isTitleCase(int codePoint) {
        return isTitleCaseImpl(codePoint);
    }

    public static boolean isDigit(char ch) {
        return isDigit((int) ch);
    }

    public static boolean isDigit(int codePoint) {
        return isDigitImpl(codePoint);
    }

    public static boolean isDefined(char ch) {
        return isDefined((int) ch);
    }

    public static boolean isDefined(int codePoint) {
        return isDefinedImpl(codePoint);
    }

    public static boolean isLetter(char ch) {
        return isLetter((int) ch);
    }

    public static boolean isLetter(int codePoint) {
        return isLetterImpl(codePoint);
    }

    public static boolean isLetterOrDigit(char ch) {
        return isLetterOrDigit((int) ch);
    }

    public static boolean isLetterOrDigit(int codePoint) {
        return isLetterOrDigitImpl(codePoint);
    }

    @Deprecated(since = "1.1")
    public static boolean isJavaLetter(char ch) {
        return isJavaIdentifierStart(ch);
    }

    @Deprecated(since = "1.1")
    public static boolean isJavaLetterOrDigit(char ch) {
        return isJavaIdentifierPart(ch);
    }

    public static boolean isAlphabetic(int codePoint) {
        return isAlphabeticImpl(codePoint);
    }

    public static boolean isIdeographic(int codePoint) {
        return isIdeographicImpl(codePoint);
    }

    public static boolean isJavaIdentifierStart(char ch) {
        return isJavaIdentifierStart((int) ch);
    }

    public static boolean isJavaIdentifierStart(int codePoint) {
        return codePoint < 64 ? codePoint == 36 : codePoint < 128 ? ((1 << (codePoint + (-64))) & 576460745995190270L) != 0 : ((1 << getType(codePoint)) & 75498558) != 0;
    }

    public static boolean isJavaIdentifierPart(char ch) {
        return isJavaIdentifierPart((int) ch);
    }

    public static boolean isJavaIdentifierPart(int codePoint) {
        return codePoint < 64 ? ((1 << codePoint) & 287948970162897407L) != 0 : codePoint < 128 ? ((1 << (codePoint + (-64))) & (-8646911290859585538L)) != 0 : ((1 << getType(codePoint)) & 75564926) != 0 || (codePoint >= 0 && codePoint <= 8) || ((codePoint >= 14 && codePoint <= 27) || (codePoint >= 127 && codePoint <= 159));
    }

    public static boolean isUnicodeIdentifierStart(char ch) {
        return isUnicodeIdentifierStart((int) ch);
    }

    public static boolean isUnicodeIdentifierStart(int codePoint) {
        return isUnicodeIdentifierStartImpl(codePoint);
    }

    public static boolean isUnicodeIdentifierPart(char ch) {
        return isUnicodeIdentifierPart((int) ch);
    }

    public static boolean isUnicodeIdentifierPart(int codePoint) {
        return isUnicodeIdentifierPartImpl(codePoint);
    }

    public static boolean isIdentifierIgnorable(char ch) {
        return isIdentifierIgnorable((int) ch);
    }

    public static boolean isIdentifierIgnorable(int codePoint) {
        return isIdentifierIgnorableImpl(codePoint);
    }

    public static char toLowerCase(char ch) {
        return (char) toLowerCase((int) ch);
    }

    public static int toLowerCase(int codePoint) {
        if (codePoint >= 65 && codePoint <= 90) {
            return codePoint + 32;
        }
        if (codePoint < 128) {
            return codePoint;
        }
        return toLowerCaseImpl(codePoint);
    }

    public static char toUpperCase(char ch) {
        return (char) toUpperCase((int) ch);
    }

    public static int toUpperCase(int codePoint) {
        if (codePoint >= 97 && codePoint <= 122) {
            return codePoint - 32;
        }
        if (codePoint < 128) {
            return codePoint;
        }
        return toUpperCaseImpl(codePoint);
    }

    public static char toTitleCase(char ch) {
        return (char) toTitleCase((int) ch);
    }

    public static int toTitleCase(int codePoint) {
        return toTitleCaseImpl(codePoint);
    }

    public static int digit(char ch, int radix) {
        return digit((int) ch, radix);
    }

    public static int digit(int codePoint, int radix) {
        if (radix < 2 || radix > 36) {
            return -1;
        }
        if (codePoint < 128) {
            int result = -1;
            if (48 <= codePoint && codePoint <= 57) {
                result = codePoint - 48;
            } else if (97 <= codePoint && codePoint <= 122) {
                result = (codePoint - 97) + 10;
            } else if (65 <= codePoint && codePoint <= 90) {
                result = (codePoint - 65) + 10;
            }
            if (result < radix) {
                return result;
            }
            return -1;
        }
        return digitImpl(codePoint, radix);
    }

    public static int getNumericValue(char ch) {
        return getNumericValue((int) ch);
    }

    public static int getNumericValue(int codePoint) {
        if (codePoint < 128) {
            if (codePoint >= 48 && codePoint <= 57) {
                return codePoint - 48;
            }
            if (codePoint >= 97 && codePoint <= 122) {
                return codePoint - 87;
            }
            if (codePoint >= 65 && codePoint <= 90) {
                return codePoint - 55;
            }
            return -1;
        }
        if (codePoint >= 65313 && codePoint <= 65338) {
            return codePoint - 65303;
        }
        if (codePoint >= 65345 && codePoint <= 65370) {
            return codePoint - 65335;
        }
        return getNumericValueImpl(codePoint);
    }

    @Deprecated(since = "1.1")
    public static boolean isSpace(char ch) {
        return ch <= ' ' && ((13824 >> ch) & 1) != 0;
    }

    public static boolean isSpaceChar(char ch) {
        return isSpaceChar((int) ch);
    }

    public static boolean isSpaceChar(int codePoint) {
        if (codePoint == 32 || codePoint == 160) {
            return true;
        }
        if (codePoint < 4096) {
            return false;
        }
        if (codePoint == 5760 || codePoint == 6158) {
            return true;
        }
        if (codePoint < 8192) {
            return false;
        }
        if (codePoint <= 65535) {
            return codePoint <= 8202 || codePoint == 8232 || codePoint == 8233 || codePoint == 8239 || codePoint == 8287 || codePoint == 12288;
        }
        return isSpaceCharImpl(codePoint);
    }

    public static boolean isWhitespace(char ch) {
        return isWhitespace((int) ch);
    }

    public static boolean isWhitespace(int codePoint) {
        if ((codePoint >= 28 && codePoint <= 32) || (codePoint >= 9 && codePoint <= 13)) {
            return true;
        }
        if (codePoint < 4096) {
            return false;
        }
        if (codePoint == 5760 || codePoint == 6158) {
            return true;
        }
        if (codePoint < 8192 || codePoint == 8199 || codePoint == 8239) {
            return false;
        }
        if (codePoint <= 65535) {
            return codePoint <= 8202 || codePoint == 8232 || codePoint == 8233 || codePoint == 8287 || codePoint == 12288;
        }
        return isWhitespaceImpl(codePoint);
    }

    public static boolean isISOControl(char ch) {
        return isISOControl((int) ch);
    }

    public static boolean isISOControl(int codePoint) {
        return codePoint <= 159 && (codePoint >= 127 || (codePoint >>> 5) == 0);
    }

    public static int getType(char ch) {
        return getType((int) ch);
    }

    public static int getType(int codePoint) {
        int type = getTypeImpl(codePoint);
        if (type <= 16) {
            return type;
        }
        return type + 1;
    }

    public static char forDigit(int digit, int radix) {
        if (digit >= radix || digit < 0 || radix < 2 || radix > 36) {
            return (char) 0;
        }
        if (digit < 10) {
            return (char) (digit + 48);
        }
        return (char) (digit + 87);
    }

    public static byte getDirectionality(char ch) {
        return getDirectionality((int) ch);
    }

    public static byte getDirectionality(int codePoint) {
        byte directionality;
        if (getType(codePoint) != 0 && (directionality = getDirectionalityImpl(codePoint)) >= 0) {
            byte[] bArr = DIRECTIONALITY;
            if (directionality < bArr.length) {
                return bArr[directionality];
            }
        }
        return (byte) -1;
    }

    public static boolean isMirrored(char ch) {
        return isMirrored((int) ch);
    }

    public static boolean isMirrored(int codePoint) {
        return isMirroredImpl(codePoint);
    }

    @Override // java.lang.Comparable
    public int compareTo(Character anotherCharacter) {
        return compare(this.value, anotherCharacter.value);
    }

    public static int compare(char x10, char y10) {
        return x10 - y10;
    }

    public static char reverseBytes(char ch) {
        return (char) (((65280 & ch) >> 8) | (ch << '\b'));
    }

    public static String getName(int codePoint) {
        if (!isValidCodePoint(codePoint)) {
            throw new IllegalArgumentException(String.format("Not a valid Unicode code point: 0x%X", Integer.valueOf(codePoint)));
        }
        String name = getNameImpl(codePoint);
        if (name != null) {
            return name;
        }
        if (getType(codePoint) == 0) {
            return null;
        }
        UnicodeBlock block = UnicodeBlock.of(codePoint);
        if (block != null) {
            return block.toString().replace('_', ' ') + " " + Integer.toHexString(codePoint).toUpperCase(Locale.ROOT);
        }
        return Integer.toHexString(codePoint).toUpperCase(Locale.ROOT);
    }
}
