package android.view.inputmethod;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.icu.text.DisplayContext;
import android.icu.text.LocaleDisplayNames;
import android.icu.util.ULocale;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.inputmethod.SubtypeLocaleUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InputMethodSubtype implements Parcelable {
    private static final String EXTRA_KEY_UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME = "UntranslatableReplacementStringInSubtypeName";
    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    private static final String LANGUAGE_TAG_NONE = "";
    public static final int SUBTYPE_ID_NONE = 0;
    private static final String SUBTYPE_MODE_KEYBOARD = "keyboard";
    private static final String UNDEFINED_LANGUAGE_TAG = "und";
    private volatile String mCachedCanonicalizedLanguageTag;
    private volatile Locale mCachedLocaleObj;
    private volatile HashMap<String, String> mExtraValueHashMapCache;
    private final boolean mIsAsciiCapable;
    private final boolean mIsAuxiliary;
    private final Object mLock;
    private final boolean mOverridesImplicitlyEnabledSubtype;
    private final String mPkLanguageTag;
    private final String mPkLayoutType;
    private final String mSubtypeExtraValue;
    private final int mSubtypeHashCode;
    private final int mSubtypeIconResId;
    private final int mSubtypeId;
    private final String mSubtypeLanguageTag;
    private final String mSubtypeLocale;
    private final String mSubtypeMode;
    private final CharSequence mSubtypeNameOverride;
    private final int mSubtypeNameResId;
    private static final String TAG = InputMethodSubtype.class.getSimpleName();
    public static final Parcelable.Creator<InputMethodSubtype> CREATOR = new Parcelable.Creator<InputMethodSubtype>() { // from class: android.view.inputmethod.InputMethodSubtype.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodSubtype createFromParcel(Parcel source) {
            return new InputMethodSubtype(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodSubtype[] newArray(int size) {
            return new InputMethodSubtype[size];
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class InputMethodSubtypeBuilder {
        private boolean mIsAuxiliary = false;
        private boolean mOverridesImplicitlyEnabledSubtype = false;
        private boolean mIsAsciiCapable = false;
        private int mSubtypeIconResId = 0;
        private int mSubtypeNameResId = 0;
        private CharSequence mSubtypeNameOverride = "";
        private String mPkLanguageTag = "";
        private String mPkLayoutType = "";
        private int mSubtypeId = 0;
        private String mSubtypeLocale = "";
        private String mSubtypeLanguageTag = "";
        private String mSubtypeMode = "";
        private String mSubtypeExtraValue = "";

        public InputMethodSubtypeBuilder setIsAuxiliary(boolean isAuxiliary) {
            this.mIsAuxiliary = isAuxiliary;
            return this;
        }

        public InputMethodSubtypeBuilder setOverridesImplicitlyEnabledSubtype(boolean overridesImplicitlyEnabledSubtype) {
            this.mOverridesImplicitlyEnabledSubtype = overridesImplicitlyEnabledSubtype;
            return this;
        }

        public InputMethodSubtypeBuilder setIsAsciiCapable(boolean isAsciiCapable) {
            this.mIsAsciiCapable = isAsciiCapable;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeIconResId(int subtypeIconResId) {
            this.mSubtypeIconResId = subtypeIconResId;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeNameResId(int subtypeNameResId) {
            this.mSubtypeNameResId = subtypeNameResId;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeNameOverride(CharSequence nameOverride) {
            this.mSubtypeNameOverride = nameOverride;
            return this;
        }

        public InputMethodSubtypeBuilder setPhysicalKeyboardHint(ULocale languageTag, String layoutType) {
            Objects.requireNonNull(layoutType, "layoutType cannot be null");
            this.mPkLanguageTag = languageTag == null ? "" : languageTag.toLanguageTag();
            this.mPkLayoutType = layoutType;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeId(int subtypeId) {
            this.mSubtypeId = subtypeId;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeLocale(String subtypeLocale) {
            this.mSubtypeLocale = subtypeLocale == null ? "" : subtypeLocale;
            return this;
        }

        public InputMethodSubtypeBuilder setLanguageTag(String languageTag) {
            this.mSubtypeLanguageTag = languageTag == null ? "" : languageTag;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeMode(String subtypeMode) {
            this.mSubtypeMode = subtypeMode == null ? "" : subtypeMode;
            return this;
        }

        public InputMethodSubtypeBuilder setSubtypeExtraValue(String subtypeExtraValue) {
            this.mSubtypeExtraValue = subtypeExtraValue == null ? "" : subtypeExtraValue;
            return this;
        }

        public InputMethodSubtype build() {
            return new InputMethodSubtype(this);
        }
    }

    private static InputMethodSubtypeBuilder getBuilder(int nameId, int iconId, String locale, String mode, String extraValue, boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype, int id2, boolean isAsciiCapable) {
        InputMethodSubtypeBuilder builder = new InputMethodSubtypeBuilder();
        builder.mSubtypeNameResId = nameId;
        builder.mSubtypeIconResId = iconId;
        builder.mSubtypeLocale = locale;
        builder.mSubtypeMode = mode;
        builder.mSubtypeExtraValue = extraValue;
        builder.mIsAuxiliary = isAuxiliary;
        builder.mOverridesImplicitlyEnabledSubtype = overridesImplicitlyEnabledSubtype;
        builder.mSubtypeId = id2;
        builder.mIsAsciiCapable = isAsciiCapable;
        return builder;
    }

    @Deprecated
    public InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue, boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) {
        this(nameId, iconId, locale, mode, extraValue, isAuxiliary, overridesImplicitlyEnabledSubtype, 0);
    }

    @Deprecated
    public InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue, boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype, int id2) {
        this(getBuilder(nameId, iconId, locale, mode, extraValue, isAuxiliary, overridesImplicitlyEnabledSubtype, id2, false));
    }

    private InputMethodSubtype(InputMethodSubtypeBuilder builder) {
        this.mLock = new Object();
        this.mSubtypeNameResId = builder.mSubtypeNameResId;
        this.mSubtypeNameOverride = builder.mSubtypeNameOverride;
        this.mPkLanguageTag = builder.mPkLanguageTag;
        this.mPkLayoutType = builder.mPkLayoutType;
        this.mSubtypeIconResId = builder.mSubtypeIconResId;
        String str = builder.mSubtypeLocale;
        this.mSubtypeLocale = str;
        this.mSubtypeLanguageTag = builder.mSubtypeLanguageTag;
        String str2 = builder.mSubtypeMode;
        this.mSubtypeMode = str2;
        String str3 = builder.mSubtypeExtraValue;
        this.mSubtypeExtraValue = str3;
        boolean z10 = builder.mIsAuxiliary;
        this.mIsAuxiliary = z10;
        boolean z11 = builder.mOverridesImplicitlyEnabledSubtype;
        this.mOverridesImplicitlyEnabledSubtype = z11;
        int i10 = builder.mSubtypeId;
        this.mSubtypeId = i10;
        boolean z12 = builder.mIsAsciiCapable;
        this.mIsAsciiCapable = z12;
        if (i10 != 0) {
            this.mSubtypeHashCode = i10;
        } else {
            this.mSubtypeHashCode = hashCodeInternal(str, str2, str3, z10, z11, z12);
        }
    }

    InputMethodSubtype(Parcel source) {
        this.mLock = new Object();
        this.mSubtypeNameResId = source.readInt();
        CharSequence cs = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        this.mSubtypeNameOverride = cs != null ? cs : "";
        String s2 = source.readString8();
        this.mPkLanguageTag = s2 != null ? s2 : "";
        String s10 = source.readString8();
        this.mPkLayoutType = s10 != null ? s10 : "";
        this.mSubtypeIconResId = source.readInt();
        String s11 = source.readString();
        this.mSubtypeLocale = s11 != null ? s11 : "";
        String s12 = source.readString();
        this.mSubtypeLanguageTag = s12 != null ? s12 : "";
        String s13 = source.readString();
        this.mSubtypeMode = s13 != null ? s13 : "";
        String s14 = source.readString();
        this.mSubtypeExtraValue = s14 != null ? s14 : "";
        this.mIsAuxiliary = source.readInt() == 1;
        this.mOverridesImplicitlyEnabledSubtype = source.readInt() == 1;
        this.mSubtypeHashCode = source.readInt();
        this.mSubtypeId = source.readInt();
        this.mIsAsciiCapable = source.readInt() == 1;
    }

    public int getNameResId() {
        return this.mSubtypeNameResId;
    }

    public CharSequence getNameOverride() {
        return this.mSubtypeNameOverride;
    }

    public ULocale getPhysicalKeyboardHintLanguageTag() {
        if (TextUtils.isEmpty(this.mPkLanguageTag)) {
            return null;
        }
        return ULocale.forLanguageTag(this.mPkLanguageTag);
    }

    public String getPhysicalKeyboardHintLayoutType() {
        return this.mPkLayoutType;
    }

    public int getIconResId() {
        return this.mSubtypeIconResId;
    }

    @Deprecated
    public String getLocale() {
        return this.mSubtypeLocale;
    }

    public String getLanguageTag() {
        return this.mSubtypeLanguageTag;
    }

    public Locale getLocaleObject() {
        if (this.mCachedLocaleObj != null) {
            return this.mCachedLocaleObj;
        }
        synchronized (this.mLock) {
            if (this.mCachedLocaleObj != null) {
                return this.mCachedLocaleObj;
            }
            if (!TextUtils.isEmpty(this.mSubtypeLanguageTag)) {
                this.mCachedLocaleObj = Locale.forLanguageTag(this.mSubtypeLanguageTag);
            } else {
                this.mCachedLocaleObj = SubtypeLocaleUtils.constructLocaleFromString(this.mSubtypeLocale);
            }
            return this.mCachedLocaleObj;
        }
    }

    public String getCanonicalizedLanguageTag() {
        String cachedValue = this.mCachedCanonicalizedLanguageTag;
        if (cachedValue != null) {
            return cachedValue;
        }
        String result = null;
        Locale locale = getLocaleObject();
        if (locale != null) {
            String langTag = locale.toLanguageTag();
            if (!TextUtils.isEmpty(langTag)) {
                result = ULocale.createCanonical(ULocale.forLanguageTag(langTag)).toLanguageTag();
            }
        }
        String result2 = TextUtils.emptyIfNull(result);
        this.mCachedCanonicalizedLanguageTag = result2;
        return result2;
    }

    public boolean isSuitableForPhysicalKeyboardLayoutMapping() {
        if (hashCode() != 0 && TextUtils.equals(getMode(), SUBTYPE_MODE_KEYBOARD)) {
            return !isAuxiliary();
        }
        return false;
    }

    public String getMode() {
        return this.mSubtypeMode;
    }

    public String getExtraValue() {
        return this.mSubtypeExtraValue;
    }

    public boolean isAuxiliary() {
        return this.mIsAuxiliary;
    }

    public boolean overridesImplicitlyEnabledSubtype() {
        return this.mOverridesImplicitlyEnabledSubtype;
    }

    public boolean isAsciiCapable() {
        return this.mIsAsciiCapable;
    }

    public CharSequence getDisplayName(Context context, String packageName, ApplicationInfo appInfo) {
        DisplayContext displayContext;
        String replacementString;
        if (this.mSubtypeNameResId == 0) {
            if (TextUtils.isEmpty(this.mSubtypeNameOverride)) {
                return getLocaleDisplayName(getLocaleFromContext(context), getLocaleObject(), DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU);
            }
            return this.mSubtypeNameOverride;
        }
        CharSequence subtypeName = context.getPackageManager().getText(packageName, this.mSubtypeNameResId, appInfo);
        if (TextUtils.isEmpty(subtypeName)) {
            return "";
        }
        String subtypeNameString = subtypeName.toString();
        if (containsExtraValueKey(EXTRA_KEY_UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME)) {
            replacementString = getExtraValueOf(EXTRA_KEY_UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME);
        } else {
            if (TextUtils.equals(subtypeNameString, "%s")) {
                displayContext = DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU;
            } else if (subtypeNameString.startsWith("%s")) {
                displayContext = DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE;
            } else {
                displayContext = DisplayContext.CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE;
            }
            replacementString = getLocaleDisplayName(getLocaleFromContext(context), getLocaleObject(), displayContext);
        }
        if (replacementString == null) {
            replacementString = "";
        }
        try {
            return String.format(subtypeNameString, replacementString);
        } catch (IllegalFormatException e2) {
            Slog.w(TAG, "Found illegal format in subtype name(" + ((Object) subtypeName) + "): " + ((Object) e2));
            return "";
        }
    }

    private static Locale getLocaleFromContext(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return null;
        }
        return configuration.getLocales().get(0);
    }

    private static String getLocaleDisplayName(Locale displayLocale, Locale localeToDisplay, DisplayContext displayContext) {
        if (localeToDisplay == null) {
            return "";
        }
        Locale nonNullDisplayLocale = displayLocale != null ? displayLocale : Locale.getDefault();
        return LocaleDisplayNames.getInstance(nonNullDisplayLocale, displayContext).localeDisplayName(localeToDisplay);
    }

    private HashMap<String, String> getExtraValueHashMap() {
        synchronized (this) {
            HashMap<String, String> extraValueMap = this.mExtraValueHashMapCache;
            if (extraValueMap != null) {
                return extraValueMap;
            }
            HashMap<String, String> extraValueMap2 = new HashMap<>();
            String[] pairs = this.mSubtypeExtraValue.split(",");
            for (String str : pairs) {
                String[] pair = str.split("=");
                if (pair.length == 1) {
                    extraValueMap2.put(pair[0], null);
                } else if (pair.length > 1) {
                    if (pair.length > 2) {
                        Slog.w(TAG, "ExtraValue has two or more '='s");
                    }
                    extraValueMap2.put(pair[0], pair[1]);
                }
            }
            this.mExtraValueHashMapCache = extraValueMap2;
            return extraValueMap2;
        }
    }

    public boolean containsExtraValueKey(String key) {
        return getExtraValueHashMap().containsKey(key);
    }

    public String getExtraValueOf(String key) {
        return getExtraValueHashMap().get(key);
    }

    public int hashCode() {
        return this.mSubtypeHashCode;
    }

    public final boolean hasSubtypeId() {
        return this.mSubtypeId != 0;
    }

    public final int getSubtypeId() {
        return this.mSubtypeId;
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof InputMethodSubtype)) {
            return false;
        }
        InputMethodSubtype subtype = (InputMethodSubtype) o10;
        return (subtype.mSubtypeId == 0 && this.mSubtypeId == 0) ? subtype.hashCode() == hashCode() && subtype.getLocale().equals(getLocale()) && subtype.getLanguageTag().equals(getLanguageTag()) && subtype.getMode().equals(getMode()) && subtype.getExtraValue().equals(getExtraValue()) && subtype.isAuxiliary() == isAuxiliary() && subtype.overridesImplicitlyEnabledSubtype() == overridesImplicitlyEnabledSubtype() && subtype.isAsciiCapable() == isAsciiCapable() : subtype.hashCode() == hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mSubtypeNameResId);
        TextUtils.writeToParcel(this.mSubtypeNameOverride, parcel, i10);
        parcel.writeString8(this.mPkLanguageTag);
        parcel.writeString8(this.mPkLayoutType);
        parcel.writeInt(this.mSubtypeIconResId);
        parcel.writeString(this.mSubtypeLocale);
        parcel.writeString(this.mSubtypeLanguageTag);
        parcel.writeString(this.mSubtypeMode);
        parcel.writeString(this.mSubtypeExtraValue);
        parcel.writeInt(this.mIsAuxiliary ? 1 : 0);
        parcel.writeInt(this.mOverridesImplicitlyEnabledSubtype ? 1 : 0);
        parcel.writeInt(this.mSubtypeHashCode);
        parcel.writeInt(this.mSubtypeId);
        parcel.writeInt(this.mIsAsciiCapable ? 1 : 0);
    }

    private static int hashCodeInternal(String locale, String mode, String extraValue, boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype, boolean isAsciiCapable) {
        boolean needsToCalculateCompatibleHashCode = !isAsciiCapable;
        if (needsToCalculateCompatibleHashCode) {
            return Arrays.hashCode(new Object[]{locale, mode, extraValue, Boolean.valueOf(isAuxiliary), Boolean.valueOf(overridesImplicitlyEnabledSubtype)});
        }
        return Arrays.hashCode(new Object[]{locale, mode, extraValue, Boolean.valueOf(isAuxiliary), Boolean.valueOf(overridesImplicitlyEnabledSubtype), Boolean.valueOf(isAsciiCapable)});
    }

    public static List<InputMethodSubtype> sort(InputMethodInfo imi, List<InputMethodSubtype> subtypeList) {
        if (imi == null) {
            return subtypeList;
        }
        HashSet<InputMethodSubtype> inputSubtypesSet = new HashSet<>(subtypeList);
        ArrayList<InputMethodSubtype> sortedList = new ArrayList<>();
        int N = imi.getSubtypeCount();
        for (int i10 = 0; i10 < N; i10++) {
            InputMethodSubtype subtype = imi.getSubtypeAt(i10);
            if (inputSubtypesSet.contains(subtype)) {
                sortedList.add(subtype);
                inputSubtypesSet.remove(subtype);
            }
        }
        Iterator<InputMethodSubtype> iterator2 = inputSubtypesSet.iterator2();
        while (iterator2.hasNext()) {
            sortedList.add(iterator2.next());
        }
        return sortedList;
    }
}
