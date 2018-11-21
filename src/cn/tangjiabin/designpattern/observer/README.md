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
创建一个主题（Subject）接口，被观察者（WeatherDate）实现主题接口。创建观察者接口以及具体实现类,当被观察者改变时，通知已注册的观察者。
![](http://image.tangjiabin.cn/design_pattern/observer_pattern_uml.png)

- 步骤一  
创建一个主题接口
```
public interface Subject {

    /**
     * 注册观察者
     * @param o 观察者
     */
    public void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o 观察者
     */
    public void removeObsever(Observer o);

    /**
     * 通知观察者
     */
    public void notifyObserver();
}

```
  
- 步骤二  
创建被观察者（天气信息）类  

```
public class WeatherData implements Subject {

    /**
     * 观察者集合
     */
    private List<Observer> observerList;
    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float humidity;
    /**
     * 压力
     */
    private float pressure;


    public WeatherData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObsever(Observer o) {
        int index = observerList.indexOf(o);
        if (index > 0) {
            observerList.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(temperature,humidity,pressure);
        }
    }

    /**
     * 设置测量值
     * @param temperature 温度
     * @param humidity 湿度
     * @param pressure 压力
     */
    public void setMeasurements(float temperature,float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    /**
     * 当信息改变通知观察者
     */
    public void measurementsChanged(){
        notifyObserver();
    }
}


```  
  
- 步骤三  
创建观察者接口  

```
public interface Observer {
    /**
     * 观察者更新接口
     *
     * 当气象值改变时，主题会把这些值当做方法参数，传递给观察者。
     *
     * @param temperature 温度
     * @param humidity 湿度
     * @param pressure 压力
     */
    public void update(float temperature,float humidity,float pressure);
}

public interface DisplayElement {

    /**
     * 天气显示接口
     */
    public void display();
}


```  
  
- 步骤四  
创建具体观察者（天气观察者）类  

```
public class WeatherObserver implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public WeatherObserver(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("收到天气变化 温度：%s 湿度：%s 压力：%s",temperature,humidity,pressure));
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}

```  
  
- 步骤五  
创建测试类

```
public class ObserverPatternDemo {

    public static void main(String[] args) {
        //创建天气数据类
        WeatherData weatherData = new WeatherData();
        //天气观察者注册
        Observer weatherObserver = new WeatherObserver(weatherData);
        //温度观察者注册
        Observer temperatureObserver = new TemperatureObserver(weatherData);
        //更新天气信息
        weatherData.setMeasurements(16,40,33);
    }
}

``` 
  
- 步骤六  
执行程序，输出结果  
```
收到天气变化 温度：16.0 湿度：40.0 压力：33.0
收到温度变化：16.0

```  
  
  
完整代码: [https://github.com/jiabintang/DesignPattern](https://github.com/jiabintang/DesignPattern)

