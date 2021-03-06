package cn.tangjiabin.designpattern.strategy.character.impl;

import cn.tangjiabin.designpattern.strategy.behavior.impl.BowAndArrowBehavior;
import cn.tangjiabin.designpattern.strategy.character.AbstractCharacter;

/**
 * 皇后
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public class Queen extends AbstractCharacter {

    public Queen(){
        weaponBehavior = new BowAndArrowBehavior();
    }
}
