package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.style.TtsSpan;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadialTimePickerView;
import android.widget.RelativeLayout;
import android.widget.TextInputTimePickerView;
import android.widget.TimePicker;
import com.android.internal.R;
import com.android.internal.widget.NumericTextView;
import com.huawei.openalliance.ad.constant.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class TimePickerClockDelegate extends TimePicker.AbstractTimePickerDelegate {
    private static final int AM = 0;
    private static final long DELAY_COMMIT_MILLIS = 2000;
    private static final int FROM_EXTERNAL_API = 0;
    private static final int FROM_INPUT_PICKER = 2;
    private static final int FROM_RADIAL_PICKER = 1;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final int HOUR_INDEX = 0;
    private static final int MINUTE_INDEX = 1;
    private static final int PM = 1;
    private boolean mAllowAutoAdvance;
    private final RadioButton mAmLabel;
    private final View mAmPmLayout;
    private final View.OnClickListener mClickListener;
    private final Runnable mCommitHour;
    private final Runnable mCommitMinute;
    private int mCurrentHour;
    private int mCurrentMinute;
    private final NumericTextView.OnValueChangedListener mDigitEnteredListener;
    private final View.OnFocusChangeListener mFocusListener;
    private boolean mHourFormatShowLeadingZero;
    private boolean mHourFormatStartsAtZero;
    private final NumericTextView mHourView;
    private boolean mIs24Hour;
    private boolean mIsAmPmAtLeft;
    private boolean mIsAmPmAtTop;
    private boolean mIsEnabled;
    private boolean mLastAnnouncedIsHour;
    private CharSequence mLastAnnouncedText;
    private final NumericTextView mMinuteView;
    private final RadialTimePickerView.OnValueSelectedListener mOnValueSelectedListener;
    private final TextInputTimePickerView.OnValueTypedListener mOnValueTypedListener;
    private final RadioButton mPmLabel;
    private boolean mRadialPickerModeEnabled;
    private final View mRadialTimePickerHeader;
    private final ImageButton mRadialTimePickerModeButton;
    private final String mRadialTimePickerModeEnabledDescription;
    private final RadialTimePickerView mRadialTimePickerView;
    private final String mSelectHours;
    private final String mSelectMinutes;
    private final TextView mSeparatorView;
    private final Calendar mTempCalendar;
    private final View mTextInputPickerHeader;
    private final String mTextInputPickerModeEnabledDescription;
    private final TextInputTimePickerView mTextInputPickerView;
    private static final int[] ATTRS_TEXT_COLOR = {16842904};
    private static final int[] ATTRS_DISABLED_ALPHA = {16842803};

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private @interface ChangeSource {
    }

    public TimePickerClockDelegate(TimePicker delegator, Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(delegator, context);
        RadialTimePickerView.OnValueSelectedListener onValueSelectedListener;
        ColorStateList headerTextColor;
        this.mRadialPickerModeEnabled = true;
        this.mIsEnabled = true;
        this.mIsAmPmAtLeft = false;
        this.mIsAmPmAtTop = false;
        RadialTimePickerView.OnValueSelectedListener onValueSelectedListener2 = new RadialTimePickerView.OnValueSelectedListener() { // from class: android.widget.TimePickerClockDelegate.2
            @Override // android.widget.RadialTimePickerView.OnValueSelectedListener
            public void onValueSelected(int pickerType, int newValue, boolean autoAdvance) {
                boolean valueChanged = false;
                switch (pickerType) {
                    case 0:
                        if (TimePickerClockDelegate.this.getHour() != newValue) {
                            valueChanged = true;
                        }
                        boolean isTransition = TimePickerClockDelegate.this.mAllowAutoAdvance && autoAdvance;
                        TimePickerClockDelegate.this.setHourInternal(newValue, 1, !isTransition, true);
                        if (isTransition) {
                            TimePickerClockDelegate.this.setCurrentItemShowing(1, true, false);
                            int localizedHour = TimePickerClockDelegate.this.getLocalizedHour(newValue);
                            TimePickerClockDelegate.this.mDelegator.announceForAccessibility(localizedHour + ". " + TimePickerClockDelegate.this.mSelectMinutes);
                            break;
                        }
                        break;
                    case 1:
                        if (TimePickerClockDelegate.this.getMinute() != newValue) {
                            valueChanged = true;
                        }
                        TimePickerClockDelegate.this.setMinuteInternal(newValue, 1, true);
                        break;
                }
                if (TimePickerClockDelegate.this.mOnTimeChangedListener != null && valueChanged) {
                    TimePickerClockDelegate.this.mOnTimeChangedListener.onTimeChanged(TimePickerClockDelegate.this.mDelegator, TimePickerClockDelegate.this.getHour(), TimePickerClockDelegate.this.getMinute());
                }
            }
        };
        this.mOnValueSelectedListener = onValueSelectedListener2;
        TextInputTimePickerView.OnValueTypedListener onValueTypedListener = new TextInputTimePickerView.OnValueTypedListener() { // from class: android.widget.TimePickerClockDelegate.3
            @Override // android.widget.TextInputTimePickerView.OnValueTypedListener
            public void onValueChanged(int pickerType, int newValue) {
                switch (pickerType) {
                    case 0:
                        TimePickerClockDelegate.this.setHourInternal(newValue, 2, false, true);
                        return;
                    case 1:
                        TimePickerClockDelegate.this.setMinuteInternal(newValue, 2, true);
                        return;
                    case 2:
                        TimePickerClockDelegate.this.setAmOrPm(newValue);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mOnValueTypedListener = onValueTypedListener;
        NumericTextView.OnValueChangedListener onValueChangedListener = new NumericTextView.OnValueChangedListener() { // from class: android.widget.TimePickerClockDelegate.4
            public void onValueChanged(NumericTextView view, int value, boolean isValid, boolean isFinished) {
                Runnable commitCallback;
                NumericTextView numericTextView;
                if (view == TimePickerClockDelegate.this.mHourView) {
                    commitCallback = TimePickerClockDelegate.this.mCommitHour;
                    numericTextView = view.isFocused() ? TimePickerClockDelegate.this.mMinuteView : null;
                } else if (view == TimePickerClockDelegate.this.mMinuteView) {
                    commitCallback = TimePickerClockDelegate.this.mCommitMinute;
                    numericTextView = null;
                } else {
                    return;
                }
                view.removeCallbacks(commitCallback);
                if (isValid) {
                    if (isFinished) {
                        commitCallback.run();
                        if (numericTextView != null) {
                            numericTextView.requestFocus();
                            return;
                        }
                        return;
                    }
                    view.postDelayed(commitCallback, TimePickerClockDelegate.DELAY_COMMIT_MILLIS);
                }
            }
        };
        this.mDigitEnteredListener = onValueChangedListener;
        this.mCommitHour = new Runnable() { // from class: android.widget.TimePickerClockDelegate.5
            @Override // java.lang.Runnable
            public void run() {
                TimePickerClockDelegate timePickerClockDelegate = TimePickerClockDelegate.this;
                timePickerClockDelegate.setHour(timePickerClockDelegate.mHourView.getValue());
            }
        };
        this.mCommitMinute = new Runnable() { // from class: android.widget.TimePickerClockDelegate.6
            @Override // java.lang.Runnable
            public void run() {
                TimePickerClockDelegate timePickerClockDelegate = TimePickerClockDelegate.this;
                timePickerClockDelegate.setMinute(timePickerClockDelegate.mMinuteView.getValue());
            }
        };
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: android.widget.TimePickerClockDelegate.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v2, boolean focused) {
                if (focused) {
                    switch (v2.getId()) {
                        case 16908781:
                            TimePickerClockDelegate.this.setAmOrPm(0);
                            break;
                        case 16909105:
                            TimePickerClockDelegate.this.setCurrentItemShowing(0, true, true);
                            break;
                        case 16909254:
                            TimePickerClockDelegate.this.setCurrentItemShowing(1, true, true);
                            break;
                        case 16909383:
                            TimePickerClockDelegate.this.setAmOrPm(1);
                            break;
                        default:
                            return;
                    }
                    TimePickerClockDelegate.this.tryVibrate();
                }
            }
        };
        this.mFocusListener = onFocusChangeListener;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: android.widget.TimePickerClockDelegate.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                switch (v2.getId()) {
                    case 16908781:
                        TimePickerClockDelegate.this.setAmOrPm(0);
                        break;
                    case 16909105:
                        TimePickerClockDelegate.this.setCurrentItemShowing(0, true, true);
                        break;
                    case 16909254:
                        TimePickerClockDelegate.this.setCurrentItemShowing(1, true, true);
                        break;
                    case 16909383:
                        TimePickerClockDelegate.this.setAmOrPm(1);
                        break;
                    default:
                        return;
                }
                TimePickerClockDelegate.this.tryVibrate();
            }
        };
        this.mClickListener = onClickListener;
        TypedArray a10 = this.mContext.obtainStyledAttributes(attrs, R.styleable.TimePicker, defStyleAttr, defStyleRes);
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        Resources res = this.mContext.getResources();
        this.mSelectHours = res.getString(R.string.select_hours);
        this.mSelectMinutes = res.getString(R.string.select_minutes);
        int layoutResourceId = a10.getResourceId(12, R.layout.time_picker_material);
        View mainView = inflater.inflate(layoutResourceId, delegator);
        mainView.setSaveFromParentEnabled(false);
        View findViewById = mainView.findViewById(16909642);
        this.mRadialTimePickerHeader = findViewById;
        findViewById.setOnTouchListener(new NearestTouchDelegate());
        NumericTextView findViewById2 = mainView.findViewById(16909105);
        this.mHourView = findViewById2;
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setOnFocusChangeListener(onFocusChangeListener);
        findViewById2.setOnDigitEnteredListener(onValueChangedListener);
        findViewById2.setAccessibilityDelegate(new ClickActionDelegate(context, R.string.select_hours));
        TextView textView = (TextView) mainView.findViewById(16909498);
        this.mSeparatorView = textView;
        NumericTextView findViewById3 = mainView.findViewById(16909254);
        this.mMinuteView = findViewById3;
        findViewById3.setOnClickListener(onClickListener);
        findViewById3.setOnFocusChangeListener(onFocusChangeListener);
        findViewById3.setOnDigitEnteredListener(onValueChangedListener);
        findViewById3.setAccessibilityDelegate(new ClickActionDelegate(context, R.string.select_minutes));
        findViewById3.setRange(0, 59);
        View findViewById4 = mainView.findViewById(16908783);
        this.mAmPmLayout = findViewById4;
        findViewById4.setOnTouchListener(new NearestTouchDelegate());
        String[] amPmStrings = TimePicker.getAmPmStrings(context);
        RadioButton radioButton = (RadioButton) findViewById4.findViewById(16908781);
        this.mAmLabel = radioButton;
        radioButton.setText(obtainVerbatim(amPmStrings[0]));
        radioButton.setOnClickListener(onClickListener);
        ensureMinimumTextWidth(radioButton);
        RadioButton radioButton2 = (RadioButton) findViewById4.findViewById(16909383);
        this.mPmLabel = radioButton2;
        radioButton2.setText(obtainVerbatim(amPmStrings[1]));
        radioButton2.setOnClickListener(onClickListener);
        ensureMinimumTextWidth(radioButton2);
        int timeHeaderTextAppearance = a10.getResourceId(1, 0);
        if (timeHeaderTextAppearance == 0) {
            onValueSelectedListener = onValueSelectedListener2;
            headerTextColor = null;
        } else {
            onValueSelectedListener = onValueSelectedListener2;
            TypedArray textAppearance = this.mContext.obtainStyledAttributes(null, ATTRS_TEXT_COLOR, 0, timeHeaderTextAppearance);
            ColorStateList legacyHeaderTextColor = textAppearance.getColorStateList(0);
            headerTextColor = applyLegacyColorFixes(legacyHeaderTextColor);
            textAppearance.recycle();
        }
        headerTextColor = headerTextColor == null ? a10.getColorStateList(11) : headerTextColor;
        View findViewById5 = mainView.findViewById(16909137);
        this.mTextInputPickerHeader = findViewById5;
        if (headerTextColor != null) {
            findViewById2.setTextColor(headerTextColor);
            textView.setTextColor(headerTextColor);
            findViewById3.setTextColor(headerTextColor);
            radioButton.setTextColor(headerTextColor);
            radioButton2.setTextColor(headerTextColor);
        }
        if (a10.hasValueOrEmpty(0)) {
            findViewById.setBackground(a10.getDrawable(0));
            findViewById5.setBackground(a10.getDrawable(0));
        }
        a10.recycle();
        RadialTimePickerView radialTimePickerView = (RadialTimePickerView) mainView.findViewById(16909412);
        this.mRadialTimePickerView = radialTimePickerView;
        radialTimePickerView.applyAttributes(attrs, defStyleAttr, defStyleRes);
        radialTimePickerView.setOnValueSelectedListener(onValueSelectedListener);
        TextInputTimePickerView textInputTimePickerView = (TextInputTimePickerView) mainView.findViewById(16909149);
        this.mTextInputPickerView = textInputTimePickerView;
        textInputTimePickerView.setListener(onValueTypedListener);
        ImageButton imageButton = (ImageButton) mainView.findViewById(R.id.toggle_mode);
        this.mRadialTimePickerModeButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: android.widget.TimePickerClockDelegate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                TimePickerClockDelegate.this.toggleRadialPickerMode();
            }
        });
        this.mRadialTimePickerModeEnabledDescription = context.getResources().getString(R.string.time_picker_radial_mode_description);
        this.mTextInputPickerModeEnabledDescription = context.getResources().getString(R.string.time_picker_text_input_mode_description);
        this.mAllowAutoAdvance = true;
        updateHourFormat();
        Calendar calendar = Calendar.getInstance(this.mLocale);
        this.mTempCalendar = calendar;
        int currentHour = calendar.get(11);
        int currentMinute = calendar.get(12);
        initialize(currentHour, currentMinute, this.mIs24Hour, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleRadialPickerMode() {
        if (this.mRadialPickerModeEnabled) {
            this.mRadialTimePickerView.setVisibility(8);
            this.mRadialTimePickerHeader.setVisibility(8);
            this.mTextInputPickerHeader.setVisibility(0);
            this.mTextInputPickerView.setVisibility(0);
            this.mRadialTimePickerModeButton.setImageResource(17301806);
            this.mRadialTimePickerModeButton.setContentDescription(this.mRadialTimePickerModeEnabledDescription);
            this.mRadialPickerModeEnabled = false;
            return;
        }
        this.mRadialTimePickerView.setVisibility(0);
        this.mRadialTimePickerHeader.setVisibility(0);
        this.mTextInputPickerHeader.setVisibility(8);
        this.mTextInputPickerView.setVisibility(8);
        this.mRadialTimePickerModeButton.setImageResource(17301883);
        this.mRadialTimePickerModeButton.setContentDescription(this.mTextInputPickerModeEnabledDescription);
        updateTextInputPicker();
        InputMethodManager imm = (InputMethodManager) this.mContext.getSystemService(InputMethodManager.class);
        if (imm != null) {
            imm.hideSoftInputFromWindow(this.mDelegator.getWindowToken(), 0);
        }
        this.mRadialPickerModeEnabled = true;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public boolean validateInput() {
        return this.mTextInputPickerView.validateInput();
    }

    private static void ensureMinimumTextWidth(TextView v2) {
        v2.measure(0, 0);
        int minWidth = v2.getMeasuredWidth();
        v2.setMinWidth(minWidth);
        v2.setMinimumWidth(minWidth);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[LOOP:1: B:29:0x006e->B:31:0x0072, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateHourFormat() {
        /*
            r10 = this;
            java.util.Locale r0 = r10.mLocale
            boolean r1 = r10.mIs24Hour
            if (r1 == 0) goto L9
            java.lang.String r1 = "Hm"
            goto Lb
        L9:
            java.lang.String r1 = "hm"
        Lb:
            java.lang.String r0 = android.text.format.DateFormat.getBestDateTimePattern(r0, r1)
            int r1 = r0.length()
            r2 = 0
            r3 = 0
            r4 = 0
        L16:
            r5 = 72
            r6 = 75
            if (r4 >= r1) goto L3e
            char r7 = r0.charAt(r4)
            if (r7 == r5) goto L30
            r8 = 104(0x68, float:1.46E-43)
            if (r7 == r8) goto L30
            if (r7 == r6) goto L30
            r8 = 107(0x6b, float:1.5E-43)
            if (r7 != r8) goto L2d
            goto L30
        L2d:
            int r4 = r4 + 1
            goto L16
        L30:
            r3 = r7
            int r8 = r4 + 1
            if (r8 >= r1) goto L3e
            int r8 = r4 + 1
            char r8 = r0.charAt(r8)
            if (r7 != r8) goto L3e
            r2 = 1
        L3e:
            r10.mHourFormatShowLeadingZero = r2
            r4 = 1
            if (r3 == r6) goto L48
            if (r3 != r5) goto L46
            goto L48
        L46:
            r5 = 0
            goto L49
        L48:
            r5 = r4
        L49:
            r10.mHourFormatStartsAtZero = r5
            r4 = r4 ^ r5
            boolean r5 = r10.mIs24Hour
            if (r5 == 0) goto L53
            r5 = 23
            goto L55
        L53:
            r5 = 11
        L55:
            int r5 = r5 + r4
            com.android.internal.widget.NumericTextView r6 = r10.mHourView
            r6.setRange(r4, r5)
            com.android.internal.widget.NumericTextView r6 = r10.mHourView
            boolean r7 = r10.mHourFormatShowLeadingZero
            r6.setShowLeadingZeroes(r7)
            java.util.Locale r6 = r10.mLocale
            android.icu.text.DecimalFormatSymbols r6 = android.icu.text.DecimalFormatSymbols.getInstance(r6)
            java.lang.String[] r6 = r6.getDigitStrings()
            r7 = 0
            r8 = 0
        L6e:
            r9 = 10
            if (r8 >= r9) goto L7f
            r9 = r6[r8]
            int r9 = r9.length()
            int r7 = java.lang.Math.max(r7, r9)
            int r8 = r8 + 1
            goto L6e
        L7f:
            android.widget.TextInputTimePickerView r8 = r10.mTextInputPickerView
            int r9 = r7 * 2
            r8.setHourFormat(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TimePickerClockDelegate.updateHourFormat():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence obtainVerbatim(String text) {
        return new SpannableStringBuilder().append(text, new TtsSpan.VerbatimBuilder(text).build(), 0);
    }

    private ColorStateList applyLegacyColorFixes(ColorStateList color) {
        int activatedColor;
        int defaultColor;
        if (color == null || color.hasState(16843518)) {
            return color;
        }
        if (color.hasState(16842913)) {
            activatedColor = color.getColorForState(StateSet.get(10), 0);
            defaultColor = color.getColorForState(StateSet.get(8), 0);
        } else {
            activatedColor = color.getDefaultColor();
            TypedArray ta2 = this.mContext.obtainStyledAttributes(ATTRS_DISABLED_ALPHA);
            float disabledAlpha = ta2.getFloat(0, 0.3f);
            ta2.recycle();
            defaultColor = multiplyAlphaComponent(activatedColor, disabledAlpha);
        }
        if (activatedColor == 0 || defaultColor == 0) {
            return null;
        }
        int[][] stateSet = {new int[]{16843518}, new int[0]};
        int[] colors = {activatedColor, defaultColor};
        return new ColorStateList(stateSet, colors);
    }

    private int multiplyAlphaComponent(int color, float alphaMod) {
        int srcRgb = 16777215 & color;
        int srcAlpha = (color >> 24) & 255;
        int dstAlpha = (int) ((srcAlpha * alphaMod) + 0.5f);
        return (dstAlpha << 24) | srcRgb;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class ClickActionDelegate extends View.AccessibilityDelegate {
        private final AccessibilityNodeInfo.AccessibilityAction mClickAction;

        public ClickActionDelegate(Context context, int resId) {
            this.mClickAction = new AccessibilityNodeInfo.AccessibilityAction(16, context.getString(resId));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.addAction(this.mClickAction);
        }
    }

    private void initialize(int hourOfDay, int minute, boolean is24HourView, int index) {
        this.mCurrentHour = hourOfDay;
        this.mCurrentMinute = minute;
        this.mIs24Hour = is24HourView;
        updateUI(index);
    }

    private void updateUI(int index) {
        updateHeaderAmPm();
        updateHeaderHour(this.mCurrentHour, false);
        updateHeaderSeparator();
        updateHeaderMinute(this.mCurrentMinute, false);
        updateRadialPicker(index);
        updateTextInputPicker();
        this.mDelegator.invalidate();
    }

    private void updateTextInputPicker() {
        this.mTextInputPickerView.updateTextInputValues(getLocalizedHour(this.mCurrentHour), this.mCurrentMinute, this.mCurrentHour < 12 ? 0 : 1, this.mIs24Hour, this.mHourFormatStartsAtZero);
    }

    private void updateRadialPicker(int index) {
        this.mRadialTimePickerView.initialize(this.mCurrentHour, this.mCurrentMinute, this.mIs24Hour);
        setCurrentItemShowing(index, false, true);
    }

    private void updateHeaderAmPm() {
        if (this.mIs24Hour) {
            this.mAmPmLayout.setVisibility(8);
            return;
        }
        String dateTimePattern = DateFormat.getBestDateTimePattern(this.mLocale, "hm");
        boolean isAmPmAtStart = dateTimePattern.startsWith("a");
        setAmPmStart(isAmPmAtStart);
        updateAmPmLabelStates(this.mCurrentHour < 12 ? 0 : 1);
    }

    private void setAmPmStart(boolean isAmPmAtStart) {
        boolean isAmPmAtLeft;
        int otherViewId;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.mAmPmLayout.getLayoutParams();
        if (params.getRule(1) != 0 || params.getRule(0) != 0) {
            int margin = (int) (this.mContext.getResources().getDisplayMetrics().density * 8.0f);
            if (TextUtils.getLayoutDirectionFromLocale(this.mLocale) == 0) {
                isAmPmAtLeft = isAmPmAtStart;
            } else {
                isAmPmAtLeft = !isAmPmAtStart;
            }
            if (isAmPmAtLeft) {
                params.removeRule(1);
                params.addRule(0, this.mHourView.getId());
            } else {
                params.removeRule(0);
                params.addRule(1, this.mMinuteView.getId());
            }
            if (isAmPmAtStart) {
                params.setMarginStart(0);
                params.setMarginEnd(margin);
            } else {
                params.setMarginStart(margin);
                params.setMarginEnd(0);
            }
            this.mIsAmPmAtLeft = isAmPmAtLeft;
        } else if (params.getRule(3) != 0 || params.getRule(2) != 0) {
            if (this.mIsAmPmAtTop == isAmPmAtStart) {
                return;
            }
            if (isAmPmAtStart) {
                otherViewId = params.getRule(3);
                params.removeRule(3);
                params.addRule(2, otherViewId);
            } else {
                otherViewId = params.getRule(2);
                params.removeRule(2);
                params.addRule(3, otherViewId);
            }
            View otherView = this.mRadialTimePickerHeader.findViewById(otherViewId);
            int top = otherView.getPaddingTop();
            int bottom = otherView.getPaddingBottom();
            int left = otherView.getPaddingLeft();
            int right = otherView.getPaddingRight();
            otherView.setPadding(left, bottom, right, top);
            this.mIsAmPmAtTop = isAmPmAtStart;
        }
        this.mAmPmLayout.setLayoutParams(params);
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setDate(int hour, int minute) {
        setHourInternal(hour, 0, true, false);
        setMinuteInternal(minute, 0, false);
        onTimeChanged();
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setHour(int hour) {
        setHourInternal(hour, 0, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHourInternal(int hour, int source, boolean announce, boolean notify) {
        if (this.mCurrentHour == hour) {
            return;
        }
        resetAutofilledValue();
        this.mCurrentHour = hour;
        updateHeaderHour(hour, announce);
        updateHeaderAmPm();
        if (source != 1) {
            this.mRadialTimePickerView.setCurrentHour(hour);
            this.mRadialTimePickerView.setAmOrPm(hour < 12 ? 0 : 1);
        }
        if (source != 2) {
            updateTextInputPicker();
        }
        this.mDelegator.invalidate();
        if (notify) {
            onTimeChanged();
        }
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public int getHour() {
        int currentHour = this.mRadialTimePickerView.getCurrentHour();
        if (this.mIs24Hour) {
            return currentHour;
        }
        if (this.mRadialTimePickerView.getAmOrPm() == 1) {
            return (currentHour % 12) + 12;
        }
        return currentHour % 12;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setMinute(int minute) {
        setMinuteInternal(minute, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinuteInternal(int minute, int source, boolean notify) {
        if (this.mCurrentMinute == minute) {
            return;
        }
        resetAutofilledValue();
        this.mCurrentMinute = minute;
        updateHeaderMinute(minute, true);
        if (source != 1) {
            this.mRadialTimePickerView.setCurrentMinute(minute);
        }
        if (source != 2) {
            updateTextInputPicker();
        }
        this.mDelegator.invalidate();
        if (notify) {
            onTimeChanged();
        }
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public int getMinute() {
        return this.mRadialTimePickerView.getCurrentMinute();
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setIs24Hour(boolean is24Hour) {
        if (this.mIs24Hour != is24Hour) {
            this.mIs24Hour = is24Hour;
            this.mCurrentHour = getHour();
            updateHourFormat();
            updateUI(this.mRadialTimePickerView.getCurrentItemShowing());
        }
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public boolean is24Hour() {
        return this.mIs24Hour;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setEnabled(boolean enabled) {
        this.mHourView.setEnabled(enabled);
        this.mMinuteView.setEnabled(enabled);
        this.mAmLabel.setEnabled(enabled);
        this.mPmLabel.setEnabled(enabled);
        this.mRadialTimePickerView.setEnabled(enabled);
        this.mIsEnabled = enabled;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public int getBaseline() {
        return -1;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public Parcelable onSaveInstanceState(Parcelable superState) {
        return new TimePicker.AbstractTimePickerDelegate.SavedState(superState, getHour(), getMinute(), is24Hour(), getCurrentItemShowing());
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof TimePicker.AbstractTimePickerDelegate.SavedState) {
            TimePicker.AbstractTimePickerDelegate.SavedState ss = (TimePicker.AbstractTimePickerDelegate.SavedState) state;
            initialize(ss.getHour(), ss.getMinute(), ss.is24HourMode(), ss.getCurrentItemShowing());
            this.mRadialTimePickerView.invalidate();
        }
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        int flags;
        if (this.mIs24Hour) {
            flags = 1 | 128;
        } else {
            flags = 1 | 64;
        }
        this.mTempCalendar.set(11, getHour());
        this.mTempCalendar.set(12, getMinute());
        String selectedTime = DateUtils.formatDateTime(this.mContext, this.mTempCalendar.getTimeInMillis(), flags);
        String selectionMode = this.mRadialTimePickerView.getCurrentItemShowing() == 0 ? this.mSelectHours : this.mSelectMinutes;
        event.getText().add(selectedTime + " " + selectionMode);
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public View getHourView() {
        return this.mHourView;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public View getMinuteView() {
        return this.mMinuteView;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public View getAmView() {
        return this.mAmLabel;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public View getPmView() {
        return this.mPmLabel;
    }

    private int getCurrentItemShowing() {
        return this.mRadialTimePickerView.getCurrentItemShowing();
    }

    private void onTimeChanged() {
        this.mDelegator.sendAccessibilityEvent(4);
        if (this.mOnTimeChangedListener != null) {
            this.mOnTimeChangedListener.onTimeChanged(this.mDelegator, getHour(), getMinute());
        }
        if (this.mAutoFillChangeListener != null) {
            this.mAutoFillChangeListener.onTimeChanged(this.mDelegator, getHour(), getMinute());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryVibrate() {
        this.mDelegator.performHapticFeedback(4);
    }

    private void updateAmPmLabelStates(int amOrPm) {
        boolean isAm = amOrPm == 0;
        this.mAmLabel.setActivated(isAm);
        this.mAmLabel.setChecked(isAm);
        boolean isPm = amOrPm == 1;
        this.mPmLabel.setActivated(isPm);
        this.mPmLabel.setChecked(isPm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLocalizedHour(int hourOfDay) {
        boolean z10 = this.mIs24Hour;
        if (!z10) {
            hourOfDay %= 12;
        }
        if (!this.mHourFormatStartsAtZero && hourOfDay == 0) {
            return z10 ? 24 : 12;
        }
        return hourOfDay;
    }

    private void updateHeaderHour(int hourOfDay, boolean announce) {
        int localizedHour = getLocalizedHour(hourOfDay);
        this.mHourView.setValue(localizedHour);
        if (announce) {
            tryAnnounceForAccessibility(this.mHourView.getText(), true);
        }
    }

    private void updateHeaderMinute(int minuteOfHour, boolean announce) {
        this.mMinuteView.setValue(minuteOfHour);
        if (announce) {
            tryAnnounceForAccessibility(this.mMinuteView.getText(), false);
        }
    }

    private void updateHeaderSeparator() {
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(this.mLocale, this.mIs24Hour ? "Hm" : "hm");
        String separatorText = getHourMinSeparatorFromPattern(bestDateTimePattern);
        this.mSeparatorView.setText(separatorText);
        this.mTextInputPickerView.updateSeparator(separatorText);
    }

    private static String getHourMinSeparatorFromPattern(String dateTimePattern) {
        boolean foundHourPattern = false;
        for (int i10 = 0; i10 < dateTimePattern.length(); i10++) {
            switch (dateTimePattern.charAt(i10)) {
                case ' ':
                    break;
                case '\'':
                    if (foundHourPattern) {
                        SpannableStringBuilder quotedSubstring = new SpannableStringBuilder(dateTimePattern.substring(i10));
                        int quotedTextLength = DateFormat.appendQuotedText(quotedSubstring, 0);
                        return quotedSubstring.subSequence(0, quotedTextLength).toString();
                    }
                    break;
                case 'H':
                case 'K':
                case 'h':
                case 'k':
                    foundHourPattern = true;
                    break;
                default:
                    if (foundHourPattern) {
                        return Character.toString(dateTimePattern.charAt(i10));
                    }
                    break;
            }
        }
        return u.bD;
    }

    private static int lastIndexOfAny(String str, char[] any) {
        int lengthAny = any.length;
        if (lengthAny > 0) {
            for (int i10 = str.length() - 1; i10 >= 0; i10--) {
                char c4 = str.charAt(i10);
                for (char c10 : any) {
                    if (c4 == c10) {
                        return i10;
                    }
                }
            }
            return -1;
        }
        return -1;
    }

    private void tryAnnounceForAccessibility(CharSequence text, boolean isHour) {
        if (this.mLastAnnouncedIsHour != isHour || !text.equals(this.mLastAnnouncedText)) {
            this.mDelegator.announceForAccessibility(text);
            this.mLastAnnouncedText = text;
            this.mLastAnnouncedIsHour = isHour;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItemShowing(int index, boolean animateCircle, boolean announce) {
        this.mRadialTimePickerView.setCurrentItemShowing(index, animateCircle);
        if (index == 0) {
            if (announce) {
                this.mDelegator.announceForAccessibility(this.mSelectHours);
            }
        } else if (announce) {
            this.mDelegator.announceForAccessibility(this.mSelectMinutes);
        }
        this.mHourView.setActivated(index == 0);
        this.mMinuteView.setActivated(index == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmOrPm(int amOrPm) {
        updateAmPmLabelStates(amOrPm);
        if (this.mRadialTimePickerView.setAmOrPm(amOrPm)) {
            this.mCurrentHour = getHour();
            updateTextInputPicker();
            if (this.mOnTimeChangedListener != null) {
                this.mOnTimeChangedListener.onTimeChanged(this.mDelegator, getHour(), getMinute());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class NearestTouchDelegate implements View.OnTouchListener {
        private View mInitialTouchTarget;

        private NearestTouchDelegate() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (view instanceof ViewGroup) {
                    this.mInitialTouchTarget = findNearestChild((ViewGroup) view, (int) motionEvent.getX(), (int) motionEvent.getY());
                } else {
                    this.mInitialTouchTarget = null;
                }
            }
            View child = this.mInitialTouchTarget;
            if (child == null) {
                return false;
            }
            float offsetX = view.getScrollX() - child.getLeft();
            float offsetY = view.getScrollY() - child.getTop();
            motionEvent.offsetLocation(offsetX, offsetY);
            boolean handled = child.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-offsetX, -offsetY);
            if (actionMasked == 1 || actionMasked == 3) {
                this.mInitialTouchTarget = null;
            }
            return handled;
        }

        private View findNearestChild(ViewGroup v2, int x10, int y10) {
            View bestChild = null;
            int bestDist = Integer.MAX_VALUE;
            int count = v2.getChildCount();
            for (int i10 = 0; i10 < count; i10++) {
                View child = v2.getChildAt(i10);
                int dX = x10 - (child.getLeft() + (child.getWidth() / 2));
                int dY = y10 - (child.getTop() + (child.getHeight() / 2));
                int dist = (dX * dX) + (dY * dY);
                if (bestDist > dist) {
                    bestChild = child;
                    bestDist = dist;
                }
            }
            return bestChild;
        }
    }
}
