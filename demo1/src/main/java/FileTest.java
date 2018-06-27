import java.io.File;
import java.io.IOException;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.FileTest
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/6/27 14:09
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/6/27      wangtongbang          v1.0.0               修改原因
 */
public class FileTest {
    public static void main(String[] args) throws Exception {
        FileCreateSuccess();
    }

    /**
     * 之前一直想在PersonalStudyUnit目录下的/demo1/src/main下面使用这种方式新建一个文件，但是一直没有成功
     * 错误原因就是因为前面多带了一个/
     */
    private static void FileCreateFail() {
        try {
            File file = new File("/demo1/src/main/12311.txt");
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void FileCreateSuccess() {
        try {
            String filePath = "demo2/src/main";
            File dictionary = new File(filePath);
            if (!dictionary.exists()) {
                dictionary.mkdirs();
            }
            File file = new File(filePath, "12311.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
