package com.huawei.quickcard.base;

import com.huawei.quickcard.base.log.CardLogUtils;
import com.kuaishou.weapon.p0.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Attributes {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33286a = "Attrs";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AnimationCommons {
        public static final String DEFAULT_ANIMATION_FILL_MODE = "none";
        public static final int DEFAULT_COUNT = 1;
        public static final String DEFAULT_TIME = "0";
        public static final String DEFAULT_TIMING_FUNCTION = "ease";
        public static final String DEFAULT_TRANSFORM_ORIGIN = "50% 50% 0";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AnimationStyle {
        public static final String ANIMATION_DELAY = "animationDelay";
        public static final String ANIMATION_DURATION = "animationDuration";
        public static final String ANIMATION_FILL_MODE = "animationFillMode";
        public static final String ANIMATION_ITERATION_COUNT = "animationIterationCount";
        public static final String ANIMATION_NAME = "animationName";
        public static final String ANIMATION_TIMING_FUNCTION = "animationTimingFunction";
        public static final String TRANSFORM = "transform";
        public static final String TRANSFORM_ORIGIN = "transformOrigin";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AnimationTiming {
        public static final String EASE = "ease";
        public static final String EASE_IN = "ease-in";
        public static final String EASE_IN_OUT = "ease-in-out";
        public static final String EASE_OUT = "ease-out";
        public static final String EASING_CUBIC = "cubic-bezier";
        public static final String LINEAR = "linear";
        public static final String STEPS = "steps";
        public static final String STEP_END = "step-end";
        public static final String STEP_START = "step-start";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Component {
        public static final String DIV = "div";
        public static final String IMAGE = "image";
        public static final String LIST = "list";
        public static final String LIST_ITEM = "list-item";
        public static final String PROGRESS_CIRCULAR = "progress_circular";
        public static final String PROGRESS_DEFAULT = "progress";
        public static final String PROGRESS_HORIZONTAL = "progress_horizontal";
        public static final String ROOT = "_root";
        public static final String STACK = "stack";
        public static final String TEXT = "text";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Display {
        public static final String FLEX = "flex";
        public static final String NONE = "none";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Event {
        public static final String APPEAR = "appear";
        public static final String BLUR = "blur";
        public static final String CHANGE = "change";
        public static final String CLICK = "click";
        public static final String DISAPPEAR = "disappear";
        public static final String FOCUS = "focus";
        public static final String FULLSCREEN_CHANGE = "fullscreenchange";
        public static final String IMAGE_COMPLETE = "complete";
        public static final String IMAGE_ERROR = "error";
        public static final String LIST_SCROLL = "scroll";
        public static final String LIST_SCROLL_BOTTOM = "scrollbottom";
        public static final String LIST_SCROLL_END = "scrollend";
        public static final String LIST_SCROLL_TOP = "scrolltop";
        public static final String LIST_SCROLL_TOUCHUP = "scrolltouchup";
        public static final String LONGPRESS = "longpress";
        public static final String REFRESH = "refresh";
        public static final String SCROLL = "scroll";
        public static final String SCROLL_BOTTOM = "scrollbottom";
        public static final String SCROLL_TOP = "scrolltop";
        public static final String SWIPE = "swipe";
        public static final String TOUCHCANCEL = "touchcancel";
        public static final String TOUCHEND = "touchend";
        public static final String TOUCHMOVE = "touchmove";
        public static final String TOUCHSTART = "touchstart";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ImageMode {
        public static final String CONTAIN = "contain";
        public static final String COVER = "cover";
        public static final String FILL = "fill";
        public static final String NONE = "none";
        public static final String SCALE_DOWN = "scaleDown";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InputType {
        public static final String BUTTON = "button";
        public static final String CHECK_BOX = "checkbox";
        public static final String DATE = "date";
        public static final String EMAIL = "email";
        public static final String NUMBER = "number";
        public static final String PASSWORD = "password";
        public static final String TEXT = "text";
        public static final String TIME = "time";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface LayoutDegrees {
        public static final int PI = 180;
        public static final int ZERO = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface LayoutDirection {
        public static final String AUTO = "auto";
        public static final String LTR = "ltr";
        public static final String RTL = "rtl";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Mode {
        public static final String FIXED = "fixed";
        public static final String SCROLLABLE = "scrollable";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface PickerType {
        public static final String DATE = "date";
        public static final String MULTI_TEXT = "multi-text";
        public static final String TEXT = "text";
        public static final String TIME = "time";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Position {
        public static final String FIXED = "fixed";
        public static final String NONE = "none";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ProgressType {
        public static final String CIRCULAR = "circular";
        public static final String HORIZONTAL = "horizontal";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface SelfStyle {
        public static final String FORCE_REFRESH = "forceRefresh";
        public static final String OUTLINE = "outline";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Style {
        public static final String ACTIONS = "actions";
        public static final String ACTIVE = "active";
        public static final String ALIGN_CONTENT = "alignContent";
        public static final String ALIGN_ITEMS = "alignItems";
        public static final String ALIGN_SELF = "alignSelf";
        public static final String ALT = "alt";
        public static final String ALT_OBJECT_FIT = "altObjectFit";
        public static final String ANIMATION_DELAY = "animationDelay";
        public static final String ANIMATION_DURATION = "animationDuration";
        public static final String ANIMATION_FILL_MODE = "animationFillMode";
        public static final String ANIMATION_ITERATION_COUNT = "animationIterationCount";
        public static final String ANIMATION_KEYFRAMES = "animationKeyframes";
        public static final String ANIMATION_TIMING_FUNCTION = "animationTimingFunction";
        public static final String ASPECT_RATIO = "aspectRatio";
        public static final String AUTO_PLAY = "autoplay";
        public static final String BACKGROUND = "background";
        public static final String BACKGROUND_COLOR = "backgroundColor";
        public static final String BACKGROUND_IMAGE = "backgroundImage";
        public static final String BACKGROUND_POSITION = "backgroundPosition";
        public static final String BACKGROUND_REPEAT = "backgroundRepeat";
        public static final String BACKGROUND_SIZE = "backgroundSize";
        public static final String BLOCK_COLOR = "blockColor";
        public static final String BLUR = "blur";
        public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
        public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
        public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
        public static final String BORDER_BOTTOM_STYLE = "borderBottomStyle";
        public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
        public static final String BORDER_COLOR = "borderColor";
        public static final String BORDER_LEFT_COLOR = "borderLeftColor";
        public static final String BORDER_LEFT_STYLE = "borderLeftStyle";
        public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
        public static final String BORDER_RADIUS = "borderRadius";
        public static final String BORDER_RIGHT_COLOR = "borderRightColor";
        public static final String BORDER_RIGHT_STYLE = "borderRightStyle";
        public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
        public static final String BORDER_STYLE = "borderStyle";
        public static final String BORDER_TOP_COLOR = "borderTopColor";
        public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
        public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
        public static final String BORDER_TOP_STYLE = "borderTopStyle";
        public static final String BORDER_TOP_WIDTH = "borderTopWidth";
        public static final String BORDER_WIDTH = "borderWidth";
        public static final String BOTTOM = "bottom";
        public static final String CHECKED = "checked";
        public static final String CLIP_X = "clipX";
        public static final String CLIP_Y = "clipY";
        public static final String COLOR = "color";
        public static final String COLUMNS = "columns";
        public static final String COLUMN_SPAN = "columnSpan";
        public static final String CONTENT = "content";
        public static final String CONTENT_DESCRIPTION = "ariaLabel";
        public static final String CONTENT_DESCRIPTION_ACTION = "ariaAction";
        public static final String CONTENT_DESCRIPTION_LIVE = "ariaLive";
        public static final String CONTENT_DESCRIPTION_SWITCH = "ariaUnfocusable";
        public static final String DIR = "dir";
        public static final String DIRECTION = "flexDirection";
        public static final String DISABLED = "disabled";
        public static final String DISPLAY = "display";
        public static final String ENABLE = "enable";
        public static final String END = "end";
        public static final String EXPOSURE = "exposure";
        public static final String EXTEND_EXPOSURE = "extendExposure";
        public static final String FILTER = "filter";
        public static final String FLEX = "flex";
        public static final String FLEX_BASIS = "flexBasis";
        public static final String FLEX_DIRECTION = "flexDirection";
        public static final String FLEX_GROW = "flexGrow";
        public static final String FLEX_SHRINK = "flexShrink";
        public static final String FLEX_WRAP = "flexWrap";
        public static final String FOCUSABLE = "focusable";
        public static final String FONT_FAMILY = "fontFamily";
        public static final String FONT_SIZE = "fontSize";
        public static final String FONT_STYLE = "fontStyle";
        public static final String FONT_WEIGHT = "fontWeight";
        public static final String FOOL_PROOFING_TIME = "foolProofingTime";
        public static final String HEIGHT = "height";
        public static final String HREF = "href";
        public static final String ID = "id";
        public static final String INDEX = "index";
        public static final String INDICATOR_COLOR = "indicatorColor";
        public static final String INDICATOR_ENABLED = "indicator";
        public static final String INDICATOR_SELECTED_COLOR = "indicatorSelectedColor";
        public static final String INDICATOR_SIZE = "indicatorSize";
        public static final String INTERVAL = "interval";
        public static final String JUSTIFY_CONTENT = "justifyContent";
        public static final String LAYER_COLOR = "layerColor";
        public static final String LEFT = "left";
        public static final String LETTER_SPACING = "letterSpacing";
        public static final String LINES = "lines";
        public static final String LINE_HEIGHT = "lineHeight";
        public static final String LIST_BOUNCE = "bounce";
        public static final String LIST_COLUMNS = "columns";
        public static final String LIST_LAYOUT_TYPE = "layoutType";
        public static final String LIST_SNAP_GRAVITY = "snapgravity";
        public static final String LIST_SNAP_MODE = "snapmode";
        public static final String LIST_SNAP_OFFSET = "snapoffset";
        public static final String LOCKED_DENSITY = "lockedDensity";
        public static final String MARGIN = "margin";
        public static final String MARGIN_BOTTOM = "marginBottom";
        public static final String MARGIN_INLINE_END = "marginInlineEnd";
        public static final String MARGIN_INLINE_START = "marginInlineStart";
        public static final String MARGIN_LEFT = "marginLeft";
        public static final String MARGIN_RIGHT = "marginRight";
        public static final String MARGIN_TOP = "marginTop";
        public static final String MAX = "max";
        public static final String MAX_HEIGHT = "maxHeight";
        public static final String MAX_WIDTH = "maxWidth";
        public static final String MIN = "min";
        public static final String MIN_HEIGHT = "minHeight";
        public static final String MIN_WIDTH = "minWidth";
        public static final String MODE = "mode";
        public static final String NAME = "name";
        public static final String NET_WORK_ENHANCE = "networkenhance";
        public static final String NO_CACHE = "noCache";
        public static final String OBJECT_FIT = "objectFit";
        public static final String OFFSET = "offset";
        public static final String OPACITY = "opacity";
        public static final String PADDING = "padding";
        public static final String PADDING_BOTTOM = "paddingBottom";
        public static final String PADDING_INLINE_END = "paddingInlineEnd";
        public static final String PADDING_INLINE_START = "paddingInlineStart";
        public static final String PADDING_LEFT = "paddingLeft";
        public static final String PADDING_RIGHT = "paddingRight";
        public static final String PADDING_TOP = "paddingTop";
        public static final String PERCENT = "percent";
        public static final String PLACEHOLDER = "placeholder";
        public static final String PLACEHOLDER_COLOR = "placeholderColor";
        public static final String POSITION = "position";
        public static final String PROGRESS_COLOR = "progressColor";
        public static final String RANGE = "range";
        public static final String REFRESHING = "refreshing";
        public static final String RESIZE_MODE = "resizeMode";
        public static final String RIGHT = "right";
        public static final String SCROLL_PAGE = "scrollpage";
        public static final String SELECTABLE = "selectable";
        public static final String SELECTED = "selected";
        public static final String SELECTED_COLOR = "selectedColor";
        public static final String SHOW = "show";
        public static final String SMOOTH = "smooth";
        public static final String SRC = "src";
        public static final String START = "start";
        public static final String STEP = "step";
        public static final String STROKE_WIDTH = "strokeWidth";
        public static final String TABMODE = "tabmode";
        public static final String TAG = "tag";
        public static final String TARGET = "target";
        public static final String TEXT_ALIGN = "textAlign";
        public static final String TEXT_DECORATION = "textDecoration";
        public static final String TEXT_INDENT = "textIndent";
        public static final String TEXT_OVERFLOW = "textOverflow";
        public static final String TOP = "top";
        public static final String TRANSFORM = "transform";
        public static final String TRANSFORM_ORIGIN = "transformOrigin";
        public static final String TYPE = "type";
        public static final String UNDERLINE = "underline";
        public static final String VALUE = "value";
        public static final String VISIBILITY = "visibility";
        public static final String WIDTH = "width";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface TextOverflow {
        public static final String CLIP = "clip";
        public static final String ELLIPSIS = "ellipsis";
        public static final String STRING = "string";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface TextType {
        public static final String HTML = "html";
        public static final String TEXT = "text";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface UiMode {
        public static final String DARK = "dark";
        public static final String LIGHT = "light";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Visibility {
        public static final String HIDDEN = "hidden";
        public static final String VISIBLE = "visible";
    }

    private Attributes() {
    }

    private static int a(String str, int i10) {
        return (int) ((Float.parseFloat(str) / 100.0f) * i10);
    }

    public static float getFloat(Object obj, float f10) {
        if (obj == null || "".equals(obj)) {
            return f10;
        }
        String trim = obj.toString().trim();
        if (trim.endsWith(t.f36232q)) {
            trim = trim.substring(0, trim.length() - 2);
        }
        try {
            return Float.parseFloat(trim);
        } catch (NumberFormatException unused) {
            return f10;
        }
    }

    public static int getInt(Object obj, int i10) {
        if (obj == null) {
            return i10;
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public static float getPercent(String str, float f10) {
        if (str != null && !"".equals(str)) {
            if (str.endsWith("%")) {
                str = str.substring(0, str.length() - 1);
            }
            try {
                return Float.parseFloat(str) / 100.0f;
            } catch (NumberFormatException e2) {
                CardLogUtils.e(f33286a, "parse percent failed", e2);
            }
        }
        return f10;
    }

    public static String getString(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    public static int parseUnitOrPercent(String str, int i10) {
        try {
            int lastIndexOf = str.lastIndexOf(37);
            if (lastIndexOf != -1) {
                return a(str.substring(0, lastIndexOf), i10);
            }
            int lastIndexOf2 = str.lastIndexOf(46);
            if (lastIndexOf2 != -1) {
                return Integer.parseInt(str.substring(0, lastIndexOf2));
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            CardLogUtils.e(f33286a, "parse unit or percent fail", e2);
            return -1;
        }
    }

    public static String getString(Object obj) {
        return getString(obj, null);
    }

    public static float getPercent(String str) {
        return getPercent(str, -1.0f);
    }
}
