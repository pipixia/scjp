package scjp.designpattern.decorator1;

/**
 * Created by jingbin on 2016/11/1.
 * 装备的接�?�
 * 下�?�有:武器,护腕,鞋�?,戒指�?�?�?�?还有装饰�?接�?�
 */

public interface IEquip {

    /**
     * 计算攻击力
     */
    public int caculateAttack();

    /**
     * 装备的�??述
     */
    public String description();
}
