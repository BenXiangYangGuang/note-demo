package com.wewe.timeLoggerExample;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: fei2
 * Date:  2018/11/7 17:47
 * Description:
 * Refer To:
 */
@Data
@AllArgsConstructor
public class KafkaDealDataIndicator {

    private AtomicLong pollDataRow;
    private AtomicLong successRow;
    private AtomicLong failureRow;

}
