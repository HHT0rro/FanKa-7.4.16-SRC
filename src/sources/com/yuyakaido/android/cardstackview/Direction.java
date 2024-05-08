package com.yuyakaido.android.cardstackview;

import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum Direction {
    Left,
    Right,
    Top,
    Bottom;

    public static final List<Direction> FREEDOM;
    public static final List<Direction> HORIZONTAL;
    public static final List<Direction> VERTICAL;

    static {
        Direction direction = Left;
        Direction direction2 = Right;
        Direction direction3 = Top;
        Direction direction4 = Bottom;
        HORIZONTAL = Arrays.asList(direction, direction2);
        VERTICAL = Arrays.asList(direction3, direction4);
        FREEDOM = Arrays.asList(values());
    }
}
