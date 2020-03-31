import com.ttxs.function.PickUpChinese;

/**
 * @author kai.hu
 * @date 2020/3/27 9:26
 */
public class TestClass {
    public static void main(String[] args) {
        PickUpChinese pk = new PickUpChinese();
        pk.setFilePath("D://r-test//App.vue");
        pk.setResultPath("D://result//app.txt");
        pk.getSuffixList().add(".txt");
        pk.execute();
        pk.getResult().forEach(System.out :: println);
    }
}
