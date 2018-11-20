package cn.tangjiabin.designpattern.strategy.character;

import cn.tangjiabin.designpattern.strategy.behavior.WeaponBehavior;

/**
 * 抽象角色
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public abstract class AbstractCharacter {

    public WeaponBehavior weaponBehavior;

    public void fight() {
        weaponBehavior.useWeapon();
    }

    public void setWeapon(WeaponBehavior w) {
        weaponBehavior = w;
    }


}
