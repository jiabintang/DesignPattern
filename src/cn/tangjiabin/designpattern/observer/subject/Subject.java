package cn.tangjiabin.designpattern.observer.subject;

import cn.tangjiabin.designpattern.observer.observer.Observer;

/**
 * 主题
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/11/21
 * @email : seven_tjb@163.com
 **/
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
