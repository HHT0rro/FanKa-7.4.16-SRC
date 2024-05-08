package com.irisdt.client.increment;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class IncrementProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015IncrementProtos.proto\u0012\u001bcom.irisdt.client.increment\"¬\u0007\n\u000eIncrementProto\u00121\n\u0005event\u0018\u0001 \u0001(\u000e2\".com.irisdt.client.increment.Event\u0012\u000f\n\u0007content\u0018\u0002 \u0001(\t\u0012\f\n\u0004from\u0018\u0003 \u0001(\t\u0012\r\n\u0005level\u0018\u0004 \u0001(\t\u0012\f\n\u0004type\u0018\u0005 \u0001(\t\u0012\u000f\n\u0007is_true\u0018\u0006 \u0001(\b\u00129\n\tenum_type\u0018\u0007 \u0001(\u000e2&.com.irisdt.client.increment.Enum_type\u00127\n\bsub_type\u0018\b \u0001(\u000e2%.com.irisdt.client.increment.Sub_type\u00127\n\bbuy_type\u0018\t \u0001(\u000e2%.com.irisdt.client.increment.Buy_type\u0012\f\n\u0004name\u0018\n \u0001(\t\u0012\u0011\n\tlongitude\u0018\u000b \u0001(\u0001\u0012\u0010\n\blatitude\u0018\f \u0001(\u0001\u0012\n\n\u0002id\u0018\r \u0001(\t\u0012\u0010\n\bposition\u0018\u000e \u0001(\t\u0012\u0010\n\blocation\u0018\u000f \u0001(\t\u0012\f\n\u0004role\u0018\u0010 \u0001(\t\u0012\u0015\n\rconstellation\u0018\u0011 \u0001(\t\u0012\u000b\n\u0003age\u0018\u0012 \u0001(\t\u0012\u000e\n\u0006height\u0018\u0013 \u0001(\t\u0012\u000e\n\u0006weight\u0018\u0014 \u0001(\t\u0012\f\n\u0004time\u0018\u0015 \u0001(\u0005\u0012\u000e\n\u0006method\u0018\u0016 \u0001(\t\u0012\u0016\n\u000etransaction_id\u0018\u0017 \u0001(\t\u0012\u000b\n\u0003sku\u0018\u0018 \u0001(\t\u0012\r\n\u0005scene\u0018\u0019 \u0001(\t\u0012\u0011\n\tcoupon_id\u0018\u001a \u0001(\t\u0012\u0011\n\tuser_type\u0018\u001b \u0001(\u0005\u0012\f\n\u0004info\u0018\u001c \u0001(\t\u0012\u0013\n\u000bactive_time\u0018\u001d \u0001(\t\u0012\u000b\n\u0003num\u0018\u001e \u0001(\u0005\u0012;\n\u000bdefault_tag\u0018\u001f \u0001(\u000e2&.com.irisdt.client.increment.Enum_type\u00129\n\tshow_type\u0018  \u0001(\u000e2&.com.irisdt.client.increment.Enum_type\u0012\r\n\u0005price\u0018! \u0001(\t\u0012\u0015\n\ris_bought_vip\u0018\" \u0001(\b\u0012\f\n\u0004mbti\u0018# \u0001(\t\u0012\u0011\n\tis_single\u0018$ \u0001(\b\u0012\u000e\n\u0006is_new\u0018% \u0001(\b\u0012\u0012\n\nis_popular\u0018& \u0001(\b\u0012\u001a\n\u0012is_high_match_rate\u0018' \u0001(\b\u0012\u0011\n\tis_travel\u0018( \u0001(\b*£\n\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010\u0000\u0012\u001a\n\u0016BUY_VIP_ENTRANCE_CLICK\u0010\u0001\u0012\u0016\n\u0012BUY_VIP_POPUP_SHOW\u0010\u0002\u0012\u0019\n\u0015BUY_VIP_BUY_BTN_CLICK\u0010\u0003\u0012\u0013\n\u000fBUY_VIP_SUCCESS\u0010\u0004\u0012\"\n\u001eBUY_VIP_BUY_VIP_ENTRANCE_CLICK\u0010\u0005\u0012\u0012\n\u000eVIP_RIGHT_SHOW\u0010\u0006\u0012\u001e\n\u001aBUY_VISITOR_ENTRANCE_CLICK\u0010\u0007\u0012\u001a\n\u0016BUY_VISITOR_POPUP_SHOW\u0010\b\u0012\u0019\n\u0015BUY_VISITOR_BTN_CLICK\u0010\t\u0012\u0017\n\u0013BUY_VISITOR_SUCCESS\u0010\n\u0012\u0014\n\u0010SHOW_MY_VISITORS\u0010\u000b\u0012\u0015\n\u0011CLICK_MY_VISITORS\u0010\f\u0012!\n\u001dFIND_SOMEONE_ON_MAP_BTN_CLICK\u0010\r\u0012!\n\u001dFIND_SOMEONE_ON_MAP_PAGE_SHOW\u0010\u000e\u0012!\n\u001dFIND_SOMEONE_ON_MAP_BAR_CLICK\u0010\u000f\u0012)\n%FIND_SOMEONE_ON_MAP_REPLACE_BTN_CLICK\u0010\u0010\u0012\u0017\n\u0013SEARCH_RESULT_CLICK\u0010\u0011\u0012\u0014\n\u0010GO_NOW_BTN_CLICK\u0010\u0012\u0012\u001c\n\u0018RETURN_CURRENT_BTN_CLICK\u0010\u0013\u0012\u0019\n\u0015NOBODY_FIND_TIPS_SHOW\u0010\u0014\u0012\u001a\n\u0016NEARBY_MATCH_BTN_CLICK\u0010\u0015\u0012\u001a\n\u0016NEARBY_MATCH_PAGE_SHOW\u0010\u0016\u0012\u001b\n\u0017FILTER_CONDITION_CHANGE\u0010\u0017\u0012\u001d\n\u0019BUY_SUPER_LIKE_POPUP_SHOW\u0010\u0018\u0012\u0018\n\u0014BUY_SUPER_LIKE_CLICK\u0010\u0019\u0012\u001a\n\u0016BUY_SUPER_LIKE_SUCCESS\u0010\u001a\u0012\u0016\n\u0012IAP_PAYMENT_CANCEL\u0010\u001b\u0012\u0016\n\u0012IAP_PAYMENT_FAILED\u0010\u001c\u0012\u001b\n\u0017IAP_ORDER_STATUS_CHANGE\u0010\u001d\u0012\u0017\n\u0013IAP_RECEIPT_REQUEST\u0010\u001e\u0012\u0016\n\u0012MY_VISITOR_AD_SHOW\u0010\u001f\u0012!\n\u001dBUY_RECALL_VISITOR_POPUP_SHOW\u0010 \u0012 \n\u001cBUY_RECALL_VISITOR_BTN_CLICK\u0010!\u0012\u001e\n\u001aBUY_RECALL_VISITOR_SUCCESS\u0010\"\u0012\u001e\n\u001aBUY_SUPER_EXPOSURE_SUCCESS\u0010#\u0012\u001e\n\u001aUSE_SUPER_EXPOSURE_SUCCESS\u0010$\u0012!\n\u001dBUY_SUPER_EXPOSURE_POPUP_SHOW\u0010%\u0012\"\n\u001eBUY_SUPER_EXPOSURE_POPUP_CLICK\u0010&\u0012'\n#SUPER_EXPOSURE_USE_CHECK_POPUP_SHOW\u0010'\u0012#\n\u001fDISCOUNT_BUY_VISITOR_POPUP_SHOW\u0010(\u0012\"\n\u001eDISCOUNT_BUY_VISITOR_BTN_CLICK\u0010)\u0012 \n\u001cDISCOUNT_BUY_VISITOR_SUCCESS\u0010*\u0012\u0017\n\u0013VAS_POPUP_BTN_CLICK\u0010+\u0012\u0011\n\rAI_UPLOAD_PIC\u0010,*ê\u0001\n\tEnum_type\u0012\u0015\n\u0011UNKNOWN_ENUM_TYPE\u0010\u0000\u0012\n\n\u0006A_PLUS\u0010\u0001\u0012\u000e\n\nDIO_A_PLUS\u0010\u0002\u0012\u0015\n\u0011A_PLUS_REPURCHASE\u0010\u0003\u0012\b\n\u0004ICON\u0010\u0004\u0012\n\n\u0006FILTER\u0010\u0005\u0012\u000b\n\u0007MIXTURE\u0010\u0006\u0012\u0012\n\u000eRAINBOW_A_PLUS\u0010\u0007\u0012\u0019\n\u0015A_DIO_RAINBOW_MIXTURE\u0010\b\u0012\u0017\n\u0013DIO_RAINBOW_MIXTURE\u0010\t\u0012\u000b\n\u0007VISITOR\u0010\n\u0012\u001b\n\u0017VISITOR_RAINBOW_MIXTURE\u0010\u000b*N\n\bSub_type\u0012\u0014\n\u0010UNKNOWN_SUB_TYPE\u0010\u0000\u0012\n\n\u0006WECHAT\u0010\u0001\u0012\u000b\n\u0007ALI_PAY\u0010\u0002\u0012\u0013\n\u000fANT_CHECK_LATER\u0010\u0003*]\n\bBuy_type\u0012\u0014\n\u0010UNKNOWN_BUY_TYPE\u0010\u0000\u0012\u000b\n\u0007UPGRADE\u0010\u0001\u0012\u000b\n\u0007DEGRADE\u0010\u0002\u0012\u0012\n\u000eNON_MEMBER_BUY\u0010\u0003\u0012\r\n\tNO_CHANGE\u0010\u0004B\f¢\u0002\tINCREMENTb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_increment_IncrementProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_increment_IncrementProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Buy_type implements ProtocolMessageEnum {
        UNKNOWN_BUY_TYPE(0),
        UPGRADE(1),
        DEGRADE(2),
        NON_MEMBER_BUY(3),
        NO_CHANGE(4),
        UNRECOGNIZED(-1);

        public static final int DEGRADE_VALUE = 2;
        public static final int NON_MEMBER_BUY_VALUE = 3;
        public static final int NO_CHANGE_VALUE = 4;
        public static final int UNKNOWN_BUY_TYPE_VALUE = 0;
        public static final int UPGRADE_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<Buy_type> internalValueMap = new Internal.EnumLiteMap<Buy_type>() { // from class: com.irisdt.client.increment.IncrementProtos.Buy_type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Buy_type findValueByNumber(int i10) {
                return Buy_type.forNumber(i10);
            }
        };
        private static final Buy_type[] VALUES = values();

        Buy_type(int i10) {
            this.value = i10;
        }

        public static Buy_type forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_BUY_TYPE;
            }
            if (i10 == 1) {
                return UPGRADE;
            }
            if (i10 == 2) {
                return DEGRADE;
            }
            if (i10 == 3) {
                return NON_MEMBER_BUY;
            }
            if (i10 != 4) {
                return null;
            }
            return NO_CHANGE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return IncrementProtos.getDescriptor().getEnumTypes().get(3);
        }

        public static Internal.EnumLiteMap<Buy_type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Buy_type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Buy_type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Enum_type implements ProtocolMessageEnum {
        UNKNOWN_ENUM_TYPE(0),
        A_PLUS(1),
        DIO_A_PLUS(2),
        A_PLUS_REPURCHASE(3),
        ICON(4),
        FILTER(5),
        MIXTURE(6),
        RAINBOW_A_PLUS(7),
        A_DIO_RAINBOW_MIXTURE(8),
        DIO_RAINBOW_MIXTURE(9),
        VISITOR(10),
        VISITOR_RAINBOW_MIXTURE(11),
        UNRECOGNIZED(-1);

        public static final int A_DIO_RAINBOW_MIXTURE_VALUE = 8;
        public static final int A_PLUS_REPURCHASE_VALUE = 3;
        public static final int A_PLUS_VALUE = 1;
        public static final int DIO_A_PLUS_VALUE = 2;
        public static final int DIO_RAINBOW_MIXTURE_VALUE = 9;
        public static final int FILTER_VALUE = 5;
        public static final int ICON_VALUE = 4;
        public static final int MIXTURE_VALUE = 6;
        public static final int RAINBOW_A_PLUS_VALUE = 7;
        public static final int UNKNOWN_ENUM_TYPE_VALUE = 0;
        public static final int VISITOR_RAINBOW_MIXTURE_VALUE = 11;
        public static final int VISITOR_VALUE = 10;
        private final int value;
        private static final Internal.EnumLiteMap<Enum_type> internalValueMap = new Internal.EnumLiteMap<Enum_type>() { // from class: com.irisdt.client.increment.IncrementProtos.Enum_type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Enum_type findValueByNumber(int i10) {
                return Enum_type.forNumber(i10);
            }
        };
        private static final Enum_type[] VALUES = values();

        Enum_type(int i10) {
            this.value = i10;
        }

        public static Enum_type forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_ENUM_TYPE;
                case 1:
                    return A_PLUS;
                case 2:
                    return DIO_A_PLUS;
                case 3:
                    return A_PLUS_REPURCHASE;
                case 4:
                    return ICON;
                case 5:
                    return FILTER;
                case 6:
                    return MIXTURE;
                case 7:
                    return RAINBOW_A_PLUS;
                case 8:
                    return A_DIO_RAINBOW_MIXTURE;
                case 9:
                    return DIO_RAINBOW_MIXTURE;
                case 10:
                    return VISITOR;
                case 11:
                    return VISITOR_RAINBOW_MIXTURE;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return IncrementProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Enum_type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Enum_type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Enum_type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        BUY_VIP_ENTRANCE_CLICK(1),
        BUY_VIP_POPUP_SHOW(2),
        BUY_VIP_BUY_BTN_CLICK(3),
        BUY_VIP_SUCCESS(4),
        BUY_VIP_BUY_VIP_ENTRANCE_CLICK(5),
        VIP_RIGHT_SHOW(6),
        BUY_VISITOR_ENTRANCE_CLICK(7),
        BUY_VISITOR_POPUP_SHOW(8),
        BUY_VISITOR_BTN_CLICK(9),
        BUY_VISITOR_SUCCESS(10),
        SHOW_MY_VISITORS(11),
        CLICK_MY_VISITORS(12),
        FIND_SOMEONE_ON_MAP_BTN_CLICK(13),
        FIND_SOMEONE_ON_MAP_PAGE_SHOW(14),
        FIND_SOMEONE_ON_MAP_BAR_CLICK(15),
        FIND_SOMEONE_ON_MAP_REPLACE_BTN_CLICK(16),
        SEARCH_RESULT_CLICK(17),
        GO_NOW_BTN_CLICK(18),
        RETURN_CURRENT_BTN_CLICK(19),
        NOBODY_FIND_TIPS_SHOW(20),
        NEARBY_MATCH_BTN_CLICK(21),
        NEARBY_MATCH_PAGE_SHOW(22),
        FILTER_CONDITION_CHANGE(23),
        BUY_SUPER_LIKE_POPUP_SHOW(24),
        BUY_SUPER_LIKE_CLICK(25),
        BUY_SUPER_LIKE_SUCCESS(26),
        IAP_PAYMENT_CANCEL(27),
        IAP_PAYMENT_FAILED(28),
        IAP_ORDER_STATUS_CHANGE(29),
        IAP_RECEIPT_REQUEST(30),
        MY_VISITOR_AD_SHOW(31),
        BUY_RECALL_VISITOR_POPUP_SHOW(32),
        BUY_RECALL_VISITOR_BTN_CLICK(33),
        BUY_RECALL_VISITOR_SUCCESS(34),
        BUY_SUPER_EXPOSURE_SUCCESS(35),
        USE_SUPER_EXPOSURE_SUCCESS(36),
        BUY_SUPER_EXPOSURE_POPUP_SHOW(37),
        BUY_SUPER_EXPOSURE_POPUP_CLICK(38),
        SUPER_EXPOSURE_USE_CHECK_POPUP_SHOW(39),
        DISCOUNT_BUY_VISITOR_POPUP_SHOW(40),
        DISCOUNT_BUY_VISITOR_BTN_CLICK(41),
        DISCOUNT_BUY_VISITOR_SUCCESS(42),
        VAS_POPUP_BTN_CLICK(43),
        AI_UPLOAD_PIC(44),
        UNRECOGNIZED(-1);

        public static final int AI_UPLOAD_PIC_VALUE = 44;
        public static final int BUY_RECALL_VISITOR_BTN_CLICK_VALUE = 33;
        public static final int BUY_RECALL_VISITOR_POPUP_SHOW_VALUE = 32;
        public static final int BUY_RECALL_VISITOR_SUCCESS_VALUE = 34;
        public static final int BUY_SUPER_EXPOSURE_POPUP_CLICK_VALUE = 38;
        public static final int BUY_SUPER_EXPOSURE_POPUP_SHOW_VALUE = 37;
        public static final int BUY_SUPER_EXPOSURE_SUCCESS_VALUE = 35;
        public static final int BUY_SUPER_LIKE_CLICK_VALUE = 25;
        public static final int BUY_SUPER_LIKE_POPUP_SHOW_VALUE = 24;
        public static final int BUY_SUPER_LIKE_SUCCESS_VALUE = 26;
        public static final int BUY_VIP_BUY_BTN_CLICK_VALUE = 3;
        public static final int BUY_VIP_BUY_VIP_ENTRANCE_CLICK_VALUE = 5;
        public static final int BUY_VIP_ENTRANCE_CLICK_VALUE = 1;
        public static final int BUY_VIP_POPUP_SHOW_VALUE = 2;
        public static final int BUY_VIP_SUCCESS_VALUE = 4;
        public static final int BUY_VISITOR_BTN_CLICK_VALUE = 9;
        public static final int BUY_VISITOR_ENTRANCE_CLICK_VALUE = 7;
        public static final int BUY_VISITOR_POPUP_SHOW_VALUE = 8;
        public static final int BUY_VISITOR_SUCCESS_VALUE = 10;
        public static final int CLICK_MY_VISITORS_VALUE = 12;
        public static final int DISCOUNT_BUY_VISITOR_BTN_CLICK_VALUE = 41;
        public static final int DISCOUNT_BUY_VISITOR_POPUP_SHOW_VALUE = 40;
        public static final int DISCOUNT_BUY_VISITOR_SUCCESS_VALUE = 42;
        public static final int FILTER_CONDITION_CHANGE_VALUE = 23;
        public static final int FIND_SOMEONE_ON_MAP_BAR_CLICK_VALUE = 15;
        public static final int FIND_SOMEONE_ON_MAP_BTN_CLICK_VALUE = 13;
        public static final int FIND_SOMEONE_ON_MAP_PAGE_SHOW_VALUE = 14;
        public static final int FIND_SOMEONE_ON_MAP_REPLACE_BTN_CLICK_VALUE = 16;
        public static final int GO_NOW_BTN_CLICK_VALUE = 18;
        public static final int IAP_ORDER_STATUS_CHANGE_VALUE = 29;
        public static final int IAP_PAYMENT_CANCEL_VALUE = 27;
        public static final int IAP_PAYMENT_FAILED_VALUE = 28;
        public static final int IAP_RECEIPT_REQUEST_VALUE = 30;
        public static final int MY_VISITOR_AD_SHOW_VALUE = 31;
        public static final int NEARBY_MATCH_BTN_CLICK_VALUE = 21;
        public static final int NEARBY_MATCH_PAGE_SHOW_VALUE = 22;
        public static final int NOBODY_FIND_TIPS_SHOW_VALUE = 20;
        public static final int RETURN_CURRENT_BTN_CLICK_VALUE = 19;
        public static final int SEARCH_RESULT_CLICK_VALUE = 17;
        public static final int SHOW_MY_VISITORS_VALUE = 11;
        public static final int SUPER_EXPOSURE_USE_CHECK_POPUP_SHOW_VALUE = 39;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        public static final int USE_SUPER_EXPOSURE_SUCCESS_VALUE = 36;
        public static final int VAS_POPUP_BTN_CLICK_VALUE = 43;
        public static final int VIP_RIGHT_SHOW_VALUE = 6;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.irisdt.client.increment.IncrementProtos.Event.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i10) {
                return Event.forNumber(i10);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i10) {
            this.value = i10;
        }

        public static Event forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_EVENT;
                case 1:
                    return BUY_VIP_ENTRANCE_CLICK;
                case 2:
                    return BUY_VIP_POPUP_SHOW;
                case 3:
                    return BUY_VIP_BUY_BTN_CLICK;
                case 4:
                    return BUY_VIP_SUCCESS;
                case 5:
                    return BUY_VIP_BUY_VIP_ENTRANCE_CLICK;
                case 6:
                    return VIP_RIGHT_SHOW;
                case 7:
                    return BUY_VISITOR_ENTRANCE_CLICK;
                case 8:
                    return BUY_VISITOR_POPUP_SHOW;
                case 9:
                    return BUY_VISITOR_BTN_CLICK;
                case 10:
                    return BUY_VISITOR_SUCCESS;
                case 11:
                    return SHOW_MY_VISITORS;
                case 12:
                    return CLICK_MY_VISITORS;
                case 13:
                    return FIND_SOMEONE_ON_MAP_BTN_CLICK;
                case 14:
                    return FIND_SOMEONE_ON_MAP_PAGE_SHOW;
                case 15:
                    return FIND_SOMEONE_ON_MAP_BAR_CLICK;
                case 16:
                    return FIND_SOMEONE_ON_MAP_REPLACE_BTN_CLICK;
                case 17:
                    return SEARCH_RESULT_CLICK;
                case 18:
                    return GO_NOW_BTN_CLICK;
                case 19:
                    return RETURN_CURRENT_BTN_CLICK;
                case 20:
                    return NOBODY_FIND_TIPS_SHOW;
                case 21:
                    return NEARBY_MATCH_BTN_CLICK;
                case 22:
                    return NEARBY_MATCH_PAGE_SHOW;
                case 23:
                    return FILTER_CONDITION_CHANGE;
                case 24:
                    return BUY_SUPER_LIKE_POPUP_SHOW;
                case 25:
                    return BUY_SUPER_LIKE_CLICK;
                case 26:
                    return BUY_SUPER_LIKE_SUCCESS;
                case 27:
                    return IAP_PAYMENT_CANCEL;
                case 28:
                    return IAP_PAYMENT_FAILED;
                case 29:
                    return IAP_ORDER_STATUS_CHANGE;
                case 30:
                    return IAP_RECEIPT_REQUEST;
                case 31:
                    return MY_VISITOR_AD_SHOW;
                case 32:
                    return BUY_RECALL_VISITOR_POPUP_SHOW;
                case 33:
                    return BUY_RECALL_VISITOR_BTN_CLICK;
                case 34:
                    return BUY_RECALL_VISITOR_SUCCESS;
                case 35:
                    return BUY_SUPER_EXPOSURE_SUCCESS;
                case 36:
                    return USE_SUPER_EXPOSURE_SUCCESS;
                case 37:
                    return BUY_SUPER_EXPOSURE_POPUP_SHOW;
                case 38:
                    return BUY_SUPER_EXPOSURE_POPUP_CLICK;
                case 39:
                    return SUPER_EXPOSURE_USE_CHECK_POPUP_SHOW;
                case 40:
                    return DISCOUNT_BUY_VISITOR_POPUP_SHOW;
                case 41:
                    return DISCOUNT_BUY_VISITOR_BTN_CLICK;
                case 42:
                    return DISCOUNT_BUY_VISITOR_SUCCESS;
                case 43:
                    return VAS_POPUP_BTN_CLICK;
                case 44:
                    return AI_UPLOAD_PIC;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return IncrementProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Event valueOf(int i10) {
            return forNumber(i10);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class IncrementProto extends GeneratedMessageV3 implements IncrementProtoOrBuilder {
        public static final int ACTIVE_TIME_FIELD_NUMBER = 29;
        public static final int AGE_FIELD_NUMBER = 18;
        public static final int BUY_TYPE_FIELD_NUMBER = 9;
        public static final int CONSTELLATION_FIELD_NUMBER = 17;
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int COUPON_ID_FIELD_NUMBER = 26;
        public static final int DEFAULT_TAG_FIELD_NUMBER = 31;
        public static final int ENUM_TYPE_FIELD_NUMBER = 7;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 3;
        public static final int HEIGHT_FIELD_NUMBER = 19;
        public static final int ID_FIELD_NUMBER = 13;
        public static final int INFO_FIELD_NUMBER = 28;
        public static final int IS_BOUGHT_VIP_FIELD_NUMBER = 34;
        public static final int IS_HIGH_MATCH_RATE_FIELD_NUMBER = 39;
        public static final int IS_NEW_FIELD_NUMBER = 37;
        public static final int IS_POPULAR_FIELD_NUMBER = 38;
        public static final int IS_SINGLE_FIELD_NUMBER = 36;
        public static final int IS_TRAVEL_FIELD_NUMBER = 40;
        public static final int IS_TRUE_FIELD_NUMBER = 6;
        public static final int LATITUDE_FIELD_NUMBER = 12;
        public static final int LEVEL_FIELD_NUMBER = 4;
        public static final int LOCATION_FIELD_NUMBER = 15;
        public static final int LONGITUDE_FIELD_NUMBER = 11;
        public static final int MBTI_FIELD_NUMBER = 35;
        public static final int METHOD_FIELD_NUMBER = 22;
        public static final int NAME_FIELD_NUMBER = 10;
        public static final int NUM_FIELD_NUMBER = 30;
        public static final int POSITION_FIELD_NUMBER = 14;
        public static final int PRICE_FIELD_NUMBER = 33;
        public static final int ROLE_FIELD_NUMBER = 16;
        public static final int SCENE_FIELD_NUMBER = 25;
        public static final int SHOW_TYPE_FIELD_NUMBER = 32;
        public static final int SKU_FIELD_NUMBER = 24;
        public static final int SUB_TYPE_FIELD_NUMBER = 8;
        public static final int TIME_FIELD_NUMBER = 21;
        public static final int TRANSACTION_ID_FIELD_NUMBER = 23;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int USER_TYPE_FIELD_NUMBER = 27;
        public static final int WEIGHT_FIELD_NUMBER = 20;
        private static final long serialVersionUID = 0;
        private volatile Object activeTime_;
        private volatile Object age_;
        private int buyType_;
        private volatile Object constellation_;
        private volatile Object content_;
        private volatile Object couponId_;
        private int defaultTag_;
        private int enumType_;
        private int event_;
        private volatile Object from_;
        private volatile Object height_;
        private volatile Object id_;
        private volatile Object info_;
        private boolean isBoughtVip_;
        private boolean isHighMatchRate_;
        private boolean isNew_;
        private boolean isPopular_;
        private boolean isSingle_;
        private boolean isTravel_;
        private boolean isTrue_;
        private double latitude_;
        private volatile Object level_;
        private volatile Object location_;
        private double longitude_;
        private volatile Object mbti_;
        private byte memoizedIsInitialized;
        private volatile Object method_;
        private volatile Object name_;
        private int num_;
        private volatile Object position_;
        private volatile Object price_;
        private volatile Object role_;
        private volatile Object scene_;
        private int showType_;
        private volatile Object sku_;
        private int subType_;
        private int time_;
        private volatile Object transactionId_;
        private volatile Object type_;
        private int userType_;
        private volatile Object weight_;
        private static final IncrementProto DEFAULT_INSTANCE = new IncrementProto();
        private static final Parser<IncrementProto> PARSER = new AbstractParser<IncrementProto>() { // from class: com.irisdt.client.increment.IncrementProtos.IncrementProto.1
            @Override // com.google.protobuf.Parser
            public IncrementProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new IncrementProto(codedInputStream, extensionRegistryLite);
            }
        };

        private IncrementProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static IncrementProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IncrementProtos.internal_static_com_irisdt_client_increment_IncrementProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static IncrementProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IncrementProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static IncrementProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<IncrementProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IncrementProto)) {
                return super.equals(obj);
            }
            IncrementProto incrementProto = (IncrementProto) obj;
            return this.event_ == incrementProto.event_ && getContent().equals(incrementProto.getContent()) && getFrom().equals(incrementProto.getFrom()) && getLevel().equals(incrementProto.getLevel()) && getType().equals(incrementProto.getType()) && getIsTrue() == incrementProto.getIsTrue() && this.enumType_ == incrementProto.enumType_ && this.subType_ == incrementProto.subType_ && this.buyType_ == incrementProto.buyType_ && getName().equals(incrementProto.getName()) && Double.doubleToLongBits(getLongitude()) == Double.doubleToLongBits(incrementProto.getLongitude()) && Double.doubleToLongBits(getLatitude()) == Double.doubleToLongBits(incrementProto.getLatitude()) && getId().equals(incrementProto.getId()) && getPosition().equals(incrementProto.getPosition()) && getLocation().equals(incrementProto.getLocation()) && getRole().equals(incrementProto.getRole()) && getConstellation().equals(incrementProto.getConstellation()) && getAge().equals(incrementProto.getAge()) && getHeight().equals(incrementProto.getHeight()) && getWeight().equals(incrementProto.getWeight()) && getTime() == incrementProto.getTime() && getMethod().equals(incrementProto.getMethod()) && getTransactionId().equals(incrementProto.getTransactionId()) && getSku().equals(incrementProto.getSku()) && getScene().equals(incrementProto.getScene()) && getCouponId().equals(incrementProto.getCouponId()) && getUserType() == incrementProto.getUserType() && getInfo().equals(incrementProto.getInfo()) && getActiveTime().equals(incrementProto.getActiveTime()) && getNum() == incrementProto.getNum() && this.defaultTag_ == incrementProto.defaultTag_ && this.showType_ == incrementProto.showType_ && getPrice().equals(incrementProto.getPrice()) && getIsBoughtVip() == incrementProto.getIsBoughtVip() && getMbti().equals(incrementProto.getMbti()) && getIsSingle() == incrementProto.getIsSingle() && getIsNew() == incrementProto.getIsNew() && getIsPopular() == incrementProto.getIsPopular() && getIsHighMatchRate() == incrementProto.getIsHighMatchRate() && getIsTravel() == incrementProto.getIsTravel() && this.unknownFields.equals(incrementProto.unknownFields);
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getActiveTime() {
            Object obj = this.activeTime_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.activeTime_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getActiveTimeBytes() {
            Object obj = this.activeTime_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.activeTime_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getAge() {
            Object obj = this.age_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.age_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getAgeBytes() {
            Object obj = this.age_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.age_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public Buy_type getBuyType() {
            Buy_type valueOf = Buy_type.valueOf(this.buyType_);
            return valueOf == null ? Buy_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getBuyTypeValue() {
            return this.buyType_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getConstellation() {
            Object obj = this.constellation_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.constellation_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getConstellationBytes() {
            Object obj = this.constellation_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.constellation_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getCouponId() {
            Object obj = this.couponId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.couponId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getCouponIdBytes() {
            Object obj = this.couponId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.couponId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public Enum_type getDefaultTag() {
            Enum_type valueOf = Enum_type.valueOf(this.defaultTag_);
            return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getDefaultTagValue() {
            return this.defaultTag_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public Enum_type getEnumType() {
            Enum_type valueOf = Enum_type.valueOf(this.enumType_);
            return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getEnumTypeValue() {
            return this.enumType_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            return valueOf == null ? Event.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getFrom() {
            Object obj = this.from_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.from_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getFromBytes() {
            Object obj = this.from_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.from_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getHeight() {
            Object obj = this.height_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.height_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getHeightBytes() {
            Object obj = this.height_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.height_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getInfo() {
            Object obj = this.info_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.info_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getInfoBytes() {
            Object obj = this.info_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.info_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public boolean getIsBoughtVip() {
            return this.isBoughtVip_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public boolean getIsHighMatchRate() {
            return this.isHighMatchRate_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public boolean getIsNew() {
            return this.isNew_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public boolean getIsPopular() {
            return this.isPopular_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public boolean getIsSingle() {
            return this.isSingle_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public boolean getIsTravel() {
            return this.isTravel_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public double getLatitude() {
            return this.latitude_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getLevel() {
            Object obj = this.level_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.level_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getLevelBytes() {
            Object obj = this.level_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.level_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getLocation() {
            Object obj = this.location_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.location_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getLocationBytes() {
            Object obj = this.location_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.location_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public double getLongitude() {
            return this.longitude_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getMbti() {
            Object obj = this.mbti_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mbti_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getMbtiBytes() {
            Object obj = this.mbti_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mbti_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getMethod() {
            Object obj = this.method_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.method_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getMethodBytes() {
            Object obj = this.method_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IncrementProto> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getPosition() {
            Object obj = this.position_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.position_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getPrice() {
            Object obj = this.price_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.price_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getPriceBytes() {
            Object obj = this.price_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.price_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getRole() {
            Object obj = this.role_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.role_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getRoleBytes() {
            Object obj = this.role_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.role_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getScene() {
            Object obj = this.scene_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.scene_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getSceneBytes() {
            Object obj = this.scene_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.scene_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeEnumSize = this.event_ != Event.UNKNOWN_EVENT.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.event_) : 0;
            if (!getContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.content_);
            }
            if (!getFromBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.from_);
            }
            if (!getLevelBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(4, this.level_);
            }
            if (!getTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(5, this.type_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                computeEnumSize += CodedOutputStream.computeBoolSize(6, z10);
            }
            int i11 = this.enumType_;
            Enum_type enum_type = Enum_type.UNKNOWN_ENUM_TYPE;
            if (i11 != enum_type.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(7, this.enumType_);
            }
            if (this.subType_ != Sub_type.UNKNOWN_SUB_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(8, this.subType_);
            }
            if (this.buyType_ != Buy_type.UNKNOWN_BUY_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(9, this.buyType_);
            }
            if (!getNameBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(10, this.name_);
            }
            double d10 = this.longitude_;
            if (d10 != ShadowDrawableWrapper.COS_45) {
                computeEnumSize += CodedOutputStream.computeDoubleSize(11, d10);
            }
            double d11 = this.latitude_;
            if (d11 != ShadowDrawableWrapper.COS_45) {
                computeEnumSize += CodedOutputStream.computeDoubleSize(12, d11);
            }
            if (!getIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(13, this.id_);
            }
            if (!getPositionBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(14, this.position_);
            }
            if (!getLocationBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(15, this.location_);
            }
            if (!getRoleBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(16, this.role_);
            }
            if (!getConstellationBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(17, this.constellation_);
            }
            if (!getAgeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(18, this.age_);
            }
            if (!getHeightBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(19, this.height_);
            }
            if (!getWeightBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(20, this.weight_);
            }
            int i12 = this.time_;
            if (i12 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(21, i12);
            }
            if (!getMethodBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(22, this.method_);
            }
            if (!getTransactionIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(23, this.transactionId_);
            }
            if (!getSkuBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(24, this.sku_);
            }
            if (!getSceneBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(25, this.scene_);
            }
            if (!getCouponIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(26, this.couponId_);
            }
            int i13 = this.userType_;
            if (i13 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(27, i13);
            }
            if (!getInfoBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(28, this.info_);
            }
            if (!getActiveTimeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(29, this.activeTime_);
            }
            int i14 = this.num_;
            if (i14 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(30, i14);
            }
            if (this.defaultTag_ != enum_type.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(31, this.defaultTag_);
            }
            if (this.showType_ != enum_type.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(32, this.showType_);
            }
            if (!getPriceBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(33, this.price_);
            }
            boolean z11 = this.isBoughtVip_;
            if (z11) {
                computeEnumSize += CodedOutputStream.computeBoolSize(34, z11);
            }
            if (!getMbtiBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(35, this.mbti_);
            }
            boolean z12 = this.isSingle_;
            if (z12) {
                computeEnumSize += CodedOutputStream.computeBoolSize(36, z12);
            }
            boolean z13 = this.isNew_;
            if (z13) {
                computeEnumSize += CodedOutputStream.computeBoolSize(37, z13);
            }
            boolean z14 = this.isPopular_;
            if (z14) {
                computeEnumSize += CodedOutputStream.computeBoolSize(38, z14);
            }
            boolean z15 = this.isHighMatchRate_;
            if (z15) {
                computeEnumSize += CodedOutputStream.computeBoolSize(39, z15);
            }
            boolean z16 = this.isTravel_;
            if (z16) {
                computeEnumSize += CodedOutputStream.computeBoolSize(40, z16);
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public Enum_type getShowType() {
            Enum_type valueOf = Enum_type.valueOf(this.showType_);
            return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getShowTypeValue() {
            return this.showType_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getSku() {
            Object obj = this.sku_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sku_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getSkuBytes() {
            Object obj = this.sku_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sku_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public Sub_type getSubType() {
            Sub_type valueOf = Sub_type.valueOf(this.subType_);
            return valueOf == null ? Sub_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getSubTypeValue() {
            return this.subType_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getTime() {
            return this.time_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getTransactionId() {
            Object obj = this.transactionId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.transactionId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getTransactionIdBytes() {
            Object obj = this.transactionId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.transactionId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public int getUserType() {
            return this.userType_;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public String getWeight() {
            Object obj = this.weight_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.weight_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
        public ByteString getWeightBytes() {
            Object obj = this.weight_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.weight_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getContent().hashCode()) * 37) + 3) * 53) + getFrom().hashCode()) * 37) + 4) * 53) + getLevel().hashCode()) * 37) + 5) * 53) + getType().hashCode()) * 37) + 6) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 7) * 53) + this.enumType_) * 37) + 8) * 53) + this.subType_) * 37) + 9) * 53) + this.buyType_) * 37) + 10) * 53) + getName().hashCode()) * 37) + 11) * 53) + Internal.hashLong(Double.doubleToLongBits(getLongitude()))) * 37) + 12) * 53) + Internal.hashLong(Double.doubleToLongBits(getLatitude()))) * 37) + 13) * 53) + getId().hashCode()) * 37) + 14) * 53) + getPosition().hashCode()) * 37) + 15) * 53) + getLocation().hashCode()) * 37) + 16) * 53) + getRole().hashCode()) * 37) + 17) * 53) + getConstellation().hashCode()) * 37) + 18) * 53) + getAge().hashCode()) * 37) + 19) * 53) + getHeight().hashCode()) * 37) + 20) * 53) + getWeight().hashCode()) * 37) + 21) * 53) + getTime()) * 37) + 22) * 53) + getMethod().hashCode()) * 37) + 23) * 53) + getTransactionId().hashCode()) * 37) + 24) * 53) + getSku().hashCode()) * 37) + 25) * 53) + getScene().hashCode()) * 37) + 26) * 53) + getCouponId().hashCode()) * 37) + 27) * 53) + getUserType()) * 37) + 28) * 53) + getInfo().hashCode()) * 37) + 29) * 53) + getActiveTime().hashCode()) * 37) + 30) * 53) + getNum()) * 37) + 31) * 53) + this.defaultTag_) * 37) + 32) * 53) + this.showType_) * 37) + 33) * 53) + getPrice().hashCode()) * 37) + 34) * 53) + Internal.hashBoolean(getIsBoughtVip())) * 37) + 35) * 53) + getMbti().hashCode()) * 37) + 36) * 53) + Internal.hashBoolean(getIsSingle())) * 37) + 37) * 53) + Internal.hashBoolean(getIsNew())) * 37) + 38) * 53) + Internal.hashBoolean(getIsPopular())) * 37) + 39) * 53) + Internal.hashBoolean(getIsHighMatchRate())) * 37) + 40) * 53) + Internal.hashBoolean(getIsTravel())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IncrementProtos.internal_static_com_irisdt_client_increment_IncrementProto_fieldAccessorTable.ensureFieldAccessorsInitialized(IncrementProto.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new IncrementProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.content_);
            }
            if (!getFromBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.from_);
            }
            if (!getLevelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.level_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.type_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                codedOutputStream.writeBool(6, z10);
            }
            int i10 = this.enumType_;
            Enum_type enum_type = Enum_type.UNKNOWN_ENUM_TYPE;
            if (i10 != enum_type.getNumber()) {
                codedOutputStream.writeEnum(7, this.enumType_);
            }
            if (this.subType_ != Sub_type.UNKNOWN_SUB_TYPE.getNumber()) {
                codedOutputStream.writeEnum(8, this.subType_);
            }
            if (this.buyType_ != Buy_type.UNKNOWN_BUY_TYPE.getNumber()) {
                codedOutputStream.writeEnum(9, this.buyType_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.name_);
            }
            double d10 = this.longitude_;
            if (d10 != ShadowDrawableWrapper.COS_45) {
                codedOutputStream.writeDouble(11, d10);
            }
            double d11 = this.latitude_;
            if (d11 != ShadowDrawableWrapper.COS_45) {
                codedOutputStream.writeDouble(12, d11);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.id_);
            }
            if (!getPositionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.position_);
            }
            if (!getLocationBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.location_);
            }
            if (!getRoleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.role_);
            }
            if (!getConstellationBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.constellation_);
            }
            if (!getAgeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.age_);
            }
            if (!getHeightBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.height_);
            }
            if (!getWeightBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.weight_);
            }
            int i11 = this.time_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(21, i11);
            }
            if (!getMethodBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 22, this.method_);
            }
            if (!getTransactionIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.transactionId_);
            }
            if (!getSkuBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.sku_);
            }
            if (!getSceneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.scene_);
            }
            if (!getCouponIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 26, this.couponId_);
            }
            int i12 = this.userType_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(27, i12);
            }
            if (!getInfoBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 28, this.info_);
            }
            if (!getActiveTimeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 29, this.activeTime_);
            }
            int i13 = this.num_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(30, i13);
            }
            if (this.defaultTag_ != enum_type.getNumber()) {
                codedOutputStream.writeEnum(31, this.defaultTag_);
            }
            if (this.showType_ != enum_type.getNumber()) {
                codedOutputStream.writeEnum(32, this.showType_);
            }
            if (!getPriceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 33, this.price_);
            }
            boolean z11 = this.isBoughtVip_;
            if (z11) {
                codedOutputStream.writeBool(34, z11);
            }
            if (!getMbtiBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 35, this.mbti_);
            }
            boolean z12 = this.isSingle_;
            if (z12) {
                codedOutputStream.writeBool(36, z12);
            }
            boolean z13 = this.isNew_;
            if (z13) {
                codedOutputStream.writeBool(37, z13);
            }
            boolean z14 = this.isPopular_;
            if (z14) {
                codedOutputStream.writeBool(38, z14);
            }
            boolean z15 = this.isHighMatchRate_;
            if (z15) {
                codedOutputStream.writeBool(39, z15);
            }
            boolean z16 = this.isTravel_;
            if (z16) {
                codedOutputStream.writeBool(40, z16);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IncrementProtoOrBuilder {
            private Object activeTime_;
            private Object age_;
            private int buyType_;
            private Object constellation_;
            private Object content_;
            private Object couponId_;
            private int defaultTag_;
            private int enumType_;
            private int event_;
            private Object from_;
            private Object height_;
            private Object id_;
            private Object info_;
            private boolean isBoughtVip_;
            private boolean isHighMatchRate_;
            private boolean isNew_;
            private boolean isPopular_;
            private boolean isSingle_;
            private boolean isTravel_;
            private boolean isTrue_;
            private double latitude_;
            private Object level_;
            private Object location_;
            private double longitude_;
            private Object mbti_;
            private Object method_;
            private Object name_;
            private int num_;
            private Object position_;
            private Object price_;
            private Object role_;
            private Object scene_;
            private int showType_;
            private Object sku_;
            private int subType_;
            private int time_;
            private Object transactionId_;
            private Object type_;
            private int userType_;
            private Object weight_;

            private Builder() {
                this.event_ = 0;
                this.content_ = "";
                this.from_ = "";
                this.level_ = "";
                this.type_ = "";
                this.enumType_ = 0;
                this.subType_ = 0;
                this.buyType_ = 0;
                this.name_ = "";
                this.id_ = "";
                this.position_ = "";
                this.location_ = "";
                this.role_ = "";
                this.constellation_ = "";
                this.age_ = "";
                this.height_ = "";
                this.weight_ = "";
                this.method_ = "";
                this.transactionId_ = "";
                this.sku_ = "";
                this.scene_ = "";
                this.couponId_ = "";
                this.info_ = "";
                this.activeTime_ = "";
                this.defaultTag_ = 0;
                this.showType_ = 0;
                this.price_ = "";
                this.mbti_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return IncrementProtos.internal_static_com_irisdt_client_increment_IncrementProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearActiveTime() {
                this.activeTime_ = IncrementProto.getDefaultInstance().getActiveTime();
                onChanged();
                return this;
            }

            public Builder clearAge() {
                this.age_ = IncrementProto.getDefaultInstance().getAge();
                onChanged();
                return this;
            }

            public Builder clearBuyType() {
                this.buyType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearConstellation() {
                this.constellation_ = IncrementProto.getDefaultInstance().getConstellation();
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = IncrementProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearCouponId() {
                this.couponId_ = IncrementProto.getDefaultInstance().getCouponId();
                onChanged();
                return this;
            }

            public Builder clearDefaultTag() {
                this.defaultTag_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEnumType() {
                this.enumType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFrom() {
                this.from_ = IncrementProto.getDefaultInstance().getFrom();
                onChanged();
                return this;
            }

            public Builder clearHeight() {
                this.height_ = IncrementProto.getDefaultInstance().getHeight();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = IncrementProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearInfo() {
                this.info_ = IncrementProto.getDefaultInstance().getInfo();
                onChanged();
                return this;
            }

            public Builder clearIsBoughtVip() {
                this.isBoughtVip_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsHighMatchRate() {
                this.isHighMatchRate_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsNew() {
                this.isNew_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsPopular() {
                this.isPopular_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSingle() {
                this.isSingle_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTravel() {
                this.isTravel_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearLatitude() {
                this.latitude_ = ShadowDrawableWrapper.COS_45;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = IncrementProto.getDefaultInstance().getLevel();
                onChanged();
                return this;
            }

            public Builder clearLocation() {
                this.location_ = IncrementProto.getDefaultInstance().getLocation();
                onChanged();
                return this;
            }

            public Builder clearLongitude() {
                this.longitude_ = ShadowDrawableWrapper.COS_45;
                onChanged();
                return this;
            }

            public Builder clearMbti() {
                this.mbti_ = IncrementProto.getDefaultInstance().getMbti();
                onChanged();
                return this;
            }

            public Builder clearMethod() {
                this.method_ = IncrementProto.getDefaultInstance().getMethod();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = IncrementProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = IncrementProto.getDefaultInstance().getPosition();
                onChanged();
                return this;
            }

            public Builder clearPrice() {
                this.price_ = IncrementProto.getDefaultInstance().getPrice();
                onChanged();
                return this;
            }

            public Builder clearRole() {
                this.role_ = IncrementProto.getDefaultInstance().getRole();
                onChanged();
                return this;
            }

            public Builder clearScene() {
                this.scene_ = IncrementProto.getDefaultInstance().getScene();
                onChanged();
                return this;
            }

            public Builder clearShowType() {
                this.showType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSku() {
                this.sku_ = IncrementProto.getDefaultInstance().getSku();
                onChanged();
                return this;
            }

            public Builder clearSubType() {
                this.subType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTransactionId() {
                this.transactionId_ = IncrementProto.getDefaultInstance().getTransactionId();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = IncrementProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUserType() {
                this.userType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWeight() {
                this.weight_ = IncrementProto.getDefaultInstance().getWeight();
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getActiveTime() {
                Object obj = this.activeTime_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.activeTime_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getActiveTimeBytes() {
                Object obj = this.activeTime_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.activeTime_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getAge() {
                Object obj = this.age_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.age_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getAgeBytes() {
                Object obj = this.age_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.age_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public Buy_type getBuyType() {
                Buy_type valueOf = Buy_type.valueOf(this.buyType_);
                return valueOf == null ? Buy_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getBuyTypeValue() {
                return this.buyType_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getConstellation() {
                Object obj = this.constellation_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.constellation_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getConstellationBytes() {
                Object obj = this.constellation_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.constellation_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.content_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getCouponId() {
                Object obj = this.couponId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.couponId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getCouponIdBytes() {
                Object obj = this.couponId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.couponId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public Enum_type getDefaultTag() {
                Enum_type valueOf = Enum_type.valueOf(this.defaultTag_);
                return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getDefaultTagValue() {
                return this.defaultTag_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IncrementProtos.internal_static_com_irisdt_client_increment_IncrementProto_descriptor;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public Enum_type getEnumType() {
                Enum_type valueOf = Enum_type.valueOf(this.enumType_);
                return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getEnumTypeValue() {
                return this.enumType_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                return valueOf == null ? Event.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getFrom() {
                Object obj = this.from_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.from_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getFromBytes() {
                Object obj = this.from_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.from_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getHeight() {
                Object obj = this.height_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.height_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getHeightBytes() {
                Object obj = this.height_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.height_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getInfo() {
                Object obj = this.info_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.info_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getInfoBytes() {
                Object obj = this.info_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.info_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public boolean getIsBoughtVip() {
                return this.isBoughtVip_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public boolean getIsHighMatchRate() {
                return this.isHighMatchRate_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public boolean getIsNew() {
                return this.isNew_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public boolean getIsPopular() {
                return this.isPopular_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public boolean getIsSingle() {
                return this.isSingle_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public boolean getIsTravel() {
                return this.isTravel_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public double getLatitude() {
                return this.latitude_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getLevel() {
                Object obj = this.level_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.level_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getLevelBytes() {
                Object obj = this.level_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.level_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getLocation() {
                Object obj = this.location_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.location_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getLocationBytes() {
                Object obj = this.location_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.location_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public double getLongitude() {
                return this.longitude_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getMbti() {
                Object obj = this.mbti_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.mbti_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getMbtiBytes() {
                Object obj = this.mbti_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mbti_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getMethod() {
                Object obj = this.method_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.method_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getMethodBytes() {
                Object obj = this.method_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getPosition() {
                Object obj = this.position_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.position_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getPositionBytes() {
                Object obj = this.position_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.position_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getPrice() {
                Object obj = this.price_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.price_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getPriceBytes() {
                Object obj = this.price_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.price_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getRole() {
                Object obj = this.role_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.role_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getRoleBytes() {
                Object obj = this.role_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.role_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getScene() {
                Object obj = this.scene_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.scene_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getSceneBytes() {
                Object obj = this.scene_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.scene_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public Enum_type getShowType() {
                Enum_type valueOf = Enum_type.valueOf(this.showType_);
                return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getShowTypeValue() {
                return this.showType_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getSku() {
                Object obj = this.sku_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.sku_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getSkuBytes() {
                Object obj = this.sku_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sku_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public Sub_type getSubType() {
                Sub_type valueOf = Sub_type.valueOf(this.subType_);
                return valueOf == null ? Sub_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getSubTypeValue() {
                return this.subType_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getTime() {
                return this.time_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getTransactionId() {
                Object obj = this.transactionId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.transactionId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getTransactionIdBytes() {
                Object obj = this.transactionId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.transactionId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.type_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public int getUserType() {
                return this.userType_;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public String getWeight() {
                Object obj = this.weight_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.weight_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.increment.IncrementProtos.IncrementProtoOrBuilder
            public ByteString getWeightBytes() {
                Object obj = this.weight_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.weight_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IncrementProtos.internal_static_com_irisdt_client_increment_IncrementProto_fieldAccessorTable.ensureFieldAccessorsInitialized(IncrementProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setActiveTime(String str) {
                Objects.requireNonNull(str);
                this.activeTime_ = str;
                onChanged();
                return this;
            }

            public Builder setActiveTimeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.activeTime_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAge(String str) {
                Objects.requireNonNull(str);
                this.age_ = str;
                onChanged();
                return this;
            }

            public Builder setAgeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.age_ = byteString;
                onChanged();
                return this;
            }

            public Builder setBuyType(Buy_type buy_type) {
                Objects.requireNonNull(buy_type);
                this.buyType_ = buy_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setBuyTypeValue(int i10) {
                this.buyType_ = i10;
                onChanged();
                return this;
            }

            public Builder setConstellation(String str) {
                Objects.requireNonNull(str);
                this.constellation_ = str;
                onChanged();
                return this;
            }

            public Builder setConstellationBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.constellation_ = byteString;
                onChanged();
                return this;
            }

            public Builder setContent(String str) {
                Objects.requireNonNull(str);
                this.content_ = str;
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCouponId(String str) {
                Objects.requireNonNull(str);
                this.couponId_ = str;
                onChanged();
                return this;
            }

            public Builder setCouponIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.couponId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDefaultTag(Enum_type enum_type) {
                Objects.requireNonNull(enum_type);
                this.defaultTag_ = enum_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setDefaultTagValue(int i10) {
                this.defaultTag_ = i10;
                onChanged();
                return this;
            }

            public Builder setEnumType(Enum_type enum_type) {
                Objects.requireNonNull(enum_type);
                this.enumType_ = enum_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setEnumTypeValue(int i10) {
                this.enumType_ = i10;
                onChanged();
                return this;
            }

            public Builder setEvent(Event event) {
                Objects.requireNonNull(event);
                this.event_ = event.getNumber();
                onChanged();
                return this;
            }

            public Builder setEventValue(int i10) {
                this.event_ = i10;
                onChanged();
                return this;
            }

            public Builder setFrom(String str) {
                Objects.requireNonNull(str);
                this.from_ = str;
                onChanged();
                return this;
            }

            public Builder setFromBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.from_ = byteString;
                onChanged();
                return this;
            }

            public Builder setHeight(String str) {
                Objects.requireNonNull(str);
                this.height_ = str;
                onChanged();
                return this;
            }

            public Builder setHeightBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.height_ = byteString;
                onChanged();
                return this;
            }

            public Builder setId(String str) {
                Objects.requireNonNull(str);
                this.id_ = str;
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.id_ = byteString;
                onChanged();
                return this;
            }

            public Builder setInfo(String str) {
                Objects.requireNonNull(str);
                this.info_ = str;
                onChanged();
                return this;
            }

            public Builder setInfoBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.info_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIsBoughtVip(boolean z10) {
                this.isBoughtVip_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsHighMatchRate(boolean z10) {
                this.isHighMatchRate_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsNew(boolean z10) {
                this.isNew_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsPopular(boolean z10) {
                this.isPopular_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsSingle(boolean z10) {
                this.isSingle_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTravel(boolean z10) {
                this.isTravel_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z10) {
                this.isTrue_ = z10;
                onChanged();
                return this;
            }

            public Builder setLatitude(double d10) {
                this.latitude_ = d10;
                onChanged();
                return this;
            }

            public Builder setLevel(String str) {
                Objects.requireNonNull(str);
                this.level_ = str;
                onChanged();
                return this;
            }

            public Builder setLevelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.level_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLocation(String str) {
                Objects.requireNonNull(str);
                this.location_ = str;
                onChanged();
                return this;
            }

            public Builder setLocationBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.location_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLongitude(double d10) {
                this.longitude_ = d10;
                onChanged();
                return this;
            }

            public Builder setMbti(String str) {
                Objects.requireNonNull(str);
                this.mbti_ = str;
                onChanged();
                return this;
            }

            public Builder setMbtiBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mbti_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMethod(String str) {
                Objects.requireNonNull(str);
                this.method_ = str;
                onChanged();
                return this;
            }

            public Builder setMethodBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.method_ = byteString;
                onChanged();
                return this;
            }

            public Builder setName(String str) {
                Objects.requireNonNull(str);
                this.name_ = str;
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNum(int i10) {
                this.num_ = i10;
                onChanged();
                return this;
            }

            public Builder setPosition(String str) {
                Objects.requireNonNull(str);
                this.position_ = str;
                onChanged();
                return this;
            }

            public Builder setPositionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.position_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPrice(String str) {
                Objects.requireNonNull(str);
                this.price_ = str;
                onChanged();
                return this;
            }

            public Builder setPriceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.price_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRole(String str) {
                Objects.requireNonNull(str);
                this.role_ = str;
                onChanged();
                return this;
            }

            public Builder setRoleBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.role_ = byteString;
                onChanged();
                return this;
            }

            public Builder setScene(String str) {
                Objects.requireNonNull(str);
                this.scene_ = str;
                onChanged();
                return this;
            }

            public Builder setSceneBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.scene_ = byteString;
                onChanged();
                return this;
            }

            public Builder setShowType(Enum_type enum_type) {
                Objects.requireNonNull(enum_type);
                this.showType_ = enum_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setShowTypeValue(int i10) {
                this.showType_ = i10;
                onChanged();
                return this;
            }

            public Builder setSku(String str) {
                Objects.requireNonNull(str);
                this.sku_ = str;
                onChanged();
                return this;
            }

            public Builder setSkuBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.sku_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSubType(Sub_type sub_type) {
                Objects.requireNonNull(sub_type);
                this.subType_ = sub_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setSubTypeValue(int i10) {
                this.subType_ = i10;
                onChanged();
                return this;
            }

            public Builder setTime(int i10) {
                this.time_ = i10;
                onChanged();
                return this;
            }

            public Builder setTransactionId(String str) {
                Objects.requireNonNull(str);
                this.transactionId_ = str;
                onChanged();
                return this;
            }

            public Builder setTransactionIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.transactionId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setType(String str) {
                Objects.requireNonNull(str);
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
                onChanged();
                return this;
            }

            public Builder setUserType(int i10) {
                this.userType_ = i10;
                onChanged();
                return this;
            }

            public Builder setWeight(String str) {
                Objects.requireNonNull(str);
                this.weight_ = str;
                onChanged();
                return this;
            }

            public Builder setWeightBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.weight_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IncrementProto build() {
                IncrementProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IncrementProto buildPartial() {
                IncrementProto incrementProto = new IncrementProto(this);
                incrementProto.event_ = this.event_;
                incrementProto.content_ = this.content_;
                incrementProto.from_ = this.from_;
                incrementProto.level_ = this.level_;
                incrementProto.type_ = this.type_;
                incrementProto.isTrue_ = this.isTrue_;
                incrementProto.enumType_ = this.enumType_;
                incrementProto.subType_ = this.subType_;
                incrementProto.buyType_ = this.buyType_;
                incrementProto.name_ = this.name_;
                incrementProto.longitude_ = this.longitude_;
                incrementProto.latitude_ = this.latitude_;
                incrementProto.id_ = this.id_;
                incrementProto.position_ = this.position_;
                incrementProto.location_ = this.location_;
                incrementProto.role_ = this.role_;
                incrementProto.constellation_ = this.constellation_;
                incrementProto.age_ = this.age_;
                incrementProto.height_ = this.height_;
                incrementProto.weight_ = this.weight_;
                incrementProto.time_ = this.time_;
                incrementProto.method_ = this.method_;
                incrementProto.transactionId_ = this.transactionId_;
                incrementProto.sku_ = this.sku_;
                incrementProto.scene_ = this.scene_;
                incrementProto.couponId_ = this.couponId_;
                incrementProto.userType_ = this.userType_;
                incrementProto.info_ = this.info_;
                incrementProto.activeTime_ = this.activeTime_;
                incrementProto.num_ = this.num_;
                incrementProto.defaultTag_ = this.defaultTag_;
                incrementProto.showType_ = this.showType_;
                incrementProto.price_ = this.price_;
                incrementProto.isBoughtVip_ = this.isBoughtVip_;
                incrementProto.mbti_ = this.mbti_;
                incrementProto.isSingle_ = this.isSingle_;
                incrementProto.isNew_ = this.isNew_;
                incrementProto.isPopular_ = this.isPopular_;
                incrementProto.isHighMatchRate_ = this.isHighMatchRate_;
                incrementProto.isTravel_ = this.isTravel_;
                onBuilt();
                return incrementProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IncrementProto getDefaultInstanceForType() {
                return IncrementProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.content_ = "";
                this.from_ = "";
                this.level_ = "";
                this.type_ = "";
                this.isTrue_ = false;
                this.enumType_ = 0;
                this.subType_ = 0;
                this.buyType_ = 0;
                this.name_ = "";
                this.longitude_ = ShadowDrawableWrapper.COS_45;
                this.latitude_ = ShadowDrawableWrapper.COS_45;
                this.id_ = "";
                this.position_ = "";
                this.location_ = "";
                this.role_ = "";
                this.constellation_ = "";
                this.age_ = "";
                this.height_ = "";
                this.weight_ = "";
                this.time_ = 0;
                this.method_ = "";
                this.transactionId_ = "";
                this.sku_ = "";
                this.scene_ = "";
                this.couponId_ = "";
                this.userType_ = 0;
                this.info_ = "";
                this.activeTime_ = "";
                this.num_ = 0;
                this.defaultTag_ = 0;
                this.showType_ = 0;
                this.price_ = "";
                this.isBoughtVip_ = false;
                this.mbti_ = "";
                this.isSingle_ = false;
                this.isNew_ = false;
                this.isPopular_ = false;
                this.isHighMatchRate_ = false;
                this.isTravel_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof IncrementProto) {
                    return mergeFrom((IncrementProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(IncrementProto incrementProto) {
                if (incrementProto == IncrementProto.getDefaultInstance()) {
                    return this;
                }
                if (incrementProto.event_ != 0) {
                    setEventValue(incrementProto.getEventValue());
                }
                if (!incrementProto.getContent().isEmpty()) {
                    this.content_ = incrementProto.content_;
                    onChanged();
                }
                if (!incrementProto.getFrom().isEmpty()) {
                    this.from_ = incrementProto.from_;
                    onChanged();
                }
                if (!incrementProto.getLevel().isEmpty()) {
                    this.level_ = incrementProto.level_;
                    onChanged();
                }
                if (!incrementProto.getType().isEmpty()) {
                    this.type_ = incrementProto.type_;
                    onChanged();
                }
                if (incrementProto.getIsTrue()) {
                    setIsTrue(incrementProto.getIsTrue());
                }
                if (incrementProto.enumType_ != 0) {
                    setEnumTypeValue(incrementProto.getEnumTypeValue());
                }
                if (incrementProto.subType_ != 0) {
                    setSubTypeValue(incrementProto.getSubTypeValue());
                }
                if (incrementProto.buyType_ != 0) {
                    setBuyTypeValue(incrementProto.getBuyTypeValue());
                }
                if (!incrementProto.getName().isEmpty()) {
                    this.name_ = incrementProto.name_;
                    onChanged();
                }
                if (incrementProto.getLongitude() != ShadowDrawableWrapper.COS_45) {
                    setLongitude(incrementProto.getLongitude());
                }
                if (incrementProto.getLatitude() != ShadowDrawableWrapper.COS_45) {
                    setLatitude(incrementProto.getLatitude());
                }
                if (!incrementProto.getId().isEmpty()) {
                    this.id_ = incrementProto.id_;
                    onChanged();
                }
                if (!incrementProto.getPosition().isEmpty()) {
                    this.position_ = incrementProto.position_;
                    onChanged();
                }
                if (!incrementProto.getLocation().isEmpty()) {
                    this.location_ = incrementProto.location_;
                    onChanged();
                }
                if (!incrementProto.getRole().isEmpty()) {
                    this.role_ = incrementProto.role_;
                    onChanged();
                }
                if (!incrementProto.getConstellation().isEmpty()) {
                    this.constellation_ = incrementProto.constellation_;
                    onChanged();
                }
                if (!incrementProto.getAge().isEmpty()) {
                    this.age_ = incrementProto.age_;
                    onChanged();
                }
                if (!incrementProto.getHeight().isEmpty()) {
                    this.height_ = incrementProto.height_;
                    onChanged();
                }
                if (!incrementProto.getWeight().isEmpty()) {
                    this.weight_ = incrementProto.weight_;
                    onChanged();
                }
                if (incrementProto.getTime() != 0) {
                    setTime(incrementProto.getTime());
                }
                if (!incrementProto.getMethod().isEmpty()) {
                    this.method_ = incrementProto.method_;
                    onChanged();
                }
                if (!incrementProto.getTransactionId().isEmpty()) {
                    this.transactionId_ = incrementProto.transactionId_;
                    onChanged();
                }
                if (!incrementProto.getSku().isEmpty()) {
                    this.sku_ = incrementProto.sku_;
                    onChanged();
                }
                if (!incrementProto.getScene().isEmpty()) {
                    this.scene_ = incrementProto.scene_;
                    onChanged();
                }
                if (!incrementProto.getCouponId().isEmpty()) {
                    this.couponId_ = incrementProto.couponId_;
                    onChanged();
                }
                if (incrementProto.getUserType() != 0) {
                    setUserType(incrementProto.getUserType());
                }
                if (!incrementProto.getInfo().isEmpty()) {
                    this.info_ = incrementProto.info_;
                    onChanged();
                }
                if (!incrementProto.getActiveTime().isEmpty()) {
                    this.activeTime_ = incrementProto.activeTime_;
                    onChanged();
                }
                if (incrementProto.getNum() != 0) {
                    setNum(incrementProto.getNum());
                }
                if (incrementProto.defaultTag_ != 0) {
                    setDefaultTagValue(incrementProto.getDefaultTagValue());
                }
                if (incrementProto.showType_ != 0) {
                    setShowTypeValue(incrementProto.getShowTypeValue());
                }
                if (!incrementProto.getPrice().isEmpty()) {
                    this.price_ = incrementProto.price_;
                    onChanged();
                }
                if (incrementProto.getIsBoughtVip()) {
                    setIsBoughtVip(incrementProto.getIsBoughtVip());
                }
                if (!incrementProto.getMbti().isEmpty()) {
                    this.mbti_ = incrementProto.mbti_;
                    onChanged();
                }
                if (incrementProto.getIsSingle()) {
                    setIsSingle(incrementProto.getIsSingle());
                }
                if (incrementProto.getIsNew()) {
                    setIsNew(incrementProto.getIsNew());
                }
                if (incrementProto.getIsPopular()) {
                    setIsPopular(incrementProto.getIsPopular());
                }
                if (incrementProto.getIsHighMatchRate()) {
                    setIsHighMatchRate(incrementProto.getIsHighMatchRate());
                }
                if (incrementProto.getIsTravel()) {
                    setIsTravel(incrementProto.getIsTravel());
                }
                mergeUnknownFields(incrementProto.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.content_ = "";
                this.from_ = "";
                this.level_ = "";
                this.type_ = "";
                this.enumType_ = 0;
                this.subType_ = 0;
                this.buyType_ = 0;
                this.name_ = "";
                this.id_ = "";
                this.position_ = "";
                this.location_ = "";
                this.role_ = "";
                this.constellation_ = "";
                this.age_ = "";
                this.height_ = "";
                this.weight_ = "";
                this.method_ = "";
                this.transactionId_ = "";
                this.sku_ = "";
                this.scene_ = "";
                this.couponId_ = "";
                this.info_ = "";
                this.activeTime_ = "";
                this.defaultTag_ = 0;
                this.showType_ = 0;
                this.price_ = "";
                this.mbti_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.increment.IncrementProtos.IncrementProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.increment.IncrementProtos.IncrementProto.q0()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.increment.IncrementProtos$IncrementProto r3 = (com.irisdt.client.increment.IncrementProtos.IncrementProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.irisdt.client.increment.IncrementProtos$IncrementProto r4 = (com.irisdt.client.increment.IncrementProtos.IncrementProto) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.increment.IncrementProtos.IncrementProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.increment.IncrementProtos$IncrementProto$Builder");
            }
        }

        public static Builder newBuilder(IncrementProto incrementProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(incrementProto);
        }

        public static IncrementProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private IncrementProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.content_ = "";
            this.from_ = "";
            this.level_ = "";
            this.type_ = "";
            this.enumType_ = 0;
            this.subType_ = 0;
            this.buyType_ = 0;
            this.name_ = "";
            this.id_ = "";
            this.position_ = "";
            this.location_ = "";
            this.role_ = "";
            this.constellation_ = "";
            this.age_ = "";
            this.height_ = "";
            this.weight_ = "";
            this.method_ = "";
            this.transactionId_ = "";
            this.sku_ = "";
            this.scene_ = "";
            this.couponId_ = "";
            this.info_ = "";
            this.activeTime_ = "";
            this.defaultTag_ = 0;
            this.showType_ = 0;
            this.price_ = "";
            this.mbti_ = "";
        }

        public static IncrementProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IncrementProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static IncrementProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IncrementProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static IncrementProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static IncrementProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static IncrementProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static IncrementProto parseFrom(InputStream inputStream) throws IOException {
            return (IncrementProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static IncrementProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IncrementProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static IncrementProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (IncrementProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static IncrementProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IncrementProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private IncrementProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z10 = true;
                                case 8:
                                    this.event_ = codedInputStream.readEnum();
                                case 18:
                                    this.content_ = codedInputStream.readStringRequireUtf8();
                                case 26:
                                    this.from_ = codedInputStream.readStringRequireUtf8();
                                case 34:
                                    this.level_ = codedInputStream.readStringRequireUtf8();
                                case 42:
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                case 48:
                                    this.isTrue_ = codedInputStream.readBool();
                                case 56:
                                    this.enumType_ = codedInputStream.readEnum();
                                case 64:
                                    this.subType_ = codedInputStream.readEnum();
                                case 72:
                                    this.buyType_ = codedInputStream.readEnum();
                                case 82:
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                case 89:
                                    this.longitude_ = codedInputStream.readDouble();
                                case 97:
                                    this.latitude_ = codedInputStream.readDouble();
                                case 106:
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                case 114:
                                    this.position_ = codedInputStream.readStringRequireUtf8();
                                case 122:
                                    this.location_ = codedInputStream.readStringRequireUtf8();
                                case 130:
                                    this.role_ = codedInputStream.readStringRequireUtf8();
                                case 138:
                                    this.constellation_ = codedInputStream.readStringRequireUtf8();
                                case 146:
                                    this.age_ = codedInputStream.readStringRequireUtf8();
                                case 154:
                                    this.height_ = codedInputStream.readStringRequireUtf8();
                                case 162:
                                    this.weight_ = codedInputStream.readStringRequireUtf8();
                                case 168:
                                    this.time_ = codedInputStream.readInt32();
                                case 178:
                                    this.method_ = codedInputStream.readStringRequireUtf8();
                                case 186:
                                    this.transactionId_ = codedInputStream.readStringRequireUtf8();
                                case 194:
                                    this.sku_ = codedInputStream.readStringRequireUtf8();
                                case 202:
                                    this.scene_ = codedInputStream.readStringRequireUtf8();
                                case 210:
                                    this.couponId_ = codedInputStream.readStringRequireUtf8();
                                case 216:
                                    this.userType_ = codedInputStream.readInt32();
                                case 226:
                                    this.info_ = codedInputStream.readStringRequireUtf8();
                                case 234:
                                    this.activeTime_ = codedInputStream.readStringRequireUtf8();
                                case 240:
                                    this.num_ = codedInputStream.readInt32();
                                case 248:
                                    this.defaultTag_ = codedInputStream.readEnum();
                                case 256:
                                    this.showType_ = codedInputStream.readEnum();
                                case 266:
                                    this.price_ = codedInputStream.readStringRequireUtf8();
                                case 272:
                                    this.isBoughtVip_ = codedInputStream.readBool();
                                case 282:
                                    this.mbti_ = codedInputStream.readStringRequireUtf8();
                                case 288:
                                    this.isSingle_ = codedInputStream.readBool();
                                case 296:
                                    this.isNew_ = codedInputStream.readBool();
                                case 304:
                                    this.isPopular_ = codedInputStream.readBool();
                                case 312:
                                    this.isHighMatchRate_ = codedInputStream.readBool();
                                case 320:
                                    this.isTravel_ = codedInputStream.readBool();
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        z10 = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IncrementProtoOrBuilder extends MessageOrBuilder {
        String getActiveTime();

        ByteString getActiveTimeBytes();

        String getAge();

        ByteString getAgeBytes();

        Buy_type getBuyType();

        int getBuyTypeValue();

        String getConstellation();

        ByteString getConstellationBytes();

        String getContent();

        ByteString getContentBytes();

        String getCouponId();

        ByteString getCouponIdBytes();

        Enum_type getDefaultTag();

        int getDefaultTagValue();

        Enum_type getEnumType();

        int getEnumTypeValue();

        Event getEvent();

        int getEventValue();

        String getFrom();

        ByteString getFromBytes();

        String getHeight();

        ByteString getHeightBytes();

        String getId();

        ByteString getIdBytes();

        String getInfo();

        ByteString getInfoBytes();

        boolean getIsBoughtVip();

        boolean getIsHighMatchRate();

        boolean getIsNew();

        boolean getIsPopular();

        boolean getIsSingle();

        boolean getIsTravel();

        boolean getIsTrue();

        double getLatitude();

        String getLevel();

        ByteString getLevelBytes();

        String getLocation();

        ByteString getLocationBytes();

        double getLongitude();

        String getMbti();

        ByteString getMbtiBytes();

        String getMethod();

        ByteString getMethodBytes();

        String getName();

        ByteString getNameBytes();

        int getNum();

        String getPosition();

        ByteString getPositionBytes();

        String getPrice();

        ByteString getPriceBytes();

        String getRole();

        ByteString getRoleBytes();

        String getScene();

        ByteString getSceneBytes();

        Enum_type getShowType();

        int getShowTypeValue();

        String getSku();

        ByteString getSkuBytes();

        Sub_type getSubType();

        int getSubTypeValue();

        int getTime();

        String getTransactionId();

        ByteString getTransactionIdBytes();

        String getType();

        ByteString getTypeBytes();

        int getUserType();

        String getWeight();

        ByteString getWeightBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Sub_type implements ProtocolMessageEnum {
        UNKNOWN_SUB_TYPE(0),
        WECHAT(1),
        ALI_PAY(2),
        ANT_CHECK_LATER(3),
        UNRECOGNIZED(-1);

        public static final int ALI_PAY_VALUE = 2;
        public static final int ANT_CHECK_LATER_VALUE = 3;
        public static final int UNKNOWN_SUB_TYPE_VALUE = 0;
        public static final int WECHAT_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<Sub_type> internalValueMap = new Internal.EnumLiteMap<Sub_type>() { // from class: com.irisdt.client.increment.IncrementProtos.Sub_type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Sub_type findValueByNumber(int i10) {
                return Sub_type.forNumber(i10);
            }
        };
        private static final Sub_type[] VALUES = values();

        Sub_type(int i10) {
            this.value = i10;
        }

        public static Sub_type forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_SUB_TYPE;
            }
            if (i10 == 1) {
                return WECHAT;
            }
            if (i10 == 2) {
                return ALI_PAY;
            }
            if (i10 != 3) {
                return null;
            }
            return ANT_CHECK_LATER;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return IncrementProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<Sub_type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Sub_type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Sub_type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_client_increment_IncrementProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_increment_IncrementProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{com.huawei.hianalytics.core.storage.Event.TAG, "Content", "From", "Level", "Type", "IsTrue", "EnumType", "SubType", "BuyType", "Name", "Longitude", "Latitude", "Id", "Position", "Location", "Role", "Constellation", "Age", "Height", "Weight", "Time", "Method", "TransactionId", "Sku", "Scene", "CouponId", "UserType", "Info", "ActiveTime", "Num", "DefaultTag", "ShowType", "Price", "IsBoughtVip", "Mbti", "IsSingle", "IsNew", "IsPopular", "IsHighMatchRate", "IsTravel"});
    }

    private IncrementProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
