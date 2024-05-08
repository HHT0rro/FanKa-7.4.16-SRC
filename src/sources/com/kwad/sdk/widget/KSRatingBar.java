package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KSRatingBar extends LinearLayout {
    private boolean aSC;
    private boolean aSD;
    private int aSE;
    private int aSF;
    private a aSG;
    private float aSH;
    private float aSI;
    private float aSJ;
    private Drawable aSK;
    private Drawable aSL;
    private Drawable aSM;
    private boolean aSN;

    /* renamed from: y, reason: collision with root package name */
    private int f36653y;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36653y = 1;
        this.aSN = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.aSM = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aSK = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aSL = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aSH = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aSI = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aSJ = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aSE = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aSF = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aSC = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aSD = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i10 = 0; i10 < this.aSE; i10++) {
            ImageView w3 = w(context, this.aSN);
            w3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.aSC) {
                        if (KSRatingBar.this.aSD) {
                            if (KSRatingBar.this.f36653y % 2 == 0) {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            } else {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                            }
                            if (KSRatingBar.this.aSG != null) {
                                if (KSRatingBar.this.f36653y % 2 == 0) {
                                    a unused = KSRatingBar.this.aSG;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                } else {
                                    a unused2 = KSRatingBar.this.aSG;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                }
                            }
                            return;
                        }
                        KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        if (KSRatingBar.this.aSG != null) {
                            a unused3 = KSRatingBar.this.aSG;
                            KSRatingBar.this.indexOfChild(view);
                        }
                    }
                }
            });
            addView(w3);
        }
        setStar(this.aSF);
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i10 = kSRatingBar.f36653y;
        kSRatingBar.f36653y = i10 + 1;
        return i10;
    }

    private ImageView w(Context context, boolean z10) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aSH), Math.round(this.aSI)));
        imageView.setPadding(0, 0, Math.round(this.aSJ), 0);
        if (z10) {
            imageView.setImageDrawable(this.aSK);
        } else {
            imageView.setImageDrawable(this.aSL);
        }
        return imageView;
    }

    public void setImagePadding(float f10) {
        this.aSJ = f10;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aSG = aVar;
    }

    public void setStar(float f10) {
        int i10 = (int) f10;
        float floatValue = new BigDecimal(Float.toString(f10)).subtract(new BigDecimal(Integer.toString(i10))).floatValue();
        int i11 = this.aSE;
        float f11 = i10 > i11 ? i11 : i10;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        for (int i12 = 0; i12 < f11; i12++) {
            ((ImageView) getChildAt(i12)).setImageDrawable(this.aSL);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i10)).setImageDrawable(this.aSM);
            int i13 = this.aSE;
            while (true) {
                i13--;
                if (i13 < 1.0f + f11) {
                    return;
                } else {
                    ((ImageView) getChildAt(i13)).setImageDrawable(this.aSK);
                }
            }
        } else {
            int i14 = this.aSE;
            while (true) {
                i14--;
                if (i14 < f11) {
                    return;
                } else {
                    ((ImageView) getChildAt(i14)).setImageDrawable(this.aSK);
                }
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aSK = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aSL = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aSM = drawable;
    }

    public void setStarImageHeight(float f10) {
        this.aSI = f10;
    }

    public void setStarImageWidth(float f10) {
        this.aSH = f10;
    }

    public void setTotalStarCount(int i10) {
        this.aSE = i10;
    }

    public void setmClickable(boolean z10) {
        this.aSC = z10;
    }
}
