package localhost.test.test01;

import org.bukkit.Color;
import java.awt.*;
/**
 * ClassName : RgbGradientModel
 * Package : localhost.test.test01
 * Description :
 *
 * @Author Aliancn
 * @Create 2023/4/22 22:15
 * @Version 1.0
 */
public class RgbGradientModel {
    public Color begin;

    public Color end ;

    public static RgbGradientModel make(int r,int g,int b,int R,int G,int B){
        RgbGradientModel model = new RgbGradientModel();
//        model.begin = new Color(r,g,b); Color为private类型，应该使用static方法fromRGB
        model.begin = Color.fromRGB(r,g,b);
        model.end = Color.fromRGB(R,G,B);
        return model;
    }
}
