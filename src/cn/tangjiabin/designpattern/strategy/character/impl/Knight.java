package cn.tangjiabin.designpattern.strategy.character.impl;

import cn.tangjiabin.designpattern.strategy.behavior.impl.AxeBehavior;
import cn.tangjiabin.designpattern.strategy.character.AbstractCharacter;

/**
 * 骑士
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public class Knight extends AbstractCharacter {

    public Knight(){
        weaponBehavior = new AxeBehavior();
    }
}
