## 策略模式

### 定义
**策略模式**定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。

### 介绍
对象有某个行为，但是在不同的场景中，该行为有不同的实现算法。比如国王和骑士都有武器，但是武器的使用方法不同。

### 应用场景
1. 多个类只区别在表现行为不同，可以使用策略模式，在运行时动态选择具体要执行的行为。
2. 需要在不同情况下使用不同的策略(算法)，或者策略还可能在未来用其它方式来实现。
3. 对客户隐藏具体策略(算法)的实现细节，彼此完全独立。

### 实现
AbstractCharacter(角色)是抽象类，由具体的角色来继承，具体的角色包括国王（King）、皇后（Queen）和骑士（Knight）。而武器是接口，由具体武器来继承，所有实际的角色和武器都是具体类。
任何角色如果想换武器，可以调用setWeapon（）方法。
![](http://image.tangjiabin.cn/design_pattern/strategy_pattern_uml.png)
 
- 步骤一  
创建一个抽象角色类
```
public abstract class AbstractCharacter {

    public WeaponBehavior weaponBehavior;

    public void fight() {
        weaponBehavior.useWeapon();
    }

    public void setWeapon(WeaponBehavior w) {
        weaponBehavior = w;
    }
    
}

```
  
- 步骤二  
创建具体实现角色类  

```
public class King extends AbstractCharacter {

    public King(){
        weaponBehavior = new SwordBehavior();
    }

}

```  
  
- 步骤三  
创建武器行为接口  

```
public interface WeaponBehavior {
    
    /**
     * 使用武器
     */
    void useWeapon();
}

```  
  
- 步骤四  
创建武器具体行为类  

```
public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("挥舞宝剑。。。");
    }
}

```  
  
- 步骤五  
创建测试类

```
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

``` 
  
- 步骤六  
执行程序，输出结果  
```
挥舞宝剑。。。
斧头劈砍。。。
射箭。。。
斧头劈砍。。。

```  
  
  
完整代码: [https://github.com/jiabintang/DesignPattern](https://github.com/jiabintang/DesignPattern)

