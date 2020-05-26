package com.spring.springbootintegrated1.utils;

import org.springframework.stereotype.Component;

/**
 * Common Constant
 */
@Component
public final class ConstantUtil {

    /**
     * HashMap Load factor initialization - (8 [0x8])
     */
    public static final int RESULT_MAP_INIT_COUNT = 0x8;

    /**
     * The default maximum number per page
     */
    public static final String DEFAULT_PAGE_SIZE = "10000";

    /**
     * The default page index number
     */
    public static final String DEFAULT_PAGE_INDEX = "0";

    /**
     * Deleted flag
     */
    public static final Byte IS_DELETE = 1;

    /**
     * Not Deleted flag
     */
    public static final Byte IS_NOT_DELETE = 0;

}
