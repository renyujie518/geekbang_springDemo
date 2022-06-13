package com.example.geekbang.spring.class6.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author gao wei
 * @className: C6E2ElectricService
 * @description 案例 1：错乱混合不同类型的增强
 * @date 2022/1/27/0027 10:35
 */

@Service
public class C6E1ElectricService {
    /*
     *问题复现
     */
    //public void charge() throws Exception {
    //    System.out.println("Electric charging ...");
    //
    //c

    /*
     *修正方式
 1. 将 ElectricService.charge() 的业务逻辑全部移动到 doCharge()，在 charge() 中调用 doCharge()；

2. 性能统计只需要拦截 doCharge()；

3. 权限统计增强保持不变，依然拦截 charge()。
*
* 这样就保证了@Around虽然优先级高，但是将需要统计时间的真实逻辑（本案例中是System.out.println("Electric charging ...");）
* 单独提溜出来成为一个单独的方法 doCharge()，让@Around先去拦截 doCharge()进而做到统计时间的需求（可以把这个理解为新增需求）
* 同时为了鉴权的需求逻辑不变（可以把这个理解为老逻辑） 还是让 @Before继续拦截原先代码的charge()，这样做到了尽量改动原代码最少
     */
    @Autowired
    @Lazy
    C6E1ElectricService c6E1ElectricService;

    public void charge() {
        c6E1ElectricService.doCharge();
    }

    public void doCharge() {
        System.out.println("Electric charging ...");
    }
}
