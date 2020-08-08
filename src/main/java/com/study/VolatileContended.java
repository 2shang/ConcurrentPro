package com.study;

/**
 * @author lenovo
 * @date 15:54
 * 要这个注解生效，需要配置jvm参数 -XX:-RestrictContended
 */
@sun.misc.Contended
public class VolatileContended {

    volatile int value = 4;

}
