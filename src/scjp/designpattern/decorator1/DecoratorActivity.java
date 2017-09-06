package scjp.designpattern.decorator1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jingbin.designpattern.R;
import com.example.jingbin.designpattern.app.AppConstant;
import com.example.jingbin.designpattern.decorator.equip.RingEquip;
import com.example.jingbin.designpattern.decorator.equip.ShoeEquip;
import com.example.jingbin.designpattern.decorator.gem.BlueGemDecotator;
import com.example.jingbin.designpattern.decorator.gem.RedGemDecotator;
import com.example.jingbin.designpattern.decorator.gem.YellowGemDecotator;
import com.example.jingbin.designpattern.app.EMTagHandler;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 装饰者模�?:
 * 装饰者模�?：若�?扩展功能，装饰者�??供了比集�?更有弹性的替代方案，动�?地将责任附加到对象上。
 * 先简�?��??述下装饰者模�?�?�挥作用的地方，当我们设计好了一个类，我们需�?给这个类添加一些辅助的功能，
 * 并且�?希望改�?�这个类的代�?，这时候就是装饰者模�?大展雄�?的时候了。
 * 这里还体现了一个原则：类应该对扩展开放，对修改关闭。
 * eg:
 * 1�?武器（攻击力20） �?戒指（攻击力5）�?护腕（攻击力5）�?鞋�?（攻击力5）
 * 2�?�?�?石（攻击力5/颗）�?黄�?石（攻击力10/颗）�?红�?石（攻击力15/颗）
 * 3�?�?个装备�?�以�?�?镶嵌3颗
 */
public class DecoratorActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_decorator)
    Button btDecorator;
    @BindView(R.id.tv_define)
    TextView tvDefine;
    @BindView(R.id.activity_decorator)
    LinearLayout activityDecorator;
    @BindView(R.id.bt_demo1)
    Button btDemo1;
    @BindView(R.id.bt_demo2)
    Button btDemo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);
        ButterKnife.bind(this);
        setTitle("装饰者模�?");

        tvDefine.setText(EMTagHandler.fromHtml(AppConstant.DECORATOR_DEFINE));
        btDemo1.setText("一个镶嵌2颗红�?石,1颗�?�?石的�?��?");
        btDemo2.setText("一个镶嵌1颗红�?石,1颗�?�?石,1颗黄�?石的戒指");

        btDecorator.setOnClickListener(this);
        btDemo1.setOnClickListener(this);
        btDemo2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_decorator:// 外观模�?
                break;

            case R.id.bt_demo1:
                Log.e("---", "一个镶嵌2颗红�?石,1颗�?�?石的�?��?: ");

                IEquip iEquip = new RedGemDecotator(new RedGemDecotator(new BlueGemDecotator(new ShoeEquip())));
                Log.e("---", "攻击力:" + iEquip.caculateAttack());
                Log.e("---", "�??述语:" + iEquip.description());
                break;

            case R.id.bt_demo2:
                Log.e("---", "一个镶嵌1颗红�?石,1颗�?�?石,1颗黄�?石的戒指: ");
                RedGemDecotator redGemDecotator = new RedGemDecotator(new BlueGemDecotator(new YellowGemDecotator(new RingEquip())));
                Log.e("---", "攻击力:" + redGemDecotator.caculateAttack());
                Log.e("---", "�??述语:" + redGemDecotator.description());
                break;
            default:
                break;
        }
    }
}
