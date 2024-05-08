package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    public ConstraintLayout.LayoutParams mParams;
    public View mView;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
            this.mView = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int i10) {
        switch (i10) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i10, int i11) {
        connect(1, i10, i10 == 0 ? 1 : 2, 0);
        connect(2, i11, i11 == 0 ? 2 : 1, 0);
        if (i10 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i10)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i11 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i11)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i10, int i11) {
        connect(6, i10, i10 == 0 ? 6 : 7, 0);
        connect(7, i11, i11 == 0 ? 7 : 6, 0);
        if (i10 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i10)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i11 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i11)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i10, int i11) {
        connect(3, i10, i10 == 0 ? 3 : 4, 0);
        connect(4, i11, i11 == 0 ? 4 : 3, 0);
        if (i10 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i10)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i11 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i11)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f10) {
        this.mView.setAlpha(f10);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i10, int i11, int i12, int i13, int i14, int i15, float f10) {
        if (i12 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i15 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f10 <= 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i11 == 1 || i11 == 2) {
            connect(1, i10, i11, i12);
            connect(2, i13, i14, i15);
            this.mParams.horizontalBias = f10;
        } else if (i11 != 6 && i11 != 7) {
            connect(3, i10, i11, i12);
            connect(4, i13, i14, i15);
            this.mParams.verticalBias = f10;
        } else {
            connect(6, i10, i11, i12);
            connect(7, i13, i14, i15);
            this.mParams.horizontalBias = f10;
        }
        return this;
    }

    public ConstraintProperties centerHorizontally(int i10, int i11, int i12, int i13, int i14, int i15, float f10) {
        connect(1, i10, i11, i12);
        connect(2, i13, i14, i15);
        this.mParams.horizontalBias = f10;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i10, int i11, int i12, int i13, int i14, int i15, float f10) {
        connect(6, i10, i11, i12);
        connect(7, i13, i14, i15);
        this.mParams.horizontalBias = f10;
        return this;
    }

    public ConstraintProperties centerVertically(int i10, int i11, int i12, int i13, int i14, int i15, float f10) {
        connect(3, i10, i11, i12);
        connect(4, i13, i14, i15);
        this.mParams.verticalBias = f10;
        return this;
    }

    public ConstraintProperties connect(int i10, int i11, int i12, int i13) {
        switch (i10) {
            case 1:
                if (i12 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToLeft = i11;
                    layoutParams.leftToRight = -1;
                } else if (i12 == 2) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.leftToRight = i11;
                    layoutParams2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(i12) + " undefined");
                }
                this.mParams.leftMargin = i13;
                return this;
            case 2:
                if (i12 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.rightToLeft = i11;
                    layoutParams3.rightToRight = -1;
                } else if (i12 == 2) {
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.rightToRight = i11;
                    layoutParams4.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i12) + " undefined");
                }
                this.mParams.rightMargin = i13;
                return this;
            case 3:
                if (i12 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.topToTop = i11;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                } else if (i12 == 4) {
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.topToBottom = i11;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i12) + " undefined");
                }
                this.mParams.topMargin = i13;
                return this;
            case 4:
                if (i12 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    layoutParams7.bottomToBottom = i11;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                } else if (i12 == 3) {
                    ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams8.bottomToTop = i11;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i12) + " undefined");
                }
                this.mParams.bottomMargin = i13;
                return this;
            case 5:
                if (i12 == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                    layoutParams9.baselineToBaseline = i11;
                    layoutParams9.bottomToBottom = -1;
                    layoutParams9.bottomToTop = -1;
                    layoutParams9.topToTop = -1;
                    layoutParams9.topToBottom = -1;
                    return this;
                }
                throw new IllegalArgumentException("right to " + sideToString(i12) + " undefined");
            case 6:
                if (i12 == 6) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams10.startToStart = i11;
                    layoutParams10.startToEnd = -1;
                } else if (i12 == 7) {
                    ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    layoutParams11.startToEnd = i11;
                    layoutParams11.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i12) + " undefined");
                }
                this.mParams.setMarginStart(i13);
                return this;
            case 7:
                if (i12 == 7) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams12.endToEnd = i11;
                    layoutParams12.endToStart = -1;
                } else if (i12 == 6) {
                    ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    layoutParams13.endToStart = i11;
                    layoutParams13.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i12) + " undefined");
                }
                this.mParams.setMarginEnd(i13);
                return this;
            default:
                throw new IllegalArgumentException(sideToString(i10) + " to " + sideToString(i12) + " unknown");
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i10) {
        this.mParams.matchConstraintDefaultHeight = i10;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i10) {
        this.mParams.matchConstraintDefaultWidth = i10;
        return this;
    }

    public ConstraintProperties constrainHeight(int i10) {
        this.mParams.height = i10;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i10) {
        this.mParams.matchConstraintMaxHeight = i10;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i10) {
        this.mParams.matchConstraintMaxWidth = i10;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i10) {
        this.mParams.matchConstraintMinHeight = i10;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i10) {
        this.mParams.matchConstraintMinWidth = i10;
        return this;
    }

    public ConstraintProperties constrainWidth(int i10) {
        this.mParams.width = i10;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f10) {
        this.mView.setElevation(f10);
        return this;
    }

    public ConstraintProperties goneMargin(int i10, int i11) {
        switch (i10) {
            case 1:
                this.mParams.goneLeftMargin = i11;
                return this;
            case 2:
                this.mParams.goneRightMargin = i11;
                return this;
            case 3:
                this.mParams.goneTopMargin = i11;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i11;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i11;
                return this;
            case 7:
                this.mParams.goneEndMargin = i11;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f10) {
        this.mParams.horizontalBias = f10;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i10) {
        this.mParams.horizontalChainStyle = i10;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f10) {
        this.mParams.horizontalWeight = f10;
        return this;
    }

    public ConstraintProperties margin(int i10, int i11) {
        switch (i10) {
            case 1:
                this.mParams.leftMargin = i11;
                return this;
            case 2:
                this.mParams.rightMargin = i11;
                return this;
            case 3:
                this.mParams.topMargin = i11;
                return this;
            case 4:
                this.mParams.bottomMargin = i11;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i11);
                return this;
            case 7:
                this.mParams.setMarginEnd(i11);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i10) {
        switch (i10) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.mParams;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                layoutParams.leftMargin = -1;
                layoutParams.goneLeftMargin = -1;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                layoutParams2.rightMargin = -1;
                layoutParams2.goneRightMargin = -1;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                layoutParams3.topMargin = -1;
                layoutParams3.goneTopMargin = -1;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                layoutParams4.bottomMargin = -1;
                layoutParams4.goneBottomMargin = -1;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = -1;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = -1;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i10 = layoutParams.leftToRight;
        int i11 = layoutParams.rightToLeft;
        if (i10 == -1 && i11 == -1) {
            int i12 = layoutParams.startToEnd;
            int i13 = layoutParams.endToStart;
            if (i12 != -1 || i13 != -1) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i12));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i13));
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                if (i12 != -1 && i13 != -1) {
                    constraintProperties.connect(7, i13, 6, 0);
                    constraintProperties2.connect(6, i10, 7, 0);
                } else if (i10 != -1 || i13 != -1) {
                    int i14 = layoutParams2.rightToRight;
                    if (i14 != -1) {
                        constraintProperties.connect(7, i14, 7, 0);
                    } else {
                        int i15 = layoutParams2.leftToLeft;
                        if (i15 != -1) {
                            constraintProperties2.connect(6, i15, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
        } else {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i10));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i11));
            ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
            if (i10 != -1 && i11 != -1) {
                constraintProperties3.connect(2, i11, 1, 0);
                constraintProperties4.connect(1, i10, 2, 0);
            } else if (i10 != -1 || i11 != -1) {
                int i16 = layoutParams3.rightToRight;
                if (i16 != -1) {
                    constraintProperties3.connect(2, i16, 2, 0);
                } else {
                    int i17 = layoutParams3.leftToLeft;
                    if (i17 != -1) {
                        constraintProperties4.connect(1, i17, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
        }
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i10 = layoutParams.topToBottom;
        int i11 = layoutParams.bottomToTop;
        if (i10 != -1 || i11 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i10));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i11));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i10 != -1 && i11 != -1) {
                constraintProperties.connect(4, i11, 3, 0);
                constraintProperties2.connect(3, i10, 4, 0);
            } else if (i10 != -1 || i11 != -1) {
                int i12 = layoutParams2.bottomToBottom;
                if (i12 != -1) {
                    constraintProperties.connect(4, i12, 4, 0);
                } else {
                    int i13 = layoutParams2.topToTop;
                    if (i13 != -1) {
                        constraintProperties2.connect(3, i13, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f10) {
        this.mView.setRotation(f10);
        return this;
    }

    public ConstraintProperties rotationX(float f10) {
        this.mView.setRotationX(f10);
        return this;
    }

    public ConstraintProperties rotationY(float f10) {
        this.mView.setRotationY(f10);
        return this;
    }

    public ConstraintProperties scaleX(float f10) {
        this.mView.setScaleY(f10);
        return this;
    }

    public ConstraintProperties scaleY(float f10) {
        return this;
    }

    public ConstraintProperties transformPivot(float f10, float f11) {
        this.mView.setPivotX(f10);
        this.mView.setPivotY(f11);
        return this;
    }

    public ConstraintProperties transformPivotX(float f10) {
        this.mView.setPivotX(f10);
        return this;
    }

    public ConstraintProperties transformPivotY(float f10) {
        this.mView.setPivotY(f10);
        return this;
    }

    public ConstraintProperties translation(float f10, float f11) {
        this.mView.setTranslationX(f10);
        this.mView.setTranslationY(f11);
        return this;
    }

    public ConstraintProperties translationX(float f10) {
        this.mView.setTranslationX(f10);
        return this;
    }

    public ConstraintProperties translationY(float f10) {
        this.mView.setTranslationY(f10);
        return this;
    }

    public ConstraintProperties translationZ(float f10) {
        this.mView.setTranslationZ(f10);
        return this;
    }

    public ConstraintProperties verticalBias(float f10) {
        this.mParams.verticalBias = f10;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i10) {
        this.mParams.verticalChainStyle = i10;
        return this;
    }

    public ConstraintProperties verticalWeight(float f10) {
        this.mParams.verticalWeight = f10;
        return this;
    }

    public ConstraintProperties visibility(int i10) {
        this.mView.setVisibility(i10);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i10) {
        if (i10 == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i10, 2, 0, i10, 1, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i10) {
        if (i10 == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i10, 7, 0, i10, 6, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int i10) {
        if (i10 == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i10, 4, 0, i10, 3, 0, 0.5f);
        }
        return this;
    }
}
