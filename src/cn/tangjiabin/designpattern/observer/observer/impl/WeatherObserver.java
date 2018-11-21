package cn.tangjiabin.designpattern.observer.observer.impl;

import cn.tangjiabin.designpattern.observer.observer.DisplayElement;
import cn.tangjiabin.designpattern.observer.observer.Observer;
import cn.tangjiabin.designpattern.observer.subject.Subject;

/**
 * 天气观察者
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/21
 * @email : seven_tjb@163.com
 **/
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
