package cn.tangjiabin.designpattern.strategy.behavior.impl;

import cn.tangjiabin.designpattern.strategy.behavior.WeaponBehavior;

/**
 * 斧头
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("斧头劈砍。。。");
    }
}
