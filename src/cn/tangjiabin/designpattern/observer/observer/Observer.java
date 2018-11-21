package cn.tangjiabin.designpattern.observer.observer;

/**
 * 观察者
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/21
 * @email : seven_tjb@163.com
 **/
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
