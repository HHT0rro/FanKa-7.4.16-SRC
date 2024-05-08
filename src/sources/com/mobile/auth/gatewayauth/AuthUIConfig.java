package com.mobile.auth.gatewayauth;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import com.mobile.auth.gatewayauth.annotations.AuthNumber;
import java.io.Serializable;

@AuthNumber
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AuthUIConfig implements Serializable {
    public static int DEFAULT_BOTTOM_NAV_COLOR = -16777216;
    public static int DEFAULT_LOGIN_BTN_TEXT_COLOR = -1;
    public static int DEFAULT_NAV_COLOR = -16617774;
    public static int DEFAULT_NAV_TEXT_COLOR = -1;
    public static int DEFAULT_NUMBER_COLOR = -16777216;
    public static int DEFAULT_PROTOCOL_COLOR = -6710887;
    public static int DEFAULT_PROTOCOL_ONE_COLOR = -13070867;
    public static int DEFAULT_PROTOCOL_THREE_COLOR = -13070867;
    public static int DEFAULT_PROTOCOL_TWO_COLOR = -13070867;
    public static int DEFAULT_SLOGAN_TEXT_COLOR = -6710887;
    public static int DEFAULT_STATUS_BAR_COLOR = -1;
    public static int DEFAULT_SWITCH_ACC_TEXT_COLOR = -10066330;
    public static int DEFAULT_WEB_NAV_COLOR = -16617774;
    public static int DEFAULT_WEB_NAV_TEXT_COLOR = -1;
    public static int DEFAULT_WEB_STATUS_BAR_COLOR = -1;
    public static final int DP_MODE = 1073741824;
    private static final int MODE_MASK = -1073741824;
    private static final int MODE_SHIFT = 30;
    public static final int SP_MODE = 0;
    private String activityIn;
    private String activityOut;
    private String authPageActIn;
    private String authPageActOut;
    private int bottomNavBarColor;
    private int checkBoxHeight;
    private int checkBoxMarginTop;
    private String checkBoxShakePath;
    private int checkBoxWidth;
    private boolean checkboxHidden;
    private Drawable checkedImgDrawable;
    private String checkedImgPath;
    private float dialogAlpha;
    private boolean dialogBottom;
    private int dialogHeight;
    private int dialogOffsetX;
    private int dialogOffsetY;
    private int dialogWidth;
    private boolean isHiddenLoading;
    private boolean isLightColor;
    private boolean isStatusBarHidden;
    private Drawable loadingBackgroundDrawable;
    private String loadingBackgroundPath;
    private Drawable loadingImgDrawable;
    private String loadingImgPath;
    private Drawable logBtnBackgroundDrawable;
    private String logBtnBackgroundPath;
    private StateListDrawable logBtnBgStateListDrawable;
    private String logBtnFontName;
    private int logBtnHeight;
    private int logBtnLayoutGravity;
    private int logBtnMarginLeftAndRight;
    private int logBtnOffsetX;
    private int logBtnOffsetY;
    private int logBtnOffsetY_B;
    private String logBtnText;
    private int logBtnTextColor;
    private ColorStateList logBtnTextColorStateList;
    private int logBtnTextSize;
    private boolean logBtnToastHidden;
    private Typeface logBtnTypeface;
    private boolean logBtnUseFont;
    private int logBtnWidth;
    private int logoHeight;
    private boolean logoHidden;
    private Drawable logoImgDrawable;
    private String logoImgPath;
    private int logoOffsetY;
    private int logoOffsetY_B;
    private ImageView.ScaleType logoScaleType;
    private int logoWidth;
    private int navColor;
    private String navFontName;
    private boolean navHidden;
    private boolean navReturnHidden;
    private Drawable navReturnImgDrawable;
    private int navReturnImgHeight;
    private String navReturnImgPath;
    private int navReturnImgWidth;
    private ImageView.ScaleType navReturnScaleType;
    private String navText;
    private int navTextColor;
    private int navTextSize;
    private Typeface navTypeFace;
    private boolean navUseFont;
    private int numFieldOffsetY;
    private int numFieldOffsetY_B;
    private int numberColor;
    private int numberFieldOffsetX;
    private String numberFontName;
    private int numberLayoutGravity;
    private int numberSize;
    private Typeface numberTypeface;
    private boolean numberUseFont;
    private String packageName;
    private Drawable pageBackgroundDrawable;
    private String pageBackgroundPath;
    private int privacyAlertAlignment;
    private float privacyAlertAlpha;
    private int privacyAlertBackgroundColor;
    private String privacyAlertBefore;
    private Drawable privacyAlertBtnBackgroundImgDrawable;
    private String privacyAlertBtnBackgroundImgPath;
    private StateListDrawable privacyAlertBtnBgStateListDrawable;
    private String privacyAlertBtnFontName;
    private int[] privacyAlertBtnGrivaty;
    private int privacyAlertBtnHeigth;
    private int privacyAlertBtnHorizontalMargin;
    private int privacyAlertBtnOffsetX;
    private int privacyAlertBtnOffsetY;
    private String privacyAlertBtnText;
    private int privacyAlertBtnTextColor;
    private String privacyAlertBtnTextColorPath;
    private ColorStateList privacyAlertBtnTextColorStateList;
    private int privacyAlertBtnTextSize;
    private Typeface privacyAlertBtnTypeface;
    private boolean privacyAlertBtnUseFont;
    private int privacyAlertBtnVerticalMargin;
    private int privacyAlertBtnWidth;
    private boolean privacyAlertCloseBtnShow;
    private Drawable privacyAlertCloseImagDrawable;
    private String privacyAlertCloseImagPath;
    private int privacyAlertCloseImgHeight;
    private int privacyAlertCloseImgWidth;
    private ImageView.ScaleType privacyAlertCloseScaleType;
    private int privacyAlertContentAlignment;
    private int privacyAlertContentBackgroundColor;
    private int privacyAlertContentBaseColor;
    private int privacyAlertContentColor;
    private int privacyAlertContentHorizontalMargin;
    private String privacyAlertContentTextFontName;
    private int privacyAlertContentTextSize;
    private boolean privacyAlertContentTextUseFont;
    private Typeface privacyAlertContentTypeface;
    private int privacyAlertContentVerticalMargin;
    private int[] privacyAlertCornerRadiusArray;
    private String privacyAlertEnd;
    private String privacyAlertEntryAnimation;
    private String privacyAlertExitAnimation;
    private int privacyAlertHeight;
    private boolean privacyAlertIsNeedAutoLogin;
    private boolean privacyAlertIsNeedShow;
    private float privacyAlertMaskAlpha;
    private int privacyAlertMaskColor;
    private boolean privacyAlertMaskIsNeedShow;
    private int privacyAlertOffsetX;
    private int privacyAlertOffsetY;
    private int privacyAlertOperatorColor;
    private int privacyAlertOwnOneColor;
    private int privacyAlertOwnThreeColor;
    private int privacyAlertOwnTwoColor;
    private int privacyAlertProtocolLineSpaceDp;
    private Typeface privacyAlertProtocolNameTypeface;
    private boolean privacyAlertProtocolNameUseUnderLine;
    private int privacyAlertTitleAlignment;
    private int privacyAlertTitleBackgroundColor;
    private int privacyAlertTitleColor;
    private int privacyAlertTitleOffsetX;
    private int privacyAlertTitleOffsetY;
    private String privacyAlertTitleText;
    private String privacyAlertTitleTextFontName;
    private int privacyAlertTitleTextSize;
    private boolean privacyAlertTitleTextUseFont;
    private Typeface privacyAlertTitleTypeface;
    private int privacyAlertWidth;
    private String privacyBefore;
    private String[] privacyConectTexts;
    private String privacyEnd;
    private int privacyMargin;
    private int privacyOffsetX;
    private int privacyOffsetY;
    private int privacyOffsetY_B;
    private int privacyOperatorIndex;
    private boolean privacyState;
    private int privacyTextSize;
    private String protocolAction;
    private int protocolColor;
    private String protocolFontName;
    private int protocolGravity;
    private int protocolLayoutGravity;
    private int protocolLineSpaceDp;
    private Typeface protocolNameTypeface;
    private boolean protocolNameUseUnderLine;
    private int protocolOneColor;
    private String protocolOneName;
    private String protocolOneURL;
    private int protocolOwnColor;
    private int protocolOwnOneColor;
    private int protocolOwnThreeColor;
    private int protocolOwnTwoColor;
    private String protocolShakePath;
    private int protocolThreeColor;
    private String protocolThreeName;
    private String protocolThreeURL;
    private int protocolTwoColor;
    private String protocolTwoName;
    private String protocolTwoURL;
    private Typeface protocolTypeface;
    private boolean protocolUseFont;
    private int screenOrientation;
    private String sloganFontName;
    private boolean sloganHidden;
    private int sloganOffsetY;
    private int sloganOffsetY_B;
    private String sloganText;
    private int sloganTextColor;
    private int sloganTextSize;
    private Typeface sloganTypeface;
    private boolean sloganUseFont;
    private int statusBarColor;
    private int statusBarUIFlag;
    private boolean switchAccHidden;
    private String switchAccText;
    private int switchAccTextColor;
    private ColorStateList switchAccTextColorStateList;
    private int switchAccTextSize;
    private int switchOffsetY;
    private int switchOffsetY_B;
    private String swtichFontName;
    private Typeface swtichTypeface;
    private boolean swtichUseFont;
    private boolean tapAuthPageMaskClosePage;
    private boolean tapPrivacyAlertMaskCloseAlert;
    private Drawable uncheckedImgDrawable;
    private String uncheckedImgPath;
    private String vendorPrivacyPrefix;
    private String vendorPrivacySuffix;
    private int webCacheMode;
    private boolean webHiddeProgress;
    private int webNavColor;
    private Drawable webNavReturnImgDrawable;
    private String webNavReturnImgPath;
    private int webNavTextColor;
    private int webNavTextSize;
    private boolean webSupportedJavascript;
    private int webViewStatusBarColor;

    @AuthNumber
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {
        private Drawable checkedImgDrawable;
        private boolean isHiddenLoading;
        private Drawable loadingBackgroundDrawable;
        private String loadingBackgroundPath;
        private Drawable loadingImgDrawable;
        private Drawable logBtnBackgroundDrawable;
        private Drawable logoImgDrawable;
        private Drawable navReturnImgDrawable;
        private String packageName;
        private Drawable pageBackgroundDrawable;
        private String privacyAlertBtnTextColorPath;
        private int privacyAlertBtnWidth;
        private Drawable privacyAlertCloseImagDrawable;
        private String privacyAlertCloseImagPath;
        private int privacyAlertContentHorizontalMargin;
        private int privacyAlertContentVerticalMargin;
        private int[] privacyAlertCornerRadiusArray;
        private int privacyAlertTitleOffsetX;
        private int privacyAlertTitleOffsetY;
        private String[] privacyConectTexts;
        private int privacyOffsetX;
        private String protocolAction;
        private Drawable uncheckedImgDrawable;
        private Drawable webNavReturnImgDrawable;
        private int statusBarColor = AuthUIConfig.DEFAULT_STATUS_BAR_COLOR;
        private int bottomNavColor = AuthUIConfig.DEFAULT_BOTTOM_NAV_COLOR;
        private boolean isLightColor = false;
        private boolean isStatusBarHidden = false;
        private int statusBarUIFlag = -1;
        private int navColor = AuthUIConfig.DEFAULT_NAV_COLOR;
        private String navText = "免密登录";
        private int navTextColor = AuthUIConfig.DEFAULT_NAV_TEXT_COLOR;
        private String navReturnImgPath = "authsdk_return_bg";
        private boolean navUseFont = false;
        private String navFontName = null;
        private Typeface navTypeFace = null;
        private int navReturnImgWidth = 30;
        private int navReturnImgHeight = 30;
        private boolean navReturnHidden = false;
        private ImageView.ScaleType navReturnScaleType = ImageView.ScaleType.CENTER;
        private boolean navHidden = false;
        private String logoImgPath = null;
        private boolean logoHidden = false;
        private int numberColor = AuthUIConfig.DEFAULT_NUMBER_COLOR;
        private int numberSize = makeTextSizeSpec(28, 1073741824);
        private boolean numberUseFont = false;
        private Typeface numberTypeface = null;
        private String numberFontName = null;
        private boolean switchAccHidden = false;
        private int switchAccTextColor = AuthUIConfig.DEFAULT_SWITCH_ACC_TEXT_COLOR;
        private ColorStateList switchAccTextColorStateList = null;
        private String logBtnText = "一键登录";
        private boolean logBtnUseFont = false;
        private Typeface logBtnTypeface = null;
        private String logBtnFontName = null;
        private int logBtnTextSize = makeTextSizeSpec(16, 1073741824);
        private int logBtnTextColor = AuthUIConfig.DEFAULT_LOGIN_BTN_TEXT_COLOR;
        private String protocolOneName = null;
        private String protocolOneURL = null;
        private int protocolOneColor = AuthUIConfig.DEFAULT_PROTOCOL_ONE_COLOR;
        private int protocolOwnOneColor = 0;
        private int protocolOwnTwoColor = 0;
        private int protocolOwnThreeColor = 0;
        private String protocolTwoName = null;
        private String protocolTwoURL = null;
        private int protocolTwoColor = AuthUIConfig.DEFAULT_PROTOCOL_TWO_COLOR;
        private int protocolColor = AuthUIConfig.DEFAULT_PROTOCOL_COLOR;
        private int protocolOwnColor = 0;
        private int protocolLayoutGravity = 1;
        private int sloganTextColor = AuthUIConfig.DEFAULT_SLOGAN_TEXT_COLOR;
        private String sloganText = null;
        private boolean sloganUseFont = false;
        private Typeface sloganTypeface = null;
        private String sloganFontName = null;
        private String logBtnBackgroundPath = null;
        private String loadingImgPath = "authsdk_waiting_icon";
        private int sloganOffsetY = -1;
        private int logoOffsetY = -1;
        private int logoOffsetY_B = -1;
        private ImageView.ScaleType logoScaleType = ImageView.ScaleType.FIT_XY;
        private int numFieldOffsetY = -1;
        private int numFieldOffsetY_B = -1;
        private int numberFieldOffsetX = 0;
        private int numberLayoutGravity = 1;
        private int switchOffsetY = -1;
        private int switchOffsetY_B = -1;
        private int logBtnOffsetY = -1;
        private int logBtnOffsetY_B = -1;
        private int logBtnWidth = -1;
        private int logBtnHeight = 51;
        private int logBtnOffsetX = 0;
        private int logBtnMarginLeftAndRight = 28;
        private int logBtnLayoutGravity = 1;
        private int privacyOffsetY = -1;
        private int privacyOffsetY_B = 28;
        private int sloganOffsetY_B = -1;
        private int checkBoxWidth = 18;
        private int checkBoxHeight = 18;
        private int checkBoxMarginTop = 0;
        private boolean checkboxHidden = false;
        private int navTextSize = makeTextSizeSpec(18, 1073741824);
        private int logoWidth = 90;
        private int logoHeight = 90;
        private int switchAccTextSize = makeTextSizeSpec(16, 1073741824);
        private String switchAccText = "切换到其他方式";
        private boolean swtichUseFont = false;
        private Typeface swtichTypeface = null;
        private String swtichFontName = null;
        private int sloganTextSize = makeTextSizeSpec(16, 1073741824);
        private boolean sloganHidden = false;
        private String uncheckedImgPath = "authsdk_checkbox_uncheck_bg";
        private String checkedImgPath = "authsdk_checkbox_checked_bg";
        private boolean privacyState = false;
        private int protocolGravity = 17;
        private int privacyTextSize = makeTextSizeSpec(12, 1073741824);
        private int privacyMargin = 28;
        private String privacyBefore = "";
        private String privacyEnd = "";
        private String vendorPrivacyPrefix = "";
        private String vendorPrivacySuffix = "";
        private int dialogWidth = -1;
        private int dialogHeight = -1;
        private boolean dialogBottom = false;
        private int dialogOffsetX = 0;
        private int dialogOffsetY = 0;
        private String pageBackgroundPath = null;
        private int webViewStatusBarColor = AuthUIConfig.DEFAULT_WEB_STATUS_BAR_COLOR;
        private int webNavColor = AuthUIConfig.DEFAULT_WEB_NAV_COLOR;
        private int webNavTextColor = AuthUIConfig.DEFAULT_WEB_NAV_TEXT_COLOR;
        private int webNavTextSize = -1;
        private String webNavReturnImgPath = null;
        private boolean webSupportedJavascript = true;
        private int webCacheMode = -1;
        private boolean webHiddeProgress = false;
        private String authPageActIn = null;
        private String activityOut = null;
        private String authPageActOut = null;
        private String activityIn = null;
        private String protocolShakePath = null;
        private String checkBoxShakePath = null;
        private int screenOrientation = -1;
        private boolean logBtnToastHidden = false;
        private float dialogAlpha = -1.0f;
        private String protocolThreeName = null;
        private String protocolThreeURL = null;
        private int protocolThreeColor = AuthUIConfig.DEFAULT_PROTOCOL_THREE_COLOR;
        private int privacyOperatorIndex = 0;
        private boolean protocolUseFont = false;
        private Typeface protocolTypeface = null;
        private String protocolFontName = null;
        private Typeface protocolNameTypeface = null;
        private boolean protocolNameUseUnderLine = false;
        private int protocolLineSpaceDp = -1;
        private StateListDrawable logBtnBgStateListDrawable = null;
        private ColorStateList logBtnTextColorStateList = null;
        private boolean tapAuthPageMaskClosePage = false;
        private boolean privacyAlertIsNeedShow = false;
        private boolean privacyAlertIsNeedAutoLogin = true;
        private boolean tapPrivacyAlertMaskCloseAlert = true;
        private int privacyAlertAlignment = -1;
        private int privacyAlertWidth = 160;
        private int privacyAlertHeight = 90;
        private int privacyAlertOffsetX = 0;
        private int privacyAlertOffsetY = 0;
        private String privacyAlertEntryAnimation = null;
        private String privacyAlertExitAnimation = null;
        private int privacyAlertBackgroundColor = Color.parseColor("#FFFFFF");
        private int privacyAlertTitleBackgroundColor = -1;
        private float privacyAlertAlpha = 1.0f;
        private float privacyAlertMaskAlpha = 0.3f;
        private int privacyAlertMaskColor = -16777216;
        private int privacyAlertTitleTextSize = makeTextSizeSpec(18, 1073741824);
        private int privacyAlertTitleColor = -16777216;
        private String privacyAlertTitleText = "请阅读并同意以下条款";
        private boolean privacyAlertTitleTextUseFont = false;
        private Typeface privacyAlertTitleTypeface = null;
        private String privacyAlertTitleTextFontName = null;
        private int privacyAlertTitleAlignment = 17;
        private int privacyAlertContentTextSize = makeTextSizeSpec(16, 1073741824);
        private boolean privacyAlertContentTextUseFont = false;
        private Typeface privacyAlertContentTypeface = null;
        private String privacyAlertContentTextFontName = null;
        private Typeface privacyAlertProtocolNameTypeface = null;
        private boolean privacyAlertProtocolNameUseUnderLine = false;
        private int privacyAlertContentColor = 0;
        private int privacyAlertContentBaseColor = 0;
        private int privacyAlertOwnOneColor = 0;
        private int privacyAlertOwnTwoColor = 0;
        private int privacyAlertOwnThreeColor = 0;
        private int privacyAlertOperatorColor = 0;
        private int privacyAlertProtocolLineSpaceDp = -1;
        private String privacyAlertBefore = "";
        private String privacyAlertEnd = "";
        private int privacyAlertContentBackgroundColor = -1;
        private int privacyAlertContentAlignment = 3;
        private String privacyAlertBtnBackgroundImgPath = null;
        private StateListDrawable privacyAlertBtnBgStateListDrawable = null;
        private Drawable privacyAlertBtnBackgroundImgDrawable = null;
        private int privacyAlertBtnTextColor = -16777216;
        private ColorStateList privacyAlertBtnTextColorStateList = null;
        private int privacyAlertBtnTextSize = makeTextSizeSpec(14, 1073741824);
        private int[] privacyAlertBtnGrivaty = {13};
        private int privacyAlertBtnOffsetX = -1;
        private int privacyAlertBtnOffsetY = -1;
        private String privacyAlertBtnText = "同意并继续";
        private boolean privacyAlertBtnUseFont = false;
        private Typeface privacyAlertBtnTypeface = null;
        private String privacyAlertBtnFontName = null;
        private int privacyAlertBtnHorizontalMargin = 0;
        private int privacyAlertBtnVerticalMargin = 0;
        private int privacyAlertBtnHeigth = 60;
        private boolean privacyAlertCloseBtnShow = true;
        private boolean privacyAlertMaskIsNeedShow = true;
        private ImageView.ScaleType privacyAlertCloseScaleType = ImageView.ScaleType.CENTER;
        private int privacyAlertCloseImgWidth = 30;
        private int privacyAlertCloseImgHeight = 30;

        public static /* synthetic */ int access$000(Builder builder) {
            try {
                return builder.statusBarColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$100(Builder builder) {
            try {
                return builder.bottomNavColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$1000(Builder builder) {
            try {
                return builder.navFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$10000(Builder builder) {
            try {
                return builder.webNavColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$10100(Builder builder) {
            try {
                return builder.webNavTextColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$10200(Builder builder) {
            try {
                return builder.webNavTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$10300(Builder builder) {
            try {
                return builder.webNavReturnImgPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$10400(Builder builder) {
            try {
                return builder.authPageActIn;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$10500(Builder builder) {
            try {
                return builder.activityOut;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$10600(Builder builder) {
            try {
                return builder.authPageActOut;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$10700(Builder builder) {
            try {
                return builder.activityIn;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$10800(Builder builder) {
            try {
                return builder.protocolShakePath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$10900(Builder builder) {
            try {
                return builder.checkBoxShakePath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Typeface access$1100(Builder builder) {
            try {
                return builder.navTypeFace;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$11000(Builder builder) {
            try {
                return builder.screenOrientation;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$11100(Builder builder) {
            try {
                return builder.protocolLayoutGravity;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$11200(Builder builder) {
            try {
                return builder.numberLayoutGravity;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$11300(Builder builder) {
            try {
                return builder.logBtnLayoutGravity;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$11400(Builder builder) {
            try {
                return builder.privacyOffsetX;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$11500(Builder builder) {
            try {
                return builder.logBtnToastHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ float access$11600(Builder builder) {
            try {
                return builder.dialogAlpha;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1.0f;
            }
        }

        public static /* synthetic */ String access$11700(Builder builder) {
            try {
                return builder.protocolThreeName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$11800(Builder builder) {
            try {
                return builder.protocolThreeURL;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$11900(Builder builder) {
            try {
                return builder.protocolThreeColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$1200(Builder builder) {
            try {
                return builder.navReturnImgWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$12000(Builder builder) {
            try {
                return builder.webSupportedJavascript;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$12100(Builder builder) {
            try {
                return builder.webCacheMode;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$12200(Builder builder) {
            try {
                return builder.webHiddeProgress;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$12300(Builder builder) {
            try {
                return builder.privacyOperatorIndex;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$12400(Builder builder) {
            try {
                return builder.protocolUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$12500(Builder builder) {
            try {
                return builder.protocolTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$12600(Builder builder) {
            try {
                return builder.protocolFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Typeface access$12700(Builder builder) {
            try {
                return builder.protocolNameTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$12800(Builder builder) {
            try {
                return builder.protocolNameUseUnderLine;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$12900(Builder builder) {
            try {
                return builder.protocolLineSpaceDp;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$1300(Builder builder) {
            try {
                return builder.navReturnImgHeight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String[] access$13000(Builder builder) {
            try {
                return builder.privacyConectTexts;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$13100(Builder builder) {
            try {
                return builder.navReturnImgDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$13200(Builder builder) {
            try {
                return builder.logoImgDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$13300(Builder builder) {
            try {
                return builder.uncheckedImgDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$13400(Builder builder) {
            try {
                return builder.checkedImgDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$13500(Builder builder) {
            try {
                return builder.logBtnBackgroundDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ StateListDrawable access$13600(Builder builder) {
            try {
                return builder.logBtnBgStateListDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ ColorStateList access$13700(Builder builder) {
            try {
                return builder.logBtnTextColorStateList;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$13800(Builder builder) {
            try {
                return builder.pageBackgroundDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$13900(Builder builder) {
            try {
                return builder.webNavReturnImgDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$1400(Builder builder) {
            try {
                return builder.navReturnHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ String access$14000(Builder builder) {
            try {
                return builder.packageName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$14100(Builder builder) {
            try {
                return builder.protocolAction;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$14200(Builder builder) {
            try {
                return builder.loadingImgDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$14300(Builder builder) {
            try {
                return builder.loadingBackgroundPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$14400(Builder builder) {
            try {
                return builder.loadingBackgroundDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$14500(Builder builder) {
            try {
                return builder.isHiddenLoading;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ boolean access$14600(Builder builder) {
            try {
                return builder.tapAuthPageMaskClosePage;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ boolean access$14700(Builder builder) {
            try {
                return builder.privacyAlertIsNeedShow;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ boolean access$14800(Builder builder) {
            try {
                return builder.privacyAlertIsNeedAutoLogin;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ boolean access$14900(Builder builder) {
            try {
                return builder.tapPrivacyAlertMaskCloseAlert;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ ImageView.ScaleType access$1500(Builder builder) {
            try {
                return builder.navReturnScaleType;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$15000(Builder builder) {
            try {
                return builder.privacyAlertAlignment;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$15100(Builder builder) {
            try {
                return builder.privacyAlertWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$15200(Builder builder) {
            try {
                return builder.privacyAlertHeight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$15300(Builder builder) {
            try {
                return builder.privacyAlertOffsetX;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$15400(Builder builder) {
            try {
                return builder.privacyAlertOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$15500(Builder builder) {
            try {
                return builder.privacyAlertEntryAnimation;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$15600(Builder builder) {
            try {
                return builder.privacyAlertExitAnimation;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int[] access$15700(Builder builder) {
            try {
                return builder.privacyAlertCornerRadiusArray;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$15800(Builder builder) {
            try {
                return builder.privacyAlertBackgroundColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ float access$15900(Builder builder) {
            try {
                return builder.privacyAlertAlpha;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1.0f;
            }
        }

        public static /* synthetic */ String access$1600(Builder builder) {
            try {
                return builder.logoImgPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ float access$16000(Builder builder) {
            try {
                return builder.privacyAlertMaskAlpha;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1.0f;
            }
        }

        public static /* synthetic */ int access$16100(Builder builder) {
            try {
                return builder.privacyAlertMaskColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$16200(Builder builder) {
            try {
                return builder.privacyAlertTitleTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$16300(Builder builder) {
            try {
                return builder.privacyAlertTitleColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$16400(Builder builder) {
            try {
                return builder.privacyAlertTitleText;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$16500(Builder builder) {
            try {
                return builder.privacyAlertTitleTextUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$16600(Builder builder) {
            try {
                return builder.privacyAlertTitleTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$16700(Builder builder) {
            try {
                return builder.privacyAlertTitleTextFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$16800(Builder builder) {
            try {
                return builder.privacyAlertTitleBackgroundColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$16900(Builder builder) {
            try {
                return builder.privacyAlertTitleAlignment;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$1700(Builder builder) {
            try {
                return builder.logoHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$17000(Builder builder) {
            try {
                return builder.privacyAlertTitleOffsetX;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$17100(Builder builder) {
            try {
                return builder.privacyAlertTitleOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$17200(Builder builder) {
            try {
                return builder.privacyAlertContentTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$17300(Builder builder) {
            try {
                return builder.privacyAlertContentTextUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ String access$17400(Builder builder) {
            try {
                return builder.privacyAlertContentTextFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Typeface access$17500(Builder builder) {
            try {
                return builder.privacyAlertProtocolNameTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$17600(Builder builder) {
            try {
                return builder.privacyAlertProtocolNameUseUnderLine;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$17700(Builder builder) {
            try {
                return builder.privacyAlertContentTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$17800(Builder builder) {
            try {
                return builder.privacyAlertContentColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$17900(Builder builder) {
            try {
                return builder.privacyAlertContentBaseColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ ImageView.ScaleType access$1800(Builder builder) {
            try {
                return builder.logoScaleType;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$18000(Builder builder) {
            try {
                return builder.privacyAlertOwnOneColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$18100(Builder builder) {
            try {
                return builder.privacyAlertOwnTwoColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$18200(Builder builder) {
            try {
                return builder.privacyAlertOwnThreeColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$18300(Builder builder) {
            try {
                return builder.privacyAlertOperatorColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$18400(Builder builder) {
            try {
                return builder.privacyAlertProtocolLineSpaceDp;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$18500(Builder builder) {
            try {
                return builder.privacyAlertBefore;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$18600(Builder builder) {
            try {
                return builder.privacyAlertEnd;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$18700(Builder builder) {
            try {
                return builder.privacyAlertContentBackgroundColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$18800(Builder builder) {
            try {
                return builder.privacyAlertContentAlignment;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$18900(Builder builder) {
            try {
                return builder.privacyAlertContentHorizontalMargin;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$1900(Builder builder) {
            try {
                return builder.numberColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$19000(Builder builder) {
            try {
                return builder.privacyAlertContentVerticalMargin;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$19100(Builder builder) {
            try {
                return builder.privacyAlertBtnBackgroundImgPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ StateListDrawable access$19200(Builder builder) {
            try {
                return builder.privacyAlertBtnBgStateListDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$19300(Builder builder) {
            try {
                return builder.privacyAlertBtnTextColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$19400(Builder builder) {
            try {
                return builder.privacyAlertBtnTextColorPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ ColorStateList access$19500(Builder builder) {
            try {
                return builder.privacyAlertBtnTextColorStateList;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$19600(Builder builder) {
            try {
                return builder.privacyAlertBtnTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int[] access$19700(Builder builder) {
            try {
                return builder.privacyAlertBtnGrivaty;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$19800(Builder builder) {
            try {
                return builder.privacyAlertBtnOffsetX;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$19900(Builder builder) {
            try {
                return builder.privacyAlertBtnOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$200(Builder builder) {
            try {
                return builder.isLightColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ boolean access$2000(Builder builder) {
            try {
                return builder.switchAccHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ String access$20000(Builder builder) {
            try {
                return builder.privacyAlertBtnText;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$20100(Builder builder) {
            try {
                return builder.privacyAlertBtnUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$20200(Builder builder) {
            try {
                return builder.privacyAlertBtnTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$20300(Builder builder) {
            try {
                return builder.privacyAlertBtnFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$20400(Builder builder) {
            try {
                return builder.privacyAlertBtnHorizontalMargin;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$20500(Builder builder) {
            try {
                return builder.privacyAlertBtnVerticalMargin;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ Drawable access$20600(Builder builder) {
            try {
                return builder.privacyAlertBtnBackgroundImgDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$20700(Builder builder) {
            try {
                return builder.privacyAlertBtnWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$20800(Builder builder) {
            try {
                return builder.privacyAlertBtnHeigth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$20900(Builder builder) {
            try {
                return builder.privacyAlertCloseBtnShow;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$2100(Builder builder) {
            try {
                return builder.switchAccTextColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$21000(Builder builder) {
            try {
                return builder.privacyAlertCloseImagPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ ImageView.ScaleType access$21100(Builder builder) {
            try {
                return builder.privacyAlertCloseScaleType;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ Drawable access$21200(Builder builder) {
            try {
                return builder.privacyAlertCloseImagDrawable;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$21300(Builder builder) {
            try {
                return builder.privacyAlertCloseImgWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$21400(Builder builder) {
            try {
                return builder.privacyAlertCloseImgHeight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$21500(Builder builder) {
            try {
                return builder.privacyAlertMaskIsNeedShow;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ ColorStateList access$2200(Builder builder) {
            try {
                return builder.switchAccTextColorStateList;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$2300(Builder builder) {
            try {
                return builder.logBtnText;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$2400(Builder builder) {
            try {
                return builder.logBtnUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$2500(Builder builder) {
            try {
                return builder.logBtnTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$2600(Builder builder) {
            try {
                return builder.logBtnFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$2700(Builder builder) {
            try {
                return builder.logBtnTextColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$2800(Builder builder) {
            try {
                return builder.protocolOneName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$2900(Builder builder) {
            try {
                return builder.protocolOneURL;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$300(Builder builder) {
            try {
                return builder.isStatusBarHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$3000(Builder builder) {
            try {
                return builder.protocolOneColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$3100(Builder builder) {
            try {
                return builder.protocolOwnOneColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$3200(Builder builder) {
            try {
                return builder.protocolOwnTwoColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$3300(Builder builder) {
            try {
                return builder.protocolOwnThreeColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$3400(Builder builder) {
            try {
                return builder.protocolTwoColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$3500(Builder builder) {
            try {
                return builder.protocolTwoName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$3600(Builder builder) {
            try {
                return builder.protocolTwoURL;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$3700(Builder builder) {
            try {
                return builder.protocolColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$3800(Builder builder) {
            try {
                return builder.protocolOwnColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$3900(Builder builder) {
            try {
                return builder.sloganTextColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$400(Builder builder) {
            try {
                return builder.statusBarUIFlag;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$4000(Builder builder) {
            try {
                return builder.numberSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$4100(Builder builder) {
            try {
                return builder.numberUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$4200(Builder builder) {
            try {
                return builder.numberTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$4300(Builder builder) {
            try {
                return builder.numberFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$4400(Builder builder) {
            try {
                return builder.logBtnBackgroundPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$4500(Builder builder) {
            try {
                return builder.loadingImgPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$4600(Builder builder) {
            try {
                return builder.sloganOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$4700(Builder builder) {
            try {
                return builder.logoOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$4800(Builder builder) {
            try {
                return builder.logoOffsetY_B;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$4900(Builder builder) {
            try {
                return builder.numFieldOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$500(Builder builder) {
            try {
                return builder.navColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5000(Builder builder) {
            try {
                return builder.numFieldOffsetY_B;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5100(Builder builder) {
            try {
                return builder.numberFieldOffsetX;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5200(Builder builder) {
            try {
                return builder.switchOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5300(Builder builder) {
            try {
                return builder.switchOffsetY_B;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5400(Builder builder) {
            try {
                return builder.logBtnTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5500(Builder builder) {
            try {
                return builder.logBtnOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5600(Builder builder) {
            try {
                return builder.logBtnOffsetY_B;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5700(Builder builder) {
            try {
                return builder.logBtnWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5800(Builder builder) {
            try {
                return builder.logBtnHeight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$5900(Builder builder) {
            try {
                return builder.logBtnOffsetX;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$600(Builder builder) {
            try {
                return builder.navText;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$6000(Builder builder) {
            try {
                return builder.logBtnMarginLeftAndRight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$6100(Builder builder) {
            try {
                return builder.privacyOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$6200(Builder builder) {
            try {
                return builder.privacyOffsetY_B;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$6300(Builder builder) {
            try {
                return builder.sloganOffsetY_B;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$6400(Builder builder) {
            try {
                return builder.checkboxHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ String access$6500(Builder builder) {
            try {
                return builder.sloganText;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$6600(Builder builder) {
            try {
                return builder.sloganUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$6700(Builder builder) {
            try {
                return builder.sloganTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$6800(Builder builder) {
            try {
                return builder.sloganFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$6900(Builder builder) {
            try {
                return builder.navTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$700(Builder builder) {
            try {
                return builder.navTextColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$7000(Builder builder) {
            try {
                return builder.logoWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$7100(Builder builder) {
            try {
                return builder.logoHeight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$7200(Builder builder) {
            try {
                return builder.switchAccTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$7300(Builder builder) {
            try {
                return builder.switchAccText;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$7400(Builder builder) {
            try {
                return builder.swtichUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ Typeface access$7500(Builder builder) {
            try {
                return builder.swtichTypeface;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$7600(Builder builder) {
            try {
                return builder.swtichFontName;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$7700(Builder builder) {
            try {
                return builder.sloganTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$7800(Builder builder) {
            try {
                return builder.sloganHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ String access$7900(Builder builder) {
            try {
                return builder.uncheckedImgPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$800(Builder builder) {
            try {
                return builder.navReturnImgPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$8000(Builder builder) {
            try {
                return builder.checkedImgPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$8100(Builder builder) {
            try {
                return builder.checkBoxHeight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$8200(Builder builder) {
            try {
                return builder.checkBoxWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$8300(Builder builder) {
            try {
                return builder.checkBoxMarginTop;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$8400(Builder builder) {
            try {
                return builder.privacyState;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$8500(Builder builder) {
            try {
                return builder.protocolGravity;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$8600(Builder builder) {
            try {
                return builder.privacyTextSize;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$8700(Builder builder) {
            try {
                return builder.privacyMargin;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$8800(Builder builder) {
            try {
                return builder.privacyBefore;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$8900(Builder builder) {
            try {
                return builder.vendorPrivacyPrefix;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$900(Builder builder) {
            try {
                return builder.navUseFont;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ String access$9000(Builder builder) {
            try {
                return builder.vendorPrivacySuffix;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String access$9100(Builder builder) {
            try {
                return builder.privacyEnd;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int access$9200(Builder builder) {
            try {
                return builder.dialogWidth;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$9300(Builder builder) {
            try {
                return builder.dialogHeight;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ boolean access$9400(Builder builder) {
            try {
                return builder.dialogBottom;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$9500(Builder builder) {
            try {
                return builder.dialogOffsetX;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ int access$9600(Builder builder) {
            try {
                return builder.dialogOffsetY;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public static /* synthetic */ String access$9700(Builder builder) {
            try {
                return builder.pageBackgroundPath;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ boolean access$9800(Builder builder) {
            try {
                return builder.navHidden;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return false;
            }
        }

        public static /* synthetic */ int access$9900(Builder builder) {
            try {
                return builder.webViewStatusBarColor;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public AuthUIConfig create() {
            try {
                return new AuthUIConfig(this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public int makeTextSizeSpec(int i10, int i11) {
            return (i10 & View.LAST_APP_AUTOFILL_ID) | (i11 & AuthUIConfig.MODE_MASK);
        }

        public Builder privacyAlertProtocolLineSpaceDp(int i10) {
            try {
                this.privacyAlertProtocolLineSpaceDp = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder privacyAlertProtocolNameUseUnderLine(boolean z10) {
            try {
                this.privacyAlertProtocolNameUseUnderLine = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder protocolLineSpaceDp(int i10) {
            try {
                this.protocolLineSpaceDp = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder protocolNameUseUnderLine(boolean z10) {
            try {
                this.protocolNameUseUnderLine = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setAppPrivacyColor(@ColorInt int i10, @ColorInt int i11) {
            try {
                this.protocolColor = i10;
                this.protocolOneColor = i11;
                this.protocolTwoColor = i11;
                this.protocolThreeColor = i11;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setAppPrivacyOne(String str, String str2) {
            try {
                this.protocolOneName = str;
                this.protocolOneURL = str2;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setAppPrivacyThree(String str, String str2) {
            try {
                this.protocolThreeName = str;
                this.protocolThreeURL = str2;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setAppPrivacyTwo(String str, String str2) {
            try {
                this.protocolTwoName = str;
                this.protocolTwoURL = str2;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setAuthPageActIn(String str, String str2) {
            try {
                this.authPageActIn = str;
                this.activityOut = str2;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setAuthPageActOut(String str, String str2) {
            try {
                this.authPageActOut = str;
                this.activityIn = str2;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setBottomNavColor(@ColorInt int i10) {
            try {
                this.bottomNavColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCheckBoxHeight(int i10) {
            try {
                this.checkBoxHeight = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCheckBoxMarginTop(int i10) {
            try {
                this.checkBoxMarginTop = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCheckBoxShakePath(String str) {
            try {
                this.checkBoxShakePath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCheckBoxWidth(int i10) {
            try {
                this.checkBoxWidth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCheckboxHidden(boolean z10) {
            try {
                this.checkboxHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCheckedImgDrawable(Drawable drawable) {
            try {
                this.checkedImgDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setCheckedImgPath(String str) {
            try {
                this.checkedImgPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setDialogAlpha(float f10) {
            try {
                this.dialogAlpha = f10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setDialogBottom(boolean z10) {
            try {
                this.dialogBottom = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setDialogHeight(int i10) {
            try {
                this.dialogHeight = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setDialogOffsetX(int i10) {
            try {
                this.dialogOffsetX = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setDialogOffsetY(int i10) {
            try {
                this.dialogOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setDialogWidth(int i10) {
            try {
                this.dialogWidth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setHiddenLoading(boolean z10) {
            try {
                this.isHiddenLoading = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLightColor(boolean z10) {
            try {
                this.isLightColor = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLoadingBackgroundDrawable(Drawable drawable) {
            try {
                this.loadingBackgroundDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLoadingBackgroundPath(String str) {
            try {
                this.loadingBackgroundPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLoadingImgDrawable(Drawable drawable) {
            try {
                this.loadingImgDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLoadingImgPath(String str) {
            try {
                this.loadingImgPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnBackgroundDrawable(Drawable drawable) {
            try {
                this.logBtnBackgroundDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnBackgroundPath(String str) {
            try {
                this.logBtnBackgroundPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnBgStateListDrawable(StateListDrawable stateListDrawable) {
            try {
                this.logBtnBgStateListDrawable = stateListDrawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnHeight(int i10) {
            try {
                this.logBtnHeight = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnLayoutGravity(int i10) {
            try {
                this.logBtnLayoutGravity = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnMarginLeftAndRight(int i10) {
            try {
                this.logBtnMarginLeftAndRight = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnOffsetX(int i10) {
            try {
                this.logBtnOffsetX = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnOffsetY(int i10) {
            try {
                this.logBtnOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnOffsetY_B(int i10) {
            try {
                this.logBtnOffsetY_B = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnText(String str) {
            try {
                this.logBtnText = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnTextColor(@ColorInt int i10) {
            try {
                this.logBtnTextColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnTextColorStateList(ColorStateList colorStateList) {
            try {
                this.logBtnTextColorStateList = colorStateList;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        @Deprecated
        public Builder setLogBtnTextSize(int i10) {
            try {
                this.logBtnTextSize = makeTextSizeSpec(i10, 0);
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnTextSizeDp(int i10) {
            if (i10 > 0) {
                try {
                    this.logBtnTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setLogBtnToastHidden(boolean z10) {
            try {
                this.logBtnToastHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnTypeface(Typeface typeface) {
            try {
                this.logBtnTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogBtnWidth(int i10) {
            try {
                this.logBtnWidth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoHeight(int i10) {
            try {
                this.logoHeight = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoHidden(boolean z10) {
            try {
                this.logoHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoImgDrawable(Drawable drawable) {
            try {
                this.logoImgDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoImgPath(String str) {
            try {
                this.logoImgPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoOffsetY(int i10) {
            try {
                this.logoOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoOffsetY_B(int i10) {
            try {
                this.logoOffsetY_B = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoScaleType(ImageView.ScaleType scaleType) {
            try {
                this.logoScaleType = scaleType;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setLogoWidth(int i10) {
            try {
                this.logoWidth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavColor(@ColorInt int i10) {
            try {
                this.navColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavHidden(boolean z10) {
            try {
                this.navHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavReturnHidden(boolean z10) {
            try {
                this.navReturnHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavReturnImgDrawable(Drawable drawable) {
            try {
                this.navReturnImgDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavReturnImgHeight(int i10) {
            try {
                this.navReturnImgHeight = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavReturnImgPath(String str) {
            try {
                this.navReturnImgPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavReturnImgWidth(int i10) {
            try {
                this.navReturnImgWidth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavReturnScaleType(ImageView.ScaleType scaleType) {
            try {
                this.navReturnScaleType = scaleType;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavText(String str) {
            try {
                this.navText = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavTextColor(@ColorInt int i10) {
            try {
                this.navTextColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        @Deprecated
        public Builder setNavTextSize(int i10) {
            try {
                this.navTextSize = makeTextSizeSpec(i10, 0);
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNavTextSizeDp(int i10) {
            if (i10 > 0) {
                try {
                    this.navTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setNavTypeface(Typeface typeface) {
            try {
                this.navTypeFace = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNumFieldOffsetY(int i10) {
            try {
                this.numFieldOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNumFieldOffsetY_B(int i10) {
            try {
                this.numFieldOffsetY_B = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNumberColor(@ColorInt int i10) {
            try {
                this.numberColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNumberFieldOffsetX(int i10) {
            try {
                this.numberFieldOffsetX = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNumberLayoutGravity(int i10) {
            try {
                this.numberLayoutGravity = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        @Deprecated
        public Builder setNumberSize(int i10) {
            try {
                this.numberSize = makeTextSizeSpec(i10, 0);
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setNumberSizeDp(int i10) {
            if (i10 > 0) {
                try {
                    this.numberSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setNumberTypeface(Typeface typeface) {
            try {
                this.numberTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPackageName(String str) {
            try {
                this.packageName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPageBackgroundDrawable(Drawable drawable) {
            try {
                this.pageBackgroundDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPageBackgroundPath(String str) {
            try {
                this.pageBackgroundPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertAlignment(int i10) {
            try {
                this.privacyAlertAlignment = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertAlpha(float f10) {
            float f11 = 0.3f;
            try {
                if (f10 >= 0.3f) {
                    f11 = 1.0f;
                    if (f10 <= 1.0f) {
                        this.privacyAlertAlpha = f10;
                        return this;
                    }
                }
                this.privacyAlertAlpha = f11;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBackgroundColor(int i10) {
            try {
                this.privacyAlertBackgroundColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBefore(String str) {
            try {
                this.privacyAlertBefore = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnBackgroundImgDrawable(Drawable drawable) {
            try {
                this.privacyAlertBtnBackgroundImgDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnBackgroundImgPath(String str) {
            try {
                this.privacyAlertBtnBackgroundImgPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnBgStateListDrawable(StateListDrawable stateListDrawable) {
            try {
                this.privacyAlertBtnBgStateListDrawable = stateListDrawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnContent(String str) {
            try {
                this.privacyAlertBtnText = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnGrivaty(int[] iArr) {
            try {
                this.privacyAlertBtnGrivaty = iArr;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnHeigth(int i10) {
            try {
                this.privacyAlertBtnHeigth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnHorizontalMargin(int i10) {
            try {
                this.privacyAlertBtnHorizontalMargin = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnOffsetX(int i10) {
            try {
                this.privacyAlertBtnOffsetX = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnOffsetY(int i10) {
            try {
                this.privacyAlertBtnOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnTextColor(int i10) {
            try {
                this.privacyAlertBtnTextColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnTextColorPath(String str) {
            try {
                this.privacyAlertBtnTextColorPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnTextColorStateList(ColorStateList colorStateList) {
            try {
                this.privacyAlertBtnTextColorStateList = colorStateList;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnTextSize(int i10) {
            if (i10 > 0) {
                try {
                    this.privacyAlertBtnTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setPrivacyAlertBtnTypeface(Typeface typeface) {
            try {
                this.privacyAlertBtnTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnVerticalMargin(int i10) {
            try {
                this.privacyAlertBtnVerticalMargin = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertBtnWidth(int i10) {
            try {
                this.privacyAlertBtnWidth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertCloseBtnShow(boolean z10) {
            try {
                this.privacyAlertCloseBtnShow = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertCloseImagDrawable(Drawable drawable) {
            try {
                this.privacyAlertCloseImagDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertCloseImagPath(String str) {
            try {
                this.privacyAlertCloseImagPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertCloseImgHeight(int i10) {
            try {
                this.privacyAlertCloseImgHeight = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertCloseImgWidth(int i10) {
            try {
                this.privacyAlertCloseImgWidth = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertCloseScaleType(ImageView.ScaleType scaleType) {
            try {
                this.privacyAlertCloseScaleType = scaleType;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertContentAlignment(int i10) {
            try {
                this.privacyAlertContentAlignment = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertContentBackgroundColor(int i10) {
            try {
                this.privacyAlertContentBackgroundColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertContentBaseColor(int i10) {
            try {
                this.privacyAlertContentBaseColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertContentColor(int i10) {
            try {
                this.privacyAlertContentColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertContentHorizontalMargin(int i10) {
            try {
                this.privacyAlertContentHorizontalMargin = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertContentTextSize(int i10) {
            if (i10 > 0) {
                try {
                    this.privacyAlertContentTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setPrivacyAlertContentTypeface(Typeface typeface) {
            try {
                this.privacyAlertContentTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertContentVerticalMargin(int i10) {
            try {
                this.privacyAlertContentVerticalMargin = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertCornerRadiusArray(int[] iArr) {
            try {
                this.privacyAlertCornerRadiusArray = iArr;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertEnd(String str) {
            try {
                this.privacyAlertEnd = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertEntryAnimation(String str) {
            try {
                this.privacyAlertEntryAnimation = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertExitAnimation(String str) {
            try {
                this.privacyAlertExitAnimation = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertHeight(int i10) {
            if (i10 >= 90) {
                try {
                    this.privacyAlertHeight = i10;
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setPrivacyAlertIsNeedAutoLogin(boolean z10) {
            try {
                this.privacyAlertIsNeedAutoLogin = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertIsNeedShow(boolean z10) {
            try {
                this.privacyAlertIsNeedShow = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertMaskAlpha(float f10) {
            float f11 = 0.3f;
            try {
                if (f10 >= 0.3f) {
                    f11 = 1.0f;
                    if (f10 <= 1.0f) {
                        this.privacyAlertMaskAlpha = f10;
                        return this;
                    }
                }
                this.privacyAlertMaskAlpha = f11;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertMaskColor(int i10) {
            try {
                this.privacyAlertMaskColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertMaskIsNeedShow(boolean z10) {
            try {
                this.privacyAlertMaskIsNeedShow = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertOffsetX(int i10) {
            try {
                this.privacyAlertOffsetX = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertOffsetY(int i10) {
            try {
                this.privacyAlertOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertOneColor(int i10) {
            try {
                this.privacyAlertOwnOneColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertOperatorColor(int i10) {
            try {
                this.privacyAlertOperatorColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertProtocolNameTypeface(Typeface typeface) {
            try {
                this.privacyAlertProtocolNameTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertThreeColor(int i10) {
            try {
                this.privacyAlertOwnThreeColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTitleAlignment(int i10) {
            try {
                this.privacyAlertTitleAlignment = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTitleBackgroundColor(int i10) {
            try {
                this.privacyAlertTitleBackgroundColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTitleColor(int i10) {
            try {
                this.privacyAlertTitleColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTitleContent(String str) {
            try {
                this.privacyAlertTitleText = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTitleOffsetX(int i10) {
            try {
                this.privacyAlertTitleOffsetX = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTitleOffsetY(int i10) {
            try {
                this.privacyAlertTitleOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTitleTextSize(int i10) {
            if (i10 > 0) {
                try {
                    this.privacyAlertTitleTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setPrivacyAlertTitleTypeface(Typeface typeface) {
            try {
                this.privacyAlertTitleTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertTwoColor(int i10) {
            try {
                this.privacyAlertOwnTwoColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyAlertWidth(int i10) {
            if (i10 >= 160) {
                try {
                    this.privacyAlertWidth = i10;
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setPrivacyBefore(String str) {
            try {
                this.privacyBefore = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyConectTexts(String[] strArr) {
            try {
                this.privacyConectTexts = strArr;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyEnd(String str) {
            try {
                this.privacyEnd = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyMargin(int i10) {
            try {
                this.privacyMargin = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyOffsetX(int i10) {
            try {
                this.privacyOffsetX = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyOffsetY(int i10) {
            try {
                this.privacyOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyOffsetY_B(int i10) {
            try {
                this.privacyOffsetY_B = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyOneColor(@ColorInt int i10) {
            try {
                this.protocolOwnOneColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyOperatorColor(@ColorInt int i10) {
            try {
                this.protocolOwnColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyOperatorIndex(@IntRange(from = 0, to = 3) int i10) {
            try {
                this.privacyOperatorIndex = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyState(boolean z10) {
            try {
                this.privacyState = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyTextSize(int i10) {
            try {
                this.privacyTextSize = makeTextSizeSpec(i10, 0);
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyTextSizeDp(int i10) {
            if (i10 > 0) {
                try {
                    this.privacyTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setPrivacyThreeColor(@ColorInt int i10) {
            try {
                this.protocolOwnThreeColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setPrivacyTwoColor(@ColorInt int i10) {
            try {
                this.protocolOwnTwoColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setProtocolAction(String str) {
            try {
                this.protocolAction = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setProtocolGravity(int i10) {
            try {
                this.protocolGravity = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setProtocolLayoutGravity(int i10) {
            try {
                this.protocolLayoutGravity = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setProtocolNameTypeface(Typeface typeface) {
            try {
                this.protocolNameTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setProtocolShakePath(String str) {
            try {
                this.protocolShakePath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setProtocolTypeface(Typeface typeface) {
            try {
                this.protocolTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setScreenOrientation(int i10) {
            try {
                this.screenOrientation = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSloganHidden(boolean z10) {
            try {
                this.sloganHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSloganOffsetY(int i10) {
            try {
                this.sloganOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSloganOffsetY_B(int i10) {
            try {
                this.sloganOffsetY_B = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSloganText(String str) {
            try {
                this.sloganText = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSloganTextColor(@ColorInt int i10) {
            try {
                this.sloganTextColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        @Deprecated
        public Builder setSloganTextSize(int i10) {
            try {
                this.sloganTextSize = makeTextSizeSpec(i10, 0);
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSloganTextSizeDp(int i10) {
            if (i10 > 0) {
                try {
                    this.sloganTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setSloganTypeface(Typeface typeface) {
            try {
                this.sloganTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setStatusBarColor(@ColorInt int i10) {
            try {
                this.statusBarColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setStatusBarHidden(boolean z10) {
            try {
                this.isStatusBarHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setStatusBarUIFlag(int i10) {
            try {
                this.statusBarUIFlag = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSwitchAccHidden(boolean z10) {
            try {
                this.switchAccHidden = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSwitchAccText(String str) {
            try {
                this.switchAccText = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSwitchAccTextColor(@ColorInt int i10) {
            try {
                this.switchAccTextColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSwitchAccTextColorStateList(ColorStateList colorStateList) {
            try {
                this.switchAccTextColorStateList = colorStateList;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        @Deprecated
        public Builder setSwitchAccTextSize(int i10) {
            try {
                this.switchAccTextSize = makeTextSizeSpec(i10, 0);
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSwitchAccTextSizeDp(int i10) {
            if (i10 > 0) {
                try {
                    this.switchAccTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setSwitchOffsetY(int i10) {
            try {
                this.switchOffsetY = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSwitchOffsetY_B(int i10) {
            try {
                this.switchOffsetY_B = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setSwitchTypeface(Typeface typeface) {
            try {
                this.swtichTypeface = typeface;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setTapAuthPageMaskClosePage(boolean z10) {
            try {
                this.tapAuthPageMaskClosePage = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setTapPrivacyAlertMaskCloseAlert(boolean z10) {
            try {
                this.tapPrivacyAlertMaskCloseAlert = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setUncheckedImgDrawable(Drawable drawable) {
            try {
                this.uncheckedImgDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setUncheckedImgPath(String str) {
            try {
                this.uncheckedImgPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setVendorPrivacyPrefix(String str) {
            try {
                this.vendorPrivacyPrefix = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setVendorPrivacySuffix(String str) {
            try {
                this.vendorPrivacySuffix = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebCacheMode(int i10) {
            try {
                this.webCacheMode = this.webCacheMode;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebHiddeProgress(boolean z10) {
            try {
                this.webHiddeProgress = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebNavColor(@ColorInt int i10) {
            try {
                this.webNavColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebNavReturnImgDrawable(Drawable drawable) {
            try {
                this.webNavReturnImgDrawable = drawable;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebNavReturnImgPath(String str) {
            try {
                this.webNavReturnImgPath = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebNavTextColor(@ColorInt int i10) {
            try {
                this.webNavTextColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        @Deprecated
        public Builder setWebNavTextSize(int i10) {
            try {
                this.webNavTextSize = makeTextSizeSpec(i10, 0);
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebNavTextSizeDp(int i10) {
            if (i10 > 0) {
                try {
                    this.webNavTextSize = makeTextSizeSpec(i10, 1073741824);
                } catch (Throwable th) {
                    ExceptionProcessor.processException(th);
                    return null;
                }
            }
            return this;
        }

        public Builder setWebSupportedJavascript(boolean z10) {
            try {
                this.webSupportedJavascript = z10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder setWebViewStatusBarColor(@ColorInt int i10) {
            try {
                this.webViewStatusBarColor = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder useLogBtnFontAndPath(boolean z10, String str) {
            try {
                this.logBtnUseFont = z10;
                this.logBtnFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder useNavFontAndPath(boolean z10, String str) {
            try {
                this.navUseFont = z10;
                this.navFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder useNumberFontAndPath(boolean z10, String str) {
            try {
                this.numberUseFont = z10;
                this.numberFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder usePrivacyAlertBtnFontAndPath(boolean z10, String str) {
            try {
                this.privacyAlertBtnUseFont = z10;
                this.privacyAlertBtnFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder usePrivacyAlertContentFontAndPath(boolean z10, String str) {
            try {
                this.privacyAlertContentTextUseFont = z10;
                this.privacyAlertContentTextFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder usePrivacyAlertTitleFontAndPath(boolean z10, String str) {
            try {
                this.privacyAlertTitleTextUseFont = z10;
                this.privacyAlertTitleTextFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder useProtocolFontAndPath(boolean z10, String str) {
            try {
                this.protocolUseFont = z10;
                this.protocolFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder useSloganFontAndPath(boolean z10, String str) {
            try {
                this.sloganUseFont = z10;
                this.sloganFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public Builder useSwitchFontAndPath(boolean z10, String str) {
            try {
                this.swtichUseFont = z10;
                this.swtichFontName = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }
    }

    private AuthUIConfig(Builder builder) {
        this.dialogAlpha = -1.0f;
        this.protocolThreeName = null;
        this.protocolThreeURL = null;
        this.protocolThreeColor = DEFAULT_PROTOCOL_THREE_COLOR;
        this.statusBarColor = Builder.access$000(builder);
        this.bottomNavBarColor = Builder.access$100(builder);
        this.isLightColor = Builder.access$200(builder);
        this.isStatusBarHidden = Builder.access$300(builder);
        this.statusBarUIFlag = Builder.access$400(builder);
        this.navColor = Builder.access$500(builder);
        this.navText = Builder.access$600(builder);
        this.navTextColor = Builder.access$700(builder);
        this.navReturnImgPath = Builder.access$800(builder);
        this.navUseFont = Builder.access$900(builder);
        this.navFontName = Builder.access$1000(builder);
        this.navTypeFace = Builder.access$1100(builder);
        this.navReturnImgWidth = Builder.access$1200(builder);
        this.navReturnImgHeight = Builder.access$1300(builder);
        this.navReturnHidden = Builder.access$1400(builder);
        this.navReturnScaleType = Builder.access$1500(builder);
        this.logoImgPath = Builder.access$1600(builder);
        this.logoHidden = Builder.access$1700(builder);
        this.logoScaleType = Builder.access$1800(builder);
        this.numberColor = Builder.access$1900(builder);
        this.switchAccHidden = Builder.access$2000(builder);
        this.switchAccTextColor = Builder.access$2100(builder);
        this.switchAccTextColorStateList = Builder.access$2200(builder);
        this.logBtnText = Builder.access$2300(builder);
        this.logBtnUseFont = Builder.access$2400(builder);
        this.logBtnTypeface = Builder.access$2500(builder);
        this.logBtnFontName = Builder.access$2600(builder);
        this.logBtnTextColor = Builder.access$2700(builder);
        this.protocolOneName = Builder.access$2800(builder);
        this.protocolOneURL = Builder.access$2900(builder);
        this.protocolOneColor = Builder.access$3000(builder);
        this.protocolOwnOneColor = Builder.access$3100(builder);
        this.protocolOwnTwoColor = Builder.access$3200(builder);
        this.protocolOwnThreeColor = Builder.access$3300(builder);
        this.protocolTwoColor = Builder.access$3400(builder);
        this.protocolTwoName = Builder.access$3500(builder);
        this.protocolTwoURL = Builder.access$3600(builder);
        this.protocolColor = Builder.access$3700(builder);
        this.protocolOwnColor = Builder.access$3800(builder);
        this.sloganTextColor = Builder.access$3900(builder);
        this.numberSize = Builder.access$4000(builder);
        this.numberUseFont = Builder.access$4100(builder);
        this.numberTypeface = Builder.access$4200(builder);
        this.numberFontName = Builder.access$4300(builder);
        this.logBtnBackgroundPath = Builder.access$4400(builder);
        this.loadingImgPath = Builder.access$4500(builder);
        this.sloganOffsetY = Builder.access$4600(builder);
        this.logoOffsetY = Builder.access$4700(builder);
        this.logoOffsetY_B = Builder.access$4800(builder);
        this.numFieldOffsetY = Builder.access$4900(builder);
        this.numFieldOffsetY_B = Builder.access$5000(builder);
        this.numberFieldOffsetX = Builder.access$5100(builder);
        this.switchOffsetY = Builder.access$5200(builder);
        this.switchOffsetY_B = Builder.access$5300(builder);
        this.logBtnTextSize = Builder.access$5400(builder);
        this.logBtnOffsetY = Builder.access$5500(builder);
        this.logBtnOffsetY_B = Builder.access$5600(builder);
        this.logBtnWidth = Builder.access$5700(builder);
        this.logBtnHeight = Builder.access$5800(builder);
        this.logBtnOffsetX = Builder.access$5900(builder);
        this.logBtnMarginLeftAndRight = Builder.access$6000(builder);
        this.privacyOffsetY = Builder.access$6100(builder);
        this.privacyOffsetY_B = Builder.access$6200(builder);
        this.sloganOffsetY_B = Builder.access$6300(builder);
        this.checkboxHidden = Builder.access$6400(builder);
        this.sloganText = Builder.access$6500(builder);
        this.sloganUseFont = Builder.access$6600(builder);
        this.sloganTypeface = Builder.access$6700(builder);
        this.sloganFontName = Builder.access$6800(builder);
        this.navTextSize = Builder.access$6900(builder);
        this.logoWidth = Builder.access$7000(builder);
        this.logoHeight = Builder.access$7100(builder);
        this.switchAccTextSize = Builder.access$7200(builder);
        this.switchAccText = Builder.access$7300(builder);
        this.swtichUseFont = Builder.access$7400(builder);
        this.swtichTypeface = Builder.access$7500(builder);
        this.swtichFontName = Builder.access$7600(builder);
        this.sloganTextSize = Builder.access$7700(builder);
        this.sloganHidden = Builder.access$7800(builder);
        this.uncheckedImgPath = Builder.access$7900(builder);
        this.checkedImgPath = Builder.access$8000(builder);
        this.checkBoxHeight = Builder.access$8100(builder);
        this.checkBoxWidth = Builder.access$8200(builder);
        this.checkBoxMarginTop = Builder.access$8300(builder);
        this.privacyState = Builder.access$8400(builder);
        this.protocolGravity = Builder.access$8500(builder);
        this.privacyTextSize = Builder.access$8600(builder);
        this.privacyMargin = Builder.access$8700(builder);
        this.privacyBefore = Builder.access$8800(builder);
        this.vendorPrivacyPrefix = Builder.access$8900(builder);
        this.vendorPrivacySuffix = Builder.access$9000(builder);
        this.privacyEnd = Builder.access$9100(builder);
        this.dialogWidth = Builder.access$9200(builder);
        this.dialogHeight = Builder.access$9300(builder);
        this.dialogBottom = Builder.access$9400(builder);
        this.dialogOffsetX = Builder.access$9500(builder);
        this.dialogOffsetY = Builder.access$9600(builder);
        this.pageBackgroundPath = Builder.access$9700(builder);
        this.navHidden = Builder.access$9800(builder);
        this.webViewStatusBarColor = Builder.access$9900(builder);
        this.webNavColor = Builder.access$10000(builder);
        this.webNavTextColor = Builder.access$10100(builder);
        this.webNavTextSize = Builder.access$10200(builder);
        this.webNavReturnImgPath = Builder.access$10300(builder);
        this.authPageActIn = Builder.access$10400(builder);
        this.activityOut = Builder.access$10500(builder);
        this.authPageActOut = Builder.access$10600(builder);
        this.activityIn = Builder.access$10700(builder);
        this.protocolShakePath = Builder.access$10800(builder);
        this.checkBoxShakePath = Builder.access$10900(builder);
        this.screenOrientation = Builder.access$11000(builder);
        this.protocolLayoutGravity = Builder.access$11100(builder);
        this.numberLayoutGravity = Builder.access$11200(builder);
        this.logBtnLayoutGravity = Builder.access$11300(builder);
        this.privacyOffsetX = Builder.access$11400(builder);
        this.logBtnToastHidden = Builder.access$11500(builder);
        this.dialogAlpha = Builder.access$11600(builder);
        this.protocolThreeName = Builder.access$11700(builder);
        this.protocolThreeURL = Builder.access$11800(builder);
        this.protocolThreeColor = Builder.access$11900(builder);
        this.webSupportedJavascript = Builder.access$12000(builder);
        this.webCacheMode = Builder.access$12100(builder);
        this.webHiddeProgress = Builder.access$12200(builder);
        this.privacyOperatorIndex = (Builder.access$12300(builder) < 0 || Builder.access$12300(builder) > 3) ? 0 : Builder.access$12300(builder);
        this.protocolUseFont = Builder.access$12400(builder);
        this.protocolTypeface = Builder.access$12500(builder);
        this.protocolFontName = Builder.access$12600(builder);
        this.protocolNameTypeface = Builder.access$12700(builder);
        this.protocolNameUseUnderLine = Builder.access$12800(builder);
        this.protocolLineSpaceDp = Builder.access$12900(builder);
        this.privacyConectTexts = makePrivacyConectTexts(Builder.access$13000(builder));
        this.navReturnImgDrawable = Builder.access$13100(builder);
        this.logoImgDrawable = Builder.access$13200(builder);
        this.uncheckedImgDrawable = Builder.access$13300(builder);
        this.checkedImgDrawable = Builder.access$13400(builder);
        this.logBtnBackgroundDrawable = Builder.access$13500(builder);
        this.logBtnBgStateListDrawable = Builder.access$13600(builder);
        this.logBtnTextColorStateList = Builder.access$13700(builder);
        this.pageBackgroundDrawable = Builder.access$13800(builder);
        this.webNavReturnImgDrawable = Builder.access$13900(builder);
        this.packageName = Builder.access$14000(builder);
        this.protocolAction = Builder.access$14100(builder);
        this.loadingImgDrawable = Builder.access$14200(builder);
        this.loadingBackgroundPath = Builder.access$14300(builder);
        this.loadingBackgroundDrawable = Builder.access$14400(builder);
        this.isHiddenLoading = Builder.access$14500(builder);
        this.tapAuthPageMaskClosePage = Builder.access$14600(builder);
        this.privacyAlertIsNeedShow = Builder.access$14700(builder);
        this.privacyAlertIsNeedAutoLogin = Builder.access$14800(builder);
        this.tapPrivacyAlertMaskCloseAlert = Builder.access$14900(builder);
        this.privacyAlertAlignment = Builder.access$15000(builder);
        this.privacyAlertWidth = Builder.access$15100(builder);
        this.privacyAlertHeight = Builder.access$15200(builder);
        this.privacyAlertOffsetX = Builder.access$15300(builder);
        this.privacyAlertOffsetY = Builder.access$15400(builder);
        this.privacyAlertEntryAnimation = Builder.access$15500(builder);
        this.privacyAlertExitAnimation = Builder.access$15600(builder);
        this.privacyAlertCornerRadiusArray = Builder.access$15700(builder);
        this.privacyAlertBackgroundColor = Builder.access$15800(builder);
        this.privacyAlertAlpha = Builder.access$15900(builder);
        this.privacyAlertMaskAlpha = Builder.access$16000(builder);
        this.privacyAlertMaskColor = Builder.access$16100(builder);
        this.privacyAlertTitleTextSize = Builder.access$16200(builder);
        this.privacyAlertTitleColor = Builder.access$16300(builder);
        this.privacyAlertTitleText = Builder.access$16400(builder);
        this.privacyAlertTitleTextUseFont = Builder.access$16500(builder);
        this.privacyAlertTitleTypeface = Builder.access$16600(builder);
        this.privacyAlertTitleTextFontName = Builder.access$16700(builder);
        this.privacyAlertTitleBackgroundColor = Builder.access$16800(builder);
        this.privacyAlertTitleAlignment = Builder.access$16900(builder);
        this.privacyAlertTitleOffsetX = Builder.access$17000(builder);
        this.privacyAlertTitleOffsetY = Builder.access$17100(builder);
        this.privacyAlertContentTextSize = Builder.access$17200(builder);
        this.privacyAlertContentTextUseFont = Builder.access$17300(builder);
        this.privacyAlertContentTextFontName = Builder.access$17400(builder);
        this.privacyAlertProtocolNameTypeface = Builder.access$17500(builder);
        this.privacyAlertProtocolNameUseUnderLine = Builder.access$17600(builder);
        this.privacyAlertContentTypeface = Builder.access$17700(builder);
        this.privacyAlertContentColor = Builder.access$17800(builder);
        this.privacyAlertContentBaseColor = Builder.access$17900(builder);
        this.privacyAlertOwnOneColor = Builder.access$18000(builder);
        this.privacyAlertOwnTwoColor = Builder.access$18100(builder);
        this.privacyAlertOwnThreeColor = Builder.access$18200(builder);
        this.privacyAlertOperatorColor = Builder.access$18300(builder);
        this.privacyAlertProtocolLineSpaceDp = Builder.access$18400(builder);
        this.privacyAlertBefore = Builder.access$18500(builder);
        this.privacyAlertEnd = Builder.access$18600(builder);
        this.privacyAlertContentBackgroundColor = Builder.access$18700(builder);
        this.privacyAlertContentAlignment = Builder.access$18800(builder);
        this.privacyAlertContentHorizontalMargin = Builder.access$18900(builder);
        this.privacyAlertContentVerticalMargin = Builder.access$19000(builder);
        this.privacyAlertBtnBackgroundImgPath = Builder.access$19100(builder);
        this.privacyAlertBtnBgStateListDrawable = Builder.access$19200(builder);
        this.privacyAlertBtnTextColor = Builder.access$19300(builder);
        this.privacyAlertBtnTextColorPath = Builder.access$19400(builder);
        this.privacyAlertBtnTextColorStateList = Builder.access$19500(builder);
        this.privacyAlertBtnTextSize = Builder.access$19600(builder);
        this.privacyAlertBtnGrivaty = Builder.access$19700(builder);
        this.privacyAlertBtnOffsetX = Builder.access$19800(builder);
        this.privacyAlertBtnOffsetY = Builder.access$19900(builder);
        this.privacyAlertBtnText = Builder.access$20000(builder);
        this.privacyAlertBtnUseFont = Builder.access$20100(builder);
        this.privacyAlertBtnTypeface = Builder.access$20200(builder);
        this.privacyAlertBtnFontName = Builder.access$20300(builder);
        this.privacyAlertBtnHorizontalMargin = Builder.access$20400(builder);
        this.privacyAlertBtnVerticalMargin = Builder.access$20500(builder);
        this.privacyAlertBtnBackgroundImgDrawable = Builder.access$20600(builder);
        this.privacyAlertBtnWidth = Builder.access$20700(builder);
        this.privacyAlertBtnHeigth = Builder.access$20800(builder);
        this.privacyAlertCloseBtnShow = Builder.access$20900(builder);
        this.privacyAlertCloseImagPath = Builder.access$21000(builder);
        this.privacyAlertCloseScaleType = Builder.access$21100(builder);
        this.privacyAlertCloseImagDrawable = Builder.access$21200(builder);
        this.privacyAlertCloseImgWidth = Builder.access$21300(builder);
        this.privacyAlertCloseImgHeight = Builder.access$21400(builder);
        this.privacyAlertMaskIsNeedShow = Builder.access$21500(builder);
    }

    private String[] makePrivacyConectTexts(String[] strArr) {
        try {
            String[] strArr2 = {"和", "、", "、"};
            if (strArr != null && strArr.length != 0) {
                String[] strArr3 = {"和", "、", "、"};
                int length = strArr.length;
                for (int i10 = 0; i10 < length && i10 < 3; i10++) {
                    strArr3[i10] = strArr[i10];
                }
                return strArr3;
            }
            return strArr2;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getActivityIn() {
        try {
            return this.activityIn;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getActivityOut() {
        try {
            return this.activityOut;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getAuthPageActIn() {
        try {
            return this.authPageActIn;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getAuthPageActOut() {
        try {
            return this.authPageActOut;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getBottomNavBarColor() {
        try {
            return this.bottomNavBarColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getCheckBoxHeight() {
        try {
            return this.checkBoxHeight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getCheckBoxMarginTop() {
        try {
            return this.checkBoxMarginTop;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getCheckBoxShakePath() {
        try {
            return this.checkBoxShakePath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getCheckBoxWidth() {
        try {
            return this.checkBoxWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Drawable getCheckedImgDrawable() {
        try {
            return this.checkedImgDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getCheckedImgPath() {
        try {
            return this.checkedImgPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public float getDialogAlpha() {
        try {
            return this.dialogAlpha;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1.0f;
        }
    }

    public int getDialogHeight() {
        try {
            return this.dialogHeight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getDialogOffsetX() {
        try {
            return this.dialogOffsetX;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getDialogOffsetY() {
        try {
            return this.dialogOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getDialogWidth() {
        try {
            return this.dialogWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Drawable getLoadingBackgroundDrawable() {
        try {
            return this.loadingBackgroundDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getLoadingBackgroundPath() {
        try {
            return this.loadingBackgroundPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Drawable getLoadingImgDrawable() {
        try {
            return this.loadingImgDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getLoadingImgPath() {
        try {
            return this.loadingImgPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Drawable getLogBtnBackgroundDrawable() {
        try {
            return this.logBtnBackgroundDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getLogBtnBackgroundPath() {
        try {
            return this.logBtnBackgroundPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public StateListDrawable getLogBtnBgStateListDrawable() {
        try {
            return this.logBtnBgStateListDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getLogBtnFontName() {
        try {
            return this.logBtnFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getLogBtnHeight() {
        try {
            return this.logBtnHeight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getLogBtnLayoutGravity() {
        try {
            return this.logBtnLayoutGravity;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getLogBtnMarginLeftAndRight() {
        try {
            return this.logBtnMarginLeftAndRight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getLogBtnOffsetX() {
        try {
            return this.logBtnOffsetX;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getLogBtnOffsetY() {
        try {
            return this.logBtnOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getLogBtnOffsetY_B() {
        try {
            return this.logBtnOffsetY_B;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getLogBtnText() {
        try {
            return this.logBtnText;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getLogBtnTextColor() {
        try {
            return this.logBtnTextColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public ColorStateList getLogBtnTextColorStateList() {
        try {
            return this.logBtnTextColorStateList;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getLogBtnTextSize() {
        try {
            return this.logBtnTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getLogBtnTypeface() {
        try {
            return this.logBtnTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getLogBtnWidth() {
        try {
            return this.logBtnWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getLogoHeight() {
        try {
            return this.logoHeight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Drawable getLogoImgDrawable() {
        try {
            return this.logoImgDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getLogoImgPath() {
        try {
            return this.logoImgPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getLogoOffsetY() {
        try {
            return this.logoOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getLogoOffsetY_B() {
        try {
            return this.logoOffsetY_B;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        try {
            return this.logoScaleType;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getLogoWidth() {
        try {
            return this.logoWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getMode(int i10) {
        return i10 & MODE_MASK;
    }

    public int getNavColor() {
        try {
            return this.navColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getNavFontName() {
        try {
            return this.navFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Drawable getNavReturnImgDrawable() {
        try {
            return this.navReturnImgDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getNavReturnImgHeight() {
        try {
            return this.navReturnImgHeight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getNavReturnImgPath() {
        try {
            return this.navReturnImgPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getNavReturnImgWidth() {
        try {
            return this.navReturnImgWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public ImageView.ScaleType getNavReturnScaleType() {
        try {
            return this.navReturnScaleType;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getNavText() {
        try {
            return this.navText;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getNavTextColor() {
        try {
            return this.navTextColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getNavTextSize() {
        try {
            return this.navTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getNavTypeFace() {
        try {
            return this.navTypeFace;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getNumFieldOffsetY() {
        try {
            return this.numFieldOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getNumFieldOffsetY_B() {
        try {
            return this.numFieldOffsetY_B;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getNumberColor() {
        try {
            return this.numberColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getNumberFieldOffsetX() {
        try {
            return this.numberFieldOffsetX;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getNumberFontName() {
        try {
            return this.numberFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getNumberLayoutGravity() {
        try {
            return this.numberLayoutGravity;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getNumberSize() {
        try {
            return this.numberSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getNumberTypeface() {
        try {
            return this.numberTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPackageName() {
        try {
            return this.packageName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Drawable getPageBackgroundDrawable() {
        try {
            return this.pageBackgroundDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPageBackgroundPath() {
        try {
            return this.pageBackgroundPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertAlignment() {
        try {
            return this.privacyAlertAlignment;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public float getPrivacyAlertAlpha() {
        try {
            return this.privacyAlertAlpha;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1.0f;
        }
    }

    public int getPrivacyAlertBackgroundColor() {
        try {
            return this.privacyAlertBackgroundColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getPrivacyAlertBefore() {
        try {
            return this.privacyAlertBefore;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Drawable getPrivacyAlertBtnBackgroundImgDrawable() {
        try {
            return this.privacyAlertBtnBackgroundImgDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyAlertBtnBackgroundImgPath() {
        try {
            return this.privacyAlertBtnBackgroundImgPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public StateListDrawable getPrivacyAlertBtnBgStateListDrawable() {
        try {
            return this.privacyAlertBtnBgStateListDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyAlertBtnFontName() {
        try {
            return this.privacyAlertBtnFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int[] getPrivacyAlertBtnGrivaty() {
        try {
            return this.privacyAlertBtnGrivaty;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertBtnHeigth() {
        try {
            return this.privacyAlertBtnHeigth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertBtnHorizontalMargin() {
        try {
            return this.privacyAlertBtnHorizontalMargin;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertBtnOffsetX() {
        try {
            return this.privacyAlertBtnOffsetX;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertBtnOffsetY() {
        try {
            return this.privacyAlertBtnOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getPrivacyAlertBtnText() {
        try {
            return this.privacyAlertBtnText;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertBtnTextColor() {
        try {
            return this.privacyAlertBtnTextColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getPrivacyAlertBtnTextColorPath() {
        try {
            return this.privacyAlertBtnTextColorPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public ColorStateList getPrivacyAlertBtnTextColorStateList() {
        try {
            return this.privacyAlertBtnTextColorStateList;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertBtnTextSize() {
        try {
            return this.privacyAlertBtnTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getPrivacyAlertBtnTypeface() {
        try {
            return this.privacyAlertBtnTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertBtnVerticalMargin() {
        try {
            return this.privacyAlertBtnVerticalMargin;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertBtnWidth() {
        try {
            return this.privacyAlertBtnWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Drawable getPrivacyAlertCloseImagDrawable() {
        try {
            return this.privacyAlertCloseImagDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyAlertCloseImagPath() {
        try {
            return this.privacyAlertCloseImagPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertCloseImgHeight() {
        try {
            return this.privacyAlertCloseImgHeight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertCloseImgWidth() {
        try {
            return this.privacyAlertCloseImgWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public ImageView.ScaleType getPrivacyAlertCloseScaleType() {
        try {
            return this.privacyAlertCloseScaleType;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertContentAlignment() {
        try {
            return this.privacyAlertContentAlignment;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertContentBackgroundColor() {
        try {
            return this.privacyAlertContentBackgroundColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertContentBaseColor() {
        try {
            return this.privacyAlertContentBaseColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertContentColor() {
        try {
            return this.privacyAlertContentColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertContentHorizontalMargin() {
        try {
            return this.privacyAlertContentHorizontalMargin;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getPrivacyAlertContentTextFontName() {
        try {
            return this.privacyAlertContentTextFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertContentTextSize() {
        try {
            return this.privacyAlertContentTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getPrivacyAlertContentTypeface() {
        try {
            return this.privacyAlertContentTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertContentVerticalMargin() {
        try {
            return this.privacyAlertContentVerticalMargin;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int[] getPrivacyAlertCornerRadiusArray() {
        try {
            return this.privacyAlertCornerRadiusArray;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyAlertEnd() {
        try {
            return this.privacyAlertEnd;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyAlertEntryAnimation() {
        try {
            return this.privacyAlertEntryAnimation;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyAlertExitAnimation() {
        try {
            return this.privacyAlertExitAnimation;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertHeight() {
        try {
            return this.privacyAlertHeight;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public float getPrivacyAlertMaskAlpha() {
        try {
            return this.privacyAlertMaskAlpha;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1.0f;
        }
    }

    public int getPrivacyAlertMaskColor() {
        try {
            return this.privacyAlertMaskColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertOffsetX() {
        try {
            return this.privacyAlertOffsetX;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertOffsetY() {
        try {
            return this.privacyAlertOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertOperatorColor() {
        try {
            return this.privacyAlertOperatorColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertOwnOneColor() {
        try {
            return this.privacyAlertOwnOneColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertOwnThreeColor() {
        try {
            return this.privacyAlertOwnThreeColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertOwnTwoColor() {
        try {
            return this.privacyAlertOwnTwoColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertProtocolLineSpaceDp() {
        try {
            return this.privacyAlertProtocolLineSpaceDp;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getPrivacyAlertProtocolNameTypeface() {
        try {
            return this.privacyAlertProtocolNameTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertTitleAlignment() {
        try {
            return this.privacyAlertTitleAlignment;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertTitleBackgroundColor() {
        try {
            return this.privacyAlertTitleBackgroundColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertTitleColor() {
        try {
            return this.privacyAlertTitleColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertTitleOffsetX() {
        try {
            return this.privacyAlertTitleOffsetX;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyAlertTitleOffsetY() {
        try {
            return this.privacyAlertTitleOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getPrivacyAlertTitleText() {
        try {
            return this.privacyAlertTitleText;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyAlertTitleTextFontName() {
        try {
            return this.privacyAlertTitleTextFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertTitleTextSize() {
        try {
            return this.privacyAlertTitleTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getPrivacyAlertTitleTypeface() {
        try {
            return this.privacyAlertTitleTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyAlertWidth() {
        try {
            return this.privacyAlertWidth;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getPrivacyBefore() {
        try {
            return this.privacyBefore;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String[] getPrivacyConectTexts() {
        try {
            return this.privacyConectTexts;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getPrivacyEnd() {
        try {
            return this.privacyEnd;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getPrivacyMargin() {
        try {
            return this.privacyMargin;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyOffsetX() {
        try {
            return this.privacyOffsetX;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyOffsetY() {
        try {
            return this.privacyOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyOffsetY_B() {
        try {
            return this.privacyOffsetY_B;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyOperatorIndex() {
        try {
            return this.privacyOperatorIndex;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getPrivacyTextSize() {
        try {
            return this.privacyTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getProtocolAction() {
        try {
            return this.protocolAction;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getProtocolColor() {
        try {
            return this.protocolColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getProtocolFontName() {
        try {
            return this.protocolFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getProtocolGravity() {
        try {
            return this.protocolGravity;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getProtocolLayoutGravity() {
        try {
            return this.protocolLayoutGravity;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getProtocolLineSpaceDp() {
        try {
            return this.protocolLineSpaceDp;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getProtocolNameTypeface() {
        try {
            return this.protocolNameTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getProtocolOneColor() {
        try {
            return this.protocolOneColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getProtocolOneName() {
        try {
            return this.protocolOneName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getProtocolOneURL() {
        try {
            return this.protocolOneURL;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getProtocolOwnColor() {
        try {
            return this.protocolOwnColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getProtocolOwnOneColor() {
        try {
            return this.protocolOwnOneColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getProtocolOwnThreeColor() {
        try {
            return this.protocolOwnThreeColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getProtocolOwnTwoColor() {
        try {
            return this.protocolOwnTwoColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getProtocolShakePath() {
        try {
            return this.protocolShakePath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getProtocolThreeColor() {
        try {
            return this.protocolThreeColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getProtocolThreeName() {
        try {
            return this.protocolThreeName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getProtocolThreeURL() {
        try {
            return this.protocolThreeURL;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getProtocolTwoColor() {
        try {
            return this.protocolTwoColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getProtocolTwoName() {
        try {
            return this.protocolTwoName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getProtocolTwoURL() {
        try {
            return this.protocolTwoURL;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Typeface getProtocolTypeface() {
        try {
            return this.protocolTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getScreenOrientation() {
        try {
            return this.screenOrientation;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getSize(int i10) {
        return i10 & View.LAST_APP_AUTOFILL_ID;
    }

    public String getSloganFontName() {
        try {
            return this.sloganFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getSloganOffsetY() {
        try {
            return this.sloganOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getSloganOffsetY_B() {
        try {
            return this.sloganOffsetY_B;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getSloganText() {
        try {
            return this.sloganText;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getSloganTextColor() {
        try {
            return this.sloganTextColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getSloganTextSize() {
        try {
            return this.sloganTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Typeface getSloganTypeface() {
        try {
            return this.sloganTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getStatusBarColor() {
        try {
            return this.statusBarColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getStatusBarUIFlag() {
        try {
            return this.statusBarUIFlag;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getSwitchAccText() {
        try {
            return this.switchAccText;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getSwitchAccTextColor() {
        try {
            return this.switchAccTextColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public ColorStateList getSwitchAccTextColorStateList() {
        try {
            return this.switchAccTextColorStateList;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getSwitchAccTextSize() {
        try {
            return this.switchAccTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getSwitchOffsetY() {
        try {
            return this.switchOffsetY;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getSwitchOffsetY_B() {
        try {
            return this.switchOffsetY_B;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public String getSwtichFontName() {
        try {
            return this.swtichFontName;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Typeface getSwtichTypeface() {
        try {
            return this.swtichTypeface;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public Drawable getUncheckedImgDrawable() {
        try {
            return this.uncheckedImgDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getUncheckedImgPath() {
        try {
            return this.uncheckedImgPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getVendorPrivacyPrefix() {
        try {
            return this.vendorPrivacyPrefix;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getVendorPrivacySuffix() {
        try {
            return this.vendorPrivacySuffix;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getWebCacheMode() {
        try {
            return this.webCacheMode;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getWebNavColor() {
        try {
            return this.webNavColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public Drawable getWebNavReturnImgDrawable() {
        try {
            return this.webNavReturnImgDrawable;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String getWebNavReturnImgPath() {
        try {
            return this.webNavReturnImgPath;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int getWebNavTextColor() {
        try {
            return this.webNavTextColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getWebNavTextSize() {
        try {
            return this.webNavTextSize;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public int getWebViewStatusBarColor() {
        try {
            return this.webViewStatusBarColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public boolean isCheckboxHidden() {
        try {
            return this.checkboxHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isDialog() {
        try {
            if (this.dialogWidth > 0) {
                return this.dialogHeight > 0;
            }
            return false;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isDialogBottom() {
        try {
            return this.dialogBottom;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isHiddenLoading() {
        try {
            return this.isHiddenLoading;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isLightColor() {
        try {
            return this.isLightColor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isLogBtnToastHidden() {
        try {
            return this.logBtnToastHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isLogBtnUseFont() {
        try {
            return this.logBtnUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isLogoHidden() {
        try {
            return this.logoHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isNavHidden() {
        try {
            return this.navHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isNavReturnHidden() {
        try {
            return this.navReturnHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isNavUseFont() {
        try {
            return this.navUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isNumberUseFont() {
        try {
            return this.numberUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertBtnUseFont() {
        try {
            return this.privacyAlertBtnUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertCloseBtnShow() {
        try {
            return this.privacyAlertCloseBtnShow;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertContentTextUseFont() {
        try {
            return this.privacyAlertContentTextUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertIsNeedAutoLogin() {
        try {
            return this.privacyAlertIsNeedAutoLogin;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertIsNeedShow() {
        try {
            return this.privacyAlertIsNeedShow;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertMaskIsNeedShow() {
        try {
            return this.privacyAlertMaskIsNeedShow;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertProtocolNameUseUnderLine() {
        try {
            return this.privacyAlertProtocolNameUseUnderLine;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyAlertTitleTextUseFont() {
        try {
            return this.privacyAlertTitleTextUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isPrivacyState() {
        try {
            return this.privacyState;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isProtocolNameUseUnderLine() {
        try {
            return this.protocolNameUseUnderLine;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isProtocolUseFont() {
        try {
            return this.protocolUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isSloganHidden() {
        try {
            return this.sloganHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isSloganUseFont() {
        try {
            return this.sloganUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isStatusBarHidden() {
        try {
            return this.isStatusBarHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isSwitchAccHidden() {
        try {
            return this.switchAccHidden;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isSwtichUseFont() {
        try {
            return this.swtichUseFont;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isTapAuthPageMaskClosePage() {
        try {
            return this.tapAuthPageMaskClosePage;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isTapPrivacyAlertMaskCloseAlert() {
        try {
            return this.tapPrivacyAlertMaskCloseAlert;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isWebHiddeProgress() {
        try {
            return this.webHiddeProgress;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean isWebSupportedJavascript() {
        try {
            return this.webSupportedJavascript;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void setDialogAlpha(float f10) {
        try {
            this.dialogAlpha = f10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void setProtocolThreeColor(int i10) {
        try {
            this.protocolThreeColor = i10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void setProtocolThreeName(String str) {
        try {
            this.protocolThreeName = str;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void setProtocolThreeURL(String str) {
        try {
            this.protocolThreeURL = str;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void setTextSize(TextView textView, int i10) {
        int i11;
        int size;
        try {
            if (getMode(i10) == 0) {
                i11 = 2;
                size = getSize(i10);
            } else {
                i11 = 1;
                size = getSize(i10);
            }
            textView.setTextSize(i11, size);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public String toString() {
        try {
            return "AuthUIConfig{statusBarColor=" + this.statusBarColor + ", bottomNavBarColor=" + this.bottomNavBarColor + ", isLightColor=" + this.isLightColor + ", isStatusBarHidden=" + this.isStatusBarHidden + ", statusBarUIFlag=" + this.statusBarUIFlag + ", navColor=" + this.navColor + ", navText='" + this.navText + "', navTextColor=" + this.navTextColor + ", navTextSize=" + this.navTextSize + ", navReturnImgPath='" + this.navReturnImgPath + "', navReturnImgWidth=" + this.navReturnImgWidth + ", navReturnImgHeight=" + this.navReturnImgHeight + ", navReturnHidden=" + this.navReturnHidden + ", navReturnScaleType=" + ((Object) this.navReturnScaleType) + ", navHidden=" + this.navHidden + ", logoImgPath='" + this.logoImgPath + "', logoWidth=" + this.logoWidth + ", logoHeight=" + this.logoHeight + ", logoHidden=" + this.logoHidden + ", logoOffsetY=" + this.logoOffsetY + ", logoOffsetY_B=" + this.logoOffsetY_B + ", logoScaleType=" + ((Object) this.logoScaleType) + ", checkboxHidden=" + this.checkboxHidden + ", uncheckedImgPath='" + this.uncheckedImgPath + "', checkedImgPath='" + this.checkedImgPath + "', checkBoxHeight=" + this.checkBoxHeight + ", checkBoxWidth=" + this.checkBoxWidth + ", numberColor=" + this.numberColor + ", numberSize=" + this.numberSize + ", numFieldOffsetY=" + this.numFieldOffsetY + ", numFieldOffsetY_B=" + this.numFieldOffsetY_B + ", numberFieldOffsetX=" + this.numberFieldOffsetX + ", numberLayoutGravity=" + this.numberLayoutGravity + ", switchAccHidden=" + this.switchAccHidden + ", switchAccTextColor=" + this.switchAccTextColor + ", switchAccTextSize=" + this.switchAccTextSize + ", switchAccText='" + this.switchAccText + "', switchOffsetY=" + this.switchOffsetY + ", switchOffsetY_B=" + this.switchOffsetY_B + ", logBtnText='" + this.logBtnText + "', logBtnTextColor=" + this.logBtnTextColor + ", logBtnTextSize=" + this.logBtnTextSize + ", logBtnBackgroundPath='" + this.logBtnBackgroundPath + "', logBtnOffsetX=" + this.logBtnOffsetX + ", logBtnOffsetY=" + this.logBtnOffsetY + ", logBtnOffsetY_B=" + this.logBtnOffsetY_B + ", logBtnWidth=" + this.logBtnWidth + ", logBtnHeight=" + this.logBtnHeight + ", logBtnMarginLeftAndRight=" + this.logBtnMarginLeftAndRight + ", loadingImgPath='" + this.loadingImgPath + "', logBtnLayoutGravity=" + this.logBtnLayoutGravity + ", logBtnToastHidden=" + this.logBtnToastHidden + ", protocolOneName='" + this.protocolOneName + "', protocolOneURL='" + this.protocolOneURL + "', protocolOneColor=" + this.protocolOneColor + ", protocolTwoName='" + this.protocolTwoName + "', protocolTwoURL='" + this.protocolTwoURL + "', protocolTwoColor=" + this.protocolTwoColor + ", protocolColor=" + this.protocolColor + ", privacyOffsetX=" + this.privacyOffsetX + ", privacyOffsetY=" + this.privacyOffsetY + ", privacyOffsetY_B=" + this.privacyOffsetY_B + ", privacyState=" + this.privacyState + ", protocolGravity=" + this.protocolGravity + ", privacyTextSize=" + this.privacyTextSize + ", privacyMargin=" + this.privacyMargin + ", privacyBefore='" + this.privacyBefore + "', privacyEnd='" + this.privacyEnd + "', vendorPrivacyPrefix='" + this.vendorPrivacyPrefix + "', vendorPrivacySuffix='" + this.vendorPrivacySuffix + "', protocolLayoutGravity=" + this.protocolLayoutGravity + ", sloganHidden=" + this.sloganHidden + ", sloganText='" + this.sloganText + "', sloganTextSize=" + this.sloganTextSize + ", sloganTextColor=" + this.sloganTextColor + ", sloganOffsetY=" + this.sloganOffsetY + ", sloganOffsetY_B=" + this.sloganOffsetY_B + ", dialogWidth=" + this.dialogWidth + ", dialogHeight=" + this.dialogHeight + ", dialogBottom=" + this.dialogBottom + ", dialogOffsetX=" + this.dialogOffsetX + ", dialogOffsetY=" + this.dialogOffsetY + ", pageBackgroundPath='" + this.pageBackgroundPath + "', webViewStatusBarColor=" + this.webViewStatusBarColor + ", webNavColor=" + this.webNavColor + ", webNavTextColor=" + this.webNavTextColor + ", webNavTextSize=" + this.webNavTextSize + ", webNavReturnImgPath='" + this.webNavReturnImgPath + "', webSupportedJavascript=" + this.webSupportedJavascript + ", authPageActIn='" + this.authPageActIn + "', activityOut='" + this.activityOut + "', authPageActOut='" + this.authPageActOut + "', activityIn='" + this.activityIn + "', screenOrientation=" + this.screenOrientation + ", dialogAlpha=" + this.dialogAlpha + ", protocolThreeName='" + this.protocolThreeName + "', protocolThreeURL='" + this.protocolThreeURL + "', privacyConectTexts='" + ((Object) this.privacyConectTexts) + "', privacyOperatorIndex='" + this.privacyOperatorIndex + "', protocolAction='" + this.protocolAction + "', packageName='" + this.packageName + "', protocolThreeColor=" + this.protocolThreeColor + ", loadingBackgroundPath=" + this.loadingBackgroundPath + ", isHiddenLoading=" + this.isHiddenLoading + ", privacyAlertIsNeedShow=" + this.privacyAlertIsNeedShow + ", privacyAlertIsNeedAutoLogin=" + this.privacyAlertIsNeedAutoLogin + ", tapPrivacyAlertMaskCloseAlert=" + this.tapPrivacyAlertMaskCloseAlert + ", privacyAlertAlignment=" + this.privacyAlertAlignment + ", privacyAlertWidth=" + this.privacyAlertWidth + ", privacyAlertHeight=" + this.privacyAlertHeight + ", privacyAlertOffsetX=" + this.privacyAlertOffsetX + ", privacyAlertOffsetY=" + this.privacyAlertOffsetY + ", privacyAlertEntryAnimation=" + this.privacyAlertEntryAnimation + ", privacyAlertExitAnimation=" + this.privacyAlertExitAnimation + ", privacyAlertCornerRadiusArray=" + ((Object) this.privacyAlertCornerRadiusArray) + ", privacyAlertBackgroundColor=" + this.privacyAlertBackgroundColor + ", privacyAlertAlpha=" + this.privacyAlertAlpha + ", privacyAlertMaskAlpha=" + this.privacyAlertMaskAlpha + ", privacyAlertTitleTextSize=" + this.privacyAlertTitleTextSize + ", privacyAlertTitleColor=" + this.privacyAlertTitleColor + ", privacyAlertTitleOffsetX=" + this.privacyAlertTitleOffsetX + ", privacyAlertTitleOffsetY=" + this.privacyAlertTitleOffsetY + ", privacyAlertContentTextSize=" + this.privacyAlertContentTextSize + ", privacyAlertContentColor=" + this.privacyAlertContentColor + ", privacyAlertContentBaseColor=" + this.privacyAlertContentBaseColor + ", privacyAlertContentHorizontalMargin=" + this.privacyAlertContentHorizontalMargin + ", privacyAlertContentVerticalMargin=" + this.privacyAlertContentVerticalMargin + ", privacyAlertBtnBackgroundImgPath=" + this.privacyAlertBtnBackgroundImgPath + ", privacyAlertBtnTextColor=" + this.privacyAlertBtnTextColor + ", privacyAlertBtnTextSize=" + this.privacyAlertBtnTextSize + ", privacyAlertBtnWidth=" + this.privacyAlertBtnWidth + ", privacyAlertBtnHeigth=" + this.privacyAlertBtnHeigth + ", privacyAlertCloseBtnShow=" + this.privacyAlertCloseBtnShow + ", privacyAlertMaskIsNeedShow=" + this.privacyAlertMaskIsNeedShow + ", privacyAlertCloseImagPath=" + this.privacyAlertCloseImagPath + ", privacyAlertCloseScaleType=" + ((Object) this.privacyAlertCloseScaleType) + ", privacyAlertCloseImgWidth=" + this.privacyAlertCloseImgWidth + ", privacyAlertCloseImgHeight=" + this.privacyAlertCloseImgHeight + '}';
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }
}
