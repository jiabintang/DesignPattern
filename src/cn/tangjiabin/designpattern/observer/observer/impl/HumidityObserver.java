package cn.tangjiabin.designpattern.observer.observer.impl;

import cn.tangjiabin.designpattern.observer.observer.DisplayElement;
import cn.tangjiabin.designpattern.observer.observer.Observer;
import cn.tangjiabin.designpattern.observer.subject.Subject;

/**
 * 湿度观察者
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/21
 * @email : seven_tjb@163.com
 **/
public class HumidityObserver implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public HumidityObserver(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("收到湿度变化：%s ",humidity));
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
