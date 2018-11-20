package cn.tangjiabin.designpattern.strategy.behavior.impl;

import cn.tangjiabin.designpattern.strategy.behavior.WeaponBehavior;

/**
 * 弓箭行为
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("射箭。。。");
    }
}
