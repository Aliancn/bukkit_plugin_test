package localhost.test.test01;

import org.bukkit.Color;
import org.bukkit.event.Listener;

import java.util.Random;

/**
 * ClassName : ColorUtils
 * Package : localhost.test.test01
 * Description :
 *
 * @Author Aliancn
 * @Create 2023/4/21 16:04
 * @Version 1.0
 */
public class ColorUtils {
    public static Color generatorRandomColor(){
        Random random = new Random();
        return Color.fromRGB(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
    public static String getColoredString(String original){
        StringBuilder builder = new StringBuilder();
        for(char c : original.toCharArray()){
            StringBuilder rgbBuilder = new StringBuilder();
            rgbBuilder.append("§x");
            for(char rgb :String.valueOf(generatorRandomColor().asRGB()).toCharArray()){
                rgbBuilder.append("§");
                rgbBuilder.append(rgb);
            }
            builder.append(rgbBuilder.toString());
            builder.append(c);
        }
        return builder.toString();
    }
}
