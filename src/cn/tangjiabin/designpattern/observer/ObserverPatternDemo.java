package cn.tangjiabin.designpattern.observer;

import cn.tangjiabin.designpattern.observer.observer.Observer;
import cn.tangjiabin.designpattern.observer.observer.impl.TemperatureObserver;
import cn.tangjiabin.designpattern.observer.observer.impl.WeatherObserver;
import cn.tangjiabin.designpattern.observer.subject.impl.WeatherData;

/**
 * 观察者模式
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/21
 * @email : seven_tjb@163.com
 **/
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
