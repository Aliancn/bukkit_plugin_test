package localhost.test.test01;

/**
 * ClassName : GradientGeneratePolicy
 * Package : localhost.test.test01
 * Description :
 *
 * @Author Aliancn
 * @Create 2023/4/22 21:26
 * @Version 1.0
 */
public class GradientGeneratePolicy implements IColorGeneratePolicy{

    private char[] _colors;

    public GradientGeneratePolicy(){
        _colors = "4c6e2ab319d5f780".toCharArray();
    }

    // TODO: 2023/4/22 说明下列代码的用途 
    private int getColorIndex(int i){
        int count = i/_colors.length;
        i%= _colors.length;
        if ((count %2 )!= 0){
            return Math.abs(i-(_colors.length-1));
        }
        return i;
    }

    @Override
    public String getNextColorString(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<str.length();i++){
            int colorIndex = getColorIndex(i);
            builder.append("§");
            builder.append(_colors[colorIndex]);
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
