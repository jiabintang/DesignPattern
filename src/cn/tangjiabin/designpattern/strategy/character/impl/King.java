package cn.tangjiabin.designpattern.strategy.character.impl;

import cn.tangjiabin.designpattern.strategy.behavior.impl.SwordBehavior;
import cn.tangjiabin.designpattern.strategy.character.AbstractCharacter;

/**
 * 国王
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public class King extends AbstractCharacter {

    public King(){
        weaponBehavior = new SwordBehavior();
    }


}
