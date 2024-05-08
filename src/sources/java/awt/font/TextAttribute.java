package java.awt.font;

import androidx.appcompat.widget.ActivityChooserModel;
import com.huawei.quickcard.base.Attributes;
import java.io.InvalidObjectException;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class TextAttribute extends AttributedCharacterIterator.Attribute {
    public static final TextAttribute BACKGROUND;
    public static final TextAttribute BIDI_EMBEDDING;
    public static final TextAttribute CHAR_REPLACEMENT;
    public static final TextAttribute FONT;
    public static final TextAttribute FOREGROUND;
    public static final TextAttribute INPUT_METHOD_HIGHLIGHT;
    public static final TextAttribute INPUT_METHOD_UNDERLINE;
    public static final TextAttribute JUSTIFICATION;
    public static final Float JUSTIFICATION_FULL;
    public static final Float JUSTIFICATION_NONE;
    public static final TextAttribute KERNING;
    public static final Integer KERNING_ON;
    public static final TextAttribute LIGATURES;
    public static final Integer LIGATURES_ON;
    public static final TextAttribute NUMERIC_SHAPING;
    public static final TextAttribute POSTURE;
    public static final Float POSTURE_OBLIQUE;
    public static final Float POSTURE_REGULAR;
    public static final TextAttribute RUN_DIRECTION;
    public static final Boolean RUN_DIRECTION_LTR;
    public static final Boolean RUN_DIRECTION_RTL;
    public static final TextAttribute SIZE;
    public static final TextAttribute STRIKETHROUGH;
    public static final Boolean STRIKETHROUGH_ON;
    public static final TextAttribute SUPERSCRIPT;
    public static final Integer SUPERSCRIPT_SUB;
    public static final Integer SUPERSCRIPT_SUPER;
    public static final TextAttribute SWAP_COLORS;
    public static final Boolean SWAP_COLORS_ON;
    public static final TextAttribute TRACKING;
    public static final Float TRACKING_LOOSE;
    public static final Float TRACKING_TIGHT;
    public static final TextAttribute TRANSFORM;
    public static final TextAttribute UNDERLINE;
    public static final Integer UNDERLINE_LOW_DASHED;
    public static final Integer UNDERLINE_LOW_DOTTED;
    public static final Integer UNDERLINE_LOW_GRAY;
    public static final Integer UNDERLINE_LOW_ONE_PIXEL;
    public static final Integer UNDERLINE_LOW_TWO_PIXEL;
    public static final Integer UNDERLINE_ON;
    public static final Float WEIGHT_BOLD;
    public static final Float WEIGHT_DEMIBOLD;
    public static final Float WEIGHT_DEMILIGHT;
    public static final Float WEIGHT_EXTRABOLD;
    public static final Float WEIGHT_HEAVY;
    public static final Float WEIGHT_LIGHT;
    public static final Float WEIGHT_MEDIUM;
    public static final Float WEIGHT_REGULAR;
    public static final Float WEIGHT_SEMIBOLD;
    public static final Float WEIGHT_ULTRABOLD;
    public static final TextAttribute WIDTH;
    public static final Float WIDTH_CONDENSED;
    public static final Float WIDTH_EXTENDED;
    public static final Float WIDTH_REGULAR;
    public static final Float WIDTH_SEMI_CONDENSED;
    public static final Float WIDTH_SEMI_EXTENDED;
    static final long serialVersionUID = 7744112784117861702L;
    private static final Map<String, TextAttribute> instanceMap = new HashMap(29);
    public static final TextAttribute FAMILY = new TextAttribute("family");
    public static final TextAttribute WEIGHT = new TextAttribute(ActivityChooserModel.ATTRIBUTE_WEIGHT);
    public static final Float WEIGHT_EXTRA_LIGHT = Float.valueOf(0.5f);

    static {
        Float valueOf = Float.valueOf(0.75f);
        WEIGHT_LIGHT = valueOf;
        Float valueOf2 = Float.valueOf(0.875f);
        WEIGHT_DEMILIGHT = valueOf2;
        Float valueOf3 = Float.valueOf(1.0f);
        WEIGHT_REGULAR = valueOf3;
        Float valueOf4 = Float.valueOf(1.25f);
        WEIGHT_SEMIBOLD = valueOf4;
        Float valueOf5 = Float.valueOf(1.5f);
        WEIGHT_MEDIUM = valueOf5;
        WEIGHT_DEMIBOLD = Float.valueOf(1.75f);
        WEIGHT_BOLD = Float.valueOf(2.0f);
        WEIGHT_HEAVY = Float.valueOf(2.25f);
        WEIGHT_EXTRABOLD = Float.valueOf(2.5f);
        WEIGHT_ULTRABOLD = Float.valueOf(2.75f);
        WIDTH = new TextAttribute("width");
        WIDTH_CONDENSED = valueOf;
        WIDTH_SEMI_CONDENSED = valueOf2;
        WIDTH_REGULAR = valueOf3;
        WIDTH_SEMI_EXTENDED = valueOf4;
        WIDTH_EXTENDED = valueOf5;
        POSTURE = new TextAttribute("posture");
        Float valueOf6 = Float.valueOf(0.0f);
        POSTURE_REGULAR = valueOf6;
        POSTURE_OBLIQUE = Float.valueOf(0.2f);
        SIZE = new TextAttribute("size");
        TRANSFORM = new TextAttribute("transform");
        SUPERSCRIPT = new TextAttribute("superscript");
        SUPERSCRIPT_SUPER = 1;
        SUPERSCRIPT_SUB = -1;
        FONT = new TextAttribute("font");
        CHAR_REPLACEMENT = new TextAttribute("char_replacement");
        FOREGROUND = new TextAttribute("foreground");
        BACKGROUND = new TextAttribute(Attributes.Style.BACKGROUND);
        UNDERLINE = new TextAttribute(Attributes.Style.UNDERLINE);
        UNDERLINE_ON = 0;
        STRIKETHROUGH = new TextAttribute("strikethrough");
        STRIKETHROUGH_ON = Boolean.TRUE;
        RUN_DIRECTION = new TextAttribute("run_direction");
        RUN_DIRECTION_LTR = Boolean.FALSE;
        RUN_DIRECTION_RTL = Boolean.TRUE;
        BIDI_EMBEDDING = new TextAttribute("bidi_embedding");
        JUSTIFICATION = new TextAttribute("justification");
        JUSTIFICATION_FULL = valueOf3;
        JUSTIFICATION_NONE = valueOf6;
        INPUT_METHOD_HIGHLIGHT = new TextAttribute("input method highlight");
        INPUT_METHOD_UNDERLINE = new TextAttribute("input method underline");
        UNDERLINE_LOW_ONE_PIXEL = 1;
        UNDERLINE_LOW_TWO_PIXEL = 2;
        UNDERLINE_LOW_DOTTED = 3;
        UNDERLINE_LOW_GRAY = 4;
        UNDERLINE_LOW_DASHED = 5;
        SWAP_COLORS = new TextAttribute("swap_colors");
        SWAP_COLORS_ON = Boolean.TRUE;
        NUMERIC_SHAPING = new TextAttribute("numeric_shaping");
        KERNING = new TextAttribute("kerning");
        KERNING_ON = 1;
        LIGATURES = new TextAttribute("ligatures");
        LIGATURES_ON = 1;
        TRACKING = new TextAttribute("tracking");
        TRACKING_TIGHT = Float.valueOf(-0.04f);
        TRACKING_LOOSE = Float.valueOf(0.04f);
    }

    protected TextAttribute(String name) {
        super(name);
        if (getClass() == TextAttribute.class) {
            instanceMap.put(name, this);
        }
    }

    @Override // java.text.AttributedCharacterIterator.Attribute
    protected Object readResolve() throws InvalidObjectException {
        if (getClass() != TextAttribute.class) {
            throw new InvalidObjectException("subclass didn't correctly implement readResolve");
        }
        TextAttribute instance = instanceMap.get(getName());
        if (instance != null) {
            return instance;
        }
        throw new InvalidObjectException("unknown attribute name");
    }
}
