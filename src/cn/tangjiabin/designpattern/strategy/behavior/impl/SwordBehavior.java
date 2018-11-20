package cn.tangjiabin.designpattern.strategy.behavior.impl;

import cn.tangjiabin.designpattern.strategy.behavior.WeaponBehavior;

/**
 * 宝剑
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("挥舞宝剑。。。");
    }
}
