package org.ttrung.mai.tool.util.common;

import com.github.f4b6a3.uuid.UuidCreator;

public class UuidUtil {
    public static String uuidv7() {
        return UuidCreator.getTimeOrderedEpoch().toString();
    }

}

