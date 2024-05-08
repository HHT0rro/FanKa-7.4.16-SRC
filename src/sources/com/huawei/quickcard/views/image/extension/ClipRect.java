package com.huawei.quickcard.views.image.extension;

import com.huawei.quickcard.framework.unit.LengthValue;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ClipRect {

    /* renamed from: a, reason: collision with root package name */
    private LengthValue f34522a;

    /* renamed from: b, reason: collision with root package name */
    private LengthValue f34523b;

    /* renamed from: c, reason: collision with root package name */
    private LengthValue f34524c;

    /* renamed from: d, reason: collision with root package name */
    private LengthValue f34525d;

    public ClipRect() {
    }

    private void a(LengthValue lengthValue) {
        this.f34525d = lengthValue;
    }

    private void b(LengthValue lengthValue) {
        this.f34522a = lengthValue;
    }

    private void c(LengthValue lengthValue) {
        this.f34523b = lengthValue;
    }

    private void d(LengthValue lengthValue) {
        this.f34524c = lengthValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClipRect clipRect = (ClipRect) obj;
        return Objects.equals(this.f34522a, clipRect.f34522a) && Objects.equals(this.f34523b, clipRect.f34523b) && Objects.equals(this.f34524c, clipRect.f34524c) && Objects.equals(this.f34525d, clipRect.f34525d);
    }

    public LengthValue getBottom() {
        return this.f34525d;
    }

    public LengthValue getLeft() {
        return this.f34522a;
    }

    public LengthValue getRight() {
        return this.f34523b;
    }

    public LengthValue getTop() {
        return this.f34524c;
    }

    public int hashCode() {
        return Objects.hash(this.f34522a, this.f34523b, this.f34524c, this.f34525d);
    }

    public boolean isEmpty() {
        return this.f34522a == null && this.f34523b == null && this.f34524c == null && this.f34525d == null;
    }

    public ClipRect(LengthValue lengthValue, LengthValue lengthValue2, LengthValue lengthValue3, LengthValue lengthValue4) {
        b(lengthValue);
        d(lengthValue2);
        c(lengthValue3);
        a(lengthValue4);
    }
}
