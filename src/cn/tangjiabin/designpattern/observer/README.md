## 观察者模式


### 定义
**观察者模式**定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。

### 介绍
观察者模式（Observer）完美的将观察者和被观察的对象分离开。举个例子，用户界面可以作为一个观察者，业务数据是被观察者，用户界面观察业务数据的变化，发现数据变化后，就显示在界面上。

### 应用场景
1. 一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方面封装在独立的对象中使它们可以各自独立地改变和复用。
2. 一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体有多少对象将发生改变，可以降低对象之间的耦合度。
3. 一个对象必须通知其他对象，而并不知道这些对象是谁。  
4. 需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对象……，可以使用观察者模式创建一种链式触发机制。

### 实现


![](http://image.tangjiabin.cn/design_pattern/observer_pattern_uml.png)

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

