package com.cupidapp.live.liveshow.beauty.model;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.huawei.quickcard.base.Attributes;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveBeautyButtonEnum.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FKLiveBeautyButtonEnum {
    Filter { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Filter
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_filter;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_filter;
        }
    },
    Sticker { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Sticker
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_sticker;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_effect;
        }
    },
    BlurBg { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.BlurBg
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.0f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Blur_intensity";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "background_blur";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_blur_bg;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_blur_bg;
        }
    },
    Whitening { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Whitening
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.35f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "whiten";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "beauty_Android_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_whitening;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_whitening;
        }
    },
    GrindingSkin { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.GrindingSkin
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return Attributes.Style.SMOOTH;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "beauty_Android_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_grinding_skin;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_grinding_skin;
        }
    },
    Sharp { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Sharp
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 1.0f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "sharp";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "beauty_Android_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_sharp;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_sharp;
        }
    },
    ThinFace { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.ThinFace
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.35f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_Overall";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_thin_face;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_thin_face;
        }
    },
    NarrowFace { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.NarrowFace
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_CutFace";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_narrow_face;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_narrow_face;
        }
    },
    SmallFace { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.SmallFace
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_Face";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_small_face;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_small_face;
        }
    },
    Eye { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Eye
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.35f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_Eye";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_eye;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_eye;
        }
    },
    ThinCheek { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.ThinCheek
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.2f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_Zoom_Cheekbone";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_thin_cheek;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_thin_cheek;
        }
    },
    ThinNose { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.ThinNose
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_Nose";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_thin_nose;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_thin_nose;
        }
    },
    Chin { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Chin
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_Chin";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_chin;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_chin;
        }
    },
    Forehead { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Forehead
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Internal_Deform_Forehead";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "reshape_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_forehead;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_forehead;
        }
    },
    RemovePouch { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.RemovePouch
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "BEF_BEAUTY_REMOVE_POUCH";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "beauty_4Items";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_remove_pouch;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_remove_pouch;
        }
    },
    SmileFolds { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.SmileFolds
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.35f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "BEF_BEAUTY_SMILES_FOLDS";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "beauty_4Items";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_smile_folds;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_smile_folds;
        }
    },
    Clarity { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Clarity
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "clear";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "beauty_Android_lite";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_clarity;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_clarity;
        }
    },
    Contrast { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Contrast
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Intensity_Contrast";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "palette/contrast";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_contrast;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_contrast;
        }
    },
    Saturation { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Saturation
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Intensity_Saturation";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "palette/color";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_saturation;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_saturation;
        }
    },
    Brightness { // from class: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum.Brightness
        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public float defaultValue() {
            return 0.5f;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String getEffectId() {
            return "Intensity_Light";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        @NotNull
        public String nodeName() {
            return "palette/light";
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeIcon() {
            return R$mipmap.live_beauty_brightness;
        }

        @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum
        public int typeName() {
            return R$string.live_beauty_brightness;
        }
    };


    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: FKLiveBeautyButtonEnum.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* compiled from: FKLiveBeautyButtonEnum.kt */
        @d
        /* renamed from: com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public /* synthetic */ class C0156a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14878a;

            static {
                int[] iArr = new int[FKLiveBeautyButtonEnum.values().length];
                try {
                    iArr[FKLiveBeautyButtonEnum.ThinNose.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FKLiveBeautyButtonEnum.Chin.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FKLiveBeautyButtonEnum.Forehead.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f14878a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@NotNull String effectId) {
            s.i(effectId, "effectId");
            if (s.d(effectId, FKLiveBeautyButtonEnum.BlurBg.getEffectId())) {
                return "background_blur";
            }
            if (s.d(effectId, FKLiveBeautyButtonEnum.Whitening.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.Sharp.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.GrindingSkin.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.Clarity.getEffectId())) {
                return "beauty_Android_lite";
            }
            if (s.d(effectId, FKLiveBeautyButtonEnum.ThinFace.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.NarrowFace.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.SmallFace.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.Eye.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.ThinCheek.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.ThinNose.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.Chin.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.Forehead.getEffectId())) {
                return "reshape_lite";
            }
            return s.d(effectId, FKLiveBeautyButtonEnum.RemovePouch.getEffectId()) ? true : s.d(effectId, FKLiveBeautyButtonEnum.SmileFolds.getEffectId()) ? "beauty_4Items" : s.d(effectId, FKLiveBeautyButtonEnum.Contrast.getEffectId()) ? "palette/contrast" : s.d(effectId, FKLiveBeautyButtonEnum.Saturation.getEffectId()) ? "palette/color" : s.d(effectId, FKLiveBeautyButtonEnum.Brightness.getEffectId()) ? "palette/light" : "";
        }

        public final boolean b(@NotNull FKLiveBeautyButtonEnum buttonType) {
            s.i(buttonType, "buttonType");
            int i10 = C0156a.f14878a[buttonType.ordinal()];
            return i10 == 1 || i10 == 2 || i10 == 3;
        }
    }

    /* synthetic */ FKLiveBeautyButtonEnum(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public float defaultValue() {
        return 0.0f;
    }

    @NotNull
    public String getEffectId() {
        return "";
    }

    @NotNull
    public String nodeName() {
        return "";
    }

    public abstract int typeIcon();

    public abstract int typeName();
}
