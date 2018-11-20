package cn.tangjiabin.designpattern.strategy;

import cn.tangjiabin.designpattern.strategy.behavior.impl.AxeBehavior;
import cn.tangjiabin.designpattern.strategy.character.AbstractCharacter;
import cn.tangjiabin.designpattern.strategy.character.impl.King;
import cn.tangjiabin.designpattern.strategy.character.impl.Knight;
import cn.tangjiabin.designpattern.strategy.character.impl.Queen;

/**
 * 策略模式
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/20
 * @email : seven_tjb@163.com
 **/
public class StrategyPatternDemo {

    public static void main(String[] args) {
        AbstractCharacter character;

        //创建国王角色
        character = new King();
        character.fight();
        //战斗要求国王使用斧头
        character.setWeapon(new AxeBehavior());
        character.fight();

        //创建皇后角色
        character = new Queen();
        character.fight();

        //创建骑士角色
        character = new Knight();
        character.fight();
    }
}
