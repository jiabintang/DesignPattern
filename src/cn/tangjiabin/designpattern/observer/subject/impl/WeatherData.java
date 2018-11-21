package cn.tangjiabin.designpattern.observer.subject.impl;

import cn.tangjiabin.designpattern.observer.observer.Observer;
import cn.tangjiabin.designpattern.observer.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气信息
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/21
 * @email : seven_tjb@163.com
 **/
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
